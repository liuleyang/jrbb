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
import jp.co.ndensan.reams.af.afa.business.core.TohyoJiyuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 不在者投票の事由に関する調書帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class TohyoJiyuChoshoFuzaihsaBreakEditor {

    private final TohyoJiyuChoshoParam 不在者投票調書;
    private final Code 直接_本人 = new Code("1");
    private final Code 直接_代理人 = new Code("2");
    private final Code 郵便 = new Code("3");
    private final Code コード1 = new Code("1");
    private final Code コード2 = new Code("2");
    private final Code コード3 = new Code("3");
    private final Code コード4 = new Code("4");
    private final Code コード5 = new Code("5");
    private final Code コード6 = new Code("6");
    private final Code コード7 = new Code("7");
    private final Map<Code, List<Integer>> 明細計数;
    private final Map<Code, List<Integer>> 選挙明細計数;
    private final RString 計 = new RString("計");
    private NippoPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public TohyoJiyuChoshoFuzaihsaBreakEditor(AFABTE503SelectProcessParameter parameter) {
        明細計数 = new HashMap<>();
        putMap(明細計数);
        選挙明細計数 = new HashMap<>();
        putMap(選挙明細計数);
        TohyoJokyoEntity 投票状況 = new TohyoJokyoEntity();
        不在者投票調書 = new TohyoJiyuChoshoParam(投票状況, null,
                null, toRDate(parameter.get受理日Fr()), toRDate(parameter.get受理日To()));
    }

    /**
     * usualProcess
     *
     * @param current NippoPrintEntity
     */
    public void usualProcess(NippoPrintEntity current) {
        lastData = current;
        不在者投票調書.get投票状況Entity().set投票状況(new RString("3"));
        不在者投票調書.get投票状況Entity().set選挙種類(current.get抄本Entity().getSenkyoShurui().value());
        不在者投票調書.get投票状況Entity().set投票区(current.get選挙人名簿Entity().getTohyokuCode());
        不在者投票調書.get投票状況Entity().set選挙番号(new RString(current.get投票状況Entity().getSenkyoNo().toString()));
        投票計数(current, 明細計数);
        投票計数(current, 選挙明細計数);
    }

    /**
     * keyBreakProcessByTohyokuCode
     *
     * @param before before
     * @param current current
     * @return TohyoJiyuChoshoParam
     */
    public TohyoJiyuChoshoParam keyBreakProcessByTohyokuCode(NippoPrintEntity before, NippoPrintEntity current) {
        if (isNew投票区(before, current)) {
            調書セット(明細計数);
            putMap(明細計数);
            return 不在者投票調書;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyoNo
     *
     * @param before before
     * @param current current
     * @return TohyoJiyuChoshoParam
     */
    public TohyoJiyuChoshoParam keyBreakProcessBySenkyoNo(NippoPrintEntity before, NippoPrintEntity current) {
        if (isNew選挙(before, current) && !isNew投票区(before, current)) {
            調書セット(明細計数);
            putMap(明細計数);
            return 不在者投票調書;
        }
        return null;
    }

    /**
     * keyBreakProcessBySenkyoNo1
     *
     * @param before before
     * @param current current
     * @return TohyoJiyuChoshoParam
     */
    public TohyoJiyuChoshoParam keyBreakProcessBySenkyoNo1(NippoPrintEntity before, NippoPrintEntity current) {
        if (isNew選挙(before, current)) {
            不在者投票調書.get投票状況Entity().set投票区(計);
            調書セット(選挙明細計数);
            putMap(選挙明細計数);
            return 不在者投票調書;
        }
        return null;
    }

    /**
     * createLastProcess1
     *
     * @return TohyoJiyuChoshoParam
     */
    public TohyoJiyuChoshoParam createLastProcess1() {
        if (null == lastData) {
            return null;
        }
        調書セット(明細計数);
        return 不在者投票調書;
    }

    /**
     * createLastProcess2
     *
     * @return TohyoJiyuChoshoParam
     */
    public TohyoJiyuChoshoParam createLastProcess2() {
        if (null == lastData) {
            return null;
        }
        不在者投票調書.get投票状況Entity().set投票区(計);
        調書セット(選挙明細計数);
        return 不在者投票調書;
    }

    /**
     * 調書セット
     *
     */
    private void 調書セット(Map<Code, List<Integer>> map) {
        不在者投票調書.set直接1(toZZ_ZZ9編集(map.get(コード1).get(0)));
        不在者投票調書.set郵送1(toZZ_ZZ9編集(map.get(コード1).get(1)));
        不在者投票調書.set計1(toZZ_ZZ9編集(map.get(コード1).get(0) + map.get(コード1).get(1)));
        不在者投票調書.set直接2(toZZ_ZZ9編集(map.get(コード2).get(0)));
        不在者投票調書.set郵送2(toZZ_ZZ9編集(map.get(コード2).get(1)));
        不在者投票調書.set計2(toZZ_ZZ9編集(map.get(コード2).get(0) + map.get(コード2).get(1)));
        不在者投票調書.set直接3(toZZ_ZZ9編集(map.get(コード3).get(0)));
        不在者投票調書.set郵送3(toZZ_ZZ9編集(map.get(コード3).get(1)));
        不在者投票調書.set計3(toZZ_ZZ9編集(map.get(コード3).get(0) + map.get(コード3).get(1)));
        不在者投票調書.set直接4(toZZ_ZZ9編集(map.get(コード4).get(0)));
        不在者投票調書.set郵送4(toZZ_ZZ9編集(map.get(コード4).get(1)));
        不在者投票調書.set計4(toZZ_ZZ9編集(map.get(コード4).get(0) + map.get(コード4).get(1)));
        不在者投票調書.set直接5(toZZ_ZZ9編集(map.get(コード5).get(0)));
        不在者投票調書.set郵送5(toZZ_ZZ9編集(map.get(コード5).get(1)));
        不在者投票調書.set計5(toZZ_ZZ9編集(map.get(コード5).get(0) + map.get(コード5).get(1)));
        不在者投票調書.set直接6(toZZ_ZZ9編集(map.get(コード6).get(0)));
        不在者投票調書.set郵送6(toZZ_ZZ9編集(map.get(コード6).get(1)));
        不在者投票調書.set計6(toZZ_ZZ9編集(map.get(コード6).get(0) + map.get(コード6).get(1)));
        不在者投票調書.set直接7(toZZ_ZZ9編集(map.get(コード7).get(0)));
        不在者投票調書.set郵送7(toZZ_ZZ9編集(map.get(コード7).get(1)));
        不在者投票調書.set計7(toZZ_ZZ9編集(map.get(コード7).get(0) + map.get(コード7).get(1)));
        不在者投票調書.set直接合計(toZZ_ZZ9編集(map.get(コード1).get(0)
                + map.get(コード2).get(0)
                + map.get(コード3).get(0)
                + map.get(コード4).get(0)
                + map.get(コード5).get(0)
                + map.get(コード6).get(0)
                + map.get(コード7).get(0)));
        不在者投票調書.set郵送合計(toZZ_ZZ9編集(map.get(コード1).get(1)
                + map.get(コード2).get(1)
                + map.get(コード3).get(1)
                + map.get(コード4).get(1)
                + map.get(コード5).get(1)
                + map.get(コード6).get(1)
                + map.get(コード7).get(1)));
        不在者投票調書.set計合計(toZZ_ZZ9編集(map.get(コード1).get(0)
                + map.get(コード2).get(0)
                + map.get(コード3).get(0)
                + map.get(コード4).get(0)
                + map.get(コード5).get(0)
                + map.get(コード6).get(0)
                + map.get(コード7).get(0)
                + map.get(コード1).get(1)
                + map.get(コード2).get(1)
                + map.get(コード3).get(1)
                + map.get(コード4).get(1)
                + map.get(コード5).get(1)
                + map.get(コード6).get(1)
                + map.get(コード7).get(1)));
    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPrintEntity current, Map<Code, List<Integer>> map) {
        Code 事由コード = current.get投票状況Entity().getTohyoJiyuCode();
        if (!map.containsKey(事由コード)) {
            return;
        }
        List<Integer> 計数 = new ArrayList<>();
        Integer 代理人計数 = map.get(事由コード).get(0);
        Integer 郵便計数 = map.get(事由コード).get(1);
        if (直接_本人.equals(current.get投票状況Entity().getSeikyuHoho())
                || 直接_代理人.equals(current.get投票状況Entity().getSeikyuHoho())) {
            代理人計数 = 代理人計数 + 1;
        } else if (郵便.equals(current.get投票状況Entity().getSeikyuHoho())) {
            郵便計数 = 郵便計数 + 1;
        }
        計数.add(代理人計数);
        計数.add(郵便計数);
        map.put(事由コード, 計数);
    }

    /**
     * 投票区コード集計。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew投票区(NippoPrintEntity before, NippoPrintEntity current) {
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
    private boolean isNew選挙(NippoPrintEntity before, NippoPrintEntity current) {
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

    private RString toZZ_ZZ9編集(Integer value) {
        if (null == value) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value), 0);
        }

    }

    private void putMap(Map<Code, List<Integer>> map) {
        List<Integer> 初期数 = new ArrayList<>();
        初期数.add(0);
        初期数.add(0);
        map.put(コード1, 初期数);
        map.put(コード2, 初期数);
        map.put(コード3, 初期数);
        map.put(コード4, 初期数);
        map.put(コード5, 初期数);
        map.put(コード6, 初期数);
        map.put(コード7, 初期数);
    }
}
