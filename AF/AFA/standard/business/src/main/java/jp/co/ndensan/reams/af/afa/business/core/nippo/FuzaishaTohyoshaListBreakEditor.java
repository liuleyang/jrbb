/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nippo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.FuzaishaTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaIchiran;
import jp.co.ndensan.reams.af.afa.business.core.NippoGamenKyotsuKomoku;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 不在者投票者一覧表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class FuzaishaTohyoshaListBreakEditor {

    private final FuzaishaTohyoshaListParam 不在者投票者一覧表;
    private final List<RString> 改頁リスト;
    private final RString 投票区コード = new RString("tohyokuCode");
    private int 同じ投票区コード男数 = 0;
    private int 全投票区コード男数 = 0;
    private int 同じ投票区コード女数 = 0;
    private int 全投票区コード女数 = 0;
    private static final int 投票区桁数 = 5;
    private final boolean isチェックボックス指定あり;
    private final RString 同区書式１ = new RString("【");
    private final RString 同区書式２ = new RString("投票区】");
    private final RString 全区書式１ = new RString("　　　【合計】");
    private final RString 書式男 = new RString("　　男 ");
    private final RString 書式女 = new RString("　　女 ");
    private final RString 書式計 = new RString("　　計 ");
    private static final int 一頁最大レコード数 = 30;
    private NippoPSMPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public FuzaishaTohyoshaListBreakEditor(AFABTE503SelectProcessParameter parameter) {
        改頁リスト = parameter.get改頁項目();
        isチェックボックス指定あり = parameter.get投票状況リスト() != null && !parameter.get投票状況リスト().isEmpty();
        KijitsumaeTohyoshaIchiran 不在者投票者明細 = new KijitsumaeTohyoshaIchiran();
        NippoGamenKyotsuKomoku 画面入力項目 = new NippoGamenKyotsuKomoku();
        画面入力項目.set投票区コード開始(parameter.get投票区コードFr());
        画面入力項目.set投票区コード終了(parameter.get投票区コードTo());
        画面入力項目.set施設コード開始(parameter.get施設コードFr());
        画面入力項目.set施設コード終了(parameter.get施設コードTo());
        画面入力項目.set交付日開始(toRDate(parameter.get交付日Fr()));
        画面入力項目.set交付日終了(toRDate(parameter.get交付日To()));
        画面入力項目.set受理日開始(toRDate(parameter.get受理日Fr()));
        画面入力項目.set受理日終了(toRDate(parameter.get受理日To()));
        画面入力項目.set受理時刻開始(parameter.get受理時刻Fr());
        画面入力項目.set受理時刻終了(parameter.get受理時刻To());
        不在者投票者一覧表 = new FuzaishaTohyoshaListParam(不在者投票者明細, 画面入力項目);
        不在者投票者一覧表.set改頁リスト(改頁リスト);
        不在者投票者一覧表.setカウント(Decimal.ZERO);
    }

    /**
     * usualProcess
     *
     * @param current NippoPSMPrintEntity
     * @param 施設名称 RString
     * @param 施設種別コード RString
     * @param 施設種別名称 RString
     * @param 施設種別略称 RString
     * @param 投票区名 RString
     */
    public void usualProcess(NippoPSMPrintEntity current, RString 施設名称, RString 施設種別コード, RString 施設種別名称, RString 施設種別略称, RString 投票区名) {
        lastData = current;
        不在者投票者一覧表.set施設名(施設名称);
        不在者投票者一覧表.set施設種別(施設種別コード);
        不在者投票者一覧表.set施設種別名称(施設種別名称);
        不在者投票者一覧表.set施設種別略称(施設種別略称);
        Code tohyoJokyo = current.get投票状況Entity().getTohyoJokyo();
        if (tohyoJokyo == null) {
            tohyoJokyo = Code.EMPTY;
        }
        不在者投票者一覧表.get不在者投票者明細().setサブタイトル(isチェックボックス指定あり ? RString.EMPTY : tohyoJokyo.value());
        不在者投票者一覧表.get不在者投票者明細().set受付番号(toRString(current.get投票状況Entity().getUketsukeNo()));
        不在者投票者一覧表.get不在者投票者明細().set投票区(current.get選挙人名簿Entity().getTohyokuCode());
        不在者投票者一覧表.get不在者投票者明細().set頁(toRString(current.get選挙人名簿Entity().getPage()));
        不在者投票者一覧表.get不在者投票者明細().set行(toRString(current.get選挙人名簿Entity().getGyo()));

        AtenaMeisho meisho = current.get宛名PSMEntity().getMeisho();
        if (meisho == null) {
            meisho = AtenaMeisho.EMPTY;
        }
        不在者投票者一覧表.get不在者投票者明細().set名称(meisho.value());
        不在者投票者一覧表.get不在者投票者明細().set性別コード(current.get宛名PSMEntity().getSeibetsuCode());
        不在者投票者一覧表.get不在者投票者明細().set生年月日(current.get宛名PSMEntity().getSeinengappiYMD());
        不在者投票者一覧表.get不在者投票者明細().set投票事由コード(current.get投票状況Entity().getTohyoJiyuCode());
        不在者投票者一覧表.get不在者投票者明細().set施設コード(current.get投票状況Entity().getShisetsuCode());
        不在者投票者一覧表.get不在者投票者明細().set投票状況コード(current.get投票状況Entity().getTohyoJokyo());
        不在者投票者一覧表.get不在者投票者明細().set交付年月日(toRDate(current.get投票状況Entity().getKofuYMD()));
        不在者投票者一覧表.get不在者投票者明細().set受理年月日(toRDate(current.get投票状況Entity().getJuriYMD()));
        不在者投票者一覧表.get不在者投票者明細().set受理時刻(current.get投票状況Entity().getJuriTime());
        不在者投票者一覧表.get不在者投票者明細().set交付方法(current.get投票状況Entity().getKofuHoho());
        不在者投票者一覧表.get不在者投票者明細().set受理方法(current.get投票状況Entity().getJuriHoho());
        不在者投票者一覧表.get不在者投票者明細().set代理投票有フラグ(current.get投票状況Entity().getDairiTohyoAriFlag());
        不在者投票者一覧表.get不在者投票者明細().set点字フラグ(current.get投票状況Entity().getTenjiFlag());
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード)) {
            不在者投票者一覧表.get不在者投票者明細().set投票区コード(current.get選挙人名簿Entity().getTohyokuCode());
            不在者投票者一覧表.get不在者投票者明細().set投票区名(投票区名);
        }
        投票計数(current);

    }

    /**
     * keyBreakProcessByTohyokuCode
     *
     * @param before before
     * @param current current
     * @return FuzaishaTohyoshaListParam
     */
    public FuzaishaTohyoshaListParam keyBreakProcessByTohyokuCode(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード) && isNew投票区(before, current)) {
            不在者投票者一覧表.setカウント(Decimal.ZERO);
            不在者投票者一覧表.set合計エリア１(同区書式１
                    .concat(不在者投票者一覧表.get不在者投票者明細().get投票区コード()).padLeft(投票区桁数)
                    .concat(同区書式２)
                    .concat(書式男)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数)))
                    .concat(書式女)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード女数)))
                    .concat(書式計)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数 + 同じ投票区コード女数))));
            同じ投票区コード男数 = 0;
            同じ投票区コード女数 = 0;
        } else {
            不在者投票者一覧表.setページ(new RString(不在者投票者一覧表.getカウント().divideAndRemainder(new Decimal(一頁最大レコード数))[0].add(Decimal.ONE).intValue()));
            不在者投票者一覧表.setカウント(不在者投票者一覧表.getカウント().add(Decimal.ONE));
        }
        return 不在者投票者一覧表;
    }

    /**
     * createLastProcess
     *
     * @return FuzaishaTohyoshaListParam
     */
    public FuzaishaTohyoshaListParam createLastProcess() {
        if (null == lastData) {
            return null;
        }
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード)) {
            不在者投票者一覧表.set合計エリア１(同区書式１
                    .concat(不在者投票者一覧表.get不在者投票者明細().get投票区コード()).padLeft(投票区桁数)
                    .concat(同区書式２)
                    .concat(書式男)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数)))
                    .concat(書式女)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード女数)))
                    .concat(書式計)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数 + 同じ投票区コード女数))));
        }
        不在者投票者一覧表.set合計エリア2(全区書式１
                .concat(書式男)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード男数)))
                .concat(書式女)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード女数)))
                .concat(書式計)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード男数 + 全投票区コード女数))));
        return 不在者投票者一覧表;
    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPSMPrintEntity current) {
        if (new RString("1").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
            同じ投票区コード男数++;
            全投票区コード男数++;
        } else {
            同じ投票区コード女数++;
            全投票区コード女数++;
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

    private RDate toRDate(FlexibleDate 日付) {
        if (null == 日付 || 日付.isEmpty()) {
            return null;
        }
        return new RDate(日付.toString());
    }

    private RString toRString(Integer no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return new RString(no);
    }

    private RString toZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

    }

}
