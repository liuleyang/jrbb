/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import org.junit.BeforeClass;

/**
 * {@link TestBase3}のラッパークラスです。<br/>
 * AFXプロジェクトのデータベースに接続しないテストはこのクラスを継承してください。
 *
 * @author N8168 岩山 慎吾
 * @deprecated 使用してません
 */
public class AfxTestBase extends TestBase3 {

    @Override
    public RString getSubGyomuCD() {
        return new RString("AFX");
    }

    /**
     * サブ業務コードがAFXのコントロールデータをセットします。
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        setDummyControlData(new RString("AFX"));
    }
}
