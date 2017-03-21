/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT510RyojikanEntityGenerator;
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
 * {@link AfT510RyojikanDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT510RyojikanDacTest extends AfaTestDacBase {

    private static AfT510RyojikanDac sut;

    private static final RString 領事官T11 = new RString("T11");
    private static final RString 領事官T22 = new RString("T22");
    private static final RString 領事官T33 = new RString("T33");
    private static final RString 領事官T44 = new RString("T44");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT510RyojikanDac.class);
    }

    public static class selectTest_RyojikanCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
            sut.insertOrUpdate(create領事官(領事官T22));
        }

        @Test
        public void 領事官T22を指定した場合_領事官名_テスト領事官T22のエンティティを返す() {
            AfT510RyojikanEntity result = sut.select(領事官T22);
            assertThat(result.getRyojikanName(), is(new RString("テスト領事官T22")));
        }

        @Test
        public void 未登録の領事官を指定した場合_nullが返る() {
            AfT510RyojikanEntity result = sut.select(領事官T44);
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
            sut.insertOrUpdate(create領事官(領事官T22));
            sut.insertOrUpdate(create領事官(領事官T33));
            sut.insertOrUpdate(create領事官(領事官T44));
        }

        @Test
        public void 引数なしで検索した場合_4件返す() {
            List<AfT510RyojikanEntity> result = sut.select();
            assertThat(result.size(), is(4));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
            sut.insertOrUpdate(create領事官(領事官T22));
        }

        @Test
        public void 領事官T33のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create領事官(領事官T33));

            AfT510RyojikanEntity result = sut.select(領事官T33);
            assertNotNull(result);
            assertThat(result.getRyojikanName(), is(new RString("テスト領事官T33")));
        }

        @Test
        public void 領事官T11_領事官名称_更新済のentityを渡すと_updateが実行される() {
            AfT510RyojikanEntity entity = sut.select(領事官T11);
            assertThat(entity.getRyojikanName(), is(new RString("テスト領事官T11")));

            entity.setRyojikanName(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT510RyojikanEntity result = sut.select(領事官T11);
            assertThat(result.getRyojikanName(), is(new RString("更新済")));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
        }

        @Test
        public void 領事官T22_T44で複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT510RyojikanEntity> entities = new ArrayList<>();
            entities.add(create領事官(領事官T22));
            entities.add(create領事官(領事官T33));
            entities.add(create領事官(領事官T44));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
        }

        @Test
        public void 領事官T11のentityを指定した場合_deleteが成功し_1が返る() {
            AfT510RyojikanEntity entity = sut.select(領事官T11);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
            sut.insertOrUpdate(create領事官(領事官T22));
            sut.insertOrUpdate(create領事官(領事官T33));
            sut.insertOrUpdate(create領事官(領事官T44));
        }

        @Test
        public void 全件を指定した場合_deleteが成功し_処理件数4件が返る() {
            List<AfT510RyojikanEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(4));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
        }

        @Test
        public void 領事官T11のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT510RyojikanEntity entity = sut.select(領事官T11);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create領事官(領事官T11));
            sut.insertOrUpdate(create領事官(領事官T22));
            sut.insertOrUpdate(create領事官(領事官T33));
            sut.insertOrUpdate(create領事官(領事官T44));
        }

        @Test
        public void 全件を指定した場合_deletePhysicalが成功し_処理件数4件が返る() {
            List<AfT510RyojikanEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(4));
        }
    }

    private static AfT510RyojikanEntity create領事官(RString ryojikanCode) {
        return AfT510RyojikanEntityGenerator.createAfT510RyojikanEntity(ryojikanCode);
    }

    private static void deleteTable(AfT510RyojikanDac dac) {
        List<AfT510RyojikanEntity> list = dac.select();
        dac.delete(list);
    }
}
