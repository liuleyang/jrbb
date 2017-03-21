/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.domain;

import jp.co.ndensan.reams.af.afa.testhelper.AfaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 選挙番号のテストクラスです。
 *
 * @author N1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class SenkyoNoTest extends AfaTestBase {

    private static SenkyoNo sut;

    @BeforeClass
    public static void setUpClass() {
        sut = new SenkyoNo(new Integer(10));
    }

    public static class コンストラクタ extends AfaTestBase {

        @Test
        public void コンストラクタ引数のvalueに_10を指定した場合_valueは_10を返す() {
            assertThat(sut.value(), is(new Integer(10)));
        }

        @Test
        public void コンストラクタ引数のvalueに_10を指定した場合_getColumnValueは_10を返す() {
            assertThat(sut.getColumnValue(), is(new Integer(10)));
        }
    }

    public static class Equals extends AfaTestBase {

        @Test
        public void valueが同じ場合_trueを返す() {
            SenkyoNo other = new SenkyoNo(new Integer(10));
            assertTrue(sut.equals(other));
        }

        @Test
        public void valueが異なる場合_falseを返す() {
            SenkyoNo other = new SenkyoNo(new Integer(99));
            assertFalse(sut.equals(other));
        }
    }

    public static class CompareTo extends AfaTestBase {

        @Test
        public void valueが小さい値と比較した場合_1を返す() {
            SenkyoNo other = new SenkyoNo(new Integer(9));
            assertThat(sut.compareTo(other), is(1));
        }

        @Test
        public void valueが同じ値と比較した場合_0を返す() {
            SenkyoNo other = new SenkyoNo(new Integer(10));
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void valueが大きい値と比較した場合_マイナス1を返す() {
            SenkyoNo other = new SenkyoNo(new Integer(11));
            assertThat(sut.compareTo(other), is(-1));
        }
    }
}
