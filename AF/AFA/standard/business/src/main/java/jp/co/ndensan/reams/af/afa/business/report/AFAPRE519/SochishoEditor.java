/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE519;

import jp.co.ndensan.reams.af.afa.business.core.SochishoParam;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE519.SochishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link SochishoReportSource}を編集します。
 *
 * @reamsid_L AF-0280-036 lit
 */
public class SochishoEditor implements ISochishoEditor {

    private static final RString 管理者_選挙長 = new RString("選挙長");
    private static final RString 管理者_開票管理者 = new RString("開票管理者");
    private static final RString 選管委員長 = new RString("選挙管理委員会委員長");
    private static final RString 連絡文_1 = new RString("執行の");
    private static final RString 連絡文_2 = new RString("の投票箱等を次のとおり送致します。");
    private static final RString 連絡文_3 = new RString("汚損残余の投票用紙及び封筒を添えて次のとおり報告します。");
    private static final int 連絡文_上段数 = 42;
    private final ZenjitsuPrintEntity entity;
    private final SochishoParam param;

    /**
     * コンストラクタです。
     *
     * @param entity 送致書帳票対象クラス
     * @param param SochishoParam
     */
    public SochishoEditor(ZenjitsuPrintEntity entity, SochishoParam param) {
        this.entity = entity;
        this.param = param;
    }

    @Override
    public SochishoReportSource edit(SochishoReportSource source) {
        set帳票基本情報(source);
        set帳票明細情報(source);
        return source;
    }

    private void set帳票基本情報(SochishoReportSource source) {
        RString 投票年月日 = getKanjiYmd(entity.get抄本Entity().getTohyoYMD());
        Code 選挙レベル = entity.get選挙Entity().getSenkyoLevel();
        RString 投票区コード = param.get投票区コード();
        RString 選挙名称 = entity.get選挙Entity().getSenkyoName();
        RString 選挙番号 = new RString(String.valueOf(entity.get選挙Entity().getSenkyoNo().value()));

        source.sakuseiYmd = 投票年月日;
        if (null != 選挙レベル && 選挙レベル.value().equals(SennkyoLevel.市区町村.value())) {
            source.kanrishaMei1 = 管理者_選挙長;
        } else {
            source.kanrishaMei1 = 管理者_開票管理者;
        }

        source.kanrishaMei2 = param.get市町村名().concat(選管委員長);

        source.tohyokuCode = 投票区コード;
        source.senkyoNo = 選挙番号;
        RString 連絡文 = RString.FULL_SPACE
                .concat(投票年月日)
                .concat(連絡文_1)
                .concat(選挙名称)
                .concat(連絡文_2)
                .concat(連絡文_3);
        source.honbun1 = 連絡文.substring(0, 連絡文_上段数);
        source.honbun2 = 連絡文.substring(連絡文_上段数);

    }

    private void set帳票明細情報(SochishoReportSource source) {
        source.torokuSuMan = getFormatNumber(param.get名簿登録者男数());
        source.torokuSuWoman = getFormatNumber(param.get名簿登録者女数());
        source.torokuSuKei = getFormatNumber(param.get名簿登録者男数().add(param.get名簿登録者女数()));
        source.yukenshaSuMan = getFormatNumber(param.get有権者男数());
        source.yukenshaSuWoman = getFormatNumber(param.get有権者女数());
        source.yukenshaSuKei = getFormatNumber(param.get有権者男数().add(param.get有権者女数()));
        source.fuzaishaSuMan = getFormatNumber(param.get不在者投票者男数());
        source.fuzaishaSuWoman = getFormatNumber(param.get不在者投票者女数());
        source.fuzaishaSuKei = getFormatNumber(param.get不在者投票者男数().add(param.get不在者投票者女数()));
        source.tohyoYoshiSu = getFormatNumber(param.get受数_投票用紙());
        source.tenjiTohyoSu = getFormatNumber(param.get受数_点字投票用紙());
        source.kariTohyoSu = getFormatNumber(param.get受数_仮投票用封筒());
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
}
