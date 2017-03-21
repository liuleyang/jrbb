/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRH101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SeikyuDaihyoshaShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRH101.SeikyuDaihyoshaShomeishoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRH101.SeikyuDaihyoshaShomeishoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRH101.SeikyuDaihyoshaShomeishoSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 請求代表者証明書
 *
 * @reamsid_L AF-0140-030 wangh
 */
public class SeikyuDaihyoshaShomeishoPrintService {

    /**
     * 請求代表者証明書作成を発行します。
     *
     * @param paramList List<SeikyuDaihyoshaShomeishoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<SeikyuDaihyoshaShomeishoParam> paramList) {
        try (ReportManager reportManager = new ReportManager()) {
            SeikyuDaihyoshaShomeishoProperty property = new SeikyuDaihyoshaShomeishoProperty();
            try (ReportAssembler<SeikyuDaihyoshaShomeishoSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<SeikyuDaihyoshaShomeishoSource> reportSourceWriter = new ReportSourceWriter(assembler);
                Association association = AssociationFinderFactory.createInstance().getAssociation();

                for (SeikyuDaihyoshaShomeishoParam param : paramList) {
                    for (RString 氏名 : param.get氏名Lst()) {
                        List<SeikyuDaihyoshaShomeishoParam> list = new ArrayList();
                        param.set請求代表者名(氏名);
                        param.set市町村名(association.get市町村名());
                        list.add(param);
                        SeikyuDaihyoshaShomeishoReport report = toReport(list);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private SeikyuDaihyoshaShomeishoReport toReport(List<SeikyuDaihyoshaShomeishoParam> param) {
        return new SeikyuDaihyoshaShomeishoReport(param);
    }

}
