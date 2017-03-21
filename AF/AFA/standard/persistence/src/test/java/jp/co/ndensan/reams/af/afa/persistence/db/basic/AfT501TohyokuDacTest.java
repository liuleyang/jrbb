/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT501TohyokuEntityGenerator;
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
 * {@link AfT501TohyokuDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT501TohyokuDacTest extends AfaTestDacBase {

    private static AfT501TohyokuDac sut;

    private static final Code 通常選挙 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    private static final Code 国民投票 = new Code(SenkyoShurui.憲法改正国民投票.getCode());
    private static final Code 農委選挙 = new Code(SenkyoShurui.農業委員会委員選挙.getCode());
    private static final Code 未存在選挙種類 = new Code("Z");

    private static final RString 投票区T001 = new RString("T001");
    private static final RString 投票区T002 = new RString("T002");
    private static final RString 投票区T003 = new RString("T003");
    private static final RString 投票区T004 = new RString("T004");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT501TohyokuDac.class);
    }

    public static class selectTest_SenkyoShurui_TohyokuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T002));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T003));
        }

        @Test
        public void 通常選挙の投票区T002を指定した場合_投票区名_1T002のエンティティを返す() {
            AfT501TohyokuEntity result = sut.select(通常選挙, 投票区T002);
            assertThat(result.getTohyokuName(), is(new RString("テスト投票区1T002")));
        }

        @Test
        public void 未登録の投票区を指定した場合_nullが返る() {
            AfT501TohyokuEntity result = sut.select(未存在選挙種類, 投票区T001);
            assertNull(result);
        }
    }

    public static class selectTest_SenkyoShurui extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T002));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T003));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T002));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T003));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T004));
            sut.insertOrUpdate(create投票区(国民投票, 投票区T001));
            sut.insertOrUpdate(create投票区(国民投票, 投票区T002));
        }

        @Test
        public void 通常選挙を指定した場合_3件返す() {
            List<AfT501TohyokuEntity> result = sut.select(通常選挙);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の選挙種類を指定した場合_EMPTY_LISTが返る() {
            List<AfT501TohyokuEntity> result = sut.select(未存在選挙種類);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(国民投票, 投票区T001));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT501TohyokuEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(国民投票, 投票区T001));
            sut.insertOrUpdate(create投票区(国民投票, 投票区T002));
        }

        @Test
        public void 国民投票の投票区T003のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create投票区(国民投票, 投票区T003));

            AfT501TohyokuEntity result = sut.select(国民投票, 投票区T003);
            assertNotNull(result);
            assertThat(result.getTohyokuName(), is(new RString("テスト投票区2T003")));
        }

        @Test
        public void 国民投票の投票区T001_投票区名称_更新済のentityを渡すと_updateが実行される() {
            AfT501TohyokuEntity entity = sut.select(国民投票, 投票区T001);
            assertThat(entity.getTohyokuName(), is(new RString("テスト投票区2T001")));

            entity.setTohyokuName(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT501TohyokuEntity result = sut.select(国民投票, 投票区T001);
            assertThat(result.getTohyokuName(), is(new RString(("更新済"))));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(国民投票, 投票区T001));
        }

        @Test
        public void 通常選挙の投票区T002_T003と国民投票の投票区T001の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT501TohyokuEntity> entities = new ArrayList<>();
            entities.add(create投票区(通常選挙, 投票区T002));
            entities.add(create投票区(通常選挙, 投票区T003));
            entities.add(create投票区(国民投票, 投票区T001));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
        }

        @Test
        public void 通常選挙の投票区T001のentityを指定した場合_deleteが成功し_1が返る() {
            AfT501TohyokuEntity entity = sut.select(通常選挙, 投票区T001);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T002));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T003));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T001));
        }

        @Test
        public void 通常選挙のentityを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT501TohyokuEntity> entities = sut.select(通常選挙);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
        }

        @Test
        public void 通常選挙の投票区T001のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT501TohyokuEntity entity = sut.select(通常選挙, 投票区T001);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T001));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T002));
            sut.insertOrUpdate(create投票区(通常選挙, 投票区T003));
            sut.insertOrUpdate(create投票区(農委選挙, 投票区T001));
        }

        @Test
        public void 通常選挙のentityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT501TohyokuEntity> entities = sut.select(通常選挙);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT501TohyokuEntity create投票区(Code senkyoShurui, RString tohyokuCode) {
        return AfT501TohyokuEntityGenerator.createAfT501TohyokuEntity(senkyoShurui, tohyokuCode);
    }

    private static void deleteTable(AfT501TohyokuDac dac) {
        List<AfT501TohyokuEntity> list = dac.select();
        dac.delete(list);
    }
}
