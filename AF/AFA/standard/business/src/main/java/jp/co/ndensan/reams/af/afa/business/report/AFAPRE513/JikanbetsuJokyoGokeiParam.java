package jp.co.ndensan.reams.af.afa.business.report.AFAPRE513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計のパラメータクラスです。
 *
 * @reamsid_L AF-0280-030 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JikanbetsuJokyoGokeiParam {

    private final FlexibleDate 日付;
    private final SenkyoNo 選挙番号;
    private final RString 選挙名称;

    private final List<Decimal> 投票数;
    private final List<Decimal> 不在者数;
    private Decimal 投票数計;
    private Decimal 不在者数計;

    private Decimal その他投票数;
    private Decimal 投票者数合計;

    private final TeijiCommonJohoItem 選挙帳票共通情報;
    private final RString 時間帯１;
    private final RString 時間帯２;
    private final RString 時間帯３;
    private final RString 時間帯４;

    private boolean is合計;
    private List<Decimal> 合計投票数;
    private List<Decimal> 合計不在者数;
    private Decimal 合計投票数計;
    private Decimal 合計不在者数計;
    private Decimal 合計その他投票数;
    private Decimal 合計投票者数合計;
    private List<Decimal> 時間別投票率;
    private List<Decimal> 投票人数_１時間あたり;
    private Decimal 投票人数計_１時間あたり;

    private JikanbetsuJokyoGokeiParam(FlexibleDate 日付,
            SenkyoNo 選挙番号,
            RString 選挙名称,
            TeijiCommonJohoItem 選挙帳票共通情報,
            RString 時間帯１,
            RString 時間帯２,
            RString 時間帯３,
            RString 時間帯４) {
        this.日付 = 日付;
        this.選挙番号 = 選挙番号;
        this.選挙名称 = 選挙名称;

        this.投票数 = initDecimalList();
        this.不在者数 = initDecimalList();
        this.投票数計 = Decimal.ZERO;
        this.不在者数計 = Decimal.ZERO;
        this.その他投票数 = Decimal.ZERO;
        this.投票者数合計 = Decimal.ZERO;
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.時間帯１ = 時間帯１;
        this.時間帯２ = 時間帯２;
        this.時間帯３ = 時間帯３;
        this.時間帯４ = 時間帯４;
        this.is合計 = false;
    }

    private static List<Decimal> initDecimalList() {
        return new ArrayList<>(Arrays.asList(Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO));
    }

    private void addCount(Jikantai 時間帯, AfT201TohyoJokyoEntity 投票状況) {

        Code 投票状況Code = 投票状況.getTohyoJokyo();
        Code 受理施設種別 = 投票状況.getJuriShisetsuShubetsu();

        if (投票状況Code != null
                && (TohyoJokyo.受理.getCode().equals(投票状況Code.getColumnValue())
                || TohyoJokyo.期日前.getCode().equals(投票状況Code.getColumnValue()))) {
            投票者数合計 = 投票者数合計.add(Decimal.ONE);
            // 投票資格の情報.投票状況.受理施設種別＝01（本庁）のデータを対象とする。
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 16 LINES
            if (受理施設種別 != null && ShisetsuShubetsu.一般_本庁.getCode().equals(受理施設種別.getColumnValue())) {
                投票数計 = 投票数計.add(Decimal.ONE);
                if (TohyoJokyo.受理.getCode().equals(投票状況Code.getColumnValue())) {
                    不在者数計 = 不在者数計.add(Decimal.ONE);
                }
                Jikantai.JikantaiType 集計時間帯 = 時間帯.get時間帯Index(投票状況.getJuriTime());
                if (集計時間帯 != null) {
                    投票数.set(集計時間帯.getIndex(), 投票数.get(集計時間帯.getIndex()).add(Decimal.ONE));
                    if (TohyoJokyo.受理.getCode().equals(投票状況Code.getColumnValue())) {
                        不在者数.set(集計時間帯.getIndex(), 不在者数.get(集計時間帯.getIndex()).add(Decimal.ONE));
                    }

                }
            } else {
                その他投票数 = その他投票数.add(Decimal.ONE);
            }

        }

    }

    private void setSum(List<Decimal> 合計投票数,
            List<Decimal> 合計不在者数,
            Decimal 合計投票数計,
            Decimal 合計不在者数計,
            Decimal 合計その他投票数,
            Decimal 合計投票者数合計,
            List<Decimal> 時間別投票率,
            List<Decimal> 投票人数_１時間あたり,
            Decimal 投票人数計_１時間あたり) {

        this.is合計 = true;
        this.合計投票数 = 合計投票数;
        this.合計不在者数 = 合計不在者数;
        this.合計投票数計 = 合計投票数計;
        this.合計不在者数計 = 合計不在者数計;
        this.合計その他投票数 = 合計その他投票数;
        this.合計投票者数合計 = 合計投票者数合計;
        this.時間別投票率 = 時間別投票率;
        this.投票人数_１時間あたり = 投票人数_１時間あたり;
        this.投票人数計_１時間あたり = 投票人数計_１時間あたり;
    }

    /**
     * 帳票AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計のパラメータbuilderクラスです。
     *
     */
    public static class JikanbetsuJokyoGokeiParamBuilder {

        private static final int ONE_HUNDRED = 100;
        private static final int ONE_PAGE_COUNT = 25;

        private final FlexibleDate 帳票作成日;
        private final Jikantai 時間帯;
        private final TeijiCommonJohoItem 選挙帳票共通情報;

        private FlexibleDate 投票受付開始年月日;
        private List<JikanbetsuJokyoGokeiParam> 投票データ;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 TeijiCommonJohoItem
         * @param 帳票作成日 FlexibleDate
         */
        public JikanbetsuJokyoGokeiParamBuilder(TeijiCommonJohoItem 選挙帳票共通情報, FlexibleDate 帳票作成日) {

            this.選挙帳票共通情報 = 選挙帳票共通情報;
            this.帳票作成日 = 帳票作成日;

            時間帯 = new Jikantai();
            投票データ = null;
        }

        /**
         * 検索データを追加します。
         *
         * @param 抄本 AfT100ShohonEntity
         * @param 選挙 AfT111SenkyoEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         */
        public void addData(AfT100ShohonEntity 抄本, AfT111SenkyoEntity 選挙, AfT201TohyoJokyoEntity 投票状況) {

            if (投票データ == null) {
                initList(抄本, 選挙);
            }
            FlexibleDate 受理年月日 = 投票状況.getJuriYMD();
            if (投票受付開始年月日 == null || 受理年月日 == null) {
                return;
            }
            int index = 受理年月日.getBetweenDays(投票受付開始年月日);
            if (index < 0 || index >= 投票データ.size()) {
                return;
            }
            投票データ.get(index).addCount(時間帯, 投票状況);

        }

        /**
         * 合計の処理です。
         *
         * @return List<JikanbetsuJokyoGokeiParam>
         */
        public List<JikanbetsuJokyoGokeiParam> sum() {
            if (投票データ == null) {
                return new ArrayList<>();
            }
            List<Decimal> 合計投票数 = initDecimalList();
            List<Decimal> 合計不在者数 = initDecimalList();
            Decimal 合計投票数計 = Decimal.ZERO;
            Decimal 合計不在者数計 = Decimal.ZERO;
            Decimal 合計その他投票数 = Decimal.ZERO;
            Decimal 合計投票者数合計 = Decimal.ZERO;
            for (JikanbetsuJokyoGokeiParam param : 投票データ) {

                for (int i = 0; i < 合計投票数.size(); i++) {
                    合計投票数.set(i, 合計投票数.get(i).add(param.投票数.get(i)));
                    合計不在者数.set(i, 合計不在者数.get(i).add(param.不在者数.get(i)));
                }

                合計投票数計 = 合計投票数計.add(param.投票数計);
                合計不在者数計 = 合計不在者数計.add(param.不在者数計);
                合計その他投票数 = 合計その他投票数.add(param.その他投票数);
                合計投票者数合計 = 合計投票者数合計.add(param.投票者数合計);
            }

            if (!投票データ.isEmpty()) {
                JikanbetsuJokyoGokeiParam lastParam = 投票データ.get((投票データ.size() - 1) / ONE_PAGE_COUNT * ONE_PAGE_COUNT);
                List<Decimal> 時間別投票率 = new ArrayList<>();
                List<Decimal> 投票人数_１時間あたり = new ArrayList<>();
                for (int i = 0; i < 合計投票数.size(); i++) {

                    if (合計投票数計.equals(Decimal.ZERO)) {
                        時間別投票率.add(Decimal.ZERO);
                    } else {
                        時間別投票率.add(合計投票数.get(i).divide(合計投票数計).multiply(ONE_HUNDRED).roundHalfUpTo(2));
                    }
                    投票人数_１時間あたり.add(合計投票数.get(i).divide(時間帯.get時間帯の時間差(i)).divide(投票データ.size())
                            .roundHalfUpTo(0));
                }
                Decimal 投票人数計_１時間あたり = 合計投票数計.divide(時間帯.get時間帯の時間差合計()).divide(投票データ.size()).roundHalfUpTo(0);

                lastParam.setSum(合計投票数,
                        合計不在者数,
                        合計投票数計,
                        合計不在者数計,
                        合計その他投票数,
                        合計投票者数合計,
                        時間別投票率,
                        投票人数_１時間あたり,
                        投票人数計_１時間あたり);
            }
            List<JikanbetsuJokyoGokeiParam> rslt = 投票データ;
            投票データ = null;
            return rslt;
        }

        private void initList(AfT100ShohonEntity 抄本, AfT111SenkyoEntity 選挙) {
            投票受付開始年月日 = 選挙.getTohyoUketsukeYMD();
            FlexibleDate 投票年月日 = 抄本.getTohyoYMD();

            投票データ = new ArrayList<>();
            if (投票受付開始年月日 == null || 投票年月日 == null) {
                return;
            }

            for (int i = 0; i < 投票年月日.getBetweenDays(投票受付開始年月日) && i < 帳票作成日.getBetweenDays(投票受付開始年月日) + 1; i++) {
                投票データ.add(new JikanbetsuJokyoGokeiParam(投票受付開始年月日.plusDay(i),
                        選挙.getSenkyoNo(),
                        選挙.getSenkyoName(),
                        選挙帳票共通情報,
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯１),
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯２),
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯３),
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯４)));
            }

        }

    }

}
