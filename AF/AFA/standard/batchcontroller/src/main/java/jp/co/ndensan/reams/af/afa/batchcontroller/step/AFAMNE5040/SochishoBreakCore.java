/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.SochishoParam;
import jp.co.ndensan.reams.af.afa.business.core.tohyoyoshimaisukanri.TohyoYoshiMaisuKanri;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.service.core.tohyoku.TohyokuManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoyoshimaisukanri.TohyoYoshiMaisuKanriManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 送致書帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-036 lit
 */
public class SochishoBreakCore {

    private Decimal 不在者投票者男数;
    private Decimal 不在者投票者女数;
    private Decimal 名簿登録者男数;
    private Decimal 名簿登録者女数;
    private Decimal 有権者男数;
    private Decimal 有権者女数;
    private final boolean 印字有無フラグ;
    private final RString 市町村名;
    private final AFABTE504SelectProcessParameter parameter;

    private List<RString> 投票区対象リスト = new ArrayList<>();
    private Map<RString, SochishoParam> 投票区別Map = new HashMap<>();

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE504SelectProcessParameter
     */
    public SochishoBreakCore(AFABTE504SelectProcessParameter parameter) {
        不在者投票者男数 = Decimal.ZERO;
        不在者投票者女数 = Decimal.ZERO;
        名簿登録者男数 = Decimal.ZERO;
        名簿登録者女数 = Decimal.ZERO;
        有権者男数 = Decimal.ZERO;
        有権者女数 = Decimal.ZERO;
        this.印字有無フラグ = parameter.is印字有無フラグ();
        this.parameter = parameter;
        this.市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
    }

    /**
     * usualProcess
     *
     * @param before ZenjitsuPrintEntity
     * @param current ZenjitsuPrintEntity
     */
    public void usualProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (null == before) {
            get投票区対象一覧(parameter.get投票区コードFROM(), parameter.get投票区コードTO(), current.get抄本Entity().getTohyoYMD());
        }
        if (null == current || 印字有無フラグ) {
            return;
        }
        countUp(current);
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<SochishoParam> SochishoParam
     */
    public List<SochishoParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        List<SochishoParam> resultList = new ArrayList<>();
        if (isNew投票区(before, current) || isNew選挙(before, current)) {
            SochishoParam param = createPrintData(before);
            投票区別Map.put(before.get選挙人名簿Entity().getTohyokuCode(), param);
        }

