package jp.co.ndensan.reams.af.afa.service.report.AFAPRB204;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenPostexParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB204.NyujokenPostexPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB204.NyujokenPostexReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 投票所入場券（ポステックス）
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujokenPostexPrintService {

    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int SEVEN = 7;
    private static final int FOUR = 4;
    private static final RString 入場券種類 = new RString("1");
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho1");
    private static final RString 長さ_送付先行政区名2 = new RString("sofusakiGyoseikuMei2");
    private static final RString 長さ_送付先行政区名1 = new RString("sofusakiGyoseikuMei1");
    private static final RString 長さ_送付先行政区名3 = new RString("sofusakiGyoseikuMei3");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_住所2 = new RString("jusho21");
    private static final RString 長さ_氏名11 = new RString("shimei11");
    private static final RString 長さ_氏名31 = new RString("shimei31");
    private static final RString 長さ_氏名21 = new RString("shimei21");
    private static final RString 長さ_氏名12 = new RString("shimei12");
    private static final RString 長さ_氏名32 = new RString("shimei32");
    private static final RString 長さ_氏名22 = new RString("shimei22");
    private static final RString 長さ_氏名13 = new RString("shimei13");
    private static final RString 長さ_氏名33 = new RString("shimei33");
    private static final RString 長さ_氏名23 = new RString("shimei23");
    private static final RString 長さ_氏名14 = new RString("shimei14");
    private static final RString 長さ_氏名24 = new RString("shimei24");
    private static final RString 長さ_氏名15 = new RString("shimei15");
    private static final RString 長さ_氏名34 = new RString("shimei34");
    private static final RString 長さ_氏名25 = new RString("shimei25");
    private static final RString 長さ_氏名35 = new RString("shimei35");
    private static final RString 長さ_氏名26 = new RString("shimei26");
    private static final RString 長さ_氏名16 = new RString("shimei16");
    private static final RString 長さ_氏名36 = new RString("shimei36");
    private static final RString 長さ_投票所名11 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名13 = new RString("tohyojoMei13");
    private static final RString 長さ_投票所名12 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名14 = new RString("tohyojoMei14");
    private static final RString 長さ_投票所名15 = new RString("tohyojoMei15");
    private static final RString 長さ_投票所名16 = new RString("tohyojoMei16");
    private static final RString 長さ_投票所名22 = new RString("tohyojoMei22");
    private static final RString 長さ_投票所名21 = new RString("tohyojoMei21");
    private static final RString 長さ_投票所名23 = new RString("tohyojoMei23");
    private static final RString 長さ_投票所名24 = new RString("tohyojoMei24");
    private static final RString 長さ_投票所名26 = new RString("tohyojoMei26");
    private static final RString 長さ_投票所名25 = new RString("tohyojoMei25");
    private static final RString 長さ_投票所名31 = new RString("tohyojoMei31");
    private static final RString 長さ_投票所名32 = new RString("tohyojoMei32");
    private static final RString 長さ_投票所名33 = new RString("tohyojoMei33");
    private static final RString 長さ_投票所名35 = new RString("tohyojoMei35");
    private static final RString 長さ_投票所名34 = new RString("tohyojoMei34");
    private static final RString 長さ_投票所名36 = new RString("tohyojoMei36");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_名称2 = new RString("shimei21");
    private static final RString 長さ_名称1 = new RString("shimei11");
    private static final RString 長さ_名称3 = new RString("shimei31");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");

    /**
     * 投票所入場券（ポステックス）
     *
     * @param nyujokenPostexParam NyujokenPostexParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(NyujokenPostexParam nyujokenPostexParam) {
        try (ReportManager reportManager = new ReportManager()) {
            NyujokenPostexPorperty property = new NyujokenPostexPorperty();
            try (ReportAssembler<NyujokenPostexSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<NyujokenPostexSource> reportSourceWriter = new ReportSourceWriter(assembler);

                Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
                setカスタマーバーコード(nyujoken3tsuori, nyujokenPostexParam);
                set送付先郵便番号(nyujokenPostexParam);
                set送付先行政区名(nyujoken3tsuori, nyujokenPostexParam);
                set送付先住所(nyujoken3tsuori, nyujokenPostexParam);
                set宛名(nyujoken3tsuori, nyujokenPostexParam);
                set性別(nyujoken3tsuori, nyujokenPostexParam);
                setカナ名称(nyujokenPostexParam, nyujoken3tsuori);
                set名称(nyujokenPostexParam, nyujoken3tsuori);
                set投票所名(nyujoken3tsuori, nyujokenPostexParam);
                set送付先名簿番号(nyujoken3tsuori, nyujokenPostexParam);
                set世帯主名(nyujokenPostexParam, nyujoken3tsuori);
                set名簿番号(nyujokenPostexParam, nyujoken3tsuori);
                set生年月日(nyujokenPostexParam, nyujoken3tsuori);
                set入場券バーコード(nyujokenPostexParam, nyujoken3tsuori);
                set世帯主区分(nyujokenPostexParam, nyujoken3tsuori);
                set地図情報(nyujokenPostexParam, nyujoken3tsuori);
                set明細情報(nyujokenPostexParam, nyujoken3tsuori);

                for (NyujokenPostexReport report : toReports(nyujokenPostexParam)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    /**
     * 投票所入場券（ポステックス）
     *
     * @param nyujokenPostexList List<NyujokenPostexParam>
     * @return List<NyujokenPostexParam>
     */
    public List<NyujokenPostexParam> printポステックス(List<NyujokenPostexParam> nyujokenPostexList) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        for (NyujokenPostexParam param : nyujokenPostexList) {
            setカスタマーバーコード(nyujoken3tsuori, param);
            set送付先郵便番号(param);
            set送付先行政区名(nyujoken3tsuori, param);
            set送付先住所(nyujoken3tsuori, param);
            set宛名(nyujoken3tsuori, param);
            set性別(nyujoken3tsuori, param);
            setカナ名称(param, nyujoken3tsuori);
            set名称(param, nyujoken3tsuori);
            set投票所名(nyujoken3tsuori, param);
            set送付先名簿番号(nyujoken3tsuori, param);
            set世帯主名(param, nyujoken3tsuori);
            set名簿番号(param, nyujoken3tsuori);
            set生年月日(param, nyujoken3tsuori);
            set入場券バーコード(param, nyujoken3tsuori);
            set世帯主区分(param, nyujoken3tsuori);
            set地図情報(param, nyujoken3tsuori);
            set明細情報(param, nyujoken3tsuori);
        }
        return nyujokenPostexList;

    }

    private void set入場券バーコード(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            RString nyujoukenBarCode1 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報1().get抄本番号(), param.get明細情報1().get識別コード());
            param.setBarcodeNyujokenBarcode1(nyujoukenBarCode1);
        }
        if (null != param.get明細情報6()) {
            RString nyujoukenBarCode6 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報6().get抄本番号(), param.get明細情報6().get識別コード());
            param.setBarcodeNyujokenBarcode6(nyujoukenBarCode6);
        }
        if (null != param.get明細情報2()) {
            RString nyujoukenBarCode2 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
            param.setBarcodeNyujokenBarcode2(nyujoukenBarCode2);
        }
        if (null != param.get明細情報5()) {
            RString nyujoukenBarCode5 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報5().get抄本番号(), param.get明細情報5().get識別コード());
            param.setBarcodeNyujokenBarcode5(nyujoukenBarCode5);
        }
        if (null != param.get明細情報3()) {
            RString nyujoukenBarCode3 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());
            param.setBarcodeNyujokenBarcode3(nyujoukenBarCode3);
        }
        if (null != param.get明細情報4()) {
            RString nyujoukenBarCode4 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報4().get抄本番号(), param.get明細情報4().get識別コード());
            param.setBarcodeNyujokenBarcode4(nyujoukenBarCode4);
        }
    }

    private void set生年月日(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報6()) {
            RString 生年月日6 = nyujoken3tsuori.getSeinengappi(param.get明細情報6().get住民種別コード(), param.get明細情報6().get生年月日());
            param.setSeinengappi6(生年月日6);
        }
        if (null != param.get明細情報1()) {
            RString 生年月日1 = nyujoken3tsuori.getSeinengappi(param.get明細情報1().get住民種別コード(), param.get明細情報1().get生年月日());
            param.setSeinengappi1(生年月日1);
        }
        if (null != param.get明細情報5()) {
            RString 生年月日5 = nyujoken3tsuori.getSeinengappi(param.get明細情報5().get住民種別コード(), param.get明細情報5().get生年月日());
            param.setSeinengappi5(生年月日5);
        }
        if (null != param.get明細情報2()) {
            RString 生年月日2 = nyujoken3tsuori.getSeinengappi(param.get明細情報2().get住民種別コード(), param.get明細情報2().get生年月日());
            param.setSeinengappi2(生年月日2);
        }
        if (null != param.get明細情報4()) {
            RString 生年月日4 = nyujoken3tsuori.getSeinengappi(param.get明細情報4().get住民種別コード(), param.get明細情報4().get生年月日());
            param.setSeinengappi4(生年月日4);
        }
        if (null != param.get明細情報3()) {
            RString 生年月日3 = nyujoken3tsuori.getSeinengappi(param.get明細情報3().get住民種別コード(), param.get明細情報3().get生年月日());
            param.setSeinengappi3(生年月日3);
        }
    }

    private void set名称(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報5()) {
            List<RString> 名称リスト5 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報5().get名称(),
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            param.setShimei15(名称リスト5.get(ZERO));
            param.setShimei25(名称リスト5.get(ONE));
            param.setShimei35(名称リスト5.get(TWO));
        }
        if (null != param.get明細情報1()) {
            List<RString> 名称リスト1 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報1().get名称(),
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            param.setShimei11(名称リスト1.get(ZERO));
            param.setShimei21(名称リスト1.get(ONE));
            param.setShimei31(名称リスト1.get(TWO));
        }
        if (null != param.get明細情報2()) {
            List<RString> 名称リスト2 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報2().get名称(),
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            param.setShimei12(名称リスト2.get(ZERO));
            param.setShimei22(名称リスト2.get(ONE));
            param.setShimei32(名称リスト2.get(TWO));
        }
        if (null != param.get明細情報6()) {
            List<RString> 名称リスト6 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報6().get名称(),
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            param.setShimei16(名称リスト6.get(ZERO));
            param.setShimei26(名称リスト6.get(ONE));
            param.setShimei36(名称リスト6.get(TWO));
        }
        if (null != param.get明細情報3()) {
            List<RString> 名称リスト3 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報3().get名称(),
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            param.setShimei13(名称リスト3.get(ZERO));
            param.setShimei23(名称リスト3.get(ONE));
            param.setShimei33(名称リスト3.get(TWO));
        }
        if (null != param.get明細情報4()) {
            List<RString> 名称リスト4 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報4().get名称(),
                    getItemLength(長さ_名称1), getItemLength(長さ_名称2), getItemLength(長さ_名称3));
            param.setShimei14(名称リスト4.get(ZERO));
            param.setShimei24(名称リスト4.get(ONE));
            param.setShimei34(名称リスト4.get(TWO));
        }
    }

    private void set名簿番号(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報6()) {
            RString meiboNo6 = nyujoken3tsuori.getTohyokuCode(param.get明細情報6().get投票区コード());
            param.setMeiboNo6(meiboNo6);
        }
        if (null != param.get明細情報1()) {
            RString meiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get明細情報1().get投票区コード());
            param.setMeiboNo1(meiboNo1);
        }
        if (null != param.get明細情報2()) {
            RString meiboNo2 = nyujoken3tsuori.getTohyokuCode(param.get明細情報2().get投票区コード());
            param.setMeiboNo2(meiboNo2);
        }
        if (null != param.get明細情報5()) {
            RString meiboNo5 = nyujoken3tsuori.getTohyokuCode(param.get明細情報5().get投票区コード());
            param.setMeiboNo5(meiboNo5);
        }
        if (null != param.get明細情報3()) {
            RString meiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get明細情報3().get投票区コード());
            param.setMeiboNo3(meiboNo3);
        }
        if (null != param.get明細情報4()) {
            RString meiboNo4 = nyujoken3tsuori.getTohyokuCode(param.get明細情報4().get投票区コード());
            param.setMeiboNo4(meiboNo4);
        }
    }

    private void set世帯主区分(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            SetaiCode 世帯コード1 = param.get明細情報1().get世帯コード();
            RString setainushiKunbun1 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード1 ? RString.EMPTY : 世帯コード1.getColumnValue());
            param.setSetainushiKubun1(setainushiKunbun1);
        }
        if (null != param.get明細情報5()) {
            SetaiCode 世帯コード5 = param.get明細情報5().get世帯コード();
            RString setainushiKunbun5 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード5 ? RString.EMPTY : 世帯コード5.getColumnValue());
            param.setSetainushiKubun5(setainushiKunbun5);
        }
        if (null != param.get明細情報2()) {
            SetaiCode 世帯コード2 = param.get明細情報2().get世帯コード();
            RString setainushiKunbun2 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード2 ? RString.EMPTY : 世帯コード2.getColumnValue());
            param.setSetainushiKubun2(setainushiKunbun2);
        }
        if (null != param.get明細情報6()) {
            SetaiCode 世帯コード6 = param.get明細情報6().get世帯コード();
            RString setainushiKunbun6 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード6 ? RString.EMPTY : 世帯コード6.getColumnValue());
            param.setSetainushiKubun6(setainushiKunbun6);
        }
        if (null != param.get明細情報3()) {
            SetaiCode 世帯コード3 = param.get明細情報3().get世帯コード();
            RString setainushiKunbun3 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード3 ? RString.EMPTY : 世帯コード3.getColumnValue());
            param.setSetainushiKubun3(setainushiKunbun3);
        }
        if (null != param.get明細情報4()) {
            SetaiCode 世帯コード4 = param.get明細情報4().get世帯コード();
            RString setainushiKunbun4 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード4 ? RString.EMPTY : 世帯コード4.getColumnValue());
            param.setSetainushiKubun4(setainushiKunbun4);
        }
    }

    private void setカナ名称(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報6()) {
            List<RString> 氏名カナリスト6 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報6().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana16(氏名カナリスト6.get(ZERO));
            param.setShimeiKana26(氏名カナリスト6.get(ONE));
        }
        if (null != param.get明細情報1()) {
            List<RString> 氏名カナリスト1 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報1().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana11(氏名カナリスト1.get(ZERO));
            param.setShimeiKana21(氏名カナリスト1.get(ONE));
        }
        if (null != param.get明細情報2()) {
            List<RString> 氏名カナリスト2 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報2().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana12(氏名カナリスト2.get(ZERO));
            param.setShimeiKana22(氏名カナリスト2.get(ONE));
        }
        if (null != param.get明細情報5()) {
            List<RString> 氏名カナリスト5 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報5().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana15(氏名カナリスト5.get(ZERO));
            param.setShimeiKana25(氏名カナリスト5.get(ONE));
        }
        if (null != param.get明細情報3()) {
            List<RString> 氏名カナリスト3 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報3().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana13(氏名カナリスト3.get(ZERO));
            param.setShimeiKana23(氏名カナリスト3.get(ONE));
        }
        if (null != param.get明細情報4()) {
            List<RString> 氏名カナリスト4 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報4().getカナ名称(),
                    getItemLength(長さ_カナ名称1), getItemLength(長さ_カナ名称2));
            param.setShimeiKana14(氏名カナリスト4.get(ZERO));
            param.setShimeiKana24(氏名カナリスト4.get(ONE));
        }
    }

    private void set地図情報(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報1()) {
            RString mapJoho1 = nyujoken3tsuori.getMapJoho(param.get送付先情報1().get送付先投票区コード());
            param.setMapJoho1(mapJoho1);
        }
    }

    private void set世帯主名(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get送付先情報1()) {
            AtenaMeisho 世帯主名1 = param.get送付先情報1().get世帯主名();
            RString setainushiMei1 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名1 ? RString.EMPTY : 世帯主名1.getColumnValue(),
                    getItemLength(長さ_世帯主名1));
            param.setSetainushiMei1(setainushiMei1);
        }
    }

    private void setカスタマーバーコード(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get送付先情報1()) {
            RString カスタマーバーコード1 = nyujoken3tsuori.getCustomBarCode(
                    nyujokenPostexParam.get送付先情報1().get送付先郵便番号(), nyujokenPostexParam.get送付先情報1().get送付先住所(),
                    nyujokenPostexParam.get送付先情報1().get送付先番地(), nyujokenPostexParam.get送付先情報1().get送付先方書());

            nyujokenPostexParam.setBarcodeCustombarcode1(null == カスタマーバーコード1 ? RString.EMPTY : カスタマーバーコード1);
        }
    }

    private void set送付先名簿番号(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam param) {
        if (null != param.get送付先情報1()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get送付先情報1().get送付先投票区コード());
            RString sofusakiMeiboNo1 = nyujoken3tsuori.getMeiboNo(投票区コード, param.get送付先情報1().get送付先名簿_頁(), param.get送付先情報1().get送付先名簿_行());
            param.setSofusakiMeiboNo1(sofusakiMeiboNo1);
        }
    }

    private void set送付先郵便番号(NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get送付先情報1()) {
            YubinNo 送付先郵便番号1 = nyujokenPostexParam.get送付先情報1().get送付先郵便番号();

            if (null != 送付先郵便番号1) {
                nyujokenPostexParam.setYubinNo11(null == 送付先郵便番号1.getYubinNo() ? RString.EMPTY : 送付先郵便番号1.getYubinNo().substring(ZERO, THREE));
                nyujokenPostexParam.setYubinNo21(null == 送付先郵便番号1.getYubinNo() ? RString.EMPTY : 送付先郵便番号1.getYubinNo().substring(THREE, SEVEN));
            }
        }
    }

    private void set送付先行政区名(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get送付先情報1()) {
            List<RString> 送付先行政区名リスト1 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    nyujokenPostexParam.get送付先情報1().get送付先行政区名(),
                    getItemLength(長さ_送付先行政区名1),
                    getItemLength(長さ_送付先行政区名2),
                    getItemLength(長さ_送付先行政区名3));
            nyujokenPostexParam.setSofusakiGyoseikuMei11(送付先行政区名リスト1.get(ZERO));
            nyujokenPostexParam.setSofusakiGyoseikuMei21(送付先行政区名リスト1.get(ONE));
            nyujokenPostexParam.setSofusakiGyoseikuMei31(送付先行政区名リスト1.get(TWO));
        }
    }

    private void set送付先住所(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get送付先情報1()) {
            List<RString> 送付先住所リスト1 = nyujoken3tsuori.getSofusakiJushoCode(
                    nyujokenPostexParam.get送付先情報1().get送付先住所(), nyujokenPostexParam.get送付先情報1().get送付先番地(),
                    nyujokenPostexParam.get送付先情報1().get送付先方書(), nyujokenPostexParam.get送付先情報1().get送付先行政区名(), getItemLength(長さ_送付先住所1));
            nyujokenPostexParam.setSofusakiJusho11(送付先住所リスト1.get(ZERO));
            nyujokenPostexParam.setSofusakiJusho21(送付先住所リスト1.get(ONE));
            nyujokenPostexParam.setSofusakiJusho31(送付先住所リスト1.get(TWO));
            nyujokenPostexParam.setSofusakiJusho41(送付先住所リスト1.get(THREE));
            nyujokenPostexParam.setSofusakiJusho51(送付先住所リスト1.get(FOUR));
        }
    }

    private void set宛名(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get送付先情報1()) {
            List<RString> 宛名リスト1 = nyujoken3tsuori.getAtena(nyujokenPostexParam.get送付先情報1().get送付先宛名(), getItemLength(長さ_宛名1));
            nyujokenPostexParam.setAtena11(宛名リスト1.get(ZERO));
            nyujokenPostexParam.setAtena21(宛名リスト1.get(ONE));
            nyujokenPostexParam.setAtena31(宛名リスト1.get(TWO));
        }
    }

    private void set明細情報(NyujokenPostexParam param, Nyujoken3tsuori nyujoken3tsuori) {
        set明細情報住所(param, nyujoken3tsuori);
        set明細情報氏名(param, nyujoken3tsuori);
    }

    private void set明細情報住所(NyujokenPostexParam nyujokenPostexParam, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != nyujokenPostexParam.get明細情報6()) {
            AtenaJusho 住登内住所6 = nyujokenPostexParam.get明細情報6().get住登内住所();
            AtenaBanchi 住登内番地6 = nyujokenPostexParam.get明細情報6().get住登内番地();
            RString 行政区名6 = nyujokenPostexParam.get明細情報6().get行政区名();
            RString 地区名16 = nyujokenPostexParam.get明細情報6().get地区名1();
            RString 地区名26 = nyujokenPostexParam.get明細情報6().get地区名2();
            RString 地区名36 = nyujokenPostexParam.get明細情報6().get地区名3();
            List<RString> 住所リスト6 = nyujoken3tsuori.getMeisaiJusho(住登内住所6, 住登内番地6, 行政区名6, 地区名16, 地区名26, 地区名36,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            nyujokenPostexParam.setJusho16(住所リスト6.get(ZERO));
            nyujokenPostexParam.setJusho26(住所リスト6.get(ONE));
        }
        if (null != nyujokenPostexParam.get明細情報1()) {
            AtenaJusho 住登内住所1 = nyujokenPostexParam.get明細情報1().get住登内住所();
            AtenaBanchi 住登内番地1 = nyujokenPostexParam.get明細情報1().get住登内番地();
            RString 行政区名1 = nyujokenPostexParam.get明細情報1().get行政区名();
            RString 地区名11 = nyujokenPostexParam.get明細情報1().get地区名1();
            RString 地区名21 = nyujokenPostexParam.get明細情報1().get地区名2();
            RString 地区名31 = nyujokenPostexParam.get明細情報1().get地区名3();
            List<RString> 住所リスト1 = nyujoken3tsuori.getMeisaiJusho(住登内住所1, 住登内番地1, 行政区名1, 地区名11, 地区名21, 地区名31,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            nyujokenPostexParam.setJusho11(住所リスト1.get(ZERO));
            nyujokenPostexParam.setJusho21(住所リスト1.get(ONE));
        }
        if (null != nyujokenPostexParam.get明細情報3()) {
            AtenaJusho 住登内住所3 = nyujokenPostexParam.get明細情報3().get住登内住所();
            AtenaBanchi 住登内番地3 = nyujokenPostexParam.get明細情報3().get住登内番地();
            RString 行政区名3 = nyujokenPostexParam.get明細情報3().get行政区名();
            RString 地区名13 = nyujokenPostexParam.get明細情報3().get地区名1();
            RString 地区名23 = nyujokenPostexParam.get明細情報3().get地区名2();
            RString 地区名33 = nyujokenPostexParam.get明細情報3().get地区名3();
            List<RString> 住所リスト3 = nyujoken3tsuori.getMeisaiJusho(住登内住所3, 住登内番地3, 行政区名3, 地区名13, 地区名23, 地区名33,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            nyujokenPostexParam.setJusho13(住所リスト3.get(ZERO));
            nyujokenPostexParam.setJusho23(住所リスト3.get(ONE));
        }
        if (null != nyujokenPostexParam.get明細情報2()) {
            AtenaJusho 住登内住所2 = nyujokenPostexParam.get明細情報2().get住登内住所();
            AtenaBanchi 住登内番地2 = nyujokenPostexParam.get明細情報2().get住登内番地();
            RString 行政区名2 = nyujokenPostexParam.get明細情報2().get行政区名();
            RString 地区名12 = nyujokenPostexParam.get明細情報2().get地区名1();
            RString 地区名22 = nyujokenPostexParam.get明細情報2().get地区名2();
            RString 地区名32 = nyujokenPostexParam.get明細情報2().get地区名3();
            List<RString> 住所リスト2 = nyujoken3tsuori.getMeisaiJusho(住登内住所2, 住登内番地2, 行政区名2, 地区名12, 地区名22, 地区名32,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            nyujokenPostexParam.setJusho12(住所リスト2.get(ZERO));
            nyujokenPostexParam.setJusho22(住所リスト2.get(ONE));
        }
        if (null != nyujokenPostexParam.get明細情報4()) {
            AtenaJusho 住登内住所4 = nyujokenPostexParam.get明細情報4().get住登内住所();
            AtenaBanchi 住登内番地4 = nyujokenPostexParam.get明細情報4().get住登内番地();
            RString 行政区名4 = nyujokenPostexParam.get明細情報4().get行政区名();
            RString 地区名14 = nyujokenPostexParam.get明細情報4().get地区名1();
            RString 地区名24 = nyujokenPostexParam.get明細情報4().get地区名2();
            RString 地区名34 = nyujokenPostexParam.get明細情報4().get地区名3();
            List<RString> 住所リスト4 = nyujoken3tsuori.getMeisaiJusho(住登内住所4, 住登内番地4, 行政区名4, 地区名14, 地区名24, 地区名34,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            nyujokenPostexParam.setJusho14(住所リスト4.get(ZERO));
            nyujokenPostexParam.setJusho24(住所リスト4.get(ONE));
        }
        if (null != nyujokenPostexParam.get明細情報5()) {
            AtenaJusho 住登内住所5 = nyujokenPostexParam.get明細情報5().get住登内住所();
            AtenaBanchi 住登内番地5 = nyujokenPostexParam.get明細情報5().get住登内番地();
            RString 行政区名5 = nyujokenPostexParam.get明細情報5().get行政区名();
            RString 地区名15 = nyujokenPostexParam.get明細情報5().get地区名1();
            RString 地区名25 = nyujokenPostexParam.get明細情報5().get地区名2();
            RString 地区名35 = nyujokenPostexParam.get明細情報5().get地区名3();
            List<RString> 住所リスト5 = nyujoken3tsuori.getMeisaiJusho(住登内住所5, 住登内番地5, 行政区名5, 地区名15, 地区名25, 地区名35,
                    getItemLength(長さ_住所1), getItemLength(長さ_住所2));
            nyujokenPostexParam.setJusho15(住所リスト5.get(ZERO));
            nyujokenPostexParam.setJusho25(住所リスト5.get(ONE));
        }
    }

    private void set明細情報氏名(NyujokenPostexParam nyujokenPostexParam, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != nyujokenPostexParam.get明細情報1()) {
            RString 名称1 = nyujokenPostexParam.get明細情報1().get名称();
            List<RString> 氏名リスト1 = nyujoken3tsuori.getMeisaiShimei(名称1,
                    getItemLength(長さ_氏名11), getItemLength(長さ_氏名21), getItemLength(長さ_氏名31));
            nyujokenPostexParam.setShimei11(氏名リスト1.get(ZERO));
            nyujokenPostexParam.setShimei21(氏名リスト1.get(ONE));
            nyujokenPostexParam.setShimei31(氏名リスト1.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報5()) {
            RString 名称5 = nyujokenPostexParam.get明細情報5().get名称();
            List<RString> 氏名リスト5 = nyujoken3tsuori.getMeisaiShimei(名称5,
                    getItemLength(長さ_氏名15), getItemLength(長さ_氏名25), getItemLength(長さ_氏名35));
            nyujokenPostexParam.setShimei15(氏名リスト5.get(ZERO));
            nyujokenPostexParam.setShimei25(氏名リスト5.get(ONE));
            nyujokenPostexParam.setShimei35(氏名リスト5.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報2()) {
            RString 名称2 = nyujokenPostexParam.get明細情報2().get名称();
            List<RString> 氏名リスト2 = nyujoken3tsuori.getMeisaiShimei(名称2,
                    getItemLength(長さ_氏名12), getItemLength(長さ_氏名22), getItemLength(長さ_氏名32));
            nyujokenPostexParam.setShimei12(氏名リスト2.get(ZERO));
            nyujokenPostexParam.setShimei22(氏名リスト2.get(ONE));
            nyujokenPostexParam.setShimei32(氏名リスト2.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報6()) {
            RString 名称6 = nyujokenPostexParam.get明細情報6().get名称();
            List<RString> 氏名リスト6 = nyujoken3tsuori.getMeisaiShimei(名称6,
                    getItemLength(長さ_氏名16), getItemLength(長さ_氏名26), getItemLength(長さ_氏名36));
            nyujokenPostexParam.setShimei16(氏名リスト6.get(ZERO));
            nyujokenPostexParam.setShimei26(氏名リスト6.get(ONE));
            nyujokenPostexParam.setShimei36(氏名リスト6.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報3()) {
            RString 名称3 = nyujokenPostexParam.get明細情報3().get名称();
            List<RString> 氏名リスト3 = nyujoken3tsuori.getMeisaiShimei(名称3,
                    getItemLength(長さ_氏名13), getItemLength(長さ_氏名23), getItemLength(長さ_氏名33));
            nyujokenPostexParam.setShimei13(氏名リスト3.get(ZERO));
            nyujokenPostexParam.setShimei23(氏名リスト3.get(ONE));
            nyujokenPostexParam.setShimei33(氏名リスト3.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報4()) {
            RString 名称4 = nyujokenPostexParam.get明細情報4().get名称();
            List<RString> 氏名リスト4 = nyujoken3tsuori.getMeisaiShimei(名称4,
                    getItemLength(長さ_氏名14), getItemLength(長さ_氏名24), getItemLength(長さ_氏名34));
            nyujokenPostexParam.setShimei14(氏名リスト4.get(ZERO));
            nyujokenPostexParam.setShimei24(氏名リスト4.get(ONE));
            nyujokenPostexParam.setShimei34(氏名リスト4.get(TWO));
        }
    }

    private void set性別(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get明細情報6()) {
            RString 性別表示文字6 = nyujoken3tsuori.getSeibetu(nyujokenPostexParam.get明細情報6().get性別コード(), 入場券種類);
            nyujokenPostexParam.setSeibetsu6(性別表示文字6);
        }
        if (null != nyujokenPostexParam.get明細情報1()) {
            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(nyujokenPostexParam.get明細情報1().get性別コード(), 入場券種類);
            nyujokenPostexParam.setSeibetsu1(性別表示文字1);
        }
        if (null != nyujokenPostexParam.get明細情報2()) {
            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(nyujokenPostexParam.get明細情報2().get性別コード(), 入場券種類);
            nyujokenPostexParam.setSeibetsu2(性別表示文字2);
        }
        if (null != nyujokenPostexParam.get明細情報5()) {
            RString 性別表示文字5 = nyujoken3tsuori.getSeibetu(nyujokenPostexParam.get明細情報5().get性別コード(), 入場券種類);
            nyujokenPostexParam.setSeibetsu5(性別表示文字5);
        }
        if (null != nyujokenPostexParam.get明細情報3()) {
            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(nyujokenPostexParam.get明細情報3().get性別コード(), 入場券種類);
            nyujokenPostexParam.setSeibetsu3(性別表示文字3);
        }
        if (null != nyujokenPostexParam.get明細情報4()) {
            RString 性別表示文字4 = nyujoken3tsuori.getSeibetu(nyujokenPostexParam.get明細情報4().get性別コード(), 入場券種類);
            nyujokenPostexParam.setSeibetsu4(性別表示文字4);
        }
    }

    private void set投票所名(Nyujoken3tsuori nyujoken3tsuori, NyujokenPostexParam nyujokenPostexParam) {
        if (null != nyujokenPostexParam.get明細情報5()) {
            RString 投票所名5 = nyujokenPostexParam.get明細情報5().get投票所名();
            List<RString> 投票所名リスト5 = nyujoken3tsuori.getTohyojoMei(投票所名5,
                    nyujokenPostexParam.get明細情報5().get帳票ID(), getItemLength(長さ_投票所名15),
                    getItemLength(長さ_投票所名25), getItemLength(長さ_投票所名35));
            nyujokenPostexParam.setTohyojoMei15(投票所名リスト5.get(ZERO));
            nyujokenPostexParam.setTohyojoMei25(投票所名リスト5.get(ONE));
            nyujokenPostexParam.setTohyojoMei35(投票所名リスト5.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報1()) {
            RString 投票所名1 = nyujokenPostexParam.get明細情報1().get投票所名();
            List<RString> 投票所名リスト1 = nyujoken3tsuori.getTohyojoMei(投票所名1,
                    nyujokenPostexParam.get明細情報1().get帳票ID(), getItemLength(長さ_投票所名11),
                    getItemLength(長さ_投票所名21), getItemLength(長さ_投票所名31));
            nyujokenPostexParam.setTohyojoMei11(投票所名リスト1.get(ZERO));
            nyujokenPostexParam.setTohyojoMei21(投票所名リスト1.get(ONE));
            nyujokenPostexParam.setTohyojoMei31(投票所名リスト1.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報2()) {
            RString 投票所名2 = nyujokenPostexParam.get明細情報2().get投票所名();
            List<RString> 投票所名リスト2 = nyujoken3tsuori.getTohyojoMei(投票所名2,
                    nyujokenPostexParam.get明細情報2().get帳票ID(), getItemLength(長さ_投票所名12),
                    getItemLength(長さ_投票所名22), getItemLength(長さ_投票所名32));
            nyujokenPostexParam.setTohyojoMei12(投票所名リスト2.get(ZERO));
            nyujokenPostexParam.setTohyojoMei22(投票所名リスト2.get(ONE));
            nyujokenPostexParam.setTohyojoMei32(投票所名リスト2.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報6()) {
            RString 投票所名6 = nyujokenPostexParam.get明細情報6().get投票所名();
            List<RString> 投票所名リスト6 = nyujoken3tsuori.getTohyojoMei(投票所名6,
                    nyujokenPostexParam.get明細情報6().get帳票ID(), getItemLength(長さ_投票所名16),
                    getItemLength(長さ_投票所名26), getItemLength(長さ_投票所名36));
            nyujokenPostexParam.setTohyojoMei16(投票所名リスト6.get(ZERO));
            nyujokenPostexParam.setTohyojoMei26(投票所名リスト6.get(ONE));
            nyujokenPostexParam.setTohyojoMei36(投票所名リスト6.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報3()) {
            RString 投票所名3 = nyujokenPostexParam.get明細情報3().get投票所名();
            List<RString> 投票所名リスト3 = nyujoken3tsuori.getTohyojoMei(投票所名3,
                    nyujokenPostexParam.get明細情報3().get帳票ID(), getItemLength(長さ_投票所名13),
                    getItemLength(長さ_投票所名23), getItemLength(長さ_投票所名33));
            nyujokenPostexParam.setTohyojoMei13(投票所名リスト3.get(ZERO));
            nyujokenPostexParam.setTohyojoMei23(投票所名リスト3.get(ONE));
            nyujokenPostexParam.setTohyojoMei33(投票所名リスト3.get(TWO));
        }
        if (null != nyujokenPostexParam.get明細情報4()) {
            RString 投票所名4 = nyujokenPostexParam.get明細情報4().get投票所名();
            List<RString> 投票所名リスト4 = nyujoken3tsuori.getTohyojoMei(投票所名4,
                    nyujokenPostexParam.get明細情報4().get帳票ID(), getItemLength(長さ_投票所名14),
                    getItemLength(長さ_投票所名24), getItemLength(長さ_投票所名34));
            nyujokenPostexParam.setTohyojoMei14(投票所名リスト4.get(ZERO));
            nyujokenPostexParam.setTohyojoMei24(投票所名リスト4.get(ONE));
            nyujokenPostexParam.setTohyojoMei34(投票所名リスト4.get(TWO));
        }
    }

    private static List<NyujokenPostexReport> toReports(NyujokenPostexParam target) {
        List<NyujokenPostexReport> list = new ArrayList<>();
        list.add(new NyujokenPostexReport(target));
        return list;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NyujokenPostexSource.class, itemName);
    }
}
