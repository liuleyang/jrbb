/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohonselect;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本選択共有子divクラスです。
 *
 * @reamsid_L AF-0160-011 guyq
 */
public class SenkyoResult implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private AfT111SenkyoEntity entity;

    /**
     * AfT111SenkyoEntityを返します。
     *
     * @return AfT111SenkyoEntity
     */
    public AfT111SenkyoEntity getEntity() {
        return entity;
    }

    /**
     * AfT111SenkyoEntityのsetメソッドです。
     *
     * @param entity AfT111SenkyoEntity
     */
    public void setEntity(AfT111SenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT111SenkyoEntity
     */
    public SenkyoResult(AfT111SenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     */
    public SenkyoResult() {
        entity = new AfT111SenkyoEntity();
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public SenkyoNo get選挙番号() {
        return entity.getSenkyoNo();
    }

    /**
     * 選挙レベルを返します。
     *
     * @return 選挙レベル
     */
    public Code get選挙レベル() {
        return entity.getSenkyoLevel();
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称
     */
    public RString get選挙名称() {
        return entity.getSenkyoName();
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称
     */
    public RString get選挙略称() {
        return entity.getSenkyoRyakusho();
    }

    /**
     * 選挙マークを返します。
     *
     * @return 選挙マーク
     */
    public RString get選挙マーク() {
        return entity.getSenkyoMark();
    }

    /**
     * 名簿基準年月日を返します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 告示（公示）年月日を返します。
     *
     * @return 告示（公示）年月日
     */
    public FlexibleDate get告示公示年月日() {
        return entity.getKokujiYMD();
    }

    /**
     * 転出期限年月日を返します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return entity.getTenshutsuKigenYMD();
    }

    /**
     * 転入期限年月日を返します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return entity.getTennyuKigenYMD();
    }

    /**
     * 投票受付開始年月日を返します。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return entity.getTohyoUketsukeYMD();
    }

    /**
     * 無投票選挙フラグを返します。
     *
     * @return 無投票選挙フラグ
     */
    public boolean is無投票選挙フラグ() {
        return entity.getMutohyoSenkyoFlag();
    }

    /**
     * 抄本番号を設定します。
     *
     * @param shohonNo 抄本番号
     */
    public void set抄本番号(ShohonNo shohonNo) {
        this.entity.setShohonNo(shohonNo);
    }

    /**
     * 選挙番号を設定します。
     *
     * @param senkyoNo 選挙番号
     */
    public void set選挙番号(SenkyoNo senkyoNo) {
        this.entity.setSenkyoNo(senkyoNo);
    }

    /**
     * 選挙レベルを設定します。
     *
     * @param senkyoLevel 選挙レベル
     */
    public void set選挙レベル(Code senkyoLevel) {
        this.entity.setSenkyoLevel(senkyoLevel);
    }

    /**
     * 選挙名称を設定します。
     *
     * @param senkyoName 選挙名称
     */
    public void set選挙名称(RString senkyoName) {
        this.entity.setSenkyoName(senkyoName);
    }

    /**
     * 選挙略称を設定します。
     *
     * @param senkyoRyakusho 選挙略称
     */
    public void set選挙略称(RString senkyoRyakusho) {
        this.entity.setSenkyoRyakusho(senkyoRyakusho);
    }

    /**
     * 選挙マークを設定します。
     *
     * @param senkyoMark 選挙マーク
     */
    public void set選挙マーク(RString senkyoMark) {
        this.entity.setSenkyoMark(senkyoMark);
    }

    /**
     * 名簿基準年月日を設定します。
     *
     * @param kijunYMD 名簿基準年月日
     */
    public void set名簿基準年月日(FlexibleDate kijunYMD) {
        this.entity.setKijunYMD(kijunYMD);
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
     * 告示公示年月日を設定します。
     *
     * @param kokujiYMD 告示公示年月日
     */
    public void set告示公示年月日(FlexibleDate kokujiYMD) {
        this.entity.setKokujiYMD(kokujiYMD);
    }

    /**
     * 転出期限年月日を設定します。
     *
     * @param tenshutsuKigenYMD 転出期限年月日
     */
    public void set転出期限年月日(FlexibleDate tenshutsuKigenYMD) {
        this.entity.setTenshutsuKigenYMD(tenshutsuKigenYMD);
    }

    /**
     * 転入期限年月日を設定します。
     *
     * @param tennyuKigenYMD 転入期限年月日
     */
    public void set転入期限年月日(FlexibleDate tennyuKigenYMD) {
        this.entity.setTennyuKigenYMD(tennyuKigenYMD);
    }

    /**
     * 投票受付開始年月日を設定します。
     *
     * @param tohyoUketsukeYMD 投票受付開始年月日
     */
    public void set投票受付開始年月日(FlexibleDate tohyoUketsukeYMD) {
        this.entity.setTohyoUketsukeYMD(tohyoUketsukeYMD);
    }

    /**
     * 無投票選挙フラグを設定します。
     *
     * @param mutohyoSenkyoFlag 無投票選挙フラグ
     */
    public void set無投票選挙フラグ(boolean mutohyoSenkyoFlag) {
        this.entity.setMutohyoSenkyoFlag(mutohyoSenkyoFlag);
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new SenkyoResult._SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final AfT111SenkyoEntity afT111Senkyo;
        private static final long serialVersionUID = 351900186803745749L;

        private _SerializationProxy(SenkyoResult result) {
            this.afT111Senkyo = result.getEntity();
        }

        private Object readResolve() {
            return new SenkyoResult(afT111Senkyo);
        }
    }
}
