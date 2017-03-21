/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMK1010;

import jp.co.ndensan.reams.af.afa.business.core.shohon.kaikusenkyo.KaikuSenkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.batchprm.meibosakuseikaiku.AFABTK101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010.KaikuMeiboSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1010.KaikuMeiboSakuseiValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohon.kaikusenkyo.KaikuSenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMK1010 海区漁業調整委員会委員選挙選挙人名簿作成 <br />
 * KaikuMeiboSakuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuMeiboSakusei {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.海区漁業調整委員会委員選挙;
    private static final RString 新規登録 = new RString("1");
    private static final RString 画面起動チェック_処理可能な = new RString("処理可能な");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KaikuMeiboSakuseiDiv
     * @return ResponseData<KaikuMeiboSakuseiDiv>
     */
    public ResponseData<KaikuMeiboSakuseiDiv> onLoad(KaikuMeiboSakuseiDiv mainPanel) {
        RString menuID = ResponseHolder.getMenuID();
        ViewState.setメニューID(menuID);

        KaikuMeiboKoshinKijun.load(mainPanel.getKaikuMeiboKoshinKijun(), SENKYO_SHURUI);
        mainPanel.getKaikuMeiboKoshinKijun().getCcdShohonNameList().initialize(SENKYO_SHURUI);
        mainPanel.getCcdKaikuMeiboKaikuSakuseiChohyo().initialize();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 新規処理と再処理のラジオボタンchange時のイベントメソッドです。
     *
     * @param div KaikuMeiboSakuseiDiv
     * @return ResponseData<KaikuMeiboSakuseiDiv>
     */
    public ResponseData<KaikuMeiboSakuseiDiv> onChange_radShori(KaikuMeiboSakuseiDiv div) {
        div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.FALSE);

        clearThisPanel(div);
        if (div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()
                && !ResponseHolder.isReRequest()) {
            div.getKaikuMeiboKoshinKijun().getRadShori().setSelectedKey(新規登録);
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                    .replace(画面起動チェック_処理可能な.toString())).respond();
        }
        div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().setReadOnlyMode(Boolean.FALSE);
        if (div.getKaikuMeiboKoshinKijun().getRadShori().getSelectedKey().equals(新規登録)) {
            div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().setDisabled(true);
            div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
        } else {
            div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().setDisabled(false);
            div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
            set選択抄本情報(div);
        }
        return ResponseData.of(div).respond();
    }

    private void clearThisPanel(KaikuMeiboSakuseiDiv div) {
        div.getKaikuMeiboKoshinKijun().getRadSakuseiKijun().setSelectedKey(new RString("0"));
        div.getKaikuMeiboKoshinKijun().getTxtShohonName().clearValue();
        div.getKaikuMeiboKoshinKijun().getTxtKijunYMD().clearValue();
        div.getKaikuMeiboKoshinKijun().getTxtKakuteiYMD().clearValue();
        div.getKaikuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().clearValue();
        div.getCcdKaikuMeiboKaikuSakuseiChohyo().get海区作成帳票情報().
                getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().clearValue();
    }

    private void set選択抄本情報(KaikuMeiboSakuseiDiv div) throws IllegalArgumentException {

        RString 抄本番号 = changeNullToEmpty(div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().getSelectedKey());
        div.getKaikuMeiboKoshinKijun().getTxtShohonName().setValue(changeNullToEmpty(div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getSelectedShohonName()));
        div.getKaikuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().setValue(div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getSelectedKiteiNenreiTotatsuYMD());
        SenkyoManager senkyoManager = new SenkyoManager();
        KaikuSenkyoManager kaikusenkyoManager = new KaikuSenkyoManager();

        Senkyo senkyo = senkyoManager.get選挙(new ShohonNo(抄本番号), new SenkyoNo(new RString("1")));
        KaikuSenkyo kaikuSenkyo = kaikusenkyoManager.get名簿確定年月日By抄本番号(new ShohonNo(抄本番号));
        FlexibleDate kijunYMD = null;
        FlexibleDate 名簿確定年月日 = null;
        if (null != senkyo) {
            kijunYMD = senkyo.get名簿基準年月日();
        }
        if (null != kaikuSenkyo) {
            名簿確定年月日 = kaikuSenkyo.get名簿確定年月日();
        }
        if (null != kijunYMD) {
            div.getKaikuMeiboKoshinKijun().getTxtKijunYMD().setValue(new RDate(kijunYMD.toString()));
            div.getCcdKaikuMeiboKaikuSakuseiChohyo().set時点日(new RDate(kijunYMD.toString()));
        }

        if (null != 名簿確定年月日) {
            div.getKaikuMeiboKoshinKijun().getTxtKakuteiYMD().setValue(new RDate(名簿確定年月日.toString()));
        }

    }

    private RString changeNullToEmpty(RString 文字列) {
        return null == 文字列 ? RString.EMPTY : 文字列;
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div KaikuMeiboSakuseiDiv
     * @return ResponseData<KaikuMeiboSakuseiDiv>
     */
    public ResponseData<KaikuMeiboSakuseiDiv> onChange_ccdShohonNameList(KaikuMeiboSakuseiDiv div) {
        div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().changeDdlShohon();
        RString selectedKey = div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().getSelectedKey();
        if (selectedKey.equals(RString.EMPTY)) {
            clearThisPanel(div);

        } else {
            set選択抄本情報(div);
        }
        div.getCcdKaikuMeiboKaikuSakuseiChohyo().set時点日(div.getKaikuMeiboKoshinKijun().getTxtKijunYMD().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * グリッド選択時のイベントメソッドです。
     *
     * @param div KaikuMeiboSakuseiDiv
     * @return ResponseData<KaikuMeiboSakuseiDiv>
     */
    public ResponseData<KaikuMeiboSakuseiDiv> onBeforeOpenDialog_btnBatchExecute(KaikuMeiboSakuseiDiv div) {
        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KaikuMeiboSakuseiValidationHandler getValidatorHandler(KaikuMeiboSakuseiDiv div) {
        return KaikuMeiboSakuseiValidationHandler.of(div);
    }

    /**
     * 実行する時バッチパラメータ設定
     *
     * @param div KaikuMeiboSakuseiDiv
     * @return AFABTK101BatchParameter
     */
    public ResponseData<AFABTK101BatchParameter> setBatchParameter(KaikuMeiboSakuseiDiv div) {
        AFABTK101BatchParameter param = new AFABTK101BatchParameter();
        param.set処理種別(div.getKaikuMeiboKoshinKijun().getRadShori().getSelectedKey());
        param.set作成方法(div.getKaikuMeiboKoshinKijun().getRadSakuseiKijun().getSelectedKey());
        param.set抄本番号(div.getKaikuMeiboKoshinKijun().getCcdShohonNameList().getSelectedShohonNo());
        param.set抄本名(div.getKaikuMeiboKoshinKijun().getTxtShohonName().getValue());
        param.set基準日(new FlexibleDate(div.getKaikuMeiboKoshinKijun().getTxtKijunYMD().getValue().toString()));
        param.set名簿確定日(new FlexibleDate(div.getKaikuMeiboKoshinKijun().getTxtKakuteiYMD().getValue().toString()));
        param.set年齢到達日(new FlexibleDate(div.getKaikuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().getValue().toString()));
        param.set選挙人名簿抄本出力有無(div.getCcdKaikuMeiboKaikuSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoMeiboShohon().isIsPublish());

        param.set登録者数リスト出力有無(div.getCcdKaikuMeiboKaikuSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoTorokushasuList().isIsPublish());
        if (param.is登録者数リスト出力有無()) {
            param.set時点日(new FlexibleDate(div.getCcdKaikuMeiboKaikuSakuseiChohyo().get海区作成帳票情報().
                    getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue().toString()));
        }

        return ResponseData.of(param).respond();
    }

}
