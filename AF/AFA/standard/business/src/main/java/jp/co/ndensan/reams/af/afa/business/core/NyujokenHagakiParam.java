/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票所入場券（はがき4つ切り）
 *
 * @reamsid_L AF-0160-032 guyq
 */
public class NyujokenHagakiParam extends NyujokenHagakiPart {

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
    private RString sofusakiGyoseikuMei11;
    private RString sofusakiGyoseikuMei21;
    private RString sofusakiGyoseikuMei31;
    private RString atena11;
    private RString atena21;
    private RString atena31;
    private RString sofusakiMeiboNo1;
    private RString mapJoho1;
    private RString jusho11;
    private RString jusho21;
    private RString barcodeNyujokenBarcode1;
    private RString barcodeCustombarcode2;
    private RString sofusakiGyoseikuMei12;
    private RString sofusakiGyoseikuMei22;
    private RString sofusakiGyoseikuMei32;
    private RString atena12;
    private RString atena22;
    private RString atena32;
    private RString sofusakiMeiboNo2;
    private RString mapJoho2;
    private RString jusho12;
    private RString jusho22;
    private RString barcodeNyujokenBarcode2;
    private RString barcodeNyujokenBarcode3;
    private RString barcodeCustombarcode3;
    private RString sofusakiGyoseikuMei13;
    private RString sofusakiGyoseikuMei23;
    private RString sofusakiGyoseikuMei33;
    private RString atena13;
    private RString atena23;
    private RString atena33;
    private RString sofusakiMeiboNo3;
    private RString mapJoho3;
    private RString jusho13;
    private RString jusho23;
    private RString meiboNo1;
    private RString meiboNo2;
    private RString meiboNo3;
    private RString atena14;
    private RString atena24;
    private RString atena34;
    private RString sofusakiMeiboNo4;
    private RString jusho14;
    private RString jusho24;
    private RString sofusakiJusho14;
    private RString sofusakiJusho24;
    private RString sofusakiJusho34;
    private RString sofusakiJusho44;
    private RString sofusakiJusho54;
    private RString yubinNo4;
    private RString sofusakiGyoseikuCode4;
    private RString sofusakiJushoCode4;
    private RString sofusakiChikuName4;
    private RString sofusakiSetaiCode4;
    private RString setainushiMei4;
    private RString mapJoho4;
    private RString jushoCode4;
    private RString jusho4;
    private RString shimei4;
    private RString shimeiKana14;
    private RString shimeiKana24;
    private RString shimeiKana4;
    private RString setainushiKubun4;
    private RString seinengappi4;
    private RString tohyojoMei4;
    private RString tohyojoJusho4;
    private RString tohyokuMei4;
    private RString meiboNo4;
    private RString gyoseikuCode4;
    private RString gyoseikuMei4;
    private RString chikuCode14;
    private RString chikuName14;
    private RString chikuCode24;
    private RString chikuName24;
    private RString chikuCode34;
    private RString chikuName34;
    private RString sofusakiGyoseikuMei14;
    private RString sofusakiGyoseikuMei24;
    private RString sofusakiGyoseikuMei34;
    private RString shimei14;
    private RString shimei24;
    private RString shimei34;
    private RString barcodeNyujokenBarcode4;
    private RString barcodeCustombarcode4;
    private int seiriNo1;
    private int seiriNo2;
    private int seiriNo3;

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
    public NyujokenHagakiParam(NyujoukenGamenModel 入場券帳票作成入力情報, SoufusakiJouhou 送付先情報1,
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
     * barcodeCustombarcode1を設定します。
     *
     * @param barcodeCustombarcode1 RString
     */
    public void setBarcodeCustombarcode1(RString barcodeCustombarcode1) {
        this.barcodeCustombarcode1 = barcodeCustombarcode1;
    }

    /**
     * sofusakiGyoseikuMei11を設定します。
     *
     * @param sofusakiGyoseikuMei11 RString
     */
    public void setSofusakiGyoseikuMei11(RString sofusakiGyoseikuMei11) {
        this.sofusakiGyoseikuMei11 = sofusakiGyoseikuMei11;
    }

    /**
     * sofusakiGyoseikuMei21を設定します。
     *
     * @param sofusakiGyoseikuMei21 RString
     */
    public void setSofusakiGyoseikuMei21(RString sofusakiGyoseikuMei21) {
        this.sofusakiGyoseikuMei21 = sofusakiGyoseikuMei21;
    }

    /**
     * sofusakiGyoseikuMei31を設定します。
     *
     * @param sofusakiGyoseikuMei31 RString
     */
    public void setSofusakiGyoseikuMei31(RString sofusakiGyoseikuMei31) {
        this.sofusakiGyoseikuMei31 = sofusakiGyoseikuMei31;
    }

    /**
     * atena11を設定します。
     *
     * @param atena11 RString
     */
    public void setAtena11(RString atena11) {
        this.atena11 = atena11;
    }

    /**
     * atena21を設定します。
     *
     * @param atena21 RString
     */
    public void setAtena21(RString atena21) {
        this.atena21 = atena21;
    }

    /**
     * atena31を設定します。
     *
     * @param atena31 RString
     */
    public void setAtena31(RString atena31) {
        this.atena31 = atena31;
    }

    /**
     * sofusakiMeiboNo1を設定します。
     *
     * @param sofusakiMeiboNo1 RString
     */
    public void setSofusakiMeiboNo1(RString sofusakiMeiboNo1) {
        this.sofusakiMeiboNo1 = sofusakiMeiboNo1;
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
     * jusho11を設定します。
     *
     * @param jusho11 RString
     */
    public void setJusho11(RString jusho11) {
        this.jusho11 = jusho11;
    }

    /**
     * jusho21を設定します。
     *
     * @param jusho21 RString
     */
    public void setJusho21(RString jusho21) {
        this.jusho21 = jusho21;
    }

    /**
     * barcodeNyujokenBarcode1を設定します。
     *
     * @param barcodeNyujokenBarcode1 RString
     */
    public void setBarcodeNyujokenBarcode1(RString barcodeNyujokenBarcode1) {
        this.barcodeNyujokenBarcode1 = barcodeNyujokenBarcode1;
    }

    /**
     * barcodeCustombarcode2を設定します。
     *
     * @param barcodeCustombarcode2 RString
     */
    public void setBarcodeCustombarcode2(RString barcodeCustombarcode2) {
        this.barcodeCustombarcode2 = barcodeCustombarcode2;
    }

    /**
     * sofusakiGyoseikuMei12を設定します。
     *
     * @param sofusakiGyoseikuMei12 RString
     */
    public void setSofusakiGyoseikuMei12(RString sofusakiGyoseikuMei12) {
        this.sofusakiGyoseikuMei12 = sofusakiGyoseikuMei12;
    }

    /**
     * sofusakiGyoseikuMei22を設定します。
     *
     * @param sofusakiGyoseikuMei22 RString
     */
    public void setSofusakiGyoseikuMei22(RString sofusakiGyoseikuMei22) {
        this.sofusakiGyoseikuMei22 = sofusakiGyoseikuMei22;
    }

    /**
     * sofusakiGyoseikuMei32を設定します。
     *
     * @param sofusakiGyoseikuMei32 RString
     */
    public void setSofusakiGyoseikuMei32(RString sofusakiGyoseikuMei32) {
        this.sofusakiGyoseikuMei32 = sofusakiGyoseikuMei32;
    }

    /**
     * atena12を設定します。
     *
     * @param atena12 RString
     */
    public void setAtena12(RString atena12) {
        this.atena12 = atena12;
    }

    /**
     * atena22を設定します。
     *
     * @param atena22 RString
     */
    public void setAtena22(RString atena22) {
        this.atena22 = atena22;
    }

    /**
     * atena32を設定します。
     *
     * @param atena32 RString
     */
    public void setAtena32(RString atena32) {
        this.atena32 = atena32;
    }

    /**
     * sofusakiMeiboNo2を設定します。
     *
     * @param sofusakiMeiboNo2 RString
     */
    public void setSofusakiMeiboNo2(RString sofusakiMeiboNo2) {
        this.sofusakiMeiboNo2 = sofusakiMeiboNo2;
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
     * jusho12を設定します。
     *
     * @param jusho12 RString
     */
    public void setJusho12(RString jusho12) {
        this.jusho12 = jusho12;
    }

    /**
     * jusho22を設定します。
     *
     * @param jusho22 RString
     */
    public void setJusho22(RString jusho22) {
        this.jusho22 = jusho22;
    }

    /**
     * barcodeNyujokenBarcode2を設定します。
     *
     * @param barcodeNyujokenBarcode2 RString
     */
    public void setBarcodeNyujokenBarcode2(RString barcodeNyujokenBarcode2) {
        this.barcodeNyujokenBarcode2 = barcodeNyujokenBarcode2;
    }

    /**
     * barcodeNyujokenBarcode3を設定します。
     *
     * @param barcodeNyujokenBarcode3 RString
     */
    public void setBarcodeNyujokenBarcode3(RString barcodeNyujokenBarcode3) {
        this.barcodeNyujokenBarcode3 = barcodeNyujokenBarcode3;
    }

    /**
     * barcodeCustombarcode3を設定します。
     *
     * @param barcodeCustombarcode3 RString
     */
    public void setBarcodeCustombarcode3(RString barcodeCustombarcode3) {
        this.barcodeCustombarcode3 = barcodeCustombarcode3;
    }

    /**
     * sofusakiGyoseikuMei13を設定します。
     *
     * @param sofusakiGyoseikuMei13 RString
     */
    public void setSofusakiGyoseikuMei13(RString sofusakiGyoseikuMei13) {
        this.sofusakiGyoseikuMei13 = sofusakiGyoseikuMei13;
    }

    /**
     * sofusakiGyoseikuMei23を設定します。
     *
     * @param sofusakiGyoseikuMei23 RString
     */
    public void setSofusakiGyoseikuMei23(RString sofusakiGyoseikuMei23) {
        this.sofusakiGyoseikuMei23 = sofusakiGyoseikuMei23;
    }

    /**
     * sofusakiGyoseikuMei33を設定します。
     *
     * @param sofusakiGyoseikuMei33 RString
     */
    public void setSofusakiGyoseikuMei33(RString sofusakiGyoseikuMei33) {
        this.sofusakiGyoseikuMei33 = sofusakiGyoseikuMei33;
    }

    /**
     * atena13を設定します。
     *
     * @param atena13 RString
     */
    public void setAtena13(RString atena13) {
        this.atena13 = atena13;
    }

    /**
     * atena23を設定します。
     *
     * @param atena23 RString
     */
    public void setAtena23(RString atena23) {
        this.atena23 = atena23;
    }

    /**
     * atena33を設定します。
     *
     * @param atena33 RString
     */
    public void setAtena33(RString atena33) {
        this.atena33 = atena33;
    }

    /**
     * sofusakiMeiboNo3を設定します。
     *
     * @param sofusakiMeiboNo3 RString
     */
    public void setSofusakiMeiboNo3(RString sofusakiMeiboNo3) {
        this.sofusakiMeiboNo3 = sofusakiMeiboNo3;
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
     * jusho13を設定します。
     *
     * @param jusho13 RString
     */
    public void setJusho13(RString jusho13) {
        this.jusho13 = jusho13;
    }

    /**
     * jusho23を設定します。
     *
     * @param jusho23 RString
     */
    public void setJusho23(RString jusho23) {
        this.jusho23 = jusho23;
    }

    /**
     * meiboNo1を設定します。
     *
     * @param meiboNo1 RString
     */
    public void setMeiboNo1(RString meiboNo1) {
        this.meiboNo1 = meiboNo1;
    }

    /**
     * meiboNo2を設定します。
     *
     * @param meiboNo2 RString
     */
    public void setMeiboNo2(RString meiboNo2) {
        this.meiboNo2 = meiboNo2;
    }

    /**
     * meiboNo3を設定します。
     *
     * @param meiboNo3 RString
     */
    public void setMeiboNo3(RString meiboNo3) {
        this.meiboNo3 = meiboNo3;
    }

    /**
     * 地方公共団体情報を設定します。
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }

    /**
     * atena14を設定します。
     *
     * @param atena14 RString
     */
    public void setAtena14(RString atena14) {
        this.atena14 = atena14;
    }

    /**
     * atena24を設定します。
     *
     * @param atena24 RString
     */
    public void setAtena24(RString atena24) {
        this.atena24 = atena24;
    }

    /**
     * atena34を設定します。
     *
     * @param atena34 RString
     */
    public void setAtena34(RString atena34) {
        this.atena34 = atena34;
    }

    /**
     * sofusakiMeiboNo4を設定します。
     *
     * @param sofusakiMeiboNo4 RString
     */
    public void setSofusakiMeiboNo4(RString sofusakiMeiboNo4) {
        this.sofusakiMeiboNo4 = sofusakiMeiboNo4;
    }

    /**
     * jusho14を設定します。
     *
     * @param jusho14 RString
     */
    public void setJusho14(RString jusho14) {
        this.jusho14 = jusho14;
    }

    /**
     * jusho24を設定します。
     *
     * @param jusho24 RString
     */
    public void setJusho24(RString jusho24) {
        this.jusho24 = jusho24;
    }

    /**
     * sofusakiJusho14を設定します。
     *
     * @param sofusakiJusho14 RString
     */
    public void setSofusakiJusho14(RString sofusakiJusho14) {
        this.sofusakiJusho14 = sofusakiJusho14;
    }

    /**
     * sofusakiJusho24を設定します。
     *
     * @param sofusakiJusho24 RString
     */
    public void setSofusakiJusho24(RString sofusakiJusho24) {
        this.sofusakiJusho24 = sofusakiJusho24;
    }

    /**
     * sofusakiJusho34を設定します。
     *
     * @param sofusakiJusho34 RString
     */
    public void setSofusakiJusho34(RString sofusakiJusho34) {
        this.sofusakiJusho34 = sofusakiJusho34;
    }

    /**
     * sofusakiJusho44を設定します。
     *
     * @param sofusakiJusho44 RString
     */
    public void setSofusakiJusho44(RString sofusakiJusho44) {
        this.sofusakiJusho44 = sofusakiJusho44;
    }

    /**
     * sofusakiJusho54を設定します。
     *
     * @param sofusakiJusho54 RString
     */
    public void setSofusakiJusho54(RString sofusakiJusho54) {
        this.sofusakiJusho54 = sofusakiJusho54;
    }

    /**
     * yubinNo4を設定します。
     *
     * @param yubinNo4 RString
     */
    public void setYubinNo4(RString yubinNo4) {
        this.yubinNo4 = yubinNo4;
    }

    /**
     * sofusakiGyoseikuCode4を設定します。
     *
     * @param sofusakiGyoseikuCode4 RString
     */
    public void setSofusakiGyoseikuCode4(RString sofusakiGyoseikuCode4) {
        this.sofusakiGyoseikuCode4 = sofusakiGyoseikuCode4;
    }

    /**
     * sofusakiJushoCode4を設定します。
     *
     * @param sofusakiJushoCode4 RString
     */
    public void setSofusakiJushoCode4(RString sofusakiJushoCode4) {
        this.sofusakiJushoCode4 = sofusakiJushoCode4;
    }

    /**
     * sofusakiChikuName4を設定します。
     *
     * @param sofusakiChikuName4 RString
     */
    public void setSofusakiChikuName4(RString sofusakiChikuName4) {
        this.sofusakiChikuName4 = sofusakiChikuName4;
    }

    /**
     * sofusakiSetaiCode4を設定します。
     *
     * @param sofusakiSetaiCode4 RString
     */
    public void setSofusakiSetaiCode4(RString sofusakiSetaiCode4) {
        this.sofusakiSetaiCode4 = sofusakiSetaiCode4;
    }

    /**
     * setainushiMei4を設定します。
     *
     * @param setainushiMei4 RString
     */
    public void setSetainushiMei4(RString setainushiMei4) {
        this.setainushiMei4 = setainushiMei4;
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
     * jushoCode4を設定します。
     *
     * @param jushoCode4 RString
     */
    public void setJushoCode4(RString jushoCode4) {
        this.jushoCode4 = jushoCode4;
    }

    /**
     * jusho4を設定します。
     *
     * @param jusho4 RString
     */
    public void setJusho4(RString jusho4) {
        this.jusho4 = jusho4;
    }

    /**
     * shimei4を設定します。
     *
     * @param shimei4 RString
     */
    public void setShimei4(RString shimei4) {
        this.shimei4 = shimei4;
    }

    /**
     * shimeiKana14を設定します。
     *
     * @param shimeiKana14 RString
     */
    public void setShimeiKana14(RString shimeiKana14) {
        this.shimeiKana14 = shimeiKana14;
    }

    /**
     * shimeiKana24を設定します。
     *
     * @param shimeiKana24 RString
     */
    public void setShimeiKana24(RString shimeiKana24) {
        this.shimeiKana24 = shimeiKana24;
    }

    /**
     * shimeiKana4を設定します。
     *
     * @param shimeiKana4 RString
     */
    public void setShimeiKana4(RString shimeiKana4) {
        this.shimeiKana4 = shimeiKana4;
    }

    /**
     * setainushiKubun4を設定します。
     *
     * @param setainushiKubun4 RString
     */
    public void setSetainushiKubun4(RString setainushiKubun4) {
        this.setainushiKubun4 = setainushiKubun4;
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
     * tohyojoMei4を設定します。
     *
     * @param tohyojoMei4 RString
     */
    public void setTohyojoMei4(RString tohyojoMei4) {
        this.tohyojoMei4 = tohyojoMei4;
    }

    /**
     * tohyojoJusho4を設定します。
     *
     * @param tohyojoJusho4 RString
     */
    public void setTohyojoJusho4(RString tohyojoJusho4) {
        this.tohyojoJusho4 = tohyojoJusho4;
    }

    /**
     * tohyokuMei4を設定します。
     *
     * @param tohyokuMei4 RString
     */
    public void setTohyokuMei4(RString tohyokuMei4) {
        this.tohyokuMei4 = tohyokuMei4;
    }

    /**
     * meiboNo4を設定します。
     *
     * @param meiboNo4 RString
     */
    public void setMeiboNo4(RString meiboNo4) {
        this.meiboNo4 = meiboNo4;
    }

    /**
     * gyoseikuCode4を設定します。
     *
     * @param gyoseikuCode4 RString
     */
    public void setGyoseikuCode4(RString gyoseikuCode4) {
        this.gyoseikuCode4 = gyoseikuCode4;
    }

    /**
     * gyoseikuMei4を設定します。
     *
     * @param gyoseikuMei4 RString
     */
    public void setGyoseikuMei4(RString gyoseikuMei4) {
        this.gyoseikuMei4 = gyoseikuMei4;
    }

    /**
     * chikuCode14を設定します。
     *
     * @param chikuCode14 RString
     */
    public void setChikuCode14(RString chikuCode14) {
        this.chikuCode14 = chikuCode14;
    }

    /**
     * chikuName14を設定します。
     *
     * @param chikuName14 RString
     */
    public void setChikuName14(RString chikuName14) {
        this.chikuName14 = chikuName14;
    }

    /**
     * chikuCode24を設定します。
     *
     * @param chikuCode24 RString
     */
    public void setChikuCode24(RString chikuCode24) {
        this.chikuCode24 = chikuCode24;
    }

    /**
     * chikuName24を設定します。
     *
     * @param chikuName24 RString
     */
    public void setChikuName24(RString chikuName24) {
        this.chikuName24 = chikuName24;
    }

    /**
     * chikuCode34を設定します。
     *
     * @param chikuCode34 RString
     */
    public void setChikuCode34(RString chikuCode34) {
        this.chikuCode34 = chikuCode34;
    }

    /**
     * chikuName34を設定します。
     *
     * @param chikuName34 RString
     */
    public void setChikuName34(RString chikuName34) {
        this.chikuName34 = chikuName34;
    }

    /**
     * sofusakiGyoseikuMei14を設定します。
     *
     * @param sofusakiGyoseikuMei14 RString
     */
    public void setSofusakiGyoseikuMei14(RString sofusakiGyoseikuMei14) {
        this.sofusakiGyoseikuMei14 = sofusakiGyoseikuMei14;
    }

    /**
     * sofusakiGyoseikuMei24を設定します。
     *
     * @param sofusakiGyoseikuMei24 RString
     */
    public void setSofusakiGyoseikuMei24(RString sofusakiGyoseikuMei24) {
        this.sofusakiGyoseikuMei24 = sofusakiGyoseikuMei24;
    }

    /**
     * sofusakiGyoseikuMei34を設定します。
     *
     * @param sofusakiGyoseikuMei34 RString
     */
    public void setSofusakiGyoseikuMei34(RString sofusakiGyoseikuMei34) {
        this.sofusakiGyoseikuMei34 = sofusakiGyoseikuMei34;
    }

    /**
     * shimei14を設定します。
     *
     * @param shimei14 RString
     */
    public void setShimei14(RString shimei14) {
        this.shimei14 = shimei14;
    }

    /**
     * shimei24を設定します。
     *
     * @param shimei24 RString
     */
    public void setShimei24(RString shimei24) {
        this.shimei24 = shimei24;
    }

    /**
     * shimei34を設定します。
     *
     * @param shimei34 RString
     */
    public void setShimei34(RString shimei34) {
        this.shimei34 = shimei34;
    }

    /**
     * seiriNo1を設定します。
     *
     * @param seiriNo1 int
     */
    public void setSeiriNo1(int seiriNo1) {
        this.seiriNo1 = seiriNo1;
    }

    /**
     * seiriNo2を設定します。
     *
     * @param seiriNo2 int
     */
    public void setSeiriNo2(int seiriNo2) {
        this.seiriNo2 = seiriNo2;
    }

    /**
     * seiriNo3を設定します。
     *
     * @param seiriNo3 int
     */
    public void setSeiriNo3(int seiriNo3) {
        this.seiriNo3 = seiriNo3;
    }

    /**
     * barcodeCustombarcode1を返します。
     *
     * @return barcodeCustombarcode1 RString
     */
    public RString getBarcodeCustombarcode1() {
        return this.barcodeCustombarcode1;
    }

    /**
     * sofusakiGyoseikuMei11を返します。
     *
     * @return sofusakiGyoseikuMei11 RString
     */
    public RString getSofusakiGyoseikuMei11() {
        return this.sofusakiGyoseikuMei11;
    }

    /**
     * sofusakiGyoseikuMei21を返します。
     *
     * @return sofusakiGyoseikuMei21 RString
     */
    public RString getSofusakiGyoseikuMei21() {
        return this.sofusakiGyoseikuMei21;
    }

    /**
     * sofusakiGyoseikuMei31を返します。
     *
     * @return sofusakiGyoseikuMei31 RString
     */
    public RString getSofusakiGyoseikuMei31() {
        return this.sofusakiGyoseikuMei31;
    }

    /**
     * atena11を返します。
     *
     * @return atena11 RString
     */
    public RString getAtena11() {
        return this.atena11;
    }

    /**
     * atena21を返します。
     *
     * @return atena21 RString
     */
    public RString getAtena21() {
        return this.atena21;
    }

    /**
     * atena31を返します。
     *
     * @return atena31 RString
     */
    public RString getAtena31() {
        return this.atena31;
    }

    /**
     * sofusakiMeiboNo1を返します。
     *
     * @return sofusakiMeiboNo1 RString
     */
    public RString getSofusakiMeiboNo1() {
        return this.sofusakiMeiboNo1;
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
     * jusho11を返します。
     *
     * @return jusho11 RString
     */
    public RString getJusho11() {
        return this.jusho11;
    }

    /**
     * jusho21を返します。
     *
     * @return jusho21 RString
     */
    public RString getJusho21() {
        return this.jusho21;
    }

    /**
     * barcodeNyujokenBarcode1を返します。
     *
     * @return barcodeNyujokenBarcode1 RString
     */
    public RString getBarcodeNyujokenBarcode1() {
        return this.barcodeNyujokenBarcode1;
    }

    /**
     * barcodeCustombarcode2を返します。
     *
     * @return barcodeCustombarcode2 RString
     */
    public RString getBarcodeCustombarcode2() {
        return this.barcodeCustombarcode2;
    }

    /**
     * sofusakiGyoseikuMei12を返します。
     *
     * @return sofusakiGyoseikuMei12 RString
     */
    public RString getSofusakiGyoseikuMei12() {
        return this.sofusakiGyoseikuMei12;
    }

    /**
     * sofusakiGyoseikuMei22を返します。
     *
     * @return sofusakiGyoseikuMei22 RString
     */
    public RString getSofusakiGyoseikuMei22() {
        return this.sofusakiGyoseikuMei22;
    }

    /**
     * sofusakiGyoseikuMei32を返します。
     *
     * @return sofusakiGyoseikuMei32 RString
     */
    public RString getSofusakiGyoseikuMei32() {
        return this.sofusakiGyoseikuMei32;
    }

    /**
     * atena12を返します。
     *
     * @return atena12 RString
     */
    public RString getAtena12() {
        return this.atena12;
    }

    /**
     * atena22を返します。
     *
     * @return atena22 RString
     */
    public RString getAtena22() {
        return this.atena22;
    }

    /**
     * atena32を返します。
     *
     * @return atena32 RString
     */
    public RString getAtena32() {
        return this.atena32;
    }

    /**
     * sofusakiMeiboNo2を返します。
     *
     * @return sofusakiMeiboNo2 RString
     */
    public RString getSofusakiMeiboNo2() {
        return this.sofusakiMeiboNo2;
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
     * jusho12を返します。
     *
     * @return jusho12 RString
     */
    public RString getJusho12() {
        return this.jusho12;
    }

    /**
     * jusho22を返します。
     *
     * @return jusho22 RString
     */
    public RString getJusho22() {
        return this.jusho22;
    }

    /**
     * barcodeNyujokenBarcode2を返します。
     *
     * @return barcodeNyujokenBarcode2 RString
     */
    public RString getBarcodeNyujokenBarcode2() {
        return this.barcodeNyujokenBarcode2;
    }

    /**
     * barcodeNyujokenBarcode3を返します。
     *
     * @return barcodeNyujokenBarcode3 RString
     */
    public RString getBarcodeNyujokenBarcode3() {
        return this.barcodeNyujokenBarcode3;
    }

    /**
     * barcodeCustombarcode3を返します。
     *
     * @return barcodeCustombarcode3 RString
     */
    public RString getBarcodeCustombarcode3() {
        return this.barcodeCustombarcode3;
    }

    /**
     * sofusakiGyoseikuMei13を返します。
     *
     * @return sofusakiGyoseikuMei13 RString
     */
    public RString getSofusakiGyoseikuMei13() {
        return this.sofusakiGyoseikuMei13;
    }

    /**
     * sofusakiGyoseikuMei23を返します。
     *
     * @return sofusakiGyoseikuMei23 RString
     */
    public RString getSofusakiGyoseikuMei23() {
        return this.sofusakiGyoseikuMei23;
    }

    /**
     * sofusakiGyoseikuMei33を返します。
     *
     * @return sofusakiGyoseikuMei33 RString
     */
    public RString getSofusakiGyoseikuMei33() {
        return this.sofusakiGyoseikuMei33;
    }

    /**
     * atena13を返します。
     *
     * @return atena13 RString
     */
    public RString getAtena13() {
        return this.atena13;
    }

    /**
     * atena23を返します。
     *
     * @return atena23 RString
     */
    public RString getAtena23() {
        return this.atena23;
    }

    /**
     * atena33を返します。
     *
     * @return atena33 RString
     */
    public RString getAtena33() {
        return this.atena33;
    }

    /**
     * sofusakiMeiboNo3を返します。
     *
     * @return sofusakiMeiboNo3 RString
     */
    public RString getSofusakiMeiboNo3() {
        return this.sofusakiMeiboNo3;
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
     * jusho13を返します。
     *
     * @return jusho13 RString
     */
    public RString getJusho13() {
        return this.jusho13;
    }

    /**
     * jusho23を返します。
     *
     * @return jusho23 RString
     */
    public RString getJusho23() {
        return this.jusho23;
    }

    /**
     * meiboNo1を返します。
     *
     * @return meiboNo1 RString
     */
    public RString getMeiboNo1() {
        return this.meiboNo1;
    }

    /**
     * meiboNo2を返します。
     *
     * @return meiboNo2 RString
     */
    public RString getMeiboNo2() {
        return this.meiboNo2;
    }

    /**
     * meiboNo3を返します。
     *
     * @return meiboNo3 RString
     */
    public RString getMeiboNo3() {
        return this.meiboNo3;
    }

    /**
     * 地方公共団体情報を返します。
     *
     * @return 地方公共団体情報 Association
     */
    public Association get地方公共団体情報() {
        return this.地方公共団体情報;
    }

    /**
     * atena14を返します。
     *
     * @return atena14 RString
     */
    public RString getAtena14() {
        return this.atena14;
    }

    /**
     * atena24を返します。
     *
     * @return atena24 RString
     */
    public RString getAtena24() {
        return this.atena24;
    }

    /**
     * atena34を返します。
     *
     * @return atena34 RString
     */
    public RString getAtena34() {
        return this.atena34;
    }

    /**
     * sofusakiMeiboNo4を返します。
     *
     * @return sofusakiMeiboNo4 RString
     */
    public RString getSofusakiMeiboNo4() {
        return this.sofusakiMeiboNo4;
    }

    /**
     * jusho14を返します。
     *
     * @return jusho14 RString
     */
    public RString getJusho14() {
        return this.jusho14;
    }

    /**
     * jusho24を返します。
     *
     * @return jusho24 RString
     */
    public RString getJusho24() {
        return this.jusho24;
    }

    /**
     * sofusakiJusho14を返します。
     *
     * @return sofusakiJusho14 RString
     */
    public RString getSofusakiJusho14() {
        return this.sofusakiJusho14;
    }

    /**
     * sofusakiJusho24を返します。
     *
     * @return sofusakiJusho24 RString
     */
    public RString getSofusakiJusho24() {
        return this.sofusakiJusho24;
    }

    /**
     * sofusakiJusho34を返します。
     *
     * @return sofusakiJusho34 RString
     */
    public RString getSofusakiJusho34() {
        return this.sofusakiJusho34;
    }

    /**
     * sofusakiJusho44を返します。
     *
     * @return sofusakiJusho44 RString
     */
    public RString getSofusakiJusho44() {
        return this.sofusakiJusho44;
    }

    /**
     * sofusakiJusho54を返します。
     *
     * @return sofusakiJusho54 RString
     */
    public RString getSofusakiJusho54() {
        return this.sofusakiJusho54;
    }

    /**
     * yubinNo4を返します。
     *
     * @return yubinNo4 RString
     */
    public RString getYubinNo4() {
        return this.yubinNo4;
    }

    /**
     * sofusakiGyoseikuCode4を返します。
     *
     * @return sofusakiGyoseikuCode4 RString
     */
    public RString getSofusakiGyoseikuCode4() {
        return this.sofusakiGyoseikuCode4;
    }

    /**
     * sofusakiJushoCode4を返します。
     *
     * @return sofusakiJushoCode4 RString
     */
    public RString getSofusakiJushoCode4() {
        return this.sofusakiJushoCode4;
    }

    /**
     * sofusakiChikuName4を返します。
     *
     * @return sofusakiChikuName4 RString
     */
    public RString getSofusakiChikuName4() {
        return this.sofusakiChikuName4;
    }

    /**
     * sofusakiSetaiCode4を返します。
     *
     * @return sofusakiSetaiCode4 RString
     */
    public RString getSofusakiSetaiCode4() {
        return this.sofusakiSetaiCode4;
    }

    /**
     * setainushiMei4を返します。
     *
     * @return setainushiMei4 RString
     */
    public RString getSetainushiMei4() {
        return this.setainushiMei4;
    }

    /**
     * mapJoho4を返します。
     *
     * @return mapJoho4 RString
     */
    public RString getMapJoho4() {
        return this.mapJoho4;
    }

    /**
     * jushoCode4を返します。
     *
     * @return jushoCode4 RString
     */
    public RString getJushoCode4() {
        return this.jushoCode4;
    }

    /**
     * jusho4を返します。
     *
     * @return jusho4 RString
     */
    public RString getJusho4() {
        return this.jusho4;
    }

    /**
     * shimei4を返します。
     *
     * @return shimei4 RString
     */
    public RString getShimei4() {
        return this.shimei4;
    }

    /**
     * shimeiKana14を返します。
     *
     * @return shimeiKana14 RString
     */
    public RString getShimeiKana14() {
        return this.shimeiKana14;
    }

    /**
     * shimeiKana24を返します。
     *
     * @return shimeiKana24 RString
     */
    public RString getShimeiKana24() {
        return this.shimeiKana24;
    }

    /**
     * shimeiKana4を返します。
     *
     * @return shimeiKana4 RString
     */
    public RString getShimeiKana4() {
        return this.shimeiKana4;
    }

    /**
     * setainushiKubun4を返します。
     *
     * @return setainushiKubun4 RString
     */
    public RString getSetainushiKubun4() {
        return this.setainushiKubun4;
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
     * tohyojoMei4を返します。
     *
     * @return tohyojoMei4 RString
     */
    public RString getTohyojoMei4() {
        return this.tohyojoMei4;
    }

    /**
     * tohyojoJusho4を返します。
     *
     * @return tohyojoJusho4 RString
     */
    public RString getTohyojoJusho4() {
        return this.tohyojoJusho4;
    }

    /**
     * tohyokuMei4を返します。
     *
     * @return tohyokuMei4 RString
     */
    public RString getTohyokuMei4() {
        return this.tohyokuMei4;
    }

    /**
     * meiboNo4を返します。
     *
     * @return meiboNo4 RString
     */
    public RString getMeiboNo4() {
        return this.meiboNo4;
    }

    /**
     * gyoseikuCode4を返します。
     *
     * @return gyoseikuCode4 RString
     */
    public RString getGyoseikuCode4() {
        return this.gyoseikuCode4;
    }

    /**
     * gyoseikuMei4を返します。
     *
     * @return gyoseikuMei4 RString
     */
    public RString getGyoseikuMei4() {
        return this.gyoseikuMei4;
    }

    /**
     * chikuCode14を返します。
     *
     * @return chikuCode14 RString
     */
    public RString getChikuCode14() {
        return this.chikuCode14;
    }

    /**
     * chikuName14を返します。
     *
     * @return chikuName14 RString
     */
    public RString getChikuName14() {
        return this.chikuName14;
    }

    /**
     * chikuCode24を返します。
     *
     * @return chikuCode24 RString
     */
    public RString getChikuCode24() {
        return this.chikuCode24;
    }

    /**
     * chikuName24を返します。
     *
     * @return chikuName24 RString
     */
    public RString getChikuName24() {
        return this.chikuName24;
    }

    /**
     * chikuCode34を返します。
     *
     * @return chikuCode34 RString
     */
    public RString getChikuCode34() {
        return this.chikuCode34;
    }

    /**
     * chikuName34を返します。
     *
     * @return chikuName34 RString
     */
    public RString getChikuName34() {
        return this.chikuName34;
    }

    /**
     * sofusakiGyoseikuMei14を返します。
     *
     * @return sofusakiGyoseikuMei14 RString
     */
    public RString getSofusakiGyoseikuMei14() {
        return this.sofusakiGyoseikuMei14;
    }

    /**
     * sofusakiGyoseikuMei24を返します。
     *
     * @return sofusakiGyoseikuMei24 RString
     */
    public RString getSofusakiGyoseikuMei24() {
        return this.sofusakiGyoseikuMei24;
    }

    /**
     * sofusakiGyoseikuMei34を返します。
     *
     * @return sofusakiGyoseikuMei34 RString
     */
    public RString getSofusakiGyoseikuMei34() {
        return this.sofusakiGyoseikuMei34;
    }

    /**
     * shimei14を返します。
     *
     * @return shimei14 RString
     */
    public RString getShimei14() {
        return this.shimei14;
    }

    /**
     * shimei24を返します。
     *
     * @return shimei24 RString
     */
    public RString getShimei24() {
        return this.shimei24;
    }

    /**
     * shimei34を返します。
     *
     * @return shimei34 RString
     */
    public RString getShimei34() {
        return this.shimei34;
    }

    /**
     * seiriNo1を返します。
     *
     * @return seiriNo1 int
     */
    public int getSeiriNo1() {
        return this.seiriNo1;
    }

    /**
     * seiriNo2を返します。
     *
     * @return seiriNo2 int
     */
    public int getSeiriNo2() {
        return this.seiriNo2;
    }

    /**
     * seiriNo3を返します。
     *
     * @return seiriNo3 int
     */
    public int getSeiriNo3() {
        return this.seiriNo3;
    }

    /**
     * barcodeNyujokenBarcode4を設定します。
     *
     * @param barcodeNyujokenBarcode4 RString
     */
    public void setBarcodeNyujokenBarcode4(RString barcodeNyujokenBarcode4) {
        this.barcodeNyujokenBarcode4 = barcodeNyujokenBarcode4;
    }

    /**
     * barcodeCustombarcode4を設定します。
     *
     * @param barcodeCustombarcode4 RString
     */
    public void setBarcodeCustombarcode4(RString barcodeCustombarcode4) {
        this.barcodeCustombarcode4 = barcodeCustombarcode4;
    }

    /**
     * barcodeNyujokenBarcode4を返します。
     *
     * @return barcodeNyujokenBarcode4 RString
     */
    public RString getBarcodeNyujokenBarcode4() {
        return this.barcodeNyujokenBarcode4;
    }

    /**
     * barcodeCustombarcode4を返します。
     *
     * @return barcodeCustombarcode4 RString
     */
    public RString getBarcodeCustombarcode4() {
        return this.barcodeCustombarcode4;
    }
}
