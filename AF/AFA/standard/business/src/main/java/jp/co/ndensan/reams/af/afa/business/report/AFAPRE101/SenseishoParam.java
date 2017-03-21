/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE101;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * Senseishoのパラメータクラスです。
 *
 * @reamsid_L AF-0070-020 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SenseishoParam {

    private final SenkyoninTohyoJokyoEntity 選挙人資格情報;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 期日前不在者区分;
    private final List<RString> 選挙名称リスト;

    /**
     * コンストラクタです
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 期日前不在者区分 RString
     * @param 選挙名称リスト List<RString>
     */
    public SenseishoParam(SenkyoninTohyoJokyoEntity 選挙人資格情報, TeijiCommonJohoItem 帳票共通ヘッダー,
            RString 期日前不在者区分, List<RString> 選挙名称リスト) {
        this.選挙人資格情報 = 選挙人資格情報;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.期日前不在者区分 = 期日前不在者区分;
        this.選挙名称リスト = 選挙名称リスト;
    }
}
