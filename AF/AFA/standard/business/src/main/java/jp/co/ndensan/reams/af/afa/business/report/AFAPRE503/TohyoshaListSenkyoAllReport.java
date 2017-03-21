/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE503;

import jp.co.ndensan.reams.af.afa.business.core.TohyoshaListSenkyoAllParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503.TohyoshaListSenkyoAllSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllReport extends Report<TohyoshaListSenkyoAllSource> {

    private final TohyoshaListSenkyoAllParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target {@link TohyoshaListSenkyoAllParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public TohyoshaListSenkyoAllReport(TohyoshaListSenkyoAllParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TohyoshaListSenkyoAllSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TohyoshaListSenkyoAllSource> reportSourceWriter) {
        TohyoshaListSenkyoAllEditor editor = new TohyoshaListSenkyoAllEditor(target, 帳票共通ヘッダー);
        ITohyoshaListSenkyoAllBuilder builder = new TohyoshaListSenkyoAllBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
