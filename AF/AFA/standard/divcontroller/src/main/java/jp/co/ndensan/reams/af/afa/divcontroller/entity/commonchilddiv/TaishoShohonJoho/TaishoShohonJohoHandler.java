/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * TaishoShohonJohoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTaishoShohonJohoDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 */
public class TaishoShohonJohoHandler {

    private final TaishoShohonJohoDiv div;
    private static final RString AFAGMB1020_選挙情報修正 = new RString("AFAGMB1020");
    private static final RString AFAGMA1020_投票区変更 = new RString("AFAGMA1020");
    private static final RString KEY_識別コード = new RString("ShikibetsuCode");

    /**
     * コンストラクタです
     *
     * @param div 対象抄本情報Div
     */
    public TaishoShohonJohoHandler(TaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    public void initialize(SenkyoShurui senkyoShurui) {

        div.getCcdShohonNameList().initialize(senkyoShurui);
        RString 画面ID = ViewStateHolder.get(ViewStateKeys.画面ID, RString.class);
        if (画面ID.equals(AFAGMB1020_選挙情報修正)) {
            div.getTxtShohonName().setDisabled(Boolean.FALSE);
            div.getTxtShohonName().setRequired(Boolean.TRUE);
            div.getCcdShohonNameList().setDisabled(Boolean.FALSE);
            set修正対象抄本選択の状態(Boolean.TRUE);
            RString shohonNo = div.getCcdShohonNameList().getSelectedShohonNo();
            div.getTxtShohonName().setValue(div.getCcdShohonNameList().getSelectedShohonName());
            if (!RString.isNullOrEmpty(shohonNo)) {
                div.setTxtHdnShohonNo(shohonNo);
                div.setTxtHdnSenkyoShurui(div.getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
                set修正対象抄本選択の内容(shohonNo);
            }
        } else if (画面ID.equals(AFAGMA1020_投票区変更)) {
            div.getCcdShohonNameList().setDisabled(Boolean.FALSE);
            div.getTxtShohonName().setDisplayNone(Boolean.TRUE);
            set修正対象抄本選択の状態(Boolean.TRUE);
            FlowParameters flowParameters = FlowParameterAccessor.get();
            if (null != flowParameters && !RString.isNullOrEmpty(flowParameters.get(KEY_識別コード, RString.class))) {
                div.getCcdShohonNameList().setDisabled(Boolean.FALSE);
                set修正対象抄本選択の内容(senkyoShurui);
            }
        }

        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     */
    public void initialSetting() {

        div.getCcdShohonNameList().changeDdlShohon();
        RString selectedKey = div.getCcdShohonNameList().getSelectedShohonNo();

        if (selectedKey.equals(RString.EMPTY)) {
            clearThisPanel();
        } else {
            set修正対象抄本選択の内容(selectedKey);
        }
    }

    /**
     * 抄本番号取得時の処理をするメソッドです。
     *
     * @param shohonNo RString
     */
    public void initialize(RString shohonNo) {
        div.getCcdShohonNameList().initialize();
        RString 画面ID = ViewStateHolder.get(ViewStateKeys.画面ID, RString.class);
        if (画面ID.equals(AFAGMA1020_投票区変更)) {
            FlowParameters flowParameters = FlowParameterAccessor.get();
            if (null == flowParameters || null == flowParameters.get(KEY_識別コード, RString.class)) {
                div.getCcdShohonNameList().setDisplayNone(Boolean.FALSE);
                div.getCcdShohonNameList().setDisabled(Boolean.TRUE);
                div.getCcdShohonNameList().selectedShohon(shohonNo);
                div.getTxtShohonName().setDisplayNone(Boolean.TRUE);
                set修正対象抄本選択の内容(shohonNo);
            }
        } else {
            set選択抄本情報(shohonNo);
        }
    }

    /**
     * 各項目をクリアします。
     */
    public void clearThisPanel() {
        div.getCcdShohonNameList().selectedShohon(RString.EMPTY);
        div.getTxtShohonName().clearValue();
        div.getTxtKijunYMD().clearValue();
        div.getTxtTohyoYMD().clearValue();

        div.getTxtMeiboTorokuYMD().clearValue();
        div.getTxtTennyuKigenYMD().clearValue();
        div.getTxtTenshutsuKigenYMD().clearValue();
        div.getTxtNenreiTotatsuYMD().clearValue();

        div.setTxtHdnSenkyoShurui(RString.EMPTY);
        div.setTxtHdnShohonNo(RString.EMPTY);
    }

    private void set選択抄本情報(RString shohonNo) {
        div.setTxtHdnSenkyoShurui(RString.EMPTY);
        div.setTxtHdnShohonNo(RString.EMPTY);
        ShohonManager manager = ShohonManager.createInstance();
        Shohon shohon = manager.get抄本(new ShohonNo(shohonNo));
        if (shohon != null) {
            div.getCcdShohonNameList().initialize(SenkyoShurui.toValue(shohon.get選挙種類().value()));
            div.getCcdShohonNameList().selectedShohon(shohonNo);
            set修正対象抄本選択(shohon);
        }
    }

    private void set修正対象抄本選択の状態(Boolean 状態) {
        div.getTxtKijunYMD().setDisabled(状態);
        div.getTxtTohyoYMD().setDisabled(状態);
        div.getTxtMeiboTorokuYMD().setDisabled(状態);
        div.getTxtTennyuKigenYMD().setDisabled(状態);
        div.getTxtTenshutsuKigenYMD().setDisabled(状態);
        div.getTxtNenreiTotatsuYMD().setDisabled(状態);
    }

    private void set修正対象抄本選択の内容(RString shohonNo) {
        div.setTxtHdnShohonNo(RString.EMPTY);
        div.setTxtHdnSenkyoShurui(RString.EMPTY);
        ShohonManager manager = ShohonManager.createInstance();
        Shohon shohon = manager.get抄本(new ShohonNo(shohonNo));
        if (shohon != null) {
            set修正対象抄本選択(shohon);
        }
    }

    private void set修正対象抄本選択(Shohon shohon) {
        List<Senkyo> senkyoList = shohon.getSenkyoList();
        if (!senkyoList.isEmpty()) {
            set表示用選挙情報(senkyoList);
            if (null != shohon.get規定年齢到達年月日() && !shohon.get規定年齢到達年月日().isEmpty()) {
                div.getTxtNenreiTotatsuYMD().setValue(new RDate(shohon.get規定年齢到達年月日().toString()));
            }
        }
        if (null != shohon.get抄本番号() && !shohon.get抄本番号().toString().isEmpty()) {
            div.getTxtTohyoYMD().setValue(new RDate(shohon.get投票年月日().toString()));
            div.setTxtHdnShohonNo(new RString(shohon.get抄本番号().toString()));
            div.setTxtHdnSenkyoShurui(shohon.get選挙種類().value());
            div.getTxtShohonName().clearValue();
            div.getTxtShohonName().setValue(shohon.get抄本名());
        }
    }

    private void set修正対象抄本選択の内容(SenkyoShurui senkyoShurui) {
        if (SenkyoShurui.定時登録.equals(senkyoShurui)) {
            RString ShohonNo = div.getCcdShohonNameList().get一番近い過去抄本番号();
            if (!RString.isNullOrEmpty(ShohonNo)) {
                div.getCcdShohonNameList().selectedShohon(ShohonNo);
            }
//            SenkyoShuseiFinder finder = SenkyoShuseiFinder.createInstance();
//            List<ShohonSenkyoSearchResult> searchResult
//                    = finder.get抄本選挙一覧By選挙種類と基準日(senkyoShurui, FlexibleDate.getNowDate()).records();
//            if (!searchResult.isEmpty()) {
//                div.getCcdShohonNameList().selectedShohon(new RString(searchResult.get(0).get抄本番号().toString()));
//                div.setTxtHdnShohonNo(new RString(searchResult.get(0).get抄本番号().toString()));
//                div.setTxtHdnSenkyoShurui(searchResult.get(0).get選挙種類().value());
//            }
        } else if (SenkyoShurui.国政選挙_地方選挙.equals(senkyoShurui)
                || SenkyoShurui.憲法改正国民投票.equals(senkyoShurui)) {

            // TODO
            RString ShohonNo = div.getCcdShohonNameList().get一番近い未来抄本番号();
            if (!RString.isNullOrEmpty(ShohonNo)) {
                div.getCcdShohonNameList().selectedShohon(ShohonNo);
            }

        }
    }

    private void set表示用選挙情報(List<Senkyo> senkyoList) {
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        FlexibleDate 名簿登録日 = FlexibleDate.EMPTY;
        FlexibleDate 転出期限日 = FlexibleDate.EMPTY;
        FlexibleDate 転入期限日 = FlexibleDate.EMPTY;
        for (Senkyo senkyo : senkyoList) {
            if (FlexibleDate.EMPTY.equals(基準日)) {
                基準日 = senkyo.get名簿基準年月日();
            } else {
                if (基準日 != null && 基準日.compareTo(senkyo.get名簿基準年月日()) > 0) {
                    基準日 = senkyo.get名簿基準年月日();
                }
            }
            if (FlexibleDate.EMPTY.equals(名簿登録日)) {
                名簿登録日 = senkyo.get名簿登録年月日();
            } else {
                if (名簿登録日 != null && 名簿登録日.compareTo(senkyo.get名簿登録年月日()) > 0) {
                    名簿登録日 = senkyo.get名簿登録年月日();
                }
            }
            if (FlexibleDate.EMPTY.equals(転出期限日)) {
                転出期限日 = senkyo.get転出期限年月日();
            } else {
                if (転出期限日 != null && 転出期限日.compareTo(senkyo.get転出期限年月日()) < 0) {
                    転出期限日 = senkyo.get転出期限年月日();
                }
            }
            if (FlexibleDate.EMPTY.equals(転入期限日)) {
                転入期限日 = senkyo.get転入期限年月日();
            } else {
                if (転入期限日 != null && 転入期限日.compareTo(senkyo.get転入期限年月日()) > 0) {
                    転入期限日 = senkyo.get転入期限年月日();
                }
            }
        }

        if (null != 基準日 && !基準日.isEmpty()) {
            div.getTxtKijunYMD().setValue(new RDate(基準日.toString()));
        }
        if (null != 名簿登録日 && !名簿登録日.isEmpty()) {
            div.getTxtMeiboTorokuYMD().setValue(new RDate(名簿登録日.toString()));
        }
        if (null != 転入期限日 && !転入期限日.isEmpty()) {
            div.getTxtTennyuKigenYMD().setValue(new RDate(転入期限日.toString()));
        }
        if (null != 転出期限日 && !転出期限日.isEmpty()) {
            div.getTxtTenshutsuKigenYMD().setValue(new RDate(転出期限日.toString()));
        }
    }
}
