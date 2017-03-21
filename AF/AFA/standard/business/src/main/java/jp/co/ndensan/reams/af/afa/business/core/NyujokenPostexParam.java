/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票所入場券（ポステックス）
 *
 * @reamsid_L AF-0160-034 guyq
 */
public class NyujokenPostexParam extends NyujokenPostexParentParam {

    private NyujoukenGamenModel 入場券帳票作成入力情報;
    private SoufusakiJouhou 送付先情報1;
    private SoufusakiJouhou 送付先情報2;
    private SoufusakiJouhou 送付先情報3;
    private SoufusakiJouhou 送付先情報4;
    private MeisaiJouhou 明細情報1;
    private MeisaiJouhou 明細情報2;
    private MeisaiJouhou 明細情報3;
    private MeisaiJouhou 明細情報4;
    private MeisaiJouhou 明細情報5;
    private MeisaiJouhou 明細情報6;
    private MeisaiJouhou 明細情報7;
    private MeisaiJouhou 明細情報8;

    private RString yubinNo11;
    private RString yubinNo21;
    private RString barcodeCustombarcode1;
    private RString sofusakiGyoseikuMei11;
    private RString sofusakiGyoseikuMei21;
    private RString sofusakiGyoseikuMei31;
    private RString sofusakiJusho11;
    private RString sofusakiJusho21;
    private RString sofusakiJusho31;
    private RString sofusakiJusho41;
    private RString sofusakiJusho51;
    private RString atena11;
    private RString atena21;
    private RString atena31;
    private RString sofusakiMeiboNo1;
    private RString jusho11;
    private RString jusho21;
    private RString shimei11;
    private RString shimei21;
    private RString shimei31;
    private RString seibetsu1;
    private RString tohyojoMei11;
    private RString tohyojoMei21;
    private RString tohyojoMei31;
    private RString barcodeNyujokenBarcode1;
    private RString barcodeNyujokenBarcode2;
    private RString barcodeNyujokenBarcode3;
    private RString barcodeNyujokenBarcode4;
    private RString barcodeNyujokenBarcode5;
    private RString barcodeNyujokenBarcode6;

    private Integer seiriNo1;
    private RString jusho12;
    private RString jusho22;
    private RString jusho13;
    private RString jusho23;
    private RString jusho14;
    private RString jusho24;
    private RString jusho15;
    private RString jusho25;
    private RString jusho16;
    private RString jusho26;
    private RString shimei12;
    private RString shimei22;
    private RString shimei32;
    private RString shimei13;
    private RString shimei23;
    private RString shimei33;
    private RString shimei14;
    private RString shimei24;
    private RString shimei34;
    private RString shimei15;
    private RString shimei25;
    private RString shimei35;
    private RString shimei16;
    private RString shimei26;
    private RString shimei36;
    private RString seibetsu2;
    private RString seibetsu3;
    private RString seibetsu4;
    private RString seibetsu5;
    private RString seibetsu6;
    private RString tohyojoMei12;
    private RString tohyojoMei22;
    private RString tohyojoMei32;
    private RString tohyojoMei13;
    private RString tohyojoMei23;
    private RString tohyojoMei33;
    private RString tohyojoMei14;
    private RString tohyojoMei24;
    private RString tohyojoMei34;
    private RString tohyojoMei15;
    private RString tohyojoMei25;
    private RString tohyojoMei35;
    private RString tohyojoMei16;
    private RString tohyojoMei26;
    private RString tohyojoMei36;
    private Association 地方公共団体情報;

