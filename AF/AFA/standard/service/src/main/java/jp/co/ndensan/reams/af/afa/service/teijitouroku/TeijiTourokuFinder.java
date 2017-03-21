/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.teijitouroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.ISenkyoRelateMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuDateKeisan;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 定時登録ビジネスクラス
 *
 */
public class TeijiTourokuFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TeijiTourokuFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    TeijiTourokuFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンス
     */
    public static TeijiTourokuFinder createInstance() {
        return InstanceProvider.create(TeijiTourokuFinder.class);
    }

    /**
     * 日付を自動計算する
     *
     * @param 基準日 FlexibleDate
     * @return 登録日、転出期限日、転入期限日、年齢期限日
     */
    @Transaction
    public TeijiTourokuDateKeisan dateKeisan(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        if (基準日.isEmpty()) {
            return null;
        }
        TeijiTourokuDateKeisan result = new TeijiTourokuDateKeisan();
        // 業務実行
        RString teijiToroku = BusinessConfig.get(ConfigKeysAFA.定時_登録日判定基準, SubGyomuCode.AFA選挙本体);
        RString teijiTensyutu = BusinessConfig.get(ConfigKeysAFA.定時_転出期限日判定基準, SubGyomuCode.AFA選挙本体);
        RString teijiTennyuu = BusinessConfig.get(ConfigKeysAFA.定時_転入期限日判定基準, SubGyomuCode.AFA選挙本体);

        if (AFAConfigKeysValue.定時_登録日判定基準_基準日_ADD1日.isEqual(teijiToroku)) {
            result.set登録日(基準日.plusDay(1));
        } else if (AFAConfigKeysValue.定時_登録日判定基準_基準日.isEqual(teijiToroku)) {
            result.set登録日(基準日);
        }

        if (AFAConfigKeysValue.定時_転出期限日判定基準_基準日_4ヶ月.isEqual(teijiTensyutu)) {
            result.set転出期限日(基準日.minusMonth(CommonConstant.月_4ヶ));
        } else if (AFAConfigKeysValue.定時_転出期限日判定基準_基準日_4ヶ月_ADD1日.isEqual(teijiTensyutu)) {
            result.set転出期限日(基準日.minusMonth(CommonConstant.月_4ヶ).plusDay(1));
        } else if (AFAConfigKeysValue.定時_転出期限日判定基準_基準日_4ヶ月_MINUS1日.isEqual(teijiTensyutu)) {
            result.set転出期限日(基準日.minusMonth(CommonConstant.月_4ヶ).minusDay(1));
        }

        if (AFAConfigKeysValue.定時_転入期限日判定基準_基準日_3ヶ月.isEqual(teijiTennyuu)) {
            result.set転入期限日(基準日.minusMonth(CommonConstant.月_3ヶ));
        } else if (AFAConfigKeysValue.定時_転入期限日判定基準_基準日_3ヶ月_ADD1日.isEqual(teijiTennyuu)) {
            result.set転入期限日(基準日.minusMonth(CommonConstant.月_3ヶ).plusDay(1));
        } else if (AFAConfigKeysValue.定時_転入期限日判定基準_基準日_3ヶ月_MINUS1日.isEqual(teijiTennyuu)) {
            result.set転入期限日(基準日.minusMonth(CommonConstant.月_3ヶ).minusDay(1));
        }

        result.set年齢期限日(基準日.plusDay(1));

        return result;
    }

    /**
     * 帳票の条件を設定する
     *
     * @param 基準日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @return 転入期間From～To、帰化期間From～To
     */
    @Transaction
    public TeijiTourokuCyohyoSeitei cyouhyouJyoukenSet(FlexibleDate 基準日, FlexibleDate 転入期限日) {
        requireNonNull(転入期限日, UrSystemErrorMessages.値がnull.getReplacedMessage("転入期限日"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        if (基準日.isEmpty() || 転入期限日.isEmpty()) {
            return null;
        }
        TeijiTourokuCyohyoSeitei result = new TeijiTourokuCyohyoSeitei();
        result.set転入期間From(基準日.minusMonth(CommonConstant.月_4ヶ).plusDay(1));
        result.set転入期間To(転入期限日);

        // 基準日に一番近い過去の選挙.名簿基準年月日を取得
        ISenkyoRelateMapper senkyoRelateMapper = mapperProvider.create(ISenkyoRelateMapper.class);
        FlexibleDate ymd = senkyoRelateMapper.getMeiboTorokuYMD(基準日);
        FlexibleDate 帰化期間From;
        if (null == ymd || ymd.isEmpty()) {
            帰化期間From = 基準日.minusMonth(CommonConstant.月_3ヶ);
        } else {
            帰化期間From = ymd.plusDay(1);
        }
        result.set帰化期間From(帰化期間From);
        result.set帰化期間To(基準日);
        return result;
    }
}
