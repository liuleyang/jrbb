/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakuseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT302SaibaninYoteishaEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT301SaibaninMeiboSakuseiEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT302SaibaninYoteishaEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link AfT302SaibaninYoteishaDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT302SaibaninYoteishaDacTest extends AfaTestDacBase {

    private static AfT302SaibaninYoteishaDac sut;
    private static AfT301SaibaninMeiboSakuseiDac oyaDac;

    private static final RYear 年度9991 = new RYear("9991");
    private static final RYear 年度9992 = new RYear("9992");
    private static final RYear 年度9999 = new RYear("9999");

    private static final int 連番0001 = 9990001;
    private static final int 連番0002 = 9990002;
    private static final int 連番0003 = 9990003;

    public static final ShikibetsuCode 識別コード = new ShikibetsuCode("123456789012");
    private static final ShohonNo 抄本9991 = new ShohonNo(9991);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT302SaibaninYoteishaDac.class);
        oyaDac = InstanceProvider.create(AfT301SaibaninMeiboSakuseiDac.class);
    }

    public static class selectTest_Nendo_Renban_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
            sut.insert(create裁判員候補者予定者(年度9992, 連番0001));
        }

        @Test
        public void 年度9991_連番0001_識別コードを指定した場合_ファイル名_テスト裁判員予定者名簿9991のエンティティを返す() {
            AfT302SaibaninYoteishaEntity result = sut.select(年度9991, 連番0001, 識別コード);
            assertThat(result.getShimei(), is(new AtenaMeisho("テスト裁判員予定者名簿9991：連番9990001")));
        }

        @Test
        public void 未登録の年度を指定した場合_nullが返る() {
            AfT302SaibaninYoteishaEntity result = sut.select(年度9999, 連番0001, 識別コード);
            assertNull(result);
        }
    }

    public static class selectTest_Nendo extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
            sut.insert(create裁判員候補者予定者(年度9991, 連番0002));
            sut.insert(create裁判員候補者予定者(年度9991, 連番0003));
            sut.insert(create裁判員候補者予定者(年度9992, 連番0001));
        }

        @Test
        public void 年度9991を指定した場合_3件返る() {
            List<AfT302SaibaninYoteishaEntity> result = sut.select(年度9991);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 存在しない年度を指定した場合_EMPTY_LISTが返る() {
            List<AfT302SaibaninYoteishaEntity> result = sut.select(年度9999);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
            sut.insert(create裁判員候補者予定者(年度9992, 連番0001));
        }

        @Test
        public void selectした場合_2件返る() {
            List<AfT302SaibaninYoteishaEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertTest_Nendo_Renban_ShikibetsuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
        }

        @Test
        public void 連番0002のentityを指定した場合_insertが実行される() {
            sut.insert(create裁判員候補者予定者(年度9991, 連番0002));

            AfT302SaibaninYoteishaEntity result = sut.select(年度9991, 連番0002, 識別コード);
            assertNotNull(result);
            assertThat(result.getShimei(), is(new AtenaMeisho("テスト裁判員予定者名簿9991：連番9990002")));
        }
    }

    public static class insertTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
        }

        @Test
        public void 連番_1から3の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT302SaibaninYoteishaEntity> entities = new ArrayList<>();
            entities.add(create裁判員候補者予定者(年度9991, 連番0001));
            entities.add(create裁判員候補者予定者(年度9991, 連番0002));
            entities.add(create裁判員候補者予定者(年度9991, 連番0003));

            assertThat(sut.insert(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
        }

        @Test
        public void 年度9991のentityを指定した場合_deleteが成功し_1が返る() {
            AfT302SaibaninYoteishaEntity entity = sut.select(年度9991, 連番0001, 識別コード);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
            sut.insert(create裁判員候補者予定者(年度9991, 連番0002));
            sut.insert(create裁判員候補者予定者(年度9991, 連番0003));
            sut.insert(create裁判員候補者予定者(年度9992, 連番0001));
        }

        @Test
        public void 年度9991のentityを指定した場合_deleteが成功し_削除件数_3が返る() {
            List<AfT302SaibaninYoteishaEntity> entities = sut.select(年度9991);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
        }

        @Test
        public void 年度9991のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT302SaibaninYoteishaEntity entity = sut.select(年度9991, 連番0001, 識別コード);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();

            sut.insert(create裁判員候補者予定者(年度9991, 連番0001));
            sut.insert(create裁判員候補者予定者(年度9991, 連番0002));
            sut.insert(create裁判員候補者予定者(年度9991, 連番0003));
            sut.insert(create裁判員候補者予定者(年度9992, 連番0001));
        }

        @Test
        public void 年度9991のentityを指定した場合_deletePhysicalが成功し_削除件数_3が返る() {
            List<AfT302SaibaninYoteishaEntity> entities = sut.select(年度9991);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static void populate() {
        deleteTable(sut);
        oyaDac.delete(oyaDac.select());
        oyaDac.insertOrUpdate(create裁判員名簿(年度9991, 抄本9991));
        oyaDac.insertOrUpdate(create裁判員名簿(年度9992, 抄本9991));
        oyaDac.insertOrUpdate(create裁判員名簿(年度9999, 抄本9991));
    }

    private static AfT301SaibaninMeiboSakuseiEntity create裁判員名簿(RYear nendo, ShohonNo shohonNo) {
        return AfT301SaibaninMeiboSakuseiEntityGenerator.createAfT301SaibaninMeiboSakuseiEntity(nendo, shohonNo);
    }

    private static AfT302SaibaninYoteishaEntity create裁判員候補者予定者(RYear nendo, int renban) {
        return AfT302SaibaninYoteishaEntityGenerator.createAfT302SaibaninYoteishaEntity(nendo, renban);
    }

    private static void deleteTable(AfT302SaibaninYoteishaDac dac) {
        List<AfT302SaibaninYoteishaEntity> list = dac.select();
        dac.delete(list);
    }
}
