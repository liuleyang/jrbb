/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.business.report.AFAPRG111;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG111.IchigoShikakuTorokuTsuchiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 1号資格登録通知（様式1）Reportクラスです。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
public class IchigoShikakuTorokuTsuchiReport extends Report<IchigoShikakuTorokuTsuchiSource> {
    
    private final IchigoShikakuTorokuTsuchiParameter target;

    /**
     * コンストラクタです。
     *
     * @param target {@link IchigoShikakuTorokuTsuchiParameter}
     */
    public IchigoShikakuTorokuTsuchiReport(IchigoShikakuTorokuTsuchiParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<IchigoShikakuTorokuTsuchiSource> writer) {

        IIchigoShikakuTorokuTsuchiEditor editor = new IchigoShikakuTorokuTsuchiEditor(target);
        IIchigoShikakuTorokuTsuchiBuilder builder = new IchigoShikakuTorokuTsuchiBuilder(editor);
        writer.writeLine(builder);

    }
}
