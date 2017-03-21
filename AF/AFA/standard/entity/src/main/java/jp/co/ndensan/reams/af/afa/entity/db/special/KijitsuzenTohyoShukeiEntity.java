/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.special;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 【期日前投票】投票状況の集計結果を格納するエンティティクラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class KijitsuzenTohyoShukeiEntity extends DbTableEntityBase<KijitsuzenTohyoShukeiEntity> implements IDbAccessable {

    /**
     * テーブル名"KijitsuzenTohyoShukei"を表します。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("KijitsuzenTohyoShukeiEntity");
    }

    @PrimaryKey
    private ShohonNo shohonNo;
    @PrimaryKey
    private SenkyoNo senkyoNo;
    @PrimaryKey
    private RString shisetsuCode;
    private RString shisetsuName;
    private int tohyoToday_Man;
    private int tohyoToday_Woman;
    private int tohyoToday_Kei;
    private int tohyo_Man;
    private int tohyo_Woman;
    private int tohyo_Kei;

    /**
     * shohonNoを取得します。
     *
     * @return shohonNo
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * senkyoNoを取得します。
     *
     * @return senkyoNo
     */
    public SenkyoNo getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * shisetsuCodeを取得します。
     *
     * @return shisetsuCode
     */
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    /**
     * shisetsuNameを取得します。
     *
     * @return shisetsuName
     */
    public RString getShisetsuName() {
        return shisetsuName;
    }

    /**
     * tohyoToday_Manを取得します。
     *
     * @return tohyoToday_Man
     */
    public int getTohyoToday_Man() {
        return tohyoToday_Man;
    }

    /**
     * tohyoToday_Womanを取得します。
     *
     * @return tohyoToday_Woman
     */
    public int getTohyoToday_Woman() {
        return tohyoToday_Woman;
    }

    /**
     * tohyoToday_Keiを取得します。
     *
     * @return tohyoToday_Kei
     */
    public int getTohyoToday_Kei() {
        return tohyoToday_Kei;
    }

    /**
     * tohyo_Manを取得します。
     *
     * @return tohyo_Man
     */
    public int getTohyo_Man() {
        return tohyo_Man;
    }

    /**
     * tohyo_Womanを取得します。
     *
     * @return tohyo_Woman
     */
    public int getTohyo_Woman() {
        return tohyo_Woman;
    }

    /**
     * tohyo_Keiを取得します。
     *
     * @return tohyo_Kei
     */
    public int getTohyo_Kei() {
        return tohyo_Kei;
    }

    /**
     * shohonNoを設定します。
     *
     * @param shohonNo shohonNo
     */
    public void setShohonNo(ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * senkyoNoを設定します。
     *
     * @param senkyoNo senkyoNo
     */
    public void setSenkyoNo(SenkyoNo senkyoNo) {
        this.senkyoNo = senkyoNo;
    }

    /**
     * shisetsuCodeを設定します。
     *
     * @param shisetsuCode shisetsuCode
     */
    public void setShisetsuCode(RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * shisetsuNameを設定します。
     *
     * @param shisetsuName shisetsuName
     */
    public void setShisetsuName(RString shisetsuName) {
        this.shisetsuName = shisetsuName;
    }

    /**
     * tohyoToday_Manを設定します。
     *
     * @param tohyoToday_Man tohyoToday_Man
     */
    public void setTohyoToday_Man(int tohyoToday_Man) {
        this.tohyoToday_Man = tohyoToday_Man;
    }

    /**
     * tohyoToday_Womanを設定します。
     *
     * @param tohyoToday_Woman tohyoToday_Woman
     */
    public void setTohyoToday_Woman(int tohyoToday_Woman) {
        this.tohyoToday_Woman = tohyoToday_Woman;
    }

    /**
     * tohyoToday_Keiを設定します。
     *
     * @param tohyoToday_Kei tohyoToday_Kei
     */
    public void setTohyoToday_Kei(int tohyoToday_Kei) {
        this.tohyoToday_Kei = tohyoToday_Kei;
    }

    /**
     * tohyo_Manを設定します。
     *
     * @param tohyo_Man tohyo_Man
     */
    public void setTohyo_Man(int tohyo_Man) {
        this.tohyo_Man = tohyo_Man;
    }

    /**
     * tohyo_Womanを設定します。
     *
     * @param tohyo_Woman tohyo_Woman
     */
    public void setTohyo_Woman(int tohyo_Woman) {
        this.tohyo_Woman = tohyo_Woman;
    }

    /**
     * tohyo_Keiを設定します。
     *
     * @param tohyo_Kei tohyo_Kei
     */
    public void setTohyo_Kei(int tohyo_Kei) {
        this.tohyo_Kei = tohyo_Kei;
    }

}
