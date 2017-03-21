package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaSochiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuzaishaSochiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkSochiZumi")
    private CheckBoxList chkSochiZumi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkSochiZumi
     * @return chkSochiZumi
     */
    @JsonProperty("chkSochiZumi")
    public CheckBoxList getChkSochiZumi() {
        return chkSochiZumi;
    }

    /*
     * setchkSochiZumi
     * @param chkSochiZumi chkSochiZumi
     */
    @JsonProperty("chkSochiZumi")
    public void setChkSochiZumi(CheckBoxList chkSochiZumi) {
        this.chkSochiZumi = chkSochiZumi;
    }

    // </editor-fold>
}
