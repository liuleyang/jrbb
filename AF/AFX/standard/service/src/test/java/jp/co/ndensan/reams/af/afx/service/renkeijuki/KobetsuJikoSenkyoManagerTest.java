/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.renkeijuki;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afx.business.renkeijuki.KobetsuJikoSenkyo;
import jp.co.ndensan.reams.af.afx.definition.mybatis.KobetsuJikoSenkyoFinderParameter;
import jp.co.ndensan.reams.af.afx.entity.renkeijuki.KobetsuJikoSenkyoEntity;
import jp.co.ndensan.reams.af.afx.persistence.renkeijuki.KobetsuJikoSenkyoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * {@link KobetsuJikoSenkyoManager}のテストクラスです。
 *
 * @author
 */
@RunWith(Enclosed.class)
public class KobetsuJikoSenkyoManagerTest {

    private static KobetsuJikoSenkyoManager sut;
    private static final KobetsuJikoSenkyoDac SENKYO_DAC = mock(KobetsuJikoSenkyoDac.class);

    public static class selectTest {

        @Before
        public void setup() {
            sut = new KobetsuJikoSenkyoManager(SENKYO_DAC);
        }

        @Test
        public void selectを実行すると_KobetsuJikoSenkyoのリストが返る() {
            ShikibetsuCode code = new ShikibetsuCode("999999999900001");
            Code senkyoShikaku = new Code("1");
            FlexibleDate torokuYMD = new FlexibleDate("20160901");
            KobetsuJikoSenkyoEntity entity = getSpiedInstance(code, senkyoShikaku);
            when(SENKYO_DAC.select(Matchers.any(KobetsuJikoSenkyoFinderParameter.class))).thenReturn(Arrays.asList(entity));
            List<KobetsuJikoSenkyo> result = sut.select(new KobetsuJikoSenkyoFinderParameter(Arrays.asList(code), torokuYMD));
            assertThat(result.get(0), is(KobetsuJikoSenkyo.class));
        }

        @Test
        public void 対象なしの場合_0件リストを返す() {
            ShikibetsuCode code = new ShikibetsuCode("999999999900001");
            FlexibleDate torokuYMD = new FlexibleDate("20160629");
            when(SENKYO_DAC.select(Matchers.any(KobetsuJikoSenkyoFinderParameter.class))).thenReturn(Collections.EMPTY_LIST);
            List<KobetsuJikoSenkyo> result = sut.select(new KobetsuJikoSenkyoFinderParameter(Arrays.asList(code), torokuYMD));
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 有権者データの場合_有_を返す() {
            ShikibetsuCode code = new ShikibetsuCode("999999999900001");
            Code senkyoShikaku = new Code("1");
            FlexibleDate torokuYMD = new FlexibleDate("20160629");
            KobetsuJikoSenkyoEntity entity = getSpiedInstance(code, senkyoShikaku);
            when(SENKYO_DAC.select(Matchers.any(KobetsuJikoSenkyoFinderParameter.class))).thenReturn(Arrays.asList(entity));
            List<KobetsuJikoSenkyo> result = sut.select(new KobetsuJikoSenkyoFinderParameter(Arrays.asList(code), torokuYMD));
            assertThat(result.size(), is(1));
            assertThat(result.get(0).getSenkyoShikaku(), is(new RString("有")));
        }

        @Test
        public void 表示者データの場合_有_を返す() {
            ShikibetsuCode code = new ShikibetsuCode("999999999900001");
            Code senkyoShikaku = new Code("2");
            FlexibleDate torokuYMD = new FlexibleDate("20160629");
            KobetsuJikoSenkyoEntity entity = getSpiedInstance(code, senkyoShikaku);
            when(SENKYO_DAC.select(Matchers.any(KobetsuJikoSenkyoFinderParameter.class))).thenReturn(Arrays.asList(entity));
            List<KobetsuJikoSenkyo> result = sut.select(new KobetsuJikoSenkyoFinderParameter(Arrays.asList(code), torokuYMD));
            assertThat(result.size(), is(1));
            assertThat(result.get(0).getSenkyoShikaku(), is(new RString("有")));
        }

        @Test
        public void 抹消者データの場合_空白_を返す() {
            ShikibetsuCode code = new ShikibetsuCode("999999999900001");
            Code senkyoShikaku = new Code("3");
            FlexibleDate kijunYMD = new FlexibleDate("20161231");
            KobetsuJikoSenkyoEntity entity = getSpiedInstance(code, senkyoShikaku);
            when(SENKYO_DAC.select(Matchers.any(KobetsuJikoSenkyoFinderParameter.class))).thenReturn(Arrays.asList(entity));
            List<KobetsuJikoSenkyo> result = sut.select(new KobetsuJikoSenkyoFinderParameter(Arrays.asList(code), kijunYMD));
            assertThat(result.size(), is(1));
            assertThat(result.get(0).getSenkyoShikaku(), is(RString.FULL_SPACE));
        }

        @Test
        public void 公民権停止者のデータの場合_有_を返す() {
            ShikibetsuCode code = new ShikibetsuCode("999999999900001");
            Code senkyoShikaku = new Code("4");
            FlexibleDate kijunYMD = new FlexibleDate("20161231");
            KobetsuJikoSenkyoEntity entity = getSpiedInstance(code, senkyoShikaku);
            when(SENKYO_DAC.select(Matchers.any(KobetsuJikoSenkyoFinderParameter.class))).thenReturn(Arrays.asList(entity));
            List<KobetsuJikoSenkyo> result = sut.select(new KobetsuJikoSenkyoFinderParameter(Arrays.asList(code), kijunYMD));
            assertThat(result.size(), is(1));
            assertThat(result.get(0).getSenkyoShikaku(), is(new RString("有")));
        }

    }

    public static KobetsuJikoSenkyoEntity getSpiedInstance(
            ShikibetsuCode shikibetsuCode, Code senkyoShikaku) {
        KobetsuJikoSenkyoEntity entity = new KobetsuJikoSenkyoEntity(
                shikibetsuCode, senkyoShikaku);
        return spy(entity);
    }

}
