/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME6020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.AFABTE6010BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020.AFAGME6020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020.SealTenshutsushaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6020.SealTenshutsushaValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME6020 転出者宛名シール
 *
 * @reamsid_L AF-0620-011 lis2
 */
public class SealTenshutsusha {

    private static final RString メニュー_ID = new RString("AFAMNE6020");
    private static final RString 転出者宛名シール = new RString("AFAGME6020");
    private static final RString 位置指定区分の表示有無 = new RString("FALSE");
    private static final RString 位置指定区分 = new RString("2");
    private static final RString 印字開始位置 = new RString("1");
    private static final RString 画面起動チェック_処理可能な = new RString("処理可能な");
    private static final int 月_4ヶ = 4;
    private static List<FlexibleDate> 名簿基準年月日list;
    private static List<RString> 選挙番号list;
    private static List<RString> 選挙レベルlist;

    /**
     * 初期化イベントです。
     *
     * @param div SealTenshutsushaDiv
     * @return SealTenshutsushaDiv
     */
    public ResponseData<SealTenshutsushaDiv> onLoad(SealTenshutsushaDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGME6020TransitionEventName.メニューへ戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ViewState.setメニューID(メニュー_ID);
            div.getCcdShohonNameList().initialize();
            if (div.getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(画面起動チェック_処理可能な.toString())).respond();
            }
            div.getCcdSealLayout().initialize();
            RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
            edit対象選挙(抄本番号, div);

