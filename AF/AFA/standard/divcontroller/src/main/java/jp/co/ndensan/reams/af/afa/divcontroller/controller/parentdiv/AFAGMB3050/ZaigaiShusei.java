/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB3050;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninMeiboResult;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.afagmb3050.ZaigaiShuseiEnum;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050.AFAGMB3050TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050.ZaigaiShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050.ZaigaiShuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050.ZaigaiShuseiValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.zaigaishusei.ZaigaiShuseiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMB3050 在外選挙人名簿修正<br />
 * ZaigaiShuseiDivに対するコントローラです。
 *
 * @reamsid_L AF-0325-034 guancy
 */
public class ZaigaiShusei {

    private final RString メニューID_AFAMNB3 = new RString("AFAMNB3");
    private final RString 申請番号_初期値 = new RString("0");
    private final RString 国民投票区分_在外国民投票資格 = new RString("2");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ZaigaiShuseiDiv
     * @return ResponseData<ZaigaiShuseiDiv>
     */
    public ResponseData<ZaigaiShuseiDiv> onLoad(ZaigaiShuseiDiv div) {

        ViewState.setメニューID(ResponseHolder.getMenuID());
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class));
        RString 申請番号 = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
        if (RString.isNullOrEmpty(申請番号)) {
            申請番号 = 申請番号_初期値;
        }
        ZaigaiShuseiManager manager = ZaigaiShuseiManager.createInstance();
        Boolean isTrue = Boolean.FALSE;

        List<ZaigaiSenkyoninMeiboResult> resultList = manager.get外選挙人名簿By識別コード(識別コード);
        if (resultList == null || resultList.isEmpty()) {
            ZaigaiShuseiHandler.of(div).initialize(識別コード, 申請番号, new ZaigaiSenkyoninMeiboResult());
        } else {
            ZaigaiShuseiHandler.of(div).initialize(識別コード, 申請番号, resultList.get(0));
        }
        if (ResponseHolder.getMenuID().startsWith(メニューID_AFAMNB3)) {
            RString 国民投票区分 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getHdnKokuminTohyoKubun();
            if (国民投票区分_在外国民投票資格.equals(国民投票区分)) {
                isTrue = Boolean.TRUE;
            }
        }

        RString rootTitle = ZaigaiShuseiEnum.在外選挙人名簿修正.getValue();
        if (AFAMenuId.AFAMNG3050_投票人名簿修正.menuId().equals(ResponseHolder.getMenuID())) {
            rootTitle = ZaigaiShuseiEnum.在外投票人名簿修正.getValue();
            div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().setTitle(ZaigaiShuseiEnum.在外投票人名簿情報.getValue());
        }

        if (isTrue && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(AfInformationMessages.在外国民投票資格確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMB3050TransitionEventName.戻る).respond();
        }
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
        return ResponseData.of(div).rootTitle(rootTitle).respond();
    }

    /**
     * 「保存」ボタンのonClickイベントメソッドです。
     *
     * @param div ZaigaiShuseiDiv
     * @return ResponseData<ZaigaiShuseiDiv>
     */
    public ResponseData<ZaigaiShuseiDiv> onClick_btnUpdate(ZaigaiShuseiDiv div) {
        Message waringMessage = ZaigaiShuseiValidationHandler.of(div).validate();
        if (null != waringMessage && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(waringMessage).respond();
        }
        if (!ResponseHolder.isReRequest()
                && !new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class));
        RString 申請番号 = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
        if (申請番号 == null) {
            申請番号 = 申請番号_初期値;

        }
        ZaigaiShuseiManager manager = ZaigaiShuseiManager.createInstance();
        ZaigaiShuseiHandler handler = ZaigaiShuseiHandler.of(div);
        ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult = handler.set在外選挙資格更新引数(識別コード, 申請番号);
        ZaigaiSenkyoninJushoResult zaigaiSenkyoninJushoResult = handler.set在外選挙人住所情報更新引数(識別コード, 申請番号);
        boolean 国民投票抄本番号更新Flg = false;
        if (AFAMenuId.AFAMNG3050_投票人名簿修正.menuId().equals(ResponseHolder.getMenuID())) {
            国民投票抄本番号更新Flg = true;
        }
        boolean 更新結果 = manager.update在外選挙資格と在外選挙人住所情報(zaigaiSenkyoShikakuResult, zaigaiSenkyoninJushoResult,
                国民投票抄本番号更新Flg);

        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));

        KanryoKakuninParameter kanryoKakuninParam = new KanryoKakuninParameter();
        kanryoKakuninParam.setメニューID(ResponseHolder.getMenuID());
        kanryoKakuninParam.set処理結果(更新結果);
        kanryoKakuninParam.set識別コード(識別コード);
        //TODO 画面設計_AFAGMC1010_KojinJoho_個人情報共有子DIV
        kanryoKakuninParam.set氏名(div.getCcdKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().get名称().getName().value());

        if (AFAMenuId.AFAMNG3050_投票人名簿修正.menuId().equals(ResponseHolder.getMenuID())) {
            kanryoKakuninParam.set抄本番号(new ShohonNo(div.getZaigaiShuseiShikakuJoho()
                    .getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdShohonNameList().getSelectedShohonNo()));
            kanryoKakuninParam.set抄本名(div.getZaigaiShuseiShikakuJoho()
                    .getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdShohonNameList().getSelectedShohonName());
        } else {
            kanryoKakuninParam.set抄本番号(null);
            kanryoKakuninParam.set抄本名(RString.EMPTY);
        }

        ViewStateHolder.put(ViewStateKeys.完了確認, kanryoKakuninParam);
        return ResponseData.of(div).forwardWithEventName(AFAGMB3050TransitionEventName.更新).respond();
    }

}
