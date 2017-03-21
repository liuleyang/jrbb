/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiCodeSelect;

import jp.co.ndensan.reams.af.afa.business.core.kumiai.KumiaiResult;
import jp.co.ndensan.reams.af.afa.definition.core.AfaSeniKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuJoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.service.core.kumiai.kumiai.KumiaiManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 組合コード選択共用共有子Divのコントロールクラスです。
 *
 * @reamsid_L AF-0500-030 gyq
 */
public class KumiaiCodeSelectHandler {

    private final KumiaiCodeSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 組合コード選択Div
     */
    public KumiaiCodeSelectHandler(KumiaiCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 組合コード選択共用共有子Div
     * @return HenreiChohyoShokaiHandler
     */
    public static KumiaiCodeSelectHandler of(KumiaiCodeSelectDiv div) {
        return new KumiaiCodeSelectHandler(div);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 渡された組合コード RString
     */
    public void initialize(RString 渡された組合コード) {

        AfaSeniKey 海区漁業削除 = ViewStateHolder.get(KaikuJoho.海区漁業削除の場合, AfaSeniKey.class);
        set状態(海区漁業削除);
        KumiaiManager kumiaiManager = KumiaiManager.createInstance();
        KumiaiResult kumiaiResult;
        if (!渡された組合コード.isEmpty()) {
            div.getTxtKumiaiCode().setValue(渡された組合コード);
            kumiaiResult = kumiaiManager.selectBy組合コード(渡された組合コード);
            if (kumiaiResult != null) {
                div.getTxtKumiaiName().setValue(kumiaiResult.get組合名称());
            }

        }
    }

    private void set状態(AfaSeniKey 海区漁業削除) {
        if (海区漁業削除 != null) {
            div.getTxtKumiaiCode().setVisible(true);
            div.getBtnKumiaiCode().setVisible(true);
            div.getTxtKumiaiName().setVisible(true);
        }
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
        if (senkyoShurui == SenkyoShurui.農業委員会委員選挙) {
            //TODO ほんとは管理情報から取得する
            div.getTxtKumiaiCode().setMaxLength(2);
        } else if (senkyoShurui == SenkyoShurui.海区漁業調整委員会委員選挙) {
            //TODO ほんとは管理情報から取得する
            div.getTxtKumiaiCode().setMaxLength(3);
        } else {
            div.getTxtKumiaiCode().setMaxLength(4);
        }

    }

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     */
    public void clear() {
        div.getTxtKumiaiCode().clearValue();
        div.getTxtKumiaiName().clearValue();
        div.setTxtHdnSenkyoShurui(RString.EMPTY);
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.setReadOnly(readOnlySetMode);
        div.getBtnKumiaiCode().setDisplayNone(readOnlySetMode);
    }

}
