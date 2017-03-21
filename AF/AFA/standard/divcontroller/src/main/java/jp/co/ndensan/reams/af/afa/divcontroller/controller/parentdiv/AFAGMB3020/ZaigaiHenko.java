/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB3020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiHonsekiParam;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.core.SaikofuTsuchiParam;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShinseiResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.afagmb3020.ZaigaiHenkoEnum;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3020.AFAGMB3020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3020.ZaigaiHenkoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3020.ZaigaiHenkoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3020.ZaigaiHenkoValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB301.ZaigaiSenkyoninShoPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB303.MasshoTsuchiHonsekiPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB305.KisaijikoHenkoTsuchiHonninPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB305.SaikofuTsuchiPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB306.MasshoTsuchiRyojikanPrintService;
import jp.co.ndensan.reams.af.afa.service.zaigaihenko.ZaigaiHenkoManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * AFAGMB3020 証明書記載事項変更<br />
 * ZaigaiHenkoDivに対するコントローラです。
 *
 * @reamsid_L AF-0330-010 guancy
 */
public class ZaigaiHenko {

    private final RString 通常選挙のメニュー = new RString("AFAMNB3");
    private final RString 国民投票区分_在外国民投票資格 = new RString("2");
    private final RString 申請番号_採番 = new RString("申請番号");
    private static final RString 証明書記載事項変更 = new RString("証明書記載事項変更");
    private static final RString 証明書再交付 = new RString("証明書再交付");
    private static final RString 在外名簿抹消 = new RString("在外名簿抹消");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ZaigaiHenkoDiv
     * @return ResponseData<ZaigaiHenkoDiv>
     */
    public ResponseData<ZaigaiHenkoDiv> onLoad(ZaigaiHenkoDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMB3020TransitionEventName.戻る).respond();
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(changeNullToEmpty(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class)));
        RString 申請番号 = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
        div.getCcdZaigaiHenkoKojinJoho().initialize(識別コード);
        div.getCcdZaigaiHenkoSenkyoninJoho().initialize(識別コード, 申請番号);
        div.getCcdZaigaiHenkoJoho().initialize(申請番号, 識別コード);
        div.getCcdZaigaiHenkoSakuseiChohyo().initialize();
        if (changeNullToEmpty(ResponseHolder.getMenuID()).startsWith(通常選挙のメニュー)
                && 国民投票区分_在外国民投票資格.equals(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getHdnKokuminTohyoKubun())
                && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(AfInformationMessages.在外国民投票資格確認.getMessage()).respond();
        }
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));

        if (AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())) {
            div.getCcdZaigaiHenkoSenkyoninJoho().setTitle(ZaigaiHenkoEnum.在外投票人情報.getValue());
            div.getCcdZaigaiHenkoJoho().setTitle(ZaigaiHenkoEnum.在外投票人名簿情報.getValue());
        }

        RString rootTitle = 証明書記載事項変更;
        if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())) {
            rootTitle = 証明書記載事項変更;
        } else if (AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())) {
            rootTitle = 証明書再交付;
        } else if (AFAMenuId.AFAMNB3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())) {
            rootTitle = 在外名簿抹消;
        }

        return ResponseData.of(div).rootTitle(rootTitle).respond();
    }

    /**
     * 「保存」ボタンのonClickイベントメソッドです。
     *
     * @param div ZaigaiHenkoDiv
     * @return ResponseData<ZaigaiHenkoDiv>
     */
    public ResponseData<ZaigaiHenkoDiv> onClick_btnUpdate(ZaigaiHenkoDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ShikibetsuCode 識別コード = new ShikibetsuCode(changeNullToEmpty(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class)));
            RString 申請番号Str = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
            int 申請番号 = Integer.parseInt(申請番号Str.toString());
            ZaigaiHenkoHandler handler = ZaigaiHenkoHandler.of(div);
            ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ = MeibotorokuZaigai.createInstance().get在外選挙人情報のデータ(申請番号, 識別コード);

            申請番号Str = Saiban.get(SubGyomuCode.AFA選挙本体, 申請番号_採番).nextString();
            申請番号 = Integer.parseInt(申請番号Str.toString());

            ZaigaiSenkyoShikakuResult 在外選挙資格 = handler.eidt在外選挙資格Forインサート(申請番号, 識別コード, 在外選挙人情報のデータ);
            ZaigaiSenkyoninShinseiResult 在外選挙人申請情報 = handler.eidt在外選挙人申請情報Forインサート(申請番号, 識別コード);
            ZaigaiSenkyoninJushoResult 本籍地住所 = handler.eidt在外選挙人住所情報_本籍地住所Forインサート(申請番号, 識別コード, 在外選挙人情報のデータ);
            ZaigaiSenkyoninJushoResult 国外転出前最終住所 = handler.eidt在外選挙人住所情報_国外転出前最終住所Forインサート(申請番号, 識別コード, 在外選挙人情報のデータ);
            ZaigaiSenkyoninJushoResult 国内転入先住所 = handler.eidt在外選挙人住所情報_国内転入先住所Forインサート(申請番号, 識別コード, 在外選挙人情報のデータ);
            ZaigaiSenkyoninJushoResult 海外住所 = handler.eidt在外選挙人住所情報_海外住所Forインサート(申請番号, 識別コード, 在外選挙人情報のデータ);
            ZaigaiSenkyoninJushoResult 海外送付先住所 = handler.eidt在外選挙人住所情報_海外送付先住所Forインサート(申請番号, 識別コード, 在外選挙人情報のデータ);
            ZaigaiHenkoManager manager = ZaigaiHenkoManager.createInstance();
            boolean 更新結果 = manager.insert在外選挙情報(在外選挙資格.getEntity(), 在外選挙人申請情報.getEntity(), 本籍地住所.getEntity(),
                    国外転出前最終住所.getEntity(), 国内転入先住所.getEntity(), 海外住所.getEntity(), 海外送付先住所.getEntity());
            AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));

            if (更新結果) {
                print帳票(div, handler, 在外選挙人情報のデータ, 識別コード);
            }
            KanryoKakuninParameter kanryoKakuninParam = new KanryoKakuninParameter();
            kanryoKakuninParam.setメニューID(ResponseHolder.getMenuID());
            kanryoKakuninParam.set処理結果(更新結果);
            kanryoKakuninParam.set識別コード(識別コード);
            kanryoKakuninParam.set氏名(div.getCcdZaigaiHenkoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
            kanryoKakuninParam.set抄本名(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdShohonNameList().getSelectedShohonName());
            ViewStateHolder.put(ViewStateKeys.完了確認, kanryoKakuninParam);
            return ResponseData.of(div).forwardWithEventName(AFAGMB3020TransitionEventName.更新).respond();
        } else {
            Message waringMessage = ZaigaiHenkoValidationHandler.of(div).validate();
            if (null != waringMessage) {
                return ResponseData.of(div).addMessage(waringMessage).respond();
            }

            return ResponseData.of(div).addMessage(AfQuestionMessages.保存の確認.getMessage()).respond();

        }
    }

    private void print帳票(ZaigaiHenkoDiv div, ZaigaiHenkoHandler handler, ZaigaiSenkyoninJohoResult 在外選挙人情報, ShikibetsuCode 識別コード) {
        RString menuId = ResponseHolder.getMenuID();
        if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(menuId)
                || AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(menuId)
                || AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(menuId)
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(menuId)) {
            List<ZaigaiSenkyoninShoParam> zaigaiSenkyoninShoList = handler.edit在外選挙人証(在外選挙人情報);
            ZaigaiSenkyoninShoPrintService 在外選挙人証 = new ZaigaiSenkyoninShoPrintService();
            在外選挙人証.print(zaigaiSenkyoninShoList);
        }

        if (!div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoHenkoHonnin().isDisplayNone()
                && div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoHenkoHonnin().isIsPublish()) {
            List<KisaijikoHenkoTsuchiHonninParam> notTorokuTsuchiList = handler.edit記載事項変更通知_本人(在外選挙人情報);
            KisaijikoHenkoTsuchiHonninPrintService 記載事項変更通知_本人 = new KisaijikoHenkoTsuchiHonninPrintService();
            記載事項変更通知_本人.print(notTorokuTsuchiList);
        }

        if (!div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoHenkoRyojikan().isDisplayNone()
                && div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoHenkoRyojikan().isIsPublish()) {
            List<KisaijikoHenkoTsuchiRyojikanParam> notTorokuTsuchiHonninList = handler.edit記載事項変更通知_領事官(在外選挙人情報, 識別コード);
            KisaijikoHenkoTsuchiRyojikanPrintService 記載事項変更通知_領事官 = new KisaijikoHenkoTsuchiRyojikanPrintService();
            記載事項変更通知_領事官.print(notTorokuTsuchiHonninList);
        }

        if (!div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoSaiKofu().isDisplayNone()
                && div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoSaiKofu().isIsPublish()) {
            List<SaikofuTsuchiParam> saikofuTsuchiList = handler.edit再交付通知(在外選挙人情報, 識別コード);
            SaikofuTsuchiPrintService 再交付通知 = new SaikofuTsuchiPrintService();
            再交付通知.print(saikofuTsuchiList);
        }

        if (!div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoMasshoHonsekichi().isDisplayNone()
                && div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoMasshoHonsekichi().isIsPublish()) {
            List<MasshoTsuchiHonsekiParam> masshoTsuchiHonsekiList = handler.edit抹消通知_本籍地(在外選挙人情報, 識別コード);
            MasshoTsuchiHonsekiPrintService 抹消通知_本籍地 = new MasshoTsuchiHonsekiPrintService();
            抹消通知_本籍地.print(masshoTsuchiHonsekiList);
        }

        if (!div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoMasshoRyojikan().isDisplayNone()
                && div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoMasshoRyojikan().isIsPublish()) {
            List<MasshoTsuchiRyojikanParam> masshoTsuchiRyojikanList = handler.edit抹消通知_領事官(在外選挙人情報, 識別コード);
            MasshoTsuchiRyojikanPrintService 抹消通知_領事官 = new MasshoTsuchiRyojikanPrintService();
            抹消通知_領事官.print(masshoTsuchiRyojikanList);
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
