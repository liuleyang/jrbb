/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.teijitouroku;

import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * NUllの解消クラス。
 *
 */
public final class NullHandler {

    private static final int 転入前全国住所コード上5桁 = 5;

    private NullHandler() {

    }

    /**
     * CodeがNUllの解消メソード。
     *
     * @param arg Code
     * @return RString
     */
    public static RString getNullToRString(Code arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg.value();
        }
    }

    /**
     * TohyokuCodeがNUllの解消メソード。
     *
     * @param arg TohyokuCode
     * @return RString
     */
    public static RString getNullToRString(TohyokuCode arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg.value();
        }
    }

    /**
     * ChikuCodeがNUllの解消メソード。
     *
     * @param arg ChikuCode
     * @return RString
     */
    public static RString getNullToRString(ChikuCode arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg.value();
        }
    }

    /**
     * GyoseikuCodeがNUllの解消メソード。
     *
     * @param arg GyoseikuCode
     * @return RString
     */
    public static RString getNullToRString(GyoseikuCode arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg.value();
        }
    }

    /**
     * LasdecCodeがNUllの解消メソード。
     *
     * @param arg LasdecCode
     * @return RString
     */
    public static RString getNullToRString(LasdecCode arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg.value();
        }
    }

    /**
     * ZenkokuJushoCodeがNUllの解消メソード。
     *
     * @param arg ZenkokuJushoCode
     * @return RString
     */
    public static RString getNullToRString(ZenkokuJushoCode arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg.value();
        }
    }

    /**
     * RStringがNUllの解消メソード。
     *
     * @param arg RString
     * @return RString
     */
    public static RString getNullToRString(RString arg) {
        if (null == arg) {
            return RString.EMPTY;
        } else {
            return arg;
        }
    }

    /**
     * FlexibleDateがNUllの解消メソード。
     *
     * @param arg FlexibleDate
     * @return FlexibleDate
     */
    public static FlexibleDate getNullToFlexibleDate(FlexibleDate arg) {
        if (null == arg) {
            return FlexibleDate.EMPTY;
        } else {
            return arg;
        }
    }

    /**
     * 転入前全国住所コードがNUllの解消メソード。
     *
     * @param entity SenkyoninTohyoJokyoEntity
     * @return RString
     */
    public static RString get転入前全国住所コード上5桁(SenkyoninTohyoJokyoEntity entity) {
        RString 転入前全国住所コード = getNullToRString(entity.getAtenaPSMEntity().getTennyumaeZenkokuJushoCode());
        if (転入前全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 転入前全国住所コード.substring(0, 転入前全国住所コード上5桁);
        }
    }

    /**
     * 転出確定全国住所コードがNUllの解消メソード。
     *
     * @param entity SenkyoninTohyoJokyoEntity
     * @return RString
     */
    public static RString get転出確定全国住所コード上5桁(SenkyoninTohyoJokyoEntity entity) {
        RString 転出確定全国住所コード = getNullToRString(entity.getAtenaPSMEntity().getTenshutsuKakuteiZenkokuJushoCode());
        if (転出確定全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 転出確定全国住所コード.substring(0, 転入前全国住所コード上5桁);
        }
    }
}
