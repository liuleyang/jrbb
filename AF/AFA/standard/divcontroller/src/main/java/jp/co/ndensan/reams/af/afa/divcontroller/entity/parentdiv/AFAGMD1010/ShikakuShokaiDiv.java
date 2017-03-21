package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuShokaiJoho")
    private ShikakuShokaiJohoDiv ShikakuShokaiJoho;
    @JsonProperty("ShikakuShokaiFuzaisha")
    private ShikakuShokaiFuzaishaDiv ShikakuShokaiFuzaisha;
    @JsonProperty("ccdShikakuShokaiKojinJoho")
    private KojinJohoDiv ccdShikakuShokaiKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShikakuShokaiJoho
     * @return ShikakuShokaiJoho
     */
    @JsonProperty("ShikakuShokaiJoho")
    public ShikakuShokaiJohoDiv getShikakuShokaiJoho() {
        return ShikakuShokaiJoho;
    }

    /*
     * setShikakuShokaiJoho
     * @param ShikakuShokaiJoho ShikakuShokaiJoho
     */
    @JsonProperty("ShikakuShokaiJoho")
    public void setShikakuShokaiJoho(ShikakuShokaiJohoDiv ShikakuShokaiJoho) {
        this.ShikakuShokaiJoho = ShikakuShokaiJoho;
    }

    /*
     * getShikakuShokaiFuzaisha
     * @return ShikakuShokaiFuzaisha
     */
    @JsonProperty("ShikakuShokaiFuzaisha")
    public ShikakuShokaiFuzaishaDiv getShikakuShokaiFuzaisha() {
        return ShikakuShokaiFuzaisha;
    }

    /*
     * setShikakuShokaiFuzaisha
     * @param ShikakuShokaiFuzaisha ShikakuShokaiFuzaisha
     */
    @JsonProperty("ShikakuShokaiFuzaisha")
    public void setShikakuShokaiFuzaisha(ShikakuShokaiFuzaishaDiv ShikakuShokaiFuzaisha) {
        this.ShikakuShokaiFuzaisha = ShikakuShokaiFuzaisha;
    }

    /*
     * getccdShikakuShokaiKojinJoho
     * @return ccdShikakuShokaiKojinJoho
     */
    @JsonProperty("ccdShikakuShokaiKojinJoho")
    public IKojinJohoDiv getCcdShikakuShokaiKojinJoho() {
        return ccdShikakuShokaiKojinJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtSenkyoShurui() {
        return this.getShikakuShokaiJoho().getTxtSenkyoShurui();
    }

    @JsonIgnore
    public void  setTxtSenkyoShurui(TextBox txtSenkyoShurui) {
        this.getShikakuShokaiJoho().setTxtSenkyoShurui(txtSenkyoShurui);
    }

    @JsonIgnore
    public DataGrid<dgShikakuShokai_Row> getDgShikakuShokai() {
        return this.getShikakuShokaiJoho().getDgShikakuShokai();
    }

    @JsonIgnore
    public void  setDgShikakuShokai(DataGrid<dgShikakuShokai_Row> dgShikakuShokai) {
        this.getShikakuShokaiJoho().setDgShikakuShokai(dgShikakuShokai);
    }

    @JsonIgnore
    public DataGrid<dgShikakuShokaiFuzaisha_Row> getDgShikakuShokaiFuzaisha() {
        return this.getShikakuShokaiFuzaisha().getDgShikakuShokaiFuzaisha();
    }

    @JsonIgnore
    public void  setDgShikakuShokaiFuzaisha(DataGrid<dgShikakuShokaiFuzaisha_Row> dgShikakuShokaiFuzaisha) {
        this.getShikakuShokaiFuzaisha().setDgShikakuShokaiFuzaisha(dgShikakuShokaiFuzaisha);
    }

    // </editor-fold>
}
