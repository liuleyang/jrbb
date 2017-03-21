/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020;

import jp.co.ndensan.reams.af.afa.definition.batchprm.doitsujinbutsuChosa.AFABTM107BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020.DoitsuninCsvOutputDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票人名簿最新化のクラス
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public class DoitsuninCsvOutputHandler {

    private final DoitsuninCsvOutputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DoitsuninCsvOutputDiv
     */
    public DoitsuninCsvOutputHandler(DoitsuninCsvOutputDiv div) {
        this.div = div;
    }

    /**
     * 「実行する」ボタン押下のチェックする。
     *
     * @return parameter AFABTM107BatchParameter
     */
    public AFABTM107BatchParameter set画面入力内容() {
        AFABTM107BatchParameter param = new AFABTM107BatchParameter();
        param.set抄本番号(div.getCcdShohonNameList().getSelectedShohonNo());
        param.set投票年月日(new FlexibleDate(div.getCcdShohonNameList().getSelectedTohyoYMD().toString()));
        param.set氏名(is氏名チェック());
        param.setカナ(isカナチェック());
        param.set名(is名チェック());
        param.set氏(is氏チェック());
        param.set漢字(is漢字チェック());

        param.set生年月日(div.getChkSeinengappi().isAllSelected());
        param.set性別(div.getChkSeibetsu().isAllSelected());
        param.set住所コード(div.getChkJushoCode().isAllSelected());
        param.set住所(div.getChkJusho().isAllSelected());
        param.set番地コード(div.getChkBanchiCode().isAllSelected());
        param.set抄本名(div.getCcdShohonNameList().getSelectedShohonName());
        return param;
    }

    private Boolean is氏名チェック() {
        if (div.getChkShimei().isAllSelected()) {
            return div.getRadSeiMei().getSelectedKey().equals(new RString("0"));
        }
        return false;
    }

    private Boolean is氏チェック() {
        if (div.getChkShimei().isAllSelected()) {
            return div.getRadSeiMei().getSelectedKey().equals(new RString("1"));
        }
        return false;
    }

    private Boolean is名チェック() {
        if (div.getChkShimei().isAllSelected()) {
            return div.getRadSeiMei().getSelectedKey().equals(new RString("2"));
        }
        return false;
    }

    private Boolean isカナチェック() {
        if (div.getChkShimei().isAllSelected()) {
            return div.getRadKanaKanji().getSelectedKey().equals(new RString("0"));
        }
        return false;
    }

    private Boolean is漢字チェック() {
        if (div.getChkShimei().isAllSelected()) {
            return div.getRadKanaKanji().getSelectedKey().equals(new RString("1"));
        }
        return false;
    }
}
