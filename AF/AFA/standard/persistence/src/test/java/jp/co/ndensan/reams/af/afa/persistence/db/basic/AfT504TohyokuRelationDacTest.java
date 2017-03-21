/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT501TohyokuEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT502TohyojoEntityGenerator;
import jp.co.ndensan.reams.af.afa.entity.db.basic.helper.AfT504TohyokuRelationEntityGenerator;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link AfT504TohyokuRelationDac}のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AfT504TohyokuRelationDacTest extends AfaTestDacBase {

    private static AfT504TohyokuRelationDac sut;
    private static AfT501TohyokuDac tohyokuDac;
    private static AfT502TohyojoDac tohyojoDac;

    private static final Code 通常選挙 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    private static final Code 国民投票 = new Code(SenkyoShurui.憲法改正国民投票.getCode());
    private static final Code 農委選挙 = new Code(SenkyoShurui.農業委員会委員選挙.getCode());
    private static final Code 未存在選挙種類 = new Code("Z");

    private static final RString 投票区T01 = new RString("T01");
    private static final RString 投票区T02 = new RString("T02");
    private static final RString 投票区T03 = new RString("T03");
    private static final RString 投票区T04 = new RString("T04");

    @BeforeClass
    public static void setUpClass() {
        tohyokuDac = InstanceProvider.create(AfT501TohyokuDac.class);
        tohyojoDac = InstanceProvider.create(AfT502TohyojoDac.class);
        sut = InstanceProvider.create(AfT504TohyokuRelationDac.class);
    }

    public static class selectTest_SenkyoShurui_TohyokuCode extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T02));
        }

        @Test
        public void 通常選挙の投票区T02を指定した場合_投票所_1T02のエンティティを返す() {
            AfT504TohyokuRelationEntity result = sut.select(通常選挙, 投票区T02);
            assertThat(result.getTohyojoCode(), is(new RString("1T02")));
        }

        @Test
        public void 未登録の投票区を指定した場合_nullが返る() {
            AfT504TohyokuRelationEntity result = sut.select(未存在選挙種類, 投票区T01);
            assertNull(result);
        }
    }

    public static class selectTest_SenkyoShurui extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T02));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T03));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T02));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T03));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T04));
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T02));
        }

        @Test
        public void 通常選挙を指定した場合_3件返す() {
            List<AfT504TohyokuRelationEntity> result = sut.select(通常選挙);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 未登録の選挙種類を指定した場合_EMPTY_LISTが返る() {
            List<AfT504TohyokuRelationEntity> result = sut.select(未存在選挙種類);
            assertThat(result, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectTest_All extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T01));
        }

        @Test
        public void selectした場合_3件返す() {
            List<AfT504TohyokuRelationEntity> result = sut.select();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertOrUpdateTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T02));
        }

        @Test
        public void 国民投票の投票区T03のentityを指定した場合_insertが実行される() {
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T03));

            AfT504TohyokuRelationEntity result = sut.select(国民投票, 投票区T03);
            assertNotNull(result);
            assertThat(result.getTohyojoCode(), is(new RString("2T03")));
        }

        @Test
        public void 国民投票の投票区T01_選挙区999のentityを渡すと_updateが実行される() {
            AfT504TohyokuRelationEntity entity = sut.select(国民投票, 投票区T01);
            assertThat(entity.getSenkyokuCode(), is(RString.EMPTY));

            entity.setSenkyokuCode(new RString("999"));
            sut.insertOrUpdate(entity);

            AfT504TohyokuRelationEntity result = sut.select(国民投票, 投票区T01);
            assertThat(result.getSenkyokuCode(), is(new RString("999")));
        }
    }

    public static class insertOrUpdateTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(国民投票, 投票区T01));
        }

        @Test
        public void 通常選挙の投票区T02_T03と国民投票の投票区T01の複数件数Listを指定した場合_処理件数3件が返る() {
            List<AfT504TohyokuRelationEntity> entities = new ArrayList<>();
            entities.add(create投票区投票所(通常選挙, 投票区T02));
            entities.add(create投票区投票所(通常選挙, 投票区T03));
            entities.add(create投票区投票所(国民投票, 投票区T01));

            assertThat(sut.insertOrUpdate(entities), is(3));
        }
    }

    public static class deleteTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
        }

        @Test
        public void 通常選挙の投票区T01のentityを指定した場合_deleteが成功し_1が返る() {
            AfT504TohyokuRelationEntity entity = sut.select(通常選挙, 投票区T01);
            assertThat(sut.delete(entity), is(1));
        }
    }

    public static class deleteTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T02));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T03));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T01));
        }

        @Test
        public void 通常選挙のentityリストを指定した場合_deleteが成功し_処理件数3件が返る() {
            List<AfT504TohyokuRelationEntity> entities = sut.select(通常選挙);
            assertThat(sut.delete(entities), is(3));
        }
    }

    public static class deletePhysicalTest extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
        }

        @Test
        public void 通常選挙の投票区T01のentityを指定した場合_deletePhysicalが成功し_1が返る() {
            AfT504TohyokuRelationEntity entity = sut.select(通常選挙, 投票区T01);
            assertThat(sut.deletePhysical(entity), is(1));
        }
    }

    public static class deletePhysicalTest_List extends AfaTestDacBase {

        @Before
        public void setUp() {
            populate();
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T01));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T02));
            sut.insertOrUpdate(create投票区投票所(通常選挙, 投票区T03));
            sut.insertOrUpdate(create投票区投票所(農委選挙, 投票区T01));
        }

        @Test
        public void 通常選挙のentityリストを指定した場合_deletePhysicalが成功し_処理件数3件が返る() {
            List<AfT504TohyokuRelationEntity> entities = sut.select(通常選挙);
            assertThat(sut.deletePhysical(entities), is(3));
        }
    }

    private static AfT501TohyokuEntity create投票区(Code senkyoShurui, RString tohyokuCode) {
        return AfT501TohyokuEntityGenerator.createAfT501TohyokuEntity(senkyoShurui, tohyokuCode);
    }

    private static AfT502TohyojoEntity create投票所(Code senkyoShurui, RString tohyokuCode) {
        return AfT502TohyojoEntityGenerator.createAfT502TohyojoEntity(new RString(senkyoShurui.toString() + tohyokuCode.toString()));
    }

    private static AfT504TohyokuRelationEntity create投票区投票所(Code senkyoShurui, RString tohyokuCode) {
        return AfT504TohyokuRelationEntityGenerator.createAfT504TohyokuRelationEntity(senkyoShurui, tohyokuCode);
    }

    private static void populate() {
        deleteTable(sut);
        tohyokuDac.delete(tohyokuDac.select());
        tohyojoDac.delete(tohyojoDac.select());

        tohyokuDac.insertOrUpdate(create投票区(通常選挙, 投票区T01));
        tohyokuDac.insertOrUpdate(create投票区(通常選挙, 投票区T02));
        tohyokuDac.insertOrUpdate(create投票区(通常選挙, 投票区T03));

        tohyojoDac.insertOrUpdate(create投票所(通常選挙, 投票区T01));
        tohyojoDac.insertOrUpdate(create投票所(通常選挙, 投票区T02));
        tohyojoDac.insertOrUpdate(create投票所(通常選挙, 投票区T03));

        tohyokuDac.insertOrUpdate(create投票区(農委選挙, 投票区T01));
        tohyokuDac.insertOrUpdate(create投票区(農委選挙, 投票区T02));
        tohyokuDac.insertOrUpdate(create投票区(農委選挙, 投票区T03));
        tohyokuDac.insertOrUpdate(create投票区(農委選挙, 投票区T04));

        tohyojoDac.insertOrUpdate(create投票所(農委選挙, 投票区T01));
        tohyojoDac.insertOrUpdate(create投票所(農委選挙, 投票区T02));
        tohyojoDac.insertOrUpdate(create投票所(農委選挙, 投票区T03));
        tohyojoDac.insertOrUpdate(create投票所(農委選挙, 投票区T04));

        tohyokuDac.insertOrUpdate(create投票区(国民投票, 投票区T01));
        tohyokuDac.insertOrUpdate(create投票区(国民投票, 投票区T02));
        tohyokuDac.insertOrUpdate(create投票区(国民投票, 投票区T03));

        tohyojoDac.insertOrUpdate(create投票所(国民投票, 投票区T01));
        tohyojoDac.insertOrUpdate(create投票所(国民投票, 投票区T02));
        tohyojoDac.insertOrUpdate(create投票所(国民投票, 投票区T03));
    }

    private static void deleteTable(AfT504TohyokuRelationDac dac) {
        List<AfT504TohyokuRelationEntity> list = dac.select();
        dac.delete(list);
    }
}
