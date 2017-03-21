/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人名簿抄本のEntityクラスです。
 *
 * @reamsid_L AF-0010-041 xiaoj
 */
public class SenkyoMeiboShohonEntity {

    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity atenaPSMEntity;
    private AfT100ShohonEntity shohonEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT121ZaigaiSenkyoninMeiboEntity zaigaiSenkyoninMeiboEntity;
    private AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity;
    private AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity;
    private AfT123ZaigaiSenkyoninJushoEntity zaigaiSenkyoninJushoEntity;
    private UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity;
    private RString 投票区名;
    private RString 領事官名;
    private RString 在外選挙人国内住所;
    private RString 導入団体都道府県名;
    private RString 導入団体市区町村名;
    private RString 全国住所都道府県名;
    private RString 全国住所市区町村名;

    /**
     * 取扱い注意者Entityを返します。
     *
     * @return 取扱い注意者Entity
     */
    public UaFt400FindeCautionShaMapperEntity getFindeCautionShaMapperEntity() {
        return findeCautionShaMapperEntity;
    }

    /**
     * 取扱い注意者Entityを設定します。
     *
     * @param findeCautionShaMapperEntity 取扱い注意者Entity
     */
    public void setFindeCautionShaMapperEntity(UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity) {
        this.findeCautionShaMapperEntity = findeCautionShaMapperEntity;
    }

    /**
     * 抄本Entityを返します。
     *
     * @return 抄本Entity
     */
    public AfT100ShohonEntity getShohonEntity() {
        return shohonEntity;
    }

    /**
     * 抄本Entityを設定します。
     *
     * @param shohonEntity 抄本Entity
     */
    public void setShohonEntity(AfT100ShohonEntity shohonEntity) {
        this.shohonEntity = shohonEntity;
    }

    /**
     * 選挙Entityを返します。
     *
     * @return 選挙Entity
     */
    public AfT111SenkyoEntity getSenkyoEntity() {
        return senkyoEntity;
    }

    /**
     * 選挙Entityを設定します。
     *
     * @param senkyoEntity 選挙Entity
     */
    public void setSenkyoEntity(AfT111SenkyoEntity senkyoEntity) {
        this.senkyoEntity = senkyoEntity;
    }

    /**
     * 選挙人名簿Entityを返します。
     *
     * @return 選挙人名簿Entity
     */
    public AfT112SenkyoninMeiboEntity getSenkyoninMeiboEntity() {
        return senkyoninMeiboEntity;
    }

    /**
     * 選挙人名簿Entityを設定します。
     *
     * @param senkyoninMeiboEntity 選挙人名簿Entity
     */
    public void setSenkyoninMeiboEntity(AfT112SenkyoninMeiboEntity senkyoninMeiboEntity) {
        this.senkyoninMeiboEntity = senkyoninMeiboEntity;
    }

    /**
     * 選挙資格Entityを返します。
     *
     * @return 選挙資格Entity
     */
    public AfT113SenkyoShikakuEntity getSenkyoShikakuEntity() {
        return senkyoShikakuEntity;
    }

