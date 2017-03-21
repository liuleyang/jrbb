/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE517;

import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE517.FuzaishaTohyoYoshiChoshoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE517_FuzaishaTohyoYoshiChosho_不在者投票用紙等の調書を編集するクラスです。
 *
 * @reamsid_L AF-0280-034 wangm
 */
public class FuzaishaTohyoYoshiChoshoEditor implements IFuzaishaTohyoYoshiChoshoEditor {

    private static final RString 左かっこ = new RString("(");
    private static final RString 右かっこ = new RString(")");

    private static final RString ゼロ = new RString("　―　");

    private static final int 請求_本人 = 0;
    private static final int 請求_代理人 = 1;
    private static final int 請求_郵送 = 2;
    private static final int 請求_合計 = 3;
    private static final int 交付_直接 = 4;
    private static final int 交付_郵送 = 5;
    private static final int 交付_小計 = 6;

    private final FuzaishaTohyoYoshiChoshoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link FuzaishaTohyoYoshiChoshoParam}
     */
    public FuzaishaTohyoYoshiChoshoEditor(FuzaishaTohyoYoshiChoshoParam target) {
        this.target = target;
    }

    @Override
    public FuzaishaTohyoYoshiChoshoSource edit(FuzaishaTohyoYoshiChoshoSource source) {

        ZenjitsuCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();
        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();
        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();
        // 選挙名称
        source.senkyoMei = target.get選挙名称();
        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();
        source.pagecnt = new RString(String.valueOf(target.getPage()));

        source.sakuseiJoken1 = target.get指示画面投票区コード();
        source.sakuseiJoken2 = RString.EMPTY;

        editDetail(source);

        return source;
    }

    private void editDetail(FuzaishaTohyoYoshiChoshoSource source) {
        // 投票区
        source.listMeisai1_1 = target.get投票区コード();
        // （請求）本人_上段
        source.listMeisai1_2 = edit上段(請求_本人);
        // （請求）本人_左かっこ
        source.listMeisai2_1 = 左かっこ;
        // （請求）本人_下段
        source.listMeisai2_2 = edit下段(請求_本人);
        // （請求）本人_右かっこ
        source.listMeisai2_3 = 右かっこ;
        // （請求）代理人_上段
        source.listMeisai1_3 = edit上段(請求_代理人);
        // （請求）代理人_左かっこ
        source.listMeisai2_4 = 左かっこ;
        // （請求）代理人_下段
        source.listMeisai2_5 = edit下段(請求_代理人);
        // （請求）代理人_右かっこ
        source.listMeisai2_6 = 右かっこ;
        // （請求）郵送_上段
        source.listMeisai1_4 = edit上段(請求_郵送);
        // （請求）郵送_左かっこ
        source.listMeisai2_7 = 左かっこ;
        // （請求）郵送_下段
        source.listMeisai2_8 = edit下段(請求_郵送);
        // （請求）郵送_右かっこ
        source.listMeisai2_9 = 右かっこ;
        // （請求）合計_上段
        source.listMeisai1_5 = edit上段(請求_合計);
        // （請求）合計_左かっこ
        source.listMeisai2_10 = 左かっこ;
        // （請求）合計_下段
        source.listMeisai2_11 = edit下段(請求_合計);
        // （請求）合計_右かっこ
        source.listMeisai2_12 = 右かっこ;
        // （交付）直接_上段
        source.listMeisai1_6 = edit上段(交付_直接);
        // （交付）直接_左かっこ
        source.listMeisai2_13 = 左かっこ;
        // （交付）直接_下段
        source.listMeisai2_14 = edit下段WithBlank(交付_直接);
        // （交付）直接_右かっこ
        source.listMeisai2_15 = 右かっこ;
        // （交付）郵送_上段
        source.listMeisai1_7 = edit上段(交付_郵送);
        // （交付）郵送_左かっこ
        source.listMeisai2_16 = 左かっこ;
        // （交付）郵送_下段
        source.listMeisai2_17 = edit下段(交付_郵送);
        // （交付）郵送_右かっこ
        source.listMeisai2_18 = 右かっこ;
        // （交付）小計_上段
        source.listMeisai1_8 = edit上段(交付_小計);
        // （交付）小計_左かっこ
        source.listMeisai2_19 = 左かっこ;
        // （交付）小計_下段
        source.listMeisai2_20 = edit下段(交付_小計);
        // （交付）小計_右かっこ
        source.listMeisai2_21 = 右かっこ;
        // （交付）拒絶_上段
        source.listMeisai1_9 = RString.EMPTY;
        // （交付）拒絶_左かっこ
        source.listMeisai2_22 = RString.EMPTY;
        // （交付）拒絶_下段
        source.listMeisai2_23 = RString.EMPTY;
        // （交付）拒絶_右かっこ
        source.listMeisai2_24 = RString.EMPTY;
        // （交付）合計_上段
        source.listMeisai1_10 = edit上段(交付_小計);
        // （交付）合計_左かっこ
        source.listMeisai2_25 = 左かっこ;
        // （交付）合計_下段
        source.listMeisai2_26 = edit下段(交付_小計);
        // （交付）合計_右かっこ
        source.listMeisai2_27 = 右かっこ;

    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    private RString edit上段(int 項目) {
        return formatInt(target.get集計上段().get(項目));
    }

    private RString edit下段(int 項目) {
        return formatInt(target.get集計下段().get(項目));
    }

    private RString edit下段WithBlank(int 項目) {
        Decimal trgt = target.get集計下段().get(項目);
        if (trgt.compareTo(Decimal.ZERO) == 0) {
            return ゼロ;
        }
        return formatInt(trgt);
    }
}
