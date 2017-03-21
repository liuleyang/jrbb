/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.core;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 選挙人の資格情報を検索する際に条件指定する項目の列挙型のテストクラスです。
 *
 * @author LDNS 黄希文
 */
@RunWith(Enclosed.class)
public class SenkyoninShikakuSearchItemTest extends TestBase3 {

    public static class SenkyoninShikakuSearchItemのテスト extends TestBase3 {

        @Test
        public void LDNS_選挙人の資格情報存在する場合_valuesは_lengthが0を返す() {
            assertThat(SenkyoninShikakuSearchItem.values().length, is(0));
        }
    }
}