    /**
     * 選挙資格Entityを設定します。
     *
     * @param senkyoShikakuEntity 選挙資格Entity
     */
    public void setSenkyoShikakuEntity(AfT113SenkyoShikakuEntity senkyoShikakuEntity) {
        this.senkyoShikakuEntity = senkyoShikakuEntity;
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public UaFt200FindShikibetsuTaishoEntity getAtenaPSMEntity() {
        return atenaPSMEntity;
    }

    /**
     * 宛名PSMを設定します。
     *
     * @param atenaPSMEntity 宛名PSM
     */
    public void setAtenaPSMEntity(UaFt200FindShikibetsuTaishoEntity atenaPSMEntity) {
        this.atenaPSMEntity = atenaPSMEntity;
    }

    /**
     * 在外選挙人名簿Entityを返します。
     *
     * @return 在外選挙人名簿Entity
     */
    public AfT121ZaigaiSenkyoninMeiboEntity getZaigaiSenkyoninMeiboEntity() {
        return zaigaiSenkyoninMeiboEntity;
    }

    /**
     * 在外選挙人名簿Entityを設定します。
     *
     * @param zaigaiSenkyoninMeiboEntity 在外選挙人名簿Entity
     */
    public void setZaigaiSenkyoninMeiboEntity(AfT121ZaigaiSenkyoninMeiboEntity zaigaiSenkyoninMeiboEntity) {
        this.zaigaiSenkyoninMeiboEntity = zaigaiSenkyoninMeiboEntity;
    }

    /**
     * 在外選挙資格Entityを返します。
     *
     * @return 在外選挙資格Entity
     */
    public AfT122ZaigaiSenkyoShikakuEntity getZaigaiSenkyoShikakuEntity() {
        return zaigaiSenkyoShikakuEntity;
    }

    /**
     * 在外選挙資格Entityを設定します。
     *
     * @param zaigaiSenkyoShikakuEntity 在外選挙資格Entity
     */
    public void setZaigaiSenkyoShikakuEntity(AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity) {
        this.zaigaiSenkyoShikakuEntity = zaigaiSenkyoShikakuEntity;
    }

    /**
     * 在外選挙人申請Entityを返します。
     *
     * @return 在外選挙人申請Entity
     */
    public AfT124ZaigaiSenkyoninShinseiEntity getZaigaiSenkyoninShinseiEntity() {
        return zaigaiSenkyoninShinseiEntity;
    }

    /**
     * 在外選挙人申請Entityを設定します。
     *
     * @param zaigaiSenkyoninShinseiEntity 在外選挙人申請Entity
     */
    public void setZaigaiSenkyoninShinseiEntity(AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity) {
        this.zaigaiSenkyoninShinseiEntity = zaigaiSenkyoninShinseiEntity;
    }

    /**
     * 在外選挙人住所Entityを返します。
     *
     * @return 在外選挙人住所Entity
     */
    public AfT123ZaigaiSenkyoninJushoEntity getZaigaiSenkyoninJushoEntity() {
        return zaigaiSenkyoninJushoEntity;
    }

    /**
     * 在外選挙人住所Entityを設定します。
     *
     * @param zaigaiSenkyoninJushoEntity 在外選挙人住所Entity
     */
    public void setZaigaiSenkyoninJushoEntity(AfT123ZaigaiSenkyoninJushoEntity zaigaiSenkyoninJushoEntity) {
        this.zaigaiSenkyoninJushoEntity = zaigaiSenkyoninJushoEntity;
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return 投票区名;
    }

    /**
     * 投票区名を設定します。
     *
     * @param 投票区名 投票区名
     */
    public void set投票区名(RString 投票区名) {
        this.投票区名 = 投票区名;
    }

    /**
     * 領事官名を返します。
     *
     * @return 領事官名
     */
    public RString get領事官名() {
        return 領事官名;
    }

    /**
     * 領事官名を設定します。
     *
     * @param 領事官名 領事官名
     */
    public void set領事官名(RString 領事官名) {
        this.領事官名 = 領事官名;
    }

    /**
     * 在外選挙人国内住所を返します。
     *
     * @return 在外選挙人国内住所
     */
    public RString get在外選挙人国内住所() {
        return 在外選挙人国内住所;
    }

    /**
     * 在外選挙人国内住所を設定します。
     *
     * @param 在外選挙人国内住所 在外選挙人国内住所
     */
    public void set在外選挙人国内住所(RString 在外選挙人国内住所) {
        this.在外選挙人国内住所 = 在外選挙人国内住所;
    }

    /**
     * 導入団体都道府県名を返します。
     *
     * @return 導入団体都道府県名
     */
    public RString get導入団体都道府県名() {
        return 導入団体都道府県名;
    }

    /**
     * 導入団体都道府県名を設定します。
     *
     * @param 導入団体都道府県名 導入団体都道府県名
     */
    public void set導入団体都道府県名(RString 導入団体都道府県名) {
        this.導入団体都道府県名 = 導入団体都道府県名;
    }

    /**
     * 導入団体市区町村名を返します。
     *
     * @return 導入団体市区町村名
     */
    public RString get導入団体市区町村名() {
        return 導入団体市区町村名;
    }

    /**
     * 導入団体市区町村名を設定します。
     *
     * @param 導入団体市区町村名 導入団体市区町村名
     */
    public void set導入団体市区町村名(RString 導入団体市区町村名) {
        this.導入団体市区町村名 = 導入団体市区町村名;
    }

    /**
     * 全国住所都道府県名を返します。
     *
     * @return 全国住所都道府県名
     */
    public RString get全国住所都道府県名() {
        return 全国住所都道府県名;
    }

    /**
     * 全国住所都道府県名を設定します。
     *
     * @param 全国住所都道府県名 全国住所都道府県名
     */
    public void set全国住所都道府県名(RString 全国住所都道府県名) {
        this.全国住所都道府県名 = 全国住所都道府県名;
    }

    /**
     * 全国住所市区町村名を返します。
     *
     * @return 全国住所市区町村名
     */
    public RString get全国住所市区町村名() {
        return 全国住所市区町村名;
    }

    /**
     * 全国住所市区町村名を設定します。
     *
     * @param 全国住所市区町村名 全国住所市区町村名
     */
    public void set全国住所市区町村名(RString 全国住所市区町村名) {
        this.全国住所市区町村名 = 全国住所市区町村名;
    }
}
