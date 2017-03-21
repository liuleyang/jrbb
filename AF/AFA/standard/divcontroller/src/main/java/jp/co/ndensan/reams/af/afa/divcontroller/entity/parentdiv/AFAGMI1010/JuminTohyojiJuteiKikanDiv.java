package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminTohyojiJuteiKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminTohyojiJuteiKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblJuteiKikan")
    private Label lblJuteiKikan;
    @JsonProperty("txtJuteiKikan")
    private TextBoxDateRange txtJuteiKikan;
    @JsonProperty("chkRenzokuKikan")
    private CheckBoxList chkRenzokuKikan;
    @JsonProperty("txtKyojuNensu")
    private TextBoxNum txtKyojuNensu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblJuteiKikan
     * @return lblJuteiKikan
     */
    @JsonProperty("lblJuteiKikan")
    public Label getLblJuteiKikan() {
        return lblJuteiKikan;
    }

    /*
     * setlblJuteiKikan
     * @param lblJuteiKikan lblJuteiKikan
     */
    @JsonProperty("lblJuteiKikan")
    public void setLblJuteiKikan(Label lblJuteiKikan) {
        this.lblJuteiKikan = lblJuteiKikan;
    }

    /*
     * gettxtJuteiKikan
     * @return txtJuteiKikan
     */
    @JsonProperty("txtJuteiKikan")
    public TextBoxDateRange getTxtJuteiKikan() {
        return txtJuteiKikan;
    }

    /*
     * settxtJuteiKikan
     * @param txtJuteiKikan txtJuteiKikan
     */
    @JsonProperty("txtJuteiKikan")
    public void setTxtJuteiKikan(TextBoxDateRange txtJuteiKikan) {
        this.txtJuteiKikan = txtJuteiKikan;
    }

    /*
     * getchkRenzokuKikan
     * @return chkRenzokuKikan
     */
    @JsonProperty("chkRenzokuKikan")
    public CheckBoxList getChkRenzokuKikan() {
        return chkRenzokuKikan;
    }

    /*
     * setchkRenzokuKikan
     * @param chkRenzokuKikan chkRenzokuKikan
     */
    @JsonProperty("chkRenzokuKikan")
    public void setChkRenzokuKikan(CheckBoxList chkRenzokuKikan) {
        this.chkRenzokuKikan = chkRenzokuKikan;
    }

    /*
     * gettxtKyojuNensu
     * @return txtKyojuNensu
     */
    @JsonProperty("txtKyojuNensu")
    public TextBoxNum getTxtKyojuNensu() {
        return txtKyojuNensu;
    }

    /*
     * settxtKyojuNensu
     * @param txtKyojuNensu txtKyojuNensu
     */
    @JsonProperty("txtKyojuNensu")
    public void setTxtKyojuNensu(TextBoxNum txtKyojuNensu) {
        this.txtKyojuNensu = txtKyojuNensu;
    }

    // </editor-fold>
}
