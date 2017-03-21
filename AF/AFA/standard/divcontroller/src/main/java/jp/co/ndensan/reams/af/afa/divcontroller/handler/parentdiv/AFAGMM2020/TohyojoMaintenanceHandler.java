/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyojoForCtrl;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.TohyojoEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.TohyojoMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.dgTohyojoList_Row;
import jp.co.ndensan.reams.af.afa.service.core.tohyojo.TohyojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 投票所保守Handler
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public final class TohyojoMaintenanceHandler {

    private final TohyojoMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyojoMaintenanceDiv
     */
    public TohyojoMaintenanceHandler(TohyojoMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * 投票所保守のHandler初期化
     *
     * @param div TohyojoMaintenanceDiv
     * @return TohyojoMaintenanceHandler
     */
    public static TohyojoMaintenanceHandler of(TohyojoMaintenanceDiv div) {
        return new TohyojoMaintenanceHandler(div);
    }

    /**
     * 投票所保守画面のonLoadイベント
     */
    public void set投票所保守初期化画面() {
        set初期化状態1();
        TohyojoFinder finder = TohyojoFinder.createInstance();
        List<TohyojoForCtrl> 投票所選択リスト = finder.get投票所保守全件();
        List<dgTohyojoList_Row> rowList = new ArrayList();
        if (null != 投票所選択リスト) {
            for (TohyojoForCtrl 投票所選択情報 : 投票所選択リスト) {
                dgTohyojoList_Row row = new dgTohyojoList_Row();
                row.setTxtCode(投票所選択情報.getEntity().getTohyojoCode());
                row.setTxtName(投票所選択情報.getEntity().getTohyojoName());
                row.setTxtKanaName(投票所選択情報.getEntity().getKanaTohyojoName());
                row.getTxtTimeFrom().setValue(投票所選択情報.getEntity().getTohyoStartTime());
                row.getTxtTimeTo().setValue(投票所選択情報.getEntity().getTohyoStopTime());
                row.setChkZaigaiTohyo(投票所選択情報.getEntity().getZaigaiTohyoKanoFlag());
                YubinNo yubinNum = 投票所選択情報.getEntity().getYubinNo();
                RString yubinNo = null == yubinNum
                        ? RString.EMPTY : yubinNum.getColumnValue();
                row.setTxtYubinNo(yubinNo);
                AtenaJusho jushoAddr = 投票所選択情報.getEntity().getJusho();
                RString jusho = null == jushoAddr
                        ? RString.EMPTY : jushoAddr.getColumnValue();
                row.setTxtJusho(jusho);
                AtenaMeisho atenaInfo = 投票所選択情報.getEntity().getTohyojoAtena();
                RString atena = null == atenaInfo
                        ? RString.EMPTY : atenaInfo.getColumnValue();
                row.setTxtAtena(atena);
                TelNo telNumber = 投票所選択情報.getEntity().getTelNo();
                RString telNo = null == telNumber
                        ? RString.EMPTY : telNumber.getColumnValue();
                row.setTxtTel(telNo);
                TelNo faxNum = 投票所選択情報.getEntity().getFaxNo();
                RString fax = null == faxNum
                        ? RString.EMPTY : faxNum.getColumnValue();
                row.setTxtFax(fax);
                row.setTxtFileName(投票所選択情報.getEntity().getMapImage());
                row.setHidMotoData(new RString(Base64Serializer.serialize(投票所選択情報)));
                rowList.add(row);
            }
        }
        div.getDgTohyojoList().setDataSource(rowList);
    }

    /**
     * 投票所コードの重複チェック処理
     *
     * @param 投票所コード RString
     * @return boolean
     */
    public boolean set投票所重複チェック(RString 投票所コード) {
        TohyojoFinder finder = TohyojoFinder.createInstance();
        return null != finder.get投票所保守By投票所コード(投票所コード);
    }

    /**
     * 投票所詳細コードを追加と保存するの処理
     *
     * @param 投票所 Tohyojo
     * @return int
     */
    public int set投票所詳細コードを追加と保存する(TohyojoForCtrl 投票所) {
        TohyojoFinder finder = TohyojoFinder.createInstance();
        return finder.insert投票所保守情報(投票所);
    }

    /**
     * 投票所詳細エリア内の「コードを削除する」ボタンクリック時
     *
     * @param 投票所 TohyojoForCtrl
     * @return boolean
     */
    public boolean set投票所詳細コードを削除する(TohyojoForCtrl 投票所) {
        TohyojoFinder finder = TohyojoFinder.createInstance();
        return finder.deltete投票所保守情報(投票所);
    }

    /**
     * コード重複チェック処理
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new TohyojoMaintenanceValidatorHandler(div).validateコード重複();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 初期化状態
     */
    public void set初期化状態1() {
        div.getTohyojoSelect().setDisabled(Boolean.FALSE);
        div.getTohyojoSelect().getBtnAdd().setDisabled(Boolean.FALSE);
        div.getDgTohyojoList().setDisplayNone(Boolean.FALSE);
        div.getDgTohyojoList().setDisabled(Boolean.FALSE);
        div.getDgTohyojoList().getDataSource().clear();
        div.getDgTohyojoList().getGridSetting().setIsShowModifyButtonColumn(Boolean.TRUE);
        div.getDgTohyojoList().getGridSetting().setIsShowDeleteButtonColumn(Boolean.TRUE);
        div.getTohyojoInput().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 投票所選択エリア内の「コードを追加する」ボタンクリック時画面状態
     */
    public void setコードを追加する() {
        div.getTohyojoInput().getTxtCode().setDisabled(Boolean.FALSE);
        if (div.getTohyojoInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().setDisplayNone(Boolean.FALSE);
        div.getTohyojoSelect().setDisabled(Boolean.TRUE);
        if (div.getTohyojoInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getTohyojoSelect().getBtnAdd().setDisabled(Boolean.TRUE);
        div.getTohyojoSelect().getDgTohyojoList().setDisplayNone(Boolean.FALSE);
        div.getTohyojoInput().getTxtName().setDisabled(Boolean.FALSE);
        if (div.getTohyojoInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getTohyojoSelect().getDgTohyojoList().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtCode().clearValue();
        div.getTohyojoInput().getTxtName().clearValue();
        div.getTohyojoInput().getTxtKanaName().clearValue();
        div.getTohyojoInput().getTxtTohyoTimeRange().clearFromValue();
        div.getTohyojoInput().getTxtTohyoTimeRange().clearToValue();
        div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setDisabled(Boolean.FALSE);
        List<RString> keyList = new ArrayList();
        div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setSelectedItemsByKey(keyList);
        if ((BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体)).equals(TohyojoEnum.印字する.getKey())) {
            div.getTohyojoInput().getImgChizu().setDisplayNone(Boolean.FALSE);
        } else if ((BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体)).equals(TohyojoEnum.印字しない.getKey())) {
            div.getTohyojoInput().getImgChizu().setDisplayNone(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtYubinNo().clearValue();
        div.getTohyojoInput().getTxtJusho().clearDomain();
        div.getTohyojoInput().getTxtAtenaMeisho().clearDomain();
        div.getTohyojoInput().getTxtTelNo().clearDomain();
        div.getTohyojoInput().getTxtFaxNo().clearDomain();
        div.getTohyojoInput().getTxtMapFileName().clearValue();
        div.getTohyojoInput().getTxtTohyoTimeRange().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtYubinNo().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtJusho().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtAtenaMeisho().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtTelNo().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtFaxNo().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtMapFileName().setDisabled(Boolean.FALSE);
        div.getBtnStop().setText(TohyojoEnum.コードの追加をやめる.getKey());
        if (div.getTohyojoInput().getTxtTohyoTimeRange().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtTohyoTimeRange().setFromRequired(Boolean.FALSE);
            div.getTohyojoInput().getTxtTohyoTimeRange().setToRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtTohyoTimeRange().setToRequired(Boolean.TRUE);
            div.getTohyojoInput().getTxtTohyoTimeRange().setFromRequired(Boolean.TRUE);
        }
        div.getBtnAddNew().setText(TohyojoEnum.コードを追加する.getKey());
        div.getBtnStop().setDisabled(Boolean.FALSE);
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.setHiddenFlag(TohyojoEnum.追加.getKey());
    }

    /**
     * 投票所選択エリア内のグリッド内の修正ボタンクリック時画面状態
     */
    public void setコードを修正() {
        div.getTohyojoSelect().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().setDisplayNone(Boolean.FALSE);
        if ((BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体)).equals(TohyojoEnum.印字する.getKey())) {
            div.getTohyojoInput().getImgChizu().setDisplayNone(Boolean.FALSE);
            div.getTohyojoInput().getImgChizu().setSrc((BusinessConfig.get(ConfigKeysAFA.入場券_地図格納フォルダ, SubGyomuCode.AFA選挙本体)).concat("\\").concat(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtFileName()));
        } else if ((BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体)).equals(TohyojoEnum.印字しない.getKey())) {
            div.getTohyojoInput().getImgChizu().setDisplayNone(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtTelNo().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtTelNo().setDomain(new TelNo(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtTel()));
        div.getTohyojoInput().getTxtFaxNo().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtFaxNo().setDomain(new TelNo(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtFax()));
        div.getTohyojoInput().getTxtMapFileName().setDisabled(Boolean.FALSE);
        div.getTohyojoSelect().setDisplayNone(Boolean.FALSE);
        div.getTohyojoInput().getTxtTohyoTimeRange().setFromValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtTimeFrom().getValue());
        div.getTohyojoInput().getTxtTohyoTimeRange().setToValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtTimeTo().getValue());
        KeyValueDataSource source = new KeyValueDataSource();
        source.setValue(new RString("在外投票受付可能"));
        source.setKey(new RString("0"));
        List<KeyValueDataSource> dataList = new ArrayList();
        dataList.add(source);
        div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setDataSource(dataList);
        div.getTohyojoInput().getTxtCode().setDisabled(Boolean.TRUE);
        if (div.getTohyojoInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtJusho().setDomain(new AtenaJusho(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtJusho()));
        div.getTohyojoInput().getTxtAtenaMeisho().setDomain(new AtenaMeisho(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtAtena()));
        if (Boolean.TRUE == div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getChkZaigaiTohyo().booleanValue()) {
            List<RString> keyList = new ArrayList();
            keyList.add(new RString("0"));
            div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setSelectedItemsByKey(keyList);
        } else {
            List<RString> keyList = new ArrayList();
            div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setSelectedItemsByKey(keyList);
        }
        div.getTohyojoInput().getTxtMapFileName().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtFileName());
        div.getTohyojoInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtYubinNo().setValue(new YubinNo(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtYubinNo()));
        div.getTohyojoInput().getTxtKanaName().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtKanaName());
        if (div.getTohyojoInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtKanaName().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtTohyoTimeRange().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtJusho().setDisabled(Boolean.FALSE);
        div.getBtnAddNew().setText(TohyojoEnum.コードを保存する.getKey());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getBtnStop().setText(TohyojoEnum.コードの修正をやめる.getKey());
        div.getTohyojoInput().getTxtName().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtName());
        div.getTohyojoInput().getTxtAtenaMeisho().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setDisabled(Boolean.FALSE);
        div.getTohyojoInput().getTxtYubinNo().setDisabled(Boolean.FALSE);
        if (div.getTohyojoInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtCode().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtCode());
        div.setHiddenFlag(TohyojoEnum.修正.getKey());
        div.getBtnStop().setDisabled(Boolean.FALSE);
        if (div.getTohyojoInput().getTxtTohyoTimeRange().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtTohyoTimeRange().setFromRequired(Boolean.FALSE);
            div.getTohyojoInput().getTxtTohyoTimeRange().setToRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtTohyoTimeRange().setToRequired(Boolean.TRUE);
            div.getTohyojoInput().getTxtTohyoTimeRange().setFromRequired(Boolean.TRUE);
        }
    }

    /**
     * 投票所選択エリア内のグリッド内の削除ボタンクリック時画面状態
     */
    public void setコードを削除() {
        div.getTohyojoSelect().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().setDisplayNone(Boolean.FALSE);
        div.getTohyojoInput().getTxtCode().setDisabled(Boolean.TRUE);
        if (div.getTohyojoInput().getTxtCode().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtCode().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtCode().setRequired(Boolean.TRUE);
        }
        div.getTohyojoSelect().setDisplayNone(Boolean.FALSE);
        div.getTohyojoInput().getTxtCode().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtCode());
        div.getTohyojoInput().getTxtName().setDisabled(Boolean.TRUE);
        if (div.getTohyojoInput().getTxtName().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtName().setRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtName().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtName());
        div.getTohyojoInput().getTxtKanaName().setDisabled(Boolean.TRUE);
        if (div.getTohyojoInput().getTxtKanaName().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtKanaName().setRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtKanaName().setRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtKanaName().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtKanaName());
        div.getTohyojoInput().getTxtTohyoTimeRange().setFromValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtTimeFrom().getValue());
        div.getTohyojoInput().getTxtTohyoTimeRange().setDisabled(Boolean.TRUE);
        if (div.getTohyojoInput().getTxtTohyoTimeRange().isDisabled() == Boolean.TRUE) {
            div.getTohyojoInput().getTxtTohyoTimeRange().setFromRequired(Boolean.FALSE);
            div.getTohyojoInput().getTxtTohyoTimeRange().setToRequired(Boolean.FALSE);
        } else {
            div.getTohyojoInput().getTxtTohyoTimeRange().setFromRequired(Boolean.TRUE);
            div.getTohyojoInput().getTxtTohyoTimeRange().setToRequired(Boolean.TRUE);
        }
        div.getTohyojoInput().getTxtTohyoTimeRange().setToValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtTimeTo().getValue());
        div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setDisabled(Boolean.TRUE);
        List<KeyValueDataSource> dataList = new ArrayList();
        KeyValueDataSource source = new KeyValueDataSource();
        source.setKey(new RString("0"));
        source.setValue(new RString("在外投票受付可能"));
        dataList.add(source);
        div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setDataSource(dataList);
        if (Boolean.TRUE == div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getChkZaigaiTohyo().booleanValue()) {
            List<RString> keyList = new ArrayList();
            keyList.add(new RString("0"));
            div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setSelectedItemsByKey(keyList);
        } else {
            List<RString> keyList = new ArrayList();
            div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().setSelectedItemsByKey(keyList);
        }
        div.getTohyojoInput().getTxtYubinNo().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtYubinNo().setValue(new YubinNo(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtYubinNo()));
        div.getTohyojoInput().getTxtJusho().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtJusho().setDomain(new AtenaJusho(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtJusho()));
        div.getTohyojoInput().getTxtAtenaMeisho().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtAtenaMeisho().setDomain(new AtenaMeisho(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtAtena()));
        div.getTohyojoInput().getTxtTelNo().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtTelNo().setDomain(new TelNo(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtTel()));
        div.getTohyojoInput().getTxtFaxNo().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtFaxNo().setDomain(new TelNo(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtFax()));
        div.getTohyojoInput().getTxtMapFileName().setDisabled(Boolean.TRUE);
        div.getTohyojoInput().getTxtMapFileName().setValue(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtFileName());
        if ((BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体)).equals(TohyojoEnum.印字しない.getKey())) {
            div.getTohyojoInput().getImgChizu().setDisplayNone(Boolean.TRUE);
        } else if ((BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体)).equals(TohyojoEnum.印字する.getKey())) {
            div.getTohyojoInput().getImgChizu().setDisplayNone(Boolean.FALSE);
            div.getTohyojoInput().getImgChizu().setSrc((BusinessConfig.get(ConfigKeysAFA.入場券_地図格納フォルダ, SubGyomuCode.AFA選挙本体)).concat("\\").concat(div.getTohyojoSelect().getDgTohyojoList().getActiveRow().getTxtFileName()));
        }
        div.setHiddenFlag(TohyojoEnum.削除.getKey());
        div.getBtnStop().setText(TohyojoEnum.コードの削除をやめる.getKey());
        div.getBtnStop().setDisabled(Boolean.FALSE);
        div.getBtnAddNew().setText(TohyojoEnum.コードを削除する.getKey());
        div.getBtnAddNew().setDisabled(Boolean.FALSE);
    }

    /**
     * 入力内容の破棄。
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData
     */
    public ResponseData check入力内容の破棄(TohyojoMaintenanceDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
        }
        return ResponseData.of(div).respond();
    }
}
