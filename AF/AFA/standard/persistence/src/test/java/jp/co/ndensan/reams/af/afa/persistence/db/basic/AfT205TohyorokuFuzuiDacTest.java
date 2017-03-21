/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT204TohyorokuEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT205TohyorokuFuzuiEntityGenerator;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyorokuKomokuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link AfT205TohyorokuFuzuiDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT205TohyorokuFuzuiDacTest extends AfaTestDacBase {

    private static AfT205TohyorokuFuzuiDac sut;
    private static AfT204TohyorokuDac tohyorokuDac;

    private static final ShohonNo 抄本9991 = new ShohonNo(999991);
    private static final ShohonNo 抄本9992 = new ShohonNo(999992);
    private static final ShohonNo 抄本9999 = new ShohonNo(999999);

    private static final SenkyoNo 選挙番号1 = new SenkyoNo(1);

    private static final FlexibleDate 報告日 = AfT204TohyorokuEntityGenerator.DEFAULT_報告年月日;
    private static final RString 施設コード = AfT204TohyorokuEntityGenerator.DEFAULT_施設コード;
    private static final RString 投票区コード = AfT204TohyorokuEntityGenerator.DEFAULT_投票区コード;

    private static final Code 立会人 = new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode());
    private static final Code 再交付者 = new Code(TohyorokuKomokuShurui.再交付者.getCode());
    private static final Code 用紙返還 = new Code(TohyorokuKomokuShurui.用紙返還.getCode());

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(AfT205TohyorokuFuzuiDac.class);
        tohyorokuDac = InstanceProvider.create(AfT204TohyorokuDac.class);
    }

    public static class selectTest_PrimaryKey extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 再交付者));
            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 用紙返還));
        }

        @Test
        public void 抄本9991_選挙番号1_立会人を指定した場合_党派_投票立会人_選管のエンティティを返す() {
            AfT205TohyorokuFuzuiEntity result = sut.select(抄本9991, 選挙番号1, 報告日, 施設コード, 投票区コード, 立会人, 1);
            assertThat(result.getShimei(), is(new AtenaMeisho("テスト投票録付随　：抄本番号999991：選挙番号1：項目種類1")));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_nullが返る() {
            AfT205TohyorokuFuzuiEntity result = sut.select(抄本9992, 選挙番号1, 報告日, 施設コード, 投票区コード, 立会人, 1);
            assertNull(result);
        }
    }

    public static class selectTest_ShohonNo_HokokuYMD extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9999, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 用紙返還));
        }

        @Test
        public void 抄本9992を指定した場合_2件返す() {
            List<AfT205TohyorokuFuzuiEntity> result = sut.select(抄本9992, 報告日);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 未登録の抄本番号を指定した場合_EMPTY_LISTが返る() {
            List<AfT205TohyorokuFuzuiEntity> result = sut.select(抄本9999, 報告日);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9992, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9999, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 用紙返還));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT205TohyorokuFuzuiEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9992, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 用紙返還));
        }

        @Test
        public void 抄本9991_選挙番号1_再交付者のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 再交付者));

            AfT205TohyorokuFuzuiEntity result = sut.select(抄本9991, 選挙番号1, 報告日, 施設コード, 投票区コード, 再交付者, 1);
            assertNotNull(result);
        }

        @Test
        public void 抄本9992_選挙番号1_異常内容が_更新済のentityを渡すと_updateが実行される() {
            AfT205TohyorokuFuzuiEntity entity = sut.select(抄本9992, 選挙番号1, 報告日, 施設コード, 投票区コード, 用紙返還, 1);
            assertThat(entity.getShimei(), is(new AtenaMeisho("テスト投票録付随　：抄本番号999992：選挙番号1：項目種類5")));

            entity.setShimei(new AtenaMeisho("更新済"));
            sut.insertOrUpdate(entity);

            AfT205TohyorokuFuzuiEntity result = sut.select(抄本9992, 選挙番号1, 報告日, 施設コード, 投票区コード, 用紙返還, 1);
            assertThat(result.getShimei(), is(new AtenaMeisho("更新済")));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
        }

        @Test
        public void 抄本9991_選挙番号1_立会人のentityを指定した場合_deleteが成功し_1が返る() {
            AfT205TohyorokuFuzuiEntity entity = sut.select(抄本9991, 選挙番号1, 報告日, 施設コード, 投票区コード, 立会人, 1);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9992, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 用紙返還));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 再交付者));
        }

        @Test
        public void 抄本9992のentityを指定した場合_deleteが成功し_処理件数2件が返る() {
            List<AfT205TohyorokuFuzuiEntity> entities = sut.select(抄本9992, 報告日);
            assertThat(sut.delete(entities), is(2));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
        }

        @Test
        public void 抄本9991_選挙番号1_立会人のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT205TohyorokuFuzuiEntity entity = sut.select(抄本9991, 選挙番号1, 報告日, 施設コード, 投票区コード, 立会人, 1);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            deleteTable(sut);
            tohyorokuDac.delete(tohyorokuDac.select());

            tohyorokuDac.insertOrUpdate(create投票録(抄本9991, 選挙番号1));
            tohyorokuDac.insertOrUpdate(create投票録(抄本9992, 選挙番号1));

            sut.insertOrUpdate(create投票録付随(抄本9991, 選挙番号1, 立会人));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 用紙返還));
            sut.insertOrUpdate(create投票録付随(抄本9992, 選挙番号1, 再交付者));
        }

        @Test
        public void 抄本9992のentityを指定した場合_deletePhysicalが成功し_処理件数2件が返る() {
            List<AfT205TohyorokuFuzuiEntity> entities = sut.select(抄本9992, 報告日);
            assertThat(sut.deletePhysical(entities), is(2));
        }
    }

    private static AfT205TohyorokuFuzuiEntity create投票録付随(ShohonNo shohonNo, SenkyoNo senkyoNo, Code shurui) {
        return AfT205TohyorokuFuzuiEntityGenerator.createAfT205TohyorokuFuzuiEntity(shohonNo, senkyoNo, shurui);
    }

    private static AfT204TohyorokuEntity create投票録(ShohonNo shohonNo, SenkyoNo senkyoNo) {
        return AfT204TohyorokuEntityGenerator.createAfT204TohyorokuEntity(shohonNo, senkyoNo);
    }

    private static void deleteTable(AfT205TohyorokuFuzuiDac dac) {
        List<AfT205TohyorokuFuzuiEntity> list = dac.select();
        dac.delete(list);
    }
}
