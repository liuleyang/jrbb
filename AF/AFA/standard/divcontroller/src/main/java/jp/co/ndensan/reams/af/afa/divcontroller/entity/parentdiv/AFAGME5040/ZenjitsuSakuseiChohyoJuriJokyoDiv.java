package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ZenjitsuSakuseiChohyoJuriJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoJuriJokyoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJuriJokyoJuriYMD")
    private TextBoxDateRange txtJuriJokyoJuriYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJuriJokyoJuriYMD
     * @return txtJuriJokyoJuriYMD
     */
    @JsonProperty("txtJuriJokyoJuriYMD")
    public TextBoxDateRange getTxtJuriJokyoJuriYMD() {
        return txtJuriJokyoJuriYMD;
    }

    /*
     * settxtJuriJokyoJuriYMD
     * @param txtJuriJokyoJuriYMD txtJuriJokyoJuriYMD
     */
    @JsonProperty("txtJuriJokyoJuriYMD")
    public void setTxtJuriJokyoJuriYMD(TextBoxDateRange txtJuriJokyoJuriYMD) {
        this.txtJuriJokyoJuriYMD = txtJuriJokyoJuriYMD;
    }

    // </editor-fold>
}
