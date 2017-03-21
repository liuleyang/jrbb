package jp.co.ndensan.reams.af.afa.service.report.AFAPRE502;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.FuzaishaTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaIchiran;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE502.FuzaishaTohyoshaListPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE502.FuzaishaTohyoshaListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 不在者投票者一覧表
 *
 * @reamsid_L AF-0270-032 wangl
 */
public class FuzaishaTohyoshaListPrintService {

    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");
    private static final int 改ページ数 = 30;

    /**
     * 不在者投票者一覧表
     *
     * @param fuzaihsaNippoList List<FuzaishaTohyoshaListParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<FuzaishaTohyoshaListParam> fuzaihsaNippoList) {
        try (ReportManager reportManager = new ReportManager()) {
            FuzaishaTohyoshaListPorperty property = new FuzaishaTohyoshaListPorperty();
            try (ReportAssembler<KijitsumaeTohyoshaListReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<KijitsumaeTohyoshaListReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
                if (null != fuzaihsaNippoList && !fuzaihsaNippoList.isEmpty()) {
                    List<FuzaishaTohyoshaListParam> 不在者投票者リスト = get合計(fuzaihsaNippoList);
                    for (FuzaishaTohyoshaListParam param : 不在者投票者リスト) {
                        FuzaishaTohyoshaListReport report = toReports(param, 帳票共通ヘッダー);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static FuzaishaTohyoshaListReport toReports(FuzaishaTohyoshaListParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new FuzaishaTohyoshaListReport(param, 帳票共通ヘッダー);
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通_不在者投票者一覧 = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通_不在者投票者一覧.set選挙名称(定時登録.toRString());
        帳票共通_不在者投票者一覧.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通_不在者投票者一覧;
    }

    /**
     * 不在者投票者一覧表
     *
     * @param 不在者投票者リスト List<FuzaishaTohyoshaListParam>
     * @return List<FuzaishaTohyoshaListParam>
     */
    public List<FuzaishaTohyoshaListParam> get合計(List<FuzaishaTohyoshaListParam> 不在者投票者リスト) {
        RString 同区書式１ = new RString("【");
        RString 同区書式２ = new RString("投票区】　　男");
        RString 同区書式３ = new RString("　　女");
        RString 同区書式４ = new RString("　　計");
        RString 全区書式１ = new RString("　　　【合計】　　男");
        RString 全区書式２ = new RString("　　女");
        RString 全区書式３ = new RString("　　計");
        int 同区集計_男 = 0;
        int 同区集計_女 = 0;
        int 全区集計_男 = 0;
        int 全区集計_女 = 0;
        int ページ = 1;
        int 倍数 = 1;
        RString 合計エリア１;
        RString 合計エリア２;
        RString 投票区コード_OLD = RString.EMPTY;
        for (int i = 0, j = 0; i < 不在者投票者リスト.size(); i++, j++) {
            KijitsumaeTohyoshaIchiran 不在者投票者 = 不在者投票者リスト.get(i).get不在者投票者明細();
            RString 性別コード = 不在者投票者.get性別コード();
            RString 性別 = Gender.toValue(性別コード).getCommonName();
            RString 投票区コード_NEW = 不在者投票者.get投票区コード();
            if (i == 0) {
                if (性別.equals(性別_男)) {
                    同区集計_男++;
                }
                if (性別.equals(性別_女)) {
                    同区集計_女++;
                }
                投票区コード_OLD = 投票区コード_NEW;
            } else {
                if (投票区コード_OLD.equals(投票区コード_NEW)) {
                    if (性別.equals(性別_男)) {
                        同区集計_男++;
                    }
                    if (性別.equals(性別_女)) {
                        同区集計_女++;
                    }
                    if ((j + 1) % 改ページ数 == 0) {
                        不在者投票者リスト.get(i).setページ(new RString(ページ));
                        ページ++;
                    }
                } else {
                    不在者投票者リスト.get(i - 1).setページ(new RString(ページ));
                    ページ = 1;
                    j = 0;
                    合計エリア１ = 同区書式１
                            .concat(不在者投票者リスト.get(i - 1).get不在者投票者明細().get投票区名())
                            .concat(同区書式２)
                            .concat(doZZZ_ZZ9編集(new RString(同区集計_男)))
                            .concat(同区書式３)
                            .concat(doZZZ_ZZ9編集(new RString(同区集計_女)))
                            .concat(同区書式４)
                            .concat(doZZZ_ZZ9編集(new RString(同区集計_男 + 同区集計_女)));
                    不在者投票者リスト.get(i - 1).set合計エリア１(合計エリア１);
                    if (性別.equals(性別_男)) {
                        同区集計_男 = 1;
                        同区集計_女 = 0;
                    }
                    if (性別.equals(性別_女)) {
                        同区集計_女 = 1;
                        同区集計_男 = 0;
                    }
                    投票区コード_OLD = 投票区コード_NEW;
                }
            }
            if (性別.equals(性別_男)) {
                全区集計_男++;
            }
            if (性別.equals(性別_女)) {
                全区集計_女++;
            }
            if (i == 不在者投票者リスト.size() - 1) {
                合計エリア１ = 同区書式１
                        .concat(不在者投票者リスト.get(i).get不在者投票者明細().get投票区名())
                        .concat(同区書式２)
                        .concat(doZZZ_ZZ9編集(new RString(同区集計_男)))
                        .concat(同区書式３)
                        .concat(doZZZ_ZZ9編集(new RString(同区集計_女)))
                        .concat(同区書式４)
                        .concat(doZZZ_ZZ9編集(new RString(同区集計_男 + 同区集計_女)));
                不在者投票者リスト.get(i).set合計エリア１(合計エリア１);
                合計エリア２ = 全区書式１
                        .concat(doZZZ_ZZ9編集(new RString(全区集計_男)))
                        .concat(全区書式２)
                        .concat(doZZZ_ZZ9編集(new RString(全区集計_女)))
                        .concat(全区書式３)
                        .concat(doZZZ_ZZ9編集(new RString(全区集計_男 + 全区集計_女)));
                不在者投票者リスト.get(i).set合計エリア2(合計エリア２);
                不在者投票者リスト.get(i).setページ(new RString(ページ));
            }
            不在者投票者リスト.get(i).set施設名(get施設名(不在者投票者.get施設コード()));
            不在者投票者リスト.get(i).set施設種別(get施設種別(不在者投票者.get施設コード()));
            不在者投票者リスト.get(i).set施設種別名称(get施設種別名称(不在者投票者.get施設コード()));
            不在者投票者リスト.get(i).set施設種別略称(get施設種別略称(不在者投票者.get施設コード()));
        }

        return 不在者投票者リスト;
    }

    private RString get施設名(RString 施設コード) {
        ShisetsuManager shisetsuManager = ShisetsuManager.createInstance();
        return shisetsuManager.get施設By施設コード(施設コード).get施設名称();
    }

    private RString get施設種別(RString 施設コード) {
        ShisetsuManager shisetsuManager = ShisetsuManager.createInstance();
        return shisetsuManager.get施設By施設コード(施設コード).get施設種別().getColumnValue();
    }

    private RString get施設種別名称(RString 施設コード) {
        ShisetsuManager shisetsuManager = ShisetsuManager.createInstance();
        Code 施設種別 = shisetsuManager.get施設By施設コード(施設コード).get施設種別();
        return CodeMasterNoOption.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設種別);
    }

    private RString get施設種別略称(RString 施設コード) {
        ShisetsuManager shisetsuManager = ShisetsuManager.createInstance();
        Code 施設種別 = shisetsuManager.get施設By施設コード(施設コード).get施設種別();
        return CodeMasterNoOption.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設種別);
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

    }
}
