/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.senkyokuselectdialog;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区選択ダイアログに対するコントローラですModel。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SenkyokuSelectDialogModel implements Serializable {

    private RString 選挙種類;
    private RString 選挙区コード;
}
