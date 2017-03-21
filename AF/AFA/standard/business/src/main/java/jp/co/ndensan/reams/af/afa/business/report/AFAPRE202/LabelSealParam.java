/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE202;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * LabelSealのパラメータクラスです。
 *
 * @reamsid_L AF-0070-021 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class LabelSealParam {

    private final SenkyoninTohyoJokyoEntity 選挙人資格情報;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 期日前不在者区分;
    private final List<RString> 選挙マークリスト;
    private final RString シール種別;
    private final List<RString> 施設種別コード名称リスト;
    private final List<RString> 施設名称リスト;
    private final int 選挙Index;

    /**
     * コンストラクタです
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 期日前不在者区分 RString
     * @param 選挙マークリスト List<RString>
     * @param シール種別 RString
     * @param 施設種別コード名称リスト List<RString>
     * @param 施設名称リスト List<RString>
     * @param 選挙Index int
     */
    public LabelSealParam(SenkyoninTohyoJokyoEntity 選挙人資格情報, TeijiCommonJohoItem 帳票共通ヘッダー,
            RString 期日前不在者区分, List<RString> 選挙マークリスト, RString シール種別, List<RString> 施設種別コード名称リスト, List<RString> 施設名称リスト, int 選挙Index) {
        this.選挙人資格情報 = 選挙人資格情報;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.期日前不在者区分 = 期日前不在者区分;
        this.選挙マークリスト = 選挙マークリスト;
        this.シール種別 = シール種別;
        this.施設種別コード名称リスト = 施設種別コード名称リスト;
        this.施設名称リスト = 施設名称リスト;
        this.選挙Index = 選挙Index;
    }
}
