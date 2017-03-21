package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.TohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ZenjitsuSakuseiChohyoJimuShoribo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoJimuShoriboDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkJimuShoriboTaisho")
    private CheckBoxList chkJimuShoriboTaisho;
    @JsonProperty("ccdJimuShoriboTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdJimuShoriboTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkJimuShoriboTaisho
     * @return chkJimuShoriboTaisho
     */
    @JsonProperty("chkJimuShoriboTaisho")
    public CheckBoxList getChkJimuShoriboTaisho() {
        return chkJimuShoriboTaisho;
    }

    /*
     * setchkJimuShoriboTaisho
     * @param chkJimuShoriboTaisho chkJimuShoriboTaisho
     */
    @JsonProperty("chkJimuShoriboTaisho")
    public void setChkJimuShoriboTaisho(CheckBoxList chkJimuShoriboTaisho) {
        this.chkJimuShoriboTaisho = chkJimuShoriboTaisho;
    }

    /*
     * getccdJimuShoriboTohyokuCode
     * @return ccdJimuShoriboTohyokuCode
     */
    @JsonProperty("ccdJimuShoriboTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdJimuShoriboTohyokuCode() {
        return ccdJimuShoriboTohyokuCode;
    }

    // </editor-fold>
}