    /**
     * コンストラクタです。
     *
     * @param 入場券帳票作成入力情報 NyujoukenGamenModel
     * @param 送付先情報1 SoufusakiJouhou
     * @param 送付先情報2 SoufusakiJouhou
     * @param 送付先情報3 SoufusakiJouhou
     * @param 送付先情報4 SoufusakiJouhou
     * @param 明細情報1 MeisaiJouhou
     * @param 明細情報2 MeisaiJouhou
     * @param 明細情報3 MeisaiJouhou
     * @param 明細情報4 MeisaiJouhou
     * @param 明細情報5 MeisaiJouhou
     * @param 明細情報6 MeisaiJouhou
     * @param 明細情報7 MeisaiJouhou
     * @param 明細情報8 MeisaiJouhou
     */
    public NyujokenPostexParam(NyujoukenGamenModel 入場券帳票作成入力情報, SoufusakiJouhou 送付先情報1,
            SoufusakiJouhou 送付先情報2, SoufusakiJouhou 送付先情報3, SoufusakiJouhou 送付先情報4,
            MeisaiJouhou 明細情報1, MeisaiJouhou 明細情報2, MeisaiJouhou 明細情報3, MeisaiJouhou 明細情報4,
            MeisaiJouhou 明細情報5, MeisaiJouhou 明細情報6, MeisaiJouhou 明細情報7, MeisaiJouhou 明細情報8) {
        this.入場券帳票作成入力情報 = 入場券帳票作成入力情報;
        this.送付先情報1 = 送付先情報1;
        this.送付先情報2 = 送付先情報2;
        this.送付先情報3 = 送付先情報3;
        this.送付先情報4 = 送付先情報4;
        this.明細情報1 = 明細情報1;
        this.明細情報2 = 明細情報2;
        this.明細情報3 = 明細情報3;
        this.明細情報4 = 明細情報4;
        this.明細情報5 = 明細情報5;
        this.明細情報6 = 明細情報6;
        this.明細情報7 = 明細情報7;
        this.明細情報8 = 明細情報8;
    }

    /**
     * 入場券帳票作成入力情報を設定します。
     *
     * @param 入場券帳票作成入力情報 NyujoukenGamenModel
     */
    public void set入場券帳票作成入力情報(NyujoukenGamenModel 入場券帳票作成入力情報) {
        this.入場券帳票作成入力情報 = 入場券帳票作成入力情報;
    }

    /**
     * 送付先情報1を設定します。
     *
     * @param 送付先情報1 SoufusakiJouhou
     */
    public void set送付先情報1(SoufusakiJouhou 送付先情報1) {
        this.送付先情報1 = 送付先情報1;
    }

    /**
     * 送付先情報2を設定します。
     *
     * @param 送付先情報2 SoufusakiJouhou
     */
    public void set送付先情報2(SoufusakiJouhou 送付先情報2) {
        this.送付先情報2 = 送付先情報2;
    }

    /**
     * 送付先情報3を設定します。
     *
     * @param 送付先情報3 SoufusakiJouhou
     */
    public void set送付先情報3(SoufusakiJouhou 送付先情報3) {
        this.送付先情報3 = 送付先情報3;
    }

