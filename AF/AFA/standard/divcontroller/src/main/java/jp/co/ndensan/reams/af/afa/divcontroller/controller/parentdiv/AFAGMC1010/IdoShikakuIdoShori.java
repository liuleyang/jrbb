/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMC1010;

import jp.co.ndensan.reams.af.afa.business.core.shikakujoho.ShikakuJohoResult;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1010.AFAGMC1010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1010.IdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1010.IdoShikakuIdoShoriHandler;
import jp.co.ndensan.reams.af.afa.service.core.shikakujoho.ShikakuJohoManger;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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

/**
 * AFAGMC1010 選挙　資格異動処理 <br />
 * IdoShikakuIdoShoriDivに対応するコントローラです。
 *
 * @reamsid_L AF-0180-010 wanghj
 */
public class IdoShikakuIdoShori {

    private static final RString 抹消者KEY = new RString("3");
    private final RString 検索結果一覧へ = new RString("btnSearchResult");
    private final RString 検索結果状態フラグ = new RString("2");
    private final RString 再検索状態フラグ = new RString("3");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel IdoShikakuIdoShoriDiv
     * @return ResponseData<IdoShikakuIdoShoriDiv>
     */
    public ResponseData<IdoShikakuIdoShoriDiv> onLoad(IdoShikakuIdoShoriDiv mainPanel) {
        SennkyoSikakuShurui senkyoShurui = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode((RString) ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        Boolean ボタン表示フラグ = ViewStateHolder.get(ViewStateKeys.住民検索_資格_ボタン表示フラグ, Boolean.class);

        mainPanel.getCcdIdoKojinJoho().initialize(shikibetsuCode);
        mainPanel.getCcdIdoShikakuJoho().initialize(SenkyoShurui.toValue(senkyoShurui.value()), shikibetsuCode);

        if (ボタン表示フラグ) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, Boolean.TRUE);
        } else {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, Boolean.FALSE);
        }

        AccessLogger.log(AccessLogType.照会, PersonalData.of(shikibetsuCode));

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 保存するのイベントメソッドです。
     *
     * @param mainPanel IdoShikakuIdoShoriDiv
     * @return ResponseData<IdoShikakuIdoShoriDiv>
     */
    public ResponseData<IdoShikakuIdoShoriDiv> onClick_btnUpdate(IdoShikakuIdoShoriDiv mainPanel) {
        IdoShikakuIdoShoriHandler handler = getHandler(mainPanel);
        RString メニューID = ResponseHolder.getMenuID();

        if (null == mainPanel.getCcdIdoShikakuJoho().getRadSenkyoShikaku().getSelectedKey()) {
            ValidationMessageControlPairs 選挙資格有無メッセージ = handler.選挙資格が有無チェック();
            if (null != 選挙資格有無メッセージ) {
                return ResponseData.of(mainPanel).addValidationMessages(選挙資格有無メッセージ).respond();
            }
        } else if (!mainPanel.getCcdIdoShikakuJoho().getRadSenkyoShikaku().getSelectedKey().equals(抹消者KEY)) {
            ValidationMessageControlPairs 選挙資格が抹消者以外メッセージ = handler.選挙資格が抹消者以外チェック(メニューID);
            if (null != 選挙資格が抹消者以外メッセージ) {
                return ResponseData.of(mainPanel).addValidationMessages(選挙資格が抹消者以外メッセージ).respond();
            }
        } else {
            ValidationMessageControlPairs 選挙資格が抹消者メッセージ = handler.選挙資格が抹消者チェック(メニューID);
            if (null != 選挙資格が抹消者メッセージ) {
                return ResponseData.of(mainPanel).addValidationMessages(選挙資格が抹消者メッセージ).respond();
            }
        }

        ValidationMessageControlPairs 住登外メッセージ = handler.住登外チェック();
        if (null != 住登外メッセージ) {
            return ResponseData.of(mainPanel).addValidationMessages(住登外メッセージ).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs 登録対象外Warnメッセージ = handler.登録対象外Warnチェック();
            if (null != 登録対象外Warnメッセージ) {
                return ResponseData.of(mainPanel).addValidationMessages(登録対象外Warnメッセージ).respond();
            } else if (!new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(mainPanel).respond();
        }
        boolean is新規登録 = ViewStateHolder.get(ViewStateKeys.新規登録区分, boolean.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode((RString) ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        SennkyoSikakuShurui 選挙種類 = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
        ShikakuJohoDiv 資格情報DIV = mainPanel.getCcdIdoShikakuJoho().get選挙資格情報();
        if (is新規登録) {
            ShikakuJohoResult 元選挙資格 = new ShikakuJohoResult();
            元選挙資格.set識別コード(識別コード);
            元選挙資格.set選挙種類(new Code(選挙種類.value()));
            ShikakuJohoResult 選挙資格 = handler.set選挙資格新規引数(識別コード, new Code(選挙種類.value()), 資格情報DIV);
            ShikakuJohoManger shikakuJohoManger = ShikakuJohoManger.createInstance();
            boolean 選挙資格新規結果 = shikakuJohoManger.save選挙資格(選挙資格);
            AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));

            KanryoKakuninParameter 選挙資格新規Param = new KanryoKakuninParameter();
            選挙資格新規Param.setメニューID(ResponseHolder.getMenuID());
            選挙資格新規Param.set処理結果(選挙資格新規結果);
            選挙資格新規Param.set識別コード(識別コード);
            選挙資格新規Param.set氏名(mainPanel.getCcdIdoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
            選挙資格新規Param.set抄本番号(null);
            選挙資格新規Param.set抄本名(RString.EMPTY);
            ViewStateHolder.put(ViewStateKeys.完了確認, 選挙資格新規Param);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1010TransitionEventName.更新).respond();
        } else {
            ShikakuJohoResult 元選挙資格 = ViewStateHolder.get(ViewStateKeys.選挙資格情報, ShikakuJohoResult.class);
            ShikakuJohoResult 選挙資格 = handler.set選挙資格更新引数(資格情報DIV, 元選挙資格);
            ShikakuJohoManger shikakuJohoManger = ShikakuJohoManger.createInstance();
            boolean 選挙資格更新結果 = shikakuJohoManger.save選挙資格(選挙資格);
            AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));

            KanryoKakuninParameter 選挙資格更新Param = new KanryoKakuninParameter();
            選挙資格更新Param.setメニューID(ResponseHolder.getMenuID());
            選挙資格更新Param.set処理結果(選挙資格更新結果);
            選挙資格更新Param.set識別コード(識別コード);
            選挙資格更新Param.set氏名(mainPanel.getCcdIdoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().get名称().getName().value());
            選挙資格更新Param.set抄本番号(null);
            選挙資格更新Param.set抄本名(RString.EMPTY);
            ViewStateHolder.put(ViewStateKeys.完了確認, 選挙資格更新Param);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1010TransitionEventName.更新).respond();
        }

    }

    /**
     * ボタン「検索結果一覧へ」をクリックするイベントメソッドです。
     *
     * @param mainPanel IdoShikakuIdoShoriDiv
     * @return ResponseData<IdoShikakuIdoShoriDiv>
     */
    public ResponseData<IdoShikakuIdoShoriDiv> onClick_btnSearchResult(IdoShikakuIdoShoriDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            IdoShikakuIdoShoriHandler handler = getHandler(mainPanel);
            boolean is新規 = ViewStateHolder.get(ViewStateKeys.新規登録区分, boolean.class);
            ShikibetsuCode 識別コード = new ShikibetsuCode((RString) ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
            SennkyoSikakuShurui 選挙種類 = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
            ShikakuJohoDiv 資格情報DIV = mainPanel.getCcdIdoShikakuJoho().get選挙資格情報();
            boolean is資格情報変更;
            if (is新規) {
                ShikakuJohoResult 元選挙資格新規 = new ShikakuJohoResult();
                元選挙資格新規.set識別コード(識別コード);
                元選挙資格新規.set選挙種類(new Code(選挙種類.value()));
                ShikakuJohoResult 選挙資格新規 = handler.set選挙資格新規引数(識別コード, new Code(選挙種類.value()), 資格情報DIV);
                is資格情報変更 = is資格情報新規変更1(選挙資格新規, 資格情報DIV);
            } else {
                ShikakuJohoResult 選挙資格 = handler.set選挙資格更新引数(資格情報DIV, ViewStateHolder.get(ViewStateKeys.選挙資格情報, ShikakuJohoResult.class));
                ShikakuJohoResult 元選挙資格 = ViewStateHolder.get(ViewStateKeys.選挙資格情報, ShikakuJohoResult.class);
                is資格情報変更 = is資格情報変更1(元選挙資格, 選挙資格, 資格情報DIV);
            }
            if (is資格情報変更) {
                return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            } else {
                ViewStateHolder.put(ViewStateKeys.住民検索資格状態変更パラメータ, 検索結果状態フラグ);
                return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1010TransitionEventName.検索結果一覧へ).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ViewStateHolder.put(ViewStateKeys.住民検索資格状態変更パラメータ, 検索結果状態フラグ);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1010TransitionEventName.検索結果一覧へ).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 再検索するのイベントメソッドです。
     *
     * @param mainPanel IdoShikakuIdoShoriDiv
     * @return ResponseData<IdoShikakuIdoShoriDiv>
     */
    public ResponseData<IdoShikakuIdoShoriDiv> onClick_btnReSearch(IdoShikakuIdoShoriDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            IdoShikakuIdoShoriHandler handler = getHandler(mainPanel);
            boolean is新規登録 = ViewStateHolder.get(ViewStateKeys.新規登録区分, boolean.class);
            ShikibetsuCode 識別コード = new ShikibetsuCode((RString) ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
            SennkyoSikakuShurui 選挙種類 = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
            ShikakuJohoDiv 資格情報DIV = mainPanel.getCcdIdoShikakuJoho().get選挙資格情報();
            boolean is資格情報新規_変更;
            if (is新規登録) {
                ShikakuJohoResult 元選挙資格新規 = new ShikakuJohoResult();
                元選挙資格新規.set識別コード(識別コード);
                元選挙資格新規.set選挙種類(new Code(選挙種類.value()));
                ShikakuJohoResult 選挙資格新規 = handler.set選挙資格新規引数(識別コード, new Code(選挙種類.value()), 資格情報DIV);
                is資格情報新規_変更 = is資格情報新規変更1(選挙資格新規, 資格情報DIV);
            } else {
                ShikakuJohoResult 選挙資格 = handler.set選挙資格更新引数(資格情報DIV, ViewStateHolder.get(ViewStateKeys.選挙資格情報, ShikakuJohoResult.class));
                ShikakuJohoResult 元選挙資格 = ViewStateHolder.get(ViewStateKeys.選挙資格情報, ShikakuJohoResult.class);
                is資格情報新規_変更 = is資格情報変更1(元選挙資格, 選挙資格, 資格情報DIV);
            }
            if (is資格情報新規_変更) {
                return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            } else {
                ViewStateHolder.put(ViewStateKeys.住民検索資格状態変更パラメータ, 再検索状態フラグ);
                return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1010TransitionEventName.再検索).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(mainPanel).respond();
        }
        ViewStateHolder.put(ViewStateKeys.住民検索資格状態変更パラメータ, 再検索状態フラグ);
        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1010TransitionEventName.再検索).respond();
    }

    private static IdoShikakuIdoShoriHandler getHandler(IdoShikakuIdoShoriDiv mainPanel) {
        return new IdoShikakuIdoShoriHandler(mainPanel);
    }

    private boolean is資格情報新規変更1(ShikakuJohoResult 選挙資格, ShikakuJohoDiv 資格情報DIV) {
        if (!資格情報DIV.getTxtKeikiShuryoYMD().isDisplayNone()
                && null != 選挙資格.get刑期終了年月日()
                && !選挙資格.get刑期終了年月日().isEmpty()) {
            return true;
        }
        if (!資格情報DIV.getTxtMeiboTorokuYMD().isDisplayNone()
                && null != 選挙資格.get名簿登録年月日()
                && !選挙資格.get名簿登録年月日().isEmpty()) {
            return true;
        }
        if (!資格情報DIV.getCcdMasshoJiyu().isDisplayNone()
                && null != 選挙資格.get抹消事由コード()
                && !選挙資格.get抹消事由コード().isEmpty()) {
            return true;

        }
        if (!資格情報DIV.getTxtMasshoYMD().isDisplayNone()
                && null != 選挙資格.get抹消年月日()
                && !選挙資格.get抹消年月日().isEmpty()) {
            return true;
        }
        return is資格情報新規変更2(選挙資格, 資格情報DIV);
    }

    private boolean is資格情報新規変更2(ShikakuJohoResult 選挙資格, ShikakuJohoDiv 資格情報DIV) {
        if (!資格情報DIV.getCcdTorokuTeishiJiyu().isDisplayNone()
                && null != 選挙資格.get登録停止事由コード()
                && !選挙資格.get登録停止事由コード().isEmpty()) {
            return true;
        }
        if (!資格情報DIV.getTxtTorokuTeishiYMD().isDisplayNone()
                && null != 選挙資格.get登録停止年月日()
                && !選挙資格.get登録停止年月日().isEmpty()) {
            return true;
        }
        return is資格情報新規変更3(選挙資格, 資格情報DIV);
    }

    private boolean is資格情報新規変更3(ShikakuJohoResult 選挙資格, ShikakuJohoDiv 資格情報DIV) {
        return (!資格情報DIV.getCcdHyojiJiyu().isDisplayNone()
                && null != 選挙資格.get表示事由コード()
                && !選挙資格.get表示事由コード().isEmpty())
                || (!資格情報DIV.getTxtHyojiYMD().isDisplayNone()
                && null != 選挙資格.get表示年月日()
                && !選挙資格.get表示年月日().isEmpty())
                || (!資格情報DIV.getTxtHyojiShojoYoteiYMD().isDisplayNone()
                && null != 選挙資格.get表示消除予定年月日()
                && !選挙資格.get表示消除予定年月日().isEmpty())
                || (!資格情報DIV.getTxtHyojiShojoYMD().isDisplayNone()
                && null != 選挙資格.get表示消除年月日()
                && !選挙資格.get表示消除年月日().isEmpty())
                || (!資格情報DIV.getRadSenkyoShikaku().isDisplayNone()
                && null != 選挙資格.get選挙資格区分()
                && !選挙資格.get選挙資格区分().isEmpty())
                || (!資格情報DIV.getChk2keiMochi().isDisplayNone()
                && 選挙資格.is2刑持ちフラグ());
    }

    private boolean is資格情報変更1(ShikakuJohoResult 元選挙資格, ShikakuJohoResult 選挙資格, ShikakuJohoDiv 資格情報DIV) {        
        if (!資格情報DIV.getTxtKeikiShuryoYMD().isDisplayNone()
                && !元選挙資格.get刑期終了年月日().equals(選挙資格.get刑期終了年月日())) {
            return true;
        }
        if (!資格情報DIV.getTxtMeiboTorokuYMD().isDisplayNone()
                && 元選挙資格.get名簿登録年月日() != 選挙資格.get名簿登録年月日()) {
            return true;
        }
        if (!資格情報DIV.getCcdMasshoJiyu().isDisplayNone()
                && !元選挙資格.get抹消事由コード().equals(選挙資格.get抹消事由コード())) {
            return true;

        }
        if (!資格情報DIV.getTxtMasshoYMD().isDisplayNone()
                && !元選挙資格.get抹消年月日().equals(選挙資格.get抹消年月日())) {
            return true;
        }
        if (!資格情報DIV.getCcdTohyokuCode().isDisplayNone()
                && !元選挙資格.get登録事由コード().equals(選挙資格.get登録事由コード())) {
            return true;
        }
        return is資格情報変更2(元選挙資格, 選挙資格, 資格情報DIV);
    }

    private boolean is資格情報変更2(ShikakuJohoResult 元選挙資格, ShikakuJohoResult 選挙資格, ShikakuJohoDiv 資格情報DIV) {
        return (!資格情報DIV.getCcdTorokuTeishiJiyu().isDisplayNone()
                && !元選挙資格.get登録停止事由コード().equals(選挙資格.get登録停止事由コード()))
                || (!資格情報DIV.getTxtTorokuTeishiYMD().isDisplayNone()
                && !元選挙資格.get登録停止年月日().equals(選挙資格.get登録停止年月日()))
                || (!資格情報DIV.getCcdHyojiJiyu().isDisplayNone()
                && !元選挙資格.get表示事由コード().equals(選挙資格.get表示事由コード()))
                || (!資格情報DIV.getTxtHyojiYMD().isDisplayNone()
                && !元選挙資格.get表示年月日().equals(選挙資格.get表示年月日()))
                || (!資格情報DIV.getTxtHyojiShojoYoteiYMD().isDisplayNone()
                && !元選挙資格.get表示消除予定年月日().equals(選挙資格.get表示消除予定年月日()))
                || (!資格情報DIV.getTxtHyojiShojoYMD().isDisplayNone()
                && !元選挙資格.get表示消除年月日().equals(選挙資格.get表示消除年月日()))
                || (!資格情報DIV.getRadSenkyoShikaku().isDisplayNone()
                && !元選挙資格.get選挙資格区分().equals(選挙資格.get選挙資格区分()))
                || (!資格情報DIV.getChk2keiMochi().isDisplayNone()
                && !is2刑持ちフラグ変更なし(元選挙資格.is2刑持ちフラグ(), 選挙資格.is2刑持ちフラグ()));
    }

    private boolean is2刑持ちフラグ変更なし(boolean 元2刑持ちフラグ, boolean 刑持ちフラグ) {
        if (元2刑持ちフラグ
                && 刑持ちフラグ) {
            return true;
        } else if (!元2刑持ちフラグ
                && !刑持ちフラグ) {
            return true;
        }
        return false;
    }

}
