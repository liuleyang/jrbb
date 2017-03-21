/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 期日前・当日投票録エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT204TohyorokuEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final SenkyoNo DEFAULT_選挙番号 = new SenkyoNo(1);
    public static final FlexibleDate DEFAULT_報告年月日 = new FlexibleDate("20140228");
    public static final RString DEFAULT_施設コード = new RString("0001");
    public static final RString DEFAULT_投票区コード = RString.EMPTY;
    public static final RString DEFAULT_投票所設置状況 = new RString("テスト投票録");
    public static final RString DEFAULT_投票所開設場所 = RString.EMPTY;
    public static final FlexibleDate DEFAULT_設置期間_開始年月日 = new FlexibleDate("20140225");
    public static final FlexibleDate DEFAULT_設置期間_終了年月日 = new FlexibleDate("20140315");
    public static final RTime DEFAULT_開閉時刻_開始 = RTime.of(0, 0);
    public static final RTime DEFAULT_開閉時刻_終了 = RTime.of(0, 0);
    public static final int DEFAULT_選管書記人数 = 2;
    public static final int DEFAULT_職員人数 = 3;
    public static final int DEFAULT_その他人数 = 2;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT204TohyorokuEntityGenerator() {
    }

    public static AfT204TohyorokuEntity createAfT204TohyorokuEntity() {
        return createAfT204TohyorokuEntity(DEFAULT_抄本番号, DEFAULT_選挙番号);
    }

    public static AfT204TohyorokuEntity createAfT204TohyorokuEntity(ShohonNo shohonNo, SenkyoNo senkyoNo) {
        AfT204TohyorokuEntity entity = new AfT204TohyorokuEntity();
        entity.setShohonNo(shohonNo);
        entity.setSenkyoNo(senkyoNo);
        entity.setHokokuYMD(DEFAULT_報告年月日);
        entity.setShisetsuCode(DEFAULT_施設コード);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setSecchiJokyo(
                new RString(DEFAULT_投票所設置状況.toString() + "　：抄本番号" + shohonNo.value() + "：選挙番号" + senkyoNo.value()));
        entity.setKaisetsuBasho(DEFAULT_投票所開設場所);
        entity.setSecchiFirstYMD(DEFAULT_設置期間_開始年月日);
        entity.setSecchiLastYMD(DEFAULT_設置期間_終了年月日);
        entity.setKaiheiStartTime(DEFAULT_開閉時刻_開始);
        entity.setKaiheiStopTime(DEFAULT_開閉時刻_終了);
        entity.setShokiNinzu(DEFAULT_選管書記人数);
        entity.setShokuinNinzu(DEFAULT_職員人数);
        entity.setSonotaNinzu(DEFAULT_その他人数);
        return entity;
    }

}
