/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG103;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG103.TorokushasuListKokuminSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票人名簿登録者数リスト作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの投票人名簿登録者数リストソースクラスを受け取ります。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public class TorokushasuListReport extends Report<TorokushasuListKokuminSource> {

    private final TorokushasuListParameter target;

    /**
     * コンストラクタです。
     *
     * @param target TorokushasuListParameter
     */
    public TorokushasuListReport(TorokushasuListParameter target) {
        this.target = target;

    }

    @Override
    public void writeBy(ReportSourceWriter<TorokushasuListKokuminSource> writer) {
        ITorokushasuListEditor editor = new TorokushasuListEditor(target);
        ITorokushasuListBuilder builder = new TorokushasuListBuilder(editor);
        writer.writeLine(builder);
    }
}
