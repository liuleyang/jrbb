/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.ReportOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * バッチ出力条件表作成のクラスです。
 */
public class BatchSyuturyokuJyoukenProcess extends SimpleBatchProcessBase {

    private static final RString CSV_出力有無 = new RString("あり");

    private static final RString 出力条件_投票区 = new RString("【  投票区】");
    private static final RString 出力条件_出力条件 = new RString("【出力条件】");
    private static final RString 出力条件_識別コード = new RString("【識別コード】");
    private static final RString 出力条件_指定日 = new RString("【指定日】");
    private static final RString 出力条件_異動事由 = new RString("【異動事由】");
    private static final RString 出力条件_時点日 = new RString("【  時点日】");
    private static final RString 出力条件_発行日 = new RString("【  発行日】");
    private static final RString 出力条件_発行番号の第 = new RString("【  発行番号の第】");
    private static final RString 出力条件_発行番号の番号 = new RString("【  発行番号の番号】");
    private static final RString 出力条件_発行番号の号 = new RString("【  発行番号の号】");
    private static final RString 出力条件_転入期間 = new RString("【  転入期間】");
    private static final RString 出力条件_帰化期間 = new RString("【帰化期間】");
    private static final RString 出力条件_抄本名 = new RString("【抄本名】");
    private static final RString 出力条件_基準日 = new RString("【基準日】");
    private static final RString 出力条件_登録日 = new RString("【登録日】");
    private static final RString 出力条件_転出期限日 = new RString("【転出期限日】");
    private static final RString 出力条件_転入期限日 = new RString("【転入期限日】");
    private static final RString 出力条件_年齢期限日 = new RString("【年齢期限日】");

    private static final RString 出力条件_出力条件_全ページ出力する = new RString("全ページ出力する");
    private static final RString 出力条件_出力条件_識別コード指定で出力する = new RString("識別コード指定で出力する");
    private static final RString 出力条件_出力条件_指定日事由により出力する = new RString("指定日、事由により出力する");

    private AFABTA101BatchPrintProcessParameter batchPrintProcessParameter;
    private AfaMapperProvider mapperProvider;
    private IAFABTA101Mapper mapper;

