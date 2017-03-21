package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho.IKaikuFuzuiJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho.KaikuFuzuiJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.IShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokaiShikakuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokaiShikakuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokaiMeiboJoho")
    private ShokaiMeiboJohoDiv ShokaiMeiboJoho;
    @JsonProperty("ccdShokaiTohyoShikakuJoho")
    private ShikakuJohoDiv ccdShokaiTohyoShikakuJoho;
    @JsonProperty("ccdShokaiKaikuFuzuiJoho")
    private KaikuFuzuiJohoDiv ccdShokaiKaikuFuzuiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShokaiMeiboJoho
     * @return ShokaiMeiboJoho
     */
    @JsonProperty("ShokaiMeiboJoho")
    public ShokaiMeiboJohoDiv getShokaiMeiboJoho() {
        return ShokaiMeiboJoho;
    }

    /*
     * setShokaiMeiboJoho
     * @param ShokaiMeiboJoho ShokaiMeiboJoho
     */
    @JsonProperty("ShokaiMeiboJoho")
    public void setShokaiMeiboJoho(ShokaiMeiboJohoDiv ShokaiMeiboJoho) {
        this.ShokaiMeiboJoho = ShokaiMeiboJoho;
    }

    /*
     * getccdShokaiTohyoShikakuJoho
     * @return ccdShokaiTohyoShikakuJoho
     */
    @JsonProperty("ccdShokaiTohyoShikakuJoho")
    public IShikakuJohoDiv getCcdShokaiTohyoShikakuJoho() {
        return ccdShokaiTohyoShikakuJoho;
    }

    /*
     * getccdShokaiKaikuFuzuiJoho
     * @return ccdShokaiKaikuFuzuiJoho
     */
    @JsonProperty("ccdShokaiKaikuFuzuiJoho")
    public IKaikuFuzuiJohoDiv getCcdShokaiKaikuFuzuiJoho() {
        return ccdShokaiKaikuFuzuiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtGroupCode() {
        return this.getShokaiMeiboJoho().getTxtGroupCode();
    }

    @JsonIgnore
    public void  setTxtGroupCode(TextBox txtGroupCode) {
        this.getShokaiMeiboJoho().setTxtGroupCode(txtGroupCode);
    }

    @JsonIgnore
    public TextBox getTxtKokugaiBunruiCode() {
        return this.getShokaiMeiboJoho().getTxtKokugaiBunruiCode();
    }

    @JsonIgnore
    public void  setTxtKokugaiBunruiCode(TextBox txtKokugaiBunruiCode) {
        this.getShokaiMeiboJoho().setTxtKokugaiBunruiCode(txtKokugaiBunruiCode);
    }

    @JsonIgnore
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeMeibo() {
        return this.getShokaiMeiboJoho().getCcdTohyokuCodeMeibo();
    }

    @JsonIgnore
    public IMeiboBangoDiv getCcdMeiboBango() {
        return this.getShokaiMeiboJoho().getCcdMeiboBango();
    }

    // </editor-fold>
}
