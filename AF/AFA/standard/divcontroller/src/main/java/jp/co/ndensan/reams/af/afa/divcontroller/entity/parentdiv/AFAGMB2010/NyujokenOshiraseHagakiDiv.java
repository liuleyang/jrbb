package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NyujokenOshiraseHagaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenOshiraseHagakiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTenshutsuYMDRange")
    private TextBoxDateRange txtTenshutsuYMDRange;
    @JsonProperty("chkNijuMassho")
    private CheckBoxList chkNijuMassho;
    @JsonProperty("chkAtenaSeal")
    private CheckBoxList chkAtenaSeal;
    @JsonProperty("Hidden転出日From")
    private RString Hidden転出日From;
    @JsonProperty("Hidden転出日To")
    private RString Hidden転出日To;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTenshutsuYMDRange
     * @return txtTenshutsuYMDRange
     */
    @JsonProperty("txtTenshutsuYMDRange")
    public TextBoxDateRange getTxtTenshutsuYMDRange() {
        return txtTenshutsuYMDRange;
    }

    /*
     * settxtTenshutsuYMDRange
     * @param txtTenshutsuYMDRange txtTenshutsuYMDRange
     */
    @JsonProperty("txtTenshutsuYMDRange")
    public void setTxtTenshutsuYMDRange(TextBoxDateRange txtTenshutsuYMDRange) {
        this.txtTenshutsuYMDRange = txtTenshutsuYMDRange;
    }

    /*
     * getchkNijuMassho
     * @return chkNijuMassho
     */
    @JsonProperty("chkNijuMassho")
    public CheckBoxList getChkNijuMassho() {
        return chkNijuMassho;
    }

    /*
     * setchkNijuMassho
     * @param chkNijuMassho chkNijuMassho
     */
    @JsonProperty("chkNijuMassho")
    public void setChkNijuMassho(CheckBoxList chkNijuMassho) {
        this.chkNijuMassho = chkNijuMassho;
    }

    /*
     * getchkAtenaSeal
     * @return chkAtenaSeal
     */
    @JsonProperty("chkAtenaSeal")
    public CheckBoxList getChkAtenaSeal() {
        return chkAtenaSeal;
    }

    /*
     * setchkAtenaSeal
     * @param chkAtenaSeal chkAtenaSeal
     */
    @JsonProperty("chkAtenaSeal")
    public void setChkAtenaSeal(CheckBoxList chkAtenaSeal) {
        this.chkAtenaSeal = chkAtenaSeal;
    }

    /*
     * getHidden転出日From
     * @return Hidden転出日From
     */
    @JsonProperty("Hidden転出日From")
    public RString getHidden転出日From() {
        return Hidden転出日From;
    }

    /*
     * setHidden転出日From
     * @param Hidden転出日From Hidden転出日From
     */
    @JsonProperty("Hidden転出日From")
    public void setHidden転出日From(RString Hidden転出日From) {
        this.Hidden転出日From = Hidden転出日From;
    }

    /*
     * getHidden転出日To
     * @return Hidden転出日To
     */
    @JsonProperty("Hidden転出日To")
    public RString getHidden転出日To() {
        return Hidden転出日To;
    }

    /*
     * setHidden転出日To
     * @param Hidden転出日To Hidden転出日To
     */
    @JsonProperty("Hidden転出日To")
    public void setHidden転出日To(RString Hidden転出日To) {
        this.Hidden転出日To = Hidden転出日To;
    }

    // </editor-fold>
}
