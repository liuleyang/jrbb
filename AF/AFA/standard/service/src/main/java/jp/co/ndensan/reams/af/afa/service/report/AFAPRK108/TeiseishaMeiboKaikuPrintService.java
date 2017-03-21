package jp.co.ndensan.reams.af.afa.service.report.AFAPRK108;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TeiseishaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK108.TeiseishaMeiboKaikuPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK108.TeiseishaMeiboKaikuReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108.TeiseishaMeiboKaikuSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 訂正者名簿
 *
 * @reamsid_L AF-0460-035 wanghj
 */
public class TeiseishaMeiboKaikuPrintService {

//    private static final int ZERO_NUMBER = 0;
//    private static final int ONE_NUMBER = 1;
//    private static final int TWO_NUMBER = 2;
//    private static final int THREE_NUMBER = 3;
//    private static final int 投票区項目サイズ = 4;
//    private static final int 漁業者項目サイズ = 4;
//    private static final int NINE = 9;
//    private static final int EIGHT = 8;
//    private static final int FIFTEEN = 15;
//    private static final int 性別項目サイズ = 1;
//    private static final RString ZONE = new RString("01");
//    private static final RString ONE = new RString("1");
//    private static final RString ZTWO = new RString("02");
//    private static final RString TWO = new RString("2");
//    private static final RString 全角スペース = new RString("　");
//    private static final RString 空白 = new RString(" ");
//    private static final RString 横線_EIGHT = new RString("--------");
//    private static final RString 住所訂正前 = new RString("listTeiseiBeforeMeisai1_4");
//    private static final RString 住所訂正後 = new RString("listTeiseiAfterMeisai1_4");
//    private static final RString 氏名訂正後 = new RString("listTeiseiAfterMeisai1_5");
    /**
     * 訂正者名簿
     *
     * @param shisetsuSofushoList List<TeiseishaMeiboKaikuParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TeiseishaMeiboKaikuParam> shisetsuSofushoList) {
        try (ReportManager reportManager = new ReportManager()) {
            TeiseishaMeiboKaikuPorperty property = new TeiseishaMeiboKaikuPorperty();
            try (ReportAssembler<TeiseishaMeiboKaikuSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<TeiseishaMeiboKaikuSource> reportSourceWriter = new ReportSourceWriter(assembler);

//                IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
//                for (TeiseishaMeiboKaikuParam param : shisetsuSofushoList) {
//                    if (!param.is空白行()) {
//                        帳票共通ヘッダー = create帳票共通ヘッダー();
//                        List<RString> 地区リスト = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正前());
//                        if (null != 地区リスト) {
//                            param.set地区コード(地区リスト.get(ZERO_NUMBER));
//                            param.set地区コード名(地区リスト.get(ONE_NUMBER));
//                            param.set地区(地区リスト.get(TWO_NUMBER));
//                            param.set地区名(地区リスト.get(THREE_NUMBER));
//                        }
//                        set投票区訂正後(param, idouSenkyoninIchiran);
//                        set住所コード訂正後(param, idouSenkyoninIchiran);
//                        set世帯コード訂正後(param, idouSenkyoninIchiran);
//                        set氏名訂正後(param, idouSenkyoninIchiran);
//                        set性別訂正後(param, idouSenkyoninIchiran);
//                        set表示年月日訂正後(param, idouSenkyoninIchiran);
//                        set識別コード訂正後(param, idouSenkyoninIchiran);
//                        set漁業者訂正後(param, idouSenkyoninIchiran);
//                        set従事者訂正後(param, idouSenkyoninIchiran);
//                        set住所(param, idouSenkyoninIchiran);
//                        set生年月日(param, idouSenkyoninIchiran);
//                        set明細タイトル年月日(param, idouSenkyoninIchiran);
//                        set地区コード名(param, idouSenkyoninIchiran);
//                        set明細４列目(param, idouSenkyoninIchiran);
//                        set地区名(param, idouSenkyoninIchiran);
//                        set作成条件(param, idouSenkyoninIchiran);
//                    }
//                }
                for (TeiseishaMeiboKaikuReport report : toReports(shisetsuSofushoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }
//
//    private void set作成条件(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前() && null != param.get海区選挙人名簿訂正後()) {
//            param.set作成条件(idouSenkyoninIchiran.get作成条件(param.get帳票ID(), param.get事由コード(),
//                    param.get海区選挙人名簿情報訂正前()));
//        }
//    }
//
//    private void set従事者訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前()) {
//            param.set従事者漁業日数訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get漁業日数_漁業従事者(),
//                    null, 漁業者項目サイズ));
//            if (null != param.get海区選挙人名簿訂正後()) {
//                param.set従事者漁業日数訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get漁業日数_漁業従事者(),
//                        param.get海区選挙人名簿訂正後().get漁業日数_漁業従事者(), 漁業者項目サイズ));
//            }
//        }
//    }
//
//    private void set漁業者訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前()) {
//            param.set漁業者漁業日数訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get漁業日数_漁業者(),
//                    null, 漁業者項目サイズ));
//            if (null != param.get海区選挙人名簿訂正後()) {
//                param.set漁業者漁業日数訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get漁業日数_漁業者(),
//                        param.get海区選挙人名簿訂正後().get漁業日数_漁業者(), 漁業者項目サイズ));
//            }
//        }
//    }
//
//    private void set地区名(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿情報訂正前()) {
//            List<RString> 地区名リスト = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正前());
//            param.set地区名訂正前(地区名リスト.get(THREE_NUMBER));
//            RString 地区名訂正後1 = idouSenkyoninIchiran.set訂正後情報(地区名リスト.get(THREE_NUMBER),
//                    null, NINE);
//            param.set地区名訂正後(地区名訂正後1);
//            if (null != param.get海区選挙人名簿情報訂正後() && null != param.get海区選挙人名簿訂正後()) {
//                List<RString> 地区名リスト訂正前 = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正前());
//                List<RString> 地区名リスト訂正後 = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正後());
//                RString 地区名訂正後 = idouSenkyoninIchiran.set訂正後情報(地区名リスト訂正前.get(THREE_NUMBER),
//                        地区名リスト訂正後.get(THREE_NUMBER), NINE);
//                param.set地区名訂正後(地区名訂正後);
//            }
//        }
//    }
//
//    private void set明細４列目(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前()) {
//            RString 文字列訂正前 = changeNullToEmpty(param.get海区選挙人名簿訂正前().get住登内住所()).replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY)
//                    .concat(changeNullToEmpty(param.get海区選挙人名簿訂正前().get住登内番地()))
//                    .replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY).concat(全角スペース)
//                    .concat(changeNullToEmpty(param.get海区選挙人名簿訂正前().get住登内方書()));
//            List<RString> 文字列リスト = idouSenkyoninIchiran.文字列分割(文字列訂正前, getItemLength(住所訂正前));
//            param.set明細４列目訂正前(文字列リスト.get(ZERO_NUMBER));
//
//            RString 文字列1 = idouSenkyoninIchiran.set訂正後情報(文字列訂正前, null, getItemLength(住所訂正後));
//            List<RString> 文字列リスト1 = idouSenkyoninIchiran.文字列分割(文字列1, getItemLength(住所訂正後));
//            param.set明細４列目訂正後(文字列リスト1.get(ZERO_NUMBER));
//
//            if (null != param.get海区選挙人名簿訂正後()) {
//                RString 文字列訂正後 = changeNullToEmpty(param.get海区選挙人名簿訂正後().get住登内住所()).replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY)
//                        .concat(changeNullToEmpty(param.get海区選挙人名簿訂正後().get住登内番地()))
//                        .replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY).concat(全角スペース)
//                        .concat(changeNullToEmpty(param.get海区選挙人名簿訂正後().get住登内方書()));
//
//                RString 文字列 = idouSenkyoninIchiran.set訂正後情報(文字列訂正前, 文字列訂正後, getItemLength(住所訂正後));
//                List<RString> 文字列リスト2 = idouSenkyoninIchiran.文字列分割(文字列, getItemLength(住所訂正後));
//                param.set明細４列目訂正後(文字列リスト2.get(ZERO_NUMBER));
//            }
//        }
//    }
//
//    private void set識別コード訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前()
//                && null != param.get海区選挙人名簿訂正前().get識別コード()) {
//            param.set識別コード訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get識別コード().getColumnValue(),
//                    null, FIFTEEN));
//            if (null != param.get海区選挙人名簿訂正後() && null != param.get海区選挙人名簿訂正後().get識別コード()) {
//                param.set識別コード訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get識別コード().getColumnValue(),
//                        param.get海区選挙人名簿訂正後().get識別コード().getColumnValue(), FIFTEEN));
//            }
//        }
//    }
//
//    private void set地区コード名(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿情報訂正前()) {
//            List<RString> 地区コード名訂正前 = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正前());
//            param.set地区コード名訂正前(地区コード名訂正前.get(ONE_NUMBER));
//            param.set地区コード名訂正後(idouSenkyoninIchiran.set訂正後情報(地区コード名訂正前.get(ONE_NUMBER),
//                    null, NINE));
//            if (null != param.get海区選挙人名簿情報訂正後() && null != param.get海区選挙人名簿訂正後()) {
//                List<RString> 地区コード名訂正前1 = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正前());
//                List<RString> 地区コード名訂正後 = idouSenkyoninIchiran.is行政区_地区(param.get海区選挙人名簿情報訂正後());
//                param.set地区コード名訂正後(idouSenkyoninIchiran.set訂正後情報(地区コード名訂正前1.get(ONE_NUMBER),
//                        地区コード名訂正後.get(ONE_NUMBER), NINE));
//            }
//        }
//    }
//
//    private void set表示年月日訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿情報訂正前()
//                && null != param.get海区選挙人名簿情報訂正前().getSenkyoShikakuEntity()) {
//            FlexibleDate 海区選挙人名簿情報訂正前 = param.get海区選挙人名簿情報訂正前().getSenkyoShikakuEntity().getHyojiYMD();
//            RString 海区選挙人名簿情報訂正前RStr = null;
//            if (海区選挙人名簿情報訂正前 != null) {
//                海区選挙人名簿情報訂正前RStr = new RString(海区選挙人名簿情報訂正前.toString());
//            }
//            RString 表示年月日1 = idouSenkyoninIchiran.set訂正後情報(
//                    海区選挙人名簿情報訂正前RStr,
//                    null, EIGHT);
//            param.set表示年月日訂正後(edit年月日(表示年月日1));
//
//            if (null != param.get海区選挙人名簿情報訂正後()
//                    && null != param.get海区選挙人名簿情報訂正後().getSenkyoShikakuEntity()) {
//                FlexibleDate 海区選挙人名簿情報訂正後 = param.get海区選挙人名簿情報訂正後().getSenkyoShikakuEntity().getHyojiYMD();
//                RString 海区選挙人名簿情報訂正後RStr = null == 海区選挙人名簿情報訂正後 ? RString.EMPTY : new RString(海区選挙人名簿情報訂正後.toString());
//
//                RString 表示年月日 = idouSenkyoninIchiran.set訂正後情報(
//                        海区選挙人名簿情報訂正前RStr,
//                        海区選挙人名簿情報訂正後RStr, EIGHT);
//                param.set表示年月日訂正後(edit年月日(表示年月日));
//            }
//
//        }
//    }
//
//    private void set明細タイトル年月日(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (ZONE.equals(param.get事由コード()) && null != param.get海区選挙人名簿訂正前()
//                && null != param.get海区選挙人名簿訂正前().get住定届出年月日()) {
//            param.set明細タイトル年月日訂正前(param.get海区選挙人名簿訂正前().get住定届出年月日().wareki().toDateString());
//        } else if (ZTWO.equals(param.get事由コード())) {
//            if (ONE.equals(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体)) && null != param.get海区選挙人名簿訂正前()
//                    && null != param.get海区選挙人名簿訂正前().get登録届出年月日()) {
//                param.set明細タイトル年月日訂正前(param.get海区選挙人名簿訂正前().get登録届出年月日().wareki().toDateString());
//            }
//            if (TWO.equals(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体)) && null != param.get海区選挙人名簿訂正前()
//                    && null != param.get海区選挙人名簿訂正前().get登録異動年月日()) {
//                param.set明細タイトル年月日訂正前(param.get海区選挙人名簿訂正前().get登録異動年月日().wareki().toDateString());
//            }
//        }
//        edit明細タイトル年月日訂正後(param, idouSenkyoninIchiran);
//    }
//
//    private void edit明細タイトル年月日訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (ZONE.equals(param.get事由コード()) && null != param.get海区選挙人名簿訂正後()
//                && null != param.get海区選挙人名簿訂正後().get住定届出年月日()) {
//            param.set明細タイトル年月日訂正後(RString.EMPTY);
//        } else if (ZTWO.equals(param.get事由コード()) && ONE.equals(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体))
//                && null != param.get海区選挙人名簿訂正前()
//                && null != param.get海区選挙人名簿訂正後()
//                && null != param.get海区選挙人名簿訂正前().get登録届出年月日()) {
//            RString 登録届出年月日 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get登録届出年月日().toDateString(),
//                    null, EIGHT);
//            if (null != param.get海区選挙人名簿訂正後().get登録届出年月日()) {
//                登録届出年月日 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get登録届出年月日().toDateString(),
//                        param.get海区選挙人名簿訂正後().get登録届出年月日().toDateString(), EIGHT);
//            }
//            param.set明細タイトル年月日訂正後(edit年月日(登録届出年月日));
//        } else if (ZTWO.equals(param.get事由コード()) && TWO.equals(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体))
//                && null != param.get海区選挙人名簿訂正前()) {
//            RString 登録異動年月日 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get登録異動年月日().toDateString(),
//                    null, EIGHT);
//            if (null != param.get海区選挙人名簿訂正後() && null != param.get海区選挙人名簿訂正後().get登録異動年月日()) {
//                登録異動年月日 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get登録異動年月日().toDateString(),
//                        param.get海区選挙人名簿訂正後().get登録異動年月日().toDateString(), EIGHT);
//            }
//            param.set明細タイトル年月日訂正後(edit年月日(登録異動年月日));
//        } else {
//            param.set明細タイトル年月日訂正後(RString.EMPTY);
//        }
//    }
//
//    private void set生年月日(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前() && null != param.get海区選挙人名簿訂正前().get生年月日()) {
//            param.set生年月日訂正前(idouSenkyoninIchiran.get生年月日(param.get海区選挙人名簿訂正前().get住民種別コード(),
//                    new FlexibleDate(param.get海区選挙人名簿訂正前().get生年月日().toDateString())));
//            RString 生年月日訂正後 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get生年月日().toDateString(),
//                    null, EIGHT);
//            param.set生年月日訂正後(生年月日訂正後);
//            if (null != param.get海区選挙人名簿訂正後() && null != param.get海区選挙人名簿訂正後().get生年月日()) {
//                生年月日訂正後 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get生年月日().toDateString(),
//                        param.get海区選挙人名簿訂正後().get生年月日().toDateString(), EIGHT);
//            }
//            if (!RString.isNullOrEmpty(生年月日訂正後) && !横線_EIGHT.equals(生年月日訂正後)) {
//                param.set生年月日訂正後(idouSenkyoninIchiran.get生年月日(param.get海区選挙人名簿訂正後().get住民種別コード(),
//                        new FlexibleDate(param.get海区選挙人名簿訂正後().get生年月日().toDateString())));
//            }
//            if (RString.isNullOrEmpty(生年月日訂正後)) {
//                param.set生年月日訂正後(生年月日訂正後);
//            }
//        }
//    }
//
//    private void set性別訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前() && null != param.get海区選挙人名簿訂正後()) {
//            RString 性別訂正後 = idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get性別コード(),
//                    param.get海区選挙人名簿訂正後().get性別コード(), 性別項目サイズ);
//            param.set性別コード訂正後(性別訂正後);
//        }
//    }
//
//    private void set氏名訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前() && null != param.get海区選挙人名簿訂正後()) {
//            param.set氏名訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get名称(),
//                    param.get海区選挙人名簿訂正後().get名称(), getItemLength(氏名訂正後)));
//        }
//    }
//
//    private void set住所(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        RString 文字列訂正前 = RString.EMPTY;
//        if (null != param.get海区選挙人名簿訂正前()) {
//            文字列訂正前 = changeNullToEmpty(param.get海区選挙人名簿訂正前().get住登内住所()).replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY)
//                    .concat(changeNullToEmpty(param.get海区選挙人名簿訂正前().get住登内番地()))
//                    .replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY).concat(全角スペース)
//                    .concat(changeNullToEmpty(param.get海区選挙人名簿訂正前().get住登内方書()));
//            List<RString> 住所リスト = idouSenkyoninIchiran.文字列分割(文字列訂正前, getItemLength(住所訂正前));
//            param.set住所訂正前(住所リスト.get(ZERO_NUMBER));
//        }
//        if (null != param.get海区選挙人名簿訂正後()) {
//            RString 文字列訂正後 = changeNullToEmpty(param.get海区選挙人名簿訂正後().get住登内住所()).replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY)
//                    .concat(changeNullToEmpty(param.get海区選挙人名簿訂正後().get住登内番地()))
//                    .replace(全角スペース, RString.EMPTY).replace(空白, RString.EMPTY).concat(全角スペース)
//                    .concat(changeNullToEmpty(param.get海区選挙人名簿訂正後().get住登内方書()));
//            RString 訂正後情報 = idouSenkyoninIchiran.set訂正後情報(文字列訂正前, 文字列訂正後, getItemLength(住所訂正後));
//            List<RString> 住所リスト = idouSenkyoninIchiran.文字列分割(訂正後情報, getItemLength(住所訂正後));
//            param.set住所訂正後(住所リスト.get(ZERO_NUMBER));
//        }
//    }
//
//    private void set世帯コード訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前() && null != param.get海区選挙人名簿訂正後()) {
//            param.set世帯コード訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get世帯コード(),
//                    param.get海区選挙人名簿訂正後().get世帯コード(), FIFTEEN));
//        }
//    }
//
//    private void set住所コード訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿訂正前() && null != param.get海区選挙人名簿訂正後()) {
//            param.set住所コード訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿訂正前().get住登内町域コード(),
//                    param.get海区選挙人名簿訂正後().get住登内町域コード(), EIGHT));
//        }
//    }
//
//    private void set投票区訂正後(TeiseishaMeiboKaikuParam param, IdouSenkyoninIchiran idouSenkyoninIchiran) {
//        if (null != param.get海区選挙人名簿情報訂正前()
//                && null != param.get海区選挙人名簿情報訂正前().getSenkyoninMeiboEntity()
//                && null != param.get海区選挙人名簿情報訂正後()
//                && null != param.get海区選挙人名簿情報訂正後().getSenkyoninMeiboEntity()) {
//            param.set投票区訂正後(idouSenkyoninIchiran.set訂正後情報(param.get海区選挙人名簿情報訂正前().getSenkyoninMeiboEntity().getTohyokuCode(),
//                    param.get海区選挙人名簿情報訂正後().getSenkyoninMeiboEntity().getTohyokuCode(), 投票区項目サイズ));
//        }
//    }

    private static List<TeiseishaMeiboKaikuReport> toReports(List<TeiseishaMeiboKaikuParam> targets) {
        List<TeiseishaMeiboKaikuReport> list = new ArrayList<>();
        for (TeiseishaMeiboKaikuParam target : targets) {
            list.add(new TeiseishaMeiboKaikuReport(target));
        }
        return list;
    }

}
