/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.ReportOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * バッチ出力条件表作成のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
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
    private static final RString 出力条件_年齢期限日 = new RString("【年齢期限日】");
    private static final RString 出力条件_コロン = new RString("：");
    private static final RString 出力条件_投票日 = new RString("【投票日】");
    private static final RString 出力条件_研修用データも作成有無 = new RString("【研修用データも作成有無】");
    private static final RString 出力条件_研修用データも_作成 = new RString("作成");
    private static final RString 出力条件_研修用データも_作成しない = new RString("作成しない");
    private static final RString 出力条件_選挙一覧_NO = new RString("【選挙一覧リスト.No】");
    private static final RString 出力条件_選挙一覧_レベル = new RString("【選挙一覧リスト.レベル】");
    private static final RString 出力条件_選挙一覧_選挙名 = new RString("【選挙一覧リスト.選挙名】");
    private static final RString 出力条件_選挙一覧_略称 = new RString("【選挙一覧リスト.略称】");
    private static final RString 出力条件_選挙一覧_マーク = new RString("【選挙一覧リスト.マーク】");
    private static final RString 出力条件_選挙一覧_基準日 = new RString("【選挙一覧リスト.基準日】");
    private static final RString 出力条件_選挙一覧_受付開始日 = new RString("【選挙一覧リスト.受付開始日】");
    private static final RString 出力条件_選挙一覧_告示公示日 = new RString("【選挙一覧リスト.告示（公示）日】");
    private static final RString 出力条件_選挙一覧_登録日 = new RString("【選挙一覧リスト.登録日】");
    private static final RString 出力条件_選挙一覧_転出期限日 = new RString("【選挙一覧リスト.転出期限日】");
    private static final RString 出力条件_選挙一覧_転入期限日 = new RString("【選挙一覧リスト.転入期限日】");
    private static final RString 出力条件_出力条件_全ページ出力する = new RString("全ページ出力する");
    private static final RString 出力条件_出力条件_識別コード指定で出力する = new RString("識別コード指定で出力する");
    private static final RString 出力条件_出力条件_指定日事由により出力する = new RString("指定日、事由により出力する");

    private AFABTB101BatchPrintProcessParameter batchPrintProcessParameter;
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
        if (batchPrintProcessParameter.get選挙人名簿抄本出力有無()) {
            List<RString> 出力条件 = set選挙人名簿抄本出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.選挙人名簿抄本, batchPrintProcessParameter.get選挙人名簿抄本出力数()));
            items.add(getItem(出力条件, ReportIdKeys.選挙人名簿抄本_縦覧用, batchPrintProcessParameter.get選挙人名簿抄本縦覧出力数()));
        }
        if (batchPrintProcessParameter.get永久選挙人名簿出力有無()) {
            List<RString> 出力条件 = set永久選挙人名簿出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.永久選挙人名簿, batchPrintProcessParameter.get永久選挙人名簿出力数()));
        }
        if (batchPrintProcessParameter.get選挙人名簿索引簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.選挙人名簿索引簿, batchPrintProcessParameter.get選挙人名簿索引簿出力数()));
            items.add(getItem(出力条件Base, ReportIdKeys.選挙人名簿索引簿_投票区別50音順,
                    batchPrintProcessParameter.get選挙人名簿索引簿投票区別出力数()));
        }
        if (batchPrintProcessParameter.get登録者数リスト出力有無()) {
            List<RString> 出力条件 = set登録者数リスト出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.登録者数リスト, batchPrintProcessParameter.get登録者数リスト出力数()));
            if (batchPrintProcessParameter.get不在者投票資格者分作成有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.不在者投票資格者分, batchPrintProcessParameter.get不在者投票資格者分作成出力数()));
            }
            if (batchPrintProcessParameter.get不在資格対象者名簿作成有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.不在資格対象者名簿, batchPrintProcessParameter.get不在資格対象者名簿作成出力数()));
            }
        }
        if (batchPrintProcessParameter.get有榷者数調べ出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.有権者数調べ, batchPrintProcessParameter.get有榷者数調べ出力数()));
        }
        if (batchPrintProcessParameter.get二重登録通知出力有無() && batchPrintProcessParameter.get二重登録系の帳票作成条件判断()) {
            List<RString> 出力条件 = set二重登録通知出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.二重登録通知書, batchPrintProcessParameter.get二重登録通知出力数()));
            if (batchPrintProcessParameter.get送付先宛名シール作成有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.送付先宛名シール作成, batchPrintProcessParameter.get送付先宛名シール出力数()));
            }
            if (batchPrintProcessParameter.get二重登録通知一覧表作成有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.二重登録者通知一覧表,
                        batchPrintProcessParameter.get二重登録通知一覧表作成出力数()));
            }
        }
        if (batchPrintProcessParameter.get二重登録調査票有無()) {
            List<RString> 出力条件 = set二重登録調査票出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.二重登録調査票_照会, batchPrintProcessParameter.get二重登録調査票照会出力数()));
            items.add(getItem(出力条件, ReportIdKeys.二重登録調査票_回答, batchPrintProcessParameter.get二重登録調査票回答出力数()));
            if (batchPrintProcessParameter.get送付先宛名シール作成有無_調査票()) {
                items.add(getItem(出力条件, getReportIdKeys(), batchPrintProcessParameter.get二重登録調査票回答出力数()));
            }
            if (batchPrintProcessParameter.get二重調査票一覧表作成有無_調査票()) {
                items.add(getItem(出力条件, ReportIdKeys.二重登録調査一覧表, batchPrintProcessParameter.get二重調査票一覧表作成_調査票数()));
            }
        }
        if (batchPrintProcessParameter.get登録者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.新規登録者名簿, batchPrintProcessParameter.get登録者名簿出力数()));
            if (batchPrintProcessParameter.get縦覧用作成有無_登録者()) {
                items.add(getItem(出力条件Base, ReportIdKeys.新規登録者名簿縦覧, batchPrintProcessParameter.get登録者名簿縦覧出力数()));
            }
            if (batchPrintProcessParameter.get新規登録者宛名シール作成有無()) {
                items.add(getItem(出力条件Base, ReportIdKeys.新規登録者宛名シール, batchPrintProcessParameter.get新規登録者宛名シール作成数()));
            }
        }
        if (batchPrintProcessParameter.get帰化対象者名簿出力有無()) {
            items.add(getItem(set帰化対象者名簿出力条件(出力条件Base), ReportIdKeys.帰化対象者リスト,
                    batchPrintProcessParameter.get帰化対象者名簿出力数()));
        }
        if (batchPrintProcessParameter.get抹消者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.抹消者名簿, batchPrintProcessParameter.get抹消者名簿出力数()));
            if (batchPrintProcessParameter.get縦覧用作成有無_抹消者()) {
                items.add(getItem(出力条件Base, ReportIdKeys.抹消者名簿縦覧, batchPrintProcessParameter.get抹消者名簿縦覧用出力数()));
            }
        }
        if (batchPrintProcessParameter.get居住要件抹消者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.居住要件抹消者名簿, batchPrintProcessParameter.get居住要件抹消者名簿出力数()));
        }
        if (batchPrintProcessParameter.get表示者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.表示者名簿, batchPrintProcessParameter.get表示者名簿出力数()));
        }
        if (batchPrintProcessParameter.get表示消除者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.表示消除者名簿, batchPrintProcessParameter.get表示消除者名簿出力数()));
        }
        if (batchPrintProcessParameter.get規定年齢未到達者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.規定年齢未到達者名簿, batchPrintProcessParameter.get規定年齢未到達者名簿出力数()));
        }
        if (batchPrintProcessParameter.get再転入者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.再転入者名簿, batchPrintProcessParameter.get再転入者名簿出力数()));
        }
        if (batchPrintProcessParameter.get訂正者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.訂正者名簿, batchPrintProcessParameter.get訂正者名簿出力数()));
        }
        if (batchPrintProcessParameter.get転出者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.転出者名簿, batchPrintProcessParameter.get転出者名簿出力数()));
        }
        if (batchPrintProcessParameter.get登録停止者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.登録停止者名簿, batchPrintProcessParameter.get登録停止者名簿出力数()));
        }
        if (batchPrintProcessParameter.get在外選挙人名簿抄本出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.在外選挙人名簿抄本, batchPrintProcessParameter.get在外選挙人名簿抄本出力数()));
            items.add(getItem(出力条件Base, ReportIdKeys.在外選挙人名簿抄本_縦覧用,
                    batchPrintProcessParameter.get在外選挙人名簿抄本縦覧用出力数()));
        }
        if (batchPrintProcessParameter.get在外投票資格者名簿出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.AFAPRB309_在外投票資格者名簿, batchPrintProcessParameter.get在外選挙人名簿抄本出力数()));
        }
        ReportOutputJokenhyoFactory.createInstance(items).print();
    }

    private List<RString> set帰化対象者名簿出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_帰化期間, batchPrintProcessParameter.get帰化期間()));
        return 出力条件;
    }

    private ReportIdKeys getReportIdKeys() {
        ReportIdKeys keys;
        if (("12").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
            keys = ReportIdKeys.送付先宛名シール作成;
        } else {
            keys = ReportIdKeys.送付先宛名シール作成_21;
        }
        return keys;
    }

    private List<RString> set登録者数リスト出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_時点日, batchPrintProcessParameter.get時点()));

        return 出力条件;
    }

    private List<RString> set選挙人名簿抄本出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_投票区, batchPrintProcessParameter.get投票区From(), batchPrintProcessParameter.get投票区To()));
        return 出力条件;
    }

    private List<RString> set永久選挙人名簿出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        if (new RString("1").equals(batchPrintProcessParameter.get出力条件())) {
            出力条件.add(get出力条件(出力条件_出力条件, 出力条件_出力条件_全ページ出力する));
        } else if (new RString("2").equals(batchPrintProcessParameter.get出力条件())) {
            出力条件.add(get出力条件(出力条件_出力条件, 出力条件_出力条件_識別コード指定で出力する));
        } else {
            出力条件.add(get出力条件(出力条件_出力条件, 出力条件_出力条件_指定日事由により出力する));
        }
        出力条件.add(get出力条件(出力条件_識別コード, batchPrintProcessParameter.get識別コード()));
        出力条件.add(get出力条件(出力条件_指定日, batchPrintProcessParameter.get指定日()));
        出力条件.add(get出力条件(出力条件_異動事由, batchPrintProcessParameter.get異動事由()));

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

    private List<RString> set二重登録通知出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get発行日()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get発行番号の第()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get発行番号の番号()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get発行番号の号()));
        出力条件.add(get出力条件(出力条件_転入期間, batchPrintProcessParameter.get転入期間()));
        return 出力条件;
    }

    private List<RString> set二重登録調査票出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_発行日, batchPrintProcessParameter.get発行日_調査票()));
        出力条件.add(get出力条件(出力条件_発行番号の第, batchPrintProcessParameter.get発行番号の第_調査票()));
        出力条件.add(get出力条件(出力条件_発行番号の番号, batchPrintProcessParameter.get発行番号の番号_調査票()));
        出力条件.add(get出力条件(出力条件_発行番号の号, batchPrintProcessParameter.get発行番号の号_調査票()));
        出力条件.add(get出力条件(出力条件_転入期間, batchPrintProcessParameter.get転入期間_調査票()));
        return 出力条件;
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
        出力条件Base.add(get出力条件(出力条件_年齢期限日, batchPrintProcessParameter.get年齢期限日()));
        Boolean 研修用データも作成有無 = batchPrintProcessParameter.get研修用データ作成有無();
        if (研修用データも作成有無) {
            出力条件Base.add(get出力条件(出力条件_研修用データも作成有無, 出力条件_研修用データも_作成));
        } else {
            出力条件Base.add(get出力条件(出力条件_研修用データも作成有無, 出力条件_研修用データも_作成しない));
        }
        for (AFABTB101Senkyoichiran 選択一覧 : batchPrintProcessParameter.get選択一覧リスト()) {
            SenkyoNo 選挙一覧リストNo = 選択一覧.getSenkyoNo();
            if (選挙一覧リストNo == null) {
                出力条件Base.add(get出力条件(出力条件_選挙一覧_NO, RString.EMPTY));
            } else {
                出力条件Base.add(get出力条件(出力条件_選挙一覧_NO, new RString(選挙一覧リストNo.toString())));
            }
            if (選択一覧.getSenkyoLevel() == null) {
                出力条件Base.add(get出力条件(出力条件_選挙一覧_レベル, RString.EMPTY));
            } else {
                出力条件Base.add(get出力条件(出力条件_選挙一覧_レベル, 選択一覧.getSenkyoLevelMeisho()));
            }
            出力条件Base.add(get出力条件(出力条件_選挙一覧_選挙名, 選択一覧.getSenkyoName()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_略称, 選択一覧.getSenkyoRyakusho()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_マーク, 選択一覧.getSenkyoMark()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_基準日, 選択一覧.getKijunYMD()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_受付開始日, 選択一覧.getTohyoUketsukeYMD()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_告示公示日, 選択一覧.getKokujiYMD()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_登録日, 選択一覧.getMeiboTorokuYMD()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_転出期限日, 選択一覧.getTenshutsuKigenYMD()));
            出力条件Base.add(get出力条件(出力条件_選挙一覧_転入期限日, 選択一覧.getTennyuKigenYMD()));
        }
        return 出力条件Base;
    }

}
