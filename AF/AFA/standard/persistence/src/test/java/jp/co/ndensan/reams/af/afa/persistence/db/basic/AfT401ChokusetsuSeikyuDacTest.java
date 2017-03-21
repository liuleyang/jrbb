/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT401ChokusetsuSeikyuEntityGenerator;
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
 * {@link AfT401ChokusetsuSeikyuDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT401ChokusetsuSeikyuDacTest extends AfaTestDacBase {

    private static AfT401ChokusetsuSeikyuDac sut;

    private static final int 請求番号9991 = 9991;
    private static final int 請求番号9992 = 9992;
    private static final int 請求番号9999 = 9999;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT401ChokusetsuSeikyuDac.class);
    }

    public static class selectTest_Nendo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
            sut.insertOrUpdate(create直接請求(請求番号9992));
        }

        @Test
        public void 請求番号9991を指定した場合_請求名_テスト直接請求9991のエンティティを返す() {
            AfT401ChokusetsuSeikyuEntity result = sut.select(請求番号9991);
            assertThat(result.getSeikyuMei(), is(new RString("テスト直接請求名9991")));
        }

        @Test
        public void 未登録の請求番号を指定した場合_nullが返る() {
            AfT401ChokusetsuSeikyuEntity result = sut.select(請求番号9999);
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
            sut.insertOrUpdate(create直接請求(請求番号9992));
        }

        @Test
        public void 引数に何も指定しない場合_2件返る() {
            List<AfT401ChokusetsuSeikyuEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
        }

        @Test
        public void 請求番号9992のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create直接請求(請求番号9992));

            AfT401ChokusetsuSeikyuEntity result = sut.select(請求番号9992);
            assertNotNull(result);
            assertThat(result.getSeikyuMei(), is(new RString("テスト直接請求名9992")));
        }

        @Test
        public void 請求番号9991_請求名_更新済みのentityを渡すと_updateが実行される() {
            AfT401ChokusetsuSeikyuEntity entity = create直接請求(請求番号9991);
            assertThat(entity.getSeikyuMei(), is(new RString("テスト直接請求名9991")));

            entity.setSeikyuMei(new RString("更新済み"));
            sut.insertOrUpdate(entity);

            AfT401ChokusetsuSeikyuEntity result = sut.select(請求番号9991);
            assertThat(result.getSeikyuMei(), is(new RString("更新済み")));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT401ChokusetsuSeikyuEntity entity = sut.select(請求番号9991);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
            sut.insertOrUpdate(create直接請求(請求番号9992));
            sut.insertOrUpdate(create直接請求(請求番号9999));
        }

        @Test
        public void 複数件数のentityを指定した場合_deleteが成功し_削除件数_3が返る() {
            List<AfT401ChokusetsuSeikyuEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT401ChokusetsuSeikyuEntity entity = sut.select(請求番号9991);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create直接請求(請求番号9991));
            sut.insertOrUpdate(create直接請求(請求番号9992));
            sut.insertOrUpdate(create直接請求(請求番号9999));
        }

        @Test
        public void 複数件数のentityを指定した場合_deletePhysicalが成功し_削除件数_3が返る() {
            List<AfT401ChokusetsuSeikyuEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT401ChokusetsuSeikyuEntity create直接請求(int seikyuNo) {
        return AfT401ChokusetsuSeikyuEntityGenerator.createAfT401ChokusetsuSeikyuEntity(seikyuNo);
    }

    private static void deleteTable(AfT401ChokusetsuSeikyuDac dac) {
        List<AfT401ChokusetsuSeikyuEntity> list = dac.select();
        dac.delete(list);
    }

}
