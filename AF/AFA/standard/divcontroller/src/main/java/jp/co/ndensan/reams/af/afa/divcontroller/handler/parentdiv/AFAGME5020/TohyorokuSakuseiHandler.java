/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.Tohyoroku;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.TohyorokuBuilder;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugi;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui.TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui.TohyorokuFuzuiBuilder;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.TohyorokuGamen;
import jp.co.ndensan.reams.af.afa.definition.core.TohyouSha;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyorokuKomokuShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo.SenkyoninMeiboPsmMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo.TohyojokyoMapperParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.dgTohyorokuDairiTohyosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.dgTohyorokuKyohiNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.dgTohyorokuShimeiNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.TohyorokuSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.TohyorokuSakuseiJokenDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.TohyorokuShosaiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.dgTohyorokuSaikofusha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.dgTohyorokuTachiaininKanrisha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020.dgTohyorokuTachiaininSenkan_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyojo.TohyojoFinder;
import jp.co.ndensan.reams.af.afa.service.core.tohyoku.TohyokuManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.TohyorokuManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugiManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tohyorokufuzui.TohyorokuFuzuiManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tohyorokufuzui.TohyorokuFuzuiManager.OrderTohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE301.TojitsuTohyorokuPrinter;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE506.KijitsumaeTohyorokuOneMaiPrinter;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE506.KijitsumaeTohyorokuThreeMaiPrinter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.AssociationKey;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.TohyokuFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.Order;

/**
 * AFAGME5020 投票受付　投票録作成のhandler
 *
 * @reamsid_L AF-0130-010 lit
 */
public class TohyorokuSakuseiHandler {

    private final TohyorokuSakuseiDiv div;
    private final TohyorokuSakuseiJokenDiv jokenDiv;
    private final TohyorokuShosaiDiv shosaiDiv;
    private static final RString 投票日TEXT_期日前投票日 = new RString("期日前投票日");
    private static final RString DEFAULT_施設コード = new RString("0000");
    private static final RString DEFAULT_投票区コード = new RString("0000");
    private static final RString 性別女 = new RString("2");
    private static final RString 性別男 = new RString("1");
    private static final int 投票立会人_選任_行数 = 5;
    private static final int 投票立会人_投票管理者_行数 = 3;
    private static final int 投票立会人_再交付者_行数 = 2;
    private static final int 決定書または裁決書投票者_毎行_投票者数 = 4;
    private static final RTime DEFAULT_開始時刻 = new RTime(new RString("08:00"));
    private static final RTime DEFAULT_終了時刻 = new RTime(new RString("20:00"));
    private static final RString 法第63条の投票の拒否 = new RString("法第63条の投票の拒否");
    private static final RString 法第50条の投票の拒否 = new RString("法第50条の投票の拒否");
    private static final RString 法第59条の代理投票の拒否 = new RString("法第59条の代理投票の拒否");
    private static final RString 法第48条の代理投票の拒否 = new RString("法第48条の代理投票の拒否");
    private static final RString パタン_法1 = new RString("法1");
    private static final RString 法1_NO63 = new RString("63");
    private static final RString 法1_NO50 = new RString("50");
    private static final RString パタン_法2 = new RString("法2");
    private static final RString 法2_NO59 = new RString("59");
    private static final RString 法2_NO48 = new RString("48");
    private static final RString 法3_NO61 = new RString("61");
    private static final RString 法3_NO49 = new RString("49");
    private static final RString パタン_決定投票者 = new RString("決定投票者");
    private static final RString パタン_返還者 = new RString("返還者");
    private static final RString 種類タイトル_投票人 = new RString("投票人");
    private static final RString 種類タイトル_選挙人 = new RString("選挙人");
    private static final RTime 更新用時間初期値 = new RTime(new RString("00:00"));

    /**
     * 投票受付　投票録作成Enum
     */
    public enum TohyorokuSakuseiEnum {

        /**
         * 投票録画面対象Key
         */
        投票録画面対象Key(new RString("投票録画面対象Key")),
        /**
         * 投票録
         */
        投票録(new RString("投票録")),
        /**
         * 投票立会人
         */
        投票立会人(new RString("投票立会人")),
        /**
         * 投票管理者
         */
        投票管理者(new RString("投票管理者")),
        /**
         * 再交付者
         */
        再交付者(new RString("再交付者")),
        /**
         * 決定書または裁決書投票者
         */
        決定書または裁決書投票者(new RString("決定書または裁決書投票者"));

        private final RString key;

        TohyorokuSakuseiEnum(RString key) {
            this.key = key;
        }

