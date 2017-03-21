/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku;

import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.不明者;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMH1030_署名簿登録のクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public class NenreiNendaiResult {

    private RString key;
    private RString tohyokuCode;
    private RString tohyokuName;
    private RString tohyojoCode;
    private RString tohyojoName;
    private RString nenrei;
    private RString nendai;
    private RString sex;
    private int yukenshasuMan;
    private int yukenshasuWoman;
    private int yukenshasu;
    private int yukosuMan;
    private int yukosuWoman;
    private int yukosu;
    private int mukosuMan;
    private int mukosuWoman;
    private int mukosu;

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int getYukenshasuMan() {
        return yukenshasuMan;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int getYukenshasuWoman() {
        return yukenshasuWoman;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int getYukosuMan() {
        return yukosuMan;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int getYukosuWoman() {
        return yukosuWoman;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int getMukosuMan() {
        return mukosuMan;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int getMukosuWoman() {
        return mukosuWoman;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public RString getKey() {
        return key;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int get有権者計() {
        return yukenshasu;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int get署名有効計() {
        return yukosu;
    }

    /**
     * getメソッドです。
     *
     * @return int
     */
    public int get署名無効計() {
        return mukosu;
    }

    /**
     * setメソッドです。
     *
     * @param key RString
     */
    public void setKey(RString key) {
        this.key = key;
    }

    /**
     * setメソッドです。
     *
     * @param sex RString
     */
    public void setSex(RString sex) {
        this.sex = sex;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString getSex() {
        return sex;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString get投票区コード() {
        return tohyokuCode;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString get投票区名() {
        return tohyokuName;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString get投票所コード() {
        return tohyojoCode;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString get投票所名() {
        return null == get投票所コード() ? 不明者.getKey() : tohyojoName;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString getNenrei() {
        return nenrei;
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public RString getNendai() {
        return nendai;
    }

    /**
     * setメソッドです。
     *
     * @param tohyokuCode RString
     */
    public void setTohyokuCode(RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * setメソッドです。
     *
     * @param tohyokuName RString
     */
    public void setTohyokuName(RString tohyokuName) {
        this.tohyokuName = tohyokuName;
    }

    /**
     * setメソッドです。
     *
     * @param tohyojoCode RString
     */
    public void setTohyojoCode(RString tohyojoCode) {
        this.tohyojoCode = tohyojoCode;
    }

    /**
     * setメソッドです。
     *
     * @param tohyojoName RString
     */
    public void setTohyojoName(RString tohyojoName) {
        this.tohyojoName = tohyojoName;
    }

    /**
     * setメソッドです。
     *
     * @param nenrei RString
     */
    public void setNenrei(RString nenrei) {
        this.nenrei = nenrei;
    }

    /**
     * setメソッドです。
     *
     * @param nendai RString
     */
    public void setNendai(RString nendai) {
        this.nendai = nendai;
    }

    /**
     * setメソッドです。
     *
     * @param yukenshasuMan Integer
     */
    public void setYukenshasuMan(Integer yukenshasuMan) {
        this.yukenshasuMan = yukenshasuMan;
    }

    /**
     * setメソッドです。
     *
     * @param yukenshasuWoman Integer
     */
    public void setYukenshasuWoman(Integer yukenshasuWoman) {
        this.yukenshasuWoman = yukenshasuWoman;
    }

    /**
     * setメソッドです。
     *
     * @param yukenshasu Integer
     */
    public void set有権者計(Integer yukenshasu) {
        this.yukenshasu = yukenshasu;
    }

    /**
     * setメソッドです。
     *
     * @param yukosuMan Integer
     */
    public void setYukosuMan(Integer yukosuMan) {
        this.yukosuMan = yukosuMan;
    }

    /**
     * setメソッドです。
     *
     * @param yukosuWoman Integer
     */
    public void setYukosuWoman(Integer yukosuWoman) {
        this.yukosuWoman = yukosuWoman;
    }

    /**
     * setメソッドです。
     *
     * @param yukosu Integer
     */
    public void set署名有効計(Integer yukosu) {
        this.yukosu = yukosu;
    }

    /**
     * setメソッドです。
     *
     * @param mukosuMan Integer
     */
    public void setMukosuMan(Integer mukosuMan) {
        this.mukosuMan = mukosuMan;
    }

    /**
     * setメソッドです。
     *
     * @param mukosuWoman Integer
     */
    public void setMukosuWoman(Integer mukosuWoman) {
        this.mukosuWoman = mukosuWoman;
    }

    /**
     * setメソッドです。
     *
     * @param mukosu Integer
     */
    public void set署名無効計(Integer mukosu) {
        this.mukosu = mukosu;
    }

}
