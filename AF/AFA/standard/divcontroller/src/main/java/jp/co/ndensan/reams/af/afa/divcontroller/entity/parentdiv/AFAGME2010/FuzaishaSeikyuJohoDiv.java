package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.ITohyoJiyuCodeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.TohyoJiyuCodeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaSeikyuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuzaishaSeikyuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSeikyusha")
    private RadioButton radSeikyusha;
    @JsonProperty("txtSeikyuYMD")
    private TextBoxDate txtSeikyuYMD;
    @JsonProperty("ccdFuzaishaTohyoJiyu")
    private TohyoJiyuCodeDiv ccdFuzaishaTohyoJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSeikyusha
     * @return radSeikyusha
     */
    @JsonProperty("radSeikyusha")
    public RadioButton getRadSeikyusha() {
        return radSeikyusha;
    }

    /*
     * setradSeikyusha
     * @param radSeikyusha radSeikyusha
     */
    @JsonProperty("radSeikyusha")
    public void setRadSeikyusha(RadioButton radSeikyusha) {
        this.radSeikyusha = radSeikyusha;
    }

    /*
     * gettxtSeikyuYMD
     * @return txtSeikyuYMD
     */
    @JsonProperty("txtSeikyuYMD")
    public TextBoxDate getTxtSeikyuYMD() {
        return txtSeikyuYMD;
    }

    /*
     * settxtSeikyuYMD
     * @param txtSeikyuYMD txtSeikyuYMD
     */
    @JsonProperty("txtSeikyuYMD")
    public void setTxtSeikyuYMD(TextBoxDate txtSeikyuYMD) {
        this.txtSeikyuYMD = txtSeikyuYMD;
    }

    /*
     * getccdFuzaishaTohyoJiyu
     * @return ccdFuzaishaTohyoJiyu
     */
    @JsonProperty("ccdFuzaishaTohyoJiyu")
    public ITohyoJiyuCodeDiv getCcdFuzaishaTohyoJiyu() {
        return ccdFuzaishaTohyoJiyu;
    }

    // </editor-fold>
}
