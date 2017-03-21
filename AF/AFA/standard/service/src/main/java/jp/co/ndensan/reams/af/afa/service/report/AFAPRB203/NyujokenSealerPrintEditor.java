package jp.co.ndensan.reams.af.afa.service.report.AFAPRB203;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenSealerParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB203.NyujokenSealerPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB203.NyujokenSealerReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 投票所入場券（シーラー）
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenSealerPrintEditor {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final RString 入場券種類 = new RString("1");
    private static final RString 長さ_送付先住所2 = new RString("sofusakiJusho21");
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho11");
    private static final RString 長さ_送付先行政区名2 = new RString("sofusakiGyoseikuMei21");
    private static final RString 長さ_送付先行政区名3 = new RString("sofusakiGyoseikuMei31");
    private static final RString 長さ_送付先行政区名1 = new RString("sofusakiGyoseikuMei11");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_宛名2 = new RString("atena21");
    private static final RString 長さ_住所2 = new RString("jusho21");
    private static final RString 長さ_氏名11 = new RString("shimei11");
    private static final RString 長さ_氏名12 = new RString("shimei12");
    private static final RString 長さ_氏名14 = new RString("shimei14");
    private static final RString 長さ_氏名13 = new RString("shimei13");
    private static final RString 長さ_氏名15 = new RString("shimei15");
    private static final RString 長さ_氏名16 = new RString("shimei16");
    private static final RString 長さ_氏名18 = new RString("shimei18");
    private static final RString 長さ_氏名17 = new RString("shimei17");
    private static final RString 長さ_氏名22 = new RString("shimei22");
    private static final RString 長さ_氏名21 = new RString("shimei21");
    private static final RString 長さ_氏名23 = new RString("shimei23");
    private static final RString 長さ_氏名24 = new RString("shimei24");
    private static final RString 長さ_氏名26 = new RString("shimei26");
    private static final RString 長さ_氏名25 = new RString("shimei25");
    private static final RString 長さ_氏名27 = new RString("shimei27");
    private static final RString 長さ_氏名28 = new RString("shimei28");
    private static final RString 長さ_氏名32 = new RString("shimei32");
    private static final RString 長さ_氏名31 = new RString("shimei31");
    private static final RString 長さ_氏名33 = new RString("shimei33");
    private static final RString 長さ_氏名34 = new RString("shimei34");
    private static final RString 長さ_氏名36 = new RString("shimei36");
    private static final RString 長さ_氏名35 = new RString("shimei35");
    private static final RString 長さ_氏名37 = new RString("shimei37");
    private static final RString 長さ_氏名38 = new RString("shimei38");
    private static final RString 長さ_投票所名21 = new RString("tohyojoMei21");
    private static final RString 長さ_投票所名31 = new RString("tohyojoMei31");
    private static final RString 長さ_投票所名11 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名12 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名32 = new RString("tohyojoMei32");
    private static final RString 長さ_投票所名22 = new RString("tohyojoMei22");
    private static final RString 長さ_投票所名13 = new RString("tohyojoMei13");
    private static final RString 長さ_投票所名33 = new RString("tohyojoMei33");
    private static final RString 長さ_投票所名14 = new RString("tohyojoMei14");
    private static final RString 長さ_投票所名23 = new RString("tohyojoMei23");
    private static final RString 長さ_投票所名24 = new RString("tohyojoMei24");
    private static final RString 長さ_投票所名15 = new RString("tohyojoMei15");
    private static final RString 長さ_投票所名34 = new RString("tohyojoMei34");
    private static final RString 長さ_投票所名25 = new RString("tohyojoMei25");
    private static final RString 長さ_投票所名16 = new RString("tohyojoMei16");
    private static final RString 長さ_投票所名35 = new RString("tohyojoMei35");
    private static final RString 長さ_投票所名26 = new RString("tohyojoMei26");
    private static final RString 長さ_投票所名17 = new RString("tohyojoMei17");
    private static final RString 長さ_投票所名36 = new RString("tohyojoMei36");
    private static final RString 長さ_投票所名27 = new RString("tohyojoMei27");
    private static final RString 長さ_投票所名37 = new RString("tohyojoMei37");
    private static final RString 長さ_投票所名28 = new RString("tohyojoMei28");
    private static final RString 長さ_投票所名18 = new RString("tohyojoMei18");
    private static final RString 長さ_投票所名38 = new RString("tohyojoMei38");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_世帯主名2 = new RString("setainushiMei2");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");

    /**
     * 投票所入場券（シーラー）
     *
     * @param nyujokenSealerList List<NyujokenSealerParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NyujokenSealerParam> nyujokenSealerList) {
        try (ReportManager reportManager = new ReportManager()) {
            NyujokenSealerPorperty property = new NyujokenSealerPorperty();
            try (ReportAssembler<NyujokenSealerSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<NyujokenSealerSource> reportSourceWriter = new ReportSourceWriter(assembler);
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体情報 = associationFinder.getAssociation();
                for (NyujokenSealerParam param : nyujokenSealerList) {
                    Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
                    param.set地方公共団体情報(地方公共団体情報);
                    set送付先情報1_シーラー(param, nyujoken3tsuori);
                    set送付先情報2_シーラー(param, nyujoken3tsuori);
                    set明細情報1_シーラー(param, nyujoken3tsuori);
                    set明細情報2_シーラー(param, nyujoken3tsuori);
                    set明細情報3_シーラー(param, nyujoken3tsuori);
                    set明細情報4_シーラー(param, nyujoken3tsuori);
                    set明細情報5_シーラー(param, nyujoken3tsuori);
                    set明細情報6_シーラー(param, nyujoken3tsuori);
                    set明細情報7_シーラー(param, nyujoken3tsuori);
                    set明細情報8_シーラー(param, nyujoken3tsuori);
                }

                for (NyujokenSealerReport report : toReports(nyujokenSealerList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    /**
     * 送付先情報1を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set送付先情報1_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報1()) {
            List<RString> 宛名リスト1 = nyujoken3tsuori.getAtena(param.get送付先情報1().get送付先宛名(), getItemLength(長さ_宛名1));
            param.setAtena11(宛名リスト1.get(ZERO));
            param.setAtena21(宛名リスト1.get(ONE));
            param.setAtena31(宛名リスト1.get(TWO));

            List<RString> 送付先住所リスト1 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報1().get送付先住所(), param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書(), param.get送付先情報1().get送付先行政区名(), getItemLength(長さ_送付先住所1));
            param.setSofusakiJusho11(送付先住所リスト1.get(ZERO));
            param.setSofusakiJusho21(送付先住所リスト1.get(ONE));
            param.setSofusakiJusho31(送付先住所リスト1.get(TWO));
            param.setSofusakiJusho41(送付先住所リスト1.get(THREE));
            param.setSofusakiJusho51(送付先住所リスト1.get(FOUR));

            List<RString> 送付先行政区名リスト1 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報1().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));
            param.setSofusakiGyoseikuMei11(送付先行政区名リスト1.get(ZERO));
            param.setSofusakiGyoseikuMei21(送付先行政区名リスト1.get(ONE));
            param.setSofusakiGyoseikuMei31(送付先行政区名リスト1.get(TWO));

            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報1().get送付先投票区コード());
            RString sofusakiMeiboNo1 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報1().get送付先名簿_頁(), param.get送付先情報1().get送付先名簿_行());
            param.setSofusakiMeiboNo1(sofusakiMeiboNo1);

            RString カスタマーバーコード1 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報1().get送付先郵便番号(), param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(), param.get送付先情報1().get送付先方書());
            param.setBarcodeCustombarcode1(null == カスタマーバーコード1 ? RString.EMPTY : カスタマーバーコード1);

            AtenaMeisho 世帯主名1 = param.get送付先情報1().get世帯主名();
            RString setainushiMei1 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名1 ? RString.EMPTY : 世帯主名1.getColumnValue(),
                    getItemLength(長さ_世帯主名1));
            param.setSetainushiMei1(setainushiMei1);

            RString mapJoho1 = nyujoken3tsuori.getMapJoho(param.get送付先情報1().get送付先投票区コード());
            param.setMapJoho1(mapJoho1);

        }
        return param;
    }

    /**
     * 送付先情報2を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set送付先情報2_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報2()) {
            List<RString> 宛名リスト2 = nyujoken3tsuori.getAtena(param.get送付先情報2().get送付先宛名(), getItemLength(長さ_宛名2));
            param.setAtena12(宛名リスト2.get(ZERO));
            param.setAtena22(宛名リスト2.get(ONE));
            param.setAtena32(宛名リスト2.get(TWO));

            List<RString> 送付先住所リスト2 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報2().get送付先住所(), param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書(), param.get送付先情報2().get送付先行政区名(), getItemLength(長さ_送付先住所2));
            param.setSofusakiJusho12(送付先住所リスト2.get(ZERO));
            param.setSofusakiJusho22(送付先住所リスト2.get(ONE));
            param.setSofusakiJusho32(送付先住所リスト2.get(TWO));
            param.setSofusakiJusho42(送付先住所リスト2.get(THREE));
            param.setSofusakiJusho52(送付先住所リスト2.get(FOUR));

            List<RString> 送付先行政区名リスト2 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報2().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));
            param.setSofusakiGyoseikuMei12(送付先行政区名リスト2.get(ZERO));
            param.setSofusakiGyoseikuMei22(送付先行政区名リスト2.get(ONE));
            param.setSofusakiGyoseikuMei32(送付先行政区名リスト2.get(TWO));

            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報2().get送付先投票区コード());
            RString sofusakiMeiboNo2 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報2().get送付先名簿_頁(), param.get送付先情報2().get送付先名簿_行());
            param.setSofusakiMeiboNo2(sofusakiMeiboNo2);

            RString カスタマーバーコード2 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報2().get送付先郵便番号(), param.get送付先情報2().get送付先住所(),
                    param.get送付先情報1().get送付先番地(), param.get送付先情報1().get送付先方書());
            param.setBarcodeCustombarcode2(null == カスタマーバーコード2 ? RString.EMPTY : カスタマーバーコード2);

            AtenaMeisho 世帯主名2 = param.get送付先情報2().get世帯主名();
            RString setainushiMei2 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名2 ? RString.EMPTY : 世帯主名2.getColumnValue(),
                    getItemLength(長さ_世帯主名2));
            param.setSetainushiMei2(setainushiMei2);

            RString mapJoho2 = nyujoken3tsuori.getMapJoho(param.get送付先情報2().get送付先投票区コード());
            param.setMapJoho2(mapJoho2);

        }
        return param;
    }

    /**
     * 明細情報1を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報1_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            RString 投票所名11 = param.get明細情報1().get投票所名();
            List<RString> 投票所名リスト11 = nyujoken3tsuori.getTohyojoMei(投票所名11,
                    param.get明細情報1().get帳票ID(), getItemLength(長さ_投票所名11),
                    getItemLength(長さ_投票所名21), getItemLength(長さ_投票所名31));
            param.setTohyojoMei11(投票所名リスト11.get(ZERO));
            param.setTohyojoMei21(投票所名リスト11.get(ONE));
            param.setTohyojoMei31(投票所名リスト11.get(TWO));

            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(param.get明細情報1().get性別コード(), 入場券種類);
            param.setSeibetsu1(性別表示文字1);

            RString 名称1 = param.get明細情報1().get名称();
            List<RString> 氏名リスト1 = nyujoken3tsuori.getMeisaiShimei(名称1,
                    getItemLength(長さ_氏名11), getItemLength(長さ_氏名21), getItemLength(長さ_氏名31));
            param.setShimei11(氏名リスト1.get(ZERO));
            param.setShimei21(氏名リスト1.get(ONE));
            param.setShimei31(氏名リスト1.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報1().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報1().get住登内番地();
            RString 行政区名 = param.get明細情報1().get行政区名();
            RString 地区名11 = param.get明細情報1().get地区名1();
            RString 地区名21 = param.get明細情報1().get地区名2();
            RString 地区名31 = param.get明細情報1().get地区名3();
            List<RString> 住所リスト1 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名11, 地区名21, 地区名31,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho11(住所リスト1.get(ZERO));
            param.setJusho21(住所リスト1.get(ONE));

            RString カナ名称1 = param.get明細情報1().getカナ名称();
            List<RString> 氏名カナリスト1 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称1,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana11(氏名カナリスト1.get(ZERO));
            param.setShimeiKana21(氏名カナリスト1.get(ONE));

            RString 続柄コード1 = param.get明細情報1().get続柄コード();
            RString setainushiKunbun1 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード1 ? RString.EMPTY : 続柄コード1);
            param.setSetainushiKubun1(setainushiKunbun1);

            RString meiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get明細情報1().get投票区コード());
            param.setMeiboNo1(meiboNo1);

            RString 生年月日1 = nyujoken3tsuori.getSeinengappi(param.get明細情報1().get住民種別コード(), param.get明細情報1().get生年月日());
            param.setSeinengappi1(生年月日1);

            RString nyujoukenBarCode1 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報1().get抄本番号(), param.get明細情報1().get識別コード());
            param.setBarcodeNyujokenBarcode1(nyujoukenBarCode1);
        }
        return param;
    }

    /**
     * 明細情報2を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報2_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報2()) {
            RString 投票所名28 = param.get明細情報2().get投票所名();
            List<RString> 投票所名リスト28 = nyujoken3tsuori.getTohyojoMei(投票所名28,
                    param.get明細情報2().get帳票ID(), getItemLength(長さ_投票所名12),
                    getItemLength(長さ_投票所名22), getItemLength(長さ_投票所名32));
            param.setTohyojoMei12(投票所名リスト28.get(ZERO));
            param.setTohyojoMei22(投票所名リスト28.get(ONE));
            param.setTohyojoMei32(投票所名リスト28.get(TWO));

            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(param.get明細情報2().get性別コード(), 入場券種類);
            param.setSeibetsu2(性別表示文字2);

            RString 名称2 = param.get明細情報2().get名称();
            List<RString> 氏名リスト2 = nyujoken3tsuori.getMeisaiShimei(名称2,
                    getItemLength(長さ_氏名12), getItemLength(長さ_氏名22), getItemLength(長さ_氏名32));
            param.setShimei12(氏名リスト2.get(ZERO));
            param.setShimei22(氏名リスト2.get(ONE));
            param.setShimei32(氏名リスト2.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報2().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報2().get住登内番地();
            RString 行政区名 = param.get明細情報2().get行政区名();
            RString 地区名12 = param.get明細情報2().get地区名1();
            RString 地区名22 = param.get明細情報2().get地区名2();
            RString 地区名32 = param.get明細情報2().get地区名3();
            List<RString> 住所リスト2 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名12, 地区名22, 地区名32,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2)
            );
            param.setJusho12(住所リスト2.get(ZERO));
            param.setJusho22(住所リスト2.get(ONE));

            RString カナ名称2 = param.get明細情報1().getカナ名称();
            List<RString> 氏名カナリスト2 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称2,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana12(氏名カナリスト2.get(ZERO));
            param.setShimeiKana22(氏名カナリスト2.get(ONE));

            RString 続柄コード2 = param.get明細情報2().get続柄コード();
            RString setainushiKunbun2 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード2 ? RString.EMPTY : 続柄コード2);
            param.setSetainushiKubun2(setainushiKunbun2);

            RString meiboNo2 = nyujoken3tsuori.getTohyokuCode(param.get明細情報2().get投票区コード());
            param.setMeiboNo2(meiboNo2);

            RString 生年月日2 = nyujoken3tsuori.getSeinengappi(param.get明細情報2().get住民種別コード(), param.get明細情報2().get生年月日());
            param.setSeinengappi2(生年月日2);

            RString nyujoukenBarCode2 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
            param.setBarcodeNyujokenBarcode2(nyujoukenBarCode2);
        }
        return param;
    }

    /**
     * 明細情報3を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報3_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報3()) {
            RString 投票所名33 = param.get明細情報3().get投票所名();
            List<RString> 投票所名リスト33 = nyujoken3tsuori.getTohyojoMei(投票所名33,
                    param.get明細情報3().get帳票ID(), getItemLength(長さ_投票所名13),
                    getItemLength(長さ_投票所名23), getItemLength(長さ_投票所名33));
            param.setTohyojoMei13(投票所名リスト33.get(ZERO));
            param.setTohyojoMei23(投票所名リスト33.get(ONE));
            param.setTohyojoMei33(投票所名リスト33.get(TWO));

            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(param.get明細情報3().get性別コード(), 入場券種類);
            param.setSeibetsu3(性別表示文字3);

            RString 名称3 = param.get明細情報3().get名称();
            List<RString> 氏名リスト3 = nyujoken3tsuori.getMeisaiShimei(名称3,
                    getItemLength(長さ_氏名13), getItemLength(長さ_氏名23), getItemLength(長さ_氏名33));
            param.setShimei13(氏名リスト3.get(ZERO));
            param.setShimei23(氏名リスト3.get(ONE));
            param.setShimei33(氏名リスト3.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報2().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報2().get住登内番地();
            RString 行政区名 = param.get明細情報3().get行政区名();
            RString 地区名13 = param.get明細情報3().get地区名1();
            RString 地区名23 = param.get明細情報3().get地区名2();
            RString 地区名33 = param.get明細情報3().get地区名3();
            List<RString> 住所リスト3 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名13, 地区名23, 地区名33,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho13(住所リスト3.get(ZERO));
            param.setJusho23(住所リスト3.get(ONE));

            RString カナ名称3 = param.get明細情報3().getカナ名称();
            List<RString> 氏名カナリスト3 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称3,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana13(氏名カナリスト3.get(ZERO));
            param.setShimeiKana23(氏名カナリスト3.get(ONE));

            RString 続柄コード3 = param.get明細情報3().get続柄コード();
            RString setainushiKunbun3 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード3 ? RString.EMPTY : 続柄コード3);
            param.setSetainushiKubun3(setainushiKunbun3);

            RString meiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get明細情報3().get投票区コード());
            param.setMeiboNo3(meiboNo3);

            RString 生年月日3 = nyujoken3tsuori.getSeinengappi(param.get明細情報3().get住民種別コード(), param.get明細情報3().get生年月日());
            param.setSeinengappi3(生年月日3);

            RString nyujoukenBarCode3 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());
            param.setBarcodeNyujokenBarcode3(nyujoukenBarCode3);
        }
        return param;
    }

    /**
     * 明細情報4を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報4_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報4()) {
            RString 投票所名4 = param.get明細情報4().get投票所名();
            List<RString> 投票所名リスト4 = nyujoken3tsuori.getTohyojoMei(投票所名4,
                    param.get明細情報4().get帳票ID(), getItemLength(長さ_投票所名14),
                    getItemLength(長さ_投票所名24), getItemLength(長さ_投票所名34));
            param.setTohyojoMei14(投票所名リスト4.get(ZERO));
            param.setTohyojoMei24(投票所名リスト4.get(ONE));
            param.setTohyojoMei34(投票所名リスト4.get(TWO));

            RString 性別表示文字4 = nyujoken3tsuori.getSeibetu(param.get明細情報4().get性別コード(), 入場券種類);
            param.setSeibetsu4(性別表示文字4);

            RString 名称4 = param.get明細情報4().get名称();
            List<RString> 氏名リスト4 = nyujoken3tsuori.getMeisaiShimei(名称4,
                    getItemLength(長さ_氏名14), getItemLength(長さ_氏名24), getItemLength(長さ_氏名34));
            param.setShimei14(氏名リスト4.get(ZERO));
            param.setShimei24(氏名リスト4.get(ONE));
            param.setShimei34(氏名リスト4.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報3().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報3().get住登内番地();
            RString 行政区名 = param.get明細情報4().get行政区名();
            RString 地区名14 = param.get明細情報4().get地区名1();
            RString 地区名24 = param.get明細情報4().get地区名2();
            RString 地区名34 = param.get明細情報4().get地区名3();
            List<RString> 住所リスト4 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名14, 地区名24, 地区名34,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho14(住所リスト4.get(ZERO));
            param.setJusho24(住所リスト4.get(ONE));

            RString カナ名称4 = param.get明細情報4().getカナ名称();
            List<RString> 氏名カナリスト4 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称4,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana14(氏名カナリスト4.get(ZERO));
            param.setShimeiKana24(氏名カナリスト4.get(ONE));

            RString 続柄コード4 = param.get明細情報4().get続柄コード();
            RString setainushiKunbun4 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード4 ? RString.EMPTY : 続柄コード4);
            param.setSetainushiKubun4(setainushiKunbun4);

            RString meiboNo4 = nyujoken3tsuori.getTohyokuCode(param.get明細情報4().get投票区コード());
            param.setMeiboNo4(meiboNo4);

            RString 生年月日4 = nyujoken3tsuori.getSeinengappi(param.get明細情報4().get住民種別コード(), param.get明細情報4().get生年月日());
            param.setSeinengappi4(生年月日4);

            RString nyujoukenBarCode4 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報4().get抄本番号(), param.get明細情報4().get識別コード());
            param.setBarcodeNyujokenBarcode4(nyujoukenBarCode4);
        }
        return param;
    }

    /**
     * 明細情報5を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報5_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報5()) {
            RString 投票所名5 = param.get明細情報5().get投票所名();
            List<RString> 投票所名リスト5 = nyujoken3tsuori.getTohyojoMei(投票所名5,
                    param.get明細情報5().get帳票ID(), getItemLength(長さ_投票所名15),
                    getItemLength(長さ_投票所名25), getItemLength(長さ_投票所名35));
            param.setTohyojoMei15(投票所名リスト5.get(ZERO));
            param.setTohyojoMei25(投票所名リスト5.get(ONE));
            param.setTohyojoMei35(投票所名リスト5.get(TWO));

            RString 性別表示文字5 = nyujoken3tsuori.getSeibetu(param.get明細情報5().get性別コード(), 入場券種類);
            param.setSeibetsu5(性別表示文字5);

            RString 名称5 = param.get明細情報5().get名称();
            List<RString> 氏名リスト5 = nyujoken3tsuori.getMeisaiShimei(名称5,
                    getItemLength(長さ_氏名15), getItemLength(長さ_氏名25), getItemLength(長さ_氏名35));
            param.setShimei15(氏名リスト5.get(ZERO));
            param.setShimei25(氏名リスト5.get(ONE));
            param.setShimei35(氏名リスト5.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報5().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報5().get住登内番地();
            RString 行政区名 = param.get明細情報5().get行政区名();
            RString 地区名15 = param.get明細情報5().get地区名1();
            RString 地区名25 = param.get明細情報5().get地区名2();
            RString 地区名35 = param.get明細情報5().get地区名3();
            List<RString> 住所リスト5 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名15, 地区名25, 地区名35,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho15(住所リスト5.get(ZERO));
            param.setJusho25(住所リスト5.get(ONE));

            RString カナ名称5 = param.get明細情報5().getカナ名称();
            List<RString> 氏名カナリスト5 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称5,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana15(氏名カナリスト5.get(ZERO));
            param.setShimeiKana25(氏名カナリスト5.get(ONE));

            RString 続柄コード5 = param.get明細情報5().get続柄コード();
            RString setainushiKunbun5 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード5 ? RString.EMPTY : 続柄コード5);
            param.setSetainushiKubun5(setainushiKunbun5);

            RString meiboNo5 = nyujoken3tsuori.getTohyokuCode(param.get明細情報5().get投票区コード());
            param.setMeiboNo5(meiboNo5);

            RString 生年月日5 = nyujoken3tsuori.getSeinengappi(param.get明細情報5().get住民種別コード(), param.get明細情報5().get生年月日());
            param.setSeinengappi5(生年月日5);

            RString nyujoukenBarCode5 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報5().get抄本番号(), param.get明細情報5().get識別コード());
            param.setBarcodeNyujokenBarcode5(nyujoukenBarCode5);
        }
        return param;
    }

    /**
     * 明細情報6を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報6_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報6()) {
            RString 投票所名6 = param.get明細情報6().get投票所名();
            List<RString> 投票所名リスト6 = nyujoken3tsuori.getTohyojoMei(投票所名6,
                    param.get明細情報6().get帳票ID(), getItemLength(長さ_投票所名16),
                    getItemLength(長さ_投票所名26), getItemLength(長さ_投票所名36));
            param.setTohyojoMei16(投票所名リスト6.get(ZERO));
            param.setTohyojoMei26(投票所名リスト6.get(ONE));
            param.setTohyojoMei36(投票所名リスト6.get(TWO));

            RString 性別表示文字6 = nyujoken3tsuori.getSeibetu(param.get明細情報6().get性別コード(), 入場券種類);
            param.setSeibetsu6(性別表示文字6);

            RString 名称6 = param.get明細情報6().get名称();
            List<RString> 氏名リスト6 = nyujoken3tsuori.getMeisaiShimei(名称6,
                    getItemLength(長さ_氏名16), getItemLength(長さ_氏名26), getItemLength(長さ_氏名36));
            param.setShimei16(氏名リスト6.get(ZERO));
            param.setShimei26(氏名リスト6.get(ONE));
            param.setShimei36(氏名リスト6.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報6().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報6().get住登内番地();
            RString 行政区名 = param.get明細情報6().get行政区名();
            RString 地区名16 = param.get明細情報6().get地区名1();
            RString 地区名26 = param.get明細情報6().get地区名2();
            RString 地区名36 = param.get明細情報6().get地区名3();
            List<RString> 住所リスト6 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名16, 地区名26, 地区名36,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho16(住所リスト6.get(ZERO));
            param.setJusho26(住所リスト6.get(ONE));

            RString カナ名称6 = param.get明細情報6().getカナ名称();
            List<RString> 氏名カナリスト6 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称6,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana16(氏名カナリスト6.get(ZERO));
            param.setShimeiKana26(氏名カナリスト6.get(ONE));

            RString 続柄コード6 = param.get明細情報6().get続柄コード();
            RString setainushiKunbun6 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード6 ? RString.EMPTY : 続柄コード6);
            param.setSetainushiKubun6(setainushiKunbun6);

            RString meiboNo6 = nyujoken3tsuori.getTohyokuCode(param.get明細情報6().get投票区コード());
            param.setMeiboNo6(meiboNo6);

            RString 生年月日6 = nyujoken3tsuori.getSeinengappi(param.get明細情報6().get住民種別コード(), param.get明細情報6().get生年月日());
            param.setSeinengappi6(生年月日6);

            RString nyujoukenBarCode6 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報6().get抄本番号(), param.get明細情報6().get識別コード());
            param.setBarcodeNyujokenBarcode6(nyujoukenBarCode6);
        }
        return param;
    }

    /**
     * 明細情報7を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報7_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報7()) {
            RString 投票所名7 = param.get明細情報7().get投票所名();
            List<RString> 投票所名リスト7 = nyujoken3tsuori.getTohyojoMei(投票所名7,
                    param.get明細情報7().get帳票ID(), getItemLength(長さ_投票所名17),
                    getItemLength(長さ_投票所名27), getItemLength(長さ_投票所名37));
            param.setTohyojoMei17(投票所名リスト7.get(ZERO));
            param.setTohyojoMei27(投票所名リスト7.get(ONE));
            param.setTohyojoMei37(投票所名リスト7.get(TWO));

            RString 性別表示文字7 = nyujoken3tsuori.getSeibetu(param.get明細情報7().get性別コード(), 入場券種類);
            param.setSeibetsu7(性別表示文字7);

            RString 名称7 = param.get明細情報7().get名称();
            List<RString> 氏名リスト7 = nyujoken3tsuori.getMeisaiShimei(名称7,
                    getItemLength(長さ_氏名17), getItemLength(長さ_氏名27), getItemLength(長さ_氏名37));
            param.setShimei17(氏名リスト7.get(ZERO));
            param.setShimei27(氏名リスト7.get(ONE));
            param.setShimei37(氏名リスト7.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報7().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報7().get住登内番地();
            RString 行政区名 = param.get明細情報7().get行政区名();
            RString 地区名17 = param.get明細情報7().get地区名1();
            RString 地区名27 = param.get明細情報7().get地区名2();
            RString 地区名37 = param.get明細情報7().get地区名3();
            List<RString> 住所リスト7 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名17, 地区名27, 地区名37,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho17(住所リスト7.get(ZERO));
            param.setJusho27(住所リスト7.get(ONE));

            RString カナ名称7 = param.get明細情報7().getカナ名称();
            List<RString> 氏名カナリスト7 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称7,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana17(氏名カナリスト7.get(ZERO));
            param.setShimeiKana27(氏名カナリスト7.get(ONE));

            RString 続柄コード7 = param.get明細情報7().get続柄コード();
            RString setainushiKunbun7 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード7 ? RString.EMPTY : 続柄コード7);
            param.setSetainushiKubun7(setainushiKunbun7);

            RString meiboNo7 = nyujoken3tsuori.getTohyokuCode(param.get明細情報7().get投票区コード());
            param.setMeiboNo7(meiboNo7);

            RString 生年月日7 = nyujoken3tsuori.getSeinengappi(param.get明細情報7().get住民種別コード(), param.get明細情報7().get生年月日());
            param.setSeinengappi7(生年月日7);

            RString nyujoukenBarCode7 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報7().get抄本番号(), param.get明細情報7().get識別コード());
            param.setBarcodeNyujokenBarcode7(nyujoukenBarCode7);
        }
        return param;
    }

    /**
     * 明細情報8を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenSealerParam
     */
    public NyujokenSealerParam set明細情報8_シーラー(NyujokenSealerParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報8()) {
            RString 投票所名8 = param.get明細情報8().get投票所名();
            List<RString> 投票所名リスト8 = nyujoken3tsuori.getTohyojoMei(投票所名8,
                    param.get明細情報8().get帳票ID(), getItemLength(長さ_投票所名18),
                    getItemLength(長さ_投票所名28), getItemLength(長さ_投票所名38));
            param.setTohyojoMei18(投票所名リスト8.get(ZERO));
            param.setTohyojoMei28(投票所名リスト8.get(ONE));
            param.setTohyojoMei38(投票所名リスト8.get(TWO));

            RString 性別表示文字8 = nyujoken3tsuori.getSeibetu(param.get明細情報8().get性別コード(), 入場券種類);
            param.setSeibetsu8(性別表示文字8);

            RString 名称8 = param.get明細情報8().get名称();
            List<RString> 氏名リスト8 = nyujoken3tsuori.getMeisaiShimei(名称8,
                    getItemLength(長さ_氏名18), getItemLength(長さ_氏名28), getItemLength(長さ_氏名38));
            param.setShimei18(氏名リスト8.get(ZERO));
            param.setShimei28(氏名リスト8.get(ONE));
            param.setShimei38(氏名リスト8.get(TWO));

            AtenaJusho 住登内住所 = param.get明細情報1().get住登内住所();
            AtenaBanchi 住登内番地 = param.get明細情報1().get住登内番地();
            RString 行政区名 = param.get明細情報1().get行政区名();
            RString 地区名18 = param.get明細情報8().get地区名1();
            RString 地区名28 = param.get明細情報8().get地区名2();
            RString 地区名38 = param.get明細情報8().get地区名3();
            List<RString> 住所リスト8 = nyujoken3tsuori.getMeisaiJusho(住登内住所, 住登内番地, 行政区名, 地区名18, 地区名28, 地区名38,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho18(住所リスト8.get(ZERO));
            param.setJusho28(住所リスト8.get(ONE));

            RString カナ名称8 = param.get明細情報8().getカナ名称();
            List<RString> 氏名カナリスト8 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称8,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana18(氏名カナリスト8.get(ZERO));
            param.setShimeiKana28(氏名カナリスト8.get(ONE));

            RString 続柄コード8 = param.get明細情報8().get続柄コード();
            RString setainushiKunbun8 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード8 ? RString.EMPTY : 続柄コード8);
            param.setSetainushiKubun8(setainushiKunbun8);

            RString meiboNo8 = nyujoken3tsuori.getTohyokuCode(param.get明細情報8().get投票区コード());
            param.setMeiboNo8(meiboNo8);

            RString 生年月日8 = nyujoken3tsuori.getSeinengappi(param.get明細情報8().get住民種別コード(), param.get明細情報8().get生年月日());
            param.setSeinengappi8(生年月日8);

            RString nyujoukenBarCode8 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報8().get抄本番号(), param.get明細情報8().get識別コード());
            param.setBarcodeNyujokenBarcode8(nyujoukenBarCode8);
        }
        return param;
    }

    private static List<NyujokenSealerReport> toReports(List<NyujokenSealerParam> targets) {
        List<NyujokenSealerReport> list = new ArrayList<>();
        for (NyujokenSealerParam target : targets) {
            list.add(new NyujokenSealerReport(target));
        }
        return list;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NyujokenSealerSource.class, itemName);
    }
}
