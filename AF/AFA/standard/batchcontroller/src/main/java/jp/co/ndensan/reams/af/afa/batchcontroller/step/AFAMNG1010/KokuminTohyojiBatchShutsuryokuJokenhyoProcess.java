/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper;
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
 *
 * @reamsid_L AF-0030-020 qiuxy
 */
public class KokuminTohyojiBatchShutsuryokuJokenhyoProcess extends SimpleBatchProcessBase {

    private static final RString CSV_出力有無 = new RString("あり");
    private static final RString 出力条件_抄本名 = new RString("【抄本名】");
    private static final RString 出力条件_投票日 = new RString("【投票日】");
    private static final RString 出力条件_基準日 = new RString("【基準日】");
    private static final RString 出力条件_名簿登録日 = new RString("【名簿登録日】");
    private static final RString 出力条件_年齢到達日 = new RString("【年齢到達日】");
    private static final RString 出力条件_特定期間開始日 = new RString("【特定期間開始日】");
    private static final RString 出力条件_特定期限日 = new RString("【特定期限日】");
    private static final RString 出力条件_受付開始日 = new RString("【受付開始日】");
    private static final RString 出力条件_改正案一覧リスト_NO = new RString("【改正案一覧リスト.No】");
    private static final RString 出力条件_改正案一覧リスト_改正案 = new RString("【改正案一覧リスト.改正案】");
    private static final RString 出力条件_改正案一覧リスト_略称 = new RString("【改正案一覧リスト.略称】");
    private static final RString 出力条件_発行番号の第 = new RString("【  発行番号の第】");
    private static final RString 出力条件_発行番号の番号 = new RString("【  発行番号の番号】");
    private static final RString 出力条件_発行番号の号 = new RString("【  発行番号の号】");
    private static final RString 出力条件_時点日 = new RString("【  時点日】");
    private static final RString 出力条件_発行日 = new RString("【  発行日】");
    private static final RString 出力条件_抹消日 = new RString("【抹消日】");
    private static final RString 出力条件_コロン = new RString("：");

