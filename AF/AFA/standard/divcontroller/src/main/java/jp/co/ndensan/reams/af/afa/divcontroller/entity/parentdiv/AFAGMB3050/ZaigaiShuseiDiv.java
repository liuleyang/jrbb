package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050;
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
 * ZaigaiShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaigaiShuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZaigaiShuseiShikakuJoho")
    private ZaigaiShuseiShikakuJohoDiv ZaigaiShuseiShikakuJoho;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdKojinJoho")
    private KojinJohoDiv ccdKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZaigaiShuseiShikakuJoho
     * @return ZaigaiShuseiShikakuJoho
     */
    @JsonProperty("ZaigaiShuseiShikakuJoho")
    public ZaigaiShuseiShikakuJohoDiv getZaigaiShuseiShikakuJoho() {
        return ZaigaiShuseiShikakuJoho;
    }

    /*
     * setZaigaiShuseiShikakuJoho
     * @param ZaigaiShuseiShikakuJoho ZaigaiShuseiShikakuJoho
     */
    @JsonProperty("ZaigaiShuseiShikakuJoho")
    public void setZaigaiShuseiShikakuJoho(ZaigaiShuseiShikakuJohoDiv ZaigaiShuseiShikakuJoho) {
        this.ZaigaiShuseiShikakuJoho = ZaigaiShuseiShikakuJoho;
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
     * getccdKojinJoho
     * @return ccdKojinJoho
     */
    @JsonProperty("ccdKojinJoho")
    public IKojinJohoDiv getCcdKojinJoho() {
        return ccdKojinJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtGroupCode() {
        return this.getZaigaiShuseiShikakuJoho().getZaigaiShuseiMeiboJoho().getTxtGroupCode();
    }

    @JsonIgnore
    public void  setTxtGroupCode(TextBox txtGroupCode) {
        this.getZaigaiShuseiShikakuJoho().getZaigaiShuseiMeiboJoho().setTxtGroupCode(txtGroupCode);
    }

    @JsonIgnore
    public TextBox getTxtKokugaiBunruiCode() {
        return this.getZaigaiShuseiShikakuJoho().getZaigaiShuseiMeiboJoho().getTxtKokugaiBunruiCode();
    }

    @JsonIgnore
    public void  setTxtKokugaiBunruiCode(TextBox txtKokugaiBunruiCode) {
        this.getZaigaiShuseiShikakuJoho().getZaigaiShuseiMeiboJoho().setTxtKokugaiBunruiCode(txtKokugaiBunruiCode);
    }

    @JsonIgnore
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeMeibo() {
        return this.getZaigaiShuseiShikakuJoho().getZaigaiShuseiMeiboJoho().getCcdTohyokuCodeMeibo();
    }

    @JsonIgnore
    public IMeiboBangoDiv getCcdMeiboBango() {
        return this.getZaigaiShuseiShikakuJoho().getZaigaiShuseiMeiboJoho().getCcdMeiboBango();
    }

    // </editor-fold>
}
