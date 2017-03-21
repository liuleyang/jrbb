/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMG1020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.dgKokuminShusei_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【View】KokuminTohyoJohoShuseiDiv内の <br />
 * KokuminShuseiDivに対するコントローラです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public final class KokuminShusei {

    private KokuminShusei() {
    }

    /**
     * 抄本番号を渡された時のイベントメソッドです。
     *
     * @param senkyoList List<Senkyo>
     *
     * @return List<dgKokuminShusei_Row>
     */
    public static List<dgKokuminShusei_Row> setData(List<Senkyo> senkyoList) {
        return createSenkyoDataSource(senkyoList);
    }

    private static List<dgKokuminShusei_Row> createSenkyoDataSource(List<Senkyo> senkyoList) {
        List<dgKokuminShusei_Row> rowList = new ArrayList<>();
        for (Senkyo 選挙 : senkyoList) {
            rowList.add(creatSenkyoShuseiRow(選挙));
        }
        return rowList;
    }

    private static dgKokuminShusei_Row creatSenkyoShuseiRow(Senkyo 選挙) {
        dgKokuminShusei_Row row = new dgKokuminShusei_Row();
        row.setTxtNo(new RString(選挙.get選挙番号().toString()));
        if (!選挙.get選挙名称().isNullOrEmpty()) {
            row.getTxtKaiseianName().setValue(選挙.get選挙名称());
        }
        if (!選挙.get選挙略称().isNullOrEmpty()) {
            row.getTxtRyakusho().setValue(選挙.get選挙略称());
        }
        row.setChkMutohyoSenkyoFlag(選挙.is無投票選挙フラグ());
        return row;
    }

}
