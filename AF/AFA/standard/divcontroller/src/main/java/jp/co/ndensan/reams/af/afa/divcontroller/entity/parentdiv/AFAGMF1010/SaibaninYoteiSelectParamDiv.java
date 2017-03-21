package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SaibaninYoteiSelectParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaibaninYoteiSelectParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHozonFileName")
    private TextBox txtHozonFileName;
    @JsonProperty("txtNenrei")
    private TextBoxNum txtNenrei;
    @JsonProperty("txtNenreiKijunYMD")
    private TextBoxDate txtNenreiKijunYMD;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHozonFileName
     * @return txtHozonFileName
     */
    @JsonProperty("txtHozonFileName")
    public TextBox getTxtHozonFileName() {
        return txtHozonFileName;
    }

    /*
     * settxtHozonFileName
     * @param txtHozonFileName txtHozonFileName
     */
    @JsonProperty("txtHozonFileName")
    public void setTxtHozonFileName(TextBox txtHozonFileName) {
        this.txtHozonFileName = txtHozonFileName;
    }

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBoxNum getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBoxNum txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxtNenreiKijunYMD
     * @return txtNenreiKijunYMD
     */
    @JsonProperty("txtNenreiKijunYMD")
    public TextBoxDate getTxtNenreiKijunYMD() {
        return txtNenreiKijunYMD;
    }

    /*
     * settxtNenreiKijunYMD
     * @param txtNenreiKijunYMD txtNenreiKijunYMD
     */
    @JsonProperty("txtNenreiKijunYMD")
    public void setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.txtNenreiKijunYMD = txtNenreiKijunYMD;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    // </editor-fold>
}
