/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.ICodeValueObject;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * データ引継区分を表すドメインクラスです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class DataHikituKubun implements ICodeValueObject, IDbColumnMappable, IValueObject<Code>, Comparable<DataHikituKubun> {

    /**
     * AFA選挙本体を表すサブ業務コードです。
     */
    public static final SubGyomuCode SUB_GYOMU_CODE;
    /**
     * 転出表示区分を表すコード種別です。
     */
    public static final CodeShubetsu CODE_SHUBETSU;

    private final Code code;

    static {
        SUB_GYOMU_CODE = SubGyomuCode.AFA選挙本体;
        CODE_SHUBETSU = AFACodeShubetsu.データ引継区分.getCodeShubetsu();
    }

    /**
     * コンストラクタです。
     *
     * @param code データ引継区分
     */
    public DataHikituKubun(Code code) {
        this.code = code;
    }

    /**
     * コンストラクタです。
     *
     * @param code 転出表示区分を表す文字列
     */
    public DataHikituKubun(RString code) {
        this.code = new Code(code);
    }

    @Override
    public RString toRString() {
        return code == null ? RString.EMPTY : code.value();
    }

    //TODO hashCode()を生成するのに使用している数値を変更してください。
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataHikituKubun other = (DataHikituKubun) obj;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public int compareTo(DataHikituKubun o) {
        return this.code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return toRString().toString();
    }

    @Override
    public Code value() {
        return code;
    }

    @Override
    public RString getColumnValue() {
        return value().getColumnValue();
    }

    @Override
    public RString getMeisho() {
        return code == null ? RString.EMPTY : CodeMaster.getCodeMeisho(SUB_GYOMU_CODE, CODE_SHUBETSU, code);
    }

    @Override
    public RString getMeisho(FlexibleDate kijunbi) {
        return code == null ? RString.EMPTY : CodeMaster.getCodeMeisho(SUB_GYOMU_CODE, CODE_SHUBETSU, code, kijunbi);
    }

    @Override
    public RString getRyakusho() {
        return code == null ? RString.EMPTY : CodeMaster.getCodeRyakusho(SUB_GYOMU_CODE, CODE_SHUBETSU, code);
    }

    @Override
    public RString getRyakusho(FlexibleDate kijunbi) {
        return code == null ? RString.EMPTY : CodeMaster.getCodeRyakusho(SUB_GYOMU_CODE, CODE_SHUBETSU, code, kijunbi);
    }
}
