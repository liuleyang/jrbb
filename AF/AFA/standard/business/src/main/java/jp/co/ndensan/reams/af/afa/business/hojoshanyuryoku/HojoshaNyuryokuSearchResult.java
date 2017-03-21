/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshanyuryoku.HojoshaNyuryokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者入力用ビジネスです。
 *
 * @reamsid_L AF-0080-030 qiuxy
 */
public class HojoshaNyuryokuSearchResult implements Serializable {

    private final HojoshaNyuryokuEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link HojoshaNyuryokuEntity}より{@link HojoshaNyuryoku}を生成します。
     *
     * @param entity DBより取得した{@link HojoshaNyuryokuEntity}
     */
    public HojoshaNyuryokuSearchResult(HojoshaNyuryokuEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 補助者識別コードを返します。
     *
     * @return 補助者識別コード ShikibetsuCode
     */
    public ShikibetsuCode get補助者識別コード() {
        ShikibetsuCode 補助者識別コード = entity.getShikibetsuCode();
        return 補助者識別コード == null ? ShikibetsuCode.EMPTY : 補助者識別コード;
    }

    /**
     * 宛名PSM名称を返します。
     *
     * @return 宛名PSM名称 RString
     */
    public RString get宛名PSM名称() {
        AtenaMeisho 名称 = entity.getMeisho();
        return 名称 == null ? RString.EMPTY : 名称.getColumnValue();
    }

    /**
     * 投票所名称を返します。
     *
     * @return 投票所名称
     */
    public RString get投票所名称() {
        RString 名称 = entity.getTohyojoName();
        return 名称 == null ? RString.EMPTY : 名称;
    }
}
