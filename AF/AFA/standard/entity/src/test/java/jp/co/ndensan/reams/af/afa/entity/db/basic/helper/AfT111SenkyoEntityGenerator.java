/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT111SenkyoEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final SenkyoNo DEFAULT_選挙番号 = new SenkyoNo(1);
    public static final Code DEFAULT_選挙レベル = new Code("1");
    public static final RString DEFAULT_選挙名称 = new RString("テスト選挙");
    public static final RString DEFAULT_選挙略称 = RString.EMPTY;
    public static final RString DEFAULT_選挙マーク = RString.EMPTY;
    public static final FlexibleDate DEFAULT_告示_公示年月日 = new FlexibleDate("20141231");
    public static final FlexibleDate DEFAULT_名簿基準年月日 = new FlexibleDate("20141231");
    public static final FlexibleDate DEFAULT_名簿登録年月日 = new FlexibleDate("20141231");
    public static final FlexibleDate DEFAULT_転出期限年月日 = new FlexibleDate("20141231");
    public static final FlexibleDate DEFAULT_転入期限年月日 = new FlexibleDate("20141231");
    public static final FlexibleDate DEFAULT_投票受付開始年月日 = new FlexibleDate("20141231");
    public static final boolean DEFAULT_無投票選挙フラグ = Boolean.FALSE;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT111SenkyoEntityGenerator() {
    }

    public static AfT111SenkyoEntity createAfT111SenkyoEntity() {
        return createAfT111SenkyoEntity(DEFAULT_抄本番号, DEFAULT_選挙番号);
    }

    public static AfT111SenkyoEntity createAfT111SenkyoEntity(ShohonNo shohonNo, SenkyoNo senkyoNo) {
        AfT111SenkyoEntity entity = new AfT111SenkyoEntity();
        entity.setShohonNo(shohonNo);
        entity.setSenkyoNo(senkyoNo);
        entity.setSenkyoLevel(DEFAULT_選挙レベル);
        entity.setSenkyoName(new RString(DEFAULT_選挙名称.toString() + senkyoNo.value()));
        entity.setSenkyoRyakusho(DEFAULT_選挙略称);
        entity.setSenkyoMark(DEFAULT_選挙マーク);
        entity.setKokujiYMD(DEFAULT_告示_公示年月日);
        entity.setKijunYMD(DEFAULT_名簿基準年月日);
        entity.setMeiboTorokuYMD(DEFAULT_名簿登録年月日);
        entity.setTenshutsuKigenYMD(DEFAULT_転出期限年月日);
        entity.setTennyuKigenYMD(DEFAULT_転入期限年月日);
        entity.setTohyoUketsukeYMD(DEFAULT_投票受付開始年月日);
        entity.setMutohyoSenkyoFlag(DEFAULT_無投票選挙フラグ);
        return entity;
    }

}
