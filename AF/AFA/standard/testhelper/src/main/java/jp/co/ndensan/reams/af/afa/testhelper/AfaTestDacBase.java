/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/**
 * {@link TestDacBase}のラッパークラスです。<br />
 * AFAプロジェクトのデータベースに接続するテストはこのクラスを継承してください。
 *
 * @author N1823 有澤 礼恵
 */
public class AfaTestDacBase extends TestDacBase3 {

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
    public static void setUpClass() {
        setDummyControlData(new RString("AFA"));
        openMainSession();
    }

    /**
     * テスト後の処理を行います。
     */
    @After
    public void afterTearDown() {
        rollback();
    }

    /**
     * テスト後の処理を行います。
     */
    @AfterClass
    public static void aterTearDownClass() {
        closeSession();
    }
}
