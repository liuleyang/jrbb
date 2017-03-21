/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.kaiku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成のパラーメタです。
 *
 * @reamsid_L AF-0460-020 lis
 */
public enum OutputKeys {

    /**
     * 汎用キー
     */
    汎用キー(new RString("抄本番号")),
    /**
     * CSV出力有無_有り
     */
    CSV出力有無_有り(new RString("有り")),
    /**
     * 出力内容_連絡符号１
     */
    出力内容_連絡符号１(new RString(":")),
    /**
     * 出力内容_出力
     */
    出力内容_出力(new RString("出力")),
    /**
     * 出力内容_出力しない
     */
    出力内容_出力しない(new RString("出力しない")),
    /**
     * 海区
     */
    海区(new RString("海区")),
    /**
     * 選挙レベル
     */
    選挙レベル(new RString("9")),
    /**
     * 選挙番号
     */
    選挙番号(new RString("1")),
    /**
     * 投票区名称
     */
    投票区名称(new RString("投票区名称")),
    /**
     * コンマ
     */
    コンマ(new RString(",")),
    /**
     * 斜線
     */
    斜線(new RString("\"")),
    /**
     * 死亡者
     */
    死亡者(new RString("4")),
    /**
     * 消除者
     */
    消除者(new RString("9")),
    /**
     * 登録者_2
     */
    登録者_2(new RString("登録者_2")),
    /**
     * 登録者_1
     */
    登録者_1(new RString("登録者_1")),
    /**
     * SPACE
     */
    SPACE(new RString("　")),
    /**
     * 抽出区分
     */
    抽出区分(new RString("1")),
    /**
     * 注意種類コード
     */
    注意種類コード(new RString("01")),
    /**
     * 有効期限
     */
    有効期限(new RString("0")),
    /**
     * 利用区分
     */
    利用区分(new RString("2")),
    /**
     * 改ページ
     */
    改ページ(new RString("改ページ")),
    /**
     * ソート順
     */
    ソート順(new RString("ソート順：投票区コード＞")),
    /**
     * 改頁
     */
    改頁(new RString("　　　改頁：なし"));

    private final RString value;

    private OutputKeys(RString value) {
        this.value = value;
    }

    /**
     * valueを取得 <BR>
     *
     * @return value RString
     */
    public RString getValue() {
        return value;
    }

}
