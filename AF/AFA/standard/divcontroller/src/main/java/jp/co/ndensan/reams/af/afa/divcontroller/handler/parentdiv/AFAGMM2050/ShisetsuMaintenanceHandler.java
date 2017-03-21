/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.shisetsuselect.ShisetsuSelectGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050.ShisetsuMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050.dgShisetsuList_Row;
import jp.co.ndensan.reams.af.afa.service.shisetsu.ShisetsuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 不在者投票管理施設保守
 *
 * @reamsid_L AF-0730-010 liuj
 */
public final class ShisetsuMaintenanceHandler {

    private final ShisetsuMaintenanceDiv div;

    private ShisetsuMaintenanceHandler(ShisetsuMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 不在者投票管理施設のDiv
     * @return 不在者投票管理施設のハンドラ
     */
    public static ShisetsuMaintenanceHandler of(ShisetsuMaintenanceDiv div) {
        return new ShisetsuMaintenanceHandler(div);
    }

    /**
     * 不在者投票管理施設画面のonLoadイベント
     *
     */
    public void set不在者投票管理施設初期化画面() {
        set初期化状態();
        ShisetsuFinder finder = ShisetsuFinder.createInstance();
        List<ShisetsuSelectGamenData> 施設情報リスト = finder.select施設情報();
        List<dgShisetsuList_Row> rowList = new ArrayList();
        if (null != 施設情報リスト) {
            for (ShisetsuSelectGamenData 施設情報 : 施設情報リスト) {
                dgShisetsuList_Row row = new dgShisetsuList_Row();
                YubinNo 郵便番号 = 施設情報.getEntity().getYubinNo();
                AtenaJusho 住所 = 施設情報.getEntity().getJusho();
                AtenaMeisho 施設宛名 = 施設情報.getEntity().getShisetsuAtena();
                TelNo 電話番号 = 施設情報.getEntity().getTelNo();
                TelNo 番号 = 施設情報.getEntity().getFaxNo();
                row.setTxtCode(施設情報.getEntity().getShisetsuCode());
                row.setTxtName(施設情報.getEntity().getShisetsuName());
                row.setTxtShisetsuShubetsu(施設情報.getEntity().getShisetsuShubetsuMeisho());
                row.setTxtKanaName(施設情報.getEntity().getKanaShisetsuName());
                row.setTxtYubinNo(null == 郵便番号 ? RString.EMPTY : 郵便番号.getColumnValue());
                row.setTxtJusho(null == 住所 ? RString.EMPTY : 住所.getColumnValue());
                row.setTxtAtena(null == 施設宛名 ? RString.EMPTY : 施設宛名.getColumnValue());
                row.setTxtTel(null == 電話番号 ? RString.EMPTY : 電話番号.getColumnValue());
                row.setTxtFax(null == 番号 ? RString.EMPTY : 番号.getColumnValue());
                row.setTxtShubetsuCode(施設情報.getEntity().getShisetsuShubetsu().getColumnValue());
                row.setHidMotoData(new RString(Base64Serializer.serialize(施設情報)));
                rowList.add(row);
            }
        }
        div.getShisetsuSelect().getDgShisetsuList().setDataSource(rowList);
    }

    /**
     * 初期化状態
     *
     */
    public void set初期化状態() {
        div.getShisetsuSelect().setDisabled(Boolean.FALSE);
        div.getShisetsuSelect().getBtnAdd().setDisabled(Boolean.FALSE);
        div.getShisetsuSelect().getDgShisetsuList().getDataSource().clear();
        div.getShisetsuSelect().getDgShisetsuList().getGridSetting().setIsShowModifyButtonColumn(Boolean.TRUE);
        div.getShisetsuSelect().getDgShisetsuList().getGridSetting().setIsShowDeleteButtonColumn(Boolean.TRUE);
        div.getShisetsuInput().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 施設選択エリア内の「コードを追加する」ボタン
     *
     */
    public void setコードを追加する() {
        div.getShisetsuSelect().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().setDisplayNone(Boolean.FALSE);
        div.getShisetsuInput().getCcdShisetsuShubetsu().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtCode().clearValue();
        div.getShisetsuInput().getCcdShisetsuShubetsu().clear();
        if (div.getShisetsuInput().getCcdShisetsuShubetsu().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getCcdShisetsuShubetsu().setRequired(CodeInputDiv.Required.任意);
        } else {
            div.getShisetsuInput().getCcdShisetsuShubetsu().setRequired(CodeInputDiv.Required.必須);
        }
        div.getShisetsuInput().getCcdShisetsuShubetsu().load(AFACodeShubetsu.施設種別.getCodeShubetsu());
        div.getShisetsuInput().getTxtName().clearValue();
        div.getShisetsuInput().getTxtKanaName().clearValue();
        div.getShisetsuInput().getTxtYubinNo().clearValue();
        div.getShisetsuInput().getTxtJusho().clearDomain();
        div.getShisetsuInput().getTxtAtenaMeisho().clearDomain();
        div.getShisetsuInput().getTxtTelNo().clearDomain();
        div.getShisetsuInput().getTxtFaxNo().clearDomain();
        div.getShisetsuInput().getTxtCode().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtYubinNo().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtJusho().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtAtenaMeisho().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtTelNo().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtFaxNo().setDisabled(Boolean.FALSE);
        div.setHiddenFlag(SenkyokuRStringEnum.追加.getKey());
        div.getShisetsuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの追加をやめる.getKey());
        div.getShisetsuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを追加する.getKey());
        div.getShisetsuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        if (div.getShisetsuInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        if (div.getShisetsuInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        if (div.getShisetsuInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtName().setRequired(Boolean.TRUE);
        }
    }

    /**
     * 施設選択エリア内のグリッド内の修正ボタン
     *
     */
    public void setグリッド内を修正する() {
        div.getShisetsuSelect().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().setDisplayNone(Boolean.FALSE);
        if (div.getShisetsuInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getShisetsuInput().getTxtCode().setValue(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtCode());
        div.getShisetsuInput().getCcdShisetsuShubetsu().setDisabled(Boolean.FALSE);
        if (div.getShisetsuInput().getCcdShisetsuShubetsu().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getCcdShisetsuShubetsu().setRequired(CodeInputDiv.Required.任意);
        } else {
            div.getShisetsuInput().getCcdShisetsuShubetsu().setRequired(CodeInputDiv.Required.必須);
        }
        div.getShisetsuInput().getCcdShisetsuShubetsu().load(AFACodeShubetsu.施設種別.getCodeShubetsu(),
                new Code(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtShubetsuCode()));
        div.getShisetsuInput().getTxtName().setValue(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtName());
        div.getShisetsuInput().getTxtKanaName().setValue(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtKanaName());
        div.getShisetsuInput().getTxtYubinNo().setValue(new YubinNo(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtYubinNo()));
        div.getShisetsuInput().getTxtJusho().setDomain(new AtenaJusho(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtJusho()));
        div.getShisetsuInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        if (div.getShisetsuInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getShisetsuInput().getTxtAtenaMeisho().setDomain(new AtenaMeisho(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtAtena()));
        div.getShisetsuInput().getTxtTelNo().setDomain(new TelNo(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtTel()));
        div.getShisetsuInput().getTxtName().setDisabled(Boolean.FALSE);
        if (div.getShisetsuInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getShisetsuInput().getTxtFaxNo().setDomain(new TelNo(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtFax()));
        div.getShisetsuInput().getTxtYubinNo().setDisabled(Boolean.FALSE);
        div.setHiddenFlag(SenkyokuRStringEnum.修正.getKey());
        div.getShisetsuInput().getTxtAtenaMeisho().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtTelNo().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの修正をやめる.getKey());
        div.getShisetsuInput().getTxtFaxNo().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getTxtJusho().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを保存する.getKey());
        div.getShisetsuInput().getCcdShisetsuShubetsu().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
    }

    /**
     * 施設選択エリア内のグリッド内の削除ボタン
     *
     */
    public void setグリッド内を削除する() {
        div.getShisetsuSelect().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().setDisplayNone(Boolean.FALSE);
        div.getShisetsuInput().getTxtCode().setValue(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtCode());
        div.getShisetsuInput().getTxtCode().setDisabled(Boolean.TRUE);
        if (div.getShisetsuInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getShisetsuInput().getTxtName().setDisabled(Boolean.TRUE);
        if (div.getShisetsuInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getShisetsuInput().getCcdShisetsuShubetsu().load(AFACodeShubetsu.施設種別.getCodeShubetsu(),
                new Code(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtShubetsuCode()));
        div.getShisetsuInput().getCcdShisetsuShubetsu().setDisabled(Boolean.TRUE);
        if (div.getShisetsuInput().getCcdShisetsuShubetsu().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getCcdShisetsuShubetsu().setRequired(CodeInputDiv.Required.任意);
        } else {
            div.getShisetsuInput().getCcdShisetsuShubetsu().setRequired(CodeInputDiv.Required.必須);
        }
        div.getShisetsuInput().getTxtName().setValue(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtName());
        div.getShisetsuInput().getTxtKanaName().setValue(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtKanaName());
        div.getShisetsuInput().getTxtKanaName().setDisabled(Boolean.TRUE);
        if (div.getShisetsuInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getShisetsuInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getShisetsuInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getShisetsuInput().getTxtYubinNo().setValue(new YubinNo(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtYubinNo()));
        div.getShisetsuInput().getTxtYubinNo().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().getTxtJusho().setDomain(new AtenaJusho(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtJusho()));
        div.getShisetsuInput().getTxtJusho().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().getTxtAtenaMeisho().setDomain(new AtenaMeisho(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtAtena()));
        div.getShisetsuInput().getTxtAtenaMeisho().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().getTxtTelNo().setDomain(new TelNo(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtTel()));
        div.getShisetsuInput().getTxtTelNo().setDisabled(Boolean.TRUE);
        div.getShisetsuInput().getTxtFaxNo().setDomain(new TelNo(div.getShisetsuSelect().getDgShisetsuList().getActiveRow().getTxtFax()));
        div.getShisetsuInput().getTxtFaxNo().setDisabled(Boolean.TRUE);
        div.setHiddenFlag(SenkyokuRStringEnum.削除.getKey());
        div.getShisetsuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの削除をやめる.getKey());
        div.getShisetsuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getShisetsuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを削除する.getKey());
        div.getShisetsuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
    }

    /**
     * 施設コードの重複チェック処理
     *
     * @param 施設コード RString
     * @return boolean
     */
    public boolean set施設重複チェック(RString 施設コード) {
        ShisetsuFinder finder = ShisetsuFinder.createInstance();
        return null != finder.get施設情報(施設コード);
    }

    /**
     * 施設詳細エリア内の「コードを追加する」ボタンクリック時
     *
     * @param 施設情報 ShisetsuSelectGamenData
     * @return int
     */
    public int set施設詳細エリア内を追加する(ShisetsuSelectGamenData 施設情報) {
        ShisetsuFinder finder = ShisetsuFinder.createInstance();
        return finder.insert施設情報(施設情報);
    }

    /**
     * 施設詳細エリア内の「コードを保存する」ボタンクリック時
     *
     * @param 施設情報 ShisetsuSelectGamenData
     * @return int
     */
    public int set施設詳細エリア内を保存する(ShisetsuSelectGamenData 施設情報) {
        ShisetsuFinder finder = ShisetsuFinder.createInstance();
        return finder.update施設情報(施設情報);
    }

    /**
     * 施設詳細エリア内のコードを追加するボタンのチェックする。
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new ShisetsuMaintenanceValidationHandler(div).validateコード重複チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設詳細エリア内の「コードを削除する」ボタンクリック時
     *
     * @param 施設情報 ShisetsuSelectGamenData
     * @return boolean
     */
    public boolean set施設詳細エリア内を削除する(ShisetsuSelectGamenData 施設情報) {
        ShisetsuFinder finder = ShisetsuFinder.createInstance();
        return finder.deltete施設情報(施設情報);
    }

    /**
     * 不在者投票管理施設の入力内容の破棄。
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData
     */
    public ResponseData check入力内容の破棄(ShisetsuMaintenanceDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
        }
        return ResponseData.of(div).respond();
    }
}
