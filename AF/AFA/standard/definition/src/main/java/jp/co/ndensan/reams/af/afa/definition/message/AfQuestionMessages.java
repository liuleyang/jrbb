/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.message;

import static jp.co.ndensan.reams.af.afa.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * AFの質問メッセージ定義列挙型です。
 *
 * @reamsid_L AF-0320-011 lis
 */
public enum AfQuestionMessages implements IMessageGettable {

    /**
     * 投票受付判断
     */
    投票受付判断(1, "投票受付しますか？?"),
    /**
     * 画面クリア
     */
    画面クリア(2, "表示内容をクリアし、別の住民を検索します。よろしいですか？"),
    /**
     * 保存確認_投票録
     */
    保存確認_投票録(3, "％が保存されていません。保存しますか？"),
    /**
     * 保存の確認
     */
    保存の確認(4, "保存をします。よろしいですか？"),
    /**
     * 交付番号採番確認
     */
    交付番号採番確認(5, "交付番号を採番します。よろしいですか？<br>交付日：％"),
    /**
     * 工事中メッセージ
     */
    工事中メッセージ(99999, "現在、作成中です。。。");

    private final RString replece = new RString("％");
    private final RString code;
    private final RString message;
    private ButtonSelectPattern pattern;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private AfQuestionMessages(int no, String message) {
        this.code = new RString(toCode("Q", no));
        this.message = new RString(message);
        this.pattern = null;
    }

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     * @param pattern パタン
     */
    private AfQuestionMessages(int no, String message, ButtonSelectPattern pattern) {
        this.code = new RString(toCode("Q", no));
        this.message = new RString(message);
        this.pattern = pattern;
    }

    /**
     * メッセージを返します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        if (pattern == null) {
            return new QuestionMessage(code.toString(), message.toString());
        }
        return new QuestionMessage(code.toString(), message.toString(), pattern);
    }

    /**
     * 選択可能ボタンを指定してメッセージを返します。
     *
     * @param pattern ボタンセレクトパターン
     * @return メッセージ
     */
    public Message getMessage(ButtonSelectPattern pattern) {
        return new QuestionMessage(code.toString(), message.toString(), pattern);
    }

    /**
     * 自身のメッセージの?の部分を引数で受け取った値で置換した値を返します。
     *
     * @param replacers ?を置換する文字列
     * @return 引数で受け取った値で置換したメッセージ
     */
    public Message getReplacedMessage(String... replacers) {
        return getReplacedMessage(pattern, replacers);
    }

    /**
     * 自身のメッセージの?の部分を引数で受け取った値で置換した値を、選択可能ボタンを指定して返します。
     *
     * @param pattern ボタンセレクトパターン
     * @param replacers ?を置換する文字列
     * @return 引数で受け取った値で置換したメッセージ
     */
    public Message getReplacedMessage(ButtonSelectPattern pattern, String... replacers) {

        if (getReplacerCount() != replacers.length) {
            throw new IllegalArgumentException("置換予定部分の数と、指定する置換文字列の数を一致させてください。");
        }
        RString replaced = message;
        int i = 0;

        while (true) {
            replaced = replaced.replace(replece.toString(), replacers[i++]);

            if (replaced.indexOf(replece.toString()) < 0) {
                return new QuestionMessage(code.toString(), replaced.toString(), pattern);
            }
        }
    }

    private int getReplacerCount() {
        int count = 0;
        int position = 0;
        while (true) {
            int index = message.indexOf(replece.toString(), position);
            if (index == -1) {
                break;
            }
            position += (index + 1);
            count++;
        }
        return count;
    }
}
