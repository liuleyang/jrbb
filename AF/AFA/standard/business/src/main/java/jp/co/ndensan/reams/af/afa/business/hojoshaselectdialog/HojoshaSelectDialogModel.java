/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.hojoshaselectdialog;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者ダイアログ用モデルです。
 *
 * @reamsid_L AF-0080-030 wangm
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HojoshaSelectDialogModel implements Serializable {

    private ShohonNo shohonNo;
    private RString tohyokuCode;

    private RString shikibetsuCode;
    private RString meisho;

}
