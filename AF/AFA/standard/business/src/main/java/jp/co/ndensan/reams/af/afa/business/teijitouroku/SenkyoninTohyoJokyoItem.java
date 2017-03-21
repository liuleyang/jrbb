/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.teijitouroku;

import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙人資格の情報
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SenkyoninTohyoJokyoItem {

    private SenkyoninTohyoJokyoEntity 選挙人資格の情報;
    private RString 出力区分;
    private RString 集計;
    private RString 事由コード;
    private RString 選挙名称;

    /**
     * コンストラクタです。
     *
     */
    public SenkyoninTohyoJokyoItem() {
    }

    /**
     * コンストラクタです。 選挙人資格の情報です。
     *
     * @param 選挙人資格の情報 SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoItem(SenkyoninTohyoJokyoEntity 選挙人資格の情報) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.出力区分 = new RString("データ");
    }

    /**
     * コンストラクタです。 選挙人資格の情報です。
     *
     * @param 選挙人資格の情報 SenkyoninTohyoJokyoEntity
     * @param 選挙名称 RString
     */
    public SenkyoninTohyoJokyoItem(SenkyoninTohyoJokyoEntity 選挙人資格の情報, RString 選挙名称) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.出力区分 = new RString("データ");
        this.選挙名称 = 選挙名称;
    }

    /**
     * コンストラクタです。 その他の情報です。
     *
     * @param 出力区分 RString
     */
    public SenkyoninTohyoJokyoItem(RString 出力区分) {
        this.出力区分 = 出力区分;
    }

    /**
     * コンストラクタです。 その他の情報です。
     *
     * @param 出力区分 RString
     * @param 選挙名称 RString
     */
    public SenkyoninTohyoJokyoItem(RString 出力区分, RString 選挙名称) {
        this.出力区分 = 出力区分;
        this.選挙名称 = 選挙名称;
    }

    /**
     * 宛名PSMを取得します。
     *
     * @return IShikibetsuTaisho 宛名PSM
     *
     */
    public IShikibetsuTaisho toShikibetsuTaisho() {
        return ShikibetsuTaishoFactory.createShikibetsuTaisho(this.get選挙人資格の情報().getAtenaPSMEntity());
    }
}
