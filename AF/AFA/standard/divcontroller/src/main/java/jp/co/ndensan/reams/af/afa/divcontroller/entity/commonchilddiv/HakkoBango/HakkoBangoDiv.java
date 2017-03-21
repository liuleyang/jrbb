package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango;
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

/**
 * HakkoBango のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoBangoDiv extends Panel implements IHakkoBangoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoNoDai")
    private TextBox txtHakkoNoDai;
    @JsonProperty("txtHakkoNoBango")
    private TextBox txtHakkoNoBango;
    @JsonProperty("txtHakkoNoGo")
    private TextBox txtHakkoNoGo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoNoDai
     * @return txtHakkoNoDai
     */
    @JsonProperty("txtHakkoNoDai")
    public TextBox getTxtHakkoNoDai() {
        return txtHakkoNoDai;
    }

    /*
     * settxtHakkoNoDai
     * @param txtHakkoNoDai txtHakkoNoDai
     */
    @JsonProperty("txtHakkoNoDai")
    public void setTxtHakkoNoDai(TextBox txtHakkoNoDai) {
        this.txtHakkoNoDai = txtHakkoNoDai;
    }

    /*
     * gettxtHakkoNoBango
     * @return txtHakkoNoBango
     */
    @JsonProperty("txtHakkoNoBango")
    public TextBox getTxtHakkoNoBango() {
        return txtHakkoNoBango;
    }

    /*
     * settxtHakkoNoBango
     * @param txtHakkoNoBango txtHakkoNoBango
     */
    @JsonProperty("txtHakkoNoBango")
    public void setTxtHakkoNoBango(TextBox txtHakkoNoBango) {
        this.txtHakkoNoBango = txtHakkoNoBango;
    }

    /*
     * gettxtHakkoNoGo
     * @return txtHakkoNoGo
     */
    @JsonProperty("txtHakkoNoGo")
    public TextBox getTxtHakkoNoGo() {
        return txtHakkoNoGo;
    }

    /*
     * settxtHakkoNoGo
     * @param txtHakkoNoGo txtHakkoNoGo
     */
    @JsonProperty("txtHakkoNoGo")
    public void setTxtHakkoNoGo(TextBox txtHakkoNoGo) {
        this.txtHakkoNoGo = txtHakkoNoGo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public RString get発行番号_第() {
        return getTxtHakkoNoDai().getValue();
    }

    @JsonIgnore
    @Override
    public RString get発行番号_番号() {
        return getTxtHakkoNoBango().getValue();
    }

    @JsonIgnore
    @Override
    public RString get発行番号_号() {
        return getTxtHakkoNoGo().getValue();
    }

    @Override
    public void initialize(RString chohyoID) {
        getHandler().initialize(chohyoID);
    }

    @Override
    public void initialize() {
        //TODO 帳票IDとかをもらって、管理情報から取得するようにしたほうがいいか？
//        getHandler().initialize(帳票ID);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @JsonIgnore
    public HakkoBangoHandler getHandler() {
        return new HakkoBangoHandler(this);
    }

}
