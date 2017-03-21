package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaisankuSenkyojiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaisankuSenkyojiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZaisankuSenkyojiTorokuParam")
    private ZaisankuSenkyojiTorokuParamDiv ZaisankuSenkyojiTorokuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZaisankuSenkyojiTorokuParam
     * @return ZaisankuSenkyojiTorokuParam
     */
    @JsonProperty("ZaisankuSenkyojiTorokuParam")
    public ZaisankuSenkyojiTorokuParamDiv getZaisankuSenkyojiTorokuParam() {
        return ZaisankuSenkyojiTorokuParam;
    }

    /*
     * setZaisankuSenkyojiTorokuParam
     * @param ZaisankuSenkyojiTorokuParam ZaisankuSenkyojiTorokuParam
     */
    @JsonProperty("ZaisankuSenkyojiTorokuParam")
    public void setZaisankuSenkyojiTorokuParam(ZaisankuSenkyojiTorokuParamDiv ZaisankuSenkyojiTorokuParam) {
        this.ZaisankuSenkyojiTorokuParam = ZaisankuSenkyojiTorokuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ZaisankuMeiboKoshinKijunDiv getZaisankuMeiboKoshinKijun() {
        return this.getZaisankuSenkyojiTorokuParam().getZaisankuMeiboKoshinKijun();
    }

    @JsonIgnore
    public void  setZaisankuMeiboKoshinKijun(ZaisankuMeiboKoshinKijunDiv ZaisankuMeiboKoshinKijun) {
        this.getZaisankuSenkyojiTorokuParam().setZaisankuMeiboKoshinKijun(ZaisankuMeiboKoshinKijun);
    }

    @JsonIgnore
    public ZaisankuJushoJokenDiv getZaisankuJushoJoken() {
        return this.getZaisankuSenkyojiTorokuParam().getZaisankuJushoJoken();
    }

    @JsonIgnore
    public void  setZaisankuJushoJoken(ZaisankuJushoJokenDiv ZaisankuJushoJoken) {
        this.getZaisankuSenkyojiTorokuParam().setZaisankuJushoJoken(ZaisankuJushoJoken);
    }

    @JsonIgnore
    public ZaisankuSakuseiChohyoDiv getZaisankuSakuseiChohyo() {
        return this.getZaisankuSenkyojiTorokuParam().getZaisankuSakuseiChohyo();
    }

    @JsonIgnore
    public void  setZaisankuSakuseiChohyo(ZaisankuSakuseiChohyoDiv ZaisankuSakuseiChohyo) {
        this.getZaisankuSenkyojiTorokuParam().setZaisankuSakuseiChohyo(ZaisankuSakuseiChohyo);
    }

    @JsonIgnore
    public ZaisankuSakuseiChohyoMeiboShohonDiv getZaisankuSakuseiChohyoMeiboShohon() {
        return this.getZaisankuSenkyojiTorokuParam().getZaisankuSakuseiChohyo().getZaisankuSakuseiChohyoMeiboShohon();
    }

    @JsonIgnore
    public void  setZaisankuSakuseiChohyoMeiboShohon(ZaisankuSakuseiChohyoMeiboShohonDiv ZaisankuSakuseiChohyoMeiboShohon) {
        this.getZaisankuSenkyojiTorokuParam().getZaisankuSakuseiChohyo().setZaisankuSakuseiChohyoMeiboShohon(ZaisankuSakuseiChohyoMeiboShohon);
    }

    // </editor-fold>
}
