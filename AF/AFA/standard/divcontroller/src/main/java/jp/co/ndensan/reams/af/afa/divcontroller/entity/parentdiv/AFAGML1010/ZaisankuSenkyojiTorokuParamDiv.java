package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ZaisankuSenkyojiTorokuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaisankuSenkyojiTorokuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZaisankuMeiboKoshinKijun")
    private ZaisankuMeiboKoshinKijunDiv ZaisankuMeiboKoshinKijun;
    @JsonProperty("ZaisankuJushoJoken")
    private ZaisankuJushoJokenDiv ZaisankuJushoJoken;
    @JsonProperty("ZaisankuSakuseiChohyo")
    private ZaisankuSakuseiChohyoDiv ZaisankuSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZaisankuMeiboKoshinKijun
     * @return ZaisankuMeiboKoshinKijun
     */
    @JsonProperty("ZaisankuMeiboKoshinKijun")
    public ZaisankuMeiboKoshinKijunDiv getZaisankuMeiboKoshinKijun() {
        return ZaisankuMeiboKoshinKijun;
    }

    /*
     * setZaisankuMeiboKoshinKijun
     * @param ZaisankuMeiboKoshinKijun ZaisankuMeiboKoshinKijun
     */
    @JsonProperty("ZaisankuMeiboKoshinKijun")
    public void setZaisankuMeiboKoshinKijun(ZaisankuMeiboKoshinKijunDiv ZaisankuMeiboKoshinKijun) {
        this.ZaisankuMeiboKoshinKijun = ZaisankuMeiboKoshinKijun;
    }

    /*
     * getZaisankuJushoJoken
     * @return ZaisankuJushoJoken
     */
    @JsonProperty("ZaisankuJushoJoken")
    public ZaisankuJushoJokenDiv getZaisankuJushoJoken() {
        return ZaisankuJushoJoken;
    }

    /*
     * setZaisankuJushoJoken
     * @param ZaisankuJushoJoken ZaisankuJushoJoken
     */
    @JsonProperty("ZaisankuJushoJoken")
    public void setZaisankuJushoJoken(ZaisankuJushoJokenDiv ZaisankuJushoJoken) {
        this.ZaisankuJushoJoken = ZaisankuJushoJoken;
    }

    /*
     * getZaisankuSakuseiChohyo
     * @return ZaisankuSakuseiChohyo
     */
    @JsonProperty("ZaisankuSakuseiChohyo")
    public ZaisankuSakuseiChohyoDiv getZaisankuSakuseiChohyo() {
        return ZaisankuSakuseiChohyo;
    }

    /*
     * setZaisankuSakuseiChohyo
     * @param ZaisankuSakuseiChohyo ZaisankuSakuseiChohyo
     */
    @JsonProperty("ZaisankuSakuseiChohyo")
    public void setZaisankuSakuseiChohyo(ZaisankuSakuseiChohyoDiv ZaisankuSakuseiChohyo) {
        this.ZaisankuSakuseiChohyo = ZaisankuSakuseiChohyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgZaisankuJusho_Row> getDgZaisankuJusho() {
        return this.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().getDgZaisankuJusho();
    }

    @JsonIgnore
    public void  setDgZaisankuJusho(DataGrid<dgZaisankuJusho_Row> dgZaisankuJusho) {
        this.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().setDgZaisankuJusho(dgZaisankuJusho);
    }

    @JsonIgnore
    public ZaisankuSakuseiChohyoMeiboShohonDiv getZaisankuSakuseiChohyoMeiboShohon() {
        return this.getZaisankuSakuseiChohyo().getZaisankuSakuseiChohyoMeiboShohon();
    }

    @JsonIgnore
    public void  setZaisankuSakuseiChohyoMeiboShohon(ZaisankuSakuseiChohyoMeiboShohonDiv ZaisankuSakuseiChohyoMeiboShohon) {
        this.getZaisankuSakuseiChohyo().setZaisankuSakuseiChohyoMeiboShohon(ZaisankuSakuseiChohyoMeiboShohon);
    }

    // </editor-fold>
}
