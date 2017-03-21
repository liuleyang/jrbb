package jp.co.ndensan.reams.af.afa.service.report.AFAPRE501;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.FuzaihsaNippoParam;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE501.FuzaihsaNippoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE501.FuzaihsaNippoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501.FuzaihsaNippoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoPrintService {

    private static final Code ONE = new Code("01");
    private static final Code TWO = new Code("02");
    private static final Code THREE = new Code("03");
    private static final Code FOUR = new Code("04");
    private static final Code FIVE = new Code("05");
    private static final Code SIX = new Code("06");
    private static final Code SEVEN = new Code("07");
    private static final Code EIGHT = new Code("08");
    private static final Code NINE = new Code("09");
    private static final Code TEN = new Code("10");
    private static final Code ELEVEN = new Code("11");

    /**
     * 不在者投票日報
     *
     * @param fuzaihsaNippoList List<FuzaihsaNippoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<FuzaihsaNippoParam> fuzaihsaNippoList) {
        try (ReportManager reportManager = new ReportManager()) {
            FuzaihsaNippoPorperty property = new FuzaihsaNippoPorperty();
            try (ReportAssembler<FuzaihsaNippoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<FuzaihsaNippoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
                if (null != fuzaihsaNippoList && !fuzaihsaNippoList.isEmpty()) {
                    List<FuzaihsaNippoParam> 不在者投票日報リスト = sort不在者投票交付日報(fuzaihsaNippoList);
                    for (FuzaihsaNippoParam param : 不在者投票日報リスト) {
                        FuzaihsaNippoReport report = toReports(param, 帳票共通ヘッダー);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static FuzaihsaNippoReport toReports(FuzaihsaNippoParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new FuzaihsaNippoReport(param, 帳票共通ヘッダー);
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通_不在者投票 = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通_不在者投票.set選挙名称(定時登録.toRString());
        帳票共通_不在者投票.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通_不在者投票;
    }

    /**
     * 不在者投票日報
     *
     * @param param FuzaihsaNippoParam
     * @return FuzaihsaNippoParam
     */
    public FuzaihsaNippoParam get施設データ集計(FuzaihsaNippoParam param) {
        List<AfT201TohyoJokyoEntity> 投票状況リスト = param.get投票状況情報().get投票状況();
        boolean 日報フラグ = param.get投票状況情報().is交付_受理フラグ();
        Map<Code, Integer> map1 = getMap();
        Map<Code, Integer> map2 = getMap();
        for (AfT201TohyoJokyoEntity 投票状況 : 投票状況リスト) {
            if (日報フラグ) {
                RString 施設コード = 投票状況.getShisetsuCode();
                boolean 点字フラグ = 投票状況.getTenjiFlag();
                Code 施設種別;
                if (施設コード != null) {
                    Shisetsu 施設データ = ShisetsuManager.createInstance().get施設By施設コード(施設コード);
                    施設種別 = null == 施設データ ? Code.EMPTY : 施設データ.get施設種別();
                } else {
                    施設種別 = Code.EMPTY;
                }

                if (map1.containsKey(施設種別)) {
                    map1.put(施設種別, map1.get(施設種別) + 1);
                }
                if (map1.containsKey(施設種別) && 点字フラグ) {
                    map2.put(施設種別, map2.get(施設種別) + 1);
                }
            } else {
                Code 施設種別 = 投票状況.getJuriShisetsuShubetsu();
                boolean 点字フラグ = 投票状況.getTenjiFlag();
                if (map1.containsKey(施設種別)) {
                    map1.put(施設種別, map1.get(施設種別) + 1);
                }
                if (map1.containsKey(施設種別) && 点字フラグ) {
                    map2.put(施設種別, map2.get(施設種別) + 1);
                }
            }
        }

        if (日報フラグ) {
            param.set施設数(new RString(map1.get(THREE)
                    + map1.get(FOUR)
                    + map1.get(SEVEN)
                    + map1.get(EIGHT)
                    + map1.get(NINE)
                    + map1.get(TEN)
                    + map1.get(ELEVEN)));
            param.set施設点字数(new RString(map2.get(THREE)
                    + map2.get(FOUR)
                    + map2.get(SEVEN)
                    + map2.get(EIGHT)
                    + map2.get(NINE)
                    + map2.get(TEN)
                    + map2.get(ELEVEN)));
            param.set合計数(new RString(map1.get(ONE)
                    + map1.get(TWO)
                    + map1.get(THREE)
                    + map1.get(FOUR)
                    + map1.get(FIVE)
                    + map1.get(SIX)
                    + map1.get(SEVEN)
                    + map1.get(EIGHT)
                    + map1.get(NINE)
                    + map1.get(TEN)
                    + map1.get(ELEVEN)));
            param.set合計点字数(new RString(map2.get(ONE)
                    + map2.get(TWO)
                    + map2.get(THREE)
                    + map2.get(FOUR)
                    + map2.get(FIVE)
                    + map2.get(SIX)
                    + map2.get(SEVEN)
                    + map2.get(EIGHT)
                    + map2.get(NINE)
                    + map2.get(TEN)
                    + map2.get(ELEVEN)));
        } else {
            param.set施設数(new RString(map1.get(THREE)
                    + map1.get(FOUR)
                    + map1.get(EIGHT)
                    + map1.get(NINE)
                    + map1.get(TEN)
                    + map1.get(ELEVEN)));
            param.set施設点字数(new RString(map2.get(THREE)
                    + map2.get(FOUR)
                    + map2.get(EIGHT)
                    + map2.get(NINE)
                    + map2.get(TEN)
                    + map2.get(ELEVEN)));
            param.set合計数(new RString(map1.get(ONE)
                    + map1.get(TWO)
                    + map1.get(THREE)
                    + map1.get(FOUR)
                    + map1.get(FIVE)
                    + map1.get(SIX)
                    + map1.get(EIGHT)
                    + map1.get(NINE)
                    + map1.get(TEN)
                    + map1.get(ELEVEN)));
            param.set合計点字数(new RString(map2.get(ONE)
                    + map2.get(TWO)
                    + map2.get(THREE)
                    + map2.get(FOUR)
                    + map2.get(FIVE)
                    + map2.get(SIX)
                    + map2.get(EIGHT)
                    + map2.get(NINE)
                    + map2.get(TEN)
                    + map2.get(ELEVEN)));
        }
        param.set本庁数(new RString(map1.get(ONE)));
        param.set本庁点字数(new RString(map2.get(ONE)));
        param.set郵便数(new RString(map1.get(FIVE)));
        param.set郵便点字数(new RString(map2.get(FIVE)));
        param.set他市町村数(new RString(map1.get(SIX)));
        param.set他市町村点字数(new RString(map2.get(SIX)));
        param.set支所数(new RString(map1.get(TWO)));
        param.set支所点字数(new RString(map2.get(TWO)));

        return param;
    }

    /**
     * 不在者投票日報
     *
     * @param 不在者投票日報 List<FuzaihsaNippoParam>
     * @return List<FuzaihsaNippoParam>
     */
    public List<FuzaihsaNippoParam> sort不在者投票交付日報(List<FuzaihsaNippoParam> 不在者投票日報) {
        Collections.sort(不在者投票日報, new Comparator<FuzaihsaNippoParam>() {
            @Override
            public int compare(FuzaihsaNippoParam o1, FuzaihsaNippoParam o2) {
                int i = o1.get投票状況情報().get選挙番号().compareTo(o2.get投票状況情報().get選挙番号());
                if (i == 0) {
                    if (o1.get投票状況情報().is交付_受理フラグ()) {
                        return o1.get投票状況情報().get交付年月日().compareTo(o2.get投票状況情報().get交付年月日());
                    } else {
                        return o1.get投票状況情報().get受理年月日().compareTo(o2.get投票状況情報().get受理年月日());
                    }
                }
                return i;
            }
        });
        return 不在者投票日報;
    }

    private Map getMap() {
        Map<Code, Integer> map = new HashMap<>();
        map.put(ONE, 0);
        map.put(TWO, 0);
        map.put(THREE, 0);
        map.put(FOUR, 0);
        map.put(FIVE, 0);
        map.put(SIX, 0);
        map.put(SEVEN, 0);
        map.put(EIGHT, 0);
        map.put(NINE, 0);
        map.put(TEN, 0);
        map.put(ELEVEN, 0);
        return map;
    }

}
