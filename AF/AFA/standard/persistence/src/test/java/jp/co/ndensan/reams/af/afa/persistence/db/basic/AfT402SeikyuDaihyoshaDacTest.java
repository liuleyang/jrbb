/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyoshaEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT401ChokusetsuSeikyuEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT402SeikyuDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link AfT402SeikyuDaihyoshaDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT402SeikyuDaihyoshaDacTest extends AfaTestDacBase {

    private static AfT402SeikyuDaihyoshaDac sut;
    private static AfT401ChokusetsuSeikyuDac oyaDac;

    private static final int 請求番号9991 = 9991;
    private static final int 請求番号9992 = 9992;
    private static final int 請求番号9999 = 9999;

    public static final ShikibetsuCode 識別コード001 = new ShikibetsuCode("999999999001");
    public static final ShikibetsuCode 識別コード002 = new ShikibetsuCode("999999999002");
    public static final ShikibetsuCode 識別コード003 = new ShikibetsuCode("999999999003");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT402SeikyuDaihyoshaDac.class);
        oyaDac = InstanceProvider.create(AfT401ChokusetsuSeikyuDac.class);
    }

    public static class selectTest_SeikyuNo_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
            sut.insert(create直接請求代表者(請求番号9992, 識別コード001));
        }

        @Test
        public void 請求番号9991_識別コード001を指定した場合_識別コード_999999999001のエンティティを返す() {
            AfT402SeikyuDaihyoshaEntity result = sut.select(請求番号9991, 識別コード001);
            assertThat(result.getSeikyuShikibetsuCode(), is(new ShikibetsuCode("999999999001")));
        }

        @Test
        public void 未登録の請求番号を指定した場合_nullが返る() {
            AfT402SeikyuDaihyoshaEntity result = sut.select(請求番号9999, 識別コード001);
            assertNull(result);
        }
    }

    public static class selectTest_SeikyuNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            oyaDac.insertOrUpdate(create直接請求(請求番号9999));

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
            sut.insert(create直接請求代表者(請求番号9991, 識別コード002));
            sut.insert(create直接請求代表者(請求番号9991, 識別コード003));
            sut.insert(create直接請求代表者(請求番号9992, 識別コード001));
        }

        @Test
        public void 請求番号9991を指定した場合_3件返る() {
            List<AfT402SeikyuDaihyoshaEntity> result = sut.select(請求番号9991);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 存在しない請求番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT402SeikyuDaihyoshaEntity> result = sut.select(請求番号9999);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
            sut.insert(create直接請求代表者(請求番号9992, 識別コード001));
        }

        @Test
        public void selectした場合_2件返る() {
            List<AfT402SeikyuDaihyoshaEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertTest_SeikyuNo_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
        }

        @Test
        public void 識別コード002のentityを指定した場合_insertが実行される() {
            sut.insert(create直接請求代表者(請求番号9991, 識別コード002));

            AfT402SeikyuDaihyoshaEntity result = sut.select(請求番号9991, 識別コード002);
            assertNotNull(result);
            assertThat(result.getSeikyuShikibetsuCode(), is(new ShikibetsuCode("999999999002")));
        }
    }

    public static class insertTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
        }

        @Test
        public void 請求番号9991_識別コード001から003の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT402SeikyuDaihyoshaEntity> entities = new ArrayList<>();
            entities.add(create直接請求代表者(請求番号9991, 識別コード001));
            entities.add(create直接請求代表者(請求番号9991, 識別コード002));
            entities.add(create直接請求代表者(請求番号9991, 識別コード003));

            assertThat(sut.insert(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT402SeikyuDaihyoshaEntity entity = sut.select(請求番号9991, 識別コード001);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
            sut.insert(create直接請求代表者(請求番号9991, 識別コード002));
            sut.insert(create直接請求代表者(請求番号9991, 識別コード003));
            sut.insert(create直接請求代表者(請求番号9992, 識別コード001));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deleteが成功し_削除件数_3が返る() {
            List<AfT402SeikyuDaihyoshaEntity> entities = sut.select(請求番号9991);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT402SeikyuDaihyoshaEntity entity = sut.select(請求番号9991, 識別コード001);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create直接請求代表者(請求番号9991, 識別コード001));
            sut.insert(create直接請求代表者(請求番号9991, 識別コード002));
            sut.insert(create直接請求代表者(請求番号9991, 識別コード003));
            sut.insert(create直接請求代表者(請求番号9992, 識別コード001));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deletePhysicalが成功し_削除件数_3が返る() {
            List<AfT402SeikyuDaihyoshaEntity> entities = sut.select(請求番号9991);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static void populate() {
        deleteTable(sut);
        oyaDac.delete(oyaDac.select());
        oyaDac.insertOrUpdate(create直接請求(請求番号9991));
        oyaDac.insertOrUpdate(create直接請求(請求番号9992));
    }

    private static AfT401ChokusetsuSeikyuEntity create直接請求(int seikyuNo) {
        return AfT401ChokusetsuSeikyuEntityGenerator.createAfT401ChokusetsuSeikyuEntity(seikyuNo);
    }

    private static AfT402SeikyuDaihyoshaEntity create直接請求代表者(int seikyuNo, ShikibetsuCode shikibetsuCode) {
        return AfT402SeikyuDaihyoshaEntityGenerator.createAfT402SeikyuDaihyoshaEntity(seikyuNo, shikibetsuCode);
    }

    private static void deleteTable(AfT402SeikyuDaihyoshaDac dac) {
        List<AfT402SeikyuDaihyoshaEntity> list = dac.select();
        dac.delete(list);
    }
}