        RString getKey() {
            return this.key;
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div 投票録作成Div
     */
    public TohyorokuSakuseiHandler(TohyorokuSakuseiDiv div) {
        this.div = div;
        this.shosaiDiv = div.getTohyorokuShosai();
        this.jokenDiv = div.getTohyorokuSakuseiJoken();
    }

    /**
     * 画面初期化。
     *
     * @param flg 設定フラグ true:初期化値を設定する｜false:初期化値を設定しない。
     * @return 初期化結果
     */
    public boolean initialize(boolean flg) {
        if (loadJoken(flg)) {
            loadShosai();
        } else {
            return false;
        }
        return true;
    }

    /**
     * 「投票録を表示する」ボタンのイベントメソッドです。
     *
     * @return TohyorokuSaveData
     */
    public TohyorokuSaveData setDataShosai() {
        clearShosaiPanel();
        editText();
        editShosaiDisplayMode(true);
        editResearchToSaveButtonDisplayMode(true);
        editJokenDivMode(false);
        shosaiDiv.getCcdTohyorokuHenkanTohyosha().setEditMode(false);
        return createDataSourceAndSetData();
    }

    /**
     * 帳票印刷
     */
    public void print() {
        TohyorokuChohyo item = createItemFromGamen();
        if (AFAMenuId.AFAMNE5020_投票録.menuId().equals(ViewState.getメニューID())) {
            printKijitsumaeTohyoroku(item);
        } else if (AFAMenuId.AFAMNE3020_当日投票録.menuId().equals(ViewState.getメニューID())) {
            RString 投票録_出力様式_当日値 = BusinessConfig.get(ConfigKeysAFA.投票録_出力様式_当日);
            if (AFAConfigKeysValue.投票録_出力様式_当日_当日投票録.isEqual(投票録_出力様式_当日値)) {
                setTojitsuItemFromGamen(item);
                new TojitsuTohyorokuPrinter().print(item);
            } else if (AFAConfigKeysValue.投票録_出力様式_当日_期日前投票録.isEqual(投票録_出力様式_当日値)) {
                printKijitsumaeTohyoroku(item);
            }
        }
    }

    private void printKijitsumaeTohyoroku(TohyorokuChohyo item) {
        RString 投票録_出力様式値 = BusinessConfig.get(ConfigKeysAFA.投票録_出力様式);
        if (AFAConfigKeysValue.投票録_出力様式_1枚タイプ.isEqual(投票録_出力様式値)) {
            new KijitsumaeTohyorokuOneMaiPrinter().print(item);
        } else if (AFAConfigKeysValue.投票録_出力様式_甲乙丙の3枚タイプ.isEqual(投票録_出力様式値)) {
            new KijitsumaeTohyorokuThreeMaiPrinter().print(item);
        }
    }

    private void editJokenDivMode(boolean flg) {
        jokenDiv.setIsOpen(flg);
        jokenDiv.setDisabled(!flg);
    }

    private boolean loadJoken(boolean flg) {

        ViewState.setメニューID(ResponseHolder.getMenuID());

        editJokenDisplayMode();

        if (flg) {
            jokenDiv.getCcdShohonNameList().initialize();
            if (jokenDiv.getCcdShohonNameList().getShohonListSize() == 0) {
                jokenDiv.getCcdShohonNameList().setChkKakoShohonCheckMode(true);
                jokenDiv.getCcdShohonNameList().click_chkKakoShohon();
                jokenDiv.getCcdShohonNameList().initialize();

                //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 1 LINES
                if (jokenDiv.getCcdShohonNameList().getShohonListSize() == 0) {
                    return false;
                }
                jokenDiv.getCcdShohonNameList().selectedShohon(jokenDiv.getCcdShohonNameList().get一番近い過去抄本番号());

            }
            setDataJokenWithoutShohonNo();
            setDataJokenByShohonNo();
        }

        editResearchToSaveButtonDisplayMode(false);
        return true;
    }

    /**
     * 条件エリアのデータを設定する。
     */
    public void changeShohonName() {
        jokenDiv.getCcdShohonNameList().changeDdlShohon();
        setDataJokenByShohonNo();
        clearShosaiPanel();
        editShosaiDisplayMode(false);
    }

    /**
     * 画面内容変更かどうか。(変更の場合：TRUE、変更しない：FALSE)
     *
     * @param 投票録保存用データ TohyorokuSaveData
     * @return 画面内容変更かどうか
     */
    public boolean checkGamenUpdate(TohyorokuSaveData 投票録保存用データ) {
        TohyorokuGamen 変更前対象 = 投票録保存用データ.get投票録画面対象();
        TohyorokuGamen 変更後対象 = get投票録画面対象();
        return !変更前対象.equals(変更後対象);
    }

    /**
     * 画面の保存処理。
     *
     * @param 投票録保存用データ TohyorokuSaveData
     * @return 保存処理の結果(Success : true、Failer : false)
     */
    public boolean save(TohyorokuSaveData 投票録保存用データ) {
        Tohyoroku 投票録 = 投票録保存用データ.get投票録();
        List<TohyorokuFuzui> 投票立会人リスト = 投票録保存用データ.get投票立会人リスト();
        List<TohyorokuFuzui> 投票管理者リスト = 投票録保存用データ.get投票管理者リスト();
        List<TohyorokuFuzui> 再交付者リスト = 投票録保存用データ.get再交付者リスト();
        List<TohyorokuFuzui> 決定投票者リスト = 投票録保存用データ.get決定投票者リスト();

        List<dgTohyorokuTachiaininSenkan_Row> 投票立会人DataGrid = shosaiDiv.getDgTohyorokuTachiaininSenkan().getDataSource();
        List<dgTohyorokuTachiaininKanrisha_Row> 投票管理者DataGrid = shosaiDiv.getDgTohyorokuTachiaininKanrisha().getDataSource();
        List<dgTohyorokuSaikofusha_Row> 再交付者DataGrid = shosaiDiv.getDgTohyorokuSaikofusha().getDataSource();
        List<dgTohyorokuShimeiNyuryoku_Row> 決定投票者DataGrid = shosaiDiv.getCcdTohyorokuKetteishoSaiketsusho().getDgTohyorokuShimeiNyuryoku().getDataSource();

        ShohonNo 抄本番号 = new ShohonNo(jokenDiv.getCcdShohonNameList().getSelectedShohonNo());
        SenkyoNo 選挙番号 = new SenkyoNo(jokenDiv.getDdlSenkyoName().getSelectedKey());
        FlexibleDate 報告年月日 = convertRdateToFlexibleDate(jokenDiv.getTxtTohyoYMDJoken().getValue());
        RString 施設コード = jokenDiv.getDdlShisetsu().isDisplayNone() ? DEFAULT_施設コード : jokenDiv.getDdlShisetsu().getSelectedKey();
        RString 投票区コード = jokenDiv.getDdlTohyoku().isDisplayNone() ? DEFAULT_投票区コード : jokenDiv.getDdlTohyoku().getSelectedKey();

        投票録 = get投票録更新用(投票録, 抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);
        投票立会人リスト = get投票者リスト更新用(投票立会人リスト, 投票立会人DataGrid, 抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);
        投票管理者リスト = get投票者リスト更新用(投票管理者リスト, 投票管理者DataGrid, 抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);
        再交付者リスト = get投票者リスト更新用(再交付者リスト, 再交付者DataGrid, 抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);
        決定投票者リスト = get決定投票者リスト更新用(決定投票者リスト, 決定投票者DataGrid,
                抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);

        投票立会人リスト.addAll(投票管理者リスト);
        投票立会人リスト.addAll(再交付者リスト);
        投票立会人リスト.addAll(決定投票者リスト);

        return TohyorokuManager.createInstance().save(投票録, 投票立会人リスト);
    }

    /**
     * 選択したの選挙が無投票選挙かどうか
     *
     * @return is無投票選挙
     */
    public boolean is無投票選挙() {
        RString 抄本番号 = jokenDiv.getCcdShohonNameList().getSelectedShohonNo();
        RString 選挙番号 = jokenDiv.getDdlSenkyoName().getSelectedKey();
        Senkyo 選挙 = SenkyoManager.createInstance().get選挙(new ShohonNo(抄本番号), new SenkyoNo(選挙番号));
        return null != 選挙 && 選挙.is無投票選挙フラグ();
    }

    private void setDataJokenWithoutShohonNo() {
        jokenDiv.getTxtTohyoYMDJoken().setValue(RDate.getNowDate());

        if (AFAMenuId.AFAMNE5020_投票録.menuId().equals(ViewState.getメニューID())) {
            setSelectValue(jokenDiv.getDdlShisetsu(), createShisetsuDataSource());
        }
    }

    private void setDataJokenByShohonNo() {
        RString shohonNo = jokenDiv.getCcdShohonNameList().getSelectedShohonNo();
        Shohon 抄本 = null;
        jokenDiv.getDdlSenkyoName().getDataSource().clear();
        if (!shohonNo.isEmpty()) {
            抄本 = ShohonManager.createInstance().get抄本(new ShohonNo(shohonNo));
            setSelectValue(jokenDiv.getDdlSenkyoName(), createSenkyoDataSource(抄本));
        }

        if (AFAMenuId.AFAMNE3020_当日投票録.menuId().equals(ViewState.getメニューID())) {
            setSelectValue(jokenDiv.getDdlTohyoku(), createTohyokuDataSource(抄本));
        }
    }

    private void editJokenDisplayMode() {
        if (AFAMenuId.AFAMNE5020_投票録.menuId().equals(ViewState.getメニューID())) {
            jokenDiv.getTxtTohyoYMDJoken().setLabelLText(投票日TEXT_期日前投票日);
            jokenDiv.getDdlShisetsu().setDisplayNone(false);
            jokenDiv.getDdlTohyoku().setDisplayNone(true);
        } else if (AFAMenuId.AFAMNE3020_当日投票録.menuId().equals(ViewState.getメニューID())) {
            jokenDiv.getDdlShisetsu().setDisplayNone(true);
            jokenDiv.getDdlTohyoku().setDisplayNone(false);
        } else {
            jokenDiv.getDdlShisetsu().setDisplayNone(true);
            jokenDiv.getDdlTohyoku().setDisplayNone(true);
        }
        editJokenDivMode(true);
    }

    private List<KeyValueDataSource> createSenkyoDataSource(Shohon 抄本) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<Senkyo> 選挙リスト = 抄本.getSenkyoList();
        if (null == 選挙リスト) {
            return dataSource;
        }

        Collections.sort(選挙リスト, new Comparator<Senkyo>() {
            @Override
            public int compare(Senkyo o1, Senkyo o2) {
                return o1.get選挙番号().value().compareTo(o2.get選挙番号().value());
            }
        });

        for (Senkyo 選挙 : 選挙リスト) {
            KeyValueDataSource row = new KeyValueDataSource();
            row.setKey(new RString(選挙.get選挙番号().toString()));
            row.setValue(選挙.get選挙名称());
            dataSource.add(row);
        }
        return dataSource;

    }

    private List<KeyValueDataSource> createShisetsuDataSource() {
        List<Shisetsu> 施設リスト = ShisetsuManager.createInstance()
                .get施設By施設種別コードリスト(ShisetsuShubetsu.一般_本庁.getCode(), ShisetsuShubetsu.一般_支所.getCode());
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        if (null == 施設リスト) {
            return dataSource;
        }

        for (Shisetsu 施設 : 施設リスト) {
            KeyValueDataSource row = new KeyValueDataSource();
            row.setKey(施設.get施設コード());
            row.setValue(施設.get施設名称());
            dataSource.add(row);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> createTohyokuDataSource(Shohon 抄本) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        if (null == 抄本) {
            return dataSource;
        }
        if (SenkyoShurui.国政選挙_地方選挙.getCode().equals(抄本.get選挙種類().value())) {
            FlexibleDate 投票日 = convertRdateToFlexibleDate(jokenDiv.getCcdShohonNameList().getSelectedTohyoYMD());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            AssociationKey key = new AssociationKey(地方公共団体.get地方公共団体コード(), 地方公共団体.getLasdecCodeRenban_());
            List<Tohyoku> tohyokuList
                    = TohyokuFinderFactory.createInstance().get投票区by地方公共団体and基準日(key, 投票日);
            if (null != tohyokuList) {
                Collections.sort(tohyokuList, new Comparator<Tohyoku>() {
                    @Override
                    public int compare(Tohyoku o1, Tohyoku o2) {
                        return o1.get投票区コード().value().compareTo(o2.get投票区コード().value());
                    }
                });

                for (Tohyoku 投票区 : tohyokuList) {
                    KeyValueDataSource row = new KeyValueDataSource();
                    row.setKey(投票区.get投票区コード().value());
                    row.setValue(投票区.get漢字名称());
                    dataSource.add(row);
                }
            }
        } else {
            List<jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku> tohyokuList
                    = TohyokuManager.createInstance().get投票区By選挙種類(抄本.get選挙種類());
            if (null != tohyokuList) {
                for (jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku 投票区 : tohyokuList) {
                    KeyValueDataSource row = new KeyValueDataSource();
                    row.setKey(投票区.get投票区コード());
                    row.setValue(投票区.get投票区名());
                    dataSource.add(row);
                }
            }
        }

        return dataSource;
    }

    private void setSelectValue(DropDownList dropdownList, List<KeyValueDataSource> dataSource) {
        dropdownList.getDataSource().clear();
        if (null == dataSource || dataSource.isEmpty()) {
            return;
        }
        dropdownList.setDataSource(dataSource);
        dropdownList.setSelectedIndex(0);
    }

    private void loadShosai() {
        clearShosaiPanel();
        createEmptyDataSource();
        editShosaiDisplayMode(false);
    }

    private void editText() {
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(jokenDiv.getCcdShohonNameList().getSelectedSenkyoShurui().getCode())) {
            shosaiDiv.getLblTohyoKyohi().setText(法第63条の投票の拒否);
            shosaiDiv.getLblDairiTohyoKyohi().setText(法第59条の代理投票の拒否);
        } else {
            shosaiDiv.getLblTohyoKyohi().setText(法第50条の投票の拒否);
            shosaiDiv.getLblDairiTohyoKyohi().setText(法第48条の代理投票の拒否);
        }
    }

