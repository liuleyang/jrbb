/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5020;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.Tohyoroku;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui.TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.definition.core.TohyorokuGamen;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.AFAGME5020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.TohyorokuSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5020.TohyorokuSakuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5020.TohyorokuSakuseiHandler.TohyorokuSaveData;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGME5020 投票受付　投票録作成 <br />
 * TohyoryokuSakuseiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0130-010 lit
 */
public class TohyorokuSakusei {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString メッセージ_投票録情報 = new RString("投票録情報");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiDiv
     * @return ResponseData<TohyorokuSakuseiDiv>
     */
    public ResponseData<TohyorokuSakuseiDiv> onLoad(TohyorokuSakuseiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME5020TransitionEventName.メニューに戻る).respond();
        }
        if (!getHandler(div).initialize(true)) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiDiv
     * @return ResponseData<TohyorokuSakuseiDiv>
     */
    public ResponseData<TohyorokuSakuseiDiv> onChange_ccdShohonNameList(TohyorokuSakuseiDiv div) {
        getHandler(div).changeShohonName();
        return ResponseData.of(div).respond();
    }

    /**
     * 投票録を表示するボタンクリック時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiDiv
     * @return ResponseData<TohyorokuSakuseiDiv>
     */
    public ResponseData<TohyorokuSakuseiDiv> onClick_btnSearch(TohyorokuSakuseiDiv div) {
        boolean is無投票選挙 = getHandler(div).is無投票選挙();
        if (is無投票選挙 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div)
                    .addMessage(AfWarningMessages.処理の続行確認.getMessage().replace("無投票選挙です。")).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes || !ResponseHolder.isReRequest()) {
            set投票録保存用データ(getHandler(div).setDataShosai());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索ボタンクリック時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiDiv
     * @return ResponseData<TohyorokuSakuseiDiv>
     */
    public ResponseData<TohyorokuSakuseiDiv> onClick_btnReSearch(TohyorokuSakuseiDiv div) {

        TohyorokuSaveData 投票録保存用データ = get投票録保存用データ(div);
        if (!ResponseHolder.isReRequest() && getHandler(div).checkGamenUpdate(投票録保存用データ)) {
            return ResponseData.of(div)
                    .addMessage(AfQuestionMessages.保存確認_投票録
                            .getReplacedMessage(ButtonSelectPattern.YesNo, メッセージ_投票録情報.toString())).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save(投票録保存用データ);
        }

        getHandler(div).initialize(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンクリック時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiDiv
     * @return ResponseData<TohyorokuSakuseiDiv>
     */
    public ResponseData<TohyorokuSakuseiDiv> onClick_btnUpdate(TohyorokuSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save(get投票録保存用データ(div));
//            getHandler(div).print();
            getHandler(div).initialize(false);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 発行するボタンクリック時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiDiv
     * @return ResponseData<TohyorokuSakuseiDiv>
     */
    public ResponseData<TohyorokuSakuseiDiv> onClick_btnPrint(TohyorokuSakuseiDiv div) {
        getHandler(div).print();
        getHandler(div).initialize(false);
        return ResponseData.of(div).respond();
    }

    private TohyorokuSakuseiHandler getHandler(TohyorokuSakuseiDiv div) {
        return new TohyorokuSakuseiHandler(div);
    }

    private void set投票録保存用データ(TohyorokuSaveData data) {
        ViewStateHolder.put(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票録画面対象Key, data.get投票録画面対象());
        ViewStateHolder.put(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票録, data.get投票録());
        ViewStateHolder.put(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票立会人, (Serializable) data.get投票立会人リスト());
        ViewStateHolder.put(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票管理者, (Serializable) data.get投票管理者リスト());
        ViewStateHolder.put(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.再交付者, (Serializable) data.get再交付者リスト());
    }

    private TohyorokuSaveData get投票録保存用データ(TohyorokuSakuseiDiv div) {
        Tohyoroku 投票録 = ViewStateHolder.get(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票録, Tohyoroku.class);
        List<TohyorokuFuzui> 投票立会人リスト = ViewStateHolder.get(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票立会人, List.class);
        List<TohyorokuFuzui> 投票管理者リスト = ViewStateHolder.get(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票管理者, List.class);
        List<TohyorokuFuzui> 再交付者リスト = ViewStateHolder.get(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.再交付者, List.class);
        List<TohyorokuFuzui> 決定投票者リスト = ViewStateHolder.get(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.決定書または裁決書投票者, List.class);
        TohyorokuGamen 画面対象 = ViewStateHolder.get(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.投票録画面対象Key, TohyorokuGamen.class);

        TohyorokuSaveData resultData = getHandler(div).createTohyorokuSaveData();
        resultData.set投票録(投票録);
        resultData.set投票録画面対象(画面対象);
        resultData.set投票立会人リスト(投票立会人リスト);
        resultData.set投票管理者リスト(投票管理者リスト);
        resultData.set再交付者リスト(再交付者リスト);
        resultData.set決定投票者リスト(決定投票者リスト);
        return resultData;
    }

}
