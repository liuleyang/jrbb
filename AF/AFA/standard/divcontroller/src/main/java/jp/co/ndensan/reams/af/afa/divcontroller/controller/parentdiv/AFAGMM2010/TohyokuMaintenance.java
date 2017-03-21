/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2010;

import jp.co.ndensan.reams.af.afa.business.tohyokuselect.TohyokuSelectGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.Initial;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010.TohyokuMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2010.TohyokuMaintenanceHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 投票区保守のクラス
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public class TohyokuMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> onLoad(TohyokuMaintenanceDiv mainPanel) {
        TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
        return ResponseData.of(mainPanel).respond();

    }

    /**
     * 投票区選択パネル内の「コードを追加する」ボタン.
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> onClick_btnAdd(TohyokuMaintenanceDiv mainPanel) {
        TohyokuMaintenanceHandler.of(mainPanel).setコードを追加する();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区選択パネル内のグリッド内の修正ボタン。
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> onClick_onSelectByModifyButton(TohyokuMaintenanceDiv mainPanel) {
        TohyokuMaintenanceHandler.of(mainPanel).setグリッド内を修正する();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区選択パネル内のグリッド内の削除ボタン。
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> onClick_onSelectByDeleteButton(TohyokuMaintenanceDiv mainPanel) {
        TohyokuMaintenanceHandler.of(mainPanel).setグリッド内を削除する();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区詳細パネル内のコードの追加と修正と削除をやめるボタン。
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> onClick_btnNoOperation(TohyokuMaintenanceDiv mainPanel) {
        if (SenkyokuRStringEnum.追加.getKey().equals(mainPanel.getHiddenFlag())) {
            RString 画面_投票区コード = mainPanel.getTohyokuInput().getTxtCode().getValue();
            RString 画面_投票区名 = mainPanel.getTohyokuInput().getTxtName().getValue();
            RString 画面_カナ投票区名 = mainPanel.getTohyokuInput().getTxtKanaName().getValue();
            RString 画面_表示順 = new RString(String.valueOf(mainPanel.getTohyokuInput().getTxtHyojiJun().getControlValue()));
            if (画面_投票区コード.isEmpty() && 画面_投票区名.isEmpty() && 画面_カナ投票区名.isEmpty() && 画面_表示順.isEmpty()) {
                TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
            } else {
                return TohyokuMaintenanceHandler.of(mainPanel).check入力内容の破棄(mainPanel);
            }
        }
        if (SenkyokuRStringEnum.修正.getKey().equals(mainPanel.getHiddenFlag())) {
            TohyokuSelectGamenData 投票区情報 = Base64Serializer.deSerialize(mainPanel.getDgTohyokuList().getClickedItem().getHidMotoData().toString(), TohyokuSelectGamenData.class);
            RString 投票区コード = RString.EMPTY;
            RString 投票区名 = RString.EMPTY;
            RString カナ投票区名 = RString.EMPTY;
            int 表示順 = 投票区情報.getEntity().getHyojijun();
            if (null != 投票区情報.getEntity()) {
                投票区コード = changeNullToEmpty(投票区情報.getEntity().getTohyokuCode());
                投票区名 = changeNullToEmpty(投票区情報.getEntity().getTohyokuName());
                カナ投票区名 = changeNullToEmpty(投票区情報.getEntity().getKanaTohyokuName());
            }
            RString 画面_投票区コード = mainPanel.getTohyokuInput().getTxtCode().getValue();
            RString 画面_投票区名 = mainPanel.getTohyokuInput().getTxtName().getValue();
            RString 画面_カナ投票区名 = mainPanel.getTohyokuInput().getTxtKanaName().getValue();
            int 画面_表示順 = null == mainPanel.getTohyokuInput().getTxtHyojiJun().getValue()
                    ? Initial.表示順初期値.getKey() : mainPanel.getTohyokuInput().getTxtHyojiJun().getValue().intValue();
            if (投票区コード.equals(画面_投票区コード) && 投票区名.equals(画面_投票区名) && カナ投票区名.equals(画面_カナ投票区名) && 表示順 == 画面_表示順) {
                TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
            } else {
                return TohyokuMaintenanceHandler.of(mainPanel).check入力内容の破棄(mainPanel);
            }
        }
        if (SenkyokuRStringEnum.削除.getKey().equals(mainPanel.getHiddenFlag())) {
            TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区詳細パネル内のコードの追加と修正と削除するボタン。
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> onClick_btnOperation(TohyokuMaintenanceDiv mainPanel) {
        if (SenkyokuRStringEnum.追加.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnAddNew(mainPanel);
        } else if (SenkyokuRStringEnum.修正.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnModify(mainPanel);
        } else if (SenkyokuRStringEnum.削除.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnDelete(mainPanel);
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区詳細パネル内のコードを追加するボタン
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> btnAddNew(TohyokuMaintenanceDiv mainPanel) {
        TohyokuSelectGamenData 投票区情報 = new TohyokuSelectGamenData();
        RString 選挙種類 = mainPanel.getTohyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        RString 投票区コード = mainPanel.getTohyokuInput().getTxtCode().getValue();
        boolean 投票区件数フラグ = TohyokuMaintenanceHandler.of(mainPanel).set投票区重複チェック(選挙種類, 投票区コード);
        if (投票区件数フラグ) {
            return TohyokuMaintenanceHandler.of(mainPanel).checkコード重複チェック();
        }
        投票区情報.getEntity().setSenkyoShurui(new Code(mainPanel.getTohyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode()));
        投票区情報.getEntity().setTohyokuCode(mainPanel.getTohyokuInput().getTxtCode().getValue());
        投票区情報.getEntity().setTohyokuName(mainPanel.getTohyokuInput().getTxtName().getValue());
        投票区情報.getEntity().setKanaTohyokuName(mainPanel.getTohyokuInput().getTxtKanaName().getValue());
        投票区情報.getEntity().setSearchKanaTohyokuName(RStringUtil.convertTo清音化(mainPanel.getTohyokuInput().getTxtKanaName().getValue()));
        投票区情報.getEntity().setHyojijun(null == mainPanel.getTohyokuInput().getTxtHyojiJun().getValue()
                ? Initial.表示順初期値.getKey() : mainPanel.getTohyokuInput().getTxtHyojiJun().getValue().intValue());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = TohyokuMaintenanceHandler.of(mainPanel).set投票区詳細パネル内を追加する(投票区情報);
            if (number > 0) {
                TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
            }
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区詳細パネル内のコードを保存するボタン
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> btnModify(TohyokuMaintenanceDiv mainPanel) {
        TohyokuSelectGamenData 投票区情報 = Base64Serializer.deSerialize(mainPanel.getDgTohyokuList().getClickedItem().getHidMotoData().toString(), TohyokuSelectGamenData.class);
        投票区情報.getEntity().setHyojijun(null == mainPanel.getTohyokuInput().getTxtHyojiJun().getValue()
                ? Initial.表示順初期値.getKey() : mainPanel.getTohyokuInput().getTxtHyojiJun().getValue().intValue());
        投票区情報.getEntity().setTohyokuCode(mainPanel.getTohyokuInput().getTxtCode().getValue());
        投票区情報.getEntity().setSenkyoShurui(new Code(mainPanel.getTohyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode()));
        投票区情報.getEntity().setSearchKanaTohyokuName(RStringUtil.convertTo清音化(mainPanel.getTohyokuInput().getTxtKanaName().getValue()));
        投票区情報.getEntity().setKanaTohyokuName(mainPanel.getTohyokuInput().getTxtKanaName().getValue());
        投票区情報.getEntity().setTohyokuName(mainPanel.getTohyokuInput().getTxtName().getValue());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = TohyokuMaintenanceHandler.of(mainPanel).set投票区詳細パネル内を保存する(投票区情報);
            if (number > 0) {
                TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
            }
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 投票区詳細パネル内のコードを削除するボタン
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData<TohyokuMaintenanceDiv>
     */
    public ResponseData<TohyokuMaintenanceDiv> btnDelete(TohyokuMaintenanceDiv mainPanel) {
        TohyokuSelectGamenData 投票区情報 = Base64Serializer.deSerialize(mainPanel.getDgTohyokuList().getClickedItem().getHidMotoData().toString(), TohyokuSelectGamenData.class);
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean deleteFlag = TohyokuMaintenanceHandler.of(mainPanel).set投票区詳細パネル内を削除する(投票区情報);
            if (deleteFlag) {
                TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
            }
        }
        return ResponseData.of(mainPanel).respond();
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
