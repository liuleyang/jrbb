package jp.co.ndensan.reams.af.afa.business.report.AFAPRE514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.Jikantai;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE514_JikanbetsuJokyoTohyojo_時間別投票状況表　投票所別のパラメータクラスです。
 *
 * @reamsid_L AF-0280-031 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JikanbetsuJokyoTohyojoParam {

    /**
     * 男
     */
    public static final int 男;
    /**
     * 女
     */
    public static final int 女;
    /**
     * 計
     */
    public static final int 計;

    static {
        男 = 0;
        女 = 1;
        計 = 2;
    }

    private final TeijiCommonJohoItem 選挙帳票共通情報;
    private final RString 時間帯１;
    private final RString 時間帯２;
    private final RString 時間帯３;
    private final RString 時間帯４;

    private final SenkyoNo 選挙番号;
    private final RString 選挙名称;
    private final RString 施設コード;
    private final RString 施設名称;

    private final FlexibleDate 日付;

    private final List<List<Decimal>> 時間帯投票数;
    private final List<Decimal> 合計投票数;

    private boolean is合計;

    private List<List<Decimal>> 合計時間帯投票数;
    private List<Decimal> 合計合計投票数;

    private List<List<Decimal>> 時間別投票率;
    private List<Decimal> 合計時間別投票率;

    private List<List<Decimal>> 投票人数_１時間あたり;
    private List<Decimal> 投票人数計_１時間あたり;

    private JikanbetsuJokyoTohyojoParam(TeijiCommonJohoItem 選挙帳票共通情報,
            RString 時間帯１,
            RString 時間帯２,
            RString 時間帯３,
            RString 時間帯４,
            SenkyoNo 選挙番号,
            RString 選挙名称,
            RString 施設コード,
            RString 施設名称,
            FlexibleDate 日付) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.時間帯１ = 時間帯１;
        this.時間帯２ = 時間帯２;
        this.時間帯３ = 時間帯３;
        this.時間帯４ = 時間帯４;
        this.選挙番号 = 選挙番号;
        this.選挙名称 = 選挙名称;
        this.施設コード = 施設コード;
        this.施設名称 = 施設名称;
        this.日付 = 日付;

        this.時間帯投票数 = Arrays.asList(initDecimalList(),
                initDecimalList(),
                initDecimalList(),
                initDecimalList());
        this.合計投票数 = initDecimalList();

        is合計 = false;
    }

    private static List<Decimal> initDecimalList() {
        List<Decimal> rslt = new ArrayList<>();
        rslt.add(Decimal.ZERO);
        rslt.add(Decimal.ZERO);
        rslt.add(Decimal.ZERO);
        return rslt;
    }

    private void addCount(Jikantai 時間帯, AfT201TohyoJokyoEntity 投票状況, Gender 性別) {
        // 期日前投票者（投票資格の情報.投票状況.投票状況＝"6"：期日前）のみが対象
        Code 投票状況Code = 投票状況.getTohyoJokyo();

        if (投票状況Code != null && TohyoJokyo.期日前.getCode().equals(投票状況Code.getColumnValue())) {
            addCount(合計投票数, 性別);
            Jikantai.JikantaiType 集計時間帯 = 時間帯.get時間帯Index(投票状況.getJuriTime());
            if (集計時間帯 != null) {
                addCount(時間帯投票数.get(集計時間帯.getIndex()), 性別);
            }
        }
    }

    private void addCount(List<Decimal> 時間帯, Gender 性別) {
        switch (性別) {
            case MALE:
                時間帯.set(男, 時間帯.get(男).add(Decimal.ONE));
                break;
            case FEMALE:
                時間帯.set(女, 時間帯.get(女).add(Decimal.ONE));
                break;
            default:
        }
        時間帯.set(計, 時間帯.get(計).add(Decimal.ONE));
    }

    private void setSum(List<List<Decimal>> 合計時間帯投票数,
            List<Decimal> 合計合計投票数,
            List<List<Decimal>> 時間別投票率,
            List<Decimal> 合計時間別投票率,
            List<List<Decimal>> 投票人数_１時間あたり,
            List<Decimal> 投票人数計_１時間あたり) {
        this.is合計 = true;

        this.合計時間帯投票数 = 合計時間帯投票数;
        this.合計合計投票数 = 合計合計投票数;
        this.時間別投票率 = 時間別投票率;
        this.合計時間別投票率 = 合計時間別投票率;
        this.投票人数_１時間あたり = 投票人数_１時間あたり;
        this.投票人数計_１時間あたり = 投票人数計_１時間あたり;
    }

    /**
     * 帳票AFAPRE514_JikanbetsuJokyoTohyojo_時間別投票状況表　投票所別のパラメータbuilderクラスです。
     *
     */
    public static class JikanbetsuJokyoTohyojoParamBuilder {

        private static final int ONE_HUNDRED = 100;
        private static final int ONE_PAGE_COUNT = 25;
        private static final RString 施設名称_全施設合計 = new RString("全施設合計");

        private final FlexibleDate 帳票作成日;
        private final Jikantai 時間帯;
        private final TeijiCommonJohoItem 選挙帳票共通情報;

        private FlexibleDate 投票受付開始年月日;
        private List<JikanbetsuJokyoTohyojoParam> 投票データ;

        private List<JikanbetsuJokyoTohyojoParam> 全施設合計投票データ;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 TeijiCommonJohoItem
         * @param 帳票作成日 FlexibleDate
         */
        public JikanbetsuJokyoTohyojoParamBuilder(TeijiCommonJohoItem 選挙帳票共通情報, FlexibleDate 帳票作成日) {

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
         * @param 施設 AfT507ShisetsuEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         * @param 性別 Gender
         */
        public void addData(AfT100ShohonEntity 抄本,
                AfT111SenkyoEntity 選挙,
                AfT507ShisetsuEntity 施設,
                AfT201TohyoJokyoEntity 投票状況,
                Gender 性別) {

            if (投票データ == null) {
                投票データ = initList(抄本, 選挙, 施設);
            }
            if (全施設合計投票データ == null) {
                全施設合計投票データ = initList(抄本, 選挙, null);
            }
            FlexibleDate 受理年月日 = 投票状況.getJuriYMD();
            if (投票受付開始年月日 == null || 受理年月日 == null) {
                return;
            }
            int index = 受理年月日.getBetweenDays(投票受付開始年月日);
            if (index < 0 || index >= 投票データ.size()) {
                return;
            }
            投票データ.get(index).addCount(時間帯, 投票状況, 性別);

        }

        /**
         * 合計の処理です。
         *
         * @return List<JikanbetsuJokyoTohyojoParam>
         */
        public List<JikanbetsuJokyoTohyojoParam> 合計() {
            if (投票データ == null) {
                return new ArrayList<>();
            }
            sum(全施設合計投票データ, 投票データ);
            List<JikanbetsuJokyoTohyojoParam> rslt = sum(投票データ);
            投票データ = null;
            return rslt;

        }

        /**
         * 合計の処理です。
         *
         * @return List<JikanbetsuJokyoTohyojoParam>
         */
        public List<JikanbetsuJokyoTohyojoParam> 全施設合計() {
            if (全施設合計投票データ == null) {
                return new ArrayList<>();
            }
            List<JikanbetsuJokyoTohyojoParam> rslt = sum(全施設合計投票データ);
            全施設合計投票データ = null;
            return rslt;

        }

        private void sum(List<JikanbetsuJokyoTohyojoParam> 全施設合計投票データ, List<JikanbetsuJokyoTohyojoParam> 投票データ) {
            for (int i = 0; i < 全施設合計投票データ.size(); i++) {
                JikanbetsuJokyoTohyojoParam 全施設合計行 = 全施設合計投票データ.get(i);
                JikanbetsuJokyoTohyojoParam 投票データ行 = 投票データ.get(i);

                for (int j = 0; j < 全施設合計行.get時間帯投票数().size(); j++) {
                    addDecimalList(全施設合計行.get時間帯投票数().get(j), 投票データ行.get時間帯投票数().get(j));
                }
                addDecimalList(全施設合計行.get合計投票数(), 投票データ行.get合計投票数());
            }
        }

        private List<JikanbetsuJokyoTohyojoParam> sum(List<JikanbetsuJokyoTohyojoParam> paramList) {

            List<List<Decimal>> 合計時間帯投票数 = Arrays.asList(initDecimalList(),
                    initDecimalList(),
                    initDecimalList(),
                    initDecimalList());
            List<Decimal> 合計合計投票数 = initDecimalList();

            for (JikanbetsuJokyoTohyojoParam param : paramList) {
                for (int i = 0; i < 合計時間帯投票数.size(); i++) {
                    addDecimalList(合計時間帯投票数.get(i), param.時間帯投票数.get(i));

                }
                addDecimalList(合計合計投票数, param.合計投票数);
            }
            if (!paramList.isEmpty()) {
                JikanbetsuJokyoTohyojoParam lastParam = paramList.get((paramList.size() - 1) / ONE_PAGE_COUNT * ONE_PAGE_COUNT);
                Decimal 合計合計投票数計 = 合計合計投票数.get(計);

                List<List<Decimal>> 時間別投票率 = new ArrayList<>();
                List<List<Decimal>> 投票人数_１時間あたり = new ArrayList<>();
                for (int i = 0; i < 合計時間帯投票数.size(); i++) {
                    List<Decimal> 投票率 = new ArrayList<>();
                    List<Decimal> 投票人数リスト_１時間あたり = new ArrayList<>();
                    for (Decimal 投票数 : 合計時間帯投票数.get(i)) {
                        if (合計合計投票数計.equals(Decimal.ZERO)) {
                            投票率.add(Decimal.ZERO);
                        } else {
                            投票率.add(投票数.divide(合計合計投票数計).multiply(ONE_HUNDRED).roundHalfUpTo(2));
                        }
                        投票人数リスト_１時間あたり.add(投票数.divide(時間帯.get時間帯の時間差(i)).divide(paramList.size())
                                .roundHalfUpTo(0));
                    }
                    時間別投票率.add(投票率);
                    投票人数_１時間あたり.add(投票人数リスト_１時間あたり);
                }

                List<Decimal> 合計時間別投票率 = new ArrayList<>();
                List<Decimal> 投票人数計_１時間あたり = new ArrayList<>();
                for (Decimal 投票数 : 合計合計投票数) {
                    if (合計合計投票数計.equals(Decimal.ZERO)) {
                        合計時間別投票率.add(Decimal.ZERO);
                    } else {
                        合計時間別投票率.add(投票数.divide(合計合計投票数計).multiply(ONE_HUNDRED).roundHalfUpTo(2));
                    }
                    投票人数計_１時間あたり.add(投票数.divide(時間帯.get時間帯の時間差合計()).divide(paramList.size())
                            .roundHalfUpTo(0));
                }
                lastParam.setSum(合計時間帯投票数,
                        合計合計投票数,
                        時間別投票率,
                        合計時間別投票率,
                        投票人数_１時間あたり,
                        投票人数計_１時間あたり);

            }

            return paramList;
        }

        private void addDecimalList(List<Decimal> rslt, List<Decimal> trgt) {
            for (int i = 0; i < rslt.size(); i++) {
                rslt.set(i, rslt.get(i).add(trgt.get(i)));
            }
        }

        private List<JikanbetsuJokyoTohyojoParam> initList(AfT100ShohonEntity 抄本, AfT111SenkyoEntity 選挙, AfT507ShisetsuEntity 施設) {
            投票受付開始年月日 = 選挙.getTohyoUketsukeYMD();
            FlexibleDate 投票年月日 = 抄本.getTohyoYMD();

            List<JikanbetsuJokyoTohyojoParam> list = new ArrayList<>();
            if (投票受付開始年月日 == null || 投票年月日 == null) {
                return list;
            }

            for (int i = 0; i < 投票年月日.getBetweenDays(投票受付開始年月日) && i < 帳票作成日.getBetweenDays(投票受付開始年月日) + 1; i++) {
                list.add(new JikanbetsuJokyoTohyojoParam(選挙帳票共通情報,
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯１),
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯２),
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯３),
                        時間帯.get時間帯(Jikantai.JikantaiType.時間帯４),
                        選挙.getSenkyoNo(),
                        選挙.getSenkyoName(),
                        施設 == null ? RString.EMPTY : 施設.getShisetsuCode(),
                        施設 == null ? 施設名称_全施設合計 : 施設.getShisetsuName(),
                        投票受付開始年月日.plusDay(i)));

            }
            return list;

        }

    }
}
