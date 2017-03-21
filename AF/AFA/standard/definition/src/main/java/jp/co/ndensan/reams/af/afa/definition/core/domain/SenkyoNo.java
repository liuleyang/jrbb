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
 * 選挙番号を表すクラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class SenkyoNo implements IValueObject<Integer>, Comparable<SenkyoNo>, IDbColumnMappable {

    private final Integer theValue;

    /**
     * コンストラクタです。
     *
     * @param value Integer 選挙番号
     */
    public SenkyoNo(Integer value) {
        this.theValue = value;
    }

    /**
     * コンストラクタです。
     *
     * @param value RString 選挙番号
     */
    public SenkyoNo(RString value) {
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
        final SenkyoNo other = (SenkyoNo) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.theValue);
        return hash;
    }

    @Override
    public int compareTo(SenkyoNo o) {
        return value().compareTo(o.value());
    }
}
