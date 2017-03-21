/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nippo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.NippoGamenKyotsuKomoku;
import jp.co.ndensan.reams.af.afa.business.core.ShukeiSeirihyoParam;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 投票集計整理表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class ShukeiSeirihyoBreakEditor {

    private final ShukeiSeirihyoParam 投票集計整理表印刷用パラメータ;
    private final ShukeiSeirihyoParam 投票集計整理表不在者印刷用パラメータ;
    private final Map<Code, List<Integer>> 投票集計;
    private final Map<Code, List<Integer>> 投票集計不在者;
    private final Map<Code, List<Integer>> 選挙投票集計;
    private final Map<Code, List<Integer>> 選挙投票集計不在者;
    private final Map<Code, List<Integer>> 投票集計累計;
    private final Map<Code, List<Integer>> 投票集計不在者累計;
    private final Map<Code, List<Integer>> 選挙投票集計累計;
    private final Map<Code, List<Integer>> 選挙投票集計不在者累計;

    private static final RString 計 = new RString("計");
    private static final Code 本庁 = new Code("01");
    private static final Code 支所 = new Code("02");
    private static final Code 病院 = new Code("03");
    private static final Code 施設 = new Code("04");
    private static final Code 郵便 = new Code("05");
    private static final Code 他市町村 = new Code("06");
    private static final Code 船舶 = new Code("08");
    private static final Code 刑事施設 = new Code("09");
    private static final Code 少年院 = new Code("10");
    private static final Code 特定国外 = new Code("11");
    private static final Code 期日前 = new Code("6");
    private static final Code 不在者 = new Code("3");
    private final FlexibleDate 受理日;
    private NippoPSMPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public ShukeiSeirihyoBreakEditor(AFABTE503SelectProcessParameter parameter) {
        受理日 = parameter.get受理日();
        投票集計 = new HashMap<>();
        putMap(投票集計);
        選挙投票集計 = new HashMap<>();
        putMap(選挙投票集計);
        投票集計累計 = new HashMap<>();
        putMap(投票集計累計);
        選挙投票集計累計 = new HashMap<>();
        putMap(選挙投票集計累計);

        投票集計不在者 = new HashMap<>();
        putMap不在者(投票集計不在者);
        選挙投票集計不在者 = new HashMap<>();
        putMap不在者(選挙投票集計不在者);
        投票集計不在者累計 = new HashMap<>();
        putMap不在者(投票集計不在者累計);
        選挙投票集計不在者累計 = new HashMap<>();
        putMap不在者(選挙投票集計不在者累計);
        NippoGamenKyotsuKomoku 画面入力項目 = new NippoGamenKyotsuKomoku();
        画面入力項目.set投票区コード開始(parameter.get投票区コードFr());
        画面入力項目.set投票区コード終了(parameter.get投票区コードTo());
        画面入力項目.set受理日(toRDate(parameter.get受理日()));
        投票集計整理表印刷用パラメータ = new ShukeiSeirihyoParam(画面入力項目);
        投票集計整理表不在者印刷用パラメータ = new ShukeiSeirihyoParam(画面入力項目);
    }

    /**
     * usualProcess
     *
     * @param current NippoPSMPrintEntity
     */
    public void usualProcess(NippoPSMPrintEntity current) {
        lastData = current;
        投票集計整理表印刷用パラメータ.set投票区(current.get選挙人名簿Entity().getTohyokuCode());
        RString senkyoNo;
        if (null == current.get投票状況Entity().getSenkyoNo()) {
            senkyoNo = RString.EMPTY;
        } else {
            senkyoNo = new RString(current.get投票状況Entity().getSenkyoNo().value());
        }
        投票集計整理表印刷用パラメータ.set選挙番号(senkyoNo);
        Code 投票状況 = current.get投票状況Entity().getTohyoJokyo();
        Code 受理施設種別 = current.get投票状況Entity().getJuriShisetsuShubetsu();
        if (受理日.equals(current.get投票状況Entity().getJuriYMD())) {
            投票計数(current, 投票集計, 投票状況);
            投票計数(current, 投票集計, 受理施設種別);
            投票計数(current, 選挙投票集計, 投票状況);
            投票計数(current, 選挙投票集計, 受理施設種別);
        }
        投票計数(current, 投票集計累計, 投票状況);
        投票計数(current, 投票集計累計, 受理施設種別);
        投票計数(current, 選挙投票集計累計, 投票状況);
        投票計数(current, 選挙投票集計累計, 受理施設種別);
    }

    /**
     * usualProcessFuzaisha
     *
     * @param current NippoPSMPrintEntity
     */
    public void usualProcessFuzaisha(NippoPSMPrintEntity current) {
        投票集計整理表不在者印刷用パラメータ.set投票区(current.get選挙人名簿Entity().getTohyokuCode());
        RString senkyoNo;
        if (null == current.get投票状況Entity().getSenkyoNo()) {
            senkyoNo = RString.EMPTY;
        } else {
            senkyoNo = new RString(current.get投票状況Entity().getSenkyoNo().value());
        }
        投票集計整理表不在者印刷用パラメータ.set選挙番号(senkyoNo);
        Code 受理施設種別 = current.get投票状況Entity().getJuriShisetsuShubetsu();
        if (受理日.equals(current.get投票状況Entity().getJuriYMD())) {
            投票計数(current, 投票集計不在者, 受理施設種別);
            投票計数(current, 選挙投票集計不在者, 受理施設種別);
        }
        投票計数(current, 投票集計不在者累計, 受理施設種別);
        投票計数(current, 選挙投票集計不在者累計, 受理施設種別);
    }

    /**
     * keyBreakProcessByTohyokuCode
     *
     * @param before before
     * @param current current
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam keyBreakProcessByTohyokuCode(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew投票区(before, current)) {
            投票集計整理表印刷用パラメータ.set不在者投票フラグ(false);
            項目設定(投票集計);
            putMap(投票集計);
            累計項目設定(投票集計累計);
            putMap(投票集計累計);
            return 投票集計整理表印刷用パラメータ;
        }
        return null;
    }

    /**
     * keyBreakProcessByTohyokuCodeFuzaisha
     *
     * @param before before
     * @param current current
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam keyBreakProcessByTohyokuCodeFuzaisha(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew投票区(before, current)) {
            投票集計整理表不在者印刷用パラメータ.set不在者投票フラグ(true);
            項目設定不在者(投票集計不在者);
            putMap不在者(投票集計不在者);
            累計項目設定不在者(投票集計不在者累計);
            putMap不在者(投票集計不在者累計);
            return 投票集計整理表不在者印刷用パラメータ;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyoNo
     *
     * @param before before
     * @param current current
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam keyBreakProcessBySenkyoNo(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew選挙(before, current) && !isNew投票区(before, current)) {
            投票集計整理表印刷用パラメータ.set不在者投票フラグ(false);
            項目設定(投票集計);
            putMap(投票集計);
            累計項目設定(投票集計累計);
            putMap(投票集計累計);
            return 投票集計整理表印刷用パラメータ;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyoNo1
     *
     * @param before before
     * @param current current
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam keyBreakProcessBySenkyoNo1(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew選挙(before, current)) {
            投票集計整理表印刷用パラメータ.set投票区(計);
            投票集計整理表印刷用パラメータ.set不在者投票フラグ(false);
            項目設定(選挙投票集計);
            putMap(選挙投票集計);
            累計項目設定(選挙投票集計累計);
            putMap(選挙投票集計累計);
            return 投票集計整理表印刷用パラメータ;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyoNoFuzaisha
     *
     * @param before before
     * @param current current
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam keyBreakProcessBySenkyoNoFuzaisha(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew選挙(before, current) && !isNew投票区(before, current)) {
            投票集計整理表不在者印刷用パラメータ.set不在者投票フラグ(true);
            項目設定不在者(投票集計不在者);
            putMap不在者(投票集計不在者);
            累計項目設定不在者(投票集計不在者累計);
            putMap不在者(投票集計不在者累計);
            return 投票集計整理表不在者印刷用パラメータ;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyoNoFuzaisha1
     *
     * @param before before
     * @param current current
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam keyBreakProcessBySenkyoNoFuzaisha1(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew選挙(before, current)) {
            投票集計整理表不在者印刷用パラメータ.set不在者投票フラグ(true);
            項目設定不在者(選挙投票集計不在者);
            putMap不在者(選挙投票集計不在者);
            累計項目設定不在者(選挙投票集計不在者累計);
            putMap不在者(選挙投票集計不在者累計);
            return 投票集計整理表不在者印刷用パラメータ;
        }
        return null;
    }

    /**
     * createLastProcess1
     *
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam createLastProcess1() {
        if (null == lastData) {
            return null;
        }
        投票集計整理表印刷用パラメータ.set不在者投票フラグ(false);
        項目設定(投票集計);
        putMap(投票集計);
        累計項目設定(投票集計累計);
        putMap(投票集計累計);
        return 投票集計整理表印刷用パラメータ;
    }

    /**
     * createLastProcess2
     *
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam createLastProcess2() {
        if (null == lastData) {
            return null;
        }
        投票集計整理表印刷用パラメータ.set不在者投票フラグ(false);
        投票集計整理表印刷用パラメータ.set投票区(計);
        項目設定(選挙投票集計);
        putMap(選挙投票集計);
        累計項目設定(選挙投票集計累計);
        putMap(選挙投票集計累計);
        return 投票集計整理表印刷用パラメータ;
    }

    /**
     * createLastProcessFuzaisha1
     *
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam createLastProcessFuzaisha1() {
        if (null == lastData) {
            return null;
        }
        投票集計整理表不在者印刷用パラメータ.set不在者投票フラグ(true);
        項目設定不在者(投票集計不在者);
        putMap不在者(投票集計不在者);
        累計項目設定不在者(投票集計不在者累計);
        putMap不在者(投票集計不在者累計);
        return 投票集計整理表不在者印刷用パラメータ;
    }

    /**
     * createLastProcessFuzaisha2
     *
     * @return ShukeiSeirihyoParam
     */
    public ShukeiSeirihyoParam createLastProcessFuzaisha2() {
        if (null == lastData) {
            return null;
        }
        投票集計整理表不在者印刷用パラメータ.set不在者投票フラグ(true);
        投票集計整理表不在者印刷用パラメータ.set投票区(計);
        項目設定不在者(選挙投票集計不在者);
        putMap不在者(選挙投票集計不在者);
        累計項目設定不在者(選挙投票集計不在者累計);
        putMap不在者(選挙投票集計不在者累計);
        return 投票集計整理表不在者印刷用パラメータ;
    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPSMPrintEntity current, Map<Code, List<Integer>> map, Code code) {
        if (map.containsKey(code)) {
            List<Integer> 計数 = new ArrayList<>();
            Integer 男計数 = map.get(code).get(0);
            Integer 女計数 = map.get(code).get(1);
            if (new RString("1").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
                男計数 = 男計数 + 1;
            } else {
                女計数 = 女計数 + 1;
            }
            計数.add(男計数);
            計数.add(女計数);
            計数.add(男計数 + 女計数);
            map.put(code, 計数);
        }
    }

    /**
     * 項目を設定設定する。
     *
     */
    private void 項目設定(Map<Code, List<Integer>> map) {
        if (!投票集計整理表印刷用パラメータ.is不在者投票フラグ()) {
            投票集計整理表印刷用パラメータ.set本庁_男(toZZZ_ZZ9編集(map.get(本庁).get(0)));
            投票集計整理表印刷用パラメータ.set本庁_女(toZZZ_ZZ9編集(map.get(本庁).get(1)));
            投票集計整理表印刷用パラメータ.set本庁_計(toZZZ_ZZ9編集(map.get(本庁).get(2)));
            投票集計整理表印刷用パラメータ.set支所_男(toZZZ_ZZ9編集(map.get(支所).get(0)));
            投票集計整理表印刷用パラメータ.set支所_女(toZZZ_ZZ9編集(map.get(支所).get(1)));
            投票集計整理表印刷用パラメータ.set支所_計(toZZZ_ZZ9編集(map.get(支所).get(2)));
            投票集計整理表印刷用パラメータ.set項目６_男(toZZZ_ZZ9編集(map.get(期日前).get(0)));
            投票集計整理表印刷用パラメータ.set項目６_女(toZZZ_ZZ9編集(map.get(期日前).get(1)));
            投票集計整理表印刷用パラメータ.set項目６_計(toZZZ_ZZ9編集(map.get(期日前).get(2)));
            投票集計整理表印刷用パラメータ.set項目７_男(toZZZ_ZZ9編集(map.get(不在者).get(0)));
            投票集計整理表印刷用パラメータ.set項目７_女(toZZZ_ZZ9編集(map.get(不在者).get(1)));
            投票集計整理表印刷用パラメータ.set項目７_計(toZZZ_ZZ9編集(map.get(不在者).get(2)));
            投票集計整理表印刷用パラメータ.set合計_男(toZZZ_ZZ9編集(map.get(本庁).get(0)
                    + map.get(支所).get(0)
                    + map.get(期日前).get(0)
                    + map.get(不在者).get(0)));
            投票集計整理表印刷用パラメータ.set合計_女(toZZZ_ZZ9編集(map.get(本庁).get(1)
                    + map.get(支所).get(1)
                    + map.get(期日前).get(1)
                    + map.get(不在者).get(1)));
            投票集計整理表印刷用パラメータ.set合計_計(toZZZ_ZZ9編集(map.get(本庁).get(2)
                    + map.get(支所).get(2)
                    + map.get(期日前).get(2)
                    + map.get(不在者).get(2)));
        }
    }

    /**
     * 不在者項目を設定する。
     *
     */
    private void 項目設定不在者(Map<Code, List<Integer>> map) {
        if (投票集計整理表不在者印刷用パラメータ.is不在者投票フラグ()) {
            投票集計整理表不在者印刷用パラメータ.set本庁_男(toZZZ_ZZ9編集(map.get(本庁).get(0)));
            投票集計整理表不在者印刷用パラメータ.set本庁_女(toZZZ_ZZ9編集(map.get(本庁).get(1)));
            投票集計整理表不在者印刷用パラメータ.set本庁_計(toZZZ_ZZ9編集(map.get(本庁).get(2)));
            投票集計整理表不在者印刷用パラメータ.set支所_男(toZZZ_ZZ9編集(map.get(支所).get(0)));
            投票集計整理表不在者印刷用パラメータ.set支所_女(toZZZ_ZZ9編集(map.get(支所).get(1)));
            投票集計整理表不在者印刷用パラメータ.set支所_計(toZZZ_ZZ9編集(map.get(支所).get(2)));
            投票集計整理表不在者印刷用パラメータ.set項目１_男(toZZZ_ZZ9編集(map.get(他市町村).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目１_女(toZZZ_ZZ9編集(map.get(他市町村).get(1)));
            投票集計整理表不在者印刷用パラメータ.set項目１_計(toZZZ_ZZ9編集(map.get(他市町村).get(2)));
            投票集計整理表不在者印刷用パラメータ.set項目２_男(toZZZ_ZZ9編集(map.get(病院).get(0) + map.get(施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目２_女(toZZZ_ZZ9編集(map.get(病院).get(1) + map.get(施設).get(1)));
            投票集計整理表不在者印刷用パラメータ.set項目２_計(toZZZ_ZZ9編集(map.get(病院).get(2) + map.get(施設).get(2)));
            投票集計整理表不在者印刷用パラメータ.set項目３_男(toZZZ_ZZ9編集(map.get(郵便).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目３_女(toZZZ_ZZ9編集(map.get(郵便).get(1)));
            投票集計整理表不在者印刷用パラメータ.set項目３_計(toZZZ_ZZ9編集(map.get(郵便).get(2)));
            投票集計整理表不在者印刷用パラメータ.set項目４_男(toZZZ_ZZ9編集(map.get(船舶).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目４_女(toZZZ_ZZ9編集(map.get(船舶).get(1)));
            投票集計整理表不在者印刷用パラメータ.set項目４_計(toZZZ_ZZ9編集(map.get(船舶).get(2)));
            投票集計整理表不在者印刷用パラメータ.set項目５_男(toZZZ_ZZ9編集(map.get(刑事施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目５_女(toZZZ_ZZ9編集(map.get(刑事施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目５_計(toZZZ_ZZ9編集(map.get(刑事施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目６_男(toZZZ_ZZ9編集(map.get(少年院).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目６_女(toZZZ_ZZ9編集(map.get(少年院).get(1)));
            投票集計整理表不在者印刷用パラメータ.set項目６_計(toZZZ_ZZ9編集(map.get(少年院).get(2)));
            投票集計整理表不在者印刷用パラメータ.set項目７_男(toZZZ_ZZ9編集(map.get(特定国外).get(0)));
            投票集計整理表不在者印刷用パラメータ.set項目７_女(toZZZ_ZZ9編集(map.get(特定国外).get(1)));
            投票集計整理表不在者印刷用パラメータ.set項目７_計(toZZZ_ZZ9編集(map.get(特定国外).get(2)));
            投票集計整理表不在者印刷用パラメータ.set合計_男(toZZZ_ZZ9編集(map.get(本庁).get(0)
                    + map.get(支所).get(0)
                    + map.get(他市町村).get(0)
                    + map.get(病院).get(0)
                    + map.get(施設).get(0)
                    + map.get(郵便).get(0)
                    + map.get(船舶).get(0)
                    + map.get(刑事施設).get(0)
                    + map.get(少年院).get(0)
                    + map.get(特定国外).get(0)));
            投票集計整理表不在者印刷用パラメータ.set合計_女(toZZZ_ZZ9編集(map.get(本庁).get(1)
                    + map.get(支所).get(1)
                    + map.get(他市町村).get(1)
                    + map.get(病院).get(1)
                    + map.get(施設).get(1)
                    + map.get(郵便).get(1)
                    + map.get(船舶).get(1)
                    + map.get(刑事施設).get(1)
                    + map.get(少年院).get(1)
                    + map.get(特定国外).get(1)));
            投票集計整理表不在者印刷用パラメータ.set合計_計(toZZZ_ZZ9編集(map.get(本庁).get(2)
                    + map.get(支所).get(2)
                    + map.get(他市町村).get(2)
                    + map.get(病院).get(2)
                    + map.get(施設).get(2)
                    + map.get(郵便).get(2)
                    + map.get(船舶).get(2)
                    + map.get(刑事施設).get(2)
                    + map.get(少年院).get(2)
                    + map.get(特定国外).get(2)));
        }
    }

    /**
     * 累計項目を設定する。
     *
     */
    private void 累計項目設定(Map<Code, List<Integer>> map) {
        if (!投票集計整理表印刷用パラメータ.is不在者投票フラグ()) {
            投票集計整理表印刷用パラメータ.set累計_本庁_男(toZZZ_ZZ9編集(map.get(本庁).get(0)));
            投票集計整理表印刷用パラメータ.set累計_本庁_女(toZZZ_ZZ9編集(map.get(本庁).get(1)));
            投票集計整理表印刷用パラメータ.set累計_本庁_計(toZZZ_ZZ9編集(map.get(本庁).get(2)));
            投票集計整理表印刷用パラメータ.set累計_支所_男(toZZZ_ZZ9編集(map.get(支所).get(0)));
            投票集計整理表印刷用パラメータ.set累計_支所_女(toZZZ_ZZ9編集(map.get(支所).get(1)));
            投票集計整理表印刷用パラメータ.set累計_支所_計(toZZZ_ZZ9編集(map.get(支所).get(2)));
            投票集計整理表印刷用パラメータ.set累計_項目６_男(toZZZ_ZZ9編集(map.get(期日前).get(0)));
            投票集計整理表印刷用パラメータ.set累計_項目６_女(toZZZ_ZZ9編集(map.get(期日前).get(1)));
            投票集計整理表印刷用パラメータ.set累計_項目６_計(toZZZ_ZZ9編集(map.get(期日前).get(2)));
            投票集計整理表印刷用パラメータ.set累計_項目７_男(toZZZ_ZZ9編集(map.get(不在者).get(0)));
            投票集計整理表印刷用パラメータ.set累計_項目７_女(toZZZ_ZZ9編集(map.get(不在者).get(1)));
            投票集計整理表印刷用パラメータ.set累計_項目７_計(toZZZ_ZZ9編集(map.get(不在者).get(2)));
            投票集計整理表印刷用パラメータ.set累計_合計_男(toZZZ_ZZ9編集(map.get(本庁).get(0)
                    + map.get(支所).get(0)
                    + map.get(期日前).get(0)
                    + map.get(不在者).get(0)));
            投票集計整理表印刷用パラメータ.set累計_合計_女(toZZZ_ZZ9編集(map.get(本庁).get(1)
                    + map.get(支所).get(1)
                    + map.get(期日前).get(1)
                    + map.get(不在者).get(1)));
            投票集計整理表印刷用パラメータ.set累計_合計_計(toZZZ_ZZ9編集(map.get(本庁).get(2)
                    + map.get(支所).get(2)
                    + map.get(期日前).get(2)
                    + map.get(不在者).get(2)));
        }
    }

    /**
     * 不在者累計項目を設定する。
     *
     */
    private void 累計項目設定不在者(Map<Code, List<Integer>> map) {
        if (投票集計整理表不在者印刷用パラメータ.is不在者投票フラグ()) {
            投票集計整理表不在者印刷用パラメータ.set累計_本庁_男(toZZZ_ZZ9編集(map.get(本庁).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_本庁_女(toZZZ_ZZ9編集(map.get(本庁).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_本庁_計(toZZZ_ZZ9編集(map.get(本庁).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_支所_男(toZZZ_ZZ9編集(map.get(支所).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_支所_女(toZZZ_ZZ9編集(map.get(支所).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_支所_計(toZZZ_ZZ9編集(map.get(支所).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目１_男(toZZZ_ZZ9編集(map.get(他市町村).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目１_女(toZZZ_ZZ9編集(map.get(他市町村).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目１_計(toZZZ_ZZ9編集(map.get(他市町村).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目２_男(toZZZ_ZZ9編集(map.get(病院).get(0) + map.get(施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目２_女(toZZZ_ZZ9編集(map.get(病院).get(1) + map.get(施設).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目２_計(toZZZ_ZZ9編集(map.get(病院).get(2) + map.get(施設).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目３_男(toZZZ_ZZ9編集(map.get(郵便).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目３_女(toZZZ_ZZ9編集(map.get(郵便).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目３_計(toZZZ_ZZ9編集(map.get(郵便).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目４_男(toZZZ_ZZ9編集(map.get(船舶).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目４_女(toZZZ_ZZ9編集(map.get(船舶).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目４_計(toZZZ_ZZ9編集(map.get(船舶).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目５_男(toZZZ_ZZ9編集(map.get(刑事施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目５_女(toZZZ_ZZ9編集(map.get(刑事施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目５_計(toZZZ_ZZ9編集(map.get(刑事施設).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目６_男(toZZZ_ZZ9編集(map.get(少年院).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目６_女(toZZZ_ZZ9編集(map.get(少年院).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目６_計(toZZZ_ZZ9編集(map.get(少年院).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目７_男(toZZZ_ZZ9編集(map.get(特定国外).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目７_女(toZZZ_ZZ9編集(map.get(特定国外).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_項目７_計(toZZZ_ZZ9編集(map.get(特定国外).get(2)));
            投票集計整理表不在者印刷用パラメータ.set累計_合計_男(toZZZ_ZZ9編集(map.get(本庁).get(0)
                    + map.get(支所).get(0)
                    + map.get(他市町村).get(0)
                    + map.get(病院).get(0)
                    + map.get(施設).get(0)
                    + map.get(郵便).get(0)
                    + map.get(船舶).get(0)
                    + map.get(刑事施設).get(0)
                    + map.get(少年院).get(0)
                    + map.get(特定国外).get(0)));
            投票集計整理表不在者印刷用パラメータ.set累計_合計_女(toZZZ_ZZ9編集(map.get(本庁).get(1)
                    + map.get(支所).get(1)
                    + map.get(他市町村).get(1)
                    + map.get(病院).get(1)
                    + map.get(施設).get(1)
                    + map.get(郵便).get(1)
                    + map.get(船舶).get(1)
                    + map.get(刑事施設).get(1)
                    + map.get(少年院).get(1)
                    + map.get(特定国外).get(1)));
            投票集計整理表不在者印刷用パラメータ.set累計_合計_計(toZZZ_ZZ9編集(map.get(本庁).get(2)
                    + map.get(支所).get(2)
                    + map.get(他市町村).get(2)
                    + map.get(病院).get(2)
                    + map.get(施設).get(2)
                    + map.get(郵便).get(2)
                    + map.get(船舶).get(2)
                    + map.get(刑事施設).get(2)
                    + map.get(少年院).get(2)
                    + map.get(特定国外).get(2)));
        }
    }

    /**
     * 投票区コード集計。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew投票区(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null == before) {
            return false;
        }
        RString 投票区コード前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区コード現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 投票区コード前 && null != 投票区コード現 && 投票区コード前.equals(投票区コード現));

    }

    /**
     * 選挙番号集計。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew選挙(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null == before) {
            return false;
        }
        SenkyoNo 選挙番号前 = before.get投票状況Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get投票状況Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));

    }

    private RDate toRDate(FlexibleDate 日付) {
        if (null == 日付 || 日付.isEmpty()) {
            return null;
        }
        return new RDate(日付.toString());
    }

    private RString toZZZ_ZZ9編集(Integer value) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(value), 0);

    }

    private void putMap(Map<Code, List<Integer>> map) {
        List<Integer> 初期数 = new ArrayList<>();
        初期数.add(0);
        初期数.add(0);
        初期数.add(0);
        map.put(本庁, 初期数);
        map.put(支所, 初期数);
        map.put(期日前, 初期数);
        map.put(不在者, 初期数);
    }

    private void putMap不在者(Map<Code, List<Integer>> map) {
        List<Integer> 初期数 = new ArrayList<>();
        初期数.add(0);
        初期数.add(0);
        初期数.add(0);
        map.put(本庁, 初期数);
        map.put(支所, 初期数);
        map.put(病院, 初期数);
        map.put(施設, 初期数);
        map.put(郵便, 初期数);
        map.put(他市町村, 初期数);
        map.put(船舶, 初期数);
        map.put(刑事施設, 初期数);
        map.put(少年院, 初期数);
        map.put(特定国外, 初期数);
    }

}
