package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール12面用param
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSealPartParam {

    private AtenaSeal12GamenJoho 画面情報;
    private SenkyoninTohyoJokyoEntity 投票資格情報;
    private AfT507ShisetsuEntity 施設情報;
    private RString 通し番号;
    private RString customBarCode;

    /**
     * 画面情報を返します。
     *
     * @return 画面情報 AtenaSeal12GamenJoho
     */
    public AtenaSeal12GamenJoho get画面情報() {
        return 画面情報;
    }

    /**
     * 投票資格情報を返します。
     *
     * @return 投票資格情報 SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity get投票資格情報() {
        return 投票資格情報;
    }

    /**
     * 施設情報を返します。
     *
     * @return 施設情報 AfT507ShisetsuEntity
     */
    public AfT507ShisetsuEntity get施設情報() {
        return 施設情報;
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号 RString
     */
    public RString get通し番号() {
        return 通し番号;
    }

    /**
     * 画面情報を設定します。
     *
     * @param 画面情報 AtenaSeal12GamenJoho
     */
    public void set画面情報(AtenaSeal12GamenJoho 画面情報) {
        this.画面情報 = 画面情報;
    }

    /**
     * 投票資格情報を設定します。
     *
     * @param 投票資格情報 SenkyoninTohyoJokyoEntity
     */
    public void set投票資格情報(SenkyoninTohyoJokyoEntity 投票資格情報) {
        this.投票資格情報 = 投票資格情報;
    }

    /**
     * 施設情報を設定します。
     *
     * @param 施設情報 AfT507ShisetsuEntity
     */
    public void set施設情報(AfT507ShisetsuEntity 施設情報) {
        this.施設情報 = 施設情報;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 RString
     */
    public void set通し番号(RString 通し番号) {
        this.通し番号 = 通し番号;
    }

    /**
     * customBarCodeを返します。
     *
     * @return customBarCode RString
     */
    public RString getCustomBarCode() {
        return customBarCode;
    }

    /**
     * customBarCodeを設定します。
     *
     * @param customBarCode RString
     */
    public void setCustomBarCode(RString customBarCode) {
        this.customBarCode = customBarCode;
    }

}
