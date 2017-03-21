package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITohyorokuDairiTohyoshaDiv extends ICommonChildDivBaseProperties {

    /**
     * 投票録代理投票者共有子DIVの初期表示を行います。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     */
    void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況);

    /**
     * 投票録代理投票者DataGridを返す。
     *
     * @return DataGrid　投票録代理投票者DataGrid
     */
    DataGrid<dgTohyorokuDairiTohyosha_Row> getDgTohyorokuDairiTohyosha();

}
