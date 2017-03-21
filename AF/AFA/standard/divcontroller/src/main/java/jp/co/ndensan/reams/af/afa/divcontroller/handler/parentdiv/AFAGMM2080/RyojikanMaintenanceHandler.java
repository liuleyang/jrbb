/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2080;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.ryojikan.Ryojikan;
import jp.co.ndensan.reams.af.afa.definition.core.ryojikan.enumeratedtype.RyojikanRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080.RyojikanMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080.dgRyojikanList_Row;
import jp.co.ndensan.reams.af.afa.service.ryojikan.RyojikanFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMM2080 領事官保守Handler
 *
 * @reamsid_L AF-0770-010 lis2
 */
public class RyojikanMaintenanceHandler {

    private final RyojikanMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RyojikanMaintenanceDiv
     */
    public RyojikanMaintenanceHandler(RyojikanMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * 領事官保守のHandler初期化
     *
     * @param div RyojikanMaintenanceDiv
     * @return RyojikanMaintenanceHandler
     */
    public static RyojikanMaintenanceHandler of(RyojikanMaintenanceDiv div) {
        return new RyojikanMaintenanceHandler(div);
    }

    /**
     * 領事官保守画面のonLoadイベント
     *
     */
    public void set領事官保守初期化() {
        set初期化状態();
        RyojikanFinder finder = RyojikanFinder.createInstance();
        List<Ryojikan> 領事官リスト = finder.get領事官();
        List<dgRyojikanList_Row> rowList = new ArrayList();
        if (null != 領事官リスト) {
            for (Ryojikan 領事官 : 領事官リスト) {
                dgRyojikanList_Row row = new dgRyojikanList_Row();
                row.setTxtCode(領事官.getEntity().getRyojikanCode());
                row.setTxtName(領事官.getEntity().getRyojikanName());
                row.setTxtKanaName(領事官.getEntity().getKanaRyojikanName());
                RString 表示順 = new RString(領事官.getEntity().getHyojijun());
                row.setTxtHyojiJun(表示順);
                row.setHidMotoData(new RString(Base64Serializer.serialize(領事官)));
                rowList.add(row);
            }
        }
        div.getDgRyojikanList().setDataSource(rowList);
    }

    /**
     * 領事官コードの重複チェック処理
     *
     * @param 領事官コード RString
     * @return boolean
     */
    public boolean set領事官コード重複チェック(RString 領事官コード) {
        RyojikanFinder finder = RyojikanFinder.createInstance();
        Ryojikan 領事官 = finder.get領事官By領事官コード(領事官コード);
        return null != 領事官;
    }

    /**
     * 「コードを追加する」ボタンクリックの内容を保存する
     *
     * @param 領事官 Ryojikan
     * @return int
     */
    public int setコードを追加する(Ryojikan 領事官) {
        RyojikanFinder finder = RyojikanFinder.createInstance();
        return finder.insert領事官(領事官);
    }

    /**
     * 「コードを保存する」ボタンクリックの内容を保存する
     *
     * @param 領事官 Ryojikan
     * @return int
     */
    public int setコードを保存する(Ryojikan 領事官) {
        RyojikanFinder finder = RyojikanFinder.createInstance();
        return finder.update領事官(領事官);
    }

    /**
     * 「コードを削除する」ボタンクリック
     *
     * @param 領事官 Ryojikan
     * @return boolean
     */
    public boolean setコードを削除する(Ryojikan 領事官) {
        RyojikanFinder finder = RyojikanFinder.createInstance();
        return finder.delete領事官(領事官);
    }

    /**
     * コード重複チェック
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new RyojikanMaintenanceValidationHandler(div).
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
        div.getRyojikanSelect().setDisplayNone(Boolean.FALSE);
        div.getRyojikanSelect().setDisabled(Boolean.FALSE);
        div.getDgRyojikanList().getDataSource().clear();
        div.getDgRyojikanList().setDisplayNone(Boolean.FALSE);
        div.getRyojikanInput().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 領事官選択パネル内の「コードを追加する」ボタンクリック時画面状態
     */
    public void setコードを追加する状態() {
        div.getRyojikanSelect().setDisabled(Boolean.TRUE);
        div.getRyojikanInput().setDisplayNone(Boolean.FALSE);
        div.getRyojikanInput().getTxtCode().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtName().setDisabled(Boolean.FALSE);
        if (div.getRyojikanInput().getTxtKanaName().isDisabled() == Boolean.FALSE) {
            div.getRyojikanInput().getTxtKanaName().setRequired(Boolean.TRUE);
        } else {
            div.getRyojikanInput().getTxtKanaName().setRequired(Boolean.FALSE);
        }
        div.getRyojikanInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtHyojiJun().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtCode().clearValue();
        div.getRyojikanInput().getTxtName().clearValue();
        if (div.getRyojikanInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getRyojikanInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getRyojikanInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getRyojikanInput().getTxtKanaName().clearValue();
        div.getRyojikanInput().getTxtHyojiJun().clearValue();
        if (div.getRyojikanInput().getTxtCode().isDisabled() == Boolean.FALSE) {
            div.getRyojikanInput().getTxtCode().setRequired(Boolean.TRUE);
        } else {
            div.getRyojikanInput().getTxtCode().setRequired(Boolean.FALSE);
        }
        div.setHiddenFlag(RyojikanRStringEnum.追加.getKey());
        div.getBtnStop().setText(RyojikanRStringEnum.コードの追加をやめる.getKey());
        div.getBtnAddNew().setText(RyojikanRStringEnum.コードを追加する.getKey());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getBtnStop().setDisabled(Boolean.FALSE);
    }

    /**
     * 領事官選択パネル内のグリッド内の修正ボタンクリック時画面状態
     */
    public void set修正ボタンクリック状態() {
        div.getRyojikanSelect().setDisabled(Boolean.TRUE);
        div.getRyojikanInput().setDisplayNone(Boolean.FALSE);
        if (div.getRyojikanInput().getTxtCode().isDisabled() == Boolean.FALSE) {
            div.getRyojikanInput().getTxtCode().setRequired(Boolean.TRUE);
        } else {
            div.getRyojikanInput().getTxtCode().setRequired(Boolean.FALSE);
        }
        div.getRyojikanInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getRyojikanInput().getTxtCode().setValue(div.getDgRyojikanList().getActiveRow().getTxtCode());
        div.getRyojikanInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtName().setValue(div.getDgRyojikanList().getActiveRow().getTxtName());
        div.getRyojikanInput().getTxtKanaName().setValue(div.getDgRyojikanList().getActiveRow().getTxtKanaName());
        div.getRyojikanInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtHyojiJun().setDisabled(Boolean.FALSE);
        if (div.getRyojikanInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getRyojikanInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getRyojikanInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getRyojikanInput().getTxtHyojiJun().setValue(new Decimal(div.getDgRyojikanList().getActiveRow().getTxtHyojiJun().toString()));
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getBtnStop().setText(RyojikanRStringEnum.コードの修正をやめる.getKey());
        div.getBtnStop().setDisabled(Boolean.FALSE);
        div.setHiddenFlag(RyojikanRStringEnum.修正.getKey());
        div.getBtnAddNew().setText(RyojikanRStringEnum.コードを保存する.getKey());
        if (div.getRyojikanInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getRyojikanInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getRyojikanInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
    }

    /**
     * 領事官選択パネル内のグリッド内の削除ボタンクリック時画面状態
     */
    public void set削除ボタンクリック状態() {
        Decimal hyoJiJun = new Decimal(div.getDgRyojikanList().getActiveRow().getTxtHyojiJun().toString());
        div.getRyojikanSelect().setDisabled(Boolean.TRUE);
        if (div.getRyojikanInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getRyojikanInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getRyojikanInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getRyojikanInput().getTxtName().setValue(div.getDgRyojikanList().getActiveRow().getTxtName());
        div.getRyojikanInput().setDisplayNone(Boolean.FALSE);
        div.getRyojikanInput().getTxtCode().setValue(div.getDgRyojikanList().getActiveRow().getTxtCode());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtHyojiJun().setValue(hyoJiJun);
        div.getRyojikanInput().getTxtKanaName().setValue(div.getDgRyojikanList().getActiveRow().getTxtKanaName());
        div.setHiddenFlag(RyojikanRStringEnum.削除.getKey());
        div.getBtnStop().setText(RyojikanRStringEnum.コードの削除をやめる.getKey());
        div.getBtnStop().setDisabled(Boolean.FALSE);
        div.getRyojikanInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getRyojikanInput().getTxtKanaName().setDisabled(Boolean.TRUE);
        div.getRyojikanInput().getTxtHyojiJun().setDisabled(Boolean.TRUE);
        if (div.getRyojikanInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getRyojikanInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getRyojikanInput().getTxtName().setRequired(Boolean.TRUE);
        }
        if (div.getRyojikanInput().getTxtKanaName().isDisabled() == Boolean.FALSE) {
            div.getRyojikanInput().getTxtKanaName().setRequired(Boolean.TRUE);
        } else {
            div.getRyojikanInput().getTxtKanaName().setRequired(Boolean.FALSE);
        }
        div.getBtnAddNew().setText(RyojikanRStringEnum.コードを削除する.getKey());
        div.getRyojikanInput().getTxtName().setDisabled(Boolean.TRUE);
    }

    /**
     * 入力内容の破棄。
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData
     */
    public ResponseData check入力内容の破棄(RyojikanMaintenanceDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
        }
        return ResponseData.of(div).respond();
    }
}
