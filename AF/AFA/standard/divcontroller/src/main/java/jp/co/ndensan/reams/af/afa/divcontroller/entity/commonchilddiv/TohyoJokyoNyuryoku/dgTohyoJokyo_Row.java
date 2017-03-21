package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 23 14:36:47 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgTohyoJokyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTohyoJokyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtTohyoJokyo;
    private RString txtSenkyoRyakusho;
    private RString txtUketsukeNo;
    private TextBoxFlexibleDate txtUketsukeYMD;
    private TextBoxTime txtUketsukeTime;
    private RString txtTohyoJiyu;
    private RString txtShisetsu;
    private RString txtSeikyuHoho;
    private Boolean chkTenjiFlag;
    private Boolean chkDairiFlag;
    private RString txtHojoshaShimei1;
    private RString txtHojoshaShimei2;
    private RString txtKyohiJiyu;
    private TextBoxNum txtSenkyoNo;
    private RString txtTohyoJiyuCode;
    private RString txtShisetsuCode;
    private RString txtSeikyuHohoCode;
    private RString txtHojoshaShikibetsuCode1;
    private RString txtHojoshaShikibetsuCode2;
    private RString txtSenkyoShuruiCode;
    private Boolean chkMutohyo;
    private Boolean senkyoShikakuFlg;
    private Boolean tohyoJokyoFlg;
    private RString tohyoJokyoCode;
    private TextBoxFlexibleDate txtTohyoUketsukeYMD;
    private RString rowData;
    private RString reamsClientId;

    public dgTohyoJokyo_Row() {
        super();
        this.txtTohyoJokyo = RString.EMPTY;
        this.txtSenkyoRyakusho = RString.EMPTY;
        this.txtUketsukeNo = RString.EMPTY;
        this.txtUketsukeYMD = new TextBoxFlexibleDate();
        this.txtUketsukeTime = new TextBoxTime();
        this.txtTohyoJiyu = RString.EMPTY;
        this.txtShisetsu = RString.EMPTY;
        this.txtSeikyuHoho = RString.EMPTY;
        this.chkTenjiFlag = false;
        this.chkDairiFlag = false;
        this.txtHojoshaShimei1 = RString.EMPTY;
        this.txtHojoshaShimei2 = RString.EMPTY;
        this.txtKyohiJiyu = RString.EMPTY;
        this.txtSenkyoNo = new TextBoxNum();
        this.txtTohyoJiyuCode = RString.EMPTY;
        this.txtShisetsuCode = RString.EMPTY;
        this.txtSeikyuHohoCode = RString.EMPTY;
        this.txtHojoshaShikibetsuCode1 = RString.EMPTY;
        this.txtHojoshaShikibetsuCode2 = RString.EMPTY;
        this.txtSenkyoShuruiCode = RString.EMPTY;
        this.chkMutohyo = false;
        this.senkyoShikakuFlg = false;
        this.tohyoJokyoFlg = false;
        this.tohyoJokyoCode = RString.EMPTY;
        this.txtTohyoUketsukeYMD = new TextBoxFlexibleDate();
        this.rowData = RString.EMPTY;
        this.reamsClientId = RString.EMPTY;
        this.setOriginalData("txtTohyoJokyo", txtTohyoJokyo);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.setOriginalData("txtUketsukeYMD", txtUketsukeYMD);
        this.setOriginalData("txtUketsukeTime", txtUketsukeTime);
        this.setOriginalData("txtTohyoJiyu", txtTohyoJiyu);
        this.setOriginalData("txtShisetsu", txtShisetsu);
        this.setOriginalData("txtSeikyuHoho", txtSeikyuHoho);
        this.setOriginalData("chkTenjiFlag", chkTenjiFlag);
        this.setOriginalData("chkDairiFlag", chkDairiFlag);
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.setOriginalData("txtKyohiJiyu", txtKyohiJiyu);
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtTohyoJiyuCode", txtTohyoJiyuCode);
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.setOriginalData("txtSeikyuHohoCode", txtSeikyuHohoCode);
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.setOriginalData("txtSenkyoShuruiCode", txtSenkyoShuruiCode);
        this.setOriginalData("chkMutohyo", chkMutohyo);
        this.setOriginalData("senkyoShikakuFlg", senkyoShikakuFlg);
        this.setOriginalData("tohyoJokyoFlg", tohyoJokyoFlg);
        this.setOriginalData("tohyoJokyoCode", tohyoJokyoCode);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("rowData", rowData);
        this.setOriginalData("reamsClientId", reamsClientId);
    }

    public dgTohyoJokyo_Row(RString txtTohyoJokyo, RString txtSenkyoRyakusho, RString txtUketsukeNo, TextBoxFlexibleDate txtUketsukeYMD, TextBoxTime txtUketsukeTime, RString txtTohyoJiyu, RString txtShisetsu, RString txtSeikyuHoho, Boolean chkTenjiFlag, Boolean chkDairiFlag, RString txtHojoshaShimei1, RString txtHojoshaShimei2, RString txtKyohiJiyu, TextBoxNum txtSenkyoNo, RString txtTohyoJiyuCode, RString txtShisetsuCode, RString txtSeikyuHohoCode, RString txtHojoshaShikibetsuCode1, RString txtHojoshaShikibetsuCode2, RString txtSenkyoShuruiCode, Boolean chkMutohyo, Boolean senkyoShikakuFlg, Boolean tohyoJokyoFlg, RString tohyoJokyoCode, TextBoxFlexibleDate txtTohyoUketsukeYMD, RString rowData, RString reamsClientId) {
        super();
        this.setOriginalData("txtTohyoJokyo", txtTohyoJokyo);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.setOriginalData("txtUketsukeYMD", txtUketsukeYMD);
        this.setOriginalData("txtUketsukeTime", txtUketsukeTime);
        this.setOriginalData("txtTohyoJiyu", txtTohyoJiyu);
        this.setOriginalData("txtShisetsu", txtShisetsu);
        this.setOriginalData("txtSeikyuHoho", txtSeikyuHoho);
        this.setOriginalData("chkTenjiFlag", chkTenjiFlag);
        this.setOriginalData("chkDairiFlag", chkDairiFlag);
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.setOriginalData("txtKyohiJiyu", txtKyohiJiyu);
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtTohyoJiyuCode", txtTohyoJiyuCode);
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.setOriginalData("txtSeikyuHohoCode", txtSeikyuHohoCode);
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.setOriginalData("txtSenkyoShuruiCode", txtSenkyoShuruiCode);
        this.setOriginalData("chkMutohyo", chkMutohyo);
        this.setOriginalData("senkyoShikakuFlg", senkyoShikakuFlg);
        this.setOriginalData("tohyoJokyoFlg", tohyoJokyoFlg);
        this.setOriginalData("tohyoJokyoCode", tohyoJokyoCode);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("rowData", rowData);
        this.setOriginalData("reamsClientId", reamsClientId);
        this.txtTohyoJokyo = txtTohyoJokyo;
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
        this.txtUketsukeNo = txtUketsukeNo;
        this.txtUketsukeYMD = txtUketsukeYMD;
        this.txtUketsukeTime = txtUketsukeTime;
        this.txtTohyoJiyu = txtTohyoJiyu;
        this.txtShisetsu = txtShisetsu;
        this.txtSeikyuHoho = txtSeikyuHoho;
        this.chkTenjiFlag = chkTenjiFlag;
        this.chkDairiFlag = chkDairiFlag;
        this.txtHojoshaShimei1 = txtHojoshaShimei1;
        this.txtHojoshaShimei2 = txtHojoshaShimei2;
        this.txtKyohiJiyu = txtKyohiJiyu;
        this.txtSenkyoNo = txtSenkyoNo;
        this.txtTohyoJiyuCode = txtTohyoJiyuCode;
        this.txtShisetsuCode = txtShisetsuCode;
        this.txtSeikyuHohoCode = txtSeikyuHohoCode;
        this.txtHojoshaShikibetsuCode1 = txtHojoshaShikibetsuCode1;
        this.txtHojoshaShikibetsuCode2 = txtHojoshaShikibetsuCode2;
        this.txtSenkyoShuruiCode = txtSenkyoShuruiCode;
        this.chkMutohyo = chkMutohyo;
        this.senkyoShikakuFlg = senkyoShikakuFlg;
        this.tohyoJokyoFlg = tohyoJokyoFlg;
        this.tohyoJokyoCode = tohyoJokyoCode;
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
        this.rowData = rowData;
        this.reamsClientId = reamsClientId;
    }

    public RString getTxtTohyoJokyo() {
        return txtTohyoJokyo;
    }

    public RString getTxtSenkyoRyakusho() {
        return txtSenkyoRyakusho;
    }

    public RString getTxtUketsukeNo() {
        return txtUketsukeNo;
    }

    public TextBoxFlexibleDate getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    public TextBoxTime getTxtUketsukeTime() {
        return txtUketsukeTime;
    }

    public RString getTxtTohyoJiyu() {
        return txtTohyoJiyu;
    }

    public RString getTxtShisetsu() {
        return txtShisetsu;
    }

    public RString getTxtSeikyuHoho() {
        return txtSeikyuHoho;
    }

    public Boolean getChkTenjiFlag() {
        return chkTenjiFlag;
    }

    public Boolean getChkDairiFlag() {
        return chkDairiFlag;
    }

    public RString getTxtHojoshaShimei1() {
        return txtHojoshaShimei1;
    }

    public RString getTxtHojoshaShimei2() {
        return txtHojoshaShimei2;
    }

    public RString getTxtKyohiJiyu() {
        return txtKyohiJiyu;
    }

    public TextBoxNum getTxtSenkyoNo() {
        return txtSenkyoNo;
    }

    public RString getTxtTohyoJiyuCode() {
        return txtTohyoJiyuCode;
    }

    public RString getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    public RString getTxtSeikyuHohoCode() {
        return txtSeikyuHohoCode;
    }

    public RString getTxtHojoshaShikibetsuCode1() {
        return txtHojoshaShikibetsuCode1;
    }

    public RString getTxtHojoshaShikibetsuCode2() {
        return txtHojoshaShikibetsuCode2;
    }

    public RString getTxtSenkyoShuruiCode() {
        return txtSenkyoShuruiCode;
    }

    public Boolean getChkMutohyo() {
        return chkMutohyo;
    }

    public Boolean getSenkyoShikakuFlg() {
        return senkyoShikakuFlg;
    }

    public Boolean getTohyoJokyoFlg() {
        return tohyoJokyoFlg;
    }

    public RString getTohyoJokyoCode() {
        return tohyoJokyoCode;
    }

    public TextBoxFlexibleDate getTxtTohyoUketsukeYMD() {
        return txtTohyoUketsukeYMD;
    }

    public RString getRowData() {
        return rowData;
    }

    public RString getReamsClientId() {
        return reamsClientId;
    }

    public void setTxtTohyoJokyo(RString txtTohyoJokyo) {
        this.setOriginalData("txtTohyoJokyo", txtTohyoJokyo);
        this.txtTohyoJokyo = txtTohyoJokyo;
    }

    public void setTxtSenkyoRyakusho(RString txtSenkyoRyakusho) {
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
    }

    public void setTxtUketsukeNo(RString txtUketsukeNo) {
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.txtUketsukeNo = txtUketsukeNo;
    }

    public void setTxtUketsukeYMD(TextBoxFlexibleDate txtUketsukeYMD) {
        this.setOriginalData("txtUketsukeYMD", txtUketsukeYMD);
        this.txtUketsukeYMD = txtUketsukeYMD;
    }

    public void setTxtUketsukeTime(TextBoxTime txtUketsukeTime) {
        this.setOriginalData("txtUketsukeTime", txtUketsukeTime);
        this.txtUketsukeTime = txtUketsukeTime;
    }

    public void setTxtTohyoJiyu(RString txtTohyoJiyu) {
        this.setOriginalData("txtTohyoJiyu", txtTohyoJiyu);
        this.txtTohyoJiyu = txtTohyoJiyu;
    }

    public void setTxtShisetsu(RString txtShisetsu) {
        this.setOriginalData("txtShisetsu", txtShisetsu);
        this.txtShisetsu = txtShisetsu;
    }

    public void setTxtSeikyuHoho(RString txtSeikyuHoho) {
        this.setOriginalData("txtSeikyuHoho", txtSeikyuHoho);
        this.txtSeikyuHoho = txtSeikyuHoho;
    }

    public void setChkTenjiFlag(Boolean chkTenjiFlag) {
        this.setOriginalData("chkTenjiFlag", chkTenjiFlag);
        this.chkTenjiFlag = chkTenjiFlag;
    }

    public void setChkDairiFlag(Boolean chkDairiFlag) {
        this.setOriginalData("chkDairiFlag", chkDairiFlag);
        this.chkDairiFlag = chkDairiFlag;
    }

    public void setTxtHojoshaShimei1(RString txtHojoshaShimei1) {
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.txtHojoshaShimei1 = txtHojoshaShimei1;
    }

    public void setTxtHojoshaShimei2(RString txtHojoshaShimei2) {
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.txtHojoshaShimei2 = txtHojoshaShimei2;
    }

    public void setTxtKyohiJiyu(RString txtKyohiJiyu) {
        this.setOriginalData("txtKyohiJiyu", txtKyohiJiyu);
        this.txtKyohiJiyu = txtKyohiJiyu;
    }

    public void setTxtSenkyoNo(TextBoxNum txtSenkyoNo) {
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.txtSenkyoNo = txtSenkyoNo;
    }

    public void setTxtTohyoJiyuCode(RString txtTohyoJiyuCode) {
        this.setOriginalData("txtTohyoJiyuCode", txtTohyoJiyuCode);
        this.txtTohyoJiyuCode = txtTohyoJiyuCode;
    }

    public void setTxtShisetsuCode(RString txtShisetsuCode) {
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.txtShisetsuCode = txtShisetsuCode;
    }

    public void setTxtSeikyuHohoCode(RString txtSeikyuHohoCode) {
        this.setOriginalData("txtSeikyuHohoCode", txtSeikyuHohoCode);
        this.txtSeikyuHohoCode = txtSeikyuHohoCode;
    }

    public void setTxtHojoshaShikibetsuCode1(RString txtHojoshaShikibetsuCode1) {
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.txtHojoshaShikibetsuCode1 = txtHojoshaShikibetsuCode1;
    }

    public void setTxtHojoshaShikibetsuCode2(RString txtHojoshaShikibetsuCode2) {
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.txtHojoshaShikibetsuCode2 = txtHojoshaShikibetsuCode2;
    }

    public void setTxtSenkyoShuruiCode(RString txtSenkyoShuruiCode) {
        this.setOriginalData("txtSenkyoShuruiCode", txtSenkyoShuruiCode);
        this.txtSenkyoShuruiCode = txtSenkyoShuruiCode;
    }

    public void setChkMutohyo(Boolean chkMutohyo) {
        this.setOriginalData("chkMutohyo", chkMutohyo);
        this.chkMutohyo = chkMutohyo;
    }

    public void setSenkyoShikakuFlg(Boolean senkyoShikakuFlg) {
        this.setOriginalData("senkyoShikakuFlg", senkyoShikakuFlg);
        this.senkyoShikakuFlg = senkyoShikakuFlg;
    }

    public void setTohyoJokyoFlg(Boolean tohyoJokyoFlg) {
        this.setOriginalData("tohyoJokyoFlg", tohyoJokyoFlg);
        this.tohyoJokyoFlg = tohyoJokyoFlg;
    }

    public void setTohyoJokyoCode(RString tohyoJokyoCode) {
        this.setOriginalData("tohyoJokyoCode", tohyoJokyoCode);
        this.tohyoJokyoCode = tohyoJokyoCode;
    }

    public void setTxtTohyoUketsukeYMD(TextBoxFlexibleDate txtTohyoUketsukeYMD) {
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
    }

    public void setRowData(RString rowData) {
        this.setOriginalData("rowData", rowData);
        this.rowData = rowData;
    }

    public void setReamsClientId(RString reamsClientId) {
        this.setOriginalData("reamsClientId", reamsClientId);
        this.reamsClientId = reamsClientId;
    }

    // </editor-fold>
}
