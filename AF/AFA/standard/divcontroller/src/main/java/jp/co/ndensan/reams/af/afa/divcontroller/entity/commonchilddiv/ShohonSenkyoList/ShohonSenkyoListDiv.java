package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShohonSenkyoList のクラスファイル
 *
 * @author 自動生成
 */
public class ShohonSenkyoListDiv extends Panel implements IShohonSenkyoListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("chkMutohyo")
    private CheckBoxList chkMutohyo;
    @JsonProperty("btnHdnChangeShohon")
    private Button btnHdnChangeShohon;
    @JsonProperty("dgSenkyoList")
    private DataGrid<dgSenkyoList_Row> dgSenkyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getchkMutohyo
     * @return chkMutohyo
     */
    @JsonProperty("chkMutohyo")
    public CheckBoxList getChkMutohyo() {
        return chkMutohyo;
    }

    /*
     * setchkMutohyo
     * @param chkMutohyo chkMutohyo
     */
    @JsonProperty("chkMutohyo")
    public void setChkMutohyo(CheckBoxList chkMutohyo) {
        this.chkMutohyo = chkMutohyo;
    }

    /*
     * getbtnHdnChangeShohon
     * @return btnHdnChangeShohon
     */
    @JsonProperty("btnHdnChangeShohon")
    public Button getBtnHdnChangeShohon() {
        return btnHdnChangeShohon;
    }

    /*
     * setbtnHdnChangeShohon
     * @param btnHdnChangeShohon btnHdnChangeShohon
     */
    @JsonProperty("btnHdnChangeShohon")
    public void setBtnHdnChangeShohon(Button btnHdnChangeShohon) {
        this.btnHdnChangeShohon = btnHdnChangeShohon;
    }

    /*
     * getdgSenkyoList
     * @return dgSenkyoList
     */
    @JsonProperty("dgSenkyoList")
    public DataGrid<dgSenkyoList_Row> getDgSenkyoList() {
        return dgSenkyoList;
    }

    /*
     * setdgSenkyoList
     * @param dgSenkyoList dgSenkyoList
     */
    @JsonProperty("dgSenkyoList")
    public void setDgSenkyoList(DataGrid<dgSenkyoList_Row> dgSenkyoList) {
        this.dgSenkyoList = dgSenkyoList;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @Override
    public void changeflag() {
        getHandler().changeflag();
    }

    @Override
    public void clearThisPanel() {
        getHandler().clearThisPanel();
    }

    @Override
    public int getShohonListSize() {
        return getHandler().getShohonListSize();
    }

    @Override
    public RString getSelectedShohonNo() {
        return getHandler().getSelectedShohonNo();
    }

    @Override
    public List<dgSenkyoList_Row> getSenkyoDataSource() {
        return getHandler().getSenkyoDataSource();
    }

    @Override
    public boolean 無投票選挙check() {
        return getHandler().無投票選挙check();
    }

    @Override
    public void click過去分も含める() {
        getHandler().click過去分も含める();
    }

    @JsonIgnore
    public ShohonSenkyoListHandler getHandler() {
        return new ShohonSenkyoListHandler(this);
    }

}
