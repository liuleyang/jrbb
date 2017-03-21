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
import jp.co.ndensan.reams.af.afa.business.core.JikanbetsuTohyoshaData;
import jp.co.ndensan.reams.af.afa.business.core.JikanbetsuTohyoshaParam;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.core.tohyoku.UrTohyoku;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.service.core.tohyoku.TohyokuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 年代別投票率集計表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0290-035 lit
 */
public class JikanbetsuTohyoshaBreakCore {

    private static final int COUNT_COLUMN = 5;
    private static final int COLUMN_FOUR = 4;
    private static final int COLUMN_THREE = 3;
    private static final int COLUMN_TWO = 2;
    private static final int COLUMN_ONE = 1;
    private static final int 集計時間帯_開始時間_文字開始位置 = 0;
    private static final int 集計時間帯_開始時間_文字終了位置 = 4;
    private static final int 集計時間帯_終了時間_文字開始位置 = 5;
    private static final int 集計時間帯_終了時間_文字終了位置 = 9;
    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;
    private final AFABTE505SelectProcessParameter parameter;

    private final List<JikanLabel> ラベルリスト = new ArrayList<>();
    private List<UrTohyoku> 投票区対象リスト = new ArrayList<>();
    private JikanbetsuTohyoshaData 投票区時間別データ = new JikanbetsuTohyoshaData();
    private Map<RString, JikanbetsuTohyoshaData> 投票区時間別Map = new HashMap<>();

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE505SelectProcessParameter
     */
    public JikanbetsuTohyoshaBreakCore(AFABTE505SelectProcessParameter parameter) {
        this.帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        this.parameter = parameter;
        getラベルリスト();
        投票区時間別データ = 初期化データ作成();
    }

    private JikanbetsuTohyoshaData 初期化データ作成() {
        JikanbetsuTohyoshaData data = new JikanbetsuTohyoshaData();
        for (JikanLabel ラベル : ラベルリスト) {
            data.put(ラベル.getラベル名(), false);
        }
        return data;
    }

    private void 投票区時間別MAP初期化() {
        投票区時間別Map = new HashMap<>();
    }

    private void get投票区対象一覧(Code 選挙種類, RString 投票区From, RString 投票区To, FlexibleDate 投票年月日) {
        List<UrTohyoku> 投票区リスト = TohyokuManager.createInstance().getUR投票区(選挙種類, 投票区From, 投票区To, 投票年月日);
        if (null == 投票区リスト) {
            return;
        }
        投票区対象リスト = 投票区リスト;
    }

    private JikanbetsuTohyoshaData create投票区時間別MAP空白データ() {
        JikanbetsuTohyoshaData result = new JikanbetsuTohyoshaData();
        for (JikanLabel ラベル : ラベルリスト) {
            result.put(ラベル.getラベル名(), true);
        }
        return result;
    }

    private JikanbetsuTohyoshaData create投票区時間別MAP合計データ() {
        JikanbetsuTohyoshaData result = new JikanbetsuTohyoshaData();
        for (JikanLabel ラベル : ラベルリスト) {
            result.put(ラベル.getラベル名(), false);
        }

        result.set投票区コード(RString.EMPTY);
        result.set投票所名称(new RString("*** 合 計 ***"));

        for (Map.Entry<RString, JikanbetsuTohyoshaData> entry : 投票区時間別Map.entrySet()) {
            for (JikanLabel ラベル : ラベルリスト) {
                RString ラベル名 = ラベル.getラベル名();
                result.countUp(ラベル名, true, entry.getValue().get時間帯男数(ラベル名));
                result.countUp(ラベル名, false, entry.getValue().get時間帯女数(ラベル名));
            }
        }

        return result;
    }

