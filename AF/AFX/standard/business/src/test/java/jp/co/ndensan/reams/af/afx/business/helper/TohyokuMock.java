package jp.co.ndensan.reams.af.afx.business.helper;

import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * 投票区のMockです。
 *
 * @author N8103 日高 達也
 */
public final class TohyokuMock {

    private TohyokuMock() {
    }

    public static Tohyoku getSpiedInstance() {
        UrT0159TohyokuEntity entity = new UrT0159TohyokuEntity();
        entity.setTohyokuCode(new TohyokuCode(new RString("0001")));
//        entity.setReamsDonyuDantaiCode(new ReamsDonyuDantaiCode("000001"));
//        entity.setReamsDonyuDantaiCodeRenban(0);
        entity.setYukoKaishiYMD(new FlexibleDate("20130101"));
        entity.setYukoShuryoYMD(new FlexibleDate("20131231"));
        entity.setName(new RString("投票区漢字名称"));
        entity.setKanaName(new RString("トウヒョウクカナメイショウ"));
        entity.setKensakuKana(new RString("検索用カナ"));
        entity.setHyojiJun(0);
        return spy(new Tohyoku(entity));
    }
}
