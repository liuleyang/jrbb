package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMH1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.seikyushatoroku.SeikyushaTorokuGamenData;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyushaTorokuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuNaiyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.dgSeikyushaTorokuDaihyoshaIchiran_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.dgSeikyushaTorokuSeikyuIchiran_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.AFAGMH1020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010.SeikyushaTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010.SeikyushaTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.seikyushatoroku.SeikyushaTorokuManager;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRH101.SeikyuDaihyoshaShomeishoPrintService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 請求代表者証明書交付
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyushaToroku {

    /**
     * 初期化イベントです。
     *
     * @param div SeikyushaTorokuDiv
     * @return SeikyushaTorokuDiv
     */
    public ResponseData<SeikyushaTorokuDiv> onLoad(SeikyushaTorokuDiv div) {

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMH1020TransitionEventName.作成).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ViewState.setメニューID(ResponseHolder.getMenuID());
            List<dgSeikyushaTorokuSeikyuIchiran_Row> rowList = getHandler(div).get一覧データ();
            if (!rowList.isEmpty()) {
                div.getDgSeikyushaTorokuSeikyuIchiran().setDataSource(rowList);
            } else {
                div.getDgSeikyushaTorokuSeikyuIchiran().getDataSource().clear();
            }
            div.getSeikyushaTorokuDaihyosha().setDisplayNone(true);
            div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 直接請求一覧の「直接請求を登録する」ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onlick_BtnAdd(SeikyushaTorokuDiv div) {

        ViewStateHolder.put(ViewStateKeys.ボタン区分, SeikyushaTorokuEnum.追加.getValue());
        getHandler(div).set初期化以外状態();
        getHandler(div).get画面制御(SeikyushaTorokuEnum.新規制御.getValue());
        div.getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource().clear();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD().setValue(RDate.getNowDate());
        getHandler(div).get交付組織リスト();

        return ResponseData.of(div).respond();
    }

    /**
     * 直接請求一覧.修正ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onSelectByModifyBtn(SeikyushaTorokuDiv div) {

        ViewStateHolder.put(ViewStateKeys.ボタン区分, SeikyushaTorokuEnum.修正.getValue());
        getHandler(div).set初期化以外状態();
        getHandler(div).get画面制御(SeikyushaTorokuEnum.修正制御.getValue());
        dgSeikyushaTorokuSeikyuIchiran_Row row = div.getDgSeikyushaTorokuSeikyuIchiran().getClickedItem();
        div.setTxtHdnSeikyuNo(row.getTxtSeikyuNo());
        div.setTxtHdnShoHonNo(row.getTxtShohonNo());
        getHandler(div).set請求内容入力();
        return ResponseData.of(div).respond();
    }

    /**
     * 直接請求一覧.削除ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onSelectByDelectBtn(SeikyushaTorokuDiv div) {

        ViewStateHolder.put(ViewStateKeys.ボタン区分, SeikyushaTorokuEnum.削除.getValue());
        getHandler(div).set初期化以外状態();
        getHandler(div).get画面制御(SeikyushaTorokuEnum.削除制御.getValue());
        dgSeikyushaTorokuSeikyuIchiran_Row row = div.getDgSeikyushaTorokuSeikyuIchiran().getClickedItem();
        div.setTxtHdnSeikyuNo(row.getTxtSeikyuNo());
        div.setTxtHdnShoHonNo(row.getTxtShohonNo());
        getHandler(div).set請求内容入力();
        div.getSeikyushaTorokuDaihyosha().getBtnSearchSimple().setDisabled(Boolean.TRUE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD().setDisabled(Boolean.TRUE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName().setDisabled(Boolean.TRUE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuNaiyo().setDisabled(Boolean.TRUE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().setDisabled(Boolean.TRUE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD().setDisabled(Boolean.TRUE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki().setDisabled(Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 住民を検索するボタン押下時BeforeOpenDialogのイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<LabelSealRePrintDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onBeforeOpenDialog_btnSearchSimple(SeikyushaTorokuDiv div) {

        div.setTxtHdnKey_Dialog(SeikyushaTorokuEnum.ONE.getValue());
        div.setTxtHdnKey_GyomuCode(SeikyushaTorokuEnum.業務種類.getValue());
        div.setTxtHdnKey_SearchYusenKubun(SeikyushaTorokuEnum.住登内優先.getValue());
        div.setTxtHdnKey_AgeArrivalDay(SeikyushaTorokuEnum.前日.getValue());
        div.setTxtHdnKey_KojinNoHyoji(SeikyushaTorokuEnum.表示しない.getValue());
        div.setTxtHdnKey_HojinNoHyoji(SeikyushaTorokuEnum.表示しない.getValue());
        div.setTxtHdnKey_SeinengappiHyoji(SeikyushaTorokuEnum.基本エリアに表示する.getValue());
        div.setTxtHdnKey_SeibetsuHyoji(SeikyushaTorokuEnum.基本エリアに表示する.getValue());
        div.setTxtHdnKey_HojinkeitaiHyoji(SeikyushaTorokuEnum.表示しない.getValue());
        div.setTxtHdnKey_ZairyuCardHyoji(SeikyushaTorokuEnum.表示しない.getValue());
        div.setTxtHdnKey_ButtonAddNewHyoji(SeikyushaTorokuEnum.表示しない.getValue());
        div.setTxtHdnKey_JuminShubetsuMode(SeikyushaTorokuEnum.個人のみ.getValue());
        div.setTxtHdnKey_JuminJotaiDefault(SeikyushaTorokuEnum.住民.getValue());
        div.setTxtHdnKey_RadNihonjinDefault(SeikyushaTorokuEnum.含む.getValue());
        div.setTxtHdnKey_RadGaikokujinDefault(SeikyushaTorokuEnum.含まない.getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 「住民を検索する」ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onOkClose_BtnSearchSimple(SeikyushaTorokuDiv div) {

        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTxtHdnKey_OutShikibetsuCode());

        List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowlist = div.getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource();
        getHandler(div).get請求代表者一覧(識別コード, rowlist);
        div.getDgSeikyushaTorokuDaihyoshaIchiran().setDataSource(rowlist);

        return ResponseData.of(div).respond();
    }

    /**
     * 請求代表者一覧.削除ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onClick_DeleteRows(SeikyushaTorokuDiv div) {

        div.getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource().remove(div.getDgSeikyushaTorokuDaihyoshaIchiran().getClickedRowId());
        return ResponseData.of(div).respond();
    }

    /**
     * 交付組織ドロップダウンリスト選択イベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onChange_DdlKofuSoshiki(SeikyushaTorokuDiv div) {

        RString 交付コード = div.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki().getSelectedKey();
        getHandler(div).get交付者名(交付コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 請求内容入力の「直接請求の登録（修正、削除）をやめる」ボタンクリックイベントのメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onClick_BtnStop(SeikyushaTorokuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            SeikyushaTorokuNaiyoNyuryokuDiv 入力画面情報 = div.getSeikyushaTorokuNaiyoNyuryoku();
            RString ボタン区分 = ViewStateHolder.get(ViewStateKeys.ボタン区分, RString.class);
            boolean is変更 = false;
            if (SeikyushaTorokuEnum.追加.getValue().equals(ボタン区分)) {
                is変更 = is新規変更(入力画面情報);
            } else if (SeikyushaTorokuEnum.修正.getValue().equals(ボタン区分)) {
                SeikyushaTorokuGamenData 検索結果 = SeikyushaTorokuManager.createInstance()
                        .get直接請求データ(Integer.valueOf(div.getTxtHdnSeikyuNo().toString()));
                is変更 = is修正変更(検索結果, 入力画面情報);
            } else if (SeikyushaTorokuEnum.削除.getValue().equals(ボタン区分)) {
                is変更 = false;
            }

            if (is変更) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            } else {
                getHandler(div).set初期化状態();
                clear請求内容入力(div);
                return ResponseData.of(div).respond();
            }
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        clear請求内容入力(div);
        getHandler(div).set初期化状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 請求内容入力の「追加・保存・削除」ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyushaTorokuDiv> onClick_BtnAddNew(SeikyushaTorokuDiv div) {

        RString ボタン区分 = ViewStateHolder.get(ViewStateKeys.ボタン区分, RString.class);
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = new ValidationMessageControlPairs();
            if (SeikyushaTorokuEnum.追加.getValue().equals(ボタン区分)
                    || SeikyushaTorokuEnum.修正.getValue().equals(ボタン区分)) {
                controlPairs = SeikyushaTorokuValidationHandler.of(div).validate();
            }

            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            if (SeikyushaTorokuEnum.追加.getValue().equals(ボタン区分)) {
                return ResponseData.of(div).addMessage(AfQuestionMessages.保存の確認.getMessage()).respond();
            }

            if (SeikyushaTorokuEnum.修正.getValue().equals(ボタン区分)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }

            if (SeikyushaTorokuEnum.削除.getValue().equals(ボタン区分)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        if (SeikyushaTorokuEnum.追加.getValue().equals(ボタン区分)) {
            onClick_追加(div);
        }

        if (SeikyushaTorokuEnum.修正.getValue().equals(ボタン区分)) {
            onClick_修正(div);
        }

        if (SeikyushaTorokuEnum.削除.getValue().equals(ボタン区分)) {
            onClick_削除(div);
        }

        return ResponseData.of(div).respond();
    }

    private boolean is新規変更(SeikyushaTorokuNaiyoNyuryokuDiv 入力画面情報) {
        return null == 入力画面情報.getTxtSeikyuYMD()
                || !入力画面情報.getTxtSeikyuYMD().getText().equals(RDate.getNowDate().toDateString())
                || (null != 入力画面情報.getTxtSeikyuName()
                && !入力画面情報.getTxtSeikyuName().getText().isEmpty())
                || (null != 入力画面情報.getTxtSeikyuNaiyo()
                && !入力画面情報.getTxtSeikyuNaiyo().getText().isEmpty())
                || (null != 入力画面情報.getTxtKofuYMD()
                && !入力画面情報.getTxtKofuYMD().getText().isEmpty())
                || (null != 入力画面情報.getTxtTeishutsuKigenYMD()
                && !入力画面情報.getTxtTeishutsuKigenYMD().getText().isEmpty())
                || 入力画面情報.getDdlKofuSoshiki().getSelectedIndex() != 0;
    }

    private boolean is修正変更(SeikyushaTorokuGamenData 直接請求データ, SeikyushaTorokuNaiyoNyuryokuDiv 入力画面情報) {
        return null == 入力画面情報.getTxtSeikyuYMD()
                || !入力画面情報.getTxtSeikyuYMD().getText().equals(new RString(直接請求データ.getSeikyuYMD().toString()))
                || null == 入力画面情報.getTxtSeikyuName()
                || !入力画面情報.getTxtSeikyuName().getText().equals(直接請求データ.getSeikyuMei())
                || null == 入力画面情報.getTxtSeikyuNaiyo()
                || !入力画面情報.getTxtSeikyuNaiyo().getText().equals(直接請求データ.getSeikyuNaiyo())
                || null == 入力画面情報.getTxtKofuYMD()
                || !入力画面情報.getTxtKofuYMD().getText().equals(new RString(直接請求データ.getKofuYMD().toString()))
                || null == 入力画面情報.getTxtTeishutsuKigenYMD()
                || !入力画面情報.getTxtTeishutsuKigenYMD().getText().equals(new RString(直接請求データ.getTeishutsuKigenYMD().toString()))
                || null == 入力画面情報.getDdlKofuSoshiki().getSelectedValue()
                || !入力画面情報.getDdlKofuSoshiki().getSelectedKey().equals(直接請求データ.getKofuSoshikiCode().value());
    }

    private ResponseData<SeikyushaTorokuDiv> onClick_追加(SeikyushaTorokuDiv div) {

        SeikyushaTorokuManager manager = SeikyushaTorokuManager.createInstance();
        boolean saveFlg = manager.save直接請求データ(getHandler(div).set直接請求データ());
        if (saveFlg) {
            if (SeikyushaTorokuEnum.証明書発行有無_請求代表者.getValue().equals(
                    BusinessConfig.get(ConfigKeysAFA.証明書発行有無_請求代表者, SubGyomuCode.AFA選挙本体))) {
                SeikyuDaihyoshaShomeishoPrintService printer = InstanceProvider.create(SeikyuDaihyoshaShomeishoPrintService.class);
                printer.print(getHandler(div).print請求代表者証明書());
            }
            List<dgSeikyushaTorokuSeikyuIchiran_Row> rowList = getHandler(div).get一覧データ();
            if (!rowList.isEmpty()) {
                div.getDgSeikyushaTorokuSeikyuIchiran().setDataSource(rowList);
            } else {
                div.getDgSeikyushaTorokuSeikyuIchiran().getDataSource().clear();
            }
            getHandler(div).set初期化状態();
        }

        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyushaTorokuDiv> onClick_修正(SeikyushaTorokuDiv div) {

        SeikyushaTorokuManager manager = SeikyushaTorokuManager.createInstance();
        boolean saveFlg = manager.save直接請求データ(getHandler(div).set修正後直接請求データ());
        if (saveFlg) {
            if (SeikyushaTorokuEnum.証明書発行有無_請求代表者.getValue().equals(
                    BusinessConfig.get(ConfigKeysAFA.証明書発行有無_請求代表者, SubGyomuCode.AFA選挙本体))) {
                SeikyuDaihyoshaShomeishoPrintService printer = InstanceProvider.create(SeikyuDaihyoshaShomeishoPrintService.class);
                printer.print(getHandler(div).print請求代表者証明書());
            }
            List<dgSeikyushaTorokuSeikyuIchiran_Row> rowList = getHandler(div).get一覧データ();
            if (!rowList.isEmpty()) {
                div.getDgSeikyushaTorokuSeikyuIchiran().setDataSource(rowList);
            } else {
                div.getDgSeikyushaTorokuSeikyuIchiran().getDataSource().clear();
            }
            getHandler(div).set初期化状態();
        }

        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyushaTorokuDiv> onClick_削除(SeikyushaTorokuDiv div) {

        SeikyushaTorokuManager manager = SeikyushaTorokuManager.createInstance();
        SeikyushaTorokuGamenData gamenData = Base64Serializer.deSerialize(
                div.getHidMotoData().toString(), SeikyushaTorokuGamenData.class);
        gamenData.setState(EntityDataState.Deleted);
        boolean saveFlg = manager.delect直接請求データ(gamenData);
        if (saveFlg) {
            List<dgSeikyushaTorokuSeikyuIchiran_Row> rowList = getHandler(div).get一覧データ();
            if (!rowList.isEmpty()) {
                div.getDgSeikyushaTorokuSeikyuIchiran().setDataSource(rowList);
            } else {
                div.getDgSeikyushaTorokuSeikyuIchiran().getDataSource().clear();
            }
            getHandler(div).set初期化状態();
        }

        return ResponseData.of(div).respond();
    }

    private SeikyushaTorokuHandler getHandler(SeikyushaTorokuDiv div) {
        return new SeikyushaTorokuHandler(div);
    }

    private void clear請求内容入力(SeikyushaTorokuDiv div) {
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuNaiyo().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD().clearValue();
        div.getSeikyushaTorokuDaihyosha().getBtnSearchSimple().setDisabled(Boolean.FALSE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD().setDisabled(Boolean.FALSE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName().setDisabled(Boolean.FALSE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuNaiyo().setDisabled(Boolean.FALSE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().setDisabled(Boolean.FALSE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD().setDisabled(Boolean.FALSE);
        div.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki().setDisabled(Boolean.FALSE);
    }
}
