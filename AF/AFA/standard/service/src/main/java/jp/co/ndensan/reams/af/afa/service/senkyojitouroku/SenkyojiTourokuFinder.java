/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.senkyojitouroku;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.ISenkyoRelateMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuDateKeisan;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のビジネスクラスです。
 *
 * @reamsid_L AF-0030-030 liss
 */
public class SenkyojiTourokuFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SenkyojiTourokuFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    SenkyojiTourokuFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンス
     */
    public static SenkyojiTourokuFinder createInstance() {
        return InstanceProvider.create(SenkyojiTourokuFinder.class);
    }

    /**
     * 日付を自動計算します。
     *
     * @param 基準日 FlexibleDate
     * @return 登録日、転出期限日、転入期限日、年齢期限日
     */
    @Transaction
    public TeijiTourokuDateKeisan calcDateInfo(FlexibleDate 基準日) {
        TeijiTourokuDateKeisan result = new TeijiTourokuDateKeisan();
        if (基準日.isEmpty()) {
            return result;
        }

        // 業務実行
        RString senkyojiToroku = BusinessConfig.get(ConfigKeysAFA.選挙時_登録日判定基準, SubGyomuCode.AFA選挙本体);
        RString senkyojiTensyutu = BusinessConfig.get(ConfigKeysAFA.選挙時_転出期限日判定基準, SubGyomuCode.AFA選挙本体);
        RString senkyojiTennyuu = BusinessConfig.get(ConfigKeysAFA.選挙時_転入期限日判定基準, SubGyomuCode.AFA選挙本体);

        if (senkyojiToroku.equals(new RString("1"))) {
            result.set登録日(基準日.plusDay(1));
        } else if (senkyojiToroku.equals(new RString("2"))) {
            result.set登録日(基準日);
        }

        if (senkyojiTensyutu.equals(new RString("1"))) {
            result.set転出期限日(基準日.minusMonth(CommonConstant.月_4ヶ));
        } else if (senkyojiTensyutu.equals(new RString("2"))) {
            result.set転出期限日(基準日.minusMonth(CommonConstant.月_4ヶ).plusDay(1));
        } else if (senkyojiTensyutu.equals(new RString("3"))) {
            result.set転出期限日(基準日.minusMonth(CommonConstant.月_4ヶ).minusDay(1));
        }

        if (senkyojiTennyuu.equals(new RString("1"))) {
            result.set転入期限日(基準日.minusMonth(CommonConstant.月_3ヶ));
        } else if (senkyojiTennyuu.equals(new RString("2"))) {
            result.set転入期限日(基準日.minusMonth(CommonConstant.月_3ヶ).plusDay(1));
        } else if (senkyojiTennyuu.equals(new RString("3"))) {
            result.set転入期限日(基準日.minusMonth(CommonConstant.月_3ヶ).minusDay(1));
        }

        result.set告示公示日(基準日.plusDay(1));

        return result;
    }

    /**
     * 帳票の条件を設定します。
     *
     * @param 基準日R RDate
     * @param 転入期限日R RDate
     * @param 転出期限日R RDate
     * @return 転入期間From～To、転出期間From～To、帰化期間From～To
     */
    @Transaction
    public TeijiTourokuCyohyoSeitei calcChouhyoDateInfo(RDate 基準日R, RDate 転入期限日R, RDate 転出期限日R) {

        FlexibleDate 基準日 = new FlexibleDate(基準日R.getYearValue(), 基準日R.getMonthValue(), 基準日R.getDayValue());
        FlexibleDate 転入期限日 = new FlexibleDate(転入期限日R.getYearValue(), 転入期限日R.getMonthValue(), 転入期限日R.getDayValue());
        FlexibleDate 転出期限日 = new FlexibleDate(転出期限日R.getYearValue(), 転出期限日R.getMonthValue(), 転出期限日R.getDayValue());
        TeijiTourokuCyohyoSeitei result = new TeijiTourokuCyohyoSeitei();
        if (基準日.isEmpty() || 転入期限日.isEmpty() || 転出期限日.isEmpty()
                || RDate.MAX.equals(転入期限日R) || RDate.MIN.equals(転出期限日R) || RDate.MIN.equals(基準日R)) {
            return null;
        }

        result.set転入期間From(基準日.minusMonth(CommonConstant.月_4ヶ).plusDay(1));
        result.set転入期間To(転入期限日);

        // 基準日に一番近い過去の選挙.名簿基準年月日を取得
        ISenkyoRelateMapper senkyoRelateMapper = mapperProvider.create(ISenkyoRelateMapper.class);
        FlexibleDate ymd = senkyoRelateMapper.getMeiboTorokuYMD(基準日);
        if (ymd == null || ymd.isEmpty()) {
            result.set帰化期間From(基準日.minusMonth(CommonConstant.月_3ヶ));
        } else {
            result.set帰化期間From(ymd.plusDay(1));
        }
        result.set帰化期間To(基準日);

        result.set転出期間From(転出期限日);
        result.set転出期間To(転入期限日);
        return result;
    }
}
