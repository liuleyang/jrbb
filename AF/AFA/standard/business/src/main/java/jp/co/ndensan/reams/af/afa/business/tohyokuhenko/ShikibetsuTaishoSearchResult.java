/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokuhenko;

import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民情報検索結果です。
 *
 * @reamsid_L AF-0050-010 qiuxy
 */
public class ShikibetsuTaishoSearchResult {

    private final IShikibetsuTaisho entity;

    /**
     * コンストラクタです。
     *
     * @param entity UaFt200FindShikibetsuTaishoEntity
     */
    public ShikibetsuTaishoSearchResult(IShikibetsuTaisho entity) {
        this.entity = entity;
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public UaFt200FindShikibetsuTaishoEntity getShikibetsuTaishoEntity() {
        return entity.toEntity();
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public TohyokuCode getTohyokuCode() {
        return entity.toEntity().getTohyokuCode();
    }

    /**
     * 投票区名のgetメソッドです。
     *
     * @return 投票区名
     */
    @CheckForNull
    public RString getTohyokuName() {
        return entity.toEntity().getTohyokuName();
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    @CheckForNull
    public RString getSeibetsuCode() {
        return entity.toEntity().getSeibetsuCode();
    }

}