    private Association association;

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(IAFABTA101Mapper.class);
    }

    //CHECKSTYLE IGNORE MethodLength FOR NEXT 170 LINES
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 170 LINES
    @Override
    protected void process() {

        List<RString> 出力条件Base = get出力条件Base();

        List<ReportOutputJokenhyoItem> items = new ArrayList<>();

        // 【選挙人名簿抄本】出力
        if (batchPrintProcessParameter.get選挙人名簿抄本出力有無()) {

            List<RString> 出力条件 = set選挙人名簿抄本出力条件(出力条件Base);

            items.add(getItem(出力条件, ReportIdKeys.選挙人名簿抄本, batchPrintProcessParameter.get選挙人名簿抄本出力数()));
            items.add(getItem(出力条件, ReportIdKeys.選挙人名簿抄本_縦覧用, batchPrintProcessParameter.get選挙人名簿抄本縦覧出力数()));
        }

        if (batchPrintProcessParameter.get永久選挙人名簿出力有無()) {
            items.add(getItem(set永久選挙人名簿出力条件(出力条件Base),
                    ReportIdKeys.永久選挙人名簿,
                    batchPrintProcessParameter.get永久選挙人名簿出力数()));
        }

        if (batchPrintProcessParameter.get選挙人名簿索引簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.選挙人名簿索引簿, batchPrintProcessParameter.get選挙人名簿索引簿出力数()));
            items.add(getItem(出力条件Base, ReportIdKeys.選挙人名簿索引簿_投票区別50音順, batchPrintProcessParameter.get選挙人名簿索引簿投票区別出力数()));
        }

        if (batchPrintProcessParameter.get登録者数リスト出力有無()) {
            List<RString> 出力条件 = set登録者数リスト出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.登録者数リスト, batchPrintProcessParameter.get登録者数リスト出力数()));

            if (batchPrintProcessParameter.get不在者投票資格者分作成有無()) {
                items.add(getItem(出力条件,
                        ReportIdKeys.不在者投票資格者分,
                        batchPrintProcessParameter.get不在者投票資格者分作成出力数()));
            }

            if (batchPrintProcessParameter.get不在資格対象者名簿作成有無()) {
                items.add(getItem(出力条件,
                        ReportIdKeys.不在資格対象者名簿,
                        batchPrintProcessParameter.get不在資格対象者名簿作成出力数()));
            }
        }

        if (batchPrintProcessParameter.get有榷者数調べ出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.有権者数調べ,
                    batchPrintProcessParameter.get有榷者数調べ出力数()));
        }

        if (batchPrintProcessParameter.get二重登録通知出力有無()) {
            List<RString> 出力条件 = set二重登録通知出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.二重登録通知書, batchPrintProcessParameter.get二重登録通知出力数()));

            if (batchPrintProcessParameter.get送付先宛名シール作成有無()) {
                items.add(getItem(出力条件,
                        ReportIdKeys.送付先宛名シール作成,
                        batchPrintProcessParameter.get送付先宛名シール作成出力数()));
            }

            if (batchPrintProcessParameter.get二重登録通知一覧表作成有無()) {
                items.add(getItem(出力条件,
                        ReportIdKeys.二重登録者通知一覧表,
                        batchPrintProcessParameter.get二重登録通知一覧表作成出力数()));
            }
        }

        if (batchPrintProcessParameter.get登録者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.新規登録者名簿, batchPrintProcessParameter.get登録者名簿出力数()));

            if (batchPrintProcessParameter.get縦覧用作成有無_登録者()) {
                items.add(getItem(出力条件Base,
                        ReportIdKeys.新規登録者名簿縦覧,
                        batchPrintProcessParameter.get登録者名簿縦覧用出力数()));
            }

            if (batchPrintProcessParameter.get新規登録者宛名シール作成有無()) {
                items.add(getItem(出力条件Base,
                        ReportIdKeys.新規登録者宛名シール,
                        batchPrintProcessParameter.get新規登録者宛名シール作成出力数()));
            }
        }

        if (batchPrintProcessParameter.get帰化対象者名簿出力有無()) {
            items.add(getItem(set帰化対象者名簿出力条件(出力条件Base),
                    ReportIdKeys.帰化対象者リスト,
                    batchPrintProcessParameter.get帰化対象者名簿出力数()));
        }

        if (batchPrintProcessParameter.get抹消者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.抹消者名簿,
                    batchPrintProcessParameter.get抹消者名簿出力数()));

            if (batchPrintProcessParameter.get縦覧用作成有無_抹消者()) {
                items.add(getItem(出力条件Base,
                        ReportIdKeys.抹消者名簿縦覧,
                        batchPrintProcessParameter.get抹消者名簿縦覧用出力数()));
            }
        }

        if (batchPrintProcessParameter.get居住要件抹消者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.居住要件抹消者名簿,
                    batchPrintProcessParameter.get居住要件抹消者名簿出力数()));
        }

        if (batchPrintProcessParameter.get表示者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.表示者名簿,
                    batchPrintProcessParameter.get表示者名簿出力数()));
        }

        if (batchPrintProcessParameter.get表示消除者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.表示消除者名簿,
                    batchPrintProcessParameter.get表示消除者名簿出力数()));
        }

        if (batchPrintProcessParameter.get規定年齢前名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.規定年齢前名簿,
                    batchPrintProcessParameter.get規定年齢前名簿出力数()));
            if (batchPrintProcessParameter.get規定年齢前シール作成有無()) {
                items.add(getItem(出力条件Base,
                        ReportIdKeys.規定年齢前名簿,
                        batchPrintProcessParameter.get規定年齢前シール作成出力数()));
            }
        }

        if (batchPrintProcessParameter.get規定年齢未到達者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.規定年齢未到達者名簿,
                    batchPrintProcessParameter.get規定年齢未到達者名簿出力数()));
        }

        if (batchPrintProcessParameter.get再転入者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.再転入者名簿,
                    batchPrintProcessParameter.get再転入者名簿出力数()));
        }

        if (batchPrintProcessParameter.get訂正者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.訂正者名簿,
                    batchPrintProcessParameter.get訂正者名簿出力数()));

        }

        if (batchPrintProcessParameter.get転出者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.転出者名簿,
                    batchPrintProcessParameter.get転出者名簿出力数()));
        }

        if (batchPrintProcessParameter.get登録停止者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.登録停止者名簿,
                    batchPrintProcessParameter.get登録停止者名簿出力数()));
        }

        if (batchPrintProcessParameter.get在外選挙人名簿抄本出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.在外選挙人名簿抄本,
                    batchPrintProcessParameter.get在外選挙人名簿抄本出力数()));
            items.add(getItem(出力条件Base,
                    ReportIdKeys.在外選挙人名簿抄本_縦覧用,
                    batchPrintProcessParameter.get在外選挙人名簿抄本縦覧用出力数()));
        }

        if (batchPrintProcessParameter.get在外投票資格者名簿出力有無()) {
            items.add(getItem(出力条件Base,
                    ReportIdKeys.AFAPRB309_在外投票資格者名簿,
                    batchPrintProcessParameter.get在外選挙人名簿抄本出力数()));
        }
        ReportOutputJokenhyoFactory.createInstance(items).print();
    }

    private List<RString> get出力条件Base() {
        List<RString> 出力条件Base = new ArrayList();
        RString 抄本名 = mapper.selectShohonName(batchPrintProcessParameter.get抄本番号());
        出力条件Base.add(get出力条件(出力条件_抄本名, 抄本名));
        出力条件Base.add(get出力条件(出力条件_基準日, batchPrintProcessParameter.get基準日()));
        出力条件Base.add(get出力条件(出力条件_登録日, batchPrintProcessParameter.get登録日()));
        出力条件Base.add(get出力条件(出力条件_転出期限日, batchPrintProcessParameter.get転出期限日()));
        出力条件Base.add(get出力条件(出力条件_転入期限日, batchPrintProcessParameter.get転入期限日()));
        出力条件Base.add(get出力条件(出力条件_年齢期限日, batchPrintProcessParameter.get年齢期限日()));
        return 出力条件Base;
    }

    private ReportOutputJokenhyoItem getItem(List<RString> 出力条件, ReportIdKeys reportIdKeys, Integer 出力数) {
        return new ReportOutputJokenhyoItem(
                reportIdKeys.value(),
                association.get地方公共団体コード().getColumnValue(),
                association.get市町村名(),
                new RString(batchPrintProcessParameter.getジョブ番号().toString()),
                reportIdKeys.getReportName(),
                new RString(出力数 == null ? 0 : 出力数),
                CSV_出力有無,
                reportIdKeys.getEucFileName(),
                出力条件);
    }

    private List<RString> set選挙人名簿抄本出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_投票区, batchPrintProcessParameter.get投票区From(), batchPrintProcessParameter.get投票区To()));

        return 出力条件;
    }

    private List<RString> set永久選挙人名簿出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);

        // 【出力条件】出力条件
        if (new RString("1").equals(batchPrintProcessParameter.get出力条件())) {
            出力条件.add(get出力条件(出力条件_出力条件, 出力条件_出力条件_全ページ出力する));
        } else if (new RString("2").equals(batchPrintProcessParameter.get出力条件())) {
            出力条件.add(get出力条件(出力条件_出力条件, 出力条件_出力条件_識別コード指定で出力する));
        } else {
            出力条件.add(get出力条件(出力条件_出力条件, 出力条件_出力条件_指定日事由により出力する));
        }
        // 【識別コード】識別コード
        出力条件.add(get出力条件(出力条件_識別コード, batchPrintProcessParameter.get識別コード()));
        // 【指定日】指定日
        出力条件.add(get出力条件(出力条件_指定日, batchPrintProcessParameter.get指定日()));
        // 【異動事由】異動事由
        出力条件.add(get出力条件(出力条件_異動事由, batchPrintProcessParameter.get異動事由()));

        return 出力条件;

    }

    private List<RString> set登録者数リスト出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_時点日, batchPrintProcessParameter.get時点()));

        return 出力条件;
    }

    private List<RString> set二重登録通知出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get発行番号の号()));
        出力条件.add(get出力条件(出力条件_転入期間, batchPrintProcessParameter.get転入期間()));
        return 出力条件;
    }

    private List<RString> set帰化対象者名簿出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_帰化期間, batchPrintProcessParameter.get帰化期間()));
        return 出力条件;
    }

    private RString get出力条件(RString title, RString value) {
        return title.concat(NullHandler.getNullToRString(value));
    }

    private RString get出力条件(RString title, FlexibleDate value) {
        return title.concat(value == null ? RString.EMPTY : value.wareki().toDateString());
    }

    private RString get出力条件(RString title, RString valueFrom, RString valueTo) {
        if (RString.isNullOrEmpty(valueFrom) && RString.isNullOrEmpty(valueTo)) {
            return get出力条件(title, RString.EMPTY);
        }
        return get出力条件(title, NullHandler.getNullToRString(valueFrom).concat("～").concat(NullHandler.getNullToRString(valueTo)));
    }

    private RString get出力条件(RString title, List<FlexibleDate> value) {
        if (value == null || value.isEmpty()) {
            return get出力条件(title, RString.EMPTY);
        }
        FlexibleDate valueFrom = value.get(0);
        FlexibleDate valueTo = value.get(1);
        return get出力条件(title,
                valueFrom == null ? RString.EMPTY : valueFrom.wareki().toDateString(),
                valueTo == null ? RString.EMPTY : valueTo.wareki().toDateString());
    }

}
