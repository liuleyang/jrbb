/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokuselect.TohyokuSelectGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010.TohyokuMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010.dgTohyokuList_Row;
import jp.co.ndensan.reams.af.afa.service.tohyoku.TohyokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 投票区保守Handler
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public final class TohyokuMaintenanceHandler {

    private final TohyokuMaintenanceDiv div;

    private TohyokuMaintenanceHandler(TohyokuMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 投票区のDiv
     * @return 投票区のハンドラ
     */
    public static TohyokuMaintenanceHandler of(TohyokuMaintenanceDiv div) {
        return new TohyokuMaintenanceHandler(div);
    }

    /**
     * 投票区保守画面のonLoadイベント
     *
     */
    public void set投票区初期化画面() {
        set初期化状態();
        RString 選挙種類 = div.getTohyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        TohyokuFinder finder = TohyokuFinder.createInstance();
        List<TohyokuSelectGamenData> 投票区情報リスト = finder.select投票区情報(new Code(選挙種類));
        List<dgTohyokuList_Row> rowList = new ArrayList();
        if (null != 投票区情報リスト) {
            for (TohyokuSelectGamenData 投票区情報 : 投票区情報リスト) {
                dgTohyokuList_Row row = new dgTohyokuList_Row();
                row.setTxtCode(投票区情報.getEntity().getTohyokuCode());
                row.setTxtName(投票区情報.getEntity().getTohyokuName());
                row.setTxtKanaName(投票区情報.getEntity().getKanaTohyokuName());
                row.setTxtHyojiJun(new RString(投票区情報.getEntity().getHyojijun()));
                row.setHidMotoData(new RString(Base64Serializer.serialize(投票区情報)));
                rowList.add(row);
            }
        }
        div.getTohyokuSelect().getDgTohyokuList().setDataSource(rowList);
    }

    /**
     * 初期化状態
     *
     */
    public void set初期化状態() {
        div.getTohyokuSelect().getCcdSenkyoShurui().initialize();
        div.getTohyokuSelect().setDisabled(Boolean.FALSE);
        div.getTohyokuSelect().getDgTohyokuList().setDisabled(Boolean.FALSE);
        div.getTohyokuSelect().getBtnAdd().setDisabled(Boolean.FALSE);
        div.getTohyokuSelect().getDgTohyokuList().getDataSource().clear();
        div.getTohyokuSelect().getDgTohyokuList().getGridSetting().setIsShowModifyButtonColumn(Boolean.TRUE);
        div.getTohyokuSelect().getDgTohyokuList().getGridSetting().setIsShowDeleteButtonColumn(Boolean.TRUE);
        div.getTohyokuInput().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 投票区選択パネル内の「コードを追加する」ボタンクリック時画面状態
     *
     */
    public void setコードを追加する() {
        div.getTohyokuSelect().setDisabled(Boolean.TRUE);
        div.getTohyokuInput().setDisplayNone(Boolean.FALSE);
        div.getTohyokuInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getTohyokuInput().getTxtCode().clearValue();
        div.getTohyokuInput().getTxtName().clearValue();
        if (div.getTohyokuInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getTohyokuInput().getTxtKanaName().clearValue();
        div.getTohyokuInput().getTxtHyojiJun().clearValue();
        div.getTohyokuInput().getTxtCode().setDisabled(Boolean.FALSE);
        div.getTohyokuInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        if (div.getTohyokuInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getTohyokuInput().getTxtHyojiJun().setDisabled(Boolean.FALSE);
        div.setHiddenFlag(SenkyokuRStringEnum.追加.getKey());
        div.getTohyokuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの追加をやめる.getKey());
        div.getTohyokuInput().getBtnStop().setDisabled(Boolean.FALSE);
        if (div.getTohyokuInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getTohyokuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを追加する.getKey());
        div.getTohyokuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
    }

    /**
     * 投票区選択パネル内のグリッド内の修正ボタンクリック時画面状態
     *
     */
    public void setグリッド内を修正する() {
        div.getTohyokuSelect().setDisabled(Boolean.TRUE);
        div.getDgTohyokuList().setDisabled(Boolean.TRUE);
        div.getTohyokuInput().getTxtCode().setValue(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtCode());
        div.getTohyokuInput().getTxtName().setValue(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtName());
        div.getTohyokuInput().getTxtKanaName().setValue(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtKanaName());
        div.getTohyokuInput().getTxtHyojiJun().setValue(new Decimal(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtHyojiJun().toString()));
        div.getTohyokuInput().setDisplayNone(Boolean.FALSE);
        div.getTohyokuInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getTohyokuInput().getTxtName().setDisabled(Boolean.FALSE);
        if (div.getTohyokuInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getTohyokuInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getTohyokuInput().getTxtHyojiJun().setDisabled(Boolean.FALSE);
        div.setHiddenFlag(SenkyokuRStringEnum.修正.getKey());
        div.getTohyokuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getTohyokuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getTohyokuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの修正をやめる.getKey());
        if (div.getTohyokuInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getTohyokuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを保存する.getKey());
        if (div.getTohyokuInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
    }

    /**
     * 投票区選択パネル内のグリッド内の削除ボタンクリック時画面状態
     *
     */
    public void setグリッド内を削除する() {
        div.getTohyokuInput().getTxtName().setDisabled(Boolean.TRUE);
        if (div.getTohyokuInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getTohyokuSelect().setDisabled(Boolean.TRUE);
        div.getTohyokuSelect().setDisplayNone(Boolean.FALSE);
        div.getTohyokuInput().setDisplayNone(Boolean.FALSE);
        div.getTohyokuInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getTohyokuInput().getTxtCode().setValue(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtCode());
        div.getTohyokuInput().getTxtName().setValue(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtName());
        div.getTohyokuInput().getTxtKanaName().setDisabled(Boolean.TRUE);
        if (div.getTohyokuInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getTohyokuInput().getTxtKanaName().setValue(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtKanaName());
        div.getTohyokuInput().getTxtHyojiJun().setDisabled(Boolean.TRUE);
        div.getTohyokuInput().getTxtHyojiJun().setValue(new Decimal(div.getTohyokuSelect().getDgTohyokuList().getActiveRow().getTxtHyojiJun().toString()));
        div.setHiddenFlag(SenkyokuRStringEnum.削除.getKey());
        div.getTohyokuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの削除をやめる.getKey());
        div.getTohyokuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getTohyokuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを削除する.getKey());
        div.getTohyokuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        if (div.getTohyokuInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getTohyokuInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getTohyokuInput().getTxtCode().setRequired(Boolean.TRUE);
        }
    }

    /**
     * 投票区コードの重複チェック処理
     *
     * @param 選挙種類 RString
     * @param 投票区コード RString
     * @return boolean
     */
    public boolean set投票区重複チェック(RString 選挙種類, RString 投票区コード) {
        Code tohyokushurui = null == 選挙種類 ? Code.EMPTY : new Code(選挙種類);
        TohyokuFinder finder = TohyokuFinder.createInstance();
        return null != finder.get投票区情報(tohyokushurui, 投票区コード);
    }

    /**
     * 投票区詳細パネル内の「コードを追加する」ボタンクリック時
     *
     * @param 投票区情報 TohyokuSelectGamenData
     * @return int
     */
    public int set投票区詳細パネル内を追加する(TohyokuSelectGamenData 投票区情報) {
        TohyokuFinder finder = TohyokuFinder.createInstance();
        return finder.insert投票区情報(投票区情報);
    }

    /**
     * 投票区詳細パネル内の「コードを保存する」ボタンクリック時
     *
     * @param 投票区情報 TohyokuSelectGamenData
     * @return int
     */
    public int set投票区詳細パネル内を保存する(TohyokuSelectGamenData 投票区情報) {
        TohyokuFinder finder = TohyokuFinder.createInstance();
        return finder.update投票区情報(投票区情報);
    }

    /**
     * 投票区詳細パネル内の「コードを削除する」ボタンクリック時
     *
     * @param 投票区情報 TohyokuSelectGamenData
     * @return boolean
     */
    public boolean set投票区詳細パネル内を削除する(TohyokuSelectGamenData 投票区情報) {
        TohyokuFinder finder = TohyokuFinder.createInstance();
        return finder.deltete投票区情報(投票区情報);
    }

    /**
     * 「投票区詳細」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new TohyokuMaintenanceValidationHandler(div).validateコード重複チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 入力内容の破棄。
     *
     * @param mainPanel TohyokuMaintenanceDiv
     * @return ResponseData
     */
    public ResponseData check入力内容の破棄(TohyokuMaintenanceDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            TohyokuMaintenanceHandler.of(mainPanel).set投票区初期化画面();
        }
        return ResponseData.of(div).respond();
    }
}
