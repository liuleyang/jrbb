/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE2050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205BatchPrintProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * バッチ出力条件表作成のクラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class ShisetsuSofushoShutsuryokuhyouProcess extends SimpleBatchProcessBase {

    private AFABTE205BatchPrintProcessParameter batchPrintProcessParameter;
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString 出力内容_有り = new RString("する");
    private static final RString 出力内容_無し = new RString("しない");
    private static final RString 出力条件_抄本番号 = new RString("【抄本番号】");
    private static final RString 出力条件_無投票選挙も出力する = new RString("【無投票選挙も出力する】");
    private static final RString 出力条件_発行番号 = new RString("【発行番号】");
    private static final RString 出力条件_発行日 = new RString("【発行日】");
    private static final RString 出力条件_施設コード開始 = new RString("【施設コード_開始】");
    private static final RString 出力条件_施設コード終了 = new RString("【施設コード_終了】");
    private static final RString 出力条件_交付日開始 = new RString("【交付日_開始】");
    private static final RString 出力条件_交付日終了 = new RString("【交付日_終了】");
    private Association association;

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process() {
        List<RString> 出力条件 = new ArrayList<>();
        ShohonNo 抄本番号 = batchPrintProcessParameter.get抄本番号();

        if (抄本番号 == null) {
            出力条件.add(出力条件_抄本番号);
        } else {
            出力条件.add(出力条件_抄本番号.concat(new RString(抄本番号.getColumnValue().toString())));
        }
        Boolean is無投票選挙も出力する = batchPrintProcessParameter.is無投票選挙も出力する();
        if (is無投票選挙も出力する == null) {
            出力条件.add(出力条件_無投票選挙も出力する);
        } else {
            出力条件.add(出力条件_無投票選挙も出力する.concat(
                    is無投票選挙も出力する ? 出力内容_有り : 出力内容_無し));
        }
        RString 発行番号 = batchPrintProcessParameter.get発行番号();
        if (発行番号 == null) {
            出力条件.add(出力条件_発行番号);
        } else {
            出力条件.add(出力条件_発行番号.concat(発行番号));
        }
        FlexibleDate 発行日 = batchPrintProcessParameter.get発行日();
        if (発行日 == null) {
            出力条件.add(出力条件_発行日);
        } else {
            出力条件.add(出力条件_発行日.concat(edit日時(発行日)));
        }
        RString 施設コード開始 = batchPrintProcessParameter.get施設コード_開始();
        if (施設コード開始 == null) {
            出力条件.add(出力条件_施設コード開始);
        } else {
            出力条件.add(出力条件_施設コード開始.concat(施設コード開始));
        }
        RString 施設コード終了 = batchPrintProcessParameter.get施設コード_終了();
        if (施設コード終了 == null) {
            出力条件.add(出力条件_施設コード終了);
        } else {
            出力条件.add(出力条件_施設コード終了.concat(施設コード終了));
        }
        FlexibleDate 交付日開始 = batchPrintProcessParameter.get交付日_開始();
        if (交付日開始 == null) {
            出力条件.add(出力条件_交付日開始);
        } else {
            出力条件.add(出力条件_交付日開始.concat(edit日時(交付日開始)));
        }
        FlexibleDate 交付日終了 = batchPrintProcessParameter.get交付日_終了();
        if (交付日終了 == null) {
            出力条件.add(出力条件_交付日終了);
        } else {
            出力条件.add(出力条件_交付日終了.concat(edit日時(交付日終了)));
        }
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdKeys.AFAPRE205_施設送付書.value(),
                        association.get地方公共団体コード().getColumnValue(),
                        association.get市町村名(),
                        batchPrintProcessParameter.getジョブ番号() == null ? RString.EMPTY : new RString(batchPrintProcessParameter.getジョブ番号()),
                        ReportIdKeys.AFAPRE205_施設送付書.getReportName(),
                        batchPrintProcessParameter.get出力ページ数(),
                        CSV出力有無_あり,
                        ReportIdKeys.AFAPRE205_施設送付書.getEucFileName(),
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private RString edit日時(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
