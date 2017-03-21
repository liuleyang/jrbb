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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT503SenkyokuEntityGenerator;
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
 * {@link AfT503SenkyokuDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT503SenkyokuDacTest extends AfaTestDacBase {

    private static AfT503SenkyokuDac sut;

    private static final Code 通常選挙 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    private static final Code 国民投票 = new Code(SenkyoShurui.憲法改正国民投票.getCode());
    private static final Code 農委選挙 = new Code(SenkyoShurui.農業委員会委員選挙.getCode());
    private static final Code 未存在選挙種類 = new Code("Z");

    private static final RString 選挙区T991 = new RString("T991");
    private static final RString 選挙区T992 = new RString("T992");
    private static final RString 選挙区T993 = new RString("T993");
    private static final RString 選挙区T994 = new RString("T994");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT503SenkyokuDac.class);
    }

    public static class selectTest_SenkyoShurui_SenkyokuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T992));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T993));
        }

        @Test
        public void 通常選挙の選挙区T992を指定した場合_選挙区名_テスト選挙区1T992のエンティティを返す() {
            AfT503SenkyokuEntity result = sut.select(通常選挙, 選挙区T992);
            assertThat(result.getSenkyokuName(), is(new RString("テスト選挙区1T992")));
        }

        @Test
        public void 未登録の選挙区を指定した場合_nullが返る() {
            AfT503SenkyokuEntity result = sut.select(未存在選挙種類, 選挙区T991);
            assertNull(result);
        }
    }

    public static class selectTest_SenkyoShurui extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T992));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T993));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T992));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T993));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T994));
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T991));
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T992));
        }

        @Test
        public void 通常選挙を指定した場合_3件返す() {
            List<AfT503SenkyokuEntity> result = sut.select(通常選挙);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の選挙種類を指定した場合_EMPTY_LISTが返る() {
            List<AfT503SenkyokuEntity> result = sut.select(未存在選挙種類);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T991));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT503SenkyokuEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T991));
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T992));
        }

        @Test
        public void 国民投票の選挙区T993のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T993));

            AfT503SenkyokuEntity result = sut.select(国民投票, 選挙区T993);
            assertNotNull(result);
            assertThat(result.getSenkyokuName(), is(new RString("テスト選挙区2T993")));
        }

        @Test
        public void 国民投票の選挙区T991_選挙区名称_更新済のentityを渡すと_updateが実行される() {
            AfT503SenkyokuEntity entity = sut.select(国民投票, 選挙区T991);
            assertThat(entity.getSenkyokuName(), is(new RString("テスト選挙区2T991")));

            entity.setSenkyokuName(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT503SenkyokuEntity result = sut.select(国民投票, 選挙区T991);
            assertThat(result.getSenkyokuName(), is(new RString(("更新済"))));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(国民投票, 選挙区T991));
        }

        @Test
        public void 通常選挙の選挙区T992_T993と国民投票の選挙区T991の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT503SenkyokuEntity> entities = new ArrayList<>();
            entities.add(create選挙区(通常選挙, 選挙区T992));
            entities.add(create選挙区(通常選挙, 選挙区T993));
            entities.add(create選挙区(国民投票, 選挙区T991));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
        }

        @Test
        public void 通常選挙の選挙区T991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT503SenkyokuEntity entity = sut.select(通常選挙, 選挙区T991);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T992));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T993));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T991));
        }

        @Test
        public void 通常選挙のentityを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT503SenkyokuEntity> entities = sut.select(通常選挙);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
        }

        @Test
        public void 通常選挙の選挙区T991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT503SenkyokuEntity entity = sut.select(通常選挙, 選挙区T991);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T991));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T992));
            sut.insertOrUpdate(create選挙区(通常選挙, 選挙区T993));
            sut.insertOrUpdate(create選挙区(農委選挙, 選挙区T991));
        }

        @Test
        public void 通常選挙のentityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT503SenkyokuEntity> entities = sut.select(通常選挙);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT503SenkyokuEntity create選挙区(Code senkyoShurui, RString senkyokuCode) {
        return AfT503SenkyokuEntityGenerator.createAfT503SenkyokuEntity(senkyoShurui, senkyokuCode);
    }

    private static void deleteTable(AfT503SenkyokuDac dac) {
        List<AfT503SenkyokuEntity> list = dac.select();
        dac.delete(list);
    }
}
