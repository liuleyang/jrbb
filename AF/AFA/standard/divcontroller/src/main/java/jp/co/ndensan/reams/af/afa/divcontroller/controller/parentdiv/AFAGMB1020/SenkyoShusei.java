/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB1020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.dgSenkyoShusei_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 【View】SenkyoJohoShuseiDiv内の <br />
 * SenkyoShuseiDivに対するコントローラです。
 *
 */
public final class SenkyoShusei {

    private SenkyoShusei() {
    }

    /**
     * 選挙リストを渡された時のイベントメソッドです。
     *
     * @param senkyoList List<Senkyo>
     * @return 選挙一覧リスト
     */
    public static List<dgSenkyoShusei_Row> setData(List<Senkyo> senkyoList) {
        return createSenkyoDataSource(senkyoList);
    }

    private static List<dgSenkyoShusei_Row> createSenkyoDataSource(List<Senkyo> senkyoList) {
        List<dgSenkyoShusei_Row> rowList = new ArrayList<>();
        for (Senkyo 選挙 : senkyoList) {
            rowList.add(creatSenkyoShuseiRow(選挙));
        }
        return rowList;
    }

    private static dgSenkyoShusei_Row creatSenkyoShuseiRow(Senkyo 選挙) {
        dgSenkyoShusei_Row row = new dgSenkyoShusei_Row();
        row.setTxtNo(new RString(選挙.get選挙番号().toString()));
        row.setTxtLevel(CodeMaster.getCodeRyakusho(
                SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), 選挙.get選挙レベル()));
        if (!RString.isNullOrEmpty(選挙.get選挙名称())) {
            row.getTxtSenkyoName().setValue(選挙.get選挙名称());
        }
        if (!RString.isNullOrEmpty(選挙.get選挙略称())) {
            row.getTxtSenkyoRyakusho().setValue(選挙.get選挙略称());
        }
        if (!RString.isNullOrEmpty(選挙.get選挙マーク())) {
            row.getTxtSenkyoMark().setValue(選挙.get選挙マーク());
        }
        row.setChkMutohyoSenkyoFlag(選挙.is無投票選挙フラグ());
        row.getTxtKokujiYMD().setValue(選挙.get告示_公示年月日());
        row.getTxtTohyoUketsukeYMD().setValue(選挙.get投票受付開始年月日());
        if (AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(ResponseHolder.getMenuID())) {
            row.getTxtTohyoUketsukeYMD().setReadOnly(Boolean.FALSE);
        } else {
            row.getTxtTohyoUketsukeYMD().setReadOnly(Boolean.TRUE);
        }
        row.getTxtKijunYMD().setValue(選挙.get名簿基準年月日());
        row.getTxtMeiboTorokuYMD().setValue(選挙.get名簿登録年月日());
        row.getTxtTenshutsuKigenYMD().setValue(選挙.get転出期限年月日());
        row.getTxtTennyuKigenYMD().setValue(選挙.get転入期限年月日());
        return row;
    }

}
