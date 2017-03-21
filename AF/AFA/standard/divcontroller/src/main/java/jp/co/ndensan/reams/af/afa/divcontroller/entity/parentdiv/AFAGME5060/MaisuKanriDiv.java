package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MaisuKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class MaisuKanriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgMaisuSenkyoList")
    private DataGrid<dgMaisuSenkyoList_Row> dgMaisuSenkyoList;
    @JsonProperty("MaisuInput")
    private MaisuInputDiv MaisuInput;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("HidMaisuKanriMoto")
    private RString HidMaisuKanriMoto;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgMaisuSenkyoList
     * @return dgMaisuSenkyoList
     */
    @JsonProperty("dgMaisuSenkyoList")
    public DataGrid<dgMaisuSenkyoList_Row> getDgMaisuSenkyoList() {
        return dgMaisuSenkyoList;
    }

    /*
     * setdgMaisuSenkyoList
     * @param dgMaisuSenkyoList dgMaisuSenkyoList
     */
    @JsonProperty("dgMaisuSenkyoList")
    public void setDgMaisuSenkyoList(DataGrid<dgMaisuSenkyoList_Row> dgMaisuSenkyoList) {
        this.dgMaisuSenkyoList = dgMaisuSenkyoList;
    }

    /*
     * getMaisuInput
     * @return MaisuInput
     */
    @JsonProperty("MaisuInput")
    public MaisuInputDiv getMaisuInput() {
        return MaisuInput;
    }

    /*
     * setMaisuInput
     * @param MaisuInput MaisuInput
     */
    @JsonProperty("MaisuInput")
    public void setMaisuInput(MaisuInputDiv MaisuInput) {
        this.MaisuInput = MaisuInput;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getHidMaisuKanriMoto
     * @return HidMaisuKanriMoto
     */
    @JsonProperty("HidMaisuKanriMoto")
    public RString getHidMaisuKanriMoto() {
        return HidMaisuKanriMoto;
    }

    /*
     * setHidMaisuKanriMoto
     * @param HidMaisuKanriMoto HidMaisuKanriMoto
     */
    @JsonProperty("HidMaisuKanriMoto")
    public void setHidMaisuKanriMoto(RString HidMaisuKanriMoto) {
        this.HidMaisuKanriMoto = HidMaisuKanriMoto;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgMaisuInput_Row> getDgMaisuInput() {
        return this.getMaisuInput().getDgMaisuInput();
    }

    @JsonIgnore
    public void  setDgMaisuInput(DataGrid<dgMaisuInput_Row> dgMaisuInput) {
        this.getMaisuInput().setDgMaisuInput(dgMaisuInput);
    }

    @JsonIgnore
    public Button getBtnUpdate() {
        return this.getMaisuInput().getBtnUpdate();
    }

    @JsonIgnore
    public void  setBtnUpdate(Button btnUpdate) {
        this.getMaisuInput().setBtnUpdate(btnUpdate);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getMaisuInput().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getMaisuInput().setBtnStop(btnStop);
    }

    // </editor-fold>
}
