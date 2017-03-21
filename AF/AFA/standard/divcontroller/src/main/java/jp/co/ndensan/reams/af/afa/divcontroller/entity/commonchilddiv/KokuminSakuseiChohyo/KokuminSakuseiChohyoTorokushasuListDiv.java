package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class KokuminSakuseiChohyoTorokushasuListDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokushasuListKijunYmd")
    private TextBoxDate txtTorokushasuListKijunYmd;
    @JsonProperty("lblTorokushasuList")
    private Label lblTorokushasuList;
    @JsonProperty("chkTorokuListFuzaishabun")
    private CheckBoxList chkTorokuListFuzaishabun;
    @JsonProperty("chkFuzaiTohyoMeibo")
    private CheckBoxList chkFuzaiTohyoMeibo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorokushasuListKijunYmd
     * @return txtTorokushasuListKijunYmd
     */
    @JsonProperty("txtTorokushasuListKijunYmd")
    public TextBoxDate getTxtTorokushasuListKijunYmd() {
        return txtTorokushasuListKijunYmd;
    }

    /*
     * settxtTorokushasuListKijunYmd
     * @param txtTorokushasuListKijunYmd txtTorokushasuListKijunYmd
     */
    @JsonProperty("txtTorokushasuListKijunYmd")
    public void setTxtTorokushasuListKijunYmd(TextBoxDate txtTorokushasuListKijunYmd) {
        this.txtTorokushasuListKijunYmd = txtTorokushasuListKijunYmd;
    }

    /*
     * getlblTorokushasuList
     * @return lblTorokushasuList
     */
    @JsonProperty("lblTorokushasuList")
    public Label getLblTorokushasuList() {
        return lblTorokushasuList;
    }

    /*
     * setlblTorokushasuList
     * @param lblTorokushasuList lblTorokushasuList
     */
    @JsonProperty("lblTorokushasuList")
    public void setLblTorokushasuList(Label lblTorokushasuList) {
        this.lblTorokushasuList = lblTorokushasuList;
    }

    /*
     * getchkTorokuListFuzaishabun
     * @return chkTorokuListFuzaishabun
     */
    @JsonProperty("chkTorokuListFuzaishabun")
    public CheckBoxList getChkTorokuListFuzaishabun() {
        return chkTorokuListFuzaishabun;
    }

    /*
     * setchkTorokuListFuzaishabun
     * @param chkTorokuListFuzaishabun chkTorokuListFuzaishabun
     */
    @JsonProperty("chkTorokuListFuzaishabun")
    public void setChkTorokuListFuzaishabun(CheckBoxList chkTorokuListFuzaishabun) {
        this.chkTorokuListFuzaishabun = chkTorokuListFuzaishabun;
    }

    /*
     * getchkFuzaiTohyoMeibo
     * @return chkFuzaiTohyoMeibo
     */
    @JsonProperty("chkFuzaiTohyoMeibo")
    public CheckBoxList getChkFuzaiTohyoMeibo() {
        return chkFuzaiTohyoMeibo;
    }

    /*
     * setchkFuzaiTohyoMeibo
     * @param chkFuzaiTohyoMeibo chkFuzaiTohyoMeibo
     */
    @JsonProperty("chkFuzaiTohyoMeibo")
    public void setChkFuzaiTohyoMeibo(CheckBoxList chkFuzaiTohyoMeibo) {
        this.chkFuzaiTohyoMeibo = chkFuzaiTohyoMeibo;
    }

    // </editor-fold>
}
