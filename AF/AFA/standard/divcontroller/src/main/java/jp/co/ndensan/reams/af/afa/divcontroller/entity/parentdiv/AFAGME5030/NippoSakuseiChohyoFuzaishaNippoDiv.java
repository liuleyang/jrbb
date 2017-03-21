package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NippoSakuseiChohyoFuzaishaNippo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoFuzaishaNippoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkKofuNippo")
    private CheckBoxList chkKofuNippo;
    @JsonProperty("txtFuzaishaNippoKofuYMD")
    private TextBoxDateRange txtFuzaishaNippoKofuYMD;
    @JsonProperty("chkJuriNippo")
    private CheckBoxList chkJuriNippo;
    @JsonProperty("txtFuzaishaNippoJuriYMD")
    private TextBoxDateRange txtFuzaishaNippoJuriYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkKofuNippo
     * @return chkKofuNippo
     */
    @JsonProperty("chkKofuNippo")
    public CheckBoxList getChkKofuNippo() {
        return chkKofuNippo;
    }

    /*
     * setchkKofuNippo
     * @param chkKofuNippo chkKofuNippo
     */
    @JsonProperty("chkKofuNippo")
    public void setChkKofuNippo(CheckBoxList chkKofuNippo) {
        this.chkKofuNippo = chkKofuNippo;
    }

    /*
     * gettxtFuzaishaNippoKofuYMD
     * @return txtFuzaishaNippoKofuYMD
     */
    @JsonProperty("txtFuzaishaNippoKofuYMD")
    public TextBoxDateRange getTxtFuzaishaNippoKofuYMD() {
        return txtFuzaishaNippoKofuYMD;
    }

    /*
     * settxtFuzaishaNippoKofuYMD
     * @param txtFuzaishaNippoKofuYMD txtFuzaishaNippoKofuYMD
     */
    @JsonProperty("txtFuzaishaNippoKofuYMD")
    public void setTxtFuzaishaNippoKofuYMD(TextBoxDateRange txtFuzaishaNippoKofuYMD) {
        this.txtFuzaishaNippoKofuYMD = txtFuzaishaNippoKofuYMD;
    }

    /*
     * getchkJuriNippo
     * @return chkJuriNippo
     */
    @JsonProperty("chkJuriNippo")
    public CheckBoxList getChkJuriNippo() {
        return chkJuriNippo;
    }

    /*
     * setchkJuriNippo
     * @param chkJuriNippo chkJuriNippo
     */
    @JsonProperty("chkJuriNippo")
    public void setChkJuriNippo(CheckBoxList chkJuriNippo) {
        this.chkJuriNippo = chkJuriNippo;
    }

    /*
     * gettxtFuzaishaNippoJuriYMD
     * @return txtFuzaishaNippoJuriYMD
     */
    @JsonProperty("txtFuzaishaNippoJuriYMD")
    public TextBoxDateRange getTxtFuzaishaNippoJuriYMD() {
        return txtFuzaishaNippoJuriYMD;
    }

    /*
     * settxtFuzaishaNippoJuriYMD
     * @param txtFuzaishaNippoJuriYMD txtFuzaishaNippoJuriYMD
     */
    @JsonProperty("txtFuzaishaNippoJuriYMD")
    public void setTxtFuzaishaNippoJuriYMD(TextBoxDateRange txtFuzaishaNippoJuriYMD) {
        this.txtFuzaishaNippoJuriYMD = txtFuzaishaNippoJuriYMD;
    }

    // </editor-fold>
}
