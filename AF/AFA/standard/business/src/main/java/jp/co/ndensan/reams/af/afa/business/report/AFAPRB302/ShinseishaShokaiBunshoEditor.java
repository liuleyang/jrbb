package jp.co.ndensan.reams.af.afa.business.report.AFAPRB302;

import jp.co.ndensan.reams.af.afa.business.core.ShinseishaShokaiBunshoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB302.ShinseishaShokaiBunshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoEditor implements IShinseishaShokaiBunshoEditor {

    private static final int ZERO = 0;
    private static final int 回答先市町村名の文字数 = 13;
    private static final RString 本籍地登録区分_0 = new RString("0");
    private static final RString 本籍地登録区分_1 = new RString("1");
    private static final RString 丸印 = new RString("○");
    private static final RString 全角スペース = new RString("　");
    private static final RString スペース = new RString(" ");
    private static final RString 漢字文字 = new RString("選挙管理委員会委員長");
    private static final RString 漢字氏名_殿 = new RString("殿");
    private static final RString 長さ_本籍1 = new RString("honsekiU");
    private static final RString 長さ_最終住所1 = new RString("endJusho1");
    private static final RString 長さ_最終住所2 = new RString("endJusho2");

    private final ShinseishaShokaiBunshoParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link ShinseishaShokaiBunshoParam}
     */
    public ShinseishaShokaiBunshoEditor(ShinseishaShokaiBunshoParam data) {
        this.data = data;
    }

    /**
     * 申請者の被登録資格の照会文書エディットメソッド
     *
     * @param source 申請者の被登録資格の照会文書
     * @return 申請者の被登録資格の照会文書
     */
    @Override
    public ShinseishaShokaiBunshoReportSource edit(ShinseishaShokaiBunshoReportSource source) {
        edit郵便番号(source);
        edit発行番号(source);
        edit発行年月日(source);
        edit通知先市町村(source);
        edit照会元市町村名(source);
        edit委員長名(source);
        edit作成年月日(source);
        edit選挙種類(source);
        edit市区町村区分(source);
        edit氏名(source);
        edit生年月日(source);
        edit性別(source);
        edit本籍(source);
        edit本籍登録区分(source);
        edit最終住所(source);
        edit元号(source);
        edit回答先市町村名(source);
        edit公印省略(source);
        editログの出力(source);
        return source;
    }

    private void edit郵便番号(ShinseishaShokaiBunshoReportSource source) {
        source.yubinNo = data.getYubinNo();
    }

    private void edit発行番号(ShinseishaShokaiBunshoReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit発行年月日(ShinseishaShokaiBunshoReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit通知先市町村(ShinseishaShokaiBunshoReportSource source) {
        source.shokaiSaki = data.getShokaiSaki();
        source.shokaiSakiL = data.getShokaiSakiL();
    }

    private void edit照会元市町村名(ShinseishaShokaiBunshoReportSource source) {
        source.shokaiMoto1 = data.getShokaiMoto1();
        source.shokaiMoto2 = data.getShokaiMoto2();
    }

    private void edit委員長名(ShinseishaShokaiBunshoReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }

    private void edit選挙種類(ShinseishaShokaiBunshoReportSource source) {
        source.senkyoShurui = data.getSenkyoShurui();
    }

    private void edit市区町村区分(ShinseishaShokaiBunshoReportSource source) {
        source.cityKubun = data.getCityKubun();
    }

    private void edit氏名(ShinseishaShokaiBunshoReportSource source) {
        source.shimei1 = data.getShimei1();
        source.shimei2 = data.getShimei2();
        source.shimei3 = data.getShimei3();
    }

    private void edit生年月日(ShinseishaShokaiBunshoReportSource source) {
        source.seinengappi = data.getSeinengappi();
    }

    private void edit性別(ShinseishaShokaiBunshoReportSource source) {
        source.seibetsu = data.getSeibetsu();
    }

    private void edit本籍(ShinseishaShokaiBunshoReportSource source) {
        source.honsekiU = RString.EMPTY;
        source.honsekiD = RString.EMPTY;
        if (data.get在外選挙人住所情報_本籍() != null) {
            AtenaJusho 住所 = data.get在外選挙人住所情報_本籍().getJusho();
            AtenaBanchi 番地 = data.get在外選挙人住所情報_本籍().getBanchi();
            RString 連結 = (null == 住所 ? RString.EMPTY : 住所.getColumnValue()).concat(null == 番地 ? RString.EMPTY : 番地.getColumnValue());
            連結 = replace文字列(連結, スペース, RString.EMPTY);
            if (getItemLength(長さ_本籍1) >= 連結.length()) {
                source.honsekiU = 連結;
            } else {
                source.honsekiU = 連結.substring(ZERO, getItemLength(長さ_本籍1));
                source.honsekiD = 連結.substring(getItemLength(長さ_本籍1));
            }

        }
    }

    private void edit本籍登録区分(ShinseishaShokaiBunshoReportSource source) {
        source.honsekiTorokuKubunEnd = RString.EMPTY;
        source.honsekiTorokuKubunHon = RString.EMPTY;
        if (data.get在外選挙資格() != null) {
            Code 本籍地登録 = data.get在外選挙資格().getHonsekiTorokuKubun();
            RString 本籍地登録区分 = null == 本籍地登録 ? RString.EMPTY : 本籍地登録.getColumnValue();
            if (本籍地登録区分.equals(本籍地登録区分_0)) {
                source.honsekiTorokuKubunEnd = 丸印;
            } else if (本籍地登録区分.equals(本籍地登録区分_1)) {
                source.honsekiTorokuKubunHon = 丸印;
            }
        }
    }

    private void edit最終住所(ShinseishaShokaiBunshoReportSource source) {
        source.endJusho1 = RString.EMPTY;
        source.endJusho2 = RString.EMPTY;
        source.endJusho3 = RString.EMPTY;
        AtenaJusho 住所 = data.get在外選挙人住所情報_最終住所().getJusho();
        AtenaBanchi 番地 = data.get在外選挙人住所情報_最終住所().getBanchi();
        Katagaki 方書 = data.get在外選挙人住所情報_最終住所().getKatagaki();
        RString 連結1 = null == 住所 ? RString.EMPTY : 住所.getColumnValue().concat(null == 番地 ? RString.EMPTY : 番地.getColumnValue());
        連結1 = replace文字列(連結1, スペース, RString.EMPTY);
        RString 連結2 = 連結1.concat(全角スペース).concat(null == 方書 ? RString.EMPTY : 方書.getColumnValue());
        if (getItemLength(長さ_最終住所1) >= 連結2.length()) {
            source.endJusho1 = 連結2;
        } else if (getItemLength(長さ_最終住所1) + getItemLength(長さ_最終住所2) >= 連結2.length()) {
            source.endJusho1 = 連結2.substring(ZERO, getItemLength(長さ_最終住所1));
            source.endJusho2 = 連結2.substring(getItemLength(長さ_最終住所1));
        } else {
            source.endJusho1 = 連結2.substring(ZERO, getItemLength(長さ_最終住所1));
            source.endJusho2 = 連結2.substring(getItemLength(長さ_最終住所1), getItemLength(長さ_最終住所1) + getItemLength(長さ_最終住所2));
            source.endJusho3 = 連結2.substring(getItemLength(長さ_最終住所1) + getItemLength(長さ_最終住所2));
        }
    }

    private void edit元号(ShinseishaShokaiBunshoReportSource source) {
        source.gengo = data.getGengo();
    }

    private void edit作成年月日(ShinseishaShokaiBunshoReportSource source) {
        source.sakuseiYmd = data.getSakuseiYmd();
    }

    private void edit回答先市町村名(ShinseishaShokaiBunshoReportSource source) {
        source.kaitoSakiLu = RString.EMPTY;
        source.kaitoSakiLd = RString.EMPTY;
        source.kaitoSakiRd = RString.EMPTY;
        if (null != data.get地方公共団体()) {
            RString 回答先市町村名 = changeNullToEmpty(data.get地方公共団体().get都道府県名())
                    .concat(changeNullToEmpty(data.get地方公共団体().get郡名()))
                    .concat(changeNullToEmpty(data.get地方公共団体().get市町村名()));
            if (回答先市町村名.length() <= ZERO) {
                source.kaitoSakiRd = 全角スペース.concat(漢字文字).concat(全角スペース).concat(漢字氏名_殿);
            } else if (回答先市町村名.length() <= 回答先市町村名の文字数) {
                source.kaitoSakiLd = 回答先市町村名.concat(全角スペース).concat(漢字文字).concat(全角スペース).concat(漢字氏名_殿);
            } else {
                source.kaitoSakiLu = 回答先市町村名;
                source.kaitoSakiRd = 全角スペース.concat(漢字文字).concat(全角スペース).concat(漢字氏名_殿);
            }
        }
    }

    private void edit公印省略(ShinseishaShokaiBunshoReportSource source) {
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void editログの出力(ShinseishaShokaiBunshoReportSource source) {
        source.識別コード = data.get在外選挙人申請情報().get申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private static RString replace文字列(RString 文字列, RString oldStr, RString newStr) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列.replace(oldStr, newStr);
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ShinseishaShokaiBunshoReportSource.class, itemName);
    }
}