    /**
     * usualProcess
     *
     * @param before before
     * @param current current
     */
    public void usualProcess(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        if (null == before) {
            get投票区対象一覧(parameter.get選挙種類(), parameter.get投票区コードFROM(), parameter.get投票区コードTO(), current.get抄本Entity().getTohyoYMD());
        }

        if (null != current) {
            RString ラベル = getラベル(current);
            if (!ラベル.isEmpty()) {
                投票区時間別データ.set投票区コード(current.get選挙人名簿Entity().getTohyokuCode());
                投票区時間別データ.set投票所名称(null != current.get投票所Entity() ? current.get投票所Entity().getTohyojoName() : RString.EMPTY);
                投票区時間別データ.countUp(ラベル, TohyoritsuCommonCore.is男(current));
            }
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return 集計結果リスト List<JikanbetsuTohyoshaParam>
     */
    public List<JikanbetsuTohyoshaParam> keyBreakProcess(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        List<JikanbetsuTohyoshaParam> resultList = new ArrayList<>();
        if (isNew投票区(before, current) || isNew選挙(before, current)) {
            投票区時間別Map.put(投票区時間別データ.get投票区コード(), 投票区時間別データ);
            投票区時間別データ = 初期化データ作成();
        }

        if (isNew選挙(before, current)) {
            resultList = getResultList(before);
            投票区時間別MAP初期化();
        }
        return resultList;
    }

    private List<JikanbetsuTohyoshaData> 全部投票区投票区時間別リストを作成() {
        List<JikanbetsuTohyoshaData> resultList = new ArrayList<>();
        for (UrTohyoku 投票区 : 投票区対象リスト) {
            if (投票区時間別Map.containsKey(投票区.get投票区コード().value())) {
                resultList.add(投票区時間別Map.get(投票区.get投票区コード().value()));
            } else {
                JikanbetsuTohyoshaData data = 初期化データ作成();
                data.set投票区コード(投票区.get投票区コード().value());
                data.set投票所名称(投票区.get投票所名());
                resultList.add(data);
            }
        }
        if (!resultList.isEmpty()) {
            resultList.add(create投票区時間別MAP空白データ());
            resultList.add(create投票区時間別MAP合計データ());
        }

        return resultList;
    }

    private List<JikanbetsuTohyoshaParam> getResultList(TohyokekkaPrintEntity entity) {
        List<JikanbetsuTohyoshaParam> resultList = new ArrayList<>();
        JikanbetsuTohyoshaParam param;

        List<JikanbetsuTohyoshaData> 投票区時間別リスト = 全部投票区投票区時間別リストを作成();
        for (int i = 0; i < ラベルリスト.size() + 1; i = i + COUNT_COLUMN) {
            for (JikanbetsuTohyoshaData data : 投票区時間別リスト) {
                param = new JikanbetsuTohyoshaParam();
                param.set投票区コード(data.get投票区コード());
                param.set投票所名称(data.get投票所名称());
                param.setCommonHeader(帳票共通ヘッダー);
                param.setSubTitle(i / COUNT_COLUMN + 1);
                param.set選挙名(entity.get選挙Entity().getSenkyoName());
                param.set選挙番号(new RString(String.valueOf(entity.get選挙Entity().getSenkyoNo().value())));
                param.setParam(parameter);
                RString ラベル名;
                if (i >= ラベルリスト.size()) {
                    param.set時間帯1(RString.EMPTY);
                    param.set時間帯1男数(null);
                    param.set時間帯1女数(null);
                } else {
                    ラベル名 = ラベルリスト.get(i).getラベル名();
                    param.set時間帯1(ラベル名);
                    param.set時間帯1男数(data.get時間帯男数(ラベル名));
                    param.set時間帯1女数(data.get時間帯女数(ラベル名));
                }

                if (i + COLUMN_ONE >= ラベルリスト.size()) {
                    param.set時間帯2(RString.EMPTY);
                    param.set時間帯2男数(null);
                    param.set時間帯2女数(null);
                } else {
                    ラベル名 = ラベルリスト.get(i + COLUMN_ONE).getラベル名();
                    param.set時間帯2(ラベル名);
                    param.set時間帯2男数(data.get時間帯男数(ラベル名));
                    param.set時間帯2女数(data.get時間帯女数(ラベル名));
                }

                if (i + COLUMN_TWO >= ラベルリスト.size()) {
                    param.set時間帯3(RString.EMPTY);
                    param.set時間帯3男数(null);
                    param.set時間帯3女数(null);
                } else {
                    ラベル名 = ラベルリスト.get(i + COLUMN_TWO).getラベル名();
                    param.set時間帯3(ラベル名);
                    param.set時間帯3男数(data.get時間帯男数(ラベル名));
                    param.set時間帯3女数(data.get時間帯女数(ラベル名));
                }

                if (i + COLUMN_THREE >= ラベルリスト.size()) {
                    param.set時間帯4(RString.EMPTY);
                    param.set時間帯4男数(null);
                    param.set時間帯4女数(null);
                } else {
                    ラベル名 = ラベルリスト.get(i + COLUMN_THREE).getラベル名();
                    param.set時間帯4(ラベル名);
                    param.set時間帯4男数(data.get時間帯男数(ラベル名));
                    param.set時間帯4女数(data.get時間帯女数(ラベル名));
                }

                if (i + COLUMN_FOUR >= ラベルリスト.size()) {
                    ラベル名 = new RString("合計");
                    JikanbetsuTohyoshaData.JikanbetsuLabelData 合計 = data.get合計ラベル();
                    param.set時間帯5(ラベル名);
                    param.set時間帯5男数(合計.get時間帯男数());
                    param.set時間帯5女数(合計.get時間帯女数());
                } else {
                    ラベル名 = ラベルリスト.get(i + COLUMN_FOUR).getラベル名();
                    param.set時間帯5(ラベル名);
                    param.set時間帯5男数(data.get時間帯男数(ラベル名));
                    param.set時間帯5女数(data.get時間帯女数(ラベル名));
                }
                resultList.add(param);
            }
        }
        return resultList;
    }

    /**
     * New投票区かどうか。
     *
     * @param before before
     * @param current current
     * @return New投票区かどうか
     */
    private boolean isNew投票区(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
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
    private boolean isNew選挙(TohyokekkaPrintEntity before, TohyokekkaPrintEntity current) {
        if (null == current) {
            return true;
        }

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));
    }

    private RString getラベル(TohyokekkaPrintEntity current) {
        if (null == current.get投票状況Entity()) {
            return RString.EMPTY;
        }
        RTime 受理時間 = current.get投票状況Entity().getJuriTime();
        if (null == 受理時間) {
            return RString.EMPTY;
        }

        for (JikanLabel ラベル : ラベルリスト) {
            if (ラベル.is範囲内対象(受理時間)) {
                return ラベル.getラベル名();
            }
        }
        return RString.EMPTY;
    }

    private void getラベルリスト() {
        RString 集計時間帯 = BusinessConfig.get(ConfigKeysAFA.投票所時間別投票者集計表_集計時間帯);
        if (null == 集計時間帯 || 集計時間帯.isEmpty()) {
            return;
        }
        RTime 開始時間 = new RTime(集計時間帯.substring(集計時間帯_開始時間_文字開始位置, 集計時間帯_開始時間_文字終了位置));
        RTime 終了時間 = new RTime(集計時間帯.substring(集計時間帯_終了時間_文字開始位置, 集計時間帯_終了時間_文字終了位置));
        for (RTime start = new RTime(new RString("00:00")); start.isBefore(終了時間); start = start.plusHours(1)) {
            RTime end = start.plusHours(1);
            if (!end.isAfter(開始時間)) {
                continue;
            }
            RTime startTime = start.isBefore(開始時間) ? 開始時間 : start;
            RTime endTime = end.isAfter(終了時間) ? 終了時間 : end;
            ラベルリスト.add(new JikanLabel(startTime, endTime));

        }
    }

    /**
     * 時間ラベルのクラスです。
     */
    static class JikanLabel {

        private final RTime startTime;
        private final RTime endTime;

        /**
         * コストクラス。
         *
         */
        JikanLabel(RTime startTime, RTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        /**
         * ラベル名を返す。
         *
         * @return ラベル名
         */
        RString getラベル名() {
            if (null == startTime || null == endTime) {
                return RString.EMPTY;
            }

            return startTime.toFormattedTimeString(DisplayTimeFormat.HH_mm)
                    .concat(new RString("～"))
                    .concat(endTime.toFormattedTimeString(DisplayTimeFormat.HH_mm));
        }

        /**
         * 範囲内対象かどうか。
         *
         * @param 受理時刻
         * @return 範囲内対象かどうか
         */
        boolean is範囲内対象(RTime 受理時刻) {
            if (null == 受理時刻) {
                return false;
            }

            return 受理時刻.isBefore(endTime) && !startTime.isAfter(受理時刻);
        }
    }
}
