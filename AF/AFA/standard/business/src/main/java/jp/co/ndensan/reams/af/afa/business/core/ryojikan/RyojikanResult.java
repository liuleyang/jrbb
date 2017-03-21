/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.ryojikan;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領事官コードのBusiness
 *
 * @reamsid_L AF-0320-015 xul
 */
public class RyojikanResult {

    private final AfT510RyojikanEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT510RyojikanEntity}より{@link RyojikanResult}を生成します。
     *
     * @param entity DBより取得した{@link RyojikanResult}
     */
    public RyojikanResult(AfT510RyojikanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("領事官コード選択"));
    }

    /**
     * 領事官コードを返します。
     *
     * @return 領事官コード
     */
    public RString get領事官コード() {
        return this.entity.getRyojikanCode();
    }

    /**
     * 領事官名称を返します。
     *
     * @return 領事官名称
     */
    public RString get領事官名称() {
        return this.entity.getRyojikanName();
    }

    /**
     * カナ領事官名称を返します。
     *
     * @return カナ領事官名称
     */
    public RString getカナ領事官名称() {
        return this.entity.getKanaRyojikanName();
    }

    /**
     * 検索用カナ領事官名称を返します。
     *
     * @return 検索用カナ領事官名称
     */
    public RString get検索用カナ領事官名称() {
        return this.entity.getSearchKanaRyojikanName();
    }

    /**
     * 表示順を返します。
     *
     * @return 表示順
     */
    public int get表示順() {
        return this.entity.getHyojijun();
    }

}
