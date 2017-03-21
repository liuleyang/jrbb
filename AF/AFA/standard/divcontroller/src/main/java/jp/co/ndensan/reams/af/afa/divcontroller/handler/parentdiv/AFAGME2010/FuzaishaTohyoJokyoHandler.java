/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.TohyoJokyoSearchResult;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuState;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.UketoriState;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.dgFuzaishaTohyoJokyo_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * FuzaishaTohyoJokyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaTohyoJokyoHandler {

    private FuzaishaTohyoJokyoHandler() {

    }

    /**
     * 投票状況保存用Enum
     */
    public enum TohyoJokyoSaveKeyEnum {

        /**
         * 投票状況保存用Key
         */
        投票状況保存用Key(new RString("投票状況保存用Key"));

        private final RString key;

        TohyoJokyoSaveKeyEnum(RString key) {
            this.key = key;
        }

        RString getKey() {
            return this.key;
        }
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoJokyoDiv
     */
    public static void initialize(FuzaishaTohyoJokyoDiv div) {

        FuzaishaJokyoSelectHandler.initialize(div.getFuzaishaJokyoSelect(), div.getTxtHdnKidoMode());
        FuzaishaSeikyuJohoHandler.initialize(div.getFuzaishaSeikyuJoho(), SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui()));
        FuzaishaKofuJohoHandler.initialize(div.getFuzaishaKofuJoho());
        FuzaishaJuriJohoHandler.initialize(div.getFuzaishaJuriJoho(), div.getTxtHdnShohonNo());
        set画面表示モード(div);
        div.getDgFuzaishaTohyoJokyo().init();
        div.getFuzaishaUketoriJoho().getTxtUketoriYMD().setValue(RDate.getNowDate());
    }

    private static void set画面表示モード(FuzaishaTohyoJokyoDiv div) {
        div.getFuzaishaSeikyuJoho().setDisplayNone(true);
        div.getFuzaishaKofuJoho().setDisplayNone(true);
        div.getFuzaishaUketoriJoho().setDisplayNone(true);
        div.getFuzaishaJuriJoho().setDisplayNone(true);
        div.getFuzaishaSochiJoho().setDisplayNone(true);

        TohyoJokyo tohyoJokyo = TohyoJokyo.valueOf(div.getTxtHdnKidoMode().toString());
        if (TohyoJokyo.請求.equals(tohyoJokyo)) {
            div.getFuzaishaSeikyuJoho().setDisplayNone(false);
        } else if (TohyoJokyo.交付.equals(tohyoJokyo)) {
            div.getFuzaishaSeikyuJoho().setDisplayNone(false);
            div.getFuzaishaKofuJoho().setDisplayNone(false);
        } else if (TohyoJokyo.受取.equals(tohyoJokyo)) {
            div.getFuzaishaUketoriJoho().setDisplayNone(false);
        } else if (TohyoJokyo.受理.equals(tohyoJokyo)) {
            div.getFuzaishaSeikyuJoho().setDisplayNone(false);
            div.getFuzaishaKofuJoho().setDisplayNone(false);
            div.getFuzaishaJuriJoho().setDisplayNone(false);
            RString 不在者_受取処理制御 = BusinessConfig.get(ConfigKeysAFA.不在者_受取処理制御, SubGyomuCode.AFA選挙本体);
            div.getFuzaishaUketoriJoho().setDisplayNone(不在者_受取処理制御.equals(UketoriState.表示しない.getKey()));
        } else if (TohyoJokyo.送致.equals(tohyoJokyo)) {
            div.getFuzaishaSochiJoho().setDisplayNone(false);
        }
    }

    /**
     * 引数の情報を、hiddenInputにセットする。
     *
     * @param div FuzaishaTohyoJokyoDiv
     * @param shohonNo 抄本番号
     * @param senkyoShurui 選挙種類
     */
    public static void setHiddenInput(FuzaishaTohyoJokyoDiv div, RString shohonNo, SenkyoShurui senkyoShurui) {
        div.setTxtHdnShohonNo(shohonNo);
        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
    }

    private static boolean getCheckBoxSelectAble(FuzaishaTohyoJokyoDiv div, dgFuzaishaTohyoJokyo_Row row) {

        if (row.getChkTohyoAri().booleanValue() || !row.getChkTohyoShikaku()) {
            return false;
        }

        TohyoJokyo tohyoJokyo = TohyoJokyo.toValue(div.getFuzaishaJokyoSelect().getRadFuzaishaTohyoJokyo().getSelectedKey());
        RString menuID = ResponseHolder.getMenuID();

        if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2010_不在者投票用紙請求.menuId())) {
            return getCheckBoxModeFor請求(row, tohyoJokyo);
        } else if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2020_不在者投票用紙交付.menuId())) {
            return getCheckBoxModeFor交付(row, tohyoJokyo);
        } else if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId())) {
            return getCheckBoxModeFor受理(row, tohyoJokyo);
        }

        return false;
    }

    private static boolean getCheckBoxModeFor請求(dgFuzaishaTohyoJokyo_Row row, TohyoJokyo selectedTohyoJokyo) {

        if (row.getChkTohyojokyo()) {
            return TohyoJokyo.請求.toRString().equals(row.getTxtTohyoJokyo());
        }
        return TohyoJokyo.請求.equals(selectedTohyoJokyo);

    }

    private static boolean getCheckBoxModeFor交付(dgFuzaishaTohyoJokyo_Row row, TohyoJokyo selectedTohyoJokyo) {

        RString 不在者請求処理制御 = BusinessConfig.get(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体);

        if (AFAConfigKeysValue.不在者_請求処理制御_個別処理しない.isEqual(不在者請求処理制御)) {
            if (row.getChkTohyojokyo()) {
                return TohyoJokyo.交付.toRString().equals(row.getTxtTohyoJokyo());
            }
            return TohyoJokyo.交付.equals(selectedTohyoJokyo);
        } else if (AFAConfigKeysValue.不在者_請求処理制御_個別処理する.isEqual(不在者請求処理制御)) {
            if (row.getChkTohyojokyo()) {
                return TohyoJokyo.交付.toRString().equals(row.getTxtTohyoJokyo())
                        || (TohyoJokyo.交付.equals(selectedTohyoJokyo) && TohyoJokyo.請求.toRString().equals(row.getTxtTohyoJokyo()));
            }
            return TohyoJokyo.取消.equals(selectedTohyoJokyo);
        }

        return false;

    }

    private static boolean getCheckBoxModeFor受理(dgFuzaishaTohyoJokyo_Row row, TohyoJokyo selectedTohyoJokyo) {

        if (row.getChkTohyojokyo()) {
            switch (selectedTohyoJokyo) {
                case 受理:
                    return TohyoJokyo.交付.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.受理.toRString().equals(row.getTxtTohyoJokyo());
                case 返還:
                    return TohyoJokyo.交付.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.返還.toRString().equals(row.getTxtTohyoJokyo());
                case 棄権:
                    return TohyoJokyo.交付.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.棄権.toRString().equals(row.getTxtTohyoJokyo());
                case 受付拒否:
                    return TohyoJokyo.交付.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.受付拒否.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.仮投票.toRString().equals(row.getTxtTohyoJokyo());
                case 取消:
                    return TohyoJokyo.受理.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.返還.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.棄権.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.受付拒否.toRString().equals(row.getTxtTohyoJokyo())
                            || TohyoJokyo.仮投票.toRString().equals(row.getTxtTohyoJokyo());
                default:
                    return false;
            }
        }
        return row.getChkSenin() && TohyoJokyo.受理.equals(selectedTohyoJokyo);

    }

    /**
     * 投票情報を入力するボタンクリック時に呼ばれるメソッドです。
     *
     * @param div FuzaishaTohyoJokyoDiv
     * @param searchResult List<TohyoJokyoSearchResult>
     * @param 選挙種類 SenkyoShurui
     */
    public static void setData(FuzaishaTohyoJokyoDiv div, List<TohyoJokyoSearchResult> searchResult, SenkyoShurui 選挙種類) {

        clearThisPanel(div);
        set使用状態(div);

        List<dgFuzaishaTohyoJokyo_Row> dataSource = new ArrayList<>();
        for (TohyoJokyoSearchResult 投票状況 : searchResult) {
            dataSource.add(createDataRow(div, 投票状況, 選挙種類));
        }
        div.getDgFuzaishaTohyoJokyo().getDataSource().addAll(dataSource);
    }

    /**
     * 投票状況ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoJokyoDiv
     */
    public static void changeRadTohyoJokyo(FuzaishaTohyoJokyoDiv div) {

        set初期値(div);
        set使用状態(div);

        List<dgFuzaishaTohyoJokyo_Row> sourceFuzaisha = div.getDgFuzaishaTohyoJokyo().getDataSource();
        for (dgFuzaishaTohyoJokyo_Row row : sourceFuzaisha) {
            boolean isSelectAble = getCheckBoxSelectAble(div, row);
            if (row.getChkTohyoAri() || !isSelectAble) {
                row.setSelected(false);
            }
            row.setSelectable(isSelectAble);
        }
    }

    private static void set使用状態(FuzaishaTohyoJokyoDiv div) {
        RString selectedKey = div.getFuzaishaJokyoSelect().getRadFuzaishaTohyoJokyo().getSelectedKey();
        if (selectedKey.equalsIgnoreCase(TohyoJokyo.請求.getCode())) {
            FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), false);
        } else if (selectedKey.equalsIgnoreCase(TohyoJokyo.交付.getCode())) {
            RString 不在者_請求処理制御 = BusinessConfig.get(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体);
            FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), 不在者_請求処理制御.equals(SeikyuState.個別処理する.getKey()));
            FuzaishaKofuJohoHandler.setHyoji(div.getFuzaishaKofuJoho(), false);
        } else if (selectedKey.equalsIgnoreCase(TohyoJokyo.受理.getCode())) {
            FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), true);
            FuzaishaKofuJohoHandler.setHyoji(div.getFuzaishaKofuJoho(), true);
            FuzaishaJuriJohoHandler.setHyoji(div.getFuzaishaJuriJoho(), false, true, false);
        } else if ((selectedKey.equalsIgnoreCase(TohyoJokyo.返還.getCode()))
                || (selectedKey.equalsIgnoreCase(TohyoJokyo.棄権.getCode()))) {
            FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), true);
            FuzaishaKofuJohoHandler.setHyoji(div.getFuzaishaKofuJoho(), true);
            FuzaishaJuriJohoHandler.setHyoji(div.getFuzaishaJuriJoho(), true, false, false);
        } else if (selectedKey.equalsIgnoreCase(TohyoJokyo.受付拒否.getCode())) {
            RString 不在者_請求処理制御 = BusinessConfig.get(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体);
            FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), true);
            FuzaishaKofuJohoHandler.setHyoji(div.getFuzaishaKofuJoho(), true);
            if (不在者_請求処理制御.equals(UketoriState.表示する.getKey())) {
                FuzaishaUketoriJohoHandler.setHyoji(div.getFuzaishaUketoriJoho(), false);
            }
            FuzaishaJuriJohoHandler.setHyoji(div.getFuzaishaJuriJoho(), true, false, true);
        } else if (selectedKey.equalsIgnoreCase(TohyoJokyo.取消.getCode())) {
            FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), true);
            FuzaishaKofuJohoHandler.setHyoji(div.getFuzaishaKofuJoho(), true);
            FuzaishaJuriJohoHandler.setHyoji(div.getFuzaishaJuriJoho(), true, false, false);
        }
    }

    private static dgFuzaishaTohyoJokyo_Row createDataRow(FuzaishaTohyoJokyoDiv div, TohyoJokyoSearchResult item, SenkyoShurui 選挙種類) {
        dgFuzaishaTohyoJokyo_Row row = new dgFuzaishaTohyoJokyo_Row();
        row.setTxtTohyoJokyo(null == item.get投票状況() || item.get投票状況().isEmpty()
                ? RString.EMPTY : TohyoJokyo.toValue(item.get投票状況().value()).toRString());
        row.setTxtShimei(item.get氏名().value());
        row.setTxtSeibetsu(item.get性別());
        row.setTxtSenkyoRyakusho(item.get選挙略称());
        row.setTxtUketsukeNo(null == item.get受付番号() ? RString.EMPTY : item.get受付番号());

        if (null != item.get不在者投票事由()) {
            RString 不在者投票事由;
            if (SenkyoShurui.憲法改正国民投票.equals(選挙種類)) {
                不在者投票事由 = CodeMasterNoOption.getCodeMeisho(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), item.get不在者投票事由());
            } else {
                不在者投票事由 = CodeMasterNoOption.getCodeMeisho(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), item.get不在者投票事由());
            }
            row.setTxtTohyoJiyu(不在者投票事由);
        }
        row.getTxtSeikyuYMD().setValue(item.get請求日());
        row.setTxtSeikyuHoho(null == item.get請求方法()
                ? RString.EMPTY : CodeMasterNoOption.getCodeMeisho(AFACodeShubetsu.請求方法.getCodeShubetsu(), item.get請求方法()));
        row.getTxtKofuYMD().setValue(item.get交付日());
        row.setTxtKofuHoho(null == item.get交付方法()
                ? RString.EMPTY : CodeMasterNoOption.getCodeMeisho(AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), item.get交付方法()));
        row.setChkTenjiFlag(item.is点字());
        row.setChkShomeisho(item.is証明書());
        row.getTxtUketoriYMD().setValue(item.get受取日());
        row.getTxtJuriYMD().setValue(item.get受理日());
        row.getTxtJuriTime().setValue(item.get受理時刻());
        row.setTxtJuriHoho(null == item.get受理方法()
                ? RString.EMPTY : CodeMasterNoOption.getCodeMeisho(AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), item.get受理方法()));
        row.setTxtShisetsuShubetsu(null == item.get受理施設種別()
                ? RString.EMPTY : CodeMasterNoOption.getCodeRyakusho(AFACodeShubetsu.施設種別.getCodeShubetsu(), item.get受理施設種別()));
        row.setChkDairiFlag(item.is代理());
        row.setTxtHojoshaShimei1(null == item.get補助者氏名１() ? RString.EMPTY : item.get補助者氏名１().value());
        row.setTxtHojoshaShimei2(null == item.get補助者氏名１() ? RString.EMPTY : item.get補助者氏名２().value());
        row.setTxtKyohijiyu(item.get拒否の事由());
        row.setChkSochiZumiFlag(item.is送致済());
        row.setTxtShikibetsuCode(null == item.get識別コード() ? RString.EMPTY : item.get識別コード().value());
        row.setTxtSetaiCode(null == item.get世帯コード() ? RString.EMPTY : item.get世帯コード().value());
        row.setTxtHojoshaShikibetsuCode1(null == item.get補助者識別コード１() ? RString.EMPTY : item.get補助者識別コード１().value());
        row.setTxtHojoshaShikibetsuCode2(null == item.get補助者識別コード２() ? RString.EMPTY : item.get補助者識別コード２().value());
        row.setChkTohyoAri(item.is無投票選挙());
        row.setChkTohyoShikaku(new TohyoShikakuHantei().has投票資格Old(item.getSenkyoninTohyoJokyoEntity(), item.get識別コード(), item.get投票年月日()));
        row.setChkTohyojokyo(item.has投票状況());
        row.setTxtSenkyoNo(item.get選挙番号());
        row.setTxtShisetsuCode(item.get施設コード());
        row.setTxtShubetsuCode(null == item.get施設種別() ? RString.EMPTY : item.get施設種別().value());
        row.setChkSenin(item.is船員());
        row.setChkNankyoku(item.is南極());
        row.setChkYubin(item.is郵便());

        row.setSelectable(getCheckBoxSelectAble(div, row));
        if (row.getChkTohyoAri() || !row.getSelectable()) {
            row.setSelected(false);
        }

        return row;
    }

    private static void set使用不可状態にする(FuzaishaTohyoJokyoDiv div, Boolean blnShiyoFuka) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        FuzaishaSeikyuJohoHandler.setHyoji(div.getFuzaishaSeikyuJoho(), blnShiyoFuka);
        FuzaishaKofuJohoHandler.setHyoji(div.getFuzaishaKofuJoho(), blnShiyoFuka);
        FuzaishaUketoriJohoHandler.setHyoji(div.getFuzaishaUketoriJoho(), blnShiyoFuka);
        FuzaishaJuriJohoHandler.setHyoji(div.getFuzaishaJuriJoho(), blnShiyoFuka, false, true);
        FuzaishaSochiJohoHandler.setHyoji(div.getFuzaishaSochiJoho(), blnShiyoFuka);

    }

    private static void set初期値(FuzaishaTohyoJokyoDiv div) {
        set使用不可状態にする(div, false);

        FuzaishaSeikyuJohoHandler.clearThisPanel(div.getFuzaishaSeikyuJoho());
        FuzaishaKofuJohoHandler.clearThisPanel(div.getFuzaishaKofuJoho());
        FuzaishaUketoriJohoHandler.clearThisPanel(div.getFuzaishaUketoriJoho());
        FuzaishaJuriJohoHandler.clearThisPanel(div.getFuzaishaJuriJoho(), div.getTxtHdnShohonNo());
        FuzaishaSochiJohoHandler.clearThisPanel(div.getFuzaishaSochiJoho());
    }

    /**
     * 画面項目をクリアし、初期状態にするメソッドです。
     *
     * @param div FuzaishaTohyoJokyoDiv
     */
    public static void clearThisPanel(FuzaishaTohyoJokyoDiv div) {
        FuzaishaJokyoSelectHandler.clearThisPanel(div.getFuzaishaJokyoSelect());
        div.getDgFuzaishaTohyoJokyo().getDataSource().clear();
        set初期値(div);
    }
}
