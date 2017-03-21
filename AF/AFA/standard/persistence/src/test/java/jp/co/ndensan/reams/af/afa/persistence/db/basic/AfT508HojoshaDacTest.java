/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508HojoshaEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT508HojoshaEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT508HojoshaDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT508HojoshaDacTest extends AfaTestDacBase {

    private static AfT508HojoshaDac sut;

    private static final ShohonNo 抄本番号9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本番号9992 = new ShohonNo(999992);

    private static final ShikibetsuCode 補助者00001 = new ShikibetsuCode("999999999900001");
    private static final ShikibetsuCode 補助者00002 = new ShikibetsuCode("999999999900002");
    private static final ShikibetsuCode 補助者00003 = new ShikibetsuCode("999999999900003");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT508HojoshaDac.class);
    }

    public static class selectTest_ShohonNo_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00002));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00003));
        }

        @Test
        public void 抄本番号9991_補助者00002を指定した場合_補助者のエンティティを返す() {
            AfT508HojoshaEntity result = sut.select(抄本番号9991, 補助者00002);
            assertThat(result.getShikibetsuCode(), is(new ShikibetsuCode("999999999900002")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT508HojoshaEntity result = sut.select(new ShohonNo(9999), 補助者00002);
            assertNull(result);
        }
    }

    public static class selectTest_ShohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00002));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00003));
            sut.insertOrUpdate(create補助者(抄本番号9992, 補助者00001));
        }

        @Test
        public void 抄本番号9991を指定した場合_3件返す() {
            List<AfT508HojoshaEntity> result = sut.select(抄本番号9991);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT508HojoshaEntity> result = sut.select(new ShohonNo(9999));
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00002));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00003));
            sut.insertOrUpdate(create補助者(抄本番号9992, 補助者00001));
        }

        @Test
        public void selectした場合_4件返す() {
            List<AfT508HojoshaEntity> result = sut.select();
            assertThat(result.size(), is(4));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00002));
        }

        @Test
        public void 抄本番号9991の補助者00003のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00003));

            AfT508HojoshaEntity result = sut.select(抄本番号9991, 補助者00003);
            assertNotNull(result);
            assertThat(result.getShikibetsuCode(), is(new ShikibetsuCode("999999999900003")));
        }

        @Test
        public void 抄本番号9991の補助者00001_投票所_999のentityを渡すと_updateが実行される() {
            AfT508HojoshaEntity entity = sut.select(抄本番号9991, 補助者00001);
            assertThat(entity.getTohyojoCode(), is(RString.EMPTY));

            entity.setTohyojoCode(new RString("999"));
            sut.insertOrUpdate(entity);

            AfT508HojoshaEntity result = sut.select(抄本番号9991, 補助者00001);
            assertThat(result.getTohyojoCode(), is(new RString("999")));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9992, 補助者00001));
        }

        @Test
        public void 抄本番号9991の補助者_00002_00003と抄本番号9992の補助者_00001の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT508HojoshaEntity> entities = new ArrayList<>();
            entities.add(create補助者(抄本番号9991, 補助者00002));
            entities.add(create補助者(抄本番号9991, 補助者00003));
            entities.add(create補助者(抄本番号9992, 補助者00001));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
        }

        @Test
        public void 抄本番号9991の補助者00001のentityを指定した場合_deleteが成功し_1が返る() {
            AfT508HojoshaEntity entity = sut.select(抄本番号9991, 補助者00001);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00002));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00003));
            sut.insertOrUpdate(create補助者(抄本番号9992, 補助者00001));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT508HojoshaEntity> entities = sut.select(抄本番号9991);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
        }

        @Test
        public void 抄本番号9991の補助者00001のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT508HojoshaEntity entity = sut.select(抄本番号9991, 補助者00001);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00001));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00002));
            sut.insertOrUpdate(create補助者(抄本番号9991, 補助者00003));
            sut.insertOrUpdate(create補助者(抄本番号9992, 補助者00001));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT508HojoshaEntity> entities = sut.select(抄本番号9991);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT508HojoshaEntity create補助者(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        return AfT508HojoshaEntityGenerator.createAfT508HojoshaEntity(shohonNo, shikibetsuCode);
    }

    private static void deleteTable(AfT508HojoshaDac dac) {
        List<AfT508HojoshaEntity> list = dac.select();
        dac.delete(list);
    }
}
