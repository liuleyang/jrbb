package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyorokuShimeiNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class TohyorokuShimeiNyuryokuDiv extends Panel implements ITohyorokuShimeiNyuryokuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTohyorokuShimeiNyuryoku")
    private DataGrid<dgTohyorokuShimeiNyuryoku_Row> dgTohyorokuShimeiNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTohyorokuShimeiNyuryoku
     * @return dgTohyorokuShimeiNyuryoku
     */
    @JsonProperty("dgTohyorokuShimeiNyuryoku")
    @Override
    public DataGrid<dgTohyorokuShimeiNyuryoku_Row> getDgTohyorokuShimeiNyuryoku() {
        return dgTohyorokuShimeiNyuryoku;
    }

    /*
     * setdgTohyorokuShimeiNyuryoku
     * @param dgTohyorokuShimeiNyuryoku dgTohyorokuShimeiNyuryoku
     */
    @JsonProperty("dgTohyorokuShimeiNyuryoku")
    public void setDgTohyorokuShimeiNyuryoku(DataGrid<dgTohyorokuShimeiNyuryoku_Row> dgTohyorokuShimeiNyuryoku) {
        this.dgTohyorokuShimeiNyuryoku = dgTohyorokuShimeiNyuryoku;
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
    public TohyorokuShimeiNyuryokuHandler getHandler() {
        return new TohyorokuShimeiNyuryokuHandler(this);
    }

    @Override
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            Code 投票録項目種類,
            RString 立会人連番) {
        getHandler().initialize(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票状況, 投票録項目種類, 立会人連番, 2);
    }

    @Override
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            Code 投票録項目種類,
            RString 立会人連番,
            int 行数) {
        getHandler().initialize(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票状況, 投票録項目種類, 立会人連番, 行数);
    }

    @Override
    public void setEditMode(boolean editFlg) {
        getHandler().setEditMode(editFlg);
    }
}
