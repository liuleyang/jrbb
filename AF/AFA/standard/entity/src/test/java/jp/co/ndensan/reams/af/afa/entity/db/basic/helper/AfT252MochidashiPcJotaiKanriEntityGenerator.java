/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 持出端末状態管理エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N1823
 */
public class AfT252MochidashiPcJotaiKanriEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final RString DEFAULT_投票区コード = new RString("001");
    public static final Code DEFAULT_作成区分 = new Code(new RString("1"));
    public static final Code DEFAULT_AP受渡区分 = new Code(new RString("0"));
    public static final Code DEFAULT_受渡区分 = new Code(new RString("0"));
    public static final Code DEFAULT_取込区分 = new Code(new RString("3"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT252MochidashiPcJotaiKanriEntityGenerator() {
    }

    public static AfT252MochidashiPcJotaiKanriEntity createAfT252MochidashiPcJotaiKanriEntity() {
        return createAfT252MochidashiPcJotaiKanriEntity(DEFAULT_抄本番号, DEFAULT_投票区コード);
    }

    public static AfT252MochidashiPcJotaiKanriEntity createAfT252MochidashiPcJotaiKanriEntity(ShohonNo shohonNo, RString tohyokuCode) {
        AfT252MochidashiPcJotaiKanriEntity entity = new AfT252MochidashiPcJotaiKanriEntity();
        entity.setShohonNo(shohonNo);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setDataCreateKubun(DEFAULT_作成区分);
        entity.setDataCreateYMD(YMDHMS.now());
        entity.setSystemSendKubun(DEFAULT_AP受渡区分);
        entity.setSystemSendYMD(YMDHMS.now());
        entity.setDataSendKubun(DEFAULT_受渡区分);
        entity.setDataSendYMD(YMDHMS.now());
        entity.setDataImportKubun(DEFAULT_取込区分);
        entity.setDataImportYMD(YMDHMS.now());
        return entity;
    }

}
