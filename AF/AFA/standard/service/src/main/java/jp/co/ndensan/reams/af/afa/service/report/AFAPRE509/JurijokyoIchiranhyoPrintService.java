/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE509;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE509.JurijokyoIchiranhyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE509.JurijokyoIchiranhyoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE509.JurijokyoIchiranhyoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE509.JurijokyoIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE509_受理状況一覧表作成を発行します。
 *
 * @reamsid_L AF-0280-026 wangm
 */
public class JurijokyoIchiranhyoPrintService {

    /**
     * 帳票_AFAPRE509_受理状況一覧表作成を発行します。
     *
     * @param targets JurijokyoIchiranhyoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<JurijokyoIchiranhyoParam> targets) {
        JurijokyoIchiranhyoProperty property = new JurijokyoIchiranhyoProperty();
        return new Printer<JurijokyoIchiranhyoSource>().spool(property, toReports(targets));
    }

    private static List<JurijokyoIchiranhyoReport> toReports(List<JurijokyoIchiranhyoParam> targets) {
        List<JurijokyoIchiranhyoReport> list = new ArrayList<>();

        for (JurijokyoIchiranhyoParam trgt : targets) {
            list.add(new JurijokyoIchiranhyoReport(trgt));
        }
        return list;
    }

}
