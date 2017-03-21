/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.Chiku1ConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.Chiku2ConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.Chiku3ConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.GyoseikuConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.JushoConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.TohyokuConditionResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.service.core.jushojokenselect.JushoJokenSelectManager;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.chikubunrui1.ChikuBunrui1;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.chikubunrui2.ChikuBunrui2;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.chikubunrui3.ChikuBunrui3;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.gyoseiku.Gyoseiku;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.choiki.ChoikiItem;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumn;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住所条件選択共有子DIVに対するコントローラです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class JushoJokenSelectHandler {

    private final JushoJokenSelectDiv div;
    private final RString なしkey = new RString("00");
    private final RString 投票区key = new RString("10");
    private final RString 行政区key = new RString("12");
    private final RString 住所key = new RString("11");
    private final RString 地区1key = new RString("13");
    private final RString 地区2key = new RString("14");
    private final RString 地区3key = new RString("15");
    private final RString 投票区value = new RString("投票区");
    private final RString 行政区value = new RString("行政区");
    private final RString 住所value = new RString("住所");
    private final RString 投票区名 = new RString("投票区名");
    private final RString 行政区名 = new RString("行政区名");
    private final RString 住所名 = new RString("住所名");
    private final RString コード = new RString("コード");
    private final RString 名称 = new RString("名称");

    /**
     * コンストラクタです。
     *
     * @param div 宛名シールレイアウト共有子DIV
     */
    public JushoJokenSelectHandler(JushoJokenSelectDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙種類 Code
     */
    public void initialize(ShohonNo 抄本番号, Code 選挙種類) {
        JushoJokenSelectManager 住所条件選択Manager = JushoJokenSelectManager.createInstance();
        div.setSenkyoShuruiKey(選挙種類.getKey());
        div.setSenkyoShuruiValue(選挙種類.getColumnValue());
        div.setRadioButtonName(null);
        RString menuID = ResponseHolder.getMenuID();

        List<KeyValueDataSource> 住所条件 = div.getRadJushoJoken().getDataSource();
        for (int i = 0; i < 住所条件.size(); i++) {
            if (地区1key.equals(住所条件.get(i).getKey())) {
                住所条件.get(i).setValue(BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１,
                        SubGyomuCode.URZ業務共通_共通系));
            }
            if (地区2key.equals(住所条件.get(i).getKey())) {
                住所条件.get(i).setValue(BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２,
                        SubGyomuCode.URZ業務共通_共通系));
            }
            if (地区3key.equals(住所条件.get(i).getKey())) {
                住所条件.get(i).setValue(BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３,
                        SubGyomuCode.URZ業務共通_共通系));
            }
        }

        if (null != 抄本番号) {
            div.setShohonNoValue(new RString(抄本番号.value()));
        }

        if (menuID.equals(AFAMenuId.AFAMNI1010_住民投票時登録.menuId())) {
            List<TohyokuConditionResult> 投票区抽出 = 住所条件選択Manager.get投票区抽出条件(抄本番号);
            List<GyoseikuConditionResult> 行政区抽出 = 住所条件選択Manager.get行政区抽出条件(抄本番号);
            List<JushoConditionResult> 住所抽出 = 住所条件選択Manager.get住所抽出条件(抄本番号);
            List<Chiku1ConditionResult> 地区1抽出 = 住所条件選択Manager.get地区1抽出条件(抄本番号);
            List<Chiku2ConditionResult> 地区2抽出 = 住所条件選択Manager.get地区2抽出条件(抄本番号);
            List<Chiku3ConditionResult> 地区3抽出 = 住所条件選択Manager.get地区3抽出条件(抄本番号);
            if (!投票区抽出.isEmpty()) {
                div.getRadJushoJoken().setSelectedKey(投票区key);
                初期化処理_投票区(投票区抽出, 選挙種類, 住所条件選択Manager);
            } else if (!行政区抽出.isEmpty()) {
                div.getRadJushoJoken().setSelectedKey(行政区key);
                初期化処理_行政区(行政区抽出, 住所条件選択Manager);
            } else if (!住所抽出.isEmpty()) {
                div.getRadJushoJoken().setSelectedKey(住所key);
                初期化処理_住所(住所抽出, 住所条件選択Manager);
            } else if (!地区1抽出.isEmpty()) {
                div.getRadJushoJoken().setSelectedKey(地区1key);
                初期化処理_地区1(地区1抽出, 住所条件選択Manager);
            } else if (!地区2抽出.isEmpty()) {
                div.getRadJushoJoken().setSelectedKey(地区2key);
                初期化処理_地区2(地区2抽出, 住所条件選択Manager);
            } else if (!地区3抽出.isEmpty()) {
                div.getRadJushoJoken().setSelectedKey(地区3key);
                初期化処理_地区3(地区3抽出, 住所条件選択Manager);
            } else {
                div.getRadJushoJoken().setSelectedKey(なしkey);
                初期化処理_なし();
            }

        } else {
            div.getRadJushoJoken().setSelectedKey(なしkey);
            div.getDgJushoJokenList().getDataSource().clear();
        }

    }

    /**
     * ラジオボタンのonChangeのイベントメソッドです。
     *
     */
    public void onChange_radJushoJoken() {
        JushoJokenSelectManager 住所条件選択Manager = JushoJokenSelectManager.createInstance();
        ShohonNo 抄本番号 = null;
        if (!RString.isNullOrEmpty(div.getShohonNoValue())) {
            抄本番号 = new ShohonNo(div.getShohonNoValue());
        }
        Code 選挙種類 = new Code(div.getSenkyoShuruiKey(), div.getSenkyoShuruiValue());
        div.setRadioButtonName(null);

        if (投票区key.equals(div.getRadJushoJoken().getSelectedKey())) {
            List<TohyokuConditionResult> 投票区抽出 = 住所条件選択Manager.get投票区抽出条件(抄本番号);
            初期化処理_投票区(投票区抽出, 選挙種類, 住所条件選択Manager);
        } else if (行政区key.equals(div.getRadJushoJoken().getSelectedKey())) {
            List<GyoseikuConditionResult> 行政区抽出 = 住所条件選択Manager.get行政区抽出条件(抄本番号);
            初期化処理_行政区(行政区抽出, 住所条件選択Manager);
        } else if (住所key.equals(div.getRadJushoJoken().getSelectedKey())) {
            List<JushoConditionResult> 住所抽出 = 住所条件選択Manager.get住所抽出条件(抄本番号);
            初期化処理_住所(住所抽出, 住所条件選択Manager);
        } else if (地区1key.equals(div.getRadJushoJoken().getSelectedKey())) {
            List<Chiku1ConditionResult> 地区1抽出 = 住所条件選択Manager.get地区1抽出条件(抄本番号);
            初期化処理_地区1(地区1抽出, 住所条件選択Manager);
        } else if (地区2key.equals(div.getRadJushoJoken().getSelectedKey())) {
            List<Chiku2ConditionResult> 地区2抽出 = 住所条件選択Manager.get地区2抽出条件(抄本番号);
            初期化処理_地区2(地区2抽出, 住所条件選択Manager);
        } else if (地区3key.equals(div.getRadJushoJoken().getSelectedKey())) {
            List<Chiku3ConditionResult> 地区3抽出 = 住所条件選択Manager.get地区3抽出条件(抄本番号);
            初期化処理_地区3(地区3抽出, 住所条件選択Manager);
        } else if (なしkey.equals(div.getRadJushoJoken().getSelectedKey())) {
            初期化処理_なし();
        }
    }

    private void 初期化処理_投票区(List<TohyokuConditionResult> 投票区抽出List, Code 選挙種類, JushoJokenSelectManager 住所条件選択Manager) {

        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        ヘッダ名称.get(0).setColumnName(投票区value);
        ヘッダ名称.get(1).setColumnName(投票区名);

        List<dgJushoJokenList_Row> グリッドlist = new ArrayList<>();
        dgJushoJokenList_Row グリッド;
        Boolean チェックflag;
        チェックflag = Boolean.TRUE;

        Map<RString, TohyokuConditionResult> 投票区抽出Map = new HashMap();
        for (TohyokuConditionResult 投票区抽出 : 投票区抽出List) {
            投票区抽出Map.put(投票区抽出.get投票区コード(), 投票区抽出);
        }

        if (!(SenkyoShurui.定時登録.getCode().equals(選挙種類.getKey())
                || SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類.getKey()))) {
            List<jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku> 投票区情報
                    = 住所条件選択Manager.getAFT投票区情報(選挙種類);
            if (null != 投票区情報 && !投票区情報.isEmpty()) {
                for (int i = 0; i < 投票区情報.size(); i++) {
                    グリッド = new dgJushoJokenList_Row();
                    グリッド.setTxtJushoJokenCode(投票区情報.get(i).get投票区コード());
                    グリッド.setTxtJushoJokenName(投票区情報.get(i).get投票区名());
                    if (投票区抽出Map.get(投票区情報.get(i).get投票区コード()) != null) {
                        グリッド.setSelected(Boolean.TRUE);
                        チェックflag = Boolean.FALSE;
                    }
                    グリッドlist.add(グリッド);
                }
            }
            div.getDgJushoJokenList().setDataSource(グリッドlist);

        } else {
            List<Tohyoku> 投票区情報 = 住所条件選択Manager.getURT投票区情報();
            if (null != 投票区情報 && !投票区情報.isEmpty()) {
                for (int i = 0; i < 投票区情報.size(); i++) {
                    グリッド = new dgJushoJokenList_Row();
                    グリッド.setTxtJushoJokenCode(投票区情報.get(i).get投票区コード().value());//TODO
                    グリッド.setTxtJushoJokenName(投票区情報.get(i).get漢字名称());
                    if (投票区抽出Map.get(投票区情報.get(i).get投票区コード().value()) != null) {
                        グリッド.setSelected(Boolean.TRUE);
                        チェックflag = Boolean.FALSE;
                    }
                    グリッドlist.add(グリッド);
                }
            }
            div.getDgJushoJokenList().setDataSource(グリッドlist);
        }
        if (チェックflag) {
            div.setRadioButtonName(投票区value);
        } else {
            div.setRadioButtonName(null);
        }
    }

    private void 初期化処理_行政区(List<GyoseikuConditionResult> 行政区抽出List, JushoJokenSelectManager 住所条件選択Manager) {

        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        ヘッダ名称.get(0).setColumnName(行政区value);
        ヘッダ名称.get(1).setColumnName(行政区名);
        div.getDgJushoJokenList().getGridSetting().setColumns(ヘッダ名称);

        List<dgJushoJokenList_Row> グリッドlist = new ArrayList<>();
        dgJushoJokenList_Row グリッド;
        Boolean チェックflag;
        チェックflag = Boolean.TRUE;

        List<Gyoseiku> 行政区情報 = 住所条件選択Manager.get行政区情報();
        Map<RString, GyoseikuConditionResult> 行政区抽出Map = new HashMap();
        for (GyoseikuConditionResult 行政区抽出 : 行政区抽出List) {
            行政区抽出Map.put(行政区抽出.get行政区コード().value(), 行政区抽出);
        }
        if (null != 行政区情報 && !行政区情報.isEmpty()) {
            for (int i = 0; i < 行政区情報.size(); i++) {
                グリッド = new dgJushoJokenList_Row();
                グリッド.setTxtJushoJokenCode(行政区情報.get(i).get行政区コード().value());
                グリッド.setTxtJushoJokenName(行政区情報.get(i).get漢字名称());
                if (行政区抽出Map.get(行政区情報.get(i).get行政区コード().value()) != null) {
                    グリッド.setSelected(Boolean.TRUE);
                    チェックflag = Boolean.FALSE;
                }
                グリッドlist.add(グリッド);
            }
        }
        div.getDgJushoJokenList().setDataSource(グリッドlist);

        if (チェックflag) {
            div.setRadioButtonName(行政区value);
        } else {
            div.setRadioButtonName(null);
        }
    }

    private void 初期化処理_住所(List<JushoConditionResult> 住所抽出List, JushoJokenSelectManager 住所条件選択Manager) {
        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        ヘッダ名称.get(0).setColumnName(住所value);
        ヘッダ名称.get(1).setColumnName(住所名);

        List<dgJushoJokenList_Row> グリッドlist = new ArrayList<>();
        dgJushoJokenList_Row グリッド;
        Boolean チェックflag;
        チェックflag = Boolean.TRUE;

        Map<RString, JushoConditionResult> 住所抽出Map = new HashMap();
        for (JushoConditionResult 住所抽出 : 住所抽出List) {
            住所抽出Map.put(住所抽出.get町域コード().value(), 住所抽出);
        }

        List<ChoikiItem> 住所情報 = 住所条件選択Manager.get住所情報();
        if (null != 住所情報 && !住所情報.isEmpty()) {
            for (int i = 0; i < 住所情報.size(); i++) {
                グリッド = new dgJushoJokenList_Row();
                グリッド.setTxtJushoJokenCode(住所情報.get(i).get町域コード().value());
                グリッド.setTxtJushoJokenName(住所情報.get(i).get漢字名称());
                if (住所抽出Map.get(住所情報.get(i).get町域コード().value()) != null) {
                    グリッド.setSelected(Boolean.TRUE);
                    チェックflag = Boolean.FALSE;
                }
                グリッドlist.add(グリッド);
            }
        }
        div.getDgJushoJokenList().setDataSource(グリッドlist);
        if (チェックflag) {
            div.setRadioButtonName(住所value);
        } else {
            div.setRadioButtonName(null);
        }
    }

    private void 初期化処理_地区1(List<Chiku1ConditionResult> 地区1抽出List, JushoJokenSelectManager 住所条件選択Manager) {

        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        RString 地区1名;
        地区1名 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        ヘッダ名称.get(0).setColumnName(コード);
        ヘッダ名称.get(1).setColumnName(地区1名);

        List<dgJushoJokenList_Row> グリッドlist = new ArrayList<>();
        dgJushoJokenList_Row グリッド;
        Boolean チェックflag;
        チェックflag = Boolean.TRUE;

        Map<RString, Chiku1ConditionResult> 地区1抽出Map = new HashMap();
        for (Chiku1ConditionResult 地区1抽出 : 地区1抽出List) {
            地区1抽出Map.put(地区1抽出.get地区コード1().value(), 地区1抽出);
        }

        List<ChikuBunrui1> 地区1情報 = 住所条件選択Manager.get地区1情報();
        if (null != 地区1情報 && !地区1情報.isEmpty()) {
            for (int i = 0; i < 地区1情報.size(); i++) {
                グリッド = new dgJushoJokenList_Row();
                グリッド.setTxtJushoJokenCode(地区1情報.get(i).get地区コード().value());
                グリッド.setTxtJushoJokenName(地区1情報.get(i).get漢字名称());
                if (地区1抽出Map.get(地区1情報.get(i).get地区コード().value()) != null) {
                    グリッド.setSelected(Boolean.TRUE);
                    チェックflag = Boolean.FALSE;
                }
                グリッドlist.add(グリッド);
            }
        }
        div.getDgJushoJokenList().setDataSource(グリッドlist);
        if (チェックflag) {
            div.setRadioButtonName(地区1名);
        } else {
            div.setRadioButtonName(null);
        }
    }

    private void 初期化処理_地区2(List<Chiku2ConditionResult> 地区2抽出List, JushoJokenSelectManager 住所条件選択Manager) {
        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        RString 地区2名;
        地区2名 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        ヘッダ名称.get(0).setColumnName(コード);
        ヘッダ名称.get(1).setColumnName(地区2名);

        List<dgJushoJokenList_Row> グリッドlist = new ArrayList<>();
        dgJushoJokenList_Row グリッド;
        Boolean チェックflag;
        チェックflag = Boolean.TRUE;

        Map<RString, Chiku2ConditionResult> 地区2抽出Map = new HashMap();
        for (Chiku2ConditionResult 地区2抽出 : 地区2抽出List) {
            地区2抽出Map.put(地区2抽出.get地区コード2().value(), 地区2抽出);
        }

        List<ChikuBunrui2> 地区2情報 = 住所条件選択Manager.get地区2情報();
        if (null != 地区2情報 && !地区2情報.isEmpty()) {
            for (int i = 0; i < 地区2情報.size(); i++) {
                グリッド = new dgJushoJokenList_Row();
                グリッド.setTxtJushoJokenCode(地区2情報.get(i).get地区コード().value());//TODO
                グリッド.setTxtJushoJokenName(地区2情報.get(i).get漢字名称());
                if (地区2抽出Map.get(地区2情報.get(i).get地区コード().value()) != null) {
                    グリッド.setSelected(Boolean.TRUE);
                    チェックflag = Boolean.FALSE;
                }
                グリッドlist.add(グリッド);
            }
        }
        div.getDgJushoJokenList().setDataSource(グリッドlist);
        if (チェックflag) {
            div.setRadioButtonName(地区2名);
        } else {
            div.setRadioButtonName(null);
        }
    }

    private void 初期化処理_地区3(List<Chiku3ConditionResult> 地区3抽出List, JushoJokenSelectManager 住所条件選択Manager) {
        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        RString 地区3名;
        地区3名 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        ヘッダ名称.get(0).setColumnName(コード);
        ヘッダ名称.get(1).setColumnName(地区3名);

        List<dgJushoJokenList_Row> グリッドlist = new ArrayList<>();
        dgJushoJokenList_Row グリッド;
        Boolean チェックflag;
        チェックflag = Boolean.TRUE;

        Map<RString, Chiku3ConditionResult> 地区3抽出Map = new HashMap();
        for (Chiku3ConditionResult 地区3抽出 : 地区3抽出List) {
            地区3抽出Map.put(地区3抽出.get地区コード3().value(), 地区3抽出);
        }

        List<ChikuBunrui3> 地区3情報 = 住所条件選択Manager.get地区3情報();
        if (null != 地区3情報 && !地区3情報.isEmpty()) {
            for (int i = 0; i < 地区3情報.size(); i++) {
                グリッド = new dgJushoJokenList_Row();
                グリッド.setTxtJushoJokenCode(地区3情報.get(i).get地区コード().value());//TODO
                グリッド.setTxtJushoJokenName(地区3情報.get(i).get漢字名称());
                if (地区3抽出Map.get(地区3情報.get(i).get地区コード().value()) != null) {
                    グリッド.setSelected(Boolean.TRUE);
                    チェックflag = Boolean.FALSE;
                }
                グリッドlist.add(グリッド);
            }
        }
        div.getDgJushoJokenList().setDataSource(グリッドlist);
        if (チェックflag) {
            div.setRadioButtonName(地区3名);
        } else {
            div.setRadioButtonName(null);
        }
    }

    private void 初期化処理_なし() {
        List<DataGridColumn> ヘッダ名称 = div.getDgJushoJokenList().getGridSetting().getColumns();
        ヘッダ名称.get(0).setColumnName(コード);
        ヘッダ名称.get(1).setColumnName(名称);
        div.getDgJushoJokenList().getDataSource().clear();
        div.setRadioButtonName(null);
    }

}
