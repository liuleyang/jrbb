/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 投票所エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT502TohyojoEntityGenerator {

    public static final RString DEFAULT_投票所コード = new RString("T991");
    public static final RString DEFAULT_投票所名称 = new RString("テスト投票所");
    public static final RString DEFAULT_カナ投票所名称 = new RString("ﾃｽﾄﾄｳﾋｮｳｼﾞｮ");
    public static final RString DEFAULT_検索用カナ投票所名称 = new RString("ﾃｽﾄﾄｳﾋﾖｳｼﾞﾖ");
    public static final RTime DEFAULT_投票開始時刻 = RTime.of(7, 0);
    public static final RTime DEFAULT_投票終了時刻 = RTime.of(20, 30);
    public static final boolean DEFAULT_在外投票可能フラグ = false;
    public static final YubinNo DEFAULT_郵便番号 = YubinNo.EMPTY;
    public static final AtenaJusho DEFAULT_住所 = AtenaJusho.EMPTY;
    public static final AtenaMeisho DEFAULT_投票所宛名 = AtenaMeisho.EMPTY;
    public static final TelNo DEFAULT_電話番号 = TelNo.EMPTY;
    public static final TelNo DEFAULT_FAX番号 = TelNo.EMPTY;
    public static final RString DEFAULT_地図ファイル名 = RString.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT502TohyojoEntityGenerator() {
    }

    public static AfT502TohyojoEntity createAfT502TohyojoEntity() {
        return createAfT502TohyojoEntity(DEFAULT_投票所コード);
    }

    public static AfT502TohyojoEntity createAfT502TohyojoEntity(RString tohyojoCode) {
        AfT502TohyojoEntity entity = new AfT502TohyojoEntity();
        entity.setTohyojoCode(tohyojoCode);
        entity.setTohyojoName(new RString(DEFAULT_投票所名称.toString() + tohyojoCode));
        entity.setKanaTohyojoName(DEFAULT_カナ投票所名称);
        entity.setSearchKanaTohyojoName(DEFAULT_検索用カナ投票所名称);
        entity.setTohyoStartTime(DEFAULT_投票開始時刻);
        entity.setTohyoStopTime(DEFAULT_投票終了時刻);
        entity.setZaigaiTohyoKanoFlag(DEFAULT_在外投票可能フラグ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTohyojoAtena(DEFAULT_投票所宛名);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setMapImage(DEFAULT_地図ファイル名);
        return entity;
    }

}
