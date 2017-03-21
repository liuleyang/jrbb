/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;

/**
 *
 * 財産区議会議員選挙時登録
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuEntity {

    private AfT100ShohonEntity 抄本情報;
    private AfT111SenkyoEntity 選挙情報;
    private AfT112SenkyoninMeiboEntity 選挙人名簿情報;
    private AfT113SenkyoShikakuEntity 選挙資格情報;
    private AfT141ZaisankuJuminTohyoConditionEntity 住民投票選挙人抽出条件情報;
    private AfT142TohyokuConditionEntity 投票区抽出条件情報;
    private AfT144JushoConditionEntity 住所抽出条件情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSM情報;
    private UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity;

    /**
     * 抄本情報を返します。
     *
     * @return 抄本情報
     */
    public AfT100ShohonEntity get抄本情報() {
        return 抄本情報;
    }

    /**
     * 選挙情報を返します。
     *
     * @return 選挙情報
     */
    public AfT111SenkyoEntity get選挙情報() {
        return 選挙情報;
    }

    /**
     * 選挙人名簿情報を返します。
     *
     * @return 選挙人名簿情報
     */
    public AfT112SenkyoninMeiboEntity get選挙人名簿情報() {
        return 選挙人名簿情報;
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
     * 住民投票選挙人抽出条件情報を返します。
     *
     * @return 住民投票選挙人抽出条件情報
     */
    public AfT141ZaisankuJuminTohyoConditionEntity get住民投票選挙人抽出条件情報() {
        return 住民投票選挙人抽出条件情報;
    }

    /**
     * 投票区抽出条件情報を返します。
     *
     * @return 投票区抽出条件情報
     */
    public AfT142TohyokuConditionEntity get投票区抽出条件情報() {
        return 投票区抽出条件情報;
    }

    /**
     * 住所抽出条件情報を返します。
     *
     * @return 住所抽出条件情報
     */
    public AfT144JushoConditionEntity get住所抽出条件情報() {
        return 住所抽出条件情報;
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
     * 宛名PSM情報を設定します。
     *
     * @param 宛名PSM情報 UaFt200FindShikibetsuTaishoEntity
     */
    public void set宛名PSM情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM情報) {
        this.宛名PSM情報 = 宛名PSM情報;
    }

    /**
     * 抄本情報を設定します。
     *
     * @param 抄本情報 AfT100ShohonEntity
     */
    public void set抄本情報(AfT100ShohonEntity 抄本情報) {
        this.抄本情報 = 抄本情報;
    }

    /**
     * 選挙情報を設定します。
     *
     * @param 選挙情報 AfT111SenkyoEntity
     */
    public void set選挙情報(AfT111SenkyoEntity 選挙情報) {
        this.選挙情報 = 選挙情報;
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
     * 選挙資格情報を設定します。
     *
     * @param 選挙資格情報 AfT113SenkyoShikakuEntity
     */
    public void set選挙資格情報(AfT113SenkyoShikakuEntity 選挙資格情報) {
        this.選挙資格情報 = 選挙資格情報;
    }

    /**
     * 住民投票選挙人抽出条件情報を設定します。
     *
     * @param 住民投票選挙人抽出条件情報 AfT141ZaisankuJuminTohyoConditionEntity
     */
    public void set住民投票選挙人抽出条件情報(AfT141ZaisankuJuminTohyoConditionEntity 住民投票選挙人抽出条件情報) {
        this.住民投票選挙人抽出条件情報 = 住民投票選挙人抽出条件情報;
    }

    /**
     * 投票区抽出条件情報を設定します。
     *
     * @param 投票区抽出条件情報 AfT142TohyokuConditionEntity
     */
    public void set投票区抽出条件情報(AfT142TohyokuConditionEntity 投票区抽出条件情報) {
        this.投票区抽出条件情報 = 投票区抽出条件情報;
    }

    /**
     * 住所抽出条件情報を設定します。
     *
     * @param 住所抽出条件情報 AfT144JushoConditionEntity
     */
    public void set住所抽出条件情報(AfT144JushoConditionEntity 住所抽出条件情報) {
        this.住所抽出条件情報 = 住所抽出条件情報;
    }

    /**
     * findeCautionShaMapperEntityを返します。
     *
     * @return findeCautionShaMapperEntity
     */
    public UaFt400FindeCautionShaMapperEntity getFindeCautionShaMapperEntity() {
        return findeCautionShaMapperEntity;
    }

    /**
     * findeCautionShaMapperEntityを設定します。
     *
     * @param findeCautionShaMapperEntity UaFt400FindeCautionShaMapperEntity
     */
    public void setFindeCautionShaMapperEntity(UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity) {
        this.findeCautionShaMapperEntity = findeCautionShaMapperEntity;
    }

}
