/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6030;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.AFABTE6010BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設宛名シールに対応するHandlerクラスです
 *
 * @reamsid_L AF-0620-010 xul
 */
public class SealShisetsuHandler {

    private static final RString 施設宛名シール = new RString("AFAGME6030");
    private final SealShisetsuDiv div;
    private ShisetsuManager manager;

    /**
     * コンストラクタです。
     *
     * @param div SealShisetsuHandler
     */
    public SealShisetsuHandler(SealShisetsuDiv div) {
        this.div = div;
    }

    /**
     * 施設宛名シールのHandler初期化
     *
     * @param div SealShisetsuDiv
     * @return SealShisetsuHandler
     */
    public static SealShisetsuHandler of(SealShisetsuDiv div) {
        return new SealShisetsuHandler(div);
    }

    /**
     * 実行するボタン押下時チェックです。
     *
     * @return ResponseData
     */
    public ResponseData check入力内容() {
        ValidationMessageControlPairs controlPairs = div.getSealShisetsuParam().getCcdShisetsuCodeRange().関係チェック();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }

        ValidationMessageControlPairs controlErrorPairs = new SealShisetsuValidationHandler(div).validate();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設コードFromの変更イベント。
     *
     * @return ResponseData div
     */
    public ResponseData 施設コードFrom_ChangeEvent() {
        if (!div.getSealShisetsuParam().getCcdShisetsuShubetsu().isコード入力済み()
                && div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードFROM() != null) {
            Code 施設コードFrom = get施設種別キー(div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードFROM());
            if (!施設コードFrom.equals(Code.EMPTY)) {
                div.getSealShisetsuParam().getCcdShisetsuShubetsu().load(AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設コードFrom);
                RString focusID = div.getSealShisetsuParam().getCcdShisetsuShubetsu().getCode().value();
                div.getCcdShisetsuCodeRange().initialize(
                        施設コードFromの入力値設定(div),
                        施設コードToの入力値設定(div),
                        ShisetsuShubetsu.toValue(focusID));
            }
        }
        if (div.getSealShisetsuParam().getCcdShisetsuShubetsu().isコード入力済み()) {
            return check施設コードFrom();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設コードToの変更イベント。
     *
     * @return ResponseData div
     */
    public ResponseData 施設コードTo_ChangeEvent() {
        if (!div.getSealShisetsuParam().getCcdShisetsuShubetsu().isコード入力済み()
                && div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードTO() != null) {
            Code 施設コードTo = get施設種別キー(div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードTO());
            if (!施設コードTo.equals(Code.EMPTY)) {
                div.getSealShisetsuParam().getCcdShisetsuShubetsu().load(AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設コードTo);
                RString focusID = div.getSealShisetsuParam().getCcdShisetsuShubetsu().getCode().value();
                div.getCcdShisetsuCodeRange().initialize(
                        施設コードFromの入力値設定(div),
                        施設コードToの入力値設定(div),
                        ShisetsuShubetsu.toValue(focusID));
            }
        }
        if (div.getSealShisetsuParam().getCcdShisetsuShubetsu().isコード入力済み()) {
            return check施設コードTo();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設コードFrom入力時に施設種別との相関チェックを行います。
     *
     * @return ResponseData div
     */
    private ResponseData check施設コードFrom() {
        return ResponseData.of(div).respond();
    }

    /**
     * 施設コードFrom入力時に施設種別との相関チェックを行います。
     *
     * @return ResponseData div
     */
    private ResponseData check施設コードTo() {
        return ResponseData.of(div).respond();
    }

    /**
     * 実行する時バッチパラメータ設定
     *
     * @return AFABTE6010BatchParameter
     */
    public AFABTE6010BatchParameter setBatchParameter() {
        AFABTE6010BatchParameter parm = new AFABTE6010BatchParameter();

        parm.set起動画面ID(施設宛名シール);
        RString 施設種別コード = div.getSealShisetsuParam().getCcdShisetsuShubetsu().getCode().getColumnValue();
        parm.set施設種別(changeNullToEmpty(施設種別コード));
        RString 施設種別名称 = RString.EMPTY;
        List<KeyValueDataSource> key = CodeMasterHelper.createDataSource(AFACodeShubetsu.施設種別.getCodeShubetsu());
        for (KeyValueDataSource keyValueDataSource : key) {
            if (keyValueDataSource.getKey().equals(施設種別コード)) {
                施設種別名称 = keyValueDataSource.getValue();
            }
        }
        parm.set施設種別名称(changeNullToEmpty(施設種別名称));
        RString 施設コードFROM = div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードFROM();
        parm.set施設コードFROM(changeNullToEmpty(施設コードFROM));
        RString 施設名称FROM = div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設名称From();
        parm.set施設名称FROM(changeNullToEmpty(施設名称FROM));
        RString 施設コードTO = div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードTO();
        parm.set施設コードTO(changeNullToEmpty(施設コードTO));
        RString 施設名称TO = div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設名称To();
        parm.set施設名称TO(changeNullToEmpty(施設名称TO));
        RString 四隅項目コード1 = div.getSealShisetsuParam().getCcdSealLayout().getDdlRightUp().getSelectedKey();
        parm.set四隅項目コード_右上隅(changeNullToEmpty(四隅項目コード1));
        RString 四隅項目1 = div.getSealShisetsuParam().getCcdSealLayout().getDdlRightUp().getSelectedValue();
        parm.set四隅項目_右上隅(changeNullToEmpty(四隅項目1));
        RString 住所コード = div.getSealShisetsuParam().getCcdSealLayout().getDdlJusho().getSelectedKey();
        parm.set住所コード(changeNullToEmpty(住所コード));
        RString 住所名称 = div.getSealShisetsuParam().getCcdSealLayout().getDdlJusho().getSelectedValue();
        parm.set住所コード名称(changeNullToEmpty(住所名称));
        RString 住所表示1 = div.getSealShisetsuParam().getCcdSealLayout().getTxtJusho1().getValue();
        RString 住所表示2 = div.getSealShisetsuParam().getCcdSealLayout().getTxtJusho2().getValue();
        RString 住所表示3 = div.getSealShisetsuParam().getCcdSealLayout().getTxtJusho3().getValue();
        RString 住所表示 = changeNullToEmpty(住所表示1).concat(changeNullToEmpty(住所表示2)).concat(changeNullToEmpty(住所表示3));
        parm.set住所表示(住所表示);
        RString 宛名コード = div.getSealShisetsuParam().getCcdSealLayout().getDdlAtena().getSelectedKey();
        parm.set宛名コード(changeNullToEmpty(宛名コード));
        RString 宛名名称 = div.getSealShisetsuParam().getCcdSealLayout().getDdlAtena().getSelectedValue();
        parm.set宛名コード名称(changeNullToEmpty(宛名名称));
        RString 名称1 = div.getSealShisetsuParam().getCcdSealLayout().getTxtAtena1().getValue();
        RString 名称2 = div.getSealShisetsuParam().getCcdSealLayout().getTxtAtena2().getValue();
        parm.set名称_上段(changeNullToEmpty(名称1));
        parm.set名称_下段(changeNullToEmpty(名称2));
        RString 世帯主コード = div.getSealShisetsuParam().getCcdSealLayout().getDdlKeisho1().getSelectedKey();
        parm.set世帯主敬称コード(changeNullToEmpty(世帯主コード));
        RString 世帯主敬称 = div.getSealShisetsuParam().getCcdSealLayout().getDdlKeisho1().getSelectedValue();
        parm.set世帯主敬称(changeNullToEmpty(世帯主敬称));
        RString 本人コード = div.getSealShisetsuParam().getCcdSealLayout().getDdlKeisho2().getSelectedKey();
        parm.set本人敬称コード(changeNullToEmpty(本人コード));
        RString 本人敬称 = div.getSealShisetsuParam().getCcdSealLayout().getDdlKeisho2().getSelectedValue();
        parm.set本人敬称(changeNullToEmpty(本人敬称));
        RString 四隅項目コード2 = div.getSealShisetsuParam().getCcdSealLayout().getDdlLeftDown().getSelectedKey();
        parm.set四隅項目コード_左下隅(changeNullToEmpty(四隅項目コード2));
        RString 四隅項目2 = div.getSealShisetsuParam().getCcdSealLayout().getDdlLeftDown().getSelectedValue();
        parm.set四隅項目_左下隅(changeNullToEmpty(四隅項目2));
        RString 四隅項目コード3 = div.getSealShisetsuParam().getCcdSealLayout().getDdlRightDown().getSelectedKey();
        parm.set四隅項目コード_右下隅(changeNullToEmpty(四隅項目コード3));
        RString 四隅項目3 = div.getSealShisetsuParam().getCcdSealLayout().getDdlRightDown().getSelectedValue();
        parm.set四隅項目_右下隅(changeNullToEmpty(四隅項目3));
        RString 開始印字位置番号 = ((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue();
        parm.set開始印字位置番号(changeNullToEmpty(開始印字位置番号));

        return parm;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    /**
     * 施設コードに対する施設種別を返送します。 *
     *
     * @param 施設コード RString
     * @return 施設種別 Code
     */
    public Code get施設種別キー(RString 施設コード) {
        manager = InstanceProvider.create(ShisetsuManager.class);
        Shisetsu 施設 = manager.get施設By施設コード(施設コード);
        return 施設 == null ? Code.EMPTY : 施設.get施設種別();
    }

    private RString 施設コードToの入力値設定(SealShisetsuDiv div) {
        return div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードTO() == null
                ? RString.EMPTY
                : div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードTO();
    }

    private RString 施設コードFromの入力値設定(SealShisetsuDiv div) {
        return div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードFROM() == null
                ? RString.EMPTY
                : div.getSealShisetsuParam().getCcdShisetsuCodeRange().get施設コードFROM();
    }
}
