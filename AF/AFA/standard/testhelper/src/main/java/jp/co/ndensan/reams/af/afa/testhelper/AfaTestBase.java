/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import org.junit.BeforeClass;

/**
 * {@link TestBase}のラッパークラスです。<br />
 * AFAプロジェクトのデータベースに接続しないテストはこのクラスを継承してください。
 *
 * @author N1823 有澤 礼恵
 */
public class AfaTestBase extends TestBase3 {

    /**
     * サブ業務コードを指定します。
     *
     * @return サブ業務コード
     */
    @Override
    public RString getSubGyomuCD() {
        return new RString("AFA");
    }

    /**
     * テスト実行前の設定を行います。
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        setDummyControlData(new RString("AFA"));
    }
}
