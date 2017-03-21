package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaKofuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuzaishaKofuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKofuHoho")
    private RadioButton radKofuHoho;
    @JsonProperty("txtKofuYMD")
    private TextBoxDate txtKofuYMD;
    @JsonProperty("chkTenjiYoshi")
    private CheckBoxList chkTenjiYoshi;
    @JsonProperty("chkShomeishoHakko")
    private CheckBoxList chkShomeishoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKofuHoho
     * @return radKofuHoho
     */
    @JsonProperty("radKofuHoho")
    public RadioButton getRadKofuHoho() {
        return radKofuHoho;
    }

    /*
     * setradKofuHoho
     * @param radKofuHoho radKofuHoho
     */
    @JsonProperty("radKofuHoho")
    public void setRadKofuHoho(RadioButton radKofuHoho) {
        this.radKofuHoho = radKofuHoho;
    }

    /*
     * gettxtKofuYMD
     * @return txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public TextBoxDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    /*
     * settxtKofuYMD
     * @param txtKofuYMD txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public void setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.txtKofuYMD = txtKofuYMD;
    }

    /*
     * getchkTenjiYoshi
     * @return chkTenjiYoshi
     */
    @JsonProperty("chkTenjiYoshi")
    public CheckBoxList getChkTenjiYoshi() {
        return chkTenjiYoshi;
    }

    /*
     * setchkTenjiYoshi
     * @param chkTenjiYoshi chkTenjiYoshi
     */
    @JsonProperty("chkTenjiYoshi")
    public void setChkTenjiYoshi(CheckBoxList chkTenjiYoshi) {
        this.chkTenjiYoshi = chkTenjiYoshi;
    }

    /*
     * getchkShomeishoHakko
     * @return chkShomeishoHakko
     */
    @JsonProperty("chkShomeishoHakko")
    public CheckBoxList getChkShomeishoHakko() {
        return chkShomeishoHakko;
    }

    /*
     * setchkShomeishoHakko
     * @param chkShomeishoHakko chkShomeishoHakko
     */
    @JsonProperty("chkShomeishoHakko")
    public void setChkShomeishoHakko(CheckBoxList chkShomeishoHakko) {
        this.chkShomeishoHakko = chkShomeishoHakko;
    }

    // </editor-fold>
}
