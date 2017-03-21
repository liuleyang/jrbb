/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.tojitsutohyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;

/**
 * 当日投票のパラメータクラスです
 *
 * @reamsid_L AF-0260-010 liuj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@lombok.Setter
public class TojitsuTohyoParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final FlexibleDate tohyoYMD;
    private final FlexibleDate tohyoUketsukeYMD;
    private final FlexibleDate kijunDate;
    private final SenkyoNo senkyoNo;
    private final List<RString> tohyoJokyolist;
    private final Code senkyoSyurui;
    private final ShikibetsuCode shikibetsuCode;
    private final List<SenkyoNo> senkyoNoLst;
    private final RString tanmatsuID;
    private List<RString> shikibetsuCodeList;
    private RTime 交付時刻From;
    private RTime 交付時刻To;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param tohyoYMD FlexibleDate
     * @param tohyoUketsukeYMD FlexibleDate
     * @param kijunDate FlexibleDate
     * @param senkyoNo SenkyoNo
     * @param tohyoJokyolist List<RString>
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoNoLst List<SenkyoNo>
     * @param senkyoSyurui Code
     * @param tanmatsuID RString
     * @param 交付時刻From RTime
     * @param 交付時刻To RTime
     */
    public TojitsuTohyoParameter(IShikibetsuTaishoPSMSearchKey key,
            ShohonNo shohonNo, FlexibleDate tohyoYMD, FlexibleDate tohyoUketsukeYMD,
            FlexibleDate kijunDate, SenkyoNo senkyoNo, List<RString> tohyoJokyolist,
            ShikibetsuCode shikibetsuCode,
            List<SenkyoNo> senkyoNoLst, Code senkyoSyurui, RString tanmatsuID, RTime 交付時刻From, RTime 交付時刻To) {
        super(key);
        this.shohonNo = shohonNo;
        this.tohyoYMD = tohyoYMD;
        this.tohyoUketsukeYMD = tohyoUketsukeYMD;
        this.kijunDate = kijunDate;
        this.senkyoNo = senkyoNo;
        this.tohyoJokyolist = tohyoJokyolist;
        this.shikibetsuCode = shikibetsuCode;
        this.senkyoNoLst = senkyoNoLst;
        this.senkyoSyurui = senkyoSyurui;
        this.tanmatsuID = tanmatsuID;
        this.交付時刻From = 交付時刻From;
        this.交付時刻To = 交付時刻To;
    }
}
