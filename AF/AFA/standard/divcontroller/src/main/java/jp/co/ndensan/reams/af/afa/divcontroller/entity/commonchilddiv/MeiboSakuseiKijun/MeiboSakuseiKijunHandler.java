/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuDateKeisan;
import jp.co.ndensan.reams.af.afa.service.senkyojitouroku.SenkyojiTourokuFinder;
import jp.co.ndensan.reams.af.afa.service.teijitouroku.TeijiTourokuFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * MeiboSakuseiKijunDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してMeiboSakuseiKijunDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 */
public class MeiboSakuseiKijunHandler {

    private final MeiboSakuseiKijunDiv div;
    private final RString 新規処理 = new RString("新規処理");

    /**
     * コンストラクタです。
     *
     * @param div 名簿作成基準Div
     */
    public MeiboSakuseiKijunHandler(MeiboSakuseiKijunDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    public void initialize(SenkyoShurui senkyoShurui) {

        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
        if (senkyoShurui.equals(SenkyoShurui.定時登録)) {
            状態定義(Boolean.TRUE);
        } else if (senkyoShurui.equals(SenkyoShurui.国政選挙_地方選挙)) {
            国政状態定義(Boolean.TRUE);
//            div.getBtnSetChohyoYmd().setDisabled(Boolean.TRUE);
            div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().init();
        } else {
            状態定義(Boolean.FALSE);
            div.getLblTenshutsuYMD().setDisplayNone(true);
            div.getLblTennyuYMD().setDisplayNone(true);
            div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().init();
        }
        this.clickRadShori();
    }

    private void set定時登録_新規処理設値() {
        ShohonManager manager = ShohonManager.createInstance();
        FlexibleDate 最後定時登録 = manager.get最後定時登録();
        RString 実行予定年月RStr = RString.EMPTY;
        FlexibleYearMonth 実行予定年月 = FlexibleYearMonth.EMPTY;
        if (null != 最後定時登録) {
            実行予定年月 = 最後定時登録.getYearMonth().plusMonth(3);
            実行予定年月RStr = 実行予定年月.wareki().toDateString();
        }
        div.getTxtShohonName().setValue(実行予定年月RStr.concat(RString.FULL_SPACE).concat(SenkyoShurui.定時登録.toRString()));
        if (!実行予定年月.isEmpty()) {
            div.getTxtKijunYMD().setValue(new RDate(実行予定年月.getYearValue(), 実行予定年月.getMonthValue(), 1));
            this.onClick_btnSetYmdBy定時登録();
        }
    }

    /**
     * 画面項目状態の定義です。
     *
     * @param is定時登録 Boolean
     */
    private void 状態定義(Boolean is定時登録) {
        div.getTxtTohyoYMD().setDisplayNone(is定時登録);
        div.getTxtKijunYMD().setDisabled(!is定時登録);
        div.getTxtMeiboTorokuYMD().setDisabled(!is定時登録);
        div.getTxtTenshutsuYMD().setDisabled(!is定時登録);
        div.getTxtTennyuYMD().setDisabled(!is定時登録);
        div.getSenkyoNyuryoku().getBtnAddRowSenkyo().setDisplayNone(is定時登録);
        div.getSenkyoNyuryoku().getBtnCopySenkyo().setDisplayNone(is定時登録);
        div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().setDisplayNone(is定時登録);
    }

    /**
     * 画面項目状態の定義です。
     *
     * @param is国政登録 Boolean
     */
    private void 国政状態定義(Boolean is国政登録) {
        div.getTxtTohyoYMD().setDisplayNone(!is国政登録);
        div.getTxtKijunYMD().setDisabled(!is国政登録);
        div.getTxtMeiboTorokuYMD().setDisabled(!is国政登録);
        div.getTxtTenshutsuYMD().setDisabled(!is国政登録);
        div.getTxtTennyuYMD().setDisabled(!is国政登録);
    }

    /**
     * ドロップダウンリストに抄本情報をセットするメソッドです。
     *
     */
    public void initialSetting() {
        div.getCcdShohonNameList().initialize(SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui()));
    }

