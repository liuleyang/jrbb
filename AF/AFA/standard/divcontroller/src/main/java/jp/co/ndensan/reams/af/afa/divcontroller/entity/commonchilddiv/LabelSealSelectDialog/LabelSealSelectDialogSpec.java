/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealSelectDialog;

import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ラベルシール印刷確認ダイアログ用Specクラスです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
public enum LabelSealSelectDialogSpec implements IPredicate<LabelSealSelectDialogDiv> {

    /**
     * 開始印字位置チェック。
     */
    開始印字位置チェック {
                @Override
                public boolean apply(LabelSealSelectDialogDiv div) {
                    return div.getCcdSealPosition().isDisplayNone()
                    || !((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue().isNullOrEmpty();
                }
            }
}
