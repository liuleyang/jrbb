package jp.co.ndensan.reams.af.afa.business.report.AFAPRE511;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表のパラメータクラスです。
 *
 * @reamsid_L AF-0280-028 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class DairiTohyoShukeihyoParam {

    private static final RString 合計の投票区 = new RString("　＊＊＊　合　　　　　計　＊＊＊");

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

    private final ZenjitsuCommonJohoItem 選挙帳票共通情報;

    private final RString サブタイトル;
    private final RString タイトル_対象期間;
    private final RString 対象期間;
    private final RString 投票種類;
    private final RString 洋上投票タイトル上;
    private final RString 洋上投票タイトル下;

    private final RString 選挙名称;

    private int ページ;

    private final Code senkyoShurui;
    private final RString tohyokuCode;

    private final RString 投票区;

    private final List<Decimal> 投票者数;
    private final List<Decimal> 代理投票者数;
    private Decimal 点字投票者数;
    private Decimal 洋上投票者数;

    private DairiTohyoShukeihyoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            RString サブタイトル,
            RString タイトル_対象期間,
            RString 対象期間,
            RString 投票種類,
            RString 洋上投票タイトル上,
            RString 洋上投票タイトル下,
            RString 選挙名称,
            RString 投票区,
            Code senkyoShurui,
            RString tohyokuCode) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.サブタイトル = サブタイトル;
        this.タイトル_対象期間 = タイトル_対象期間;
        this.対象期間 = 対象期間;
        this.投票種類 = 投票種類;
        this.洋上投票タイトル上 = 洋上投票タイトル上;
        this.洋上投票タイトル下 = 洋上投票タイトル下;
        this.選挙名称 = 選挙名称;
        this.投票区 = 投票区;
        this.senkyoShurui = senkyoShurui;
        this.tohyokuCode = tohyokuCode;

        投票者数 = initDecimalList();
        代理投票者数 = initDecimalList();
        点字投票者数 = Decimal.ZERO;
        洋上投票者数 = Decimal.ZERO;
    }

    private DairiTohyoShukeihyoParam(DairiTohyoShukeihyoParam other) {
        this.選挙帳票共通情報 = other.選挙帳票共通情報;
        this.サブタイトル = other.サブタイトル;
        this.タイトル_対象期間 = other.タイトル_対象期間;
        this.対象期間 = other.対象期間;
        this.投票種類 = other.投票種類;
        this.洋上投票タイトル上 = other.洋上投票タイトル上;
        this.洋上投票タイトル下 = other.洋上投票タイトル下;
        this.選挙名称 = other.選挙名称;
        this.投票区 = 合計の投票区;
        this.senkyoShurui = Code.EMPTY;
        this.tohyokuCode = RString.EMPTY;

        投票者数 = initDecimalList();
        代理投票者数 = initDecimalList();
        点字投票者数 = Decimal.ZERO;
        洋上投票者数 = Decimal.ZERO;
    }

    private static List<Decimal> initDecimalList() {
        List<Decimal> rslt = new ArrayList<>();
        rslt.add(Decimal.ZERO);
        rslt.add(Decimal.ZERO);
        rslt.add(Decimal.ZERO);
        return rslt;
    }

    private void addCount(AfT201TohyoJokyoEntity 投票状況, TohyoJokyo 画面選択の投票状況, Gender 性別) {
        Code 投票状況Code = 投票状況.getTohyoJokyo();
        //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 13 LINES
        if (投票状況Code != null && 画面選択の投票状況.getCode().equals(投票状況Code.getColumnValue())) {
            addCount(投票者数, 性別);
            if (投票状況.getDairiTohyoAriFlag()) {
                addCount(代理投票者数, 性別);
            }
            if (投票状況.getTenjiFlag()) {
                点字投票者数 = 点字投票者数.add(Decimal.ONE);
            }
            Code 施設種別 = 投票状況.getJuriShisetsuShubetsu();
            if (施設種別 != null && ShisetsuShubetsu.船舶.getCode().equals(施設種別.getColumnValue())) {
                洋上投票者数 = 洋上投票者数.add(Decimal.ONE);
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
     * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表のパラメータbuilderクラスです。
     *
     */
    public static class DairiTohyoShukeihyoParamBuilder {

        private static final int ONE_PAGE_COUNT = 30;

        private static final RString サブタイトル_期日前 = new RString("（期日前投票分）");
        private static final RString サブタイトル_不在者 = new RString("（不在者投票分）");

        private static final RString 投票種類_期日前 = new RString("期　　日　　前");
        private static final RString 投票種類_不在者 = new RString("不　　在　　者");

        private static final RString タイトル_対象期間 = new RString("抽出受理日");
        private static final RString 対象期間_SEPARATOR = new RString("～");

        private static final RString 洋上投票タイトル_上 = new RString("洋　　上");
        private static final RString 洋上投票タイトル_下 = new RString("投票者数");

        private final TohyoJokyo 画面選択の投票状況;

        private final ZenjitsuCommonJohoItem 選挙帳票共通情報;

        private final RString サブタイトル;
        private final RString タイトル対象期間;
        private final RString 対象期間;
        private final RString 投票種類;
        private final RString 洋上投票タイトル上;
        private final RString 洋上投票タイトル下;

        private int pageCount;

        private List<DairiTohyoShukeihyoParam> paramList;

        /**
         * コンストラクタです。
         *
         * @param 画面選択の投票状況 TohyoJokyo
         * @param 選挙帳票共通情報 ZenjitsuCommonJohoItem
         * @param 代理投票集計表受理日from FlexibleDate
         * @param 代理投票集計表受理日to FlexibleDate
         */
        public DairiTohyoShukeihyoParamBuilder(TohyoJokyo 画面選択の投票状況,
                ZenjitsuCommonJohoItem 選挙帳票共通情報,
                FlexibleDate 代理投票集計表受理日from,
                FlexibleDate 代理投票集計表受理日to) {
            this.画面選択の投票状況 = 画面選択の投票状況;
            this.選挙帳票共通情報 = 選挙帳票共通情報;
            switch (画面選択の投票状況) {
                case 期日前:
                    this.サブタイトル = サブタイトル_期日前;
                    this.投票種類 = 投票種類_期日前;
                    this.洋上投票タイトル上 = RString.EMPTY;
                    this.洋上投票タイトル下 = RString.EMPTY;
                    break;
                case 受理:
                    this.サブタイトル = サブタイトル_不在者;
                    this.投票種類 = 投票種類_不在者;
                    this.洋上投票タイトル上 = 洋上投票タイトル_上;
                    this.洋上投票タイトル下 = 洋上投票タイトル_下;
                    break;
                default:
                    this.サブタイトル = RString.EMPTY;
                    this.投票種類 = RString.EMPTY;
                    this.洋上投票タイトル上 = RString.EMPTY;
                    this.洋上投票タイトル下 = RString.EMPTY;
            }
            if (代理投票集計表受理日from != null && !代理投票集計表受理日from.isEmpty()
                    && 代理投票集計表受理日to != null && !代理投票集計表受理日to.isEmpty()) {

                this.タイトル対象期間 = タイトル_対象期間;
                this.対象期間 = パターン12(代理投票集計表受理日from).concat(対象期間_SEPARATOR).concat(パターン12(代理投票集計表受理日to));
            } else {

                this.タイトル対象期間 = RString.EMPTY;
                this.対象期間 = RString.EMPTY;
            }

            paramList = new ArrayList<>();
            pageCount = 0;

        }

        /**
         * 検索データを追加します。
         *
         * @param 抄本 AfT100ShohonEntity
         * @param 選挙 AfT111SenkyoEntity
         * @param 選挙人名簿 AfT112SenkyoninMeiboEntity
         * @param 投票区 AfT501Tohyoku
         * @param 投票区Ur UrT0159TohyokuEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         * @param 性別 Gender
         */
        public void addData(AfT100ShohonEntity 抄本,
                AfT111SenkyoEntity 選挙,
                AfT112SenkyoninMeiboEntity 選挙人名簿,
                AfT501TohyokuEntity 投票区,
                UrT0159TohyokuEntity 投票区Ur,
                AfT201TohyoJokyoEntity 投票状況,
                Gender 性別) {

            DairiTohyoShukeihyoParam param;
            DairiTohyoShukeihyoParam lastParam = paramList.isEmpty() ? null : paramList.get(paramList.size() - 1);
            if (lastParam == null
                    || !(lastParam.senkyoShurui.equals(抄本.getSenkyoShurui()) && lastParam.tohyokuCode.equals(選挙人名簿.getTohyokuCode()))) {
                param = new DairiTohyoShukeihyoParam(選挙帳票共通情報,
                        サブタイトル,
                        タイトル対象期間,
                        対象期間,
                        投票種類,
                        洋上投票タイトル上,
                        洋上投票タイトル下,
                        選挙.getSenkyoName(),
                        edit投票区(抄本, 投票区, 投票区Ur),
                        抄本.getSenkyoShurui(),
                        選挙人名簿.getTohyokuCode());
                paramList.add(param);
            } else {
                param = paramList.get(paramList.size() - 1);
            }
            param.addCount(投票状況, 画面選択の投票状況, 性別);
        }

        private RString edit投票区(AfT100ShohonEntity 抄本, AfT501TohyokuEntity 投票区, UrT0159TohyokuEntity 投票区Ur) {

            Code 選挙種類 = 抄本.getSenkyoShurui();
            RString 投票区名 = RString.EMPTY;
            if (null != 選挙種類 && SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類.value())) {
                if (null != 投票区Ur) {
                    投票区名 = 投票区Ur.getTohyokuCode().getColumnValue().concat(RString.FULL_SPACE).concat(投票区Ur.getName());
                }
            } else {
                if (null != 投票区) {
                    投票区名 = 投票区.getTohyokuCode().concat(RString.FULL_SPACE).concat(投票区.getTohyokuName());
                }
            }

            return 投票区名;
        }

        /**
         * 合計の処理です。
         *
         * @return List<DairiTohyoShukeihyoParam>
         */
        public List<DairiTohyoShukeihyoParam> 合計() {

            if (this.paramList.isEmpty()) {
                return new ArrayList<>();
            }
            List<DairiTohyoShukeihyoParam> rslt = this.paramList;
            this.paramList = new ArrayList<>();

            DairiTohyoShukeihyoParam sum = new DairiTohyoShukeihyoParam(rslt.get(0));

            int i = 0;
            for (; i < rslt.size(); i++) {
                DairiTohyoShukeihyoParam param = rslt.get(i);
                param.ページ = pageCount + i / ONE_PAGE_COUNT + 1;
                addDecimalList(sum.投票者数, param.投票者数);
                addDecimalList(sum.代理投票者数, param.代理投票者数);
                sum.点字投票者数 = sum.点字投票者数.add(param.点字投票者数);
                sum.洋上投票者数 = sum.洋上投票者数.add(param.洋上投票者数);
            }
            sum.ページ = pageCount + i / ONE_PAGE_COUNT + 1;
            pageCount = sum.ページ;
            rslt.add(sum);

            return rslt;

        }

        private void addDecimalList(List<Decimal> rslt, List<Decimal> trgt) {
            for (int i = 0; i < rslt.size(); i++) {
                rslt.set(i, rslt.get(i).add(trgt.get(i)));
            }
        }

        private RString パターン12(FlexibleDate date) {
            if (date == null || date.isEmpty()) {
                return RString.EMPTY;
            }
            return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                    .toDateString();
        }

    }
}
