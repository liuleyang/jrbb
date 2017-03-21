/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;

/**
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriParam extends Nyujoken3tsuoriParentParam {

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
    public Nyujoken3tsuoriParam(NyujoukenGamenModel 入場券帳票作成入力情報, SoufusakiJouhou 送付先情報1,
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
     * 入場券帳票作成入力情報
     *
     * @param 入場券帳票作成入力情報 NyujoukenGamenModel
     */
    public void set入場券帳票作成入力情報(NyujoukenGamenModel 入場券帳票作成入力情報) {
        this.入場券帳票作成入力情報 = 入場券帳票作成入力情報;
    }

    /**
     * 送付先情報1
     *
     * @param 送付先情報1 SoufusakiJouhou
     */
    public void set送付先情報1(SoufusakiJouhou 送付先情報1) {
        this.送付先情報1 = 送付先情報1;
    }

    /**
     * 送付先情報2
     *
     * @param 送付先情報2 SoufusakiJouhou
     */
    public void set送付先情報2(SoufusakiJouhou 送付先情報2) {
        this.送付先情報2 = 送付先情報2;
    }

    /**
     * 送付先情報3
     *
     * @param 送付先情報3 SoufusakiJouhou
     */
    public void set送付先情報3(SoufusakiJouhou 送付先情報3) {
        this.送付先情報3 = 送付先情報3;
    }

    /**
     * 送付先情報4
     *
     * @param 送付先情報4 SoufusakiJouhou
     */
    public void set送付先情報4(SoufusakiJouhou 送付先情報4) {
        this.送付先情報4 = 送付先情報4;
    }

    /**
     * 明細情報1
     *
     * @param 明細情報1 MeisaiJouhou
     */
    public void set明細情報1(MeisaiJouhou 明細情報1) {
        this.明細情報1 = 明細情報1;
    }

    /**
     * 明細情報2
     *
     * @param 明細情報2 MeisaiJouhou
     */
    public void set明細情報2(MeisaiJouhou 明細情報2) {
        this.明細情報2 = 明細情報2;
    }

    /**
     * 明細情報3
     *
     * @param 明細情報3 MeisaiJouhou
     */
    public void set明細情報3(MeisaiJouhou 明細情報3) {
        this.明細情報3 = 明細情報3;
    }

    /**
     * 明細情報4
     *
     * @param 明細情報4 MeisaiJouhou
     */
    public void set明細情報4(MeisaiJouhou 明細情報4) {
        this.明細情報4 = 明細情報4;
    }

    /**
     * 明細情報5
     *
     * @param 明細情報5 MeisaiJouhou
     */
    public void set明細情報5(MeisaiJouhou 明細情報5) {
        this.明細情報5 = 明細情報5;
    }

    /**
     * 明細情報6
     *
     * @param 明細情報6 MeisaiJouhou
     */
    public void set明細情報6(MeisaiJouhou 明細情報6) {
        this.明細情報6 = 明細情報6;
    }

    /**
     * 明細情報7
     *
     * @param 明細情報7 MeisaiJouhou
     */
    public void set明細情報7(MeisaiJouhou 明細情報7) {
        this.明細情報7 = 明細情報7;
    }

    /**
     * 明細情報8
     *
     * @param 明細情報8 MeisaiJouhou
     */
    public void set明細情報8(MeisaiJouhou 明細情報8) {
        this.明細情報8 = 明細情報8;
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
