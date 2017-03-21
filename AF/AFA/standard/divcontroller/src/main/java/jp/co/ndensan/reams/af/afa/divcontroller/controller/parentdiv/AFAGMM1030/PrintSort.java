/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM1030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.printsort.ReportControlResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1030.PrintSortDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1030.dgPrintSortTaishoChohyo_Row;
import jp.co.ndensan.reams.af.afa.service.core.printsort.PrintSortManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 帳票出力条件保守のクラス
 *
 * @reamsid_L AF-0680-010 wanghj
 */
public class PrintSort {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div PrintSortDiv
     * @return ResponseData<PrintSortDiv>
     */
    public ResponseData<PrintSortDiv> onLoad(PrintSortDiv div) {
        div.getDgPrintSortTaishoChohyo().getDataSource().clear();
        List<ReportControlResult> 帳票データ = PrintSortManager.createInstance().get帳票データ();
        List<dgPrintSortTaishoChohyo_Row> rowList = new ArrayList<>();

        if (null != 帳票データ && !帳票データ.isEmpty()) {
            for (ReportControlResult result : 帳票データ) {
                dgPrintSortTaishoChohyo_Row row = new dgPrintSortTaishoChohyo_Row();
                row.setTxtChohyoID(result.get帳票ID());
                row.setTxtChohyoName(result.get帳票名());
                rowList.add(row);
            }
        }
        div.getDgPrintSortTaishoChohyo().setDataSource(rowList);
        if (null != div.getDgPrintSortTaishoChohyo().getDataSource()
                && !div.getDgPrintSortTaishoChohyo().getDataSource().isEmpty()) {
            List<dgPrintSortTaishoChohyo_Row> selectedrows = new ArrayList<>();
            dgPrintSortTaishoChohyo_Row selectedrow = div.getDgPrintSortTaishoChohyo().getDataSource().get(0);
            selectedrows.add(selectedrow);
            div.getDgPrintSortTaishoChohyo().setSelectedItems(selectedrows);
            div.getCcdPrintSort().load(SubGyomuCode.AFA選挙本体, new ReportId(div.getDgPrintSortTaishoChohyo().getSelectedItems().get(0).getTxtChohyoID()));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンのイベントメソッドです。
     *
     * @param div PrintSortDiv
     * @return ResponseData<PrintSortDiv>
     */
    public ResponseData<PrintSortDiv> onSelectBySelectButton(PrintSortDiv div) {
        dgPrintSortTaishoChohyo_Row row = div.getDgPrintSortTaishoChohyo().getClickedItem();
        div.getCcdPrintSort().load(SubGyomuCode.AFA選挙本体, new ReportId(row.getTxtChohyoID()));
        return ResponseData.of(div).respond();
    }
}