        if (isNew選挙(before, current)) {
            resultList = 全部投票区リストを作成();
            投票区別Map = new HashMap<>();
        }
        return resultList;
    }

    private SochishoParam createNullPrintData(RString 投票区コード) {
        SochishoParam param = new SochishoParam();
        param.set市町村名(this.市町村名);
        param.set投票区コード(投票区コード);
        return param;
    }

    private SochishoParam createPrintData(ZenjitsuPrintEntity entity) {
        SochishoParam param = new SochishoParam();
        param.set投票区コード(entity.get選挙人名簿Entity().getTohyokuCode());
        if (!印字有無フラグ) {
            param.set不在者投票者男数(不在者投票者男数);
            param.set不在者投票者女数(不在者投票者女数);
            param.set有権者男数(有権者男数);
            param.set有権者女数(有権者女数);
            param.set名簿登録者男数(名簿登録者男数);
            param.set名簿登録者女数(名簿登録者女数);
            clearCount();
        }

        TohyoYoshiMaisuKanri tohyoYoshiMaisuKanri = TohyoYoshiMaisuKanriManager.createInstance().get投票用紙枚数管理ByKey(
                entity.get抄本Entity().getShohonNo(),
                entity.get選挙Entity().getSenkyoNo(),
                entity.get選挙人名簿Entity().getTohyokuCode());
        if (null != tohyoYoshiMaisuKanri) {
            param.set受数_仮投票用封筒(new Decimal(tohyoYoshiMaisuKanri.getKariFutoMaisu()));
            param.set受数_投票用紙(new Decimal(tohyoYoshiMaisuKanri.getTohyoYoshiMaisu()));
            param.set受数_点字投票用紙(new Decimal(tohyoYoshiMaisuKanri.getTenjiYoshiMaisu()));
        }
        param.set市町村名(this.市町村名);

        return param;

    }

    private void get投票区対象一覧(RString 投票区From, RString 投票区To, FlexibleDate 投票年月日) {
        List<RString> 投票区リスト = TohyokuManager.createInstance().get全投票区(
                new Code(SenkyoShurui.国政選挙_地方選挙.getCode()), 投票区From, 投票区To, 投票年月日);
        if (投票区リスト != null) {
            投票区対象リスト = 投票区リスト;
        }
    }

    private List<SochishoParam> 全部投票区リストを作成() {
        List<SochishoParam> resultList = new ArrayList<>();
        for (RString 投票区 : 投票区対象リスト) {
            if (投票区別Map.containsKey(投票区)) {
                resultList.add(投票区別Map.get(投票区));
            } else {
                resultList.add(createNullPrintData(投票区));
            }
        }
        return resultList;
    }

    private void countUp(ZenjitsuPrintEntity current) {
        if (null == current.get投票状況Entity()) {
            return;
        }
        if (is男(current)) {
            if (is有権者(current)) {
                有権者男数 = 有権者男数.add(Decimal.ONE);
            }
            if (is登録者(current)) {
                名簿登録者男数 = 名簿登録者男数.add(Decimal.ONE);
            }
            if (is不在者(current)) {
                不在者投票者男数 = 不在者投票者男数.add(Decimal.ONE);
            }
        } else {
            if (is有権者(current)) {
                有権者女数 = 有権者女数.add(Decimal.ONE);
            }
            if (is登録者(current)) {
                名簿登録者女数 = 名簿登録者女数.add(Decimal.ONE);
            }
            if (is不在者(current)) {
                不在者投票者女数 = 不在者投票者女数.add(Decimal.ONE);
            }
        }
    }

    private void clearCount() {
        不在者投票者男数 = Decimal.ZERO;
        不在者投票者女数 = Decimal.ZERO;
        有権者男数 = Decimal.ZERO;
        有権者女数 = Decimal.ZERO;
        名簿登録者男数 = Decimal.ZERO;
        名簿登録者女数 = Decimal.ZERO;
    }

    /**
     * NewDataかどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        if (null == current) {
            return true;
        }

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();
        RString 投票区コード前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区コード現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現)
                && null != 投票区コード前 && null != 投票区コード現 && 投票区コード前.equals(投票区コード現));
    }

    /**
     * New投票区かどうか。
     *
     * @param before before
     * @param current current
     * @return New投票区かどうか
     */
    private boolean isNew投票区(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (null == current) {
            return true;
        }
        RString 投票区コード前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区コード現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 投票区コード前 && null != 投票区コード現 && 投票区コード前.equals(投票区コード現));
    }

    /**
     * New選挙かどうか。
     *
     * @param before before
     * @param current current
     * @return New選挙かどうか
     */
    private boolean isNew選挙(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (null == current) {
            return true;
        }

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));
    }

    private boolean is有権者(ZenjitsuPrintEntity current) {
        Code 投票状況 = current.get投票状況Entity().getTohyoJokyo();
        if (null != 投票状況 && TohyoJokyo.なし.getCode().equals(投票状況.value())) {
            return false;
        }

        return new ShikakuHantei().is有権者(current.get宛名情報Entity(),
                current.get選挙Entity().getTenshutsuKigenYMD(),
                current.get抄本Entity().getKiteiNenreiTotatsuYMD(),
                current.get抄本Entity().getTohyoYMD(),
                SenkyoShurui.toValue(current.get抄本Entity().getSenkyoShurui().getColumnValue()),
                current.get選挙資格Entity());
    }

    private boolean is不在者(ZenjitsuPrintEntity current) {
        Code 投票状況 = current.get投票状況Entity().getTohyoJokyo();
        return null != 投票状況 && TohyoJokyo.受理.getCode().equals(投票状況.value());
    }

    private boolean is男(ZenjitsuPrintEntity current) {
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.get宛名情報Entity());
        if (宛名対象.canBe個人()) {
            return 宛名対象.to個人().get性別().equals(Gender.MALE);
        }
        return false;
    }

    private boolean is登録者(ZenjitsuPrintEntity current) {
        return is有権者(current) || new ShikakuHantei().is表示者(current.get宛名情報Entity(),
                current.get選挙Entity().getTenshutsuKigenYMD(),
                current.get抄本Entity().getKiteiNenreiTotatsuYMD(),
                current.get抄本Entity().getTohyoYMD(),
                current.get抄本Entity().getTohyoYMD(),
                SenkyoShurui.toValue(current.get抄本Entity().getSenkyoShurui().getColumnValue()));
    }
}
