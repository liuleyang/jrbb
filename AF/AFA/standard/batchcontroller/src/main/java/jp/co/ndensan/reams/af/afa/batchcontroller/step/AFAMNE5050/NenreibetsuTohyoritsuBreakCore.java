/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.ZenjitsuReportHeaderEditor;
import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuData;
import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuListData;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.euc.afapre520.NenreibetsuTohyoritsuCsvEntityEditor;
import jp.co.ndensan.reams.af.afa.business.tohyokekkashukeisakusei.TohyoKekkaShukeihyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.afapre520.NenreibetsuTohyoritsuCsvEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.Order;

/**
 * 年齢別投票率集計表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0290-036 lit
 */
public class NenreibetsuTohyoritsuBreakCore {

    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;
    private final AFABTE505SelectProcessParameter parameter;

    private Map<RString, TohyoritsuData> 行政区系 = new HashMap<>();
    private Map<RString, TohyoritsuData> 投票区系 = new HashMap<>();
    private Map<RString, TohyoritsuData> 選挙系 = new HashMap<>();
    private List<RString> ラベルリスト = new ArrayList<>();
    private List<TohyoritsuData> 行政区系CSV用リスト = new ArrayList<>();
    private List<TohyoritsuData> 投票区系CSV用リスト = new ArrayList<>();
    private List<TohyoritsuData> 選挙系CSV用リスト = new ArrayList<>();
    private Decimal 行政区系有権者男数 = Decimal.ZERO;
    private Decimal 行政区系有権者女数 = Decimal.ZERO;
    private Decimal 投票区系有権者男数 = Decimal.ZERO;
    private Decimal 投票区系有権者女数 = Decimal.ZERO;
    private Decimal 選挙系有権者男数 = Decimal.ZERO;
    private Decimal 選挙系有権者女数 = Decimal.ZERO;
    private boolean 行政区系不正データ有フラグ = false;
    private boolean 投票区系不正データ有フラグ = false;
    private boolean 選挙系不正データ有フラグ = false;
    private static final RString 文字列_不正データ = new RString("不正データ");
    private static final RString 文字列_合計 = new RString("** 合計 **");
    private static final RString 文字列_100以上計 = new RString("100以上計");

    private static final int 年齢_100 = 100;
    private static final int 年齢_十用 = 10;
    private static final int 年齢_九用 = 9;
    private static final int 年齢_四用 = 4;
    private static final int ラベルリスト_MINAGE位置 = 3;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE505SelectProcessParameter
     */
    public NenreibetsuTohyoritsuBreakCore(AFABTE505SelectProcessParameter parameter) {
        this.帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        this.parameter = parameter;

        ラベルリスト = new TohyoKekkaShukeihyo().get年齢年代ラベル(TohyoKekkaShukeihyo.LabelShurui.年齢, parameter.getOrder());
        mapInit(NenreibetsuTohyoritsuReportSource.DataType.行政区系);
        mapInit(NenreibetsuTohyoritsuReportSource.DataType.投票区系);
        mapInit(NenreibetsuTohyoritsuReportSource.DataType.選挙系);
    }

