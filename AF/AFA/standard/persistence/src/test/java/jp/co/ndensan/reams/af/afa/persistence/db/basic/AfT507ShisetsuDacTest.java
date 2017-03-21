/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT507ShisetsuEntityGenerator;
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
 * {@link AfT507ShisetsuDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT507ShisetsuDacTest extends AfaTestDacBase {

    private static AfT507ShisetsuDac sut;

    private static final RString 施設T011 = new RString("T011");
    private static final RString 施設T022 = new RString("T022");
    private static final RString 施設T033 = new RString("T033");
    private static final RString 施設T044 = new RString("T044");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT507ShisetsuDac.class);
    }

    public static class selectTest_ShisetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
            sut.insertOrUpdate(create施設(施設T022));
        }

        @Test
        public void 施設コード_T022を指定した場合_施設名_テスト施設T022のエンティティを返す() {
            AfT507ShisetsuEntity result = sut.select(施設T022);
            assertThat(result.getShisetsuName(), is(new RString("テスト施設T022")));
        }

        @Test
        public void 未登録の施設コードを指定した場合_nullが返る() {
            AfT507ShisetsuEntity result = sut.select(施設T044);
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
            sut.insertOrUpdate(create施設(施設T022));
            sut.insertOrUpdate(create施設(施設T033));
            sut.insertOrUpdate(create施設(施設T044));
        }

        @Test
        public void 引数なしで検索した場合_4件返す() {
            List<AfT507ShisetsuEntity> result = sut.select();
            assertThat(result.size(), is(4));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
            sut.insertOrUpdate(create施設(施設T022));
        }

        @Test
        public void 施設コード_T033のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create施設(施設T033));

            AfT507ShisetsuEntity result = sut.select(施設T033);
            assertNotNull(result);
            assertThat(result.getShisetsuName(), is(new RString("テスト施設T033")));
        }

        @Test
        public void 施設コード_T011_施設名称_更新済のentityを渡すと_updateが実行される() {
            AfT507ShisetsuEntity entity = sut.select(施設T011);
            assertThat(entity.getShisetsuName(), is(new RString("テスト施設T011")));

            entity.setShisetsuName(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT507ShisetsuEntity result = sut.select(施設T011);
            assertThat(result.getShisetsuName(), is(new RString(("更新済"))));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
        }

        @Test
        public void 施設コード_T022_T044で複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT507ShisetsuEntity> entities = new ArrayList<>();
            entities.add(create施設(施設T022));
            entities.add(create施設(施設T033));
            entities.add(create施設(施設T044));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
        }

        @Test
        public void 施設コード_T011のentityを指定した場合_deleteが成功し_1が返る() {
            AfT507ShisetsuEntity entity = sut.select(施設T011);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
            sut.insertOrUpdate(create施設(施設T022));
            sut.insertOrUpdate(create施設(施設T033));
            sut.insertOrUpdate(create施設(施設T044));
        }

        @Test
        public void 全件を指定した場合_deleteが成功し_処理件数4件が返る() {
            List<AfT507ShisetsuEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(4));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
        }

        @Test
        public void 施設コード_T011のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT507ShisetsuEntity entity = sut.select(施設T011);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
            sut.insertOrUpdate(create施設(施設T022));
            sut.insertOrUpdate(create施設(施設T033));
            sut.insertOrUpdate(create施設(施設T044));
        }

        @Test
        public void 全件を指定した場合_deletePhysicalが成功し_処理件数4件が返る() {
            List<AfT507ShisetsuEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(4));
        }
    }

    public static class existTest_ShisetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create施設(施設T011));
            sut.insertOrUpdate(create施設(施設T022));
        }

        @Test
        public void 施設コード_T022を指定した場合_trueを返す() {
            boolean result = sut.exists(施設T022);
            assertThat(result, is(Boolean.TRUE));
        }

        @Test
        public void 未登録の施設コードを指定した場合_falseが返る() {
            boolean result = sut.exists(施設T044);
            assertThat(result, is(Boolean.FALSE));
        }
    }

    private static AfT507ShisetsuEntity create施設(RString shisetsuCode) {
        return AfT507ShisetsuEntityGenerator.createAfT507ShisetsuEntity(shisetsuCode);
    }

    private static void deleteTable(AfT507ShisetsuDac dac) {
        List<AfT507ShisetsuEntity> list = dac.select();
        dac.delete(list);
    }
}
