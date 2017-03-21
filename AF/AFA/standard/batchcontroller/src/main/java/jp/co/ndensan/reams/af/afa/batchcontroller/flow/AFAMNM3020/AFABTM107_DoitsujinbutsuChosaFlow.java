/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNM3020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNM3020.DoitsujinbutsuChosaReportProcess;
import jp.co.ndensan.reams.af.afa.definition.batchprm.doitsujinbutsuChosa.AFABTM107BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.doitsujinbutsuchosa.enumeratedtype.DoitsujinbutsuChosaRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 同一人物調査
 *
 * @reamsid_L AF-0690-020 wanghj
 */
public class AFABTM107_DoitsujinbutsuChosaFlow extends BatchFlowBase<AFABTM107BatchParameter> {

    private static final String 同一人物調査結果 = "同一人物調査結果";

    private Association association;
    private final List<EucFileOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    @Override
    protected void prepareConfigData() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void defineFlow() {
        同一人物調査結果帳票出力();

        バッチ出力条件リスト出力();
    }

    private void 同一人物調査結果帳票出力() {
        executeStep(同一人物調査結果);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                null == getResult(Long.class, new RString(同一人物調査結果), DoitsujinbutsuChosaRStringEnum.ページコント.getKey()) ? RString.EMPTY
                : new RString(getResult(Long.class, new RString(同一人物調査結果), DoitsujinbutsuChosaRStringEnum.ページコント.getKey()))));
    }

    @Step(同一人物調査結果)
    IBatchFlowCommand get同一人物調査結果べ出力() {
        return loopBatch(DoitsujinbutsuChosaReportProcess.class).arguments(getParameter()).define();
    }

    private void バッチ出力条件リスト出力() {
        for (EucFileOutputJokenhyoItem item : reportOutputJokenhyoItems) {
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private EucFileOutputJokenhyoItem getReportOutputJokenhyoItem(RString 出力ページ数) {
        RString 日本語ファイル名 = DoitsujinbutsuChosaRStringEnum.同一人物調査結果.getKey();
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 英数字ファイル名 = AFAEucEntityId.同一人物調査結果.getFileName();
        RString エンティティID = AFAEucEntityId.同一人物調査結果.getEucEntityId().toRString();
        RString 出力件数 = new RString(String.valueOf(出力ページ数));
        List<RString> 出力条件 = get出力条件リスト();

        return new EucFileOutputJokenhyoItem(日本語ファイル名, 地方公共団体コード, 市町村名, ジョブ番号,
                英数字ファイル名, エンティティID, 出力件数, 出力条件);
    }

    private List<RString> get出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_抄本名.getKey().concat(getParameter().get抄本名()));
        if (getParameter().get氏名()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_氏名.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_氏名.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get氏()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_氏.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_氏.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get名()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_名.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_名.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().getカナ()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_カナ.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_カナ.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get漢字()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_漢字.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_漢字.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get生年月日()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_生年月日.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_生年月日.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get性別()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_性別.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_性別.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get住所コード()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_住所コード.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_住所コード.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get住所()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_住所.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_住所.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }
        if (getParameter().get番地コード()) {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_番地コード.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_あり.getKey()));
        } else {
            出力条件リスト.add(DoitsujinbutsuChosaRStringEnum.出力条件_番地コード.getKey().concat(DoitsujinbutsuChosaRStringEnum.フラグ_しない.getKey()));
        }

        return 出力条件リスト;
    }

}
