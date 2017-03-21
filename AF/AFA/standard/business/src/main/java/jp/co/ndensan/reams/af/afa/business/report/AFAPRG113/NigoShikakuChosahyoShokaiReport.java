/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG113;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG113.NigoShikakuChosahyoShokaiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 2号資格調査票（照会）（様式2-1）作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの2号資格調査票（照会）（様式2-1）ソースクラスを受け取ります。
 *
 * @reamsid_L AF-0360-061 qiuxy
 */
public class NigoShikakuChosahyoShokaiReport extends Report<NigoShikakuChosahyoShokaiSource> {

    private final NigoShikakuChosahyoShokaiParameter target;

    /**
     * コンストラクタです。
     *
     * @param target NigoShikakuChosahyoShokaiParameter
     */
    public NigoShikakuChosahyoShokaiReport(NigoShikakuChosahyoShokaiParameter target) {
        this.target = target;

    }

    @Override
    public void writeBy(ReportSourceWriter<NigoShikakuChosahyoShokaiSource> writer) {
        INigoShikakuChosahyoShokaiEditor editor = new NigoShikakuChosahyoShokaiEditor(target);
        INigoShikakuChosahyoShokaiBuilder builder = new NigoShikakuChosahyoShokaiBuilder(editor);
        writer.writeLine(builder);
    }
}
