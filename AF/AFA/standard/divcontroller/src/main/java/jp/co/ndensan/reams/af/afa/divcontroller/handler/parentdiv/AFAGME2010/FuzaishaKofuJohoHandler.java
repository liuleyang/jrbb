/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KofuJuriHoho;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaKofuJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * 【子Div】FuzaishaTohyoJokyoDiv内の <br />
 * FuzaishaKofuJohoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaKofuJohoHandler {

    private FuzaishaKofuJohoHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div FuzaishaKofuJohoDiv
     */
    public static void initialize(FuzaishaKofuJohoDiv div) {
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValueDataSource(KofuJuriHoho.直接.getCode(), KofuJuriHoho.直接.toRString()));
        keyValueList.add(new KeyValueDataSource(KofuJuriHoho.郵便.getCode(), KofuJuriHoho.郵便.toRString()));
        div.getRadKofuHoho().setDataSource(keyValueList);
        div.getRadKofuHoho().setSelectedKey(KofuJuriHoho.直接.getCode());
        div.getTxtKofuYMD().setValue(RDate.getNowDate());
    }

    /**
     * 初期表示時のイベントメソッドです。
     *
     * @param div FuzaishaKofuJohoDiv
     */
    public static void clearThisPanel(FuzaishaKofuJohoDiv div) {
        div.getRadKofuHoho().setSelectedKey(KofuJuriHoho.直接.getCode());
        div.getTxtKofuYMD().setValue(RDate.getNowDate());
        div.getChkTenjiYoshi().getSelectedItems().clear();
        div.getChkShomeishoHakko().getSelectedItems().clear();
    }

    /**
     * 投票状況クリック時のイベントメソッドです。
     *
     * @param div FuzaishaKofuJohoDiv
     * @param blnShiyoFuka Boolean True：画面での入力不可、False：画面での入力可
     */
    public static void setHyoji(FuzaishaKofuJohoDiv div, Boolean blnShiyoFuka) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        div.getRadKofuHoho().setDisabled(blnShiyoFuka);
        div.getTxtKofuYMD().setReadOnly(blnShiyoFuka);
        div.getChkTenjiYoshi().setDisabled(blnShiyoFuka);
        div.getChkShomeishoHakko().setDisabled(blnShiyoFuka);
    }

}
