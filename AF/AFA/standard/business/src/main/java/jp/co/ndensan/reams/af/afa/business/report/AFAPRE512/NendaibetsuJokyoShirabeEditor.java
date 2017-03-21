/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE512;

import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeParam.女;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeParam.男;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeParam.計;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE512.NendaibetsuJokyoShirabeSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE512_NendaibetsuJokyoShirabe_年代別投票状況調べを編集するクラスです。
 *
 * @reamsid_L AF-0280-029 wangm
 */
public class NendaibetsuJokyoShirabeEditor implements INendaibetsuJokyoShirabeEditor {

    private final NendaibetsuJokyoShirabeParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link NendaibetsuJokyoShirabeParam}
     */
    public NendaibetsuJokyoShirabeEditor(NendaibetsuJokyoShirabeParam target) {
        this.target = target;
    }

    @Override
    public NendaibetsuJokyoShirabeSource edit(NendaibetsuJokyoShirabeSource source) {
        ZenjitsuCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();

        // タイトル
        source.title = target.getタイトル();
        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();
        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();
        // 選挙名称
        source.senkyoMei = target.get選挙名称();
        // 投票区コード
        source.tohyokuCode = target.get投票区コード();
        // 投票日
        source.tohyoYmd = target.get投票日().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();
        // 年齢・年代ラベル
        source.listMeisai_1 = target.get年齢年代ラベル();
        // 有権者　男
        source.listMeisai_2 = formatInt(target.get有権者().get(男));
        // 有権者　女
        source.listMeisai_3 = formatInt(target.get有権者().get(女));
        // 有権者　計
        source.listMeisai_4 = formatInt(target.get有権者().get(計));
        // 投票者　男
        source.listMeisai_5 = formatInt(target.get投票者().get(男));
        // 投票者　女
        source.listMeisai_6 = formatInt(target.get投票者().get(女));
        // 投票者　計
        source.listMeisai_7 = formatInt(target.get投票者().get(計));
        // 投票率　男
        source.listMeisai_8 = formatDouble(target.get投票率().get(男));
        // 投票率　女
        source.listMeisai_9 = formatDouble(target.get投票率().get(女));
        // 投票率　計
        source.listMeisai_10 = formatDouble(target.get投票率().get(計));

        return source;
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    private RString formatDouble(Decimal trgt) {
        return new RString(trgt.toString("#,##0.00"));
    }
}
