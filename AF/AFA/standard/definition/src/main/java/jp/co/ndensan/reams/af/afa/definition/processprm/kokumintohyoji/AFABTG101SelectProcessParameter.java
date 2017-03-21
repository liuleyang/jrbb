/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 国民投票時登録バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTG101SelectProcessParameter implements IBatchProcessParameter {

    private RString 処理種別;
    private ShohonNo 抄本番号;
    private RString 抄本名;
    private FlexibleDate 投票日;
    private FlexibleDate 基準日;
    private FlexibleDate 名簿登録日;
    private FlexibleDate 年齢到達日;
    private FlexibleDate 特定期間開始日;
    private FlexibleDate 特定期限日;
    private FlexibleDate 受付開始日;
    private FlexibleDate 時点日;
    private FlexibleDate 発行日_1号資格登録;
    private RString 発行番号の第_1号資格;
    private RString 発行番号の番号_1号資格;
    private RString 発行番号の号_1号資格;
    private FlexibleDate 発行日_2号資格;
    private RString 発行番号の第_2号資格;
    private RString 発行番号の番号_2号資格;
    private RString 発行番号の号_2号資格;
    private FlexibleDate 抹消日;
    private FlexibleDate 発行日_未登録者抹消;
    private RString 発行番号の第_未登録者抹消;
    private RString 発行番号の番号_未登録者抹消;
    private RString 発行番号の号_未登録者抹消;
    private FlexibleDate 発行日_国内転入者調査票;
    private RString 発行番号の第_国内転入者調査票;
    private RString 発行番号の番号_国内転入者調査票;
    private RString 発行番号の号_国内転入者調査票;
    private FlexibleDate 発行日_国外転入者調査票;
    private RString 発行番号の第_国外転入者調査票;
    private RString 発行番号の番号_国外転入者調査票;
    private RString 発行番号の号_国外転入者調査票;
    private RString sort;
    private RString table;
    private FlexibleDate ageForselect;
    private List<AFABTB101Senkyoichiran> 選挙一覧リスト;
    private ShohonNo 研修用発番抄本番号;
    private SenkyoShurui 選挙種類;
    private RString order順;

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 名簿登録日 FlexibleDate
     * @param 年齢到達日 FlexibleDate
     * @param 特定期間開始日 FlexibleDate
     * @param 特定期限日 FlexibleDate
     * @param 受付開始日 FlexibleDate
     * @param 時点日 FlexibleDate
     * @param 発行日_1号資格登録 FlexibleDate
     * @param 発行番号の第_1号資格 RString
     * @param 発行番号の番号_1号資格 RString
     * @param 発行番号の号_1号資格 RString
     * @param 発行日_2号資格 FlexibleDate
     * @param 発行番号の第_2号資格 RString
     * @param 発行番号の番号_2号資格 RString
     * @param 発行番号の号_2号資格 RString
     * @param 抹消日 FlexibleDate
     * @param 発行日_未登録者抹消 FlexibleDate
     * @param 発行番号の第_未登録者抹消 RString
     * @param 発行番号の番号_未登録者抹消 RString
     * @param 発行番号の号_未登録者抹消 RString
     * @param 発行日_国内転入者調査票 FlexibleDate
     * @param 発行番号の第_国内転入者調査票 RString
     * @param 発行番号の番号_国内転入者調査票 RString
     * @param 発行番号の号_国内転入者調査票 RString
     * @param 発行日_国外転入者調査票 FlexibleDate
     * @param 発行番号の第_国外転入者調査票 RString
     * @param 発行番号の番号_国外転入者調査票 RString
     * @param 発行番号の号_国外転入者調査票 RString
     * @param 選挙一覧リスト 選挙一覧リスト
     * @param order順 RString
     */
    public AFABTG101SelectProcessParameter(RString 処理種別, ShohonNo 抄本番号, RString 抄本名, FlexibleDate 投票日,
            FlexibleDate 基準日, FlexibleDate 名簿登録日, FlexibleDate 年齢到達日, FlexibleDate 特定期間開始日,
            FlexibleDate 特定期限日, FlexibleDate 受付開始日,
            FlexibleDate 時点日, FlexibleDate 発行日_1号資格登録, RString 発行番号の第_1号資格, RString 発行番号の番号_1号資格,
            RString 発行番号の号_1号資格, FlexibleDate 発行日_2号資格, RString 発行番号の第_2号資格,
            RString 発行番号の番号_2号資格, RString 発行番号の号_2号資格, FlexibleDate 抹消日,
            FlexibleDate 発行日_未登録者抹消, RString 発行番号の第_未登録者抹消,
            RString 発行番号の番号_未登録者抹消, RString 発行番号の号_未登録者抹消, FlexibleDate 発行日_国内転入者調査票,
            RString 発行番号の第_国内転入者調査票, RString 発行番号の番号_国内転入者調査票,
            RString 発行番号の号_国内転入者調査票, FlexibleDate 発行日_国外転入者調査票,
            RString 発行番号の第_国外転入者調査票, RString 発行番号の番号_国外転入者調査票, RString 発行番号の号_国外転入者調査票,
            List<AFABTB101Senkyoichiran> 選挙一覧リスト, RString order順) {
        this.処理種別 = 処理種別;
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.基準日 = 基準日;
        this.名簿登録日 = 名簿登録日;
        this.年齢到達日 = 年齢到達日;
        this.特定期間開始日 = 特定期間開始日;
        this.特定期限日 = 特定期限日;
        this.受付開始日 = 受付開始日;
        this.時点日 = 時点日;
        this.発行日_1号資格登録 = 発行日_1号資格登録;
        this.発行番号の第_1号資格 = 発行番号の第_1号資格;
        this.発行番号の番号_1号資格 = 発行番号の番号_1号資格;
        this.発行番号の号_1号資格 = 発行番号の号_1号資格;
        this.発行日_2号資格 = 発行日_2号資格;
        this.発行番号の第_2号資格 = 発行番号の第_2号資格;
        this.発行番号の番号_2号資格 = 発行番号の番号_2号資格;
        this.発行番号の号_2号資格 = 発行番号の号_2号資格;
        this.抹消日 = 抹消日;
        this.発行日_未登録者抹消 = 発行日_未登録者抹消;
        this.発行番号の第_未登録者抹消 = 発行番号の第_未登録者抹消;
        this.発行番号の番号_未登録者抹消 = 発行番号の番号_未登録者抹消;
        this.発行番号の号_未登録者抹消 = 発行番号の号_未登録者抹消;
        this.発行日_国内転入者調査票 = 発行日_国内転入者調査票;
        this.発行番号の第_国内転入者調査票 = 発行番号の第_国内転入者調査票;
        this.発行番号の番号_国内転入者調査票 = 発行番号の番号_国内転入者調査票;
        this.発行番号の号_国内転入者調査票 = 発行番号の号_国内転入者調査票;
        this.発行日_国外転入者調査票 = 発行日_国外転入者調査票;
        this.発行番号の第_国外転入者調査票 = 発行番号の第_国外転入者調査票;
        this.発行番号の番号_国外転入者調査票 = 発行番号の番号_国外転入者調査票;
        this.発行番号の号_国外転入者調査票 = 発行番号の号_国外転入者調査票;
        this.選挙一覧リスト = 選挙一覧リスト;
        this.order順 = order順;
    }

    /**
     * BatchMybatisParameter変換のメソッド
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @return KokuminTohyojiMybatisParameter
     */
    public KokuminTohyojiMybatisParameter toBatchMybatisParameter(IShikibetsuTaishoPSMSearchKey key, IShikibetsuTaishoPSMSearchKey keyForAll) {
        int 選挙資格到達年齢_国民投票 = Integer.
                parseInt(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢_国民投票, RDate.getNowDate(), SubGyomuCode.AFA選挙本体).toString());
        FlexibleDate 生年月日 = 年齢到達日.minusYear(選挙資格到達年齢_国民投票);
        FlexibleDate 名簿登録年月日 = 基準日.plusDay(2);
        RString order;
        if (RString.isNullOrEmpty(order順)) {
            order = new RString("order by");
        } else {
            order = order順.concat(new RString(","));
        }
        return new KokuminTohyojiMybatisParameter(年齢到達日, 基準日, 抄本番号, 抹消日, 投票日, 特定期限日,
                特定期間開始日, sort, key, keyForAll, 名簿登録年月日, 生年月日, table, ageForselect, order);
    }

    /**
     * AFABTA101SelectProcessParameterへ変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @return AFABTA101SelectProcessParameter
     */
    public AFABTA101SelectProcessParameter toAFABTA101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {
        return new AFABTA101SelectProcessParameter(
                処理種別,
                抄本番号,
                抄本名,
                基準日,
                名簿登録日,
                投票日,
                特定期間開始日,
                特定期限日,
                年齢到達日,
                Arrays.asList(FlexibleDate.EMPTY, FlexibleDate.EMPTY),
                key,
                keyForAll,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * TeijiTourokuDataDeleteMybatisParameter変換のメソッド
     *
     * @return TeijiTourokuDataDeleteMybatisParameter
     */
    public TeijiTourokuDataDeleteMybatisParameter toTeijiTourokuDataDeleteMybatisParameter() {
        FlexibleDate 基準日_検索用 = 基準日.minusYear(Integer.valueOf(
                BusinessConfig.get(ConfigKeysAFA.抄本保有年数_国民投票, SubGyomuCode.AFA選挙本体).toString()));
        return new TeijiTourokuDataDeleteMybatisParameter(処理種別, 基準日_検索用, 抄本番号);
    }

    /**
     * AFABTB101SelectProcessParameterへ変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @return AFABTB101SelectProcessParameter
     */
    public AFABTB101SelectProcessParameter toAFABTB101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {

        return new AFABTB101SelectProcessParameter(処理種別,
                選挙一覧リスト,
                抄本番号,
                抄本名,
                基準日,
                名簿登録日,
                投票日,
                特定期間開始日,
                特定期限日,
                年齢到達日,
                Arrays.asList(FlexibleDate.EMPTY, FlexibleDate.EMPTY),
                key,
                keyForAll,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

    }
}
