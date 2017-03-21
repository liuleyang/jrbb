package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sun Sep 18 21:10:28 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSenkyokuSelect_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSenkyokuSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtSenkyokuCode;
    private RString txtSenkyokuName;
    private RString txtSenkyoShurui;
    private RString txtSenkyoShuruiCode;

    public dgSenkyokuSelect_Row() {
        super();
        this.txtSenkyokuCode = RString.EMPTY;
        this.txtSenkyokuName = RString.EMPTY;
        this.txtSenkyoShurui = RString.EMPTY;
        this.txtSenkyoShuruiCode = RString.EMPTY;
        this.setOriginalData("txtSenkyokuCode", txtSenkyokuCode);
        this.setOriginalData("txtSenkyokuName", txtSenkyokuName);
        this.setOriginalData("txtSenkyoShurui", txtSenkyoShurui);
        this.setOriginalData("txtSenkyoShuruiCode", txtSenkyoShuruiCode);
    }

    public dgSenkyokuSelect_Row(RString txtSenkyokuCode, RString txtSenkyokuName, RString txtSenkyoShurui, RString txtSenkyoShuruiCode) {
        super();
        this.setOriginalData("txtSenkyokuCode", txtSenkyokuCode);
        this.setOriginalData("txtSenkyokuName", txtSenkyokuName);
        this.setOriginalData("txtSenkyoShurui", txtSenkyoShurui);
        this.setOriginalData("txtSenkyoShuruiCode", txtSenkyoShuruiCode);
        this.txtSenkyokuCode = txtSenkyokuCode;
        this.txtSenkyokuName = txtSenkyokuName;
        this.txtSenkyoShurui = txtSenkyoShurui;
        this.txtSenkyoShuruiCode = txtSenkyoShuruiCode;
    }

    public RString getTxtSenkyokuCode() {
        return txtSenkyokuCode;
    }

    public RString getTxtSenkyokuName() {
        return txtSenkyokuName;
    }

    public RString getTxtSenkyoShurui() {
        return txtSenkyoShurui;
    }

    public RString getTxtSenkyoShuruiCode() {
        return txtSenkyoShuruiCode;
    }

    public void setTxtSenkyokuCode(RString txtSenkyokuCode) {
        this.setOriginalData("txtSenkyokuCode", txtSenkyokuCode);
        this.txtSenkyokuCode = txtSenkyokuCode;
    }

    public void setTxtSenkyokuName(RString txtSenkyokuName) {
        this.setOriginalData("txtSenkyokuName", txtSenkyokuName);
        this.txtSenkyokuName = txtSenkyokuName;
    }

    public void setTxtSenkyoShurui(RString txtSenkyoShurui) {
        this.setOriginalData("txtSenkyoShurui", txtSenkyoShurui);
        this.txtSenkyoShurui = txtSenkyoShurui;
    }

    public void setTxtSenkyoShuruiCode(RString txtSenkyoShuruiCode) {
        this.setOriginalData("txtSenkyoShuruiCode", txtSenkyoShuruiCode);
        this.txtSenkyoShuruiCode = txtSenkyoShuruiCode;
    }

    // </editor-fold>
}
