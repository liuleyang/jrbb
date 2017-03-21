/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT141ZaisankuJuminTohyoConditionEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT146Chiku2ConditionEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
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
 * {@link AfT146Chiku2ConditionDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT146Chiku2ConditionDacTest extends AfaTestDacBase {

    private static AfT146Chiku2ConditionDac sut;
    private static AfT141ZaisankuJuminTohyoConditionDac oyaDac;

    private static final ShohonNo 抄本9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本9992 = new ShohonNo(999992);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT146Chiku2ConditionDac.class);
        oyaDac = InstanceProvider.create(AfT141ZaisankuJuminTohyoConditionDac.class);
    }

    public static class selectTest_ShohonNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
            sut.insert(create地区2条件(抄本9992));
        }

        @Test
        public void 抄本番号9991を指定した場合_抄本番号_999991のエンティティを返す() {
            AfT146Chiku2ConditionEntity result = sut.select(抄本9991);
            assertThat(result.getChikuCode2(), is(new ChikuCode("999991")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT146Chiku2ConditionEntity result = sut.select(new ShohonNo(999999));
            assertNull(result);
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
            sut.insert(create地区2条件(抄本9992));
        }

        @Test
        public void 引数なしで検索した場合_2件返る() {
            List<AfT146Chiku2ConditionEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
        }

        @Test
        public void 抄本番号9992のentityを指定した場合_insertが実行される() {
            sut.insert(create地区2条件(抄本9992));

            AfT146Chiku2ConditionEntity result = sut.select(抄本9992);
            assertNotNull(result);
        }
    }

    public static class insertTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
        }

        @Test
        public void 抄本番号9991と抄本番号9992の複数件数Listを指定した場合_処理件数2件が返る() {
            List<AfT146Chiku2ConditionEntity> entities = new ArrayList<>();
            entities.add(create地区2条件(抄本9991));
            entities.add(create地区2条件(抄本9992));

            assertThat(sut.insert(entities), is(2));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT146Chiku2ConditionEntity entity = sut.select(抄本9991);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
            sut.insert(create地区2条件(抄本9992));
        }

        @Test
        public void 引数を指定しなかった場合_deleteが成功し_処理件数2件が返る() {
            List<AfT146Chiku2ConditionEntity> entities = sut.select();
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT146Chiku2ConditionEntity entity = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create地区2条件(抄本9991));
            sut.insert(create地区2条件(抄本9992));
        }

        @Test
        public void 引数を指定しなかった場合_deletePhysicalが成功し_処理件数2件が返る() {
            List<AfT146Chiku2ConditionEntity> entities = sut.select();
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT146Chiku2ConditionEntity create地区2条件(ShohonNo shohonNo) {
        return AfT146Chiku2ConditionEntityGenerator.createAfT146Chiku2ConditionEntity(shohonNo);
    }

    private static void populate() {
        deleteTable(sut);
        oyaDac.insertOrUpdate(create財産区住民投票(抄本9991));
        oyaDac.insertOrUpdate(create財産区住民投票(抄本9992));
    }

    private static AfT141ZaisankuJuminTohyoConditionEntity create財産区住民投票(ShohonNo shohonNo) {
        return AfT141ZaisankuJuminTohyoConditionEntityGenerator.createAfT141ZaisankuJuminTohyoConditionEntity(shohonNo);
    }

    private static void deleteTable(AfT146Chiku2ConditionDac dac) {
        List<AfT146Chiku2ConditionEntity> list = dac.select();
        dac.delete(list);
    }

}
