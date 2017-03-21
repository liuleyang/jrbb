package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo;
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
public class KaikuSakuseiChohyoTorokushasuListDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokushasuListKijunYmd")
    private TextBoxDate txtTorokushasuListKijunYmd;
    @JsonProperty("lblTorokusha")
    private Label lblTorokusha;

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
     * getlblTorokusha
     * @return lblTorokusha
     */
    @JsonProperty("lblTorokusha")
    public Label getLblTorokusha() {
        return lblTorokusha;
    }

    /*
     * setlblTorokusha
     * @param lblTorokusha lblTorokusha
     */
    @JsonProperty("lblTorokusha")
    public void setLblTorokusha(Label lblTorokusha) {
        this.lblTorokusha = lblTorokusha;
    }

    // </editor-fold>
}
