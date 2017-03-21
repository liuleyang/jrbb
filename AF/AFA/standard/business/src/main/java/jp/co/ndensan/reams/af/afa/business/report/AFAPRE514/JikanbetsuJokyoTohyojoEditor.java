/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE514;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.Jikantai;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoParam.女;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoParam.男;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoParam.計;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE514.JikanbetsuJokyoTohyojoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE514_JikanbetsuJokyoTohyojo_時間別投票状況表　投票所別を編集するクラスです。
 *
 * @reamsid_L AF-0280-031 wangm
 */
public class JikanbetsuJokyoTohyojoEditor implements IJikanbetsuJokyoTohyojoEditor {

    private static final RString タイトル = new RString("時間別投票状況表（投票所別）");
    private static final RString 施設名称タイトル = new RString("施設名称：");
    private static final int 日付_年 = 4;

    private final JikanbetsuJokyoTohyojoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link JikanbetsuJokyoTohyojoParam}
     */
    public JikanbetsuJokyoTohyojoEditor(JikanbetsuJokyoTohyojoParam target) {
        this.target = target;
    }

    @Override
    public JikanbetsuJokyoTohyojoSource edit(JikanbetsuJokyoTohyojoSource source) {

        editタイトル(source);
        editDetail(source);
        editSum(source);
        return source;
    }

    private void editタイトル(JikanbetsuJokyoTohyojoSource source) {
        TeijiCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();
        // タイトル
        source.title = タイトル;
        // 施設名称タイトル
        source.headerShisetsuTitle = 施設名称タイトル;
        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();
        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();
        //選挙番号
        source.senkyoNo = new RString(target.get選挙番号().toString());
        // 選挙名称
        source.senkyoMei = target.get選挙名称();
        // 施設コード
        source.shisetsuCode = target.get施設コード();
        // 施設名称
        source.headerShisetsu = target.get施設名称();
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
    }

    private void editDetail(JikanbetsuJokyoTohyojoSource source) {
        // 日付
        source.listMeisai_1 = target.get日付().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString().substring(日付_年);

        // 投票数　男１
        source.listMeisai_2 = formatInt(get時間帯1(target.get時間帯投票数(), 男));
        // 投票数　女１
        source.listMeisai_3 = formatInt(get時間帯1(target.get時間帯投票数(), 女));
        // 投票数　計１
        source.listMeisai_4 = formatInt(get時間帯1(target.get時間帯投票数(), 計));
        // 投票数　男2
        source.listMeisai_5 = formatInt(get時間帯2(target.get時間帯投票数(), 男));
        // 投票数　女2
        source.listMeisai_6 = formatInt(get時間帯2(target.get時間帯投票数(), 女));
        // 投票数　計2
        source.listMeisai_7 = formatInt(get時間帯2(target.get時間帯投票数(), 計));
        // 投票数　男3
        source.listMeisai_8 = formatInt(get時間帯3(target.get時間帯投票数(), 男));
        // 投票数　女3
        source.listMeisai_9 = formatInt(get時間帯3(target.get時間帯投票数(), 女));
        // 投票数　計3
        source.listMeisai_10 = formatInt(get時間帯3(target.get時間帯投票数(), 計));
        // 投票数　男4
        source.listMeisai_11 = formatInt(get時間帯4(target.get時間帯投票数(), 男));
        // 投票数　女4
        source.listMeisai_12 = formatInt(get時間帯4(target.get時間帯投票数(), 女));
        // 投票数　計4
        source.listMeisai_13 = formatInt(get時間帯4(target.get時間帯投票数(), 計));
        // 合計投票数　男
        source.listMeisai_14 = formatInt(getBy性別(target.get合計投票数(), 男));
        // 合計投票数　女
        source.listMeisai_15 = formatInt(getBy性別(target.get合計投票数(), 女));
        // 合計投票数　計
        source.listMeisai_16 = formatInt(getBy性別(target.get合計投票数(), 計));
    }

    private void editSum(JikanbetsuJokyoTohyojoSource source) {
        if (!target.is合計()) {
            return;
        }
        // 合計　投票数　男１
        source.listGokei_1 = formatInt(get時間帯1(target.get合計時間帯投票数(), 男));
        // 合計　投票数　女１
        source.listGokei_2 = formatInt(get時間帯1(target.get合計時間帯投票数(), 女));
        // 合計　投票数　計１
        source.listGokei_3 = formatInt(get時間帯1(target.get合計時間帯投票数(), 計));
        // 合計　投票数　男2
        source.listGokei_4 = formatInt(get時間帯2(target.get合計時間帯投票数(), 男));
        // 合計　投票数　女2
        source.listGokei_5 = formatInt(get時間帯2(target.get合計時間帯投票数(), 女));
        // 合計　投票数　計2
        source.listGokei_6 = formatInt(get時間帯2(target.get合計時間帯投票数(), 計));
        // 合計　投票数　男3
        source.listGokei_7 = formatInt(get時間帯3(target.get合計時間帯投票数(), 男));
        // 合計　投票数　女3
        source.listGokei_8 = formatInt(get時間帯3(target.get合計時間帯投票数(), 女));
        // 合計　投票数　計3
        source.listGokei_9 = formatInt(get時間帯3(target.get合計時間帯投票数(), 計));
        // 合計　投票数　男4
        source.listGokei_10 = formatInt(get時間帯4(target.get合計時間帯投票数(), 男));
        // 合計　投票数　女4
        source.listGokei_11 = formatInt(get時間帯4(target.get合計時間帯投票数(), 女));
        // 合計　投票数　計4
        source.listGokei_12 = formatInt(get時間帯4(target.get合計時間帯投票数(), 計));

        // 合計　投票数　男5
        source.listGokei_13 = formatInt(getBy性別(target.get合計合計投票数(), 男));
        // 合計　投票数　女5
        source.listGokei_14 = formatInt(getBy性別(target.get合計合計投票数(), 女));
        // 合計　投票数　計5
        source.listGokei_15 = formatInt(getBy性別(target.get合計合計投票数(), 計));

        // 時間別投票率　男１
        source.listTohyoRitsu_1 = formatDouble(get時間帯1(target.get時間別投票率(), 男));
        // 時間別投票率　女1
        source.listTohyoRitsu_2 = formatDouble(get時間帯1(target.get時間別投票率(), 女));
        // 時間別投票率　計1
        source.listTohyoRitsu_3 = formatDouble(get時間帯1(target.get時間別投票率(), 計));
        // 時間別投票率　男2
        source.listTohyoRitsu_4 = formatDouble(get時間帯2(target.get時間別投票率(), 男));
        // 時間別投票率　女2
        source.listTohyoRitsu_5 = formatDouble(get時間帯2(target.get時間別投票率(), 女));
        // 時間別投票率　計2
        source.listTohyoRitsu_6 = formatDouble(get時間帯2(target.get時間別投票率(), 計));
        // 時間別投票率　男3
        source.listTohyoRitsu_7 = formatDouble(get時間帯3(target.get時間別投票率(), 男));
        // 時間別投票率　女3
        source.listTohyoRitsu_8 = formatDouble(get時間帯3(target.get時間別投票率(), 女));
        // 時間別投票率　計3
        source.listTohyoRitsu_9 = formatDouble(get時間帯3(target.get時間別投票率(), 計));
        // 時間別投票率　男4
        source.listTohyoRitsu_10 = formatDouble(get時間帯4(target.get時間別投票率(), 男));
        // 時間別投票率　女4
        source.listTohyoRitsu_11 = formatDouble(get時間帯4(target.get時間別投票率(), 女));
        // 時間別投票率　計4
        source.listTohyoRitsu_12 = formatDouble(get時間帯4(target.get時間別投票率(), 計));

        // 時間別投票率　男5
        source.listTohyoRitsu_13 = RString.EMPTY;
        // 時間別投票率　女5
        source.listTohyoRitsu_14 = RString.EMPTY;
        // 時間別投票率　計5
        source.listTohyoRitsu_15 = RString.EMPTY;

        if (RString.isNullOrEmpty(target.get施設コード())) {
            // １時間あたりの投票人数　男1
            source.listTohyoNinzu_1 = formatInt(get時間帯1(target.get投票人数_１時間あたり(), 男));
            // １時間あたりの投票人数　女1
            source.listTohyoNinzu_2 = formatInt(get時間帯1(target.get投票人数_１時間あたり(), 女));
            // １時間あたりの投票人数　計1
            source.listTohyoNinzu_3 = formatInt(get時間帯1(target.get投票人数_１時間あたり(), 計));
            // １時間あたりの投票人数　男2
            source.listTohyoNinzu_4 = formatInt(get時間帯2(target.get投票人数_１時間あたり(), 男));
            // １時間あたりの投票人数　女2
            source.listTohyoNinzu_5 = formatInt(get時間帯2(target.get投票人数_１時間あたり(), 女));
            // １時間あたりの投票人数　計2
            source.listTohyoNinzu_6 = formatInt(get時間帯2(target.get投票人数_１時間あたり(), 計));
            // １時間あたりの投票人数　男3
            source.listTohyoNinzu_7 = formatInt(get時間帯3(target.get投票人数_１時間あたり(), 男));
            // １時間あたりの投票人数　女3
            source.listTohyoNinzu_8 = formatInt(get時間帯3(target.get投票人数_１時間あたり(), 女));
            // １時間あたりの投票人数　計3
            source.listTohyoNinzu_9 = formatInt(get時間帯3(target.get投票人数_１時間あたり(), 計));
            // １時間あたりの投票人数　男4
            source.listTohyoNinzu_10 = formatInt(get時間帯4(target.get投票人数_１時間あたり(), 男));
            // １時間あたりの投票人数　女4
            source.listTohyoNinzu_11 = formatInt(get時間帯4(target.get投票人数_１時間あたり(), 女));
            // １時間あたりの投票人数　計4
            source.listTohyoNinzu_12 = formatInt(get時間帯4(target.get投票人数_１時間あたり(), 計));

            // １時間あたりの投票人数　男5
            source.listTohyoNinzu_13 = formatInt(getBy性別(target.get投票人数計_１時間あたり(), 男));
            // １時間あたりの投票人数　女5
            source.listTohyoNinzu_14 = formatInt(getBy性別(target.get投票人数計_１時間あたり(), 女));
            // １時間あたりの投票人数　計5
            source.listTohyoNinzu_15 = formatInt(getBy性別(target.get投票人数計_１時間あたり(), 計));
        }
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    private RString formatDouble(Decimal trgt) {
        return new RString(trgt.toString("#,##0.00"));
    }

    private Decimal get時間帯1(List<List<Decimal>> trgt, int 性別) {
        return getBy性別(trgt.get(Jikantai.JikantaiType.時間帯１.getIndex()), 性別);
    }

    private Decimal get時間帯2(List<List<Decimal>> trgt, int 性別) {
        return getBy性別(trgt.get(Jikantai.JikantaiType.時間帯２.getIndex()), 性別);
    }

    private Decimal get時間帯3(List<List<Decimal>> trgt, int 性別) {
        return getBy性別(trgt.get(Jikantai.JikantaiType.時間帯３.getIndex()), 性別);
    }

    private Decimal get時間帯4(List<List<Decimal>> trgt, int 性別) {
        return getBy性別(trgt.get(Jikantai.JikantaiType.時間帯４.getIndex()), 性別);
    }

    private Decimal getBy性別(List<Decimal> trgt, int 性別) {
        return trgt.get(性別);
    }
}
