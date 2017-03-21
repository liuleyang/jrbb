/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SenkyojiMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final RString 処理種別;
    private final FlexibleDate ageForselect;
    private final ShohonNo shohonNo;
    private final RString sort;
    private final RString table;
    private FlexibleDate kijunbi;
    private FlexibleDate nenreiKigenbi;
    private final FlexibleDate kikaFrom;
    private final FlexibleDate tourokubi;
    private final FlexibleDate kikaTo;
    private final RString selectKijun;
    private final FlexibleDate 転入期間_開始日;
    private final FlexibleDate 転入期間_終了日;
    private final FlexibleDate 転出期間_開始日;
    private final FlexibleDate 転出期間_終了日;
    private final RString 出力条件;
    private final RString 識別コード;
    private final FlexibleDate 指定日Form;
    private final FlexibleDate 指定日To;
    private final RString 異動事由;
    private final RString tohyokuCodeFrom;
    private final RString tohyokuCodeTo;
    private final RString order順;
    private final RString 改頁;
    private RString riyoKubun;
    private RString chushutsuKubun;
    private RDateTime zenkaiChushutsu;
    private RDateTime konkaiChushutsu;
    private RString chuiShuruiCode;
    private RString yukoKigenKubun;
    private RString 在外国外分類コード;
    private RString 地方公共団体コード;
    private int 地方公共団体コード連番;
    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param ageForselect FlexibleDate
     * @param kijunbi FlexibleDate
     * @param nenreiKigenbi FlexibleDate
     * @param tourokubi FlexibleDate
     * @param kikaFrom FlexibleDate
     * @param kikaTo FlexibleDate
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param sort RString
     * @param table RString
     * @param selectKijun RString
     * @param 転入期間_開始日 FlexibleDate
     * @param 転入期間_終了日 FlexibleDate
     * @param 転出期間_開始日 FlexibleDate
     * @param 転出期間_終了日 FlexibleDate
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日Form FlexibleDate
     * @param 指定日To FlexibleDate
     * @param 異動事由 RString
     * @param tohyokuCodeFrom RString
     * @param tohyokuCodeTo RString
     * @param order順 RString
     * @param 改頁 RString
     */
    public SenkyojiMybatisParameter(RString 処理種別,
            FlexibleDate ageForselect,
            FlexibleDate kijunbi,
            FlexibleDate nenreiKigenbi,
            FlexibleDate tourokubi,
            FlexibleDate kikaFrom,
            FlexibleDate kikaTo,
            IShikibetsuTaishoPSMSearchKey key,
            ShohonNo shohonNo,
            RString sort,
            RString table,
            RString selectKijun,
            FlexibleDate 転入期間_開始日,
            FlexibleDate 転入期間_終了日,
            FlexibleDate 転出期間_開始日,
            FlexibleDate 転出期間_終了日,
            RString 出力条件,
            RString 識別コード,
            FlexibleDate 指定日Form,
            FlexibleDate 指定日To,
            RString 異動事由,
            RString tohyokuCodeFrom,
            RString tohyokuCodeTo,
            RString order順,
            RString 改頁) {
        super(key);
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(key);
        this.処理種別 = 処理種別;
        this.ageForselect = ageForselect;
        this.kijunbi = kijunbi;
        this.nenreiKigenbi = nenreiKigenbi;
        this.tourokubi = tourokubi;
        this.kikaFrom = kikaFrom;
        this.kikaTo = kikaTo;
        this.shohonNo = shohonNo;
        this.sort = sort;
        this.table = table;
        this.selectKijun = selectKijun;
        this.転入期間_開始日 = 転入期間_開始日;
        this.転入期間_終了日 = 転入期間_終了日;
        this.転出期間_開始日 = 転出期間_開始日;
        this.転出期間_終了日 = 転出期間_終了日;
        this.出力条件 = 出力条件;
        this.識別コード = 識別コード;
        this.指定日Form = 指定日Form;
        this.指定日To = 指定日To;
        this.異動事由 = 異動事由;
        this.tohyokuCodeFrom = tohyokuCodeFrom;
        this.tohyokuCodeTo = tohyokuCodeTo;
        this.order順 = order順;
        this.改頁 = 改頁;
    }

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param ageForselect FlexibleDate
     * @param kijunbi FlexibleDate
     * @param nenreiKigenbi FlexibleDate
     * @param tourokubi FlexibleDate
     * @param kikaFrom FlexibleDate
     * @param kikaTo FlexibleDate
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param sort RString
     * @param table RString
     * @param selectKijun RString
     * @param 転入期間_開始日 FlexibleDate
     * @param 転入期間_終了日 FlexibleDate
     * @param 転出期間_開始日 FlexibleDate
     * @param 転出期間_終了日 FlexibleDate
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日Form FlexibleDate
     * @param 指定日To FlexibleDate
     * @param 異動事由 RString
     * @param order順 RString
     * @param 改頁 RString
     */
    public SenkyojiMybatisParameter(RString 処理種別,
            FlexibleDate ageForselect,
            FlexibleDate kijunbi,
            FlexibleDate nenreiKigenbi,
            FlexibleDate tourokubi,
            FlexibleDate kikaFrom,
            FlexibleDate kikaTo,
            IShikibetsuTaishoPSMSearchKey key,
            ShohonNo shohonNo,
            RString sort,
            RString table,
            RString selectKijun,
            FlexibleDate 転入期間_開始日,
            FlexibleDate 転入期間_終了日,
            FlexibleDate 転出期間_開始日,
            FlexibleDate 転出期間_終了日,
            RString 出力条件,
            RString 識別コード,
            FlexibleDate 指定日Form,
            FlexibleDate 指定日To,
            RString 異動事由,
            RString order順,
            RString 改頁) {
        super(key);
        this.処理種別 = 処理種別;
        this.ageForselect = ageForselect;
        this.kijunbi = kijunbi;
        this.nenreiKigenbi = nenreiKigenbi;
        this.tourokubi = tourokubi;
        this.kikaFrom = kikaFrom;
        this.kikaTo = kikaTo;
        this.shohonNo = shohonNo;
        this.sort = sort;
        this.table = table;
        this.selectKijun = selectKijun;
        this.転入期間_開始日 = 転入期間_開始日;
        this.転入期間_終了日 = 転入期間_終了日;
        this.転出期間_開始日 = 転出期間_開始日;
        this.転出期間_終了日 = 転出期間_終了日;
        this.出力条件 = 出力条件;
        this.識別コード = 識別コード;
        this.指定日Form = 指定日Form;
        this.指定日To = 指定日To;
        this.異動事由 = 異動事由;
        this.tohyokuCodeFrom = null;
        this.tohyokuCodeTo = null;
        this.order順 = order順;
        this.改頁 = 改頁;
    }

    /**
     * 年齢期限日の設定です。
     *
     * @param 年齢期限日 FlexibleDate
     */
    public void editNenreiKigenbi(FlexibleDate 年齢期限日) {
        this.nenreiKigenbi = 年齢期限日;
    }

    /**
     * 基準日の設定です。
     *
     * @param 基準日 FlexibleDate
     */
    public void editKijunbi(FlexibleDate 基準日) {
        this.kijunbi = 基準日;
    }
}