            div.getCcdSealPosition().initialize();
            RString 宛名シール_面数 = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
            div.getCcdSealPosition().load(位置指定区分の表示有無, 位置指定区分, new ArrayList<RString>(),
                    印字開始位置, 宛名シール_面数);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div SealTenshutsushaDiv
     * @return ResponseData<SealTenshutsushaDiv>
     */
    public ResponseData<SealTenshutsushaDiv> onChange_ccdShohonNameList(SealTenshutsushaDiv div) {
        div.getCcdShohonNameList().changeDdlShohon();
        RString 抄本番号 = div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey();
        clean対象選挙(div);
        edit対象選挙(抄本番号, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象選挙を設定時のイベントメソッドです。
     *
     * @param div SealTenshutsushaDiv
     * @return ResponseData<SealTenshutsushaDiv>
     */
    public ResponseData<SealTenshutsushaDiv> onChange_radSenkyo(SealTenshutsushaDiv div) {
        int 対象選挙key = 1;
        if (null != div.getRadSenkyo().getSelectedKey()) {
            対象選挙key = Integer.parseInt(div.getRadSenkyo().getSelectedKey().toString());
        }

        div.getTxtTaishoKikan().setFromValue(null);
        div.getTxtTaishoKikan().setToValue(null);
        FlexibleDate 名簿基準年月日 = 名簿基準年月日list.get(対象選挙key - 1);
        if (!名簿基準年月日.isEmpty()) {
            edit対象期間(名簿基準年月日, div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ実行前のイベントメソッドです。
     *
     * @param div SealTenshutsushaDiv
     * @return ResponseData<SealTenshutsushaDiv>
     */
    public ResponseData<SealTenshutsushaDiv> onBeforeOpenDialog_btnBatchExecute(SealTenshutsushaDiv div) {
        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private SealTenshutsushaValidationHandler getValidatorHandler(SealTenshutsushaDiv div) {
        return SealTenshutsushaValidationHandler.of(div);
    }

    /**
     * 実行する時バッチパラメータ設定
     *
     * @param div SealTenshutsushaDiv
     * @return AFABTE6010BatchParameter
     */
    public ResponseData<AFABTE6010BatchParameter> setBatchParameter(SealTenshutsushaDiv div) {
        AFABTE6010BatchParameter param = new AFABTE6010BatchParameter();
        RString 開始印字位置番号 = ((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue();
        RString 住所表示1 = changeNullToEmpty(div.getCcdSealLayout().getTxtJusho1().getText());
        RString 住所表示2 = changeNullToEmpty(div.getCcdSealLayout().getTxtJusho2().getText());
        RString 住所表示3 = changeNullToEmpty(div.getCcdSealLayout().getTxtJusho3().getText());
        param.set起動画面ID(転出者宛名シール);
        param.set抄本番号(div.getCcdShohonNameList().getSelectedShohonNo());
        param.set抄本名(div.getCcdShohonNameList().getSelectedShohonName());
        param.set選挙レベル(選挙レベルlist.get(div.getRadSenkyo().getSelectedIndex()));
        param.set対象選挙(選挙番号list.get(div.getRadSenkyo().getSelectedIndex()));
        param.set対象選挙名称(div.getRadSenkyo().getSelectedValue());
        param.set対象期間FROM(div.getTxtTaishoKikan().getFromValue());
        param.set対象期間TO(div.getTxtTaishoKikan().getToValue());

        param.set四隅項目コード_右上隅(div.getCcdSealLayout().getDdlRightUp().getSelectedKey());
        param.set住所コード(RString.EMPTY);
        param.set住所コード名称(RString.EMPTY);
        param.set住所表示(住所表示1.concat(住所表示2).concat(住所表示3));
        param.set宛名コード(RString.EMPTY);
        param.set宛名コード名称(RString.EMPTY);
        param.set世帯主敬称コード(RString.EMPTY);
        param.set世帯主敬称(RString.EMPTY);
        param.set名称_上段(div.getCcdSealLayout().getTxtAtena1().getText());
        param.set名称_下段(div.getCcdSealLayout().getTxtAtena2().getText());
        param.set本人敬称コード(div.getCcdSealLayout().getDdlKeisho2().getSelectedKey());
        param.set本人敬称(div.getCcdSealLayout().getDdlKeisho2().getSelectedValue());
        param.set開始印字位置番号(開始印字位置番号);
        param.set四隅項目コード_左下隅(div.getCcdSealLayout().getDdlLeftDown().getSelectedKey());
        param.set四隅項目_左下隅(div.getCcdSealLayout().getDdlLeftDown().getSelectedValue());
        param.set四隅項目コード_右下隅(div.getCcdSealLayout().getDdlRightDown().getSelectedKey());
        param.set四隅項目_右下隅(div.getCcdSealLayout().getDdlRightDown().getSelectedValue());
        return ResponseData.of(param).respond();
    }

    private void edit対象選挙(RString 抄本番号, SealTenshutsushaDiv div) {
        SenkyoManager senkyoManager = new SenkyoManager();
        List<Senkyo> list = senkyoManager.get選挙By抄本番号(new ShohonNo(抄本番号));
        List<KeyValueDataSource> keyList = new ArrayList<>();
        名簿基準年月日list = new ArrayList<>();
        選挙番号list = new ArrayList<>();
        選挙レベルlist = new ArrayList<>();
        if (!list.isEmpty()) {
            int i = 1;
            for (Senkyo senkyo : list) {
                keyList.add(new KeyValueDataSource(new RString(i), senkyo.get選挙略称()));
                名簿基準年月日list.add(senkyo.get名簿基準年月日());
                if (senkyo.get選挙番号() != null) {
                    選挙番号list.add(new RString(senkyo.get選挙番号().getColumnValue()));
                }
                選挙レベルlist.add(new RString(senkyo.get選挙レベル().toString()));
                i++;
            }
            div.getRadSenkyo().setDataSource(keyList);
            div.getRadSenkyo().setSelectedKey(new RString("1"));
            if (!list.get(0).get名簿基準年月日().isEmpty()) {
                FlexibleDate 名簿基準年月日 = list.get(0).get名簿基準年月日();
                edit対象期間(名簿基準年月日, div);
            }
        }
    }

    private void edit対象期間(FlexibleDate 名簿基準年月日, SealTenshutsushaDiv div) {
        div.getTxtTaishoKikan().setFromValue(new RDate(名簿基準年月日.minusMonth(月_4ヶ).toString()));
        div.getTxtTaishoKikan().setToValue(new RDate(名簿基準年月日.toString()));
    }

    private void clean対象選挙(SealTenshutsushaDiv div) {
        div.getTxtTaishoKikan().setFromValue(null);
        div.getTxtTaishoKikan().setToValue(null);
        div.getRadSenkyo().setSelectedIndex(0);
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
