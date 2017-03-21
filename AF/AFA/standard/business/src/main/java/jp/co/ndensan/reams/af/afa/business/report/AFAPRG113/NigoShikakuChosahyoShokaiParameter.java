/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG113;

import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtg101.NigoShikakuChosahyoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 2号資格調査票（照会）（様式2-1）のパラメータです。
 *
 * @reamsid_L AF-0360-061 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NigoShikakuChosahyoShokaiParameter {

    private final NigoShikakuChosahyoEntity entity;
    private final RString 転入元郵便番号;
    private final RString 都道府県名;
    private final RString 市区町村名;
    private final Association 導入団体;
    private final RString 発行番号_第;
    private final RString 発行番号_番号;
    private final RString 発行番号_号;
    private final FlexibleDate 発行年月日;
    private final int page;

    /**
     * コンストラクタです。
     *
     * @param entity NigoShikakuChosahyoEntity
     * @param 市区町村名 RString
     * @param 都道府県名 RString
     * @param 転入元郵便番号 RString
     * @param 導入団体 Association
     * @param 発行番号_第 RString
     * @param 発行番号_番号 RString
     * @param 発行番号_号 RString
     * @param 発行年月日 FlexibleDate
     * @param page int
     *
     */
    public NigoShikakuChosahyoShokaiParameter(NigoShikakuChosahyoEntity entity, RString 転入元郵便番号, RString 都道府県名, RString 市区町村名, Association 導入団体,
            RString 発行番号_第, RString 発行番号_番号, RString 発行番号_号, FlexibleDate 発行年月日, int page) {
        this.entity = entity;
        this.転入元郵便番号 = 転入元郵便番号;
        this.都道府県名 = 都道府県名;
        this.市区町村名 = 市区町村名;
        this.導入団体 = 導入団体;
        this.発行番号_第 = 発行番号_第;
        this.発行番号_番号 = 発行番号_番号;
        this.発行番号_号 = 発行番号_号;
        this.発行年月日 = 発行年月日;
        this.page = page;
    }
}
