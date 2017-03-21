/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT124ZaigaiSenkyoninShinseiEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT124ZaigaiSenkyoninShinseiDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT124ZaigaiSenkyoninShinseiDacTest extends AfaTestDacBase {

    private static AfT124ZaigaiSenkyoninShinseiDac sut;

    private static final int 申請番号1 = 999991;
    private static final int 申請番号2 = 999992;
    private static final int 申請番号3 = 999993;
    private static final int 申請番号9 = 999999;

    private static final ShikibetsuCode 選挙人00001 = new ShikibetsuCode("999999999900001");
    private static final ShikibetsuCode 選挙人00002 = new ShikibetsuCode("999999999900002");
    private static final ShikibetsuCode 選挙人00003 = new ShikibetsuCode("999999999900003");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT124ZaigaiSenkyoninShinseiDac.class);
    }

    public static class selectTest_ShinseiNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00002));
        }

        @Test
        public void 申請番号1を指定した場合_特記事項_テスト在外選挙人申請情報999991_識別コード999999999900001のエンティティを返す() {
            AfT124ZaigaiSenkyoninShinseiEntity result = sut.select(申請番号1);
            assertThat(result.getTokkiJiko(),
                    is(new RString("テスト在外選挙人申請情報999991：識別コード999999999900001")));
        }

        @Test
        public void 未登録の申請番号を指定した場合_nullが返る() {
            AfT124ZaigaiSenkyoninShinseiEntity result = sut.select(申請番号9);
            assertNull(result);
        }
    }

    public static class selectTest_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号3, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号9, 選挙人00002));
        }

        @Test
        public void 選挙人00001を指定した場合_3件返す() {
            List<AfT124ZaigaiSenkyoninShinseiEntity> result = sut.select(選挙人00001);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の選挙人を指定した場合_EMPTY_LISTが返る() {
            List<AfT124ZaigaiSenkyoninShinseiEntity> result = sut.select(選挙人00003);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号9, 選挙人00002));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT124ZaigaiSenkyoninShinseiEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
        }

        @Test
        public void 申請番号2のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));

            AfT124ZaigaiSenkyoninShinseiEntity result = sut.select(申請番号2);
            assertNotNull(result);
            assertThat(result.getTokkiJiko(),
                    is(new RString("テスト在外選挙人申請情報999992：識別コード999999999900001")));
        }

        @Test
        public void 申請番号1_選挙人00001_特記事項_更新済のentityを渡すと_updateが実行される() {
            AfT124ZaigaiSenkyoninShinseiEntity entity = sut.select(申請番号1);
            assertThat(entity.getTokkiJiko(),
                    is(new RString("テスト在外選挙人申請情報999991：識別コード999999999900001")));

            entity.setTokkiJiko(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT124ZaigaiSenkyoninShinseiEntity result = sut.select(申請番号1);
            assertThat(result.getTokkiJiko(), is(new RString("更新済")));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
        }

        @Test
        public void 申請番号2から3で複数件数Listを指定した場合_処理件数2件が返る() {
            List<AfT124ZaigaiSenkyoninShinseiEntity> entities = new ArrayList<>();
            entities.add(create在外申請情報(申請番号2, 選挙人00002));
            entities.add(create在外申請情報(申請番号3, 選挙人00003));

            assertThat(sut.insertOrUpdate(entities), is(2));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
        }

        @Test
        public void 申請番号00001のentityを指定した場合_deleteが成功し_1が返る() {
            AfT124ZaigaiSenkyoninShinseiEntity entity = sut.select(申請番号1);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号3, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号9, 選挙人00002));
        }

        @Test
        public void 選挙人00001を指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT124ZaigaiSenkyoninShinseiEntity> entities = sut.select(選挙人00001);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
        }

        @Test
        public void 申請番号00001のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT124ZaigaiSenkyoninShinseiEntity entity = sut.select(申請番号1);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            sut.insertOrUpdate(create在外申請情報(申請番号1, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号2, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号3, 選挙人00001));
            sut.insertOrUpdate(create在外申請情報(申請番号9, 選挙人00002));
        }

        @Test
        public void 選挙人00001を指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT124ZaigaiSenkyoninShinseiEntity> entities = sut.select(選挙人00001);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT124ZaigaiSenkyoninShinseiEntity create在外申請情報(int shinseiNo, ShikibetsuCode shikibetsuCode) {
        return AfT124ZaigaiSenkyoninShinseiEntityGenerator.createAfT124ZaigaiSenkyoninShinseiEntity(shinseiNo, shikibetsuCode);
    }

    private static void deleteTable(AfT124ZaigaiSenkyoninShinseiDac dac) {
        List<AfT124ZaigaiSenkyoninShinseiEntity> list = dac.select();
        dac.delete(list);
    }
}
