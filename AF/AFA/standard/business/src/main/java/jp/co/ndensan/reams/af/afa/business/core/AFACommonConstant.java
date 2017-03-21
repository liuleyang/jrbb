/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFACommonConstant
 *
 * @reamsid_L AF-0450-020 lis
 */
public final class AFACommonConstant {

    /**
     * 受理日開始
     */
    public static final RString 受理日開始;
    /**
     * 受理日終了
     */
    public static final RString 受理日終了;
    /**
     * INT_0
     */
    public static final int INT_0;
    /**
     * INT_1
     */
    public static final int INT_1;
    /**
     * 投票区
     */
    public static final RString 投票区;
    /**
     * 行政区
     */
    public static final RString 行政区;
    /**
     * 住所
     */
    public static final RString 住所;
    /**
     * 地区1
     */
    public static final RString 地区1;
    /**
     * 地区2
     */
    public static final RString 地区2;
    /**
     * 地区3
     */
    public static final RString 地区3;

    static {
        受理日開始 = new RString("受理日開始");
        受理日終了 = new RString("受理日終了");
        INT_0 = 0;
        INT_1 = 1;
        投票区 = new RString("投票区");
        行政区 = new RString("行政区");
        住所 = new RString("住所");
        地区1 = new RString("地区1");
        地区2 = new RString("地区2");
        地区3 = new RString("地区3");
    }

    private AFACommonConstant() {

    }
}
