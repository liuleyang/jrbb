/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050;

import java.util.Arrays;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票率集計表帳票出力の共通処理を行うクラスです。
 *
 * @reamsid_L AF-0290-035 lit
 */
public final class TohyoritsuCommonCore {

    private TohyoritsuCommonCore() {

    }

    /**
     * 有権者判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 有権者
     */
    public static boolean is有権者(TohyokekkaPrintEntity current) {

        Code 選挙資格区分 = current.get選挙資格Entity().getShikakuKubun();
        RString 選挙資格区分Str = 選挙資格区分 == null ? RString.EMPTY : 選挙資格区分.getColumnValue();
        Code 投票状況Code = get投票状況(current);
        RString 投票状況Str = 投票状況Code == null ? RString.EMPTY : 投票状況Code.getColumnValue();
        return Arrays.asList(SennkyoSikakuKubun.有権者.value(), SennkyoSikakuKubun.表示者.value()).contains(選挙資格区分Str)
                || (Arrays.asList(SennkyoSikakuKubun.抹消者.value(), SennkyoSikakuKubun.公民権停止.value()).contains(選挙資格区分Str)
                && TohyoJokyo.期日前.getCode().equals(投票状況Str));
    }

    /**
     * 投票者判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 投票者
     */
    public static boolean is投票者(TohyokekkaPrintEntity current) {
        return is当日分(current) || is期日前不在者分(current);
    }

    /**
     * 棄権者判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 棄権者
     */
    public static boolean is棄権者(TohyokekkaPrintEntity current) {
        Code 投票状況 = get投票状況(current);
        return (null != 投票状況
                && TohyoJokyo.棄権.getCode().equals(投票状況.value()));
    }

    /**
     * 当日分判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 当日分
     */
    public static boolean is当日分(TohyokekkaPrintEntity current) {
        Code 投票状況 = get投票状況(current);
        return (null != 投票状況
                && TohyoJokyo.当日.getCode().equals(投票状況.value()));
    }

    /**
     * 期日前不在者判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 期日前不在者
     */
    public static boolean is期日前不在者分(TohyokekkaPrintEntity current) {
        return is期日前(current) || is不在者(current);
    }

    /**
     * 期日前判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 期日前
     */
    public static boolean is期日前(TohyokekkaPrintEntity current) {
        Code 投票状況 = get投票状況(current);
        return (null != 投票状況
                && TohyoJokyo.期日前.getCode().equals(投票状況.value()));
    }

    /**
     * 不在者判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 不在者
     */
    public static boolean is不在者(TohyokekkaPrintEntity current) {
        Code 投票状況 = get投票状況(current);
        return (null != 投票状況
                && TohyoJokyo.受理.getCode().equals(投票状況.value()));
    }

    /**
     * 交付者判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 交付者
     */
    public static boolean is交付者(TohyokekkaPrintEntity current) {
        Code 投票状況 = get投票状況(current);
        return (null != 投票状況
                && TohyoJokyo.交付.getCode().equals(投票状況.value()));
    }

    /**
     * 男判断かどうか。
     *
     * @param current TohyokekkaPrintEntity
     * @return 男
     */
    public static boolean is男(TohyokekkaPrintEntity current) {
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.get宛名情報Entity());
        if (宛名対象.canBe個人()) {
            return 宛名対象.to個人().get性別().equals(Gender.MALE);
        }
        return false;
    }

    private static Code get投票状況(TohyokekkaPrintEntity current) {
        if (null == current.get投票状況Entity()) {
            return null;
        }
        return current.get投票状況Entity().getTohyoJokyo();
    }
}
