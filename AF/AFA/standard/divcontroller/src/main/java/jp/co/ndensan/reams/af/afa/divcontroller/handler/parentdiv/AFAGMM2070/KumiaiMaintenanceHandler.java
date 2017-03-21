/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.kumiai.Kumiai;
import jp.co.ndensan.reams.af.afa.definition.core.kumiai.enumeratedtype.KumiaiRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070.KumiaiMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070.dgKumiaiList_Row;
import jp.co.ndensan.reams.af.afa.service.kumiai.KumiaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public class KumiaiMaintenanceHandler {

    private final KumiaiMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KumiaiMaintenanceDiv
     */
    public KumiaiMaintenanceHandler(KumiaiMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * 組合保守のHandler初期化
     *
     * @param div KumiaiMaintenanceDiv
     * @return KumiaiMaintenanceHandler
     */
    public static KumiaiMaintenanceHandler of(KumiaiMaintenanceDiv div) {
        return new KumiaiMaintenanceHandler(div);
    }

    /**
     * 組合保守画面のonLoadイベント
     *
     */
    public void set組合保守初期化() {
        set初期化状態();
        KumiaiFinder finder = KumiaiFinder.createInstance();
        List<Kumiai> 組合リスト = finder.get組合();
        List<dgKumiaiList_Row> rowList = new ArrayList();
        if (null != 組合リスト) {
            for (Kumiai 組合 : 組合リスト) {
                dgKumiaiList_Row row = new dgKumiaiList_Row();
                row.setTxtCode(組合.getEntity().getKumiaiCode());
                row.setTxtName(組合.getEntity().getKumiaiName());
                row.setTxtKanaName(組合.getEntity().getKanaKumiaiName());
                AtenaJusho jusho = 組合.getEntity().getJusho();
                RString 住所 = null == jusho ? RString.EMPTY : jusho.getColumnValue();
                row.setTxtJusho(住所);
                row.setHidMotoData(new RString(Base64Serializer.serialize(組合)));
                rowList.add(row);
            }
        }
        div.getDgKumiaiList().setDataSource(rowList);
    }

    /**
     * 組合コードの重複チェック処理
     *
     * @param 組合コード RString
     * @return boolean
     */
    public boolean set組合コード重複チェック(RString 組合コード) {
        KumiaiFinder finder = KumiaiFinder.createInstance();
        Kumiai 組合 = finder.get組合By組合コード(組合コード);
        return null != 組合;
    }

    /**
     * 「コードを追加する」ボタンクリックの内容を保存する
     *
     * @param 組合 Kumiai
     * @return int
     */
    public int setコードを追加する(Kumiai 組合) {
        KumiaiFinder finder = KumiaiFinder.createInstance();
        return finder.insert組合(組合);
    }

    /**
     * 「コードを保存する」ボタンクリックの内容を保存する
     *
     * @param 組合 Kumiai
     * @return int
     */
    public int setコードを保存する(Kumiai 組合) {
        KumiaiFinder finder = KumiaiFinder.createInstance();
        return finder.update組合(組合);
    }

    /**
     * 「コードを削除する」ボタンクリック
     *
     * @param 組合 Kumiai
     * @return boolean
     */
    public boolean setコードを削除する(Kumiai 組合) {
        KumiaiFinder finder = KumiaiFinder.createInstance();
        return finder.delete組合(組合);
    }

    /**
     * コード重複チェック
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new KumiaiMaintenanceValidationHandler(div).
                validateコード重複チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 初期化状態
     */
    public void set初期化状態() {
        div.getKumiaiSelect().setDisplayNone(Boolean.FALSE);
        div.getKumiaiSelect().setDisabled(Boolean.FALSE);
        div.getDgKumiaiList().getDataSource().clear();
        div.getDgKumiaiList().setDisplayNone(Boolean.FALSE);
        div.getKumiaiInput().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 組合選択パネル内の「コードを追加する」ボタンクリック時画面状態
     */
    public void setコードを追加する状態() {
        div.getKumiaiSelect().setDisabled(Boolean.TRUE);
        div.getKumiaiInput().setDisplayNone(Boolean.FALSE);
        div.getKumiaiInput().getTxtCode().setDisabled(Boolean.FALSE);
        div.getKumiaiInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getKumiaiInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getKumiaiInput().getTxtJusho().setDisabled(Boolean.FALSE);
        div.getKumiaiInput().getTxtCode().clearValue();
        if (div.getKumiaiInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getKumiaiInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getKumiaiInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getKumiaiInput().getTxtName().clearValue();
        div.getKumiaiInput().getTxtKanaName().clearValue();
        if (div.getKumiaiInput().getTxtName().isDisabled() == Boolean.FALSE) {
            div.getKumiaiInput().getTxtName().setRequired(Boolean.TRUE);
        } else {
            div.getKumiaiInput().getTxtName().setRequired(Boolean.FALSE);
        }
        div.getKumiaiInput().getTxtJusho().clearDomain();
        div.setHiddenFlag(KumiaiRStringEnum.追加.getKey());
        div.getBtnStop().setText(KumiaiRStringEnum.コードの追加をやめる.getKey());
        div.getBtnAddNew().setText(KumiaiRStringEnum.コードを追加する.getKey());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getBtnStop().setDisabled(Boolean.FALSE);
        if (div.getKumiaiInput().getTxtKanaName().isDisabled() == Boolean.FALSE) {
            div.getKumiaiInput().getTxtKanaName().setRequired(Boolean.TRUE);
        } else {
            div.getKumiaiInput().getTxtKanaName().setRequired(Boolean.FALSE);
        }
    }

    /**
     * 組合選択パネル内のグリッド内の修正ボタンクリック時画面状態
     */
    public void set修正ボタンクリック状態() {
        div.getKumiaiSelect().setDisabled(Boolean.TRUE);
        div.getKumiaiInput().setDisplayNone(Boolean.FALSE);
        div.getKumiaiInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getKumiaiInput().getTxtCode().setValue(div.getDgKumiaiList().getActiveRow().getTxtCode());
        div.getKumiaiInput().getTxtName().setDisabled(Boolean.FALSE);
        if (div.getKumiaiInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getKumiaiInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getKumiaiInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getKumiaiInput().getTxtName().setValue(div.getDgKumiaiList().getActiveRow().getTxtName());
        div.getKumiaiInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getKumiaiInput().getTxtKanaName().setValue(div.getDgKumiaiList().getActiveRow().getTxtKanaName());
        div.getKumiaiInput().getTxtJusho().setDisabled(Boolean.FALSE);
        div.getKumiaiInput().getTxtJusho().setDomain(new AtenaJusho(div.getDgKumiaiList().getActiveRow().getTxtJusho()));
        div.setHiddenFlag(KumiaiRStringEnum.修正.getKey());
        if (div.getKumiaiInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getKumiaiInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getKumiaiInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getBtnStop().setDisabled(Boolean.FALSE);
        div.getBtnStop().setText(KumiaiRStringEnum.コードの修正をやめる.getKey());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        if (div.getKumiaiInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getKumiaiInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getKumiaiInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getBtnAddNew().setText(KumiaiRStringEnum.コードを保存する.getKey());
    }

    /**
     * 組合選択パネル内のグリッド内の削除ボタンクリック時画面状態
     */
    public void set削除ボタンクリック状態() {
        div.getKumiaiSelect().setDisabled(Boolean.TRUE);
        div.getKumiaiInput().setDisplayNone(Boolean.FALSE);
        div.getKumiaiInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getKumiaiInput().getTxtName().setDisabled(Boolean.TRUE);
        if (div.getKumiaiInput().getTxtName().isDisabled() == Boolean.FALSE) {
            div.getKumiaiInput().getTxtName().setRequired(Boolean.TRUE);
        } else {
            div.getKumiaiInput().getTxtName().setRequired(Boolean.FALSE);
        }
        div.getKumiaiInput().getTxtCode().setValue(div.getDgKumiaiList().getActiveRow().getTxtCode());
        div.getKumiaiInput().getTxtName().setValue(div.getDgKumiaiList().getActiveRow().getTxtName());
        div.getKumiaiInput().getTxtKanaName().setDisabled(Boolean.TRUE);
        if (div.getKumiaiInput().getTxtKanaName().isDisabled() == Boolean.FALSE) {
            div.getKumiaiInput().getTxtKanaName().setRequired(Boolean.TRUE);
        } else {
            div.getKumiaiInput().getTxtKanaName().setRequired(Boolean.FALSE);
        }
        div.getKumiaiInput().getTxtKanaName().setValue(div.getDgKumiaiList().getActiveRow().getTxtKanaName());
        div.getKumiaiInput().getTxtJusho().setDisabled(Boolean.TRUE);
        AtenaJusho jusho = new AtenaJusho(div.getDgKumiaiList().getActiveRow().getTxtJusho());
        div.getKumiaiInput().getTxtJusho().setDomain(jusho);
        div.setHiddenFlag(KumiaiRStringEnum.削除.getKey());
        div.getBtnStop().setText(KumiaiRStringEnum.コードの削除をやめる.getKey());
        if (div.getKumiaiInput().getTxtCode().isDisabled() == Boolean.FALSE) {
            div.getKumiaiInput().getTxtCode().setRequired(Boolean.TRUE);
        } else {
            div.getKumiaiInput().getTxtCode().setRequired(Boolean.FALSE);
        }
        div.getBtnAddNew().setText(KumiaiRStringEnum.コードを削除する.getKey());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getBtnStop().setDisabled(Boolean.FALSE);
    }

    /**
     * 入力内容の破棄。
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData
     */
    public ResponseData check入力内容の破棄(KumiaiMaintenanceDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            KumiaiMaintenanceHandler.of(div).set組合保守初期化();
        }
        return ResponseData.of(div).respond();
    }
}
