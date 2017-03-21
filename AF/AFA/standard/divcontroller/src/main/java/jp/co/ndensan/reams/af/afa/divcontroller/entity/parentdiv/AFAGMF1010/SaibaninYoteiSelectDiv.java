package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SaibaninYoteiSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaibaninYoteiSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SaibaninYoteiSelectParam")
    private SaibaninYoteiSelectParamDiv SaibaninYoteiSelectParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSaibaninYoteiSelectParam
     * @return SaibaninYoteiSelectParam
     */
    @JsonProperty("SaibaninYoteiSelectParam")
    public SaibaninYoteiSelectParamDiv getSaibaninYoteiSelectParam() {
        return SaibaninYoteiSelectParam;
    }

    /*
     * setSaibaninYoteiSelectParam
     * @param SaibaninYoteiSelectParam SaibaninYoteiSelectParam
     */
    @JsonProperty("SaibaninYoteiSelectParam")
    public void setSaibaninYoteiSelectParam(SaibaninYoteiSelectParamDiv SaibaninYoteiSelectParam) {
        this.SaibaninYoteiSelectParam = SaibaninYoteiSelectParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHozonFileName() {
        return this.getSaibaninYoteiSelectParam().getTxtHozonFileName();
    }

    @JsonIgnore
    public void  setTxtHozonFileName(TextBox txtHozonFileName) {
        this.getSaibaninYoteiSelectParam().setTxtHozonFileName(txtHozonFileName);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenrei() {
        return this.getSaibaninYoteiSelectParam().getTxtNenrei();
    }

    @JsonIgnore
    public void  setTxtNenrei(TextBoxNum txtNenrei) {
        this.getSaibaninYoteiSelectParam().setTxtNenrei(txtNenrei);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunYMD() {
        return this.getSaibaninYoteiSelectParam().getTxtNenreiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.getSaibaninYoteiSelectParam().setTxtNenreiKijunYMD(txtNenreiKijunYMD);
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getSaibaninYoteiSelectParam().getCcdShohonNameList();
    }

    // </editor-fold>
}
