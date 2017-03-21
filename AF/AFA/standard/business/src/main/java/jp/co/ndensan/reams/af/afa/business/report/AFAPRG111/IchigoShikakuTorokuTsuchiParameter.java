/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG111;

import static jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler.getNullToRString;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.IchigoShikakuTorokuTsuchiListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 1号資格登録通知（様式1）のパラメータクラスです。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IchigoShikakuTorokuTsuchiParameter {

    private static final int 転入前全国住所コード上5桁 = 5;

    private IchigoShikakuTorokuTsuchiListEntity 選挙人資格の情報;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private RString page;
    private FlexibleDate 発行日;
    private final Association 導入団体;
    private final RString 都道府県名;
    private final RString 市区町村名;
    private ShichosonAtesaki 他市町村送付先;
    private final boolean 郵便番号印字有無;
    private FlexibleDate 登録基準日;

    /**
     * コンストラクタ
     *
     * @param 選挙人資格の情報 SenkyoMeiboShohonEntity
     * @param 発行番号_第 RString
     * @param 発行番号_番号 RString
     * @param 発行番号_号 RString
     * @param page RString
     * @param 発行日 FlexibleDate
     * @param 導入団体 Association
     * @param 都道府県名 RString
     * @param 市区町村名 RString
     * @param 他市町村送付先 ShichosonAtesaki
     * @param 郵便番号印字有無 boolean
     * @param 登録基準日 FlexibleDate
     */
    public IchigoShikakuTorokuTsuchiParameter(IchigoShikakuTorokuTsuchiListEntity 選挙人資格の情報,
            RString 発行番号_第,
            RString 発行番号_番号,
            RString 発行番号_号,
            RString page,
            FlexibleDate 発行日,
            Association 導入団体,
            RString 都道府県名,
            RString 市区町村名,
            ShichosonAtesaki 他市町村送付先,
            boolean 郵便番号印字有無,
            FlexibleDate 登録基準日) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.発行番号_第 = 発行番号_第;
        this.発行番号_番号 = 発行番号_番号;
        this.発行番号_号 = 発行番号_号;
        this.page = page;
        this.発行日 = 発行日;
        this.導入団体 = 導入団体;
        this.都道府県名 = 都道府県名;
        this.市区町村名 = 市区町村名;
        this.他市町村送付先 = 他市町村送付先;
        this.郵便番号印字有無 = 郵便番号印字有無;
        this.登録基準日 = 登録基準日;

    }

    /**
     * 転入前全国住所コード上5桁を取得します。。
     *
     * @param 選挙人資格の情報 IchigoShikakuTorokuTsuchiListEntity
     * @return 転入前全国住所コード上5桁
     */
    public RString get転入前全国住所コード上5桁(IchigoShikakuTorokuTsuchiListEntity 選挙人資格の情報) {
        RString 転入前全国住所コード = getNullToRString(選挙人資格の情報.getShikibetsuTaishoEntity().getTennyumaeZenkokuJushoCode());
        if (転入前全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 転入前全国住所コード.substring(0, 転入前全国住所コード上5桁);
        }
    }
}
