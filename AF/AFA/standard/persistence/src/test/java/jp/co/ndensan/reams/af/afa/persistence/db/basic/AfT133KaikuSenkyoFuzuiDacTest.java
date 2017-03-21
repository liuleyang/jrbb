/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT133KaikuSenkyoFuzuiEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
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
 * {@link AfT133KaikuSenkyoFuzuiDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT133KaikuSenkyoFuzuiDacTest extends AfaTestDacBase {

    private static AfT133KaikuSenkyoFuzuiDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本9992 = new ShohonNo(999992);

    private static final ShikibetsuCode 選挙人00001 = new ShikibetsuCode("999999999900001");
    private static final ShikibetsuCode 選挙人00002 = new ShikibetsuCode("999999999900002");
    private static final ShikibetsuCode 選挙人00003 = new ShikibetsuCode("999999999900003");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT133KaikuSenkyoFuzuiDac.class);
    }

    public static class selectTest_ShohonNo_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00002));
        }

        @Test
        public void 抄本番号9991_選挙人00001を指定した場合_農家番号_9999900001のエンティティを返す() {
            AfT133KaikuSenkyoFuzuiEntity result = sut.select(抄本9991, 選挙人00001);
            assertThat(result.getGyogyoshaNo(), is(new RString("9999900001")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT133KaikuSenkyoFuzuiEntity result = sut.select(new ShohonNo(9999), 選挙人00001);
            assertNull(result);
        }
    }

    public static class selectTest_shohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00002));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00003));
            sut.insertOrUpdate(create海区付随(抄本9992, 選挙人00001));
        }

        @Test
        public void 抄本番号_9991_を指定した場合_3件返る() {
            List<AfT133KaikuSenkyoFuzuiEntity> result = sut.select(抄本9991);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT133KaikuSenkyoFuzuiEntity> result = sut.select(new ShohonNo(9999));
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00002));
            sut.insertOrUpdate(create海区付随(抄本9992, 選挙人00001));
        }

        @Test
        public void selectした場合_3件返る() {
            List<AfT133KaikuSenkyoFuzuiEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
        }

        @Test
        public void 抄本番号9991_選挙人00002のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00002));

            AfT133KaikuSenkyoFuzuiEntity result = sut.select(抄本9991, 選挙人00002);
            assertNotNull(result);
            assertThat(result.getGyogyoshaNo(), is(new RString("9999900002")));
        }

        @Test
        public void 抄本番号9991_選挙人000001_農家番号12345のentityを渡すと_updateが実行される() {
            AfT133KaikuSenkyoFuzuiEntity entity = sut.select(抄本9991, 選挙人00001);
            assertThat(entity.getGyogyoshaNo(), is(new RString("9999900001")));

            entity.setGyogyoshaNo(new RString("12345"));
            sut.insertOrUpdate(entity);

            AfT133KaikuSenkyoFuzuiEntity result = sut.select(抄本9991, 選挙人00001);
            assertThat(result.getGyogyoshaNo(), is(new RString("12345")));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
        }

        @Test
        public void 抄本番号9991_選挙人00001のentityを指定した場合_deleteが成功し_1が返る() {
            AfT133KaikuSenkyoFuzuiEntity entity = sut.select(抄本9991, 選挙人00001);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00002));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00003));
            sut.insertOrUpdate(create海区付随(抄本9992, 選挙人00001));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT133KaikuSenkyoFuzuiEntity> entities = sut.select(抄本9991);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
        }

        @Test
        public void 抄本番号9991_選挙人00001のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT133KaikuSenkyoFuzuiEntity entity = sut.select(抄本9991, 選挙人00001);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00001));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00002));
            sut.insertOrUpdate(create海区付随(抄本9991, 選挙人00003));
            sut.insertOrUpdate(create海区付随(抄本9992, 選挙人00001));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT133KaikuSenkyoFuzuiEntity> entities = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT133KaikuSenkyoFuzuiEntity create海区付随(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        return AfT133KaikuSenkyoFuzuiEntityGenerator.createAfT133KaikuSenkyoFuzuiEntity(shohonNo, shikibetsuCode);
    }

    private static void deleteTable(AfT133KaikuSenkyoFuzuiDac dac) {
        List<AfT133KaikuSenkyoFuzuiEntity> list = dac.select();
        dac.delete(list);
    }
}
