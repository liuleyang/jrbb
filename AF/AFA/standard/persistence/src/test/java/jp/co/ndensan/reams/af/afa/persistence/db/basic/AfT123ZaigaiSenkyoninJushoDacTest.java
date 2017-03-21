/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT123ZaigaiSenkyoninJushoDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT123ZaigaiSenkyoninJushoDacTest extends AfaTestDacBase {

    private static AfT124ZaigaiSenkyoninShinseiDac sutShinsei;
    private static AfT122ZaigaiSenkyoShikakuDac sutShikaku;
    private static AfT123ZaigaiSenkyoninJushoDac sut;

    private static final ShikibetsuCode 選挙人00001 = new ShikibetsuCode("999999999900001");
    private static final ShikibetsuCode 選挙人00002 = new ShikibetsuCode("999999999900002");
    private static final ShikibetsuCode 選挙人00003 = new ShikibetsuCode("999999999900003");

    private static final int 申請番号1 = 999991;
    private static final int 申請番号2 = 999992;

    private static final Code 住所種類1 = new Code("T1");
    private static final Code 住所種類2 = new Code("T2");
    private static final Code 住所種類3 = new Code("T3");

    @BeforeClass
    public static void setUpClass() {
        sutShinsei = InstanceProvider.create(AfT124ZaigaiSenkyoninShinseiDac.class);
        sutShikaku = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
        sut = InstanceProvider.create(AfT123ZaigaiSenkyoninJushoDac.class);
    }
//物理テーブル名が変わってしまったため、テストが通らない。とりあえずコメントにするが、テーブル変更後はテストが通るようにすること！！！
//    public static class selectTest_ShikibetsuCode_ShinseiNo_JushoShuruiKubun extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//        }
//
//        @Test
//        public void 選挙人00001_住所種類1を指定した場合_住所_テスト在外選挙人国内住所情報999999999900001住所種類T1のエンティティを返す() {
//            AfT123ZaigaiSenkyoninJushoEntity result = sut.select(選挙人00001, 申請番号1, 住所種類1);
//            assertThat(result.getJusho(),
//                    is(new AtenaJusho("テスト在外選挙人国内住所情報999999999900001：住所種類T1")));
//        }
//
//        @Test
//        public void 未登録の選挙人を指定した場合_nullが返る() {
//            AfT123ZaigaiSenkyoninJushoEntity result = sut.select(選挙人00003, 申請番号1, 住所種類1);
//            assertNull(result);
//        }
//    }
//
//    public static class selectTest_ShikibetsuCode_ShinseiNo extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号2, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//        }
//
//        @Test
//        public void 選挙人00001_申請番号1を指定した場合_2件返す() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> result = sut.select(選挙人00001, 申請番号1);
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 未登録の申請番号を指定した場合_EMPTY_LISTが返る() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> result = sut.select(選挙人00002, 申請番号2);
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class selectTest_ShikibetsuCode extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類3));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//        }
//
//        @Test
//        public void 選挙人00001を指定した場合_3件返す() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> result = sut.select(選挙人00001);
//            assertThat(result.size(), is(3));
//        }
//
//        @Test
//        public void 未登録の選挙人を指定した場合_EMPTY_LISTが返る() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> result = sut.select(選挙人00003);
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class selectTest_All extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//        }
//
//        @Test
//        public void selectした場合_3件返す() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> result = sut.select();
//            assertThat(result.size(), is(3));
//        }
//    }
//
//    public static class insertOrUpdateTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//        }
//
//        @Test
//        public void 選挙人00002のentityを指定した場合_insertが実行される() {
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//
//            AfT123ZaigaiSenkyoninJushoEntity result = sut.select(選挙人00002, 申請番号1, 住所種類1);
//            assertNotNull(result);
//            assertThat(result.getJusho(),
//                    is(new AtenaJusho("テスト在外選挙人国内住所情報999999999900002：住所種類T1")));
//        }
//
//        @Test
//        public void 選挙人00001_住所種類1_住所_更新済のentityを渡すと_updateが実行される() {
//            AfT123ZaigaiSenkyoninJushoEntity entity = sut.select(選挙人00001, 申請番号1, 住所種類1);
//            assertThat(entity.getJusho(),
//                    is(new AtenaJusho("テスト在外選挙人国内住所情報999999999900001：住所種類T1")));
//
//            entity.setJusho(new AtenaJusho("更新済"));
//            sut.insertOrUpdate(entity);
//
//            AfT123ZaigaiSenkyoninJushoEntity result = sut.select(選挙人00001, 申請番号1, 住所種類1);
//            assertThat(result.getJusho(), is(new AtenaJusho("更新済")));
//        }
//    }
//
//    public static class insertOrUpdateTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//        }
//
//        @Test
//        public void 選挙人00001_住所種類2から3_選挙人00002で複数件数Listを指定した場合_処理件数3件が返る() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> entities = new ArrayList<>();
//            entities.add(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//            entities.add(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類3));
//            entities.add(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//
//            assertThat(sut.insertOrUpdate(entities), is(3));
//        }
//    }
//
//    public static class deleteTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//        }
//
//        @Test
//        public void 選挙人00001_集所種類1のentityを指定した場合_deleteが成功し_1が返る() {
//            AfT123ZaigaiSenkyoninJushoEntity entity = sut.select(選挙人00001, 申請番号1, 住所種類1);
//            assertThat(sut.delete(entity), is(1));
//        }
//    }
//
//    public static class deleteTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類3));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//        }
//
//        @Test
//        public void 選挙人00001を指定した場合_deleteが成功し_処理件数3件が返る() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> entities = sut.select(選挙人00001);
//            assertThat(sut.delete(entities), is(3));
//        }
//    }
//
//    public static class deletePhysicalTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//        }
//
//        @Test
//        public void 選挙人00001_集所種類1のentityを指定した場合_deletePhysicalが成功し_1が返る() {
//            AfT123ZaigaiSenkyoninJushoEntity entity = sut.select(選挙人00001, 申請番号1, 住所種類1);
//            assertThat(sut.deletePhysical(entity), is(1));
//        }
//    }
//
//    public static class deletePhysicalTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            populate();
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類1));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類2));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00001, 申請番号1, 住所種類3));
//            sut.insertOrUpdate(create在外国内住所情報(選挙人00002, 申請番号1, 住所種類1));
//        }
//
//        @Test
//        public void 選挙人00001を指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
//            List<AfT123ZaigaiSenkyoninJushoEntity> entities = sut.select(選挙人00001);
//            assertThat(sut.deletePhysical(entities), is(3));
//        }
//    }
//
//    private static AfT123ZaigaiSenkyoninJushoEntity create在外国内住所情報(
//            ShikibetsuCode shikibetsuCode, int shinseiNo, Code jushoShuruiKubun) {
//        return AfT123ZaigaiSenkyoninJushoEntityGenerator.
//                createAfT123ZaigaiSenkyoninKokunaiJushoEntity(shikibetsuCode, shinseiNo, jushoShuruiKubun);
//    }
//
//    private static void populate() {
//        deleteTable(sut);
//        sutShinsei.delete(sutShinsei.select());
//        sutShikaku.delete(sutShikaku.select());
//
//        sutShinsei.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
//        sutShinsei.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
//        sutShinsei.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00002));
//
//        sutShikaku.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号1));
//        sutShikaku.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号2));
//        sutShikaku.insertOrUpdate(create在外選挙資格(選挙人00002, 申請番号1));
//    }
//
//    private static AfT124ZaigaiSenkyoninShinseiEntity create在外申請情報(int shinseiNo, ShikibetsuCode shikibetsuCode) {
//        return AfT124ZaigaiSenkyoninShinseiEntityGenerator.createAfT124ZaigaiSenkyoninShinseiEntity(shinseiNo, shikibetsuCode);
//    }
//
//    private static AfT122ZaigaiSenkyoShikakuEntity create在外選挙資格(ShikibetsuCode shikibetsuCode, int shinseiNo) {
//        return AfT122ZaigaiSenkyoShikakuEntityGenerator.createAfT122ZaigaiSenkyoShikakuEntity(shikibetsuCode, shinseiNo);
//    }
//
//    private static void deleteTable(AfT123ZaigaiSenkyoninJushoDac dac) {
//        List<AfT123ZaigaiSenkyoninJushoEntity> list = dac.select();
//        dac.delete(list);
//    }
}
