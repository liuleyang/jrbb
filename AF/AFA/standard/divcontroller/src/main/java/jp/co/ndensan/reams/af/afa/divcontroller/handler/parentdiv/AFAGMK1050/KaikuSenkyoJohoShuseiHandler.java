/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1050;

import jp.co.ndensan.reams.af.afa.business.core.KaikuTaishoShohonJohoData;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1050.KaikuSenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.service.core.kaikusenkyojohoshusei.KaikuSenkyoJohoShuseiManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * AFAGMK1050 海区漁業調整委員会委員選挙選挙情報修正 <br />
 *
 * @reamsid_L AF-0490-010 lis
 */
public class KaikuSenkyoJohoShuseiHandler {

    private final KaikuSenkyoJohoShuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 海区漁業調整委員会委員選挙選挙情報修正Div
     */
    public KaikuSenkyoJohoShuseiHandler(KaikuSenkyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * 抄本選挙をセットする。
     *
     * @param 抄本選挙情報 KaikuTaishoShohonJohoData
     *
     * @return KaikuTaishoShohonJohoData 抄本選挙情報
     */
    public KaikuTaishoShohonJohoData edit抄本選挙情報(KaikuTaishoShohonJohoData 抄本選挙情報) {
        抄本選挙情報.getAft100Entity().setShohonName(div.getCcdKaikuShusei().getTxtShohonName().getValue());
        抄本選挙情報.getAft111Entity().setSenkyoName(div.getCcdKaikuShusei().getTxtSenkyoName().getValue());
        抄本選挙情報.getAft111Entity().setTohyoUketsukeYMD(new FlexibleDate(div.getCcdKaikuShusei().getTxtTohyoUketsukeYMD().getValue().toDateString()));
        抄本選挙情報.getAft111Entity().setMutohyoSenkyoFlag(div.getCcdKaikuShusei().getChkMutohyo().isAllSelected());
        return 抄本選挙情報;
    }

    /**
     * update抄本選挙情報です。
     *
     * @param 抄本選挙情報 KaikuTaishoShohonJohoData
     * @return update抄本選挙情報
     */
    public boolean update抄本選挙情報(KaikuTaishoShohonJohoData 抄本選挙情報) {
        return KaikuSenkyoJohoShuseiManager.createInstance().update抄本選挙情報(抄本選挙情報);
    }
}
