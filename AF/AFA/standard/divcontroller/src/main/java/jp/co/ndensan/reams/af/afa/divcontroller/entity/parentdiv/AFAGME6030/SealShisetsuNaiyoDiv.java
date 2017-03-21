package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.IAtenaSealLayoutDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SealShisetsuNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealShisetsuNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSealLayout")
    private AtenaSealLayoutDiv ccdSealLayout;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSealLayout
     * @return ccdSealLayout
     */
    @JsonProperty("ccdSealLayout")
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return ccdSealLayout;
    }

    // </editor-fold>
}
