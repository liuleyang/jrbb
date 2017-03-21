/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaSeniKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaViewStateHolderKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuIdoShikakuIdoShoriEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060.AFAGMK1060TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriValidatorHandler;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.kaikuidoshikakuidoshori.KaikuIdoShikakuIdoShoriFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 * KaikuIdoShikakuIdoShoriDivに対応するコントローラです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuIdoShikakuIdoShori {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KaikuIdoShikakuIdoShoriDiv
     * @return ResponseData<KaikuIdoShikakuIdoShoriDiv>
     */
    public ResponseData<KaikuIdoShikakuIdoShoriDiv> onLoad(KaikuIdoShikakuIdoShoriDiv div) {
        RString rootTitle = RString.EMPTY;
        if (!ResponseHolder.isReRequest()) {
            RString 識別コード = ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class);
            RString menuID = ResponseHolder.getMenuID();
            div.getCcdKaikuIdoKojinJoho().initialize(new ShikibetsuCode(識別コード));
            out初期化アクセスログ出力(new ShikibetsuCode(識別コード));
            if (menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())) {
                ViewStateHolder.put(AfaViewStateHolderKey.遷移元画面Key, AFAMenuId.AFAMNK1060_選挙人名簿登録);
            } else if (menuID.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId())) {
                ViewStateHolder.put(AfaViewStateHolderKey.遷移元画面Key, AFAMenuId.AFAMNK1080_選挙人名簿削除);
            } else if (menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())) {
                ViewStateHolder.put(AfaViewStateHolderKey.遷移元画面Key, AFAMenuId.AFAMNK1070_選挙人名簿修正);
            }
            div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().initialize(new ShikibetsuCode(識別コード));
            div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().initialize(SenkyoShurui.海区漁業調整委員会委員選挙, new ShikibetsuCode(識別コード));
            if (menuID.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId())) {
                div.getCcdKaikuIdoKojinJoho().setDisabled(true);
                div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().setDisabled(true);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(KaikuIdoShikakuIdoShoriEnum.削除する.getValue(), false);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(KaikuIdoShikakuIdoShoriEnum.保存する.getValue(), true);

            } else {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(KaikuIdoShikakuIdoShoriEnum.削除する.getValue(), true);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(KaikuIdoShikakuIdoShoriEnum.保存する.getValue(), false);
            }

            if (AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId().equals(ResponseHolder.getMenuID())) {
                rootTitle = AfaSeniKey.選挙人名簿登録.getValue();
            } else if (AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId().equals(ResponseHolder.getMenuID())) {
                rootTitle = AfaSeniKey.選挙人名簿修正.getValue();
            } else if (AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId().equals(ResponseHolder.getMenuID())) {
                rootTitle = AfaSeniKey.選挙人名簿削除.getValue();
            }

            div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdTohyokuCode().setDisabled(false);
        }

        return ResponseData.of(div).rootTitle(rootTitle).respond();
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KaikuIdoShikakuIdoShoriDiv
     * @return ResponseData<KaikuIdoShikakuIdoShoriDiv>
     */
    public ResponseData<KaikuIdoShikakuIdoShoriDiv> onChange_ddlShohonData(KaikuIdoShikakuIdoShoriDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().changeDdlShohon();
        RString 抄本番号 = div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo();
        div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().changeDdlShohon(抄本番号, 識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 画面保存、修正、削除時のイベントメソッドです。
     *
     * @param div KaikuIdoShikakuIdoShoriDiv
     * @return ResponseData<KaikuIdoShikakuIdoShoriDiv>
     */
    public ResponseData<KaikuIdoShikakuIdoShoriDiv> onClick_btnUpdate(KaikuIdoShikakuIdoShoriDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        RString menuID = ResponseHolder.getMenuID();
        if (!ResponseHolder.isReRequest()) {

            ValidationMessageControlPairs controlErrorPairs = new ValidationMessageControlPairs();
            if (menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())) {
                controlErrorPairs = getValidatorHandler(div).validate保存データチェック();
            } else if (menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())) {
                controlErrorPairs = getValidatorHandler(div).validate修正削除データチェック();
            }
            if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }

            if (!new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        KaikuIdoShikakuIdoShoriHandler handler = getTohyokuHenkoHandler(div);
        boolean 海区付随情報結果 = false;
        if (menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())) {
            海区付随情報結果 = handler.insert海区付随情報(識別コード);
        }
        if (menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())) {
            KaikuSenkyoFuzuiResult 海区付随情報 = Base64Serializer.deSerialize(
                    div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getHdnKaikuSenkyoFuzuiJoho().toString(),
                    KaikuSenkyoFuzuiResult.class);
            海区付随情報 = handler.edit海区付随情報(海区付随情報, 識別コード);
            海区付随情報結果 = handler.update海区付随情報(海区付随情報, 識別コード);
        }

        if (海区付随情報結果) {
            out保存アクセスログ出力(識別コード);
        }

        ViewStateHolder.put(ViewStateKeys.完了確認, edit画面引数(div, 海区付随情報結果, 識別コード));
        return ResponseData.of(div).forwardWithEventName(AFAGMK1060TransitionEventName.更新).respond();
    }

    /**
     * 削除時のイベントメソッドです。
     *
     * @param div KaikuIdoShikakuIdoShoriDiv
     * @return ResponseData<KaikuIdoShikakuIdoShoriDiv>
     */
    public ResponseData<KaikuIdoShikakuIdoShoriDiv> onClick_btnDelete(KaikuIdoShikakuIdoShoriDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        if (!ResponseHolder.isReRequest()) {

            ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validate修正削除データチェック();
            if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }
            if (!new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        KaikuIdoShikakuIdoShoriHandler handler = getTohyokuHenkoHandler(div);

        KaikuSenkyoFuzuiResult 海区付随情報 = Base64Serializer.deSerialize(
                div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getHdnKaikuSenkyoFuzuiJoho().toString(),
                KaikuSenkyoFuzuiResult.class);
        boolean 海区付随情報結果 = false;
        if (海区付随情報 != null) {
            海区付随情報 = handler.edit海区付随情報(海区付随情報, 識別コード);

            海区付随情報結果 = handler.delete海区付随情報(海区付随情報, 識別コード);
        }
        if (海区付随情報結果) {
            out保存アクセスログ出力(識別コード);
        }

        ViewStateHolder.put(ViewStateKeys.完了確認, edit画面引数(div, 海区付随情報結果, 識別コード));

        return ResponseData.of(div).forwardWithEventName(AFAGMK1060TransitionEventName.更新).respond();
    }

    /**
     * 再検索するのイベントメソッドです。
     *
     * @param div KaikuIdoShikakuIdoShoriDiv
     * @return ResponseData<KaikuIdoShikakuIdoShoriDiv>
     */
    public ResponseData<KaikuIdoShikakuIdoShoriDiv> onClick_btnReSearch(KaikuIdoShikakuIdoShoriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMK1060TransitionEventName.再検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KaikuIdoShikakuIdoShoriValidatorHandler getValidatorHandler(KaikuIdoShikakuIdoShoriDiv div) {
        return KaikuIdoShikakuIdoShoriValidatorHandler.of(div);
    }

    private void out保存アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
    }

    private KaikuIdoShikakuIdoShoriHandler getTohyokuHenkoHandler(KaikuIdoShikakuIdoShoriDiv mainPanel) {
        return new KaikuIdoShikakuIdoShoriHandler(mainPanel);
    }

    private void out初期化アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
    }

    private KanryoKakuninParameter edit画面引数(KaikuIdoShikakuIdoShoriDiv div, boolean 保存結果, ShikibetsuCode 識別コード) {
        KanryoKakuninParameter 画面引数 = new KanryoKakuninParameter();
        KaikuIdoShikakuIdoShoriFinder kaikuIdoShikakuIdoShoriFinder = KaikuIdoShikakuIdoShoriFinder.createInstance();
        ShohonResult 最新抄本 = kaikuIdoShikakuIdoShoriFinder.get最新抄本(new ShohonNo(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo()));
        if (null != 最新抄本) {
            SenkyoninMeibo senkyoninMeibo = SenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(最新抄本.get抄本番号(), 識別コード);
            if (null != senkyoninMeibo) {
                画面引数.set投票区コード(senkyoninMeibo.get投票区コード());
                画面引数.set冊(senkyoninMeibo.get冊());
                画面引数.set頁(senkyoninMeibo.get頁());
                画面引数.set行(senkyoninMeibo.get行());
            } else {
                画面引数.set投票区コード(RString.EMPTY);
                画面引数.set冊(RString.EMPTY);
                画面引数.set頁(0);
                画面引数.set行(0);
            }
            画面引数.set抄本番号(最新抄本.get抄本番号());
            画面引数.set抄本名(最新抄本.get抄本名());
        }
        画面引数.setメニューID(ResponseHolder.getMenuID());
        画面引数.set処理結果(保存結果);
        画面引数.set氏名(div.getCcdKaikuIdoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().get名称().getName().value());
        return 画面引数;
    }
}
