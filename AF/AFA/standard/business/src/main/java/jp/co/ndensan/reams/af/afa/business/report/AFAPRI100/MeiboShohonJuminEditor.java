/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRI100;

import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminParam;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.Seibetsu;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-030 lis
 */
public class MeiboShohonJuminEditor implements IMeiboShohonJuminEditor {

    private final MeiboShohonJuminParam param;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 番地 = new RString("10");
    private static final RString 住所 = new RString("11");
    private static final RString 行政区 = new RString("12");
    private static final RString 地区コード1 = new RString("13");
    private static final RString 地区コード2 = new RString("14");
    private static final RString 地区コード3 = new RString("15");
    private static final RString 文字_住所 = new RString("住所");
    private static final RString 文字_行政区 = new RString("行政区");
    private static final RString 性別表示文字_男 = new RString("男");
    private static final RString 性別表示文字_女 = new RString("女");
    private static final RString 選挙管理委員会 = new RString("選挙管理委員会");
    private static final RString 長さ_明細部の住所１ = new RString("listListjusho1_1");
    private static final RString 長さ_明細部の住所２ = new RString("listListjusho2_1");
    private static final RString 長さ_明細部の住所３ = new RString("listListjusho3_1");
    private static final RString 長さ_生年月日 = new RString("listSeinengappi_1");
    private static final RString 長さ_性別 = new RString("listSeinengappi_2");
    private static final RString 長さ_表示の停止文字 = new RString("listTeishiMoji_1");
    private static final RString 長さ_表示の抹消事由 = new RString("listMasshoJiyu_1");
    private static final RString 長さ_氏名１ = new RString("listShimei_1");
    private static final RString 長さ_氏名２ = new RString("listKanaShimei_1");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString 文字_投票日 = new RString("投票日:");

    /**
     * コンストラクタです。
     *
     * @param param {@link MeiboShohonJuminParam}
     */
    public MeiboShohonJuminEditor(MeiboShohonJuminParam param) {
        this.param = param;
    }

    /**
     * 投票所入場券（ポステックス）エディットメソッド
     *
     * @param source 投票所入場券（ポステックス）
     * @return 投票所入場券（ポステックス）
     */
    @Override
    public MeiboShohonJuminSource edit(MeiboShohonJuminSource source) {
        edit帳票タイトル(source);
        edit投票区名(source);
        edit投票区コード(source);
        editヘッダ項目名称見出し(source);
        editヘッダ項目コード(source);
        editヘッダ項目名称(source);
        editトータルページ(source);
        editページ(source);
        if (param.get住民投票資格者名簿抄本情報().get帳票フラグ() == 1) {
            edit明細行空白行(source);
        } else if (param.get住民投票資格者名簿抄本情報().get帳票フラグ() == 2) {
            edit明細行マスキング(source);
        } else {
            edit住所(source);
            edit生年月日性別(source);
            edit氏名１(source);
            edit氏名２(source);
            eidt抹消線(source);
            edit表示の停止文字(source);
            edit表示の抹消事由(source);
        }

        edit選挙管理委員会名称(source);
        edit選択範囲１(source);
        edit選択範囲２(source);
        edit集計(source);
        editアクセスログ出力(source);
        return source;
    }

