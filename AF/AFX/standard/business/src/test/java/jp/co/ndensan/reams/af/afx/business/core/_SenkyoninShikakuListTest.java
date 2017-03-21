/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.af.afx.testhelper.AfxTestBase;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 選挙人資格情報のコレクションを表すクラスのテストクラスです。
 *
 * @author N2311 関　和可奈
 */
@RunWith(Enclosed.class)
public class _SenkyoninShikakuListTest extends AfxTestBase {

    public static class コンストラクタ extends AfxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数がnullの場合_NullPointerExceptionエラーが発生する() {
            ISenkyoninShikakuList sut = new _SenkyoninShikakuList(null);
        }
    }

    public static class get選挙人資格 extends AfxTestBase {

        private ISenkyoninShikakuList 選挙人資格List;

        @Before
        public void setUp() {
            選挙人資格List = TestSupport.create選挙人資格情報();
        }

        @Test
        public void 引数で渡された選挙人識別コードに該当する情報が選挙人資格情報コレクションにある場合_該当する資格情報を返す() {
            ISenkyoninShikaku sut = 選挙人資格List.get選挙人資格(new ShikibetsuCode("0000000001"));
            assertThat(sut.get選挙人識別コード().value(), is(new RString("0000000001")));
            assertThat(sut.get選挙資格(), is(SenkyoShikaku.有権者));
            assertThat(sut.get投票区().get投票区コード().value(), is(new RString("AAAA")));
            assertThat(sut.get選挙人名簿登録年月日(), is(new RDate("20140401")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数で渡された選挙人識別コードに該当する情報が選挙人資格情報コレクションにない場合_IllegalArgumentExceptionが発生する() {
            ISenkyoninShikaku sut = 選挙人資格List.get選挙人資格(new ShikibetsuCode("0000000010"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数がnullの場合_NullPointerExceptionが発生する() {
            ISenkyoninShikaku sut = 選挙人資格List.get選挙人資格(null);
        }
    }

    public static class sizeのテスト extends AfxTestBase {

        @Test
        public void LDNS_選挙人資格Listがインスタンスの場合_sizeは_選挙人資格Listのサイズを返す() {
            ISenkyoninShikakuList 選挙人資格List = TestSupport.create選挙人資格情報();
            assertThat(選挙人資格List.size(), is(notNullValue()));
        }
    }

    public static class iteratorのテスト extends AfxTestBase {

        @Test
        public void LDNS_選挙人資格Listがインスタンスの場合_iteratorは_選挙人資格を返す() {
            ISenkyoninShikakuList 選挙人資格List = TestSupport.create選挙人資格情報();
            assertThat(選挙人資格List.iterator(), is(notNullValue()));
        }
    }

    private static class TestSupport {

        private static ISenkyoninShikakuList create選挙人資格情報() {
            List<ISenkyoninShikaku> senkyoninShikakuList = new ArrayList();

            ShikibetsuCode 選挙人識別コード = new ShikibetsuCode("0000000001");
            SenkyoShikaku 選挙資格 = SenkyoShikaku.有権者;
            Tohyoku 投票区 = create投票区();
            RDate 選挙人名簿登録年月日 = new RDate("20140401");
            ISenkyoninShikaku senkyoninShikaku = new _SenkyoninShikaku(選挙人識別コード, 選挙資格, 投票区, 選挙人名簿登録年月日);

            senkyoninShikakuList.add(senkyoninShikaku);
            return new _SenkyoninShikakuList(senkyoninShikakuList);
        }

        private static Tohyoku create投票区() {
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
