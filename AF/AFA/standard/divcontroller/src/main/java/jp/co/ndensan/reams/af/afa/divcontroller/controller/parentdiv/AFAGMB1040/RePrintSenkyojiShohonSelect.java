/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB1040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiShohonSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.dgRePrintSenkyojiSenkyoList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.dgRePrintSenkyojiShohonSelect_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【View】RePrintSenkyojiDiv内の<br />
 * RePrintSenkyojiShohonSelectDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0060-010 liss
 */
public final class RePrintSenkyojiShohonSelect {

    private RePrintSenkyojiShohonSelect() {
    }

    static List<dgRePrintSenkyojiShohonSelect_Row> setData(List<Shohon> list) {
        return createDataSource(list);
    }

    /**
     * 抄本番号を渡されて、選挙一覧グリッドをセットするメソッドです。
     *
     * @param div RePrintSenkyojiShohonSelectDiv
     * @param senkyoList List<Senkyo>
     */
    public static void setData(RePrintSenkyojiShohonSelectDiv div, List<Senkyo> senkyoList) {
        div.getDgRePrintSenkyojiSenkyoList().setDataSource(createDataSourceSenkyo(senkyoList));
        // 転入期限日、転出期限日、期限日の取得
        //（SenkyojiToroku.javaにも同じものがあるが、グリッドが違うため何かを同一にするのは無理か？）
        setKigenYmd(div);
    }

    private static List<dgRePrintSenkyojiShohonSelect_Row> createDataSource(List<Shohon> list) {
        List<dgRePrintSenkyojiShohonSelect_Row> dataSource = new ArrayList<>();
        for (Shohon item : list) {
            dgRePrintSenkyojiShohonSelect_Row row = new dgRePrintSenkyojiShohonSelect_Row();
            row.setTxtShohonName(item.get抄本名());
            row.getTxtTohyoYMD().setValue(item.get投票年月日());
            row.getTxtNenreiTotatsuYMD().setValue(item.get規定年齢到達年月日());
            row.getTxtShoriYMD().setValue(item.get処理年月日());
            row.setTxtShohonNo(new RString(item.get抄本番号().toString()));
            dataSource.add(row);
        }
        return dataSource;
    }

    private static List<dgRePrintSenkyojiSenkyoList_Row> createDataSourceSenkyo(List<Senkyo> senkyoList) {
        List<dgRePrintSenkyojiSenkyoList_Row> dataSource = new ArrayList<>();
        if (senkyoList != null && !senkyoList.isEmpty() && senkyoList.get(0) != null) {
            for (Senkyo item : senkyoList) {
                dgRePrintSenkyojiSenkyoList_Row row = new dgRePrintSenkyojiSenkyoList_Row();
                row.setTxtSenkyoNo(new RString(item.get選挙番号().toString()));
                row.setTxtSenkyoName(item.get選挙名称());
                row.getTxtKijunYMD().setValue(new RDate(item.get名簿基準年月日().getYearValue(),
                        item.get名簿基準年月日().getMonthValue(), item.get名簿基準年月日().getDayValue()));
                row.getTxtKokujiYMD().setValue(new RDate(item.get告示_公示年月日().getYearValue(),
                        item.get告示_公示年月日().getMonthValue(), item.get告示_公示年月日().getDayValue()));
                row.getTxtTohyoUketsukeYMD().setValue(new RDate(item.get投票受付開始年月日().getYearValue(),
                        item.get投票受付開始年月日().getMonthValue(), item.get投票受付開始年月日().getDayValue()));
                row.getTxtMeiboTorokuYMD().setValue(new RDate(item.get名簿登録年月日().getYearValue(),
                        item.get名簿登録年月日().getMonthValue(), item.get名簿登録年月日().getDayValue()));
                row.getTxtTenshutsuKigenYMD().setValue(new RDate(item.get転出期限年月日().getYearValue(),
                        item.get転出期限年月日().getMonthValue(), item.get転出期限年月日().getDayValue()));
                row.getTxtTennyuKigenYMD().setValue(new RDate(item.get転入期限年月日().getYearValue(),
                        item.get転入期限年月日().getMonthValue(), item.get転入期限年月日().getDayValue()));
                row.setChkMutohyoSenkyoFlag(item.is無投票選挙フラグ());
                dataSource.add(row);
            }
        }

        return dataSource;
    }

