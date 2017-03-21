/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SimulationMenuId;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * ShohonNameListDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してShohonNameListDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 */
public class ShohonNameListHandler {

    private final ShohonNameListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 抄本名リストDiv
     */
    public ShohonNameListHandler(ShohonNameListDiv div) {
        this.div = div;
    }

    /**
     * 使用するときに必ず指定する項目の制御を行います。<br />
     * 空白行は追加されません。
     *
     * @param senkyoShurui 選挙種類
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        initialize(senkyoShurui, false);
    }

    /**
     * 使用するときに必ず指定する項目の制御を行います。<br />
     * 空白行を追加するときは、isAddEmptyRowをTrueにしてください。
     *
     * @param senkyoShurui 選挙種類
     * @param is過去分のみ対象区分 過去分のみ対象区分
     */
    public void initialize(SenkyoShurui senkyoShurui, Boolean is過去分のみ対象区分) {

        this.initialize(senkyoShurui.getCode(), is過去分のみ対象区分);
    }

    /**
     * 使用するときに必ず指定する項目の制御を行います。<br />
     *
     * @param senkyoShurui 選挙種類
     * @param is過去分のみ対象区分 過去分のみ対象区分
     */
    public void initialize(RString senkyoShurui, Boolean is過去分のみ対象区分) {

        this.clear();
        div.setTxtHdnInitialSenkyoShurui(senkyoShurui);
        if (is過去分のみ対象区分) {
            div.getChkKakoShohon().setDisplayNone(is過去分のみ対象区分);
        }
        this.setドロップダウンリスト(is過去分のみ対象区分);
    }

    /**
     * 項目をクリアします。
     *
     */
    public void clear() {
        div.getDdlShohon().getDataSource().clear();
        clearHiddenKomoku();
    }

    private void clearHiddenKomoku() {
        div.setTxtHdnShohonNo(RString.EMPTY);
        div.setTxtHdnSenkyoShurui(RString.EMPTY);
        div.setTxtHdnShohonName(RString.EMPTY);
        div.setTxtHdnTohyoYMD(RString.EMPTY);
        div.setTxtHdnKiteiNenreiTotatsuYMD(RString.EMPTY);
    }

    /**
     * 画面ロード時のイベントメソッドです。(選挙種類の指定なし)
     *
     */
    public void initialize() {
        this.clear();
        this.initialize(RString.EMPTY, false);
    }

    /**
     * 表示する抄本が1件の場合は空白行ではなく、抄本情報を初期表示させるメソッドです。
     *
     */
    public void initialSetting() {
        RString menuID = ViewState.getメニューID();
        Boolean is空白行 = AFAMenuId.AFAGMM3010_各種マスタデータ出力.menuId().equals(menuID);
        if (is空白行) {
            div.getDdlShohon().setSelectedIndex(1);
        } else {
            if (!div.getTxtHdn一番近い未来().isEmpty()) {
                div.getDdlShohon().setSelectedKey(div.getTxtHdn一番近い未来());
            } else {
                div.getDdlShohon().setSelectedIndex(0);
            }
        }
    }

    private void setChkBoxChange(RString beforeSelectedKey) {
        if (div.getChkKakoShohon().getSelectedKeys().isEmpty()) {
            div.getDdlShohon().setSelectedKey(div.getTxtHdn一番近い未来());
        } else {
            this.setチェックボックスOFF場合(beforeSelectedKey);
        }
    }

    private void setチェックボックスOFF場合(RString beforeSelectedKey) {
        if (this.ifContainBeforeKey(div.getDdlShohon().getDataSource(), beforeSelectedKey)) {
            div.getDdlShohon().setSelectedKey(beforeSelectedKey);
        } else {
            if (!div.getTxtHdn一番近い過去().isEmpty()) {
                div.getDdlShohon().setSelectedKey(div.getTxtHdn一番近い過去());
            } else {
                div.getDdlShohon().setSelectedIndex(0);
            }
        }
    }

