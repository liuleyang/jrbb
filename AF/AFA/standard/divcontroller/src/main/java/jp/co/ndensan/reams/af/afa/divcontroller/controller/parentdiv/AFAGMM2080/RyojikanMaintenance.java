/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2080;

import jp.co.ndensan.reams.af.afa.business.ryojikan.Ryojikan;
import jp.co.ndensan.reams.af.afa.definition.core.Initial;
import jp.co.ndensan.reams.af.afa.definition.core.ryojikan.enumeratedtype.RyojikanRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080.RyojikanMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2080.RyojikanMaintenanceHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMM2080 領事官保守
 *
 * @reamsid_L AF-0770-010 lis2
 */
public class RyojikanMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData<RyojikanMaintenanceDiv>
     */
    public ResponseData<RyojikanMaintenanceDiv> onLoad(RyojikanMaintenanceDiv div) {
        RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
        return ResponseData.of(div).respond();
    }

    /**
     * 領事官選択グリッドの修正ボタン
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData<RyojikanMaintenanceDiv>
     */
    public ResponseData<RyojikanMaintenanceDiv> onClick_btnModify(RyojikanMaintenanceDiv div) {
        RyojikanMaintenanceHandler.of(div).set修正ボタンクリック状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 領事官選択グリッドの削除ボタン
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData<RyojikanMaintenanceDiv>
     */
    public ResponseData<RyojikanMaintenanceDiv> onClick_btnDelete(RyojikanMaintenanceDiv div) {
        RyojikanMaintenanceHandler.of(div).set削除ボタンクリック状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「コードを追加する」ボタン押下時のイベントメソッドです。
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData<RyojikanMaintenanceDiv>
     */
    public ResponseData<RyojikanMaintenanceDiv> onClick_btnAdd(RyojikanMaintenanceDiv div) {
        RyojikanMaintenanceHandler.of(div).setコードを追加する状態();

        return ResponseData.of(div).respond();
    }

    /**
     * 「コードのXXをやめる」ボタン押下時のイベントメソッドです。
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData<RyojikanMaintenanceDiv>
     */
    public ResponseData<RyojikanMaintenanceDiv> onClick_btnStop(RyojikanMaintenanceDiv div) {
        if (RyojikanRStringEnum.追加.getKey().equals(div.getHiddenFlag())) {
            RString 画面_領事官コード = div.getRyojikanInput().getTxtCode().getValue();
            RString 画面_領事官名 = div.getRyojikanInput().getTxtName().getValue();
            RString 画面_カナ領事官名 = div.getRyojikanInput().getTxtKanaName().getValue();
            RString 画面_表示順 = new RString(String.valueOf(div.getRyojikanInput().getTxtHyojiJun().getControlValue()));
            if (画面_領事官コード.isEmpty() && 画面_領事官名.isEmpty() && 画面_カナ領事官名.isEmpty() && 画面_表示順.isEmpty()) {
                RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
            } else {
                return RyojikanMaintenanceHandler.of(div).check入力内容の破棄(div);
            }
        }
        if (RyojikanRStringEnum.修正.getKey().equals(div.getHiddenFlag())) {
            Ryojikan 領事官 = Base64Serializer.deSerialize(div.getDgRyojikanList().getClickedItem().getHidMotoData().toString(), Ryojikan.class);
            RString 領事官コード = changeNullToEmpty(領事官.getEntity().getRyojikanCode());
            RString 領事官名 = changeNullToEmpty(領事官.getEntity().getRyojikanName());
            RString カナ領事官名 = changeNullToEmpty(領事官.getEntity().getKanaRyojikanName());
            int 表示順 = 領事官.getEntity().getHyojijun();
            RString 画面_領事官コード = div.getRyojikanInput().getTxtCode().getValue();
            RString 画面_領事官名 = div.getRyojikanInput().getTxtName().getValue();
            RString 画面_カナ領事官名 = div.getRyojikanInput().getTxtKanaName().getValue();
            int 画面_表示順 = null == div.getRyojikanInput().getTxtHyojiJun().getValue()
                    ? Initial.表示順初期値.getKey() : div.getRyojikanInput().getTxtHyojiJun().getValue().intValue();
            if (領事官コード.equals(画面_領事官コード) && 領事官名.equals(画面_領事官名) && カナ領事官名.equals(画面_カナ領事官名) && 表示順 == 画面_表示順) {
                RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
            } else {
                return RyojikanMaintenanceHandler.of(div).check入力内容の破棄(div);
            }
        }
        if (RyojikanRStringEnum.削除.getKey().equals(div.getHiddenFlag())) {
            RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「コードをXXする」ボタン押下時のイベントメソッドです。
     *
     * @param div RyojikanMaintenanceDiv
     * @return ResponseData<RyojikanMaintenanceDiv>
     */
    public ResponseData<RyojikanMaintenanceDiv> onClick_btnAddNew(RyojikanMaintenanceDiv div) {
        if ((RyojikanRStringEnum.追加.getKey()).equals(div.getHiddenFlag())) {
            return btnAddTohyojo(div);
        }
        if ((RyojikanRStringEnum.修正.getKey()).equals(div.getHiddenFlag())) {
            return btnUpdateTohyojo(div);
        }
        if ((RyojikanRStringEnum.削除.getKey()).equals(div.getHiddenFlag())) {
            return btnDeleteTohyojo(div);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<RyojikanMaintenanceDiv> btnAddTohyojo(RyojikanMaintenanceDiv div) {
        Ryojikan 領事官 = new Ryojikan();
        RString 検索用カナ領事官名称 = RStringUtil.convertTo清音化(div.getRyojikanInput().getTxtKanaName().getValue());
        領事官.getEntity().setRyojikanName(div.getRyojikanInput().getTxtName().getValue());
        領事官.getEntity().setRyojikanCode(div.getRyojikanInput().getTxtCode().getValue());
        領事官.getEntity().setHyojijun(null == div.getTxtHyojiJun().getValue()
                ? Initial.表示順初期値.getKey() : div.getTxtHyojiJun().getValue().intValue());
        領事官.getEntity().setKanaRyojikanName(div.getRyojikanInput().getTxtKanaName().getValue());
        領事官.getEntity().setSearchKanaRyojikanName(検索用カナ領事官名称);
        boolean 領事官フラグ = RyojikanMaintenanceHandler.of(div).set領事官コード重複チェック(div.getRyojikanInput().getTxtCode().getValue());
        if (領事官フラグ) {
            return RyojikanMaintenanceHandler.of(div).checkコード重複チェック();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType()
                == MessageDialogSelectedResult.Yes) {
            int number = RyojikanMaintenanceHandler.of(div).setコードを追加する(領事官);
            if (number > 0) {
                RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<RyojikanMaintenanceDiv> btnUpdateTohyojo(RyojikanMaintenanceDiv div) {
        RString 検索用カナ領事官名称 = RStringUtil.convertTo清音化(div.getRyojikanInput().getTxtKanaName().getValue());
        Ryojikan 領事官 = Base64Serializer.deSerialize(div.getDgRyojikanList().getClickedItem().getHidMotoData().toString(), Ryojikan.class);
        領事官.getEntity().setSearchKanaRyojikanName(検索用カナ領事官名称);
        領事官.getEntity().setRyojikanCode(div.getRyojikanInput().getTxtCode().getValue());
        領事官.getEntity().setHyojijun(null == div.getTxtHyojiJun().getValue()
                ? Initial.表示順初期値.getKey() : div.getTxtHyojiJun().getValue().intValue());
        領事官.getEntity().setKanaRyojikanName(div.getRyojikanInput().getTxtKanaName().getValue());
        領事官.getEntity().setRyojikanName(div.getRyojikanInput().getTxtName().getValue());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = RyojikanMaintenanceHandler.of(div).setコードを保存する(領事官);
            if (number > 0) {
                RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<RyojikanMaintenanceDiv> btnDeleteTohyojo(RyojikanMaintenanceDiv div) {
        Ryojikan 領事官 = Base64Serializer.deSerialize(div.getDgRyojikanList().getClickedItem().getHidMotoData().toString(), Ryojikan.class);
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean 削除フラグ = RyojikanMaintenanceHandler.of(div).setコードを削除する(領事官);
            if (削除フラグ) {
                RyojikanMaintenanceHandler.of(div).set領事官保守初期化();
            }
        }
        return ResponseData.of(div).respond();
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
