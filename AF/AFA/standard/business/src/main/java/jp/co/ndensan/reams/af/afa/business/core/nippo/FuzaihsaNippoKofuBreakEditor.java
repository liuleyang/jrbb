/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nippo;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.FuzaihsaNippoParam;
import jp.co.ndensan.reams.af.afa.business.core.NippoGamenKyotsuKomoku;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJyohyoInfo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 不在者投票交付日報帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class FuzaihsaNippoKofuBreakEditor {

    private final FuzaihsaNippoParam 不在者投票交付日報;
    private final Map<Code, Integer> 計数;
    private final Map<Code, Integer> 点字計数;
    private final Map<Code, Integer> 選挙計数;
    private final Map<Code, Integer> 選挙点字計数;
    private static final Code 本庁 = new Code("01");
    private static final Code 支所 = new Code("02");
    private static final Code 病院 = new Code("03");
    private static final Code 施設 = new Code("04");
    private static final Code 郵便 = new Code("05");
    private static final Code 他市町村選挙管理委員会 = new Code("06");
    private static final Code 他市町村施設 = new Code("07");
    private static final Code 船舶 = new Code("08");
    private static final Code 刑事施設等 = new Code("09");
    private static final Code 少年院等 = new Code("10");
    private static final Code 特定国外派遣組織 = new Code("11");
    private static final RString 合計 = new RString("＊　合　計　＊");
    private NippoPSMPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public FuzaihsaNippoKofuBreakEditor(AFABTE503SelectProcessParameter parameter) {
        計数 = new HashMap<>();
        putMap(計数);
        点字計数 = new HashMap<>();
        putMap(点字計数);
        選挙計数 = new HashMap<>();
        putMap(選挙計数);
        選挙点字計数 = new HashMap<>();
        putMap(選挙点字計数);
        NippoGamenKyotsuKomoku 画面入力項目 = new NippoGamenKyotsuKomoku();
        TohyoJyohyoInfo 投票状況情報 = new TohyoJyohyoInfo();
        画面入力項目.set交付日開始(toRDate(parameter.get交付日Fr()));
        画面入力項目.set交付日終了(toRDate(parameter.get交付日To()));
        不在者投票交付日報 = new FuzaihsaNippoParam(投票状況情報, 画面入力項目);
    }

    /**
     * usualProcess
     *
     * @param current NippoPSMPrintEntity
     * @param 施設種別 Code
     */
    public void usualProcessCount(NippoPSMPrintEntity current, Code 施設種別) {
        投票計数(current, 施設種別);
        lastData = current;
    }

    /**
     * keyBreakProcessByTohyobi
     *
     * @param before NippoPSMPrintEntity
     * @param current NippoPSMPrintEntity
     * @return FuzaihsaNippoParam
     */
    public FuzaihsaNippoParam keyBreakProcessByTohyobi(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew投票日(before, current)) {
            setFuzaihsaNippo(計数, 点字計数);
            putMap(計数);
            putMap(点字計数);
            return 不在者投票交付日報;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyo
     *
     * @param before NippoPSMPrintEntity
     * @param current NippoPSMPrintEntity
     * @return FuzaihsaNippoParam
     */
    public FuzaihsaNippoParam keyBreakProcessBySenkyo(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew選挙(before, current) && !isNew投票日(before, current)) {
            setFuzaihsaNippo(計数, 点字計数);
            putMap(計数);
            putMap(点字計数);
            return 不在者投票交付日報;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyo1
     *
     * @param before NippoPSMPrintEntity
     * @param current NippoPSMPrintEntity
     * @return FuzaihsaNippoParam
     */
    public FuzaihsaNippoParam keyBreakProcessBySenkyo1(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (isNew選挙(before, current)) {
            不在者投票交付日報.get投票状況情報().set日付(合計);
            setFuzaihsaNippo(選挙計数, 選挙点字計数);
            putMap(選挙計数);
            putMap(選挙点字計数);
            return 不在者投票交付日報;
        }
        return null;
    }

    /**
     * createLastProcess1
     *
     * @return FuzaihsaNippoParam
     */
    public FuzaihsaNippoParam createLastProcess1() {
        if (null == lastData) {
            return null;
        }
        setFuzaihsaNippo(計数, 点字計数);
        return 不在者投票交付日報;
    }

    /**
     * createLastProcess2
     *
     * @return FuzaihsaNippoParam
     */
    public FuzaihsaNippoParam createLastProcess2() {
        if (null == lastData) {
            return null;
        }
        不在者投票交付日報.get投票状況情報().set日付(合計);
        setFuzaihsaNippo(選挙計数, 選挙点字計数);
        return 不在者投票交付日報;
    }

    private void setFuzaihsaNippo(Map<Code, Integer> map, Map<Code, Integer> map点数) {
        不在者投票交付日報.set施設数(toZZZ_ZZ9編集(new RString(map.get(病院)
                + map.get(施設)
                + map.get(他市町村施設)
                + map.get(船舶)
                + map.get(刑事施設等)
                + map.get(少年院等)
                + map.get(特定国外派遣組織))));
        不在者投票交付日報.set施設点字数(toZZZ_ZZ9編集(new RString(map点数.get(病院)
                + map点数.get(施設)
                + map点数.get(他市町村施設)
                + map点数.get(船舶)
                + map点数.get(刑事施設等)
                + map点数.get(少年院等)
                + map点数.get(特定国外派遣組織))));
        不在者投票交付日報.set合計数(toZZZ_ZZ9編集(new RString(map.get(本庁)
                + map.get(支所)
                + map.get(病院)
                + map.get(施設)
                + map.get(他市町村施設)
                + map.get(郵便)
                + map.get(他市町村選挙管理委員会)
                + map.get(船舶)
                + map.get(刑事施設等)
                + map.get(少年院等)
                + map.get(特定国外派遣組織))));
        不在者投票交付日報.set合計点字数(toZZZ_ZZ9編集(new RString(map点数.get(本庁)
                + map点数.get(支所)
                + map点数.get(病院)
                + map点数.get(施設)
                + map点数.get(他市町村施設)
                + map点数.get(郵便)
                + map点数.get(他市町村選挙管理委員会)
                + map点数.get(船舶)
                + map点数.get(刑事施設等)
                + map点数.get(少年院等)
                + map点数.get(特定国外派遣組織))));
        不在者投票交付日報.set本庁数(toZZZ_ZZ9編集(new RString(map.get(本庁))));
        不在者投票交付日報.set本庁点字数(toZZZ_ZZ9編集(new RString(map点数.get(本庁))));
        不在者投票交付日報.set郵便数(toZZZ_ZZ9編集(new RString(map.get(郵便))));
        不在者投票交付日報.set郵便点字数(toZZZ_ZZ9編集(new RString(map点数.get(郵便))));
        不在者投票交付日報.set他市町村数(toZZZ_ZZ9編集(new RString(map.get(他市町村選挙管理委員会))));
        不在者投票交付日報.set他市町村点字数(toZZZ_ZZ9編集(new RString(map点数.get(他市町村選挙管理委員会))));
        不在者投票交付日報.set支所数(toZZZ_ZZ9編集(new RString(map.get(支所))));
        不在者投票交付日報.set支所点字数(toZZZ_ZZ9編集(new RString(map点数.get(支所))));

    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPSMPrintEntity current, Code 施設種別) {
        不在者投票交付日報.get投票状況情報().set交付_受理フラグ(true);
        不在者投票交付日報.get投票状況情報().set交付年月日(toRDate(current.get投票状況Entity().getKofuYMD()));
        不在者投票交付日報.get投票状況情報().set受理年月日(toRDate(current.get投票状況Entity().getJuriYMD()));
        不在者投票交付日報.get投票状況情報().set施設コード(current.get投票状況Entity().getShisetsuCode());
        不在者投票交付日報.get投票状況情報().set投票日(toRDate(current.get投票状況Entity().getJuriYMD()));
        不在者投票交付日報.get投票状況情報().set日付(toWareki(current.get投票状況Entity().getKofuYMD()));
        不在者投票交付日報.get投票状況情報().set選挙番号(new RString(current.get投票状況Entity().getSenkyoNo().value()));
        boolean 点字フラグ = current.get投票状況Entity().getTenjiFlag();
        if (計数.containsKey(施設種別)) {
            計数.put(施設種別, 計数.get(施設種別) + 1);
            選挙計数.put(施設種別, 選挙計数.get(施設種別) + 1);
        }
        if (点字計数.containsKey(施設種別) && 点字フラグ) {
            点字計数.put(施設種別, 点字計数.get(施設種別) + 1);
            選挙点字計数.put(施設種別, 選挙点字計数.get(施設種別) + 1);
        }
    }

    /**
     * 投票日集計。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew投票日(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null == before) {
            return false;
        }
        FlexibleDate 投票日前 = before.get投票状況Entity().getKofuYMD();
        FlexibleDate 投票日現 = current.get投票状況Entity().getKofuYMD();

        return !(null != 投票日前 && null != 投票日現 && 投票日前.equals(投票日現));

    }

    /**
     * 選挙集計。
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

    private RString toWareki(FlexibleDate 日付) {
        if (null == 日付 || 日付.isEmpty()) {
            return null;
        }
//        return 日付.wareki().toDateString();
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString toZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }
    }

    private void putMap(Map<Code, Integer> map) {
        map.put(本庁, 0);
        map.put(支所, 0);
        map.put(病院, 0);
        map.put(施設, 0);
        map.put(郵便, 0);
        map.put(他市町村選挙管理委員会, 0);
        map.put(他市町村施設, 0);
        map.put(船舶, 0);
        map.put(刑事施設等, 0);
        map.put(少年院等, 0);
        map.put(特定国外派遣組織, 0);
    }
}
