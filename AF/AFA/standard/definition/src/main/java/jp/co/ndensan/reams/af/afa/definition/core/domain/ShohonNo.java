/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.domain;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 抄本番号を表すクラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class ShohonNo implements IValueObject<Integer>, Comparable<ShohonNo>, IDbColumnMappable {

    private final Integer theValue;

    /**
     * コンストラクタです。
     *
     * @param value Integer 抄本番号
     */
    public ShohonNo(Integer value) {
        this.theValue = value;
    }

    /**
     * コンストラクタです。
     *
     * @param value RString 抄本番号
     */
    public ShohonNo(RString value) {
        this.theValue = Integer.parseInt(value.toString());
    }

    @Override
    public Integer value() {
        return theValue;
    }

    @Override
    public Integer getColumnValue() {
        return value();
    }

    @Override
    public String toString() {
        return theValue.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShohonNo other = (ShohonNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.theValue);
        return hash;
    }

    @Override
    public int compareTo(ShohonNo o) {
        return value().compareTo(o.value());
    }

}
