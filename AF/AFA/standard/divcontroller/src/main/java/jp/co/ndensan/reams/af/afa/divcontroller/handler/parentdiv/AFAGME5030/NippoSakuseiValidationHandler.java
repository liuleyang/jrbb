/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGME5030_日報のチェックロジックです。
 *
 * @reamsid_L AF-0270-010 xul
 */
public class NippoSakuseiValidationHandler {

    private final NippoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KokuminTohyoJohoShuseiDiv
     */
    public NippoSakuseiValidationHandler(NippoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate出力対象チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new NippoSakuseiValidator(div).validate出力対象();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate出力帳票チェック() {

        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        NippoSakuseiChohyoDiv chohyoDiv = div.getNippoSakuseiChohyo();

        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().isIsPublish()) {
            IValidationMessages messages = new NippoSakuseiValidator(div).validate期日前投票日報();
            validateResult.add(createDictionary().check(messages));
        }

        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().isIsPublish()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getCcdKijitsumaeNippoShisetsuCode().関係チェック());
        }

        if (chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().isIsPublish()) {
            IValidationMessages messages = new NippoSakuseiValidator(div).validate不在者投票日報();
            validateResult.add(createDictionary().check(messages));
        }

        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().isIsPublish()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranShisetsuCode().関係チェック());
        }

        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().isIsPublish()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranTohyokuCode().関係チェック());
        }

        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().isIsPublish()) {
            IValidationMessages messages = new NippoSakuseiValidator(div).validate期日前投票者一覧表();
            validateResult.add(createDictionary().check(messages));
        }

        if (chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranShisetsuCode().関係チェック());
        }

        if (chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranTohyokuCode().関係チェック());
        }

        if (chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish()) {
            IValidationMessages messages = new NippoSakuseiValidator(div).validate不在者投票者一覧表();
            validateResult.add(createDictionary().check(messages));
        }

        if (chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().isIsPublish()
                && !chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkKonzaiPrint().getSelectedItems().isEmpty()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranShisetsuCode().関係チェック());
        }
        if (chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().isIsPublish()
                && !chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkKonzaiPrint().getSelectedItems().isEmpty()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranTohyokuCode().関係チェック());
        }

        if (chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().isIsPublish()) {
            IValidationMessages messages = new NippoSakuseiValidator(div).validate投票者一覧表();
            validateResult.add(createDictionary().check(messages));
        }
        if (chohyoDiv.getNippoSakuseiChohyoJiyuChosho().isIsPublish()) {
            IValidationMessages messages = new NippoSakuseiValidator(div).validate投票事由調書();
            validateResult.add(createDictionary().check(messages));
        }
        if (chohyoDiv.getNippoSakuseiChohyoSeirihyo().isIsPublish()) {
            validateResult.add(chohyoDiv.getNippoSakuseiChohyoSeirihyo().getCcdSeirihyoTohyokuCode().関係チェック());
        }

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NippoSakuseiValidationMessage.出力対象選択)
                .add(NippoSakuseiValidationMessage.期日前投票日報の投票日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD())
                .add(NippoSakuseiValidationMessage.期日前投票日報の投票日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD())
                .add(NippoSakuseiValidationMessage.期日前投票日報の投票日開始と終了の関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD())
                .add(NippoSakuseiValidationMessage.不在者投票日報の交付日と受理日の未選択, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getChkJuriNippo(), div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getChkKofuNippo())
                .add(NippoSakuseiValidationMessage.不在者投票日報の交付日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD())
                .add(NippoSakuseiValidationMessage.不在者投票日報の交付日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD())
                .add(NippoSakuseiValidationMessage.不在者投票日報の交付日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD())
                .add(NippoSakuseiValidationMessage.不在者投票日報の受理日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD())
                .add(NippoSakuseiValidationMessage.不在者投票日報の受理日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD())
                .add(NippoSakuseiValidationMessage.不在者投票日報の受理日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD())
                .add(NippoSakuseiValidationMessage.期日前投票者一覧表の期日前投票日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD())
                .add(NippoSakuseiValidationMessage.期日前投票者一覧表の期日前投票日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD())
                .add(NippoSakuseiValidationMessage.期日前投票者一覧表の期日前投票日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD())
                .add(NippoSakuseiValidationMessage.期日前投票者一覧表の投票時刻開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime())
                .add(NippoSakuseiValidationMessage.期日前投票者一覧表の投票時刻終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime())
                .add(NippoSakuseiValidationMessage.期日前投票者一覧表の投票時刻開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の交付日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の交付日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の交付日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の受理日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の受理日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の受理日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の受理時刻開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の受理時刻終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime())
                .add(NippoSakuseiValidationMessage.不在者投票者一覧表の受理時刻開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime())
                .add(NippoSakuseiValidationMessage.投票者一覧表の期日前投票日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の期日前投票日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の期日前投票日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の投票時刻開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime())
                .add(NippoSakuseiValidationMessage.投票者一覧表の投票時刻終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime())
                .add(NippoSakuseiValidationMessage.投票者一覧表の投票時刻開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime())
                .add(NippoSakuseiValidationMessage.投票者一覧表の交付日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の交付日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の交付日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の受理日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の受理日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の受理日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD())
                .add(NippoSakuseiValidationMessage.投票者一覧表の受理時刻開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime())
                .add(NippoSakuseiValidationMessage.投票者一覧表の受理時刻終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime())
                .add(NippoSakuseiValidationMessage.投票者一覧表の受理時刻開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime())
                .add(NippoSakuseiValidationMessage.投票事由調書の期日前投票日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD())
                .add(NippoSakuseiValidationMessage.投票事由調書の期日前投票日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD())
                .add(NippoSakuseiValidationMessage.投票事由調書の期日前投票日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD())
                .add(NippoSakuseiValidationMessage.投票事由調書の受理日開始, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD())
                .add(NippoSakuseiValidationMessage.投票事由調書の受理日終了, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD())
                .add(NippoSakuseiValidationMessage.投票事由調書の受理日開始と終了関係性, div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD())
                .build();
    }

}
