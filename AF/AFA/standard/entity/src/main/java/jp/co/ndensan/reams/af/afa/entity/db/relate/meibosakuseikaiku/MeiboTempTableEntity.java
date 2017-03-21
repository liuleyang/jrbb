/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成
 *
 * @reamsid_L AF-0460-020 wanghj
 */
public class MeiboTempTableEntity {

    private ShikibetsuCode 識別コード;

    private RString 投票区コード;

    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private AtenaMeisho 氏名;
    private AtenaKanaMeisho カナ氏名;
    private FlexibleDate 生年月日;
    private RString 性別;

    private RString 漁業者番号;

    private RString 組合コード;

    private int 漁業日数漁業者;

    private int 漁業日数漁業従事者;

    private RString 漁業種類;

    private RString 使用漁船種別;

    private RString 船名;

    private RString 登録番号;

    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;

    private AfT113SenkyoShikakuEntity afT113Entity;

    private AfT111SenkyoEntity afT111SenkyoEntity;

    private AfT113SenkyoShikakuEntity subAfT113Entity;

    /**
     * 識別コードを返します。
     *
     * @return subAfT113Entity
     */
    public AfT113SenkyoShikakuEntity getSubAfT113Entity() {
        return subAfT113Entity;
    }

    /**
     * AfT111SenkyoEntityを設定します。
     *
     * @param subAfT113Entity AfT111SenkyoEntity
     */
    public void setSubAfT113Entity(AfT113SenkyoShikakuEntity subAfT113Entity) {
        this.subAfT113Entity = subAfT113Entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return 投票区コード;
    }

    /**
     * 漁業者番号を返します。
     *
     * @return 漁業者番号
     */
    public RString get漁業者番号() {
        return 漁業者番号;
    }

    /**
     * 組合コードを返します。
     *
     * @return 組合コード
     */
    public RString get組合コード() {
        return 組合コード;
    }

    /**
     * 漁業日数漁業者を返します。
     *
     * @return 漁業日数漁業者
     */
    public int get漁業日数漁業者() {
        return 漁業日数漁業者;
    }

    /**
     * 漁業日数漁業従事者を返します。
     *
     * @return 漁業日数漁業従事者
     */
    public int get漁業日数漁業従事者() {
        return 漁業日数漁業従事者;
    }

    /**
     * 漁業種類を返します。
     *
     * @return 漁業種類
     */
    public RString get漁業種類() {
        return 漁業種類;
    }

    /**
     * 使用漁船種別を返します。
     *
     * @return 使用漁船種別
     */
    public RString get使用漁船種別() {
        return 使用漁船種別;
    }

    /**
     * 船名を返します。
     *
     * @return 船名
     */
    public RString get船名() {
        return 船名;
    }

    /**
     * 登録番号を返します。
     *
     * @return 登録番号
     */
    public RString get登録番号() {
        return 登録番号;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return 郵便番号;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return 住所;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return 氏名;
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public AtenaKanaMeisho getカナ氏名() {
        return カナ氏名;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 生年月日;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return 性別;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 漁業者番号を設定します。
     *
     * @param 漁業者番号 RString
     */
    public void set漁業者番号(RString 漁業者番号) {
        this.漁業者番号 = 漁業者番号;
    }

    /**
     * 組合コードを設定します。
     *
     * @param 組合コード RString
     */
    public void set組合コード(RString 組合コード) {
        this.組合コード = 組合コード;
    }

    /**
     * 漁業日数漁業者を設定します。
     *
     * @param 漁業日数漁業者 RString
     */
    public void set漁業日数漁業者(int 漁業日数漁業者) {
        this.漁業日数漁業者 = 漁業日数漁業者;
    }

    /**
     * 漁業日数漁業従事者を設定します。
     *
     * @param 漁業日数漁業従事者 RString
     */
    public void set漁業日数漁業従事者(int 漁業日数漁業従事者) {
        this.漁業日数漁業従事者 = 漁業日数漁業従事者;
    }

    /**
     * 漁業種類を設定します。
     *
     * @param 漁業種類 RString
     */
    public void set漁業種類(RString 漁業種類) {
        this.漁業種類 = 漁業種類;
    }

    /**
     * 使用漁船種別を設定します。
     *
     * @param 使用漁船種別 RString
     */
    public void set使用漁船種別(RString 使用漁船種別) {
        this.使用漁船種別 = 使用漁船種別;
    }

    /**
     * 船名を設定します。
     *
     * @param 船名 RString
     */
    public void set船名(RString 船名) {
        this.船名 = 船名;
    }

    /**
     * 登録番号を設定します。
     *
     * @param 登録番号 RString
     */
    public void set登録番号(RString 登録番号) {
        this.登録番号 = 登録番号;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 YubinNo
     */
    public void set登録番号(YubinNo 郵便番号) {
        this.郵便番号 = 郵便番号;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 AtenaJusho
     */
    public void set住所(AtenaJusho 住所) {
        this.住所 = 住所;
    }

    /**
     * 氏名を設定します。
     *
     * @param 氏名 AtenaMeisho
     */
    public void set氏名(AtenaMeisho 氏名) {
        this.氏名 = 氏名;
    }

    /**
     * カナ氏名を設定します。
     *
     * @param カナ氏名 AtenaKanaMeisho
     */
    public void setカナ氏名(AtenaKanaMeisho カナ氏名) {
        this.カナ氏名 = カナ氏名;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 FlexibleDate
     */
    public void set生年月日(FlexibleDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 RString
     */
    public void set性別(RString 性別) {
        this.性別 = 性別;
    }

    /**
     * 宛名PSMを返します。
     *
     * @return uaFt200Entity
     */
    public UaFt200FindShikibetsuTaishoEntity getUaFt200Entity() {
        return uaFt200Entity;
    }

    /**
     * 宛名PSMを設定します。
     *
     * @param uaFt200Entity UaFt200FindShikibetsuTaishoEntity
     */
    public void setUaFt200Entity(UaFt200FindShikibetsuTaishoEntity uaFt200Entity) {
        this.uaFt200Entity = uaFt200Entity;
    }

    /**
     * 選挙資格を返します。
     *
     * @return afT113Entity
     */
    public AfT113SenkyoShikakuEntity getAfT113Entity() {
        return afT113Entity;
    }

    /**
     * 選挙資格を設定します。
     *
     * @param afT113Entity AfT113SenkyoShikakuEntity
     */
    public void setAfT113Entity(AfT113SenkyoShikakuEntity afT113Entity) {
        this.afT113Entity = afT113Entity;
    }

    /**
     * 選挙を返します。
     *
     * @return AfT111SenkyoEntity
     */
    public AfT111SenkyoEntity getAfT111SenkyoEntity() {
        return afT111SenkyoEntity;
    }

    /**
     * 選挙を設定します。
     *
     * @param afT111SenkyoEntity AfT111SenkyoEntity
     */
    public void setAfT111SenkyoEntity(AfT111SenkyoEntity afT111SenkyoEntity) {
        this.afT111SenkyoEntity = afT111SenkyoEntity;
    }

}
