/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG301;

import static jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler.getNullToRString;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.CodeTopType;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国外転入者調査票（照会）のパラメータクラスです。
 *
 * @reamsid_L AF-0360-065 b_caiyf
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KokugaiTennyushaChosahyoShokaiParameter {

    private MitorokushaMasshoTsuchiListEntity 選挙人資格の情報;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 発行日;
    private ShichosonAtesaki 他市町村送付先;
    private Association 導入団体;
    private RString 全国住所都道府県名;
    private RString 全国住所市区町村名;
    private RString 帳票ID;
    private FlexibleDate 名簿基準年月日;

    /**
     * コンストラクタ
     *
     * @param 選挙人資格の情報 SenkyoMeiboShohonEntity
     * @param 発行日 FlexibleDate
     * @param 他市町村送付先 ShichosonAtesaki
     * @param 発行番号_第 RString
     * @param 発行番号_番号 RString
     * @param 発行番号_号 RString
     * @param 導入団体 Association
     * @param 全国住所都道府県名 RString
     * @param 全国住所市区町村名 RString
     * @param 帳票ID RString
     * @param 名簿基準年月日 FlexibleDate
     */
    public KokugaiTennyushaChosahyoShokaiParameter(MitorokushaMasshoTsuchiListEntity 選挙人資格の情報,
            FlexibleDate 発行日, ShichosonAtesaki 他市町村送付先, RString 発行番号_第,
            RString 発行番号_番号, RString 発行番号_号, Association 導入団体,
            RString 全国住所都道府県名, RString 全国住所市区町村名, RString 帳票ID, FlexibleDate 名簿基準年月日) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.発行番号_第 = 発行番号_第;
        this.発行番号_番号 = 発行番号_番号;
        this.発行番号_号 = 発行番号_号;
        this.発行日 = 発行日;
        this.他市町村送付先 = 他市町村送付先;
        this.導入団体 = 導入団体;
        this.全国住所都道府県名 = 全国住所都道府県名;
        this.全国住所市区町村名 = 全国住所市区町村名;
        this.帳票ID = 帳票ID;
        this.名簿基準年月日 = 名簿基準年月日;
    }

    /**
     * 本籍全国住所コードの上5桁を取得します。。
     *
     * @param entity SenkyoMeiboShohonEntity
     * @return 本籍全国住所コードの上5桁
     */
    public RString get本籍全国住所コードの上5桁(MitorokushaMasshoTsuchiListEntity entity) {
        RString 本籍全国住所コード = getNullToRString(entity.getShikibetsuTaishoEntity().getHonsekiZenkokuJushoCode());
        if (本籍全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 本籍全国住所コード.substring(0, CodeTopType.コード上5桁.value());
        }
    }

}
