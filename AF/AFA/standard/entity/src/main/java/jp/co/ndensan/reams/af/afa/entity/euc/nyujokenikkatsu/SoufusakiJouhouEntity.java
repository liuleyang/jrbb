/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.nyujokenikkatsu;

import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付先情報
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class SoufusakiJouhouEntity {

    private YubinNo 送付先郵便番号;
    private GyoseikuCode 送付先行政区コード;
    private ChoikiCode 送付先全国住所コード;
    private ChikuCode 送付先地区コード1;
    private RString 送付先地区名1;
    private SetaiCode 送付先世帯コード;
    private AtenaMeisho 世帯主名;
    private AtenaJusho 送付先住所;
    private AtenaBanchi 送付先番地;
    private Katagaki 送付先方書;
    private RString 送付先行政区名;
    private RString 送付先宛名;
    private RString 送付先投票区コード;
    private int 送付先名簿_頁;
    private int 送付先名簿_行;
    private int 整理番号;

    /**
     * 送付先郵便番号を返します。
     *
     * @return 送付先郵便番号 YubinNo
     */
    public YubinNo get送付先郵便番号() {
        return this.送付先郵便番号;
    }

    /**
     * 送付先行政区コードを返します。
     *
     * @return 送付先行政区コード GyoseikuCode
     */
    public GyoseikuCode get送付先行政区コード() {
        return this.送付先行政区コード;
    }

    /**
     * 送付先全国住所コードを返します。
     *
     * @return 送付先全国住所コード ChoikiCode
     */
    public ChoikiCode get送付先全国住所コード() {
        return this.送付先全国住所コード;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 int
     */
    public int get整理番号() {
        return 整理番号;
    }

    /**
     * 世帯主名を返します。
     *
     * @return 世帯主名 AtenaMeisho
     */
    public AtenaMeisho get世帯主名() {
        return this.世帯主名;
    }

    /**
     * 送付先地区コード1を返します。
     *
     * @return 送付先地区コード1 ChikuCode
     */
    public ChikuCode get送付先地区コード1() {
        return this.送付先地区コード1;
    }

    /**
     * 送付先地区名1を返します。
     *
     * @return 送付先地区名1 RString
     */
    public RString get送付先地区名1() {
        return this.送付先地区名1;
    }

    /**
     * 送付先世帯コードを返します。
     *
     * @return 送付先世帯コード SetaiCode
     */
    public SetaiCode get送付先世帯コード() {
        return this.送付先世帯コード;
    }

    /**
     * 送付先住所を返します。
     *
     * @return 送付先住所 AtenaJusho
     */
    public AtenaJusho get送付先住所() {
        return this.送付先住所;
    }

    /**
     * 送付先番地を返します。
     *
     * @return 送付先番地 AtenaBanchi
     */
    public AtenaBanchi get送付先番地() {
        return this.送付先番地;
    }

    /**
     * 送付先方書を返します。
     *
     * @return 送付先方書 Katagaki
     */
    public Katagaki get送付先方書() {
        return this.送付先方書;
    }

    /**
     * 送付先行政区名を返します。
     *
     * @return 送付先行政区名 RString
     */
    public RString get送付先行政区名() {
        return this.送付先行政区名;
    }

    /**
     * 送付先宛名を返します。
     *
     * @return 送付先宛名 RString
     */
    public RString get送付先宛名() {
        return this.送付先宛名;
    }

    /**
     * 送付先投票区コードを返します。
     *
     * @return 送付先投票区コード RString
     */
    public RString get送付先投票区コード() {
        return this.送付先投票区コード;
    }

    /**
     * 送付先名簿_頁を返します。
     *
     * @return 送付先名簿_頁 int
     */
    public int get送付先名簿_頁() {
        return this.送付先名簿_頁;
    }

    /**
     * 送付先名簿_行を返します。
     *
     * @return 送付先名簿_行 int
     */
    public int get送付先名簿_行() {
        return this.送付先名簿_行;
    }

    /**
     * 送付先郵便番号を設定します。
     *
     * @param 送付先郵便番号 YubinNo
     */
    public void set送付先郵便番号(YubinNo 送付先郵便番号) {
        this.送付先郵便番号 = 送付先郵便番号;
    }

    /**
     * 送付先行政区コードを設定します。
     *
     * @param 送付先行政区コード GyoseikuCode
     */
    public void set送付先行政区コード(GyoseikuCode 送付先行政区コード) {
        this.送付先行政区コード = 送付先行政区コード;
    }

    /**
     * 送付先全国住所コードを設定します。
     *
     * @param 送付先全国住所コード ChoikiCode
     */
    public void set送付先全国住所コード(ChoikiCode 送付先全国住所コード) {
        this.送付先全国住所コード = 送付先全国住所コード;
    }

    /**
     * 送付先地区コード1を設定します。
     *
     * @param 送付先地区コード1 ChikuCode
     */
    public void set送付先地区コード1(ChikuCode 送付先地区コード1) {
        this.送付先地区コード1 = 送付先地区コード1;
    }

    /**
     * 送付先地区名1を設定します。
     *
     * @param 送付先地区名1 RString
     */
    public void set送付先地区名1(RString 送付先地区名1) {
        this.送付先地区名1 = 送付先地区名1;
    }

    /**
     * 送付先世帯コードを設定します。
     *
     * @param 送付先世帯コード SetaiCode
     */
    public void set送付先世帯コード(SetaiCode 送付先世帯コード) {
        this.送付先世帯コード = 送付先世帯コード;
    }

    /**
     * 送付先住所を設定します。
     *
     * @param 送付先住所 AtenaJusho
     */
    public void set送付先住所(AtenaJusho 送付先住所) {
        this.送付先住所 = 送付先住所;
    }

    /**
     * 送付先番地を設定します。
     *
     * @param 送付先番地 AtenaBanchi
     */
    public void set送付先番地(AtenaBanchi 送付先番地) {
        this.送付先番地 = 送付先番地;
    }

    /**
     * 世帯主名を設定します。
     *
     * @param 世帯主名 AtenaMeisho
     */
    public void set世帯主名(AtenaMeisho 世帯主名) {
        this.世帯主名 = 世帯主名;
    }

    /**
     * 送付先方書を設定します。
     *
     * @param 送付先方書 Katagaki
     */
    public void set送付先方書(Katagaki 送付先方書) {
        this.送付先方書 = 送付先方書;
    }

    /**
     * 送付先行政区名を設定します。
     *
     * @param 送付先行政区名 RString
     */
    public void set送付先行政区名(RString 送付先行政区名) {
        this.送付先行政区名 = 送付先行政区名;
    }

    /**
     * 送付先宛名を設定します。
     *
     * @param 送付先宛名 RString
     */
    public void set送付先宛名(RString 送付先宛名) {
        this.送付先宛名 = 送付先宛名;
    }

    /**
     * 送付先投票区コードを設定します。
     *
     * @param 送付先投票区コード RString
     */
    public void set送付先投票区コード(RString 送付先投票区コード) {
        this.送付先投票区コード = 送付先投票区コード;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 int
     */
    public void set整理番号(int 整理番号) {
        this.整理番号 = 整理番号;
    }

    /**
     * 送付先名簿_頁を設定します。
     *
     * @param 送付先名簿_頁 int
     */
    public void set送付先名簿_頁(int 送付先名簿_頁) {
        this.送付先名簿_頁 = 送付先名簿_頁;
    }

    /**
     * 送付先名簿_行を設定します。
     *
     * @param 送付先名簿_行 int
     */
    public void set送付先名簿_行(int 送付先名簿_行) {
        this.送付先名簿_行 = 送付先名簿_行;
    }

}
