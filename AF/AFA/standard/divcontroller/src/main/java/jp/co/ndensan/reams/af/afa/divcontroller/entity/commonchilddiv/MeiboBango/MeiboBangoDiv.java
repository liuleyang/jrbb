package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * MeiboBango のクラスファイル 
 * 
 * @author 自動生成
 */
public class MeiboBangoDiv extends Panel implements IMeiboBangoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSatsu")
    private TextBox txtSatsu;
    @JsonProperty("txtPage")
    private TextBoxNum txtPage;
    @JsonProperty("txtGyo")
    private TextBoxNum txtGyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSatsu
     * @return txtSatsu
     */
    @JsonProperty("txtSatsu")
    public TextBox getTxtSatsu() {
        return txtSatsu;
    }

    /*
     * settxtSatsu
     * @param txtSatsu txtSatsu
     */
    @JsonProperty("txtSatsu")
    public void setTxtSatsu(TextBox txtSatsu) {
        this.txtSatsu = txtSatsu;
    }

    /*
     * gettxtPage
     * @return txtPage
     */
    @JsonProperty("txtPage")
    public TextBoxNum getTxtPage() {
        return txtPage;
    }

    /*
     * settxtPage
     * @param txtPage txtPage
     */
    @JsonProperty("txtPage")
    public void setTxtPage(TextBoxNum txtPage) {
        this.txtPage = txtPage;
    }

    /*
     * gettxtGyo
     * @return txtGyo
     */
    @JsonProperty("txtGyo")
    public TextBoxNum getTxtGyo() {
        return txtGyo;
    }

    /*
     * settxtGyo
     * @param txtGyo txtGyo
     */
    @JsonProperty("txtGyo")
    public void setTxtGyo(TextBoxNum txtGyo) {
        this.txtGyo = txtGyo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public RString get冊() {
        return getTxtSatsu().getValue();
    }

    @JsonIgnore
    @Override
    public Decimal get頁() {
        return getTxtPage().getValue();
    }

    @JsonIgnore
    @Override
    public Decimal get行() {
        return getTxtGyo().getValue();
    }

    @Override
    public void initialize(RString satsu, Decimal page, Decimal gyo) {
        getHandler().initialize(satsu, page, gyo);
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @JsonIgnore
    public MeiboBangoHandler getHandler() {
        return new MeiboBangoHandler(this);
    }

}
