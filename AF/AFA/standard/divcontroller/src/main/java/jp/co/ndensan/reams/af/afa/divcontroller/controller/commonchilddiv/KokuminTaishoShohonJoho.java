/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.Hitsuki;
import jp.co.ndensan.reams.af.afa.business.KokuminTohyoji;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.KokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.KokuminTaishoShohonJohoValidationMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 【共有子Div】KokuminTaishoShohonJohoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTaishoShohonJoho {

    /**
     * 日付を設定するボタンクリック時のイベントメソッドです。
     *
     * @param div KokuminTaishoShohonJohoDiv
     * @return ResponseData<KokuminTaishoShohonJohoDiv>
     */
    public ResponseData<KokuminTaishoShohonJohoDiv> onClick_btnSetTeijiYmd(KokuminTaishoShohonJohoDiv div) {

        if (!ResponseHolder.isReRequest() && null == div.getTxtTohyoYMD().getValue()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(KokuminTaishoShohonJohoValidationMessage.投票日が空白, div.getTxtTohyoYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        set選択抄本情報(div);
        return ResponseData.of(div).respond();

    }

    /**
     * 投票日の入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div KokuminTaishoShohonJohoDiv
     * @return ResponseData<KokuminTaishoShohonJohoDiv>
     */
    public ResponseData<KokuminTaishoShohonJohoDiv> onBlur_txtTohyoYMD(KokuminTaishoShohonJohoDiv div) {

        if (null == div.getTxtTohyoYMD().getValue()) {
            return ResponseData.of(div).respond();
        }
        set年齢到達日(div);

        return ResponseData.of(div).respond();

    }

    private void set年齢到達日(KokuminTaishoShohonJohoDiv div) {
        div.getTxtNenreiTotatsuYMD().setValue(div.getTxtTohyoYMD().getValue().plusDay(1));
    }

    private void set選択抄本情報(KokuminTaishoShohonJohoDiv div) {
        KokuminTohyoji kokuminTohyoji = new KokuminTohyoji();
        Hitsuki hitsuki = kokuminTohyoji.get日付項目_自動算出処理(div.getTxtTohyoYMD().getValue());
        div.setTxtHidShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        if (hitsuki != null) {
            div.getTxtKijunYMD().setValue(hitsuki.get基準日());
            div.getTxtMeiboTorokuYMD().setValue(hitsuki.get名簿登録日());
            div.getTxtNenreiTotatsuYMD().setValue(hitsuki.get年齢到達日());
            div.getTxtTokuteiKigenYMD().setValue(hitsuki.get特定期限日());
            div.getTxtTohyoUketsukeYMD().setValue(hitsuki.get受付開始日());
        }
    }
}
