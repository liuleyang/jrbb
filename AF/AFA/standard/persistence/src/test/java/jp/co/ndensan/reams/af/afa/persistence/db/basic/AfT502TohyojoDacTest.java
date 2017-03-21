/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT502TohyojoEntityGenerator;
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
 * {@link AfT502TohyojoDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT502TohyojoDacTest extends AfaTestDacBase {

    private static AfT502TohyojoDac sut;

    private static final RString 投票所T111 = new RString("T111");
    private static final RString 投票所T222 = new RString("T222");
    private static final RString 投票所T333 = new RString("T333");
    private static final RString 投票所T444 = new RString("T444");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT502TohyojoDac.class);
    }

    public static class selectTest_TohyojoCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
            sut.insertOrUpdate(create投票所(投票所T222));
        }

        @Test
        public void 投票所T222を指定した場合_投票所名_テスト投票所T222のエンティティを返す() {
            AfT502TohyojoEntity result = sut.select(投票所T222);
            assertThat(result.getTohyojoName(), is(new RString("テスト投票所T222")));
        }

        @Test
        public void 未登録の投票所を指定した場合_nullが返る() {
            AfT502TohyojoEntity result = sut.select(投票所T444);
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
            sut.insertOrUpdate(create投票所(投票所T222));
            sut.insertOrUpdate(create投票所(投票所T333));
            sut.insertOrUpdate(create投票所(投票所T444));
        }

        @Test
        public void 引数なしで検索した場合_4件返す() {
            List<AfT502TohyojoEntity> result = sut.select();
            assertThat(result.size(), is(4));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
            sut.insertOrUpdate(create投票所(投票所T222));
        }

        @Test
        public void 投票所T333のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create投票所(投票所T333));

            AfT502TohyojoEntity result = sut.select(投票所T333);
            assertNotNull(result);
            assertThat(result.getTohyojoName(), is(new RString("テスト投票所T333")));
        }

        @Test
        public void 投票所T111_投票所名称_更新済のentityを渡すと_updateが実行される() {
            AfT502TohyojoEntity entity = sut.select(投票所T111);
            assertThat(entity.getTohyojoName(), is(new RString("テスト投票所T111")));

            entity.setTohyojoName(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT502TohyojoEntity result = sut.select(投票所T111);
            assertThat(result.getTohyojoName(), is(new RString(("更新済"))));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
        }

        @Test
        public void 投票所T222_T444で複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT502TohyojoEntity> entities = new ArrayList<>();
            entities.add(create投票所(投票所T222));
            entities.add(create投票所(投票所T333));
            entities.add(create投票所(投票所T444));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
        }

        @Test
        public void 投票所T111のentityを指定した場合_deleteが成功し_1が返る() {
            AfT502TohyojoEntity entity = sut.select(投票所T111);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
            sut.insertOrUpdate(create投票所(投票所T222));
            sut.insertOrUpdate(create投票所(投票所T333));
            sut.insertOrUpdate(create投票所(投票所T444));
        }

        @Test
        public void 全件を指定した場合_deleteが成功し_処理件数4件が返る() {
            List<AfT502TohyojoEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(4));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
        }

        @Test
        public void 投票所T111のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT502TohyojoEntity entity = sut.select(投票所T111);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票所(投票所T111));
            sut.insertOrUpdate(create投票所(投票所T222));
            sut.insertOrUpdate(create投票所(投票所T333));
            sut.insertOrUpdate(create投票所(投票所T444));
        }

        @Test
        public void 全件を指定した場合_deletePhysicalが成功し_処理件数4件が返る() {
            List<AfT502TohyojoEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(4));
        }
    }

    private static AfT502TohyojoEntity create投票所(RString tohyojoCode) {
        return AfT502TohyojoEntityGenerator.createAfT502TohyojoEntity(tohyojoCode);
    }

    private static void deleteTable(AfT502TohyojoDac dac) {
        List<AfT502TohyojoEntity> list = dac.select();
        dac.delete(list);
    }
}
