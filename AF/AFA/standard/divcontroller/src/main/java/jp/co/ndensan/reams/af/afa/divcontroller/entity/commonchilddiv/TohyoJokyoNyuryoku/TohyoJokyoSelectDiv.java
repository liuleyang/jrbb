package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyoJokyoSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyoJokyoSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTohyoJokyo")
    private RadioButton radTohyoJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTohyoJokyo
     * @return radTohyoJokyo
     */
    @JsonProperty("radTohyoJokyo")
    public RadioButton getRadTohyoJokyo() {
        return radTohyoJokyo;
    }

    /*
     * setradTohyoJokyo
     * @param radTohyoJokyo radTohyoJokyo
     */
    @JsonProperty("radTohyoJokyo")
    public void setRadTohyoJokyo(RadioButton radTohyoJokyo) {
        this.radTohyoJokyo = radTohyoJokyo;
    }

    // </editor-fold>
}