    private AFABTG101BatchPrintProcessParameter batchPrintProcessParameter;
    private AfaMapperProvider mapperProvider;
    private IAFABTB101Mapper mapper;
    private Association association;

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(IAFABTB101Mapper.class);
    }

    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 150 LINES
    @Override
    protected void process() {
        List<RString> 出力条件Base = get出力条件Base();
        List<ReportOutputJokenhyoItem> items = new ArrayList<>();
        if (batchPrintProcessParameter.get投票人名簿抄本出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.投票人名簿抄本, batchPrintProcessParameter.get投票人名簿抄本出力数()));
        }
        if (batchPrintProcessParameter.get投票人名簿登録者数リスト出力有無()) {
            List<RString> 出力条件 = set投票人名簿登録者数リスト出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.AFAPRG103_投票人名簿登録者数リスト, batchPrintProcessParameter.get投票人名簿登録者数リスト出力数()));
            if (batchPrintProcessParameter.get不在者投票資格者分出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.登録者数リスト不在者投票資格者分, batchPrintProcessParameter.get不在者投票資格者分出力数()));
            }
            if (batchPrintProcessParameter.get不在資格対象者名簿出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.不在資格対象者名簿, batchPrintProcessParameter.get不在資格対象者名簿出力数()));
            }
        }
        if (batchPrintProcessParameter.get一号資格登録通知出力有無()) {
            List<RString> 出力条件 = set一号資格登録通知出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.AFAPRG111_1号資格登録通知_様式1, batchPrintProcessParameter.get一号資格登録通知出力数()));
            if (batchPrintProcessParameter.get一号資格登録通知送付先宛名シール出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get一号資格登録通知送付先宛名シール出力数()));
            }
            if (batchPrintProcessParameter.get一号資格登録通知一覧表出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.AFAPRG112_1号資格登録通知一覧表, batchPrintProcessParameter.get一号資格登録通知一覧表出力数()));
            }
        }
        if (batchPrintProcessParameter.get二号資格調査票出力有無()) {
            List<RString> 出力条件 = set二号資格調査票出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.AFAPRG113_2号資格調査票_照会, batchPrintProcessParameter.get二号資格調査票照会出力数()));
            items.add(getItem(出力条件, ReportIdKeys.AFAPRG114_2号資格調査票_回答, batchPrintProcessParameter.get二号資格調査票回答出力数()));
            if (batchPrintProcessParameter.get二号資格調査票送付先宛名シール出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get二号資格調査票送付先宛名シール出力数()));
            }
            if (batchPrintProcessParameter.get二号資格調査一覧表出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.AFAPRG112_2号資格調査一覧表, batchPrintProcessParameter.get二号資格調査一覧表出力数()));
            }
        }
        if (batchPrintProcessParameter.get二号資格候補者一覧表出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.AFAPRG116_2号資格候補者一覧表, batchPrintProcessParameter.get二号資格候補者一覧表出力数()));
        }
        if (batchPrintProcessParameter.get補正登録者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.AFAPRA105_補正登録者名簿, batchPrintProcessParameter.get補正登録者名簿出力数()));
            if (batchPrintProcessParameter.get補正登録者名簿縦覧用出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.AFAPRA106_補正登録者名簿縦覧, batchPrintProcessParameter.get補正登録者名簿縦覧用出力数()));
            }
            if (batchPrintProcessParameter.get補正登録者送付先宛名シール出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get補正登録者送付先宛名シール出力数()));
            }
        }
        if (batchPrintProcessParameter.get抹消者名簿出力有無()) {
            List<RString> 出力条件 = set抹消者名簿出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.抹消者名簿国民, batchPrintProcessParameter.get抹消者名簿出力数()));
            if (batchPrintProcessParameter.get抹消者名簿縦覧用出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.抹消者名簿縦覧国民, batchPrintProcessParameter.get抹消者名簿縦覧用出力数()));
            }
        }
        if (batchPrintProcessParameter.get訂正者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.訂正者名簿国民, batchPrintProcessParameter.get訂正者名簿出力数()));
        }
        if (batchPrintProcessParameter.get未登録者抹消通知出力有無()) {
            List<RString> 出力条件 = set未登録者抹消通知出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.未登録者抹消通知, batchPrintProcessParameter.get未登録者抹消通知出力数()));
            if (batchPrintProcessParameter.get未登録者抹消通知一覧出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.未登録者抹消通知一覧表, batchPrintProcessParameter.get未登録者抹消通知一覧出力数()));
            }
            if (batchPrintProcessParameter.get未登録者抹消通知送付先宛名シール出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get未登録者抹消通知送付先宛名シール出力数()));
            }
        }
        if (batchPrintProcessParameter.get国内転入者調査票出力有無()) {
            List<RString> 出力条件 = set国内転入者調査票出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.国内転入者調査票照会, batchPrintProcessParameter.get国内転入者調査票照会出力数()));
            items.add(getItem(出力条件, ReportIdKeys.国内転入者調査票回答, batchPrintProcessParameter.get国内転入者調査票回答出力数()));
            if (batchPrintProcessParameter.get国内転入者調査一覧表出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.国内転入者調査一覧表, batchPrintProcessParameter.get国内転入者調査一覧表出力数()));
            }
            if (batchPrintProcessParameter.get国内転入者調査票送付先宛名シール出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get国内転入者調査票送付先宛名シール出力数()));
            }
        }
        if (batchPrintProcessParameter.get国外転入者調査票出力有無()) {
            List<RString> 出力条件 = set国外転入者調査票出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.国外転入者調査票照会, batchPrintProcessParameter.get国外転入者調査票照会出力数()));
            items.add(getItem(出力条件, ReportIdKeys.国外転入者調査票回答, batchPrintProcessParameter.get国外転入者調査票回答出力数()));
            if (batchPrintProcessParameter.get国外転入者調査一覧表出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.国内転入者調査一覧表, batchPrintProcessParameter.get国外転入者調査一覧表出力数()));
            }
            if (batchPrintProcessParameter.get国外転入者調査票送付先宛名シール出力有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get国外転入者調査票送付先宛名シール出力数()));
            }
        }
        if (batchPrintProcessParameter.get在外投票人名簿抄本出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.AFAPRB300_在外投票人名簿抄本, batchPrintProcessParameter.get在外投票人名簿抄本出力数()));
        }
        if (batchPrintProcessParameter.get在外投票資格者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.AFAPRB309_在外投票資格者名簿, batchPrintProcessParameter.get在外投票資格者名簿出力数()));
        }
        if (batchPrintProcessParameter.get在外投票管理表出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.AFAPRB310_在外投票管理表, batchPrintProcessParameter.get在外投票管理表出力数()));
        }
        ReportOutputJokenhyoFactory.createInstance(items).print();
    }

    private List<RString> get出力条件Base() {
        List<RString> 出力条件Base = new ArrayList();
        ShohonNo 抄本番号 = batchPrintProcessParameter.get抄本番号();
        RString 抄本名 = RString.EMPTY;
        RString shohonNo = RString.EMPTY;
        if (抄本番号 != null) {
            抄本名 = mapper.selectShohonName(batchPrintProcessParameter.get抄本番号());
            shohonNo = new RString(抄本番号.toString()).concat(出力条件_コロン);
        }
        出力条件Base.add(get出力条件(出力条件_抄本名, shohonNo.concat(抄本名)));
        出力条件Base.add(get出力条件(出力条件_投票日, batchPrintProcessParameter.get投票日()));
        出力条件Base.add(get出力条件(出力条件_基準日, batchPrintProcessParameter.get基準日()));
        出力条件Base.add(get出力条件(出力条件_名簿登録日, batchPrintProcessParameter.get名簿登録日()));
        出力条件Base.add(get出力条件(出力条件_年齢到達日, batchPrintProcessParameter.get年齢到達日()));
        出力条件Base.add(get出力条件(出力条件_特定期間開始日, batchPrintProcessParameter.get特定期間開始日()));
        出力条件Base.add(get出力条件(出力条件_特定期限日, batchPrintProcessParameter.get特定期限日()));
        出力条件Base.add(get出力条件(出力条件_受付開始日, batchPrintProcessParameter.get受付開始日()));
        for (AFABTB101Senkyoichiran 選挙一覧 : batchPrintProcessParameter.get選挙一覧リスト()) {
            if (選挙一覧.getSenkyoNo() == null) {
                出力条件Base.add(get出力条件(出力条件_改正案一覧リスト_NO, RString.EMPTY));
            } else {
                出力条件Base.add(get出力条件(出力条件_改正案一覧リスト_NO, new RString(選挙一覧.getSenkyoNo().toString())));
            }
            出力条件Base.add(get出力条件(出力条件_改正案一覧リスト_改正案, 選挙一覧.getSenkyoName()));
            出力条件Base.add(get出力条件(出力条件_改正案一覧リスト_略称, 選挙一覧.getSenkyoRyakusho()));
        }
        return 出力条件Base;
    }

    private RString get出力条件(RString title, RString value) {
        return title.concat(NullHandler.getNullToRString(value));
    }

    private RString get出力条件(RString title, FlexibleDate value) {
        return title.concat(value == null ? RString.EMPTY : value.wareki().toDateString());
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

    private List<RString> set投票人名簿登録者数リスト出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_時点日, batchPrintProcessParameter.get時点日()));
        return 出力条件;
    }

    private List<RString> set一号資格登録通知出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get一号資格登録通知発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get一号資格登録通知発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get一号資格登録通知発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get一号資格登録通知発行番号の号()));
        return 出力条件;
    }

    private List<RString> set二号資格調査票出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get二号資格調査票発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get二号資格調査票発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get二号資格調査票発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get二号資格調査票発行番号の号()));
        return 出力条件;
    }

    private List<RString> set未登録者抹消通知出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get未登録者抹消通知発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get未登録者抹消通知発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get未登録者抹消通知発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get未登録者抹消通知発行番号の号()));
        return 出力条件;
    }

    private List<RString> set国内転入者調査票出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get国内転入者調査票発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get国内転入者調査票発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get国内転入者調査票発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get国内転入者調査票発行番号の号()));
        return 出力条件;
    }

    private List<RString> set国外転入者調査票出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get国外転入者調査票発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get国外転入者調査票発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get国外転入者調査票発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get国外転入者調査票発行番号の号()));
        return 出力条件;
    }

    private List<RString> set抹消者名簿出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_抹消日, batchPrintProcessParameter.get抹消日()));
        return 出力条件;
    }
}
