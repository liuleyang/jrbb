/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.teijitouroku;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * アクセスログ出力クラス
 */
public class TeijitourokuCommonEditor {

    /**
     * コンストラクタです。
     *
     */
    public TeijitourokuCommonEditor() {
    }

    /**
     * 宛名PSMを取得します。
     *
     * @param atenaPSMEntity 宛名
     * @return IShikibetsuTaisho 宛名PSM
     *
     */
    public IShikibetsuTaisho toShikibetsuTaisho(UaFt200FindShikibetsuTaishoEntity atenaPSMEntity) {
        return ShikibetsuTaishoFactory.createShikibetsuTaisho(atenaPSMEntity);
    }
}
