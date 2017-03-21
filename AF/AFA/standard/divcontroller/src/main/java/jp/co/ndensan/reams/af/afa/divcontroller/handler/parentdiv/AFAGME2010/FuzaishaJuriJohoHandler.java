/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KofuJuriHoho;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaJuriJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * 【子Div】FuzaishaTohyoJokyoDiv内の <br />
 * FuzaishaJuriJohoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaJuriJohoHandler {

    private FuzaishaJuriJohoHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div FuzaishaJuriJohoDiv
     * @param shohonNo RString
     */
    public static void initialize(FuzaishaJuriJohoDiv div, RString shohonNo) {
        div.getCcdFuzaishaDairiTohyo().initialize(shohonNo);
        div.getCcdKyohiJiyuNyuryoku().initialize();

        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValueDataSource(KofuJuriHoho.直接.getCode(), KofuJuriHoho.直接.toRString()));
        keyValueList.add(new KeyValueDataSource(KofuJuriHoho.郵便.getCode(), KofuJuriHoho.郵便.toRString()));
        div.getRadJuriHoho().setDataSource(keyValueList);
        div.getRadJuriHoho().setSelectedKey(KofuJuriHoho.直接.getCode());
        div.getTxtJuriYMD().setValue(RDate.getNowDate());
        div.getTxtJuriTime().setValue(RTime.of(RDate.getNowTime().getHour(), RDate.getNowTime().getSecond()));
    }

    /**
     * 初期表示時のイベントメソッドです。
     *
     * @param div FuzaishaJuriJohoDiv
     * @param shohonNo RString
     */
    public static void clearThisPanel(FuzaishaJuriJohoDiv div, RString shohonNo) {
        div.getRadJuriHoho().setSelectedKey(KofuJuriHoho.直接.getCode());
        div.getTxtJuriYMD().setValue(RDate.getNowDate());
        div.getTxtJuriTime().setValue(RTime.of(RDate.getNowTime().getHour(), RDate.getNowTime().getSecond()));
        div.getCcdFuzaishaDairiTohyo().initialize(shohonNo);
        div.getCcdKyohiJiyuNyuryoku().clear();
        div.getChkKariTohyo().getSelectedItems().clear();
    }

    /**
     * 投票状況クリック時のイベントメソッドです。
     *
     * @param div FuzaishaJuriJohoDiv
     * @param blnShiyoFuka boolean True：画面での入力不可、False：画面での入力可
     * @param 補助者Flg boolean True : 活性 、False：非表示
     * @param 受付拒否Flg boolean
     */
    public static void setHyoji(FuzaishaJuriJohoDiv div, boolean blnShiyoFuka, boolean 補助者Flg, boolean 受付拒否Flg) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        div.getRadJuriHoho().setDisabled(blnShiyoFuka);
        div.getTxtJuriYMD().setReadOnly(blnShiyoFuka);
        div.getTxtJuriTime().setReadOnly(blnShiyoFuka);

        set補助者を入力不可にする(div, 補助者Flg);
        set拒否事由を入力不可にする(div, !受付拒否Flg);
    }

    private static void set補助者を入力不可にする(FuzaishaJuriJohoDiv div, Boolean 補助者Flg) {
        div.getCcdFuzaishaDairiTohyo().setReadOnlyMode(!補助者Flg);
        div.getCcdFuzaishaDairiTohyo().setButtonDisplayNone(true);
    }

    private static void set拒否事由を入力不可にする(FuzaishaJuriJohoDiv div, Boolean 受付拒否Flg) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        div.getCcdKyohiJiyuNyuryoku().setReadOnlyMode(受付拒否Flg);
        div.getChkKariTohyo().setDisabled(受付拒否Flg);
    }

}
