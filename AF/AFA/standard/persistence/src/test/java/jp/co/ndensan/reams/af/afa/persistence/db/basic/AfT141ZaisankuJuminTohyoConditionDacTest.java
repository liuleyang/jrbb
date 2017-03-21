/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT141ZaisankuJuminTohyoConditionEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT141ZaisankuJuminTohyoConditionDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT141ZaisankuJuminTohyoConditionDacTest extends AfaTestDacBase {

    private static AfT141ZaisankuJuminTohyoConditionDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本9992 = new ShohonNo(999992);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT141ZaisankuJuminTohyoConditionDac.class);
    }

    public static class selectTest_ShohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
            sut.insertOrUpdate(create財産区住民投票(抄本9992));
        }

        @Test
        public void 抄本番号9991を指定した場合_抄本番号_999991のエンティティを返す() {
            AfT141ZaisankuJuminTohyoConditionEntity result = sut.select(抄本9991);
            assertThat(result.getShohonNo(), is(new ShohonNo(999991)));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT141ZaisankuJuminTohyoConditionEntity result = sut.select(new ShohonNo(9999));
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
            sut.insertOrUpdate(create財産区住民投票(抄本9992));
        }

        @Test
        public void 引数なしで検索した場合_2件返る() {
            List<AfT141ZaisankuJuminTohyoConditionEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
        }

        @Test
        public void 抄本番号9992のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create財産区住民投票(抄本9992));

            AfT141ZaisankuJuminTohyoConditionEntity result = sut.select(抄本9992);
            assertNotNull(result);
        }

        @Test
        public void 抄本番号9991_年齢25のentityを渡すと_updateが実行される() {
            AfT141ZaisankuJuminTohyoConditionEntity entity = sut.select(抄本9991);
            assertThat(entity.getNenrei(), is(18));

            entity.setNenrei(25);
            sut.insertOrUpdate(entity);

            AfT141ZaisankuJuminTohyoConditionEntity result = sut.select(抄本9991);
            assertThat(result.getNenrei(), is(25));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT141ZaisankuJuminTohyoConditionEntity entity = sut.select(抄本9991);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
            sut.insertOrUpdate(create財産区住民投票(抄本9992));
        }

        @Test
        public void 引数を指定しなかった場合_deleteが成功し_処理件数2件が返る() {
            List<AfT141ZaisankuJuminTohyoConditionEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT141ZaisankuJuminTohyoConditionEntity entity = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create財産区住民投票(抄本9991));
            sut.insertOrUpdate(create財産区住民投票(抄本9992));
        }

        @Test
        public void 引数を指定しなかった場合_deletePhysicalが成功し_処理件数2件が返る() {
            List<AfT141ZaisankuJuminTohyoConditionEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT141ZaisankuJuminTohyoConditionEntity create財産区住民投票(ShohonNo shohonNo) {
        return AfT141ZaisankuJuminTohyoConditionEntityGenerator.createAfT141ZaisankuJuminTohyoConditionEntity(shohonNo);
    }

    private static void deleteTable(AfT141ZaisankuJuminTohyoConditionDac dac) {
        List<AfT141ZaisankuJuminTohyoConditionEntity> list = dac.select();
        dac.delete(list);
    }
}
