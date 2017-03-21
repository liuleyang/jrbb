package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchSaibanin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchSaibaninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSaibaninNendo")
    private DropDownList ddlSaibaninNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlSaibaninNendo
     * @return ddlSaibaninNendo
     */
    @JsonProperty("ddlSaibaninNendo")
    public DropDownList getDdlSaibaninNendo() {
        return ddlSaibaninNendo;
    }

    /*
     * setddlSaibaninNendo
     * @param ddlSaibaninNendo ddlSaibaninNendo
     */
    @JsonProperty("ddlSaibaninNendo")
    public void setDdlSaibaninNendo(DropDownList ddlSaibaninNendo) {
        this.ddlSaibaninNendo = ddlSaibaninNendo;
    }

    // </editor-fold>
}
