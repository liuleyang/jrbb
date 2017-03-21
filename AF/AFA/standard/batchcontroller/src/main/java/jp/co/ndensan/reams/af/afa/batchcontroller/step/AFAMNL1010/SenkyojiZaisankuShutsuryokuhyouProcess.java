/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101BatchPrintProcessParameter;
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
 * 財産区議会議員選挙時登録のバッチ出力条件表作成のクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuShutsuryokuhyouProcess extends SimpleBatchProcessBase {

    private AFABTL101BatchPrintProcessParameter batchPrintProcessParameter;

    private Association association;

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process() {
        List<RString> 出力条件 = new ArrayList<>();
        RString 抄本番号 = batchPrintProcessParameter.get抄本番号();
        if (抄本番号 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_抄本名.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_抄本名.getKey()
                    .concat(抄本番号)
                    .concat(SenkyojiZaisankuRStringEnum.出力内容_連絡符号２.getKey())
                    .concat(batchPrintProcessParameter.get抄本名()));
        }
        FlexibleDate 投票日 = batchPrintProcessParameter.get投票日();
        if (投票日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_投票日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_投票日.getKey().concat(edit日時(投票日)));
        }
        FlexibleDate 基準日 = batchPrintProcessParameter.get基準日();
        if (基準日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_基準日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_基準日.getKey().concat(edit日時(基準日)));
        }
        FlexibleDate 登録日 = batchPrintProcessParameter.get登録日();
        if (登録日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_登録日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_登録日.getKey().concat(edit日時(登録日)));
        }
        FlexibleDate 転出期限日 = batchPrintProcessParameter.get転出期限日();
        if (転出期限日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_転出期限日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_転出期限日.getKey().concat(edit日時(転出期限日)));
        }
        FlexibleDate 転入期限日 = batchPrintProcessParameter.get転入期限日();
        if (転入期限日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_転入期限日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_転入期限日.getKey().concat(edit日時(転入期限日)));
        }
        FlexibleDate 年齢期限日 = batchPrintProcessParameter.get年齢期限日();
        if (年齢期限日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_年齢期限日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_年齢期限日.getKey().concat(edit日時(年齢期限日)));
        }
        Integer 財産区内居住年数 = batchPrintProcessParameter.get財産区内居住年数();
        if (財産区内居住年数 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_財産区内居住年数.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_財産区内居住年数.getKey().concat(new RString(財産区内居住年数)));
        }
        FlexibleDate 投票開始日 = batchPrintProcessParameter.get投票開始日();
        if (投票開始日 == null) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_投票開始日.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_投票開始日.getKey().concat(edit日時(投票開始日)));
        }
        RString 選択レコードリスト = RString.EMPTY;
        List<RString> 対象者住所条件選択レコードリスト = batchPrintProcessParameter.get対象者住所条件選択レコードリスト();
        for (RString 対象者住所条件 : 対象者住所条件選択レコードリスト) {
            選択レコードリスト = 選択レコードリスト.concat(対象者住所条件).concat(
                    SenkyojiZaisankuRStringEnum.出力内容_連絡符号１.getKey());
        }
        if (選択レコードリスト.isEmpty()) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_対象者住所条件リスト.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_対象者住所条件リスト.getKey().concat(
                    選択レコードリスト.substring(0, 選択レコードリスト.length() - 1)));
        }
        選択レコードリスト = RString.EMPTY;
        List<RString> 詳細指定選択レコードリスト = batchPrintProcessParameter.get詳細指定選択レコードリスト();
        for (RString 詳細指定 : 詳細指定選択レコードリスト) {
            選択レコードリスト = 選択レコードリスト.concat(詳細指定).concat(
                    SenkyojiZaisankuRStringEnum.出力内容_連絡符号１.getKey());
        }
        if (選択レコードリスト.isEmpty()) {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_詳細指定リスト.getKey());
        } else {
            出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_詳細指定リスト.getKey().concat(
                    選択レコードリスト.substring(0, 選択レコードリスト.length() - 1)));
        }
        出力条件.add(SenkyojiZaisankuRStringEnum.出力条件_選挙人名簿抄本.getKey().concat(
                batchPrintProcessParameter.is選挙人名簿抄本有無()
                ? SenkyojiZaisankuRStringEnum.出力内容_出力.getKey() : SenkyojiZaisankuRStringEnum.出力内容_出力しない.getKey()));
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdKeys.AFAPRL100_財産区選挙人名簿抄本.value(),
                        association.get地方公共団体コード().getColumnValue(),
                        association.get市町村名(),
                        batchPrintProcessParameter.getジョブ番号() == null
                        ? RString.EMPTY : new RString(batchPrintProcessParameter.getジョブ番号()),
                        ReportIdKeys.AFAPRL100_財産区選挙人名簿抄本.getReportName(),
                        batchPrintProcessParameter.get出力ページ数(),
                        SenkyojiZaisankuRStringEnum.CSV出力有無_あり.getKey(),
                        ReportIdKeys.AFAPRL100_財産区選挙人名簿抄本.getEucFileName(),
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private RString edit日時(FlexibleDate 日時) {
        if (日時 == null) {
            return RString.EMPTY;
        }
        return 日時.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
