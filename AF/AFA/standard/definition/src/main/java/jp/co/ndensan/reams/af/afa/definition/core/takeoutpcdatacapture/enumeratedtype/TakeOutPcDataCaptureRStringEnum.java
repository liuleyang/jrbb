/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGME8030　持出端末用データ作成 <br />
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public enum TakeOutPcDataCaptureRStringEnum {

    /**
     * カンマ
     */
    カンマ("、"),
    /**
     * KEY_0
     */
    KEY_0("0"),
    /**
     * 処理可能な
     */
    処理可能な("処理可能な"),
    /**
     * 横線
     */
    横線("-"),
    /**
     * 抄本ファイル名
     */
    抄本ファイル名("ANShohon"),
    /**
     * 投票状況ファイル名
     */
    投票状況ファイル名("ANTohyojokyo"),
    /**
     * 投票状況ファイル名
     */
    最新有権者情報ファイル("最新有権者情報ファイル"),
    /**
     * 横線。
     */
    HOSHI("*");
    private final RString key;

    private TakeOutPcDataCaptureRStringEnum(String key) {
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
