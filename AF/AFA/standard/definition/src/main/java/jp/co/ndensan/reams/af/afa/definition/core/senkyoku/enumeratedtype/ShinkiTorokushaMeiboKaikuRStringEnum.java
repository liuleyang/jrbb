/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public enum ShinkiTorokushaMeiboKaikuRStringEnum {

    /**
     * 全角スペース。
     */
    全角スペース("　"),
    /**
     * 帳票タイトル新規。
     */
    帳票タイトル新規("新規登録者名簿"),
    /**
     * 帳票タイトル抹消。
     */
    帳票タイトル抹消("抹消者名簿"),
    /**
     * 帳票タイトル失権。
     */
    帳票タイトル失権("失権者名簿"),
    /**
     * 帳票タイトル表示。
     */
    帳票タイトル表示("表示者名簿"),
    /**
     * 死亡。
     */
    死亡("死亡"),
    /**
     * 国籍喪失。
     */
    国籍喪失("国籍喪失"),
    /**
     * 誤載。
     */
    誤載("誤載"),
    /**
     * 転出4カ月。
     */
    転出4カ月("転出4カ月"),
    /**
     * 職権消除。
     */
    職権消除("職権消除"),
    /**
     * 居住要件。
     */
    居住要件("居住要件"),
    /**
     * その他。
     */
    その他("その他"),
    /**
     * 経過4ヶ月。
     */
    経過4ヶ月("経過4ヶ月"),
    /**
     * 公民権停止。
     */
    公民権停止("公民権停止"),
    /**
     * 失権。
     */
    失権("失権"),
    /**
     * 再転入。
     */
    再転入("再転入"),
    /**
     * 転出者。
     */
    転出者("転出者"),
    /**
     * 公民権停止者。
     */
    公民権停止者("公民権停止者"),
    /**
     * 異動年月日。
     */
    異動年月日("異動年月日"),
    /**
     * 表示年月日。
     */
    表示年月日("表示年月日"),
    /**
     * 抹消年月日。
     */
    抹消年月日("抹消年月日"),
    /**
     * 転出年月日。
     */
    転出年月日("転出年月日"),
    /**
     * 転出先住所。
     */
    転出先住所("転出先住所"),
    /**
     * 転入年月日。
     */
    転入年月日("転入年月日"),
    /**
     * 登録年月日。
     */
    登録年月日("登録年月日"),
    /**
     * 転居届出日。
     */
    転居届出日("転居届出日"),
    /**
     * 転入届出日。
     */
    転入届出日("転入届出日"),
    /**
     * 訂正後日付が空。
     */
    訂正後日付が空("--------");

    private final RString key;

    private ShinkiTorokushaMeiboKaikuRStringEnum(String key) {
        this.key = new RString(key);
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getKey() {
        return this.key;
    }
}
