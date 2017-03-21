/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nippo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaIchiran;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.core.NippoGamenKyotsuKomoku;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
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
 * 期日前投票者一覧表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class KijitsumaeTohyoshaListBreakEditor {

    private final KijitsumaeTohyoshaListParam 期日前投票者一覧;

    private final List<RString> 改頁リスト;
    private final RString 投票区コード = new RString("tohyokuCode");
    private final RString 受付番号 = new RString("uketsukeNo");
    private int 同じ投票区コード男数 = 0;
    private int 全投票区コード男数 = 0;
    private int 同じ投票区コード女数 = 0;
    private int 全投票区コード女数 = 0;
    private final RString 同区書式１ = new RString("【");
    private final RString 同区書式２ = new RString("投票区】");
    private final RString 全区書式１ = new RString("　　　【合計】");
    private final RString 書式男 = new RString("　　男 ");
    private final RString 書式女 = new RString("　　女 ");
    private final RString 書式計 = new RString("　　計 ");
    private static final int レコード = 30;
    private static final int 桁5 = 5;
    private NippoPSMPrintEntity lastData;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE503SelectProcessParameter
     */
    public KijitsumaeTohyoshaListBreakEditor(AFABTE503SelectProcessParameter parameter) {
        改頁リスト = parameter.get改頁項目();
        KijitsumaeTohyoshaIchiran 期日前投票者明細 = new KijitsumaeTohyoshaIchiran();
        NippoGamenKyotsuKomoku 画面入力項目 = new NippoGamenKyotsuKomoku();
        画面入力項目.set投票区コード開始(parameter.get投票区コードFr());
        画面入力項目.set投票区コード終了(parameter.get投票区コードTo());
        画面入力項目.set施設コード開始(parameter.get施設コードFr());
        画面入力項目.set施設コード終了(parameter.get施設コードTo());
        画面入力項目.set期日前投票日開始(toRDate(parameter.get期日前投票日Fr()));
        画面入力項目.set期日前投票日終了(toRDate(parameter.get期日前投票日To()));
        画面入力項目.set投票時刻開始(parameter.get投票時刻Fr());
        画面入力項目.set投票時刻終了(parameter.get投票時刻To());
        期日前投票者一覧 = new KijitsumaeTohyoshaListParam(期日前投票者明細, 画面入力項目);
        期日前投票者一覧.set改頁リスト(改頁リスト);
        期日前投票者一覧.setカウント(0);
    }

    /**
     * usualProcess
     *
     * @param current NippoPSMPrintEntity
     * @param 施設種別 Shisetsu
     */
    public void usualProcess(NippoPSMPrintEntity current, Shisetsu 施設種別) {
        lastData = current;
        期日前投票者一覧.set施設名(施設種別.get施設名称());
        Code tohyoJokyo = current.get投票状況Entity().getTohyoJokyo();
        if (tohyoJokyo == null) {
            tohyoJokyo = Code.EMPTY;
        }
        期日前投票者一覧.get期日前投票者明細().setサブタイトル(tohyoJokyo.value());
        期日前投票者一覧.get期日前投票者明細().set選挙番号(new RString(current.get選挙Entity().getSenkyoNo().value()));
        期日前投票者一覧.get期日前投票者明細().set受付番号(toRString(current.get投票状況Entity().getUketsukeNo()));
        期日前投票者一覧.get期日前投票者明細().set投票区(current.get選挙人名簿Entity().getTohyokuCode());
        期日前投票者一覧.get期日前投票者明細().set頁(toRString(current.get選挙人名簿Entity().getPage()));
        期日前投票者一覧.get期日前投票者明細().set行(toRString(current.get選挙人名簿Entity().getGyo()));
        AtenaMeisho meisho = current.get宛名PSMEntity().getMeisho();
        if (meisho == null) {
            meisho = AtenaMeisho.EMPTY;
        }
        期日前投票者一覧.get期日前投票者明細().set名称(meisho.value());
        期日前投票者一覧.get期日前投票者明細().set性別コード(current.get宛名PSMEntity().getSeibetsuCode());
        期日前投票者一覧.get期日前投票者明細().set生年月日(current.get宛名PSMEntity().getSeinengappiYMD());
        期日前投票者一覧.get期日前投票者明細().set投票事由コード(current.get投票状況Entity().getTohyoJiyuCode());
        期日前投票者一覧.get期日前投票者明細().set施設コード(current.get投票状況Entity().getShisetsuCode());
        期日前投票者一覧.get期日前投票者明細().set投票状況コード(current.get投票状況Entity().getTohyoJokyo());
        期日前投票者一覧.get期日前投票者明細().set交付年月日(toRDate(current.get投票状況Entity().getKofuYMD()));
        期日前投票者一覧.get期日前投票者明細().set受理年月日(toRDate(current.get投票状況Entity().getJuriYMD()));
        期日前投票者一覧.get期日前投票者明細().set受理時刻(current.get投票状況Entity().getJuriTime());
        期日前投票者一覧.get期日前投票者明細().set交付方法(current.get投票状況Entity().getKofuHoho());
        期日前投票者一覧.get期日前投票者明細().set受理方法(current.get投票状況Entity().getJuriHoho());
        期日前投票者一覧.get期日前投票者明細().set代理投票有フラグ(current.get投票状況Entity().getDairiTohyoAriFlag());
        期日前投票者一覧.get期日前投票者明細().set点字フラグ(current.get投票状況Entity().getTenjiFlag());
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード)) {
            if (current.get抄本Entity().getSenkyoShurui().equals(new Code("1")) || current.get抄本Entity().getSenkyoShurui().equals(new Code("0"))) {
                期日前投票者一覧.get期日前投票者明細().set投票区コード(current.getUrV0159().getTohyokuCode().value());
                期日前投票者一覧.get期日前投票者明細().set投票区名(current.getUrV0159().getName());
            } else {
                期日前投票者一覧.get期日前投票者明細().set投票区コード(current.getAfT501().getTohyokuCode());
                期日前投票者一覧.get期日前投票者明細().set投票区名(current.getAfT501().getTohyokuName());
            }
        }
        投票計数(current);
    }

    /**
     * keyBreakProcessByTohyokuCode
     *
     * @param before before
     * @param current current
     * @return KijitsumaeTohyoshaListParam
     */
    public KijitsumaeTohyoshaListParam keyBreakProcessByTohyokuCode(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (is改ページ(before, current)) {
            期日前投票者一覧.setカウント(0);
            if (null != 改頁リスト && 改頁リスト.contains(投票区コード) && isNew投票区(before, current)) {
                期日前投票者一覧.set合計エリア１(同区書式１
                        .concat(期日前投票者一覧.get期日前投票者明細().get投票区コード())
                        .concat(同区書式２)
                        .concat(書式男)
                        .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数)))
                        .concat(書式女)
                        .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード女数)))
                        .concat(書式計)
                        .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数 + 同じ投票区コード女数))));
                同じ投票区コード男数 = 0;
                同じ投票区コード女数 = 0;
            }
        } else {
            期日前投票者一覧.setページ(new RString(期日前投票者一覧.getカウント() / レコード + 1));
            期日前投票者一覧.setカウント(期日前投票者一覧.getカウント() + 1);
        }
        return 期日前投票者一覧;
    }

    /**
     * clear合計エリア１
     *
     * @param before before
     * @param current current
     */
    public void clear合計エリア１(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード) && isNew投票区(before, current)) {
            期日前投票者一覧.set合計エリア１(RString.EMPTY);
        }
    }

    /**
     * createLastProcess
     *
     * @return KijitsumaeTohyoshaListParam
     */
    public KijitsumaeTohyoshaListParam createLastProcess() {
        if (null == lastData) {
            return null;
        }
        if (null != 改頁リスト && 改頁リスト.contains(投票区コード)) {
            期日前投票者一覧.set合計エリア１((同区書式１
                    .concat(期日前投票者一覧.get期日前投票者明細().get投票区コード()).padLeft(桁5))
                    .concat(同区書式２)
                    .concat(書式男)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数)))
                    .concat(書式女)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード女数)))
                    .concat(書式計)
                    .concat(toZZZ_ZZ9編集(new RString(同じ投票区コード男数 + 同じ投票区コード女数))));
        }
        期日前投票者一覧.set合計エリア2(全区書式１
                .concat(書式男)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード男数)))
                .concat(書式女)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード女数)))
                .concat(書式計)
                .concat(toZZZ_ZZ9編集(new RString(全投票区コード男数 + 全投票区コード女数))));
        return 期日前投票者一覧;
    }

    /**
     * 投票日集計。
     *
     */
    private void 投票計数(NippoPSMPrintEntity current) {
        if (!RString.isNullOrEmpty(current.get宛名PSMEntity().getSeibetsuCode())) {
            if (new RString("1").equals(current.get宛名PSMEntity().getSeibetsuCode())) {
                同じ投票区コード男数++;
                全投票区コード男数++;
            } else {
                同じ投票区コード女数++;
                全投票区コード女数++;
            }
        }
    }

    /**
     * 投票区コード集計。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean is改ページ(NippoPSMPrintEntity before, NippoPSMPrintEntity current) {
        if (null == before) {
            return false;
        }
        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();
        Integer 受付番号前 = before.get投票状況Entity().getUketsukeNo();
        Integer 受付番号現 = current.get投票状況Entity().getUketsukeNo();
        if (null != 改頁リスト) {
            if (改頁リスト.contains(受付番号) && 改頁リスト.contains(投票区コード)) {
                return isNew投票区(before, current)
                        || !is同じ選挙番号(選挙番号前, 選挙番号現)
                        || !is同じ受付番号(受付番号前, 受付番号現);
            } else if (!改頁リスト.contains(受付番号) && 改頁リスト.contains(投票区コード)) {
                return isNew投票区(before, current)
                        || !is同じ選挙番号(選挙番号前, 選挙番号現);
            } else if (改頁リスト.contains(受付番号) && !改頁リスト.contains(投票区コード)) {
                return !is同じ受付番号(受付番号前, 受付番号現)
                        || !is同じ選挙番号(選挙番号前, 選挙番号現);
            } else {
                return !is同じ選挙番号(選挙番号前, 選挙番号現);
            }
        } else {
            return !is同じ選挙番号(選挙番号前, 選挙番号現);
        }
    }

    private Boolean is同じ選挙番号(SenkyoNo 選挙番号前, SenkyoNo 選挙番号現) {
        if (null == 選挙番号前) {
            return null == 選挙番号現;
        } else {
            return 選挙番号前.equals(選挙番号現);
        }
    }

    private Boolean is同じ投票区(RString 前項目, RString 現項目) {
        if (null == 前項目) {
            return null == 現項目;
        } else {
            return 前項目.equals(現項目);
        }
    }

    private Boolean is同じ受付番号(Integer 前項目, Integer 現項目) {
        if (null == 前項目) {
            return null == 現項目;
        } else {
            return 前項目.equals(現項目);
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

        return !is同じ投票区(投票区コード前, 投票区コード現);

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
