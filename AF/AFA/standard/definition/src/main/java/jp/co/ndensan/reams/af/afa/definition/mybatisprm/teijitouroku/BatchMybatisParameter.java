/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku;

import java.util.List;
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
 * 定時登録バッチパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class BatchMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private static final RString SORT_ORDER = new RString("order by");
    private static final RString SORT_SEPARATOR = new RString(" , ");

    private final RString 処理種別;
    private final FlexibleDate ageForselect;
    private final ShohonNo shohonNo;
    private RString sort;
    private final RString table;
    private FlexibleDate kijunbi;
    private FlexibleDate nenreiKigenbi;
    private final FlexibleDate kikaFrom;
    private final FlexibleDate tourokubi;
    private final FlexibleDate kikaTo;
    private final RString selectKijun;
    private final FlexibleDate 転入期間_開始日;
    private final FlexibleDate 転入期間_終了日;
    private final RString 出力条件;
    private final RString 識別コード;
    private final FlexibleDate 指定日Form;
    private final FlexibleDate 指定日To;
    private final RString 異動事由;
    private final RString 投票区From;
    private final RString 投票区To;
    private final RString 登録者数リスト_投票区From;
    private final RString 登録者数リスト_投票区To;
    private final RString 有権者数調べ_投票区From;
    private final RString 有権者数調べ_投票区To;
    private final Boolean has投票区From;
    private final Boolean has投票区To;
    private final Boolean has登録者数リスト_投票区From;
    private final Boolean has登録者数リスト_投票区To;
    private final Boolean has有権者数調べ_投票区From;
    private final Boolean has有権者数調べ_投票区To;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
    private RString riyoKubun;
    private RString chushutsuKubun;
    private RDateTime zenkaiChushutsu;
    private RDateTime konkaiChushutsu;
    private RString chuiShuruiCode;
    private RString yukoKigenKubun;
    private RString 消除年月日検索基準;
    private RString 登録年月日検索基準;
    private List<RString> idoJiyuCodeList;
    private RString 在外国外分類コード;
    private RString 地方公共団体コード;
    private int 地方公共団体コード連番;

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
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param sort RString
     * @param table RString
     * @param selectKijun RString
     * @param 転入期間_開始日 FlexibleDate
     * @param 転入期間_終了日 FlexibleDate
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日Form FlexibleDate
     * @param 指定日To FlexibleDate
     * @param 異動事由 RString
     * @param 投票区From 投票区From
     * @param 投票区To 投票区To
     * @param 登録者数リスト_投票区From 登録者数リスト_投票区From
     * @param 登録者数リスト_投票区To 登録者数リスト_投票区To
     * @param 有権者数調べ_投票区From 有権者数調べ_投票区From
     * @param 有権者数調べ_投票区To 有権者数調べ_投票区To
     */
    public BatchMybatisParameter(RString 処理種別, FlexibleDate ageForselect, FlexibleDate kijunbi, FlexibleDate nenreiKigenbi,
            FlexibleDate tourokubi, FlexibleDate kikaFrom, FlexibleDate kikaTo, IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll, ShohonNo shohonNo,
            RString sort, RString table, RString selectKijun, FlexibleDate 転入期間_開始日, FlexibleDate 転入期間_終了日,
            RString 出力条件, RString 識別コード, FlexibleDate 指定日Form, FlexibleDate 指定日To, RString 異動事由, RString 投票区From,
            RString 投票区To, RString 登録者数リスト_投票区From, RString 登録者数リスト_投票区To, RString 有権者数調べ_投票区From,
            RString 有権者数調べ_投票区To) {
        super(key);
        shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(keyForAll == null ? key : keyForAll);
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
        this.出力条件 = 出力条件;
        this.識別コード = 識別コード;
        this.指定日Form = 指定日Form;
        this.指定日To = 指定日To;
        this.異動事由 = 異動事由;
        this.投票区From = 投票区From;
        this.投票区To = 投票区To;
        this.登録者数リスト_投票区From = 登録者数リスト_投票区From;
        this.登録者数リスト_投票区To = 登録者数リスト_投票区To;
        this.有権者数調べ_投票区From = 有権者数調べ_投票区From;
        this.有権者数調べ_投票区To = 有権者数調べ_投票区To;
        this.has投票区From = RString.isNullOrEmpty(投票区From);
        this.has投票区To = RString.isNullOrEmpty(投票区To);
        this.has登録者数リスト_投票区From = RString.isNullOrEmpty(登録者数リスト_投票区From);
        this.has登録者数リスト_投票区To = RString.isNullOrEmpty(登録者数リスト_投票区To);
        this.has有権者数調べ_投票区From = RString.isNullOrEmpty(有権者数調べ_投票区From);
        this.has有権者数調べ_投票区To = RString.isNullOrEmpty(有権者数調べ_投票区To);
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

    /**
     * 出力順の追加です。
     *
     * @param sort RString
     */
    public void addSortAfter(RString sort) {
        if (RString.isNullOrEmpty(this.sort)) {
            this.sort = SORT_ORDER.concat(RString.HALF_SPACE).concat(sort);
        } else {
            this.sort = this.sort.concat(SORT_SEPARATOR).concat(sort);
        }
    }

    /**
     * 出力順の追加です。
     *
     * @param sort RString
     */
    public void addSortBefore(RString sort) {
        if (RString.isNullOrEmpty(this.sort)) {
            this.sort = SORT_ORDER.concat(RString.HALF_SPACE).concat(sort);
        } else {
            this.sort = this.sort.replace(SORT_ORDER, SORT_ORDER.concat(RString.HALF_SPACE).concat(sort).concat(SORT_SEPARATOR));
        }
    }
}
