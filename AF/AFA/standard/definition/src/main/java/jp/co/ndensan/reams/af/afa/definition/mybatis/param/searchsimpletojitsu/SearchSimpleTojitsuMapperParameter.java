/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.searchsimpletojitsu;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住民検索を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0260-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class SearchSimpleTojitsuMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;
    private final Code 選挙種類;
    private final RString 投票区コード;
    private final RString 冊;
    private final int 頁;
    private final int 行;
    private final RString 氏名;
    private final int 最大表示件数;
    private final boolean is氏名前方一致;
    private final boolean is氏名後方一致;
    private final boolean is氏名部分一致;

    private final boolean isUsing投票区コード;
    private final boolean isUsing氏名;
    private final boolean isUsing冊;
    private final boolean isUsing頁;
    private final boolean isUsing行;

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙種類 Code
     * @param 投票区コード RString
     * @param 冊 RString
     * @param 頁 Decimal
     * @param 行 Decimal
     * @param 氏名 RString
     * @param 最大表示件数 int
     * @param is氏名前方一致 boolean
     * @param is氏名後方一致 boolean
     * @param is氏名部分一致 boolean
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public SearchSimpleTojitsuMapperParameter(
            ShohonNo 抄本番号,
            Code 選挙種類,
            RString 投票区コード,
            RString 冊,
            Decimal 頁,
            Decimal 行,
            RString 氏名,
            int 最大表示件数,
            boolean is氏名前方一致,
            boolean is氏名後方一致,
            boolean is氏名部分一致,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抄本番号 = 抄本番号;
        this.選挙種類 = 選挙種類;
        this.投票区コード = 投票区コード;
        this.冊 = 冊;
        this.頁 = 頁 == null ? Integer.MIN_VALUE : 頁.intValue();
        this.行 = 行 == null ? Integer.MIN_VALUE : 行.intValue();
        this.氏名 = 氏名;
        this.最大表示件数 = 最大表示件数;
        this.is氏名前方一致 = is氏名前方一致;
        this.is氏名後方一致 = is氏名後方一致;
        this.is氏名部分一致 = is氏名部分一致;

        this.isUsing投票区コード = isUsingコード(投票区コード);
        this.isUsing氏名 = isUsingコード(氏名);
        this.isUsing冊 = isUsingコード(冊);
        this.isUsing頁 = 頁 != null;
        this.isUsing行 = 行 != null;
    }

    private static boolean isUsingコード(RString コード) {
        return !コード.isNullOrEmpty();
    }

}
