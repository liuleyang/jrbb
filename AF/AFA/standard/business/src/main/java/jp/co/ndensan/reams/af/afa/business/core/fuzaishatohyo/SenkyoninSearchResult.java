/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo.SenkyoninEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人の情報用ビジネスです。
 *
 * @reamsid_L AF-0080-010 lit
 */
public class SenkyoninSearchResult implements Serializable {

    private final SenkyoninEntity entity;
    private final UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link SenkyoninEntity}を生成します。
     *
     * @param entity DBより取得した{@link SenkyoninEntity}
     */
    public SenkyoninSearchResult(SenkyoninEntity entity) {
        this.entity = requireNonNull(entity);
        this.宛名情報Entity = this.entity.get宛名情報Entity();
    }

    /**
     * entityを返します。
     *
     * @return entity SenkyoninEntity
     */
    public SenkyoninEntity getEntity() {
        return this.entity;
    }

    /**
     * 実データフラグを返します。
     *
     * @return 実データフラグ
     */
    public boolean is実データフラグ() {
        return this.entity.is実データフラグ();
    }

    /**
     * 識別対象を返す。
     *
     * @return 識別対象 識別対象
     */
    public IShikibetsuTaisho get識別対象() {
        return ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報Entity);
    }

    /**
     * 氏名を返す。
     *
     * @return 氏名 氏名
     */
    public RString get氏名() {
        AtenaMeisho 氏名 = 宛名情報Entity.getKanjiShimei();
        return null != 氏名 ? 氏名.value() : RString.EMPTY;
    }

    /**
     * 生年月日を返す。
     *
     * @return 生年月日 生年月日
     */
    public FlexibleDate get生年月日() {
        return 宛名情報Entity.getSeinengappiYMD();
    }

    /**
     * 性別を返す。
     *
     * @return 性別 性別
     */
    public RString get性別() {
        RString 性別 = 宛名情報Entity.getSeibetsuCode();
        return Gender.toValue(性別).getCommonName();
    }

    /**
     * 識別コードを返す。
     *
     * @return 識別コード 識別コード
     */
    public RString get識別コード() {
        ShikibetsuCode 識別コード = 宛名情報Entity.getShikibetsuCode();
        return null != 識別コード ? 識別コード.value() : RString.EMPTY;
    }

    /**
     * 世帯コードを返す。
     *
     * @return 世帯コード 世帯コード
     */
    public RString get世帯コード() {
        SetaiCode 世帯コード = 宛名情報Entity.getSetaiCode();
        return null != 世帯コード ? 世帯コード.value() : RString.EMPTY;
    }

    /**
     * 住所を返す。
     *
     * @return 住所 住所
     */
    public RString get住所() {
        RString 住登内住所 = 宛名情報Entity.getJutonaiJusho();
        AtenaBanchi 住登内番地 = 宛名情報Entity.getJutonaiBanchi();
        Katagaki 住登内方書 = 宛名情報Entity.getJutonaiKatagaki();
        RString 住所 = null != 住登内住所 ? 住登内住所 : RString.EMPTY;
        if (null != 住登内番地) {
            住所 = 住所.concat(住登内番地.value());
        }
        if (null != 住登内方書) {
            住所 = 住所
                    .concat(RString.FULL_SPACE)
                    .concat(住登内方書.value());
        }
        return 住所;
    }
}
