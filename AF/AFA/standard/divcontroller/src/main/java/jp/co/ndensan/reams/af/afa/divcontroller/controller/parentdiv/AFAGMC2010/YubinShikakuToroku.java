/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMC2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.YubinTohyoShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.HonninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku.YubinShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010.AFAGMC2010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010.YubinShikakuTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010.YubinShikakuTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010.YubinShikakuTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.afagmc2010.YubinShikakuTorokuFinder;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRC201.YubinTohyoShomeishoPrintService;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 郵便等投票資格登録のクラス
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class YubinShikakuToroku {

    private static final int 履歴番号_1 = 1;
    private static final RString 証明書発行有無_郵便_有 = new RString("1");
    private static final int ZERO = 0;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div YubinShikakuTorokuDiv
     * @return ResponseData<YubinShikakuTorokuDiv>
     */
    public ResponseData<YubinShikakuTorokuDiv> onLoad(YubinShikakuTorokuDiv div) {
        SennkyoSikakuShurui senkyoShurui = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        out初期化アクセスログ出力(shikibetsuCode);
        div.getCcdYubinKojinJoho().initialize(shikibetsuCode);
        div.getCcdYubinTohyoShikakuJoho().initialize(SenkyoShurui.toValue(senkyoShurui.value()), shikibetsuCode);
        div.getCcdYubinShikakuJoho().initialize(shikibetsuCode, senkyoShurui.value());
        return ResponseData.of(div).respond();
    }

    /**
     * 住民を検索ボタンを押したときの処理行います。
     *
     * @param div YubinShikakuTorokuDiv
     * @return ResponseData<YubinShikakuTorokuDiv>
     */
    public ResponseData<YubinShikakuTorokuDiv> onBeforeOpenDialog_btnSearchSimple(YubinShikakuTorokuDiv div) {
        ValidationMessageControlPairs controlPairs = new YubinShikakuTorokuValidationHandler(div).validate登録日();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        div.getCcdYubinShikakuJoho().set画面項目制御_代理記載者情報非活性();
        YubinShikakuDiv yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        FlexibleDate 登録日 = new FlexibleDate(yubinShikakuDiv.getTxtShikakuTorokuYMD().getControlValue().toString());
        YubinShikakuTorokuFinder finder = YubinShikakuTorokuFinder.createInstance();
        SearchSimpleJuminModel model = new SearchSimpleJuminModel();
        ShohonSenkyoSearchResult 郵便等投票資格情報 = finder.get抄本(登録日);
        if (null != 郵便等投票資格情報) {
            yubinShikakuDiv.setTxtHdnSenkyoShurui(郵便等投票資格情報.get選挙種類().value());
            model.set抄本番号(郵便等投票資格情報.get抄本番号());
            model.set選挙種類(SenkyoShurui.toValue(郵便等投票資格情報.get選挙種類().value()));
        }
        yubinShikakuDiv.setSearchSimpleJuminModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 住民を検索ボタン（簡易版）の確定クローズイベントメソッドです。
     *
     * @param div YubinShikakuTorokuDiv
     * @return ResponseData<YubinShikakuTorokuDiv>
     */
    public ResponseData<YubinShikakuTorokuDiv> onOkClose_btnSearchSimple(YubinShikakuTorokuDiv div) {
        YubinShikakuDiv yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(yubinShikakuDiv.
                getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        div.getCcdYubinShikakuJoho().clear代理記載者情報();
        if (null != model
                && null != model.get識別コードリスト() && !model.get識別コードリスト().isEmpty()) {
            ShikibetsuCode 識別コード = model.get識別コードリスト().get(0);
            MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
            HonninJohoResult honninJohoResult = meibotorokuZaigai.get本人情報初期情報(識別コード);
            if (honninJohoResult != null
                    && honninJohoResult.get宛名PSM() != null) {
                yubinShikakuDiv.getTxtDairiJuminShubetsu().setValue(get住民種別名称(honninJohoResult.get宛名PSM().getJuminShubetsuCode()));
                yubinShikakuDiv.getTxtDairiSetaiCode().setDomain(honninJohoResult.get宛名PSM().getSetaiCode());
                yubinShikakuDiv.getTxtDairiKanjiShimei().setDomain(honninJohoResult.get宛名PSM().getKanjiShimei());
                yubinShikakuDiv.getTxtDairiKanaShimei().setValue(honninJohoResult.get宛名PSM().getKanaName());
                yubinShikakuDiv.getTxtDairiSeinengappiYMD().setValue(honninJohoResult.get宛名PSM().getSeinengappiYMD());
                yubinShikakuDiv.getTxtDairiNenrei().setValue(get年齢(honninJohoResult.get宛名PSM().getSeinengappiYMD()));
                List<KeyValueDataSource> keyList = new ArrayList<>();
                keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
                keyList.add(new KeyValueDataSource(MALE.getCode(), MALE.getCommonName()));
                keyList.add(new KeyValueDataSource(FEMALE.getCode(), FEMALE.getCommonName()));
                yubinShikakuDiv.getDdlDairiSeibetsu().setDataSource(keyList);
                yubinShikakuDiv.getDdlDairiSeibetsu().setSelectedKey(honninJohoResult.get宛名PSM().getSeibetsuCode());
                yubinShikakuDiv.getTxtYubinNo().setValue(honninJohoResult.get宛名PSM().getYubinNo());
                yubinShikakuDiv.getTxtDairiJusho().setDomain(honninJohoResult.get宛名PSM().getJusho());
                yubinShikakuDiv.getTxtDairiShikibetsuCode().setDomain(honninJohoResult.get宛名PSM().getShikibetsuCode());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押す。
     *
     * @param div YubinShikakuTorokuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuTorokuDiv> onClick_btnUpdate(YubinShikakuTorokuDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        YubinShikakuTorokuValidationHandler validationhandler = getValidatorHandler(div);
        YubinShikakuTorokuHandler handler = getHandler(div);
        YubinShikakuTorokuFinder finder = YubinShikakuTorokuFinder.createInstance();
        FuzaishaShikakuResult 直近履歴 = finder.select直近履歴(識別コード, new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()));
        FlexibleDate 履歴抹消日 = null == 直近履歴
                ? FlexibleDate.EMPTY : 直近履歴.get資格抹消年月日();
        ValidationMessageControlPairs controlErrorPairs = validationhandler.validateエラーチェックです();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            RString wkエラーメッセージ = handler.validate日付関連エラーチェック(履歴抹消日);
            if (!RString.isNullOrEmpty(wkエラーメッセージ)) {
                throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace(wkエラーメッセージ.toString()));
            }
        }
        if (!ResponseHolder.isReRequest()) {
            RString wkウォーニングメッセージ = handler.validate日付関連ウォーニングチェック();
            if (!RString.isNullOrEmpty(wkウォーニングメッセージ)) {
                return ResponseData.of(div).addMessage(AfWarningMessages.処理の続行確認.getMessage().replace(wkウォーニングメッセージ.toString())).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        YubinShikakuDiv yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        FuzaishaTohyoShikaku 元不在者投票資格 = new FuzaishaTohyoShikaku(識別コード, new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()),
                new BigSerial(get履歴番号(yubinShikakuDiv.getTxtHdnAfT114Seq())));
        FuzaishaTohyoShikakuYubin 元郵便投票資格付随情報 = new FuzaishaTohyoShikakuYubin(識別コード, new BigSerial(get履歴番号(yubinShikakuDiv.getTxtHdnAfT115Seq())));
        FuzaishaTohyoShikaku 不在者投票資格 = handler.edit不在者投票資格(元不在者投票資格, 元郵便投票資格付随情報, 識別コード);
        boolean 更新結果 = FuzaishaTohyoShikakuManager.createInstance().save不在者投票(不在者投票資格);
        out保存アクセスログ出力(識別コード);
        KanryoKakuninParameter 画面引数 = new KanryoKakuninParameter();
        YubinShikakuTorokuFinder yubinShikakuTorokuFinder = YubinShikakuTorokuFinder.createInstance();
        ShohonSenkyoSearchResult 最新抄本 = yubinShikakuTorokuFinder.get最新抄本();
        if (null != 最新抄本) {
            SenkyoninMeibo meibo = SenkyoninMeiboManager.createInstance().get名簿番号(最新抄本.get抄本番号(), 識別コード);
            if (null != meibo) {
                画面引数.set投票区コード(meibo.get投票区コード());
                画面引数.set冊(meibo.get冊());
                画面引数.set頁(meibo.get頁());
                画面引数.set行(meibo.get行());
            } else {
                画面引数.set投票区コード(RString.EMPTY);
                画面引数.set冊(RString.EMPTY);
                画面引数.set頁(ZERO);
                画面引数.set行(ZERO);
            }
            画面引数.set抄本番号(最新抄本.get抄本番号());
            画面引数.set抄本名(最新抄本.get抄本名称());

        }
        画面引数.setメニューID(AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId());
        画面引数.set処理結果(更新結果);
        画面引数.set氏名(div.getCcdYubinKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
        ViewStateHolder.put(ViewStateKeys.完了確認, 画面引数);
        if (has帳票作成条件(yubinShikakuDiv)) {
            YubinTohyoShomeishoParam parameter = handler.setparameter(識別コード);
            List<YubinTohyoShomeishoParam> list = new ArrayList<>();
            list.add(parameter);
            new YubinTohyoShomeishoPrintService().print(list);
        }
        return ResponseData.of(div).forwardWithEventName(AFAGMC2010TransitionEventName.更新).respond();
    }

    /**
     * 再検索するのイベントメソッドです。
     *
     * @param div YubinShikakuTorokuDiv
     * @return ResponseData<YubinShikakuTorokuDiv>
     */
    public ResponseData<YubinShikakuTorokuDiv> onClick_btnReSearch(YubinShikakuTorokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(AFAGMC2010TransitionEventName.再検索).respond();

    }

    private YubinShikakuTorokuHandler getHandler(YubinShikakuTorokuDiv div) {
        return YubinShikakuTorokuHandler.of(div);
    }

    private YubinShikakuTorokuValidationHandler getValidatorHandler(YubinShikakuTorokuDiv div) {
        return YubinShikakuTorokuValidationHandler.of(div);
    }

    private int get履歴番号(RString 元履歴番号) {

        if (!RString.isNullOrEmpty(元履歴番号)) {
            int 履歴番号 = Integer.parseInt(元履歴番号.toString());
            return 履歴番号 + 履歴番号_1;
        }
        return 履歴番号_1;
    }

    private boolean has帳票作成条件(YubinShikakuDiv yubinShikakuDiv) {
        int 資格区分index = yubinShikakuDiv.getRadShikakuKubun().getSelectedIndex();
        return 資格区分index == 0
                && 証明書発行有無_郵便_有.equals(BusinessConfig.get(ConfigKeysAFA.証明書発行有無_郵便, SubGyomuCode.AFA選挙本体));
    }

    private RString get年齢(FlexibleDate 生日) {
        if (null == 生日 || 生日.isEmpty()) {
            return RString.EMPTY;
        }
        RDate nowDate = RDate.getNowDate();
        int 年齢 = nowDate.getYearValue() - 生日.getYearValue();
        if (nowDate.getMonthValue() < 生日.getMonthValue()) {
            return new RString(Integer.toString(年齢 - 1));
        }
        if (nowDate.getMonthValue() > 生日.getMonthValue()) {
            return new RString(Integer.toString(年齢));
        }
        if (nowDate.getDayValue() < 生日.getDayValue()) {
            return new RString(Integer.toString(年齢 - 1));
        }
        return new RString(Integer.toString(年齢));
    }

    private void out初期化アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
    }

    private void out保存アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
    }

    private RString get住民種別名称(RString 住民種別コード) {
        return 住民種別コード == null ? RString.EMPTY : JuminShubetsu.toValue(住民種別コード).toRString();
    }
}
