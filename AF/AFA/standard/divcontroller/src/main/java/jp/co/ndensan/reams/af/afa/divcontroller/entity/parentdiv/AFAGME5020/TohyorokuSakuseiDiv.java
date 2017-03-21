package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyorokuSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyorokuSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyorokuSakuseiJoken")
    private TohyorokuSakuseiJokenDiv TohyorokuSakuseiJoken;
    @JsonProperty("TohyorokuShosai")
    private TohyorokuShosaiDiv TohyorokuShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyorokuSakuseiJoken
     * @return TohyorokuSakuseiJoken
     */
    @JsonProperty("TohyorokuSakuseiJoken")
    public TohyorokuSakuseiJokenDiv getTohyorokuSakuseiJoken() {
        return TohyorokuSakuseiJoken;
    }

    /*
     * setTohyorokuSakuseiJoken
     * @param TohyorokuSakuseiJoken TohyorokuSakuseiJoken
     */
    @JsonProperty("TohyorokuSakuseiJoken")
    public void setTohyorokuSakuseiJoken(TohyorokuSakuseiJokenDiv TohyorokuSakuseiJoken) {
        this.TohyorokuSakuseiJoken = TohyorokuSakuseiJoken;
    }

    /*
     * getTohyorokuShosai
     * @return TohyorokuShosai
     */
    @JsonProperty("TohyorokuShosai")
    public TohyorokuShosaiDiv getTohyorokuShosai() {
        return TohyorokuShosai;
    }

    /*
     * setTohyorokuShosai
     * @param TohyorokuShosai TohyorokuShosai
     */
    @JsonProperty("TohyorokuShosai")
    public void setTohyorokuShosai(TohyorokuShosaiDiv TohyorokuShosai) {
        this.TohyorokuShosai = TohyorokuShosai;
    }

    // </editor-fold>
}
