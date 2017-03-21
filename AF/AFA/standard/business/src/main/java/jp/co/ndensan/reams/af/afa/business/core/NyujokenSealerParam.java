/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票所入場券（シーラー）
 *
 * @reamsid_L AF-0160-033 xul
 */
public class NyujokenSealerParam extends NyujokenSealerParentParam {

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

    private Association 地方公共団体情報;
    private RString barcodeCustombarcode1;
    private RString barcodeCustombarcode2;
    private RString barcodeCustombarcode3;
    private RString barcodeCustombarcode4;
    private RString sofusakiGyoseikuMei11;
    private RString sofusakiGyoseikuMei21;
    private RString sofusakiGyoseikuMei31;
    private RString sofusakiGyoseikuMei12;
    private RString sofusakiGyoseikuMei22;
    private RString sofusakiGyoseikuMei32;
    private RString sofusakiJusho11;
    private RString sofusakiJusho21;
    private RString sofusakiJusho31;
    private RString sofusakiJusho41;
    private RString sofusakiJusho51;
    private RString sofusakiJusho12;
    private RString sofusakiJusho22;
    private RString sofusakiJusho32;
    private RString sofusakiJusho42;
    private RString sofusakiJusho52;
    private RString atena11;
    private RString atena21;
    private RString atena31;
    private RString sofusakiMeiboNo1;
    private RString sofusakiMeiboNo2;
    private RString jusho11;
    private RString jusho21;
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
    private RString jusho17;
    private RString jusho27;
    private RString jusho18;
    private RString jusho28;

