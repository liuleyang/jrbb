package jp.co.ndensan.reams.af.afa.service.report.AFAPRE500;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeNippoParam;
import jp.co.ndensan.reams.af.afa.business.core.KomokuShukei;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE500.KijitsumaeNippoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE500.KijitsumaeNippoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoPrintService {

    /**
     * 期日前投票日報
     *
     * @param kijitsumaeNippoList List<KijitsumaeNippoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<KijitsumaeNippoParam> kijitsumaeNippoList) {
        try (ReportManager reportManager = new ReportManager()) {
            KijitsumaeNippoPorperty property = new KijitsumaeNippoPorperty();
            try (ReportAssembler<KijitsumaeNippoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<KijitsumaeNippoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();

                if (null != kijitsumaeNippoList && !kijitsumaeNippoList.isEmpty()) {
                    List<KijitsumaeNippoParam> 期日前投票日報リスト = get投票数(kijitsumaeNippoList);
                    for (KijitsumaeNippoParam param : 期日前投票日報リスト) {
                        KijitsumaeNippoReport report = toReports(param, 帳票共通ヘッダー);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static KijitsumaeNippoReport toReports(KijitsumaeNippoParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new KijitsumaeNippoReport(param, 帳票共通ヘッダー);
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通_期日前投票 = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通_期日前投票.set選挙名称(定時登録.toRString());
        帳票共通_期日前投票.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通_期日前投票;
    }

    /**
     * 期日前投票日報
     *
     * @param 期日前投票日報情報 List<KijitsumaeNippoParam>
     * @return List<KijitsumaeNippoParam>
     */
    public List<KijitsumaeNippoParam> get投票数(List<KijitsumaeNippoParam> 期日前投票日報情報) {
        List<KijitsumaeNippoParam> 期日前投票日報リスト = sort期日前投票日報情報(期日前投票日報情報);
        RString 性別_男 = new RString("男");
        RString 性別_女 = new RString("女");
        RString 性別;
        boolean 点字フラグ;
        boolean 代理投票有フラグ;
        int 投票数_男 = 0;
        int 投票数_女 = 0;
        int 内数_点字用紙_男 = 0;
        int 内数_点字用紙_女 = 0;
        int 内数_代理投票_男 = 0;
        int 内数_代理投票_女 = 0;
        for (KijitsumaeNippoParam param : 期日前投票日報リスト) {
            List<KomokuShukei> 項目集計情報 = param.get投票状況情報().get項目集計情報();
            for (KomokuShukei 項目集計 : 項目集計情報) {
                性別 = 項目集計.get性別();
                点字フラグ = 項目集計.is点字フラグ();
                代理投票有フラグ = 項目集計.is代理投票有フラグ();
                if (性別_男.equals(性別)) {
                    投票数_男 = 投票数_男 + 1;
                    if (点字フラグ) {
                        内数_点字用紙_男 = 内数_点字用紙_男 + 1;
                    }
                    if (代理投票有フラグ) {
                        内数_代理投票_男 = 内数_代理投票_男 + 1;
                    }
                }
                if (性別_女.equals(性別)) {
                    投票数_女 = 投票数_女 + 1;
                    if (点字フラグ) {
                        内数_点字用紙_女 = 内数_点字用紙_女 + 1;
                    }
                    if (代理投票有フラグ) {
                        内数_代理投票_女 = 内数_代理投票_女 + 1;
                    }
                }
            }
            param.set投票数_男(new RString(投票数_男));
            param.set投票数_女(new RString(投票数_女));
            param.set投票数_計(new RString(投票数_男 + 投票数_女));
            param.set内数_点字用紙_男(new RString(内数_点字用紙_男));
            param.set内数_点字用紙_女(new RString(内数_点字用紙_女));
            param.set内数_点字用紙_計(new RString(内数_点字用紙_男 + 内数_点字用紙_女));
            param.set内数_代理投票_男(new RString(内数_代理投票_男));
            param.set内数_代理投票_女(new RString(内数_代理投票_女));
            param.set内数_代理投票_計(new RString(内数_代理投票_男 + 内数_代理投票_女));
        }
        return 期日前投票日報リスト;
    }

    /**
     * 期日前投票日報
     *
     * @param 期日前投票日報情報 List<KijitsumaeNippoParam>
     * @return List<KijitsumaeNippoParam>
     */
    public List<KijitsumaeNippoParam> sort期日前投票日報情報(List<KijitsumaeNippoParam> 期日前投票日報情報) {
        Collections.sort(期日前投票日報情報, new Comparator<KijitsumaeNippoParam>() {
            @Override
            public int compare(KijitsumaeNippoParam o1, KijitsumaeNippoParam o2) {
                int i = o1.get投票状況情報().get選挙番号().compareTo(o2.get投票状況情報().get選挙番号());
                if (i == 0) {
                    i = o1.get投票状況情報().get施設コード().compareTo(o2.get投票状況情報().get施設コード());
                    if (i == 0) {
                        return o1.get投票状況情報().get投票日().compareTo(o2.get投票状況情報().get投票日());
                    }
                }
                return i;
            }
        });
        return 期日前投票日報情報;
    }
}
