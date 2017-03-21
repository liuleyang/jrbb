package jp.co.ndensan.reams.af.afa.service.report.AFAPRB201;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class Nyujoken3tsuoriPrintEditor {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho11");
    private static final RString 長さ_送付先住所2 = new RString("sofusakiJusho12");
    private static final RString 長さ_送付先住所3 = new RString("sofusakiJusho13");
    private static final RString 入場券種類 = new RString("1");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_世帯主名2 = new RString("setainushiMei2");
    private static final RString 長さ_世帯主名3 = new RString("setainushiMei3");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");
    private static final RString 長さ_投票所名1 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名2 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名3 = new RString("tohyojoMei13");
    private static final RString 長さ_名称1 = new RString("shimei11");
    private static final RString 長さ_名称2 = new RString("shimei21");
    private static final RString 長さ_名称3 = new RString("shimei31");
    private static final RString 長さ_送送付先行政区名1 = new RString("sofusakiGyoseikuMei11");
    private static final RString 長さ_送送付先行政区名2 = new RString("sofusakiGyoseikuMei21");
    private static final RString 長さ_送送付先行政区名3 = new RString("sofusakiGyoseikuMei31");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_宛名2 = new RString("atena21");
    private static final RString 長さ_宛名3 = new RString("atena31");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_住所2 = new RString("jusho21");

    /**
     * 投票所入場券（個票3つ折り）
     *
     * @param nyujoken3tsuoriList List<Nyujoken3tsuoriParam>
     * @param 地方公共団体情報 Association
     * @return List<Nyujoken3tsuoriParam>
     */
    public List<Nyujoken3tsuoriParam> printFor投票所入場券_個票3つ折り(List<Nyujoken3tsuoriParam> nyujoken3tsuoriList, Association 地方公共団体情報) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        for (Nyujoken3tsuoriParam param : nyujoken3tsuoriList) {
            param = set送付先情報1と明細情報1_個票3つ折り(param, nyujoken3tsuori);
            param = set送付先情報2と明細情報2_個票3つ折り(param, nyujoken3tsuori);
            param = set送付先情報3と明細情報3_個票3つ折り(param, nyujoken3tsuori);
            param.set地方公共団体情報(地方公共団体情報);
        }
        return nyujoken3tsuoriList;
    }

    /**
     * 送付先情報1と明細情報1_個票3つ折りの編集。
     *
     * @param param Nyujoken3tsuoriParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return Nyujoken3tsuoriParam
     */
    public Nyujoken3tsuoriParam set送付先情報1と明細情報1_個票3つ折り(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報1() != null) {
            SetaiCode 世帯コード1 = param.get送付先情報1().get送付先世帯コード();
            RString setainushiKunbun1 = nyujoken3tsuori.getSetainushiKubun(
                    null == 世帯コード1 ? RString.EMPTY : 世帯コード1.getColumnValue());
            param.setSetainushiKubun1(setainushiKunbun1);
            List<RString> 送付先住所リスト1 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書(),
                    param.get送付先情報1().get送付先行政区名(),
                    getNyujoken3tsuoriItemLength(長さ_送付先住所1));
            param.setSofusakiJusho11(送付先住所リスト1.get(ZERO));
            param.setSofusakiJusho21(送付先住所リスト1.get(ONE));
            param.setSofusakiJusho31(送付先住所リスト1.get(TWO));
            param.setSofusakiJusho41(送付先住所リスト1.get(THREE));
            param.setSofusakiJusho51(送付先住所リスト1.get(FOUR));
            YubinNo 郵便番号1 = param.get送付先情報1().get送付先郵便番号();
            RString barcodeCustombarcode1 = nyujoken3tsuori.getCustomBarCode(
                    郵便番号1 == null ? YubinNo.EMPTY : 郵便番号1,
                    param.get送付先情報1().get送付先住所(),
                    param.get送付先情報1().get送付先番地(),
                    param.get送付先情報1().get送付先方書());
            param.setBarcodeCustombarcode1(barcodeCustombarcode1);

            List<RString> 送付先行政区名リスト1 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報1().get送付先行政区名(),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名1),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名2),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名3));
            param.setSofusakiGyoseikuMei11(送付先行政区名リスト1.get(ZERO));
            param.setSofusakiGyoseikuMei21(送付先行政区名リスト1.get(ONE));
            param.setSofusakiGyoseikuMei31(送付先行政区名リスト1.get(TWO));
            List<RString> 宛名リスト1 = nyujoken3tsuori.getAtena(
                    param.get送付先情報1().get送付先宛名(),
                    getNyujoken3tsuoriItemLength(長さ_宛名1));
            param.setAtena11(宛名リスト1.get(ZERO));
            param.setAtena21(宛名リスト1.get(ONE));
            param.setAtena31(宛名リスト1.get(TWO));

            RString sofusakiMeiboNo1 = nyujoken3tsuori.getTohyokuCode(param.get送付先情報1().get送付先投票区コード());
            param.setSofusakiMeiboNo1(sofusakiMeiboNo1);
            RString 送付先投票区コード = param.get送付先情報1().get送付先投票区コード();
            RString mapJoho1 = nyujoken3tsuori.getMapJoho(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);
            RString meiboNo1 = nyujoken3tsuori.getTohyokuCode(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);

            param.setMeiboNo1(meiboNo1);

            param.setMapJoho1(mapJoho1);
            AtenaMeisho 世帯主名1 = param.get送付先情報1().get世帯主名();
            RString setainushiMei1 = nyujoken3tsuori.getSetainushiMei(
                    null == 世帯主名1 ? RString.EMPTY : 世帯主名1.getColumnValue(),
                    getNyujoken3tsuoriItemLength(長さ_世帯主名1));
            param.setSetainushiMei1(setainushiMei1);

        }
        if (param.get明細情報1() != null) {
            RString 生年月日1 = nyujoken3tsuori.getSeinengappi(
                    param.get明細情報1().get住民種別コード(),
                    param.get明細情報1().get生年月日());
            List<RString> 投票所名リスト1 = nyujoken3tsuori.getTohyojoMei(
                    param.get明細情報1().get投票所名(),
                    param.get明細情報1().get帳票ID(),
                    getNyujoken3tsuoriItemLength(長さ_投票所名1),
                    getNyujoken3tsuoriItemLength(長さ_投票所名2),
                    getNyujoken3tsuoriItemLength(長さ_投票所名3));
            RString 性別表示文字1 = nyujoken3tsuori.getSeibetu(param.get明細情報1().get性別コード(), 入場券種類);

            RString nyujoukenBarCode1 = nyujoken3tsuori.getNyujokenBarCode(
                    param.get明細情報1().get抄本番号(),
                    param.get明細情報1().get識別コード());

            param.setBarcodeNyujokenBarcode1(nyujoukenBarCode1);

            param.setSeinengappi1(生年月日1);
            param.setSeibetsu1(性別表示文字1);
            param.setTohyojoMei11(投票所名リスト1.get(ZERO));
            param.setTohyojoMei21(投票所名リスト1.get(ONE));

            List<RString> 住所リスト1 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報1().get住登内住所(), param.get明細情報1().get住登内番地(),
                    param.get明細情報1().get行政区名(), param.get明細情報1().get地区名1(), param.get明細情報1().get地区名2(),
                    param.get明細情報1().get地区名3(),
                    getNyujoken3tsuoriItemLength(長さ_住所1), getNyujoken3tsuoriItemLength(長さ_住所2));
            param.setJusho11(住所リスト1.get(ZERO));
            param.setJusho21(住所リスト1.get(ONE));

            List<RString> 氏名カナリスト1 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報1().getカナ名称(),
                    getNyujoken3tsuoriItemLength(長さ_カナ名称1), getNyujoken3tsuoriItemLength(長さ_カナ名称2));
            param.setShimeiKana11(氏名カナリスト1.get(ZERO));
            param.setShimeiKana21(氏名カナリスト1.get(ONE));

            List<RString> 氏名リスト1 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報1().get名称(),
                    getNyujoken3tsuoriItemLength(長さ_名称1), getNyujoken3tsuoriItemLength(長さ_名称2), getNyujoken3tsuoriItemLength(長さ_名称3));
            param.setShimei11(氏名リスト1.get(ZERO));
            param.setShimei21(氏名リスト1.get(ONE));
            param.setShimei31(氏名リスト1.get(TWO));
        }

        return param;
    }

    /**
     * 送付先情報2と明細情報2_個票3つ折りの編集。
     *
     * @param param Nyujoken3tsuoriParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return Nyujoken3tsuoriParam
     */
    public Nyujoken3tsuoriParam set送付先情報2と明細情報2_個票3つ折り(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (param.get送付先情報2() != null) {
            SetaiCode 世帯コード2 = param.get送付先情報2().get送付先世帯コード();
            RString setainushiKunbun2 = nyujoken3tsuori.getSetainushiKubun(null == 世帯コード2 ? RString.EMPTY : 世帯コード2.getColumnValue());
            param.setSetainushiKubun2(setainushiKunbun2);
            List<RString> 送付先住所リスト2 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報2().get送付先住所(),
                    param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書(),
                    param.get送付先情報2().get送付先行政区名(),
                    getNyujoken3tsuoriItemLength(長さ_送付先住所2));

            YubinNo 郵便番号2 = param.get送付先情報2().get送付先郵便番号();
            RString barcodeCustombarcode2 = nyujoken3tsuori.getCustomBarCode(
                    郵便番号2 == null ? YubinNo.EMPTY : 郵便番号2,
                    param.get送付先情報2().get送付先住所(),
                    param.get送付先情報2().get送付先番地(),
                    param.get送付先情報2().get送付先方書());
            List<RString> 送付先行政区名リスト2 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報2().get送付先行政区名(),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名1),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名2),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名3));
            param.setBarcodeCustombarcode2(barcodeCustombarcode2);
            param.setSofusakiGyoseikuMei21(送付先行政区名リスト2.get(ZERO));
            param.setSofusakiGyoseikuMei22(送付先行政区名リスト2.get(ONE));
            param.setSofusakiGyoseikuMei32(送付先行政区名リスト2.get(TWO));
            List<RString> 宛名リスト2 = nyujoken3tsuori.getAtena(
                    param.get送付先情報2().get送付先宛名(), getNyujoken3tsuoriItemLength(長さ_宛名2));
            param.setAtena12(宛名リスト2.get(ZERO));
            param.setAtena22(宛名リスト2.get(ONE));
            param.setAtena32(宛名リスト2.get(TWO));
            RString 送付先投票区コード = param.get送付先情報2().get送付先投票区コード();
            RString sofusakiMeiboNo2 = nyujoken3tsuori.getTohyokuCode(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);
            RString mapJoho2 = nyujoken3tsuori.getMapJoho(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);
            RString meiboNo2 = nyujoken3tsuori.getTohyokuCode(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);
            param.setSofusakiMeiboNo2(sofusakiMeiboNo2);
            param.setMapJoho2(mapJoho2);
            param.setMeiboNo2(meiboNo2);
            param.setSofusakiJusho12(送付先住所リスト2.get(ZERO));
            param.setSofusakiJusho22(送付先住所リスト2.get(ONE));
            param.setSofusakiJusho32(送付先住所リスト2.get(TWO));
            param.setSofusakiJusho42(送付先住所リスト2.get(THREE));
            param.setSofusakiJusho52(送付先住所リスト2.get(FOUR));

            AtenaMeisho 世帯主名2 = param.get送付先情報2().get世帯主名();
            RString setainushiMei2 = nyujoken3tsuori.getSetainushiMei(
                    null == 世帯主名2 ? RString.EMPTY : 世帯主名2.getColumnValue(),
                    getNyujoken3tsuoriItemLength(長さ_世帯主名2));
            param.setSetainushiMei2(setainushiMei2);

        }
        if (param.get明細情報2() != null) {
            RString 生年月日2 = nyujoken3tsuori.getSeinengappi(
                    param.get明細情報2().get住民種別コード(),
                    param.get明細情報2().get生年月日());

            List<RString> 投票所名リスト2 = nyujoken3tsuori.getTohyojoMei(
                    param.get明細情報2().get投票所名(),
                    param.get明細情報2().get帳票ID(),
                    getNyujoken3tsuoriItemLength(長さ_投票所名1),
                    getNyujoken3tsuoriItemLength(長さ_投票所名2),
                    getNyujoken3tsuoriItemLength(長さ_投票所名3));

            RString 性別表示文字2 = nyujoken3tsuori.getSeibetu(param.get明細情報2().get性別コード(), 入場券種類);

            RString nyujoukenBarCode2 = nyujoken3tsuori.getNyujokenBarCode(
                    param.get明細情報2().get抄本番号(), param.get明細情報2().get識別コード());
            List<RString> 住所リスト2 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報2().get住登内住所(),
                    param.get明細情報2().get住登内番地(),
                    param.get明細情報2().get行政区名(),
                    param.get明細情報2().get地区名1(),
                    param.get明細情報2().get地区名2(),
                    param.get明細情報2().get地区名3(),
                    getNyujoken3tsuoriItemLength(長さ_住所1),
                    getNyujoken3tsuoriItemLength(長さ_住所2));
            param.setJusho12(住所リスト2.get(ZERO));
            param.setJusho22(住所リスト2.get(ONE));
            List<RString> 氏名カナリスト2 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報2().getカナ名称(),
                    getNyujoken3tsuoriItemLength(長さ_カナ名称1), getNyujoken3tsuoriItemLength(長さ_カナ名称2));
            List<RString> 氏名リスト2 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報2().get名称(),
                    getNyujoken3tsuoriItemLength(長さ_名称1), getNyujoken3tsuoriItemLength(長さ_名称2), getNyujoken3tsuoriItemLength(長さ_名称3));
            param.setShimei12(氏名リスト2.get(ZERO));
            param.setShimei22(氏名リスト2.get(ONE));
            param.setShimei32(氏名リスト2.get(TWO));
            param.setShimeiKana12(氏名カナリスト2.get(ZERO));
            param.setShimeiKana22(氏名カナリスト2.get(ONE));

            param.setBarcodeNyujokenBarcode2(nyujoukenBarCode2);

            param.setSeinengappi2(生年月日2);
            param.setSeibetsu2(性別表示文字2);
            param.setTohyojoMei12(投票所名リスト2.get(ZERO));
            param.setTohyojoMei22(投票所名リスト2.get(ONE));
        }

        return param;

    }

    /**
     * 送付先情報3と明細情報3_個票3つ折りの編集。
     *
     * @param param Nyujoken3tsuoriParam
     * @param nyujoken3tsuori Nyujoken3tsuori
     * @return Nyujoken3tsuoriParam
     */
    public Nyujoken3tsuoriParam set送付先情報3と明細情報3_個票3つ折り(Nyujoken3tsuoriParam param, Nyujoken3tsuori nyujoken3tsuori) {

        if (param.get送付先情報3() != null) {
            SetaiCode 世帯コード3 = param.get送付先情報3().get送付先世帯コード();
            List<RString> 送付先住所リスト3 = nyujoken3tsuori.getSofusakiJushoCode(
                    param.get送付先情報3().get送付先住所(),
                    param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書(),
                    param.get送付先情報3().get送付先行政区名(),
                    getNyujoken3tsuoriItemLength(長さ_送付先住所3));
            RString setainushiKunbun3 = nyujoken3tsuori.getSetainushiKubun(
                    null == 世帯コード3 ? RString.EMPTY : 世帯コード3.getColumnValue());
            param.setSetainushiKubun3(setainushiKunbun3);
            param.setSofusakiJusho13(送付先住所リスト3.get(ZERO));
            param.setSofusakiJusho23(送付先住所リスト3.get(ONE));
            param.setSofusakiJusho33(送付先住所リスト3.get(TWO));
            param.setSofusakiJusho43(送付先住所リスト3.get(THREE));
            param.setSofusakiJusho53(送付先住所リスト3.get(FOUR));
            YubinNo 郵便番号3 = param.get送付先情報3().get送付先郵便番号();
            RString barcodeCustombarcode3 = nyujoken3tsuori.getCustomBarCode(
                    郵便番号3 == null ? YubinNo.EMPTY : 郵便番号3,
                    param.get送付先情報3().get送付先住所(),
                    param.get送付先情報3().get送付先番地(),
                    param.get送付先情報3().get送付先方書());
            List<RString> 送付先行政区名リスト3 = nyujoken3tsuori.getSofusakiGyoseikuName(
                    param.get送付先情報3().get送付先行政区名(),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名1),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名2),
                    getNyujoken3tsuoriItemLength(長さ_送送付先行政区名3));
            List<RString> 宛名リスト3 = nyujoken3tsuori.getAtena(
                    param.get送付先情報3().get送付先宛名(), getNyujoken3tsuoriItemLength(長さ_宛名3));
            param.setBarcodeCustombarcode3(barcodeCustombarcode3);

            param.setSofusakiGyoseikuMei13(送付先行政区名リスト3.get(ZERO));
            param.setSofusakiGyoseikuMei23(送付先行政区名リスト3.get(ONE));
            param.setSofusakiGyoseikuMei33(送付先行政区名リスト3.get(TWO));

            param.setAtena13(宛名リスト3.get(ZERO));
            param.setAtena23(宛名リスト3.get(ONE));
            param.setAtena33(宛名リスト3.get(TWO));
            RString 送付先投票区コード = param.get送付先情報3().get送付先投票区コード();
            RString sofusakiMeiboNo3 = nyujoken3tsuori.getTohyokuCode(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);
            RString mapJoho3 = nyujoken3tsuori.getMapJoho(送付先投票区コード == null ? RString.EMPTY : 送付先投票区コード);
            param.setSofusakiMeiboNo3(sofusakiMeiboNo3);
            param.setMapJoho3(mapJoho3);
            AtenaMeisho 世帯主名3 = param.get送付先情報3().get世帯主名();
            RString setainushiMei3 = nyujoken3tsuori.getSetainushiMei(
                    null == 世帯主名3 ? RString.EMPTY : 世帯主名3.getColumnValue(),
                    getNyujoken3tsuoriItemLength(長さ_世帯主名3));
            param.setSetainushiMei3(setainushiMei3);

        }
        if (param.get明細情報3() != null) {
            RString 生年月日3 = nyujoken3tsuori.getSeinengappi(param.get明細情報3().get住民種別コード(), param.get明細情報3().get生年月日());
            List<RString> 投票所名リスト3 = nyujoken3tsuori.getTohyojoMei(
                    param.get明細情報3().get投票所名(),
                    param.get明細情報3().get帳票ID(),
                    getNyujoken3tsuoriItemLength(長さ_投票所名1),
                    getNyujoken3tsuoriItemLength(長さ_投票所名2),
                    getNyujoken3tsuoriItemLength(長さ_投票所名3));
            RString 性別表示文字3 = nyujoken3tsuori.getSeibetu(
                    param.get明細情報3().get性別コード(), 入場券種類);

            param.setSeinengappi3(生年月日3);
            param.setSeibetsu3(性別表示文字3);
            param.setTohyojoMei13(投票所名リスト3.get(ZERO));
            param.setTohyojoMei23(投票所名リスト3.get(ONE));
            RString meiboNo3 = nyujoken3tsuori.getTohyokuCode(param.get明細情報3().get投票区コード());
            RString nyujoukenBarCode3 = nyujoken3tsuori.getNyujokenBarCode(
                    param.get明細情報3().get抄本番号(), param.get明細情報3().get識別コード());

            param.setMeiboNo3(meiboNo3);
            param.setBarcodeNyujokenBarcode3(nyujoukenBarCode3);

            List<RString> 住所リスト3 = nyujoken3tsuori.getMeisaiJusho(
                    param.get明細情報3().get住登内住所(), param.get明細情報3().get住登内番地(),
                    param.get明細情報3().get行政区名(), param.get明細情報3().get地区名1(), param.get明細情報3().get地区名2(),
                    param.get明細情報3().get地区名3(),
                    getNyujoken3tsuoriItemLength(長さ_住所1),
                    getNyujoken3tsuoriItemLength(長さ_住所2));

            param.setJusho13(住所リスト3.get(ZERO));
            param.setJusho23(住所リスト3.get(ONE));
            List<RString> 氏名カナリスト3 = nyujoken3tsuori.getMeisaiKanaMeisho(param.get明細情報3().getカナ名称(),
                    getNyujoken3tsuoriItemLength(長さ_カナ名称1), getNyujoken3tsuoriItemLength(長さ_カナ名称2));
            List<RString> 氏名リスト3 = nyujoken3tsuori.getMeisaiShimei(param.get明細情報3().get名称(),
                    getNyujoken3tsuoriItemLength(長さ_名称1), getNyujoken3tsuoriItemLength(長さ_名称2), getNyujoken3tsuoriItemLength(長さ_名称3));
            param.setShimei13(氏名リスト3.get(ZERO));
            param.setShimei23(氏名リスト3.get(ONE));
            param.setShimei33(氏名リスト3.get(TWO));
            param.setShimeiKana13(氏名カナリスト3.get(ZERO));
            param.setShimeiKana23(氏名カナリスト3.get(ONE));
        }

        return param;

    }

    private int getNyujoken3tsuoriItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(Nyujoken3tsuoriSource.class, itemName);
    }
}
