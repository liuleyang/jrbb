/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.AFABTB201BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.TohyokuJyohou;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect.dgShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiIkkatsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.dgNyujokenTohyokuSelect_Row;
import jp.co.ndensan.reams.af.afa.service.core.jushojokenselect.JushoJokenSelectManager;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券発行（一括）Handlerクラスです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public final class NyujokenSakuseiIkkatsuHandler {

    private final NyujokenSakuseiIkkatsuDiv div;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString KEY = new RString("key0");
    private static final RString 固定文字 = new RString("Sample");
    private static final RString 一般分 = new RString("一般分");

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    private NyujokenSakuseiIkkatsuHandler(NyujokenSakuseiIkkatsuDiv div) {
        this.div = div;
    }

    /**
     * 在外選挙人名簿登録のHandler初期化
     *
     * @param div 在外選挙人名簿登録DIV
     * @return 在外選挙人名簿登録のHandler
     */
    public static NyujokenSakuseiIkkatsuHandler of(NyujokenSakuseiIkkatsuDiv div) {
        return new NyujokenSakuseiIkkatsuHandler(div);
    }

    /**
     * 画面状態を設定する。
     *
     * @param 選挙種類 RString
     * @param 印刷タイプ RString
     */
    public void set画面状態1(RString 選挙種類, RString 印刷タイプ) {
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtFreeText1().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtFreeText2().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtFreeText3().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkTaisho().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getDgNyujokenTohyokuSelect().getDataSource().clear();
        if (BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体).equals(ZERO)) {
            List<KeyValueDataSource> sourceList = new ArrayList();
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(ONE);
            source.setValue(一般分);
            sourceList.add(source);
            div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkTaisho().setDataSource(sourceList);
        }
        List<dgNyujokenTohyokuSelect_Row> rowList = new ArrayList();
        JushoJokenSelectManager manager = JushoJokenSelectManager.createInstance();
        if (SenkyoShurui.定時登録.getCode().equals(選挙種類) || SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類)) {
            List<Tohyoku> 投票区一覧 = manager.getURT投票区情報();
            if (null != 投票区一覧) {
                Collections.sort(投票区一覧, new Comparator<Tohyoku>() {
                    @Override
                    public int compare(Tohyoku o1, Tohyoku o2) {
                        return o1.get投票区コード().value().compareTo(o2.get投票区コード().value());
                    }
                });
                
                for (Tohyoku 投票区 : 投票区一覧) {
                    dgNyujokenTohyokuSelect_Row row = new dgNyujokenTohyokuSelect_Row();
                    row.setTxtTohyokuName(投票区.toEntity().getName());
                    row.setTxtTohyokuCode(null == 投票区.get投票区コード() ? RString.EMPTY : 投票区.get投票区コード().getColumnValue());
                    row.setSelected(Boolean.TRUE);
                    rowList.add(row);
                }
            }
        } else {
            List<jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku> 投票区一覧 = manager.getAFT投票区情報(new Code(選挙種類));
            if (null != 投票区一覧) {
                for (jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku 投票区 : 投票区一覧) {
                    dgNyujokenTohyokuSelect_Row row = new dgNyujokenTohyokuSelect_Row();
                    row.setTxtTohyokuCode(投票区.get投票区コード());
                    row.setTxtTohyokuName(投票区.get投票区名());
                    row.setSelected(Boolean.TRUE);
                    rowList.add(row);
                }
            }
        }
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getDgNyujokenTohyokuSelect().setDataSource(rowList);
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtNyujokenType().setDisabled(Boolean.TRUE);
        if (new RString("0").equals(印刷タイプ) || new RString("1").equals(印刷タイプ)) {
            div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtPrintNinzutxtNyujokenType().setDisplayNone(Boolean.TRUE);
        }
        if (new RString("2").equals(印刷タイプ) || new RString("3").equals(印刷タイプ)) {
            div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtPrintNinzutxtNyujokenType().setDisplayNone(Boolean.FALSE);
        }
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkSetaiIchiran().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtSetaiNinzu().setDisabled(Boolean.FALSE);
        if (BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体).equals(TWO)) {
            div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().setDisplayNone(Boolean.FALSE);
            set画面状態2();
        } else {
            div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().setDisplayNone(Boolean.TRUE);
        }
    }

    /**
     * 出力対象の転出者分をチェックOFFにした場合
     */
    public void set画面状態2() {
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().setDisabled(Boolean.TRUE);
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().clearFromValue();
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().clearToValue();
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getChkNijuMassho().setDisabled(Boolean.TRUE);
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getChkAtenaSeal().setDisabled(Boolean.TRUE);
    }

    /**
     * 出力対象の転出者分をチェックONにした場合
     */
    public void set画面状態3() {
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().clearFromValue();
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().clearToValue();
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getChkNijuMassho().setDisabled(Boolean.FALSE);
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getChkAtenaSeal().setDisabled(Boolean.FALSE);
        RString 抄本番号 = div.getCcdNyujokenShohonSelect().getCcdShohonNameList().getSelectedShohonNo();
        NyujokenIkkatsuFinder finder = NyujokenIkkatsuFinder.createInstance();
        FlexibleDate 転出期限年月日 = null;
        if (null != finder.select転出期限年月日MIN(new ShohonNo(抄本番号))) {
            転出期限年月日 = finder.select転出期限年月日MIN(new ShohonNo(抄本番号)).getTenshutsuKigenYMD();
        }
        if (転出期限年月日 == null || 転出期限年月日.isEmpty()) {
            転出期限年月日 = FlexibleDate.EMPTY;
        }

        RDate 投票年月日 = null;
        if (null != div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getTxtTohyoYMD()) {
            投票年月日 = div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getTxtTohyoYMD().getValue();
        }
        if (BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体).equals(ZERO)
                && null != 投票年月日) {
            投票年月日 = 投票年月日.minusDay(1);
        } else if (BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体).equals(TWO)) {
            投票年月日 = RDate.getNowDate().minusDay(1);
        } else if (BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体).equals(THREE)) {
            投票年月日 = RDate.getNowDate();
        }
        if (!転出期限年月日.isEmpty() && !転出期限年月日.isMin()) {
            div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()
                    .setFromValue(new RDate(転出期限年月日.toString()));
        } else {
            div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()
                    .setFromValue(RDate.getNowDate());
        }
        div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().setToValue(投票年月日);
    }

    /**
     * 「選挙人を検索する」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData check入力内容() {
        ValidationMessageControlPairs controlErrorPairs = new NyujokenSakuseiIkkatsuValidationHandler(div).validateエラーチェックです();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlWarningPairs = new NyujokenSakuseiIkkatsuValidationHandler(div).validateウォーニングチェックです();
            if (controlWarningPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlWarningPairs).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下のチェックする。
     *
     * @param menuId RString
     * @return parameter AFABTB202BatchParameter
     */
    public AFABTB201BatchParameter set画面入力内容(RString menuId) {
        AFABTB201BatchParameter parameter = new AFABTB201BatchParameter();
        parameter.set抄本番号(div.getCcdNyujokenShohonSelect().get抄本番号());
        parameter.set選挙種類(div.getCcdNyujokenShohonSelect().getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        RString 抄本名 = div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getHidShohonName();
        parameter.set抄本名(抄本名 == null ? RString.EMPTY : 抄本名);
        parameter.set投票日(FlexibleDate.EMPTY);
        if (div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getTxtTohyoYMD().getValue() != null) {
            parameter.set投票日(new FlexibleDate(div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getTxtTohyoYMD().getValue().toDateString()));
        }
        parameter.set入場券名1(div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtFreeText1().getValue());
        parameter.set入場券名2(div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtFreeText2().getValue());
        parameter.set入場券名3(div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtFreeText3().getValue());
        List<RString> 出力対象リスト = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkTaisho().getSelectedKeys();
        if (出力対象リスト.contains(ONE)) {
            parameter.set住民分有無(Boolean.TRUE);
        } else {
            parameter.set住民分有無(Boolean.FALSE);
        }
        if (出力対象リスト.contains(TWO)) {
            parameter.set転出者分有無(Boolean.TRUE);
        } else {
            parameter.set転出者分有無(Boolean.FALSE);
        }
        parameter.set印刷タイプ(AFAInsakuTypeEnum.getAFAInsakuTypeEnumByValue(
                div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtNyujokenType().getValue()).getKey());
        if (!div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtPrintNinzutxtNyujokenType().isDisplayNone()) {
            parameter.set世帯印字人数(new RString(div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtPrintNinzutxtNyujokenType().getValue().toString()));
        }
        List<RString> 世帯で複数枚作成リスト = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkSetaiIchiran().getSelectedKeys();
        if (世帯で複数枚作成リスト.contains(ONE)) {
            parameter.set抽出対象世帯人数有無(Boolean.TRUE);
        } else {
            parameter.set抽出対象世帯人数有無(Boolean.FALSE);
        }
        parameter.set抽出対象世帯人数(div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtSetaiNinzu().getValue());
        if (null != div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().getFromValue()) {
            parameter.set転出日From(new FlexibleDate(div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().getFromValue().toDateString()));
        }
        if (null != div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().getToValue()) {
            parameter.set転出日To(new FlexibleDate(div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange().getToValue().toDateString()));
        }
        List<RString> 二重登録抹消者分リスト = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getChkNijuMassho().getSelectedKeys();
        if (二重登録抹消者分リスト.contains(KEY)) {
            parameter.set二重登録抹消者分も含める有無(Boolean.TRUE);
        } else {
            parameter.set二重登録抹消者分も含める有無(Boolean.FALSE);
        }
        List<RString> 宛名シールも発行リスト = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getChkAtenaSeal().getSelectedKeys();
        if (宛名シールも発行リスト.contains(KEY)) {
            parameter.set宛名シールも発行する有無(Boolean.TRUE);
        } else {
            parameter.set宛名シールも発行する有無(Boolean.FALSE);
        }

        List<Senkyomeishou> 選挙リスト = new ArrayList<>();

        List<dgShohonSelect_Row> dgShohonSelect_Row = div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getDgShohonSelect().getDataSource();
        for (dgShohonSelect_Row shohonSelect : dgShohonSelect_Row) {
            Senkyomeishou senkyomeishou = new Senkyomeishou();
            senkyomeishou.set選挙名称(shohonSelect.getTxtSenkyoName());
            senkyomeishou.set選挙略称(shohonSelect.getTxtLevel());
            senkyomeishou.set選挙番号(shohonSelect.getTxtNo());
            選挙リスト.add(senkyomeishou);
        }

        parameter.set選挙リスト(選挙リスト);

        List<TohyokuJyohou> 投票区リスト = new ArrayList<>();
        List<dgNyujokenTohyokuSelect_Row> dataList = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getDgNyujokenTohyokuSelect()
                .getDataSource();
        for (dgNyujokenTohyokuSelect_Row nyujokenKobetsuTaishosha_Row : dataList) {
            TohyokuJyohou tohyokuJyohou = new TohyokuJyohou();
            tohyokuJyohou.set投票区コード(nyujokenKobetsuTaishosha_Row.getTxtTohyokuCode());
            tohyokuJyohou.set投票区名(nyujokenKobetsuTaishosha_Row.getTxtTohyokuName());
            投票区リスト.add(tohyokuJyohou);
        }

        parameter.set投票区リスト(投票区リスト);

        RString サンプル文字 = setサンプル文字(menuId);
        parameter.setサンプル文字(サンプル文字);
        return parameter;
    }

    private RString setサンプル文字(RString menuId) {
        RString サンプル文字 = RString.EMPTY;
        if (AFAMenuId.AFAMNA2010_定時登録.menuId().equals(menuId) || AFAMenuId.AFAMNB4010_選挙時登録.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4030_入場券発行個別.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7010_期日前投票.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7020_当日投票.menuId().equals(menuId)) {
            サンプル文字 = 固定文字;
        }
        return サンプル文字;
    }

}
