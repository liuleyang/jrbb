/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB3010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishaShokaiBunshoParam;
import jp.co.ndensan.reams.af.afa.business.core.TorokuTsuchiParam;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninMeiboResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShinseiResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShinseiJotai;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3010.AFAGMB3010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3010.ZaigaiMeiboTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3010.ZaigaiMeiboTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3010.ZaigaiMeiboTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB301.ZaigaiSenkyoninShoPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB302.ShinseishaShokaiBunshoPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB303.TorokuTsuchiPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB304.NotTorokuTsuchiHonninPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB305.NotTorokuTsuchiRyojikanPrintService;
import jp.co.ndensan.reams.af.afa.service.zaigaimeibotoroku.ZaigaiMeiboTorokuManager;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMB3010 在外選挙人名簿登録<br />
 * ZaigaiMeiboTorokuDivに対するコントローラです。
 *
 * @reamsid_L AF-0320-010 lis
 */
public class ZaigaiMeiboToroku {

    private final RString メッセージ_処理の続行確認 = new RString("既に登録済みです。");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ResponseData<ZaigaiMeiboTorokuDiv>
     */
    public ResponseData<ZaigaiMeiboTorokuDiv> onLoad(ZaigaiMeiboTorokuDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(
                changeNullToEmpty(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class)));
        RString 申請番号 = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
        RString menuId = UrControlDataFactory.createInstance().getMenuID();
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(menuId) && !RString.isNullOrEmpty(申請番号) || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(menuId) && !RString.isNullOrEmpty(申請番号)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(AfWarningMessages.処理の続行確認.getMessage()
                        .replace(メッセージ_処理の続行確認.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                申請番号 = null;
            } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).forwardWithEventName(AFAGMB3010TransitionEventName.戻る).respond();
            }
        }

        ZaigaiMeiboTorokuHandler handler = ZaigaiMeiboTorokuHandler.of(div);
        div.getCcdZaigaiMeiboKojinJoho().initialize(識別コード);
        div.getCcdZaigaiMeiboSenkyoninJoho().initialize(識別コード, 申請番号);
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(menuId) || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(menuId)) {
            handler.set申請状態ラジオボタン非活性();
            div.getCcdZaigaiMeiboJoho().setDisplayNoneMode(Boolean.TRUE);
            div.getBtnApproval().setDisplayNone(true);
            div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setSelectedIndex(0);
            handler.change申請情報部分の制御(識別コード, 申請番号);
            if (ShinseiJotai.未届.getValue().equals(div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedValue())) {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(true);
            } else {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(false);
                div.getCcdZaigaiMeiboSakuseiChohyo().initialize(div.getCcdZaigaiMeiboSenkyoninJoho().
                        getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey());
                handler.change作成帳票部分の制御();
            }
        } else {
            handler.cancle申請状態ラジオボタン非活性制御();
            div.getCcdZaigaiMeiboJoho().setIsOpen(Boolean.FALSE);
            div.getCcdZaigaiMeiboJoho().setReadOnlyMode(Boolean.FALSE);
            div.getCcdZaigaiMeiboJoho().initialize(申請番号, 識別コード);
            div.getBtnApproval().setDisplayNone(false);
            div.getBtnApproval().setDisabled(true);
            List<KeyValueDataSource> disabledItemList = new ArrayList<>();
            disabledItemList.add(div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getDataSource().get(0));
            div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setDisabledItem(disabledItemList);
            div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setSelectedIndex(1);
            handler.change申請情報部分の制御(識別コード, 申請番号);
            if (ShinseiJotai.申請取下げ.getValue().equals(div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedValue())) {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(true);
            } else {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(false);
                div.getCcdZaigaiMeiboSakuseiChohyo().initialize(div.getCcdZaigaiMeiboSenkyoninJoho().
                        getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey());
                handler.change作成帳票部分の制御();
            }
        }

        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請状態」ラジオボタンのonChangeイベントメソッドです。
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ResponseData<ZaigaiMeiboTorokuDiv>
     */
    public ResponseData<ZaigaiMeiboTorokuDiv> onChange_radShinseiKubun(ZaigaiMeiboTorokuDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(
                changeNullToEmpty(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class)));
        RString 申請番号 = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
        RString menuId = UrControlDataFactory.createInstance().getMenuID();
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(menuId) || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(menuId)) {
            申請番号 = null;
        }
        ZaigaiMeiboTorokuHandler handler = ZaigaiMeiboTorokuHandler.of(div);
        handler.change申請情報部分の制御(識別コード, 申請番号);
        RString menuID = UrControlDataFactory.createInstance().getMenuID();
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(menuID) || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(menuID)) {
            if (ShinseiJotai.未届.getValue().equals(div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedValue())) {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(true);
            } else {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(false);
                div.getCcdZaigaiMeiboSakuseiChohyo().initialize(div.getCcdZaigaiMeiboSenkyoninJoho().
                        getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey());
                handler.change作成帳票部分の制御();
            }
        } else {
            if (ShinseiJotai.申請取下げ.getValue().equals(div.getCcdZaigaiMeiboSenkyoninJoho().
                    getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedValue())) {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(true);
            } else {
                div.getCcdZaigaiMeiboSakuseiChohyo().setDisplayNone(false);
                div.getCcdZaigaiMeiboSakuseiChohyo().initialize(div.getCcdZaigaiMeiboSenkyoninJoho().
                        getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey());
                handler.change作成帳票部分の制御();
            }
        }
        RString shinseiJotai = div.getCcdZaigaiMeiboSenkyoninJoho().
                getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey();
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(UrControlDataFactory.createInstance().getMenuID()) || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(UrControlDataFactory.createInstance().getMenuID())) {
            div.getBtnApproval().setDisplayNone(true);
        } else {
            if (ShinseiJotai.証明書交付.getKey().equals(shinseiJotai)) {
                div.getBtnApproval().setDisabled(false);
            } else {
                div.getBtnApproval().setDisabled(true);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認」ボタンのonClickイベントメソッドです。
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ResponseData<ZaigaiMeiboTorokuDiv>
     */
    public ResponseData<ZaigaiMeiboTorokuDiv> onClick_btnApproval(ZaigaiMeiboTorokuDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            Message waringMessage = ZaigaiMeiboTorokuValidationHandler.of(div).validate();
            if (null != waringMessage) {
                return ResponseData.of(div).addMessage(waringMessage).respond();
            }
        }
        div.getCcdZaigaiMeiboJoho().setIsOpen(Boolean.TRUE);
        div.getCcdZaigaiMeiboJoho().setReadOnlyMode(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().setIsOpen(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().setReadOnly(Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存」ボタンのonClickイベントメソッドです。
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ResponseData<ZaigaiMeiboTorokuDiv>
     */
    public ResponseData<ZaigaiMeiboTorokuDiv> onClick_btnUpdate(ZaigaiMeiboTorokuDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            Message waringMessage = ZaigaiMeiboTorokuValidationHandler.of(div).validate();
            if (null != waringMessage) {
                return ResponseData.of(div).addMessage(waringMessage).respond();
            }
            return ResponseData.of(div).addMessage(AfQuestionMessages.保存の確認.getMessage()).respond();
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class));

        RString 申請番号 = ViewStateHolder.get(ViewStateKeys.住民検索_申請番号, RString.class);
        ZaigaiMeiboTorokuManager manager = ZaigaiMeiboTorokuManager.createInstance();
        ZaigaiMeiboTorokuHandler handler = ZaigaiMeiboTorokuHandler.of(div);
        int 更新結果;
        ShohonNo 抄本番号_画面遷移;
        RString 抄本名_画面遷移;
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(UrControlDataFactory.createInstance().getMenuID()) || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(UrControlDataFactory.createInstance().getMenuID())) {
            抄本番号_画面遷移 = null;
            抄本名_画面遷移 = RString.EMPTY;
            ZaigaiSenkyoShikakuResult 在外選挙資格 = handler.eidt在外選挙資格Forインサート(識別コード);
            ZaigaiSenkyoninShinseiResult 在外選挙人申請情報 = handler.eidt在外選挙人申請情報Forインサート(識別コード);
            ZaigaiSenkyoninJushoResult 本籍地住所 = handler.eidt在外選挙人住所情報_本籍地住所Forインサート(識別コード);
            ZaigaiSenkyoninJushoResult 国外転出前最終住所 = handler.eidt在外選挙人住所情報_国外転出前最終住所Forインサート(識別コード);
            ZaigaiSenkyoninJushoResult 海外住所 = handler.eidt在外選挙人住所情報_海外住所Forインサート(識別コード);
            ZaigaiSenkyoninJushoResult 海外送付先住所 = handler.eidt在外選挙人住所情報_海外送付先住所Forインサート(識別コード);
            更新結果 = manager.insert在外選挙情報(在外選挙資格.getEntity(), 在外選挙人申請情報.getEntity(),
                    本籍地住所.getEntity(), 国外転出前最終住所.getEntity(), 海外住所.getEntity(), 海外送付先住所.getEntity());
            申請番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiNo().getValue();
        } else {
            RDate 登録日 = div.getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtTorokuYMD().getValue();
            if (null == 登録日) {
                登録日 = RDate.getNowDate();
            }
            List<ShohonResult> 抄本番号リスト = manager.get抄本番号リスト(登録日);
            if (null == 抄本番号リスト || 抄本番号リスト.isEmpty()) {
                抄本番号_画面遷移 = null;
                抄本名_画面遷移 = RString.EMPTY;
            } else {
                Collections.sort(抄本番号リスト, new Comparator<ShohonResult>() {
                    @Override
                    public int compare(ShohonResult o1, ShohonResult o2) {
                        FlexibleDate 処理年月日1 = null == o1.get処理年月日() || o1.get処理年月日().isEmpty() ? FlexibleDate.MIN : o1.get処理年月日();
                        FlexibleDate 処理年月日2 = null == o2.get処理年月日() || o2.get処理年月日().isEmpty() ? FlexibleDate.MIN : o2.get処理年月日();
                        return 処理年月日2.compareTo(処理年月日1);
                    }
                });
                抄本番号_画面遷移 = 抄本番号リスト.get(0).get抄本番号();
                抄本名_画面遷移 = 抄本番号リスト.get(0).get抄本名();
            }
            List<ZaigaiSenkyoninMeiboResult> 在外選挙人名簿リスト = handler.eidt在外選挙人名簿Forインサート(抄本番号リスト, 識別コード);
            ZaigaiSenkyoShikakuResult 在外選挙資格 = Base64Serializer.deSerialize(div.getCcdZaigaiMeiboSenkyoninJoho().getHdnZaigaiSenkyoShikaku().toString(), ZaigaiSenkyoShikakuResult.class);
            在外選挙資格 = handler.eidt在外選挙資格For更新(在外選挙資格, 識別コード);
            ZaigaiSenkyoninShinseiResult 在外選挙人申請情報 = Base64Serializer.deSerialize(div.getCcdZaigaiMeiboSenkyoninJoho().getHdnZaigaiSenkyoninShinsei().toString(), ZaigaiSenkyoninShinseiResult.class);
            在外選挙人申請情報 = handler.eidt在外選挙人申請情報For更新(在外選挙人申請情報, 識別コード);
            ZaigaiSenkyoninJushoResult 元本籍地住所 = Base64Serializer.deSerialize(div.getCcdZaigaiMeiboSenkyoninJoho().getHdnJushoShuruiKubun1().toString(), ZaigaiSenkyoninJushoResult.class);
            ZaigaiSenkyoninJushoResult 本籍地住所 = handler.eidt在外選挙人住所情報_本籍地住所For更新(元本籍地住所);
            ZaigaiSenkyoninJushoResult 元国外転出前最終住所 = Base64Serializer.deSerialize(div.getCcdZaigaiMeiboSenkyoninJoho().getHdnJushoShuruiKubun2().toString(), ZaigaiSenkyoninJushoResult.class);
            ZaigaiSenkyoninJushoResult 国外転出前最終住所 = handler.eidt在外選挙人住所情報_国外転出前最終住所For更新(元国外転出前最終住所);
            ZaigaiSenkyoninJushoResult 元海外住所 = Base64Serializer.deSerialize(div.getCcdZaigaiMeiboSenkyoninJoho().getHdnJushoShuruiKubun4().toString(), ZaigaiSenkyoninJushoResult.class);
            ZaigaiSenkyoninJushoResult 海外住所 = handler.eidt在外選挙人住所情報_海外住所For更新(元海外住所);
            ZaigaiSenkyoninJushoResult 元海外送付先住所 = Base64Serializer.deSerialize(div.getCcdZaigaiMeiboSenkyoninJoho().getHdnJushoShuruiKubun5().toString(), ZaigaiSenkyoninJushoResult.class);
            ZaigaiSenkyoninJushoResult 海外送付先住所 = handler.eidt在外選挙人住所情報_海外送付先住所For更新(元海外送付先住所);
            更新結果 = manager.update在外選挙情報(在外選挙人名簿リスト, 在外選挙資格.getEntity(), 在外選挙人申請情報.getEntity(), 本籍地住所.getEntity(),
                    国外転出前最終住所.getEntity(), 海外住所.getEntity(), 海外送付先住所.getEntity());
        }

        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
        if (0 != 更新結果) {
            ZaigaiSenkyoninJohoResult 在外選挙人情報 = MeibotorokuZaigai.createInstance().get在外選挙人情報のデータ(
                    RString.isNullOrEmpty(申請番号) ? 0 : Integer.valueOf(申請番号.toString()), 識別コード);
            print帳票(div, handler, 在外選挙人情報);
        }
        KanryoKakuninParameter kanryoKakuninParam = new KanryoKakuninParameter();

        kanryoKakuninParam.setメニューID(ResponseHolder.getMenuID());
        kanryoKakuninParam.set処理結果((0 != 更新結果));
        kanryoKakuninParam.set識別コード(識別コード);
        kanryoKakuninParam.set氏名(div.getCcdZaigaiMeiboKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
        kanryoKakuninParam.set抄本番号(抄本番号_画面遷移);
        kanryoKakuninParam.set抄本名(抄本名_画面遷移);

        ViewStateHolder.put(ViewStateKeys.完了確認, kanryoKakuninParam);

        return ResponseData.of(div).forwardWithEventName(AFAGMB3010TransitionEventName.更新).respond();
    }

    private SourceDataCollection print帳票(ZaigaiMeiboTorokuDiv div, ZaigaiMeiboTorokuHandler handler, ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        SourceDataCollection collection = new SourceDataCollection();
        List<ZaigaiSenkyoninShoParam> zaigaiSenkyoninShoList = handler.edit在外選挙人証(在外選挙人情報);
        ZaigaiSenkyoninShoPrintService 在外選挙人証 = new ZaigaiSenkyoninShoPrintService();
        在外選挙人証.print(zaigaiSenkyoninShoList);

        if (!div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoToroku().isDisplayNone()
                && div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoToroku().isIsPublish()) {
            List<TorokuTsuchiParam> notTorokuTsuchiList = handler.edit登録した旨の通知(在外選挙人情報);
            TorokuTsuchiPrintService 登録した旨の通知 = new TorokuTsuchiPrintService();
            登録した旨の通知.print(notTorokuTsuchiList);
        }

        if (!div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiHonnin().isDisplayNone()
                && div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiHonnin().isIsPublish()) {
            List<NotTorokuTsuchiHonninParam> notTorokuTsuchiHonninList = handler.edit登録を行わなかった旨の通知_本人(在外選挙人情報);
            NotTorokuTsuchiHonninPrintService 登録を行わなかった旨の通知_本人 = new NotTorokuTsuchiHonninPrintService();
            登録を行わなかった旨の通知_本人.print(notTorokuTsuchiHonninList);
        }

        if (!div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiRyojikan().isDisplayNone()
                && div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiRyojikan().isIsPublish()) {
            List<NotTorokuTsuchiRyojikanParam> notTorokuTsuchiRyojikanList = handler.edit登録を行わなかった旨の通知_領事官(在外選挙人情報);
            NotTorokuTsuchiRyojikanPrintService 登録を行わなかった旨の通知_領事官 = new NotTorokuTsuchiRyojikanPrintService();
            登録を行わなかった旨の通知_領事官.print(notTorokuTsuchiRyojikanList);
        }

        if (!div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().isDisplayNone()
                && div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().isIsPublish()) {
            List<ShinseishaShokaiBunshoParam> shinseishaShokaiBunshoList = handler.edit申請者の被登録資格の照会文書(在外選挙人情報);
            ShinseishaShokaiBunshoPrintService 申請者の被登録資格の照会文書 = new ShinseishaShokaiBunshoPrintService();
            申請者の被登録資格の照会文書.print(shinseishaShokaiBunshoList);
        }

        return collection;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
