package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaUketoriJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuzaishaUketoriJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUketoriYMD")
    private TextBoxDate txtUketoriYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtUketoriYMD
     * @return txtUketoriYMD
     */
    @JsonProperty("txtUketoriYMD")
    public TextBoxDate getTxtUketoriYMD() {
        return txtUketoriYMD;
    }

    /*
     * settxtUketoriYMD
     * @param txtUketoriYMD txtUketoriYMD
     */
    @JsonProperty("txtUketoriYMD")
    public void setTxtUketoriYMD(TextBoxDate txtUketoriYMD) {
        this.txtUketoriYMD = txtUketoriYMD;
    }

    // </editor-fold>
}
