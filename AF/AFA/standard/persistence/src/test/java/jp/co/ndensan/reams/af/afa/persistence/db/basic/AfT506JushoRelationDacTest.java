/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT506JushoRelationEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT506JushoRelationEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT506JushoRelationDac}のテストです。
 *
 * @author n1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT506JushoRelationDacTest extends AfaTestDacBase {

    private static AfT506JushoRelationDac sut;

    private static final Code 通常選挙 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    private static final Code 国民投票 = new Code(SenkyoShurui.憲法改正国民投票.getCode());
    private static final Code 農委選挙 = new Code(SenkyoShurui.農業委員会委員選挙.getCode());
    private static final Code 未存在選挙種類 = new Code("Z");

    private static final ChoikiCode 町域T991 = new ChoikiCode("T991");
    private static final ChoikiCode 町域T992 = new ChoikiCode("T992");
    private static final ChoikiCode 町域T993 = new ChoikiCode("T993");
    private static final ChoikiCode 町域T994 = new ChoikiCode("T994");
    private static final BanchiCode 開始番地1 = AfT506JushoRelationEntityGenerator.DEFAULT_開始番地1;
    private static final BanchiCode 開始番地2 = AfT506JushoRelationEntityGenerator.DEFAULT_開始番地2;
    private static final BanchiCode 開始番地3 = AfT506JushoRelationEntityGenerator.DEFAULT_開始番地3;
    private static final BanchiCode 開始番地4 = AfT506JushoRelationEntityGenerator.DEFAULT_開始番地4;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT506JushoRelationDac.class);
    }

    public static class selectTest_SenkyoShurui_ChoikiCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T992));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T993));
        }

        @Test
        public void 通常選挙の町域T992を指定した場合_選挙区名_テスト選挙区1T992のエンティティを返す() {
            AfT506JushoRelationEntity result = sut.select(通常選挙, 町域T992, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertThat(result.getTohyokuCode(), is(new RString("T992")));
        }

        @Test
        public void 未登録の選挙区を指定した場合_nullが返る() {
            AfT506JushoRelationEntity result = sut.select(未存在選挙種類, 町域T991, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertNull(result);
        }
    }

    public static class selectTest_SenkyoShurui extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T992));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T993));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T992));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T993));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T994));
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T991));
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T992));
        }

        @Test
        public void 通常選挙を指定した場合_3件返す() {
            List<AfT506JushoRelationEntity> result = sut.select(通常選挙);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の選挙種類を指定した場合_EMPTY_LISTが返る() {
            List<AfT506JushoRelationEntity> result = sut.select(未存在選挙種類);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T991));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT506JushoRelationEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }

    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T991));
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T992));
        }

        @Test
        public void 国民投票の町域T993のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T993));

            AfT506JushoRelationEntity result = sut.select(国民投票, 町域T993, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertNotNull(result);
            assertThat(result.getTohyokuCode(), is(new RString("T993")));
        }

        @Test
        public void 国民投票の町域T991_選挙区名称_更新済のentityを渡すと_updateが実行される() {
            AfT506JushoRelationEntity entity = sut.select(国民投票, 町域T991, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertThat(entity.getTohyokuCode(), is(new RString("T991")));

            entity.setTohyokuCode(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT506JushoRelationEntity result = sut.select(国民投票, 町域T991, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertThat(result.getTohyokuCode(), is(new RString(("更新済"))));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(国民投票, 町域T991));
        }

        @Test
        public void 通常選挙の町域T992_T993と国民投票の町域T991の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT506JushoRelationEntity> entities = new ArrayList<>();
            entities.add(create住所番地対応(通常選挙, 町域T992));
            entities.add(create住所番地対応(通常選挙, 町域T993));
            entities.add(create住所番地対応(国民投票, 町域T991));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
        }

        @Test
        public void 通常選挙の町域T991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT506JushoRelationEntity entity = sut.select(通常選挙, 町域T991, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T992));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T993));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T991));
        }

        @Test
        public void 通常選挙のentityを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT506JushoRelationEntity> entities = sut.select(通常選挙);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
        }

        @Test
        public void 通常選挙の町域T991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT506JushoRelationEntity entity = sut.select(通常選挙, 町域T991, 開始番地1, 開始番地2, 開始番地3, 開始番地4);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T991));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T992));
            sut.insertOrUpdate(create住所番地対応(通常選挙, 町域T993));
            sut.insertOrUpdate(create住所番地対応(農委選挙, 町域T991));
        }

        @Test
        public void 通常選挙のentityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT506JushoRelationEntity> entities = sut.select(通常選挙);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT506JushoRelationEntity create住所番地対応(Code senkyoShurui, ChoikiCode choikiCode) {
        return AfT506JushoRelationEntityGenerator.createAfT506JushoRelationEntity(senkyoShurui, choikiCode);
    }

    private static void deleteTable(AfT506JushoRelationDac dac) {
        List<AfT506JushoRelationEntity> list = dac.select();
        dac.delete(list);
    }
}
