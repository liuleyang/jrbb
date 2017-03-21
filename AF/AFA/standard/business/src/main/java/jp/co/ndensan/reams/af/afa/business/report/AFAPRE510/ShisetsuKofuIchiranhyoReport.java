/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE510;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510.ShisetsuKofuIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表のReportクラスです。
 *
 * @reamsid_L AF-0280-027 wangm
 */
public class ShisetsuKofuIchiranhyoReport extends Report<ShisetsuKofuIchiranhyoSource> {

    private final ShisetsuKofuIchiranhyoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target ShisetsuKofuIchiranhyoParam
     */
    public ShisetsuKofuIchiranhyoReport(ShisetsuKofuIchiranhyoParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShisetsuKofuIchiranhyoSource> writer) {
        IShisetsuKofuIchiranhyoEditor editor = new ShisetsuKofuIchiranhyoEditor(target);
        IShisetsuKofuIchiranhyoBuilder builder = new ShisetsuKofuIchiranhyoBuilder(editor);
        writer.writeLine(builder);
    }

}
