package jp.co.ndensan.reams.af.afa.business.report.AFAPRK100;

import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonKaikuParam;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100.MeiboShohonKaikuSource;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区漁業調整委員会委員選挙人名簿抄本
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuEditor implements IMeiboShohonKaikuEditor {

    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString ONE = new RString("1");
    private static final RString ZERO = new RString("0");
    private static final RString TWO = new RString("2");
    private static final RString 番地コード = new RString("10");
    private static final RString 住所コード = new RString("11");
    private static final RString 行政区コード = new RString("12");
    private static final RString 地区コード1 = new RString("13");
    private static final RString 地区コード2 = new RString("14");
    private static final RString 地区コード3 = new RString("15");
    private static final RString 長さ_明細部の住所１ = new RString("listListjusho1_1");
    private static final RString 長さ_明細部の住所２ = new RString("listListjusho2_1");
    private static final RString 長さ_明細部の住所３ = new RString("listListjusho3_1");
    private static final RString 長さ_生年月日 = new RString("listSeinengappi_1");
    private static final RString 長さ_性別 = new RString("listSeinengappi_2");
    private static final RString 長さ_氏名１ = new RString("listShimei_1");
    private static final RString 選挙管理委員会 = new RString("選挙管理委員会");
    private static final RString 全角スペース = new RString("　");
    private static final RString 長さ_氏名２ = new RString("listKanaShimei_1");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString 基準日 = new RString("基準日:");
    private static final RString 投票日 = new RString("投票日:");
    private static final RString 長さ_表示の停止文字 = new RString("listTeishiMoji_1");
    private static final RString 長さ_表示の抹消事由 = new RString("listMasshoJiyu_1");
    private static final RString 長さ_表示の組合名称 = new RString("listKumiaiMei_1");

    private final MeiboShohonKaikuParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link MeiboShohonKaikuParam}
     */
    public MeiboShohonKaikuEditor(MeiboShohonKaikuParam data) {
        this.data = data;
    }

    /**
     * 海区漁業調整委員会委員選挙人名簿抄本エディットメソッド
     *
     * @param source 海区漁業調整委員会委員選挙人名簿抄本
     * @return 海区漁業調整委員会委員選挙人名簿抄本
     */
    @Override
    public MeiboShohonKaikuSource edit(MeiboShohonKaikuSource source) {
        edit帳票タイトル(source);
        edit投票区名(source);
        edit投票区コード(source);
        editヘッダ項目名称見出し(source);
        editヘッダ項目コード(source);
        editヘッダ項目名称(source);
        editトータルページ(source);
        editページ(source);
        if (data.get住民投票資格者名簿抄本情報().get帳票フラグ() == 1) {
            edit明細行空白行(source);
        } else if (data.get住民投票資格者名簿抄本情報().get帳票フラグ() == 2) {
            edit明細行マスキング(source);
        } else {
            edit住所(source);
            edit生年月日(source);
            edit世帯主(source);
            edit氏名１(source);
            edit氏名２(source);
            edit表示の停止文字(source);
            edit表示の抹消事由(source);
            edit表示の組合名称(source);
        }

        edit選挙管理委員会名称(source);
        edit作成条件１(source);
        edit作成条件２(source);
        edit集計(source);
        editアクセスログ出力(source);
        return source;
    }

    private void edit明細行空白行(MeiboShohonKaikuSource source) {
        source.listListjusho1_1 = RString.EMPTY;
        source.listListjusho2_1 = RString.EMPTY;
        source.listListjusho3_1 = RString.EMPTY;
        source.listSeinengappi_1 = RString.EMPTY;
        source.listSeinengappi_2 = RString.EMPTY;
        source.listShimei_1 = RString.EMPTY;
        source.listKanaShimei_1 = RString.EMPTY;
        source.listTeishiMoji_1 = RString.EMPTY;
        source.listMasshoJiyu_1 = RString.EMPTY;
    }

    private void edit明細行マスキング(MeiboShohonKaikuSource source) {
        source.listListjusho1_1 = editマスキング(getItemLength(長さ_明細部の住所１));
        source.listListjusho2_1 = editマスキング(getItemLength(長さ_明細部の住所２));
        source.listListjusho3_1 = editマスキング(getItemLength(長さ_明細部の住所３));
        source.listSeinengappi_1 = editマスキング(getItemLength(長さ_生年月日));
        source.listSeinengappi_2 = editマスキング(getItemLength(長さ_性別));
        source.listShimei_1 = editマスキング(getItemLength(長さ_氏名１));
        source.listKanaShimei_1 = editマスキング(getItemLength(長さ_氏名２));
        source.listTeishiMoji_1 = editマスキング(getItemLength(長さ_表示の停止文字));
        source.listMasshoJiyu_1 = editマスキング(getItemLength(長さ_表示の抹消事由));
        source.listKumiaiMei_1 = editマスキング(getItemLength(長さ_表示の組合名称));
    }

    private RString editマスキング(int length) {
        RString マスキング = RString.EMPTY;
        for (int i = 0; i < length; i++) {
            マスキング = マスキング.concat(new RString("*"));
        }
        return マスキング;
    }

    private void edit世帯主(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.listSetainushi_1 = data.get住民投票資格者名簿抄本情報().get世帯主();
        }
        if (null != data.get住民投票資格者名簿抄本情報()
                && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
            source.listSetainushiM_1 = data.get住民投票資格者名簿抄本情報().get世帯主();
        }
    }

    private void editアクセスログ出力(MeiboShohonKaikuSource source) {
        if (null != data.get宛名識別対象()) {
            ShikibetsuCode 識別コード = data.get宛名識別対象().getShikibetsuCode();
            source.識別コード = 識別コード;
            source.shikibetsuCode = null == 識別コード ? RString.EMPTY : 識別コード.getColumnValue();
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void edit投票区名(MeiboShohonKaikuSource source) {
        RString tohyokuMeiFlg = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_投票区名, SubGyomuCode.AFA選挙本体);
        if (null != data.get住民投票資格者名簿抄本情報() && InnjiFlg.印字する.value().equals(tohyokuMeiFlg)) {
            source.tohyokuMei = data.get住民投票資格者名簿抄本情報().get投票区名();
        }
    }

    private void edit投票区コード(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.tohyokuCode = data.get住民投票資格者名簿抄本情報().get投票区コード();
        }
    }

    private void editヘッダ項目名称見出し(MeiboShohonKaikuSource source) {
        RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        if (抄本_住所編集_ヘッダ部住所.equals(住所コード)) {
            source.jushoMeisho = 住所;
        } else if (抄本_住所編集_ヘッダ部住所.equals(行政区コード)) {
            source.jushoMeisho = 行政区;
        } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード1)) {
            source.jushoMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード2)) {
            source.jushoMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード3)) {
            source.jushoMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        }
    }

    private void editヘッダ項目コード(MeiboShohonKaikuSource source) {
        RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(住所コード)) {
            source.jushoCode = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get町域コード());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(行政区コード)) {
            source.jushoCode = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get行政区コード());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(地区コード1)) {
            source.jushoCode = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get地区コード１());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(地区コード2)) {
            source.jushoCode = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get地区コード２());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(地区コード3)) {
            source.jushoCode = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get地区コード３());
        }
    }

    private void editヘッダ項目名称(MeiboShohonKaikuSource source) {
        RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(住所コード)) {
            source.jusho = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get住登内住所());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(行政区コード)) {
            source.jusho = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get行政区名());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(地区コード1)) {
            source.jusho = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get地区名１());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(地区コード2)) {
            source.jusho = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get地区名２());
        } else if (null != data.get住民投票資格者名簿抄本情報() && 抄本_住所編集_ヘッダ部住所.equals(地区コード3)) {
            source.jusho = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get地区名３());
        }
    }

    private void editトータルページ(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.totalPage = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().getTotalPage());
        }
    }

    private void edit帳票タイトル(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.title = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get帳票タイトル());
        }
    }

    private void editページ(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.page = new RString(data.get住民投票資格者名簿抄本情報().getページ());
        }
    }

    private void edit住所編集方書有(MeiboShohonKaikuSource source, RString 住所連結文字列) {
        RString 住登内方書 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get住登内方書());
        if (住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
            edit住所２連結文字列(source, 住登内方書);
        } else if (住所連結文字列.length() > getItemLength(長さ_明細部の住所１)
                && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))) {
            RString 住所２連結文字列 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１)).concat(全角スペース)
                    .concat(changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get住登内方書()));
            edit住所２連結文字列(source, 住所２連結文字列);
        } else if (住所連結文字列.length() > (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))
                && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３))) {
            source.listListjusho3_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
        }
        if ((!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())
                && 住所連結文字列.length() > (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))
                && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３))) {
            source.listListjusho3M_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
        }
    }

    private void edit住所編集方書無(MeiboShohonKaikuSource source, RString 住所連結文字列) {
        if (住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
            source.listListjusho2_1 = RString.EMPTY;
        } else if (住所連結文字列.length() > getItemLength(長さ_明細部の住所１)
                && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))) {
            source.listListjusho2_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１));
        } else if (住所連結文字列.length() > (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))
                && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３))) {
            source.listListjusho3_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
            source.listListjusho3M_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
        }
        if (null != data.get住民投票資格者名簿抄本情報()
                && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())
                && 住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
            source.listListjusho2M_1 = RString.EMPTY;
        } else if (null != data.get住民投票資格者名簿抄本情報()
                && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())
                && 住所連結文字列.length() > getItemLength(長さ_明細部の住所１)
                && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))) {
            source.listListjusho2M_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１));
        }
    }

    private void edit住所編集方書(MeiboShohonKaikuSource source, RString 抄本_住所編集_方書印字有無, RString 住所連結文字列) {
        if (抄本_住所編集_方書印字有無.equals(ZERO)) {
            edit住所編集方書無(source, 住所連結文字列);
        } else if (抄本_住所編集_方書印字有無.equals(ONE)) {
            edit住所編集方書有(source, 住所連結文字列);
        }
    }

    private void edit住所(MeiboShohonKaikuSource source) {
        RString 住所連結文字列 = RString.EMPTY;
        RString 抄本_住所編集_住所欄出力内容 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_住所欄出力内容);
        RString 抄本_住所編集_方書印字有無 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_方書印字有無);
        if (null != data.get住民投票資格者名簿抄本情報()) {
            RString 住登内番地 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get住登内番地());
            RString 住登内住所 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get住登内住所());
            RString 行政区名 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get行政区名());
            RString 住所_番地 = 住登内住所.concat(住登内番地);
            RString 行政区_番地 = 行政区名.concat(住登内番地);
            if (抄本_住所編集_住所欄出力内容.equals(番地コード)) {
                住所連結文字列 = 住登内番地;
            } else if (抄本_住所編集_住所欄出力内容.equals(住所コード)) {
                住所連結文字列 = 住所_番地;
            } else if (抄本_住所編集_住所欄出力内容.equals(行政区コード)) {
                住所連結文字列 = 行政区_番地;
            }

            if (住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
                source.listListjusho1_1 = 住所連結文字列;
            } else {
                source.listListjusho1_1 = 住所連結文字列.substring(0, getItemLength(長さ_明細部の住所１));
            }
            if (null != data.get住民投票資格者名簿抄本情報()
                    && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())
                    && 住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
                source.listListjusho1M_1 = 住所連結文字列;
            } else if (null != data.get住民投票資格者名簿抄本情報()
                    && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
                source.listListjusho1M_1 = 住所連結文字列.substring(0, getItemLength(長さ_明細部の住所１));
            }
            source.listJusho = 住所連結文字列;
            edit住所編集方書(source, 抄本_住所編集_方書印字有無, 住所連結文字列);
        }
    }

    private void edit住所２連結文字列(MeiboShohonKaikuSource source, RString 住所２連結文字列) {
        if (getItemLength(長さ_明細部の住所２) >= 住所２連結文字列.length()) {
            source.listListjusho2_1 = 住所２連結文字列;
            if (null != data.get住民投票資格者名簿抄本情報()
                    && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
                source.listListjusho2M_1 = 住所２連結文字列;
            }
        } else if (getItemLength(長さ_明細部の住所２) < 住所２連結文字列.length()
                && (getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所２)) >= 住所２連結文字列.length()) {
            source.listListjusho2_1 = 住所２連結文字列.substring(0, getItemLength(長さ_明細部の住所２));
            source.listListjusho3_1 = 住所２連結文字列.substring(getItemLength(長さ_明細部の住所２));
            if (null != data.get住民投票資格者名簿抄本情報()
                    && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
                source.listListjusho2M_1 = 住所２連結文字列.substring(0, getItemLength(長さ_明細部の住所２));
                source.listListjusho3M_1 = 住所２連結文字列.substring(getItemLength(長さ_明細部の住所２));
            }
        }
    }

    private void edit生年月日(MeiboShohonKaikuSource source) {
        RString 抄本_印字有無_生年月日 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_生年月日);
        RString 住民種別 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get住民種別());
        RString 生年月日 = data.get住民投票資格者名簿抄本情報().get生年月日();
        RString 性別コード = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get性別コード());
        RString 性別表示文字 = RString.EMPTY;
        if (FEMALE.getCode().equals(性別コード)) {
            性別表示文字 = FEMALE.getName().getFullJapanese();
        } else if (MALE.getCode().equals(性別コード)) {
            性別表示文字 = MALE.getName().getFullJapanese();
        }
        if (抄本_印字有無_生年月日.equals(ONE) && 生年月日 != null) {
            source.listSeinengappi_1
                    = 住民種別.equals(TWO) ? new FlexibleDate(生年月日).seireki().toDateString() : new FlexibleDate(生年月日).wareki().toDateString();

            source.listSeinengappi_2 = 性別表示文字;
            if (null != data.get住民投票資格者名簿抄本情報()
                    && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
                source.listSeinengappiM_1
                        = 住民種別.equals(TWO) ? new FlexibleDate(生年月日).seireki().toDateString() : new FlexibleDate(生年月日).wareki().toDateString();
                source.listSeinengappiM_2 = 性別表示文字;
            }
        }
    }

    private void edit氏名１(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.listShimei_1 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get名称());
            if (null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
                source.listShimeiM_1 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get名称());
            }
        }
    }

    private void edit氏名２(MeiboShohonKaikuSource source) {
        RString 抄本_印字有無_カナ名称 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_カナ名称);
        RString 抄本_印字有無_識別コード = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_識別コード);
        int 最大文字数_氏名2 = getItemLength(new RString("listKanaShimei_1"));
        RString 識別コード = RString.EMPTY;
        if (null != data.get住民投票資格者名簿抄本情報()) {
            識別コード = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get識別コード());
        }
        if (抄本_印字有無_カナ名称.equals(ZERO)) {
            edit抄本カナ名称印字無(source, 抄本_印字有無_識別コード, 識別コード);
        } else if (抄本_印字有無_カナ名称.equals(ONE)) {
            edit抄本カナ名称印字有(source, 抄本_印字有無_識別コード, 最大文字数_氏名2, 識別コード);
        }
    }

    private void edit抄本カナ名称印字無(MeiboShohonKaikuSource source, RString 抄本_印字有無_識別コード, RString 識別コード) {
        source.listShimei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get名称())
                .concat(識別コード.padLeft(getItemLength(長さ_氏名２) - 識別コード.length()));
        if (抄本_印字有無_識別コード.equals(ONE)) {
            source.listKanaShimei_1 = 識別コード.padLeft(getItemLength(長さ_氏名２) - 識別コード.length());
        }
        if (抄本_印字有無_識別コード.equals(ONE) && null != data.get住民投票資格者名簿抄本情報() && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
            source.listKanaShimeiM_1 = 識別コード.padLeft(getItemLength(長さ_氏名２) - 識別コード.length());
        }
    }

    private void edit抄本カナ名称印字有(MeiboShohonKaikuSource source, RString 抄本_印字有無_識別コード, int 最大文字数_氏名2, RString 識別コード) {
        if (InnjiFlg.印字しない.value().equals(抄本_印字有無_識別コード)) {
            int 算出文字数 = 最大文字数_氏名2 - 2;
            source.listShimei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get名称())
                    .concat(左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧));
            source.listKanaShimei_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧);
        } else if (InnjiFlg.印字する.value().equals(抄本_印字有無_識別コード)) {
            int 算出文字数 = 最大文字数_氏名2 - 識別コード.length() - 2;
            source.listShimei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get名称())
                    .concat(左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧));
            source.listKanaShimei_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧).concat(識別コード);
        }
        if (InnjiFlg.印字しない.value().equals(抄本_印字有無_識別コード) && null != data.get住民投票資格者名簿抄本情報()
                && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
            int 算出文字数 = 最大文字数_氏名2 - 2;
            source.listKanaShimeiM_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧);
        } else if (InnjiFlg.印字する.value().equals(抄本_印字有無_識別コード) && null != data.get住民投票資格者名簿抄本情報()
                && null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
            int 算出文字数 = 最大文字数_氏名2 - 識別コード.length() - 2;
            source.listKanaShimeiM_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧).concat(識別コード);
        }
    }

    private RString getカナ名称_算出文字数(int number) {
        RString カナ名称 = RString.EMPTY;
        if (null != data.get住民投票資格者名簿抄本情報()) {
            RString kana = data.get住民投票資格者名簿抄本情報().getカナ名称();
            if (kana != null && kana.length() <= number) {
                カナ名称 = kana.padRight(number);
            } else if (kana != null) {
                カナ名称 = kana.substring(0, number);
            }
        }
        return カナ名称;
    }

    private void edit表示の停止文字(MeiboShohonKaikuSource source) {
        ShikakuHantei shikakuHantei = new ShikakuHantei();
        FlexibleDate 規定年齢到達年月日 = null;
        if (null != data.get住民投票資格者名簿抄本情報().get規定年齢到達年月日()) {
            規定年齢到達年月日 = data.get住民投票資格者名簿抄本情報().get規定年齢到達年月日();
        }

        if (shikakuHantei.is公民権停止者(data.get宛名識別対象(), data.get選挙資格(), 規定年齢到達年月日, FlexibleDate.getNowDate())) {
            source.listTeishiMoji_1 = BusinessConfig.get(ConfigKeysAFA.抄本_公民権停止文字);
        }
    }

    private void edit表示の抹消事由(MeiboShohonKaikuSource source) {
        RString 抹消事由コード = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get抹消事由コード());
        source.listMasshoJiyu_1 = RString.EMPTY;
        if (抹消事由コード.equals(RString.EMPTY)) {
            source.listMasshoJiyu_1 = RString.EMPTY;
        } else {
            source.listMasshoJiyu_1 = CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), new Code(抹消事由コード));
        }
    }

    private void edit表示の組合名称(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.listKumiaiMei_1 = data.get住民投票資格者名簿抄本情報().get組合名称();
            if (null != data.get住民投票資格者名簿抄本情報().get抹消事由コード()
                    && (!data.get住民投票資格者名簿抄本情報().get抹消事由コード().isNullOrEmpty()
                    || data.get住民投票資格者名簿抄本情報().is投票区変更抹消フラグ())) {
                source.listKumiaiMeiM_1 = data.get住民投票資格者名簿抄本情報().get組合名称();
            }
        }

    }

    private void edit選挙管理委員会名称(MeiboShohonKaikuSource source) {
        if (null != data.get地方公共団体情報()) {
            source.senkanMei = changeNullToEmpty(data.get地方公共団体情報().get市町村名()).concat(選挙管理委員会);
        }
    }

    private void edit作成条件１(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報()) {
            source.selHani1 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報().get抄本名());
        }
    }

    private void edit作成条件２(MeiboShohonKaikuSource source) {
        RString 投票年月日 = RString.EMPTY;
        if (null != data.get住民投票資格者名簿抄本情報()
                && null != data.get住民投票資格者名簿抄本情報().get投票年月日()) {
            投票年月日 = 投票日.concat(new FlexibleDate(data.get住民投票資格者名簿抄本情報().get投票年月日()).wareki().toDateString());
        }
        if (null != data.get住民投票資格者名簿抄本情報() && ONE.equals(data.get住民投票資格者名簿抄本情報().get選挙番号())
                && null != data.get住民投票資格者名簿抄本情報().get名簿基準年月日()) {
            投票年月日 = 基準日.concat(投票年月日.concat(data.get住民投票資格者名簿抄本情報().get名簿基準年月日().wareki().toDateString()))
                    .concat(全角スペース).concat(投票年月日);
        }
        source.selHani2 = 投票年月日;
    }

    private void edit集計(MeiboShohonKaikuSource source) {
        if (null != data.get住民投票資格者名簿抄本情報集計()) {
            source.pageKeiMan = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getPageKeiMan());
            source.pageKeiWoman = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getPageKeiWoman());
            source.pageKeiKei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getPageKeiKei());
            source.kei1Title = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei1Title());
            source.kei1Man = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei1Man());
            source.kei1Woman = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei1Woman());
            source.kei1Kei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei1Kei());
            source.kei2Title = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei2Title());
            source.kei2Man = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei2Man());
            source.kei2Woman = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei2Woman());
            source.kei2Kei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei2Kei());
            source.kei3Title = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei3Title());
            source.kei3Man = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei3Man());
            source.kei3Woman = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei3Woman());
            source.kei3Kei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei3Kei());
            source.kei4Title = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei4Title());
            source.kei4Man = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei4Man());
            source.kei4Woman = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei4Woman());
            source.kei4Kei = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKei4Kei());
            source.key1 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKey1());
            source.key2 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKey2());
            source.key3 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKey3());
            source.key4 = changeNullToEmpty(data.get住民投票資格者名簿抄本情報集計().getKey4());
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return null == 文字列 ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(MeiboShohonKaikuSource.class, itemName);
    }
}
