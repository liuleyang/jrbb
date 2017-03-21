/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 財産区_住民投票選挙人抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT141ZaisankuJuminTohyoConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final FlexibleDate DEFAULT_年齢計算基準年月日 = new FlexibleDate("20141225");
    public static final int DEFAULT_年齢 = 18;
    public static final boolean DEFAULT_誕生日含フラグ = Boolean.TRUE;
    public static final int DEFAULT_居住年数 = 15;
    public static final FlexibleDate DEFAULT_住定開始年月日 = new FlexibleDate("19990101");
    public static final FlexibleDate DEFAULT_住定終了年月日 = new FlexibleDate("20141201");
    public static final boolean DEFAULT_日本人フラグ = Boolean.FALSE;
    public static final boolean DEFAULT_外国人フラグ = Boolean.FALSE;
    public static final boolean DEFAULT_住民フラグ = Boolean.FALSE;
    public static final boolean DEFAULT_転出者フラグ = Boolean.FALSE;
    public static final boolean DEFAULT_転入者フラグ = Boolean.FALSE;
    public static final boolean DEFAULT_公民権停止者含フラグ = Boolean.FALSE;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT141ZaisankuJuminTohyoConditionEntityGenerator() {
    }

    public static AfT141ZaisankuJuminTohyoConditionEntity createAfT141ZaisankuJuminTohyoConditionEntity() {
        return createAfT141ZaisankuJuminTohyoConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT141ZaisankuJuminTohyoConditionEntity createAfT141ZaisankuJuminTohyoConditionEntity(ShohonNo shohonNo) {
        AfT141ZaisankuJuminTohyoConditionEntity entity = new AfT141ZaisankuJuminTohyoConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setNenreiKeisanKijunYMD(DEFAULT_年齢計算基準年月日);
        entity.setNenrei(DEFAULT_年齢);
        entity.setBirthdayFukumuFlag(DEFAULT_誕生日含フラグ);
        entity.setKyojuNensu(DEFAULT_居住年数);
        entity.setJuteiFirstYMD(DEFAULT_住定開始年月日);
        entity.setJuteiLastYMD(DEFAULT_住定終了年月日);
        entity.setJapaneseFlag(DEFAULT_日本人フラグ);
        entity.setForeignerFlag(DEFAULT_外国人フラグ);
        entity.setJuminFlag(DEFAULT_住民フラグ);
        entity.setTenshutsushaFlag(DEFAULT_転出者フラグ);
        entity.setTennyushaFlag(DEFAULT_転入者フラグ);
        entity.setTeishishaFukumuFlag(DEFAULT_公民権停止者含フラグ);
        return entity;
    }

}
