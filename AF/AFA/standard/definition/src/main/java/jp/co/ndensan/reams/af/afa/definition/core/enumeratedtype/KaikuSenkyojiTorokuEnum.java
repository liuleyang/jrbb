/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区選挙時登録用ENUM
 *
 * @reamsid_L AF-0470-010 jihb
 */
public enum KaikuSenkyojiTorokuEnum {

    /**
     * 抄本件数エラー用メッセージ
     */
    当初登録(new RString("当初登録の")),
    /**
     * 新規登録ボタンで画面制御
     */
    新規登録(new RString("1")),
    /**
     * チェックボックス_オン
     */
    チェックオン(new RString("0")),
    /**
     * ラベル_前
     */
    ラベル_前(new RString("平成")),
    /**
     * ラベル_後
     */
    ラベル_後(new RString("12月15日確定の名簿抄本から作成します")),
    /**
     * メニューID_登録
     */
    メニューID_登録(new RString("AFAMNK1030")),
    /**
     * メニューID_修正
     */
    メニューID_修正(new RString("AFAMNK1050")),
    /**
     * 1
     */
    ONE(new RString("1")),
    /**
     * 2
     */
    TWO(new RString("2")),
    /**
     * 本年_4月
     */
    本年_4月(new RString("4")),
    /**
     * 本年_1日
     */
    本年_1日(new RString("1")),
    /**
     * 本年_12月
     */
    本年_12月(new RString("12")),
    /**
     * 本年_31日
     */
    本年_31日(new RString("31"));

    private final RString value;

    KaikuSenkyojiTorokuEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された海区選挙時登録用ENUMを返します。
     *
     * @return 海区選挙時登録用ENUM
     */
    public RString getValue() {
        return this.value;
    }

    /**
     * 指定された海区選挙時登録用ENUMを返します。
     *
     * @return 海区選挙時登録用ENUM
     */
    public int getIntValue() {
        return Integer.valueOf(this.value.toString());
    }
}
