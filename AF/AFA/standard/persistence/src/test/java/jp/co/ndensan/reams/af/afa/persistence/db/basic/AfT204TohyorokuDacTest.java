/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT204TohyorokuEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link AfT204TohyorokuDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT204TohyorokuDacTest extends AfaTestDacBase {

    private static AfT204TohyorokuDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本9992 = new ShohonNo(999992);
    private static final ShohonNo 抄本9999 = new ShohonNo(999999);

    private static final SenkyoNo 選挙番号1 = new SenkyoNo(1);
    private static final SenkyoNo 選挙番号2 = new SenkyoNo(2);
    private static final SenkyoNo 選挙番号3 = new SenkyoNo(3);

    private static final FlexibleDate 報告日 = AfT204TohyorokuEntityGenerator.DEFAULT_報告年月日;
    private static final RString 施設コード = AfT204TohyorokuEntityGenerator.DEFAULT_施設コード;
    private static final RString 投票区コード = AfT204TohyorokuEntityGenerator.DEFAULT_投票区コード;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT204TohyorokuDac.class);
    }

    public static class selectTest_PrimaryKey extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号2));
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号3));
        }

        @Test
        public void 抄本9991_選挙番号2を指定した場合_設置状況_テスト投票録_抄本番号999991_選挙番号2のエンティティを返す() {
            AfT204TohyorokuEntity result = sut.select(抄本9991, 選挙番号2, 報告日, 施設コード, 投票区コード);
            assertThat(result.getSecchiJokyo(), is(new RString("テスト投票録　：抄本番号999991：選挙番号2")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT204TohyorokuEntity result = sut.select(抄本9992, 選挙番号1, 報告日, 施設コード, 投票区コード);
            assertNull(result);
        }
    }

    public static class selectTest_ShohonNo_HokokuYMD extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号2));
        }

        @Test
        public void 抄本9992を指定した場合_2件返す() {
            List<AfT204TohyorokuEntity> result = sut.select(抄本9992, 報告日);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT204TohyorokuEntity> result = sut.select(抄本9999, 報告日);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
        }

        @Test
        public void selectした場合_2件返す() {
            List<AfT204TohyorokuEntity> result = sut.select();
            assertThat(result.size(), is(2));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号2));
        }

        @Test
        public void 抄本9991_選挙番号2のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号2));

            AfT204TohyorokuEntity result = sut.select(抄本9991, 選挙番号2, 報告日, 施設コード, 投票区コード);
            assertNotNull(result);
        }

        @Test
        public void 抄本9992_選挙番号1_設置状況が_更新済のentityを渡すと_updateが実行される() {
            AfT204TohyorokuEntity entity = sut.select(抄本9992, 選挙番号1, 報告日, 施設コード, 投票区コード);
            assertThat(entity.getSecchiJokyo(), is(new RString("テスト投票録　：抄本番号999992：選挙番号1")));

            entity.setSecchiJokyo(new RString("更新済"));
            sut.insertOrUpdate(entity);

            AfT204TohyorokuEntity result = sut.select(抄本9992, 選挙番号1, 報告日, 施設コード, 投票区コード);
            assertThat(result.getSecchiJokyo(), is(new RString("更新済")));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
        }

        @Test
        public void 抄本9991_選挙番号1のentityを指定した場合_deleteが成功し_1が返る() {
            AfT204TohyorokuEntity entity = sut.select(抄本9991, 選挙番号1, 報告日, 施設コード, 投票区コード);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号2));
        }

        @Test
        public void 抄本9992のentityを指定した場合_deleteが成功し_処理件数2件が返る() {
            List<AfT204TohyorokuEntity> entities = sut.select(抄本9992, 報告日);
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
        }

        @Test
        public void 抄本9991_選挙番号1のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT204TohyorokuEntity entity = sut.select(抄本9991, 選挙番号1, 報告日, 施設コード, 投票区コード);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            sut.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
            sut.insertOrUpdate(create投票録(抄本9992, 選挙番号2));
        }

        @Test
        public void 抄本9992のentityを指定した場合_deletePhysicalが成功し_処理件数2件が返る() {
            List<AfT204TohyorokuEntity> entities = sut.select(抄本9992, 報告日);
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT204TohyorokuEntity create投票録(ShohonNo shohonNo, SenkyoNo senkyoNo) {
        return AfT204TohyorokuEntityGenerator.createAfT204TohyorokuEntity(shohonNo, senkyoNo);
    }

    private static void deleteTable(AfT204TohyorokuDac dac) {
        List<AfT204TohyorokuEntity> list = dac.select();
        dac.delete(list);
    }
}
