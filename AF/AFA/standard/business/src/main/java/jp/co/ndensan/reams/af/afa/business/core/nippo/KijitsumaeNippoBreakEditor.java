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
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeNippoParam;
import jp.co.ndensan.reams.af.afa.business.core.NippoGamenKyotsuKomoku;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJyohyoInfo;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
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
 * 期日前投票日報帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class KijitsumaeNippoBreakEditor {

    private final KijitsumaeNippoParam 期日前投票日報;
    private TohyoJyohyoInfo 投票状況情報;
    private final NippoGamenKyotsuKomoku 画面入力項目;
    private final Map<RString, Integer> 計数;
    private final Map<RString, Integer> 選挙計数;
    private final Map<RString, Integer> 施設計数;
    private final Map<RString, Integer> 表示者計数;
    private final Map<RString, Integer> 死亡者計数;
    private final Map<FlexibleDate, Map<RString, Integer>> 投票日別での計数Map;
    private final RString 男 = new RString("1");
    private final RString 女 = new RString("2");
    private final RString 点字男 = new RString("3");
    private final RString 点字女 = new RString("4");
    private final RString 代理男 = new RString("5");
    private final RString 代理女 = new RString("6");
    private static final RString 出力施設集計分 = new RString("出力施設集計分");
    private static final RString 施設合計 = new RString("施設合計");
    private static final RString 選挙合計 = new RString("選挙合計");
    private static final RString 死亡者投票分 = new RString("死亡者投票分");
    private static final RString 表示者投票分 = new RString("表示者投票分");
    private NippoPSMPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public KijitsumaeNippoBreakEditor(AFABTE503SelectProcessParameter parameter) {
        計数 = new HashMap<>();
        initializeMap(計数);
        選挙計数 = new HashMap<>();
        initializeMap(選挙計数);
        施設計数 = new HashMap<>();
        initializeMap(施設計数);
        表示者計数 = new HashMap<>();
        initializeMap(表示者計数);
        死亡者計数 = new HashMap<>();
        initializeMap(死亡者計数);
        投票日別での計数Map = new HashMap<>();
        画面入力項目 = new NippoGamenKyotsuKomoku();
        画面入力項目.set施設コード開始(parameter.get施設コードFr());
        画面入力項目.set施設コード終了(parameter.get施設コードTo());
        画面入力項目.set投票日開始(toRDate(parameter.get投票日Fr()));
        画面入力項目.set投票日終了(toRDate(parameter.get投票日To()));
        期日前投票日報 = new KijitsumaeNippoParam(null, 画面入力項目);
    }

    /**
     * usualProcessCount
     *
     * @param current NippoPSMPrintEntity
     */
    public void usualProcess(NippoPSMPrintEntity current) {
        lastData = current;
        投票計数(current, 計数);
        投票計数(current, 選挙計数);
        投票計数(current, 施設計数);
        if (is死亡者()) {
            投票計数(current, 死亡者計数);
        }
        if (is表示者(current)) {
            投票計数(current, 表示者計数);
        }
        投票状況情報 = new TohyoJyohyoInfo();
        投票状況情報.set交付_受理フラグ(true);
        投票状況情報.set交付年月日(toRDate(current.get投票状況Entity().getKofuYMD()));
        投票状況情報.set受理年月日(toRDate(current.get投票状況Entity().getJuriYMD()));
        投票状況情報.set施設コード(current.get投票状況Entity().getShisetsuCode());
        投票状況情報.set投票日(toRDate(current.get投票状況Entity().getJuriYMD()));
        投票状況情報.set選挙番号(new RString(current.get投票状況Entity().getSenkyoNo().toString()));
        期日前投票日報.set投票状況情報(投票状況情報);
        期日前投票日報.set施設名称(current.get施設Entity() == null ? RString.EMPTY : current.get施設Entity().getShisetsuName());
        put投票日別での計数Map(current.get投票状況Entity().getJuriYMD());
    }

    private void put投票日別での計数Map(FlexibleDate 投票日) {
        Map<RString, Integer> map = 投票日別での計数Map.get(投票日);
        if (map == null) {
            投票日別での計数Map.put(投票日, 計数);
        } else {
            投票日別での計数Map.put(投票日, update投票日の計数Map(map));
        }
    }

    private Map<RString, Integer> update投票日の計数Map(Map<RString, Integer> old投票日の計数Map) {
        old投票日の計数Map.put(男, old投票日の計数Map.get(男) + 計数.get(男));
        old投票日の計数Map.put(女, old投票日の計数Map.get(女) + 計数.get(女));
        old投票日の計数Map.put(点字男, old投票日の計数Map.get(点字男) + 計数.get(点字男));
        old投票日の計数Map.put(点字女, old投票日の計数Map.get(点字女) + 計数.get(点字女));
        old投票日の計数Map.put(代理男, old投票日の計数Map.get(代理男) + 計数.get(代理男));
        old投票日の計数Map.put(代理女, old投票日の計数Map.get(代理女) + 計数.get(代理女));
        return old投票日の計数Map;
    }

    /**
     * createLastProcess
     *
     * @return KijitsumaeNippoParam
     */
    public KijitsumaeNippoParam createLastProcess1() {
        if (null == lastData) {
            return null;
        }
        set印刷用パラメータ(計数, dateToString(lastData.get投票状況Entity().getJuriYMD()));
        return 期日前投票日報;
    }

    /**
     * createLastProcess
     *
     * @return KijitsumaeNippoParam
     */
    public KijitsumaeNippoParam createLastProcess2() {
        if (null == lastData) {
            return null;
        }
        set印刷用パラメータ(施設計数, 施設合計);
        return 期日前投票日報;
    }

    /**
     * createLastProcess
     *
     * @return KijitsumaeNippoParam
     */
    public List<KijitsumaeNippoParam> createLastProcess3() {
        if (null == lastData) {
            return null;
        }
        List<KijitsumaeNippoParam> printList = new ArrayList<>();
        for (FlexibleDate 投票日 : 投票日別での計数Map.keySet()) {
            printList.add(set印刷用パラメータ(投票日別での計数Map.get(投票日), dateToString(投票日),
                    createNewParam(RString.EMPTY, lastData.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
        }
        printList.add(set印刷用パラメータ(選挙計数, 選挙合計,
                createNewParam(RString.EMPTY, lastData.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
        printList.add(set印刷用パラメータ(死亡者計数, 死亡者投票分,
                createNewParam(RString.EMPTY, lastData.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
        printList.add(set印刷用パラメータ(表示者計数, 表示者投票分,
                createNewParam(RString.EMPTY, lastData.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
        return printList;
    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPSMPrintEntity current, Map<RString, Integer> map) {
        if (new RString("1").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
            map.put(男, map.get(男) + 1);
            if (current.get投票状況Entity().getTenjiFlag()) {
                map.put(点字男, map.get(点字男) + 1);
            }
            if (current.get投票状況Entity().getDairiTohyoAriFlag()) {
                map.put(代理男, map.get(代理男) + 1);
            }
        } else if (new RString("2").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
            map.put(女, map.get(女) + 1);
            if (current.get投票状況Entity().getTenjiFlag()) {
                map.put(点字女, map.get(点字女) + 1);
            }
            if (current.get投票状況Entity().getDairiTohyoAriFlag()) {
                map.put(代理女, map.get(代理女) + 1);
            }
        }
    }

    private KijitsumaeNippoParam set印刷用パラメータ(Map<RString, Integer> map, RString tohyobi) {
        期日前投票日報.set投票日(tohyobi);
        期日前投票日報.set投票数_男(toZZZ_ZZ9編集(new RString(map.get(男))));
        期日前投票日報.set投票数_女(toZZZ_ZZ9編集(new RString(map.get(女))));
        期日前投票日報.set投票数_計(toZZZ_ZZ9編集(new RString(map.get(男) + map.get(女))));
        期日前投票日報.set内数_点字用紙_男(toZZZ_ZZ9編集(new RString(map.get(点字男))));
        期日前投票日報.set内数_点字用紙_女(toZZZ_ZZ9編集(new RString(map.get(点字女))));
        期日前投票日報.set内数_点字用紙_計(toZZZ_ZZ9編集(new RString(map.get(点字男) + map.get(点字女))));
        期日前投票日報.set内数_代理投票_男(toZZZ_ZZ9編集(new RString(map.get(代理男))));
        期日前投票日報.set内数_代理投票_女(toZZZ_ZZ9編集(new RString(map.get(代理女))));
        期日前投票日報.set内数_代理投票_計(toZZZ_ZZ9編集(new RString(map.get(代理男) + map.get(代理女))));
        return 期日前投票日報;
    }

    private KijitsumaeNippoParam set印刷用パラメータ(Map<RString, Integer> map, RString tohyobi, KijitsumaeNippoParam printParameter) {
        printParameter.set投票日(tohyobi);
        printParameter.set投票数_男(toZZZ_ZZ9編集(new RString(map.get(男))));
        printParameter.set投票数_女(toZZZ_ZZ9編集(new RString(map.get(女))));
        printParameter.set投票数_計(toZZZ_ZZ9編集(new RString(map.get(男) + map.get(女))));
        printParameter.set内数_点字用紙_男(toZZZ_ZZ9編集(new RString(map.get(点字男))));
        printParameter.set内数_点字用紙_女(toZZZ_ZZ9編集(new RString(map.get(点字女))));
        printParameter.set内数_点字用紙_計(toZZZ_ZZ9編集(new RString(map.get(点字男) + map.get(点字女))));
        printParameter.set内数_代理投票_男(toZZZ_ZZ9編集(new RString(map.get(代理男))));
        printParameter.set内数_代理投票_女(toZZZ_ZZ9編集(new RString(map.get(代理女))));
        printParameter.set内数_代理投票_計(toZZZ_ZZ9編集(new RString(map.get(代理男) + map.get(代理女))));
        return printParameter;
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
        FlexibleDate 投票日前 = before.get投票状況Entity().getJuriYMD();
        FlexibleDate 投票日現 = current.get投票状況Entity().getJuriYMD();

        return !(null != 投票日前 && null != 投票日現 && 投票日前.equals(投票日現));

    }

    /**
     * 施設集計。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew施設(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null == before) {
            return false;
        }
        RString 施設前 = before.get投票状況Entity().getShisetsuCode();
        RString 施設現 = current.get投票状況Entity().getShisetsuCode();

        return !(null != 施設前 && null != 施設現 && 施設前.equals(施設現));

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

    private Boolean is表示者(NippoPSMPrintEntity current) {
        if (null != current.get宛名PSMEntity()) {
            return new ShikakuHantei().is表示者(current.get宛名PSMEntity(),
                    current.get選挙Entity().getTenshutsuKigenYMD(),
                    current.get抄本Entity().getKiteiNenreiTotatsuYMD(),
                    current.get投票状況Entity().getJuriYMD(), FlexibleDate.MAX,
                    SenkyoShurui.定時登録);
        }
        return false;
    }

    private Boolean is死亡者() {
        // TODO
//        if (null != current.get宛名PSMEntity()) {
//            return new ShikakuHantei().is死亡抹消者(null, FlexibleDate.MAX);
//        }
        return false;
    }

    private void initializeMap(Map<RString, Integer> map) {
        map.put(男, 0);
        map.put(女, 0);
        map.put(点字男, 0);
        map.put(点字女, 0);
        map.put(代理男, 0);
        map.put(代理女, 0);
    }

    private RDate toRDate(FlexibleDate 日付) {
        if (null == 日付 || 日付.isEmpty()) {
            return null;
        }
        return new RDate(日付.toString());
    }

    private RString dateToString(FlexibleDate 日付) {
        if (null == 日付 || 日付.isEmpty()) {
            return RString.EMPTY;
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

    /**
     * keyBreakProcess。
     *
     * @param before before
     * @param current current
     * @return List<KijitsumaeNippoParam>
     */
    public List<KijitsumaeNippoParam> keyBreakProcess(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        List<KijitsumaeNippoParam> printList = new ArrayList<>();
        if (isNew選挙(before, current)) {
            printList.add(set印刷用パラメータ(計数, dateToString(before.get投票状況Entity().getJuriYMD()),
                    createNewParam(before.get投票状況Entity().getShisetsuCode(), before.get選挙Entity().getSenkyoNo(),
                            before.get施設Entity() == null ? RString.EMPTY : before.get施設Entity().getShisetsuName())));
            printList.add(set印刷用パラメータ(施設計数, 施設合計,
                    createNewParam(before.get投票状況Entity().getShisetsuCode(), before.get選挙Entity().getSenkyoNo(),
                            before.get施設Entity() == null ? RString.EMPTY : before.get施設Entity().getShisetsuName())));

            for (FlexibleDate 投票日 : 投票日別での計数Map.keySet()) {
                printList.add(set印刷用パラメータ(投票日別での計数Map.get(投票日), dateToString(投票日),
                        createNewParam(RString.EMPTY, before.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
            }
            printList.add(set印刷用パラメータ(選挙計数, 選挙合計,
                    createNewParam(RString.EMPTY, before.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
            printList.add(set印刷用パラメータ(死亡者計数, 死亡者投票分,
                    createNewParam(RString.EMPTY, before.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
            printList.add(set印刷用パラメータ(表示者計数, 表示者投票分,
                    createNewParam(RString.EMPTY, before.get選挙Entity().getSenkyoNo(), 出力施設集計分)));
            initializeMap(計数);
            initializeMap(施設計数);
            initializeMap(選挙計数);
            initializeMap(死亡者計数);
            initializeMap(表示者計数);
            投票日別での計数Map.clear();
        } else {
            if (isNew施設(before, current)) {
                printList.add(set印刷用パラメータ(計数, dateToString(before.get投票状況Entity().getJuriYMD()),
                        createNewParam(before.get投票状況Entity().getShisetsuCode(), before.get選挙Entity().getSenkyoNo(),
                                before.get施設Entity() == null ? RString.EMPTY : before.get施設Entity().getShisetsuName())));
                printList.add(set印刷用パラメータ(施設計数, 施設合計,
                        createNewParam(before.get投票状況Entity().getShisetsuCode(), before.get選挙Entity().getSenkyoNo(),
                                before.get施設Entity() == null ? RString.EMPTY : before.get施設Entity().getShisetsuName())));
                initializeMap(計数);
                initializeMap(施設計数);
            } else {
                if (isNew投票日(before, current)) {
                    printList.add(set印刷用パラメータ(計数, dateToString(before.get投票状況Entity().getJuriYMD()),
                            createNewParam(before.get投票状況Entity().getShisetsuCode(), before.get選挙Entity().getSenkyoNo(), null)));
                    put投票日別での計数Map(before.get投票状況Entity().getJuriYMD());
                    initializeMap(計数);
                }
            }
        }
        return printList;
    }

    private KijitsumaeNippoParam createNewParam(RString shisetsuCode, SenkyoNo senkyoNo, RString shisetsuName) {

        TohyoJyohyoInfo info = new TohyoJyohyoInfo();
        info.set日付(投票状況情報.get日付());
        info.set投票日(投票状況情報.get投票日());
        info.set施設コード(投票状況情報.get施設コード());
        info.set選挙番号(投票状況情報.get選挙番号());
        info.set交付年月日(投票状況情報.get交付年月日());
        info.set受理年月日(投票状況情報.get受理年月日());
        info.set交付_受理フラグ(投票状況情報.is交付_受理フラグ());
        info.set項目集計情報(投票状況情報.get項目集計情報());
        info.set投票状況(投票状況情報.get投票状況());
        KijitsumaeNippoParam newParam = new KijitsumaeNippoParam(info, 画面入力項目);
        newParam.get投票状況情報().set施設コード(shisetsuCode);
        newParam.get投票状況情報().set選挙番号(new RString(senkyoNo.toString()));
        if (shisetsuName != null) {
            newParam.set施設名称(shisetsuName);
        }
        return newParam;
    }
}
