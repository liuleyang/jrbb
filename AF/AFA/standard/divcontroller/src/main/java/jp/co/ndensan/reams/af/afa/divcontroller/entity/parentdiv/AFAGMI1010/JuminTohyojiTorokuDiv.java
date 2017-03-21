package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminTohyojiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminTohyojiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuminTohyojiTorokuParam")
    private JuminTohyojiTorokuParamDiv JuminTohyojiTorokuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJuminTohyojiTorokuParam
     * @return JuminTohyojiTorokuParam
     */
    @JsonProperty("JuminTohyojiTorokuParam")
    public JuminTohyojiTorokuParamDiv getJuminTohyojiTorokuParam() {
        return JuminTohyojiTorokuParam;
    }

    /*
     * setJuminTohyojiTorokuParam
     * @param JuminTohyojiTorokuParam JuminTohyojiTorokuParam
     */
    @JsonProperty("JuminTohyojiTorokuParam")
    public void setJuminTohyojiTorokuParam(JuminTohyojiTorokuParamDiv JuminTohyojiTorokuParam) {
        this.JuminTohyojiTorokuParam = JuminTohyojiTorokuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JuminTohyojiJohoDiv getJuminTohyojiJoho() {
        return this.getJuminTohyojiTorokuParam().getJuminTohyojiJoho();
    }

    @JsonIgnore
    public void  setJuminTohyojiJoho(JuminTohyojiJohoDiv JuminTohyojiJoho) {
        this.getJuminTohyojiTorokuParam().setJuminTohyojiJoho(JuminTohyojiJoho);
    }

    @JsonIgnore
    public JuminTohyojiJokenDiv getJuminTohyojiJoken() {
        return this.getJuminTohyojiTorokuParam().getJuminTohyojiJoken();
    }

    @JsonIgnore
    public void  setJuminTohyojiJoken(JuminTohyojiJokenDiv JuminTohyojiJoken) {
        this.getJuminTohyojiTorokuParam().setJuminTohyojiJoken(JuminTohyojiJoken);
    }

    @JsonIgnore
    public JuminTohyojiSakuseiChohyoDiv getJuminTohyojiSakuseiChohyo() {
        return this.getJuminTohyojiTorokuParam().getJuminTohyojiSakuseiChohyo();
    }

    @JsonIgnore
    public void  setJuminTohyojiSakuseiChohyo(JuminTohyojiSakuseiChohyoDiv JuminTohyojiSakuseiChohyo) {
        this.getJuminTohyojiTorokuParam().setJuminTohyojiSakuseiChohyo(JuminTohyojiSakuseiChohyo);
    }

    @JsonIgnore
    public JuminTohyojiSakuseiChohyoMeiboShohonDiv getJuminTohyojiSakuseiChohyoMeiboShohon() {
        return this.getJuminTohyojiTorokuParam().getJuminTohyojiSakuseiChohyo().getJuminTohyojiSakuseiChohyoMeiboShohon();
    }

    @JsonIgnore
    public void  setJuminTohyojiSakuseiChohyoMeiboShohon(JuminTohyojiSakuseiChohyoMeiboShohonDiv JuminTohyojiSakuseiChohyoMeiboShohon) {
        this.getJuminTohyojiTorokuParam().getJuminTohyojiSakuseiChohyo().setJuminTohyojiSakuseiChohyoMeiboShohon(JuminTohyojiSakuseiChohyoMeiboShohon);
    }

    // </editor-fold>
}
