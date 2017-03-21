/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.senkyokutanmatsuinputdialog;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区端末管理入力ダイアログModel
 *
 * @reamsid_L AF-0720-010 liuyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SenkyokuTanmatsuInputDialogModel implements Serializable {

    private RString 選挙種類;
    private RString 選挙区コード;

}
