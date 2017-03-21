/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 登録者数リスト不在者分のentityクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRG103FuzaiShikakuEntity {

    /**
     * コンストラクタです。
     */
    public AFAPRG103FuzaiShikakuEntity() {
        this.tohyokuCode = RString.EMPTY;
    }

    /**
     * entityのcopy
     *
     * @return AFAPRG103FuzaiShikakuEntity
     */
    public AFAPRG103FuzaiShikakuEntity copy() {
        AFAPRG103FuzaiShikakuEntity copy = new AFAPRG103FuzaiShikakuEntity();
        copy.setTohyoshikakuShurui(this.getTohyoshikakuShurui());
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

    /**
     * 登録者数リストentityになります。
     *
     * @return AFAPRG103Entity
     */
    public AFAPRG103Entity toAFAPRG103Entity() {
        AFAPRG103Entity trgt = new AFAPRG103Entity();
        trgt.setSenkyoNo(this.getSenkyoNo());
        trgt.setSenkyoName(this.getSenkyoName());
        trgt.setSumType(this.getSumType());
        trgt.setTohyokuCode(this.getTohyokuCode());
        trgt.setOrderCode(this.getOrderCode());
        trgt.setTohyokuMeisho(this.getTohyokuMeisho());
        trgt.setKijunYMD(this.getKijunYMD());
        trgt.setTohyoYMD(this.getTohyoYMD());
        trgt.setIchigoShikakushaMale(this.getIchigoShikakushaMale());
        trgt.setIchigoShikakushaFemale(this.getIchigoShikakushaFemale());
        trgt.setNigoShikakushaMale(this.getNigoShikakushaMale());
        trgt.setNigoShikakushaFemale(this.getNigoShikakushaFemale());
        return trgt;
    }

    private Code tohyoshikakuShurui;
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
}
