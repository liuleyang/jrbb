package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango.HakkoBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango.IHakkoBangoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class SakuseiChohyoPrintNaiyoDiv extends Panel implements ISakuseiChohyoPrintNaiyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoYMD")
    private TextBoxDate txtHakkoYMD;
    @JsonProperty("ccdHakkoBango")
    private HakkoBangoDiv ccdHakkoBango;
    @JsonProperty("txtIinchoName")
    private TextBox txtIinchoName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoYMD
     * @return txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public TextBoxDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    /*
     * settxtHakkoYMD
     * @param txtHakkoYMD txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public void setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.txtHakkoYMD = txtHakkoYMD;
    }

    /*
     * getccdHakkoBango
     * @return ccdHakkoBango
     */
    @JsonProperty("ccdHakkoBango")
    public IHakkoBangoDiv getCcdHakkoBango() {
        return ccdHakkoBango;
    }

    /*
     * gettxtIinchoName
     * @return txtIinchoName
     */
    @JsonProperty("txtIinchoName")
    public TextBox getTxtIinchoName() {
        return txtIinchoName;
    }

    /*
     * settxtIinchoName
     * @param txtIinchoName txtIinchoName
     */
    @JsonProperty("txtIinchoName")
    public void setTxtIinchoName(TextBox txtIinchoName) {
        this.txtIinchoName = txtIinchoName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString chohyoID) {
        getHandler().initialize(chohyoID);
    }

    @Override
    public void initialize(RString chohyoID, RDate hakkoYMD) {
        getHandler().initialize(chohyoID, hakkoYMD);
    }

    @Override
    public void clearData() {
        getHandler().clearData();
    }

    @JsonIgnore
    public SakuseiChohyoPrintNaiyoHandler getHandler() {
        return new SakuseiChohyoPrintNaiyoHandler(this);
    }

}
