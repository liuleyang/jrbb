/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.kaikufuzuijoho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区付随情報のパラーメタクラスです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public class KaikuParmeter {

    private ShohonNo shohonNo;
    private ShikibetsuCode shikibetsuCode;
    private RString shohonNoHidden;

    /**
     * shohonNoを取得します。
     *
     * @return ShohonNo
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * shikibetsuCodeを取得します。
     *
     * @return ShikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shohonNoHiddenを取得します。
     *
     * @return RString
     */
    public RString getShohonNoHidden() {
        return shohonNoHidden;
    }

    /**
     * shohonNoを設定します。
     *
     * @param shohonNo ShohonNo
     */
    public void setShohonNo(ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * shikibetsuCodeを設定します。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * shohonNoHiddenを設定します。
     *
     * @param shohonNoHidden RString
     */
    public void setShohonNoHidden(RString shohonNoHidden) {
        this.shohonNoHidden = shohonNoHidden;
    }

}
