/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT122ZaigaiSenkyoShikakuEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT124ZaigaiSenkyoninShinseiEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT122ZaigaiSenkyoShikakuDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT122ZaigaiSenkyoShikakuDacTest extends AfaTestDacBase {

    private static AfT124ZaigaiSenkyoninShinseiDac sutOya;
    private static AfT122ZaigaiSenkyoShikakuDac sut;

    private static final ShikibetsuCode 選挙人00001 = new ShikibetsuCode("999999999900001");
    private static final ShikibetsuCode 選挙人00002 = new ShikibetsuCode("999999999900002");
    private static final ShikibetsuCode 選挙人00003 = new ShikibetsuCode("999999999900003");

    private static final int 申請番号11 = 999911;
    private static final int 申請番号12 = 999912;
    private static final int 申請番号21 = 999921;
    private static final int 申請番号31 = 999931;

    @BeforeClass
    public static void setUpClass() {
        sutOya = InstanceProvider.create(AfT124ZaigaiSenkyoninShinseiDac.class);
        sut = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
    }

    public static class selectTest_ShikibetsuCode_ShinseiNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号12));
        }

        @Test
        public void 選挙人00001_申請番号1を指定した場合_特記事項_テスト在外選挙資格999999999900001申請番号999911のエンティティを返す() {
            AfT122ZaigaiSenkyoShikakuEntity result = sut.select(選挙人00001, 申請番号11);
            assertThat(result.getTokkiJiko(),
                    is(new RString("テスト在外選挙資格999999999900001：申請番号999911")));
        }

        @Test
        public void 未登録の選挙人を指定した場合_nullが返る() {
            AfT122ZaigaiSenkyoShikakuEntity result = sut.select(選挙人00003, 申請番号31);
            assertNull(result);
        }
    }

    public static class selectTest_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号12));
            sut.insertOrUpdate(create在外選挙資格(選挙人00002, 申請番号21));
        }

        @Test
        public void 選挙人00001を指定した場合_2件返す() {
            List<AfT122ZaigaiSenkyoShikakuEntity> result = sut.select(選挙人00001);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 未登録の選挙人を指定した場合_EMPTY_LISTが返る() {
            List<AfT122ZaigaiSenkyoShikakuEntity> result = sut.select(選挙人00003);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00002, 申請番号21));
        }

        @Test
        public void selectした場合_2件返す() {
            List<AfT122ZaigaiSenkyoShikakuEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
        }

        @Test
        public void 選挙人00002のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create在外選挙資格(選挙人00002, 申請番号21));

            AfT122ZaigaiSenkyoShikakuEntity result = sut.select(選挙人00002, 申請番号21);
            assertNotNull(result);
            assertThat(result.getTokkiJiko(),
                    is(new RString("テスト在外選挙資格999999999900002：申請番号999921")));
        }

        @Test
        public void 選挙人00001_申請番号1_特記事項_更新済のentityを渡すと_updateが実行される() {
            AfT122ZaigaiSenkyoShikakuEntity entity = sut.select(選挙人00001, 申請番号11);
            assertThat(entity.getTokkiJiko(),
                    is(new RString("テスト在外選挙資格999999999900001：申請番号999911")));

            entity.setTokkiJiko(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT122ZaigaiSenkyoShikakuEntity result = sut.select(選挙人00001, 申請番号11);
            assertThat(result.getTokkiJiko(), is(new RString("更新済")));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
        }

        @Test
        public void 選挙人00001_申請番号1から2_選挙人00002で複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT122ZaigaiSenkyoShikakuEntity> entities = new ArrayList<>();
            entities.add(create在外選挙資格(選挙人00001, 申請番号11));
            entities.add(create在外選挙資格(選挙人00001, 申請番号12));
            entities.add(create在外選挙資格(選挙人00002, 申請番号21));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号12));
        }

        @Test
        public void 選挙人00001_集所種類1のentityを指定した場合_deleteが成功し_1が返る() {
            AfT122ZaigaiSenkyoShikakuEntity entity = sut.select(選挙人00001, 申請番号11);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号12));
            sut.insertOrUpdate(create在外選挙資格(選挙人00002, 申請番号21));
        }

        @Test
        public void 選挙人00001を指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT122ZaigaiSenkyoShikakuEntity> entities = sut.select(選挙人00001);
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号12));
        }

        @Test
        public void 選挙人00001_集所種類1のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT122ZaigaiSenkyoShikakuEntity entity = sut.select(選挙人00001, 申請番号11);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号11));
            sut.insertOrUpdate(create在外選挙資格(選挙人00001, 申請番号12));
            sut.insertOrUpdate(create在外選挙資格(選挙人00002, 申請番号21));
        }

        @Test
        public void 選挙人00001を指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT122ZaigaiSenkyoShikakuEntity> entities = sut.select(選挙人00001);
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT122ZaigaiSenkyoShikakuEntity create在外選挙資格(ShikibetsuCode shikibetsuCode, int shinseiNo) {
        return AfT122ZaigaiSenkyoShikakuEntityGenerator.createAfT122ZaigaiSenkyoShikakuEntity(shikibetsuCode, shinseiNo);
    }

    private static void populate() {
        deleteTable(sut);
        sutOya.delete(sutOya.select());

        sutOya.insertOrUpdate(create在外申請情報(申請番号11, 選挙人00001));
        sutOya.insertOrUpdate(create在外申請情報(申請番号12, 選挙人00001));
        sutOya.insertOrUpdate(create在外申請情報(申請番号21, 選挙人00002));
    }

    private static AfT124ZaigaiSenkyoninShinseiEntity create在外申請情報(int shinseiNo, ShikibetsuCode shikibetsuCode) {
        return AfT124ZaigaiSenkyoninShinseiEntityGenerator.createAfT124ZaigaiSenkyoninShinseiEntity(shinseiNo, shikibetsuCode);
    }

    private static void deleteTable(AfT122ZaigaiSenkyoShikakuDac dac) {
        List<AfT122ZaigaiSenkyoShikakuEntity> list = dac.select();
        dac.delete(list);
    }

}
