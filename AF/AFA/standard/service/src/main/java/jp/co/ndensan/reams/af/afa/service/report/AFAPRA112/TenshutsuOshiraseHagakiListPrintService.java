package jp.co.ndensan.reams.af.afa.service.report.AFAPRA112;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA112.TenshutsuOshiraseHagakiListPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA112.TenshutsuOshiraseHagakiListReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 転出者お知らせハガキ作成対象者一覧表
 *
 * @reamsid_L AF-0160-030 jihb
 */
public class TenshutsuOshiraseHagakiListPrintService {

    private static final RString ZERO = new RString("0");

    /**
     * 転出者お知らせハガキ作成対象者一覧表
     *
     * @param tenshutsuOshiraseHagakiList List<TenshutsuOshiraseHagakiListParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TenshutsuOshiraseHagakiListParam> tenshutsuOshiraseHagakiList) {
        try (ReportManager reportManager = new ReportManager()) {
            TenshutsuOshiraseHagakiListPorperty property = new TenshutsuOshiraseHagakiListPorperty();
            try (ReportAssembler<NijuTorokuTsuchishoListSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<NijuTorokuTsuchishoListSource> reportSourceWriter = new ReportSourceWriter(assembler);

                Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
                for (TenshutsuOshiraseHagakiListParam param : tenshutsuOshiraseHagakiList) {
                    set名簿番号(param, nyujoken3tsuori);
                    set生年月日(param, nyujoken3tsuori);
                }

                for (TenshutsuOshiraseHagakiListReport report : toReports(tenshutsuOshiraseHagakiList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private void set生年月日(TenshutsuOshiraseHagakiListParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get投票所入場券情報()) {
            RString 生年月日 = nyujoken3tsuori.getSeinengappi(param.get投票所入場券情報().get住民種別コード(), param.get投票所入場券情報().get生年月日());
            param.set生年月日(生年月日);
        }
    }

    private void set名簿番号(TenshutsuOshiraseHagakiListParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get投票所入場券情報()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get投票所入場券情報().get投票区コード());
            RString 名簿番号 = nyujoken3tsuori.getMeiboNo(投票区コード, Integer.valueOf(changeNullToEmpty(param.get投票所入場券情報().get頁()).toString()),
                    Integer.valueOf(changeNullToEmpty(param.get投票所入場券情報().get行()).toString()));
            param.set名簿番号(名簿番号);
        }
    }

    private static List<TenshutsuOshiraseHagakiListReport> toReports(List<TenshutsuOshiraseHagakiListParam> targets) {
        List<TenshutsuOshiraseHagakiListReport> list = new ArrayList<>();
        for (TenshutsuOshiraseHagakiListParam target : targets) {
            list.add(new TenshutsuOshiraseHagakiListReport(target));
        }
        return list;

    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? ZERO : 文字列;
    }
}
