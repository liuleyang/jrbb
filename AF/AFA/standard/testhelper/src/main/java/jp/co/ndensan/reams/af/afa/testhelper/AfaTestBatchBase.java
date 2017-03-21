/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * {@link TestDacBase3}のラッパークラスです。<br />
 * DOAプロジェクトのデータベースに接続するテストはこのクラスを継承してください。
 *
 * @author N2806 太田 智之
 */
public class AfaTestBatchBase extends TestDacBase3 {

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
