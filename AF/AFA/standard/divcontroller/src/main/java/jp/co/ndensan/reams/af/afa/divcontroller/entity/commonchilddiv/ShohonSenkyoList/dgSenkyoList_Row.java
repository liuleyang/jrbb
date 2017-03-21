package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed May 18 17:23:50 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSenkyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSenkyoList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">

    private RString txtNo;
    private RString txtSenkyoName;
    private Boolean chkMutohyoSenkyoFlag;

    public dgSenkyoList_Row() {
        super();
        this.txtNo = RString.EMPTY;
        this.txtSenkyoName = RString.EMPTY;
        this.chkMutohyoSenkyoFlag = false;
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
    }

    public dgSenkyoList_Row(RString txtNo, RString txtSenkyoName, Boolean chkMutohyoSenkyoFlag) {
        super();
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.txtNo = txtNo;
        this.txtSenkyoName = txtSenkyoName;
        this.chkMutohyoSenkyoFlag = chkMutohyoSenkyoFlag;
    }

    public RString getTxtNo() {
        return txtNo;
    }

    public RString getTxtSenkyoName() {
        return txtSenkyoName;
    }

    public Boolean getChkMutohyoSenkyoFlag() {
        return chkMutohyoSenkyoFlag;
    }

    public void setTxtNo(RString txtNo) {
        this.setOriginalData("txtNo", txtNo);
        this.txtNo = txtNo;
    }

    public void setTxtSenkyoName(RString txtSenkyoName) {
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.txtSenkyoName = txtSenkyoName;
    }

    public void setChkMutohyoSenkyoFlag(Boolean chkMutohyoSenkyoFlag) {
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.chkMutohyoSenkyoFlag = chkMutohyoSenkyoFlag;
    }

    // </editor-fold>
}
