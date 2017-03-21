package jp.co.ndensan.reams.af.afa.business.report.AFAPRE517;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KofuJuriHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE517_FuzaishaTohyoYoshiChosho_不在者投票用紙等の調書のパラメータクラスです。
 *
 * @reamsid_L AF-0280-034 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class FuzaishaTohyoYoshiChoshoParam {

    private static final RString 投票区コード_計 = new RString("計");

    private static final int 請求_本人 = 0;
    private static final int 請求_代理人 = 1;
    private static final int 請求_郵送 = 2;
    private static final int 請求_合計 = 3;
    private static final int 交付_直接 = 4;
    private static final int 交付_郵送 = 5;
    private static final int 交付_小計 = 6;

    private static final List<RString> 投票状況リスト;

    static {

        投票状況リスト = Arrays.asList(TohyoJokyo.請求.getCode(),
                TohyoJokyo.交付.getCode(),
                TohyoJokyo.受理.getCode(),
                TohyoJokyo.返還.getCode());

    }

    private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
    private final RString 指示画面投票区コード;

    private int page;
    private final RString 選挙名称;
    private final RString 投票区コード;

    private final List<Decimal> 集計上段;
    private final List<Decimal> 集計下段;

    private FuzaishaTohyoYoshiChoshoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            RString 指示画面投票区コード,
            int page,
            AfT111SenkyoEntity 選挙,
            UrT0159TohyokuEntity 投票区) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.指示画面投票区コード = 指示画面投票区コード;
        this.page = page;
        this.選挙名称 = 選挙.getSenkyoName();
        this.投票区コード = 投票区 == null ? RString.EMPTY : 投票区.getTohyokuCode().value();

        集計上段 = initDecimalList();
        集計下段 = initDecimalList();
    }

    private FuzaishaTohyoYoshiChoshoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            RString 指示画面投票区コード,
            AfT111SenkyoEntity 選挙) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.指示画面投票区コード = 指示画面投票区コード;
        this.選挙名称 = 選挙.getSenkyoName();
        this.投票区コード = 投票区コード_計;

        集計上段 = initDecimalList();
        集計下段 = initDecimalList();
    }

    private void setPage(int page) {
        this.page = page;
    }

    private void addCount(AfT201TohyoJokyoEntity 投票状況) {

        Code 投票状況Code = 投票状況.getTohyoJokyo();
        if (投票状況Code == null || !投票状況リスト.contains(投票状況Code.getColumnValue())) {
            return;
        }
        Code 請求方法 = 投票状況.getSeikyuHoho();
        if (請求方法 != null && !請求方法.isEmpty()) {
            RString 請求方法Str = 請求方法.getColumnValue();
            if (SeikyuHoho.直接_本人.getCode().equals(請求方法Str)) {
                addCount(投票状況, 請求_本人);

            } else if (SeikyuHoho.直接_代理人.getCode().equals(請求方法Str)) {
                addCount(投票状況, 請求_代理人);

            } else if (SeikyuHoho.郵便.getCode().equals(請求方法Str)) {
                addCount(投票状況, 請求_郵送);

            }

        }
        Code 受理方法 = 投票状況.getJuriHoho();
        if (受理方法 != null && !受理方法.isEmpty()) {
            RString 受理方法Str = 受理方法.getColumnValue();
            if (KofuJuriHoho.直接.getCode().equals(受理方法Str)) {
                addCount(投票状況, 交付_直接);

            } else if (KofuJuriHoho.郵便.getCode().equals(受理方法Str)) {
                addCount(投票状況, 交付_郵送);

            }
        }
    }

    private void sum() {
        集計上段.set(請求_合計, 集計上段.get(請求_本人).add(集計上段.get(請求_代理人)).add(集計上段.get(請求_郵送)));
        集計上段.set(交付_小計, 集計上段.get(交付_直接).add(集計上段.get(交付_郵送)));

        集計下段.set(請求_合計, 集計下段.get(請求_本人).add(集計下段.get(請求_代理人)).add(集計下段.get(請求_郵送)));
        集計下段.set(交付_小計, 集計下段.get(交付_直接).add(集計下段.get(交付_郵送)));
    }

    private void sum(FuzaishaTohyoYoshiChoshoParam other) {
        for (int i = 0; i < 集計上段.size(); i++) {
            集計上段.set(i, 集計上段.get(i).add(other.集計上段.get(i)));
            集計下段.set(i, 集計下段.get(i).add(other.集計下段.get(i)));
        }
    }

    private void addCount(AfT201TohyoJokyoEntity 投票状況, int 項目) {
        集計上段.set(項目, 集計上段.get(項目).add(Decimal.ONE));
        Code 投票事由コード = 投票状況.getTohyoJiyuCode();
        if (投票事由コード != null && TohyoJiyuCode.重度の障害.getCode().equals(投票事由コード.getColumnValue())) {
            集計下段.set(項目, 集計下段.get(項目).add(Decimal.ONE));
        }
    }

    private List<Decimal> initDecimalList() {
        List<Decimal> rslt = new ArrayList<>();
        for (int i = 0; i <= 交付_小計; i++) {
            rslt.add(Decimal.ZERO);
        }
        return rslt;
    }

    /**
     * 帳票AFAPRE517_FuzaishaTohyoYoshiChosho_不在者投票用紙等の調書のパラメータbuilderクラスです。
     *
     */
    public static class FuzaishaTohyoYoshiChoshoParamBuilder {

        private static final int ONE_PAGE_COUNT = 15;

        private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
        private final RString 指示画面投票区コード;

        private int count;
        private int page;

        private FuzaishaTohyoYoshiChoshoParam param;
        private FuzaishaTohyoYoshiChoshoParam sumParam;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 ZenjitsuCommonJohoItem
         * @param 指示画面投票区コード RString
         *
         */
        public FuzaishaTohyoYoshiChoshoParamBuilder(ZenjitsuCommonJohoItem 選挙帳票共通情報, RString 指示画面投票区コード) {
            this.選挙帳票共通情報 = 選挙帳票共通情報;
            this.指示画面投票区コード = 指示画面投票区コード;
            count = 0;
            page = 0;

            param = null;
            sumParam = null;
        }

        /**
         * 検索データを追加します。
         *
         * @param 選挙 AfT111SenkyoEntity
         * @param 投票区 UrT0159TohyokuEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         */
        public void addData(AfT111SenkyoEntity 選挙,
                UrT0159TohyokuEntity 投票区,
                AfT201TohyoJokyoEntity 投票状況) {

            if (sumParam == null) {
                sumParam = new FuzaishaTohyoYoshiChoshoParam(選挙帳票共通情報, 指示画面投票区コード, 選挙);
                page = page + count / ONE_PAGE_COUNT + 1;
                count = 0;
            }
            if (param == null) {
                param = new FuzaishaTohyoYoshiChoshoParam(選挙帳票共通情報, 指示画面投票区コード, page + count / ONE_PAGE_COUNT, 選挙, 投票区);
                count++;
            }
            param.addCount(投票状況);
        }

        /**
         * 投票区合計の処理です。
         *
         * @return FuzaishaTohyoYoshiChoshoParam
         */
        public FuzaishaTohyoYoshiChoshoParam 投票区合計() {
            if (param != null) {
                param.sum();
                sumParam.sum(param);
            }
            FuzaishaTohyoYoshiChoshoParam rslt = param;
            param = null;
            return rslt;
        }

        /**
         * 選挙合計の処理です。
         *
         * @return FuzaishaTohyoChoshoParam
         */
        public FuzaishaTohyoYoshiChoshoParam 選挙合計() {
            FuzaishaTohyoYoshiChoshoParam rslt = sumParam;
            rslt.setPage(page + count / ONE_PAGE_COUNT);
            sumParam = null;
            return rslt;
        }
    }
}
