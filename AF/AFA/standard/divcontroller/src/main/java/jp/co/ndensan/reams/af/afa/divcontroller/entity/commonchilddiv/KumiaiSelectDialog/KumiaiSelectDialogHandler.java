/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiSelectDialog;

import jp.co.ndensan.reams.af.afa.business.core.kumiai.KumiaiResult;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 組合選択ダイアログ共有子Divのコントロールクラスです。
 *
 * @reamsid_L AF-0500-030 gyq
 */
public class KumiaiSelectDialogHandler {

    /**
     * コンストラクタです。
     *
     */
    public KumiaiSelectDialogHandler() {
    }

    /**
     * コンストラクタ
     *
     * @return HenreiChohyoShokaiHandler
     */
    public static KumiaiSelectDialogHandler of() {
        return new KumiaiSelectDialogHandler();
    }

    /**
     * 組合マスタのセットします。
     *
     * @param kumiaiResult KumiaiResult
     * @return dgKumiaiSelect_Row
     */
    public dgKumiaiSelect_Row modelToRow(KumiaiResult kumiaiResult) {
        dgKumiaiSelect_Row row = new dgKumiaiSelect_Row();
        row.setTxtKumiaiCode(kumiaiResult.get組合コード());
        row.setTxtKumiaiName(kumiaiResult.get組合名称());
        row.setTxtKanaKumiaiName(kumiaiResult.getカナ組合名称());
        row.setTxtJusho(new RString(kumiaiResult.get組合の住所等().toString()));
        return row;
    }

}
