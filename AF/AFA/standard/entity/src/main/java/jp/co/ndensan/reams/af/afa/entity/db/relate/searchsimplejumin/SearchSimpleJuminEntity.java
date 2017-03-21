/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.searchsimplejumin;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;

/**
 * 住民検索（簡易版）の選挙人情報取得RelateEntityクラスです。
 *
 * @reamsid_L AF-0170-020 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SearchSimpleJuminEntity {

    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikaku;
    private AfT114FuzaishaTohyoShikakuEntity afT114FuzaishaTohyoShikaku;

    /**
     * コンストラクタです。
     */
    public SearchSimpleJuminEntity() {
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param afT112SenkyoninMeibo AfT112SenkyoninMeiboEntity
     * @param afT113SenkyoShikaku AfT113SenkyoShikakuEntity
     * @param afT114FuzaishaTohyoShikaku AfT114FuzaishaTohyoShikakuEntity
     */
    public SearchSimpleJuminEntity(AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo,
            AfT113SenkyoShikakuEntity afT113SenkyoShikaku, AfT114FuzaishaTohyoShikakuEntity afT114FuzaishaTohyoShikaku) {
        this.afT112SenkyoninMeibo = afT112SenkyoninMeibo;
        this.afT113SenkyoShikaku = afT113SenkyoShikaku;
        this.afT114FuzaishaTohyoShikaku = afT114FuzaishaTohyoShikaku;
    }

    /**
     * AfT112SenkyoninMeiboEntityのgetメソッドです。
     *
     * @return AfT112SenkyoninMeiboEntity
     */
    public AfT112SenkyoninMeiboEntity getAfT112SenkyoninMeibo() {
        return afT112SenkyoninMeibo;
    }

    /**
     * AfT113SenkyoShikakuEntityのgetメソッドです。
     *
     * @return AfT113SenkyoShikakuEntity
     */
    public AfT113SenkyoShikakuEntity getAfT113SenkyoShikaku() {
        return afT113SenkyoShikaku;
    }

    /**
     * setAfT112SenkyoninMeiboのsetメソッドです。
     *
     * @param afT112SenkyoninMeibo AfT112SenkyoninMeiboEntity
     */
    public void setAfT112SenkyoninMeibo(AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo) {
        this.afT112SenkyoninMeibo = afT112SenkyoninMeibo;
    }

    /**
     * setAfT113SenkyoShikakuのsetメソッドです。
     *
     * @param afT113SenkyoShikaku AfT113SenkyoShikakuEntity
     */
    public void setAfT113SenkyoShikaku(AfT113SenkyoShikakuEntity afT113SenkyoShikaku) {
        this.afT113SenkyoShikaku = afT113SenkyoShikaku;
    }

    /**
     * AfT114FuzaishaTohyoShikakuEntityのgetメソッドです。
     *
     * @return AfT114FuzaishaTohyoShikakuEntity
     */
    public AfT114FuzaishaTohyoShikakuEntity getAfT114FuzaishaTohyoShikaku() {
        return afT114FuzaishaTohyoShikaku;
    }

    /**
     * setAfT114FuzaishaTohyoShikakuのsetメソッドです。
     *
     * @param afT114FuzaishaTohyoShikaku AfT114FuzaishaTohyoShikakuEntity
     */
    public void setAfT114FuzaishaTohyoShikaku(AfT114FuzaishaTohyoShikakuEntity afT114FuzaishaTohyoShikaku) {
        this.afT114FuzaishaTohyoShikaku = afT114FuzaishaTohyoShikaku;
    }

}
