package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.IShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaJohoSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuzaishaJohoSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnFuzaishaSearch")
    private Button btnFuzaishaSearch;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdShisetsuCode")
    private ShisetsuCodeSelectDiv ccdShisetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnFuzaishaSearch
     * @return btnFuzaishaSearch
     */
    @JsonProperty("btnFuzaishaSearch")
    public Button getBtnFuzaishaSearch() {
        return btnFuzaishaSearch;
    }

    /*
     * setbtnFuzaishaSearch
     * @param btnFuzaishaSearch btnFuzaishaSearch
     */
    @JsonProperty("btnFuzaishaSearch")
    public void setBtnFuzaishaSearch(Button btnFuzaishaSearch) {
        this.btnFuzaishaSearch = btnFuzaishaSearch;
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
     * getccdShisetsuCode
     * @return ccdShisetsuCode
     */
    @JsonProperty("ccdShisetsuCode")
    public IShisetsuCodeSelectDiv getCcdShisetsuCode() {
        return ccdShisetsuCode;
    }

    // </editor-fold>
}
