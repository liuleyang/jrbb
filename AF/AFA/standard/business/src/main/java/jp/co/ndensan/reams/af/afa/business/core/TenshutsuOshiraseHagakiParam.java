/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出者お知らせハガキ
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiParam {

    private NyujoukenGamenModel 投票所入場券情報;
    private MeisaiJouhou 明細情報1;
    private MeisaiJouhou 明細情報2;
    private MeisaiJouhou 明細情報3;
    private MeisaiJouhou 明細情報4;
    private RString jusho11;
    private RString jusho21;
    private RString jusho31;
    private RString jusho41;
    private RString jusho51;
    private RString name11;
    private RString name21;
    private RString name31;
    private RString barcodeCustombarcode1;
    private int seiriNo1;
    private RString meiboPage1;
    private RString meiboNo1;
    private RString tohyojoName11;
    private RString tohyojoName21;
    private RString oldJusho11;
    private RString oldJusho21;
    private RString oldJusho31;
    private RString barcodeBarcode1;
    private RString tohyoTimeStart1;
    private RString tohyoTimeEnd1;
    private RString jusho12;
    private RString jusho22;
    private RString jusho32;
    private RString jusho42;
    private RString jusho52;
    private RString name12;
    private RString name22;
    private RString name32;
    private RString barcodeCustombarcode2;
    private int seiriNo2;
    private RString meiboPage2;
    private RString meiboNo2;
    private RString tohyojoName12;
    private RString tohyojoName22;
    private RString oldJusho12;
    private RString oldJusho22;
    private RString oldJusho32;
    private RString barcodeBarcode2;
    private RString tohyoTimeStart2;
    private RString tohyoTimeEnd2;
    private RString jusho13;
    private RString jusho23;
    private RString jusho33;
    private RString jusho43;
    private RString jusho53;
    private RString name13;
    private RString name23;
    private RString name33;
    private RString barcodeCustombarcode3;
    private int seiriNo3;
    private RString meiboPage3;
    private RString meiboNo3;
    private RString tohyojoName13;
    private RString tohyojoName23;
    private RString oldJusho13;
    private RString oldJusho23;
    private RString oldJusho33;
    private RString barcodeBarcode3;
    private RString tohyoTimeStart3;
    private RString tohyoTimeEnd3;
    private RString jusho14;
    private RString jusho24;
    private RString jusho34;
    private RString jusho44;
    private RString jusho54;
    private RString name14;
    private RString name24;
    private RString name34;
    private RString barcodeCustombarcode4;
    private int seiriNo4;
    private RString meiboPage4;
    private RString meiboNo4;
    private RString tohyojoName14;
    private RString tohyojoName24;
    private RString oldJusho14;
    private RString oldJusho24;
    private RString oldJusho34;
    private RString barcodeBarcode4;
    private RString tohyoTimeStart4;
    private RString tohyoTimeEnd4;
    private RString seibetu1;
    private RString seibetu2;
    private RString seibetu3;
    private RString seibetu4;
    private RString seinengappi1;
    private RString seinengappi2;
    private RString seinengappi3;
    private RString seinengappi4;
    private RString mapJoho1;
    private RString mapJoho2;
    private RString mapJoho3;
    private RString mapJoho4;

    /**
     * コンストラクタです。
     *
     * @param 投票所入場券情報 NyujoukenGamenModel
     * @param 明細情報1 MeisaiJouhou
     * @param 明細情報2 MeisaiJouhou
     * @param 明細情報3 MeisaiJouhou
     * @param 明細情報4 MeisaiJouhou
     */
    public TenshutsuOshiraseHagakiParam(NyujoukenGamenModel 投票所入場券情報, MeisaiJouhou 明細情報1,
            MeisaiJouhou 明細情報2, MeisaiJouhou 明細情報3, MeisaiJouhou 明細情報4) {
        this.投票所入場券情報 = 投票所入場券情報;
        this.明細情報1 = 明細情報1;
        this.明細情報2 = 明細情報2;
        this.明細情報3 = 明細情報3;
        this.明細情報4 = 明細情報4;
    }

    /**
     * 投票所入場券情報を設定します。
     *
     * @param 投票所入場券情報 NyujoukenGamenModel
     */
    public void set投票所入場券情報(NyujoukenGamenModel 投票所入場券情報) {
        this.投票所入場券情報 = 投票所入場券情報;
    }

    /**
     * 明細情報1を設定します。
     *
     * @param 明細情報1 MeisaiJouhou
     */
    public void set明細情報1(MeisaiJouhou 明細情報1) {
        this.明細情報1 = 明細情報1;
    }

    /**
     * 明細情報2を設定します。
     *
     * @param 明細情報2 MeisaiJouhou
     */
    public void set明細情報2(MeisaiJouhou 明細情報2) {
        this.明細情報2 = 明細情報2;
    }

    /**
     * 明細情報3を設定します。
     *
     * @param 明細情報3 MeisaiJouhou
     */
    public void set明細情報3(MeisaiJouhou 明細情報3) {
        this.明細情報3 = 明細情報3;
    }

    /**
     * 明細情報4を設定します。
     *
     * @param 明細情報4 MeisaiJouhou
     */
    public void set明細情報4(MeisaiJouhou 明細情報4) {
        this.明細情報4 = 明細情報4;
    }

    /**
     * 投票所入場券情報を取得します。
     *
     * @return NyujoukenGamenModel
     */
    public NyujoukenGamenModel get投票所入場券情報() {
        return 投票所入場券情報;
    }

    /**
     * 明細情報1
     *
     * @return 明細情報1 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報1() {
        return 明細情報1;
    }

    /**
     * 明細情報2
     *
     * @return 明細情報2 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報2() {
        return 明細情報2;
    }

    /**
     * 明細情報3
     *
     * @return 明細情報3 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報3() {
        return 明細情報3;
    }

    /**
     * 明細情報4
     *
     * @return 明細情報4 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報4() {
        return 明細情報4;
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho11() {
        return this.jusho11;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho21() {
        return this.jusho21;
    }

    /**
     * 住所3を返します。
     *
     * @return 住所3 RString
     */
    public RString getJusho31() {
        return this.jusho31;
    }

    /**
     * 住所4を返します。
     *
     * @return 住所4 RString
     */
    public RString getJusho41() {
        return this.jusho41;
    }

    /**
     * 住所5を返します。
     *
     * @return 住所5 RString
     */
    public RString getJusho51() {
        return this.jusho51;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getName11() {
        return this.name11;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getName21() {
        return this.name21;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getName31() {
        return this.name31;
    }

    /**
     * カスタマーバーコードを返します。
     *
     * @return カスタマーバーコード RString
     */
    public RString getBarcodeCustombarcode1() {
        return this.barcodeCustombarcode1;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 int
     */
    public int getSeiriNo1() {
        return this.seiriNo1;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 RString
     */
    public RString getMeiboPage1() {
        return this.meiboPage1;
    }

    /**
     * 行を返します。
     *
     * @return 行 RString
     */
    public RString getMeiboNo1() {
        return this.meiboNo1;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoName11() {
        return this.tohyojoName11;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoName21() {
        return this.tohyojoName21;
    }

    /**
     * 転出前住所1を返します。
     *
     * @return 転出前住所1 RString
     */
    public RString getOldJusho11() {
        return this.oldJusho11;
    }

    /**
     * 転出前住所2を返します。
     *
     * @return 転出前住所2 RString
     */
    public RString getOldJusho21() {
        return this.oldJusho21;
    }

    /**
     * 転出前住所3を返します。
     *
     * @return 転出前住所3 RString
     */
    public RString getOldJusho31() {
        return this.oldJusho31;
    }

    /**
     * バーコード1を返します。
     *
     * @return バーコード1 RString
     */
    public RString getBarcodeBarcode1() {
        return this.barcodeBarcode1;
    }

    /**
     * 投票開始時刻を返します。
     *
     * @return 投票開始時刻 RString
     */
    public RString getTohyoTimeStart1() {
        return this.tohyoTimeStart1;
    }

    /**
     * 投票終了時刻を返します。
     *
     * @return 投票終了時刻 RString
     */
    public RString getTohyoTimeEnd1() {
        return this.tohyoTimeEnd1;
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho12() {
        return this.jusho12;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho22() {
        return this.jusho22;
    }

    /**
     * 住所3を返します。
     *
     * @return 住所3 RString
     */
    public RString getJusho32() {
        return this.jusho32;
    }

    /**
     * 住所4を返します。
     *
     * @return 住所4 RString
     */
    public RString getJusho42() {
        return this.jusho42;
    }

    /**
     * 住所5を返します。
     *
     * @return 住所5 RString
     */
    public RString getJusho52() {
        return this.jusho52;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getName12() {
        return this.name12;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getName22() {
        return this.name22;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getName32() {
        return this.name32;
    }

    /**
     * カスタマーバーコードを返します。
     *
     * @return カスタマーバーコード RString
     */
    public RString getBarcodeCustombarcode2() {
        return this.barcodeCustombarcode2;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 int
     */
    public int getSeiriNo2() {
        return this.seiriNo2;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 RString
     */
    public RString getMeiboPage2() {
        return this.meiboPage2;
    }

    /**
     * 行を返します。
     *
     * @return 行 RString
     */
    public RString getMeiboNo2() {
        return this.meiboNo2;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoName12() {
        return this.tohyojoName12;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoName22() {
        return this.tohyojoName22;
    }

    /**
     * 転出前住所1を返します。
     *
     * @return 転出前住所1 RString
     */
    public RString getOldJusho12() {
        return this.oldJusho12;
    }

    /**
     * 転出前住所2を返します。
     *
     * @return 転出前住所2 RString
     */
    public RString getOldJusho22() {
        return this.oldJusho22;
    }

    /**
     * 転出前住所3を返します。
     *
     * @return 転出前住所3 RString
     */
    public RString getOldJusho32() {
        return this.oldJusho32;
    }

    /**
     * バーコード1を返します。
     *
     * @return バーコード1 RString
     */
    public RString getBarcodeBarcode2() {
        return this.barcodeBarcode2;
    }

    /**
     * 投票開始時刻を返します。
     *
     * @return 投票開始時刻 RString
     */
    public RString getTohyoTimeStart2() {
        return this.tohyoTimeStart2;
    }

    /**
     * 投票終了時刻を返します。
     *
     * @return 投票終了時刻 RString
     */
    public RString getTohyoTimeEnd2() {
        return this.tohyoTimeEnd2;
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho13() {
        return this.jusho13;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho23() {
        return this.jusho23;
    }

    /**
     * 住所3を返します。
     *
     * @return 住所3 RString
     */
    public RString getJusho33() {
        return this.jusho33;
    }

    /**
     * 住所4を返します。
     *
     * @return 住所4 RString
     */
    public RString getJusho43() {
        return this.jusho43;
    }

    /**
     * 住所5を返します。
     *
     * @return 住所5 RString
     */
    public RString getJusho53() {
        return this.jusho53;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getName13() {
        return this.name13;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getName23() {
        return this.name23;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getName33() {
        return this.name33;
    }

    /**
     * カスタマーバーコードを返します。
     *
     * @return カスタマーバーコード RString
     */
    public RString getBarcodeCustombarcode3() {
        return this.barcodeCustombarcode3;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 int
     */
    public int getSeiriNo3() {
        return this.seiriNo3;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 RString
     */
    public RString getMeiboPage3() {
        return this.meiboPage3;
    }

    /**
     * 行を返します。
     *
     * @return 行 RString
     */
    public RString getMeiboNo3() {
        return this.meiboNo3;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoName13() {
        return this.tohyojoName13;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoName23() {
        return this.tohyojoName23;
    }

    /**
     * 転出前住所1を返します。
     *
     * @return 転出前住所1 RString
     */
    public RString getOldJusho13() {
        return this.oldJusho13;
    }

    /**
     * 転出前住所2を返します。
     *
     * @return 転出前住所2 RString
     */
    public RString getOldJusho23() {
        return this.oldJusho23;
    }

    /**
     * 転出前住所3を返します。
     *
     * @return 転出前住所3 RString
     */
    public RString getOldJusho33() {
        return this.oldJusho33;
    }

    /**
     * バーコード1を返します。
     *
     * @return バーコード1 RString
     */
    public RString getBarcodeBarcode3() {
        return this.barcodeBarcode3;
    }

    /**
     * 投票開始時刻を返します。
     *
     * @return 投票開始時刻 RString
     */
    public RString getTohyoTimeStart3() {
        return this.tohyoTimeStart3;
    }

    /**
     * 投票終了時刻を返します。
     *
     * @return 投票終了時刻 RString
     */
    public RString getTohyoTimeEnd3() {
        return this.tohyoTimeEnd3;
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho14() {
        return this.jusho14;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho24() {
        return this.jusho24;
    }

    /**
     * 住所3を返します。
     *
     * @return 住所3 RString
     */
    public RString getJusho34() {
        return this.jusho34;
    }

    /**
     * 住所4を返します。
     *
     * @return 住所4 RString
     */
    public RString getJusho44() {
        return this.jusho44;
    }

    /**
     * 住所5を返します。
     *
     * @return 住所5 RString
     */
    public RString getJusho54() {
        return this.jusho54;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getName14() {
        return this.name14;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getName24() {
        return this.name24;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getName34() {
        return this.name34;
    }

    /**
     * カスタマーバーコードを返します。
     *
     * @return カスタマーバーコード RString
     */
    public RString getBarcodeCustombarcode4() {
        return this.barcodeCustombarcode4;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 int
     */
    public int getSeiriNo4() {
        return this.seiriNo4;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 RString
     */
    public RString getMeiboPage4() {
        return this.meiboPage4;
    }

    /**
     * 行を返します。
     *
     * @return 行 RString
     */
    public RString getMeiboNo4() {
        return this.meiboNo4;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoName14() {
        return this.tohyojoName14;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoName24() {
        return this.tohyojoName24;
    }

    /**
     * 転出前住所1を返します。
     *
     * @return 転出前住所1 RString
     */
    public RString getOldJusho14() {
        return this.oldJusho14;
    }

    /**
     * 転出前住所2を返します。
     *
     * @return 転出前住所2 RString
     */
    public RString getOldJusho24() {
        return this.oldJusho24;
    }

    /**
     * 転出前住所3を返します。
     *
     * @return 転出前住所3 RString
     */
    public RString getOldJusho34() {
        return this.oldJusho34;
    }

    /**
     * バーコード1を返します。
     *
     * @return バーコード1 RString
     */
    public RString getBarcodeBarcode4() {
        return this.barcodeBarcode4;
    }

    /**
     * 投票開始時刻を返します。
     *
     * @return 投票開始時刻 RString
     */
    public RString getTohyoTimeStart4() {
        return this.tohyoTimeStart4;
    }

    /**
     * 投票終了時刻を返します。
     *
     * @return 投票終了時刻 RString
     */
    public RString getTohyoTimeEnd4() {
        return this.tohyoTimeEnd4;
    }

    /**
     * 住所1を設定します。
     *
     * @param jusho11 RString
     */
    public void setJusho11(RString jusho11) {
        this.jusho11 = jusho11;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho21 RString
     */
    public void setJusho21(RString jusho21) {
        this.jusho21 = jusho21;
    }

    /**
     * 住所3を設定します。
     *
     * @param jusho31 RString
     */
    public void setJusho31(RString jusho31) {
        this.jusho31 = jusho31;
    }

    /**
     * 住所4を設定します。
     *
     * @param jusho41 RString
     */
    public void setJusho41(RString jusho41) {
        this.jusho41 = jusho41;
    }

    /**
     * 住所5を設定します。
     *
     * @param jusho51 RString
     */
    public void setJusho51(RString jusho51) {
        this.jusho51 = jusho51;
    }

    /**
     * 名称1を設定します。
     *
     * @param name11 RString
     */
    public void setName11(RString name11) {
        this.name11 = name11;
    }

    /**
     * 名称2を設定します。
     *
     * @param name21 RString
     */
    public void setName21(RString name21) {
        this.name21 = name21;
    }

    /**
     * 名称3を設定します。
     *
     * @param name31 RString
     */
    public void setName31(RString name31) {
        this.name31 = name31;
    }

    /**
     * カスタマーバーコードを設定します。
     *
     * @param barcodeCustombarcode1 RString
     */
    public void setBarcodeCustombarcode1(RString barcodeCustombarcode1) {
        this.barcodeCustombarcode1 = barcodeCustombarcode1;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo1 int
     */
    public void setSeiriNo1(int seiriNo1) {
        this.seiriNo1 = seiriNo1;
    }

    /**
     * 頁を設定します。
     *
     * @param meiboPage1 RString
     */
    public void setMeiboPage1(RString meiboPage1) {
        this.meiboPage1 = meiboPage1;
    }

    /**
     * 行を設定します。
     *
     * @param meiboNo1 RString
     */
    public void setMeiboNo1(RString meiboNo1) {
        this.meiboNo1 = meiboNo1;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoName11 RString
     */
    public void setTohyojoName11(RString tohyojoName11) {
        this.tohyojoName11 = tohyojoName11;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoName21 RString
     */
    public void setTohyojoName21(RString tohyojoName21) {
        this.tohyojoName21 = tohyojoName21;
    }

    /**
     * 転出前住所1を設定します。
     *
     * @param oldJusho11 RString
     */
    public void setOldJusho11(RString oldJusho11) {
        this.oldJusho11 = oldJusho11;
    }

    /**
     * 転出前住所2を設定します。
     *
     * @param oldJusho21 RString
     */
    public void setOldJusho21(RString oldJusho21) {
        this.oldJusho21 = oldJusho21;
    }

    /**
     * 転出前住所3を設定します。
     *
     * @param oldJusho31 RString
     */
    public void setOldJusho31(RString oldJusho31) {
        this.oldJusho31 = oldJusho31;
    }

    /**
     * バーコード1を設定します。
     *
     * @param barcodeBarcode1 RString
     */
    public void setBarcodeBarcode1(RString barcodeBarcode1) {
        this.barcodeBarcode1 = barcodeBarcode1;
    }

    /**
     * 投票開始時刻を設定します。
     *
     * @param tohyoTimeStart1 RString
     */
    public void setTohyoTimeStart1(RString tohyoTimeStart1) {
        this.tohyoTimeStart1 = tohyoTimeStart1;
    }

    /**
     * 投票終了時刻を設定します。
     *
     * @param tohyoTimeEnd1 RString
     */
    public void setTohyoTimeEnd1(RString tohyoTimeEnd1) {
        this.tohyoTimeEnd1 = tohyoTimeEnd1;
    }

    /**
     * 住所1を設定します。
     *
     * @param jusho12 RString
     */
    public void setJusho12(RString jusho12) {
        this.jusho12 = jusho12;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho22 RString
     */
    public void setJusho22(RString jusho22) {
        this.jusho22 = jusho22;
    }

    /**
     * 住所3を設定します。
     *
     * @param jusho32 RString
     */
    public void setJusho32(RString jusho32) {
        this.jusho32 = jusho32;
    }

    /**
     * 住所4を設定します。
     *
     * @param jusho42 RString
     */
    public void setJusho42(RString jusho42) {
        this.jusho42 = jusho42;
    }

    /**
     * 住所5を設定します。
     *
     * @param jusho52 RString
     */
    public void setJusho52(RString jusho52) {
        this.jusho52 = jusho52;
    }

    /**
     * 名称1を設定します。
     *
     * @param name12 RString
     */
    public void setName12(RString name12) {
        this.name12 = name12;
    }

    /**
     * 名称2を設定します。
     *
     * @param name22 RString
     */
    public void setName22(RString name22) {
        this.name22 = name22;
    }

    /**
     * 名称3を設定します。
     *
     * @param name32 RString
     */
    public void setName32(RString name32) {
        this.name32 = name32;
    }

    /**
     * カスタマーバーコードを設定します。
     *
     * @param barcodeCustombarcode2 RString
     */
    public void setBarcodeCustombarcode2(RString barcodeCustombarcode2) {
        this.barcodeCustombarcode2 = barcodeCustombarcode2;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo2 int
     */
    public void setSeiriNo2(int seiriNo2) {
        this.seiriNo2 = seiriNo2;
    }

    /**
     * 頁を設定します。
     *
     * @param meiboPage2 RString
     */
    public void setMeiboPage2(RString meiboPage2) {
        this.meiboPage2 = meiboPage2;
    }

    /**
     * 行を設定します。
     *
     * @param meiboNo2 RString
     */
    public void setMeiboNo2(RString meiboNo2) {
        this.meiboNo2 = meiboNo2;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoName12 RString
     */
    public void setTohyojoName12(RString tohyojoName12) {
        this.tohyojoName12 = tohyojoName12;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoName22 RString
     */
    public void setTohyojoName22(RString tohyojoName22) {
        this.tohyojoName22 = tohyojoName22;
    }

    /**
     * 転出前住所1を設定します。
     *
     * @param oldJusho12 RString
     */
    public void setOldJusho12(RString oldJusho12) {
        this.oldJusho12 = oldJusho12;
    }

    /**
     * 転出前住所2を設定します。
     *
     * @param oldJusho22 RString
     */
    public void setOldJusho22(RString oldJusho22) {
        this.oldJusho22 = oldJusho22;
    }

    /**
     * 転出前住所3を設定します。
     *
     * @param oldJusho32 RString
     */
    public void setOldJusho32(RString oldJusho32) {
        this.oldJusho32 = oldJusho32;
    }

    /**
     * バーコード1を設定します。
     *
     * @param barcodeBarcode2 RString
     */
    public void setBarcodeBarcode2(RString barcodeBarcode2) {
        this.barcodeBarcode2 = barcodeBarcode2;
    }

    /**
     * 投票開始時刻を設定します。
     *
     * @param tohyoTimeStart2 RString
     */
    public void setTohyoTimeStart2(RString tohyoTimeStart2) {
        this.tohyoTimeStart2 = tohyoTimeStart2;
    }

    /**
     * 投票終了時刻を設定します。
     *
     * @param tohyoTimeEnd2 RString
     */
    public void setTohyoTimeEnd2(RString tohyoTimeEnd2) {
        this.tohyoTimeEnd2 = tohyoTimeEnd2;
    }

    /**
     * 住所1を設定します。
     *
     * @param jusho13 RString
     */
    public void setJusho13(RString jusho13) {
        this.jusho13 = jusho13;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho23 RString
     */
    public void setJusho23(RString jusho23) {
        this.jusho23 = jusho23;
    }

    /**
     * 住所3を設定します。
     *
     * @param jusho33 RString
     */
    public void setJusho33(RString jusho33) {
        this.jusho33 = jusho33;
    }

    /**
     * 住所4を設定します。
     *
     * @param jusho43 RString
     */
    public void setJusho43(RString jusho43) {
        this.jusho43 = jusho43;
    }

    /**
     * 住所5を設定します。
     *
     * @param jusho53 RString
     */
    public void setJusho53(RString jusho53) {
        this.jusho53 = jusho53;
    }

    /**
     * 名称1を設定します。
     *
     * @param name13 RString
     */
    public void setName13(RString name13) {
        this.name13 = name13;
    }

    /**
     * 名称2を設定します。
     *
     * @param name23 RString
     */
    public void setName23(RString name23) {
        this.name23 = name23;
    }

    /**
     * 名称3を設定します。
     *
     * @param name33 RString
     */
    public void setName33(RString name33) {
        this.name33 = name33;
    }

    /**
     * カスタマーバーコードを設定します。
     *
     * @param barcodeCustombarcode3 RString
     */
    public void setBarcodeCustombarcode3(RString barcodeCustombarcode3) {
        this.barcodeCustombarcode3 = barcodeCustombarcode3;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo3 int
     */
    public void setSeiriNo3(int seiriNo3) {
        this.seiriNo3 = seiriNo3;
    }

    /**
     * 頁を設定します。
     *
     * @param meiboPage3 RString
     */
    public void setMeiboPage3(RString meiboPage3) {
        this.meiboPage3 = meiboPage3;
    }

    /**
     * 行を設定します。
     *
     * @param meiboNo3 RString
     */
    public void setMeiboNo3(RString meiboNo3) {
        this.meiboNo3 = meiboNo3;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoName13 RString
     */
    public void setTohyojoName13(RString tohyojoName13) {
        this.tohyojoName13 = tohyojoName13;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoName23 RString
     */
    public void setTohyojoName23(RString tohyojoName23) {
        this.tohyojoName23 = tohyojoName23;
    }

    /**
     * 転出前住所1を設定します。
     *
     * @param oldJusho13 RString
     */
    public void setOldJusho13(RString oldJusho13) {
        this.oldJusho13 = oldJusho13;
    }

    /**
     * 転出前住所2を設定します。
     *
     * @param oldJusho23 RString
     */
    public void setOldJusho23(RString oldJusho23) {
        this.oldJusho23 = oldJusho23;
    }

    /**
     * 転出前住所3を設定します。
     *
     * @param oldJusho33 RString
     */
    public void setOldJusho33(RString oldJusho33) {
        this.oldJusho33 = oldJusho33;
    }

    /**
     * バーコード1を設定します。
     *
     * @param barcodeBarcode3 RString
     */
    public void setBarcodeBarcode3(RString barcodeBarcode3) {
        this.barcodeBarcode3 = barcodeBarcode3;
    }

    /**
     * 投票開始時刻を設定します。
     *
     * @param tohyoTimeStart3 RString
     */
    public void setTohyoTimeStart3(RString tohyoTimeStart3) {
        this.tohyoTimeStart3 = tohyoTimeStart3;
    }

    /**
     * 投票終了時刻を設定します。
     *
     * @param tohyoTimeEnd3 RString
     */
    public void setTohyoTimeEnd3(RString tohyoTimeEnd3) {
        this.tohyoTimeEnd3 = tohyoTimeEnd3;
    }

    /**
     * 住所1を設定します。
     *
     * @param jusho14 RString
     */
    public void setJusho14(RString jusho14) {
        this.jusho14 = jusho14;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho24 RString
     */
    public void setJusho24(RString jusho24) {
        this.jusho24 = jusho24;
    }

    /**
     * 住所3を設定します。
     *
     * @param jusho34 RString
     */
    public void setJusho34(RString jusho34) {
        this.jusho34 = jusho34;
    }

    /**
     * 住所4を設定します。
     *
     * @param jusho44 RString
     */
    public void setJusho44(RString jusho44) {
        this.jusho44 = jusho44;
    }

    /**
     * 住所5を設定します。
     *
     * @param jusho54 RString
     */
    public void setJusho54(RString jusho54) {
        this.jusho54 = jusho54;
    }

    /**
     * 名称1を設定します。
     *
     * @param name14 RString
     */
    public void setName14(RString name14) {
        this.name14 = name14;
    }

    /**
     * 名称2を設定します。
     *
     * @param name24 RString
     */
    public void setName24(RString name24) {
        this.name24 = name24;
    }

    /**
     * 名称3を設定します。
     *
     * @param name34 RString
     */
    public void setName34(RString name34) {
        this.name34 = name34;
    }

    /**
     * カスタマーバーコードを設定します。
     *
     * @param barcodeCustombarcode4 RString
     */
    public void setBarcodeCustombarcode4(RString barcodeCustombarcode4) {
        this.barcodeCustombarcode4 = barcodeCustombarcode4;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo4 int
     */
    public void setSeiriNo4(int seiriNo4) {
        this.seiriNo4 = seiriNo4;
    }

    /**
     * 頁を設定します。
     *
     * @param meiboPage4 RString
     */
    public void setMeiboPage4(RString meiboPage4) {
        this.meiboPage4 = meiboPage4;
    }

    /**
     * 行を設定します。
     *
     * @param meiboNo4 RString
     */
    public void setMeiboNo4(RString meiboNo4) {
        this.meiboNo4 = meiboNo4;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoName14 RString
     */
    public void setTohyojoName14(RString tohyojoName14) {
        this.tohyojoName14 = tohyojoName14;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoName24 RString
     */
    public void setTohyojoName24(RString tohyojoName24) {
        this.tohyojoName24 = tohyojoName24;
    }

    /**
     * 転出前住所1を設定します。
     *
     * @param oldJusho14 RString
     */
    public void setOldJusho14(RString oldJusho14) {
        this.oldJusho14 = oldJusho14;
    }

    /**
     * 転出前住所2を設定します。
     *
     * @param oldJusho24 RString
     */
    public void setOldJusho24(RString oldJusho24) {
        this.oldJusho24 = oldJusho24;
    }

    /**
     * 転出前住所3を設定します。
     *
     * @param oldJusho34 RString
     */
    public void setOldJusho34(RString oldJusho34) {
        this.oldJusho34 = oldJusho34;
    }

    /**
     * バーコード1を設定します。
     *
     * @param barcodeBarcode4 RString
     */
    public void setBarcodeBarcode4(RString barcodeBarcode4) {
        this.barcodeBarcode4 = barcodeBarcode4;
    }

    /**
     * 投票開始時刻を設定します。
     *
     * @param tohyoTimeStart4 RString
     */
    public void setTohyoTimeStart4(RString tohyoTimeStart4) {
        this.tohyoTimeStart4 = tohyoTimeStart4;
    }

    /**
     * 投票終了時刻を設定します。
     *
     * @param tohyoTimeEnd4 RString
     */
    public void setTohyoTimeEnd4(RString tohyoTimeEnd4) {
        this.tohyoTimeEnd4 = tohyoTimeEnd4;
    }

    /**
     * seibetu1を返します。
     *
     * @return seibetu1 RString
     */
    public RString getSeibetu1() {
        return this.seibetu1;
    }

    /**
     * seibetu2を返します。
     *
     * @return seibetu2 RString
     */
    public RString getSeibetu2() {
        return this.seibetu2;
    }

    /**
     * seibetu3を返します。
     *
     * @return seibetu3 RString
     */
    public RString getSeibetu3() {
        return this.seibetu3;
    }

    /**
     * seibetu4を返します。
     *
     * @return seibetu4 RString
     */
    public RString getSeibetu4() {
        return this.seibetu4;
    }

    /**
     * seinengappi1を返します。
     *
     * @return seinengappi1 RString
     */
    public RString getSeinengappi1() {
        return this.seinengappi1;
    }

    /**
     * seinengappi2を返します。
     *
     * @return seinengappi2 RString
     */
    public RString getSeinengappi2() {
        return this.seinengappi2;
    }

    /**
     * seinengappi3を返します。
     *
     * @return seinengappi3 RString
     */
    public RString getSeinengappi3() {
        return this.seinengappi3;
    }

    /**
     * seinengappi4を返します。
     *
     * @return seinengappi4 RString
     */
    public RString getSeinengappi4() {
        return this.seinengappi4;
    }

    /**
     * seibetu1を設定します。
     *
     * @param seibetu1 RString
     */
    public void setSeibetu1(RString seibetu1) {
        this.seibetu1 = seibetu1;
    }

    /**
     * seibetu2を設定します。
     *
     * @param seibetu2 RString
     */
    public void setSeibetu2(RString seibetu2) {
        this.seibetu2 = seibetu2;
    }

    /**
     * seibetu3を設定します。
     *
     * @param seibetu3 RString
     */
    public void setSeibetu3(RString seibetu3) {
        this.seibetu3 = seibetu3;
    }

    /**
     * seibetu4を設定します。
     *
     * @param seibetu4 RString
     */
    public void setSeibetu4(RString seibetu4) {
        this.seibetu4 = seibetu4;
    }

    /**
     * seinengappi1を設定します。
     *
     * @param seinengappi1 RString
     */
    public void setSeinengappi1(RString seinengappi1) {
        this.seinengappi1 = seinengappi1;
    }

    /**
     * seinengappi2を設定します。
     *
     * @param seinengappi2 RString
     */
    public void setSeinengappi2(RString seinengappi2) {
        this.seinengappi2 = seinengappi2;
    }

    /**
     * seinengappi3を設定します。
     *
     * @param seinengappi3 RString
     */
    public void setSeinengappi3(RString seinengappi3) {
        this.seinengappi3 = seinengappi3;
    }

    /**
     * seinengappi4を設定します。
     *
     * @param seinengappi4 RString
     */
    public void setSeinengappi4(RString seinengappi4) {
        this.seinengappi4 = seinengappi4;
    }

    /**
     * mapJoho1を設定します。
     *
     * @param mapJoho1 RString
     */
    public void setMapJoho1(RString mapJoho1) {
        this.mapJoho1 = mapJoho1;
    }

    /**
     * mapJoho2を設定します。
     *
     * @param mapJoho2 RString
     */
    public void setMapJoho2(RString mapJoho2) {
        this.mapJoho2 = mapJoho2;
    }

    /**
     * mapJoho3を設定します。
     *
     * @param mapJoho3 RString
     */
    public void setMapJoho3(RString mapJoho3) {
        this.mapJoho3 = mapJoho3;
    }

    /**
     * mapJoho4を設定します。
     *
     * @param mapJoho4 RString
     */
    public void setMapJoho4(RString mapJoho4) {
        this.mapJoho4 = mapJoho4;
    }

    /**
     * mapJoho1を返します。
     *
     * @return mapJoho1 RString
     */
    public RString getMapJoho1() {
        return this.mapJoho1;
    }

    /**
     * mapJoho2を返します。
     *
     * @return mapJoho2 RString
     */
    public RString getMapJoho2() {
        return this.mapJoho2;
    }

    /**
     * mapJoho3を返します。
     *
     * @return mapJoho3 RString
     */
    public RString getMapJoho3() {
        return this.mapJoho3;
    }

    /**
     * mapJoho4を返します。
     *
     * @return mapJoho4 RString
     */
    public RString getMapJoho4() {
        return this.mapJoho4;
    }

}
