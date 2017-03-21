package jp.co.ndensan.reams.af.afa.service.report.AFAPRB201;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB201.Nyujoken3tsuoriPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB201.Nyujoken3tsuoriReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
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
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho11");
    private static final RString 長さ_送付先住所3 = new RString("sofusakiJusho13");
    private static final RString 入場券種類 = new RString("1");
    private static final RString 長さ_送付先住所2 = new RString("sofusakiJusho12");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_世帯主名3 = new RString("setainushiMei3");
    private static final RString 長さ_世帯主名2 = new RString("setainushiMei2");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");
    private static final RString 長さ_名称1 = new RString("shimei11");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");
    private static final RString 長さ_名称3 = new RString("shimei31");
    private static final RString 長さ_名称2 = new RString("shimei21");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_宛名3 = new RString("atena13");
    private static final RString 長さ_宛名2 = new RString("atena12");
    private static final RString 長さ_投票所名11 = new RString("tohyojoMei11");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_住所2 = new RString("jusho21");
    private static final RString 長さ_投票所名21 = new RString("tohyojoMei21");
    private static final RString 長さ_投票所名12 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名31 = new RString("tohyojoMei31");
    private static final RString 長さ_投票所名22 = new RString("tohyojoMei22");
    private static final RString 長さ_投票所名13 = new RString("tohyojoMei13");
    private static final RString 長さ_投票所名32 = new RString("tohyojoMei32");
    private static final RString 長さ_投票所名23 = new RString("tohyojoMei23");
    private static final RString 長さ_投票所名33 = new RString("tohyojoMei33");
    private static final RString 長さ_送付先行政区名1 = new RString("sofusakiGyoseikuMei11");
    private static final RString 長さ_送付先行政区名2 = new RString("sofusakiGyoseikuMei12");
    private static final RString 長さ_送付先行政区名3 = new RString("sofusakiGyoseikuMei13");

    /**
     * 投票所入場券（個票3つ折り）
     *
     * @param nyujoken3tsuoriParam Nyujoken3tsuoriParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(Nyujoken3tsuoriParam nyujoken3tsuoriParam) {
        try (ReportManager reportManager = new ReportManager()) {
            Nyujoken3tsuoriPorperty property = new Nyujoken3tsuoriPorperty();
            try (ReportAssembler<Nyujoken3tsuoriSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<Nyujoken3tsuoriSource> reportSourceWriter = new ReportSourceWriter(assembler);
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体情報 = associationFinder.getAssociation();
                Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();

                nyujoken3tsuoriParam.set地方公共団体情報(地方公共団体情報);
                set住所(nyujoken3tsuoriParam, nyujoken3tsuori);
                set氏名(nyujoken3tsuoriParam, nyujoken3tsuori);
                set送付先名簿番号(nyujoken3tsuoriParam, nyujoken3tsuori);
                set世帯主名(nyujoken3tsuoriParam, nyujoken3tsuori);
                set地図情報(nyujoken3tsuoriParam, nyujoken3tsuori);
                set投票所名(nyujoken3tsuoriParam, nyujoken3tsuori);
                set送付先行政区名(nyujoken3tsuori, nyujoken3tsuoriParam);
                set宛名(nyujoken3tsuori, nyujoken3tsuoriParam);
                set生年月日(nyujoken3tsuoriParam, nyujoken3tsuori);
                set世帯主区分(nyujoken3tsuoriParam, nyujoken3tsuori);
                set性別(nyujoken3tsuoriParam, nyujoken3tsuori);
                set送付先住所情報(nyujoken3tsuoriParam, nyujoken3tsuori);
                set入場券バーコード(nyujoken3tsuoriParam, nyujoken3tsuori);
                set名簿番号(nyujoken3tsuoriParam, nyujoken3tsuori);
                setカスタマーバーコード(nyujoken3tsuoriParam, nyujoken3tsuori);
                for (Nyujoken3tsuoriReport report : toReports(nyujoken3tsuoriParam)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private void setカスタマーバーコード(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報3()) {
            RString barcodeCustombarcode3 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報3().get送付先郵便番号(),
                    param.get送付先情報3().get送付先住所(),
                    param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書());
            param.setBarcodeCustombarcode3(barcodeCustombarcode3);
        }
        if (null != param.get送付先情報1()) {
            RString barcodeCustombarcode1 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報1().get送付先郵便番号(),
                    param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書());
            param.setBarcodeCustombarcode1(barcodeCustombarcode1);
        }
        if (null != param.get送付先情報2()) {
            RString barcodeCustombarcode2 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報2().get送付先郵便番号(),
                    param.get送付先情報2().get送付先住所(),
                    param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書());
            param.setBarcodeCustombarcode2(barcodeCustombarcode2);
        }
    }

    private void set名簿番号(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報3() != null) {
            RString meiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get明細情報3().get投票区コード());
            param.setMeiboNo3(meiboNo3);
        }
        if (param.get明細情報1() != null) {
            RString meiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get明細情報1().get投票区コード());
            param.setMeiboNo1(meiboNo1);
        }
        if (param.get明細情報2() != null) {
            RString meiboNo2 = nyujoken3tsuori.getTohyokuCode(param.get明細情報2().get投票区コード());
            param.setMeiboNo2(meiboNo2);
        }
    }

    private void set入場券バーコード(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報3() != null) {
            RString nyujoukenBarCode3 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());
            param.setBarcodeNyujokenBarcode3(nyujoukenBarCode3);
        }
        if (param.get明細情報1() != null) {
            RString nyujoukenBarCode1 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報1().get抄本番号(), param.get明細情報1().get識別コード());
            param.setBarcodeNyujokenBarcode1(nyujoukenBarCode1);
        }
        if (param.get明細情報2() != null) {
            RString nyujoukenBarCode2 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
            param.setBarcodeNyujokenBarcode2(nyujoukenBarCode2);
        }
    }

    private void set送付先住所情報(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報3() != null) {
            List<RString> 送付先住所リスト = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報3().get送付先住所(), param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書(), param.get送付先情報3().get送付先行政区名(), getItemLength(長さ_送付先住所3));
            param.setSofusakiJusho13(送付先住所リスト.get(ZERO));
            param.setSofusakiJusho33(送付先住所リスト.get(ONE));
            param.setSofusakiJusho33(送付先住所リスト.get(TWO));
            param.setSofusakiJusho43(送付先住所リスト.get(THREE));
            param.setSofusakiJusho53(送付先住所リスト.get(FOUR));
        }
        if (param.get送付先情報1() != null) {
            List<RString> 送付先住所リスト = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報1().get送付先住所(), param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書(), param.get送付先情報1().get送付先行政区名(), getItemLength(長さ_送付先住所1));
            param.setSofusakiJusho11(送付先住所リスト.get(ZERO));
            param.setSofusakiJusho21(送付先住所リスト.get(ONE));
            param.setSofusakiJusho31(送付先住所リスト.get(TWO));
            param.setSofusakiJusho41(送付先住所リスト.get(THREE));
            param.setSofusakiJusho51(送付先住所リスト.get(FOUR));
        }
        if (param.get送付先情報2() != null) {
            List<RString> 送付先住所リスト = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報2().get送付先住所(), param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書(), param.get送付先情報2().get送付先行政区名(), getItemLength(長さ_送付先住所2));
            param.setSofusakiJusho12(送付先住所リスト.get(ZERO));
            param.setSofusakiJusho22(送付先住所リスト.get(ONE));
            param.setSofusakiJusho32(送付先住所リスト.get(TWO));
            param.setSofusakiJusho42(送付先住所リスト.get(THREE));
            param.setSofusakiJusho52(送付先住所リスト.get(FOUR));
        }
    }

    private void set性別(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報3() != null) {
            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(param.get明細情報3().get性別コード(), 入場券種類);
            param.setSeibetsu3(性別表示文字3);
        }
        if (param.get明細情報1() != null) {
            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(param.get明細情報1().get性別コード(), 入場券種類);
            param.setSeibetsu1(性別表示文字1);
        }
        if (param.get明細情報2() != null) {
            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(param.get明細情報2().get性別コード(), 入場券種類);
            param.setSeibetsu2(性別表示文字2);
        }
    }

    private void set世帯主区分(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報3() != null) {
            RString 続柄コード3 = param.get明細情報3().get続柄コード();
            RString setainushiKunbun3 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード3 ? RString.EMPTY : 続柄コード3);
            param.setSetainushiKubun3(setainushiKunbun3);
        }
        if (param.get明細情報1() != null) {
            RString 続柄コード1 = param.get明細情報1().get続柄コード();
            RString setainushiKunbun1 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード1 ? RString.EMPTY : 続柄コード1);
            param.setSetainushiKubun1(setainushiKunbun1);
        }
        if (param.get明細情報2() != null) {
            RString 続柄コード2 = param.get明細情報2().get続柄コード();
            RString setainushiKunbun2 = nyujoken3tsuori.getSetainushiKubun(null == 続柄コード2 ? RString.EMPTY : 続柄コード2);
            param.setSetainushiKubun2(setainushiKunbun2);
        }
    }

    private void set生年月日(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報3() != null) {
            RString 生年月日3 = nyujoken3tsuori.getSeinengappi(param.get明細情報3().get住民種別コード(), param.get明細情報3().get生年月日());
            param.setSeinengappi3(生年月日3);
        }
        if (param.get明細情報1() != null) {
            RString 生年月日1 = nyujoken3tsuori.getSeinengappi(param.get明細情報1().get住民種別コード(), param.get明細情報1().get生年月日());
            param.setSeinengappi1(生年月日1);
        }
        if (param.get明細情報2() != null) {
            RString 生年月日2 = nyujoken3tsuori.getSeinengappi(param.get明細情報2().get住民種別コード(), param.get明細情報2().get生年月日());
            param.setSeinengappi2(生年月日2);
        }
    }

    private void set宛名(Nyujoken3tsuori nyujoken3tsuori, Nyujoken3tsuoriParam param) {
        if (param.get送付先情報3() != null) {
            List<RString> 宛名リスト3 = nyujoken3tsuori.getAtena(param.get送付先情報3().get送付先宛名(), getItemLength(長さ_宛名3));
            param.setAtena13(宛名リスト3.get(ZERO));
            param.setAtena23(宛名リスト3.get(ONE));
            param.setAtena33(宛名リスト3.get(TWO));
        }
        if (param.get送付先情報1() != null) {
            List<RString> 宛名リスト1 = nyujoken3tsuori.getAtena(param.get送付先情報1().get送付先宛名(), getItemLength(長さ_宛名1));
            param.setAtena11(宛名リスト1.get(ZERO));
            param.setAtena21(宛名リスト1.get(ONE));
            param.setAtena31(宛名リスト1.get(TWO));
        }
        if (param.get送付先情報2() != null) {
            List<RString> 宛名リスト2 = nyujoken3tsuori.getAtena(param.get送付先情報2().get送付先宛名(), getItemLength(長さ_宛名2));
            param.setAtena12(宛名リスト2.get(ZERO));
            param.setAtena22(宛名リスト2.get(ONE));
            param.setAtena32(宛名リスト2.get(TWO));
        }
    }

    private void set送付先行政区名(Nyujoken3tsuori nyujoken3tsuori, Nyujoken3tsuoriParam param) {
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
    }

    private void set投票所名(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報3() != null) {
            RString 投票所名3 = param.get明細情報3().get投票所名();
            List<RString> 投票所名リスト3 = nyujoken3tsuori.getTohyojoMei(投票所名3,
                    param.get明細情報3().get帳票ID(), getItemLength(長さ_投票所名13),
                    getItemLength(長さ_投票所名23), getItemLength(長さ_投票所名33));
            param.setTohyojoMei13(投票所名リスト3.get(ZERO));
            param.setTohyojoMei23(投票所名リスト3.get(ONE));
            param.setTohyojoMei33(投票所名リスト3.get(TWO));
        }
        if (param.get明細情報1() != null) {
            RString 投票所名1 = param.get明細情報1().get投票所名();
            List<RString> 投票所名リスト1 = nyujoken3tsuori.getTohyojoMei(投票所名1,
                    param.get明細情報1().get帳票ID(), getItemLength(長さ_投票所名11),
                    getItemLength(長さ_投票所名21), getItemLength(長さ_投票所名31));
            param.setTohyojoMei11(投票所名リスト1.get(ZERO));
            param.setTohyojoMei21(投票所名リスト1.get(ONE));
            param.setTohyojoMei31(投票所名リスト1.get(TWO));
        }
        if (param.get明細情報2() != null) {
            RString 投票所名22 = param.get明細情報2().get投票所名();
            List<RString> 投票所名リスト22 = nyujoken3tsuori.getTohyojoMei(投票所名22,
                    param.get明細情報2().get帳票ID(), getItemLength(長さ_投票所名12),
                    getItemLength(長さ_投票所名22), getItemLength(長さ_投票所名32));
            param.setTohyojoMei12(投票所名リスト22.get(ZERO));
            param.setTohyojoMei22(投票所名リスト22.get(ONE));
            param.setTohyojoMei32(投票所名リスト22.get(TWO));
        }
    }

    private void set地図情報(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報3() != null) {
            RString mapJoho3 = nyujoken3tsuori.getMapJoho(param.get送付先情報3().get送付先投票区コード());
            param.setMapJoho3(mapJoho3);
        }
        if (param.get送付先情報1() != null) {
            RString mapJoho1 = nyujoken3tsuori.getMapJoho(param.get送付先情報1().get送付先投票区コード());
            param.setMapJoho1(mapJoho1);
        }
        if (param.get送付先情報2() != null) {
            RString mapJoho2 = nyujoken3tsuori.getMapJoho(param.get送付先情報2().get送付先投票区コード());
            param.setMapJoho2(mapJoho2);
        }
    }

    private void set世帯主名(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            AtenaMeisho 世帯主名1 = param.get送付先情報1().get世帯主名();
            RString setainushiMei1 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名1 ? RString.EMPTY : 世帯主名1.getColumnValue(),
                    getItemLength(長さ_世帯主名1));
            param.setSetainushiMei1(setainushiMei1);
        }
        if (param.get送付先情報3() != null) {
            AtenaMeisho 世帯主名3 = param.get送付先情報3().get世帯主名();
            RString setainushiMei3 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名3 ? RString.EMPTY : 世帯主名3.getColumnValue(),
                    getItemLength(長さ_世帯主名3));
            param.setSetainushiMei3(setainushiMei3);
        }
        if (param.get送付先情報2() != null) {
            AtenaMeisho 世帯主名2 = param.get送付先情報2().get世帯主名();
            RString setainushiMei2 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名2 ? RString.EMPTY : 世帯主名2.getColumnValue(),
                    getItemLength(長さ_世帯主名2));
            param.setSetainushiMei2(setainushiMei2);
        }
    }

    private void set送付先名簿番号(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報1()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報1().get送付先投票区コード());
            RString sofusakiMeiboNo1 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報1().get送付先名簿_頁(), param.get送付先情報1().get送付先名簿_行());
            param.setSofusakiMeiboNo1(sofusakiMeiboNo1);
        }
        if (null != param.get送付先情報3()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報3().get送付先投票区コード());
            RString sofusakiMeiboNo3 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報3().get送付先名簿_頁(), param.get送付先情報3().get送付先名簿_行());
            param.setSofusakiMeiboNo3(sofusakiMeiboNo3);
        }
        if (null != param.get送付先情報2()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報2().get送付先投票区コード());
            RString sofusakiMeiboNo2 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報2().get送付先名簿_頁(), param.get送付先情報2().get送付先名簿_行());
            param.setSofusakiMeiboNo2(sofusakiMeiboNo2);
        }
    }

    private static List<Nyujoken3tsuoriReport> toReports(Nyujoken3tsuoriParam target) {
        List<Nyujoken3tsuoriReport> list = new ArrayList<>();
        list.add(new Nyujoken3tsuoriReport(target));
        return list;
    }

    private void set住所(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            List<RString> 住所リスト = nyujoken3tsuori.getMeisaiJusho(param.get明細情報1().get住登内住所(), param.get明細情報1().get住登内番地(),
                    param.get明細情報1().get行政区名(), param.get明細情報1().get地区名1(), param.get明細情報1().get地区名2(),
                    param.get明細情報1().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho11(住所リスト.get(ZERO));
            param.setJusho21(住所リスト.get(ONE));
        }
        if (param.get明細情報3() != null) {
            List<RString> 住所リスト = nyujoken3tsuori.getMeisaiJusho(param.get明細情報3().get住登内住所(), param.get明細情報3().get住登内番地(),
                    param.get明細情報3().get行政区名(), param.get明細情報3().get地区名1(), param.get明細情報3().get地区名2(),
                    param.get明細情報3().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho13(住所リスト.get(ZERO));
            param.setJusho23(住所リスト.get(ONE));
        }
        if (param.get明細情報2() != null) {
            List<RString> 住所リスト = nyujoken3tsuori.getMeisaiJusho(param.get明細情報2().get住登内住所(), param.get明細情報2().get住登内番地(),
                    param.get明細情報2().get行政区名(), param.get明細情報2().get地区名1(), param.get明細情報2().get地区名2(),
                    param.get明細情報2().get地区名3(), getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            param.setJusho12(住所リスト.get(ZERO));
            param.setJusho22(住所リスト.get(ONE));
        }
    }

    private void set氏名(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get明細情報1() != null) {
            RString 名称1 = param.get明細情報1().get名称();
            List<RString> 氏名リスト1 = nyujoken3tsuori.getMeisaiShimei(名称1,
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            List<RString> 氏名カナリスト1 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報1().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimei11(氏名リスト1.get(ZERO));
            param.setShimei21(氏名リスト1.get(ONE));
            param.setShimei31(氏名リスト1.get(TWO));
            param.setShimeiKana11(氏名カナリスト1.get(ZERO));
            param.setShimeiKana21(氏名カナリスト1.get(ONE));
        }
        if (param.get明細情報3() != null) {
            RString 名称3 = param.get明細情報3().get名称();
            List<RString> 氏名リスト3 = nyujoken3tsuori.getMeisaiShimei(名称3,
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            List<RString> 氏名カナリスト3 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報3().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimei13(氏名リスト3.get(ZERO));
            param.setShimei23(氏名リスト3.get(ONE));
            param.setShimei33(氏名リスト3.get(TWO));
            param.setShimeiKana13(氏名カナリスト3.get(ZERO));
            param.setShimeiKana23(氏名カナリスト3.get(ONE));
        }
        if (param.get明細情報2() != null) {
            RString 名称2 = param.get明細情報2().get名称();
            List<RString> 氏名リスト2 = nyujoken3tsuori.getMeisaiShimei(名称2,
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            List<RString> 氏名カナリスト2 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報2().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimei12(氏名リスト2.get(ZERO));
            param.setShimei22(氏名リスト2.get(ONE));
            param.setShimei32(氏名リスト2.get(TWO));
            param.setShimeiKana12(氏名カナリスト2.get(ZERO));
            param.setShimeiKana22(氏名カナリスト2.get(ONE));
        }
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(Nyujoken3tsuoriSource.class, itemName);
    }
}
