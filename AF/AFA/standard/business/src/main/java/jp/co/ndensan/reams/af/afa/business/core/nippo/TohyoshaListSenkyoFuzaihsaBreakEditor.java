/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nippo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.GamenInfo;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.business.core.TohyoshaListSenkyoAllParam;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 投票者一覧表不在者表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class TohyoshaListSenkyoFuzaihsaBreakEditor {

    private final TohyoshaListSenkyoAllParam 投票者一覧表不在者表;
    private final List<RString> 改頁リスト;
    private final RString 投票区コード = new RString("tohyokuCode");
    private int 同じ投票区コード男数 = 0;
    private int 全投票区コード男数 = 0;
    private int 同じ投票区コード女数 = 0;
    private int 全投票区コード女数 = 0;
    private final RString 同区書式１ = new RString("【");
    private final RString 同区書式２ = new RString("投票区】");
    private final RString 全区書式１ = new RString("　　　【合計】");
    private final RString 書式男 = new RString("　　男");
    private final RString 書式女 = new RString("　　女");
    private final RString 書式計 = new RString("　　計");
    private RString 投票区名;
    private NippoPSMPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public TohyoshaListSenkyoFuzaihsaBreakEditor(AFABTE503SelectProcessParameter parameter) {
        改頁リスト = parameter.get改頁項目();
        TohyoJokyoEntity 投票状況 = new TohyoJokyoEntity();
        GamenInfo 画面入力項目 = new GamenInfo();
        画面入力項目.set交付日開始(toRDate(parameter.get交付日Fr()));
        画面入力項目.set交付日終了(toRDate(parameter.get交付日To()));
        画面入力項目.set受理日開始(toRDate(parameter.get受理日Fr()));
        画面入力項目.set受理日終了(toRDate(parameter.get受理日To()));
        画面入力項目.set受理時刻開始(toRString(parameter.get受理時刻Fr()));
        画面入力項目.set受理時刻終了(toRString(parameter.get受理時刻To()));
        投票者一覧表不在者表 = new TohyoshaListSenkyoAllParam(投票状況, 画面入力項目);
        投票者一覧表不在者表.set改頁リスト(改頁リスト);
    }

    /**
     * usualProcess
     *
     * @param current NippoPSMPrintEntity
     * @param 投票区名 RString
     * @param 選挙略称List List<RString>
     * @param 投票場所 RString
     */
    public void usualProcess(NippoPSMPrintEntity current, RString 投票区名, List<RString> 選挙略称List, RString 投票場所) {
        lastData = current;
        if (current.get投票状況Entity().getUketsukeNo() == null) {
            投票者一覧表不在者表.get投票状況Entity().set受付番号(RString.EMPTY);
        } else {
            投票者一覧表不在者表.get投票状況Entity().set受付番号(toRString(current.get投票状況Entity().getUketsukeNo()));
        }

        投票者一覧表不在者表.get投票状況Entity().set投票区(current.get選挙人名簿Entity().getTohyokuCode());
        投票者一覧表不在者表.get投票状況Entity().set頁(current.get選挙人名簿Entity().getPage());
        投票者一覧表不在者表.get投票状況Entity().set行(current.get選挙人名簿Entity().getGyo());
        投票者一覧表不在者表.get投票状況Entity().set名称(toRString(current.get宛名PSMEntity().getMeisho()));
        投票者一覧表不在者表.get投票状況Entity().set性別コード(current.get宛名PSMEntity().getSeibetsuCode());
        投票者一覧表不在者表.get投票状況Entity().set生年月日(toRDate(current.get宛名PSMEntity().getSeinengappiYMD()));
        投票者一覧表不在者表.get投票状況Entity().set住民種別(current.get宛名PSMEntity().getJuminShubetsuCode());
        投票者一覧表不在者表.get投票状況Entity().set投票事由コード(toRString(current.get投票状況Entity().getTohyoJiyuCode()));
        投票者一覧表不在者表.get投票状況Entity().set請求方法(toRString(current.get投票状況Entity().getSeikyuHoho()));
        投票者一覧表不在者表.get投票状況Entity().set施設コード(current.get投票状況Entity().getShisetsuCode());
        投票者一覧表不在者表.get投票状況Entity().set投票状況(toRString(current.get投票状況Entity().getTohyoJokyo()));
        投票者一覧表不在者表.get投票状況Entity().set交付年月日(toRDate(current.get投票状況Entity().getKofuYMD()));
        投票者一覧表不在者表.get投票状況Entity().set受理年月日(toRDate(current.get投票状況Entity().getJuriYMD()));
        投票者一覧表不在者表.get投票状況Entity().set投票年月日(toRDate(current.get抄本Entity().getTohyoYMD()));
        投票者一覧表不在者表.get投票状況Entity().set交付方法(toRString(current.get投票状況Entity().getKofuHoho()));
        投票者一覧表不在者表.get投票状況Entity().set代理投票有フラグ(current.get投票状況Entity().getDairiTohyoAriFlag());
        投票者一覧表不在者表.get投票状況Entity().set点字フラグ(current.get投票状況Entity().getTenjiFlag());
        投票者一覧表不在者表.get投票状況Entity().set期日前不在者_場合(new RString("2"));
        投票者一覧表不在者表.set投票場所(投票場所);
        投票者一覧表不在者表.set選挙略称List(選挙略称List);
        ShikibetsuCode shikibeisuCode = current.get宛名PSMEntity().getShikibetsuCode();
        if (null == shikibeisuCode) {
            shikibeisuCode = ShikibetsuCode.EMPTY;
        }
        投票者一覧表不在者表.get投票状況Entity().set識別コード(shikibeisuCode.value());
        this.投票区名 = 投票区名;
        投票計数(current);
    }

    /**
     * keyBreakProcessByTohyokuCode
     *
     * @param before before
     * @param current current
     * @return TohyoshaListSenkyoAllParam
     */
    public TohyoshaListSenkyoAllParam keyBreakProcessByTohyokuCode(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード) && isNew投票区(before, current)) {
            投票者一覧表不在者表.set合計エリア１(同区書式１
                    .concat(投票区名)
                    .concat(同区書式２)
                    .concat(書式男)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数)))
                    .concat(書式女)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード女数)))
                    .concat(書式計)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数 + 同じ投票区コード女数))));
            同じ投票区コード男数 = 0;
            同じ投票区コード男数 = 0;
        }
        return 投票者一覧表不在者表;
    }

    /**
     * createLastProcess
     *
     * @return TohyoshaListSenkyoAllParam
     */
    public TohyoshaListSenkyoAllParam createLastProcess() {
        if (null == lastData) {
            return null;
        }
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード)) {
            投票者一覧表不在者表.set合計エリア１(同区書式１
                    .concat(投票区名)
                    .concat(同区書式２)
                    .concat(書式男)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数)))
                    .concat(書式女)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード女数)))
                    .concat(書式計)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数 + 同じ投票区コード女数))));
            同じ投票区コード男数 = 0;
            同じ投票区コード男数 = 0;
        }
        投票者一覧表不在者表.set合計エリア２(全区書式１
                .concat(書式男)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード男数)))
                .concat(書式女)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード女数)))
                .concat(書式計)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード男数 + 全投票区コード女数))));
        return 投票者一覧表不在者表;
    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPSMPrintEntity current) {
        if (new RString("1").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
            同じ投票区コード男数++;
            全投票区コード男数++;
        } else if (new RString("2").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
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

    private RString toRString(Code code) {
        if (null == code || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString toRString(AtenaMeisho code) {
        if (null == code || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString toRString(Integer no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return new RString(no);
    }

    private RString toRString(RTime time) {
        if (null == time) {
            return RString.EMPTY;
        }
        return time.toFormattedTimeString(DisplayTimeFormat.HH_mm);
    }

    private RString toZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

    }

}
