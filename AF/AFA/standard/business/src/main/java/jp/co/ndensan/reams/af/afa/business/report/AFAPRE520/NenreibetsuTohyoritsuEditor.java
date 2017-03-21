/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE520;

import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuData;
import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuListData;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link NenreibetsuTohyoritsuReportSource}を編集します。
 *
 * @reamsid_L AF-0290-036 lit
 */
public class NenreibetsuTohyoritsuEditor implements ITohyoritsuEditor {

    private final TohyoritsuData data;
    private static final Decimal MUT用_100 = new Decimal(100);

    /**
     * コンストラクタです。
     *
     * @param data 年代別投票率集計表帳票対象クラス
     */
    public NenreibetsuTohyoritsuEditor(TohyoritsuData data) {
        this.data = data;
    }

    @Override
    public NenreibetsuTohyoritsuReportSource edit(NenreibetsuTohyoritsuReportSource source) {
        set帳票共通ヘッダー(source);
        set帳票基本情報(source);
        set帳票明細情報(source);
        return source;
    }

    private void set帳票共通ヘッダー(NenreibetsuTohyoritsuReportSource source) {
        ZenjitsuCommonJohoItem 帳票共通ヘッダー = data.getCommonHeader();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.title = new RString("年齢別投票状況調べ");
    }

    private void set帳票基本情報(NenreibetsuTohyoritsuReportSource source) {
        TohyokekkaPrintEntity entity = data.getEntity();
        RString 投票年月日 = getKanjiYmd(entity.get抄本Entity().getTohyoYMD());
        RString 投票区コード = entity.get選挙人名簿Entity().getTohyokuCode();
        RString 選挙名称 = entity.get選挙Entity().getSenkyoName();
        RString 選挙番号 = new RString(String.valueOf(entity.get選挙Entity().getSenkyoNo().value()));

        source.senkyoNo = 選挙番号;
        source.tohyoYmd = 投票年月日;
        source.senkyoMei = 選挙名称;
        source.tohyokuCode = NenreibetsuTohyoritsuReportSource.DataType.選挙系.equals(data.getType()) ? new RString("全") : 投票区コード;
    }

    private void set帳票明細情報(NenreibetsuTohyoritsuReportSource source) {
        TohyoritsuListData 年代Data = data.get年代Data();
        source.listMeisai1_1 = 年代Data.getラベル();
        source.listMeisai1_2 = getFormatNumber(年代Data.get有権者男数());
        source.listMeisai1_3 = getFormatNumber(年代Data.get有権者女数());
        source.listMeisai1_4 = getFormatNumber(年代Data.get有権者数());
        source.listMeisai1_5 = getFormatNumber(年代Data.get投票者男数());
        source.listMeisai1_6 = getFormatNumber(年代Data.get投票者女数());
        source.listMeisai1_7 = getFormatNumber(年代Data.get投票者数());
        source.listMeisai1_8 = getFormatNumber(年代Data.get棄権者男数());
        source.listMeisai1_9 = getFormatNumber(年代Data.get棄権者女数());
        source.listMeisai1_10 = getFormatNumber(年代Data.get棄権者数());
        source.listMeisai1_11 = getFormatDivide(年代Data.get投票者男数(), 年代Data.get有権者男数());
        source.listMeisai1_12 = getFormatDivide(年代Data.get投票者女数(), 年代Data.get有権者女数());
        source.listMeisai1_13 = getFormatDivide(年代Data.get投票者数(), 年代Data.get有権者数());

        TohyoritsuListData 当日分Data = data.get当日分Data();
        source.listMeisai2_1 = 当日分Data.getラベル();
        source.listMeisai2_5 = getFormatNumber(当日分Data.get投票者男数());
        source.listMeisai2_6 = getFormatNumber(当日分Data.get投票者女数());
        source.listMeisai2_7 = getFormatNumber(当日分Data.get投票者数());
        source.listMeisai2_11 = getFormatDivide(当日分Data.get投票者男数(), 年代Data.get有権者男数());
        source.listMeisai2_12 = getFormatDivide(当日分Data.get投票者女数(), 年代Data.get有権者女数());
        source.listMeisai2_13 = getFormatDivide(当日分Data.get投票者数(), 年代Data.get有権者数());

        TohyoritsuListData 期日前不在者分Data = data.get期日前不在者分Data();
        source.listMeisai3_1 = 期日前不在者分Data.getラベル();
        source.listMeisai3_5 = getFormatNumber(期日前不在者分Data.get投票者男数());
        source.listMeisai3_6 = getFormatNumber(期日前不在者分Data.get投票者女数());
        source.listMeisai3_7 = getFormatNumber(期日前不在者分Data.get投票者数());
        source.listMeisai3_11 = getFormatDivide(期日前不在者分Data.get投票者男数(), 年代Data.get有権者男数());
        source.listMeisai3_12 = getFormatDivide(期日前不在者分Data.get投票者女数(), 年代Data.get有権者女数());
        source.listMeisai3_13 = getFormatDivide(期日前不在者分Data.get投票者数(), 年代Data.get有権者数());
    }

    private RString getFormatNumber(Decimal target) {
        return DecimalFormatter.toコンマ区切りRString(target, 0);
    }

    private RString getKanjiYmd(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }
        return target.wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();
    }

    private RString getFormatDivide(Decimal target1, Decimal target2) {
        if (null == target1 || null == target2 || target2.equals(Decimal.ZERO)) {
            return new RString("0.00");
        }
        return DecimalFormatter.toコンマ区切りRString(target1.multiply(MUT用_100).divide(target2).roundHalfUpTo(2), 2);
    }
}
