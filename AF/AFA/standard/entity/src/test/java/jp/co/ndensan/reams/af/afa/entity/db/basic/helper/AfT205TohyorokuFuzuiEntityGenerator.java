/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzuiEntity;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyorokuKomokuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 期日前・当日投票録エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT205TohyorokuFuzuiEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final SenkyoNo DEFAULT_選挙番号 = new SenkyoNo(1);
    public static final FlexibleDate DEFAULT_報告年月日 = new FlexibleDate("20140228");
    public static final RString DEFAULT_施設コード = new RString("0001");
    public static final RString DEFAULT_投票区コード = RString.EMPTY;
    public static final Code DEFAULT_投票録項目種類 = new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode());
    public static final int DEFAULT_連番 = 1;
    public static final RString DEFAULT_党派 = RString.EMPTY;
    public static final AtenaMeisho DEFAULT_氏名 = AtenaMeisho.EMPTY;
    public static final FlexibleDate DEFAULT_選任年月日 = new FlexibleDate("20140225");
    public static final RTime DEFAULT_立会時間_開始時刻 = RTime.of(0, 0);
    public static final RTime DEFAULT_立会時間_終了時刻 = RTime.of(0, 0);
    public static final RTime DEFAULT_参会時刻 = RTime.of(0, 0);
    public static final RTime DEFAULT_辞職時刻 = RTime.of(0, 0);
    public static final RString DEFAULT_事由 = RString.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT205TohyorokuFuzuiEntityGenerator() {
    }

    public static AfT205TohyorokuFuzuiEntity createAfT205TohyorokuFuzuiEntity() {
        return createAfT205TohyorokuFuzuiEntity(DEFAULT_抄本番号, DEFAULT_選挙番号, DEFAULT_投票録項目種類);
    }

    public static AfT205TohyorokuFuzuiEntity createAfT205TohyorokuFuzuiEntity(ShohonNo shohonNo, SenkyoNo senkyoNo, Code shurui) {
        AfT205TohyorokuFuzuiEntity entity = new AfT205TohyorokuFuzuiEntity();
        entity.setShohonNo(shohonNo);
        entity.setSenkyoNo(senkyoNo);
        entity.setHokokuYMD(DEFAULT_報告年月日);
        entity.setShisetsuCode(DEFAULT_施設コード);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setKomokuShurui(shurui);
        entity.setRenban(DEFAULT_連番);
        entity.setToha(DEFAULT_党派);
        entity.setShimei(new AtenaMeisho("テスト投票録付随" + "　：抄本番号" + shohonNo.value()
                + "：選挙番号" + senkyoNo.value() + "：項目種類" + shurui.value()));
        entity.setSennninYMD(DEFAULT_選任年月日);
        entity.setTachiaiStartTime(DEFAULT_立会時間_開始時刻);
        entity.setTachiaiStopTime(DEFAULT_立会時間_終了時刻);
        entity.setSankaiTime(DEFAULT_参会時刻);
        entity.setJishokuTime(DEFAULT_辞職時刻);
        entity.setJiyu(DEFAULT_事由);
        return entity;
    }

}
