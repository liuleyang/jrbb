/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT506JushoRelationEntity;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所番地対応エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT506JushoRelationEntityGenerator {

    public static final Code DEFAULT_選挙種類 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    public static final ChoikiCode DEFAULT_町域コード = new ChoikiCode("T991");
    public static final BanchiCode DEFAULT_開始番地1 = new BanchiCode("T991");
    public static final BanchiCode DEFAULT_開始番地2 = new BanchiCode("T992");
    public static final BanchiCode DEFAULT_開始番地3 = new BanchiCode("T993");
    public static final BanchiCode DEFAULT_開始番地4 = new BanchiCode("T994");
    public static final BanchiCode DEFAULT_終了番地1 = new BanchiCode("T991");
    public static final BanchiCode DEFAULT_終了番地2 = new BanchiCode("T992");
    public static final BanchiCode DEFAULT_終了番地3 = new BanchiCode("T993");
    public static final BanchiCode DEFAULT_終了番地4 = new BanchiCode("T994");
    public static final RString DEFAULT_投票区コード = new RString("T991");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT506JushoRelationEntityGenerator() {
    }

    public static AfT506JushoRelationEntity createAfT506JushoRelationEntity() {
        return createAfT506JushoRelationEntity(DEFAULT_選挙種類, DEFAULT_町域コード);
    }

    public static AfT506JushoRelationEntity createAfT506JushoRelationEntity(Code senkyoShurui, ChoikiCode choikiCode) {
        AfT506JushoRelationEntity entity = new AfT506JushoRelationEntity();
        entity.setSenkyoShurui(senkyoShurui);
        entity.setChoikiCode(choikiCode);
        entity.setKaishiBanchi1BanchiCode(DEFAULT_開始番地1);
        entity.setKaishiBanchi2BanchiCode(DEFAULT_開始番地2);
        entity.setKaishiBanchi3BanchiCode(DEFAULT_開始番地3);
        entity.setKaishiBanchi4BanchiCode(DEFAULT_開始番地4);
        entity.setShuiryoBanchi1BanchiCode(DEFAULT_終了番地1);
        entity.setShuiryoBanchi2BanchiCode(DEFAULT_終了番地2);
        entity.setShuiryoBanchi3BanchiCode(DEFAULT_終了番地3);
        entity.setShuiryoBanchi4BanchiCode(DEFAULT_終了番地4);
        entity.setTohyokuCode(choikiCode.getColumnValue());
        return entity;
    }
}
