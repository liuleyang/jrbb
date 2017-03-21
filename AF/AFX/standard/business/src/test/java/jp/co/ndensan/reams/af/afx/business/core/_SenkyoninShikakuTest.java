/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.core;

import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.af.afx.testhelper.AfxTestBase;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 選挙人の資格情報を表すクラスのテストクラスです。
 *
 * @author N2311 関　和可奈
 */
@RunWith(Enclosed.class)
public class _SenkyoninShikakuTest extends AfxTestBase {

    public static class コンストラクタ extends AfxTestBase {

        private ISenkyoninShikaku sut;
        private ShikibetsuCode 選挙人識別コード;
        private SenkyoShikaku 選挙資格;
        private Tohyoku 投票区;
        private RDate 選挙人名簿登録年月日;

        @Before
        public void setUp() {
            選挙人識別コード = new ShikibetsuCode("0000000001");
            選挙資格 = SenkyoShikaku.有権者;
            投票区 = create投票区();
            選挙人名簿登録年月日 = new RDate("20140401");
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数である選挙人識別コードがNullの場合_NullPointerExceptionが発生する() {
            sut = new _SenkyoninShikaku(null, 選挙資格, 投票区, 選挙人名簿登録年月日);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数である選挙資格がNullの場合_NullPointerExceptionが発生する() {
            sut = new _SenkyoninShikaku(選挙人識別コード, null, 投票区, 選挙人名簿登録年月日);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数である投票区がNullの場合_NullPointerExceptionが発生する() {
            sut = new _SenkyoninShikaku(選挙人識別コード, 選挙資格, null, 選挙人名簿登録年月日);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数である選挙人名簿登録年月日がNullの場合_NullPointerExceptionが発生する() {
            sut = new _SenkyoninShikaku(選挙人識別コード, 選挙資格, 投票区, null);
        }

        private Tohyoku create投票区() {
            UrT0159TohyokuEntity entity = new UrT0159TohyokuEntity();
            entity.setTohyokuCode(new TohyokuCode(new RString("AAAA")));
//            entity.setReamsDonyuDantaiCode(new ReamsDonyuDantaiCode("000001"));
//            entity.setReamsDonyuDantaiCodeRenban(0);
            entity.setYukoKaishiYMD(new FlexibleDate("20130101"));
            entity.setYukoShuryoYMD(new FlexibleDate("20131231"));
            entity.setName(new RString("投票区漢字名称"));
            entity.setKanaName(new RString("トウヒョウクカナメイショウ"));
            entity.setKensakuKana(new RString("検索用カナ"));
            entity.setHyojiJun(0);
            return new Tohyoku(entity);
        }
    }
}
