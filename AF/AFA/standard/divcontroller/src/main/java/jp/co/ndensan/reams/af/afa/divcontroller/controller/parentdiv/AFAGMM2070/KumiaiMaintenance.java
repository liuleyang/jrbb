/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2070;

import jp.co.ndensan.reams.af.afa.business.kumiai.Kumiai;
import jp.co.ndensan.reams.af.afa.definition.core.kumiai.enumeratedtype.KumiaiRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070.KumiaiMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2070.KumiaiMaintenanceHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public class KumiaiMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData<KumiaiMaintenanceDiv>
     */
    public ResponseData<KumiaiMaintenanceDiv> onLoad(KumiaiMaintenanceDiv div) {
        KumiaiMaintenanceHandler.of(div).set組合保守初期化();
        return ResponseData.of(div).respond();
    }

    /**
     * 組合選択グリッドの修正ボタン
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData<KumiaiMaintenanceDiv>
     */
    public ResponseData<KumiaiMaintenanceDiv> onClick_btnModify(KumiaiMaintenanceDiv div) {
        KumiaiMaintenanceHandler.of(div).set修正ボタンクリック状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 組合選択グリッドの削除ボタン
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData<KumiaiMaintenanceDiv>
     */
    public ResponseData<KumiaiMaintenanceDiv> onClick_btnDelete(KumiaiMaintenanceDiv div) {
        KumiaiMaintenanceHandler.of(div).set削除ボタンクリック状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「コードを追加する」ボタン押下時のイベントメソッドです。
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData<KumiaiMaintenanceDiv>
     */
    public ResponseData<KumiaiMaintenanceDiv> onClick_btnAdd(KumiaiMaintenanceDiv div) {
        KumiaiMaintenanceHandler.of(div).setコードを追加する状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「コードのXXをやめる」ボタン押下時のイベントメソッドです。
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData<KumiaiMaintenanceDiv>
     */
    public ResponseData<KumiaiMaintenanceDiv> onClick_btnStop(KumiaiMaintenanceDiv div) {
        if (KumiaiRStringEnum.追加.getKey().equals(div.getHiddenFlag())) {
            RString 画面_組合コード = div.getKumiaiInput().getTxtCode().getValue();
            RString 画面_組合名 = div.getKumiaiInput().getTxtName().getValue();
            RString 画面_カナ組合名 = div.getKumiaiInput().getTxtKanaName().getValue();
            RString 画面_住所 = div.getKumiaiInput().getTxtJusho().getDomain().value();
            if (画面_組合コード.isEmpty() && 画面_組合名.isEmpty() && 画面_カナ組合名.isEmpty() && 画面_住所.isEmpty()) {
                KumiaiMaintenanceHandler.of(div).set組合保守初期化();
            } else {
                return KumiaiMaintenanceHandler.of(div).check入力内容の破棄(div);
            }
        }
        if (KumiaiRStringEnum.修正.getKey().equals(div.getHiddenFlag())) {
            Kumiai 組合 = Base64Serializer.deSerialize(div.getDgKumiaiList().getClickedItem().getHidMotoData().toString(), Kumiai.class);
            RString 組合名 = changeNullToEmpty(組合.getEntity().getKumiaiName());
            RString 組合コード = changeNullToEmpty(組合.getEntity().getKumiaiCode());
            RString カナ組合名 = changeNullToEmpty(組合.getEntity().getKanaKumiaiName());

            AtenaJusho 組合住所 = 組合.getEntity().getJusho();
            RString 住所 = null == 組合住所 ? RString.EMPTY : 組合住所.getColumnValue();
            RString 画面_組合コード = div.getKumiaiInput().getTxtCode().getValue();
            RString 画面_組合名 = div.getKumiaiInput().getTxtName().getValue();
            RString 画面_カナ組合名 = div.getKumiaiInput().getTxtKanaName().getValue();
            RString 画面_住所 = div.getKumiaiInput().getTxtJusho().getDomain().value();
            if (組合コード.equals(画面_組合コード) && 組合名.equals(画面_組合名)
                    && カナ組合名.equals(画面_カナ組合名) && 住所.equals(画面_住所)) {
                KumiaiMaintenanceHandler.of(div).set組合保守初期化();
            } else {
                return KumiaiMaintenanceHandler.of(div).check入力内容の破棄(div);
            }
        }
        if (KumiaiRStringEnum.削除.getKey().equals(div.getHiddenFlag())) {
            KumiaiMaintenanceHandler.of(div).set組合保守初期化();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「コードをXXする」ボタン押下時のイベントメソッドです。
     *
     * @param div KumiaiMaintenanceDiv
     * @return ResponseData<KumiaiMaintenanceDiv>
     */
    public ResponseData<KumiaiMaintenanceDiv> onClick_btnAddNew(KumiaiMaintenanceDiv div) {
        if ((KumiaiRStringEnum.追加.getKey()).equals(div.getHiddenFlag())) {
            return btnAddTohyojo(div);
        }
        if ((KumiaiRStringEnum.修正.getKey()).equals(div.getHiddenFlag())) {
            return btnUpdateTohyojo(div);
        }
        if ((KumiaiRStringEnum.削除.getKey()).equals(div.getHiddenFlag())) {
            return btnDeleteTohyojo(div);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KumiaiMaintenanceDiv> btnAddTohyojo(KumiaiMaintenanceDiv div) {
        boolean 組合フラグ = KumiaiMaintenanceHandler.of(div).set組合コード重複チェック(div.getKumiaiInput().getTxtCode().getValue());
        if (組合フラグ) {
            return KumiaiMaintenanceHandler.of(div).checkコード重複チェック();
        }
        Kumiai 組合 = new Kumiai();
        組合.getEntity().setKanaKumiaiName(div.getKumiaiInput().getTxtKanaName().getValue());
        組合.getEntity().setKumiaiName(div.getKumiaiInput().getTxtName().getValue());
        組合.getEntity().setJusho(div.getKumiaiInput().getTxtJusho().getDomain());
        組合.getEntity().setKumiaiCode(div.getKumiaiInput().getTxtCode().getValue());
        RString 検索用カナ組合名称 = RStringUtil.convertTo清音化(div.getKumiaiInput().getTxtKanaName().getValue());
        組合.getEntity().setSearchKumiaiName(検索用カナ組合名称);
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType()
                == MessageDialogSelectedResult.Yes) {
            int number = KumiaiMaintenanceHandler.of(div).setコードを追加する(組合);
            if (number > 0) {
                KumiaiMaintenanceHandler.of(div).set組合保守初期化();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KumiaiMaintenanceDiv> btnUpdateTohyojo(KumiaiMaintenanceDiv div) {
        Kumiai 組合 = Base64Serializer.deSerialize(div.getDgKumiaiList().getClickedItem().getHidMotoData().toString(), Kumiai.class);
        組合.getEntity().setKumiaiCode(div.getKumiaiInput().getTxtCode().getValue());
        組合.getEntity().setKumiaiName(div.getKumiaiInput().getTxtName().getValue());
        組合.getEntity().setKanaKumiaiName(div.getKumiaiInput().getTxtKanaName().getValue());
        RString 検索用カナ組合名称 = RStringUtil.convertTo清音化(div.getKumiaiInput().getTxtKanaName().getValue());
        組合.getEntity().setSearchKumiaiName(検索用カナ組合名称);
        組合.getEntity().setJusho(div.getKumiaiInput().getTxtJusho().getDomain());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = KumiaiMaintenanceHandler.of(div).setコードを保存する(組合);
            if (number > 0) {
                KumiaiMaintenanceHandler.of(div).set組合保守初期化();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KumiaiMaintenanceDiv> btnDeleteTohyojo(KumiaiMaintenanceDiv div) {
        Kumiai 組合 = Base64Serializer.deSerialize(div.getDgKumiaiList().getClickedItem().getHidMotoData().toString(), Kumiai.class);
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean 削除フラグ = KumiaiMaintenanceHandler.of(div).setコードを削除する(組合);
            if (削除フラグ) {
                KumiaiMaintenanceHandler.of(div).set組合保守初期化();
            }
        }
        return ResponseData.of(div).respond();
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