    /**
     * 送付先情報4を設定します。
     *
     * @param 送付先情報4 SoufusakiJouhou
     */
    public void set送付先情報4(SoufusakiJouhou 送付先情報4) {
        this.送付先情報4 = 送付先情報4;
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
     * 明細情報5を設定します。
     *
     * @param 明細情報5 MeisaiJouhou
     */
    public void set明細情報5(MeisaiJouhou 明細情報5) {
        this.明細情報5 = 明細情報5;
    }

    /**
     * 明細情報6を設定します。
     *
     * @param 明細情報6 MeisaiJouhou
     */
    public void set明細情報6(MeisaiJouhou 明細情報6) {
        this.明細情報6 = 明細情報6;
    }

    /**
     * 明細情報7を設定します。
     *
     * @param 明細情報7 MeisaiJouhou
     */
    public void set明細情報7(MeisaiJouhou 明細情報7) {
        this.明細情報7 = 明細情報7;
    }

    /**
     * 明細情報8を設定します。
     *
     * @param 明細情報8 MeisaiJouhou
     */
    public void set明細情報8(MeisaiJouhou 明細情報8) {
        this.明細情報8 = 明細情報8;
    }

    /**
     * 入場券帳票作成入力情報
     *
     * @return 入場券帳票作成入力情報 NyujoukenGamenParam
     */
    public NyujoukenGamenModel get入場券帳票作成入力情報() {
        return 入場券帳票作成入力情報;
    }

    /**
     * 送付先情報1
     *
     * @return 送付先情報1 SoufusakiJouhou
     */
    public SoufusakiJouhou get送付先情報1() {
        return 送付先情報1;
    }

    /**
     * 送付先情報2
     *
     * @return 送付先情報2 SoufusakiJouhou
     */
    public SoufusakiJouhou get送付先情報2() {
        return 送付先情報2;
    }

    /**
     * 送付先情報3
     *
     * @return 送付先情報3 SoufusakiJouhou
     */
    public SoufusakiJouhou get送付先情報3() {
        return 送付先情報3;
    }

    /**
     * 送付先情報4
     *
     * @return 送付先情報4 SoufusakiJouhou
     */
    public SoufusakiJouhou get送付先情報4() {
        return 送付先情報4;
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
     * 明細情報5
     *
     * @return 明細情報5 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報5() {
        return 明細情報5;
    }

    /**
     * 明細情報6
     *
     * @return 明細情報6 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報6() {
        return 明細情報6;
    }

    /**
     * 明細情報7
     *
     * @return 明細情報7 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報7() {
        return 明細情報7;
    }

    /**
     * 明細情報8
     *
     * @return 明細情報8 MeisaiJouhou
     */
    public MeisaiJouhou get明細情報8() {
        return 明細情報8;
    }

    /**
     * 送付先郵便番号3桁を返します。
     *
     * @return 送付先郵便番号3桁 RString
     */
    public RString getYubinNo11() {
        return this.yubinNo11;
    }

    /**
     * 送付先郵便番号4桁を返します。
     *
     * @return 送付先郵便番号4桁 RString
     */
    public RString getYubinNo21() {
        return this.yubinNo21;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 Integer
     */
    public Integer getSeiriNo1() {
        return this.seiriNo1;
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
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho15() {
        return this.jusho15;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho25() {
        return this.jusho25;
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho16() {
        return this.jusho16;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho26() {
        return this.jusho26;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getShimei12() {
        return this.shimei12;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getShimei22() {
        return this.shimei22;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getShimei32() {
        return this.shimei32;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getShimei13() {
        return this.shimei13;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getShimei23() {
        return this.shimei23;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getShimei33() {
        return this.shimei33;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getShimei14() {
        return this.shimei14;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getShimei24() {
        return this.shimei24;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getShimei34() {
        return this.shimei34;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getShimei15() {
        return this.shimei15;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getShimei25() {
        return this.shimei25;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getShimei35() {
        return this.shimei35;
    }

    /**
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getShimei16() {
        return this.shimei16;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getShimei26() {
        return this.shimei26;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getShimei36() {
        return this.shimei36;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu2() {
        return this.seibetsu2;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu3() {
        return this.seibetsu3;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu4() {
        return this.seibetsu4;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu5() {
        return this.seibetsu5;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu6() {
        return this.seibetsu6;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei12() {
        return this.tohyojoMei12;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei22() {
        return this.tohyojoMei22;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei32() {
        return this.tohyojoMei32;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei13() {
        return this.tohyojoMei13;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei23() {
        return this.tohyojoMei23;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei33() {
        return this.tohyojoMei33;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei14() {
        return this.tohyojoMei14;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei24() {
        return this.tohyojoMei24;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei34() {
        return this.tohyojoMei34;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei15() {
        return this.tohyojoMei15;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei25() {
        return this.tohyojoMei25;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei35() {
        return this.tohyojoMei35;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei16() {
        return this.tohyojoMei16;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei26() {
        return this.tohyojoMei26;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei36() {
        return this.tohyojoMei36;
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
     * 送付先行政区名1を返します。
     *
     * @return 送付先行政区名1 RString
     */
    public RString getSofusakiGyoseikuMei11() {
        return this.sofusakiGyoseikuMei11;
    }

    /**
     * 送付先行政区名2を返します。
     *
     * @return 送付先行政区名2 RString
     */
    public RString getSofusakiGyoseikuMei21() {
        return this.sofusakiGyoseikuMei21;
    }

    /**
     * 送付先行政区名3を返します。
     *
     * @return 送付先行政区名3 RString
     */
    public RString getSofusakiGyoseikuMei31() {
        return this.sofusakiGyoseikuMei31;
    }

    /**
     * 送付先住所1を返します。
     *
     * @return 送付先住所1 RString
     */
    public RString getSofusakiJusho11() {
        return this.sofusakiJusho11;
    }

    /**
     * 送付先住所2を返します。
     *
     * @return 送付先住所2 RString
     */
    public RString getSofusakiJusho21() {
        return this.sofusakiJusho21;
    }

    /**
     * 送付先住所3を返します。
     *
     * @return 送付先住所3 RString
     */
    public RString getSofusakiJusho31() {
        return this.sofusakiJusho31;
    }

    /**
     * 送付先住所4を返します。
     *
     * @return 送付先住所4 RString
     */
    public RString getSofusakiJusho41() {
        return this.sofusakiJusho41;
    }

    /**
     * 送付先住所5を返します。
     *
     * @return 送付先住所5 RString
     */
    public RString getSofusakiJusho51() {
        return this.sofusakiJusho51;
    }

    /**
     * 宛名1を返します。
     *
     * @return 宛名1 RString
     */
    public RString getAtena11() {
        return this.atena11;
    }

    /**
     * 宛名2を返します。
     *
     * @return 宛名2 RString
     */
    public RString getAtena21() {
        return this.atena21;
    }

    /**
     * 宛名3を返します。
     *
     * @return 宛名3 RString
     */
    public RString getAtena31() {
        return this.atena31;
    }

    /**
     * 送付先名簿番号を返します。
     *
     * @return 送付先名簿番号 RString
     */
    public RString getSofusakiMeiboNo1() {
        return this.sofusakiMeiboNo1;
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
     * 名称1を返します。
     *
     * @return 名称1 RString
     */
    public RString getShimei11() {
        return this.shimei11;
    }

    /**
     * 名称2を返します。
     *
     * @return 名称2 RString
     */
    public RString getShimei21() {
        return this.shimei21;
    }

    /**
     * 名称3を返します。
     *
     * @return 名称3 RString
     */
    public RString getShimei31() {
        return this.shimei31;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu1() {
        return this.seibetsu1;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei11() {
        return this.tohyojoMei11;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei21() {
        return this.tohyojoMei21;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei31() {
        return this.tohyojoMei31;
    }

    /**
     * 入場券バーコードを返します。
     *
     * @return 入場券バーコード1 RString
     */
    public RString getBarcodeNyujokenBarcode1() {
        return this.barcodeNyujokenBarcode1;
    }

    /**
     * 入場券バーコードを返します。
     *
     * @return 入場券バーコード2 RString
     */
    public RString getBarcodeNyujokenBarcode2() {
        return this.barcodeNyujokenBarcode2;
    }

    /**
     * 入場券バーコードを返します。
     *
     * @return 入場券バーコード3 RString
     */
    public RString getBarcodeNyujokenBarcode3() {
        return this.barcodeNyujokenBarcode3;
    }

    /**
     * 入場券バーコードを返します。
     *
     * @return 入場券バーコード4 RString
     */
    public RString getBarcodeNyujokenBarcode4() {
        return this.barcodeNyujokenBarcode4;
    }

    /**
     * 入場券バーコードを返します。
     *
     * @return 入場券バーコード5 RString
     */
    public RString getBarcodeNyujokenBarcode5() {
        return this.barcodeNyujokenBarcode5;
    }

    /**
     * 入場券バーコードを返します。
     *
     * @return 入場券バーコード6 RString
     */
    public RString getBarcodeNyujokenBarcode6() {
        return this.barcodeNyujokenBarcode6;
    }

    /**
     * 送付先郵便番号3桁を設定します。
     *
     * @param yubinNo11 RString
     */
    public void setYubinNo11(RString yubinNo11) {
        this.yubinNo11 = yubinNo11;
    }

    /**
     * 送付先郵便番号4桁を設定します。
     *
     * @param yubinNo21 RString
     */
    public void setYubinNo21(RString yubinNo21) {
        this.yubinNo21 = yubinNo21;
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
     * 送付先行政区名1を設定します。
     *
     * @param sofusakiGyoseikuMei11 RString
     */
    public void setSofusakiGyoseikuMei11(RString sofusakiGyoseikuMei11) {
        this.sofusakiGyoseikuMei11 = sofusakiGyoseikuMei11;
    }

    /**
     * 送付先行政区名2を設定します。
     *
     * @param sofusakiGyoseikuMei21 RString
     */
    public void setSofusakiGyoseikuMei21(RString sofusakiGyoseikuMei21) {
        this.sofusakiGyoseikuMei21 = sofusakiGyoseikuMei21;
    }

    /**
     * 送付先行政区名3を設定します。
     *
     * @param sofusakiGyoseikuMei31 RString
     */
    public void setSofusakiGyoseikuMei31(RString sofusakiGyoseikuMei31) {
        this.sofusakiGyoseikuMei31 = sofusakiGyoseikuMei31;
    }

    /**
     * 送付先住所1を設定します。
     *
     * @param sofusakiJusho11 RString
     */
    public void setSofusakiJusho11(RString sofusakiJusho11) {
        this.sofusakiJusho11 = sofusakiJusho11;
    }

    /**
     * 送付先住所2を設定します。
     *
     * @param sofusakiJusho21 RString
     */
    public void setSofusakiJusho21(RString sofusakiJusho21) {
        this.sofusakiJusho21 = sofusakiJusho21;
    }

    /**
     * 送付先住所3を設定します。
     *
     * @param sofusakiJusho31 RString
     */
    public void setSofusakiJusho31(RString sofusakiJusho31) {
        this.sofusakiJusho31 = sofusakiJusho31;
    }

    /**
     * 送付先住所4を設定します。
     *
     * @param sofusakiJusho41 RString
     */
    public void setSofusakiJusho41(RString sofusakiJusho41) {
        this.sofusakiJusho41 = sofusakiJusho41;
    }

    /**
     * 送付先住所5を設定します。
     *
     * @param sofusakiJusho51 RString
     */
    public void setSofusakiJusho51(RString sofusakiJusho51) {
        this.sofusakiJusho51 = sofusakiJusho51;
    }

    /**
     * 宛名1を設定します。
     *
     * @param atena11 RString
     */
    public void setAtena11(RString atena11) {
        this.atena11 = atena11;
    }

    /**
     * 宛名2を設定します。
     *
     * @param atena21 RString
     */
    public void setAtena21(RString atena21) {
        this.atena21 = atena21;
    }

    /**
     * 宛名3を設定します。
     *
     * @param atena31 RString
     */
    public void setAtena31(RString atena31) {
        this.atena31 = atena31;
    }

    /**
     * 送付先名簿番号を設定します。
     *
     * @param sofusakiMeiboNo1 RString
     */
    public void setSofusakiMeiboNo1(RString sofusakiMeiboNo1) {
        this.sofusakiMeiboNo1 = sofusakiMeiboNo1;
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
     * 名称1を設定します。
     *
     * @param shimei11 RString
     */
    public void setShimei11(RString shimei11) {
        this.shimei11 = shimei11;
    }

    /**
     * 名称2を設定します。
     *
     * @param shimei21 RString
     */
    public void setShimei21(RString shimei21) {
        this.shimei21 = shimei21;
    }

    /**
     * 名称3を設定します。
     *
     * @param shimei31 RString
     */
    public void setShimei31(RString shimei31) {
        this.shimei31 = shimei31;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu1 RString
     */
    public void setSeibetsu1(RString seibetsu1) {
        this.seibetsu1 = seibetsu1;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei11 RString
     */
    public void setTohyojoMei11(RString tohyojoMei11) {
        this.tohyojoMei11 = tohyojoMei11;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei21 RString
     */
    public void setTohyojoMei21(RString tohyojoMei21) {
        this.tohyojoMei21 = tohyojoMei21;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei31 RString
     */
    public void setTohyojoMei31(RString tohyojoMei31) {
        this.tohyojoMei31 = tohyojoMei31;
    }

    /**
     * 入場券バーコードを設定します。
     *
     * @param barcodeNyujokenBarcode1 RString
     */
    public void setBarcodeNyujokenBarcode1(RString barcodeNyujokenBarcode1) {
        this.barcodeNyujokenBarcode1 = barcodeNyujokenBarcode1;
    }

    /**
     * 入場券バーコードを設定します。
     *
     * @param barcodeNyujokenBarcode2 RString
     */
    public void setBarcodeNyujokenBarcode2(RString barcodeNyujokenBarcode2) {
        this.barcodeNyujokenBarcode2 = barcodeNyujokenBarcode2;
    }

    /**
     * 入場券バーコードを設定します。
     *
     * @param barcodeNyujokenBarcode3 RString
     */
    public void setBarcodeNyujokenBarcode3(RString barcodeNyujokenBarcode3) {
        this.barcodeNyujokenBarcode3 = barcodeNyujokenBarcode3;
    }

    /**
     * 入場券バーコードを設定します。
     *
     * @param barcodeNyujokenBarcode4 RString
     */
    public void setBarcodeNyujokenBarcode4(RString barcodeNyujokenBarcode4) {
        this.barcodeNyujokenBarcode4 = barcodeNyujokenBarcode4;
    }

    /**
     * 入場券バーコードを設定します。
     *
     * @param barcodeNyujokenBarcode5 RString
     */
    public void setBarcodeNyujokenBarcode5(RString barcodeNyujokenBarcode5) {
        this.barcodeNyujokenBarcode5 = barcodeNyujokenBarcode5;
    }

    /**
     * 入場券バーコードを設定します。
     *
     * @param barcodeNyujokenBarcode6 RString
     */
    public void setBarcodeNyujokenBarcode6(RString barcodeNyujokenBarcode6) {
        this.barcodeNyujokenBarcode6 = barcodeNyujokenBarcode6;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo1 RString
     */
    public void setSeiriNo1(int seiriNo1) {
        this.seiriNo1 = seiriNo1;
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
     * 住所1を設定します。
     *
     * @param jusho15 RString
     */
    public void setJusho15(RString jusho15) {
        this.jusho15 = jusho15;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho25 RString
     */
    public void setJusho25(RString jusho25) {
        this.jusho25 = jusho25;
    }

    /**
     * 住所1を設定します。
     *
     * @param jusho16 RString
     */
    public void setJusho16(RString jusho16) {
        this.jusho16 = jusho16;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho26 RString
     */
    public void setJusho26(RString jusho26) {
        this.jusho26 = jusho26;
    }

    /**
     * 名称1を設定します。
     *
     * @param shimei12 RString
     */
    public void setShimei12(RString shimei12) {
        this.shimei12 = shimei12;
    }

    /**
     * 名称2を設定します。
     *
     * @param shimei22 RString
     */
    public void setShimei22(RString shimei22) {
        this.shimei22 = shimei22;
    }

    /**
     * 名称3を設定します。
     *
     * @param shimei32 RString
     */
    public void setShimei32(RString shimei32) {
        this.shimei32 = shimei32;
    }

    /**
     * 名称1を設定します。
     *
     * @param shimei13 RString
     */
    public void setShimei13(RString shimei13) {
        this.shimei13 = shimei13;
    }

    /**
     * 名称2を設定します。
     *
     * @param shimei23 RString
     */
    public void setShimei23(RString shimei23) {
        this.shimei23 = shimei23;
    }

    /**
     * 名称3を設定します。
     *
     * @param shimei33 RString
     */
    public void setShimei33(RString shimei33) {
        this.shimei33 = shimei33;
    }

    /**
     * 名称1を設定します。
     *
     * @param shimei14 RString
     */
    public void setShimei14(RString shimei14) {
        this.shimei14 = shimei14;
    }

    /**
     * 名称2を設定します。
     *
     * @param shimei24 RString
     */
    public void setShimei24(RString shimei24) {
        this.shimei24 = shimei24;
    }

    /**
     * 名称3を設定します。
     *
     * @param shimei34 RString
     */
    public void setShimei34(RString shimei34) {
        this.shimei34 = shimei34;
    }

    /**
     * 名称1を設定します。
     *
     * @param shimei15 RString
     */
    public void setShimei15(RString shimei15) {
        this.shimei15 = shimei15;
    }

    /**
     * 名称2を設定します。
     *
     * @param shimei25 RString
     */
    public void setShimei25(RString shimei25) {
        this.shimei25 = shimei25;
    }

    /**
     * 名称3を設定します。
     *
     * @param shimei35 RString
     */
    public void setShimei35(RString shimei35) {
        this.shimei35 = shimei35;
    }

    /**
     * 名称1を設定します。
     *
     * @param shimei16 RString
     */
    public void setShimei16(RString shimei16) {
        this.shimei16 = shimei16;
    }

    /**
     * 名称2を設定します。
     *
     * @param shimei26 RString
     */
    public void setShimei26(RString shimei26) {
        this.shimei26 = shimei26;
    }

    /**
     * 名称3を設定します。
     *
     * @param shimei36 RString
     */
    public void setShimei36(RString shimei36) {
        this.shimei36 = shimei36;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu2 RString
     */
    public void setSeibetsu2(RString seibetsu2) {
        this.seibetsu2 = seibetsu2;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu3 RString
     */
    public void setSeibetsu3(RString seibetsu3) {
        this.seibetsu3 = seibetsu3;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu4 RString
     */
    public void setSeibetsu4(RString seibetsu4) {
        this.seibetsu4 = seibetsu4;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu5 RString
     */
    public void setSeibetsu5(RString seibetsu5) {
        this.seibetsu5 = seibetsu5;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu6 RString
     */
    public void setSeibetsu6(RString seibetsu6) {
        this.seibetsu6 = seibetsu6;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei12 RString
     */
    public void setTohyojoMei12(RString tohyojoMei12) {
        this.tohyojoMei12 = tohyojoMei12;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei22 RString
     */
    public void setTohyojoMei22(RString tohyojoMei22) {
        this.tohyojoMei22 = tohyojoMei22;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei32 RString
     */
    public void setTohyojoMei32(RString tohyojoMei32) {
        this.tohyojoMei32 = tohyojoMei32;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei13 RString
     */
    public void setTohyojoMei13(RString tohyojoMei13) {
        this.tohyojoMei13 = tohyojoMei13;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei23 RString
     */
    public void setTohyojoMei23(RString tohyojoMei23) {
        this.tohyojoMei23 = tohyojoMei23;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei33 RString
     */
    public void setTohyojoMei33(RString tohyojoMei33) {
        this.tohyojoMei33 = tohyojoMei33;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei14 RString
     */
    public void setTohyojoMei14(RString tohyojoMei14) {
        this.tohyojoMei14 = tohyojoMei14;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei24 RString
     */
    public void setTohyojoMei24(RString tohyojoMei24) {
        this.tohyojoMei24 = tohyojoMei24;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei34 RString
     */
    public void setTohyojoMei34(RString tohyojoMei34) {
        this.tohyojoMei34 = tohyojoMei34;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei15 RString
     */
    public void setTohyojoMei15(RString tohyojoMei15) {
        this.tohyojoMei15 = tohyojoMei15;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei25 RString
     */
    public void setTohyojoMei25(RString tohyojoMei25) {
        this.tohyojoMei25 = tohyojoMei25;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei35 RString
     */
    public void setTohyojoMei35(RString tohyojoMei35) {
        this.tohyojoMei35 = tohyojoMei35;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei16 RString
     */
    public void setTohyojoMei16(RString tohyojoMei16) {
        this.tohyojoMei16 = tohyojoMei16;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei26 RString
     */
    public void setTohyojoMei26(RString tohyojoMei26) {
        this.tohyojoMei26 = tohyojoMei26;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei36 RString
     */
    public void setTohyojoMei36(RString tohyojoMei36) {
        this.tohyojoMei36 = tohyojoMei36;
    }

    /**
     * 地方公共団体情報
     *
     * @return 地方公共団体情報 Association
     */
    public Association get地方公共団体情報() {
        return 地方公共団体情報;
    }

    /**
     * 地方公共団体情報
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }
}
