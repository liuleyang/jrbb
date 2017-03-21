/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票事由調書
 *
 * @reamsid_L AF-0270-035 wangl
 */
public class TohyoJiyuChoshoParam {

    private TohyoJokyoEntity 投票状況Entity;
    private RDate 期日前投票日開始;
    private RDate 期日前投票日終了;
    private RDate 受理日開始;
    private RDate 受理日終了;
    private RString 直接1;
    private RString 郵送1;
    private RString 計1;
    private RString 直接2;
    private RString 郵送2;
    private RString 計2;
    private RString 直接3;
    private RString 郵送3;
    private RString 計3;
    private RString 直接4;
    private RString 郵送4;
    private RString 計4;
    private RString 直接5;
    private RString 郵送5;
    private RString 計5;
    private RString 直接6;
    private RString 郵送6;
    private RString 計6;
    private RString 直接7;
    private RString 郵送7;
    private RString 計7;
    private RString 直接合計;
    private RString 郵送合計;
    private RString 計合計;

    /**
     * コンストラクタです。
     *
     * @param 投票状況Entity TohyoJokyoEntity
     * @param 期日前投票日開始 RDate
     * @param 期日前投票日終了 RDate
     * @param 受理日開始 RDate
     * @param 受理日終了 RDate
     */
    public TohyoJiyuChoshoParam(
            TohyoJokyoEntity 投票状況Entity,
            RDate 期日前投票日開始,
            RDate 期日前投票日終了,
            RDate 受理日開始,
            RDate 受理日終了) {
        this.投票状況Entity = 投票状況Entity;
        this.期日前投票日開始 = 期日前投票日開始;
        this.期日前投票日終了 = 期日前投票日終了;
        this.受理日開始 = 受理日開始;
        this.受理日終了 = 受理日終了;
    }

    /**
     * 投票状況Entityを返します。
     *
     * @return 投票状況Entity TohyoJokyoEntity
     */
    public TohyoJokyoEntity get投票状況Entity() {
        return 投票状況Entity;
    }

    /**
     * 期日前投票日開始を返します。
     *
     * @return 期日前投票日開始 RDate
     */
    public RDate get期日前投票日開始() {
        return 期日前投票日開始;
    }

    /**
     * 投票区を返します。
     *
     * @return 期日前投票日終了 RDate
     */
    public RDate get期日前投票日終了() {
        return 期日前投票日終了;
    }

    /**
     * 受理日開始を返します。
     *
     * @return 受理日開始 RDate
     */
    public RDate get受理日開始() {
        return 受理日開始;
    }

    /**
     * 受理日終了を返します。
     *
     * @return 受理日終了 RDate
     */
    public RDate get受理日終了() {
        return 受理日終了;
    }

    /**
     * 直接1を返します。
     *
     * @return 直接1 RString
     */
    public RString get直接1() {
        return 直接1;
    }

    /**
     * 郵送1を返します。
     *
     * @return 郵送1 RString
     */
    public RString get郵送1() {
        return 郵送1;
    }

    /**
     * 計1を返します。
     *
     * @return 計1 RString
     */
    public RString get計1() {
        return 計1;
    }

    /**
     * 直接2を返します。
     *
     * @return 直接2 RString
     */
    public RString get直接2() {
        return 直接2;
    }

    /**
     * 郵送2を返します。
     *
     * @return 郵送2 RString
     */
    public RString get郵送2() {
        return 郵送2;
    }

    /**
     * 計2を返します。
     *
     * @return 計2 RString
     */
    public RString get計2() {
        return 計2;
    }

    /**
     * 直接3を返します。
     *
     * @return 直接3 RString
     */
    public RString get直接3() {
        return 直接3;
    }

    /**
     * 郵送3を返します。
     *
     * @return 郵送3 RString
     */
    public RString get郵送3() {
        return 郵送3;
    }

    /**
     * 計3を返します。
     *
     * @return 計3 RString
     */
    public RString get計3() {
        return 計3;
    }

    /**
     * 直接4を返します。
     *
     * @return 直接4 RString
     */
    public RString get直接4() {
        return 直接4;
    }

    /**
     * 郵送4を返します。
     *
     * @return 郵送4 RString
     */
    public RString get郵送4() {
        return 郵送4;
    }

    /**
     * 計4を返します。
     *
     * @return 計4 RString
     */
    public RString get計4() {
        return 計4;
    }

    /**
     * 直接5を返します。
     *
     * @return 直接5 RString
     */
    public RString get直接5() {
        return 直接5;
    }

    /**
     * 郵送5を返します。
     *
     * @return 郵送5 RString
     */
    public RString get郵送5() {
        return 郵送5;
    }

    /**
     * 計5を返します。
     *
     * @return 計5 RString
     */
    public RString get計5() {
        return 計5;
    }

    /**
     * 直接6を返します。
     *
     * @return 直接6 RString
     */
    public RString get直接6() {
        return 直接6;
    }

    /**
     * 郵送6を返します。
     *
     * @return 郵送6 RString
     */
    public RString get郵送6() {
        return 郵送6;
    }

    /**
     * 計6を返します。
     *
     * @return 計6 RString
     */
    public RString get計6() {
        return 計6;
    }

    /**
     * 直接7を返します。
     *
     * @return 直接7 RString
     */
    public RString get直接7() {
        return 直接7;
    }

    /**
     * 郵送7を返します。
     *
     * @return 郵送7 RString
     */
    public RString get郵送7() {
        return 郵送7;
    }

    /**
     * 計7を返します。
     *
     * @return 計7 RString
     */
    public RString get計7() {
        return 計7;
    }

    /**
     * 直接合計を返します。
     *
     * @return 直接合計 RString
     */
    public RString get直接合計() {
        return 直接合計;
    }