    private RString seibetsu1;
    private RString seibetsu2;
    private RString seibetsu3;
    private RString seibetsu4;
    private RString seibetsu5;
    private RString seibetsu6;
    private RString seibetsu7;
    private RString seibetsu8;
    private RString tohyojoMei11;
    private RString tohyojoMei21;
    private RString tohyojoMei31;
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
    private RString tohyojoMei17;
    private RString tohyojoMei27;
    private RString tohyojoMei37;
    private RString tohyojoMei18;
    private RString tohyojoMei28;
    private RString tohyojoMei38;
    private RString yubinNo11;
    private RString yubinNo21;
    private RString yubinNo12;
    private RString yubinNo22;
    private RString atena12;
    private RString atena22;
    private RString atena32;
    private Integer seiriNo1;
    private Integer seiriNo2;

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
    public NyujokenSealerParam(NyujoukenGamenModel 入場券帳票作成入力情報, SoufusakiJouhou 送付先情報1,
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
     * カスタマーバーコード1を返します。
     *
     * @return カスタマーバーコード1 RString
     */
    public RString getBarcodeCustombarcode1() {
        return this.barcodeCustombarcode1;
    }

    /**
     * カスタマーバーコード2を返します。
     *
     * @return カスタマーバーコード2 RString
     */
    public RString getBarcodeCustombarcode2() {
        return this.barcodeCustombarcode2;
    }

    /**
     * カスタマーバーコード3を返します。
     *
     * @return カスタマーバーコード3 RString
     */
    public RString getBarcodeCustombarcode3() {
        return this.barcodeCustombarcode3;
    }

    /**
     * カスタマーバーコード4を返します。
     *
     * @return カスタマーバーコード4 RString
     */
    public RString getBarcodeCustombarcode4() {
        return this.barcodeCustombarcode4;
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
     * 送付先行政区名1を返します。
     *
     * @return 送付先行政区名1 RString
     */
    public RString getSofusakiGyoseikuMei12() {
        return this.sofusakiGyoseikuMei12;
    }

    /**
     * 送付先行政区名2を返します。
     *
     * @return 送付先行政区名2 RString
     */
    public RString getSofusakiGyoseikuMei22() {
        return this.sofusakiGyoseikuMei22;
    }

    /**
     * 送付先行政区名3を返します。
     *
     * @return 送付先行政区名3 RString
     */
    public RString getSofusakiGyoseikuMei32() {
        return this.sofusakiGyoseikuMei32;
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
     * 送付先住所1を返します。
     *
     * @return 送付先住所1 RString
     */
    public RString getSofusakiJusho12() {
        return this.sofusakiJusho12;
    }

    /**
     * 送付先住所2を返します。
     *
     * @return 送付先住所2 RString
     */
    public RString getSofusakiJusho22() {
        return this.sofusakiJusho22;
    }

    /**
     * 送付先住所3を返します。
     *
     * @return 送付先住所3 RString
     */
    public RString getSofusakiJusho32() {
        return this.sofusakiJusho32;
    }

    /**
     * 送付先住所4を返します。
     *
     * @return 送付先住所4 RString
     */
    public RString getSofusakiJusho42() {
        return this.sofusakiJusho42;
    }

    /**
     * 送付先住所5を返します。
     *
     * @return 送付先住所5 RString
     */
    public RString getSofusakiJusho52() {
        return this.sofusakiJusho52;
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
     * 宛名1を返します。
     *
     * @return 宛名1 RString
     */
    public RString getAtena12() {
        return this.atena12;
    }

    /**
     * 宛名2を返します。
     *
     * @return 宛名2 RString
     */
    public RString getAtena22() {
        return this.atena22;
    }

    /**
     * 宛名3を返します。
     *
     * @return 宛名3 RString
     */
    public RString getAtena32() {
        return this.atena32;
    }

    /**
     * 送付先名簿番号を返します。
     *
     * @return 送付先名簿番号1 RString
     */
    public RString getSofusakiMeiboNo1() {
        return this.sofusakiMeiboNo1;
    }

    /**
     * 送付先名簿番号を返します。
     *
     * @return 送付先名簿番号2 RString
     */
    public RString getSofusakiMeiboNo2() {
        return this.sofusakiMeiboNo2;
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
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho17() {
        return this.jusho17;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho27() {
        return this.jusho27;
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1 RString
     */
    public RString getJusho18() {
        return this.jusho18;
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2 RString
     */
    public RString getJusho28() {
        return this.jusho28;
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
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu7() {
        return this.seibetsu7;
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString getSeibetsu8() {
        return this.seibetsu8;
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
     * 送付先郵便番号3桁を返します。
     *
     * @return 送付先郵便番号3桁 RString
     */
    public RString getYubinNo12() {
        return this.yubinNo12;
    }

    /**
     * 送付先郵便番号4桁を返します。
     *
     * @return 送付先郵便番号4桁 RString
     */
    public RString getYubinNo22() {
        return this.yubinNo22;
    }

    /**
     * カスタマーバーコード1を設定します。
     *
     * @param barcodeCustombarcode1 RString
     */
    public void setBarcodeCustombarcode1(RString barcodeCustombarcode1) {
        this.barcodeCustombarcode1 = barcodeCustombarcode1;
    }

    /**
     * カスタマーバーコード2を設定します。
     *
     * @param barcodeCustombarcode2 RString
     */
    public void setBarcodeCustombarcode2(RString barcodeCustombarcode2) {
        this.barcodeCustombarcode2 = barcodeCustombarcode2;
    }

    /**
     * カスタマーバーコード3を設定します。
     *
     * @param barcodeCustombarcode3 RString
     */
    public void setBarcodeCustombarcode3(RString barcodeCustombarcode3) {
        this.barcodeCustombarcode3 = barcodeCustombarcode3;
    }

    /**
     * カスタマーバーコード4を設定します。
     *
     * @param barcodeCustombarcode4 RString
     */
    public void setBarcodeCustombarcode4(RString barcodeCustombarcode4) {
        this.barcodeCustombarcode4 = barcodeCustombarcode4;
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
     * 送付先行政区名1を設定します。
     *
     * @param sofusakiGyoseikuMei12 RString
     */
    public void setSofusakiGyoseikuMei12(RString sofusakiGyoseikuMei12) {
        this.sofusakiGyoseikuMei12 = sofusakiGyoseikuMei12;
    }

    /**
     * 送付先行政区名2を設定します。
     *
     * @param sofusakiGyoseikuMei22 RString
     */
    public void setSofusakiGyoseikuMei22(RString sofusakiGyoseikuMei22) {
        this.sofusakiGyoseikuMei22 = sofusakiGyoseikuMei22;
    }

    /**
     * 送付先行政区名3を設定します。
     *
     * @param sofusakiGyoseikuMei32 RString
     */
    public void setSofusakiGyoseikuMei32(RString sofusakiGyoseikuMei32) {
        this.sofusakiGyoseikuMei32 = sofusakiGyoseikuMei32;
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
     * 宛名1を設定します。
     *
     * @param atena12 RString
     */
    public void setAtena12(RString atena12) {
        this.atena12 = atena12;
    }

    /**
     * 宛名2を設定します。
     *
     * @param atena22 RString
     */
    public void setAtena22(RString atena22) {
        this.atena22 = atena22;
    }

    /**
     * 宛名3を設定します。
     *
     * @param atena32 RString
     */
    public void setAtena32(RString atena32) {
        this.atena32 = atena32;
    }

    /**
     * 送付先名簿番号1を設定します。
     *
     * @param sofusakiMeiboNo1 RString
     */
    public void setSofusakiMeiboNo1(RString sofusakiMeiboNo1) {
        this.sofusakiMeiboNo1 = sofusakiMeiboNo1;
    }

    /**
     * 送付先名簿番号2を設定します。
     *
     * @param sofusakiMeiboNo2 RString
     */
    public void setSofusakiMeiboNo2(RString sofusakiMeiboNo2) {
        this.sofusakiMeiboNo2 = sofusakiMeiboNo2;
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
     * 住所1を設定します。
     *
     * @param jusho17 RString
     */
    public void setJusho17(RString jusho17) {
        this.jusho17 = jusho17;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho27 RString
     */
    public void setJusho27(RString jusho27) {
        this.jusho27 = jusho27;
    }

    /**
     * 住所1を設定します。
     *
     * @param jusho18 RString
     */
    public void setJusho18(RString jusho18) {
        this.jusho18 = jusho18;
    }

    /**
     * 住所2を設定します。
     *
     * @param jusho28 RString
     */
    public void setJusho28(RString jusho28) {
        this.jusho28 = jusho28;
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
     * 性別を設定します。
     *
     * @param seibetsu7 RString
     */
    public void setSeibetsu7(RString seibetsu7) {
        this.seibetsu7 = seibetsu7;
    }

    /**
     * 性別を設定します。
     *
     * @param seibetsu8 RString
     */
    public void setSeibetsu8(RString seibetsu8) {
        this.seibetsu8 = seibetsu8;
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
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei17() {
        return this.tohyojoMei17;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei27() {
        return this.tohyojoMei27;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei37() {
        return this.tohyojoMei37;
    }

    /**
     * 投票所名1を返します。
     *
     * @return 投票所名1 RString
     */
    public RString getTohyojoMei18() {
        return this.tohyojoMei18;
    }

    /**
     * 投票所名2を返します。
     *
     * @return 投票所名2 RString
     */
    public RString getTohyojoMei28() {
        return this.tohyojoMei28;
    }

    /**
     * 投票所名3を返します。
     *
     * @return 投票所名3 RString
     */
    public RString getTohyojoMei38() {
        return this.tohyojoMei38;
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
     * 投票所名1を設定します。
     *
     * @param tohyojoMei17 RString
     */
    public void setTohyojoMei17(RString tohyojoMei17) {
        this.tohyojoMei17 = tohyojoMei17;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei27 RString
     */
    public void setTohyojoMei27(RString tohyojoMei27) {
        this.tohyojoMei27 = tohyojoMei27;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei37 RString
     */
    public void setTohyojoMei37(RString tohyojoMei37) {
        this.tohyojoMei37 = tohyojoMei37;
    }

    /**
     * 投票所名1を設定します。
     *
     * @param tohyojoMei18 RString
     */
    public void setTohyojoMei18(RString tohyojoMei18) {
        this.tohyojoMei18 = tohyojoMei18;
    }

    /**
     * 投票所名2を設定します。
     *
     * @param tohyojoMei28 RString
     */
    public void setTohyojoMei28(RString tohyojoMei28) {
        this.tohyojoMei28 = tohyojoMei28;
    }

    /**
     * 投票所名3を設定します。
     *
     * @param tohyojoMei38 RString
     */
    public void setTohyojoMei38(RString tohyojoMei38) {
        this.tohyojoMei38 = tohyojoMei38;
    }

    /**
     * 送付先住所1を設定します。
     *
     * @param sofusakiJusho12 RString
     */
    public void setSofusakiJusho12(RString sofusakiJusho12) {
        this.sofusakiJusho12 = sofusakiJusho12;
    }

    /**
     * 送付先住所2を設定します。
     *
     * @param sofusakiJusho22 RString
     */
    public void setSofusakiJusho22(RString sofusakiJusho22) {
        this.sofusakiJusho22 = sofusakiJusho22;
    }

    /**
     * 送付先住所3を設定します。
     *
     * @param sofusakiJusho32 RString
     */
    public void setSofusakiJusho32(RString sofusakiJusho32) {
        this.sofusakiJusho32 = sofusakiJusho32;
    }

    /**
     * 送付先住所4を設定します。
     *
     * @param sofusakiJusho42 RString
     */
    public void setSofusakiJusho42(RString sofusakiJusho42) {
        this.sofusakiJusho42 = sofusakiJusho42;
    }

    /**
     * 送付先住所5を設定します。
     *
     * @param sofusakiJusho52 RString
     */
    public void setSofusakiJusho52(RString sofusakiJusho52) {
        this.sofusakiJusho52 = sofusakiJusho52;
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
     * 送付先郵便番号3桁を設定します。
     *
     * @param yubinNo12 RString
     */
    public void setYubinNo12(RString yubinNo12) {
        this.yubinNo12 = yubinNo12;
    }

    /**
     * 送付先郵便番号4桁を設定します。
     *
     * @param yubinNo22 RString
     */
    public void setYubinNo22(RString yubinNo22) {
        this.yubinNo22 = yubinNo22;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 Int
     */
    public Integer getSeiriNo1() {
        return this.seiriNo1;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 RString
     */
    public Integer getSeiriNo2() {
        return this.seiriNo2;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo1 RString
     */
    public void setSeiriNo1(Integer seiriNo1) {
        this.seiriNo1 = seiriNo1;
    }

    /**
     * 整理番号を設定します。
     *
     * @param seiriNo2 RString
     */
    public void setSeiriNo2(Integer seiriNo2) {
        this.seiriNo2 = seiriNo2;
    }

}
