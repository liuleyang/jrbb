/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakuseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT301SaibaninMeiboSakuseiEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
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
 * {@link AfT301SaibaninMeiboSakuseiDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT301SaibaninMeiboSakuseiDacTest extends AfaTestDacBase {

    private static AfT301SaibaninMeiboSakuseiDac sut;

    private static final RYear 年度9991 = new RYear("9991");
    private static final RYear 年度9992 = new RYear("9992");
    private static final RYear 年度9999 = new RYear("9999");

    private static final ShohonNo 抄本9991 = new ShohonNo(9991);
    private static final ShohonNo 抄本9992 = new ShohonNo(9992);
    private static final ShohonNo 抄本9999 = new ShohonNo(9999);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT301SaibaninMeiboSakuseiDac.class);
    }

    public static class selectTest_Nendo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));
        }

        @Test
        public void 年度9991を指定した場合_ファイル名_テスト裁判員名簿9991のエンティティを返す() {
            AfT301SaibaninMeiboSakuseiEntity result = sut.select(年度9991);
            assertThat(result.getFileName(), is(new RString("テスト裁判員名簿9991")));
        }

        @Test
        public void 未登録の年度を指定した場合_nullが返る() {
            AfT301SaibaninMeiboSakuseiEntity result = sut.select(年度9999);
            assertNull(result);
        }
    }

    public static class selectTest_ShohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));
        }

        @Test
        public void 抄本番号9991を指定した場合_2件返る() {
            List<AfT301SaibaninMeiboSakuseiEntity> result = sut.select(抄本9991);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 存在しない抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT301SaibaninMeiboSakuseiEntity> result = sut.select(抄本9999);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));
        }

        @Test
        public void selectした場合_2件返る() {
            List<AfT301SaibaninMeiboSakuseiEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
        }

        @Test
        public void 年度9992のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));

            AfT301SaibaninMeiboSakuseiEntity result = sut.select(年度9992);
            assertNotNull(result);
            assertThat(result.getFileName(), is(new RString("テスト裁判員名簿9992")));
        }

        @Test
        public void 年度9991_抄本番号9991_ファイル名_更新済みのentityを渡すと_updateが実行される() {
            AfT301SaibaninMeiboSakuseiEntity entity = create裁判員名簿(年度9991, 抄本9991);
            assertThat(entity.getFileName(), is(new RString("テスト裁判員名簿9991")));

            entity.setFileName(new RString("更新済み"));
            sut.insertOrUpdate(entity);

            AfT301SaibaninMeiboSakuseiEntity result = sut.select(年度9991);
            assertThat(result.getFileName(), is(new RString("更新済み")));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
        }

        @Test
        public void 年度9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT301SaibaninMeiboSakuseiEntity entity = sut.select(年度9991);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9999, 抄本9992));
        }

        @Test
        public void 抄本9991のentityを指定した場合_deleteが成功し_削除件数_2が返る() {
            List<AfT301SaibaninMeiboSakuseiEntity> entities = sut.select(抄本9991);
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
        }

        @Test
        public void 年度9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT301SaibaninMeiboSakuseiEntity entity = sut.select(年度9991);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));
            sut.insertOrUpdate(create裁判員名簿(年度9999, 抄本9992));
        }

        @Test
        public void 抄本9991のentityを指定した場合_deletePhysicalが成功し_削除件数_2が返る() {
            List<AfT301SaibaninMeiboSakuseiEntity> entities = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT301SaibaninMeiboSakuseiEntity create裁判員名簿(RYear nendo, ShohonNo shohonNo) {
        return AfT301SaibaninMeiboSakuseiEntityGenerator.createAfT301SaibaninMeiboSakuseiEntity(nendo, shohonNo);
    }

    private static void deleteTable(AfT301SaibaninMeiboSakuseiDac dac) {
        List<AfT301SaibaninMeiboSakuseiEntity> list = dac.select();
        dac.delete(list);
    }
}
