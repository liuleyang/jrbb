/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakuseiEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 裁判員名簿作成情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT301SaibaninMeiboSakuseiEntityGenerator {

    public static final RYear DEFAULT_年度 = new RYear("9991");
    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final RString DEFAULT_有権者情報保存先 = RString.EMPTY;
    public static final RString DEFAULT_有権者情報ファイル名 = new RString("テスト裁判員名簿");
    public static final boolean DEFAULT_予定者名簿取込済フラグ = Boolean.FALSE;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT301SaibaninMeiboSakuseiEntityGenerator() {
    }

    public static AfT301SaibaninMeiboSakuseiEntity createAfT301SaibaninMeiboSakuseiEntity() {
        return createAfT301SaibaninMeiboSakuseiEntity(DEFAULT_年度, DEFAULT_抄本番号);
    }

    public static AfT301SaibaninMeiboSakuseiEntity createAfT301SaibaninMeiboSakuseiEntity(RYear nendo, ShohonNo shohonNo) {
        AfT301SaibaninMeiboSakuseiEntity entity = new AfT301SaibaninMeiboSakuseiEntity();
        entity.setNendo(nendo);
        entity.setShohonNo(shohonNo);
        entity.setHozonSaki(DEFAULT_有権者情報保存先);
        entity.setFileName(new RString(DEFAULT_有権者情報ファイル名.toString() + nendo));
        entity.setMeiboTorikomiZumiFlag(DEFAULT_予定者名簿取込済フラグ);
        return entity;
    }

}
