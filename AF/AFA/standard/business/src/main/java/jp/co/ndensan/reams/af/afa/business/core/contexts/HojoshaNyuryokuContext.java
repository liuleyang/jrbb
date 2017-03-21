/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.contexts;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IContext;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者入力のコンテキストです。
 *
 * @author N1823 有澤 礼恵
 */
public class HojoshaNyuryokuContext implements IContext {

    private final Boolean dairiTohyoAri;
    private final RString hojosha1Name;
    private final RString hojosha2Name;
    private final ShikibetsuCode hojosha1ShikibetsuCode;
    private final ShikibetsuCode hojosha2ShikibetsuCode;

    /**
     * コンストラクタです。
     *
     * @param dairiTohyoAri 代理投票有無
     * @param hojosha1Name 補助者1氏名
     * @param hojosha2Name 補助者2氏名
     * @param hojosha1ShikibetsuCode 補助者1識別コード
     * @param hojosha2ShikibetsuCode 補助者2識別コード
     */
    public HojoshaNyuryokuContext(Boolean dairiTohyoAri, RString hojosha1Name, RString hojosha2Name,
            ShikibetsuCode hojosha1ShikibetsuCode, ShikibetsuCode hojosha2ShikibetsuCode) {
        this.dairiTohyoAri = dairiTohyoAri;
        this.hojosha1Name = hojosha1Name;
        this.hojosha2Name = hojosha2Name;
        this.hojosha1ShikibetsuCode = hojosha1ShikibetsuCode;
        this.hojosha2ShikibetsuCode = hojosha2ShikibetsuCode;
    }

    /**
     * 代理投票の有無を返します。
     *
     * @return Boolean 代理投票する場合true
     */
    public Boolean isDairiTohyoAri() {
        return dairiTohyoAri;
    }

    /**
     * 補助者1氏名を取得します。
     *
     * @return RString 補助者1氏名
     */
    public RString getHojosha1Name() {
        return hojosha1Name;
    }

    /**
     * 補助者2氏名を取得します。
     *
     * @return RString 補助者2氏名
     */
    public RString getHojosha2Name() {
        return hojosha2Name;
    }

    /**
     * 補助者1識別コードを取得します。
     *
     * @return ShikibetsuCode 補助者1の識別コード
     */
    public ShikibetsuCode getHojosha1ShikibetsuCode() {
        return hojosha1ShikibetsuCode;
    }

    /**
     * 補助者2識別コードを取得します。
     *
     * @return ShikibetsuCode 補助者2の識別コード
     */
    public ShikibetsuCode getHojosha2ShikibetsuCode() {
        return hojosha2ShikibetsuCode;
    }

}
