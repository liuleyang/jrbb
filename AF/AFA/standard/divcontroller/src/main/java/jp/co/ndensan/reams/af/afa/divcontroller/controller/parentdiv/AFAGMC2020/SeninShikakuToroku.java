/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMC2020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SenkyoninMeiboTorokuShomeishoParam;
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
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020.AFAGMC2020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020.SeninShikakuTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2020.SeninShikakuTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2020.SeninShikakuTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.afagmc2010.YubinShikakuTorokuFinder;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoPrintService;
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
 * 洋上投票資格登録のクラス
 *
 * @reamsid_L AF-0210-010 liuj2
 */
public class SeninShikakuToroku {

    private static final int 履歴番号_1 = 1;
    private static final RString 証明書発行有無_洋上_有 = new RString("1");
    private static final int ZERO = 0;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SeninShikakuTorokuDiv
     * @return ResponseData<SeninShikakuTorokuDiv>
     */
    public ResponseData<SeninShikakuTorokuDiv> onLoad(SeninShikakuTorokuDiv div) {
        SennkyoSikakuShurui senkyoShurui = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        div.getCcdSeninKojinJoho().initialize(shikibetsuCode);
        out初期化アクセスログ出力洋上(shikibetsuCode);
        div.getCcdSeninTohyoShikakuJoho().initialize(SenkyoShurui.toValue(senkyoShurui.value()), shikibetsuCode);
        div.getCcdSeninShikakuJoho().initialize(new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()), shikibetsuCode);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押す。
     *
     * @param div SeninShikakuTorokuDiv
     * @return ResponseData
     */
    public ResponseData<SeninShikakuTorokuDiv> onClick_btnUpdate(SeninShikakuTorokuDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        SeninShikakuTorokuValidationHandler validationhandler = getValidatorHandler(div);
        ValidationMessageControlPairs controlErrorPairs = validationhandler.validateエラーチェックです();
        SeninShikakuTorokuHandler handler = getHandler(div);
        YubinShikakuTorokuFinder finder = YubinShikakuTorokuFinder.createInstance();
        FuzaishaShikakuResult 直近履歴 = finder.select直近履歴(識別コード, new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()));
        FlexibleDate 履歴抹消日洋上 = null == 直近履歴
                ? FlexibleDate.EMPTY : 直近履歴.get資格抹消年月日();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            RString wkエラーメッセージ洋上 = handler.validate日付関連エラーチェック洋上(履歴抹消日洋上);
            if (!RString.isNullOrEmpty(wkエラーメッセージ洋上)) {
                throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace(wkエラーメッセージ洋上.toString()));
            }
        }
        if (!ResponseHolder.isReRequest()) {
            RString wkウォーニングメッセージ洋上 = handler.validate日付関連ウォーニングチェック洋上();
            if (!RString.isNullOrEmpty(wkウォーニングメッセージ洋上)) {
                return ResponseData.of(div).addMessage(AfWarningMessages.処理の続行確認.getMessage().replace(wkウォーニングメッセージ洋上.toString())).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        FuzaishaShikakuDiv fuzaishaShikakuDiv = div.getCcdSeninShikakuJoho().get不在者資格情報();
        FuzaishaTohyoShikaku 元不在者投票資格洋上 = new FuzaishaTohyoShikaku(識別コード, new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()),
                new BigSerial(get履歴番号洋上(fuzaishaShikakuDiv.getTxtHdnSeq())));
        FuzaishaTohyoShikaku 不在者投票資格洋上 = handler.edit不在者投票資格洋上(元不在者投票資格洋上);
        boolean 更新結果 = FuzaishaTohyoShikakuManager.createInstance().save不在者投票(不在者投票資格洋上);
        out保存アクセスログ出力洋上(識別コード);
        KanryoKakuninParameter 画面引数洋上 = new KanryoKakuninParameter();
        YubinShikakuTorokuFinder yubinShikakuTorokuFinder = YubinShikakuTorokuFinder.createInstance();
        ShohonSenkyoSearchResult 最新抄本 = yubinShikakuTorokuFinder.get最新抄本();
        if (null != 最新抄本) {
            SenkyoninMeibo meibo = SenkyoninMeiboManager.createInstance().get名簿番号(最新抄本.get抄本番号(), 識別コード);
            if (null != meibo) {
                画面引数洋上.set投票区コード(meibo.get投票区コード());
                画面引数洋上.set冊(meibo.get冊());
                画面引数洋上.set頁(meibo.get頁());
                画面引数洋上.set行(meibo.get行());
            } else {
                画面引数洋上.set投票区コード(RString.EMPTY);
                画面引数洋上.set冊(RString.EMPTY);
                画面引数洋上.set頁(ZERO);
                画面引数洋上.set行(ZERO);
            }
            画面引数洋上.set抄本番号(最新抄本.get抄本番号());
            画面引数洋上.set抄本名(最新抄本.get抄本名称());
        }
        画面引数洋上.set氏名(div.getCcdSeninKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
        画面引数洋上.setメニューID(AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId());
        画面引数洋上.set処理結果(更新結果);
        ViewStateHolder.put(ViewStateKeys.完了確認, 画面引数洋上);
        if (has帳票作成条件(fuzaishaShikakuDiv)) {
            SenkyoninMeiboTorokuShomeishoParam parameter = handler.setparameter洋上(識別コード);
            List<SenkyoninMeiboTorokuShomeishoParam> list = new ArrayList<>();
            list.add(parameter);
            new SenkyoninMeiboTorokuShomeishoPrintService().print(list);
        }
        return ResponseData.of(div).forwardWithEventName(AFAGMC2020TransitionEventName.更新).respond();
    }

    /**
     * 再検索するのイベントメソッドです。
     *
     * @param div SeninShikakuTorokuDiv
     * @return ResponseData<SeninShikakuTorokuDiv>
     */
    public ResponseData<SeninShikakuTorokuDiv> onClick_btnReSearch(SeninShikakuTorokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(AFAGMC2020TransitionEventName.再検索).respond();

    }

    private SeninShikakuTorokuHandler getHandler(SeninShikakuTorokuDiv div) {
        return SeninShikakuTorokuHandler.of(div);
    }

    private SeninShikakuTorokuValidationHandler getValidatorHandler(SeninShikakuTorokuDiv div) {
        return SeninShikakuTorokuValidationHandler.of(div);
    }

    private int get履歴番号洋上(RString 元履歴番号洋上) {

        if (!RString.isNullOrEmpty(元履歴番号洋上)) {
            int 履歴番号 = Integer.parseInt(元履歴番号洋上.toString());
            return 履歴番号 + 履歴番号_1;
        }
        return 履歴番号_1;
    }

    private boolean has帳票作成条件(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        int 資格区分index = fuzaishaShikakuDiv.getRadShikakuKubun().getSelectedIndex();
        return 資格区分index == 0
                && 証明書発行有無_洋上_有.equals(BusinessConfig.get(ConfigKeysAFA.証明書発行有無_洋上, SubGyomuCode.AFA選挙本体));
    }

    private void out初期化アクセスログ出力洋上(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
    }

    private void out保存アクセスログ出力洋上(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
    }
}
