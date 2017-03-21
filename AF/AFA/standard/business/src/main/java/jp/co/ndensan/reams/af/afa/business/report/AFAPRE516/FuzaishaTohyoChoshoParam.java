package jp.co.ndensan.reams.af.afa.business.report.AFAPRE516;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票AFAPRE516_FuzaishaTohyoChosho_不在者投票に関する調書（25号様式）のパラメータクラスです。
 *
 * @reamsid_L AF-0280-033 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class FuzaishaTohyoChoshoParam {

    private static final int 第53条 = 0;
    private static final int 第54条 = 1;
    private static final int 第59条の4 = 2;
    private static final int 第59条の5 = 3;
    private static final int 第59条の6 = 4;

    private static final int 交付 = 0;
    private static final int 投票者男 = 1;
    private static final int 投票者女 = 2;
    private static final int 投票者計 = 3;
    private static final int 代理 = 4;
    private static final int 点字 = 5;

    private static final RString 投票区名_TAIL = new RString("投票区");
    private static final RString 投票区名_SUM = new RString("合　計");

    private final RString 選挙名称;
    private final RString 投票区名;

    private final List<List<Decimal>> 投票者;
    private final List<Decimal> 小計;

    private final RString 調製年月日;
    private final RString 委員会名;
    private final RString 委員長名;

    private final boolean 印字有無フラグ;

    private FuzaishaTohyoChoshoParam(RString 選挙名称,
            UrT0159TohyokuEntity 投票区,
            RString 調製年月日,
            RString 委員会名,
            RString 委員長名,
            boolean 印字有無フラグ) {
        this.選挙名称 = 選挙名称;
        RString 投票区名str = 投票区 == null ? RString.EMPTY : 投票区.getTohyokuCode().value();
        this.投票区名 = (RString.isNullOrEmpty(投票区名str) ? RString.EMPTY : 投票区名str).concat(投票区名_TAIL);
        this.投票者 = initListList();
        this.小計 = initList();
        this.調製年月日 = 調製年月日;
        this.委員会名 = 委員会名;
        this.委員長名 = 委員長名;
        this.印字有無フラグ = 印字有無フラグ;
    }

    private FuzaishaTohyoChoshoParam(RString 選挙名称,
            RString 調製年月日,
            RString 委員会名,
            RString 委員長名,
            boolean 印字有無フラグ) {
        this.選挙名称 = 選挙名称;
        this.投票区名 = 投票区名_SUM;
        this.投票者 = initListList();
        this.小計 = initList();
        this.調製年月日 = 調製年月日;
        this.委員会名 = 委員会名;
        this.委員長名 = 委員長名;
        this.印字有無フラグ = 印字有無フラグ;
    }

    private List<Decimal> initList() {
        List<Decimal> rslt = new ArrayList<>();
        for (int i = 0; i <= 点字; i++) {
            rslt.add(Decimal.ZERO);
        }
        return rslt;
    }

    private List<List<Decimal>> initListList() {
        List<List<Decimal>> rslt = new ArrayList<>();
        for (int i = 0; i <= 第59条の6; i++) {
            rslt.add(initList());
        }
        return rslt;
    }

    private void addCount(AfT201TohyoJokyoEntity 投票状況, AfT507ShisetsuEntity 施設, Gender 性別) {
        // 53条の集計
        RString 投票状況Code = codeToStr(投票状況.getTohyoJokyo());
        RString 施設種別 = 施設 == null ? RString.EMPTY : codeToStr(施設.getShisetsuShubetsu());
        RString 受理施設種別 = codeToStr(投票状況.getJuriShisetsuShubetsu());
        FlexibleDate 交付年月日 = 投票状況.getKofuYMD();

        if (Arrays.asList(TohyoJokyo.交付.getCode(), TohyoJokyo.受理.getCode()).contains(投票状況Code)) {
            // 53条の集計
            if (!Arrays.asList(RString.EMPTY,
                    ShisetsuShubetsu.郵便.getCode(),
                    ShisetsuShubetsu.船舶.getCode(),
                    ShisetsuShubetsu.特定国外派遣組織.getCode()).contains(施設種別)) {
                addCount(投票者.get(第53条), 投票状況, 投票状況Code, 性別, true);
            }
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 9 LINES
            // 54条の集計
            if (TohyoJokyo.受理.getCode().equals(投票状況Code)
                    && ShisetsuShubetsu.船舶.getCode().equals(受理施設種別)) {
                if (交付年月日 == null || 交付年月日.isEmpty()) {
                    addCount(投票者.get(第54条), 投票状況, 投票状況Code, 性別, false);
                } else {
                    addCount(投票者.get(第59条の6), 投票状況, 投票状況Code, 性別, false);
                }
            }
            // 59条の4の集計
            if (ShisetsuShubetsu.郵便.getCode().equals(施設種別)) {
                addCount(投票者.get(第59条の4), 投票状況, 投票状況Code, 性別, true);
            }
            // 59条の5の集計
            if (ShisetsuShubetsu.特定国外派遣組織.getCode().equals(施設種別)) {
                addCount(投票者.get(第59条の5), 投票状況, 投票状況Code, 性別, true);
            }
        }
    }

    private void addCount(List<Decimal> trgt,
            AfT201TohyoJokyoEntity 投票状況,
            RString 投票状況Code,
            Gender 性別,
            boolean has交付) {
        if (has交付) {
            trgt.set(交付, trgt.get(交付).add(Decimal.ONE));
        }
        if (TohyoJokyo.受理.getCode().equals(投票状況Code)) {
            switch (性別) {
                case FEMALE:
                    trgt.set(投票者女, trgt.get(投票者女).add(Decimal.ONE));
                    break;
                case MALE:
                    trgt.set(投票者男, trgt.get(投票者男).add(Decimal.ONE));
                    break;
                default:
            }
            if (投票状況.getDairiTohyoAriFlag()) {
                trgt.set(代理, trgt.get(代理).add(Decimal.ONE));
            }
            if (投票状況.getTenjiFlag()) {
                trgt.set(点字, trgt.get(点字).add(Decimal.ONE));
            }
        }
    }

    private void sum() {
        for (List<Decimal> 投票者List : 投票者) {
            投票者List.set(投票者計, 投票者List.get(投票者女).add(投票者List.get(投票者男)));
            for (int i = 0; i < 小計.size(); i++) {
                小計.set(i, 小計.get(i).add(投票者List.get(i)));
            }
        }
    }

    private void sum(FuzaishaTohyoChoshoParam other) {

        for (int i = 0; i < 投票者.size(); i++) {
            List<Decimal> 投票者List = 投票者.get(i);
            List<Decimal> 投票者ListOther = other.get投票者().get(i);
            for (int j = 0; j < 小計.size(); j++) {
                投票者List.set(j, 投票者List.get(j).add(投票者ListOther.get(j)));
            }
        }
        List<Decimal> 小計Other = other.get小計();
        for (int i = 0; i < 小計.size(); i++) {
            小計.set(i, 小計.get(i).add(小計Other.get(i)));
        }
    }

    private RString codeToStr(Code code) {
        return code == null ? RString.EMPTY : code.getColumnValue();

    }

    /**
     * 帳票AFAPRE516_FuzaishaTohyoChosho_不在者投票に関する調書（25号様式）のパラメータbuilderクラスです。
     *
     */
    public static class FuzaishaTohyoChoshoParamBuilder {

        private static final RString 委員会名_TAIL = new RString("選挙管理委員会");
        private static final RString 委員長名_HEAD = new RString("委員長　");

        private final RString 調製年月日;
        private final RString 委員会名;
        private final RString 委員長名;

        private FuzaishaTohyoChoshoParam param;
        private FuzaishaTohyoChoshoParam sumParam;

        private final boolean 印字有無フラグ;

        /**
         * コンストラクタです。
         *
         * @param 市町村名 RString
         * @param 印字有無フラグ boolean
         */
        public FuzaishaTohyoChoshoParamBuilder(RString 市町村名, boolean 印字有無フラグ) {
            RString 選挙管理委員会委員長名 = BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体);
            this.調製年月日 = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            this.委員会名 = 市町村名.concat(委員会名_TAIL);
            this.委員長名 = 委員長名_HEAD.concat(選挙管理委員会委員長名);
            this.印字有無フラグ = 印字有無フラグ;
            param = null;
            sumParam = null;
        }

        /**
         * 検索データを追加します。
         *
         * @param 選挙 AfT111SenkyoEntity
         * @param 投票区 UrT0159TohyokuEntity
         * @param 施設 AfT507ShisetsuEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         * @param 性別 Gender
         */
        public void addData(AfT111SenkyoEntity 選挙,
                UrT0159TohyokuEntity 投票区,
                AfT507ShisetsuEntity 施設,
                AfT201TohyoJokyoEntity 投票状況,
                Gender 性別) {
            if (param == null) {
                param = new FuzaishaTohyoChoshoParam(選挙.getSenkyoName(), 投票区, 調製年月日, 委員会名, 委員長名, 印字有無フラグ);
            }
            if (sumParam == null) {
                sumParam = new FuzaishaTohyoChoshoParam(選挙.getSenkyoName(), 調製年月日, 委員会名, 委員長名, 印字有無フラグ);
            }
            param.addCount(投票状況, 施設, 性別);
        }

        /**
         * 投票区合計の処理です。
         *
         * @return FuzaishaTohyoChoshoParam
         */
        public FuzaishaTohyoChoshoParam 投票区合計() {
            if (param != null) {
                param.sum();
                sumParam.sum(param);
            }
            FuzaishaTohyoChoshoParam rslt = param;
            param = null;
            return rslt;
        }

        /**
         * 選挙合計の処理です。
         *
         * @return FuzaishaTohyoChoshoParam
         */
        public FuzaishaTohyoChoshoParam 選挙合計() {
            FuzaishaTohyoChoshoParam rslt = sumParam;
            sumParam = null;
            return rslt;
        }

    }
}
