/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE510;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE510.ShisetsuKofuIchiranhyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE510.ShisetsuKofuIchiranhyoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE510.ShisetsuKofuIchiranhyoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510.ShisetsuKofuIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE510_施設交付一覧表作成を発行します。
 *
 * @reamsid_L AF-0280-027 wangm
 */
public class ShisetsuKofuIchiranhyoPrintService {

    /**
     * 帳票_AFAPRE510_施設交付一覧表作成を発行します。
     *
     * @param targets ShisetsuKofuIchiranhyoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ShisetsuKofuIchiranhyoParam> targets) {
        ShisetsuKofuIchiranhyoProperty property = new ShisetsuKofuIchiranhyoProperty();
        return new Printer<ShisetsuKofuIchiranhyoSource>().spool(property, toReports(targets));
    }

    private static List<ShisetsuKofuIchiranhyoReport> toReports(List<ShisetsuKofuIchiranhyoParam> targets) {
        List<ShisetsuKofuIchiranhyoReport> list = new ArrayList<>();

        for (ShisetsuKofuIchiranhyoParam trgt : targets) {
            list.add(new ShisetsuKofuIchiranhyoReport(trgt));
        }
        return list;
    }

}
