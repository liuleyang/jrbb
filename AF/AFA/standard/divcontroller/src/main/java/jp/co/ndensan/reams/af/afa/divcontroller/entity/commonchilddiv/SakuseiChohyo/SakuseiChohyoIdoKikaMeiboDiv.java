package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
public class SakuseiChohyoIdoKikaMeiboDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKikaKikan")
    private TextBoxDateRange txtKikaKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKikaKikan
     * @return txtKikaKikan
     */
    @JsonProperty("txtKikaKikan")
    public TextBoxDateRange getTxtKikaKikan() {
        return txtKikaKikan;
    }

    /*
     * settxtKikaKikan
     * @param txtKikaKikan txtKikaKikan
     */
    @JsonProperty("txtKikaKikan")
    public void setTxtKikaKikan(TextBoxDateRange txtKikaKikan) {
        this.txtKikaKikan = txtKikaKikan;
    }

    // </editor-fold>
}
