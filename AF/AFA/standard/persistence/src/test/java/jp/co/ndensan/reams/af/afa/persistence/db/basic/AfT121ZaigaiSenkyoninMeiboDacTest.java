/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT121ZaigaiSenkyoninMeiboEntityGenerator;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT121ZaigaiSenkyoninMeiboEntityGenerator.*;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link AfT121ZaigaiSenkyoninMeiboDac}のテストです。
 *
 * @author n1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT121ZaigaiSenkyoninMeiboDacTest extends AfaTestDacBase {

    private static AfT121ZaigaiSenkyoninMeiboDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(9991);
    private static final ShohonNo 抄本9992 = new ShohonNo(9992);
    private static final ShohonNo 抄本9999 = new ShohonNo(9999);

    private static final RString 投票区9991 = new RString("9991");
    private static final RString 投票区9992 = new RString("9992");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT121ZaigaiSenkyoninMeiboDac.class);
    }

    public static class selectTest_primaryKeyのテスト extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9992));
        }

        @Test(expected = NullPointerException.class)
        public void shohonNoがnullの場合_selectは_NullPointerExceptionを発生させる() {
            sut.select(null, DEFAULT_グループコード, DEFAULT_投票区コード, DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_行);
        }

        @Test(expected = NullPointerException.class)
        public void groupCodeがnullの場合_selectは_NullPointerExceptionを発生させる() {
            sut.select(DEFAULT_抄本番号, null, DEFAULT_投票区コード, DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_行);
        }

        @Test(expected = NullPointerException.class)
        public void TohyokuCodeがnullの場合_selectは_NullPointerExceptionを発生させる() {
            sut.select(DEFAULT_抄本番号, DEFAULT_グループコード, null, DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_行);
        }

        @Test(expected = NullPointerException.class)
        public void kokugaiBunruiCodeがnullの場合_selectは_NullPointerExceptionを発生させる() {
            sut.select(DEFAULT_抄本番号, DEFAULT_グループコード, DEFAULT_投票区コード, null, DEFAULT_冊, DEFAULT_頁, DEFAULT_行);
        }

        @Test(expected = NullPointerException.class)
        public void satsuがnullの場合_selectは_NullPointerExceptionを発生させる() {
            sut.select(DEFAULT_抄本番号, DEFAULT_グループコード, DEFAULT_投票区コード, DEFAULT_国外分類コード, null, DEFAULT_頁, DEFAULT_行);
        }

        @Test
        public void 抄本番号_9991を指定した場合_抄本名_テスト抄本1のエンティティを返す() {
            AfT121ZaigaiSenkyoninMeiboEntity result = sut.select(抄本9991, DEFAULT_グループコード, 投票区9991,
                    DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_頁);
            assertThat(result.getShikibetsuCode(), is(new ShikibetsuCode("99919991")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT121ZaigaiSenkyoninMeiboEntity result = sut.select(抄本9999, DEFAULT_グループコード, DEFAULT_投票区コード,
                    DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_頁);
            assertNull(result);
        }
    }

    public static class select_ShohonNoのテスト extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9992));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9991));
        }

        @Test
        public void 抄本番号9991を指定した場合_2件返る() {
            List<AfT121ZaigaiSenkyoninMeiboEntity> result = sut.select(抄本9991);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 存在しない抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT121ZaigaiSenkyoninMeiboEntity> result = sut.select(抄本9999);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class select_Allのテスト extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9991));
        }

        @Test
        public void selectした場合_2件返る() {
            List<AfT121ZaigaiSenkyoninMeiboEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
        }

        @Test
        public void 抄本番号_9992のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9991));

            AfT121ZaigaiSenkyoninMeiboEntity result = sut.select(抄本9992, DEFAULT_グループコード, 投票区9991,
                    DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_頁);
            assertNotNull(result);
            assertThat(result.getShikibetsuCode().getColumnValue(), is(new RString("99929991")));
        }

        @Test
        public void 抄本番号_9991_通常選挙のentityを渡すと_updateが実行される() {
            AfT121ZaigaiSenkyoninMeiboEntity entity = create在外選挙人名簿(抄本9991, 投票区9991);
            sut.insertOrUpdate(entity);

            AfT121ZaigaiSenkyoninMeiboEntity result = sut.select(抄本9991, DEFAULT_グループコード, 投票区9991,
                    DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_頁);
            assertThat(result.getShikibetsuCode().getColumnValue(), is(new RString("99919991")));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
        }

        @Test
        public void 抄本番号_9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT121ZaigaiSenkyoninMeiboEntity entity = sut.select(抄本9991, DEFAULT_グループコード, 投票区9991,
                    DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_頁);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9992));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9992));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deleteが成功し_削除件数_2が返る() {
            List<AfT121ZaigaiSenkyoninMeiboEntity> entities = sut.select(抄本9991);
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
        }

        @Test
        public void 抄本番号_9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT121ZaigaiSenkyoninMeiboEntity entity = sut.select(抄本9991, DEFAULT_グループコード, 投票区9991,
                    DEFAULT_国外分類コード, DEFAULT_冊, DEFAULT_頁, DEFAULT_頁);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9991, 投票区9992));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9991));
            sut.insertOrUpdate(create在外選挙人名簿(抄本9992, 投票区9992));
        }

        @Test
        public void 抄本番号9991のentityを指定した場合_deletePhysicalが成功し_削除件数_2が返る() {
            List<AfT121ZaigaiSenkyoninMeiboEntity> entities = sut.select(抄本9991);
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT121ZaigaiSenkyoninMeiboEntity create在外選挙人名簿(ShohonNo shohonNo, RString tohyokuCode) {
        return AfT121ZaigaiSenkyoninMeiboEntityGenerator.createAfT121ZaigaiSenkyoninMeiboEntity(shohonNo, tohyokuCode);
    }

    private static void deleteTable(AfT121ZaigaiSenkyoninMeiboDac dac) {
        List<AfT121ZaigaiSenkyoninMeiboEntity> list = dac.select();
        dac.delete(list);
    }

}
