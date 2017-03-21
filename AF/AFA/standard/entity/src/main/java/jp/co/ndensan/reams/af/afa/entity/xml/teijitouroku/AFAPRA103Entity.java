/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 登録者数リストentityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRA103Entity {

    /**
     * コンストラクタです。
     */
    public AFAPRA103Entity() {
        this.tohyokuCode = RString.EMPTY;
    }

    /**
     * うち県内転出者判断
     *
     * @return hasうち県内転出者
     */
    public boolean hasうち県内転出者() {
        return this.tenshuHyojishaFemale
                .add(this.tenshuHyojishaMale)
                .add(this.tenshuKominkenTeshishaFemale)
                .add(this.tenshuKominkenTeshishaMale)
                .add(this.tenshuUkeshaFemale)
                .add(this.tenshuUkeshaMale).compareTo(Decimal.ZERO) > 0;
    }

    /**
     * entityのcopy
     *
     * @return AFAPRA103Entity
     */
    public AFAPRA103Entity copy() {
        AFAPRA103Entity copy = new AFAPRA103Entity();
        copy.setTohyokuCode(this.getTohyokuCode());
        copy.setTohyokuMeisho(this.getTohyokuMeisho());
        copy.setOrderCode(this.getOrderCode());
        copy.setHyojishaFemale(this.getHyojishaFemale());
        copy.setHyojishaMale(this.getHyojishaMale());
        copy.setKominkenTeshishaFemale(this.getKominkenTeshishaFemale());
        copy.setKominkenTeshishaMale(this.getKominkenTeshishaMale());
        copy.setTenshuUkeshaFemale(this.getTenshuUkeshaFemale());
        copy.setTenshuUkeshaMale(this.getTenshuUkeshaMale());
        copy.setTenshuHyojishaFemale(this.getTenshuHyojishaFemale());
        copy.setTenshuHyojishaMale(this.getTenshuHyojishaMale());
        copy.setTenshuKominkenTeshishaFemale(this.getTenshuKominkenTeshishaFemale());
        copy.setTenshuKominkenTeshishaMale(this.getTenshuKominkenTeshishaMale());
        copy.setUkeshaFemale(this.getUkeshaFemale());
        copy.setUkeshaMale(this.getUkeshaMale());
        copy.setKijunYMD(this.getKijunYMD());
        return copy;
    }
    private RString senkyoNo;
    private RString senkyoName;
    private RString sumType;
    private RString tohyokuCode;
    private RString orderCode;
    private RString tohyokuMeisho;
    private FlexibleDate kijunYMD;
    private FlexibleDate tohyoYMD;
    private Decimal ukeshaMale;
    private Decimal ukeshaFemale;
    private Decimal hyojishaMale;
    private Decimal hyojishaFemale;
    private Decimal kominkenTeshishaMale;
    private Decimal kominkenTeshishaFemale;
    private Decimal tenshuUkeshaMale;
    private Decimal tenshuHyojishaMale;
    private Decimal tenshuKominkenTeshishaMale;
    private Decimal tenshuUkeshaFemale;
    private Decimal tenshuHyojishaFemale;
    private Decimal tenshuKominkenTeshishaFemale;

}