    /**
     * 新規処理と再処理のラジオボタンクリック時のイベントメソッドです。
     *
     */
    public void clickRadShori() {
        clearThisPanel();
        div.getCcdShohonNameList().clear();
        Boolean is新規処理 = div.getRadShori().getSelectedValue().equals(新規処理);
        div.getCcdShohonNameList().setReadOnlyMode(is新規処理);
        if (SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui()).equals(SenkyoShurui.定時登録)) {
            this.set項目By定時登録(is新規処理);
        } else {
            this.set項目By選挙時登録(is新規処理);
        }
    }

    private void set項目By定時登録(Boolean is新規処理) {
        if (is新規処理) {
            this.set定時登録_新規処理設値();
        } else {
            this.initialSetting();
            this.setSelected抄本項目By定時登録();
        }
    }

    private void set項目By選挙時登録(Boolean is新規処理) {
        if (is新規処理) {
            return;
        }
        initialSetting();
        this.setSelected抄本項目By選挙時登録();
    }

    public void setSelected抄本項目By定時登録() {
        div.getTxtShohonName().setValue(div.getCcdShohonNameList().getSelectedShohonName());
        div.getTxtKijunYMD().setValue(div.getCcdShohonNameList().getSelectedTohyoYMD());
        if (null != div.getTxtKijunYMD().getValue()) {
            this.onClick_btnSetYmdBy定時登録();
        }
    }

    public void setSelected抄本項目By選挙時登録() {
        div.getTxtShohonName().setValue(div.getCcdShohonNameList().getSelectedShohonName());
        if (null != div.getCcdShohonNameList().getSelectedTohyoYMD()) {
            div.getTxtTohyoYMD().setValue(div.getCcdShohonNameList().getSelectedTohyoYMD());
        }
        if (null != div.getCcdShohonNameList().getSelectedKiteiNenreiTotatsuYMD()) {
            div.getTxtNenreiTotatsuYMD().setValue(div.getCcdShohonNameList().getSelectedKiteiNenreiTotatsuYMD());
        }
        List<Senkyo> senkyoList = new ArrayList<>();
        if (!div.getCcdShohonNameList().getSelectedShohonNo().isEmpty()) {
            SenkyoManager manager = SenkyoManager.createInstance();
            senkyoList = manager.get選挙By抄本番号(new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo()));
        }
        this.set選挙一覧(senkyoList);
    }

    public void onClick_btnSetYmdBy定時登録() {
        TeijiTourokuFinder finder = TeijiTourokuFinder.createInstance();
        TeijiTourokuDateKeisan dateKeisan = finder.dateKeisan(new FlexibleDate(div.getTxtKijunYMD().getValue().toDateString()));
        if (null == dateKeisan) {
            return;
        }
        //登録日を算出する。
        if (null != dateKeisan.get登録日()) {
            div.getTxtMeiboTorokuYMD().setValue(new RDate(dateKeisan.get登録日().toString()));
        } else {
            div.getTxtMeiboTorokuYMD().clearValue();
        }
        //転出期限日を算出する。
        if (null != dateKeisan.get転出期限日()) {
            div.getTxtTenshutsuYMD().setValue(new RDate(dateKeisan.get転出期限日().toString()));
        } else {
            div.getTxtTenshutsuYMD().clearValue();
        }
        //転入期限日を算出する。
        if (null != dateKeisan.get転入期限日()) {
            div.getTxtTennyuYMD().setValue(new RDate(dateKeisan.get転入期限日().toString()));
        } else {
            div.getTxtTennyuYMD().clearValue();
        }
        //年齢期限日を算出する。
        if (null != dateKeisan.get年齢期限日()) {
            div.getTxtNenreiTotatsuYMD().setValue(new RDate(dateKeisan.get年齢期限日().toString()));
        } else {
            div.getTxtNenreiTotatsuYMD().clearValue();
        }
    }

    public void onClick_btnSetYmdBy選挙時登録() {
        SenkyojiTourokuFinder finder = SenkyojiTourokuFinder.createInstance();
        TeijiTourokuDateKeisan dateKeisan = finder.calcDateInfo(new FlexibleDate(div.getTxtKijunYMD().getValue().toDateString()));
        if (null == dateKeisan) {
            return;
        }
        //登録日を算出する。
        if (null != dateKeisan.get登録日()) {
            div.getTxtMeiboTorokuYMD().setValue(new RDate(dateKeisan.get登録日().toString()));
        } else {
            div.getTxtMeiboTorokuYMD().clearValue();
        }
        //転出期限日を算出する。
        if (null != dateKeisan.get転出期限日()) {
            div.getTxtTenshutsuYMD().setValue(new RDate(dateKeisan.get転出期限日().toString()));
        } else {
            div.getTxtTenshutsuYMD().clearValue();
        }
        //転入期限日を算出する。
        if (null != dateKeisan.get転入期限日()) {
            div.getTxtTennyuYMD().setValue(new RDate(dateKeisan.get転入期限日().toString()));
        } else {
            div.getTxtTennyuYMD().clearValue();
        }
        //年齢期限日を算出する。
        div.getTxtNenreiTotatsuYMD().setValue(div.getTxtTohyoYMD().getValue().plusDay(1));
    }

    public void onChange_dgSenkyojiSenkyoNyuryoku_txtKijunYMD() {
        dgSenkyojiSenkyoNyuryoku_Row row = div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().getActiveRow();
        SenkyojiTourokuFinder finder = SenkyojiTourokuFinder.createInstance();
        RDate kijunYMD = row.getTxtKijunYMD().getValue();
        if (null != kijunYMD) {
            TeijiTourokuDateKeisan dateKeisan = finder.calcDateInfo(new FlexibleDate(kijunYMD.getYearValue(),
                    kijunYMD.getMonthValue(), kijunYMD.getDayValue()));
            row.getTxtMeiboTorokuYMD().setValue(new RDate(dateKeisan.get登録日().wareki().toDateString().toString()));
            row.getTxtKokujiYMD().setValue(new RDate(dateKeisan.get告示公示日().wareki().toDateString().toString()));
            row.getTxtTenshutsuKigenYMD().setValue(new RDate(dateKeisan.get転出期限日().wareki().toDateString().toString()));
            row.getTxtTennyuKigenYMD().setValue(new RDate(dateKeisan.get転入期限日().wareki().toDateString().toString()));
        } else {
            row.getTxtMeiboTorokuYMD().clearValue();
            row.getTxtKokujiYMD().clearValue();
            row.getTxtTenshutsuKigenYMD().clearValue();
            row.getTxtTennyuKigenYMD().clearValue();
        }
    }

    public void set選挙一覧(List<Senkyo> senkyoList) {
        List<dgSenkyojiSenkyoNyuryoku_Row> dataSource = new ArrayList<>();
        for (Senkyo senkyo : senkyoList) {
            dgSenkyojiSenkyoNyuryoku_Row row = new dgSenkyojiSenkyoNyuryoku_Row();
            //選挙番号
            row.setTxtNo(new RString(String.valueOf(senkyo.get選挙番号().value())));
            //選挙レベル
            row.getDdlLevel().setDataSource(CodeMasterHelper.createDataSourceRyakusho(
                    AFACodeShubetsu.選挙レベル.getCodeShubetsu(), Boolean.FALSE));
            row.getDdlLevel().setSelectedKey(senkyo.get選挙レベル().value());
            //選挙名称
            row.getTxtSenkyoName().setValue(senkyo.get選挙名称());
            //選挙略称
            row.getTxtSenkyoRyakusho().setValue(senkyo.get選挙略称());
            //選挙マーク
            row.getTxtSenkyoMark().setValue(senkyo.get選挙マーク());
            //名簿基準年月日
            if (null == senkyo.get名簿基準年月日()) {
                row.getTxtKijunYMD().clearValue();
            } else {
                row.getTxtKijunYMD().setValue(getFlexibleDateToRDate(senkyo.get名簿基準年月日()));
                div.getTxtKijunYMD().setValue(getFlexibleDateToRDate(senkyo.get名簿基準年月日()));
            }
            //投票受付開始年月日
            if (null == senkyo.get投票受付開始年月日()) {
                row.getTxtTohyoUketsukeYMD().clearValue();
            } else {
                row.getTxtTohyoUketsukeYMD().setValue(getFlexibleDateToRDate(senkyo.get投票受付開始年月日()));
            }
            //告示（公示）年月日
            if (null == senkyo.get告示_公示年月日()) {
                row.getTxtKokujiYMD().clearValue();
            } else {
                row.getTxtKokujiYMD().setValue(getFlexibleDateToRDate(senkyo.get告示_公示年月日()));
            }
            //名簿登録年月日
            if (null == senkyo.get名簿登録年月日()) {
                row.getTxtMeiboTorokuYMD().clearValue();
            } else {
                row.getTxtMeiboTorokuYMD().setValue(getFlexibleDateToRDate(senkyo.get名簿登録年月日()));
                div.getTxtMeiboTorokuYMD().setValue(getFlexibleDateToRDate(senkyo.get名簿登録年月日()));
            }
            //転出期限年月日
            if (null == senkyo.get転出期限年月日()) {
                row.getTxtTenshutsuKigenYMD().clearValue();
            } else {
                row.getTxtTenshutsuKigenYMD().setValue(getFlexibleDateToRDate(senkyo.get転出期限年月日()));
                div.getTxtTenshutsuYMD().setValue(getFlexibleDateToRDate(senkyo.get転出期限年月日()));
            }
            //転入期限年月日
            if (null == senkyo.get転入期限年月日()) {
                row.getTxtTennyuKigenYMD().clearValue();
            } else {
                row.getTxtTennyuKigenYMD().setValue(getFlexibleDateToRDate(senkyo.get転入期限年月日()));
                div.getTxtTennyuYMD().setValue(getFlexibleDateToRDate(senkyo.get転入期限年月日()));
            }
            dataSource.add(row);
        }
        div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().setDataSource(dataSource);
    }

    /**
     * 各項目をクリアします。
     *
     */
    public void clearThisPanel() {
        div.getTxtShohonName().clearValue();
        div.getTxtTohyoYMD().clearValue();
        div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().getDataSource().clear();
        div.getTxtKijunYMD().clearValue();
        div.getTxtMeiboTorokuYMD().clearValue();
        div.getTxtTennyuYMD().clearValue();
        div.getTxtTenshutsuYMD().clearValue();
        div.getTxtNenreiTotatsuYMD().clearValue();
    }

    /**
     * 画面上の選挙情報を取得します。
     *
     * @return 選挙情報リスト
     */
    public List<dgSenkyojiSenkyoNyuryoku_Row> get選挙情報() {
        return div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().getDataSource();
    }

    private RDate getFlexibleDateToRDate(FlexibleDate value) {
        return new RDate(value.wareki().toDateString().toString());
    }

}
