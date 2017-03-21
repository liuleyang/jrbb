/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyojizaisanku;

import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku.SenkyojiZaisankuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録の編集クラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuEditor {

    /**
     * グループコードブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreakByグループコード(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString beforeグループコード;
        RString currentグループコード;

        if (財産区選挙人名簿抄本情報before == null) {
            beforeグループコード = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get選挙人名簿情報() != null
                && 財産区選挙人名簿抄本情報before.get選挙人名簿情報().getGroupCode() == null) {
            beforeグループコード = RString.EMPTY;
        } else {
            RString グループコード = 財産区選挙人名簿抄本情報before.get選挙人名簿情報().getGroupCode();
            beforeグループコード = グループコード != null ? グループコード : RString.EMPTY;
        }
        if (財産区選挙人名簿抄本情報current == null) {
            currentグループコード = RString.EMPTY;
        } else {
            RString グループコード = 財産区選挙人名簿抄本情報current.get選挙人名簿情報().getGroupCode();
            currentグループコード = グループコード != null ? グループコード : RString.EMPTY;
        }
        if (!beforeグループコード.equals(currentグループコード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 投票区コードブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreakBy投票区(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString before投票区コード;
        RString current投票区コード;

        if (財産区選挙人名簿抄本情報before == null) {
            before投票区コード = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get宛名PSM情報() != null
                && 財産区選挙人名簿抄本情報before.get宛名PSM情報().getTohyokuCode() == null) {
            before投票区コード = RString.EMPTY;
        } else {
            TohyokuCode 投票区コード = 財産区選挙人名簿抄本情報before.get宛名PSM情報().getTohyokuCode();
            before投票区コード = 投票区コード != null ? 投票区コード.value() : RString.EMPTY;
        }
        if (財産区選挙人名簿抄本情報current == null) {
            current投票区コード = RString.EMPTY;
        } else {
            TohyokuCode 投票区コード = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getTohyokuCode();
            current投票区コード = 投票区コード != null ? 投票区コード.value() : RString.EMPTY;
        }
        if (!before投票区コード.equals(current投票区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 住所コードブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreak住所コード(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {

        RString before住所コード;
        RString current住所コード;

        if (財産区選挙人名簿抄本情報before == null) {
            before住所コード = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get宛名PSM情報() != null
                && 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChoikiCode() == null) {
            before住所コード = RString.EMPTY;
        } else {
            ChoikiCode 住所コード = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getJutonaiChoikiCode();
            before住所コード = 住所コード != null ? 住所コード.value() : RString.EMPTY;
        }

        if (財産区選挙人名簿抄本情報current == null) {
            current住所コード = RString.EMPTY;
        } else {
            ChoikiCode 住所コード = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getJutonaiChoikiCode();
            current住所コード = 住所コード != null ? 住所コード.value() : RString.EMPTY;
        }
        if (!before住所コード.equals(current住所コード)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /**
     * 行政区コードブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreak行政区コード(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString before行政区コード;
        RString current行政区コード;

        if (財産区選挙人名簿抄本情報before == null) {
            before行政区コード = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get宛名PSM情報() != null
                && 財産区選挙人名簿抄本情報before.get宛名PSM情報().getGyoseikuCode() == null) {
            before行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = 財産区選挙人名簿抄本情報before.get宛名PSM情報().getGyoseikuCode();
            before行政区コード = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }

        if (財産区選挙人名簿抄本情報current == null) {
            current行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getGyoseikuCode();
            current行政区コード = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (!before行政区コード.equals(current行政区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 地区コード１ブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreak地区コード１(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString before地区コード１;
        RString current地区コード１;

        if (財産区選挙人名簿抄本情報before == null) {
            before地区コード１ = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get宛名PSM情報() != null
                && 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChikuCode1() == null) {
            before地区コード１ = RString.EMPTY;
        } else {

            ChikuCode 地区コード１ = 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChikuCode1();
            before地区コード１ = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }

        if (財産区選挙人名簿抄本情報current == null) {
            current地区コード１ = RString.EMPTY;
        } else {
            ChikuCode 地区コード１ = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getChikuCode1();
            current地区コード１ = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (!before地区コード１.equals(current地区コード１)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /**
     * 地区コード２ブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreak地区コード２(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString before地区コード２;
        RString current地区コード２;

        if (財産区選挙人名簿抄本情報before == null) {
            before地区コード２ = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get宛名PSM情報() != null
                && 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChikuCode2() == null) {
            before地区コード２ = RString.EMPTY;
        } else {
            ChikuCode 地区コード２ = 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChikuCode1();
            before地区コード２ = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }

        if (財産区選挙人名簿抄本情報current == null) {
            current地区コード２ = RString.EMPTY;
        } else {
            ChikuCode 地区コード２ = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getChikuCode1();
            current地区コード２ = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }
        if (!before地区コード２.equals(current地区コード２)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /**
     * 地区コード３ブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreak地区コード３(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString before地区コード３;
        RString current地区コード３;

        if (財産区選挙人名簿抄本情報before == null) {
            before地区コード３ = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get宛名PSM情報() != null
                && 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChikuCode3() == null) {
            before地区コード３ = RString.EMPTY;
        } else {
            ChikuCode 地区コード３ = 財産区選挙人名簿抄本情報before.get宛名PSM情報().getChikuCode1();
            before地区コード３ = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }

        if (財産区選挙人名簿抄本情報current == null) {
            current地区コード３ = RString.EMPTY;
        } else {
            ChikuCode 地区コード３ = 財産区選挙人名簿抄本情報current.get宛名PSM情報().getChikuCode1();
            current地区コード３ = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }
        if (!before地区コード３.equals(current地区コード３)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    /**
     * 冊ブレークを判定する。
     *
     * @param 財産区選挙人名簿抄本情報before SenkyojiZaisankuEntity
     * @param 財産区選挙人名簿抄本情報current SenkyojiZaisankuEntity
     * @return Boolean
     */
    public Boolean hasBreak冊(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報before,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報current) {
        RString before冊;
        RString current冊;

        if (財産区選挙人名簿抄本情報before == null) {
            before冊 = RString.EMPTY;
        } else if (財産区選挙人名簿抄本情報before.get選挙人名簿情報() != null
                && 財産区選挙人名簿抄本情報before.get選挙人名簿情報().getSatsu() == null) {
            before冊 = RString.EMPTY;
        } else {
            RString 冊 = 財産区選挙人名簿抄本情報before.get選挙人名簿情報().getSatsu();
            before冊 = 冊 != null ? 冊 : RString.EMPTY;
        }

        if (財産区選挙人名簿抄本情報current == null) {
            current冊 = RString.EMPTY;
        } else {
            RString 冊 = 財産区選挙人名簿抄本情報current.get選挙人名簿情報().getSatsu();
            current冊 = 冊 != null ? 冊 : RString.EMPTY;
        }
        if (!before冊.equals(current冊)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

}
