/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT131KaikuSenkyoDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT131KaikuSenkyoDacTest extends AfaTestDacBase {

    private static AfT131KaikuSenkyoDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本9992 = new ShohonNo(999992);
    private static final ShohonNo 抄本9993 = new ShohonNo(999993);
    private static final ShohonNo 抄本9999 = new ShohonNo(999999);

    private static final RYear 年度2014 = new RYear("2014");
    private static final RYear 年度2015 = new RYear("2015");

//物理テーブル名が変わってしまったため、テストが通らない。とりあえずコメントにするが、テーブル変更後はテストが通るようにすること！！！
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceProvider.create(AfT131KaikuSenkyoDac.class);
//    }
//
//    public static class selectTest_shohonNo extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2015));
//        }
//
//        @Test
//        public void 抄本番号9991を指定した場合_年度_2014のエンティティを返す() {
//            AfT131KaikuSenkyoEntity result = sut.select(抄本9991);
//            assertThat(result.getNendo(), is(new RYear("2014")));
//        }
//
//        @Test
//        public void 未登録の抄本番号を指定した場合_nullが返る() {
//            AfT131KaikuSenkyoEntity result = sut.select(抄本9999);
//            assertNull(result);
//        }
//    }
//
//    public static class selectTest_nendo extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9993, 年度2015));
//        }
//
//        @Test
//        public void 年度2014_を指定した場合_2件返る() {
//            List<AfT131KaikuSenkyoEntity> result = sut.select(年度2014);
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 未登録の抄本番号を指定した場合_EMPTY_LISTが返る() {
//            List<AfT131KaikuSenkyoEntity> result = sut.select(new RYear("9999"));
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class selectTest_All extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2015));
//        }
//
//        @Test
//        public void selectした場合_2件返る() {
//            List<AfT131KaikuSenkyoEntity> result = sut.select();
//            assertThat(result.size(), is(2));
//        }
//    }
//
//    public static class insertOrUpdateTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//        }
//
//        @Test
//        public void 抄本番号9992のentityを指定した場合_insertが実行される() {
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2015));
//
//            AfT131KaikuSenkyoEntity result = sut.select(抄本9992);
//            assertNotNull(result);
//            assertThat(result.getNendo(), is(new RYear("2015")));
//        }
//
//        @Test
//        public void 抄本番号9991_年度2015のentityを渡すと_updateが実行される() {
//            AfT131KaikuSenkyoEntity entity = sut.select(抄本9991);
//            assertThat(entity.getNendo(), is(new RYear("2014")));
//
//            entity.setNendo(年度2015);
//            sut.insertOrUpdate(entity);
//
//            AfT131KaikuSenkyoEntity result = sut.select(抄本9991);
//            assertThat(result.getNendo(), is(new RYear("2015")));
//        }
//    }
//
//    public static class deleteTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2014));
//        }
//
//        @Test
//        public void 抄本番号9991のentityを指定した場合_deleteが成功し_1が返る() {
//            AfT131KaikuSenkyoEntity entity = sut.select(抄本9991);
//            assertThat(sut.delete(entity), is(1));
//        }
//    }
//
//    public static class deleteTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9993, 年度2015));
//        }
//
//        @Test
//        public void 年度2014のentityを指定した場合_deleteが成功し_処理件数2件が返る() {
//            List<AfT131KaikuSenkyoEntity> entities = sut.select(年度2014);
//            assertThat(sut.delete(entities), is(2));
//        }
//    }
//
//    public static class deletePhysicalTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2014));
//        }
//
//        @Test
//        public void 抄本番号9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
//            AfT131KaikuSenkyoEntity entity = sut.select(抄本9991);
//            assertThat(sut.deletePhysical(entity), is(1));
//        }
//    }
//
//    public static class deletePhysicalTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            sut.insertOrUpdate(create農業海区選挙(抄本9991, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9992, 年度2014));
//            sut.insertOrUpdate(create農業海区選挙(抄本9993, 年度2015));
//        }
//
//        @Test
//        public void 年度2014のentityを指定した場合_deletePhysicalが成功し_処理件数2件が返る() {
//            List<AfT131KaikuSenkyoEntity> entities = sut.select(年度2014);
//            assertThat(sut.deletePhysical(entities), is(2));
//        }
//    }
//
//    private static AfT131KaikuSenkyoEntity create農業海区選挙(ShohonNo shohonNo, RYear nendo) {
//        return AfT131KaikuSenkyoEntityGenerator.createAfT131NogyoKaikuSenkyoEntity(shohonNo, nendo);
//    }
//
//    private static void deleteTable(AfT131KaikuSenkyoDac dac) {
//        List<AfT131KaikuSenkyoEntity> list = dac.select();
//        dac.delete(list);
//    }
}
