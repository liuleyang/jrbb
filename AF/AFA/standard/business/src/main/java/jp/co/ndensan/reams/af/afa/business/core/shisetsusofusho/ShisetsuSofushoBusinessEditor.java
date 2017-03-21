/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shisetsusofusho;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shisetsusofusho.ShisetsusofushoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設送付書の編集クラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class ShisetsuSofushoBusinessEditor {

    /**
     * 改ページ条件を判断する。
     *
     * @param 改ページキーリスト List<RString>
     * @param 明細情報Before ShisetsusofushoEntity
     * @param 明細情報After ShisetsusofushoEntity
     * @return Boolean
     */
    public boolean hasBreak(List<RString> 改ページキーリスト,
            ShisetsusofushoEntity 明細情報Before,
            ShisetsusofushoEntity 明細情報After) {
        if (改ページキーリスト == null || 改ページキーリスト.isEmpty() || 明細情報Before == null) {
            return Boolean.FALSE;
        }
        RString 施設コードBefore = 明細情報Before.get施設コード();
        RString 施設コードAfter = 明細情報After.get施設コード();
        Boolean is改ページ = is改ページ_施設コード(改ページキーリスト, 施設コードBefore, 施設コードAfter);
        if (is改ページ) {
            return is改ページ;
        }
        RString 選挙番号Before = 明細情報Before.get選挙番号() == null
                ? RString.EMPTY : new RString(明細情報Before.get選挙番号().getColumnValue());
        RString 選挙番号After = 明細情報After.get選挙番号() == null
                ? RString.EMPTY : new RString(明細情報After.get選挙番号().getColumnValue());
        is改ページ = is改ページ_選挙番号(改ページキーリスト, 選挙番号Before, 選挙番号After);

        return is改ページ;
    }

    private boolean is改ページ_施設コード(List<RString> 改ページキーリスト,
            RString 施設コードBefore,
            RString 施設コードAfter) {
        Boolean is改ページ = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.施設コード.get項目ID())) {
            if (RString.isNullOrEmpty(施設コードBefore) && RString.isNullOrEmpty(施設コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(施設コードBefore)
                    && !RString.isNullOrEmpty(施設コードAfter)
                    && 施設コードBefore.equals(施設コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }

    private boolean is改ページ_選挙番号(List<RString> 改ページキーリスト,
            RString 選挙番号Before,
            RString 選挙番号After) {
        Boolean is改ページ = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.選挙番号.get項目ID())) {
            if (RString.isNullOrEmpty(選挙番号Before) && RString.isNullOrEmpty(選挙番号After)) {
                is改ページ = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(選挙番号Before)
                    && !RString.isNullOrEmpty(選挙番号After)
                    && 選挙番号Before.equals(選挙番号After)) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }
}
