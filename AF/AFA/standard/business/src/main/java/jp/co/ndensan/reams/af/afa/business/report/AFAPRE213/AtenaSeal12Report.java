/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE213;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12Param;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 宛名シール12面
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSeal12Report extends Report<AtenaSeal12Source> {

    private final AtenaSeal12Param target;

    /**
     * コンストラクタです。
     *
     * @param target AtenaSeal12Param
     */
    public AtenaSeal12Report(AtenaSeal12Param target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<AtenaSeal12Source>}
     */
    @Override
    public void writeBy(ReportSourceWriter<AtenaSeal12Source> reportSourceWriter) {
        AtenaSeal12Editor editor = new AtenaSeal12Editor(target);
        IAtenaSeal12Builder builder = new AtenaSeal12Builder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
