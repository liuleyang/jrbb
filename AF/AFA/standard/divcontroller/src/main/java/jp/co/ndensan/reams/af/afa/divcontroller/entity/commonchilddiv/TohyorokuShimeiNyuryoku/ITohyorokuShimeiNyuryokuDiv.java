package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku;

import java.util.HashMap;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITohyorokuShimeiNyuryokuDiv extends ICommonChildDivBaseProperties {

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
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     * @param 投票録項目種類 投票録項目種類（決定書・裁決書　or　用紙返還　or　点字による投票）
     * @param 立会人連番 立会人連番（※立会人引継書の場合のみ）
     */
    void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            Code 投票録項目種類,
            RString 立会人連番
    );

    /**
     * この共有子DIVの初期表示を行います。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     * @param 投票録項目種類 投票録項目種類（決定書・裁決書　or　用紙返還　or　点字による投票）
     * @param 立会人連番 立会人連番（※立会人引継書の場合のみ）
     * @param 行数 行数
     */
    void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            Code 投票録項目種類,
            RString 立会人連番,
            int 行数
    );

    /**
     * この共有子DIVのDataGridを返す。
     *
     * @return DataGrid この共有子DIVのDataGrid
     */
    DataGrid<dgTohyorokuShimeiNyuryoku_Row> getDgTohyorokuShimeiNyuryoku();

    /**
     * この共有子DIVの編集モードを設定する。
     *
     * @param editFlg editFlg
     */
    void setEditMode(boolean editFlg);
}
