package jp.co.ndensan.reams.af.afa.service.report.AFAPRB202;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenHagakiParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 投票所入場券（はがき4つ切り）
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujokenHagakiPrintEditor {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    private static final RString 入場券種類 = new RString("1");
    private static final RString 長さ_送送付先行政区名1 = new RString("sofusakiGyoseikuMei11");
    private static final RString 長さ_送送付先行政区名2 = new RString("sofusakiGyoseikuMei21");
    private static final RString 長さ_送送付先行政区名3 = new RString("sofusakiGyoseikuMei31");
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho11");
    private static final RString 長さ_投票所名1 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名2 = new RString("tohyojoMei21");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_住所2 = new RString("jusho21");
    private static final RString 長さ_名称1 = new RString("shimei11");
    private static final RString 長さ_名称2 = new RString("shimei21");
    private static final RString 長さ_名称3 = new RString("shimei31");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");
    private static final RString 長さ_世帯主名2 = new RString("setainushiMei2");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_世帯主名3 = new RString("setainushiMei3");
    private static final RString 長さ_世帯主名4 = new RString("setainushiMei4");

    /**
     * 投票所入場券（個票はがき4つ切）。
     *
     * @param nyujoken3tsuoriList List<Nyujoken3tsuoriParam>
     * @param 地方公共団体情報 Association
     * @return List<Nyujoken3tsuoriParam>
     */
    public List<NyujokenHagakiParam> printFor投票所入場券_はがき4つ切(List<NyujokenHagakiParam> nyujoken3tsuoriList, Association 地方公共団体情報) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        for (NyujokenHagakiParam param : nyujoken3tsuoriList) {
            param.set地方公共団体情報(地方公共団体情報);
            param = set送付先情報1と明細情報1_はがき4つ切(param, nyujoken3tsuori);
            param = set送付先情報2と明細情報2_はがき4つ切(param, nyujoken3tsuori);
            param = set送付先情報3と明細情報3_はがき4つ切(param, nyujoken3tsuori);
            param = set送付先情報4と明細情報4_はがき4つ切(param, nyujoken3tsuori);
        }
        return nyujoken3tsuoriList;
    }

    /**
     * 送付先情報1と明細情報1を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenHagakiParam
     */
    public NyujokenHagakiParam set送付先情報1と明細情報1_はがき4つ切(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            SetaiCode 世帯コード1 = param.get送付先情報1().get送付先世帯コード();
            RString setainushiKunbun1 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード1 ? RString.EMPTY : 世帯コード1.getColumnValue());
            param.setSetainushiKubun1(setainushiKunbun1);
            RString mapJoho1 = nyujoken3tsuori.getMapJoho(param.get送付先情報1().get送付先投票区コード());
            param.setMapJoho1(mapJoho1);

            List<RString> 送付先行政区名リスト1 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報1().get送付先行政区名(),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名1),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名2),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名3));
            param.setSofusakiGyoseikuMei11(送付先行政区名リスト1.get(ZERO));
            param.setSofusakiGyoseikuMei21(送付先行政区名リスト1.get(ONE));
            param.setSofusakiGyoseikuMei31(送付先行政区名リスト1.get(TWO));

            List<RString> 名称リスト1 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報1().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2), getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei11(名称リスト1.get(ZERO));
            param.setShimei21(名称リスト1.get(ONE));
            param.setShimei31(名称リスト1.get(TWO));

            List<RString> 宛名リスト1 = nyujoken3tsuori.getAtena(param.get送付先情報1().get送付先宛名(), getNyujokenHagakiSourceItemLength(長さ_宛名1));
            param.setAtena11(宛名リスト1.get(ZERO));
            param.setAtena21(宛名リスト1.get(ONE));
            param.setAtena31(宛名リスト1.get(TWO));

            List<RString> 送付先住所情報リスト1 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書(),
                    param.get送付先情報1().get送付先行政区名(), getNyujokenHagakiSourceItemLength(長さ_送付先住所1));
            param.setSofusakiJusho11(送付先住所情報リスト1.get(ZERO));
            param.setSofusakiJusho21(送付先住所情報リスト1.get(ONE));
            param.setSofusakiJusho31(送付先住所情報リスト1.get(TWO));
            param.setSofusakiJusho41(送付先住所情報リスト1.get(THREE));
            param.setSofusakiJusho51(送付先住所情報リスト1.get(FOUR));

            RString barcodeCustombarcode1 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報1().get送付先郵便番号(),
                    param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書());
            param.setBarcodeCustombarcode1(barcodeCustombarcode1);
            AtenaMeisho 世帯主名1 = param.get送付先情報1().get世帯主名();
            RString setainushiMei1 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名1 ? RString.EMPTY : 世帯主名1.getColumnValue(),
                    getNyujokenHagakiSourceItemLength(長さ_世帯主名1));
            param.setSetainushiMei1(setainushiMei1);
        }
        if (param.get明細情報1() != null) {
            RString meiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get明細情報1().get投票区コード());
            param.setMeiboNo1(meiboNo1);
            List<RString> 投票所名リスト1 = nyujoken3tsuori.getTohyojoMei(param.get明細情報1().get投票所名(), param.get明細情報1().get帳票ID(),
                    getNyujokenHagakiSourceItemLength(長さ_投票所名1), getNyujokenHagakiSourceItemLength(長さ_投票所名2), 0);
            param.setTohyojoMei11(投票所名リスト1.get(ZERO));
            param.setTohyojoMei21(投票所名リスト1.get(ONE));
            param.setTohyojoMei31(投票所名リスト1.get(TWO));
            List<RString> 氏名カナリスト1 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報1().getカナ名称(),
                    getNyujokenHagakiSourceItemLength(長さ_カナ名称1), getNyujokenHagakiSourceItemLength(長さ_カナ名称2));
            param.setShimeiKana11(氏名カナリスト1.get(ZERO));
            param.setShimeiKana21(氏名カナリスト1.get(ONE));

            List<RString> 氏名リスト1 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報1().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2),
                    getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei11(氏名リスト1.get(ZERO));
            param.setShimei21(氏名リスト1.get(ONE));
            param.setShimei31(氏名リスト1.get(TWO));

            RString nyujoukenBarCode1 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報1().get抄本番号(), param.get明細情報1().get識別コード());
            param.setBarcodeNyujokenBarcode1(nyujoukenBarCode1);
            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(param.get明細情報1().get性別コード(), 入場券種類);
            param.setSeibetsu1(性別表示文字1);

            RString sofusakiMeiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get送付先情報1().get送付先投票区コード());
            param.setSofusakiMeiboNo1(sofusakiMeiboNo1);
            List<RString> 住所リスト1 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報1().get住登内住所(),
                    param.get明細情報1().get住登内番地(),
                    param.get明細情報1().get行政区名(),
                    param.get明細情報1().get地区名1(),
                    param.get明細情報1().get地区名2(),
                    param.get明細情報1().get地区名3(),
                    getNyujokenHagakiSourceItemLength(長さ_住所1),
                    getNyujokenHagakiSourceItemLength(長さ_住所2));
            param.setJusho11(住所リスト1.get(ZERO));
            param.setJusho21(住所リスト1.get(ONE));

        }

        return param;
    }

    /**
     * 送付先情報2と明細情報2を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenHagakiParam
     */
    public NyujokenHagakiParam set送付先情報2と明細情報2_はがき4つ切(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報2() != null) {
            SetaiCode 世帯コード2 = param.get送付先情報2().get送付先世帯コード();
            RString setainushiKunbun2 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード2 ? RString.EMPTY : 世帯コード2.getColumnValue());
            param.setSetainushiKubun2(setainushiKunbun2);
            RString mapJoho2 = nyujoken3tsuori.getMapJoho(param.get送付先情報2().get送付先投票区コード());
            param.setMapJoho2(mapJoho2);

            List<RString> 送付先行政区名リスト2 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報2().get送付先行政区名(),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名1),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名2),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名3));
            param.setSofusakiGyoseikuMei12(送付先行政区名リスト2.get(ZERO));
            param.setSofusakiGyoseikuMei22(送付先行政区名リスト2.get(ONE));
            param.setSofusakiGyoseikuMei32(送付先行政区名リスト2.get(TWO));

            List<RString> 宛名リスト2 = nyujoken3tsuori.getAtena(param.get送付先情報2().get送付先宛名(), getNyujokenHagakiSourceItemLength(長さ_宛名1));
            param.setAtena12(宛名リスト2.get(ZERO));
            param.setAtena22(宛名リスト2.get(ONE));
            param.setAtena32(宛名リスト2.get(TWO));

            RString sofusakiMeiboNo2 = nyujoken3tsuori.getTohyokuCode(param.get送付先情報2().get送付先投票区コード());
            param.setSofusakiMeiboNo2(sofusakiMeiboNo2);

            List<RString> 送付先住所情報リスト2 = nyujoken3tsuori.getSofusakiJushoCode(param.get送付先情報2().get送付先住所(), param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書(), param.get送付先情報2().get送付先行政区名(), getNyujokenHagakiSourceItemLength(長さ_送付先住所1));
            param.setSofusakiJusho12(送付先住所情報リスト2.get(ZERO));
            param.setSofusakiJusho22(送付先住所情報リスト2.get(ONE));
            param.setSofusakiJusho32(送付先住所情報リスト2.get(TWO));
            param.setSofusakiJusho42(送付先住所情報リスト2.get(THREE));
            param.setSofusakiJusho52(送付先住所情報リスト2.get(FOUR));

            RString barcodeCustombarcode2 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報2().get送付先郵便番号(),
                    param.get送付先情報2().get送付先住所(),
                    param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書());
            param.setBarcodeCustombarcode2(barcodeCustombarcode2);
            AtenaMeisho 世帯主名2 = param.get送付先情報2().get世帯主名();
            RString setainushiMei2 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名2 ? RString.EMPTY : 世帯主名2.getColumnValue(),
                    getNyujokenHagakiSourceItemLength(長さ_世帯主名2));
            param.setSetainushiMei2(setainushiMei2);

        }
        if (param.get明細情報2() != null) {
            RString meiboNo2 = nyujoken3tsuori.getTohyokuCode(param.get明細情報2().get投票区コード());
            param.setMeiboNo2(meiboNo2);
            List<RString> 投票所名リスト2 = nyujoken3tsuori.getTohyojoMei(param.get明細情報2().get投票所名(), param.get明細情報2().get帳票ID(),
                    getNyujokenHagakiSourceItemLength(長さ_投票所名1), getNyujokenHagakiSourceItemLength(長さ_投票所名2), 0);
            param.setTohyojoMei12(投票所名リスト2.get(ZERO));
            param.setTohyojoMei22(投票所名リスト2.get(ONE));
            param.setTohyojoMei32(投票所名リスト2.get(TWO));
            List<RString> 氏名カナリスト2 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報2().getカナ名称(),
                    getNyujokenHagakiSourceItemLength(長さ_カナ名称1), getNyujokenHagakiSourceItemLength(長さ_カナ名称2));
            param.setShimeiKana12(氏名カナリスト2.get(ZERO));
            param.setShimeiKana22(氏名カナリスト2.get(ONE));

            List<RString> 氏名リスト2 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報2().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2),
                    getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei12(氏名リスト2.get(ZERO));
            param.setShimei22(氏名リスト2.get(ONE));
            param.setShimei32(氏名リスト2.get(TWO));

            RString nyujoukenBarCode2 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
            param.setBarcodeNyujokenBarcode2(nyujoukenBarCode2);

            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(param.get明細情報2().get性別コード(), 入場券種類);
            param.setSeibetsu2(性別表示文字2);

            List<RString> 名称リスト2 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報2().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2), getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei12(名称リスト2.get(ZERO));
            param.setShimei22(名称リスト2.get(ONE));
            param.setShimei32(名称リスト2.get(TWO));

            List<RString> 住所リスト2 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報2().get住登内住所(),
                    param.get明細情報2().get住登内番地(),
                    param.get明細情報2().get行政区名(),
                    param.get明細情報2().get地区名1(),
                    param.get明細情報2().get地区名2(),
                    param.get明細情報2().get地区名3(),
                    getNyujokenHagakiSourceItemLength(長さ_住所1),
                    getNyujokenHagakiSourceItemLength(長さ_住所2));
            param.setJusho12(住所リスト2.get(ZERO));
            param.setJusho22(住所リスト2.get(ONE));

        }

        return param;
    }

    /**
     * 送付先情報3と明細情報3を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenHagakiParam
     */
    public NyujokenHagakiParam set送付先情報3と明細情報3_はがき4つ切(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報3() != null) {
            SetaiCode 世帯コード3 = param.get送付先情報3().get送付先世帯コード();
            RString setainushiKunbun3 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード3 ? RString.EMPTY : 世帯コード3.getColumnValue());
            param.setSetainushiKubun3(setainushiKunbun3);
            RString mapJoho3 = nyujoken3tsuori.getMapJoho(param.get送付先情報3().get送付先投票区コード());
            param.setMapJoho3(mapJoho3);

            List<RString> 送付先行政区名リスト3 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報3().get送付先行政区名(),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名1),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名2),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名3));
            param.setSofusakiGyoseikuMei13(送付先行政区名リスト3.get(ZERO));
            param.setSofusakiGyoseikuMei23(送付先行政区名リスト3.get(ONE));
            param.setSofusakiGyoseikuMei33(送付先行政区名リスト3.get(TWO));

            RString sofusakiMeiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get送付先情報3().get送付先投票区コード());
            param.setSofusakiMeiboNo3(sofusakiMeiboNo3);

            List<RString> 宛名リスト3 = nyujoken3tsuori.getAtena(param.get送付先情報3().get送付先宛名(), getNyujokenHagakiSourceItemLength(長さ_宛名1));
            param.setAtena13(宛名リスト3.get(ZERO));
            param.setAtena23(宛名リスト3.get(ONE));
            param.setAtena33(宛名リスト3.get(TWO));

            List<RString> 送付先住所情報リスト3 = nyujoken3tsuori.getSofusakiJushoCode(param.get送付先情報3().get送付先住所(), param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書(), param.get送付先情報3().get送付先行政区名(), getNyujokenHagakiSourceItemLength(長さ_送付先住所1));
            param.setSofusakiJusho13(送付先住所情報リスト3.get(ZERO));
            param.setSofusakiJusho23(送付先住所情報リスト3.get(ONE));
            param.setSofusakiJusho33(送付先住所情報リスト3.get(TWO));
            param.setSofusakiJusho43(送付先住所情報リスト3.get(THREE));
            param.setSofusakiJusho53(送付先住所情報リスト3.get(FOUR));

            RString barcodeCustombarcode3 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報3().get送付先郵便番号(),
                    param.get送付先情報3().get送付先住所(),
                    param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書());
            param.setBarcodeCustombarcode3(barcodeCustombarcode3);
            AtenaMeisho 世帯主名3 = param.get送付先情報3().get世帯主名();
            RString setainushiMei3 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名3 ? RString.EMPTY : 世帯主名3.getColumnValue(),
                    getNyujokenHagakiSourceItemLength(長さ_世帯主名3));
            param.setSetainushiMei3(setainushiMei3);
        }
        if (param.get明細情報3() != null) {
            RString meiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get明細情報3().get投票区コード());
            param.setMeiboNo3(meiboNo3);
            List<RString> 投票所名リスト3 = nyujoken3tsuori.getTohyojoMei(param.get明細情報3().get投票所名(), param.get明細情報3().get帳票ID(),
                    getNyujokenHagakiSourceItemLength(長さ_投票所名1), getNyujokenHagakiSourceItemLength(長さ_投票所名2), 0);
            param.setTohyojoMei13(投票所名リスト3.get(ZERO));
            param.setTohyojoMei23(投票所名リスト3.get(ONE));
            param.setTohyojoMei33(投票所名リスト3.get(TWO));
            List<RString> 氏名リスト3 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報3().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2), getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei13(氏名リスト3.get(ZERO));
            param.setShimei23(氏名リスト3.get(ONE));
            param.setShimei33(氏名リスト3.get(TWO));

            List<RString> 氏名カナリスト3 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報3().getカナ名称(),
                    getNyujokenHagakiSourceItemLength(長さ_カナ名称1), getNyujokenHagakiSourceItemLength(長さ_カナ名称2));
            param.setShimeiKana13(氏名カナリスト3.get(ZERO));
            param.setShimeiKana23(氏名カナリスト3.get(ONE));

            RString nyujoukenBarCode3 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());
            param.setBarcodeNyujokenBarcode3(nyujoukenBarCode3);

            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(param.get明細情報3().get性別コード(), 入場券種類);
            param.setSeibetsu3(性別表示文字3);

            List<RString> 名称リスト3 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報3().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2), getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei13(名称リスト3.get(ZERO));
            param.setShimei23(名称リスト3.get(ONE));
            param.setShimei33(名称リスト3.get(TWO));

            List<RString> 住所リスト3 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報3().get住登内住所(),
                    param.get明細情報3().get住登内番地(),
                    param.get明細情報3().get行政区名(),
                    param.get明細情報3().get地区名1(),
                    param.get明細情報3().get地区名2(),
                    param.get明細情報3().get地区名3(),
                    getNyujokenHagakiSourceItemLength(長さ_住所1),
                    getNyujokenHagakiSourceItemLength(長さ_住所2));
            param.setJusho13(住所リスト3.get(ZERO));
            param.setJusho23(住所リスト3.get(ONE));
        }

        return param;
    }

    /**
     * 送付先情報4と明細情報4を設定する。
     *
     * @param param NyujokenHagakiParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return NyujokenHagakiParam
     */
    public NyujokenHagakiParam set送付先情報4と明細情報4_はがき4つ切(NyujokenHagakiParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報4() != null) {
            SetaiCode 世帯コード4 = param.get送付先情報4().get送付先世帯コード();
            RString setainushiKunbun4 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード4 ? RString.EMPTY : 世帯コード4.getColumnValue());
            param.setSetainushiKubun4(setainushiKunbun4);

            RString mapJoho4 = nyujoken3tsuori.getMapJoho(param.get送付先情報4().get送付先投票区コード());
            param.setMapJoho4(mapJoho4);

            List<RString> 送付先行政区名リスト4 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報4().get送付先行政区名(),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名1),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名2),
                    getNyujokenHagakiSourceItemLength(長さ_送送付先行政区名3));
            param.setSofusakiGyoseikuMei14(送付先行政区名リスト4.get(ZERO));
            param.setSofusakiGyoseikuMei24(送付先行政区名リスト4.get(ONE));
            param.setSofusakiGyoseikuMei34(送付先行政区名リスト4.get(TWO));

            RString sofusakiMeiboNo4 = nyujoken3tsuori.getTohyokuCode(param.get送付先情報4().get送付先投票区コード());
            param.setSofusakiMeiboNo4(sofusakiMeiboNo4);

            List<RString> 宛名リスト4 = nyujoken3tsuori.getAtena(param.get送付先情報4().get送付先宛名(), getNyujokenHagakiSourceItemLength(長さ_宛名1));
            param.setAtena14(宛名リスト4.get(ZERO));
            param.setAtena24(宛名リスト4.get(ONE));
            param.setAtena34(宛名リスト4.get(TWO));

            List<RString> 送付先住所情報リスト4 = nyujoken3tsuori.getSofusakiJushoCode(param.get送付先情報4().get送付先住所(), param.get送付先情報4().get送付先番地(),
                    param.get送付先情報4().get送付先方書(), param.get送付先情報4().get送付先行政区名(), getNyujokenHagakiSourceItemLength(長さ_送付先住所1));

            param.setSofusakiJusho14(送付先住所情報リスト4.get(ZERO));
            param.setSofusakiJusho24(送付先住所情報リスト4.get(ONE));
            param.setSofusakiJusho34(送付先住所情報リスト4.get(TWO));
            param.setSofusakiJusho44(送付先住所情報リスト4.get(THREE));
            param.setSofusakiJusho54(送付先住所情報リスト4.get(FOUR));

            RString barcodeCustombarcode4 = nyujoken3tsuori.getCustomBarCode(param.get送付先情報4().get送付先郵便番号(),
                    param.get送付先情報4().get送付先住所(),
                    param.get送付先情報4().get送付先番地(),
                    param.get送付先情報4().get送付先方書());
            param.setBarcodeCustombarcode4(barcodeCustombarcode4);
            AtenaMeisho 世帯主名4 = param.get送付先情報4().get世帯主名();
            RString setainushiMei4 = nyujoken3tsuori.getSetainushiMei(null == 世帯主名4 ? RString.EMPTY : 世帯主名4.getColumnValue(),
                    getNyujokenHagakiSourceItemLength(長さ_世帯主名4));
            param.setSetainushiMei4(setainushiMei4);
        }
        if (param.get明細情報4() != null) {
            RString meiboNo4 = nyujoken3tsuori.getTohyokuCode(param.get明細情報4().get投票区コード());
            param.setMeiboNo4(meiboNo4);
            List<RString> 投票所名リスト4 = nyujoken3tsuori.getTohyojoMei(param.get明細情報4().get投票所名(), param.get明細情報4().get帳票ID(),
                    getNyujokenHagakiSourceItemLength(長さ_投票所名1), getNyujokenHagakiSourceItemLength(長さ_投票所名2), 0);

            param.setTohyojoMei14(投票所名リスト4.get(ZERO));
            param.setTohyojoMei24(投票所名リスト4.get(ONE));
            param.setTohyojoMei34(投票所名リスト4.get(TWO));

            List<RString> 氏名リスト4 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報4().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2), getNyujokenHagakiSourceItemLength(長さ_名称3));
            param.setShimei14(氏名リスト4.get(ZERO));
            param.setShimei24(氏名リスト4.get(ONE));
            param.setShimei34(氏名リスト4.get(TWO));
            List<RString> 氏名カナリスト4 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報4().getカナ名称(),
                    getNyujokenHagakiSourceItemLength(長さ_カナ名称1), getNyujokenHagakiSourceItemLength(長さ_カナ名称2));
            param.setShimeiKana14(氏名カナリスト4.get(ZERO));
            param.setShimeiKana24(氏名カナリスト4.get(ONE));
            RString nyujoukenBarCode4 = nyujoken3tsuori.getNyujokenBarCode(param.get明細情報4().get抄本番号(), param.get明細情報4().get識別コード());
            param.setBarcodeNyujokenBarcode4(nyujoukenBarCode4);

            RString 性別表示文字4 = nyujoken3tsuori.getSeibetu(param.get明細情報4().get性別コード(), 入場券種類);
            param.setSeibetsu4(性別表示文字4);

            List<RString> 名称リスト4 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報4().get名称(),
                    getNyujokenHagakiSourceItemLength(長さ_名称1), getNyujokenHagakiSourceItemLength(長さ_名称2), getNyujokenHagakiSourceItemLength(長さ_名称3));

            param.setShimei14(名称リスト4.get(ZERO));
            param.setShimei24(名称リスト4.get(ONE));
            param.setShimei34(名称リスト4.get(TWO));

            List<RString> 住所リスト4 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報4().get住登内住所(),
                    param.get明細情報4().get住登内番地(),
                    param.get明細情報4().get行政区名(),
                    param.get明細情報4().get地区名1(),
                    param.get明細情報4().get地区名2(),
                    param.get明細情報4().get地区名3(),
                    getNyujokenHagakiSourceItemLength(長さ_住所1),
                    getNyujokenHagakiSourceItemLength(長さ_住所2));
            param.setJusho14(住所リスト4.get(ZERO));
            param.setJusho24(住所リスト4.get(ONE));
        }

        return param;
    }

    private int getNyujokenHagakiSourceItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NyujokenHagakiSource.class, itemName);
    }
}
