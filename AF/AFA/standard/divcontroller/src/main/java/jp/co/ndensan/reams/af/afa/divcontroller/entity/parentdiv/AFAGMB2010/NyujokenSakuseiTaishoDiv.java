package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NyujokenSakuseiTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenSakuseiTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyujokenSentaku")
    private NyujokenSentakuDiv NyujokenSentaku;
    @JsonProperty("NyujokenOshiraseHagaki")
    private NyujokenOshiraseHagakiDiv NyujokenOshiraseHagaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyujokenSentaku
     * @return NyujokenSentaku
     */
    @JsonProperty("NyujokenSentaku")
    public NyujokenSentakuDiv getNyujokenSentaku() {
        return NyujokenSentaku;
    }

    /*
     * setNyujokenSentaku
     * @param NyujokenSentaku NyujokenSentaku
     */
    @JsonProperty("NyujokenSentaku")
    public void setNyujokenSentaku(NyujokenSentakuDiv NyujokenSentaku) {
        this.NyujokenSentaku = NyujokenSentaku;
    }

    /*
     * getNyujokenOshiraseHagaki
     * @return NyujokenOshiraseHagaki
     */
    @JsonProperty("NyujokenOshiraseHagaki")
    public NyujokenOshiraseHagakiDiv getNyujokenOshiraseHagaki() {
        return NyujokenOshiraseHagaki;
    }

    /*
     * setNyujokenOshiraseHagaki
     * @param NyujokenOshiraseHagaki NyujokenOshiraseHagaki
     */
    @JsonProperty("NyujokenOshiraseHagaki")
    public void setNyujokenOshiraseHagaki(NyujokenOshiraseHagakiDiv NyujokenOshiraseHagaki) {
        this.NyujokenOshiraseHagaki = NyujokenOshiraseHagaki;
    }

    // </editor-fold>
}
