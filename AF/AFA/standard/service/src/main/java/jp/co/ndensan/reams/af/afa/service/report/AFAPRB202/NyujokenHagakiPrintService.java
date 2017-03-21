package jp.co.ndensan.reams.af.afa.service.report.AFAPRB202;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenHagakiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB202.NyujokenHagakiPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB202.NyujokenHagakiReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 投票所入場券（はがき4つ切り）
 *
 * @reamsid_L AF-0160-032 guyq
 */
public class NyujokenHagakiPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final RString 入場券種類 = new RString("1");
    private static final RString 長さ_送付先行政区名2 = new RString("sofusakiGyoseikuMei12");
    private static final RString 長さ_送付先行政区名1 = new RString("sofusakiGyoseikuMei11");
    private static final RString 長さ_送付先行政区名3 = new RString("sofusakiGyoseikuMei13");
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho11");
    private static final RString 長さ_送付先住所3 = new RString("sofusakiJusho13");
    private static final RString 長さ_送付先住所2 = new RString("sofusakiJusho12");
    private static final RString 長さ_送付先住所4 = new RString("sofusakiJusho14");
    private static final RString 長さ_投票所名11 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名31 = new RString("tohyojoMei31");
    private static final RString 長さ_投票所名21 = new RString("tohyojoMei21");
    private static final RString 長さ_投票所名12 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名22 = new RString("tohyojoMei22");
    private static final RString 長さ_投票所名32 = new RString("tohyojoMei32");
    private static final RString 長さ_投票所名23 = new RString("tohyojoMei23");
    private static final RString 長さ_投票所名13 = new RString("tohyojoMei13");
    private static final RString 長さ_投票所名33 = new RString("tohyojoMei33");
    private static final RString 長さ_投票所名14 = new RString("tohyojoMei14");
    private static final RString 長さ_投票所名24 = new RString("tohyojoMei24");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_投票所名34 = new RString("tohyojoMei34");
    private static final RString 長さ_宛名3 = new RString("atena13");
    private static final RString 長さ_宛名2 = new RString("atena12");
    private static final RString 長さ_宛名4 = new RString("atena14");
    private static final RString 長さ_氏名11 = new RString("shimei11");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_住所2 = new RString("jusho21");
    private static final RString 長さ_氏名13 = new RString("shimei13");
    private static final RString 長さ_氏名14 = new RString("shimei14");
    private static final RString 長さ_氏名12 = new RString("shimei12");
    private static final RString 長さ_氏名21 = new RString("shimei21");
    private static final RString 長さ_氏名22 = new RString("shimei22");
    private static final RString 長さ_氏名24 = new RString("shimei24");
    private static final RString 長さ_氏名23 = new RString("shimei23");
    private static final RString 長さ_氏名31 = new RString("shimei31");
    private static final RString 長さ_氏名32 = new RString("shimei32");
    private static final RString 長さ_氏名34 = new RString("shimei34");
    private static final RString 長さ_氏名33 = new RString("shimei33");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");
    private static final RString 長さ_世帯主名2 = new RString("setainushiMei2");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_世帯主名3 = new RString("setainushiMei3");
    private static final RString 長さ_世帯主名4 = new RString("setainushiMei4");

    /**
     * 投票所入場券（はがき4つ切り）
     *
     * @param nyujokenHagakiParam NyujokenHagakiParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(NyujokenHagakiParam nyujokenHagakiParam) {
        try (ReportManager reportManager = new ReportManager()) {
            NyujokenHagakiPorperty property = new NyujokenHagakiPorperty();
            try (ReportAssembler<NyujokenHagakiSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<NyujokenHagakiSource> reportSourceWriter = new ReportSourceWriter(assembler);
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体情報 = associationFinder.getAssociation();

                Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
                nyujokenHagakiParam.set地方公共団体情報(地方公共団体情報);
                setカスタマーバーコード(nyujokenHagakiParam, nyujoken3tsuori);
                set送付先行政区名(nyujokenHagakiParam, nyujoken3tsuori);
                set送付先住所情報(nyujokenHagakiParam, nyujoken3tsuori);
                set投票所名(nyujokenHagakiParam, nyujoken3tsuori);
                set宛名(nyujokenHagakiParam, nyujoken3tsuori);
                set送付先名簿(nyujokenHagakiParam, nyujoken3tsuori);
                set世帯主名(nyujokenHagakiParam, nyujoken3tsuori);
                set地図情報(nyujokenHagakiParam, nyujoken3tsuori);
                set住所(nyujokenHagakiParam, nyujoken3tsuori);
                set名称(nyujokenHagakiParam, nyujoken3tsuori);
                setカナ名称(nyujokenHagakiParam, nyujoken3tsuori);
                set世帯主区分(nyujokenHagakiParam, nyujoken3tsuori);
                set性別(nyujokenHagakiParam, nyujoken3tsuori);
                set名簿番号(nyujokenHagakiParam, nyujoken3tsuori);
                set生年月日(nyujokenHagakiParam, nyujoken3tsuori);
                set入場券バーコード(nyujokenHagakiParam, nyujoken3tsuori);

                for (NyujokenHagakiReport report : toReports(nyujokenHagakiParam)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private void set生年月日(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString 生年月日1 = nyujoken3tsuori.getSeinengappi(param.get明細情報1().get住民種別コード(), param.get明細情報1().get生年月日());
            param.setSeinengappi1(生年月日1);
        }
        if (param.get明細情報4() != null) {
            RString 生年月日4 = nyujoken3tsuori.getSeinengappi(param.get明細情報4().get住民種別コード(), param.get明細情報4().get生年月日());
            param.setSeinengappi3(生年月日4);
        }
        if (param.get明細情報2() != null) {
            RString 生年月日2 = nyujoken3tsuori.getSeinengappi(param.get明細情報2().get住民種別コード(), param.get明細情報2().get生年月日());
            param.setSeinengappi2(生年月日2);
        }
        if (param.get明細情報3() != null) {
            RString 生年月日3 = nyujoken3tsuori.getSeinengappi(param.get明細情報3().get住民種別コード(), param.get明細情報3().get生年月日());
            param.setSeinengappi3(生年月日3);
        }
    }

    private void setカナ名称(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString カナ名称1 = param.get明細情報1().getカナ名称();
            List<RString> 氏名カナリスト1 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称1,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana11(氏名カナリスト1.get(ZERO));
            param.setShimeiKana21(氏名カナリスト1.get(ONE));
        }
        if (param.get明細情報4() != null) {
            RString カナ名称4 = param.get明細情報4().getカナ名称();
            List<RString> 氏名カナリスト4 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称4,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana14(氏名カナリスト4.get(ZERO));
            param.setShimeiKana24(氏名カナリスト4.get(ONE));
        }
        if (param.get明細情報2() != null) {
            RString カナ名称2 = param.get明細情報1().getカナ名称();
            List<RString> 氏名カナリスト2 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称2,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana12(氏名カナリスト2.get(ZERO));
            param.setShimeiKana22(氏名カナリスト2.get(ONE));
        }

        if (param.get明細情報3() != null) {
            RString カナ名称3 = param.get明細情報3().getカナ名称();
            List<RString> 氏名カナリスト3 = nyujoken3tsuori.getMeisaiKanaMeisho(カナ名称3,
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana13(氏名カナリスト3.get(ZERO));
            param.setShimeiKana23(氏名カナリスト3.get(ONE));
        }
    }

    private void set世帯主名(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            AtenaMeisho 世帯主名1 = param.get送付先情報1().get世帯主名();
            RString setainushiMei1 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名1 ? RString.EMPTY : 世帯主名1.getColumnValue(),
                    getItemLength(長さ_世帯主名1));
            param.setSetainushiMei1(setainushiMei1);
        }
        if (param.get送付先情報4() != null) {
            AtenaMeisho 世帯主名4 = param.get送付先情報4().get世帯主名();
            RString setainushiMei4 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名4 ? RString.EMPTY : 世帯主名4.getColumnValue(),
                    getItemLength(長さ_世帯主名4));
            param.setSetainushiMei4(setainushiMei4);
        }
        if (param.get送付先情報2() != null) {
            AtenaMeisho 世帯主名2 = param.get送付先情報2().get世帯主名();
            RString setainushiMei2 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名2 ? RString.EMPTY : 世帯主名2.getColumnValue(),
                    getItemLength(長さ_世帯主名2));
            param.setSetainushiMei2(setainushiMei2);
        }
        if (param.get送付先情報3() != null) {
            AtenaMeisho 世帯主名3 = param.get送付先情報3().get世帯主名();
            RString setainushiMei3 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名3 ? RString.EMPTY : 世帯主名3.getColumnValue(),
                    getItemLength(長さ_世帯主名3));
            param.setSetainushiMei3(setainushiMei3);
        }
    }

    private void set名簿番号(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString meiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get明細情報1().get投票区コード());
            param.setMeiboNo1(meiboNo1);
        }
        if (param.get明細情報4() != null) {
            RString meiboNo4 = nyujoken3tsuori.getTohyokuCode(param.get明細情報4().get投票区コード());
            param.setMeiboNo4(meiboNo4);
        }
        if (param.get明細情報2() != null) {
            RString meiboNo2 = nyujoken3tsuori.getTohyokuCode(param.get明細情報2().get投票区コード());
            param.setMeiboNo2(meiboNo2);
        }
        if (param.get明細情報3() != null) {
            RString meiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get明細情報3().get投票区コード());
            param.setMeiboNo3(meiboNo3);
        }
    }

    private void set投票所名(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString 投票所名1 = param.get明細情報1().get投票所名();
            List<RString> 投票所名リスト1 = nyujoken3tsuori.getTohyojoMei(投票所名1,
                    param.get明細情報1().get帳票ID(), getItemLength(長さ_投票所名11),
                    getItemLength(長さ_投票所名21), getItemLength(長さ_投票所名31));
            param.setTohyojoMei11(投票所名リスト1.get(ZERO));
            param.setTohyojoMei21(投票所名リスト1.get(ONE));
            param.setTohyojoMei31(投票所名リスト1.get(TWO));
        }
        if (param.get明細情報4() != null) {
            RString 投票所名4 = param.get明細情報4().get投票所名();

            List<RString> 投票所名リスト4 = nyujoken3tsuori.getTohyojoMei(投票所名4,
                    param.get明細情報4().get帳票ID(), getItemLength(長さ_投票所名14),
                    getItemLength(長さ_投票所名24), getItemLength(長さ_投票所名34));
            param.setTohyojoMei14(投票所名リスト4.get(ZERO));
            param.setTohyojoMei24(投票所名リスト4.get(ONE));
            param.setTohyojoMei34(投票所名リスト4.get(TWO));
        }
        if (param.get明細情報2() != null) {
            RString 投票所名2 = param.get明細情報2().get投票所名();
            List<RString> 投票所名リスト2 = nyujoken3tsuori.getTohyojoMei(投票所名2,
                    param.get明細情報2().get帳票ID(), getItemLength(長さ_投票所名12),
                    getItemLength(長さ_投票所名22), getItemLength(長さ_投票所名32));
            param.setTohyojoMei12(投票所名リスト2.get(ZERO));
            param.setTohyojoMei22(投票所名リスト2.get(ONE));
            param.setTohyojoMei32(投票所名リスト2.get(TWO));
        }
        if (param.get明細情報3() != null) {
            RString 投票所名3 = param.get明細情報3().get投票所名();
            List<RString> 投票所名リスト3 = nyujoken3tsuori.getTohyojoMei(投票所名3,
                    param.get明細情報3().get帳票ID(), getItemLength(長さ_投票所名13),
                    getItemLength(長さ_投票所名23), getItemLength(長さ_投票所名33));
            param.setTohyojoMei13(投票所名リスト3.get(ZERO));
            param.setTohyojoMei23(投票所名リスト3.get(ONE));
            param.setTohyojoMei33(投票所名リスト3.get(TWO));
        }
    }

    private void set世帯主区分(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString 続柄コード1 = param.get明細情報1().get続柄コード();
            RString setainushiKunbun1 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード1 ? RString.EMPTY : 続柄コード1);
            param.setSetainushiKubun1(setainushiKunbun1);
        }
        if (param.get明細情報4() != null) {
            RString 続柄コード4 = param.get明細情報4().get続柄コード();
            RString setainushiKunbun4 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード4 ? RString.EMPTY : 続柄コード4);
            param.setSetainushiKubun4(setainushiKunbun4);
        }
        if (param.get明細情報2() != null) {
            RString 続柄コード2 = param.get明細情報2().get続柄コード();
            RString setainushiKunbun2 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード2 ? RString.EMPTY : 続柄コード2);
            param.setSetainushiKubun2(setainushiKunbun2);
        }
        if (param.get明細情報3() != null) {
            RString 続柄コード3 = param.get明細情報3().get続柄コード();
            RString setainushiKunbun3 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード3 ? RString.EMPTY : 続柄コード3);
            param.setSetainushiKubun3(setainushiKunbun3);
        }
    }

    private void set地図情報(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            RString mapJoho1 = nyujoken3tsuori.getMapJoho(param.get送付先情報1().get送付先投票区コード());
            param.setMapJoho1(mapJoho1);
        }
        if (param.get送付先情報4() != null) {
            RString mapJoho4 = nyujoken3tsuori.getMapJoho(param.get送付先情報4().get送付先投票区コード());
            param.setMapJoho4(mapJoho4);
        }
        if (param.get送付先情報2() != null) {
            RString mapJoho2 = nyujoken3tsuori.getMapJoho(param.get送付先情報2().get送付先投票区コード());
            param.setMapJoho2(mapJoho2);
        }
        if (param.get送付先情報3() != null) {
            RString mapJoho3 = nyujoken3tsuori.getMapJoho(param.get送付先情報3().get送付先投票区コード());
            param.setMapJoho3(mapJoho3);
        }
    }

    private void set入場券バーコード(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString nyujoukenBarCode1 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報1().get抄本番号(), param.get明細情報1().get識別コード());
            param.setBarcodeNyujokenBarcode1(nyujoukenBarCode1);
        }
        if (param.get明細情報4() != null) {
            RString nyujoukenBarCode4 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報4().get抄本番号(), param.get明細情報4().get識別コード());
            param.setBarcodeNyujokenBarcode4(nyujoukenBarCode4);
        }
        if (param.get明細情報2() != null) {
            RString nyujoukenBarCode2 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
            param.setBarcodeNyujokenBarcode2(nyujoukenBarCode2);
        }
        if (param.get明細情報3() != null) {
            RString nyujoukenBarCode3 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());
            param.setBarcodeNyujokenBarcode3(nyujoukenBarCode3);
        }
    }

    private void set性別(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(param.get明細情報1().get性別コード(), 入場券種類);
            param.setSeibetsu1(性別表示文字1);
        }
        if (param.get明細情報4() != null) {
            RString 性別表示文字4 = nyujoken3tsuori.getSeibetu(param.get明細情報4().get性別コード(), 入場券種類);
            param.setSeibetsu4(性別表示文字4);
        }
        if (param.get明細情報2() != null) {
            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(param.get明細情報2().get性別コード(), 入場券種類);
            param.setSeibetsu2(性別表示文字2);
        }
        if (param.get明細情報3() != null) {
            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(param.get明細情報3().get性別コード(), 入場券種類);
            param.setSeibetsu3(性別表示文字3);
        }
    }

    private void set送付先名簿(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報1()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報1().get送付先投票区コード());
            RString sofusakiMeiboNo1 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報1().get送付先名簿_頁(), param.get送付先情報1().get送付先名簿_行());
            param.setSofusakiMeiboNo1(sofusakiMeiboNo1);
        }
        if (null != param.get送付先情報4()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報4().get送付先投票区コード());
            RString sofusakiMeiboNo4 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報4().get送付先名簿_頁(), param.get送付先情報4().get送付先名簿_行());
            param.setSofusakiMeiboNo4(sofusakiMeiboNo4);
        }
        if (null != param.get送付先情報2()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報2().get送付先投票区コード());
            RString sofusakiMeiboNo2 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報2().get送付先名簿_頁(), param.get送付先情報2().get送付先名簿_行());
            param.setSofusakiMeiboNo2(sofusakiMeiboNo2);
        }
        if (null != param.get送付先情報3()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報3().get送付先投票区コード());
            RString sofusakiMeiboNo3 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報3().get送付先名簿_頁(), param.get送付先情報3().get送付先名簿_行());
            param.setSofusakiMeiboNo3(sofusakiMeiboNo3);
        }
    }

    private void set名称(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString 名称1 = param.get明細情報1().get名称();
            List<RString> 氏名リスト1 = nyujoken3tsuori.getMeisaiShimei(名称1,
                    getItemLength(長さ_氏名11), getItemLength(長さ_氏名21), getItemLength(長さ_氏名31));
            param.setShimei11(氏名リスト1.get(ZERO));
            param.setShimei21(氏名リスト1.get(ONE));
            param.setShimei31(氏名リスト1.get(TWO));
        }
        if (param.get明細情報4() != null) {
            RString 名称4 = param.get明細情報4().get名称();
            List<RString> 氏名リスト4 = nyujoken3tsuori.getMeisaiShimei(名称4,
                    getItemLength(長さ_氏名14), getItemLength(長さ_氏名24), getItemLength(長さ_氏名34));
            param.setShimei14(氏名リスト4.get(ZERO));
            param.setShimei24(氏名リスト4.get(ONE));
            param.setShimei34(氏名リスト4.get(TWO));
        }
        if (param.get明細情報2() != null) {
            RString 名称2 = param.get明細情報2().get名称();
            List<RString> 氏名リスト2 = nyujoken3tsuori.getMeisaiShimei(名称2,
                    getItemLength(長さ_氏名12), getItemLength(長さ_氏名22), getItemLength(長さ_氏名32));
            param.setShimei12(氏名リスト2.get(ZERO));
            param.setShimei22(氏名リスト2.get(ONE));
            param.setShimei32(氏名リスト2.get(TWO));
        }
        if (param.get明細情報3() != null) {
            RString 名称3 = param.get明細情報3().get名称();
            List<RString> 氏名リスト3 = nyujoken3tsuori.getMeisaiShimei(名称3,
                    getItemLength(長さ_氏名13), getItemLength(長さ_氏名23), getItemLength(長さ_氏名33));
            param.setShimei13(氏名リスト3.get(ZERO));
            param.setShimei23(氏名リスト3.get(ONE));
            param.setShimei33(氏名リスト3.get(TWO));
        }
    }

    private void set送付先行政区名(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            List<RString> 送付先行政区名リスト1 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報1().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));
            param.setSofusakiGyoseikuMei11(送付先行政区名リスト1.get(ZERO));
            param.setSofusakiGyoseikuMei21(送付先行政区名リスト1.get(ONE));
            param.setSofusakiGyoseikuMei31(送付先行政区名リスト1.get(TWO));
        }
        if (param.get送付先情報4() != null) {
            List<RString> 送付先行政区名リスト4 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報4().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));

            param.setSofusakiGyoseikuMei14(送付先行政区名リスト4.get(ZERO));
            param.setSofusakiGyoseikuMei24(送付先行政区名リスト4.get(ONE));
            param.setSofusakiGyoseikuMei34(送付先行政区名リスト4.get(TWO));
        }
        if (param.get送付先情報2() != null) {
            List<RString> 送付先行政区名リスト2 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報2().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));

            param.setSofusakiGyoseikuMei12(送付先行政区名リスト2.get(ZERO));
            param.setSofusakiGyoseikuMei22(送付先行政区名リスト2.get(ONE));
            param.setSofusakiGyoseikuMei32(送付先行政区名リスト2.get(TWO));
        }
        if (param.get送付先情報3() != null) {
            List<RString> 送付先行政区名リスト3 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報3().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));
            param.setSofusakiGyoseikuMei13(送付先行政区名リスト3.get(ZERO));
            param.setSofusakiGyoseikuMei23(送付先行政区名リスト3.get(ONE));
            param.setSofusakiGyoseikuMei33(送付先行政区名リスト3.get(TWO));
        }
    }

    private void set宛名(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            List<RString> 宛名リスト1 = nyujoken3tsuori.getAtena(param.get送付先情報1().get送付先宛名(), getItemLength(長さ_宛名1));
            param.setAtena11(宛名リスト1.get(ZERO));
            param.setAtena21(宛名リスト1.get(ONE));
            param.setAtena31(宛名リスト1.get(TWO));
        }
        if (param.get送付先情報4() != null) {
            List<RString> 宛名リスト4 = nyujoken3tsuori.getAtena(param.get送付先情報4().get送付先宛名(), getItemLength(長さ_宛名4));
            param.setAtena14(宛名リスト4.get(ZERO));
            param.setAtena24(宛名リスト4.get(ONE));
            param.setAtena34(宛名リスト4.get(TWO));
        }
        if (param.get送付先情報2() != null) {
            List<RString> 宛名リスト2 = nyujoken3tsuori.getAtena(param.get送付先情報2().get送付先宛名(), getItemLength(長さ_宛名2));
            param.setAtena12(宛名リスト2.get(ZERO));
            param.setAtena22(宛名リスト2.get(ONE));
            param.setAtena32(宛名リスト2.get(TWO));
        }
        if (param.get送付先情報3() != null) {
            List<RString> 宛名リスト3 = nyujoken3tsuori.getAtena(param.get送付先情報3().get送付先宛名(), getItemLength(長さ_宛名3));
            param.setAtena13(宛名リスト3.get(ZERO));
            param.setAtena23(宛名リスト3.get(ONE));
            param.setAtena33(宛名リスト3.get(TWO));
        }
    }

    private void set送付先住所情報(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            List<RString> 送付先住所リスト1 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報1().get送付先住所(), param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書(), param.get送付先情報1().get送付先行政区名(), getItemLength(長さ_送付先住所1));
            param.setSofusakiJusho11(送付先住所リスト1.get(ZERO));
            param.setSofusakiJusho21(送付先住所リスト1.get(ONE));
            param.setSofusakiJusho31(送付先住所リスト1.get(TWO));
            param.setSofusakiJusho41(送付先住所リスト1.get(THREE));
            param.setSofusakiJusho51(送付先住所リスト1.get(FOUR));
        }
        if (param.get送付先情報4() != null) {
            List<RString> 送付先住所リスト4 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報4().get送付先住所(), param.get送付先情報4().get送付先番地(),
                    param.get送付先情報4().get送付先方書(), param.get送付先情報4().get送付先行政区名(), getItemLength(長さ_送付先住所4));
            param.setSofusakiJusho14(送付先住所リスト4.get(ZERO));
            param.setSofusakiJusho44(送付先住所リスト4.get(ONE));
            param.setSofusakiJusho44(送付先住所リスト4.get(TWO));
            param.setSofusakiJusho44(送付先住所リスト4.get(THREE));
            param.setSofusakiJusho54(送付先住所リスト4.get(FOUR));
        }
        if (param.get送付先情報2() != null) {
            List<RString> 送付先住所リスト2 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報2().get送付先住所(), param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書(), param.get送付先情報2().get送付先行政区名(), getItemLength(長さ_送付先住所2));
            param.setSofusakiJusho12(送付先住所リスト2.get(ZERO));
            param.setSofusakiJusho22(送付先住所リスト2.get(ONE));
            param.setSofusakiJusho32(送付先住所リスト2.get(TWO));
            param.setSofusakiJusho42(送付先住所リスト2.get(THREE));
            param.setSofusakiJusho52(送付先住所リスト2.get(FOUR));
        }
        if (param.get送付先情報3() != null) {
            List<RString> 送付先住所リスト3 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報3().get送付先住所(), param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書(), param.get送付先情報3().get送付先行政区名(), getItemLength(長さ_送付先住所3));
            param.setSofusakiJusho13(送付先住所リスト3.get(ZERO));
            param.setSofusakiJusho33(送付先住所リスト3.get(ONE));
            param.setSofusakiJusho33(送付先住所リスト3.get(TWO));
            param.setSofusakiJusho43(送付先住所リスト3.get(THREE));
            param.setSofusakiJusho53(送付先住所リスト3.get(FOUR));
        }
    }

    private void set住所(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            List<RString> 住所リスト1 = nyujoken3tsuori.getMeisaiJusho(param.get明細情報1().get住登内住所(), param.get明細情報1().get住登内番地(),
                    param.get明細情報1().get行政区名(), param.get明細情報1().get地区名1(), param.get明細情報1().get地区名2(),
                    param.get明細情報1().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho11(住所リスト1.get(ZERO));
            param.setJusho21(住所リスト1.get(ONE));
        }
        if (param.get明細情報4() != null) {
            List<RString> 住所リスト4 = nyujoken3tsuori.getMeisaiJusho(param.get明細情報4().get住登内住所(), param.get明細情報4().get住登内番地(),
                    param.get明細情報4().get行政区名(), param.get明細情報4().get地区名1(), param.get明細情報4().get地区名2(),
                    param.get明細情報4().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho14(住所リスト4.get(ZERO));
            param.setJusho24(住所リスト4.get(ONE));
        }
        if (param.get明細情報2() != null) {
            List<RString> 住所リスト2 = nyujoken3tsuori.getMeisaiJusho(param.get明細情報2().get住登内住所(), param.get明細情報2().get住登内番地(),
                    param.get明細情報2().get行政区名(), param.get明細情報2().get地区名1(), param.get明細情報2().get地区名2(),
                    param.get明細情報2().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho12(住所リスト2.get(ZERO));
            param.setJusho22(住所リスト2.get(ONE));
        }
        if (param.get明細情報3() != null) {
            List<RString> 住所リスト3 = nyujoken3tsuori.getMeisaiJusho(param.get明細情報3().get住登内住所(), param.get明細情報3().get住登内番地(),
                    param.get明細情報3().get行政区名(), param.get明細情報3().get地区名1(), param.get明細情報3().get地区名2(),
                    param.get明細情報3().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho13(住所リスト3.get(ZERO));
            param.setJusho23(住所リスト3.get(ONE));
        }
    }

    private void setカスタマーバーコード(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報1()) {
            RString barcodeCustombarcode1 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報1().get送付先郵便番号(),
                    param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書());
            param.setBarcodeCustombarcode1(barcodeCustombarcode1);
        }
        if (null != param.get送付先情報4()) {
            RString barcodeCustombarcode4 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報4().get送付先郵便番号(),
                    param.get送付先情報4().get送付先住所(),
                    param.get送付先情報4().get送付先番地(),
                    param.get送付先情報4().get送付先方書());
            param.setBarcodeCustombarcode4(barcodeCustombarcode4);
        }
        if (null != param.get送付先情報2()) {
            RString barcodeCustombarcode2 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報2().get送付先郵便番号(),
                    param.get送付先情報2().get送付先住所(),
                    param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書());
            param.setBarcodeCustombarcode2(barcodeCustombarcode2);
        }
        if (null != param.get送付先情報3()) {
            RString barcodeCustombarcode3 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報3().get送付先郵便番号(),
                    param.get送付先情報3().get送付先住所(),
                    param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書());
            param.setBarcodeCustombarcode3(barcodeCustombarcode3);
        }
    }

    private static List<NyujokenHagakiReport> toReports(NyujokenHagakiParam target) {
        List<NyujokenHagakiReport> list = new ArrayList<>();
        list.add(new NyujokenHagakiReport(target));
        return list;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NyujokenHagakiSource.class, itemName);
    }
}
