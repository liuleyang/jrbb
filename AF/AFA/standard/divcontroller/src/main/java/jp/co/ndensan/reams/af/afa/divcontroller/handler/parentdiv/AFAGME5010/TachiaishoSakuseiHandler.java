/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.Tohyoroku;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.TohyorokuBuilder;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugi;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugiBuilder;
import jp.co.ndensan.reams.af.afa.business.tachiaishosakusei.TachiaishoSakuseiResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyorokuKomokuShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.dgTohyorokuDairiTohyosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.dgTohyorokuKyohiNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.dgTohyorokuShimeiNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.TachiaishoSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.dgTachiaishoSaikofusha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.dgTachiaishoTachiainin_Row;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.TohyorokuManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugiManager;
import jp.co.ndensan.reams.af.afa.service.tachiaishosakusei.TachiaishoSakuseiManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * AFAGME5010 立会人引継書のhandler
 *
 * @reamsid_L AF-0120-010 xul
 */
public final class TachiaishoSakuseiHandler {

    private final TachiaishoSakuseiDiv div;
    private static final int 決定書または裁決書により投票をした者情報入力可能行数 = 3;
    private static final int 投票用紙再交付者情報入力可能行数 = 5;
    private static final int 投票用紙再交付者情報行毎に入力可能氏名数 = 2;
    private final RString 横線 = new RString("-");
    private final RString 再検索するボタン = new RString("btnReSearch");
    private final RString 検索結果一覧へボタン = new RString("btnSearchResult");
    private final RString 保存するボタン = new RString("btnUpdate");
    private final RString 無投票選挙フラグ_TRUE = new RString("TRUE");
    private final RString 無投票選挙フラグ_FALSE = new RString("FALSE");
    private final RString 投票区コード_デフォルト = new RString("0000");
    private final RString 処理区分_更新 = new RString("更新");
    private final RString 処理区分_削除 = new RString("削除");
    private final RString 処理区分_新規 = new RString("新規");
    private final RString 開閉時刻 = new RString("00:00");

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    private TachiaishoSakuseiHandler(TachiaishoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 立会人引継書のHandler初期化
     *
     * @param div 立会人引継書DIV
     * @return 立会人引継書のHandler
     */
    public static TachiaishoSakuseiHandler of(TachiaishoSakuseiDiv div) {
        return new TachiaishoSakuseiHandler(div);
    }

    /**
     * 期日前投票日設定処理
     *
     */
    public void set期日前投票日() {
        div.getTxtTohyoYMDJoken().setValue(RDate.getNowDate());
    }

    /**
     * 選挙名ドロップダウンリスト設定処理
     *
     */
    public void set選挙名ドロップダウンリスト() {
        div.getDdlSenkyoName().getDataSource().clear();
        List<KeyValueDataSource> list = new ArrayList<>();
        RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
        boolean flag = false;
        if (!RString.isNullOrEmpty(抄本番号)) {
            TachiaishoSakuseiManager finder = TachiaishoSakuseiManager.createInstance();
            List<Senkyo> 選挙名リスト = finder.select選挙名By抄本番号(new ShohonNo(抄本番号));
            if (null != 選挙名リスト && !選挙名リスト.isEmpty()) {
                flag = true;
                for (Senkyo 選挙名 : 選挙名リスト) {
                    KeyValueDataSource source = new KeyValueDataSource();
                    source.setKey(new RString(選挙名.get選挙番号().getColumnValue()).concat(横線)
                            .concat(選挙名.is無投票選挙フラグ() ? 無投票選挙フラグ_TRUE : 無投票選挙フラグ_FALSE));
                    source.setValue(選挙名.get選挙名称());
                    list.add(source);
                }
            }
        }
        div.getDdlSenkyoName().setDataSource(list);
        if (flag) {
            div.getDdlSenkyoName().setSelectedIndex(0);
        }
    }

    /**
     * 期日前投票所ドロップダウンリスト設定処理
     *
     */
    public void set期日前投票所ドロップダウンリスト() {
        div.getDdlShisetsu().getDataSource().clear();
        ShisetsuManager shisetsuManager = ShisetsuManager.createInstance();
        List<Shisetsu> 施設リスト = shisetsuManager.get施設By施設種別コードリスト(
                ShisetsuShubetsu.一般_本庁.getCode(), ShisetsuShubetsu.一般_支所.getCode());
        List<KeyValueDataSource> list = new ArrayList<>();
        boolean flag = false;
        if (null != 施設リスト && !施設リスト.isEmpty()) {
            flag = true;
            for (Shisetsu 施設 : 施設リスト) {
                KeyValueDataSource source = new KeyValueDataSource();
                source.setKey(施設.get施設コード().concat(横線).concat(施設.get施設種別().getKey()));
                source.setValue(施設.get施設名称());
                list.add(source);
            }
        }
        div.getDdlShisetsu().setDataSource(list);
        if (flag) {
            div.getDdlShisetsu().setSelectedIndex(0);
        }
    }

    /**
     * 立会人引継書作成条件_初期状態
     *
     */
    public void set画面制御_立会人引継書作成条件_初期状態() {
        div.getTachiaishoJoken().setIsOpen(true);
        div.getTachiaishoJoken().setDisabled(false);
        div.getTachiaishoTachiainin().setVisible(false);
        div.getTachiaishoJokyoNyuryoku().setVisible(false);
        div.getTachiaishoJokyoNyuryoku().setDisplayNone(true);
        set共通エリアボタン非表示();
    }

    private void set共通エリアボタン非表示() {
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索するボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存するボタン, true);
    }

    /**
     * 無投票選挙フラグ取得処理
     *
     * @return 無投票選挙フラグ
     */
    public boolean is無投票選挙フラグ() {
        boolean 無投票選挙フラグ = false;
        RString 選挙 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list = 選挙.split(横線.toString());
        if (無投票選挙フラグ_TRUE.equals(list.get(1))) {
            無投票選挙フラグ = true;
        }
        return 無投票選挙フラグ;
    }

