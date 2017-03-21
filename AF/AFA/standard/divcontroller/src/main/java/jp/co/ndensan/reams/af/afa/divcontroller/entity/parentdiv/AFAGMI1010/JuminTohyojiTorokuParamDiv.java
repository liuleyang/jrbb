package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JuminTohyojiTorokuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminTohyojiTorokuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuminTohyojiJoho")
    private JuminTohyojiJohoDiv JuminTohyojiJoho;
    @JsonProperty("JuminTohyojiJoken")
    private JuminTohyojiJokenDiv JuminTohyojiJoken;
    @JsonProperty("JuminTohyojiSakuseiChohyo")
    private JuminTohyojiSakuseiChohyoDiv JuminTohyojiSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJuminTohyojiJoho
     * @return JuminTohyojiJoho
     */
    @JsonProperty("JuminTohyojiJoho")
    public JuminTohyojiJohoDiv getJuminTohyojiJoho() {
        return JuminTohyojiJoho;
    }

    /*
     * setJuminTohyojiJoho
     * @param JuminTohyojiJoho JuminTohyojiJoho
     */
    @JsonProperty("JuminTohyojiJoho")
    public void setJuminTohyojiJoho(JuminTohyojiJohoDiv JuminTohyojiJoho) {
        this.JuminTohyojiJoho = JuminTohyojiJoho;
    }

    /*
     * getJuminTohyojiJoken
     * @return JuminTohyojiJoken
     */
    @JsonProperty("JuminTohyojiJoken")
    public JuminTohyojiJokenDiv getJuminTohyojiJoken() {
        return JuminTohyojiJoken;
    }

    /*
     * setJuminTohyojiJoken
     * @param JuminTohyojiJoken JuminTohyojiJoken
     */
    @JsonProperty("JuminTohyojiJoken")
    public void setJuminTohyojiJoken(JuminTohyojiJokenDiv JuminTohyojiJoken) {
        this.JuminTohyojiJoken = JuminTohyojiJoken;
    }

    /*
     * getJuminTohyojiSakuseiChohyo
     * @return JuminTohyojiSakuseiChohyo
     */
    @JsonProperty("JuminTohyojiSakuseiChohyo")
    public JuminTohyojiSakuseiChohyoDiv getJuminTohyojiSakuseiChohyo() {
        return JuminTohyojiSakuseiChohyo;
    }

    /*
     * setJuminTohyojiSakuseiChohyo
     * @param JuminTohyojiSakuseiChohyo JuminTohyojiSakuseiChohyo
     */
    @JsonProperty("JuminTohyojiSakuseiChohyo")
    public void setJuminTohyojiSakuseiChohyo(JuminTohyojiSakuseiChohyoDiv JuminTohyojiSakuseiChohyo) {
        this.JuminTohyojiSakuseiChohyo = JuminTohyojiSakuseiChohyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JuminTohyojiSakuseiChohyoMeiboShohonDiv getJuminTohyojiSakuseiChohyoMeiboShohon() {
        return this.getJuminTohyojiSakuseiChohyo().getJuminTohyojiSakuseiChohyoMeiboShohon();
    }

    @JsonIgnore
    public void  setJuminTohyojiSakuseiChohyoMeiboShohon(JuminTohyojiSakuseiChohyoMeiboShohonDiv JuminTohyojiSakuseiChohyoMeiboShohon) {
        this.getJuminTohyojiSakuseiChohyo().setJuminTohyojiSakuseiChohyoMeiboShohon(JuminTohyojiSakuseiChohyoMeiboShohon);
    }

    // </editor-fold>
}
