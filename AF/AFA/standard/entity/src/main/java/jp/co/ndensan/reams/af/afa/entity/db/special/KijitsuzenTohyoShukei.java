/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.special;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 【期日前投票】投票状況の集計結果を格納するテーブルの項目定義を行うEnumです。
 *
 * @author N1823 有澤 礼恵
 */
public enum KijitsuzenTohyoShukei implements IColumnDefinition {

    /**
     * shohonNo
     */
    shohonNo(2147483647, 0),
    /**
     * senkyoNo
     */
    senkyoNo(2147483647, 0),
    /**
     * shisetsuCode
     */
    shisetsuCode(4, 0),
    /**
     * shisetsuName
     */
    shisetsuName(50, 0),
    /**
     * tohyoToday_Man
     */
    tohyoToday_Man(19, 0),
    /**
     * tohyoToday_Woman
     */
    tohyoToday_Woman(19, 0),
    /**
     * tohyoToday_Kei
     */
    tohyoToday_Kei(19, 0),
    /**
     * tohyo_Man
     */
    tohyo_Man(19, 0),
    /**
     * tohyo_Woman
     */
    tohyo_Woman(19, 0),
    /**
     * tohyo_Kei
     */
    tohyo_Kei(19, 0);

    private final int maxLength;
    private final int scale;

    private KijitsuzenTohyoShukei(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大桁数を返します。
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 項目の小数点以下の桁数を返します。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

}