    private Boolean ifContainBeforeKey(List<KeyValueDataSource> sources, RString beforeSelectedKey) {
        for (KeyValueDataSource source : sources) {
            if (source.getKey().equals(beforeSelectedKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 抄本ドロップダウンリストが選択変更されたときのイベントメソッドです。
     *
     */
    public void changeDdlShohon() {
        clearHiddenKomoku();

        RString 抄本番号 = div.getDdlShohon().getSelectedKey();
        if (!抄本番号.isEmpty()) {
            Shohon source = ShohonManager.createInstance().get抄本(new ShohonNo(抄本番号));
            this.setHidenKomoku(source);
        }
    }

    /**
     * 抄本ドロップダウンリスト用のデータソースを作成する。
     *
     * @param shohonModel
     * @param isAddEmptyRow 空白行の有無（Trueの時、空白行を追加する）
     * @return List<KeyValueDataSource> 作成された抄本DDLのデータソース
     */
    public List<KeyValueDataSource> toKeyValueDataSource(List<Shohon> shohonModel, Boolean isAddEmptyRow) {
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        if (isAddEmptyRow) {
            keyValueList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        }
        RString 一番近い未来 = RString.EMPTY;
        RString 一番近い過去 = RString.EMPTY;
        for (Shohon row : shohonModel) {
            keyValueList.add(new KeyValueDataSource(edit抄本番号(row), edit抄本名(row)));
            if (FlexibleDate.getNowDate().isBeforeOrEquals(row.get投票年月日())) {
                一番近い未来 = new RString(row.get抄本番号().getColumnValue());
            }
            if (一番近い過去.isEmpty() && row.get投票年月日().isBefore(FlexibleDate.getNowDate())) {
                一番近い過去 = new RString(row.get抄本番号().getColumnValue());
            }
        }
        div.setTxtHdn一番近い未来(一番近い未来);
        div.setTxtHdn一番近い過去(一番近い過去);
        return keyValueList;
    }

    private RString edit抄本番号(Shohon shohon) {
        if (shohon == null) {
            return RString.EMPTY;
        }
        return new RString(shohon.get抄本番号().getColumnValue().toString());
    }

    private RString edit抄本名(Shohon row) {
        StringBuilder wkString = new StringBuilder();

        wkString.append("【");
        wkString.append(row.get選挙種類略称());
        wkString.append("】");
        wkString.append(row.get投票年月日().wareki().toDateString());
        wkString.append("　");
        wkString.append(row.get抄本名());

        return new RString(wkString.toString());
    }

    private void setHidenKomoku(Shohon item) {
        div.setTxtHdnShohonNo(edit抄本番号(item));
        div.setTxtHdnSenkyoShurui(null == item ? RString.EMPTY : item.get選挙種類().getColumnValue());
        div.setTxtHdnShohonName(null == item ? RString.EMPTY : item.get抄本名());
        div.setTxtHdnTohyoYMD(null == item ? RString.EMPTY
                : (item.get投票年月日() == null ? RString.EMPTY : new RString(item.get投票年月日().toString())));
        div.setTxtHdnKiteiNenreiTotatsuYMD(null == item ? RString.EMPTY
                : (item.get規定年齢到達年月日() == null ? RString.EMPTY : new RString(item.get規定年齢到達年月日().toString())));
    }

    /**
     * 引数の抄本番号から、ドロップダウンリストの初期表示を行う。
     *
     * @param shohonNo
     */
    public void selectedShohon(RString shohonNo) {
        div.getDdlShohon().setSelectedKey(shohonNo);
        changeDdlShohon();
    }

    /**
     * 共有子Divの表示状態（表示／非表示）モードを設定します。
     *
     * @param displayNoneSetMode 表示状態（表示／非表示）
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        div.setDisplayNone(displayNoneSetMode);
    }

    /**
     * 共有子Divの書込み状態モードを設定します。
     *
     * @param readOnlySetMode
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.setReadOnly(readOnlySetMode);
        div.getDdlShohon().setDisabled(readOnlySetMode);
    }

    /**
     * 共有子Divの表示状態（表示／非表示）を返します。
     *
     * @return 表示状態（表示／非表示）
     */
    public boolean isDisplayNoneMode() {
        return div.isDisplayNone();
    }

    /**
     * 抄本DDLの件数を取得します。
     *
     * @return 取得された抄本の数
     */
    public int getShohonListSize() {
        return div.getDdlShohon().getDataSource().size();
    }

    /**
     * チェックボックスをクリックするときのイベントメソッドです。
     */
    public void click_chkKakoShohon() {
        //  Boolean isChecked = !div.getChkKakoShohon().getSelectedKeys().isEmpty();
        RString beforeSelectedKey = div.getTxtHdnShohonNo();
        this.setドロップダウンリスト(Boolean.FALSE);
        if (this.getShohonListSize() != 0) {
            this.setChkBoxChange(beforeSelectedKey);
        }
    }

    /**
     * 過去分のみ対象区分のsetDisplayNoneをセットします。
     *
     * @param displayNoneSetMode True：表示しない　False：表示する
     */
    public void setChkKakoShohonDisplayNoneMode(Boolean displayNoneSetMode) {
        div.getChkKakoShohon().setDisplayNone(displayNoneSetMode);
    }

    /**
     * 過去分のみ対象区分のcheckSetModeをセットします。
     *
     * @param checkSetMode True：check　False：unCheck
     */
    public void setChkKakoShohonCheckMode(Boolean checkSetMode) {
        List<KeyValueDataSource> keys = new ArrayList<>();
        if (checkSetMode) {
            keys.add(new KeyValueDataSource(new RString("key0"), new RString("過去分も含める")));
        }
        div.getChkKakoShohon().setSelectedItems(keys);
    }

    private void setドロップダウンリスト(Boolean is過去分のみ) {

        RString menuID = ViewState.getメニューID();

        RString senkyoShurui = div.getTxtHdnInitialSenkyoShurui();

        Boolean is表示 = !div.getChkKakoShohon().isDisplayNone();
        Boolean isChecked = !div.getChkKakoShohon().getSelectedKeys().isEmpty();

        Boolean is過去分も含める = false;

        SimulationMenuId simulationMenuId = new SimulationMenuId();
        Boolean isシミュレーション = simulationMenuId.isSimulationMenuId(ResponseHolder.getMenuID());

        // 海区
        Boolean is海区 = menuID.startsWith("AFAMNK");
        Boolean 選挙時登録フラグ = null;
        if (is海区) {
            if (menuID.equals(AFAMenuId.AFAMNK1010_選挙人当初登録.menuId())) {
                選挙時登録フラグ = false;
            } else if (menuID.equals(AFAMenuId.AFAMNK1030_選挙時登録.menuId()) || menuID.equals(AFAMenuId.AFAMNK1050_選挙情報修正.menuId())) {
                選挙時登録フラグ = true;
            }
        }
        // 過去分
        if (!is過去分のみ) {
            if (is表示) {
                is過去分も含める = isChecked;
            } else {
                // AFAMNAxxxx 全件
                // AFAMNKxxxx 全件
                // AFAMNLxxxx 全件
                // AFAMNBxxxx システム日付＜＝抄本.投票年月日
                // AFAMNExxxxのうちの、AFAMNE4xxx以外 システム日付＜＝抄本.投票年月日
                // AFAMNGxxxx システム日付＜＝抄本.投票年月日
                is過去分も含める = (menuID.startsWith("AFAMNA")
                        || menuID.startsWith("AFAMNK")
                        || menuID.startsWith("AFAMNL")
                        || menuID.startsWith("AFAMNE4"));

            }
        }
        // 定時登録
        boolean isNotEq定時登録 = menuID.startsWith("AFAMNE");
        
        List<RString> 名簿調製用連携の選挙種類List = new ArrayList<>();
        if (AFAMenuId.AFAMNF1010_名簿調製用連携ファイル作成.menuId().equals(menuID)) {
            名簿調製用連携の選挙種類List.add(SenkyoShurui.国政選挙_地方選挙.getCode());
            名簿調製用連携の選挙種類List.add(SenkyoShurui.定時登録.getCode());
        }

        Boolean isAddEmptyRow = this.has空白行(menuID);
        List<Shohon> shohonList = ShohonManager.createInstance().get抄本(isシミュレーション,
                is過去分のみ,
                is過去分も含める,
                is海区,
                選挙時登録フラグ,
                isNotEq定時登録,
                senkyoShurui,
                名簿調製用連携の選挙種類List);
        List<KeyValueDataSource> list = new ArrayList<>();
        div.getDdlShohon().setDataSource(list);
        if (!shohonList.isEmpty()) {
            div.getDdlShohon().setDataSource(toKeyValueDataSource(shohonList, isAddEmptyRow));
            initialSetting();
        }
        changeDdlShohon();
    }

    private Boolean has空白行(RString menuID) {
        return AFAMenuId.AFAMNA1010_定時登録.menuId().equals(menuID)
                || AFAMenuId.AFAMNB1010_選挙時登録.menuId().equals(menuID)
                || AFAMenuId.AFAMNA2010_定時登録.menuId().equals(menuID)
                || AFAMenuId.AFAMNB4010_選挙時登録.menuId().equals(menuID)
                || AFAMenuId.AFAGMG1010_国民投票時登録.menuId().equals(menuID)
                || AFAMenuId.AFAGMK1010_海区漁業調整委員会委員選挙人名簿作成.menuId().equals(menuID)
                || AFAMenuId.AFAGMK1030_海区漁業調整委員会委員選挙時登録.menuId().equals(menuID)
                || AFAMenuId.AFAGMI1010_住民投票時登録.menuId().equals(menuID)
                || AFAMenuId.AFAGML1010_財産区議会議員選挙時登録.menuId().equals(menuID)
                || AFAMenuId.AFAGMM3010_各種マスタデータ出力.menuId().equals(menuID);
    }

    /**
     * 抄本ドロップダウンリストを取得のイベントメソッドです。
     *
     * @return 抄本ドロップダウンリスト
     */
    public DropDownList getDdlShohonItem() {
        return div.getDdlShohon();
    }
}
