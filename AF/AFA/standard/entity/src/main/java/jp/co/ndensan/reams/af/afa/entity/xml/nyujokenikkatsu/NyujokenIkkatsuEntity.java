/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;

/**
 *
 * 選挙人情報
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class NyujokenIkkatsuEntity {

    private AfT112SenkyoninMeiboEntity 選挙人名簿情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSM情報;
    private AfT502TohyojoEntity 投票所情報;
    private AfT501TohyokuEntity 投票区情報;
    private AfT113SenkyoShikakuEntity 選挙資格情報;
    private UrT0159TohyokuEntity ur投票区情報;

    /**
     * 選挙人名簿情報を返します。
     *
     * @return 選挙人名簿情報
     */
    public AfT112SenkyoninMeiboEntity get選挙人名簿情報() {
        return 選挙人名簿情報;
    }

    /**
     * 宛名PSM情報を返します。
     *
     * @return 宛名PSM情報
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM情報() {
        return 宛名PSM情報;
    }

    /**
     * 投票所情報を返します。
     *
     * @return 投票所情報
     */
    public AfT502TohyojoEntity get投票所情報() {
        return 投票所情報;
    }

    /**
     * 投票区情報を返します。
     *
     * @return 投票区情報
     */
    public AfT501TohyokuEntity get投票区情報() {
        return 投票区情報;
    }

    /**
     * ur投票区情報を返します。
     *
     * @return ur投票区情報
     */
    public UrT0159TohyokuEntity getUr投票区情報() {
        return ur投票区情報;
    }

    /**
     * 選挙資格情報を返します。
     *
     * @return 選挙資格情報
     */
    public AfT113SenkyoShikakuEntity get選挙資格情報() {
        return 選挙資格情報;
    }

    /**
     * 選挙人名簿情報を設定します。
     *
     * @param 選挙人名簿情報 AfT112SenkyoninMeiboEntity
     */
    public void set選挙人名簿情報(AfT112SenkyoninMeiboEntity 選挙人名簿情報) {
        this.選挙人名簿情報 = 選挙人名簿情報;
    }

    /**
     * 宛名PSM情報を設定します。
     *
     * @param 宛名PSM情報 UaFt200FindShikibetsuTaishoEntity
     */
    public void set宛名PSM情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM情報) {
        this.宛名PSM情報 = 宛名PSM情報;
    }

    /**
     * 投票所情報を設定します。
     *
     * @param 投票所情報 AfT502TohyojoEntity
     */
    public void set投票所情報(AfT502TohyojoEntity 投票所情報) {
        this.投票所情報 = 投票所情報;
    }

    /**
     * 投票区情報を設定します。
     *
     * @param 投票区情報 AfT501TohyokuEntity
     */
    public void set投票区情報(AfT501TohyokuEntity 投票区情報) {
        this.投票区情報 = 投票区情報;
    }

    /**
     * ur投票区情報を設定します。
     *
     * @param ur投票区情報 UrT0159TohyokuEntity
     */
    public void setUr投票区情報(UrT0159TohyokuEntity ur投票区情報) {
        this.ur投票区情報 = ur投票区情報;
    }

    /**
     * 選挙資格情報を設定します。
     *
     * @param 選挙資格情報 AfT113SenkyoShikakuEntity
     */
    public void set選挙資格情報(AfT113SenkyoShikakuEntity 選挙資格情報) {
        this.選挙資格情報 = 選挙資格情報;
    }

}
