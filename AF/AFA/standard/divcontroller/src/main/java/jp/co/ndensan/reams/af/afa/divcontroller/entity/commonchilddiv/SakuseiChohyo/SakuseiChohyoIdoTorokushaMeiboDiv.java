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
public class SakuseiChohyoIdoTorokushaMeiboDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTorokushaMeiboJuran")
    private CheckBoxList chkTorokushaMeiboJuran;
    @JsonProperty("chkSealTorokushaMeibo")
    private CheckBoxList chkSealTorokushaMeibo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTorokushaMeiboJuran
     * @return chkTorokushaMeiboJuran
     */
    @JsonProperty("chkTorokushaMeiboJuran")
    public CheckBoxList getChkTorokushaMeiboJuran() {
        return chkTorokushaMeiboJuran;
    }

    /*
     * setchkTorokushaMeiboJuran
     * @param chkTorokushaMeiboJuran chkTorokushaMeiboJuran
     */
    @JsonProperty("chkTorokushaMeiboJuran")
    public void setChkTorokushaMeiboJuran(CheckBoxList chkTorokushaMeiboJuran) {
        this.chkTorokushaMeiboJuran = chkTorokushaMeiboJuran;
    }

    /*
     * getchkSealTorokushaMeibo
     * @return chkSealTorokushaMeibo
     */
    @JsonProperty("chkSealTorokushaMeibo")
    public CheckBoxList getChkSealTorokushaMeibo() {
        return chkSealTorokushaMeibo;
    }

    /*
     * setchkSealTorokushaMeibo
     * @param chkSealTorokushaMeibo chkSealTorokushaMeibo
     */
    @JsonProperty("chkSealTorokushaMeibo")
    public void setChkSealTorokushaMeibo(CheckBoxList chkSealTorokushaMeibo) {
        this.chkSealTorokushaMeibo = chkSealTorokushaMeibo;
    }

    // </editor-fold>
}
