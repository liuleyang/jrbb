package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShohonShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShohonShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokaiShikakuJoho")
    private ShokaiShikakuJohoDiv ShokaiShikakuJoho;
    @JsonProperty("ShokaiTohyoJokyo")
    private ShokaiTohyoJokyoDiv ShokaiTohyoJokyo;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdShokaiKojinJoho")
    private KojinJohoDiv ccdShokaiKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShokaiShikakuJoho
     * @return ShokaiShikakuJoho
     */
    @JsonProperty("ShokaiShikakuJoho")
    public ShokaiShikakuJohoDiv getShokaiShikakuJoho() {
        return ShokaiShikakuJoho;
    }

    /*
     * setShokaiShikakuJoho
     * @param ShokaiShikakuJoho ShokaiShikakuJoho
     */
    @JsonProperty("ShokaiShikakuJoho")
    public void setShokaiShikakuJoho(ShokaiShikakuJohoDiv ShokaiShikakuJoho) {
        this.ShokaiShikakuJoho = ShokaiShikakuJoho;
    }

    /*
     * getShokaiTohyoJokyo
     * @return ShokaiTohyoJokyo
     */
    @JsonProperty("ShokaiTohyoJokyo")
    public ShokaiTohyoJokyoDiv getShokaiTohyoJokyo() {
        return ShokaiTohyoJokyo;
    }

    /*
     * setShokaiTohyoJokyo
     * @param ShokaiTohyoJokyo ShokaiTohyoJokyo
     */
    @JsonProperty("ShokaiTohyoJokyo")
    public void setShokaiTohyoJokyo(ShokaiTohyoJokyoDiv ShokaiTohyoJokyo) {
        this.ShokaiTohyoJokyo = ShokaiTohyoJokyo;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getccdShokaiKojinJoho
     * @return ccdShokaiKojinJoho
     */
    @JsonProperty("ccdShokaiKojinJoho")
    public IKojinJohoDiv getCcdShokaiKojinJoho() {
        return ccdShokaiKojinJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtGroupCode() {
        return this.getShokaiShikakuJoho().getShokaiMeiboJoho().getTxtGroupCode();
    }

    @JsonIgnore
    public void  setTxtGroupCode(TextBox txtGroupCode) {
        this.getShokaiShikakuJoho().getShokaiMeiboJoho().setTxtGroupCode(txtGroupCode);
    }

    @JsonIgnore
    public TextBox getTxtKokugaiBunruiCode() {
        return this.getShokaiShikakuJoho().getShokaiMeiboJoho().getTxtKokugaiBunruiCode();
    }

    @JsonIgnore
    public void  setTxtKokugaiBunruiCode(TextBox txtKokugaiBunruiCode) {
        this.getShokaiShikakuJoho().getShokaiMeiboJoho().setTxtKokugaiBunruiCode(txtKokugaiBunruiCode);
    }

    @JsonIgnore
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeMeibo() {
        return this.getShokaiShikakuJoho().getShokaiMeiboJoho().getCcdTohyokuCodeMeibo();
    }

    @JsonIgnore
    public IMeiboBangoDiv getCcdMeiboBango() {
        return this.getShokaiShikakuJoho().getShokaiMeiboJoho().getCcdMeiboBango();
    }

    // </editor-fold>
}