    private void editShosaiDisplayMode(boolean flg) {
        div.getTohyorokuShosai().setVisible(flg);
        div.getTohyorokuShosai().setDisplayNone(!flg);
    }

    private void editResearchToSaveButtonDisplayMode(boolean flg) {
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnUpdate"), !flg);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnReSearch"), !flg);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnPrint"), !flg);
    }

    private void clearShosaiPanel() {
        shosaiDiv.getTxtShikkoYMD().clearValue();
        shosaiDiv.getTxtChoseiYMD().setValue(RDate.getNowDate());
        shosaiDiv.getTxtTohyoYMD().clearValue();
        shosaiDiv.getTxtSecchiJokyo().clearValue();
        shosaiDiv.getTxtKaisetsuBasho().clearValue();
        shosaiDiv.getTxtSecchiKikan().clearFromValue();
        shosaiDiv.getTxtSecchiKikan().clearToValue();
        shosaiDiv.getTxtKaiheiStartTime().clearValue();
        shosaiDiv.getTxtKaiheiStopTime().clearValue();
        shosaiDiv.getTxtTohyoshaOtoko().clearValue();
        shosaiDiv.getTxtTohyoshaOnna().clearValue();
        shosaiDiv.getTxtTohyoshaKei().clearValue();
        shosaiDiv.getTxtKariTohyoshaOtoko().clearValue();
        shosaiDiv.getTxtKariTohyoshaOnna().clearValue();
        shosaiDiv.getTxtKariTohyoshaKei().clearValue();
        shosaiDiv.getTxtTenjiNinzu().clearValue();
        shosaiDiv.getTxtDairiNinzu().clearValue();
        shosaiDiv.getTxtJimuNinzu().clearValue();
        shosaiDiv.getTxtShokiNinzu().clearValue();
        shosaiDiv.getTxtShokuinNinzu().clearValue();
        shosaiDiv.getTxtSonotaNinzu().clearValue();

        clearDataSource();

    }

    private void createEmptyDataSource() {
        shosaiDiv.getDgTohyorokuTachiaininSenkan().setDataSource(createEmptyDataSourceTachiaininSenkan());
        shosaiDiv.getDgTohyorokuTachiaininKanrisha().setDataSource(createEmptyDataSourceTachiaininKanrisha());
        shosaiDiv.getDgTohyorokuSaikofusha().setDataSource(createEmptyDataSourceSaikofusha());
        shosaiDiv.getCcdTohyorokuKetteishoSaiketsusho().load(2);
        shosaiDiv.getCcdTohyorokuHenkanTohyosha().load(2);
        final int three = 3;
        shosaiDiv.getCcdTohyorokuTohyoKyohi().load(three);
        shosaiDiv.getCcdTohyorokuDairiTohyoKyohi().load(three);
    }

    private List<dgTohyorokuTachiaininSenkan_Row> createEmptyDataSourceTachiaininSenkan() {
        List<dgTohyorokuTachiaininSenkan_Row> dataSource = new ArrayList<>();
        for (int i = 1; i <= 投票立会人_選任_行数; i++) {
            dgTohyorokuTachiaininSenkan_Row row = new dgTohyorokuTachiaininSenkan_Row();
            row.setTxtToha(new TextBox());
            row.setTxtShimei(new TextBox());
            row.setTxtSenninYMD(new TextBoxFlexibleDate());
            row.setTxtTachiaiStartTime(new TextBoxTime());
            row.setTxtTachiaiStopTime(new TextBoxTime());
            row.setTxtSankaiTime(new TextBoxTime());
            row.setTxtJishokuTime(new TextBoxTime());
            row.setTxtJiyu(new TextBox());
            dataSource.add(row);
        }
        return dataSource;
    }

    private List<dgTohyorokuTachiaininKanrisha_Row> createEmptyDataSourceTachiaininKanrisha() {
        List<dgTohyorokuTachiaininKanrisha_Row> dataSource = new ArrayList<>();

        for (int i = 1; i <= 投票立会人_投票管理者_行数; i++) {
            dgTohyorokuTachiaininKanrisha_Row row = new dgTohyorokuTachiaininKanrisha_Row();
            row.setTxtToha(new TextBox());
            row.setTxtShimei(new TextBox());
            row.setTxtSankaiTime(new TextBoxTime());
            dataSource.add(row);
        }
        return dataSource;
    }

    private List<dgTohyorokuSaikofusha_Row> createEmptyDataSourceSaikofusha() {
        List<dgTohyorokuSaikofusha_Row> dataSource = new ArrayList<>();

        for (int i = 1; i <= 投票立会人_再交付者_行数; i++) {
            dgTohyorokuSaikofusha_Row row = new dgTohyorokuSaikofusha_Row();
            row.setTxtShimei(new TextBox());
            row.setTxtJiyu(new TextBox());
            dataSource.add(row);
        }
        return dataSource;
    }

    private void clearDataSource() {
        clearDataSourceTachiaininSenkan();
        clearDataSourceTachiaininKanrisha();
        clearDataSourceSaikofusha();

        shosaiDiv.getCcdTohyorokuKetteishoSaiketsusho().clearData();
        shosaiDiv.getCcdTohyorokuHenkanTohyosha().clearData();
        shosaiDiv.getCcdTohyorokuTohyoKyohi().clearData();
        shosaiDiv.getCcdTohyorokuDairiTohyoKyohi().clearData();
    }

    private void clearDataSourceTachiaininSenkan() {
        List<dgTohyorokuTachiaininSenkan_Row> dataSource = shosaiDiv.getDgTohyorokuTachiaininSenkan().getDataSource();
        if (null != dataSource) {
            for (dgTohyorokuTachiaininSenkan_Row row : dataSource) {
                row.getTxtToha().clearValue();
                row.getTxtShimei().clearValue();
                row.getTxtSenninYMD().clearValue();
                row.getTxtTachiaiStartTime().clearValue();
                row.getTxtTachiaiStopTime().clearValue();
                row.getTxtSankaiTime().clearValue();
                row.getTxtJishokuTime().clearValue();
                row.getTxtJiyu().clearValue();
            }
        }
    }

    private void clearDataSourceTachiaininKanrisha() {
        List<dgTohyorokuTachiaininKanrisha_Row> dataSource = shosaiDiv.getDgTohyorokuTachiaininKanrisha().getDataSource();
        if (null != dataSource) {
            for (dgTohyorokuTachiaininKanrisha_Row row : dataSource) {
                row.getTxtToha().clearValue();
                row.getTxtShimei().clearValue();
                row.getTxtSankaiTime().clearValue();
            }
        }
    }

    private void clearDataSourceSaikofusha() {
        List<dgTohyorokuSaikofusha_Row> dataSource = shosaiDiv.getDgTohyorokuSaikofusha().getDataSource();
        if (null != dataSource) {
            for (dgTohyorokuSaikofusha_Row row : dataSource) {
                row.getTxtShimei().clearValue();
                row.getTxtJiyu().clearValue();
            }
        }
    }

    private TohyorokuSaveData createDataSourceAndSetData() {
        ShohonNo 抄本番号 = new ShohonNo(jokenDiv.getCcdShohonNameList().getSelectedShohonNo());
        SenkyoNo 選挙番号 = new SenkyoNo(jokenDiv.getDdlSenkyoName().getSelectedKey());
        FlexibleDate 報告年月日 = convertRdateToFlexibleDate(jokenDiv.getTxtTohyoYMDJoken().getValue());
        RString 投票状況 = RString.EMPTY;
        RString 施設コード = RString.EMPTY;
        RString 投票区コード = RString.EMPTY;
        RString 施設コードinitial = RString.EMPTY;
        RString 投票区コードinitial = RString.EMPTY;
        Code 投票録項目種類;
        Code 期日前不在者区分 = Code.EMPTY;
        boolean use選挙人名簿 = false;
        OrderTohyorokuFuzui 順種類;
        List<Order> orderAsc;
        TohyorokuManager 投票録情報Manager = TohyorokuManager.createInstance();
        TohyoJokyoManager 投票状況Manager = TohyoJokyoManager.createInstance();
        TohyorokuFuzuiManager 投票録付随情報Manager = TohyorokuFuzuiManager.createInstance();
        TachiaininHikitsugiManager 立会人引継情報Manager = TachiaininHikitsugiManager.createInstance();
        List<TohyorokuFuzui> 投票立会人選管リスト;
        List<TachiaininHikitsugi> 投票立会人選管リスト2 = new ArrayList<>();
        List<TohyorokuFuzui> 投票立会人投票管理者リスト;
        List<TohyorokuFuzui> 再交付者リスト;
        List<RString> 再交付者リスト2 = new ArrayList<>();
        TohyojokyoMapperParameter tohyojokyoMapperParameter;
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));

        if (AFAMenuId.AFAMNE5020_投票録.menuId().equals(ViewState.getメニューID())) {
            施設コード = jokenDiv.getDdlShisetsu().getSelectedKey();
            施設コードinitial = jokenDiv.getDdlShisetsu().getSelectedKey();
            投票区コード = DEFAULT_投票区コード;
            投票状況 = TohyoJokyo.期日前.getCode();
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.期日前投票.value());
            use選挙人名簿 = false;
        } else if (AFAMenuId.AFAMNE3020_当日投票録.menuId().equals(ViewState.getメニューID())) {
            施設コード = DEFAULT_施設コード;
            投票区コード = jokenDiv.getDdlTohyoku().getSelectedKey();
            投票区コードinitial = jokenDiv.getDdlTohyoku().getSelectedKey();
            投票状況 = TohyoJokyo.当日.getCode();
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.当日投票.value());
            use選挙人名簿 = true;
        }

        // 2.　1　期日前・当日投票録情報取得
        Tohyoroku 投票録 = 投票録情報Manager.
                get投票録ByKey(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);

        // 2.　2　投票録付随情報取得
        // 2.2.1　投票立会人（選管）の場合
        順種類 = OrderTohyorokuFuzui.選管順;
        orderAsc = Arrays.asList(Order.ASC);
        投票録項目種類 = new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode());
        投票立会人選管リスト = 投票録付随情報Manager.
                get投票録付随情報WithOrderBy(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 順種類, orderAsc);
        if (AFAMenuId.AFAMNE5020_投票録.menuId().equals(ViewState.getメニューID())
                && (null == 投票立会人選管リスト || 投票立会人選管リスト.isEmpty())) {
            投票立会人選管リスト2
                    = 立会人引継情報Manager.get立会人引継情報(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類);
        }

        // 2.2.2　投票立会人（投票管理者）の場合
        順種類 = OrderTohyorokuFuzui.管理者順;
        orderAsc = Arrays.asList(Order.ASC, Order.ASC, Order.ASC, Order.ASC);
        投票録項目種類 = new Code(TohyorokuKomokuShurui.投票立会人_投票管理者.getCode());
        投票立会人投票管理者リスト = 投票録付随情報Manager.
                get投票録付随情報WithOrderBy(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 順種類, orderAsc);

        // 2.2.3　再交付者の場合
        順種類 = OrderTohyorokuFuzui.再交付者順;
        orderAsc = Arrays.asList(Order.ASC, Order.ASC, Order.ASC);
        投票録項目種類 = new Code(TohyorokuKomokuShurui.再交付者.getCode());
        再交付者リスト = 投票録付随情報Manager.
                get投票録付随情報WithOrderBy(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 順種類, orderAsc);
        if (AFAMenuId.AFAMNE5020_投票録.menuId().equals(ViewState.getメニューID())
                && (null == 再交付者リスト || 再交付者リスト.isEmpty())) {
            再交付者リスト2
                    = 立会人引継情報Manager.get立会人引継情報氏名リスト(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類);
        }

        // 2.2.4　決定書・判決書の場合
        投票録項目種類 = new Code(TohyorokuKomokuShurui.決定書_判決書.getCode());
        shosaiDiv.getCcdTohyorokuKetteishoSaiketsusho()
                .initialize(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況, 投票録項目種類, RString.EMPTY);

        // 2.2.5　用紙返還の場合
        投票録項目種類 = new Code(TohyorokuKomokuShurui.用紙返還.getCode());
        shosaiDiv.getCcdTohyorokuHenkanTohyosha()
                .initialize(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況, 投票録項目種類, RString.EMPTY);

        // 2.3.4　代理投票者
        shosaiDiv.getCcdTohyorokuDairiTohyosha().initialize(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況);
        // 2.3.5　第50条の投票の拒否
        shosaiDiv.getCcdTohyorokuTohyoKyohi().initialize(抄本番号, 選挙番号, 報告年月日, false, 施設コードinitial, 投票区コードinitial, 投票状況);
        // 2.3.6　第48条の投票の拒否
        shosaiDiv.getCcdTohyorokuDairiTohyoKyohi()
                .initialize(抄本番号, 選挙番号, 報告年月日, true, 施設コードinitial, 投票区コードinitial, 投票状況);

        // 2.　3　投票状況情報取得
        // 2.3.3　点字により投票をした者数
        tohyojokyoMapperParameter = TohyojokyoMapperParameter
                .createParam(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, RString.EMPTY,
                        RString.EMPTY, 期日前不在者区分, use選挙人名簿, key.getPSM検索キー());
        int 点字により投票者数 = 投票状況Manager.get点字により投票者数(tohyojokyoMapperParameter);
        // 2.3.1　投票の状況－投票者
        tohyojokyoMapperParameter = TohyojokyoMapperParameter
                .createParam(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況,
                        性別男, 期日前不在者区分, use選挙人名簿, key.set性別(Gender.MALE).getPSM検索キー());
        int 男投票者数 = 投票状況Manager.get投票者数(tohyojokyoMapperParameter);
        tohyojokyoMapperParameter = TohyojokyoMapperParameter
                .createParam(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況,
                        性別女, 期日前不在者区分, use選挙人名簿, key.set性別(Gender.FEMALE).getPSM検索キー());
        int 女投票者数 = 投票状況Manager.get投票者数(tohyojokyoMapperParameter);
        // 2.3.2　仮投票による投票の状況－投票者
        投票状況 = TohyoJokyo.仮投票.getCode();
        tohyojokyoMapperParameter = TohyojokyoMapperParameter
                .createParam(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況,
                        性別男, 期日前不在者区分, use選挙人名簿, key.set性別(Gender.MALE).getPSM検索キー());
        int 男仮投票者数 = 投票状況Manager.get投票者数(tohyojokyoMapperParameter);
        tohyojokyoMapperParameter = TohyojokyoMapperParameter
                .createParam(抄本番号, 選挙番号, 報告年月日, 施設コードinitial, 投票区コードinitial, 投票状況,
                        性別女, 期日前不在者区分, use選挙人名簿, key.set性別(Gender.FEMALE).getPSM検索キー());
        int 女仮投票者数 = 投票状況Manager.get投票者数(tohyojokyoMapperParameter);

        set投票年月日エリア();
        set投票所設置の状況エリア(投票録, 抄本番号, 選挙番号, 施設コードinitial);
        set投票立会人選管エリア(投票立会人選管リスト, 投票立会人選管リスト2);
        set投票立会人投票管理者エリア(投票立会人投票管理者リスト);
        set再交付者エリア(再交付者リスト, 再交付者リスト2);
        set投票所開閉時刻エリア(投票録);
        set投票者数エリア(男投票者数, 女投票者数, 男仮投票者数, 女仮投票者数, 点字により投票者数);
        set投票所事務従事者エリア(投票録);
        return set画面項目(投票録, 投票立会人選管リスト, 投票立会人投票管理者リスト, 再交付者リスト);
    }

    private TohyorokuSaveData set画面項目(Tohyoroku 投票録, List<TohyorokuFuzui> 投票立会人リスト,
            List<TohyorokuFuzui> 投票管理者リスト, List<TohyorokuFuzui> 再交付者リスト) {
        TohyorokuSaveData resultData = new TohyorokuSaveData();
        resultData.set投票録(投票録);
        resultData.set投票録画面対象(get投票録画面対象());
        resultData.set投票立会人リスト((List<TohyorokuFuzui>) get固定リスト(投票立会人リスト, 投票立会人_選任_行数));
        resultData.set投票管理者リスト((List<TohyorokuFuzui>) get固定リスト(投票管理者リスト, 投票立会人_投票管理者_行数));
        resultData.set再交付者リスト((List<TohyorokuFuzui>) get固定リスト(再交付者リスト, 投票立会人_再交付者_行数));
        return resultData;
    }

    private List<?> get固定リスト(List<?> targetList, int endIndex) {
        if (null == targetList || targetList.isEmpty()) {
            return new ArrayList<>();
        }
        if (targetList.size() <= endIndex) {
            return targetList;
        }
        return new ArrayList<>(targetList.subList(0, endIndex));
    }

    private void set投票年月日エリア() {
        shosaiDiv.getTxtShikkoYMD().setValue(jokenDiv.getCcdShohonNameList().getSelectedTohyoYMD());
        shosaiDiv.getTxtChoseiYMD().setValue(RDate.getNowDate());
        shosaiDiv.getTxtTohyoYMD().setValue(jokenDiv.getTxtTohyoYMDJoken().getValue());

    }

    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 50 LINES
    private void set投票所設置の状況エリア(Tohyoroku 投票録, ShohonNo 抄本番号, SenkyoNo 選挙番号, RString 施設コード) {
        if (null != 投票録) {
            shosaiDiv.getTxtSecchiJokyo().setValue(投票録.get投票所設置状況());
            shosaiDiv.getTxtKaisetsuBasho().setValue(投票録.get投票所開設場所());
            if (null != 投票録.get設置期間_開始年月日() && !投票録.get設置期間_開始年月日().isEmpty()) {
                shosaiDiv.getTxtSecchiKikan().setFromValue(new RDate(投票録.get設置期間_開始年月日().toString()));
            }
            if (null != 投票録.get設置期間_終了年月日() && !投票録.get設置期間_終了年月日().isEmpty()) {
                shosaiDiv.getTxtSecchiKikan().setToValue(new RDate(投票録.get設置期間_終了年月日().toString()));
            }
        } else {
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 8 LINES
            if (ViewState.getメニューID().equals(AFAMenuId.AFAMNE5020_投票録.menuId())
                    && null != 施設コード
                    && !施設コード.isEmpty()) {
                Shisetsu 施設 = ShisetsuManager.createInstance().get施設By施設コード(施設コード);
                if (null != 施設 && null != 施設.get住所()) {
                    shosaiDiv.getTxtKaisetsuBasho().setValue(施設.get住所().value());
                }
            }

            if (ViewState.getメニューID().equals(AFAMenuId.AFAMNE3020_当日投票録.menuId())) {
                RDate 期日前投票日 = jokenDiv.getTxtTohyoYMDJoken().getValue();
                shosaiDiv.getTxtSecchiKikan().setFromValue(期日前投票日);
                shosaiDiv.getTxtSecchiKikan().setToValue(期日前投票日);
                Shohon 抄本 = ShohonManager.createInstance().get抄本(抄本番号);
                //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 10 LINES
                if (null != 抄本) {
                    Code 選挙種類 = 抄本.get選挙種類();
                    RString 投票区コード = jokenDiv.getDdlTohyoku().getSelectedKey();
                    if (選挙種類 != null && RString.isNullOrEmpty(投票区コード)) {

                        Tohyojo tohyojo = TohyojoFinder.createInstance().get投票所By投票区コード(
                                SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類.getColumnValue())
                                ? new Code(SenkyoShurui.定時登録.getCode()) : 選挙種類, 投票区コード);
                        shosaiDiv.getTxtKaisetsuBasho().setValue(tohyojo.get住所().value());
                    }
                }

                return;
            }

            Senkyo 選挙 = SenkyoManager.createInstance().get選挙(抄本番号, 選挙番号);
            if (null != 選挙 && null != 選挙.get投票受付開始年月日() && !選挙.get投票受付開始年月日().isEmpty()) {
                shosaiDiv.getTxtSecchiKikan().setFromValue(new RDate(選挙.get投票受付開始年月日().toString()));
            }
            Shohon 抄本 = ShohonManager.createInstance().get抄本(抄本番号);
            if (null != 抄本 && null != 抄本.get投票年月日() && !抄本.get投票年月日().isEmpty()) {
                shosaiDiv.getTxtSecchiKikan().setToValue(new RDate(抄本.get投票年月日().minusDay(1).toString()));
            }

        }
    }

    private void set投票者数エリア(int 男投票者数, int 女投票者数, int 男仮投票者数, int 女仮投票者数, int 点字により投票者数) {
        shosaiDiv.getTxtTohyoshaOtoko().setValue(new Decimal(男投票者数));
        shosaiDiv.getTxtTohyoshaOnna().setValue(new Decimal(女投票者数));
        shosaiDiv.getTxtTohyoshaKei().setValue(new Decimal(男投票者数).add(女投票者数));
        shosaiDiv.getTxtKariTohyoshaOtoko().setValue(new Decimal(男仮投票者数));
        shosaiDiv.getTxtKariTohyoshaOnna().setValue(new Decimal(女仮投票者数));
        shosaiDiv.getTxtKariTohyoshaKei().setValue(new Decimal(男仮投票者数).add(女仮投票者数));
        shosaiDiv.getTxtTenjiNinzu().setValue(new Decimal(点字により投票者数));
        shosaiDiv.getTxtDairiNinzu().setValue(new Decimal(shosaiDiv.getCcdTohyorokuDairiTohyosha().getDgTohyorokuDairiTohyosha().getDataSource().size()));
    }

    private void set投票所事務従事者エリア(Tohyoroku 投票録) {
        if (null != 投票録) {
            shosaiDiv.getTxtJimuNinzu().setValue(new Decimal(投票録.get選管書記人数()).add(投票録.get職員人数()).add(投票録.getその他人数()));
            shosaiDiv.getTxtShokiNinzu().setValue(new Decimal(投票録.get選管書記人数()));
            shosaiDiv.getTxtShokuinNinzu().setValue(new Decimal(投票録.get職員人数()));
            shosaiDiv.getTxtSonotaNinzu().setValue(new Decimal(投票録.getその他人数()));
        }
    }

    private void set投票所開閉時刻エリア(Tohyoroku 投票録) {
        if (null != 投票録) {
            shosaiDiv.getTxtKaiheiStartTime().setValue(投票録.get開閉時刻_開始());
            shosaiDiv.getTxtKaiheiStopTime().setValue(投票録.get開閉時刻_終了());
        } else {
            shosaiDiv.getTxtKaiheiStartTime().setValue(DEFAULT_開始時刻);
            shosaiDiv.getTxtKaiheiStopTime().setValue(DEFAULT_終了時刻);
        }
    }

    private void set投票立会人選管エリア(List<TohyorokuFuzui> 投票立会人選管リスト, List<TachiaininHikitsugi> 投票立会人選管リスト2) {

        dgTohyorokuTachiaininSenkan_Row row;
        List<dgTohyorokuTachiaininSenkan_Row> dataList = new ArrayList<>();

        if (null != 投票立会人選管リスト && !投票立会人選管リスト.isEmpty()) {
            for (int i = 0; i < 投票立会人_選任_行数; i++) {
                row = new dgTohyorokuTachiaininSenkan_Row();
                if (i < 投票立会人選管リスト.size()) {
                    TohyorokuFuzui 投票立会人選管 = 投票立会人選管リスト.get(i);
                    row.getTxtToha().setValue(投票立会人選管.get党派());
                    row.getTxtShimei().setValue((null != 投票立会人選管.get氏名() && !投票立会人選管.get氏名().isEmpty()) ? 投票立会人選管.get氏名().value() : RString.EMPTY);
                    row.getTxtSenninYMD().setValue(投票立会人選管.get選任年月日());
                    row.getTxtTachiaiStartTime().setValue(投票立会人選管.get立会時間_開始時刻());
                    row.getTxtTachiaiStopTime().setValue(投票立会人選管.get立会時間_終了時刻());
                    row.getTxtSankaiTime().setValue(投票立会人選管.get参会時刻());
                    row.getTxtJishokuTime().setValue(投票立会人選管.get辞職時刻());
                    row.getTxtJiyu().setValue(投票立会人選管.get事由());
                }
                dataList.add(row);
            }
            shosaiDiv.getDgTohyorokuTachiaininSenkan().setDataSource(dataList);
            return;
        }

        int 選管リストSize = 0;
        if (null != 投票立会人選管リスト2 && !投票立会人選管リスト2.isEmpty()) {
            選管リストSize = 投票立会人選管リスト2.size();
        }
        for (int i = 0; i < 投票立会人_選任_行数; i++) {
            row = new dgTohyorokuTachiaininSenkan_Row();
            if (i < 選管リストSize) {
                TachiaininHikitsugi 投票立会人選管 = 投票立会人選管リスト2.get(i);
                row.getTxtToha().setValue(投票立会人選管.get党派());
                row.getTxtShimei().setValue((null != 投票立会人選管.get氏名() && !投票立会人選管.get氏名().isEmpty()) ? 投票立会人選管.get氏名().value() : RString.EMPTY);
                row.getTxtTachiaiStartTime().setValue(投票立会人選管.get立会時間_開始時刻());
                row.getTxtTachiaiStopTime().setValue(投票立会人選管.get立会時間_終了時刻());
            }
            dataList.add(row);
        }
        shosaiDiv.getDgTohyorokuTachiaininSenkan().setDataSource(dataList);

    }

    private void set投票立会人投票管理者エリア(List<TohyorokuFuzui> 投票立会人投票管理者リスト) {
        dgTohyorokuTachiaininKanrisha_Row row;
        List<dgTohyorokuTachiaininKanrisha_Row> dataList = new ArrayList<>();
        int 投票立会人投票管理者リストSize = 0;
        if (null != 投票立会人投票管理者リスト && !投票立会人投票管理者リスト.isEmpty()) {
            投票立会人投票管理者リストSize = 投票立会人投票管理者リスト.size();
        }

        for (int i = 0; i < 投票立会人_投票管理者_行数; i++) {
            row = new dgTohyorokuTachiaininKanrisha_Row();
            if (i < 投票立会人投票管理者リストSize) {
                TohyorokuFuzui 投票立会人投票管理者 = 投票立会人投票管理者リスト.get(i);
                row.getTxtToha().setValue(投票立会人投票管理者.get党派());
                row.getTxtShimei().setValue((null != 投票立会人投票管理者.get氏名() && !投票立会人投票管理者.get氏名().isEmpty()) ? 投票立会人投票管理者.get氏名().value() : RString.EMPTY);
                row.getTxtSankaiTime().setValue(投票立会人投票管理者.get参会時刻());
            }
            dataList.add(row);
        }
        shosaiDiv.getDgTohyorokuTachiaininKanrisha().setDataSource(dataList);
    }

    private void set再交付者エリア(List<TohyorokuFuzui> 再交付者リスト, List<RString> 再交付者リスト2) {
        dgTohyorokuSaikofusha_Row row;
        List<dgTohyorokuSaikofusha_Row> dataList = new ArrayList<>();

        if (null != 再交付者リスト && !再交付者リスト.isEmpty()) {
            for (int i = 0; i < 投票立会人_再交付者_行数; i++) {
                row = new dgTohyorokuSaikofusha_Row();
                if (i < 再交付者リスト.size()) {
                    TohyorokuFuzui 再交付者 = 再交付者リスト.get(i);
                    row.getTxtShimei().setValue((null != 再交付者.get氏名() && !再交付者.get氏名().isEmpty()) ? 再交付者.get氏名().value() : RString.EMPTY);
                    row.getTxtJiyu().setValue(再交付者.get事由());
                }
                dataList.add(row);
            }
            shosaiDiv.getDgTohyorokuSaikofusha().setDataSource(dataList);
            return;
        }

        int 再交付者リストSize = 0;
        if (null != 再交付者リスト2 && !再交付者リスト2.isEmpty()) {
            再交付者リストSize = 再交付者リスト2.size();
        }
        for (int i = 0; i < 投票立会人_再交付者_行数; i++) {
            row = new dgTohyorokuSaikofusha_Row();
            if (i < 再交付者リストSize) {
                RString 再交付者 = 再交付者リスト2.get(i);
                row.getTxtShimei().setValue(再交付者);
            }
            dataList.add(row);
        }
        shosaiDiv.getDgTohyorokuSaikofusha().setDataSource(dataList);
    }

    private TohyorokuGamen get投票録画面対象() {
        TohyorokuGamen 投票録画面対象 = new TohyorokuGamen();
        投票録画面対象.set抄本(jokenDiv.getCcdShohonNameList().getSelectedShohonNo());
        投票録画面対象.set投票日(jokenDiv.getTxtTohyoYMDJoken().getValue());
        投票録画面対象.set選挙名(jokenDiv.getDdlSenkyoName().getSelectedKey());
        投票録画面対象.set投票所(jokenDiv.getDdlShisetsu().getSelectedKey());
        投票録画面対象.set投票区(jokenDiv.getDdlTohyoku().getSelectedKey());
        投票録画面対象.set調製日(shosaiDiv.getTxtChoseiYMD().getValue());
        投票録画面対象.set投票所設置状況(shosaiDiv.getTxtSecchiJokyo().getValue());
        投票録画面対象.set投票所開設場所(shosaiDiv.getTxtKaisetsuBasho().getValue());
        投票録画面対象.set投票所開始年月日(shosaiDiv.getTxtSecchiKikan().getFromValue());
        投票録画面対象.set投票所終了年月日(shosaiDiv.getTxtSecchiKikan().getToValue());
        投票録画面対象.set投票所開始時刻(shosaiDiv.getTxtKaiheiStartTime().getValue());
        投票録画面対象.set投票所終了時刻(shosaiDiv.getTxtKaiheiStopTime().getValue());
        投票録画面対象.set投票立会人リスト(get投票立会人リスト対象());
        投票録画面対象.set投票管理者リスト(get投票管理者リスト対象());
        投票録画面対象.set再交付者リスト(get再交付者リスト対象());
        投票録画面対象.set決定書または裁決書リスト(get決定投票者または返還者リスト対象(パタン_決定投票者));
        投票録画面対象.set選管書記人数(shosaiDiv.getTxtShokiNinzu().getValue());
        投票録画面対象.set職員人数(shosaiDiv.getTxtShokuinNinzu().getValue());
        投票録画面対象.setその他人数(shosaiDiv.getTxtSonotaNinzu().getValue());

        return 投票録画面対象;
    }

    private List<TohyouSha> get投票立会人リスト対象() {
        List<TohyouSha> 投票者リスト = new ArrayList<>();
        List<dgTohyorokuTachiaininSenkan_Row> 投票立会人リスト = shosaiDiv.getDgTohyorokuTachiaininSenkan().getDataSource();
        if (null == 投票立会人リスト) {
            return 投票者リスト;
        }
        for (dgTohyorokuTachiaininSenkan_Row row : 投票立会人リスト) {
            TohyouSha 投票者 = new TohyouSha();
            投票者.set党派(row.getTxtToha().getValue());
            投票者.set氏名(row.getTxtShimei().getValue());
            投票者.set選任年月日(row.getTxtSenninYMD().getValue());
            if (null != row.getTxtTachiaiStartTime().getValue()) {
                投票者.set立会時間開始(row.getTxtTachiaiStartTime().getValue());
            }
            if (null != row.getTxtTachiaiStopTime().getValue()) {
                投票者.set立会時間終了(row.getTxtTachiaiStopTime().getValue());
            }
            if (null != row.getTxtSankaiTime().getValue()) {
                投票者.set参会時刻(row.getTxtSankaiTime().getValue());
            }
            if (null != row.getTxtJishokuTime().getValue()) {
                投票者.set辞職時刻(row.getTxtJishokuTime().getValue());
            }
            投票者.set事由(row.getTxtJiyu().getValue());
            投票者リスト.add(投票者);
        }
        return 投票者リスト;
    }

    private List<TohyouSha> get投票管理者リスト対象() {
        List<TohyouSha> 投票者リスト = new ArrayList<>();
        List<dgTohyorokuTachiaininKanrisha_Row> 投票立会人リスト = shosaiDiv.getDgTohyorokuTachiaininKanrisha().getDataSource();
        if (null == 投票立会人リスト) {
            return 投票者リスト;
        }
        for (dgTohyorokuTachiaininKanrisha_Row row : 投票立会人リスト) {
            TohyouSha 投票者 = new TohyouSha();
            投票者.set党派(row.getTxtToha().getValue());
            投票者.set氏名(row.getTxtShimei().getValue());
            if (null != row.getTxtSankaiTime().getValue()) {
                投票者.set参会時刻(row.getTxtSankaiTime().getValue());
            }
            投票者リスト.add(投票者);
        }
        return 投票者リスト;
    }

    private List<TohyouSha> get再交付者リスト対象() {
        List<TohyouSha> 投票者リスト = new ArrayList<>();
        List<dgTohyorokuSaikofusha_Row> 投票立会人リスト = shosaiDiv.getDgTohyorokuSaikofusha().getDataSource();
        if (null == 投票立会人リスト) {
            return 投票者リスト;
        }
        for (dgTohyorokuSaikofusha_Row row : 投票立会人リスト) {
            TohyouSha 投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei().getValue());
            投票者.set事由(row.getTxtJiyu().getValue());
            投票者リスト.add(投票者);
        }
        return 投票者リスト;
    }

    private Tohyoroku get投票録更新用(Tohyoroku 投票録, ShohonNo 抄本番号, SenkyoNo 選挙番号, FlexibleDate 報告年月日,
            RString 施設コード, RString 投票区コード) {
        TohyorokuBuilder bulider;
        if (null == 投票録) {
            bulider = new Tohyoroku(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード).createBuilderForAddEdit();
        } else {
            bulider = 投票録.createBuilderForEdit();
        }
        bulider.set投票所設置状況(shosaiDiv.getTxtSecchiJokyo().getValue());
        bulider.set投票所開設場所(shosaiDiv.getTxtKaisetsuBasho().getValue());
        bulider.set設置期間_開始年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtSecchiKikan().getFromValue()));
        bulider.set設置期間_終了年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtSecchiKikan().getToValue()));
        bulider.set開閉時刻_開始(shosaiDiv.getTxtKaiheiStartTime().getValue());
        bulider.set開閉時刻_終了(shosaiDiv.getTxtKaiheiStopTime().getValue());
        if (null != shosaiDiv.getTxtShokiNinzu().getValue()) {
            bulider.set選管書記人数(shosaiDiv.getTxtShokiNinzu().getValue().intValue());
        } else {
            bulider.set選管書記人数(0);
        }
        if (null != shosaiDiv.getTxtShokuinNinzu().getValue()) {
            bulider.set職員人数(shosaiDiv.getTxtShokuinNinzu().getValue().intValue());
        } else {
            bulider.set職員人数(0);
        }
        if (null != shosaiDiv.getTxtSonotaNinzu().getValue()) {
            bulider.setその他人数(shosaiDiv.getTxtSonotaNinzu().getValue().intValue());
        } else {
            bulider.setその他人数(0);
        }
        return bulider.build();
    }

    private List<TohyorokuFuzui> get投票者リスト更新用(List<TohyorokuFuzui> 投票者リスト, List<?> dataGrid,
            ShohonNo 抄本番号, SenkyoNo 選挙番号, FlexibleDate 報告年月日,
            RString 施設コード, RString 投票区コード) {
        TohyorokuFuzuiBuilder builder;
        List<TohyorokuFuzui> 投票者リスト更新用 = new ArrayList<>();
        Code 投票録項目種類 = Code.EMPTY;
        Object row = dataGrid.get(0);
        if (row instanceof dgTohyorokuTachiaininSenkan_Row) {
            投票録項目種類 = new Code(TohyorokuKomokuShurui.投票立会人_選管.getCode());
        } else if (row instanceof dgTohyorokuTachiaininKanrisha_Row) {
            投票録項目種類 = new Code(TohyorokuKomokuShurui.投票立会人_投票管理者.getCode());
        } else if (row instanceof dgTohyorokuSaikofusha_Row) {
            投票録項目種類 = new Code(TohyorokuKomokuShurui.再交付者.getCode());
        }

        int 連番 = TohyorokuFuzuiManager.createInstance()
                .get投票録付随情報Max連番(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類);
        for (int i = 0; i < dataGrid.size(); i++) {
            row = dataGrid.get(i);
            if (i < 投票者リスト.size()) {
                builder = 投票者リスト.get(i).createBuilderForEdit();
            } else {
                if (isEmptyDataRow(row)) {
                    continue;
                }
                連番 = 連番 + 1;
                builder = new TohyorokuFuzui(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 連番)
                        .createBuilderForAddEdit();

            }

            builder.set立会時間_開始時刻(更新用時間初期値);
            builder.set立会時間_終了時刻(更新用時間初期値);
            builder.set参会時刻(更新用時間初期値);
            builder.set辞職時刻(更新用時間初期値);
            if (row instanceof dgTohyorokuTachiaininSenkan_Row) {
                dgTohyorokuTachiaininSenkan_Row senkanRow = (dgTohyorokuTachiaininSenkan_Row) row;
                builder.set党派(senkanRow.getTxtToha().getValue());
                builder.set氏名(new AtenaMeisho(senkanRow.getTxtShimei().getValue()));
                builder.set選任年月日(senkanRow.getTxtSenninYMD().getValue());
                builder.set立会時間_開始時刻(senkanRow.getTxtTachiaiStartTime().getValue());
                builder.set立会時間_終了時刻(senkanRow.getTxtTachiaiStopTime().getValue());
                builder.set参会時刻(senkanRow.getTxtSankaiTime().getValue());
                builder.set辞職時刻(senkanRow.getTxtJishokuTime().getValue());
                builder.set事由(senkanRow.getTxtJiyu().getValue());
            } else if (row instanceof dgTohyorokuTachiaininKanrisha_Row) {
                dgTohyorokuTachiaininKanrisha_Row kanrishaRow = (dgTohyorokuTachiaininKanrisha_Row) row;
                builder.set党派(kanrishaRow.getTxtToha().getValue());
                builder.set氏名(new AtenaMeisho(kanrishaRow.getTxtShimei().getValue()));
                builder.set参会時刻(kanrishaRow.getTxtSankaiTime().getValue());
            } else if (row instanceof dgTohyorokuSaikofusha_Row) {
                dgTohyorokuSaikofusha_Row saikofushaRow = (dgTohyorokuSaikofusha_Row) row;
                builder.set氏名(new AtenaMeisho(saikofushaRow.getTxtShimei().getValue()));
                builder.set事由(saikofushaRow.getTxtJiyu().getValue());
            }

            投票者リスト更新用.add(builder.build());
        }

        return 投票者リスト更新用;

    }

    private List<TohyorokuFuzui> get決定投票者リスト更新用(List<TohyorokuFuzui> 投票者リスト,
            List<dgTohyorokuShimeiNyuryoku_Row> dataGrid,
            ShohonNo 抄本番号, SenkyoNo 選挙番号, FlexibleDate 報告年月日,
            RString 施設コード, RString 投票区コード) {
        List<TohyorokuFuzui> 投票者リスト更新用 = new ArrayList<>();
        Code 投票録項目種類 = new Code(TohyorokuKomokuShurui.決定書_判決書.getCode());
        dgTohyorokuShimeiNyuryoku_Row row;
        RString 氏名;
        int 連番 = TohyorokuFuzuiManager.createInstance()
                .get投票録付随情報Max連番(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類);
        for (int i = 0; i < dataGrid.size(); i++) {
            row = dataGrid.get(i);
            for (int j = 0; j < 決定書または裁決書投票者_毎行_投票者数; j++) {
                if (j == 0) {
                    氏名 = row.getTxtShimei1().getValue();
                } else if (j == 1) {
                    氏名 = row.getTxtShimei2().getValue();
                } else if (j == 2) {
                    氏名 = row.getTxtShimei3().getValue();
                } else {
                    氏名 = row.getTxtShimei4().getValue();
                }
                連番 = get決定書または裁決書投票者更新用(投票者リスト更新用, 投票者リスト,
                        i * 決定書または裁決書投票者_毎行_投票者数 + j, 氏名,
                        抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 連番);
            }
        }

        return 投票者リスト更新用;
    }

    private int get決定書または裁決書投票者更新用(List<TohyorokuFuzui> 投票者リスト更新用,
            List<TohyorokuFuzui> 投票者リスト, int index, RString 氏名,
            ShohonNo 抄本番号, SenkyoNo 選挙番号, FlexibleDate 報告年月日,
            RString 施設コード, RString 投票区コード, Code 投票録項目種類, int 連番) {
        TohyorokuFuzuiBuilder builder = null;
        if (index < 投票者リスト.size()) {
            builder = 投票者リスト.get(index).createBuilderForEdit();
            builder.set氏名(new AtenaMeisho(氏名));
        } else {
            if (!氏名.isNullOrEmpty()) {
                連番 = 連番 + 1;
                builder = new TohyorokuFuzui(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 連番)
                        .createBuilderForAddEdit();
                builder.set氏名(new AtenaMeisho(氏名));
            }
        }

        if (null != builder) {
            builder.set立会時間_開始時刻(更新用時間初期値);
            builder.set立会時間_終了時刻(更新用時間初期値);
            builder.set参会時刻(更新用時間初期値);
            builder.set辞職時刻(更新用時間初期値);
            投票者リスト更新用.add(builder.build());
        }
        return 連番;
    }

    private boolean isEmptyDataRow(Object row) {
        if (row instanceof dgTohyorokuTachiaininSenkan_Row) {
            dgTohyorokuTachiaininSenkan_Row senkanRow = (dgTohyorokuTachiaininSenkan_Row) row;
            return senkanRow.getTxtToha().getValue().isNullOrEmpty()
                    && senkanRow.getTxtShimei().getValue().isNullOrEmpty()
                    && senkanRow.getTxtSenninYMD().getValue().isEmpty()
                    && senkanRow.getTxtTachiaiStartTime().getValue() == null
                    && senkanRow.getTxtTachiaiStopTime().getValue() == null
                    && senkanRow.getTxtSankaiTime().getValue() == null
                    && senkanRow.getTxtJishokuTime().getValue() == null
                    && senkanRow.getTxtJiyu().getValue().isNullOrEmpty();
        } else if (row instanceof dgTohyorokuTachiaininKanrisha_Row) {
            dgTohyorokuTachiaininKanrisha_Row kanrishaRow = (dgTohyorokuTachiaininKanrisha_Row) row;
            return kanrishaRow.getTxtToha().getValue().isNullOrEmpty()
                    && kanrishaRow.getTxtShimei().getValue().isNullOrEmpty()
                    && kanrishaRow.getTxtSankaiTime().getValue() == null;
        } else if (row instanceof dgTohyorokuSaikofusha_Row) {
            dgTohyorokuSaikofusha_Row saikofushaRow = (dgTohyorokuSaikofusha_Row) row;
            return saikofushaRow.getTxtShimei().getValue().isNullOrEmpty()
                    && saikofushaRow.getTxtJiyu().getValue().isNullOrEmpty();
        }
        return true;
    }

    private TohyorokuChohyo createItemFromGamen() {
        TohyorokuChohyo item = new TohyorokuChohyo();

        item.set投票区コード(jokenDiv.getDdlTohyoku().getSelectedKey());
        item.set執行年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtShikkoYMD().getValue()));
        item.setタイトル(jokenDiv.getDdlSenkyoName().getSelectedValue());
        item.set投票年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtTohyoYMD().getValue()));
        item.set設置状況(shosaiDiv.getTxtSecchiJokyo().getValue());
        item.set投票場所(shosaiDiv.getTxtKaisetsuBasho().getValue());
        item.set投票期間_開始年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtSecchiKikan().getFromValue()));
        item.set投票期間_終了年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtSecchiKikan().getToValue()));
        item.set選任リスト(get投票立会人リスト対象());
        item.set投票管理者リスト(get投票管理者リスト対象());
        item.set投票時刻開始(null == shosaiDiv.getTxtKaiheiStartTime().getValue() ? DEFAULT_開始時刻 : shosaiDiv.getTxtKaiheiStartTime().getValue());
        item.set投票時刻閉鎖(null == shosaiDiv.getTxtKaiheiStopTime().getValue() ? DEFAULT_終了時刻 : shosaiDiv.getTxtKaiheiStopTime().getValue());
        item.set投票者男数(shosaiDiv.getTxtTohyoshaOtoko().getValue());
        item.set仮投票者男数(shosaiDiv.getTxtKariTohyoshaOtoko().getValue());
        item.set投票者女数(shosaiDiv.getTxtTohyoshaOnna().getValue());
        item.set仮投票者女数(shosaiDiv.getTxtKariTohyoshaOnna().getValue());
        item.set投票者合計(shosaiDiv.getTxtTohyoshaKei().getValue());
        item.set仮投票者合計(shosaiDiv.getTxtKariTohyoshaKei().getValue());
        item.set再交付者リスト(get再交付者リスト対象());
        item.set決定投票者リスト(get決定投票者または返還者リスト対象(パタン_決定投票者));
        item.set返還者リスト(get決定投票者または返還者リスト対象(パタン_返還者));
        item.set点字投票者数(shosaiDiv.getTxtTenjiNinzu().getValue());
        item.set代理投票者数(shosaiDiv.getTxtDairiNinzu().getValue());
        item.set代理投票者リスト(get代理投票者リスト対象());
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(jokenDiv.getCcdShohonNameList().getSelectedSenkyoShurui().getCode())) {
            item.set種類タイトル(種類タイトル_投票人);
            item.set法1(法1_NO63);
            item.set法2(法2_NO59);
            item.set法3(法3_NO61);
        } else {
            item.set種類タイトル(種類タイトル_選挙人);
            item.set法1(法1_NO50);
            item.set法2(法2_NO48);
            item.set法3(法3_NO49);
        }
        item.set投票拒否者法1リスト(get投票拒否者リスト対象(パタン_法1));
        item.set投票拒否者法2リスト(get投票拒否者リスト対象(パタン_法2));
        item.set調整年月日(convertRdateToFlexibleDate(shosaiDiv.getTxtChoseiYMD().getValue()));
        item.set選挙管理委員会書記数(null == shosaiDiv.getTxtShokiNinzu().getValue() ? Decimal.ZERO : shosaiDiv.getTxtShokiNinzu().getValue());
        item.set職員数(null == shosaiDiv.getTxtShokuinNinzu().getValue() ? Decimal.ZERO : shosaiDiv.getTxtShokuinNinzu().getValue());
        item.setその他数(null == shosaiDiv.getTxtSonotaNinzu().getValue() ? Decimal.ZERO : shosaiDiv.getTxtSonotaNinzu().getValue());
        item.set従事者総数(item.get選挙管理委員会書記数().add(item.get職員数()).add(item.getその他数()));

        return item;
    }

    private void setTojitsuItemFromGamen(TohyorokuChohyo item) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(convertRdateToFlexibleDate(jokenDiv.getTxtTohyoYMDJoken().getValue()));
        SenkyoninMeiboPsmMapperParameter param = SenkyoninMeiboPsmMapperParameter.createParam(
                new ShohonNo(jokenDiv.getCcdShohonNameList().getSelectedShohonNo()),
                jokenDiv.getDdlTohyoku().getSelectedKey(),
                key.getPSM検索キー());
        param.set性別コード(性別男);
        int 名簿登録者男数 = SenkyoninMeiboManager.createInstance().get選挙人名簿人数(param);
        param.set性別コード(性別女);
        int 名簿登録者女数 = SenkyoninMeiboManager.createInstance().get選挙人名簿人数(param);
        item.set名簿登録者男数(new Decimal(名簿登録者男数));
        item.set名簿登録者女数(new Decimal(名簿登録者女数));
        item.set名簿登録者合計(new Decimal(名簿登録者男数 + 名簿登録者女数));
    }

    private List<TohyouSha> get決定投票者または返還者リスト対象(RString pattern) {
        List<TohyouSha> 投票者リスト = new ArrayList<>();
        List<dgTohyorokuShimeiNyuryoku_Row> 投票立会人リスト = new ArrayList<>();
        if (パタン_決定投票者.equals(pattern)) {
            投票立会人リスト = shosaiDiv.getCcdTohyorokuKetteishoSaiketsusho().getDgTohyorokuShimeiNyuryoku().getDataSource();
        } else if (パタン_返還者.equals(pattern)) {
            投票立会人リスト = shosaiDiv.getCcdTohyorokuHenkanTohyosha().getDgTohyorokuShimeiNyuryoku().getDataSource();
        }

        if (null == 投票立会人リスト) {
            return 投票者リスト;
        }

        for (dgTohyorokuShimeiNyuryoku_Row row : 投票立会人リスト) {
            TohyouSha 投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei1().getValue());
            投票者リスト.add(投票者);
            投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei2().getValue());
            投票者リスト.add(投票者);
            投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei3().getValue());
            投票者リスト.add(投票者);
            投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei4().getValue());
            投票者リスト.add(投票者);
        }
        return 投票者リスト;
    }

    private List<TohyouSha> get代理投票者リスト対象() {
        List<TohyouSha> 投票者リスト = new ArrayList<>();
        List<dgTohyorokuDairiTohyosha_Row> 投票立会人リスト = shosaiDiv.getCcdTohyorokuDairiTohyosha().getDgTohyorokuDairiTohyosha().getDataSource();
        if (null == 投票立会人リスト) {
            return 投票者リスト;
        }
        for (dgTohyorokuDairiTohyosha_Row row : 投票立会人リスト) {
            TohyouSha 投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei());
            投票者.set補助者1氏名(row.getTxtHojosha1());
            投票者.set補助者2氏名(row.getTxtHojosha2());
            投票者リスト.add(投票者);
        }
        return 投票者リスト;
    }

    private List<TohyouSha> get投票拒否者リスト対象(RString pattern) {
        List<TohyouSha> 投票者リスト = new ArrayList<>();
        List<dgTohyorokuKyohiNyuryoku_Row> 投票立会人リスト = new ArrayList<>();
        if (パタン_法1.equals(pattern)) {
            投票立会人リスト = shosaiDiv.getCcdTohyorokuTohyoKyohi().getDgTohyorokuKyohiNyuryoku().getDataSource();
        } else if (パタン_法2.equals(pattern)) {
            投票立会人リスト = shosaiDiv.getCcdTohyorokuDairiTohyoKyohi().getDgTohyorokuKyohiNyuryoku().getDataSource();
        }

        if (null == 投票立会人リスト) {
            return 投票者リスト;
        }
        for (dgTohyorokuKyohiNyuryoku_Row row : 投票立会人リスト) {
            TohyouSha 投票者 = new TohyouSha();
            投票者.set氏名(row.getTxtShimei());
            投票者.set事由(row.getTxtJiyu());
            投票者.set仮投票フラグ(row.getChkKariTohyo());
            投票者リスト.add(投票者);
        }
        return 投票者リスト;
    }

    private FlexibleDate convertRdateToFlexibleDate(RDate target) {
        if (null == target) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(target.toDateString());
    }

    /**
     * 投票録保存用クラス。
     */
    @lombok.Getter
    @lombok.Setter
    @lombok.NoArgsConstructor
    public static class TohyorokuSaveData {

        private Tohyoroku 投票録;
        private TohyorokuGamen 投票録画面対象;
        private List<TohyorokuFuzui> 投票立会人リスト;
        private List<TohyorokuFuzui> 投票管理者リスト;
        private List<TohyorokuFuzui> 再交付者リスト;
        private List<TohyorokuFuzui> 決定投票者リスト;
    }

    /**
     * TohyorokuSaveDataを返す。
     *
     * @return TohyorokuSaveData
     */
    public TohyorokuSaveData createTohyorokuSaveData() {
        return new TohyorokuSaveData();
    }
}
