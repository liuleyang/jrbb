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
 * ZenjitsuSakuseiChohyoTorokushaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoTorokushaListDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTorokushasuListFuzaishaShikaku")
    private CheckBoxList chkTorokushasuListFuzaishaShikaku;
    @JsonProperty("ccdTorokushaListTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdTorokushaListTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTorokushasuListFuzaishaShikaku
     * @return chkTorokushasuListFuzaishaShikaku
     */
    @JsonProperty("chkTorokushasuListFuzaishaShikaku")
    public CheckBoxList getChkTorokushasuListFuzaishaShikaku() {
        return chkTorokushasuListFuzaishaShikaku;
    }

    /*
     * setchkTorokushasuListFuzaishaShikaku
     * @param chkTorokushasuListFuzaishaShikaku chkTorokushasuListFuzaishaShikaku
     */
    @JsonProperty("chkTorokushasuListFuzaishaShikaku")
    public void setChkTorokushasuListFuzaishaShikaku(CheckBoxList chkTorokushasuListFuzaishaShikaku) {
        this.chkTorokushasuListFuzaishaShikaku = chkTorokushasuListFuzaishaShikaku;
    }

    /*
     * getccdTorokushaListTohyokuCode
     * @return ccdTorokushaListTohyokuCode
     */
    @JsonProperty("ccdTorokushaListTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdTorokushaListTohyokuCode() {
        return ccdTorokushaListTohyokuCode;
    }

    // </editor-fold>
}
