package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyorokuKyohiNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class TohyorokuKyohiNyuryokuDiv extends Panel implements ITohyorokuKyohiNyuryokuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTohyorokuKyohiNyuryoku")
    private DataGrid<dgTohyorokuKyohiNyuryoku_Row> dgTohyorokuKyohiNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTohyorokuKyohiNyuryoku
     * @return dgTohyorokuKyohiNyuryoku
     */
    @JsonProperty("dgTohyorokuKyohiNyuryoku")
    @Override
    public DataGrid<dgTohyorokuKyohiNyuryoku_Row> getDgTohyorokuKyohiNyuryoku() {
        return dgTohyorokuKyohiNyuryoku;
    }

    /*
     * setdgTohyorokuKyohiNyuryoku
     * @param dgTohyorokuKyohiNyuryoku dgTohyorokuKyohiNyuryoku
     */
    @JsonProperty("dgTohyorokuKyohiNyuryoku")
    public void setDgTohyorokuKyohiNyuryoku(DataGrid<dgTohyorokuKyohiNyuryoku_Row> dgTohyorokuKyohiNyuryoku) {
        this.dgTohyorokuKyohiNyuryoku = dgTohyorokuKyohiNyuryoku;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(int gyosu) {
        getHandler().load(gyosu);
    }

    @Override
    public void initialize(HashMap item) {
        getHandler().initialize(item);
    }

    @Override
    public void clearData() {
        getHandler().clearDataSource();
    }

    @JsonIgnore
    public TohyorokuKyohiNyuryokuHandler getHandler() {
        return new TohyorokuKyohiNyuryokuHandler(this);
    }

    @Override
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            boolean 代理投票有フラグ,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況) {
        getHandler().initialize(抄本番号, 選挙番号, 報告年月日, 代理投票有フラグ, 施設コード, 投票区コード, 投票状況);
    }

}
