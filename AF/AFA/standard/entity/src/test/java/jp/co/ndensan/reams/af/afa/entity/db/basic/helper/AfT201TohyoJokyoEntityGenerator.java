/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 投票状況エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT201TohyoJokyoEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final SenkyoNo DEFAULT_選挙番号 = new SenkyoNo(1);
    public static final Code DEFAULT_投票状況 = new Code(TohyoJokyo.期日前.getCode());
    public static final Code DEFAULT_投票事由コード = new Code("2");   // 通常選挙用：旅行等
    public static final boolean DEFAULT_代理投票有フラグ = false;
    public static final boolean DEFAULT_点字フラグ = false;
    public static final boolean DEFAULT_証明書出力フラグ = false;
    public static final FlexibleDate DEFAULT_棄権年月日 = FlexibleDate.EMPTY;
    public static final ShikibetsuCode DEFAULT_補助者識別コード1 = ShikibetsuCode.EMPTY;
    public static final AtenaMeisho DEFAULT_補助者氏名1 = new AtenaMeisho("テスト選挙人");
    public static final ShikibetsuCode DEFAULT_補助者識別コード2 = ShikibetsuCode.EMPTY;
    public static final AtenaMeisho DEFAULT_補助者氏名2 = AtenaMeisho.EMPTY;
    public static final RString DEFAULT_拒否事由 = RString.EMPTY;
    public static final FlexibleDate DEFAULT_請求年月日 = new FlexibleDate("20140228");
    public static final Code DEFAULT_請求方法 = new Code("1");
    public static final int DEFAULT_受付番号 = 1;
    public static final FlexibleDate DEFAULT_交付年月日 = new FlexibleDate("20140303");
    public static final RTime DEFAULT_交付時刻 = RTime.of(15, 15);
    public static final Code DEFAULT_交付方法 = new Code("1");
    public static final RString DEFAULT_交付施設コード = new RString("0001");
    public static final FlexibleDate DEFAULT_受取年月日 = new FlexibleDate("20140310");
    public static final FlexibleDate DEFAULT_受理年月日 = new FlexibleDate("20140310");
    public static final RTime DEFAULT_受理時刻 = RTime.of(0, 0);
    public static final Code DEFAULT_受理方法 = Code.EMPTY;
    public static final Code DEFAULT_受理施設種別 = Code.EMPTY;
    public static final FlexibleDate DEFAULT_返還年月日 = FlexibleDate.EMPTY;
    public static final boolean DEFAULT_送致済フラグ = false;
    public static final Code DEFAULT_期日前不在者区分 = Code.EMPTY;
    public static final RString DEFAULT_更新端末ID = new RString("testTanmatsuID");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT201TohyoJokyoEntityGenerator() {
    }

    public static AfT201TohyoJokyoEntity createAfT201TohyoJokyoEntity() {
        return createAfT201TohyoJokyoEntity(DEFAULT_抄本番号, DEFAULT_識別コード, DEFAULT_選挙番号, DEFAULT_投票状況);
    }

    public static AfT201TohyoJokyoEntity createAfT201TohyoJokyoEntity(
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, SenkyoNo senkyoNo, Code tohyoJokyo) {
        AfT201TohyoJokyoEntity entity = new AfT201TohyoJokyoEntity();
        entity.setShohonNo(shohonNo);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setSenkyoNo(senkyoNo);
        entity.setTohyoJokyo(tohyoJokyo);
        entity.setTohyoJiyuCode(DEFAULT_投票事由コード);
        entity.setDairiTohyoAriFlag(DEFAULT_代理投票有フラグ);
        entity.setTenjiFlag(DEFAULT_点字フラグ);
        entity.setShomeishoPrintFlag(DEFAULT_証明書出力フラグ);
        entity.setKikenYMD(DEFAULT_棄権年月日);
        entity.setHojoshaShikibetsuCode1(DEFAULT_補助者識別コード1);
        entity.setHojoshaShimei1(new AtenaMeisho(DEFAULT_補助者氏名1.getColumnValue() + shikibetsuCode.toString()
                + "：抄本番号" + shohonNo.value() + "：選挙番号" + senkyoNo.getColumnValue()));
        entity.setHojoshaShikibetsuCode2(DEFAULT_補助者識別コード2);
        entity.setHojoshaShimei2(DEFAULT_補助者氏名2);
        entity.setKyohiJiyu(DEFAULT_拒否事由);
        entity.setSeikyuYMD(DEFAULT_請求年月日);
        entity.setSeikyuHoho(DEFAULT_請求方法);
        entity.setUketsukeNo(DEFAULT_受付番号);
        entity.setKofuYMD(DEFAULT_交付年月日);
        entity.setKofuTime(DEFAULT_交付時刻);
        entity.setKofuHoho(DEFAULT_交付方法);
        entity.setShisetsuCode(DEFAULT_交付施設コード);
        entity.setUketoriYMD(DEFAULT_受取年月日);
        entity.setJuriYMD(DEFAULT_受理年月日);
        entity.setJuriTime(DEFAULT_受理時刻);
        entity.setJuriHoho(DEFAULT_受理方法);
        entity.setJuriShisetsuShubetsu(DEFAULT_受理施設種別);
        entity.setHenkanYMD(DEFAULT_返還年月日);
        entity.setSochiZumiFlag(DEFAULT_送致済フラグ);
        entity.setKijitsuFuzaiKubun(DEFAULT_期日前不在者区分);
        entity.setReamsClientId(DEFAULT_更新端末ID);
        return entity;
    }

}
