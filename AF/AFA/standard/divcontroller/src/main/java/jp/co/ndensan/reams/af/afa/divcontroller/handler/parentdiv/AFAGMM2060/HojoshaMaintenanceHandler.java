/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.HojoshaMaintenanceInfo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.HojoshaMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.dgHojoshaList_Row;
import jp.co.ndensan.reams.af.afa.service.core.hojoshamaintenance.HojoshaMaintenanceManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 投票補助者保守handler
 *
 * @reamsid_L AF-0750-010 lis2
 */
public class HojoshaMaintenanceHandler {

    private final HojoshaMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HojoshaMaintenanceDiv
     */
    public HojoshaMaintenanceHandler(HojoshaMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * 投票補助者保守のHandler初期化
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceHandler
     */
    public static HojoshaMaintenanceHandler of(HojoshaMaintenanceDiv div) {
        return new HojoshaMaintenanceHandler(div);
    }

    /**
     * 補助者選択初期化です。
     *
     * @param 抄本番号 RString
     * @param 投票年月日 RDate
     */
    public void set補助者選択初期化(RString 抄本番号, RDate 投票年月日) {
        List<HojoshaMaintenanceInfo> hojoshaMaintenanceInfoLst = HojoshaMaintenanceManager.createInstance().select補助者(抄本番号, 投票年月日);
        div.getDgHojoshaList().getDataSource().clear();
        List<dgHojoshaList_Row> rowList = new ArrayList();
        if (hojoshaMaintenanceInfoLst != null) {
            for (HojoshaMaintenanceInfo info : hojoshaMaintenanceInfoLst) {
                dgHojoshaList_Row row = new dgHojoshaList_Row();
                row.setTxtCode(info.getHojoshaMaintenanceEntity().get補助者情報().getShikibetsuCode().getColumnValue());
                AtenaMeisho meiSho = info.getHojoshaMaintenanceEntity().get宛名PSM情報().getMeisho() == null ? AtenaMeisho.EMPTY : info.getHojoshaMaintenanceEntity().get宛名PSM情報().getMeisho();
                RString 名称 = meiSho == null ? RString.EMPTY : meiSho.getColumnValue();
                row.setTxtName(名称);
                row.setTxtTohyojoCode(info.getHojoshaMaintenanceEntity().get補助者情報().getTohyojoCode());
                row.setTxtTohyojoName(info.getHojoshaMaintenanceEntity().get投票所情報().getTohyojoName());
                row.setHidMotoData(new RString(Base64Serializer.serialize(info)));
                HojoshaMaintenanceHandler.of(div).out照会アクセスログ出力(info.getHojoshaMaintenanceEntity().get補助者情報().getShikibetsuCode());
                rowList.add(row);
            }
        }
        div.getDgHojoshaList().setDataSource(rowList);
    }

    /**
     * 補助者詳細コードを追加するの処理
     *
     * @param 抄本番号 RString
     * @param 識別コード RString
     * @return boolean
     */
    public boolean get補助者重複チェック(RString 抄本番号, RString 識別コード) {
        return HojoshaMaintenanceManager.createInstance().select補助者(new ShohonNo(抄本番号), new ShikibetsuCode(識別コード));
    }

    /**
     * コード重複チェック処理
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new HojoshaMaintenanceValidatorHandler(div).validateコード重複();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 補助者詳細コードを追加するの処理
     *
     * @param 識別コード RString
     * @param 投票年月日 RDate
     * @return 存在_フラグ boolean
     */
    public boolean get宛名PSM存在チェック(RString 識別コード, RDate 投票年月日) {
        boolean 存在_フラグ = Boolean.FALSE;
        int count = HojoshaMaintenanceManager.createInstance().select宛名PSM(識別コード, 投票年月日);
        if (count == 0) {
            存在_フラグ = Boolean.TRUE;
        }
        return 存在_フラグ;
    }

    /**
     * コード存在チェック処理
     *
     * @return ResponseData
     */
    public ResponseData checkコード存在チェック() {
        ValidationMessageControlPairs controlErrorPairs = new HojoshaMaintenanceValidatorHandler(div).validateコード存在();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 他ユーザ使用チェック処理
     *
     * @return ResponseData
     */
    public ResponseData check他ユーザ使用チェック() {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlWarningPairs = new HojoshaMaintenanceValidatorHandler(div).validate他ユーザ使用チェック();
            if (controlWarningPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlWarningPairs).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 補助者テーブルの挿入処理
     *
     * @param 抄本番号 RString
     * @param 識別コード RString
     * @param 投票所コード RString
     */
    public void insert補助者(RString 抄本番号, RString 識別コード, RString 投票所コード) {
        HojoshaMaintenanceManager.createInstance().insert補助者(抄本番号, 識別コード, 投票所コード);
    }

    /**
     * 補助者テーブルの更新処理
     *
     * @param 投票補助者info HojoshaMaintenanceInfo
     * @return int
     */
    public int update補助者(HojoshaMaintenanceInfo 投票補助者info) {
        return HojoshaMaintenanceManager.createInstance().update補助者(投票補助者info);
    }

    /**
     * 補助者テーブルの削除処理
     *
     * @param 投票補助者info HojoshaMaintenanceInfo
     * @return int
     */
    public int delete補助者(HojoshaMaintenanceInfo 投票補助者info) {
        return HojoshaMaintenanceManager.createInstance().delete補助者(投票補助者info);
    }

    /**
     * 画面初期化処理。
     *
     */
    public void set画面初期化() {
        div.getCcdShohonNameList().initialize();
        div.getHojoshaSelect().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().setVisible(Boolean.FALSE);
        HojoshaMaintenanceHandler hojoshaMaintenanceHandler = new HojoshaMaintenanceHandler(div);

        RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
        RDate 投票年月日 = div.getCcdShohonNameList().getSelectedTohyoYMD();
        hojoshaMaintenanceHandler.set補助者選択初期化(抄本番号, 投票年月日);
    }

    /**
     * アクセスログです。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void out保存アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
    }

    /**
     * アクセスログです。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void out照会アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
    }

}
