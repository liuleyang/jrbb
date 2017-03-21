package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeMasterMaintenance.CodeMasterMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeMasterMaintenance.ICodeMasterMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * CodeMasterMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class CodeMasterMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdCodeMasterMaintenance")
    private CodeMasterMaintenanceDiv ccdCodeMasterMaintenance;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdCodeMasterMaintenance
     * @return ccdCodeMasterMaintenance
     */
    @JsonProperty("ccdCodeMasterMaintenance")
    public ICodeMasterMaintenanceDiv getCcdCodeMasterMaintenance() {
        return ccdCodeMasterMaintenance;
    }

    // </editor-fold>
}
