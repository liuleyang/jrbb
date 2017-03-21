package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KyohiJiyuNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class KyohiJiyuNyuryokuDiv extends Panel implements IKyohiJiyuNyuryokuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKyohiJiyu")
    private DropDownList ddlKyohiJiyu;
    @JsonProperty("txtKyohiJiyu")
    private TextBox txtKyohiJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKyohiJiyu
     * @return ddlKyohiJiyu
     */
    @JsonProperty("ddlKyohiJiyu")
    public DropDownList getDdlKyohiJiyu() {
        return ddlKyohiJiyu;
    }

    /*
     * setddlKyohiJiyu
     * @param ddlKyohiJiyu ddlKyohiJiyu
     */
    @JsonProperty("ddlKyohiJiyu")
    public void setDdlKyohiJiyu(DropDownList ddlKyohiJiyu) {
        this.ddlKyohiJiyu = ddlKyohiJiyu;
    }

    /*
     * gettxtKyohiJiyu
     * @return txtKyohiJiyu
     */
    @JsonProperty("txtKyohiJiyu")
    public TextBox getTxtKyohiJiyu() {
        return txtKyohiJiyu;
    }

    /*
     * settxtKyohiJiyu
     * @param txtKyohiJiyu txtKyohiJiyu
     */
    @JsonProperty("txtKyohiJiyu")
    public void setTxtKyohiJiyu(TextBox txtKyohiJiyu) {
        this.txtKyohiJiyu = txtKyohiJiyu;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public RString get拒否事由定型文() {
        return getDdlKyohiJiyu().getSelectedValue();
    }

    @JsonIgnore
    @Override
    public RString get拒否事由入力文() {
        return getTxtKyohiJiyu().getValue();
    }

    @Override
    public RString get投票状況用拒否事由() {
        return getHandler().edit投票状況用拒否事由();
    }

    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @JsonIgnore
    public KyohiJiyuNyuryokuHandler getHandler() {
        return new KyohiJiyuNyuryokuHandler(this);
    }

}
