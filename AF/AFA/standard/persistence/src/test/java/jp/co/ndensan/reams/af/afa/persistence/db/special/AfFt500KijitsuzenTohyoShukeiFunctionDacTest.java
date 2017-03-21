/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.special;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfFt500KijitsuzenTohyoShukeiFunctionDac}のテストクラスです。
 *
 * @author ds_arisawa
 */
@RunWith(Enclosed.class)
public class AfFt500KijitsuzenTohyoShukeiFunctionDacTest {

    //TODO KijitsuzenTohyoShukeiManagerのTestでmockを使ったテストは行っているので、
    //こちらのテストクラスは廃棄？それとも、DBアクセスするテストを作る？
//    private static AfFt500KijitsuzenTohyoShukeiFunctionDac dac;
//
//    @BeforeClass
//    public static void setUpClass() {
//        dac = mock(AfFt500KijitsuzenTohyoShukeiFunctionDac.class);
//    }
//
//    public static class select_shohonNo_senkyoNo_kijunYmd_Test extends AfzTestDacBase {
//
//        @Test
//        public void testSelect() {
//            List<KijitsuzenTohyoShukeiEntity> list = new ArrayList<>();
//            list.add(new KijitsuzenTohyoShukeiEntity());
//            when(dac.select(any(ShohonNo.class), any(SenkyoNo.class), any(FlexibleDate.class))).thenReturn(list);
//
//            assertThat(dac.select(new ShohonNo(11), new SenkyoNo(1), new FlexibleDate("20140711")), is(notNullValue()));
//        }
//    }
}