    /**
     * 投票立会人情報設定処理
     *
     * @return List<TachiaininHikitsugi> 立会人引継情報リスト
     */
    public List<TachiaininHikitsugi> set投票立会人情報() {
        div.getDgTachiaishoTachiainin().getDataSource().clear();
        TachiaininHikitsugiManager manager = TachiaininHikitsugiManager.createInstance();
        Code 投票録項目種類 = new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode());
        ShohonNo 抄本番号 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙 = 選挙.split(横線.toString());
        SenkyoNo 選挙番号 = new SenkyoNo(list_選挙.get(0));
        FlexibleDate 報告年月日 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設 = 施設.split(横線.toString());
        RString 施設コード = list_施設.get(0);
        List<TachiaininHikitsugi> 立会人引継情報リスト = manager.get立会人引継情報リスト(抄本番号,
                選挙番号, 報告年月日, 施設コード, 投票録項目種類);
        List<dgTachiaishoTachiainin_Row> dataSource = new ArrayList<>();
        if (null != 立会人引継情報リスト && !立会人引継情報リスト.isEmpty()) {
            for (int i = 0; i < 立会人引継情報リスト.size(); i++) {
                TachiaininHikitsugi 立会人引継情報 = 立会人引継情報リスト.get(i);
                dgTachiaishoTachiainin_Row row = new dgTachiaishoTachiainin_Row();
                row.setTxtToha(立会人引継情報.get党派());
                row.setTxtTachiaininShimei(立会人引継情報.get氏名().getColumnValue());
                row.setTxtTachiaiStartTime(立会人引継情報.get立会時間_開始時刻().toFormattedTimeString(DisplayTimeFormat.HH_mm));
                row.setTxtTachiaiStopTime(立会人引継情報.get立会時間_終了時刻().toFormattedTimeString(DisplayTimeFormat.HH_mm));
                row.setChkIjoUmu(立会人引継情報.is異常有フラグ());
                row.setTxtIjoNaiyo(立会人引継情報.get異常内容());
                row.setHdnTachiaininRenban(new RString(立会人引継情報.get立会人連番()));
                dataSource.add(row);
            }
        }
        div.getDgTachiaishoTachiainin().setDataSource(dataSource);
        return 立会人引継情報リスト;
    }

    /**
     * 立会人引継書作成条件から引継情報検索ボタン押した時画面制御
     *
     */
    public void set画面制御_立会人引継書作成条件_引継情報検索ボタン押下() {
        div.getTachiaishoJoken().setIsOpen(false);
        div.getTachiaishoJoken().setDisabled(true);
        div.getTachiaishoTachiainin().setVisible(true);
        div.getTachiaishoTachiainin().setIsOpen(true);
        div.getTachiaishoTachiainin().setDisabled(false);
        div.getTachiaishoJokyoNyuryoku().setVisible(false);
        div.getTachiaishoJokyoNyuryoku().setDisplayNone(true);
        set共通エリアボタン非表示();
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索するボタン, false);
    }

    /**
     * 引継内容詳細設定
     *
     * @return List<TachiaininHikitsugi> 投票用紙再交付者情報リスト
     */
    public List<TachiaininHikitsugi> set引継内容詳細() {
        set立会人引継情報情報();
        List<TachiaininHikitsugi> 投票用紙再交付者情報リスト = set投票用紙再交付者情報();
        set決定書または裁決書により投票をした者();
        set不在者投票の用紙及び封筒を返還して投票した者();
        set点字により投票をした者();
        set代理投票をした者();
        set投票拒否の決定をした者();
        return 投票用紙再交付者情報リスト;
    }

    private void set立会人引継情報情報() {
        dgTachiaishoTachiainin_Row row = div.getDgTachiaishoTachiainin().getClickedItem();
        div.getTxtToha().setValue(row.getTxtToha());
        div.getTxtTachiaininShimei().setDomain(RString.isNullOrEmpty(row.getTxtTachiaininShimei())
                ? AtenaMeisho.EMPTY : new AtenaMeisho(row.getTxtTachiaininShimei()));
        div.getTxtTachiaiTimeRange().setFromValue(RString.isNullOrEmpty(row.getTxtTachiaiStartTime())
                ? null : new RTime(row.getTxtTachiaiStartTime()));
        div.getTxtTachiaiTimeRange().setToValue(RString.isNullOrEmpty(row.getTxtTachiaiStopTime())
                ? null : new RTime(row.getTxtTachiaiStopTime()));
        if (row.getChkIjoUmu()) {
            div.getRadIjoAriFlag().setSelectedIndex(1);
        } else {
            div.getRadIjoAriFlag().setSelectedIndex(0);
        }
        div.getTxtIjoNaiyo().setValue(row.getTxtIjoNaiyo());
        div.getTachiaishoJokyoNyuryoku().setHdnTachiaininRenban(row.getHdnTachiaininRenban());
    }

    private List<TachiaininHikitsugi> set投票用紙再交付者情報() {
        Code tohyorokuKomokuShurui = new Code(TohyorokuKomokuShurui.再交付者.getCode());
        ShohonNo 抄本番号 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙 = 選挙.split(横線.toString());
        SenkyoNo senkyoNo = new SenkyoNo(list_選挙.get(0));
        FlexibleDate tohyoYMDJoken = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString shisetsu = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設 = shisetsu.split(横線.toString());
        RString 施設コード = list_施設.get(0);
        TachiaininHikitsugiManager manager = TachiaininHikitsugiManager.createInstance();
        dgTachiaishoTachiainin_Row tachiaishoTachiainin = div.getDgTachiaishoTachiainin().getClickedItem();
        List<TachiaininHikitsugi> 投票用紙再交付者情報リスト = manager.get投票用紙再交付者情報(抄本番号,
                senkyoNo, tohyoYMDJoken, 施設コード, tohyorokuKomokuShurui, Integer.valueOf(tachiaishoTachiainin.getHdnTachiaininRenban().toString()));
        List<dgTachiaishoSaikofusha_Row> dataSource = new ArrayList<>();
        if (null != 投票用紙再交付者情報リスト && !投票用紙再交付者情報リスト.isEmpty()) {
            for (int i = 0; i < 投票用紙再交付者情報リスト.size();) {
                if (i >= 投票用紙再交付者情報入力可能行数 * 投票用紙再交付者情報行毎に入力可能氏名数) {
                    break;
                }
                dgTachiaishoSaikofusha_Row row = new dgTachiaishoSaikofusha_Row();
                row.getTxtShimei1().setValue(投票用紙再交付者情報リスト.get(i).get氏名().getColumnValue());
                i += 1;
                if (i < 投票用紙再交付者情報リスト.size()) {
                    row.getTxtShimei2().setValue(投票用紙再交付者情報リスト.get(i).get氏名().getColumnValue());
                }
                i += 1;
                dataSource.add(row);
            }
        }
        int size = dataSource.size();
        if (投票用紙再交付者情報入力可能行数 > size) {
            for (int i = 0; i < 投票用紙再交付者情報入力可能行数 - size; i++) {
                dataSource.add(new dgTachiaishoSaikofusha_Row());
            }
        }
        div.getDgTachiaishoSaikofusha().setDataSource(dataSource);
        return 投票用紙再交付者情報リスト;
    }

    private void set決定書または裁決書により投票をした者() {
        ShohonNo 抄本番号_決定書裁決書 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_決定書裁決書 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_決定書裁決書 = 選挙_決定書裁決書.split(横線.toString());
        SenkyoNo 選挙番号_決定書裁決書 = new SenkyoNo(list_選挙_決定書裁決書.get(0));
        FlexibleDate 報告年月日_決定書裁決書 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_決定書裁決書 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_決定書裁決書 = 施設_決定書裁決書.split(横線.toString());
        RString 施設コード_決定書裁決書 = list_施設_決定書裁決書.get(0);
        RString 投票区コード_決定書裁決書 = RString.EMPTY;
        RString 投票状況_決定書裁決書 = TohyoJokyo.期日前.getCode();
        Code 投票録項目種類_決定書裁決書 = new Code(TohyorokuKomokuShurui.決定書_判決書.getCode());
        RString 立会人連番_決定書裁決書 = div.getTachiaishoJokyoNyuryoku().getHdnTachiaininRenban();
        div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource().clear();
        div.getCcdTachiaishoKetteisho().initialize(
                抄本番号_決定書裁決書,
                選挙番号_決定書裁決書,
                報告年月日_決定書裁決書,
                施設コード_決定書裁決書,
                投票区コード_決定書裁決書,
                投票状況_決定書裁決書,
                投票録項目種類_決定書裁決書,
                立会人連番_決定書裁決書,
                決定書または裁決書により投票をした者情報入力可能行数);
        List<dgTohyorokuShimeiNyuryoku_Row> dataSource = div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null == dataSource) {
            dataSource = new ArrayList<>();
        }
        int size = dataSource.size();
        if (決定書または裁決書により投票をした者情報入力可能行数 > size) {
            for (int i = 0; i < 決定書または裁決書により投票をした者情報入力可能行数 - size; i++) {
                dataSource.add(new dgTohyorokuShimeiNyuryoku_Row());
            }
        }
    }

    private void set不在者投票の用紙及び封筒を返還して投票した者() {
        ShohonNo 抄本番号_用紙返還 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_用紙返還 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_用紙返還 = 選挙_用紙返還.split(横線.toString());
        SenkyoNo 選挙番号_用紙返還 = new SenkyoNo(list_選挙_用紙返還.get(0));
        FlexibleDate 報告年月日_用紙返還 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_用紙返還 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_用紙返還 = 施設_用紙返還.split(横線.toString());
        RString 施設コード_用紙返還 = list_施設_用紙返還.get(0);
        RString 投票区コード_用紙返還 = RString.EMPTY;
        RString 投票状況_用紙返還 = TohyoJokyo.期日前.getCode();
        Code 投票録項目種類_用紙返還 = new Code(TohyorokuKomokuShurui.用紙返還.getCode());
        RString 立会人連番_用紙返還 = div.getTachiaishoJokyoNyuryoku().getHdnTachiaininRenban();
        div.getCcdTachiaishoHenkan().getDgTohyorokuShimeiNyuryoku().getDataSource().clear();
        div.getCcdTachiaishoHenkan().initialize(
                抄本番号_用紙返還,
                選挙番号_用紙返還,
                報告年月日_用紙返還,
                施設コード_用紙返還,
                投票区コード_用紙返還,
                投票状況_用紙返還,
                投票録項目種類_用紙返還,
                立会人連番_用紙返還);
    }

    private void set点字により投票をした者() {
        ShohonNo 抄本番号_点字 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_点字 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_点字 = 選挙_点字.split(横線.toString());
        SenkyoNo 選挙番号_点字 = new SenkyoNo(list_選挙_点字.get(0));
        FlexibleDate 報告年月日_点字 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_点字 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_点字 = 施設_点字.split(横線.toString());
        RString 施設コード_点字 = list_施設_点字.get(0);
        RString 投票区コード_点字 = RString.EMPTY;
        RString 投票状況_点字 = TohyoJokyo.期日前.getCode();
        Code 投票録項目種類_点字 = new Code(TohyorokuKomokuShurui.投票の拒否.getCode());
        RString 立会人連番_点字 = div.getTachiaishoJokyoNyuryoku().getHdnTachiaininRenban();
        div.getCcdTachiaishoTenji().getDgTohyorokuShimeiNyuryoku().getDataSource().clear();
        div.getCcdTachiaishoTenji().initialize(
                抄本番号_点字,
                選挙番号_点字,
                報告年月日_点字,
                施設コード_点字,
                投票区コード_点字,
                投票状況_点字,
                投票録項目種類_点字,
                立会人連番_点字);

    }

    private void set代理投票をした者() {
        ShohonNo 抄本番号_代理 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_代理 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_代理 = 選挙_代理.split(横線.toString());
        SenkyoNo 選挙番号_代理 = new SenkyoNo(list_選挙_代理.get(0));
        FlexibleDate 報告年月日_代理 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_代理 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_代理 = 施設_代理.split(横線.toString());
        RString 施設コード_代理 = list_施設_代理.get(0);
        RString 投票区コード_代理 = RString.EMPTY;
        RString 投票状況_代理 = TohyoJokyo.期日前.getCode();
        div.getCcdTachiaishoDairi().getDgTohyorokuDairiTohyosha().getDataSource().clear();
        div.getCcdTachiaishoDairi().initialize(
                抄本番号_代理,
                選挙番号_代理,
                報告年月日_代理,
                施設コード_代理,
                投票区コード_代理,
                投票状況_代理);
    }

    private void set投票拒否の決定をした者() {
        ShohonNo 抄本番号_投票拒否 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_投票拒否 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_投票拒否 = 選挙_投票拒否.split(横線.toString());
        SenkyoNo 選挙番号_投票拒否 = new SenkyoNo(list_選挙_投票拒否.get(0));
        FlexibleDate 報告年月日_投票拒否 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_投票拒否 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_投票拒否 = 施設_投票拒否.split(横線.toString());
        RString 施設コード_投票拒否 = list_施設_投票拒否.get(0);
        RString 投票区コード_投票拒否 = RString.EMPTY;
        RString 投票状況_投票拒否 = TohyoJokyo.期日前.getCode();
        div.getCcdTachiaishoKyohiKettei().getDgTohyorokuKyohiNyuryoku().getDataSource().clear();
        div.getCcdTachiaishoKyohiKettei().initialize(
                抄本番号_投票拒否,
                選挙番号_投票拒否,
                報告年月日_投票拒否,
                true,
                施設コード_投票拒否,
                投票区コード_投票拒否,
                投票状況_投票拒否);
    }

    /**
     * 投票立会人情報から修正ボタン押した時画面制御
     *
     */
    public void set画面制御_投票立会人情報_修正ボタン押下() {
        div.getTachiaishoJoken().setIsOpen(false);
        div.getTachiaishoJoken().setDisabled(true);
        div.getTachiaishoTachiainin().setIsOpen(false);
        div.getTachiaishoTachiainin().setVisible(true);
        div.getTachiaishoTachiainin().setDisabled(true);
        div.getTachiaishoJokyoNyuryoku().setVisible(true);
        div.getTachiaishoJokyoNyuryoku().setDisplayNone(false);
        set共通エリアボタン表示();
        div.getTxtToha().setDisabled(false);
        div.getTxtTachiaininShimei().setDisabled(false);
        div.getTxtTachiaiTimeRange().setDisabled(false);
        div.getRadIjoAriFlag().setDisabled(false);
        set画面制御_投票立会人情報_異常ラジオボタン選択変更();
        div.getDgTachiaishoSaikofusha().setDisabled(false);
        div.getCcdTachiaishoKetteisho().setEditMode(false);
    }

    private void set共通エリアボタン表示() {
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索するボタン, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へボタン, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存するボタン, false);
    }

    /**
     * 異常ラジオボタンonChange時画面制御
     *
     */
    public void set画面制御_投票立会人情報_異常ラジオボタン選択変更() {
        if (0 == div.getRadIjoAriFlag().getSelectedIndex()) {
            div.getTxtIjoNaiyo().setDisabled(true);
        } else {
            div.getTxtIjoNaiyo().setDisabled(false);
        }
    }

    /**
     * 投票立会人情報から削除ボタン押した時画面制御
     *
     */
    public void set画面制御_投票立会人情報_削除ボタン押下() {
        div.getTachiaishoJoken().setIsOpen(false);
        div.getTachiaishoJoken().setDisabled(true);
        div.getTachiaishoTachiainin().setIsOpen(false);
        div.getTachiaishoTachiainin().setVisible(true);
        div.getTachiaishoTachiainin().setDisabled(true);
        div.getTachiaishoJokyoNyuryoku().setVisible(true);
        div.getTachiaishoJokyoNyuryoku().setDisplayNone(false);
        set共通エリアボタン表示();
        div.getTxtToha().setDisabled(true);
        div.getTxtTachiaininShimei().setDisabled(true);
        div.getTxtTachiaiTimeRange().setDisabled(true);
        div.getRadIjoAriFlag().setDisabled(true);
        div.getTxtIjoNaiyo().setDisabled(true);
        div.getDgTachiaishoSaikofusha().setDisabled(true);
        div.getCcdTachiaishoKetteisho().setEditMode(true);
    }

    /**
     * 引継内容詳細設定
     *
     */
    public void set引継内容詳細_新規追加() {
        set立会人引継情報情報_新規追加();
        div.getDgTachiaishoSaikofusha().getDataSource().clear();
        List<dgTachiaishoSaikofusha_Row> dataSource = new ArrayList<>();
        for (int i = 0; i < 投票用紙再交付者情報入力可能行数; i++) {
            dataSource.add(new dgTachiaishoSaikofusha_Row());
        }
        div.getDgTachiaishoSaikofusha().setDataSource(dataSource);
        div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource().clear();
        List<dgTohyorokuShimeiNyuryoku_Row> source = new ArrayList<>();
        for (int i = 0; i < 決定書または裁決書により投票をした者情報入力可能行数; i++) {
            source.add(new dgTohyorokuShimeiNyuryoku_Row());
        }
        div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().setDataSource(source);
        div.getCcdTachiaishoHenkan().getDgTohyorokuShimeiNyuryoku().getDataSource().clear();
        div.getCcdTachiaishoTenji().getDgTohyorokuShimeiNyuryoku().getDataSource().clear();
        div.getCcdTachiaishoDairi().getDgTohyorokuDairiTohyosha().getDataSource().clear();
        div.getCcdTachiaishoKyohiKettei().getDgTohyorokuKyohiNyuryoku().getDataSource().clear();
        set不在者投票の用紙及び封筒を返還して投票した者();
        set点字により投票をした者();
        set代理投票をした者();
        set投票拒否の決定をした者();
    }

    private void set立会人引継情報情報_新規追加() {
        div.getTxtToha().setValue(RString.EMPTY);
        div.getTxtTachiaininShimei().setDomain(AtenaMeisho.EMPTY);
        div.getTxtTachiaiTimeRange().setFromValue(null);
        div.getTxtTachiaiTimeRange().setToValue(null);
        div.getRadIjoAriFlag().setSelectedIndex(0);
        div.getTxtIjoNaiyo().setValue(RString.EMPTY);
    }

    /**
     * 投票立会人情報から新規追加ボタン押した時画面制御
     *
     */
    public void set画面制御_投票立会人情報_新規追加ボタン押下() {
        set画面制御_投票立会人情報_修正ボタン押下();
    }

    /**
     * 新規追加で引継内容詳細情報が入力されたの判断処理
     *
     * @return 引継内容詳細情報が入力された
     */
    public boolean is引継内容詳細情報が入力された() {
        return !RString.isNullOrEmpty(div.getTxtToha().getValue())
                || !RString.isNullOrEmpty(div.getTxtTachiaininShimei().getDomain().getColumnValue())
                || null != div.getTxtTachiaiTimeRange().getFromValue()
                || null != div.getTxtTachiaiTimeRange().getToValue()
                || 0 < div.getRadIjoAriFlag().getSelectedIndex()
                || !RString.isNullOrEmpty(div.getTxtIjoNaiyo().getValue())
                || checkList();
    }

    private boolean checkList() {
        List<dgTachiaishoSaikofusha_Row> 投票用紙再交付者リスト = div.getDgTachiaishoSaikofusha().getDataSource();
        if (null != 投票用紙再交付者リスト && !投票用紙再交付者リスト.isEmpty()) {
            for (dgTachiaishoSaikofusha_Row 投票用紙再交付者 : 投票用紙再交付者リスト) {
                if (!RString.isNullOrEmpty(投票用紙再交付者.getTxtShimei1().getValue())
                        || !RString.isNullOrEmpty(投票用紙再交付者.getTxtShimei2().getValue())) {
                    return true;
                }
            }
        }
        List<dgTohyorokuShimeiNyuryoku_Row> 決定書または裁決書投票者リスト
                = div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null != 決定書または裁決書投票者リスト && !決定書または裁決書投票者リスト.isEmpty()) {
            for (dgTohyorokuShimeiNyuryoku_Row 決定書または裁決書投票者 : 決定書または裁決書投票者リスト) {
                if (!RString.isNullOrEmpty(決定書または裁決書投票者.getTxtShimei1().getValue())
                        || !RString.isNullOrEmpty(決定書または裁決書投票者.getTxtShimei2().getValue())
                        || !RString.isNullOrEmpty(決定書または裁決書投票者.getTxtShimei3().getValue())
                        || !RString.isNullOrEmpty(決定書または裁決書投票者.getTxtShimei4().getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 修正で引継内容詳細情報が修正されたの判断処理
     *
     * @param 投票用紙再交付者 ArrayList<TachiaishoSakuseiResult>
     * @param 決定書または裁決書により投票をした者 ArrayList<TachiaishoSakuseiResult>
     * @return 引継内容詳細情報が修正された
     */
    public boolean is引継内容詳細情報が修正された(ArrayList<TachiaishoSakuseiResult> 投票用紙再交付者,
            ArrayList<TachiaishoSakuseiResult> 決定書または裁決書により投票をした者) {
        if (is引継内容詳細情報が修正された()) {
            return true;
        }
        if (is投票用紙再交付者が修正された(投票用紙再交付者)) {
            return true;
        }
        return is決定書または裁決書により投票をした者が修正された(決定書または裁決書により投票をした者);
    }

    private boolean is引継内容詳細情報が修正された() {
        dgTachiaishoTachiainin_Row row = div.getDgTachiaishoTachiainin().getActiveRow();
        if (!changeNullToEmpty(row.getTxtToha()).equals(div.getTxtToha().getValue())) {
            return true;
        }
        if (!changeNullToEmpty(row.getTxtTachiaininShimei()).equals(div.getTxtTachiaininShimei().getDomain().getColumnValue())) {
            return true;
        }
        if (!div.getTxtTachiaiTimeRange().getFromValue().equals(RString.isNullOrEmpty(row.getTxtTachiaiStartTime())
                ? null : new RTime(row.getTxtTachiaiStartTime()))) {
            return true;
        }
        if (!div.getTxtTachiaiTimeRange().getToValue().equals(RString.isNullOrEmpty(row.getTxtTachiaiStopTime())
                ? null : new RTime(row.getTxtTachiaiStopTime()))) {
            return true;
        }
        if (!((0 == div.getRadIjoAriFlag().getSelectedIndex() && !row.getChkIjoUmu())
                || (1 == div.getRadIjoAriFlag().getSelectedIndex() && row.getChkIjoUmu()))) {
            return true;
        }
        return !changeNullToEmpty(row.getTxtIjoNaiyo()).equals(div.getTxtIjoNaiyo().getValue());
    }

    private boolean is投票用紙再交付者が修正された(ArrayList<TachiaishoSakuseiResult> 投票用紙再交付者) {
        boolean is投票用紙再交付者 = false;
        List<dgTachiaishoSaikofusha_Row> 投票用紙再交付者_修正後 = div.getDgTachiaishoSaikofusha().getDataSource();
        if ((null == 投票用紙再交付者 || 投票用紙再交付者.isEmpty())
                && (null == 投票用紙再交付者_修正後 || 投票用紙再交付者_修正後.isEmpty())) {
            return false;
        }
        int 投票用紙再交付者size = null == 投票用紙再交付者 || 投票用紙再交付者.isEmpty() ? 0 : 投票用紙再交付者.size();
        int 投票用紙再交付者_修正後size = null == 投票用紙再交付者_修正後 || 投票用紙再交付者_修正後.isEmpty() ? 0 : 投票用紙再交付者_修正後.size();
        if (投票用紙再交付者size != 投票用紙再交付者_修正後size) {
            is投票用紙再交付者 = true;
        } else {
            if (null == 投票用紙再交付者 || 投票用紙再交付者.isEmpty()
                    || null == 投票用紙再交付者_修正後 || 投票用紙再交付者_修正後.isEmpty()) {
                return true;
            }
            for (int i = 0; i < 投票用紙再交付者size; i++) {
                TachiaishoSakuseiResult row1 = 投票用紙再交付者.get(i);
                dgTachiaishoSaikofusha_Row row2 = 投票用紙再交付者_修正後.get(i);
                if (!changeNullToEmpty(row1.get氏名１()).equals(row2.getTxtShimei1().getValue())
                        || !changeNullToEmpty(row1.get氏名２()).equals(row2.getTxtShimei2().getValue())) {
                    is投票用紙再交付者 = true;
                    break;
                }
            }
        }
        return is投票用紙再交付者;
    }

    private boolean is決定書または裁決書により投票をした者が修正された(ArrayList<TachiaishoSakuseiResult> 決定書または裁決書により投票をした者) {
        boolean is決定書または裁決書により投票をした者 = false;
        List<dgTohyorokuShimeiNyuryoku_Row> 決定書または裁決書により投票をした者_修正後 = div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if ((null == 決定書または裁決書により投票をした者 || 決定書または裁決書により投票をした者.isEmpty())
                && (null == 決定書または裁決書により投票をした者_修正後 || 決定書または裁決書により投票をした者_修正後.isEmpty())) {
            return false;
        }
        int 決定書または裁決書により投票をした者size = null == 決定書または裁決書により投票をした者 || 決定書または裁決書により投票をした者.isEmpty() ? 0 : 決定書または裁決書により投票をした者.size();
        int 決定書または裁決書により投票をした者_修正後size = null == 決定書または裁決書により投票をした者_修正後 || 決定書または裁決書により投票をした者_修正後.isEmpty() ? 0 : 決定書または裁決書により投票をした者_修正後.size();
        if (決定書または裁決書により投票をした者size != 決定書または裁決書により投票をした者_修正後size) {
            is決定書または裁決書により投票をした者 = true;
        } else {
            if (null == 決定書または裁決書により投票をした者 || 決定書または裁決書により投票をした者.isEmpty()
                    || null == 決定書または裁決書により投票をした者_修正後 || 決定書または裁決書により投票をした者_修正後.isEmpty()) {
                return true;
            }
            for (int i = 0; i < 決定書または裁決書により投票をした者size; i++) {
                TachiaishoSakuseiResult row1 = 決定書または裁決書により投票をした者.get(i);
                dgTohyorokuShimeiNyuryoku_Row row2 = 決定書または裁決書により投票をした者_修正後.get(i);
                if (!changeNullToEmpty(row1.get氏名１()).equals(row2.getTxtShimei1().getValue())
                        || !changeNullToEmpty(row1.get氏名２()).equals(row2.getTxtShimei2().getValue())
                        || !changeNullToEmpty(row1.get氏名３()).equals(row2.getTxtShimei3().getValue())
                        || !changeNullToEmpty(row1.get氏名４()).equals(row2.getTxtShimei4().getValue())) {
                    is決定書または裁決書により投票をした者 = true;
                    break;
                }
            }
        }
        return is決定書または裁決書により投票をした者;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    /**
     * 対象情報登録処理
     *
     * @param 処理区分 RString
     * @param 立会人引継情報 TachiaininHikitsugi
     * @param 投票用紙再交付者情報リスト ArrayList<TachiaininHikitsugi>
     * @return 処理結果
     */
    public boolean save対象情報登録(RString 処理区分, TachiaininHikitsugi 立会人引継情報, ArrayList<TachiaininHikitsugi> 投票用紙再交付者情報リスト) {
        if (処理区分_新規.equals(処理区分)) {
            return save立会人引継情報();
        }
        if (処理区分_更新.equals(処理区分)) {
            return update立会人引継情報(立会人引継情報, 投票用紙再交付者情報リスト);
        }
        if (処理区分_削除.equals(処理区分)) {
            return delete立会人引継情報(立会人引継情報, 投票用紙再交付者情報リスト);
        }
        return false;
    }

    private boolean is期日前当日投票録存在() {
        ShohonNo 抄本番号_期日前当日投票録 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_期日前当日投票録 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_期日前当日投票録 = 選挙_期日前当日投票録.split(横線.toString());
        SenkyoNo 選挙番号_期日前当日投票録 = new SenkyoNo(list_選挙_期日前当日投票録.get(0));
        FlexibleDate 報告年月日_期日前当日投票録 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_期日前当日投票録 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_期日前当日投票録 = 施設_期日前当日投票録.split(横線.toString());
        RString 施設コード_期日前当日投票録 = list_施設_期日前当日投票録.get(0);
        TohyorokuManager manager = TohyorokuManager.createInstance();
        Tohyoroku tohyoroku = manager.get投票録ByKey(抄本番号_期日前当日投票録, 選挙番号_期日前当日投票録,
                報告年月日_期日前当日投票録, 施設コード_期日前当日投票録, 投票区コード_デフォルト);
        return null != tohyoroku;
    }

    private Tohyoroku edit期日前当日投票録情報() {
        ShohonNo 抄本番号_投票録 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_投票録 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_投票録 = 選挙_投票録.split(横線.toString());
        SenkyoNo 選挙番号_投票録 = new SenkyoNo(list_選挙_投票録.get(0));
        FlexibleDate 報告年月日_投票録 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_投票録 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_投票録 = 施設_投票録.split(横線.toString());
        RString 施設コード_投票録 = list_施設_投票録.get(0);
        Tohyoroku tohyoroku = new Tohyoroku(
                抄本番号_投票録,
                選挙番号_投票録,
                報告年月日_投票録,
                施設コード_投票録,
                投票区コード_デフォルト
        );
        TohyorokuBuilder builder = tohyoroku.createBuilderForAddEdit();
        builder.set投票所設置状況(RString.EMPTY);
        builder.set投票所開設場所(RString.EMPTY);
        builder.set設置期間_開始年月日(FlexibleDate.EMPTY);
        builder.set設置期間_終了年月日(FlexibleDate.EMPTY);
        builder.set開閉時刻_開始(new RTime(開閉時刻));
        builder.set開閉時刻_終了(new RTime(開閉時刻));
        builder.set選管書記人数(0);
        builder.set職員人数(0);
        builder.setその他人数(0);
        return builder.build();
    }

    private boolean save立会人引継情報() {
        Tohyoroku 期日前当日投票録情報 = null;
        if (!is期日前当日投票録存在()) {
            期日前当日投票録情報 = edit期日前当日投票録情報();
        }
        TachiaininHikitsugi tachiaininHikitsugi = edit立会人引継情報_投票立会人_選管();
        int 立会人連番 = tachiaininHikitsugi.get立会人連番();
        List<TachiaininHikitsugi> 投票用紙再交付者リスト = edit立会人引継情報_投票用紙再交付者(立会人連番);
        List<TachiaininHikitsugi> 決定書裁決書リスト = edit立会人引継情報_決定書裁決書(立会人連番);
        TachiaishoSakuseiManager manager = TachiaishoSakuseiManager.createInstance();
        return manager.insert立会人引継情報(期日前当日投票録情報, tachiaininHikitsugi, 投票用紙再交付者リスト, 決定書裁決書リスト);
    }

    private List<TachiaininHikitsugi> edit立会人引継情報_投票用紙再交付者(int 立会人連番) {
        List<TachiaininHikitsugi> list = new ArrayList<>();
        List<dgTachiaishoSaikofusha_Row> 投票用紙再交付者 = div.getDgTachiaishoSaikofusha().getDataSource();
        if (null != 投票用紙再交付者 && !投票用紙再交付者.isEmpty()) {
            int index = 0;
            for (dgTachiaishoSaikofusha_Row row : 投票用紙再交付者) {
                if (!RString.isNullOrEmpty(row.getTxtShimei1().getValue())) {
                    TachiaininHikitsugi tachiainin1 = edit立会人引継情報_再交付者(++index, row.getTxtShimei1().getValue(), 立会人連番);
                    list.add(tachiainin1);
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei2().getValue())) {
                    TachiaininHikitsugi tachiainin2 = edit立会人引継情報_再交付者(++index, row.getTxtShimei2().getValue(), 立会人連番);
                    list.add(tachiainin2);
                }
            }
        }
        return list;
    }

    private List<TachiaininHikitsugi> edit立会人引継情報_決定書裁決書(int 立会人連番) {
        List<TachiaininHikitsugi> list = new ArrayList<>();
        List<dgTohyorokuShimeiNyuryoku_Row> 決定書裁決書 = div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null != 決定書裁決書 && !決定書裁決書.isEmpty()) {
            int index = 0;
            for (dgTohyorokuShimeiNyuryoku_Row row : 決定書裁決書) {
                if (!RString.isNullOrEmpty(row.getTxtShimei1().getValue())) {
                    TachiaininHikitsugi tachiainin1 = edit立会人引継情報_決定書判決書(++index, row.getTxtShimei1().getValue(), 立会人連番);
                    list.add(tachiainin1);
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei2().getValue())) {
                    TachiaininHikitsugi tachiainin2 = edit立会人引継情報_決定書判決書(++index, row.getTxtShimei2().getValue(), 立会人連番);
                    list.add(tachiainin2);
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei3().getValue())) {
                    TachiaininHikitsugi tachiainin3 = edit立会人引継情報_決定書判決書(++index, row.getTxtShimei3().getValue(), 立会人連番);
                    list.add(tachiainin3);
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei4().getValue())) {
                    TachiaininHikitsugi tachiainin4 = edit立会人引継情報_決定書判決書(++index, row.getTxtShimei4().getValue(), 立会人連番);
                    list.add(tachiainin4);
                }
            }
        }
        return list;
    }

    private TachiaininHikitsugi edit立会人引継情報_投票立会人_選管() {
        ShohonNo 抄本番号_立会人 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_立会人 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_立会人 = 選挙_立会人.split(横線.toString());
        SenkyoNo 選挙番号_立会人 = new SenkyoNo(list_選挙_立会人.get(0));
        FlexibleDate 報告年月日_立会人 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_立会人 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_立会人 = 施設_立会人.split(横線.toString());
        RString 施設コード_立会人 = list_施設_立会人.get(0);
        TachiaininHikitsugi tachiaininHikitsugi = new TachiaininHikitsugi(
                抄本番号_立会人,
                選挙番号_立会人,
                報告年月日_立会人,
                施設コード_立会人,
                投票区コード_デフォルト,
                getMAX連番(new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode())) + 1,
                new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode()),
                1);
        TachiaininHikitsugiBuilder bulider = tachiaininHikitsugi.createBuilderForEdit();
        bulider.set党派(div.getTxtToha().getValue());
        bulider.set立会時間_開始時刻(div.getTxtTachiaiTimeRange().getFromValue());
        bulider.set立会時間_終了時刻(div.getTxtTachiaiTimeRange().getToValue());
        bulider.set氏名(div.getTxtTachiaininShimei().getDomain());
        if (1 == div.getRadIjoAriFlag().getSelectedIndex()) {
            bulider.set異常内容(div.getTxtIjoNaiyo().getValue());
            bulider.set異常有フラグ(true);
        } else {
            bulider.set異常内容(RString.EMPTY);
            bulider.set異常有フラグ(false);
        }
        return bulider.build();
    }

    private TachiaininHikitsugi edit立会人引継情報_再交付者(int 連番, RString 氏名, int 立会人連番) {
        ShohonNo 抄本番号_再交付者 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_再交付者 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_再交付者 = 選挙_再交付者.split(横線.toString());
        SenkyoNo 選挙番号_再交付者 = new SenkyoNo(list_選挙_再交付者.get(0));
        FlexibleDate 報告年月日_再交付者 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_再交付者 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_再交付者 = 施設_再交付者.split(横線.toString());
        RString 施設コード_再交付者 = list_施設_再交付者.get(0);
        TachiaininHikitsugi tachiaininHikitsugi = new TachiaininHikitsugi(
                抄本番号_再交付者,
                選挙番号_再交付者,
                報告年月日_再交付者,
                施設コード_再交付者,
                投票区コード_デフォルト,
                立会人連番,
                new Code(TohyorokuKomokuShurui.再交付者.getCode()),
                連番);
        TachiaininHikitsugiBuilder bulider = tachiaininHikitsugi.createBuilderForEdit();
        bulider.set党派(RString.EMPTY);
        bulider.set立会時間_開始時刻(new RTime(開閉時刻));
        bulider.set立会時間_終了時刻(new RTime(開閉時刻));
        bulider.set氏名(new AtenaMeisho(氏名));
        bulider.set異常内容(RString.EMPTY);
        bulider.set異常有フラグ(false);
        return bulider.build();
    }

    private TachiaininHikitsugi edit立会人引継情報_決定書判決書(int 連番, RString 氏名, int 立会人連番) {
        ShohonNo 抄本番号_決定書判決書 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString 選挙_決定書判決書 = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_選挙_決定書判決書 = 選挙_決定書判決書.split(横線.toString());
        SenkyoNo 選挙番号_決定書判決書 = new SenkyoNo(list_選挙_決定書判決書.get(0));
        FlexibleDate 報告年月日_決定書判決書 = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString 施設_決定書判決書 = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設_決定書判決書 = 施設_決定書判決書.split(横線.toString());
        RString 施設コード_決定書判決書 = list_施設_決定書判決書.get(0);
        TachiaininHikitsugi tachiainin = new TachiaininHikitsugi(
                抄本番号_決定書判決書,
                選挙番号_決定書判決書,
                報告年月日_決定書判決書,
                施設コード_決定書判決書,
                投票区コード_デフォルト,
                立会人連番,
                new Code(TohyorokuKomokuShurui.決定書_判決書.getCode()),
                連番);
        TachiaininHikitsugiBuilder bulider = tachiainin.createBuilderForEdit();
        bulider.set党派(RString.EMPTY);
        bulider.set立会時間_開始時刻(new RTime(開閉時刻));
        bulider.set立会時間_終了時刻(new RTime(開閉時刻));
        bulider.set氏名(new AtenaMeisho(氏名));
        bulider.set異常内容(RString.EMPTY);
        bulider.set異常有フラグ(false);
        return bulider.build();
    }

    private int getMAX連番(Code code) {
        TachiaininHikitsugiManager manager = TachiaininHikitsugiManager.createInstance();
        TachiaininHikitsugi tachiaininHikitsugi;
        int 連番;
        if (TohyorokuKomokuShurui.投票立会人_選管.getCode().equals(code.getKey())) {
            tachiaininHikitsugi = manager.getMAX立会人連番(code);
            if (null == tachiaininHikitsugi || null == tachiaininHikitsugi.toEntity()) {
                return 0;
            }
            連番 = tachiaininHikitsugi.toEntity().getTachiaininRenban();
        } else {
            tachiaininHikitsugi = manager.getMAX連番(code);
            if (null == tachiaininHikitsugi || null == tachiaininHikitsugi.toEntity()) {
                return 0;
            }
            連番 = tachiaininHikitsugi.toEntity().getRenban();
        }
        return 連番;
    }

    private boolean delete立会人引継情報(TachiaininHikitsugi 立会人引継情報, ArrayList<TachiaininHikitsugi> 投票用紙再交付者情報リスト) {
        List<TachiaininHikitsugi> 決定書裁決書情報リスト = get決定書裁決書情報(立会人引継情報.get立会人連番());
        TachiaishoSakuseiManager manager = TachiaishoSakuseiManager.createInstance();
        return manager.delete立会人引継情報(立会人引継情報, 投票用紙再交付者情報リスト, 決定書裁決書情報リスト);
    }

    private List<TachiaininHikitsugi> get決定書裁決書情報(int 立会人連番) {
        TachiaininHikitsugiManager manager = TachiaininHikitsugiManager.createInstance();
        Code 投票録項目種類 = new Code(TohyorokuKomokuShurui.決定書_判決書.getCode());
        ShohonNo shohon = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        RString senkyo = div.getDdlSenkyoName().getSelectedKey();
        List<RString> list_決定書裁決書 = senkyo.split(横線.toString());
        SenkyoNo senkyoNo = new SenkyoNo(list_決定書裁決書.get(0));
        FlexibleDate date = new FlexibleDate(div.getTxtTohyoYMDJoken().getValue().toDateString());
        RString shisetsu = div.getDdlShisetsu().getSelectedKey();
        List<RString> list_施設 = shisetsu.split(横線.toString());
        RString 施設コード = list_施設.get(0);
        return manager.get立会人引継情報With投票状況(shohon, senkyoNo, date, 施設コード, TohyoJokyo.期日前.getCode(), 投票録項目種類, new RString(立会人連番));
    }

    private boolean update立会人引継情報(TachiaininHikitsugi 元立会人引継情報, ArrayList<TachiaininHikitsugi> 元投票用紙再交付者情報リスト) {
        List<TachiaininHikitsugi> 元決定書裁決書情報リスト = get決定書裁決書情報(元立会人引継情報.get立会人連番());
        Tohyoroku 期日前当日投票録 = null;
        if (!is期日前当日投票録存在()) {
            期日前当日投票録 = edit期日前当日投票録情報();
        }
        TachiaininHikitsugi 立会人引継情報 = edit立会人引継情報_投票立会人_選管();
        int 立会人連番 = 立会人引継情報.get立会人連番();
        List<TachiaininHikitsugi> 投票用紙再交付者 = edit立会人引継情報_投票用紙再交付者(立会人連番);
        List<TachiaininHikitsugi> 決定書裁決書 = edit立会人引継情報_決定書裁決書(立会人連番);
        TachiaishoSakuseiManager manager = TachiaishoSakuseiManager.createInstance();
        return manager.update立会人引継情報(元立会人引継情報, 元投票用紙再交付者情報リスト, 元決定書裁決書情報リスト,
                期日前当日投票録, 立会人引継情報, 投票用紙再交付者, 決定書裁決書);
    }

    /**
     * 投票用紙再交付者編集処理
     *
     * @return 投票用紙再交付者
     */
    public ArrayList<TachiaishoSakuseiResult> edit投票用紙再交付者() {
        ArrayList<TachiaishoSakuseiResult> list = new ArrayList<>();
        List<dgTachiaishoSaikofusha_Row> 投票用紙再交付者 = div.getDgTachiaishoSaikofusha().getDataSource();
        if (null != 投票用紙再交付者 && !投票用紙再交付者.isEmpty()) {
            for (dgTachiaishoSaikofusha_Row row : 投票用紙再交付者) {
                TachiaishoSakuseiResult result = new TachiaishoSakuseiResult();
                result.set氏名１(row.getTxtShimei1().getValue());
                result.set氏名２(row.getTxtShimei2().getValue());
                list.add(result);
            }
        }
        return list;
    }

    /**
     * 決定書または裁決書により投票をした者編集処理
     *
     * @return 決定書または裁決書により投票をした者
     */
    public ArrayList<TachiaishoSakuseiResult> edit決定書または裁決書により投票をした者() {
        ArrayList<TachiaishoSakuseiResult> list = new ArrayList<>();
        List<dgTohyorokuShimeiNyuryoku_Row> 決定書または裁決書により投票をした者 = div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null != 決定書または裁決書により投票をした者 && !決定書または裁決書により投票をした者.isEmpty()) {
            for (dgTohyorokuShimeiNyuryoku_Row row : 決定書または裁決書により投票をした者) {
                TachiaishoSakuseiResult result = new TachiaishoSakuseiResult();
                result.set氏名１(row.getTxtShimei1().getValue());
                result.set氏名２(row.getTxtShimei2().getValue());
                result.set氏名３(row.getTxtShimei3().getValue());
                result.set氏名４(row.getTxtShimei4().getValue());
                list.add(result);
            }
        }
        return list;
    }

    /**
     * 投票用紙再交付者情報を取得する
     *
     * @return 投票用紙再交付者情報
     */
    public List<RString> get投票用紙再交付者情報() {
        List<RString> list = new ArrayList<>();
        List<dgTachiaishoSaikofusha_Row> source = div.getDgTachiaishoSaikofusha().getDataSource();
        if (null != source && !source.isEmpty()) {
            for (dgTachiaishoSaikofusha_Row saikofusha : source) {
                if (!RString.isNullOrEmpty(saikofusha.getTxtShimei1().getValue())) {
                    list.add(saikofusha.getTxtShimei1().getValue());
                }
                if (!RString.isNullOrEmpty(saikofusha.getTxtShimei2().getValue())) {
                    list.add(saikofusha.getTxtShimei2().getValue());
                }
            }
        }
        return list;
    }

    /**
     * 決定書または裁決書により投票をした者情報を取得する
     *
     * @return 決定書または裁決書により投票をした者情報
     */
    public List<RString> get決定書または裁決書により投票をした者情報() {
        List<RString> list = new ArrayList<>();
        List<dgTohyorokuShimeiNyuryoku_Row> source = div.getCcdTachiaishoKetteisho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null != source && !source.isEmpty()) {
            for (dgTohyorokuShimeiNyuryoku_Row shimei : source) {
                if (!RString.isNullOrEmpty(shimei.getTxtShimei1().getValue())) {
                    list.add(shimei.getTxtShimei1().getValue());
                }
                if (!RString.isNullOrEmpty(shimei.getTxtShimei2().getValue())) {
                    list.add(shimei.getTxtShimei2().getValue());
                }
                if (!RString.isNullOrEmpty(shimei.getTxtShimei3().getValue())) {
                    list.add(shimei.getTxtShimei3().getValue());
                }
                if (!RString.isNullOrEmpty(shimei.getTxtShimei4().getValue())) {
                    list.add(shimei.getTxtShimei4().getValue());
                }
            }
        }
        return list;
    }

    /**
     * 不在者投票の用紙及び封筒を返還して投票した者情報を取得する
     *
     * @return 不在者投票の用紙及び封筒を返還して投票した者情報
     */
    public List<RString> get不在者投票の用紙及び封筒を返還して投票した者情報() {
        List<RString> list = new ArrayList<>();
        List<dgTohyorokuShimeiNyuryoku_Row> source = div.getCcdTachiaishoHenkan().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null != source && !source.isEmpty()) {
            for (dgTohyorokuShimeiNyuryoku_Row tohyoroku : source) {
                if (!RString.isNullOrEmpty(tohyoroku.getTxtShimei1().getValue())) {
                    list.add(tohyoroku.getTxtShimei1().getValue());
                }
                if (!RString.isNullOrEmpty(tohyoroku.getTxtShimei2().getValue())) {
                    list.add(tohyoroku.getTxtShimei2().getValue());
                }
                if (!RString.isNullOrEmpty(tohyoroku.getTxtShimei3().getValue())) {
                    list.add(tohyoroku.getTxtShimei3().getValue());
                }
                if (!RString.isNullOrEmpty(tohyoroku.getTxtShimei4().getValue())) {
                    list.add(tohyoroku.getTxtShimei4().getValue());
                }
            }
        }
        return list;
    }

    /**
     * 点字により投票をした者情報を取得する
     *
     * @return 点字により投票をした者情報
     */
    public List<RString> get点字により投票をした者情報() {
        List<RString> list = new ArrayList<>();
        List<dgTohyorokuShimeiNyuryoku_Row> source = div.getCcdTachiaishoTenji().getDgTohyorokuShimeiNyuryoku().getDataSource();
        if (null != source && !source.isEmpty()) {
            for (dgTohyorokuShimeiNyuryoku_Row row : source) {
                if (!RString.isNullOrEmpty(row.getTxtShimei1().getValue())) {
                    list.add(row.getTxtShimei1().getValue());
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei2().getValue())) {
                    list.add(row.getTxtShimei2().getValue());
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei3().getValue())) {
                    list.add(row.getTxtShimei3().getValue());
                }
                if (!RString.isNullOrEmpty(row.getTxtShimei4().getValue())) {
                    list.add(row.getTxtShimei4().getValue());
                }
            }
        }
        return list;
    }

    /**
     * 代理投票をした者情報を取得する
     *
     * @return 代理投票をした者情報
     */
    public List<RString> get代理投票をした者情報() {
        List<RString> list = new ArrayList<>();
        List<dgTohyorokuDairiTohyosha_Row> source = div.getCcdTachiaishoDairi().getDgTohyorokuDairiTohyosha().getDataSource();
        if (null != source && !source.isEmpty()) {
            for (dgTohyorokuDairiTohyosha_Row row : source) {
                if (!RString.isNullOrEmpty(row.getTxtShimei())) {
                    list.add(row.getTxtShimei());
                }
            }
        }
        return list;

    }

    /**
     * 投票拒否の決定をした者情報を取得する
     *
     * @return 投票拒否の決定をした者情報
     */
    public List<RString> get投票拒否の決定をした者情報() {
        List<RString> list = new ArrayList<>();
        List<dgTohyorokuKyohiNyuryoku_Row> source = div.getCcdTachiaishoKyohiKettei().getDgTohyorokuKyohiNyuryoku().getDataSource();
        if (null != source && !source.isEmpty()) {
            for (dgTohyorokuKyohiNyuryoku_Row row : source) {
                if (!RString.isNullOrEmpty(row.getTxtShimei())) {
                    list.add(row.getTxtShimei());
                }
            }
        }
        return list;
    }
}
