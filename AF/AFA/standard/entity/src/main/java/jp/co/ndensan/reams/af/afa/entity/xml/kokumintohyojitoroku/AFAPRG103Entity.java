/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 登録者数リストentityクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRG103Entity {

    private RString senkyoNo;
    private RString senkyoName;
    private RString sumType;
    private RString tohyokuCode;
    private RString orderCode;
    private RString tohyokuMeisho;
    private FlexibleDate kijunYMD;
    private FlexibleDate tohyoYMD;
    private Decimal ichigoShikakushaMale;
    private Decimal ichigoShikakushaFemale;
    private Decimal nigoShikakushaMale;
    private Decimal nigoShikakushaFemale;

    /**
     * コンストラクタです。
     */
    public AFAPRG103Entity() {
        this.tohyokuCode = RString.EMPTY;
    }

    /**
     * entityのcopy
     *
     * @return AFAPRG103Entity
     */
    public AFAPRG103Entity copy() {
        AFAPRG103Entity copy = new AFAPRG103Entity();
        copy.setTohyokuCode(this.getTohyokuCode());
        copy.setTohyokuMeisho(this.getTohyokuMeisho());
        copy.setOrderCode(this.getOrderCode());
        copy.setIchigoShikakushaMale(this.getIchigoShikakushaMale());
        copy.setIchigoShikakushaFemale(this.getIchigoShikakushaFemale());
        copy.setNigoShikakushaMale(this.getNigoShikakushaMale());
        copy.setNigoShikakushaFemale(this.getNigoShikakushaFemale());
        copy.setKijunYMD(this.getKijunYMD());
        return copy;
    }
}
