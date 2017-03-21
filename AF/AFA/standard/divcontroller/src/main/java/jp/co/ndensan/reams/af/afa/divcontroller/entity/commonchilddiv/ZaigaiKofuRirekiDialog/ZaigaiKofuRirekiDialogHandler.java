/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiKofuRirekiDialog;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.zaigaikofurireki.ZaigaikofurirekiResult;
import jp.co.ndensan.reams.af.afa.service.zaigaikofurireki.ZaigaiKofuRirekiFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 在外交付履歴ダイアログのHandlerクラスです。
 *
 * @reamsid_L AF-0320-014 xul
 */
public class ZaigaiKofuRirekiDialogHandler {

    private final ZaigaiKofuRirekiDialogDiv div;

    private ZaigaiKofuRirekiDialogHandler(ZaigaiKofuRirekiDialogDiv div) {
        this.div = div;
    }

    /**
     * 在外交付履歴ダイアログのHandler
     *
     * @param div ZaigaiKofuRirekiDialogDiv
     * @return ZaigaiKofuRirekiDialogHandler
     */
    public static ZaigaiKofuRirekiDialogHandler of(ZaigaiKofuRirekiDialogDiv div) {
        return new ZaigaiKofuRirekiDialogHandler(div);
    }

    /**
     * 交付履歴情報を取得
     *
     * @param 識別コード ShikibetsuCode
     * @return 交付履歴情報 ZaigaikofurirekiResult
     */
    public List<ZaigaikofurirekiResult> get_交付履歴情報(ShikibetsuCode 識別コード) {
        ZaigaiKofuRirekiFinder finder = InstanceProvider.create(ZaigaiKofuRirekiFinder.class);
        List<ZaigaikofurirekiResult> 交付履歴情報list = finder.get交付履歴情報(識別コード);
        div.getDgKofuRireki();
        return 交付履歴情報list;
    }

}
