/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人申請情報
 *
 * @reamsid_L AF-0320-010 lis
 */
public class ZaigaiSenkyoninShinseiResult {

    private AfT124ZaigaiSenkyoninShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public ZaigaiSenkyoninShinseiResult() {
        entity = new AfT124ZaigaiSenkyoninShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT124ZaigaiSenkyoninShinseiEntity
     */
    public ZaigaiSenkyoninShinseiResult(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * AfT124ZaigaiSenkyoninShinseiEntityを返します。
     *
     * @return AfT124ZaigaiSenkyoninShinseiEntity
     */
    public AfT124ZaigaiSenkyoninShinseiEntity getEntity() {
        return entity;
    }

    /**
     * AfT124ZaigaiSenkyoninShinseiEntityを設定します。
     *
     * @param entity AfT124ZaigaiSenkyoninShinseiEntity
     */
    public void setEntity(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public int get申請番号() {
        return this.entity.getShinseiNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * 住定年月日を返します。
     *
     * @return 住定年月日
     */
    public FlexibleDate get住定年月日() {
        return this.entity.getJuteiYMD();
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
     * 国籍コードを返します。
     *
     * @return 国籍コード
     */
    public RString get国籍コード() {
        return this.entity.getKokusekiCode();
    }

    /**
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public AtenaMeisho get申請者氏名() {
        return this.entity.getShinseishaShimei();
    }

    /**
     * 申請者カナ氏名を返します。
     *
     * @return 申請者カナ氏名
     */
    public AtenaKanaMeisho get申請者カナ氏名() {
        return this.entity.getShinseishaKanaShimei();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return this.entity.getSeinengappiYMD();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return this.entity.getSeibetsuCode();
    }

    /**
     * 申請区分を返します。
     *
     * @return 申請区分
     */
    public Code get申請区分() {
        return this.entity.getShinseiKubun();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return this.entity.getShinseiYMD();
    }

    /**
     * 申請内容変更年月日を返します。
     *
     * @return 申請内容変更年月日
     */
    public FlexibleDate get申請内容変更年月日() {
        return this.entity.getHenkoYMD();
    }

    /**
     * 申請内容変更事由コードを返します。
     *
     * @return 申請内容変更事由コード
     */
    public Code get申請内容変更事由コード() {
        return this.entity.getHenkoJiyuCode();
    }

    /**
     * 申請取下年月日を返します。
     *
     * @return 申請取下年月日
     */
    public FlexibleDate get申請取下年月日() {
        return this.entity.getTorisageYMD();
    }

    /**
     * 申請取下事由コードを返します。
     *
     * @return 申請取下事由コード
     */
    public Code get申請取下事由コード() {
        return this.entity.getTorisageJiyuCode();
    }

    /**
     * 却下年月日を返します。
     *
     * @return 却下年月日
     */
    public FlexibleDate get却下年月日() {
        return this.entity.getKyakkaYMD();
    }

    /**
     * 却下事由コードを返します。
     *
     * @return 却下事由コード
     */
    public Code get却下事由コード() {
        return this.entity.getKyakkaJiyuCode();
    }

    /**
     * 本籍地照会年月日を返します。
     *
     * @return 本籍地照会年月日
     */
    public FlexibleDate get本籍地照会年月日() {
        return this.entity.getHonsekiShokaiYMD();
    }

    /**
     * 本籍地回答年月日を返します。
     *
     * @return 本籍地回答年月日
     */
    public FlexibleDate get本籍地回答年月日() {
        return this.entity.getHonsekiKaitoYMD();
    }

    /**
     * 本籍地通知年月日を返します。
     *
     * @return 本籍地通知年月日
     */
    public FlexibleDate get本籍地通知年月日() {
        return this.entity.getHonsekiTsuchiYMD();
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return this.entity.getTokkiJiko();
    }

    /**
     * 申請番号を設定します。
     *
     * @param shinseiNo 申請番号
     */
    public void set申請番号(int shinseiNo) {
        this.entity.setShinseiNo(shinseiNo);
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void set識別コード(ShikibetsuCode shikibetsuCode) {
        this.entity.setShikibetsuCode(shikibetsuCode);
    }

    /**
     * 住定年月日を設定します。
     *
     * @param juteiYMD 住定年月日
     */
    public void set住定年月日(FlexibleDate juteiYMD) {
        this.entity.setJuteiYMD(juteiYMD);
    }

    /**
     * 領事官コードを設定します。
     *
     * @param ryojikanCode 領事官コード
     */
    public void set領事官コード(RString ryojikanCode) {
        this.entity.setRyojikanCode(ryojikanCode);
    }

    /**
     * 国籍コードを設定します。
     *
     * @param kokusekiCode 国籍コード
     */
    public void set国籍コード(RString kokusekiCode) {
        this.entity.setKokusekiCode(kokusekiCode);
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param shinseishaShimei 申請者氏名
     */
    public void set申請者氏名(AtenaMeisho shinseishaShimei) {
        this.entity.setShinseishaShimei(shinseishaShimei);
    }

    /**
     * 申請者カナ氏名を設定します。
     *
     * @param shinseishaKanaShimei 申請者カナ氏名
     */
    public void set申請者カナ氏名(AtenaKanaMeisho shinseishaKanaShimei) {
        this.entity.setShinseishaKanaShimei(shinseishaKanaShimei);
    }

    /**
     * 生年月日を設定します。
     *
     * @param seinengappiYMD 生年月日
     */
    public void set生年月日(FlexibleDate seinengappiYMD) {
        this.entity.setSeinengappiYMD(seinengappiYMD);
    }

    /**
     * 性別コードを設定します。
     *
     * @param seibetsuCode 性別コード
     */
    public void set性別コード(RString seibetsuCode) {
        this.entity.setSeibetsuCode(seibetsuCode);
    }

    /**
     * 申請区分を設定します。
     *
     * @param shinseiKubun 申請区分
     */
    public void set申請区分(Code shinseiKubun) {
        this.entity.setShinseiKubun(shinseiKubun);
    }

    /**
     * 申請年月日を設定します。
     *
     * @param shinseiYMD 申請年月日
     */
    public void set申請年月日(FlexibleDate shinseiYMD) {
        this.entity.setShinseiYMD(shinseiYMD);
    }

    /**
     * 申請内容変更年月日を設定します。
     *
     * @param henkoYMD 申請内容変更年月日
     */
    public void set申請内容変更年月日(FlexibleDate henkoYMD) {
        this.entity.setHenkoYMD(henkoYMD);
    }

    /**
     * 申請内容変更事由コードを設定します。
     *
     * @param henkoJiyuCode 申請内容変更事由コード
     */
    public void set申請内容変更事由コード(Code henkoJiyuCode) {
        this.entity.setHenkoJiyuCode(henkoJiyuCode);
    }

    /**
     * 申請取下年月日を設定します。
     *
     * @param torisageYMD 申請取下年月日
     */
    public void set申請取下年月日(FlexibleDate torisageYMD) {
        this.entity.setTorisageYMD(torisageYMD);
    }

    /**
     * 申請取下事由コードを設定します。
     *
     * @param torisageJiyuCode 申請取下事由コード
     */
    public void set申請取下事由コード(Code torisageJiyuCode) {
        this.entity.setTorisageJiyuCode(torisageJiyuCode);
    }

    /**
     * 却下年月日を設定します。
     *
     * @param kyakkaYMD 却下年月日
     */
    public void set却下年月日(FlexibleDate kyakkaYMD) {
        this.entity.setKyakkaYMD(kyakkaYMD);
    }

    /**
     * 却下事由コードを設定します。
     *
     * @param kyakkaJiyuCode 却下事由コード
     */
    public void set却下事由コード(Code kyakkaJiyuCode) {
        this.entity.setKyakkaJiyuCode(kyakkaJiyuCode);
    }

    /**
     * 本籍地照会年月日を設定します。
     *
     * @param honsekiShokaiYMD 本籍地照会年月日
     */
    public void set本籍地照会年月日(FlexibleDate honsekiShokaiYMD) {
        this.entity.setHonsekiShokaiYMD(honsekiShokaiYMD);
    }

    /**
     * 本籍地回答年月日を設定します。
     *
     * @param honsekiKaitoYMD 本籍地回答年月日
     */
    public void set本籍地回答年月日(FlexibleDate honsekiKaitoYMD) {
        this.entity.setHonsekiKaitoYMD(honsekiKaitoYMD);
    }

    /**
     * 本籍地通知年月日を設定します。
     *
     * @param honsekiTsuchiYMD 本籍地通知年月日
     */
    public void set本籍地通知年月日(FlexibleDate honsekiTsuchiYMD) {
        this.entity.setHonsekiTsuchiYMD(honsekiTsuchiYMD);
    }

    /**
     * 特記事項を設定します。
     *
     * @param tokkiJiko 特記事項
     */
    public void set特記事項(RString tokkiJiko) {
        this.entity.setTokkiJiko(tokkiJiko);
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity;
        private static final long serialVersionUID = 351900186803745749L;

        private _SerializationProxy(ZaigaiSenkyoninShinseiResult zaigaiSenkyoninShinseiResult) {
            this.zaigaiSenkyoninShinseiEntity = zaigaiSenkyoninShinseiResult.getEntity();
        }

        private Object readResolve() {
            return new ZaigaiSenkyoninShinseiResult(zaigaiSenkyoninShinseiEntity);
        }
    }

}
