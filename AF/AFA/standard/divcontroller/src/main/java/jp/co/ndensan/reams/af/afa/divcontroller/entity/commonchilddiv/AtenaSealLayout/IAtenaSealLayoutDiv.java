package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout;

import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L AF-0620-013 jihb
 */
public interface IAtenaSealLayoutDiv extends ICommonChildDivBaseProperties {

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblYubinNo
     * @return lblYubinNo
     */
    Label getLblYubinNo();

    /*
     * setLblYubinNo
     * @param lblYubinNo
     */
    void setLblYubinNo(Label lblYubinNo);

    /*
     * getddlRightUp
     * @return ddlRightUp
     */
    DropDownList getDdlRightUp();

    /*
     * setddlRightUp
     * @param ddlRightUp ddlRightUp
     */
    void setDdlRightUp(DropDownList ddlRightUp);

    /*
     * getddlJusho
     * @return ddlJusho
     */
    DropDownList getDdlJusho();

    /*
     * setddlJusho
     * @param ddlJusho ddlJusho
     */
    void setDdlJusho(DropDownList ddlJusho);

    /*
     * gettxtJusho1
     * @return txtJusho1
     */
    TextBox getTxtJusho1();

    /*
     * settxtJusho1
     * @param txtJusho1 txtJusho1
     */
    void setTxtJusho1(TextBox txtJusho1);

    /*
     * gettxtJusho2
     * @return txtJusho2
     */
    TextBox getTxtJusho2();

    /*
     * settxtJusho2
     * @param txtJusho2 txtJusho2
     */
    void setTxtJusho2(TextBox txtJusho2);

    /*
     * gettxtJusho3
     * @return txtJusho3
     */
    TextBox getTxtJusho3();

    /*
     * settxtJusho3
     * @param txtJusho3 txtJusho3
     */
    void setTxtJusho3(TextBox txtJusho3);

    /*
     * getddlAtena
     * @return ddlAtena
     */
    DropDownList getDdlAtena();

    /*
     * setddlAtena
     * @param ddlAtena ddlAtena
     */
    void setDdlAtena(DropDownList ddlAtena);

    /*
     * gettxtAtena1
     * @return txtAtena1
     */
    TextBox getTxtAtena1();

    /*
     * settxtAtena1
     * @param txtAtena1 txtAtena1
     */
    void setTxtAtena1(TextBox txtAtena1);

    /*
     * getddlKeisho1
     * @return ddlKeisho1
     */
    DropDownList getDdlKeisho1();

    /*
     * setddlKeisho1
     * @param ddlKeisho1 ddlKeisho1
     */
    void setDdlKeisho1(DropDownList ddlKeisho1);

    /*
     * gettxtAtena2
     * @return txtAtena2
     */
    TextBox getTxtAtena2();

    /*
     * settxtAtena2
     * @param txtAtena2 txtAtena2
     */
    void setTxtAtena2(TextBox txtAtena2);

    /*
     * getddlKeisho2
     * @return ddlKeisho2
     */
    DropDownList getDdlKeisho2();

    /*
     * setddlKeisho2
     * @param ddlKeisho2 ddlKeisho2
     */
    void setDdlKeisho2(DropDownList ddlKeisho2);

    /*
     * getddlLeftDown
     * @return ddlLeftDown
     */
    DropDownList getDdlLeftDown();

    /*
     * setddlLeftDown
     * @param ddlLeftDown ddlLeftDown
     */
    void setDdlLeftDown(DropDownList ddlLeftDown);

    /*
     * getddlRightDown
     * @return ddlRightDown
     */
    DropDownList getDdlRightDown();

    /*
     * setddlRightDown
     * @param ddlRightDown ddlRightDown
     */
    void setDdlRightDown(DropDownList ddlRightDown);

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    void initialize();

    /**
     * 住所のonChangeのイベントメソッドです。
     *
     */
    void onChange_ddlJusho();

    /**
     * 宛名のonChangeのイベントメソッドです。
     *
     */
    void onChange_ddlAtena();
}
