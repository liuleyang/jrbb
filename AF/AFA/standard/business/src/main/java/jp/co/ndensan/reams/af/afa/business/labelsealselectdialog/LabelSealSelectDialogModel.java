/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.labelsealselectdialog;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;

/**
 * ラベルシール印刷確認ダイアログ用モデルです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class LabelSealSelectDialogModel implements Serializable {

    private KijitsumaeFuzaishaKubun kijitsumaeFuzaishaKubun;

    private ShohonNo shohonNo;

    private List<KijitsumaeTohyoChohyoData> shoriTaishoJohoList;

    private boolean chkShomeishoHakko = false;
}
