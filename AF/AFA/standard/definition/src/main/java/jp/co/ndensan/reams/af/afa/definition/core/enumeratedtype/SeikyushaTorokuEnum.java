/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求代表者登録用ENUM
 *
 * @reamsid_L AF-0140-010 wangh
 */
public enum SeikyushaTorokuEnum {

    /**
     * 新規ボタン
     */
    追加(new RString("追加")),
    /**
     * 修正ボタン
     */
    修正(new RString("修正")),
    /**
     * 削除ボタン
     */
    削除(new RString("削除")),
    /**
     * 新規ボタンで画面制御
     */
    新規制御(new RString("0")),
    /**
     * 修正ボタンで画面制御
     */
    修正制御(new RString("1")),
    /**
     * 削除ボタンで画面制御
     */
    削除制御(new RString("2")),
    /**
     * 署名簿作成
     */
    署名簿作成(new RString("作成済")),
    /**
     * 地方公共団体
     */
    地方公共団体(new RString("2820")),
    /**
     * 汎用キー
     */
    汎用キー(new RString("直接請求番号")),
    /**
     * 追加_YES
     */
    追加_YES(new RString("直接請求を登録する")),
    /**
     * 追加_NO
     */
    追加_NO(new RString("直接請求の登録をやめる")),
    /**
     * 修正_YES
     */
    修正_YES(new RString("直接請求を保存する")),
    /**
     * 修正_NO
     */
    修正_NO(new RString("直接請求の修正をやめる")),
    /**
     * 削除_YES
     */
    削除_YES(new RString("直接請求を削除する")),
    /**
     * 削除_NO
     */
    削除_NO(new RString("直接請求の削除をやめる")),
    /**
     * 1
     */
    ONE(new RString("1")),
    /**
     * 業務種類
     */
    業務種類(new RString("AF")),
    /**
     * 住登内優先
     */
    住登内優先(new RString("1")),
    /**
     * 前日
     */
    前日(new RString("1")),
    /**
     * 表示しない
     */
    表示しない(new RString("0")),
    /**
     * 基本エリアに表示する
     */
    基本エリアに表示する(new RString("直接請求を削除する")),
    /**
     * 個人のみ
     */
    個人のみ(new RString("個人のみ")),
    /**
     * 住民
     */
    住民(new RString("1")),
    /**
     * 含む
     */
    含む(new RString("含む")),
    /**
     * 個人のみ
     */
    含まない(new RString("含まない")),
    /**
     * 再処理可能な
     */
    再処理可能な(new RString("再処理可能な")),
    /**
     * 当初登録の
     */
    当初登録の(new RString("当初登録の")),
    /**
     * 証明書発行有無_請求代表者
     */
    証明書発行有無_請求代表者(new RString("1")),
    /**
     * 新規データ用抄本番号
     */
    INSERT用抄本番号(new RString("0"));

    private final RString value;

    SeikyushaTorokuEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された請求代表者登録用ENUMを返します。
     *
     * @return 請求代表者登録用ENUM
     */
    public RString getValue() {
        return this.value;
    }
}
