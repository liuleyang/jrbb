/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT250UketsukeNoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT250UketsukeNoEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * {@link AfT250UketsukeNoDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT250UketsukeNoDacTest extends AfaTestDacBase {

    private static AfT250UketsukeNoDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(9991);
    private static final ShohonNo 抄本9992 = new ShohonNo(9992);
    private static final ShohonNo 抄本9999 = new ShohonNo(9999);

    private static final Code 期日前 = new Code(TohyoJokyo.期日前.getCode());
    private static final Code 不在者 = new Code(TohyoJokyo.受理.getCode());

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT250UketsukeNoDac.class);
    }

    public static class selectTest_shohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9992, 期日前));
        }

        @Test
        public void 抄本番号9991を指定した場合_番号9991のエンティティを返す() {
            AfT250UketsukeNoEntity result = sut.select(抄本9991, new Code("1"), RString.EMPTY, 期日前);
            assertThat(result.getCurrentNumber(), is(9991L));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT250UketsukeNoEntity result = sut.select(抄本9999, new Code("1"), RString.EMPTY, 期日前);
            assertNull(result);
        }
    }

    public static class selectTest_SenkyoShurui extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9991, 不在者));
            sut.insertOrUpdate(create受付番号(抄本9992, 期日前));
        }

        @Test
        public void 抄本番号9991を指定した場合_2件返る() {
            List<AfT250UketsukeNoEntity> result = sut.select(抄本9991);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 存在しない抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT250UketsukeNoEntity> result = sut.select(抄本9999);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9992, 期日前));
        }

        @Test
        public void selectした場合_2件返る() {
            List<AfT250UketsukeNoEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
        }

        @Test
        public void 抄本番号9992のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create受付番号(抄本9992, 期日前));

            AfT250UketsukeNoEntity result = sut.select(抄本9992, new Code("1"), RString.EMPTY, 期日前);
            assertNotNull(result);
            assertThat(result.getCurrentNumber(), is(9992L));
        }

        @Test
        public void 抄本番号9991_期日前のentityを渡すと_updateが実行される() {
            AfT250UketsukeNoEntity entity = create受付番号(抄本9991, 期日前);
            assertThat(entity.getCurrentNumber(), is(9991L));

            entity.setCurrentNumber(9900099L);
            sut.insertOrUpdate(entity);

            AfT250UketsukeNoEntity result = sut.select(抄本9991, new Code("1"), RString.EMPTY, 期日前);
            assertThat(result.getCurrentNumber(), is(9900099L));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
        }

        @Test
        public void 抄本番号_9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT250UketsukeNoEntity entity = sut.select(抄本9991, new Code("1"), RString.EMPTY, 期日前);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9991, 不在者));
            sut.insertOrUpdate(create受付番号(抄本9992, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9992, 不在者));
        }

        @Test
        public void 抄本9991のentityを指定した場合_deleteが成功し_削除件数_2が返る() {
            List<AfT250UketsukeNoEntity> entities = sut.select(抄本9991);
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
        }

        @Test
        public void 抄本番号_9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT250UketsukeNoEntity entity = sut.select(抄本9991, new Code("1"), RString.EMPTY, 期日前);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create受付番号(抄本9991, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9991, 不在者));
            sut.insertOrUpdate(create受付番号(抄本9992, 期日前));
            sut.insertOrUpdate(create受付番号(抄本9992, 不在者));
        }

        @Test
        public void 抄本9991のentityを指定した場合_deletePhysicalが成功し_削除件数_2が返る() {
            List<AfT250UketsukeNoEntity> entities = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT250UketsukeNoEntity create受付番号(ShohonNo shohonNo, Code kijitsuFuzaiKbn) {
        return AfT250UketsukeNoEntityGenerator.createAfT250UketsukeNoEntity(shohonNo, kijitsuFuzaiKbn);
    }

    private static void deleteTable(AfT250UketsukeNoDac dac) {
        List<AfT250UketsukeNoEntity> list = dac.select();
        dac.delete(list);
    }
}
