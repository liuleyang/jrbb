/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙資格
 *
 * @reamsid_L AF-0320-010 lis
 */
public class ZaigaiSenkyoShikakuResult implements Serializable {

    private AfT122ZaigaiSenkyoShikakuEntity entity;

    /**
     * コンストラクタです。
     */
    public ZaigaiSenkyoShikakuResult() {
        entity = new AfT122ZaigaiSenkyoShikakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT122ZaigaiSenkyoShikakuEntity
     */
    public ZaigaiSenkyoShikakuResult(AfT122ZaigaiSenkyoShikakuEntity entity) {
        this.entity = entity;
    }

    /**
     * AfT122ZaigaiSenkyoShikakuEntityを返します。
     *
     * @return AfT122ZaigaiSenkyoShikakuEntity
     */
    public AfT122ZaigaiSenkyoShikakuEntity getEntity() {
        return entity;
    }

    /**
     * AfT122ZaigaiSenkyoShikakuEntityを設定します。
     *
     * @param entity AfT122ZaigaiSenkyoShikakuEntity
     */
    public void setEntity(AfT122ZaigaiSenkyoShikakuEntity entity) {
        this.entity = entity;
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
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public int get申請番号() {
        return this.entity.getShinseiNo();
    }

    /**
     * 国民投票区分を返します。
     *
     * @return 国民投票区分
     */
    public Code get国民投票区分() {
        return this.entity.getKokuminTohyoKubun();
    }

    /**
     * 国民投票抄本番号を返します。
     *
     * @return 国民投票抄本番号
     */
    public ShohonNo get国民投票抄本番号() {
        return this.entity.getKokuminShohonNo();
    }

    /**
     * 本籍地登録区分を返します。
     *
     * @return 本籍地登録区分
     */
    public Code get本籍地登録区分() {
        return this.entity.getHonsekiTorokuKubun();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return this.entity.getKofuNo();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return this.entity.getKofuYMD();
    }

    /**
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return this.entity.getShikakuKubun();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.entity.getTohyokuCode();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return this.entity.getMeiboTorokuYMD();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public FlexibleDate get表示年月日() {
        return this.entity.getHyojiYMD();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード
     */
    public Code get表示事由コード() {
        return this.entity.getHyojiJiyuCode();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public FlexibleDate get抹消年月日() {
        return this.entity.getMasshoYMD();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード
     */
    public Code get抹消事由コード() {
        return this.entity.getMasshoJiyuCode();
    }

    /**
     * 修正区分を返します。
     *
     * @return 修正区分
     */
    public Code get修正区分() {
        return this.entity.getShuseiKubun();
    }

    /**
     * 修正年月日を返します。
     *
     * @return 修正年月日
     */
    public FlexibleDate get修正年月日() {
        return this.entity.getShuseiYMD();
    }

    /**
     * 再交付事由コードを返します。
     *
     * @return 再交付事由コード
     */
    public Code get再交付事由コード() {
        return this.entity.getSaiKofuJiyuCode();
    }

    /**
     * 記載事項変更事由コードを返します。
     *
     * @return 記載事項変更事由コード
     */
    public Code get記載事項変更事由コード() {
        return this.entity.getHenkoJiyuCode();
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
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void set識別コード(ShikibetsuCode shikibetsuCode) {
        this.entity.setShikibetsuCode(shikibetsuCode);
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
     * 国民投票区分を設定します。
     *
     * @param kokuminTohyoKubun 国民投票区分
     */
    public void set国民投票区分(Code kokuminTohyoKubun) {
        this.entity.setKokuminTohyoKubun(kokuminTohyoKubun);
    }

    /**
     * 国民投票抄本番号を設定します。
     *
     * @param kokuminShohonNo 国民投票抄本番号
     */
    public void set国民投票抄本番号(ShohonNo kokuminShohonNo) {
        this.entity.setKokuminShohonNo(kokuminShohonNo);
    }

    /**
     * 本籍地登録区分を設定します。
     *
     * @param honsekiTorokuKubun 本籍地登録区分
     */
    public void set本籍地登録区分(Code honsekiTorokuKubun) {
        this.entity.setHonsekiTorokuKubun(honsekiTorokuKubun);
    }

    /**
     * 交付番号を設定します。
     *
     * @param kofuNo 交付番号
     */
    public void set交付番号(RString kofuNo) {
        this.entity.setKofuNo(kofuNo);
    }

    /**
     * 交付年月日を設定します。
     *
     * @param kofuYMD 交付年月日
     */
    public void set交付年月日(FlexibleDate kofuYMD) {
        this.entity.setKofuYMD(kofuYMD);
    }

    /**
     * 選挙資格区分を設定します。
     *
     * @param shikakuKubun 選挙資格区分
     */
    public void set選挙資格区分(Code shikakuKubun) {
        this.entity.setShikakuKubun(shikakuKubun);
    }

    /**
     * 投票区コードを設定します。
     *
     * @param tohyokuCode 投票区コード
     */
    public void set投票区コード(RString tohyokuCode) {
        this.entity.setTohyokuCode(tohyokuCode);
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param meiboTorokuYMD 名簿登録年月日
     */
    public void set名簿登録年月日(FlexibleDate meiboTorokuYMD) {
        this.entity.setMeiboTorokuYMD(meiboTorokuYMD);
    }

    /**
     * 表示年月日を設定します。
     *
     * @param hyojiYMD 表示年月日
     */
    public void set表示年月日(FlexibleDate hyojiYMD) {
        this.entity.setHyojiYMD(hyojiYMD);
    }

    /**
     * 表示事由コードを設定します。
     *
     * @param hyojiJiyuCode 表示事由コード
     */
    public void set表示事由コード(Code hyojiJiyuCode) {
        this.entity.setHyojiJiyuCode(hyojiJiyuCode);
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param masshoYMD 抹消年月日
     */
    public void set抹消年月日(FlexibleDate masshoYMD) {
        this.entity.setMasshoYMD(masshoYMD);
    }

    /**
     * 抹消事由コードを設定します。
     *
     * @param masshoJiyuCode 抹消事由コード
     */
    public void set抹消事由コード(Code masshoJiyuCode) {
        this.entity.setMasshoJiyuCode(masshoJiyuCode);
    }

    /**
     * 修正区分を設定します。
     *
     * @param shuseiKubun 修正区分
     */
    public void set修正区分(Code shuseiKubun) {
        this.entity.setShuseiKubun(shuseiKubun);
    }

    /**
     * 修正年月日を設定します。
     *
     * @param shuseiYMD 修正年月日
     */
    public void set修正年月日(FlexibleDate shuseiYMD) {
        this.entity.setShuseiYMD(shuseiYMD);
    }

    /**
     * 再交付事由コードを設定します。
     *
     * @param saiKofuJiyuCode 再交付事由コード
     */
    public void set再交付事由コード(Code saiKofuJiyuCode) {
        this.entity.setSaiKofuJiyuCode(saiKofuJiyuCode);
    }

    /**
     * 記載事項変更事由コードを設定します。
     *
     * @param henkoJiyuCode 記載事項変更事由コード
     */
    public void set記載事項変更事由コード(Code henkoJiyuCode) {
        this.entity.setHenkoJiyuCode(henkoJiyuCode);
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

        private final AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity;
        private static final long serialVersionUID = 351900186803745749L;

        private _SerializationProxy(ZaigaiSenkyoShikakuResult result) {
            this.zaigaiSenkyoShikakuEntity = result.getEntity();
        }

        private Object readResolve() {
            return new ZaigaiSenkyoShikakuResult(zaigaiSenkyoShikakuEntity);
        }
    }
}
