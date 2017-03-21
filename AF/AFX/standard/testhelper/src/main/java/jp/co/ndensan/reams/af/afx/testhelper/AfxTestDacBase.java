/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author
 */
public class AfxTestDacBase extends TestDacBase3 {

    /**
     * サブ業務コードを設定します。
     *
     * @return サブ業務コード
     */
    public RString getSubGyomucd() {
        return new RString("AFX");
    }

    /**
     * 事前準備を行います。
     */
    @BeforeClass
    public static void beforesetUpClass() {
        setDummyControlData(new RString("AFX"));
        openMainSession();
    }

    /**
     * ロールバックを行います。
     */
    @After
    public void afterTearDown() {
        rollback();
    }

    /**
     * セッションを終了します。
     */
    @AfterClass
    public static void afterTearDownClass() {
        closeSession();
    }

}
