/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE201;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE201.FuzaishaTohyoShomeishoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE201.FuzaishaTohyoShomeishoReport;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE201.FuzaishaTohyoShomeishoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * AFAPRE201_FuzaishaTohyoShomeisho_不在者投票証明書（12号様式）作成を発行します。
 *
 * @reamsid_L AF-0090-020 lit
 */
public class FuzaishaTohyoShomeishoPrintService {

    /**
     * AFAPRE201_FuzaishaTohyoShomeisho_不在者投票証明書（12号様式）作成を発行します。
     *
     * @param targets SenseishoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<SenseishoParam> targets) {
        FuzaishaTohyoShomeishoProperty property = new FuzaishaTohyoShomeishoProperty();
        return new Printer<FuzaishaTohyoShomeishoReportSource>().spool(property, toReports(targets));
    }

    private static List<FuzaishaTohyoShomeishoReport> toReports(List<SenseishoParam> targets) {
        List<FuzaishaTohyoShomeishoReport> list = new ArrayList<>();

        for (SenseishoParam target : targets) {
            list.add(new FuzaishaTohyoShomeishoReport(target, get地方公共団体(target.get選挙人資格情報())));
        }
        return list;
    }

    private static Association get地方公共団体(SenkyoninTohyoJokyoEntity entity) {
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association;
        LasdecCode 現全国地方公共団体コード = entity.getAtenaPSMEntity().getGenLasdecCode();
        if (null == 現全国地方公共団体コード || 現全国地方公共団体コード.isEmpty()) {
            association = null;
        } else {
            association = associationFinder.getAssociation(現全国地方公共団体コード);
        }
        return association;
    }
}
