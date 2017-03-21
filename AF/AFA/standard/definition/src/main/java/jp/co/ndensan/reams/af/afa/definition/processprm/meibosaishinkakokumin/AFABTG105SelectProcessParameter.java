/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.meibosaishinkakokumin;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票人名簿最新化バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0390-030 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTG105SelectProcessParameter implements IBatchProcessParameter {

    private RString 抄本番号;
    private RString 抄本名;
    private FlexibleDate 投票日;
    private FlexibleDate 基準日;
    private FlexibleDate 名簿登録日;
    private FlexibleDate 年齢到達日;
    private FlexibleDate 特定期間開始日;
    private FlexibleDate 特定期限日;
    private FlexibleDate 受付開始日;
    private FlexibleDate 時点日;
    private Boolean 名簿並び替え;
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
    private IShikibetsuTaishoPSMSearchKey key;
    private RString sort;
    private RString 帳票ID;
    private RString order順;

    /**
     * コンストラクタです。
     *
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
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 名簿並び替え Boolean
     */
    public AFABTG105SelectProcessParameter(RString 抄本番号, RString 抄本名, FlexibleDate 投票日,
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
            IShikibetsuTaishoPSMSearchKey key,
            Boolean 名簿並び替え) {
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
        this.key = key;
        this.名簿並び替え = 名簿並び替え;
    }

    /**
     * AFABTG105SelectProcessMyBatisParameter変換のメソッド
     *
     * @return AFABTG105SelectProcessMyBatisParameter
     */
    public AFABTG105SelectProcessMyBatisParameter toAFABTG105SelectProcessMyBatisParameter() {
        int 選挙資格到達年齢_国民投票 = Integer.
                parseInt(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢_国民投票, SubGyomuCode.AFA選挙本体).toString());
        FlexibleDate 生年月日 = 年齢到達日.minusDay(選挙資格到達年齢_国民投票);
        return new AFABTG105SelectProcessMyBatisParameter(key,
                RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号),
                生年月日, null);
    }

}
