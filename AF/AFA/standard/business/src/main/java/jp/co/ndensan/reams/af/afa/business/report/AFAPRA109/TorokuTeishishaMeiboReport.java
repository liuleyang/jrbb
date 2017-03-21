/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA109;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA109.TorokuTeishishaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録停止者名簿Reportクラスです。
 *
 * @reamsid_L AF-0010-043 wangm
 */
public class TorokuTeishishaMeiboReport extends Report<TorokuTeishishaMeiboSource> {

    private final TorokuTeishishaMeiboParam trgt;

    /**
     * コンストラクタです。
     *
     * @param trgt {@link TorokuTeishishaMeiboParam}
     */
    public TorokuTeishishaMeiboReport(TorokuTeishishaMeiboParam trgt) {
        this.trgt = trgt;
    }

    @Override
    public void writeBy(ReportSourceWriter<TorokuTeishishaMeiboSource> writer) {
        ITorokuTeishishaMeiboEditor editor = new TorokuTeishishaMeiboEditor(trgt);
        ITorokuTeishishaMeiboBuilder builder = new TorokuTeishishaMeiboBuilder(editor);
        writer.writeLine(builder);
    }

}
