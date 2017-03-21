package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku;

import java.util.HashMap;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITohyorokuKyohiNyuryokuDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param gyosu 作成する行数
     */
    void load(int gyosu);

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param item セットするデータ
     */
    void initialize(HashMap item);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * この共有子DIVの初期表示を行います。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 代理投票有フラグ 代理投票有フラグ
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     */
    void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            boolean 代理投票有フラグ,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況);

    /**
     * この共有子DivのDataGridを返す。
     *
     * @return DataGrid　この共有子DivのDataGrid
     */
    DataGrid<dgTohyorokuKyohiNyuryoku_Row> getDgTohyorokuKyohiNyuryoku();
}
