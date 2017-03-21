/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMA1020;

import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.SenkyoninMeiboJoho;
import jp.co.ndensan.reams.af.afa.definition.configkeys.tohyokuhenko.TohyokuHenkoCode;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1020.AFAGMA1020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1020.TohyokuHenkoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1020.TohyokuHenkoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.AtenaHelper;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.MeishoHyoji.IMeishoHyojiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * TohyokuHenkoDivに対応するコントローラです。
 *
 * @reamsid_L AF-0050-010 qiuxy
 */
public class TohyokuHenko {

    private static final RString KEY_識別コード = new RString("ShikibetsuCode");
    private static final RString KEY_選挙種類 = new RString("SenkyoSyurui");
    private static final RString 画面ID_投票区変更 = new RString("AFAGMA1020");
    private static final RString ラジオ_1 = new RString("key0");
    private static final RString 未来日基準日抄本確認_追加メッセージ = new RString("\"今後も適用する\"を選択しての保存はできません。");
    private static final RString 投票区変更不可_抹消者追加メッセージ = new RString("抹消者のため、");
    private static final RString 投票区変更不可_入場券追加メッセージ = new RString("入場券出力済みのため、");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel TohyokuHenkoDiv
     * @return ResponseData<TohyokuHenkoDiv>
     */
    public ResponseData<TohyokuHenkoDiv> onLoad(TohyokuHenkoDiv mainPanel) {
        ViewStateHolder.put(ViewStateKeys.画面ID, 画面ID_投票区変更);
        FlowParameters flowParameters = FlowParameterAccessor.get();
        ShikibetsuCode shikibetsuCode;
        SenkyoShurui senkyoShurui;
        RString shohonNo;
        if (null != flowParameters && null != flowParameters.get(KEY_識別コード, RString.class)) {
            shikibetsuCode = new ShikibetsuCode(flowParameters.get(KEY_識別コード, RString.class));
            senkyoShurui = flowParameters.get(KEY_選挙種類, SenkyoShurui.class);
            mainPanel.getCcdTohyokuHenkoTaishoShohonJoho().initialize(senkyoShurui);
            TohyokuHenkoMeiboBangoJoho.onLoad(mainPanel.getTohyokuHenkoMeiboBangoJoho(), senkyoShurui);
            shohonNo = mainPanel.getCcdTohyokuHenkoTaishoShohonJoho().getTxtHdnShohonNo();
            getTohyokuHenkoHandler(mainPanel).変更前名簿番号と投票区情報取得(new ShohonNo(shohonNo), shikibetsuCode);
            getTohyokuHenkoHandler(mainPanel).初期の変更後投票区(senkyoShurui, shikibetsuCode, new ShohonNo(shohonNo));
            mainPanel.getCcdTohyokuHenkoKojinJoho().getCcdKojinJohoUR().load(AtenaHelper.createSearchKeyForAtenaShokaiSimple(shikibetsuCode));
            mainPanel.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
        } else {
            ViewState.setメニューID(ResponseHolder.getMenuID());
            shikibetsuCode = new ShikibetsuCode((RString) ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class));
            shohonNo = ViewStateHolder.get(ViewStateKeys.住民検索_抄本番号, RString.class);
            mainPanel.getCcdTohyokuHenkoTaishoShohonJoho().initialize(shohonNo);
            ShohonManager manager = ShohonManager.createInstance();
            Shohon shohon = manager.get抄本(new ShohonNo(shohonNo));
            senkyoShurui = SenkyoShurui.toValue(shohon.get選挙種類().value());
            TohyokuHenkoMeiboBangoJoho.onLoad(mainPanel.getTohyokuHenkoMeiboBangoJoho(), senkyoShurui);
            getTohyokuHenkoHandler(mainPanel).変更前名簿番号と投票区情報取得(new ShohonNo(shohonNo), shikibetsuCode);
            mainPanel.getCcdTohyokuHenkoKojinJoho().getCcdKojinJohoUR().load(AtenaHelper.createSearchKeyForAtenaShokaiSimple(shikibetsuCode));
            mainPanel.setTxtHdnSenkyoShurui(senkyoShurui.getCode());

        }
        if (ResponseHolder.isReRequest()) {
            mainPanel.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter().setDisabled(true);
            return ResponseData.of(mainPanel).respond();
        }
        if (getTohyokuHenkoHandler(mainPanel).is抹消者(shikibetsuCode)) {
            return ResponseData.of(mainPanel).addMessage(
                    AfInformationMessages.投票区変更不可.getMessage().replace(投票区変更不可_抹消者追加メッセージ.toString())).respond();
        }
        if (getTohyokuHenkoHandler(mainPanel).is入場券出力済み(new ShohonNo(shohonNo))) {
            return ResponseData.of(mainPanel).addMessage(
                    AfInformationMessages.投票区変更不可.getMessage().replace(投票区変更不可_入場券追加メッセージ.toString())).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * onChange対象抄本ドロップダウンリストのイベントです。
     *
     * @param mainPanel TohyokuHenkoDiv
     * @return ResponseData<TohyokuHenkoDiv>
     */
    public ResponseData<TohyokuHenkoDiv> onChange_ddlShohonList(TohyokuHenkoDiv mainPanel) {

        RString selectShohonNo = mainPanel.getCcdTohyokuHenkoTaishoShohonJoho().getTxtHdnShohonNo();
        ShohonNo shohonNo = new ShohonNo(selectShohonNo);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(mainPanel.getCcdTohyokuHenkoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData().
                getAtenaSearchKey().get宛先検索キー().get識別コード().value());
        getTohyokuHenkoHandler(mainPanel).変更前名簿番号と投票区情報取得(shohonNo, shikibetsuCode);
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙人名簿を保存するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel TohyokuHenkoDiv
     * @return ResponseData<TohyokuHenkoDiv>
     */
    public ResponseData<TohyokuHenkoDiv> onClick_btnUpdate(TohyokuHenkoDiv mainPanel) {
        if (SenkyoShurui.toValue(mainPanel.getTxtHdnSenkyoShurui()).equals(SenkyoShurui.定時登録)
                && !mainPanel.getTohyokuHenkoMeiboBangoJoho().getRadTekiyoNaiyo().getSelectedKey().equals(ラジオ_1)
                && !ShohonManager.createInstance().選挙登録有無チェック()) {
            throw new ApplicationException(AfErrorMessages.未来日基準日抄本確認.getMessage().replace(未来日基準日抄本確認_追加メッセージ.toString()));
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(mainPanel.getCcdTohyokuHenkoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                    .getAtenaSearchKey().get宛先検索キー().get識別コード().value());
            boolean keka = getTohyokuHenkoHandler(mainPanel).保存処理(shikibetsuCode);
            KanryoKakuninParameter 画面引数 = new KanryoKakuninParameter();
            SenkyoninMeiboJoho 登録引数 = ViewStateHolder.get(TohyokuHenkoCode.登録用選挙人名簿キー, SenkyoninMeiboJoho.class);
            画面引数.setメニューID(ResponseHolder.getMenuID());
            画面引数.set処理結果(keka);
            IMeishoHyojiDiv meishoDiv = ((AtenaShokaiSimpleDiv) mainPanel.getCcdTohyokuHenkoKojinJoho().getCcdKojinJohoUR()).getCcdMeishoHyoji();
            画面引数.set氏名(meishoDiv.getカナ名称().concat(RString.FULL_SPACE).concat(meishoDiv.get漢字名称()));
            画面引数.set冊(mainPanel.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoAfter().get冊());
            画面引数.set頁(mainPanel.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoAfter().get頁().intValue());
            画面引数.set行(mainPanel.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoAfter().get行().intValue());
            画面引数.set投票区コード(登録引数.getTohyokuCode());
            ViewStateHolder.put(ViewStateKeys.完了確認, 画面引数);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1020TransitionEventName.更新).respond();
        }
        return ResponseData.of(mainPanel).respond();

    }

    /**
     * 採番するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel TohyokuHenkoDiv
     * @return ResponseData<MeiboBangoJohoDiv>
     */
    public ResponseData<TohyokuHenkoDiv> onClick_btnBangoSanshutsu(TohyokuHenkoDiv mainPanel) {

        ShohonNo shohon = new ShohonNo(mainPanel.getCcdTohyokuHenkoTaishoShohonJoho().getTxtHdnShohonNo());
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(mainPanel.getCcdTohyokuHenkoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData().
                getAtenaSearchKey().get宛先検索キー().get識別コード().value());
        TohyokuCodeSelectDiv tohyokuAfter = (TohyokuCodeSelectDiv) mainPanel.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter();
        RString tohyokuCode = tohyokuAfter.getTxtTohyokuCode().getText();
        getTohyokuHenkoHandler(mainPanel).採番処理(shohon, shikibetsuCode, tohyokuCode);
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 戻るボタンのイベントです。
     *
     * @param mainPanel TohyokuHenkoDiv
     * @return ResponseData<MeiboBangoJohoDiv>
     */
    public ResponseData<TohyokuHenkoDiv> onClick_btnBack(TohyokuHenkoDiv mainPanel) {

        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1020TransitionEventName.戻る).respond();

    }

    private TohyokuHenkoHandler getTohyokuHenkoHandler(TohyokuHenkoDiv mainPanel) {
        return new TohyokuHenkoHandler(mainPanel);
    }

}
