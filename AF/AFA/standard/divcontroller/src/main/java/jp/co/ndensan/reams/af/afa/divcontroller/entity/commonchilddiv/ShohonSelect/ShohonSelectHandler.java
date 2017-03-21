/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.SenkyoResult;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohonselect.ShohonSelectFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * ShohonSelectDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してShohonSelectDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0160-011 guyq
 */
public class ShohonSelectHandler {

    private final ShohonSelectDiv div;
    private static SenkyoShurui senkyoShurui;
    private static final RString 入場券 = new RString("未作成です。");

    /**
     * コンストラクタです。
     *
     * @param div 入場券作成可能抄本作成Div
     */
    public ShohonSelectHandler(ShohonSelectDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void initialize() {
        clearThisPanel();
        RString メニューID = ResponseHolder.getMenuID();
        ViewState.setメニューID(ResponseHolder.getMenuID());
        SenkyoShurui 選挙種類 = getSenkyoShurui(メニューID);
        div.getCcdShohonNameList().initialize(選挙種類);

        RString 未来抄本番号 = div.getCcdShohonNameList().get一番近い未来抄本番号();
        if (!未来抄本番号.isEmpty()) {
            div.getCcdShohonNameList().selectedShohon(未来抄本番号);
        }
        RString 抄本名 = div.getCcdShohonNameList().getSelectedShohonName();

        div.getTxtTohyoYMD().setValue(div.getCcdShohonNameList().getSelectedTohyoYMD());

        ShohonSelectFinder finder = ShohonSelectFinder.createInstance();
        List<SenkyoResult> senkyoResultList = new ArrayList<>();
        ShohonResult result = new ShohonResult();
        if (!未来抄本番号.isEmpty()) {
            senkyoResultList = finder.getBy抄本番号(new ShohonNo(未来抄本番号));
            result = finder.getByShohonNo(new ShohonNo(未来抄本番号));
        }

        set入場券出力状態(result);

        if (!senkyoResultList.isEmpty()) {
            div.getDgShohonSelect().setDataSource(setData(senkyoResultList));
        }

        div.setHidShohonName(抄本名 == null ? RString.EMPTY : 抄本名);
        div.setHidSenkyoShurui(選挙種類.toRString());
        div.setHidShohonNo(未来抄本番号);

    }

    private static List<dgShohonSelect_Row> setData(List<SenkyoResult> senkyoResultList) {
        return createSenkyoDataSource(senkyoResultList);
    }

    private static List<dgShohonSelect_Row> createSenkyoDataSource(List<SenkyoResult> senkyoResultList) {
        List<dgShohonSelect_Row> rowList = new ArrayList<>();
        for (SenkyoResult 選挙 : senkyoResultList) {
            rowList.add(creatSenkyoShuseiRow(選挙));
        }
        return rowList;
    }

    private static dgShohonSelect_Row creatSenkyoShuseiRow(SenkyoResult 選挙) {
        dgShohonSelect_Row row = new dgShohonSelect_Row();
        row.setTxtNo(new RString(選挙.get選挙番号().toString()));
        RString 選挙略称 = CodeMaster.getCodeRyakusho(AFACodeShubetsu.選挙レベル.getCodeShubetsu(),
                選挙.get選挙レベル(), FlexibleDate.getNowDate());
        if (null != 選挙略称 && !選挙略称.isEmpty()) {
            row.setTxtLevel(選挙略称);
        }
        row.setTxtSenkyoName(選挙.get選挙名称());
        if (選挙.is無投票選挙フラグ()) {
            row.setChkMutohyoSenkyoFlag(Boolean.TRUE);
        } else {
            row.setChkMutohyoSenkyoFlag(Boolean.FALSE);
        }

        if (!選挙.get名簿基準年月日().isEmpty() && 選挙.get名簿基準年月日().isValid()) {
            row.getTxtKijunYMD().setValue(new RDate(選挙.get名簿基準年月日().toString()));
        }

        if (!選挙.get投票受付開始年月日().isEmpty() && 選挙.get投票受付開始年月日().isValid()) {
            row.getTxtTohyoUketsukeYMD().setValue(new RDate(選挙.get投票受付開始年月日().toString()));
        }

        if (!選挙.get告示公示年月日().isEmpty() && 選挙.get告示公示年月日().isValid()) {
            row.getTxtKokujiYMD().setValue(new RDate(選挙.get告示公示年月日().toString()));
        }

        if (!選挙.get名簿登録年月日().isEmpty() && 選挙.get名簿登録年月日().isValid()) {
            row.getTxtMeiboTorokuYMD().setValue(new RDate(選挙.get名簿登録年月日().toString()));
        }

        if (!選挙.get名簿登録年月日().isEmpty() && 選挙.get名簿登録年月日().isValid()) {
            row.getTxtMeiboTorokuYMD().setValue(new RDate(選挙.get名簿登録年月日().toString()));
        }

        if (!選挙.get転出期限年月日().isEmpty() && 選挙.get転出期限年月日().isValid()) {
            row.getTxtTenshutsuKigenYMD().setValue(new RDate(選挙.get転出期限年月日().toString()));
        }

        if (!選挙.get転入期限年月日().isEmpty() && 選挙.get転入期限年月日().isValid()) {
            row.getTxtTennyuKigenYMD().setValue(new RDate(選挙.get転入期限年月日().toString()));
        }

        return row;
    }

    private void set入場券出力状態(ShohonResult result) {
        if (result != null && result.get入場券発行固有連番() != null
                && (result.get入場券発行固有連番().compareTo(Decimal.ZERO) == 0)) {
            div.getTxtPrintJotai().setValue(入場券);
        }
    }

    /**
     * 入場券作成画面で、抄本が選択されたときのメソッドです。
     *
     */
    public void initialSetting() {
        clearThisPanel();
        RString メニューID = ResponseHolder.getMenuID();
        ShohonSelectFinder finder = ShohonSelectFinder.createInstance();

        div.getCcdShohonNameList().changeDdlShohon();
        RString selectedKey = div.getCcdShohonNameList().getSelectedShohonNo();

        if (selectedKey.equals(RString.EMPTY)) {
            clearThisPanel();
        } else {
            div.getDgShohonSelect().setDataSource(set選択抄本情報(selectedKey));
            ShohonResult result = finder.getByShohonNo(new ShohonNo(selectedKey));
            set入場券出力状態(result);
            div.setHidSenkyoShurui(getSenkyoShurui(メニューID).toRString());
            div.setHidShohonNo(selectedKey);
            RString 抄本名 = div.getCcdShohonNameList().getSelectedShohonName();
            RDate 投票日 = div.getCcdShohonNameList().getSelectedTohyoYMD();
            div.getTxtTohyoYMD().setValue(投票日);
            div.setHidShohonName(抄本名 == null ? RString.EMPTY : 抄本名);
        }

    }

    private static List<dgShohonSelect_Row> set選択抄本情報(RString shohonNo) {
        ShohonSelectFinder finder = ShohonSelectFinder.createInstance();
        List<SenkyoResult> senkyoResultList = finder.getBy抄本番号(new ShohonNo(shohonNo));
        return setData(senkyoResultList);
    }

    private static SenkyoShurui getSenkyoShurui(RString メニューID) {
        senkyoShurui = SenkyoShurui.国政選挙_地方選挙;
        if (!メニューID.isEmpty()) {
            switch (メニューID.substring(5, 6).toString()) {
                case "B":
                    senkyoShurui = SenkyoShurui.国政選挙_地方選挙;
                    break;
                case "G":
                    senkyoShurui = SenkyoShurui.憲法改正国民投票;
                    break;
                case "I":
                    senkyoShurui = SenkyoShurui.住民投票;
                    break;
                case "K":
                    senkyoShurui = SenkyoShurui.海区漁業調整委員会委員選挙;
                    break;
                case "L":
                    senkyoShurui = SenkyoShurui.財産区議会議員選挙;
                    break;
                default:
                    senkyoShurui = SenkyoShurui.国政選挙_地方選挙;
                    break;
            }
        }
        return senkyoShurui;
    }

    /**
     * 各項目をクリアします。
     *
     */
    public void clear() {
        clearThisPanel();
    }

    /**
     * 各項目をクリアします。
     *
     */
    public void clearThisPanel() {
        div.getTxtTohyoYMD().clearValue();
        div.getTxtPrintJotai().clearValue();
        div.getDgShohonSelect().getDataSource().clear();
        div.setHidSenkyoShurui(RString.EMPTY);
        div.setHidShohonNo(RString.EMPTY);
    }

}