    private void mapInit(NenreibetsuTohyoritsuReportSource.DataType type) {
        if (NenreibetsuTohyoritsuReportSource.DataType.行政区系.equals(type)) {
            行政区系 = new HashMap<>();
        } else if (NenreibetsuTohyoritsuReportSource.DataType.投票区系.equals(type)) {
            投票区系 = new HashMap<>();
        } else if (NenreibetsuTohyoritsuReportSource.DataType.選挙系.equals(type)) {
            選挙系 = new HashMap<>();
        }

        for (RString ラベル : ラベルリスト) {
            TohyoritsuData ページデータ = new TohyoritsuData();
            TohyoritsuListData 年代データ = new TohyoritsuListData();
            年代データ.setラベル(ラベル);
            ページデータ.setCommonHeader(帳票共通ヘッダー);
            ページデータ.setParam(parameter);
            ページデータ.setType(type);
            ページデータ.set年代Data(年代データ);

            TohyoritsuListData 当日分データ = new TohyoritsuListData();
            当日分データ.setラベル(new RString("当日分"));
            ページデータ.set当日分Data(当日分データ);

            TohyoritsuListData 期日前不在者データ = new TohyoritsuListData();
            期日前不在者データ.setラベル(new RString("期日前＋不在者分"));
            ページデータ.set期日前不在者分Data(期日前不在者データ);

            if (NenreibetsuTohyoritsuReportSource.DataType.行政区系.equals(type)) {
                行政区系.put(ラベル, ページデータ);
            } else if (NenreibetsuTohyoritsuReportSource.DataType.投票区系.equals(type)) {
                投票区系.put(ラベル, ページデータ);
            } else if (NenreibetsuTohyoritsuReportSource.DataType.選挙系.equals(type)) {
                選挙系.put(ラベル, ページデータ);
            }
        }
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(TohyokekkaPrintEntity current) {
        if (null != current) {
            RString ラベル = getラベル(current);
            countUp(ラベル, current);
            if (!文字列_不正データ.equals(ラベル) && !文字列_100以上計.equals(ラベル)) {
                countUp(get小計ラベル(current), current);
            }
            countUp(文字列_合計, current);
            csvCountUp(current);
        }
    }

    private void csvCountUp(TohyokekkaPrintEntity current) {
        if (TohyoritsuCommonCore.is有権者(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系有権者男数 = 行政区系有権者男数.add(Decimal.ONE);
                投票区系有権者男数 = 投票区系有権者男数.add(Decimal.ONE);
                選挙系有権者男数 = 選挙系有権者男数.add(Decimal.ONE);
            } else {
                行政区系有権者女数 = 行政区系有権者女数.add(Decimal.ONE);
                投票区系有権者女数 = 投票区系有権者女数.add(Decimal.ONE);
                選挙系有権者女数 = 選挙系有権者女数.add(Decimal.ONE);
            }
        }
    }

    private void countUp(RString ラベル, TohyokekkaPrintEntity current) {
        TohyoritsuData 行政区系data = 行政区系.get(ラベル);
        TohyoritsuData 投票区系data = 投票区系.get(ラベル);
        TohyoritsuData 選挙系data = 選挙系.get(ラベル);
        TohyoritsuListData 行政区系年代Data = 行政区系data.get年代Data();
        TohyoritsuListData 投票区系年代Data = 投票区系data.get年代Data();
        TohyoritsuListData 選挙系年代Data = 選挙系data.get年代Data();

        if (文字列_不正データ.equals(ラベル)) {
            行政区系不正データ有フラグ = true;
            投票区系不正データ有フラグ = true;
            選挙系不正データ有フラグ = true;
        }

        if (TohyoritsuCommonCore.is有権者(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系年代Data.set有権者男数(行政区系年代Data.get有権者男数().add(Decimal.ONE));
                投票区系年代Data.set有権者男数(投票区系年代Data.get有権者男数().add(Decimal.ONE));
                選挙系年代Data.set有権者男数(選挙系年代Data.get有権者男数().add(Decimal.ONE));
            } else {
                行政区系年代Data.set有権者女数(行政区系年代Data.get有権者女数().add(Decimal.ONE));
                投票区系年代Data.set有権者女数(投票区系年代Data.get有権者女数().add(Decimal.ONE));
                選挙系年代Data.set有権者女数(選挙系年代Data.get有権者女数().add(Decimal.ONE));
            }
        }
        if (TohyoritsuCommonCore.is投票者(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系年代Data.set投票者男数(行政区系年代Data.get投票者男数().add(Decimal.ONE));
                投票区系年代Data.set投票者男数(投票区系年代Data.get投票者男数().add(Decimal.ONE));
                選挙系年代Data.set投票者男数(選挙系年代Data.get投票者男数().add(Decimal.ONE));
            } else {
                行政区系年代Data.set投票者女数(行政区系年代Data.get投票者女数().add(Decimal.ONE));
                投票区系年代Data.set投票者女数(投票区系年代Data.get投票者女数().add(Decimal.ONE));
                選挙系年代Data.set投票者女数(選挙系年代Data.get投票者女数().add(Decimal.ONE));
            }
        }
        if (TohyoritsuCommonCore.is棄権者(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系年代Data.set棄権者男数(行政区系年代Data.get棄権者男数().add(Decimal.ONE));
                投票区系年代Data.set棄権者男数(投票区系年代Data.get棄権者男数().add(Decimal.ONE));
                選挙系年代Data.set棄権者男数(選挙系年代Data.get棄権者男数().add(Decimal.ONE));
            } else {
                行政区系年代Data.set棄権者女数(行政区系年代Data.get棄権者女数().add(Decimal.ONE));
                投票区系年代Data.set棄権者女数(投票区系年代Data.get棄権者女数().add(Decimal.ONE));
                選挙系年代Data.set棄権者女数(選挙系年代Data.get棄権者女数().add(Decimal.ONE));
            }
        }
        if (TohyoritsuCommonCore.is当日分(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系data.get当日分Data().set投票者男数(行政区系data.get当日分Data().get投票者男数().add(Decimal.ONE));
                投票区系data.get当日分Data().set投票者男数(投票区系data.get当日分Data().get投票者男数().add(Decimal.ONE));
                選挙系data.get当日分Data().set投票者男数(選挙系data.get当日分Data().get投票者男数().add(Decimal.ONE));
            } else {
                行政区系data.get当日分Data().set投票者女数(行政区系data.get当日分Data().get投票者女数().add(Decimal.ONE));
                投票区系data.get当日分Data().set投票者女数(投票区系data.get当日分Data().get投票者女数().add(Decimal.ONE));
                選挙系data.get当日分Data().set投票者女数(選挙系data.get当日分Data().get投票者女数().add(Decimal.ONE));
            }
        }
        if (TohyoritsuCommonCore.is期日前不在者分(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系data.get期日前不在者分Data().set投票者男数(行政区系data.get期日前不在者分Data().get投票者男数().add(Decimal.ONE));
                投票区系data.get期日前不在者分Data().set投票者男数(投票区系data.get期日前不在者分Data().get投票者男数().add(Decimal.ONE));
                選挙系data.get期日前不在者分Data().set投票者男数(選挙系data.get期日前不在者分Data().get投票者男数().add(Decimal.ONE));
            } else {
                行政区系data.get期日前不在者分Data().set投票者女数(行政区系data.get期日前不在者分Data().get投票者女数().add(Decimal.ONE));
                投票区系data.get期日前不在者分Data().set投票者女数(投票区系data.get期日前不在者分Data().get投票者女数().add(Decimal.ONE));
                選挙系data.get期日前不在者分Data().set投票者女数(選挙系data.get期日前不在者分Data().get投票者女数().add(Decimal.ONE));
            }
        }

        if (TohyoritsuCommonCore.is期日前(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系data.get期日前不在者分Data().set期日前投票男(行政区系data.get期日前不在者分Data().get期日前投票男().add(Decimal.ONE));
            } else {
                行政区系data.get期日前不在者分Data().set期日前投票女(行政区系data.get期日前不在者分Data().get期日前投票女().add(Decimal.ONE));
            }
        }

        if (TohyoritsuCommonCore.is不在者(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系data.get期日前不在者分Data().set不在投票者男(行政区系data.get期日前不在者分Data().get不在投票者男().add(Decimal.ONE));
            } else {
                行政区系data.get期日前不在者分Data().set不在投票者女(行政区系data.get期日前不在者分Data().get不在投票者女().add(Decimal.ONE));
            }
        }

        if (TohyoritsuCommonCore.is交付者(current)) {
            if (TohyoritsuCommonCore.is男(current)) {
                行政区系data.get期日前不在者分Data().set交付男(行政区系data.get期日前不在者分Data().get交付男().add(Decimal.ONE));
            } else {
                行政区系data.get期日前不在者分Data().set交付女(行政区系data.get期日前不在者分Data().get交付女().add(Decimal.ONE));
            }
        }
    }

    /**
     * keyBreakChohyoProcess
     *
     * @param before before
     * @param current current
     * @return List<TohyoritsuData>
     */
    public List<TohyoritsuData> keyBreakChohyoProcess(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        List<TohyoritsuData> resultList = new ArrayList<>();
        if (isNew投票区(before, current) || isNew選挙(before, current)) {
            resultList.addAll(getリスト(NenreibetsuTohyoritsuReportSource.DataType.投票区系, before));
            mapInit(NenreibetsuTohyoritsuReportSource.DataType.投票区系);
            投票区系不正データ有フラグ = false;
        }
        if (isNew選挙(before, current)) {
            resultList.addAll(getリスト(NenreibetsuTohyoritsuReportSource.DataType.選挙系, before));
            mapInit(NenreibetsuTohyoritsuReportSource.DataType.選挙系);
            選挙系不正データ有フラグ = false;
        }
        return resultList;
    }

    /**
     * keyBreakCsvProcess
     *
     * @param before before
     * @param current current
     * @return List<TohyoritsuData>
     */
    public List<TohyoritsuData> keyBreakCsvProcess(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        List<TohyoritsuData> resultList = new ArrayList<>();
        if (isNew行政区(before, current) || isNew投票区(before, current) || isNew選挙(before, current)) {
            行政区系CSV用リスト.addAll(getリスト(NenreibetsuTohyoritsuReportSource.DataType.行政区系, before));
            mapInit(NenreibetsuTohyoritsuReportSource.DataType.行政区系);

            for (TohyoritsuData data : 行政区系CSV用リスト) {
                data.set行政区別有権者男数(行政区系有権者男数);
                data.set行政区別有権者女数(行政区系有権者女数);
            }
            投票区系CSV用リスト.addAll(行政区系CSV用リスト);

            行政区系有権者男数 = Decimal.ZERO;
            行政区系有権者女数 = Decimal.ZERO;
            行政区系CSV用リスト = new ArrayList<>();
            行政区系不正データ有フラグ = false;
        }

        if (isNew投票区(before, current) || isNew選挙(before, current)) {
            for (TohyoritsuData data : 投票区系CSV用リスト) {
                data.set投票区別有権者男数(投票区系有権者男数);
                data.set投票区別有権者女数(投票区系有権者女数);
            }
            選挙系CSV用リスト.addAll(投票区系CSV用リスト);

            投票区系有権者男数 = Decimal.ZERO;
            投票区系有権者女数 = Decimal.ZERO;
            投票区系CSV用リスト = new ArrayList<>();
        }

        if (isNew選挙(before, current)) {
            for (TohyoritsuData data : 選挙系CSV用リスト) {
                data.set選挙別有権者男数(選挙系有権者男数);
                data.set選挙別有権者女数(選挙系有権者女数);
            }
            resultList.addAll(選挙系CSV用リスト);

            選挙系有権者男数 = Decimal.ZERO;
            選挙系有権者女数 = Decimal.ZERO;
            選挙系CSV用リスト = new ArrayList<>();
        }
        return resultList;
    }

    private List<TohyoritsuData> getリスト(NenreibetsuTohyoritsuReportSource.DataType type, TohyokekkaPrintEntity entity) {
        List<TohyoritsuData> resultList = new ArrayList<>();
        List<RString> 出力用ラベルリスト = new ArrayList<>();
        for (RString ラベル : ラベルリスト) {
            出力用ラベルリスト.add(ラベル);
        }
        if (NenreibetsuTohyoritsuReportSource.DataType.行政区系.equals(type)) {
            if (!行政区系不正データ有フラグ) {
                出力用ラベルリスト.remove(文字列_不正データ);
            }
            for (RString ラベル : 出力用ラベルリスト) {
                行政区系.get(ラベル).setEntity(entity);
                resultList.add(行政区系.get(ラベル));
            }
        } else if (NenreibetsuTohyoritsuReportSource.DataType.投票区系.equals(type)) {
            if (!投票区系不正データ有フラグ) {
                出力用ラベルリスト.remove(文字列_不正データ);
            }
            for (RString ラベル : 出力用ラベルリスト) {
                投票区系.get(ラベル).setEntity(entity);
                resultList.add(投票区系.get(ラベル));
            }
        } else if (NenreibetsuTohyoritsuReportSource.DataType.選挙系.equals(type)) {
            if (!選挙系不正データ有フラグ) {
                出力用ラベルリスト.remove(文字列_不正データ);
            }
            for (RString ラベル : 出力用ラベルリスト) {
                選挙系.get(ラベル).setEntity(entity);
                resultList.add(選挙系.get(ラベル));
            }
        }
        return resultList;
    }

    /**
     * New行政区かどうか。
     *
     * @param before before
     * @param current current
     * @return New行政区かどうか
     */
    protected boolean isNew行政区(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        if (null == before) {
            return false;
        }
        if (null == current) {
            return true;
        }
        GyoseikuCode 行政区コード前 = before.get宛名情報Entity().getGyoseikuCode();
        GyoseikuCode 行政区コード現 = current.get宛名情報Entity().getGyoseikuCode();

        return !(null != 行政区コード前 && null != 行政区コード現 && 行政区コード前.equals(行政区コード現));
    }

    /**
     * New投票区かどうか。
     *
     * @param before before
     * @param current current
     * @return New投票区かどうか
     */
    protected boolean isNew投票区(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        if (null == before) {
            return false;
        }
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
    protected boolean isNew選挙(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        if (null == before) {
            return false;
        }
        if (null == current) {
            return true;
        }

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));
    }

