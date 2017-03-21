package jp.co.ndensan.reams.af.afa.business.report.AFAPRE512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE512_NendaibetsuJokyoShirabe_年代別投票状況調べのパラメータクラスです。
 *
 * @reamsid_L AF-0280-029 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NendaibetsuJokyoShirabeParam {

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

    private static final int ONE_HUNDRED = 100;

    private final ZenjitsuCommonJohoItem 選挙帳票共通情報;

    private final RString タイトル;
    private final RString 選挙名称;
    private final RString 投票区コード;
    private final FlexibleDate 投票日;

    private final RString 年齢年代ラベル;

    private final List<Decimal> 有権者;
    private final List<Decimal> 投票者;
    private final List<Decimal> 投票率;

    private NendaibetsuJokyoShirabeParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            RString タイトル,
            RString 選挙名称,
            RString 投票区コード,
            FlexibleDate 投票日,
            RString 年齢年代ラベル) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.タイトル = タイトル;
        this.選挙名称 = 選挙名称;
        this.投票区コード = 投票区コード;
        this.投票日 = 投票日;
        this.年齢年代ラベル = 年齢年代ラベル;
        this.有権者 = initDecimalList();
        this.投票者 = initDecimalList();
        this.投票率 = initDecimalList();
    }

    private static List<Decimal> initDecimalList() {
        List<Decimal> rslt = new ArrayList<>();
        rslt.add(Decimal.ZERO);
        rslt.add(Decimal.ZERO);
        rslt.add(Decimal.ZERO);
        return rslt;
    }

    /**
     * 検索データを追加します。
     *
     * @param 投票状況 AfT201TohyoJokyoEntity
     * @param is有権者 boolean
     * @param 性別 Gender
     * @param is投票者 boolean
     *
     */
    protected void addCount(AfT201TohyoJokyoEntity 投票状況, boolean is有権者, Gender 性別, boolean is投票者) {
        Code 投票状況Code = 投票状況.getTohyoJokyo();
        if (投票状況Code != null && !TohyoJokyo.取消.getCode().equals(投票状況Code.getColumnValue())) {
            if (is有権者) {
                addCount(有権者, 性別);
            }
            if (is投票者
                    && Arrays.asList(TohyoJokyo.受理.getCode(),
                            TohyoJokyo.期日前.getCode(),
                            TohyoJokyo.当日.getCode()).contains(投票状況Code.getColumnValue())) {
                addCount(投票者, 性別);
            }
        }
    }

    /**
     * 検索データを追加します。
     *
     * @param other NendaibetsuJokyoShirabeParam
     *
     */
    protected void addCount(NendaibetsuJokyoShirabeParam other) {
        for (int i = 0; i < 投票率.size(); i++) {
            有権者.set(i, 有権者.get(i).add(other.有権者.get(i)));
            投票者.set(i, 投票者.get(i).add(other.投票者.get(i)));
        }
    }

    private void 計算投票率() {
        for (int i = 0; i < 投票率.size(); i++) {
            if (!有権者.get(i).equals(Decimal.ZERO)) {
                投票率.set(i, 投票者.get(i).divide(有権者.get(i)).multiply(ONE_HUNDRED).roundHalfUpTo(2));
            }
        }
    }

    private void addCount(List<Decimal> 投票者数, Gender 性別) {
        switch (性別) {
            case MALE:
                投票者数.set(男, 投票者数.get(男).add(Decimal.ONE));
                break;
            case FEMALE:
                投票者数.set(女, 投票者数.get(女).add(Decimal.ONE));
                break;
            default:
        }
        投票者数.set(計, 投票者数.get(計).add(Decimal.ONE));

    }

    /**
     * 帳票AFAPRE512_NendaibetsuJokyoShirabe_年代別投票状況調べのパラメータbuilderクラスです。
     *
     */
    public static class NendaibetsuJokyoShirabeParamBuilder {

        private static final List<RString> タイトル_リスト = Arrays.asList(
                new RString("年代別投票状況調（不在者投票）"),
                new RString("年代別投票状況調（期日前投票）"),
                new RString("年代別投票状況調（不在者・期日前投票）")
        );

        private static final int 不在者投票 = 0;
        private static final int 期日前投票 = 1;
        private static final int 不在者_期日前投票 = 2;

        private static final List<RString> 年齢年代ラベル_リスト = Arrays.asList(
                new RString("１８歳"),
                new RString("１９歳"),
                new RString("１０代合計"),
                new RString("２０歳"),
                new RString("２１～２４"),
                new RString("２５～２９"),
                new RString("２０代計"),
                new RString("３０～３４"),
                new RString("３５～３９"),
                new RString("３０代計"),
                new RString("４０～４４"),
                new RString("４５～４９"),
                new RString("４０代計"),
                new RString("５０～５４"),
                new RString("５５～５９"),
                new RString("５０代計"),
                new RString("６０～６４"),
                new RString("６５～６９"),
                new RString("６０代計"),
                new RString("７０～７４"),
                new RString("７５～７９"),
                new RString("７０代計"),
                new RString("８０～８４"),
                new RString("８５～８９"),
                new RString("８０代計"),
                new RString("９０代以上"),
                new RString("合計")
        );

        private static enum 年齢 {

            歳１８(18, 18, 0),
            歳１９(19, 19, 1),
            計１０代(18, 19, 2),
            歳２０(20, 20, 3),
            歳２１_２４(21, 24, 4),
            歳２５_２９(25, 29, 5),
            計２０代(20, 29, 6),
            歳３０_３４(30, 34, 7),
            歳３５_３９(35, 39, 8),
            計３０代(30, 39, 9),
            歳４０_４４(40, 44, 10),
            歳４５_４９(45, 49, 11),
            計４０代(40, 49, 12),
            歳５０_５４(50, 54, 13),
            歳５５_５９(55, 59, 14),
            計５０代(50, 59, 15),
            歳６０_６４(60, 64, 16),
            歳６５_６９(65, 69, 17),
            計６０代(60, 69, 18),
            歳７０_７４(70, 74, 19),
            歳７５_７９(75, 79, 20),
            計７０代(70, 79, 21),
            歳８０_８４(80, 84, 22),
            歳８５_８９(85, 89, 23),
            計８０代(80, 89, 24),
            計９０代以上(90, null, 25),
            合計(null, null, 26);
            private final Integer before;
            private final Integer after;
            private final int index;

            private 年齢(Integer before, Integer after, int index) {
                this.before = before;
                this.after = after;
                this.index = index;
            }

            private static List<Integer> getIndex(int 歳) {
                List<Integer> indexList = new ArrayList<>();
                for (年齢 trgt : 年齢.values()) {
                    if ((trgt.before == null || trgt.before <= 歳)
                            && (trgt.after == null || trgt.after >= 歳)) {
                        indexList.add(trgt.index);
                    }

                }
                return indexList;

            }

        }

        private static final RString 合計頁_投票区コード = new RString("全");

        private final ZenjitsuCommonJohoItem 選挙帳票共通情報;

        private List<List<NendaibetsuJokyoShirabeParam>> currentPage;
        private List<List<NendaibetsuJokyoShirabeParam>> sumPage;

        private SenkyoNo 選挙番号;
        private RString 投票区コード;
        private FlexibleDate 投票日;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 ZenjitsuCommonJohoItem
         */
        public NendaibetsuJokyoShirabeParamBuilder(ZenjitsuCommonJohoItem 選挙帳票共通情報) {
            this.選挙帳票共通情報 = 選挙帳票共通情報;
            選挙番号 = null;
            投票区コード = null;
            投票日 = null;

        }

        /**
         * 検索データを追加します。
         *
         * @param 抄本 AfT100ShohonEntity
         * @param 選挙 AfT111SenkyoEntity
         * @param 選挙人名簿 AfT112SenkyoninMeiboEntity
         * @param 選挙資格 AfT113SenkyoShikaku
         * @param 投票状況 AfT201TohyoJokyoEntity
         * @param 宛名PSM UaFt200FindShikibetsuTaishoEntity
         *
         * @return List<NendaibetsuJokyoShirabeParam>
         */
        public List<NendaibetsuJokyoShirabeParam> add(AfT100ShohonEntity 抄本,
                AfT111SenkyoEntity 選挙,
                AfT112SenkyoninMeiboEntity 選挙人名簿,
                AfT113SenkyoShikakuEntity 選挙資格,
                AfT201TohyoJokyoEntity 投票状況,
                UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
            List<NendaibetsuJokyoShirabeParam> rslt = new ArrayList<>();
            if (選挙番号 == null || 投票区コード == null) {
                選挙番号 = 選挙.getSenkyoNo();
                投票区コード = 選挙人名簿.getTohyokuCode();
                投票日 = 抄本.getTohyoYMD();
                currentPage = initPage(選挙.getSenkyoName(), 投票日, 投票区コード);
                sumPage = initPage(選挙.getSenkyoName(), 投票日, 合計頁_投票区コード);
            }
            if (!選挙番号.equals(選挙.getSenkyoNo())) {
                sumPages(currentPage, sumPage);
                sumPages(sumPage, null);

                for (List<NendaibetsuJokyoShirabeParam> params : currentPage) {
                    rslt.addAll(params);
                }
                for (List<NendaibetsuJokyoShirabeParam> params : sumPage) {
                    rslt.addAll(params);
                }
                選挙番号 = 選挙.getSenkyoNo();
                投票区コード = 選挙人名簿.getTohyokuCode();
                投票日 = 抄本.getTohyoYMD();
                currentPage = initPage(選挙.getSenkyoName(), 投票日, 投票区コード);
                sumPage = initPage(選挙.getSenkyoName(), 投票日, 合計頁_投票区コード);
            } else if (!投票区コード.equals(選挙人名簿.getTohyokuCode())) {
                sumPages(currentPage, sumPage);
                for (List<NendaibetsuJokyoShirabeParam> params : currentPage) {
                    rslt.addAll(params);
                }
                投票区コード = 選挙人名簿.getTohyokuCode();
                投票日 = 抄本.getTohyoYMD();
                currentPage = initPage(選挙.getSenkyoName(), 投票日, 投票区コード);
            }
            add(選挙資格, 投票状況, 宛名PSM);
            return rslt;
        }

        /**
         * 最後のパラメータを作成します。
         *
         * @return List<NendaibetsuJokyoShirabeParam>
         */
        public List<NendaibetsuJokyoShirabeParam> getLastParam() {
            List<NendaibetsuJokyoShirabeParam> rslt = new ArrayList<>();
            if (currentPage == null) {
                return rslt;
            }
            sumPages(currentPage, sumPage);
            sumPages(sumPage, null);

            for (List<NendaibetsuJokyoShirabeParam> params : currentPage) {
                rslt.addAll(params);
            }
            for (List<NendaibetsuJokyoShirabeParam> params : sumPage) {
                rslt.addAll(params);
            }
            return rslt;
        }

        private void add(AfT113SenkyoShikakuEntity 選挙資格,
                AfT201TohyoJokyoEntity 投票状況,
                UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名PSM);
            if (宛名.canBe個人()) {
                IKojin 個人 = 宛名.to個人();
                FlexibleDate 生年月日 = 個人.get生年月日().toFlexibleDate();
                Gender 性別 = 個人.get性別();
                if (生年月日 != null && 性別 != null) {
                    int 歳 = 投票日.plusDay(1).getBetweenYears(生年月日);
                    //  選挙の投票日時点で、選挙資格TBL.選挙資格区分＝有権者or表示者の合計
                    // 選挙資格TBL.選挙資格区分＝抹消者or公民権停止者 and 投票状況TBL.投票状況 = 期日前の合計

                    投票状況 = 投票状況 == null ? new AfT201TohyoJokyoEntity() : 投票状況;
                    Code 選挙資格区分 = 選挙資格.getShikakuKubun();
                    RString 選挙資格区分Str = 選挙資格区分 == null ? RString.EMPTY : 選挙資格区分.getColumnValue();
                    Code 投票状況Code = 投票状況.getTohyoJokyo();
                    RString 投票状況Str = 投票状況Code == null ? RString.EMPTY : 投票状況Code.getColumnValue();
                    boolean is有権者 = Arrays.asList(SennkyoSikakuKubun.有権者.value(), SennkyoSikakuKubun.表示者.value()).contains(選挙資格区分Str)
                            || (Arrays.asList(SennkyoSikakuKubun.抹消者.value(), SennkyoSikakuKubun.公民権停止.value()).contains(選挙資格区分Str)
                            && TohyoJokyo.期日前.getCode().equals(投票状況Str));

                    List<Integer> indexList = 年齢.getIndex(歳);
                    //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 13 LINES
                    if (投票状況Code != null && indexList.size() > 1) {
                        boolean is不在者 = TohyoJokyo.受理.getCode().equals(投票状況Str);
                        boolean is期日前 = TohyoJokyo.期日前.getCode().equals(投票状況Str);
                        for (Integer index : indexList) {
                            currentPage.get(不在者投票).get(index).addCount(投票状況, is有権者, 性別, is不在者);
                            currentPage.get(期日前投票).get(index).addCount(投票状況, is有権者, 性別, is期日前);
                            currentPage.get(不在者_期日前投票).get(index).addCount(投票状況, is有権者, 性別, is不在者 || is期日前);
                        }
                    }
                }
            }

        }

        private List<List<NendaibetsuJokyoShirabeParam>> initPage(RString 選挙名称, FlexibleDate 投票日, RString 投票区コード) {
            List<List<NendaibetsuJokyoShirabeParam>> page = new ArrayList<>();
            for (RString タイトル : タイトル_リスト) {
                List<NendaibetsuJokyoShirabeParam> paramList = new ArrayList<>();
                page.add(paramList);
                for (RString 年齢年代ラベル : 年齢年代ラベル_リスト) {
                    paramList.add(new NendaibetsuJokyoShirabeParam(選挙帳票共通情報, タイトル, 選挙名称, 投票区コード, 投票日, 年齢年代ラベル));
                }
            }
            return page;
        }

        private void sumPages(List<List<NendaibetsuJokyoShirabeParam>> trgtPage, List<List<NendaibetsuJokyoShirabeParam>> sumPage) {

            for (int i = 0; i < trgtPage.size(); i++) {
                for (int j = 0; j < trgtPage.get(i).size(); j++) {
                    NendaibetsuJokyoShirabeParam trgt = trgtPage.get(i).get(j);
                    trgt.計算投票率();
                    if (sumPage != null) {
                        sumPage.get(i).get(j).addCount(trgt);
                    }
                }
            }
        }
    }
}
