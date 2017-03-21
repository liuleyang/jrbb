/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE513;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.Jikantai.JikantaiType;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513.JikanbetsuJokyoGokeiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計を編集するクラスです。
 *
 * @reamsid_L AF-0280-030 wangm
 */
public class JikanbetsuJokyoGokeiEditor implements IJikanbetsuJokyoGokeiEditor {

    private static final RString タイトル = new RString("時間別投票状況表（合計）");
    private static final RString タイトル_不在者 = new RString("(不在者)");
    private static final RString タイトル_その他不在者 = new RString("その他不在者");
    private static final RString タイトル_投票者数_B = new RString("投票者数　B");
    private static final RString タイトル_期日前_不在者 = new RString("期日前・不在者");
    private static final RString タイトル_投票者数合計_AB = new RString("投票者数合計 A+B");
    private static final RString 施設名称タイトル = new RString("施設名称：");
    private static final RString 施設名称 = new RString("全施設合計分");
    private static final int 日付_年 = 4;

    private final JikanbetsuJokyoGokeiParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link JikanbetsuJokyoGokeiParam}
     */
    public JikanbetsuJokyoGokeiEditor(JikanbetsuJokyoGokeiParam target) {
        this.target = target;
    }

    @Override
    public JikanbetsuJokyoGokeiSource edit(JikanbetsuJokyoGokeiSource source) {

        editタイトル(source);
        editDetail(source);
        editSum(source);
        return source;
    }

    private void editタイトル(JikanbetsuJokyoGokeiSource source) {
        TeijiCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();
        // タイトル
        source.title = タイトル;
        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();
        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();
        //選挙番号
        source.senkyoNo = new RString(target.get選挙番号().toString());
        // 選挙名称
        source.senkyoMei = target.get選挙名称();
        // 施設名称タイトル
        source.headerShisetsuTitle = 施設名称タイトル;
        // 施設名称
        source.headerShisetsu = 施設名称;
        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();
        // 時間帯１
        source.jikantai1 = target.get時間帯１();
        // 時間帯２
        source.jikantai2 = target.get時間帯２();
        // 時間帯３
        source.jikantai3 = target.get時間帯３();
        // 時間帯４
        source.jikantai4 = target.get時間帯４();
        // タイトル1
        source.lblTitle1 = タイトル_不在者;
        // タイトル2
        source.lblTitle2 = タイトル_不在者;
        // タイトル3
        source.lblTitle3 = タイトル_不在者;
        // タイトル4
        source.lblTitle4 = タイトル_不在者;
        // タイトル5
        source.lblTitle5 = タイトル_不在者;
        // タイトル6
        source.lblTitle6 = タイトル_その他不在者;
        // タイトル7
        source.lblTitle7 = タイトル_投票者数_B;
        // タイトル8
        source.lblTitle8 = タイトル_期日前_不在者;
        // タイトル9
        source.lblTitle9 = タイトル_投票者数合計_AB;

    }

    private void editDetail(JikanbetsuJokyoGokeiSource source) {
        // 日付
        source.listMeisai_1 = target.get日付().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString().substring(日付_年);
        // 投票数１
        source.listMeisai_2 = formatInt(get時間帯1(target.get投票数()));
        // 不在者数１
        source.listMeisai_3 = formatInt(get時間帯1(target.get不在者数()));
        // 投票数2
        source.listMeisai_4 = formatInt(get時間帯2(target.get投票数()));
        // 不在者数2
        source.listMeisai_5 = formatInt(get時間帯2(target.get不在者数()));
        // 投票数3
        source.listMeisai_6 = formatInt(get時間帯3(target.get投票数()));
        // 不在者数3
        source.listMeisai_7 = formatInt(get時間帯3(target.get不在者数()));
        // 投票数4
        source.listMeisai_8 = formatInt(get時間帯4(target.get投票数()));
        // 不在者数4
        source.listMeisai_9 = formatInt(get時間帯4(target.get不在者数()));
        // 投票数　計
        source.listMeisai_10 = formatInt(target.get投票数計());
        // 不在者数　計(A)
        source.listMeisai_11 = formatInt(target.get不在者数計());
        // その他投票数(B)
        source.listMeisai_12 = formatInt(target.getその他投票数());
        // 投票者数合計(A+B)
        source.listMeisai_13 = formatInt(target.get投票者数合計());

    }

    private void editSum(JikanbetsuJokyoGokeiSource source) {
        if (!target.is合計()) {
            return;
        }
        // 合計投票数１
        source.listGokei_1 = formatInt(get時間帯1(target.get合計投票数()));
        // 合計不在者数１
        source.listGokei_2 = formatInt(get時間帯1(target.get合計不在者数()));
        // 合計投票数２
        source.listGokei_3 = formatInt(get時間帯2(target.get合計投票数()));
        // 合計不在者数２
        source.listGokei_4 = formatInt(get時間帯2(target.get合計不在者数()));
        // 合計投票数３
        source.listGokei_5 = formatInt(get時間帯3(target.get合計投票数()));
        // 合計不在者数３
        source.listGokei_6 = formatInt(get時間帯3(target.get合計不在者数()));
        // 合計投票数４
        source.listGokei_7 = formatInt(get時間帯4(target.get合計投票数()));
        // 合計不在者数４
        source.listGokei_8 = formatInt(get時間帯4(target.get合計不在者数()));
        // 合計投票数計
        source.listGokei_9 = formatInt(target.get合計投票数計());
        // 合計不在者数計(A)
        source.listGokei_10 = formatInt(target.get合計不在者数計());
        // 合計その他投票数(B)
        source.listGokei_11 = formatInt(target.get合計その他投票数());
        // 合計投票者数合計(A+B)
        source.listGokei_12 = formatInt(target.get合計投票者数合計());
        // 時間別投票率１
        source.listTohyoRitsu_1 = formatDouble(get時間帯1(target.get時間別投票率()));
        // 時間別投票率２
        source.listTohyoRitsu_2 = formatDouble(get時間帯2(target.get時間別投票率()));
        // 時間別投票率３
        source.listTohyoRitsu_3 = formatDouble(get時間帯3(target.get時間別投票率()));
        // 時間別投票率４
        source.listTohyoRitsu_4 = formatDouble(get時間帯4(target.get時間別投票率()));
        // １時間あたりの投票人数１
        source.listTohyoNinzu_1 = formatInt(get時間帯1(target.get投票人数_１時間あたり()));
        // １時間あたりの投票人数２
        source.listTohyoNinzu_2 = formatInt(get時間帯2(target.get投票人数_１時間あたり()));
        // １時間あたりの投票人数３
        source.listTohyoNinzu_3 = formatInt(get時間帯3(target.get投票人数_１時間あたり()));
        // １時間あたりの投票人数４
        source.listTohyoNinzu_4 = formatInt(get時間帯4(target.get投票人数_１時間あたり()));
        // １時間あたりの投票人数計
        source.listTohyoNinzu_5 = formatInt(target.get投票人数計_１時間あたり());

    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    private RString formatDouble(Decimal trgt) {
        return new RString(trgt.toString("#,##0.00"));
    }

    private Decimal get時間帯1(List<Decimal> trgt) {
        return trgt.get(JikantaiType.時間帯１.getIndex());
    }

    private Decimal get時間帯2(List<Decimal> trgt) {
        return trgt.get(JikantaiType.時間帯２.getIndex());
    }

    private Decimal get時間帯3(List<Decimal> trgt) {
        return trgt.get(JikantaiType.時間帯３.getIndex());
    }

    private Decimal get時間帯4(List<Decimal> trgt) {
        return trgt.get(JikantaiType.時間帯４.getIndex());
    }
}