    private RString getラベル(TohyokekkaPrintEntity current) {
        RString ラベル = RString.EMPTY;
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.get宛名情報Entity());
        if (!宛名対象.canBe個人()) {
            return ラベル;
        }
        IDateOfBirth 生年月日 = 宛名対象.to個人().get生年月日();
        if (null == 生年月日 || 生年月日.is不明()) {
            return 文字列_不正データ;
        }

        FlexibleDate 投票年月日 = current.get抄本Entity().getTohyoYMD();
        int 年齢 = null != 投票年月日 ? 投票年月日.plusDay(1).getBetweenYears(生年月日.toFlexibleDate()) : 0;

        if (年齢 >= 年齢_100) {
            return 文字列_100以上計;
        }

        for (RString ラベル名 : ラベルリスト) {
            if (ラベル名.length() == 2 && Integer.valueOf(ラベル名.toString()) == 年齢) {
                return ラベル名;
            }
        }

        return 文字列_不正データ;
    }

    private RString get小計ラベル(TohyokekkaPrintEntity current) {
        RString ラベル = RString.EMPTY;
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.get宛名情報Entity());
        if (!宛名対象.canBe個人()) {
            return ラベル;
        }
        IDateOfBirth 生年月日 = 宛名対象.to個人().get生年月日();
        if (null == 生年月日 || 生年月日.is不明()) {
            return 文字列_不正データ;
        }

        FlexibleDate 投票年月日 = current.get抄本Entity().getTohyoYMD();
        int 年齢 = null != 投票年月日 ? 投票年月日.plusDay(1).getBetweenYears(生年月日.toFlexibleDate()) : 0;

        if (年齢 >= 年齢_100) {
            return 文字列_100以上計;
        }

        if (年齢 % 年齢_十用 > 年齢_四用) {
            年齢 = 年齢 + (年齢_九用 - 年齢 % 年齢_十用);
        } else {
            年齢 = 年齢 + (年齢_四用 - 年齢 % 年齢_十用);
        }

        int minAge;
        if (parameter.getOrder().equals(Order.ASC)) {
            minAge = Integer.valueOf(ラベルリスト.get(0).toString());
        } else {
            minAge = Integer.valueOf(ラベルリスト.get(ラベルリスト.size() - ラベルリスト_MINAGE位置).toString());
        }
        if (年齢 < minAge) {
            return 文字列_不正データ;
        }

        for (RString ラベル名 : ラベルリスト) {
            if (ラベル名.length() > 2 && ラベル名.indexOf(String.valueOf(年齢)) > 0) {
                return ラベル名;
            }
        }

        return 文字列_不正データ;
    }

    /**
     * EUCのcsvデータ
     *
     * @param data TohyoritsuData
     * @return entity NenreibetsuTohyoritsuCsvEntity
     */
    public NenreibetsuTohyoritsuCsvEntity createCsvEntity(TohyoritsuData data) {
        NenreibetsuTohyoritsuCsvEntityEditor editor = NenreibetsuTohyoritsuCsvEntityEditor.createInstance(data);
        return editor.createEntity();
    }
}
