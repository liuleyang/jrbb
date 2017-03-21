/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 抄本エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT100ShohonEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final Code DEFAULT_選挙種類 = new Code(SenkyoShurui.定時登録.getCode());
    public static final RString DEFAULT_抄本名 = new RString("テスト抄本");
    public static final FlexibleDate DEFAULT_投票年月日 = new FlexibleDate("20141231");
    public static final FlexibleDate DEFAULT_規定年齢到達年月日 = new FlexibleDate("20150101");
    public static final FlexibleDate DEFAULT_処理年月日 = FlexibleDate.getNowDate();
    public static final Decimal DEFAULT_入場券発行固有番号 = new Decimal(1);
    public static final ShohonNo DEFAULT_研修用抄本番号 = new ShohonNo(99991);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT100ShohonEntityGenerator() {
    }

    public static AfT100ShohonEntity createAfT100ShohonEntity() {
        return createAfT100ShohonEntity(DEFAULT_抄本番号, DEFAULT_選挙種類);
    }

    public static AfT100ShohonEntity createAfT100ShohonEntity(ShohonNo shohonNo, Code senkyoShurui) {
        return createAfT100ShohonEntity(shohonNo, senkyoShurui, DEFAULT_投票年月日);
    }

    public static AfT100ShohonEntity createAfT100ShohonEntity(ShohonNo shohonNo, Code senkyoShurui, FlexibleDate tohyoYmd) {
        AfT100ShohonEntity entity = new AfT100ShohonEntity();
        entity.setShohonNo(shohonNo);
        entity.setSenkyoShurui(senkyoShurui);
        entity.setShohonName(new RString(DEFAULT_抄本名.toString() + shohonNo.value()));
        entity.setTohyoYMD(tohyoYmd);
        entity.setKiteiNenreiTotatsuYMD(DEFAULT_規定年齢到達年月日);
        entity.setShoriYMD(DEFAULT_処理年月日);
        entity.setNyujokenReportIndex(DEFAULT_入場券発行固有番号);
        entity.setSimulationShohonNo(DEFAULT_研修用抄本番号);
        return entity;
    }

}
