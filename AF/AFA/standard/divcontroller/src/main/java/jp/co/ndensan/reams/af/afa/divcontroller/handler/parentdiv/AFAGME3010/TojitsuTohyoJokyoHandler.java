/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.TojitsuTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.TojitsuTohyoShukei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.dgTojitsuTohyoShukei_Row;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo.TojitsuTohyoManager;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * TojitsuTohyoJokyoDivの操作を担当するクラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoJokyoHandler {

    private static final RString 期日前 = new RString("期日前");
    private static final RString RST_0 = new RString("0");
    private static final RString 不在分 = new RString("不在分");
    private static final RString フォーマット = new RString("#,##0.00");
    private static final int ニ三 = 23;
    private static final int 五九 = 59;
    private static final int 一 = 1;
    private static final int 一四四零 = 1440;

    /**
     * コンストラクタです。
     *
     */
    public TojitsuTohyoJokyoHandler() {
    }

    /**
     * 選挙情報を取得します。
     *
     * @param 抄本番号 RString
     * @return List<dgKijitsumaeTohyoShukei_Row>
     */
    public List<KeyValueDataSource> getSenkyoDataSource(RString 抄本番号) {
        List<Senkyo> senkyo = SenkyoManager.createInstance().get選挙By抄本番号(new ShohonNo(抄本番号));

        List<KeyValueDataSource> source = new ArrayList<>();
        for (Senkyo senkyoitem : senkyo) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(senkyoitem.get選挙番号().getColumnValue().toString()));
            dataSource.setValue(senkyoitem.get選挙略称());
            source.add(dataSource);
        }
        return source;
    }

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param 投票区コード RString
     * @param 集計単位 int
     * @param 選挙種類 SenkyoShurui
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @return List<dgKijitsumaeTohyoShukei_Row>
     */
    public List<dgTojitsuTohyoShukei_Row> createTohyoJokyoShukeiDataSource(RString 投票区コード, SenkyoShurui 選挙種類,
            int 集計単位, RString shohonNo, RString senkyoNo) {
        List<dgTojitsuTohyoShukei_Row> dataSource = new ArrayList<>();
        ShohonSearchResult 抄本情報 = TojitsuTohyoManager.createInstance().get選挙(new ShohonNo(shohonNo), new SenkyoNo(senkyoNo));
        if (null != 抄本情報) {
            FlexibleDate 投票年月日 = 抄本情報.get投票年月日();
            FlexibleDate 規定年齢到達年月日 = 抄本情報.get規定年齢到達年月日();
            FlexibleDate 投票受付開始年月日 = 抄本情報.get投票受付開始年月日();
            FlexibleDate 転入期限年月日 = 抄本情報.get転入期限年月日();
            FlexibleDate 転出期限年月日 = 抄本情報.get転出期限年月日();
            FlexibleDate 名簿基準年月日 = 抄本情報.get名簿基準年月日();

            TojitsuTohyoShukei 投票所状況 = TojitsuTohyoManager.createInstance().get投票所状況(投票区コード, 選挙種類);
            if (null == 投票所状況) {
                return dataSource;
            }
            RTime 投票開始時間 = 投票所状況.get投票開始時間();
            RTime 投票終了時間 = 投票所状況.get投票終了時間();

            List<TojitsuTohyoChohyoData> 選挙人名簿宛名PSM = TojitsuTohyoManager.createInstance().get選挙人情報(
                    new ShohonNo(shohonNo), new Code(選挙種類.getCode()));
            if (選挙人名簿宛名PSM != null && !選挙人名簿宛名PSM.isEmpty()) {
                dataSource.add(createDataSource投票状況1行目(shohonNo, senkyoNo, 投票年月日,
                        規定年齢到達年月日, 投票受付開始年月日, 転入期限年月日, 転出期限年月日,
                        名簿基準年月日, 選挙種類, 選挙人名簿宛名PSM));
                dataSource.add(createDataSource投票状況2行目(shohonNo, senkyoNo, 投票年月日,
                        規定年齢到達年月日, 投票受付開始年月日, 転入期限年月日, 転出期限年月日,
                        名簿基準年月日, 選挙種類, 選挙人名簿宛名PSM));
                dataSource = createDataSource3行目以降(dataSource, 集計単位, shohonNo, senkyoNo,
                        投票開始時間, 投票終了時間, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日,
                        名簿基準年月日, 選挙種類, 選挙人名簿宛名PSM);
            }
        }

        return dataSource;
    }

    private dgTojitsuTohyoShukei_Row createDataSource投票状況1行目(RString shohonNo, RString senkyoNo,
            FlexibleDate 投票日, FlexibleDate 規定年齢到達日, FlexibleDate 投票受付開始日,
            FlexibleDate 転入期限日, FlexibleDate 転出期限日, FlexibleDate 名簿基準日,
            SenkyoShurui 選挙種類, List<TojitsuTohyoChohyoData> 宛名PSM) {
        List<RString> tohyoJokyolist1 = new ArrayList<>();
        tohyoJokyolist1.add(TohyoJokyo.期日前.getCode());
        TojitsuTohyoShukei 投票状況1行目 = TojitsuTohyoManager.createInstance().get投票状況1行と2行(投票日, 投票受付開始日,
                new ShohonNo(shohonNo), tohyoJokyolist1, new SenkyoNo(senkyoNo), ControlDataHolder.getClientId());
        dgTojitsuTohyoShukei_Row row = new dgTojitsuTohyoShukei_Row();
        if (投票状況1行目 != null) {
            row.setTxtTohyoTime(期日前);
            row.getTxtManTojitsu().setValue(new Decimal(投票状況1行目.getHonjitsuTohyoSuMale()));
            row.getTxtWomanTojitsu().setValue(new Decimal(投票状況1行目.getHonjitsuTohyoSuFemale()));
            row.getTxtKeiTojitsu().setValue(row.getTxtManTojitsu().getValue().
                    add(row.getTxtWomanTojitsu().getValue()));
            row.setTxtTohyoRitsu(get投票率(宛名PSM, 投票日, 転入期限日,
                    規定年齢到達日, 転出期限日, 名簿基準日, row.getTxtKeiTojitsu().getValue(), 選挙種類));
            row.getTxtManRuikei().setValue(row.getTxtManTojitsu().getValue());
            row.getTxtWomanRuikei().setValue(row.getTxtWomanTojitsu().getValue());
            row.getTxtKeiRuikei().setValue(row.getTxtManRuikei().getValue().
                    add(row.getTxtWomanRuikei().getValue()));
            row.setTxtTohyoRitsuRuikei(get投票率(宛名PSM, 投票日, 転入期限日,
                    規定年齢到達日, 転出期限日, 名簿基準日, row.getTxtKeiRuikei().getValue(), 選挙種類));
        } else {
            row = createDataSource投票状況空白行(期日前);
        }
        return row;
    }

    private dgTojitsuTohyoShukei_Row createDataSource投票状況空白行(RString time) {
        dgTojitsuTohyoShukei_Row row = new dgTojitsuTohyoShukei_Row();
        row.setTxtTohyoTime(time);
        row.getTxtManTojitsu().setValue(Decimal.ZERO);
        row.getTxtWomanTojitsu().setValue(Decimal.ZERO);
        row.getTxtKeiTojitsu().setValue(Decimal.ZERO);
        row.setTxtTohyoRitsu(new RString(Decimal.ZERO.toString(フォーマット.toString())));
        row.getTxtManRuikei().setValue(Decimal.ZERO);
        row.getTxtWomanRuikei().setValue(Decimal.ZERO);
        row.getTxtKeiRuikei().setValue(Decimal.ZERO);
        row.setTxtTohyoRitsuRuikei(new RString(Decimal.ZERO.toString(フォーマット.toString())));
        return row;

    }

    private dgTojitsuTohyoShukei_Row createDataSource投票状況2行目(RString shohonNo, RString senkyoNo,
            FlexibleDate 投票年月日, FlexibleDate 規定年齢到達年月日, FlexibleDate 投票受付開始年月日,
            FlexibleDate 転入期限年月日, FlexibleDate 転出期限年月日, FlexibleDate 名簿基準年月日,
            SenkyoShurui 選挙種類, List<TojitsuTohyoChohyoData> 選挙人名簿宛名PSM) {
        List<RString> tohyoJokyolist2 = new ArrayList<>();
        tohyoJokyolist2.add(TohyoJokyo.請求.getCode());
        tohyoJokyolist2.add(TohyoJokyo.交付.getCode());
        tohyoJokyolist2.add(TohyoJokyo.受理.getCode());
        tohyoJokyolist2.add(TohyoJokyo.返還.getCode());
        TojitsuTohyoShukei 投票状況2行目 = TojitsuTohyoManager.createInstance().get投票状況1行と2行(投票年月日, 投票受付開始年月日,
                new ShohonNo(shohonNo), tohyoJokyolist2, new SenkyoNo(senkyoNo), ControlDataHolder.getClientId());
        dgTojitsuTohyoShukei_Row row = new dgTojitsuTohyoShukei_Row();
        if (投票状況2行目 != null) {
            row.setTxtTohyoTime(不在分);
            row.getTxtManTojitsu().setValue(new Decimal(投票状況2行目.getHonjitsuTohyoSuMale()));
            row.getTxtWomanTojitsu().setValue(new Decimal(投票状況2行目.getHonjitsuTohyoSuFemale()));
            row.getTxtKeiTojitsu().setValue(row.getTxtManTojitsu().getValue().add(row.getTxtWomanTojitsu().getValue()));
            row.setTxtTohyoRitsu(get投票率(選挙人名簿宛名PSM, 投票年月日, 転入期限年月日,
                    規定年齢到達年月日, 転出期限年月日, 名簿基準年月日, row.getTxtKeiTojitsu().getValue(), 選挙種類));
            row.getTxtManRuikei().setValue(row.getTxtManTojitsu().getValue());
            row.getTxtWomanRuikei().setValue(row.getTxtWomanTojitsu().getValue());
            row.getTxtKeiRuikei().setValue(row.getTxtManRuikei().getValue().add(row.getTxtWomanRuikei().getValue()));
            row.setTxtTohyoRitsuRuikei(get投票率(選挙人名簿宛名PSM, 投票年月日, 転入期限年月日,
                    規定年齢到達年月日, 転出期限年月日, 名簿基準年月日, row.getTxtKeiRuikei().getValue(), 選挙種類));
        } else {
            row = createDataSource投票状況空白行(不在分);
        }
        return row;
    }

    private List<dgTojitsuTohyoShukei_Row> createDataSource3行目以降(List<dgTojitsuTohyoShukei_Row> dataSource,
            int 集計単位, RString shohonNo, RString senkyoNo, RTime 投票開始時間, RTime 投票終了時間,
            FlexibleDate 投票年月日, FlexibleDate 規定年齢到達年月日, FlexibleDate 転入期限年月日,
            FlexibleDate 転出期限年月日, FlexibleDate 名簿基準年月日, SenkyoShurui 選挙種類, List<TojitsuTohyoChohyoData> 選挙人名簿宛名PSM) {
        List<RString> tohyoJokyolist3 = new ArrayList<>();
        tohyoJokyolist3.add(TohyoJokyo.当日.getCode());
        RTime 交付時刻TO = RTime.of(0, 0, 0, 0);
        RTime 交付時刻temp = new Decimal(交付時刻TO.minutesDuration(投票開始時間)).add(new Decimal(集計単位))
                .compareTo(new Decimal(一四四零)) > 0
                ? RTime.of(ニ三, 五九, 五九, 0) : 投票開始時間.plusMinutes(集計単位).minusSeconds(一);
        Decimal 累積投票数_男 = Decimal.ZERO;
        Decimal 累積投票数_女 = Decimal.ZERO;
        TojitsuTohyoShukei 投票状況3行目 = TojitsuTohyoManager.createInstance().get投票状況3行目以降(集計単位,
                new ShohonNo(shohonNo), tohyoJokyolist3, new SenkyoNo(senkyoNo), ControlDataHolder.getClientId(),
                RTime.of(0, 0, 0, 0), 交付時刻temp);
        if (投票状況3行目 != null) {
            dgTojitsuTohyoShukei_Row row_3行目 = set3行目以降(投票開始時間, 投票状況3行目, 選挙人名簿宛名PSM,
                    累積投票数_男, 累積投票数_女, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日, 名簿基準年月日, 選挙種類);
            dataSource.add(row_3行目);
            累積投票数_男 = row_3行目.getTxtManRuikei().getValue();
            累積投票数_女 = row_3行目.getTxtWomanRuikei().getValue();
        } else {
            dgTojitsuTohyoShukei_Row row_3行目 = set3行目以降データなし(投票開始時間, 選挙人名簿宛名PSM,
                    累積投票数_男, 累積投票数_女, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日, 名簿基準年月日, 選挙種類);
            dataSource.add(row_3行目);
            累積投票数_男 = row_3行目.getTxtManRuikei().getValue();
            累積投票数_女 = row_3行目.getTxtWomanRuikei().getValue();
        }
        if (new Decimal(投票開始時間.minutesDuration(投票終了時間)).compareTo(new Decimal(集計単位)) < 0) {
            return dataSource;
        }
        for (RTime 交付時刻From = 投票開始時間.plusMinutes(集計単位); 交付時刻TO.compareTo(投票終了時間.minusMinutes(集計単位)) <= 0;
                交付時刻From = 交付時刻From.plusMinutes(集計単位)) {
            交付時刻TO = 交付時刻From.plusMinutes(集計単位);
            TojitsuTohyoShukei 投票状況4行目以降 = TojitsuTohyoManager.createInstance().get投票状況3行目以降(集計単位,
                    new ShohonNo(shohonNo), tohyoJokyolist3, new SenkyoNo(senkyoNo), ControlDataHolder.getClientId(),
                    交付時刻From, 交付時刻TO.minusSeconds(一));
            if (投票状況4行目以降 != null) {
                dgTojitsuTohyoShukei_Row row_4行目以降 = set3行目以降(交付時刻From, 投票状況4行目以降, 選挙人名簿宛名PSM,
                        累積投票数_男, 累積投票数_女, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日, 名簿基準年月日, 選挙種類);
                dataSource.add(row_4行目以降);
                累積投票数_男 = row_4行目以降.getTxtManRuikei().getValue();
                累積投票数_女 = row_4行目以降.getTxtWomanRuikei().getValue();
            } else {
                dgTojitsuTohyoShukei_Row row_4行目以降 = set3行目以降データなし(交付時刻From, 選挙人名簿宛名PSM,
                        累積投票数_男, 累積投票数_女, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日, 名簿基準年月日, 選挙種類);
                dataSource.add(row_4行目以降);
                累積投票数_男 = row_4行目以降.getTxtManRuikei().getValue();
                累積投票数_女 = row_4行目以降.getTxtWomanRuikei().getValue();
            }
        }
        if (交付時刻TO.compareTo(投票終了時間) > 0) {
            return dataSource;
        }
        TojitsuTohyoShukei 投票状況終了行目 = TojitsuTohyoManager.createInstance().get投票状況3行目以降(集計単位,
                new ShohonNo(shohonNo), tohyoJokyolist3, new SenkyoNo(senkyoNo), ControlDataHolder.getClientId(),
                交付時刻TO, RTime.of(ニ三, 五九, 五九, 0));
        if (投票状況終了行目 != null) {
            dgTojitsuTohyoShukei_Row row_終了行目 = set3行目以降(交付時刻TO, 投票状況終了行目, 選挙人名簿宛名PSM,
                    累積投票数_男, 累積投票数_女, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日, 名簿基準年月日, 選挙種類);
            dataSource.add(row_終了行目);
        } else {
            dgTojitsuTohyoShukei_Row row_終了行目 = set3行目以降データなし(交付時刻TO, 選挙人名簿宛名PSM,
                    累積投票数_男, 累積投票数_女, 投票年月日, 規定年齢到達年月日, 転入期限年月日, 転出期限年月日, 名簿基準年月日, 選挙種類);
            dataSource.add(row_終了行目);
        }
        return dataSource;
    }

    private dgTojitsuTohyoShukei_Row set3行目以降(RTime 交付時刻From, TojitsuTohyoShukei 投票状況3行目以降,
            List<TojitsuTohyoChohyoData> 選挙人名簿宛名PSM, Decimal 累積投票数_男, Decimal 累積投票数_女,
            FlexibleDate 投票年月日, FlexibleDate 規定年齢到達年月日, FlexibleDate 転入期限年月日,
            FlexibleDate 転出期限年月日, FlexibleDate 名簿基準年月日, SenkyoShurui 選挙種類) {
        dgTojitsuTohyoShukei_Row row = new dgTojitsuTohyoShukei_Row();
        row.setTxtTohyoTime(交付時刻From.toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        row.getTxtManTojitsu().setValue(new Decimal(投票状況3行目以降.getHonjitsuTohyoSuMale()));
        row.getTxtWomanTojitsu().setValue(new Decimal(投票状況3行目以降.getHonjitsuTohyoSuFemale()));
        row.getTxtKeiTojitsu().setValue(row.getTxtManTojitsu().getValue().add(row.getTxtWomanTojitsu().getValue()));
        row.setTxtTohyoRitsu(get投票率(選挙人名簿宛名PSM, 投票年月日, 転入期限年月日,
                規定年齢到達年月日, 転出期限年月日, 名簿基準年月日, row.getTxtKeiTojitsu().getValue(), 選挙種類));
        row.getTxtManRuikei().setValue(累積投票数_男.add(row.getTxtManTojitsu().getValue()));
        row.getTxtWomanRuikei().setValue(累積投票数_女.add(row.getTxtWomanTojitsu().getValue()));
        row.getTxtKeiRuikei().setValue(row.getTxtManRuikei().getValue().add(row.getTxtWomanRuikei().getValue()));
        row.setTxtTohyoRitsuRuikei(get投票率(選挙人名簿宛名PSM, 投票年月日, 転入期限年月日,
                規定年齢到達年月日, 転出期限年月日, 名簿基準年月日, row.getTxtKeiRuikei().getValue(), 選挙種類));
        return row;
    }

    private dgTojitsuTohyoShukei_Row set3行目以降データなし(RTime 交付時刻From,
            List<TojitsuTohyoChohyoData> 選挙人名簿宛名PSM, Decimal 累積投票数_男, Decimal 累積投票数_女,
            FlexibleDate 投票年月日, FlexibleDate 規定年齢到達年月日, FlexibleDate 転入期限年月日,
            FlexibleDate 転出期限年月日, FlexibleDate 名簿基準年月日, SenkyoShurui 選挙種類) {
        dgTojitsuTohyoShukei_Row row = new dgTojitsuTohyoShukei_Row();
        row.setTxtTohyoTime(交付時刻From.toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        row.getTxtManTojitsu().setValue(Decimal.ZERO);
        row.getTxtWomanTojitsu().setValue(Decimal.ZERO);
        row.getTxtKeiTojitsu().setValue(row.getTxtManTojitsu().getValue().add(row.getTxtWomanTojitsu().getValue()));
        row.setTxtTohyoRitsu(new RString(Decimal.ZERO.toString(フォーマット.toString())));
        row.getTxtManRuikei().setValue(累積投票数_男.add(row.getTxtManTojitsu().getValue()));
        row.getTxtWomanRuikei().setValue(累積投票数_女.add(row.getTxtWomanTojitsu().getValue()));
        row.getTxtKeiRuikei().setValue(row.getTxtManRuikei().getValue().add(row.getTxtWomanRuikei().getValue()));
        row.setTxtTohyoRitsuRuikei(get投票率(選挙人名簿宛名PSM, 投票年月日, 転入期限年月日,
                規定年齢到達年月日, 転出期限年月日, 名簿基準年月日, row.getTxtKeiRuikei().getValue(), 選挙種類));
        return row;
    }

    //TODO #94926
    private RString get投票率(List<TojitsuTohyoChohyoData> 選挙人名簿宛名PSM, FlexibleDate 投票年月日,
            FlexibleDate 転入期限年月日, FlexibleDate 規定年齢到達年月日, FlexibleDate 転出期限年月日,
            FlexibleDate 名簿基準年月日, Decimal 計, SenkyoShurui 選挙種類) {
        int sum = 0;
        if (null == 投票年月日
                || null == 転入期限年月日
                || null == 規定年齢到達年月日
                || null == 転出期限年月日
                || null == 名簿基準年月日
                || null == 選挙種類) {
            sum = 0;
        }
//        ShikakuHantei shikakuHantei = new ShikakuHantei();
        for (TojitsuTohyoChohyoData data : 選挙人名簿宛名PSM) {
//            if (shikakuHantei.is有権者(data.getEntity().getAtenaPSMEntity(), 転入期限年月日, 規定年齢到達年月日,
//                    投票年月日, 選挙種類, data.getEntity().getSenkyoShikakuEntity())
//                    || shikakuHantei.is表示者(data.getEntity().getAtenaPSMEntity(), 転出期限年月日,
//                            規定年齢到達年月日, 投票年月日, 名簿基準年月日, 選挙種類)) {
//                sum++;
//            }
            if (data.getEntity() != null && data.getEntity().getAtenaPSMEntity() != null
                    && (is有権者test(new ShikibetsuCode("1000000000000")))
                    || is表示者test(new ShikibetsuCode("1000000000022"))) {
                sum++;
            }
        }
        return new RString(計.divide(sum).toString(フォーマット.toString()));
    }

    private boolean is有権者test(ShikibetsuCode shikibetsuCode) {
        return shikibetsuCode.getColumnValue().substring(一, 一).equals(RST_0);
    }

    private boolean is表示者test(ShikibetsuCode shikibetsuCode) {
        return !shikibetsuCode.getColumnValue().substring(一, 一).equals(RST_0);
    }
}