    private static void setKigenYmd(RePrintSenkyojiShohonSelectDiv div) {
        List<dgRePrintSenkyojiSenkyoList_Row> dataSource = div.getDgRePrintSenkyojiSenkyoList().getDataSource();

//        dataSource.isEmpty() の時はエラーという処理を入れたい
        RDate wkMaxKijunYmd = RDate.MIN;
        RDate wkMaxTenshutsuYmd = RDate.MIN;
        RDate wkMinTennyuYmd = RDate.MAX;

        for (dgRePrintSenkyojiSenkyoList_Row row : dataSource) {
            wkMaxKijunYmd = get基準日の最大値(row, wkMaxKijunYmd);
            wkMaxTenshutsuYmd = get転出日の最大値(row, wkMaxTenshutsuYmd);
            wkMinTennyuYmd = get転入日の最小値(row, wkMinTennyuYmd);
        }

        set基準日(div, wkMaxKijunYmd);
        set転出期限日(div, wkMaxTenshutsuYmd);
        set転入期限日(div, wkMinTennyuYmd);

    }

    private static RDate get転入日の最小値(dgRePrintSenkyojiSenkyoList_Row row, RDate wkMinTennyuYmd) {
        if (!row.getTxtTennyuKigenYMD().toString().isEmpty()
                && !wkMinTennyuYmd.isBefore(row.getTxtTennyuKigenYMD().getValue())) {
            wkMinTennyuYmd = row.getTxtTennyuKigenYMD().getValue();
        }
        return wkMinTennyuYmd;
    }

    private static RDate get転出日の最大値(dgRePrintSenkyojiSenkyoList_Row row, RDate wkMaxTenshutsuYmd) {
        if (!row.getTxtTenshutsuKigenYMD().toString().isEmpty()
                && wkMaxTenshutsuYmd.isBefore(row.getTxtTenshutsuKigenYMD().getValue())) {
            wkMaxTenshutsuYmd = row.getTxtTenshutsuKigenYMD().getValue();
        }
        return wkMaxTenshutsuYmd;
    }

    private static RDate get基準日の最大値(dgRePrintSenkyojiSenkyoList_Row row, RDate wkMaxKijunYmd) {
        if (!row.getTxtKijunYMD().toString().isEmpty()
                && wkMaxKijunYmd.isBefore(row.getTxtKijunYMD().getValue())) {
            wkMaxKijunYmd = row.getTxtKijunYMD().getValue();
        }
        return wkMaxKijunYmd;
    }

    private static void set転入期限日(RePrintSenkyojiShohonSelectDiv div, RDate wkMaxTennyuYmd) {
        if (!wkMaxTennyuYmd.equals(RDate.MIN)) {
            div.setTxtHdnTennyuKigenYMD(wkMaxTennyuYmd.toDateString());
        }
    }

    private static void set転出期限日(RePrintSenkyojiShohonSelectDiv div, RDate wkMinTenshutsuYmd) {
        if (!wkMinTenshutsuYmd.equals(RDate.MAX)) {
            div.setTxtHdnTenshutsuKigenYMD(wkMinTenshutsuYmd.toDateString());
        }
    }

    private static void set基準日(RePrintSenkyojiShohonSelectDiv div, RDate wkMaxKijunYmd) {
        if (!wkMaxKijunYmd.equals(RDate.MIN)) {
            div.setTxtHdnKijunYMD(wkMaxKijunYmd.toDateString());
        }
    }

}