    /**
     * 郵送合計を返します。
     *
     * @return 郵送合計 RString
     */
    public RString get郵送合計() {
        return 郵送合計;
    }

    /**
     * 計合計を返します。
     *
     * @return 計合計 RString
     */
    public RString get計合計() {
        return 計合計;
    }

    /**
     * 投票状況Entityを設定します。
     *
     * @param 投票状況Entity TohyoJokyoEntity
     */
    public void set投票状況Entity(TohyoJokyoEntity 投票状況Entity) {
        this.投票状況Entity = 投票状況Entity;
    }

    /**
     * 期日前投票日開始を設定します。
     *
     * @param 期日前投票日開始 RDate
     */
    public void set期日前投票日開始(RDate 期日前投票日開始) {
        this.期日前投票日開始 = 期日前投票日開始;
    }

    /**
     * 期日前投票日終了を設定します。
     *
     * @param 期日前投票日終了 RDate
     */
    public void set期日前投票日終了(RDate 期日前投票日終了) {
        this.期日前投票日終了 = 期日前投票日終了;
    }

    /**
     * 受理日開始を設定します。
     *
     * @param 受理日開始 RDate
     */
    public void set受理日開始(RDate 受理日開始) {
        this.受理日開始 = 受理日開始;
    }

    /**
     * 受理日終了を設定します。
     *
     * @param 受理日終了 RDate
     */
    public void set受理日終了(RDate 受理日終了) {
        this.受理日終了 = 受理日終了;
    }

    /**
     * 直接1を設定します。
     *
     * @param 直接1 RString
     */
    public void set直接1(RString 直接1) {
        this.直接1 = 直接1;
    }

    /**
     * 郵送1を設定します。
     *
     * @param 郵送1 RString
     */
    public void set郵送1(RString 郵送1) {
        this.郵送1 = 郵送1;
    }

    /**
     * 計1を設定します。
     *
     * @param 計1 RString
     */
    public void set計1(RString 計1) {
        this.計1 = 計1;
    }

    /**
     * 直接2を設定します。
     *
     * @param 直接2 RString
     */
    public void set直接2(RString 直接2) {
        this.直接2 = 直接2;
    }

    /**
     * 直接6を設定します。
     *
     * @param 郵送2 RString
     */
    public void set郵送2(RString 郵送2) {
        this.郵送2 = 郵送2;
    }

    /**
     * 計2を設定します。
     *
     * @param 計2 RString
     */
    public void set計2(RString 計2) {
        this.計2 = 計2;
    }

    /**
     * 直接3を設定します。
     *
     * @param 直接3 RString
     */
    public void set直接3(RString 直接3) {
        this.直接3 = 直接3;
    }

    /**
     * 郵送3を設定します。
     *
     * @param 郵送3 RString
     */
    public void set郵送3(RString 郵送3) {
        this.郵送3 = 郵送3;
    }

    /**
     * 計3を設定します。
     *
     * @param 計3 RString
     */
    public void set計3(RString 計3) {
        this.計3 = 計3;
    }

    /**
     * 直接4を設定します。
     *
     * @param 直接4 RString
     */
    public void set直接4(RString 直接4) {
        this.直接4 = 直接4;
    }

    /**
     * 郵送4を設定します。
     *
     * @param 郵送4 RString
     */
    public void set郵送4(RString 郵送4) {
        this.郵送4 = 郵送4;
    }

    /**
     * 計4を設定します。
     *
     * @param 計4 RString
     */
    public void set計4(RString 計4) {
        this.計4 = 計4;
    }

    /**
     * 直接5を設定します。
     *
     * @param 直接5 RString
     */
    public void set直接5(RString 直接5) {
        this.直接5 = 直接5;
    }

    /**
     * 郵送5を設定します。
     *
     * @param 郵送5 RString
     */
    public void set郵送5(RString 郵送5) {
        this.郵送5 = 郵送5;
    }

    /**
     * 計5を設定します。
     *
     * @param 計5 RString
     */
    public void set計5(RString 計5) {
        this.計5 = 計5;
    }

    /**
     * 直接6を設定します。
     *
     * @param 直接6 RString
     */
    public void set直接6(RString 直接6) {
        this.直接6 = 直接6;
    }

    /**
     * 郵送6を設定します。
     *
     * @param 郵送6 RString
     */
    public void set郵送6(RString 郵送6) {
        this.郵送6 = 郵送6;
    }

    /**
     * 計6を設定します。
     *
     * @param 計6 RString
     */
    public void set計6(RString 計6) {
        this.計6 = 計6;
    }

    /**
     * 直接7を設定します。
     *
     * @param 直接7 RString
     */
    public void set直接7(RString 直接7) {
        this.直接7 = 直接7;
    }

    /**
     * 郵送7を設定します。
     *
     * @param 郵送7 RString
     */
    public void set郵送7(RString 郵送7) {
        this.郵送7 = 郵送7;
    }

    /**
     * 計7を設定します。
     *
     * @param 計7 RString
     */
    public void set計7(RString 計7) {
        this.計7 = 計7;
    }

    /**
     * 直接合計を設定します。
     *
     * @param 直接合計 RString
     */
    public void set直接合計(RString 直接合計) {
        this.直接合計 = 直接合計;
    }

    /**
     * 郵送合計を設定します。
     *
     * @param 郵送合計 RString
     */
    public void set郵送合計(RString 郵送合計) {
        this.郵送合計 = 郵送合計;
    }

    /**
     * 計合計を設定します。
     *
     * @param 計合計 RString
     */
    public void set計合計(RString 計合計) {
        this.計合計 = 計合計;
    }

}
