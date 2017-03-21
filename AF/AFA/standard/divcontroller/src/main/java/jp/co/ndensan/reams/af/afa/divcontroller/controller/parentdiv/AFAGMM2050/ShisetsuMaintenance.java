/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2050;

import jp.co.ndensan.reams.af.afa.business.shisetsuselect.ShisetsuSelectGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050.ShisetsuMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2050.ShisetsuMaintenanceHandler;
import jp.co.ndensan.reams.af.afa.service.shisetsu.ShisetsuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 不在者投票管理施設保守
 *
 * @reamsid_L AF-0730-010 liuj
 */
public class ShisetsuMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> onLoad(ShisetsuMaintenanceDiv mainPanel) {
        ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
        return ResponseData.of(mainPanel).respond();

    }

    /**
     * 施設選択エリア内の「コードを追加する」ボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> onClick_btnAdd(ShisetsuMaintenanceDiv mainPanel) {
        ShisetsuMaintenanceHandler.of(mainPanel).setコードを追加する();
        return ResponseData.of(mainPanel).respond();

    }

    /**
     * 施設選択エリア内のグリッド内の修正ボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> onClick_onModifyButton(ShisetsuMaintenanceDiv mainPanel) {
        ShisetsuMaintenanceHandler.of(mainPanel).setグリッド内を修正する();
        return ResponseData.of(mainPanel).respond();

    }

    /**
     * 施設選択エリア内のグリッド内の削除ボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> onClick_onDeleteButton(ShisetsuMaintenanceDiv mainPanel) {
        ShisetsuMaintenanceHandler.of(mainPanel).setグリッド内を削除する();
        return ResponseData.of(mainPanel).respond();

    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    /**
     * 施設詳細エリア内のコードの追加と修正と削除をやめるボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    public ResponseData<ShisetsuMaintenanceDiv> onClick_btnUntreated(ShisetsuMaintenanceDiv mainPanel) {
        if (SenkyokuRStringEnum.追加.getKey().equals(mainPanel.getHiddenFlag())) {
            RString 画面_電話番号 = mainPanel.getShisetsuInput().getTxtTelNo().getDomain().value();
            RString 画面_郵便番号 = mainPanel.getShisetsuInput().getTxtYubinNo().getValue().getColumnValue();
            RString 画面_施設コード = mainPanel.getShisetsuInput().getTxtCode().getValue();
            RString 画面_住所 = mainPanel.getShisetsuInput().getTxtJusho().getDomain().value();
            RString 画面_FAX番号 = mainPanel.getShisetsuInput().getTxtFaxNo().getDomain().value();
            RString 画面_施設種別選択 = mainPanel.getShisetsuInput().getCcdShisetsuShubetsu().getCodeMeisho();
            RString 画面_宛名 = mainPanel.getShisetsuInput().getTxtAtenaMeisho().getDomain().value();
            RString 画面_施設名 = mainPanel.getShisetsuInput().getTxtName().getValue();
            RString 画面_カナ施設名 = mainPanel.getShisetsuInput().getTxtKanaName().getValue();
            if (画面_施設コード.isEmpty() && 画面_施設種別選択.isEmpty() && 画面_施設名.isEmpty() && 画面_カナ施設名.isEmpty() && 画面_郵便番号.isEmpty()
                    && 画面_住所.isEmpty() && 画面_宛名.isEmpty() && 画面_電話番号.isEmpty() && 画面_FAX番号.isEmpty()) {
                ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
            } else {
                return ShisetsuMaintenanceHandler.of(mainPanel).check入力内容の破棄(mainPanel);
            }
        }
        if (SenkyokuRStringEnum.修正.getKey().equals(mainPanel.getHiddenFlag())) {
            ShisetsuSelectGamenData 施設情報 = Base64Serializer.deSerialize(mainPanel.getShisetsuSelect().getDgShisetsuList().getClickedItem().getHidMotoData().toString(), ShisetsuSelectGamenData.class);
            RString 施設コード = changeNullToEmpty(施設情報.getEntity().getShisetsuCode());
            RString 施設種別 = changeNullToEmpty(施設情報.getEntity().getShisetsuShubetsu().getColumnValue());
            RString 施設名 = changeNullToEmpty(施設情報.getEntity().getShisetsuName());
            RString カナ施設名 = changeNullToEmpty(施設情報.getEntity().getKanaShisetsuName());
            YubinNo yubinNo = 施設情報.getEntity().getYubinNo();
            RString 郵便番号 = null == yubinNo ? RString.EMPTY : yubinNo.getColumnValue();
            AtenaJusho jusho = 施設情報.getEntity().getJusho();
            RString 住所 = null == jusho ? RString.EMPTY : jusho.getColumnValue();
            AtenaMeisho meisho = 施設情報.getEntity().getShisetsuAtena();
            RString 宛名 = null == meisho ? RString.EMPTY : meisho.getColumnValue();
            TelNo telNo = 施設情報.getEntity().getTelNo();
            RString 電話番号 = null == telNo ? RString.EMPTY : telNo.getColumnValue();
            TelNo faxNo = 施設情報.getEntity().getFaxNo();
            RString 番号FAX = null == faxNo ? RString.EMPTY : faxNo.getColumnValue();
            RString 画面_施設コード = mainPanel.getShisetsuInput().getTxtCode().getValue();
            RString 画面_施設種別選択 = mainPanel.getShisetsuInput().getCcdShisetsuShubetsu().getCode().getColumnValue();
            RString 画面_施設名 = mainPanel.getShisetsuInput().getTxtName().getValue();
            RString 画面_カナ施設名 = mainPanel.getShisetsuInput().getTxtKanaName().getValue();
            RString 画面_郵便番号 = mainPanel.getShisetsuInput().getTxtYubinNo().getValue().getColumnValue();
            RString 画面_住所 = mainPanel.getShisetsuInput().getTxtJusho().getDomain().value();
            RString 画面_宛名 = mainPanel.getShisetsuInput().getTxtAtenaMeisho().getDomain().value();
            RString 画面_電話番号 = mainPanel.getShisetsuInput().getTxtTelNo().getDomain().value();
            RString 画面_FAX番号 = mainPanel.getShisetsuInput().getTxtFaxNo().getDomain().value();
            if (施設コード.equals(画面_施設コード) && 施設種別.equals(画面_施設種別選択) && 施設名.equals(画面_施設名)
                    && カナ施設名.equals(画面_カナ施設名) && 郵便番号.equals(画面_郵便番号) && 住所.equals(画面_住所)
                    && 宛名.equals(画面_宛名) && 電話番号.equals(画面_電話番号) && 番号FAX.equals(画面_FAX番号)) {
                ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
            } else {
                return ShisetsuMaintenanceHandler.of(mainPanel).check入力内容の破棄(mainPanel);
            }
        }
        if (SenkyokuRStringEnum.削除.getKey().equals(mainPanel.getHiddenFlag())) {
            ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 施設詳細エリア内のコードを追加と保存と削除するボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> onClick_btnProcessing(ShisetsuMaintenanceDiv mainPanel) {
        if (mainPanel.getHiddenFlag().equals(SenkyokuRStringEnum.削除.getKey())) {
            return btnDeleteData(mainPanel);
        }
        if (mainPanel.getHiddenFlag().equals(SenkyokuRStringEnum.追加.getKey())) {
            return btnAddNewData(mainPanel);
        }
        if (SenkyokuRStringEnum.修正.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnModifyData(mainPanel);
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 施設詳細エリア内のコードを削除するボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> btnDeleteData(ShisetsuMaintenanceDiv mainPanel) {
        ShisetsuSelectGamenData 施設情報 = Base64Serializer.deSerialize(mainPanel.getShisetsuSelect().getDgShisetsuList().getClickedItem().getHidMotoData().toString(), ShisetsuSelectGamenData.class);
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean deleteFlag = ShisetsuMaintenanceHandler.of(mainPanel).set施設詳細エリア内を削除する(施設情報);
            if (deleteFlag) {
                ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
            }
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 施設詳細エリア内のコードを追加するボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> btnAddNewData(ShisetsuMaintenanceDiv mainPanel) {
        RString 施設コード = mainPanel.getShisetsuInput().getTxtCode().getValue();
        boolean 施設件数フラグ = ShisetsuMaintenanceHandler.of(mainPanel).set施設重複チェック(施設コード);
        if (施設件数フラグ) {
            return ShisetsuMaintenanceHandler.of(mainPanel).checkコード重複チェック();
        }
        RString 施設種別 = mainPanel.getShisetsuInput().getCcdShisetsuShubetsu().getCode().getColumnValue();
        ShisetsuSelectGamenData 施設情報 = new ShisetsuSelectGamenData();
        施設情報.getEntity().setTelNo(new TelNo(mainPanel.getShisetsuInput().getTxtTelNo().getDomain().getColumnValue()));
        施設情報.getEntity().setShisetsuCode(mainPanel.getShisetsuInput().getTxtCode().getValue());
        施設情報.getEntity().setFaxNo(new TelNo(mainPanel.getShisetsuInput().getTxtFaxNo().getDomain().getColumnValue()));
        施設情報.getEntity().setShisetsuAtena(new AtenaMeisho(mainPanel.getShisetsuInput().getTxtAtenaMeisho().getDomain().getColumnValue()));
        施設情報.getEntity().setYubinNo(mainPanel.getShisetsuInput().getTxtYubinNo().getValue());
        施設情報.getEntity().setJusho(new AtenaJusho(mainPanel.getShisetsuInput().getTxtJusho().getDomain().getColumnValue()));
        施設情報.getEntity().setSearchKanaShisetsuName(RStringUtil.convertTo清音化(mainPanel.getShisetsuInput().getTxtKanaName().getValue()));
        施設情報.getEntity().setKanaShisetsuName(mainPanel.getShisetsuInput().getTxtKanaName().getValue());
        施設情報.getEntity().setShisetsuName(mainPanel.getShisetsuInput().getTxtName().getValue());
        施設情報.getEntity().setShisetsuShubetsu(mainPanel.getShisetsuInput().getCcdShisetsuShubetsu().getCode());
        if (施設種別.equals(ShisetsuShubetsu.一般_本庁.getCode()) && !ResponseHolder.isReRequest()) {
            ShisetsuFinder finder = ShisetsuFinder.createInstance();
            boolean 施設種別フラグ = finder.select施設種別();
            if (施設種別フラグ) {
                return ResponseData.of(mainPanel).addMessage((UrQuestionMessages.確認_汎用.getMessage()).replace("既に本庁のデータが存在します。登録しても")).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = ShisetsuMaintenanceHandler.of(mainPanel).set施設詳細エリア内を追加する(施設情報);
            if (number > 0) {
                ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
            }
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 施設詳細エリア内のコードを保存するボタン
     *
     * @param mainPanel ShisetsuMaintenanceDiv
     * @return ResponseData<ShisetsuMaintenanceDiv>
     */
    public ResponseData<ShisetsuMaintenanceDiv> btnModifyData(ShisetsuMaintenanceDiv mainPanel) {
        ShisetsuSelectGamenData 施設情報 = Base64Serializer.deSerialize(mainPanel.getShisetsuSelect().getDgShisetsuList().getClickedItem().getHidMotoData().toString(), ShisetsuSelectGamenData.class);
        施設情報.getEntity().setShisetsuCode(mainPanel.getShisetsuInput().getTxtCode().getValue());
        施設情報.getEntity().setFaxNo(new TelNo(mainPanel.getShisetsuInput().getTxtFaxNo().getDomain().getColumnValue()));
        施設情報.getEntity().setTelNo(new TelNo(mainPanel.getShisetsuInput().getTxtTelNo().getDomain().getColumnValue()));
        施設情報.getEntity().setYubinNo(mainPanel.getShisetsuInput().getTxtYubinNo().getValue());
        施設情報.getEntity().setShisetsuShubetsu(mainPanel.getShisetsuInput().getCcdShisetsuShubetsu().getCode());
        施設情報.getEntity().setShisetsuAtena(new AtenaMeisho(mainPanel.getShisetsuInput().getTxtAtenaMeisho().getDomain().getColumnValue()));
        施設情報.getEntity().setJusho(new AtenaJusho(mainPanel.getShisetsuInput().getTxtJusho().getDomain().getColumnValue()));
        施設情報.getEntity().setShisetsuName(mainPanel.getShisetsuInput().getTxtName().getValue());
        施設情報.getEntity().setKanaShisetsuName(mainPanel.getShisetsuInput().getTxtKanaName().getValue());
        施設情報.getEntity().setSearchKanaShisetsuName(RStringUtil.convertTo清音化(mainPanel.getShisetsuInput().getTxtKanaName().getValue()));
        RString 施設種別選択 = mainPanel.getShisetsuInput().getCcdShisetsuShubetsu().getCode().getColumnValue();
        if (ShisetsuShubetsu.一般_本庁.getCode().equals(施設種別選択) && !ResponseHolder.isReRequest()) {
            ShisetsuFinder finder = ShisetsuFinder.createInstance();
            if (finder.select施設種別()) {
                return ResponseData.of(mainPanel).addMessage((UrQuestionMessages.確認_汎用.getMessage()).replace("既に本庁のデータが存在します。登録しても")).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = ShisetsuMaintenanceHandler.of(mainPanel).set施設詳細エリア内を保存する(施設情報);
            if (number > 0) {
                ShisetsuMaintenanceHandler.of(mainPanel).set不在者投票管理施設初期化画面();
            }
        }
        return ResponseData.of(mainPanel).respond();
    }
}
