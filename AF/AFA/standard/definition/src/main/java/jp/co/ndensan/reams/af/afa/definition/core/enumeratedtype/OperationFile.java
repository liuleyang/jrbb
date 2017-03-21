/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 操作ファイル一覧を表す列挙型です。
 */
public enum OperationFile {

    /**
     * 選挙人名簿抄本
     */
    選挙人名簿抄本("AFAPRA100_MeiboShohon.csv"),
    /**
     * 選挙人名簿抄本_縦覧用
     */
    選挙人名簿抄本_縦覧用("AFAPRA100_MeiboShohonJuran.csv"),
    /**
     * 永久選挙人名簿
     */
    永久選挙人名簿("AFAPRA101_EikyuMeibo.csv"),
    /**
     * 選挙人名簿索引簿_50音順
     */
    選挙人名簿索引簿_50音順("AFAPRA102_Sakuinbo.csv"),
    /**
     * 選挙人名簿索引簿_投票区別50音順
     */
    選挙人名簿索引簿_投票区別50音順("AFAPRA102_SakuinboTohyoku.csv"),
    /**
     * 登録者数リスト
     */
    登録者数リスト("AFAPRA103_TorokushaSuList.csv"),
    /**
     * 登録者数リスト_不在者投票資格者分
     */
    登録者数リスト_不在者投票資格者分("AFAPRA103_TorokushasuListFuzaiShikaku.csv"),
    /**
     * 不在資格対象者名簿
     */
    不在資格対象者名簿("AFAPRC204_FuzaiShikakushaMeibo.csv"),
    /**
     * 有権者数調べ
     */
    有権者数調べ("AFAPRA104_YukenshasuShirabe.csv"),
    /**
     * 二重登録通知
     */
    二重登録通知("AFAPRA111_NijuTorokuTsuchisho.csv"),
    /**
     * 二重登録通知一覧表
     */
    二重登録通知一覧表("AFAPRA112_NijuTorokuTsuchishoList.csv"),
    /**
     * 送付先宛名シール_二重登録通知
     */
    送付先宛名シール_二重登録通知("AFAPRE213_SofusakiAtenaSeal.csv"),
    /**
     * 新規登録者名簿
     */
    新規登録者名簿("AFAPRA105_ShinkiTorokushaMeibo.csv"),
    /**
     * 新規登録者名簿_縦覧用
     */
    新規登録者名簿_縦覧用("AFAPRA106_ShinkiTorokushaMeiboJuran.csv"),
    /**
     * 新規登録者宛名シール
     */
    新規登録者宛名シール("AFAPRE213_ShinkiTorokushaAtenaSeal.csv"),
    /**
     * 帰化対象者名簿
     */
    帰化対象者名簿("AFAPRA107_KikaTaishoshaList.csv"),
    /**
     * 抹消者名簿
     */
    抹消者名簿("AFAPRA105_MashoshaMeibo.csv"),
    /**
     * 抹消者名簿_縦覧用
     */
    抹消者名簿_縦覧用("AFAPRA106_MasshoshaMeiboJuran.csv"),
    /**
     * 居住要件抹消者名簿
     */
    居住要件抹消者名簿("AFAPRA105_KyojuMasshoshaMeibo.csv"),
    /**
     * 表示者名簿
     */
    表示者名簿("AFAPRA105_HyojishaMeibo.csv"),
    /**
     * 表示消除者名簿
     */
    表示消除者名簿("AFAPRA105_HyojiShojoshaMeibo.csv"),
    /**
     * 規定年齢前名簿
     */
    規定年齢前名簿("AFAPRA105_KiteiNenreiMaeMeibo.csv"),
    /**
     * 規定年齢前宛名シール
     */
    規定年齢前宛名シール("AFAPRE213_KiteiNenreiMaeAtenaSeal.csv"),
    /**
     * 規定年齢未到達者名簿
     */
    規定年齢未到達者名簿("AFAPRA105_MitotatsushaMeibo.csv"),
    /**
     * 再転入者名簿
     */
    再転入者名簿("AFAPRA105_SaiTennyushaMeibo.csv"),
    /**
     * 訂正者名簿
     */
    訂正者名簿("AFAPRA108_TeiseishaMeibo.csv"),
    /**
     * 転出者名簿
     */
    転出者名簿("AFAPRA105_TenshutsushaMeibo.csv"),
    /**
     * 登録停止者名簿
     */
    登録停止者名簿("AFAPRA109_TorokuTeishishaMeibo.csv"),
    /**
     * 在外選挙人名簿抄本
     */
    在外選挙人名簿抄本("AFAPRB300_MeiboShohonZaigai.csv"),
    /**
     * 在外投票資格者名簿
     */
    在外投票資格者名簿("AFAPRB309_ZaigaiShikakushaMeibo.csv");

    private final RString csvName;

    private OperationFile(String csvName) {
        this.csvName = new RString(csvName);
    }

    /**
     * csvNameを取得します。
     *
     * @return csvName
     */
    public RString value() {
        return this.csvName;
    }
}
