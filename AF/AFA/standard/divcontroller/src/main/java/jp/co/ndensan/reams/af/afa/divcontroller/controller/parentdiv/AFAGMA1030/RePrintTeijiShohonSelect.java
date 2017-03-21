/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMA1030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.dgRePrintTeijiShohonSelect_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【View】RePrintTeijiDiv内の<br />
 * RePrintTeijiShohonSelectDivに対応するコントローラです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public final class RePrintTeijiShohonSelect {

    private RePrintTeijiShohonSelect() {
    }

    static List<dgRePrintTeijiShohonSelect_Row> setData(List<ShohonSenkyoSearchResult> list) {
        return createDataSource(list);
    }

    private static List<dgRePrintTeijiShohonSelect_Row> createDataSource(List<ShohonSenkyoSearchResult> list) {

        List<dgRePrintTeijiShohonSelect_Row> rowList = new ArrayList<>();
        for (ShohonSenkyoSearchResult result : list) {
            rowList.add(creatTeijiShohonSelectRow(result));
        }
        return rowList;
    }

    private static dgRePrintTeijiShohonSelect_Row creatTeijiShohonSelectRow(ShohonSenkyoSearchResult result) {

        dgRePrintTeijiShohonSelect_Row row = new dgRePrintTeijiShohonSelect_Row();
        row.getTxtKijunYMD().setValue(result.get名簿基準年月日());
        row.getTxtMeiboTorokuYMD().setValue(result.get名簿登録年月日());
        row.getTxtNenreiTotatsuYMD().setValue(result.get規定年齢到達年月日());
        row.setTxtShohonName(result.get抄本名称());
        row.setTxtShohonNo(new RString(result.get抄本番号().toString()));
        row.getTxtShoriYMD().setValue(result.get処理年月日());
        row.getTxtTennyuKigenYMD().setValue(result.get転入期限年月日());
        row.getTxtTenshutsuKigenYMD().setValue(result.get転出期限年月日());

        return row;
    }

}
