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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403ShomeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT401ChokusetsuSeikyuEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT403ShomeiboEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT403ShomeiboDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT403ShomeiboDacTest extends AfaTestDacBase {

    private static AfT403ShomeiboDac sut;
    private static AfT401ChokusetsuSeikyuDac oyaDac;

    private static final int 請求番号9991 = 9991;
    private static final int 請求番号9992 = 9992;
    private static final int 請求番号9999 = 9999;

    private static final RString 冊 = new RString("99");
    private static final int 頁 = 999999;

    private static final int 行1 = 1;
    private static final int 行2 = 2;
    private static final int 行3 = 3;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT403ShomeiboDac.class);
        oyaDac = InstanceProvider.create(AfT401ChokusetsuSeikyuDac.class);
    }

    public static class selectTest_SeikyuNo_Satsu_Page_Gyo extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行2));
        }

        @Test
        public void 請求番号9991_冊_頁_行1を指定した場合_漢字氏名_テスト署名者名簿9991頁1行1のエンティティを返す() {
            AfT403ShomeiboEntity result = sut.select(請求番号9991, 冊, 頁, 行1);
            assertThat(result.getKanjiShimei(), is(new AtenaMeisho("テスト署名者名簿9991：頁1：行1")));
        }

        @Test
        public void 未登録の請求番号を指定した場合_nullが返る() {
            AfT403ShomeiboEntity result = sut.select(請求番号9999, 冊, 頁, 行1);
            assertNull(result);
        }
    }

    public static class selectTest_SeikyuNo extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            oyaDac.insertOrUpdate(create直接請求(請求番号9999));

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行2));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行3));
            sut.insertOrUpdate(create署名者名簿(請求番号9992, 行1));
        }

        @Test
        public void 請求番号9991を指定した場合_3件返る() {
            List<AfT403ShomeiboEntity> result = sut.select(請求番号9991);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 存在しない請求番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT403ShomeiboEntity> result = sut.select(請求番号9999);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            oyaDac.insertOrUpdate(create直接請求(請求番号9999));

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行2));
            sut.insertOrUpdate(create署名者名簿(請求番号9992, 行1));
        }

        @Test
        public void selectした場合_3件返る() {
            List<AfT403ShomeiboEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
        }

        @Test
        public void 請求番号9991_行2のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行2));

            AfT403ShomeiboEntity result = sut.select(請求番号9991, 冊, 頁, 行2);
            assertNotNull(result);
            assertThat(result.getKanjiShimei(), is(new AtenaMeisho("テスト署名者名簿9991：頁1：行2")));
        }

        @Test
        public void 請求番号9991_行1_漢字氏名_更新済みのentityを渡すと_updateが実行される() {
            AfT403ShomeiboEntity entity = sut.select(請求番号9991, 冊, 頁, 行1);
            assertThat(entity.getKanjiShimei(), is(new AtenaMeisho("テスト署名者名簿9991：頁1：行1")));

            entity.setKanjiShimei(new AtenaMeisho("更新済み"));
            sut.insertOrUpdate(entity);

            AfT403ShomeiboEntity result = sut.select(請求番号9991, 冊, 頁, 行1);
            assertThat(result.getKanjiShimei(), is(new AtenaMeisho("更新済み")));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
        }

        @Test
        public void 請求番号9991_行1から行3の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT403ShomeiboEntity> entities = new ArrayList<>();
            entities.add(create署名者名簿(請求番号9991, 行1));
            entities.add(create署名者名簿(請求番号9991, 行2));
            entities.add(create署名者名簿(請求番号9991, 行3));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
        }

        @Test
        public void 請求番号9991_冊_頁_行1のentityを指定した場合_deleteが成功し_1が返る() {
            AfT403ShomeiboEntity entity = sut.select(請求番号9991, 冊, 頁, 行1);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行2));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行3));
            sut.insertOrUpdate(create署名者名簿(請求番号9992, 行1));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deleteが成功し_削除件数_3が返る() {
            List<AfT403ShomeiboEntity> entities = sut.select(請求番号9991);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
        }

        @Test
        public void 請求番号9991_冊_頁_行1のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT403ShomeiboEntity entity = sut.select(請求番号9991, 冊, 頁, 行1);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行1));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行2));
            sut.insertOrUpdate(create署名者名簿(請求番号9991, 行3));
            sut.insertOrUpdate(create署名者名簿(請求番号9992, 行1));
        }

        @Test
        public void 請求番号9991のentityを指定した場合_deletePhysicalが成功し_削除件数_3が返る() {
            List<AfT403ShomeiboEntity> entities = sut.select(請求番号9991);
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

    private static AfT403ShomeiboEntity create署名者名簿(int seikyuNo, int gyo) {
        return AfT403ShomeiboEntityGenerator.createAfT403ShomeiboEntity(seikyuNo, gyo);
    }

    private static void deleteTable(AfT403ShomeiboDac dac) {
        List<AfT403ShomeiboEntity> list = dac.select();
        dac.delete(list);
    }
}
