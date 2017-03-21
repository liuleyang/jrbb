package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.BarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BarCodeTojitsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class BarCodeTojitsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BarCodeTojitsuNyuryoku")
    private BarCodeTojitsuNyuryokuDiv BarCodeTojitsuNyuryoku;
    @JsonProperty("HdnShikakuKubun")
    private RString HdnShikakuKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBarCodeTojitsuNyuryoku
     * @return BarCodeTojitsuNyuryoku
     */
    @JsonProperty("BarCodeTojitsuNyuryoku")
    public BarCodeTojitsuNyuryokuDiv getBarCodeTojitsuNyuryoku() {
        return BarCodeTojitsuNyuryoku;
    }

    /*
     * setBarCodeTojitsuNyuryoku
     * @param BarCodeTojitsuNyuryoku BarCodeTojitsuNyuryoku
     */
    @JsonProperty("BarCodeTojitsuNyuryoku")
    public void setBarCodeTojitsuNyuryoku(BarCodeTojitsuNyuryokuDiv BarCodeTojitsuNyuryoku) {
        this.BarCodeTojitsuNyuryoku = BarCodeTojitsuNyuryoku;
    }

    /*
     * getHdnShikakuKubun
     * @return HdnShikakuKubun
     */
    @JsonProperty("HdnShikakuKubun")
    public RString getHdnShikakuKubun() {
        return HdnShikakuKubun;
    }

    /*
     * setHdnShikakuKubun
     * @param HdnShikakuKubun HdnShikakuKubun
     */
    @JsonProperty("HdnShikakuKubun")
    public void setHdnShikakuKubun(RString HdnShikakuKubun) {
        this.HdnShikakuKubun = HdnShikakuKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSenkyoRyakuName() {
        return this.getBarCodeTojitsuNyuryoku().getLblSenkyoRyakuName();
    }

    @JsonIgnore
    public void  setLblSenkyoRyakuName(Label lblSenkyoRyakuName) {
        this.getBarCodeTojitsuNyuryoku().setLblSenkyoRyakuName(lblSenkyoRyakuName);
    }

    @JsonIgnore
    public DataGrid<dgBarCodeTojitsuTaishosha_Row> getDgBarCodeTojitsuTaishosha() {
        return this.getBarCodeTojitsuNyuryoku().getDgBarCodeTojitsuTaishosha();
    }

    @JsonIgnore
    public void  setDgBarCodeTojitsuTaishosha(DataGrid<dgBarCodeTojitsuTaishosha_Row> dgBarCodeTojitsuTaishosha) {
        this.getBarCodeTojitsuNyuryoku().setDgBarCodeTojitsuTaishosha(dgBarCodeTojitsuTaishosha);
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getBarCodeTojitsuNyuryoku().getCcdShohonNameList();
    }

    @JsonIgnore
    public IBarCodeNyuryokuDiv getCcdNyujokenBarCode() {
        return this.getBarCodeTojitsuNyuryoku().getCcdNyujokenBarCode();
    }

    // </editor-fold>
}
