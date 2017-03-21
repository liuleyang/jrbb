package jp.co.ndensan.reams.af.afa.service.report.AFAPRE502;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaIchiran;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE502.KijitsumaeTohyoshaListPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE502.KijitsumaeTohyoshaListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaListPrintService {

    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");

    /**
     * 期日前投票者一覧表
     *
     * @param fuzaihsaNippoList List<KijitsumaeTohyoshaListParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<KijitsumaeTohyoshaListParam> fuzaihsaNippoList) {
        try (ReportManager reportManager = new ReportManager()) {
            KijitsumaeTohyoshaListPorperty property = new KijitsumaeTohyoshaListPorperty();
            try (ReportAssembler<KijitsumaeTohyoshaListReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<KijitsumaeTohyoshaListReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
                if (null != fuzaihsaNippoList && !fuzaihsaNippoList.isEmpty()) {
                    List<KijitsumaeTohyoshaListParam> 期日前投票者リスト = get合計(fuzaihsaNippoList);
                    for (KijitsumaeTohyoshaListParam param : 期日前投票者リスト) {
                        KijitsumaeTohyoshaListReport report = toReports(param, 帳票共通ヘッダー);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static KijitsumaeTohyoshaListReport toReports(KijitsumaeTohyoshaListParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new KijitsumaeTohyoshaListReport(param, 帳票共通ヘッダー);
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通_期日前一覧表 = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通_期日前一覧表.set選挙名称(定時登録.toRString());
        帳票共通_期日前一覧表.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通_期日前一覧表;
    }

    /**
     * 期日前投票者一覧表
     *
     * @param 期日前投票者一覧 List<KijitsumaeTohyoshaListParam>
     * @return List<KijitsumaeTohyoshaListParam>
     */
    public List<KijitsumaeTohyoshaListParam> get合計(List<KijitsumaeTohyoshaListParam> 期日前投票者一覧) {
        List<KijitsumaeTohyoshaListParam> 期日前投票者リスト = sort期日前投票者一覧情報(期日前投票者一覧);
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
        RString 合計エリア１;
        RString 合計エリア２;
        RString 投票区コード_OLD = RString.EMPTY;
        for (int i = 0; i < 期日前投票者リスト.size(); i++) {
            KijitsumaeTohyoshaIchiran 期日前投票者 = 期日前投票者リスト.get(i).get期日前投票者明細();
            RString 性別コード = 期日前投票者.get性別コード();
            RString 性別 = Gender.toValue(性別コード).getCommonName();
            RString 投票区コード_NEW = 期日前投票者.get投票区コード();
            if (i == 0) {
                if (性別.equals(性別_男)) {
                    同区集計_男++;
                }
                if (性別.equals(性別_女)) {
                    同区集計_女++;
                }
                投票区コード_OLD = 投票区コード_NEW;
//                期日前投票者リスト.get(i).setページ(new RString(ページ));
            } else {
                if (投票区コード_OLD.equals(投票区コード_NEW)) {
                    if (性別.equals(性別_男)) {
                        同区集計_男++;
                    }
                    if (性別.equals(性別_女)) {
                        同区集計_女++;
                    }
                } else {
                    合計エリア１ = 同区書式１
                            .concat(期日前投票者リスト.get(i - 1).get期日前投票者明細().get投票区名())
                            .concat(同区書式２)
                            .concat(doZZZ_ZZ9編集(new RString(同区集計_男)))
                            .concat(同区書式３)
                            .concat(doZZZ_ZZ9編集(new RString(同区集計_女)))
                            .concat(同区書式４)
                            .concat(doZZZ_ZZ9編集(new RString(同区集計_男 + 同区集計_女)));
                    期日前投票者リスト.get(i - 1).set合計エリア１(合計エリア１);
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
            if (i == 期日前投票者リスト.size() - 1) {
                合計エリア１ = 同区書式１
                        .concat(期日前投票者リスト.get(i).get期日前投票者明細().get投票区名())
                        .concat(同区書式２)
                        .concat(doZZZ_ZZ9編集(new RString(同区集計_男)))
                        .concat(同区書式３)
                        .concat(doZZZ_ZZ9編集(new RString(同区集計_女)))
                        .concat(同区書式４)
                        .concat(doZZZ_ZZ9編集(new RString(同区集計_男 + 同区集計_女)));
                期日前投票者リスト.get(i).set合計エリア１(合計エリア１);
                合計エリア２ = 全区書式１
                        .concat(doZZZ_ZZ9編集(new RString(全区集計_男)))
                        .concat(全区書式２)
                        .concat(doZZZ_ZZ9編集(new RString(全区集計_女)))
                        .concat(全区書式３)
                        .concat(doZZZ_ZZ9編集(new RString(全区集計_男 + 全区集計_女)));
                期日前投票者リスト.get(i).set合計エリア2(合計エリア２);
            }
        }

        return 期日前投票者リスト;
    }

    private RString get施設名(RString 施設コード) {
        ShisetsuManager shisetsuManager = ShisetsuManager.createInstance();
        return shisetsuManager.get施設By施設コード(施設コード).get施設名称();
    }

    private List<KijitsumaeTohyoshaListParam> sort期日前投票者一覧情報(List<KijitsumaeTohyoshaListParam> 期日前投票者一覧) {
        Collections.sort(期日前投票者一覧, new Comparator<KijitsumaeTohyoshaListParam>() {
            @Override
            public int compare(KijitsumaeTohyoshaListParam o1, KijitsumaeTohyoshaListParam o2) {
                int i = o1.get期日前投票者明細().get投票区コード().compareTo(o2.get期日前投票者明細().get投票区コード());
                if (i == 0) {
                    return o1.get期日前投票者明細().get投票区名().compareTo(o2.get期日前投票者明細().get投票区名());
                }
                return i;
            }
        });
        return 期日前投票者一覧;
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

    }
}
