package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.IJushoJokenSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.JushoJokenSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminTohyojiJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminTohyojiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuminTohyojiJuminShubetsu")
    private JuminTohyojiJuminShubetsuDiv JuminTohyojiJuminShubetsu;
    @JsonProperty("JuminTohyojiNenreiJokei")
    private JuminTohyojiNenreiJokeiDiv JuminTohyojiNenreiJokei;
    @JsonProperty("JuminTohyojiJuteiKikan")
    private JuminTohyojiJuteiKikanDiv JuminTohyojiJuteiKikan;
    @JsonProperty("ccdJuminTohyojiJushoJoken")
    private JushoJokenSelectDiv ccdJuminTohyojiJushoJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJuminTohyojiJuminShubetsu
     * @return JuminTohyojiJuminShubetsu
     */
    @JsonProperty("JuminTohyojiJuminShubetsu")
    public JuminTohyojiJuminShubetsuDiv getJuminTohyojiJuminShubetsu() {
        return JuminTohyojiJuminShubetsu;
    }

    /*
     * setJuminTohyojiJuminShubetsu
     * @param JuminTohyojiJuminShubetsu JuminTohyojiJuminShubetsu
     */
    @JsonProperty("JuminTohyojiJuminShubetsu")
    public void setJuminTohyojiJuminShubetsu(JuminTohyojiJuminShubetsuDiv JuminTohyojiJuminShubetsu) {
        this.JuminTohyojiJuminShubetsu = JuminTohyojiJuminShubetsu;
    }

    /*
     * getJuminTohyojiNenreiJokei
     * @return JuminTohyojiNenreiJokei
     */
    @JsonProperty("JuminTohyojiNenreiJokei")
    public JuminTohyojiNenreiJokeiDiv getJuminTohyojiNenreiJokei() {
        return JuminTohyojiNenreiJokei;
    }

    /*
     * setJuminTohyojiNenreiJokei
     * @param JuminTohyojiNenreiJokei JuminTohyojiNenreiJokei
     */
    @JsonProperty("JuminTohyojiNenreiJokei")
    public void setJuminTohyojiNenreiJokei(JuminTohyojiNenreiJokeiDiv JuminTohyojiNenreiJokei) {
        this.JuminTohyojiNenreiJokei = JuminTohyojiNenreiJokei;
    }

    /*
     * getJuminTohyojiJuteiKikan
     * @return JuminTohyojiJuteiKikan
     */
    @JsonProperty("JuminTohyojiJuteiKikan")
    public JuminTohyojiJuteiKikanDiv getJuminTohyojiJuteiKikan() {
        return JuminTohyojiJuteiKikan;
    }

    /*
     * setJuminTohyojiJuteiKikan
     * @param JuminTohyojiJuteiKikan JuminTohyojiJuteiKikan
     */
    @JsonProperty("JuminTohyojiJuteiKikan")
    public void setJuminTohyojiJuteiKikan(JuminTohyojiJuteiKikanDiv JuminTohyojiJuteiKikan) {
        this.JuminTohyojiJuteiKikan = JuminTohyojiJuteiKikan;
    }

    /*
     * getccdJuminTohyojiJushoJoken
     * @return ccdJuminTohyojiJushoJoken
     */
    @JsonProperty("ccdJuminTohyojiJushoJoken")
    public IJushoJokenSelectDiv getCcdJuminTohyojiJushoJoken() {
        return ccdJuminTohyojiJushoJoken;
    }

    // </editor-fold>
}
