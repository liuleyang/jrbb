package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyorokuDairiTohyosha のクラスファイル
 *
 * @author 自動生成
 */
public class TohyorokuDairiTohyoshaDiv extends Panel implements ITohyorokuDairiTohyoshaDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTohyorokuDairiTohyosha")
    private DataGrid<dgTohyorokuDairiTohyosha_Row> dgTohyorokuDairiTohyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTohyorokuDairiTohyosha
     * @return dgTohyorokuDairiTohyosha
     */
    @JsonProperty("dgTohyorokuDairiTohyosha")
    @Override
    public DataGrid<dgTohyorokuDairiTohyosha_Row> getDgTohyorokuDairiTohyosha() {
        return dgTohyorokuDairiTohyosha;
    }

    /*
     * setdgTohyorokuDairiTohyosha
     * @param dgTohyorokuDairiTohyosha dgTohyorokuDairiTohyosha
     */
    @JsonProperty("dgTohyorokuDairiTohyosha")
    public void setDgTohyorokuDairiTohyosha(DataGrid<dgTohyorokuDairiTohyosha_Row> dgTohyorokuDairiTohyosha) {
        this.dgTohyorokuDairiTohyosha = dgTohyorokuDairiTohyosha;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況) {
        handler().initialize(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票状況);
    }

    private TohyorokuDairiTohyoshaHandler handler() {
        return new TohyorokuDairiTohyoshaHandler(this);
    }
}
