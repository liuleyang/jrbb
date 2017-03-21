/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT509KumiaiEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
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
 * {@link AfT509KumiaiDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT509KumiaiDacTest extends AfaTestDacBase {

    private static AfT509KumiaiDac sut;

    private static final RString 組合T001 = new RString("T999001");
    private static final RString 組合T002 = new RString("T999002");
    private static final RString 組合T003 = new RString("T999003");
    private static final RString 組合T004 = new RString("T999004");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT509KumiaiDac.class);
    }

    public static class selectTest_SenkyoShurui_KumiaiCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
            sut.insertOrUpdate(create組合(組合T002));
            sut.insertOrUpdate(create組合(組合T003));
        }

        @Test
        public void 組合T002を指定した場合_組合名_テスト組合1T999002のエンティティを返す() {
            AfT509KumiaiEntity result = sut.select(組合T002);
            assertThat(result.getKumiaiName(), is(new RString("テスト組合T999002")));
        }

        @Test
        public void 未登録の組合を指定した場合_nullが返る() {
            AfT509KumiaiEntity result = sut.select(組合T004);
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
            sut.insertOrUpdate(create組合(組合T002));
            sut.insertOrUpdate(create組合(組合T003));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT509KumiaiEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
            sut.insertOrUpdate(create組合(組合T002));
        }

        @Test
        public void 組合T003のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create組合(組合T003));

            AfT509KumiaiEntity result = sut.select(組合T003);
            assertNotNull(result);
            assertThat(result.getKumiaiName(), is(new RString("テスト組合T999003")));
        }

        @Test
        public void 国民投票の組合T001_組合名称_更新済のentityを渡すと_updateが実行される() {
            AfT509KumiaiEntity entity = sut.select(組合T001);
            entity.setKumiaiName(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT509KumiaiEntity result = sut.select(組合T001);
            assertThat(result.getKumiaiCode(), is(組合T001));
            assertThat(result.getKumiaiName(), is(new RString(("更新済"))));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
        }

        @Test
        public void 組合T002_T003の複数件数Listを指定した場合_処理件数2件が返る() {
            List<AfT509KumiaiEntity> entities = new ArrayList<>();
            entities.add(create組合(組合T002));
            entities.add(create組合(組合T003));

            assertThat(sut.insertOrUpdate(entities), is(2));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
        }

        @Test
        public void 組合T001のentityを指定した場合_deleteが成功し_1が返る() {
            AfT509KumiaiEntity entity = sut.select(組合T001);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
            sut.insertOrUpdate(create組合(組合T002));
            sut.insertOrUpdate(create組合(組合T003));
        }

        @Test
        public void entityを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT509KumiaiEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
        }

        @Test
        public void 組合T001のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT509KumiaiEntity entity = sut.select(組合T001);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create組合(組合T001));
            sut.insertOrUpdate(create組合(組合T002));
            sut.insertOrUpdate(create組合(組合T003));
        }

        @Test
        public void entityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT509KumiaiEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT509KumiaiEntity create組合(RString kumiaiCode) {
        return AfT509KumiaiEntityGenerator.createAfT509KumiaiEntity(kumiaiCode);
    }

    private static void deleteTable(AfT509KumiaiDac dac) {
        List<AfT509KumiaiEntity> list = dac.select();
        dac.delete(list);
    }
}
