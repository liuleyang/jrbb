/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMC2030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NankyokuSenkyoninShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.FuzaishaShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2030.AFAGMC2030TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2030.NankyokuShikakuTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2030.NankyokuShikakuTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2030.NankyokuShikakuTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.afagmc2010.YubinShikakuTorokuFinder;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRC203.NankyokuSenkyoninShomeishoPrintService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 南極投票資格登録のクラス
 *
 * @reamsid_L AF-0220-010 guyq
 */
public class NankyokuShikakuToroku {

    private static final int 履歴番号_1 = 1;
    private static final RString 証明書発行有無_南極_有 = new RString("1");
    private static final int ZERO = 0;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div NankyokuShikakuTorokuDiv
     * @return ResponseData<NankyokuShikakuTorokuDiv>
     */
    public ResponseData<NankyokuShikakuTorokuDiv> onLoad(NankyokuShikakuTorokuDiv div) {
        SennkyoSikakuShurui senkyoShurui = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        div.getCcdNankyokuKojinJoho().initialize(shikibetsuCode);
        out初期化アクセスログ出力(shikibetsuCode);
        div.getCcdNankyokuTohyoShikakuJoho().initialize(SenkyoShurui.toValue(senkyoShurui.value()), shikibetsuCode);
        div.getCcdNankyokuShikakuJoho().initialize(new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()), shikibetsuCode);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押す。
     *
     * @param div SeninShikakuTorokuDiv
     * @return ResponseData
     */
    public ResponseData<NankyokuShikakuTorokuDiv> onClick_btnUpdate(NankyokuShikakuTorokuDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        NankyokuShikakuTorokuValidationHandler validationhandler = getValidatorHandler(div);
        NankyokuShikakuTorokuHandler handler = getHandler(div);
        YubinShikakuTorokuFinder finder = YubinShikakuTorokuFinder.createInstance();
        FuzaishaShikakuResult 直近履歴 = finder.select直近履歴(識別コード, new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()));
        FlexibleDate 履歴抹消日南極 = null == 直近履歴
                ? FlexibleDate.EMPTY : 直近履歴.get資格抹消年月日();
        ValidationMessageControlPairs controlErrorPairs = validationhandler.validateエラーチェックです南極();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            RString wkエラーメッセージ南極 = handler.validate日付関連エラーチェック南極(履歴抹消日南極);
            if (!RString.isNullOrEmpty(wkエラーメッセージ南極)) {
                throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace(wkエラーメッセージ南極.toString()));
            }
        }
        if (!ResponseHolder.isReRequest()) {
            RString wkウォーニングメッセージ南極 = handler.validate日付関連ウォーニングチェック南極();
            if (!RString.isNullOrEmpty(wkウォーニングメッセージ南極)) {
                return ResponseData.of(div).addMessage(AfWarningMessages.処理の続行確認.getMessage().replace(wkウォーニングメッセージ南極.toString())).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        FuzaishaShikakuDiv fuzaishaShikakuDiv = div.getCcdNankyokuShikakuJoho().get不在者資格情報();
        FuzaishaTohyoShikaku 元不在者投票資格南極 = new FuzaishaTohyoShikaku(識別コード, new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()),
                new BigSerial(get履歴番号南極(fuzaishaShikakuDiv.getTxtHdnSeq())));
        FuzaishaTohyoShikaku 不在者投票資格南極 = handler.edit不在者投票資格南極(元不在者投票資格南極);
        boolean 更新結果 = FuzaishaTohyoShikakuManager.createInstance().save(不在者投票資格南極);
        out保存アクセスログ出力(識別コード);
        KanryoKakuninParameter 画面引数南極 = new KanryoKakuninParameter();
        YubinShikakuTorokuFinder yubinShikakuTorokuFinder = YubinShikakuTorokuFinder.createInstance();
        ShohonSenkyoSearchResult 最新抄本 = yubinShikakuTorokuFinder.get最新抄本();
        if (null != 最新抄本) {
            SenkyoninMeibo meibo = SenkyoninMeiboManager.createInstance().get名簿番号(最新抄本.get抄本番号(), 識別コード);
            if (null != meibo) {
                画面引数南極.set投票区コード(meibo.get投票区コード());
                画面引数南極.set冊(meibo.get冊());
                画面引数南極.set頁(meibo.get頁());
                画面引数南極.set行(meibo.get行());
            } else {
                画面引数南極.set投票区コード(RString.EMPTY);
                画面引数南極.set冊(RString.EMPTY);
                画面引数南極.set頁(ZERO);
                画面引数南極.set行(ZERO);
            }
            画面引数南極.set抄本番号(最新抄本.get抄本番号());
            画面引数南極.set抄本名(最新抄本.get抄本名称());
        }
        画面引数南極.set氏名(div.getCcdNankyokuKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
        画面引数南極.setメニューID(AFAMenuId.AFAMNC2030_南極投票資格登録.menuId());
        画面引数南極.set処理結果(更新結果);
        ViewStateHolder.put(ViewStateKeys.完了確認, 画面引数南極);
        if (has帳票作成条件南極(fuzaishaShikakuDiv)) {
            NankyokuSenkyoninShomeishoParam parameter = handler.setparameter南極(識別コード);
            List<NankyokuSenkyoninShomeishoParam> list = new ArrayList<>();
            list.add(parameter);
            new NankyokuSenkyoninShomeishoPrintService().print(list);
        }
        return ResponseData.of(div).forwardWithEventName(AFAGMC2030TransitionEventName.更新).respond();
    }

    /**
     * 再検索するのイベントメソッドです。
     *
     * @param div NankyokuShikakuTorokuDiv
     * @return ResponseData<NankyokuShikakuTorokuDiv>
     */
    public ResponseData<NankyokuShikakuTorokuDiv> onClick_btnReSearch(NankyokuShikakuTorokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(AFAGMC2030TransitionEventName.再検索).respond();

    }

    private NankyokuShikakuTorokuHandler getHandler(NankyokuShikakuTorokuDiv div) {
        return NankyokuShikakuTorokuHandler.of(div);
    }

    private NankyokuShikakuTorokuValidationHandler getValidatorHandler(NankyokuShikakuTorokuDiv div) {
        return NankyokuShikakuTorokuValidationHandler.of(div);
    }

    private int get履歴番号南極(RString 元履歴番号南極) {
        if (!RString.isNullOrEmpty(元履歴番号南極)) {
            int 履歴番号 = Integer.parseInt(元履歴番号南極.toString());
            return 履歴番号 + 履歴番号_1;
        }
        return 履歴番号_1;
    }

    private boolean has帳票作成条件南極(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        int 資格区分index = fuzaishaShikakuDiv.getRadShikakuKubun().getSelectedIndex();
        return 資格区分index == 0
                && 証明書発行有無_南極_有.equals(BusinessConfig.get(ConfigKeysAFA.証明書発行有無_南極, SubGyomuCode.AFA選挙本体));
    }

    private void out初期化アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
    }

    private void out保存アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
    }
}
