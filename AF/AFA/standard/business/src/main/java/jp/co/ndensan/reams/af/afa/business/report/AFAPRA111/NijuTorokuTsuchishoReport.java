/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA111;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111.NijuTorokuTsuchishoCommonSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 適用適正化件数表作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの適用適正化件数表作成Itemクラスを受け取ります。
 *
 * @reamsid_L AF-0010-044 xiaoj
 */
public class NijuTorokuTsuchishoReport extends Report<NijuTorokuTsuchishoCommonSource> {

    private final NijuTorokuTsuchishoParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 二重登録者通知のパラメータ
     */
    public NijuTorokuTsuchishoReport(NijuTorokuTsuchishoParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<NijuTorokuTsuchishoCommonSource> writer) {
        if (target.getPage().equals(new RString("1"))) {
            writer.writeLine(new NijuTorokuTsuchishoBuilder(new NijuTorokuTsuchishoEditor(target)));
        } else {
            writer.writeLine(new NijuTorokuTsuchishoMeisaiBuilder(new NijuTorokuTsuchishoMeisaiEditor(target)));
        }
    }
}
