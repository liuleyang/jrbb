package jp.co.ndensan.reams.af.afa.service.report.AFAPRB210;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB210.TenshutsuOshiraseHagakiPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB210.TenshutsuOshiraseHagakiReport;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 転出者お知らせハガキ
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final RString 入場券種類 = new RString("2");
    private static final RString 住所11 = new RString("jusho11");
    private static final RString 住所21 = new RString("jusho21");
    private static final RString 住所31 = new RString("jusho31");
    private static final RString 住所41 = new RString("jusho41");
    private static final RString 名称11 = new RString("name11");
    private static final RString 名称21 = new RString("name21");
    private static final RString 名称31 = new RString("name31");
    private static final RString 名称12 = new RString("name12");
    private static final RString 名称22 = new RString("name22");
    private static final RString 名称32 = new RString("name32");
    private static final RString 名称13 = new RString("name13");
    private static final RString 名称23 = new RString("name23");
    private static final RString 名称33 = new RString("name33");
    private static final RString 名称14 = new RString("name14");
    private static final RString 名称24 = new RString("name24");
    private static final RString 名称34 = new RString("name34");
    private static final RString 投票所名11 = new RString("tohyojoName11");
    private static final RString 投票所名21 = new RString("tohyojoName21");
    private static final RString 投票所名12 = new RString("tohyojoName12");
    private static final RString 投票所名22 = new RString("tohyojoName22");
    private static final RString 投票所名13 = new RString("tohyojoName13");
    private static final RString 投票所名23 = new RString("tohyojoName23");
    private static final RString 投票所名14 = new RString("tohyojoName14");
    private static final RString 投票所名24 = new RString("tohyojoName24");
    private static final RString 転出前住所11 = new RString("oldJusho11");
    private static final RString 転出前住所12 = new RString("oldJusho12");
    private static final RString 転出前住所13 = new RString("oldJusho13");
    private static final RString 転出前住所14 = new RString("oldJusho14");

    /**
     * 転出者お知らせハガキ
     *
     * @param tenshutsuOshiraseHagakiList List<TenshutsuOshiraseHagakiParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TenshutsuOshiraseHagakiParam> tenshutsuOshiraseHagakiList) {
        try (ReportManager reportManager = new ReportManager()) {
            TenshutsuOshiraseHagakiPorperty property = new TenshutsuOshiraseHagakiPorperty();
            try (ReportAssembler<TenshutsuOshiraseHagakiSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<TenshutsuOshiraseHagakiSource> reportSourceWriter = new ReportSourceWriter(assembler);

                Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
                for (TenshutsuOshiraseHagakiParam param : tenshutsuOshiraseHagakiList) {
                    set明細住所(param, nyujoken3tsuori);
                    set名称(param, nyujoken3tsuori);
                    setカスタマーバーコード(param, nyujoken3tsuori);
                    set投票所名(param, nyujoken3tsuori);
                    setハガキ明細住所(param, nyujoken3tsuori);
                    set入場券バーコード(param, nyujoken3tsuori);
                    set地図情報(param, nyujoken3tsuori);
                    set生年月日(param, nyujoken3tsuori);
                    set性別(nyujoken3tsuori, param);
                }

                for (TenshutsuOshiraseHagakiReport report : toReports(tenshutsuOshiraseHagakiList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private void set地図情報(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            RString mapJoho1 = nyujoken3tsuori.getMapJoho(param.get明細情報1().get投票区コード());
            param.setMapJoho1(mapJoho1);
        }
        if (null != param.get明細情報4()) {
            RString mapJoho4 = nyujoken3tsuori.getMapJoho(param.get明細情報4().get投票区コード());
            param.setMapJoho4(mapJoho4);
        }
        if (null != param.get明細情報2()) {
            RString mapJoho2 = nyujoken3tsuori.getMapJoho(param.get明細情報2().get投票区コード());
            param.setMapJoho2(mapJoho2);
        }
        if (null != param.get明細情報3()) {
            RString mapJoho3 = nyujoken3tsuori.getMapJoho(param.get明細情報3().get投票区コード());
            param.setMapJoho3(mapJoho3);
        }
    }

    private void set明細住所(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            List<RString> 住所リスト1 = nyujoken3tsuori.getHagakiMeisaiJusho(param.get明細情報1().get住所(),
                    param.get明細情報1().get番地(), param.get明細情報1().get方書(), getItemLength(住所11));
            param.setJusho11(住所リスト1.get(ZERO));
            param.setJusho21(住所リスト1.get(ONE));
            param.setJusho31(住所リスト1.get(TWO));
            param.setJusho41(住所リスト1.get(THREE));
            param.setJusho51(住所リスト1.get(FOUR));
        }
        if (null != param.get明細情報3()) {
            List<RString> 住所リスト3 = nyujoken3tsuori.getHagakiMeisaiJusho(param.get明細情報3().get住所(),
                    param.get明細情報3().get番地(), param.get明細情報3().get方書(), getItemLength(住所31));
            param.setJusho13(住所リスト3.get(ZERO));
            param.setJusho23(住所リスト3.get(ONE));
            param.setJusho33(住所リスト3.get(TWO));
            param.setJusho43(住所リスト3.get(THREE));
            param.setJusho53(住所リスト3.get(FOUR));
        }
        if (null != param.get明細情報2()) {
            List<RString> 住所リスト2 = nyujoken3tsuori.getHagakiMeisaiJusho(param.get明細情報2().get住所(),
                    param.get明細情報2().get番地(), param.get明細情報2().get方書(), getItemLength(住所21));
            param.setJusho12(住所リスト2.get(ZERO));
            param.setJusho22(住所リスト2.get(ONE));
            param.setJusho32(住所リスト2.get(TWO));
            param.setJusho42(住所リスト2.get(THREE));
            param.setJusho52(住所リスト2.get(FOUR));
        }
        if (null != param.get明細情報4()) {
            List<RString> 住所リスト4 = nyujoken3tsuori.getHagakiMeisaiJusho(param.get明細情報4().get住所(),
                    param.get明細情報4().get番地(), param.get明細情報4().get方書(), getItemLength(住所41));
            param.setJusho14(住所リスト4.get(ZERO));
            param.setJusho24(住所リスト4.get(ONE));
            param.setJusho34(住所リスト4.get(TWO));
            param.setJusho44(住所リスト4.get(THREE));
            param.setJusho54(住所リスト4.get(FOUR));
        }
    }

    private void set名称(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            List<RString> 名称リスト1 = nyujoken3tsuori.getHagakiMeisaiShimei(param.get明細情報1().get名称(),
                    getItemLength(名称11), getItemLength(名称21), getItemLength(名称31));
            param.setName11(名称リスト1.get(ZERO));
            param.setName21(名称リスト1.get(ONE));
            param.setName31(名称リスト1.get(TWO));
        }
        if (null != param.get明細情報3()) {
            List<RString> 名称リスト3 = nyujoken3tsuori.getHagakiMeisaiShimei(param.get明細情報3().get名称(),
                    getItemLength(名称13), getItemLength(名称23), getItemLength(名称33));
            param.setName13(名称リスト3.get(ZERO));
            param.setName23(名称リスト3.get(ONE));
            param.setName33(名称リスト3.get(TWO));
        }
        if (null != param.get明細情報2()) {
            List<RString> 名称リスト2 = nyujoken3tsuori.getHagakiMeisaiShimei(param.get明細情報2().get名称(),
                    getItemLength(名称12), getItemLength(名称22), getItemLength(名称32));

            param.setName12(名称リスト2.get(ZERO));
            param.setName22(名称リスト2.get(ONE));
            param.setName32(名称リスト2.get(TWO));
        }
        if (null != param.get明細情報4()) {
            List<RString> 名称リスト4 = nyujoken3tsuori.getHagakiMeisaiShimei(param.get明細情報4().get名称(),
                    getItemLength(名称14), getItemLength(名称24), getItemLength(名称34));

            param.setName14(名称リスト4.get(ZERO));
            param.setName24(名称リスト4.get(ONE));
            param.setName34(名称リスト4.get(TWO));
        }
    }

    private void setカスタマーバーコード(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        RString 転出者はがき_印字有無_カスタマーバーコード = BusinessConfig.get(ConfigKeysAFA.転出者はがき_印字有無_カスタマーバーコード, SubGyomuCode.AFA選挙本体);
        if (転出者はがき_印字有無_カスタマーバーコード.equals(new RString("1"))) {
            if (null != param.get明細情報1()) {
                RString カスタマーバーコード1 = nyujoken3tsuori.getCustomBarCode(param.get明細情報1().get送付先郵便番号(),
                        param.get明細情報1().get住所(), param.get明細情報1().get番地(), param.get明細情報1().get方書());

                param.setBarcodeCustombarcode1(カスタマーバーコード1);
            }
            if (null != param.get明細情報2()) {
                RString カスタマーバーコード2 = nyujoken3tsuori.getCustomBarCode(param.get明細情報2().get送付先郵便番号(),
                        param.get明細情報2().get住所(), param.get明細情報2().get番地(), param.get明細情報2().get方書());
                param.setBarcodeCustombarcode2(カスタマーバーコード2);
            }
            if (null != param.get明細情報3()) {
                RString カスタマーバーコード3 = nyujoken3tsuori.getCustomBarCode(param.get明細情報3().get送付先郵便番号(),
                        param.get明細情報3().get住所(), param.get明細情報3().get番地(), param.get明細情報3().get方書());
                param.setBarcodeCustombarcode3(カスタマーバーコード3);
            }
            if (null != param.get明細情報4()) {
                RString カスタマーバーコード4 = nyujoken3tsuori.getCustomBarCode(param.get明細情報4().get送付先郵便番号(),
                        param.get明細情報4().get住所(), param.get明細情報4().get番地(), param.get明細情報4().get方書());

                param.setBarcodeCustombarcode4(カスタマーバーコード4);
            }
        }
    }

    private void set生年月日(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get明細情報1()) {
            RString 生年月日1 = nyujoken3tsuori.getSeinengappi(param.get明細情報1().get住民種別コード(), param.get明細情報1().get生年月日());
            param.setSeinengappi1(生年月日1);
        }
        if (null != param.get明細情報4()) {
            RString 生年月日4 = nyujoken3tsuori.getSeinengappi(param.get明細情報4().get住民種別コード(), param.get明細情報4().get生年月日());
            param.setSeinengappi4(生年月日4);
        }
        if (null != param.get明細情報2()) {
            RString 生年月日2 = nyujoken3tsuori.getSeinengappi(param.get明細情報2().get住民種別コード(), param.get明細情報2().get生年月日());
            param.setSeinengappi2(生年月日2);
        }
        if (null != param.get明細情報3()) {
            RString 生年月日3 = nyujoken3tsuori.getSeinengappi(param.get明細情報3().get住民種別コード(), param.get明細情報3().get生年月日());
            param.setSeinengappi3(生年月日3);
        }
    }

    private void set投票所名(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuoris) {
        if (null != param.get明細情報1()) {
            List<RString> 投票所名リスト1 = nyujoken3tsuoris.getTohyojoMei(param.get明細情報1().get投票所名(),
                    param.get明細情報1().get帳票ID(), getItemLength(投票所名11), getItemLength(投票所名21), ZERO);

            param.setTohyojoName11(投票所名リスト1.get(ZERO));
            param.setTohyojoName21(投票所名リスト1.get(ONE));
        }
        if (null != param.get明細情報2()) {
            List<RString> 投票所名リスト2 = nyujoken3tsuoris.getTohyojoMei(param.get明細情報2().get投票所名(),
                    param.get明細情報2().get帳票ID(), getItemLength(投票所名12), getItemLength(投票所名22), ZERO);

            param.setTohyojoName12(投票所名リスト2.get(ZERO));
            param.setTohyojoName22(投票所名リスト2.get(ONE));
        }
        if (null != param.get明細情報3()) {
            List<RString> 投票所名リスト3 = nyujoken3tsuoris.getTohyojoMei(param.get明細情報3().get投票所名(),
                    param.get明細情報3().get帳票ID(), getItemLength(投票所名13), getItemLength(投票所名23), ZERO);
            param.setTohyojoName13(投票所名リスト3.get(ZERO));
            param.setTohyojoName23(投票所名リスト3.get(ONE));
        }
        if (null != param.get明細情報4()) {
            List<RString> 投票所名リスト4 = nyujoken3tsuoris.getTohyojoMei(param.get明細情報4().get投票所名(),
                    param.get明細情報4().get帳票ID(), getItemLength(投票所名14), getItemLength(投票所名24), ZERO);

            param.setTohyojoName14(投票所名リスト4.get(ZERO));
            param.setTohyojoName24(投票所名リスト4.get(ONE));
        }
    }

    private void setハガキ明細住所(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuoris) {
        if (null != param.get明細情報1()) {
            List<RString> 転出前住所リスト1 = nyujoken3tsuoris.getHagakiMeisaiJusho(param.get明細情報1().get住登内住所(),
                    param.get明細情報1().get住登内番地(), param.get明細情報1().get住登内方書(), getItemLength(転出前住所11));

            param.setOldJusho11(転出前住所リスト1.get(ZERO));
            param.setOldJusho21(転出前住所リスト1.get(ONE));
            param.setOldJusho31(転出前住所リスト1.get(TWO));
        }
        if (null != param.get明細情報2()) {
            List<RString> 転出前住所リスト2 = nyujoken3tsuoris.getHagakiMeisaiJusho(param.get明細情報2().get住登内住所(),
                    param.get明細情報2().get住登内番地(), param.get明細情報2().get住登内方書(), getItemLength(転出前住所12));

            param.setOldJusho12(転出前住所リスト2.get(ZERO));
            param.setOldJusho22(転出前住所リスト2.get(ONE));
            param.setOldJusho32(転出前住所リスト2.get(TWO));
        }
        if (null != param.get明細情報3()) {
            List<RString> 転出前住所リスト3 = nyujoken3tsuoris.getHagakiMeisaiJusho(param.get明細情報3().get住登内住所(),
                    param.get明細情報3().get住登内番地(), param.get明細情報3().get住登内方書(), getItemLength(転出前住所13));
            param.setOldJusho13(転出前住所リスト3.get(ZERO));
            param.setOldJusho23(転出前住所リスト3.get(ONE));
            param.setOldJusho33(転出前住所リスト3.get(TWO));
        }
        if (null != param.get明細情報4()) {
            List<RString> 転出前住所リスト4 = nyujoken3tsuoris.getHagakiMeisaiJusho(param.get明細情報4().get住登内住所(),
                    param.get明細情報4().get住登内番地(), param.get明細情報4().get住登内方書(), getItemLength(転出前住所14));

            param.setOldJusho14(転出前住所リスト4.get(ZERO));
            param.setOldJusho24(転出前住所リスト4.get(ONE));
            param.setOldJusho34(転出前住所リスト4.get(TWO));
        }
    }

    private void set入場券バーコード(TenshutsuOshiraseHagakiParam param, Nyujoken3tsuori nyujoken3tsuoris) {
        RString 転出者はがき_印字有無_バーコード = BusinessConfig.get(ConfigKeysAFA.転出者はがき_印字有無_バーコード, SubGyomuCode.AFA選挙本体);
        if (転出者はがき_印字有無_バーコード.equals(new RString("1"))) {
            if (null != param.get明細情報1()) {
                RString バーコード1 = nyujoken3tsuoris.getNyujokenBarCode(param.get明細情報1().get抄本番号(), param.get明細情報1().get識別コード());
                param.setBarcodeBarcode1(バーコード1);
            }
            if (null != param.get明細情報2()) {
                RString バーコード2 = nyujoken3tsuoris.getNyujokenBarCode(param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
                param.setBarcodeBarcode2(バーコード2);
            }
            if (null != param.get明細情報3()) {
                RString バーコード3 = nyujoken3tsuoris.getNyujokenBarCode(param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());
                param.setBarcodeBarcode3(バーコード3);
            }
            if (null != param.get明細情報4()) {
                RString バーコード4 = nyujoken3tsuoris.getNyujokenBarCode(param.get明細情報4().get抄本番号(), param.get明細情報4().get識別コード());
                param.setBarcodeBarcode4(バーコード4);
            }
        }
    }

    private void set性別(Nyujoken3tsuori nyujoken3tsuori, TenshutsuOshiraseHagakiParam param) {
        if (null != param.get明細情報1()) {
            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(param.get明細情報1().get性別コード(), 入場券種類);
            param.setSeibetu1(性別表示文字1);
        }
        if (null != param.get明細情報2()) {
            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(param.get明細情報2().get性別コード(), 入場券種類);
            param.setSeibetu2(性別表示文字2);
        }
        if (null != param.get明細情報3()) {
            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(param.get明細情報3().get性別コード(), 入場券種類);
            param.setSeibetu3(性別表示文字3);
        }
        if (null != param.get明細情報4()) {
            RString 性別表示文字4 = nyujoken3tsuori.getSeibetu(param.get明細情報4().get性別コード(), 入場券種類);
            param.setSeibetu4(性別表示文字4);
        }
    }

    private static List<TenshutsuOshiraseHagakiReport> toReports(List<TenshutsuOshiraseHagakiParam> targets) {
        List<TenshutsuOshiraseHagakiReport> list = new ArrayList<>();
        for (TenshutsuOshiraseHagakiParam target : targets) {
            list.add(new TenshutsuOshiraseHagakiReport(target));
        }
        return list;

    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(TenshutsuOshiraseHagakiSource.class, itemName);
    }
}
