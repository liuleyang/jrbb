/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT100ShohonEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link AfT100ShohonDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT100ShohonDacTest extends AfaTestDacBase {

    private static AfT100ShohonDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(9991);
    private static final ShohonNo 抄本9992 = new ShohonNo(9992);
    private static final ShohonNo 抄本9999 = new ShohonNo(9999);
    private static final ShohonNo 抄本9910001 = new ShohonNo(9910001);
    private static final ShohonNo 抄本9910002 = new ShohonNo(9910002);

    private static final Code 定時登録 = new Code(SenkyoShurui.定時登録.getCode());
    private static final Code 通常選挙 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    private static final Code 国民投票 = new Code(SenkyoShurui.憲法改正国民投票.getCode());
    private static final Code 未存在選挙種類 = new Code("Z");

    private static final FlexibleDate 投票日1 = new FlexibleDate("20141214");
    private static final FlexibleDate 投票日2 = new FlexibleDate("20130601");
    private static final FlexibleDate 投票日3 = new FlexibleDate("20150808");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT100ShohonDac.class);
    }

    public static class selectTest_shohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9992, 国民投票));
            sut.insertOrUpdate(create抄本(抄本9910001, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910002, 定時登録));
        }

        @Test
        public void 抄本番号_9991を指定した場合_抄本名_テスト抄本1のエンティティを返す() {
            AfT100ShohonEntity result = sut.select(抄本9991);
            assertThat(result.getShohonName(), is(new RString("テスト抄本9991")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT100ShohonEntity result = sut.select(抄本9999);
            assertNull(result);
        }
    }

    public static class selectTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9992, 国民投票));
            sut.insertOrUpdate(create抄本(抄本9910001, 通常選挙));
        }

        @Test
        public void selectを呼びだした場合_抄本エンティティ_3件を返す() {
            List<AfT100ShohonEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class selectTest_SenkyoShurui extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9992, 国民投票));
            sut.insertOrUpdate(create抄本(抄本9999, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910001, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910002, 定時登録));
        }

        @Test
        public void 本番_選挙種類_通常選挙を指定した場合_2件返る() {
            List<AfT100ShohonEntity> result = sut.select(通常選挙);
            assertThat(result.size(), is(2));
        }

        @Test
        public void シミュレーション_選挙種類_通常選挙を指定した場合_1件返る() {
            List<AfT100ShohonEntity> result = sut.selectForSimulation(通常選挙);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 存在しない選挙種類を指定した場合_EMPTY_LISTが返る() {
            List<AfT100ShohonEntity> result = sut.select(未存在選挙種類);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_KijunYmd extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本with投票日(抄本9991, 通常選挙, 投票日1));
            sut.insertOrUpdate(create抄本with投票日(抄本9992, 通常選挙, 投票日2));
            sut.insertOrUpdate(create抄本with投票日(抄本9999, 通常選挙, 投票日3));
            sut.insertOrUpdate(create抄本with投票日(抄本9910001, 通常選挙, 投票日1));
            sut.insertOrUpdate(create抄本with投票日(抄本9910002, 通常選挙, 投票日2));
        }

        @Test
        public void 本番_基準日_20141103_を指定した場合_2件返る() {
            List<AfT100ShohonEntity> result = sut.select(new FlexibleDate("20141103"));
            assertThat(result.size(), is(2));
        }

        @Test
        public void 本番_基準日_20150401_を指定した場合_1件返る() {
            List<AfT100ShohonEntity> result = sut.select(new FlexibleDate("20150401"));
            assertThat(result.size(), is(1));
        }

        @Test
        public void シミュレーション_基準日_20141103_を指定した場合_2件返る() {
            List<AfT100ShohonEntity> result = sut.selectForSimulation(new FlexibleDate("20141103"));
            assertThat(result.size(), is(1));
        }

        @Test
        public void シミュレーション_基準日_20150401_を指定した場合_0件返る() {
            List<AfT100ShohonEntity> result = sut.selectForSimulation(new FlexibleDate("20150401"));
            assertThat(result.size(), is(0));
        }

        @Test
        public void 本番_選挙が存在しない未来日を指定した場合_EMPTY_LISTが返る() {
            List<AfT100ShohonEntity> result = sut.select(FlexibleDate.MAX);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void シミュレーション_選挙が存在しない未来日を指定した場合_EMPTY_LISTが返る() {
            List<AfT100ShohonEntity> result = sut.selectForSimulation(FlexibleDate.MAX);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 本番_空白日を指定した場合_3件返る() {
            List<AfT100ShohonEntity> result = sut.select(FlexibleDate.EMPTY);
            assertThat(result.size(), is(3));
        }

        @Test
        public void シミュレーション_空白日を指定した場合_3件返る() {
            sut.insertOrUpdate(create抄本with投票日(new ShohonNo(9910009), 通常選挙, FlexibleDate.EMPTY));
            List<AfT100ShohonEntity> result = sut.selectForSimulation(FlexibleDate.EMPTY);
            assertThat(result.size(), is(3));

            List<AfT100ShohonEntity> result1 = sut.selectForSimulation(FlexibleDate.MIN);
            assertThat(result1.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
        }

        @Test
        public void 抄本番号_9992のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create抄本(抄本9992, 国民投票));

            AfT100ShohonEntity result = sut.select(抄本9992);
            assertNotNull(result);
            assertThat(result.getShohonName(), is(new RString("テスト抄本9992")));
        }

        @Test
        public void 抄本番号_9991_通常選挙のentityを渡すと_updateが実行される() {
            AfT100ShohonEntity entity = create抄本(抄本9991, 定時登録);
            sut.insertOrUpdate(entity);

            AfT100ShohonEntity result = sut.select(抄本9991);
            assertThat(result.getShohonName(), is(new RString("テスト抄本9991")));
            assertThat(result.getSenkyoShurui(), is(定時登録));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
        }

        @Test
        public void 抄本番号_9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT100ShohonEntity entity = sut.select(抄本9991);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9992, 国民投票));
            sut.insertOrUpdate(create抄本(抄本9999, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910001, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910002, 定時登録));
        }

        @Test
        public void 本番_選挙種類_通常選挙のentityを指定した場合_deleteが成功し_削除件数_2が返る() {
            List<AfT100ShohonEntity> entities = sut.select(通常選挙);
            assertThat(sut.delete(entities), is(2));
        }

        @Test
        public void シミュレーション_選挙種類_通常選挙のentityを指定した場合_deleteが成功し_削除件数_1が返る() {
            List<AfT100ShohonEntity> entities = sut.selectForSimulation(通常選挙);
            assertThat(sut.delete(entities), is(1));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
        }

        @Test
        public void 抄本番号_9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT100ShohonEntity entity = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create抄本(抄本9991, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9992, 国民投票));
            sut.insertOrUpdate(create抄本(抄本9999, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910001, 通常選挙));
            sut.insertOrUpdate(create抄本(抄本9910002, 定時登録));
        }

        @Test
        public void 本番_選挙種類_通常選挙のentityを指定した場合_deletePhysicalが成功し_削除件数_2が返る() {
            List<AfT100ShohonEntity> entities = sut.select(通常選挙);
            assertThat(sut.deletePhysical(entities), is(2));
        }

        @Test
        public void シミュレーション_選挙種類_通常選挙のentityを指定した場合_deleteが成功し_削除件数_1が返る() {
            List<AfT100ShohonEntity> entities = sut.selectForSimulation(通常選挙);
            assertThat(sut.delete(entities), is(1));
        }
    }

    private static AfT100ShohonEntity create抄本(ShohonNo shohonNo, Code senkyoShurui) {
        return AfT100ShohonEntityGenerator.createAfT100ShohonEntity(shohonNo, senkyoShurui);
    }

    private static AfT100ShohonEntity create抄本with投票日(ShohonNo shohonNo, Code senkyoShurui, FlexibleDate tohyoYmd) {
        return AfT100ShohonEntityGenerator.createAfT100ShohonEntity(shohonNo, senkyoShurui, tohyoYmd);
    }

    private static void deleteTable(AfT100ShohonDac dac) {
        List<AfT100ShohonEntity> list = dac.select();
        dac.delete(list);
    }
}