    private void edit明細行空白行(MeiboShohonJuminSource source) {
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

    private void edit明細行マスキング(MeiboShohonJuminSource source) {
        source.listListjusho1_1 = editマスキング(getItemLength(長さ_明細部の住所１));
        source.listListjusho2_1 = editマスキング(getItemLength(長さ_明細部の住所２));
        source.listListjusho3_1 = editマスキング(getItemLength(長さ_明細部の住所３));
        source.listSeinengappi_1 = editマスキング(getItemLength(長さ_生年月日));
        source.listSeinengappi_2 = editマスキング(getItemLength(長さ_性別));
        source.listShimei_1 = editマスキング(getItemLength(長さ_氏名１));
        source.listKanaShimei_1 = editマスキング(getItemLength(長さ_氏名２));
        source.listTeishiMoji_1 = editマスキング(getItemLength(長さ_表示の停止文字));
        source.listMasshoJiyu_1 = editマスキング(getItemLength(長さ_表示の抹消事由));
    }

    private RString editマスキング(int length) {
        RString マスキング = RString.EMPTY;
        for (int i = 0; i < length; i++) {
            マスキング = マスキング.concat(new RString("*"));
        }
        return マスキング;
    }

    private void edit投票区名(MeiboShohonJuminSource source) {
        RString tohyokuMeiFlg = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_投票区名, SubGyomuCode.AFA選挙本体);
        if (InnjiFlg.印字する.value().equals(tohyokuMeiFlg) && null != param.get住民投票資格者名簿抄本情報()) {
            source.tohyokuMei = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get投票区名());
        } else {
            source.tohyokuMei = RString.EMPTY;
        }
    }

    private void edit投票区コード(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報()) {
            source.tohyokuCode = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get投票区コード());
        }
    }

    private void editヘッダ項目名称見出し(MeiboShohonJuminSource source) {
        RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        if (抄本_住所編集_ヘッダ部住所.equals(住所)) {
            source.jushoMeisho = 文字_住所;
        } else if (抄本_住所編集_ヘッダ部住所.equals(行政区)) {
            source.jushoMeisho = 文字_行政区;
        } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード1)) {
            source.jushoMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード2)) {
            source.jushoMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード3)) {
            source.jushoMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        }
    }

    private void editヘッダ項目コード(MeiboShohonJuminSource source) {
        RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        if (null != param.get住民投票資格者名簿抄本情報()) {
            if (抄本_住所編集_ヘッダ部住所.equals(住所)) {
                source.jushoCode = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get町域コード());
            } else if (抄本_住所編集_ヘッダ部住所.equals(行政区)) {
                source.jushoCode = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get行政区コード());
            } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード1)) {
                source.jushoCode = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get地区コード１());
            } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード2)) {
                source.jushoCode = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get地区コード２());
            } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード3)) {
                source.jushoCode = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get地区コード３());
            }
        }
    }

    private void editヘッダ項目名称(MeiboShohonJuminSource source) {
        RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        if (null != param.get住民投票資格者名簿抄本情報()) {
            if (抄本_住所編集_ヘッダ部住所.equals(住所)) {
                source.jusho = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get住登内住所());
            } else if (抄本_住所編集_ヘッダ部住所.equals(行政区)) {
                source.jusho = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get行政区名());
            } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード1)) {
                source.jusho = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get地区名１());
            } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード2)) {
                source.jusho = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get地区名２());
            } else if (抄本_住所編集_ヘッダ部住所.equals(地区コード3)) {
                source.jusho = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get地区名３());
            }
        }
    }

    private void editトータルページ(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報集計()) {
            source.totalPage = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().getTotalPage());
        }
    }

    private void edit帳票タイトル(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報()) {
            source.title = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get帳票タイトル());
            source.key1 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().getKey1());
            source.key2 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().getKey2());
            source.key3 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().getKey3());
            source.key4 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().getKey4());
        }
    }

    private void editページ(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報()) {
            source.page = new RString(param.get住民投票資格者名簿抄本情報().getページ());
        }
    }

    private void edit住所(MeiboShohonJuminSource source) {
        RString 抄本_住所編集_住所欄出力内容 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_住所欄出力内容);
        RString 抄本_住所編集_方書印字有無 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_方書印字有無);
        RString 住登内番地 = RString.EMPTY;
        RString 住登内住所 = RString.EMPTY;
        RString 行政区名 = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            住登内番地 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get住登内番地());
            住登内住所 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get住登内住所());
            行政区名 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get行政区名());
        }
        RString 住所_番地 = 住登内住所.concat(住登内番地);
        RString 行政区_番地 = 行政区名.concat(住登内番地);
        RString 住所連結文字列 = RString.EMPTY;
        source.listListjusho1_1 = RString.EMPTY;
        source.listListjusho2_1 = RString.EMPTY;
        source.listListjusho3_1 = RString.EMPTY;
        if (抄本_住所編集_住所欄出力内容.equals(番地)) {
            住所連結文字列 = 住登内番地;
        } else if (抄本_住所編集_住所欄出力内容.equals(住所)) {
            住所連結文字列 = 住所_番地;
        } else if (抄本_住所編集_住所欄出力内容.equals(行政区)) {
            住所連結文字列 = 行政区_番地;
        }

        if (住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
            source.listListjusho1_1 = 住所連結文字列;
        } else {
            source.listListjusho1_1 = 住所連結文字列.substring(0, getItemLength(長さ_明細部の住所１));
        }

        if (抄本_住所編集_方書印字有無.equals(ZERO)) {
            if (住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
                source.listListjusho2_1 = RString.EMPTY;
            } else if (住所連結文字列.length() > getItemLength(長さ_明細部の住所１)
                    && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))) {
                source.listListjusho2_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１));
            } else if (住所連結文字列.length() > (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２))
                    && 住所連結文字列.length() <= (getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３))) {
                source.listListjusho2_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１), getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
                source.listListjusho3_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
            } else {
                source.listListjusho2_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１), getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２));
                source.listListjusho3_1 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１) + getItemLength(長さ_明細部の住所２), getItemLength(長さ_明細部の住所１)
                        + getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３));
                source.jushoKire = 住所連結文字列;
            }
        } else if (抄本_住所編集_方書印字有無.equals(ONE)) {
            RString 住登内方書 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get住登内方書());
            RString 住所２連結文字列 = RString.EMPTY;
            if (住所連結文字列.length() <= getItemLength(長さ_明細部の住所１)) {
                住所２連結文字列 = 住登内方書;
                source.listListjusho1_1 = 住所連結文字列;
            } else if (住所連結文字列.length() > getItemLength(長さ_明細部の住所１)) {
                住所２連結文字列 = 住所連結文字列.substring(getItemLength(長さ_明細部の住所１)).concat("　")
                        .concat(changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get住登内方書()));
                source.listListjusho1_1 = 住所連結文字列.substring(0, getItemLength(長さ_明細部の住所１));
            }

            if (住所２連結文字列.length() <= getItemLength(長さ_明細部の住所２)) {
                source.listListjusho2_1 = 住所２連結文字列;
            } else if (住所２連結文字列.length() > getItemLength(長さ_明細部の住所２)
                    && 住所２連結文字列.length() <= (getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３))) {
                source.listListjusho2_1 = 住所２連結文字列.substring(0, getItemLength(長さ_明細部の住所２));
                source.listListjusho3_1 = 住所２連結文字列.substring(getItemLength(長さ_明細部の住所２));
            } else {
                source.listListjusho2_1 = 住所２連結文字列.substring(0, getItemLength(長さ_明細部の住所２));
                source.listListjusho3_1 = 住所２連結文字列.substring(getItemLength(長さ_明細部の住所２),
                        getItemLength(長さ_明細部の住所２) + getItemLength(長さ_明細部の住所３));
                source.jushoKire = 住所連結文字列.concat(住所２連結文字列);
            }
        }
    }

    private void eidt抹消線(MeiboShohonJuminSource source) {

        source.listListjusho1M_1 = RString.EMPTY;
        source.listListjusho2M_1 = RString.EMPTY;
        source.listListjusho3M_1 = RString.EMPTY;
        source.listKanaShimeiM_1 = RString.EMPTY;
        source.listSeinengappiM_1 = RString.EMPTY;
        source.listSeinengappiM_2 = RString.EMPTY;
        source.listShimeiM_1 = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            edit抹消線明細(source);
        }

    }

    private void edit抹消線明細(MeiboShohonJuminSource source) {
        RString 抄本_印字有無_抹消者抹消線 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_抹消者抹消線);
        RString 抹消事由コード = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            抹消事由コード = param.get住民投票資格者名簿抄本情報().get抹消事由コード();
        }
        if (抄本_印字有無_抹消者抹消線.equals(ONE) && !changeNullToEmpty(抹消事由コード).equals(RString.EMPTY)) {
            if (!source.listListjusho1_1.equals(RString.EMPTY)) {
                source.listListjusho1M_1 = source.listListjusho1_1;
            }
            if (!source.listListjusho2_1.equals(RString.EMPTY)) {
                source.listListjusho2M_1 = source.listListjusho2_1;
            }

            if (!source.listListjusho3_1.equals(RString.EMPTY)) {
                source.listListjusho3M_1 = source.listListjusho3_1;
            }

            if (!source.listKanaShimei_1.equals(RString.EMPTY)) {
                source.listKanaShimeiM_1 = source.listKanaShimei_1;
            }

            if (!source.listSeinengappi_1.equals(RString.EMPTY)) {
                source.listSeinengappiM_1 = source.listSeinengappi_1;
            }

            if (!source.listSeinengappi_2.equals(RString.EMPTY)) {
                source.listSeinengappiM_2 = source.listSeinengappi_2;
            }

            if (!source.listShimei_1.equals(RString.EMPTY)) {
                source.listShimeiM_1 = source.listShimei_1;
            }
        }
    }

    private void edit生年月日性別(MeiboShohonJuminSource source) {
        RString 抄本_印字有無_生年月日 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_生年月日);
        RString 住民種別 = RString.EMPTY;
        RString 生年月日 = RString.EMPTY;
        RString 性別コード = RString.EMPTY;
        RString 性別表示文字 = RString.EMPTY;
        source.listSeinengappi_1 = RString.EMPTY;
        source.listSeinengappi_2 = RString.EMPTY;

        if (null != param.get住民投票資格者名簿抄本情報()) {
            住民種別 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get住民種別());
            生年月日 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get生年月日());
            性別コード = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get性別コード());
        }

        if (Seibetsu.男.code().equals(性別コード)) {
            性別表示文字 = 性別表示文字_男;
        } else if (Seibetsu.女.code().equals(性別コード)) {
            性別表示文字 = 性別表示文字_女;
        }
        if (抄本_印字有無_生年月日.equals(ONE)) {
            if (!生年月日.equals(RString.EMPTY)) {
                source.listSeinengappi_1
                        = 住民種別 == TWO ? new FlexibleDate(生年月日).seireki().toDateString() : new FlexibleDate(生年月日).wareki().toDateString();
            }
            source.listSeinengappi_2 = 性別表示文字;

        }
    }

    private void edit氏名１(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報()) {
            source.listShimei_1 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get名称());
        }
    }

    private void edit氏名２(MeiboShohonJuminSource source) {
        RString 抄本_印字有無_カナ名称 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_カナ名称);
        RString 抄本_印字有無_識別コード = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_識別コード);
        int 最大文字数_氏名2 = getItemLength(長さ_氏名２);
        RString 識別コード = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            識別コード = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get識別コード());
        }
        source.shikibetsuCode = 識別コード;
        source.listKanaShimei_1 = RString.EMPTY;
        if (抄本_印字有無_カナ名称.equals(ZERO)) {
            if (抄本_印字有無_識別コード.equals(ONE)) {
                source.listKanaShimei_1 = RString.EMPTY;
                for (int i = 0; i < getItemLength(長さ_氏名２) - 識別コード.length(); i++) {
                    source.listKanaShimei_1 = source.listKanaShimei_1.concat(new RString(" "));
                }
                source.listKanaShimei_1 = source.listKanaShimei_1.concat(changeNullToEmpty(識別コード));
            }
        } else if (抄本_印字有無_カナ名称.equals(ONE)) {
            if (InnjiFlg.印字しない.value().equals(抄本_印字有無_識別コード)) {
                int 算出文字数 = 最大文字数_氏名2 - 2;
                source.listKanaShimei_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧);
            } else if (InnjiFlg.印字する.value().equals(抄本_印字有無_識別コード)) {
                int 算出文字数 = 最大文字数_氏名2 - 識別コード.length() - 2;
                source.listKanaShimei_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧).concat(識別コード);
            }
        }
    }

    private RString getカナ名称_算出文字数(int number) {
        RString kana = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            kana = param.get住民投票資格者名簿抄本情報().getカナ名称();
        }
        RString カナ名称;
        if (null == kana) {
            カナ名称 = RString.EMPTY;
        } else if (kana.length() <= number) {
            カナ名称 = kana.padRight(number);
        } else {
            カナ名称 = kana.substring(0, number);
        }
        return カナ名称;
    }

    private void edit表示の停止文字(MeiboShohonJuminSource source) {
        ShikakuHantei shikakuHantei = new ShikakuHantei();
        source.listTeishiMoji_1 = RString.EMPTY;
        FlexibleDate 規定年齢到達年月日 = null;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            規定年齢到達年月日 = param.get住民投票資格者名簿抄本情報().get規定年齢到達年月日();
        }

        if (null != param.get宛名識別対象() || null != param.get選挙資格()
                && shikakuHantei.is公民権停止者(param.get宛名識別対象(), param.get選挙資格(), 規定年齢到達年月日, FlexibleDate.getNowDate())) {
            source.listTeishiMoji_1 = BusinessConfig.get(ConfigKeysAFA.抄本_公民権停止文字);
        }
    }

    private void edit表示の抹消事由(MeiboShohonJuminSource source) {
        RString 抹消事由コード = RString.EMPTY;
        source.listMasshoJiyu_1 = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報()) {
            抹消事由コード = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get抹消事由コード());
        }
        if (抹消事由コード.equals(RString.EMPTY)) {
            source.listMasshoJiyu_1 = RString.EMPTY;
        } else {
            source.listMasshoJiyu_1 = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), new Code(抹消事由コード));
        }
    }

    private void edit選挙管理委員会名称(MeiboShohonJuminSource source) {
        Association 地方公共団体情報 = param.get地方公共団体情報();
        source.senkanMei = RString.EMPTY;
        if (null != 地方公共団体情報) {
            source.senkanMei = changeNullToEmpty(地方公共団体情報.get市町村名()).concat(選挙管理委員会);
        }
    }

    private void edit選択範囲１(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報()) {
            source.selHani1 = changeNullToEmpty(param.get住民投票資格者名簿抄本情報().get抄本名());
        }
    }

    private void edit選択範囲２(MeiboShohonJuminSource source) {
        RString 投票年月日 = RString.EMPTY;
        if (null != param.get住民投票資格者名簿抄本情報() && param.get住民投票資格者名簿抄本情報().get投票年月日() != null) {
            投票年月日 = 文字_投票日.concat(new FlexibleDate(param.get住民投票資格者名簿抄本情報().get投票年月日()).wareki().toDateString());
        }
        source.selHani2 = 投票年月日;
    }

    private void edit集計(MeiboShohonJuminSource source) {
        if (null != param.get住民投票資格者名簿抄本情報集計()) {

            source.pageKeiMan = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getPageKeiMan()));
            source.pageKeiWoman = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getPageKeiWoman()));
            source.pageKeiKei = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getPageKeiKei()));
            source.kei1Title = changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei1Title());
            source.kei1Man = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei1Man()));
            source.kei1Woman = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei1Woman()));
            source.kei1Kei = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei1Kei()));
            source.kei2Title = changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei2Title());
            source.kei2Man = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei2Man()));
            source.kei2Woman = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei2Woman()));
            source.kei2Kei = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei2Kei()));
            source.kei3Title = changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei3Title());
            source.kei3Man = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei3Man()));
            source.kei3Woman = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei3Woman()));
            source.kei3Kei = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei3Kei()));
            source.kei4Title = changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei4Title());
            source.kei4Man = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei4Man()));
            source.kei4Woman = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei4Woman()));
            source.kei4Kei = doZZZ_ZZ9編集(changeNullToEmpty(param.get住民投票資格者名簿抄本情報集計().getKei4Kei()));

        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return null == 文字列 ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(MeiboShohonJuminSource.class, itemName);
    }

    private RString doZZZ_ZZ9編集(RString 集計) {
        if (RString.isNullOrEmpty(集計)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(集計.toString()), 0);
        }

    }

    private void editアクセスログ出力(MeiboShohonJuminSource source) {
        if (null != param.get宛名識別対象()) {
            source.識別コード = param.get宛名識別対象().getShikibetsuCode();
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
