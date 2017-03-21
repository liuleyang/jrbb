/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.core;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 選挙人の資格情報を検索するのテストクラスです。
 *
 * @author LDNS 蘇広俊
 */
@RunWith(Enclosed.class)
public class JukiServiceTest extends TestBase3 {

    private static JukiService sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(JukiService.class);
    }

    public static class createSenkyoninShikakuFinderのテスト extends TestBase3 {

        @Test
        public void LDNS_データが見つかる_createSenkyoninShikakuFinderは_非空結果を返す() {

            ISenkyoninShikakuFinder iSenkyoninShikakuFinder = sut.createSenkyoninShikakuFinder();
            assertNotNull(iSenkyoninShikakuFinder);
        }

    }
}
