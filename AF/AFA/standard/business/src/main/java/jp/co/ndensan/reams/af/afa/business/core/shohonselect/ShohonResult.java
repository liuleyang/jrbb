/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohonselect;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ShohonResult の操作を担当するクラスです。。
 *
 * @reamsid_L AF-0160-011 guyq
 */
public class ShohonResult {

    private AfT100ShohonEntity entity;

    /**
     * AfT111SenkyoEntityを返します。
     *
     * @return AfT111SenkyoEntity
     */
    public AfT100ShohonEntity getEntity() {
        return entity;
    }

    /**
     * AfT111SenkyoEntityのsetメソッドです。
     *
     * @param entity AfT111SenkyoEntity
     */
    public void setEntity(AfT100ShohonEntity entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT111SenkyoEntity
     */
    public ShohonResult(AfT100ShohonEntity entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     */
    public ShohonResult() {
        entity = new AfT100ShohonEntity();
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
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getSenkyoShurui();
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名
     */
    public RString get抄本名() {
        return entity.getShohonName();
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return entity.getTohyoYMD();
    }

    /**
     * 規定年齢到達年月日を返します。
     *
     * @return 規定年齢到達年月日
     */
    public FlexibleDate get規定年齢到達年月日() {
        return entity.getKiteiNenreiTotatsuYMD();
    }

    /**
     * 処理年月日を返します。
     *
     * @return 処理年月日
     */
    public FlexibleDate get処理年月日() {
        return entity.getShoriYMD();
    }

    /**
     * 入場券発行固有連番を返します。
     *
     * @return 入場券発行固有連番
     */
    public Decimal get入場券発行固有連番() {
        return entity.getNyujokenReportIndex();
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
     * 選挙種類を設定します。
     *
     * @param senkyoShurui 選挙種類
     */
    public void set選挙種類(Code senkyoShurui) {
        this.entity.setSenkyoShurui(senkyoShurui);
    }

    /**
     * 抄本名を設定します。
     *
     * @param shohonName 抄本名
     */
    public void set抄本名(RString shohonName) {
        this.entity.setShohonName(shohonName);
    }

    /**
     * 投票年月日を設定します。
     *
     * @param tohyoYMD 投票年月日
     */
    public void set投票年月日(FlexibleDate tohyoYMD) {
        this.entity.setTohyoYMD(tohyoYMD);
    }

    /**
     * 規定年齢到達年月日を設定します。
     *
     * @param kiteiNenreiTotatsuYMD 規定年齢到達年月日
     */
    public void set規定年齢到達年月日(FlexibleDate kiteiNenreiTotatsuYMD) {
        this.entity.setKiteiNenreiTotatsuYMD(kiteiNenreiTotatsuYMD);
    }

    /**
     * 処理年月日を設定します。
     *
     * @param shoriYMD 処理年月日
     */
    public void set処理年月日(FlexibleDate shoriYMD) {
        this.entity.setShoriYMD(shoriYMD);
    }

    /**
     * 入場券発行固有連番を設定します。
     *
     * @param nyujokenReportIndex 入場券発行固有連番
     */
    public void set入場券発行固有連番(Decimal nyujokenReportIndex) {
        this.entity.setNyujokenReportIndex(nyujokenReportIndex);
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new ShohonResult._SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final AfT100ShohonEntity afT100Shohon;
        private static final long serialVersionUID = 351900186803745749L;

        private _SerializationProxy(ShohonResult result) {
            this.afT100Shohon = result.getEntity();
        }

        private Object readResolve() {
            return new ShohonResult(afT100Shohon);
        }
    }

}
