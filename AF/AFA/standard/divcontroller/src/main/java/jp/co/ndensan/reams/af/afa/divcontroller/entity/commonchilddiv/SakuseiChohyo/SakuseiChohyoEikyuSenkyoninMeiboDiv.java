package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class SakuseiChohyoEikyuSenkyoninMeiboDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radEikyuMeiboShoriKubun")
    private RadioButton radEikyuMeiboShoriKubun;
    @JsonProperty("txtEikyuMeiboShikibetsuCode")
    private TextBoxShikibetsuCode txtEikyuMeiboShikibetsuCode;
    @JsonProperty("txtEikyuMeiboShiteiYmdRange")
    private TextBoxDateRange txtEikyuMeiboShiteiYmdRange;
    @JsonProperty("ddlEikyuMeiboIdoJiyu")
    private DropDownList ddlEikyuMeiboIdoJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradEikyuMeiboShoriKubun
     * @return radEikyuMeiboShoriKubun
     */
    @JsonProperty("radEikyuMeiboShoriKubun")
    public RadioButton getRadEikyuMeiboShoriKubun() {
        return radEikyuMeiboShoriKubun;
    }

    /*
     * setradEikyuMeiboShoriKubun
     * @param radEikyuMeiboShoriKubun radEikyuMeiboShoriKubun
     */
    @JsonProperty("radEikyuMeiboShoriKubun")
    public void setRadEikyuMeiboShoriKubun(RadioButton radEikyuMeiboShoriKubun) {
        this.radEikyuMeiboShoriKubun = radEikyuMeiboShoriKubun;
    }

    /*
     * gettxtEikyuMeiboShikibetsuCode
     * @return txtEikyuMeiboShikibetsuCode
     */
    @JsonProperty("txtEikyuMeiboShikibetsuCode")
    public TextBoxShikibetsuCode getTxtEikyuMeiboShikibetsuCode() {
        return txtEikyuMeiboShikibetsuCode;
    }

    /*
     * settxtEikyuMeiboShikibetsuCode
     * @param txtEikyuMeiboShikibetsuCode txtEikyuMeiboShikibetsuCode
     */
    @JsonProperty("txtEikyuMeiboShikibetsuCode")
    public void setTxtEikyuMeiboShikibetsuCode(TextBoxShikibetsuCode txtEikyuMeiboShikibetsuCode) {
        this.txtEikyuMeiboShikibetsuCode = txtEikyuMeiboShikibetsuCode;
    }

    /*
     * gettxtEikyuMeiboShiteiYmdRange
     * @return txtEikyuMeiboShiteiYmdRange
     */
    @JsonProperty("txtEikyuMeiboShiteiYmdRange")
    public TextBoxDateRange getTxtEikyuMeiboShiteiYmdRange() {
        return txtEikyuMeiboShiteiYmdRange;
    }

    /*
     * settxtEikyuMeiboShiteiYmdRange
     * @param txtEikyuMeiboShiteiYmdRange txtEikyuMeiboShiteiYmdRange
     */
    @JsonProperty("txtEikyuMeiboShiteiYmdRange")
    public void setTxtEikyuMeiboShiteiYmdRange(TextBoxDateRange txtEikyuMeiboShiteiYmdRange) {
        this.txtEikyuMeiboShiteiYmdRange = txtEikyuMeiboShiteiYmdRange;
    }

    /*
     * getddlEikyuMeiboIdoJiyu
     * @return ddlEikyuMeiboIdoJiyu
     */
    @JsonProperty("ddlEikyuMeiboIdoJiyu")
    public DropDownList getDdlEikyuMeiboIdoJiyu() {
        return ddlEikyuMeiboIdoJiyu;
    }

    /*
     * setddlEikyuMeiboIdoJiyu
     * @param ddlEikyuMeiboIdoJiyu ddlEikyuMeiboIdoJiyu
     */
    @JsonProperty("ddlEikyuMeiboIdoJiyu")
    public void setDdlEikyuMeiboIdoJiyu(DropDownList ddlEikyuMeiboIdoJiyu) {
        this.ddlEikyuMeiboIdoJiyu = ddlEikyuMeiboIdoJiyu;
    }

    // </editor-fold>
}
