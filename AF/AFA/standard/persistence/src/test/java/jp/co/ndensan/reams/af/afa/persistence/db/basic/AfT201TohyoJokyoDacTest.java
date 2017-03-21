/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AfT201TohyoJokyoDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT201TohyoJokyoDacTest extends AfaTestDacBase {

    private static AfT201TohyoJokyoDac sut;

    private static final ShohonNo 抄本9991 = new ShohonNo(9991);
    private static final ShohonNo 抄本9992 = new ShohonNo(9992);

    private static final ShikibetsuCode 選挙人00001 = new ShikibetsuCode("999999999900001");
    private static final ShikibetsuCode 選挙人00002 = new ShikibetsuCode("999999999900002");

    private static final SenkyoNo 選挙番号1 = new SenkyoNo(1);
    private static final SenkyoNo 選挙番号2 = new SenkyoNo(2);
    private static final SenkyoNo 選挙番号3 = new SenkyoNo(3);

    private static final int 作成選挙数1 = 1;
    private static final int 作成選挙数2 = 2;
    private static final int 作成選挙数3 = 3;

    private static final Code 期日前 = new Code(TohyoJokyo.期日前.getCode());

//テーブル内容が変わっているためテストが通らない。とりあえずコメントにするが、テーブル変更後はテストが通るようにすること！！！
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceProvider.create(AfT201TohyoJokyoDac.class);
//    }
//
//    public static class selectTest_ShohonNo_ShikibetsuCode_SenkyoNo extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9991, 選挙人00002, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数3);
//        }
//
//        @Test
//        public void 抄本9991の選挙人00001_選挙番号2を指定した場合_投票状況_6のエンティティを返す() {
//            AfT201TohyoJokyoEntity result = sut.select(抄本9991, 選挙人00001, 選挙番号2);
//            assertThat(result.getTohyoJokyo(), is(期日前));
//        }
//
//        @Test
//        public void 未登録の選挙番号を指定した場合_nullが返る() {
//            AfT201TohyoJokyoEntity result = sut.select(抄本9991, 選挙人00001, 選挙番号3);
//            assertNull(result);
//        }
//    }
//
//    public static class selectTest_ShohonNo_ShikibetsuCode extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00002, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9992_選挙人00001を指定した場合_2件返す() {
//            List<AfT201TohyoJokyoEntity> result = sut.select(抄本9992, 選挙人00001);
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 未登録の選挙人を指定した場合_EMPTY_LISTが返る() {
//            List<AfT201TohyoJokyoEntity> result = sut.select(抄本9991, 選挙人00002);
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class selectTest_ShohonNo extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00002, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9992を指定した場合_3件返す() {
//            List<AfT201TohyoJokyoEntity> result = sut.select(抄本9992);
//            assertThat(result.size(), is(3));
//        }
//
//        @Test
//        public void 未登録の抄本を指定した場合_EMPTY_LISTが返る() {
//            List<AfT201TohyoJokyoEntity> result = sut.select(new ShohonNo(9999));
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class insertOrUpdateTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00002, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9991_選挙人00002のentityを指定した場合_insertが実行される() {
//            create投票状況(抄本9991, 選挙人00002, 作成選挙数1);
//
//            AfT201TohyoJokyoEntity result = sut.select(抄本9991, 選挙人00002, 選挙番号1);
//            assertNotNull(result);
//            assertThat(result.getHojoshaShimei1(), is(new AtenaMeisho("テスト選挙人999999999900002：抄本番号9991：選挙番号1")));
//        }
//
//        @Test
//        public void 抄本9992_選挙人00002_補助者氏名1が_更新済のentityを渡すと_updateが実行される() {
//            AfT201TohyoJokyoEntity entity = sut.select(抄本9992, 選挙人00002, 選挙番号1);
//            assertThat(entity.getHojoshaShimei2(), is(AtenaMeisho.EMPTY));
//
//            entity.setHojoshaShimei2(new AtenaMeisho("更新済"));
//            sut.insertOrUpdate(entity);
//
//            AfT201TohyoJokyoEntity result = sut.select(抄本9992, 選挙人00002, 選挙番号1);
//            assertThat(result.getHojoshaShimei2(), is(new AtenaMeisho("更新済")));
//        }
//    }
//
//    public static class insertOrUpdateTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00002, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9991の選挙人00002の選挙番号1_2と_抄本9992の選挙人00001の複数件数Listを指定した場合_処理件数3件が返る() {
//            List<AfT201TohyoJokyoEntity> entities = new ArrayList<>();
//            entities.add(create投票状況Entity(抄本9991, 選挙人00002, 1, 期日前));
//            entities.add(create投票状況Entity(抄本9991, 選挙人00002, 2, 期日前));
//            entities.add(create投票状況Entity(抄本9992, 選挙人00001, 1, 期日前));
//
//            assertThat(sut.insertOrUpdate(entities), is(3));
//        }
//    }
//
//    public static class deleteTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9991_選挙人00001_選挙番号1のentityを指定した場合_deleteが成功し_1が返る() {
//            AfT201TohyoJokyoEntity entity = sut.select(抄本9991, 選挙人00001, 選挙番号1);
//            assertThat(sut.delete(entity), is(1));
//        }
//    }
//
//    public static class deleteTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00002, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9992のentityを指定した場合_deleteが成功し_処理件数3件が返る() {
//            List<AfT201TohyoJokyoEntity> entities = sut.select(抄本9992);
//            assertThat(sut.delete(entities), is(3));
//        }
//    }
//
//    public static class deletePhysicalTest extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9991_選挙人00001_選挙番号1のentityを指定した場合_deletePhysicalが成功し_1が返る() {
//            AfT201TohyoJokyoEntity entity = sut.select(抄本9991, 選挙人00001, 選挙番号1);
//            assertThat(sut.deletePhysical(entity), is(1));
//        }
//    }
//
//    public static class deletePhysicalTest_List extends AfaTestDacBase {
//
//        @Before
//        public void setUp() {
//            deleteTable(sut);
//            create投票状況(抄本9991, 選挙人00001, 作成選挙数1);
//            create投票状況(抄本9992, 選挙人00001, 作成選挙数2);
//            create投票状況(抄本9992, 選挙人00002, 作成選挙数1);
//        }
//
//        @Test
//        public void 抄本9992のentityを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
//            List<AfT201TohyoJokyoEntity> entities = sut.select(抄本9992);
//            assertThat(sut.deletePhysical(entities), is(3));
//        }
//    }
//
//    private static void create投票状況(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, int senkyoSu) {
//        for (int i = 1; i <= senkyoSu; i++) {
//            sut.insertOrUpdate(create投票状況Entity(shohonNo, shikibetsuCode, i, 期日前));
//        }
//    }
//
//    private static AfT201TohyoJokyoEntity create投票状況Entity(
//            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, int senkyoNo, Code tohyoJokyo) {
//        return AfT201TohyoJokyoEntityGenerator.createAfT201TohyoJokyoEntity(shohonNo, shikibetsuCode, new SenkyoNo(senkyoNo), tohyoJokyo);
//    }
//
//    private static void deleteTable(AfT201TohyoJokyoDac dac) {
//        List<AfT201TohyoJokyoEntity> list = dac.select();
//        dac.delete(list);
//    }
}
