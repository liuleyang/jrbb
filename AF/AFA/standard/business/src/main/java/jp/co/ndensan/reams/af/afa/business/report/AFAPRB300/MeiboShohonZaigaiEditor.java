/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB300;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ZaigaiKokugaiKindCode;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB300.MeiboShohonZaigaiSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link MeiboShohonZaigaiSource}を編集します。
 *
 * @reamsid_L AF-0030-035 liss
 */
public class MeiboShohonZaigaiEditor implements IMeiboShohonZaigaiEditor {

    private static final RString 名称_国名 = new RString("国名");
    private static final RString 名称_経由領事官 = new RString("経由領事官");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString 選挙管理委員会 = new RString("選挙管理委員会");
    private static final RString グループコード = new RString("グループコード");
    private static final RString 投票区コード = new RString("投票区コード");
    private static final RString 領事官コード = new RString("領事官コード");
    private static final RString 国籍コード = new RString("国籍コード");
    private static final RString 冊 = new RString("冊");
    private static final RString 本籍地標識 = new RString("＊");
    private static final CharSequence 星 = new RString("*");
    private static final int サブ文字列桁数 = 5;
    private RString 住所１ = RString.EMPTY;
    private RString 住所２ = RString.EMPTY;

    private final MeiboShohonZaigaiParameter parameter;
    private final SenkyoMeiboShohonEntity target;
    private final IShikibetsuTaisho 宛名PSM;
    private final RString 出力区分;
    private final RString reportID;

    /**
     * コンストラクタです。
     *
     * @param parameter {@link MeiboShohonZaigaiParameter}
     *
     * @param reportID {@link RString}
     */
    public MeiboShohonZaigaiEditor(MeiboShohonZaigaiParameter parameter, RString reportID) {
        this.parameter = parameter;
        this.target = parameter.getEntity();
        this.出力区分 = parameter.get出力区分();
        this.宛名PSM = ShikibetsuTaishoFactory.createKojin(parameter.getEntity().getAtenaPSMEntity());
        this.reportID = reportID;
    }

    @Override
    public MeiboShohonZaigaiSource edit(MeiboShohonZaigaiSource source) {
        edit帳票タイトル(source);
        edit投票区名(source);
        edit投票区コード(source);
        editヘッダ項目名称見出し(source);
        editヘッダ項目コード(source);
        editヘッダ項目名称(source);
        editページ(source);
        if (is縦覧() && 出力区分.equals(ToriatsukaiChuishaShutsurokuHoshikiConfig.行を空白.getValue())) {
            set明細ByBlank(source);
        } else if (is縦覧() && 出力区分.equals(ToriatsukaiChuishaShutsurokuHoshikiConfig.行をマスク.getValue())) {
            set明細By星(source);
        } else {
            edit明細部の住所(source);
            edit本籍地(source);
            edit生年月日(source);
            edit性別(source);
            edit氏名１(source);
            edit氏名２(source);
            edit表示の停止文字(source);
            edit表示の抹消事由(source);
            eidt抹消線(source);
        }

        source.shikibetsuCode = 宛名PSM.get識別コード().value();
        edit選挙管理委員会名称(source);
        edit選択範囲(source);
        if (!is縦覧()) {
            editページ計(source);
            editKey１To４(source);
            edit集計１To集計４(source);
        }
        editログの出力(source);
        return source;
    }

    private void editログの出力(MeiboShohonZaigaiSource source) {
        source.識別コード1 = parameter.getEntity().getAtenaPSMEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void set明細By星(MeiboShohonZaigaiSource source) {
        source.listHonseki_1 = getマスキング文字列(this.getItemLength(new RString("listHonseki_1")));
        source.listKanaShimei_1 = getマスキング文字列(this.getItemLength(new RString("listKanaShimei_1")));
        source.listListjusho1_1 = getマスキング文字列(this.getItemLength(new RString("listListjusho1_1")));
        source.listListjusho2_1 = getマスキング文字列(this.getItemLength(new RString("listListjusho2_1")));
        source.listListjusho3_1 = getマスキング文字列(this.getItemLength(new RString("listListjusho3_1")));
        source.listSeinengappi_1 = getマスキング文字列(this.getItemLength(new RString("listSeinengappi_1")));
        source.listSeinengappi_2 = getマスキング文字列(this.getItemLength(new RString("listSeinengappi_2")));
        source.listShimei_1 = getマスキング文字列(this.getItemLength(new RString("listShimei_1")));
        source.listTeishiMoji_1 = getマスキング文字列(this.getItemLength(new RString("listTeishiMoji_1")));
        source.listMasshoJiyu_1 = getマスキング文字列(this.getItemLength(new RString("listMasshoJiyu_1")));
    }

    private void set明細ByBlank(MeiboShohonZaigaiSource source) {
        source.listHonseki_1 = RString.EMPTY;
        source.listKanaShimei_1 = RString.EMPTY;
        source.listListjusho1_1 = RString.EMPTY;
        source.listListjusho2_1 = RString.EMPTY;
        source.listListjusho3_1 = RString.EMPTY;
        source.listSeinengappi_1 = RString.EMPTY;
        source.listSeinengappi_2 = RString.EMPTY;
        source.listShimei_1 = RString.EMPTY;
        source.listTeishiMoji_1 = RString.EMPTY;
        source.listMasshoJiyu_1 = RString.EMPTY;
    }

    private RString getマスキング文字列(int length) {
        return RString.EMPTY.padRight(星, length);
    }

    private void edit帳票タイトル(MeiboShohonZaigaiSource source) {
        if (!is縦覧()) {
            source.title = new RString("在外選挙人名簿抄本");
        } else {
            source.title = new RString("在外選挙人名簿抄本（縦覧）");
        }
    }

    private void edit投票区名(MeiboShohonZaigaiSource source) {
        RString tohyokuMeiFlg = BusinessConfig.get(MeiboShohonConfigKeys.抄本_印字有無_投票区名, SubGyomuCode.AFA選挙本体);
        if (InnjiFlg.印字する.value().equals(tohyokuMeiFlg)) {
            if (new Code(SenkyoShurui.憲法改正国民投票.getCode()).equals(target.getShohonEntity().getSenkyoShurui())) {
                source.tohyokuMei = target.get投票区名();
            } else {
                source.tohyokuMei = 宛名PSM.get行政区画().getTohyoku().get名称();
            }
        } else {
            source.tohyokuMei = RString.EMPTY;
        }
    }

    private void edit投票区コード(MeiboShohonZaigaiSource source) {
        source.tohyokuCode = target.getZaigaiSenkyoninMeiboEntity().getTohyokuCode();
    }

    private void editヘッダ項目名称見出し(MeiboShohonZaigaiSource source) {
        RString ヘッダ項目名称見出し = RString.EMPTY;
        RString kokugaiKind = get在外_国外分類コード();
        if (ZaigaiKokugaiKindCode.使用しない.value().equals(kokugaiKind)) {
            ヘッダ項目名称見出し = RString.EMPTY;
        } else if (ZaigaiKokugaiKindCode.国籍コード使用する.value().equals(kokugaiKind)) {
            ヘッダ項目名称見出し = 名称_国名;
        } else if (ZaigaiKokugaiKindCode.領事官コード使用する.value().equals(kokugaiKind)) {
            ヘッダ項目名称見出し = 名称_経由領事官;
        }
        source.jushoMeisho = ヘッダ項目名称見出し;
    }

    private void editヘッダ項目コード(MeiboShohonZaigaiSource source) {
        RString ヘッダ項目コード = RString.EMPTY;
        RString kokugaiKind = get在外_国外分類コード();
        if (ZaigaiKokugaiKindCode.使用しない.value().equals(kokugaiKind)) {
            ヘッダ項目コード = RString.EMPTY;
        } else if (ZaigaiKokugaiKindCode.国籍コード使用する.value().equals(kokugaiKind)) {
            ヘッダ項目コード = target.getZaigaiSenkyoninShinseiEntity().getKokusekiCode();
        } else if (ZaigaiKokugaiKindCode.領事官コード使用する.value().equals(kokugaiKind)) {
            ヘッダ項目コード = target.getZaigaiSenkyoninShinseiEntity().getRyojikanCode();
        }
        source.jushoCode = ヘッダ項目コード;
    }

    private void editヘッダ項目名称(MeiboShohonZaigaiSource source) {
        RString ヘッダ項目名称 = RString.EMPTY;
        RString kokugaiKind = get在外_国外分類コード();
        if (ZaigaiKokugaiKindCode.使用しない.value().equals(kokugaiKind)) {
            ヘッダ項目名称 = RString.EMPTY;
        } else if (ZaigaiKokugaiKindCode.国籍コード使用する.value().equals(kokugaiKind)) {
            ヘッダ項目名称 = target.get在外選挙人国内住所();
        } else if (ZaigaiKokugaiKindCode.領事官コード使用する.value().equals(kokugaiKind)) {
            ヘッダ項目名称 = target.get領事官名();
        }
        source.jusho = ヘッダ項目名称;
    }

    private void editページ(MeiboShohonZaigaiSource source) {
        source.totalPage = parameter.getTotalPage();
        source.page = parameter.getPage();
    }

    private void edit明細部の住所(MeiboShohonZaigaiSource source) {
        AfT123ZaigaiSenkyoninJushoEntity jushoEntity = target.getZaigaiSenkyoninJushoEntity();
        AtenaJusho 住所 = null;
        AtenaBanchi 番地 = null;
        if (jushoEntity != null) {
            住所 = jushoEntity.getJusho();
            番地 = jushoEntity.getBanchi();
        }
        if (住所 == null && 番地 == null) {
            住所１ = RString.EMPTY;
        } else if (住所 == null && 番地 != null) {
            住所１ = 番地.value();
        } else if (住所 != null && 番地 != null) {
            住所１ = 住所.value().concat(番地.value());
        } else if (住所 != null) {
            住所１ = 住所.value();
        }
        int 最大文字数_住所１ = getItemLength(new RString("listListjusho1_1"));
        int 最大文字数_住所２ = getItemLength(new RString("listListjusho2_1"));
        source.listJusho = 住所１;
        RString 方書印字有無 = BusinessConfig.get(MeiboShohonConfigKeys.抄本_住所編集_方書印字有無, SubGyomuCode.AFA選挙本体);
        住所２ = RString.EMPTY;
        if (InnjiFlg.印字しない.value().equals(方書印字有無)) {
            set住所１２３By文字切れ_印字しない(最大文字数_住所１, 最大文字数_住所２);
        } else if (InnjiFlg.印字する.value().equals(方書印字有無)) {
            set住所１２３By文字切れ_印字する(source, 最大文字数_住所１, 最大文字数_住所２);
        }
        edit住所１_１(source);
        edit住所２_１(source);
        edit住所３_１(source);
    }

    private RString get在外_国外分類コード() {
        return BusinessConfig.get(MeiboShohonConfigKeys.在外_国外分類コード, SubGyomuCode.AFA選挙本体);
    }

    private void set住所１２３By文字切れ_印字しない(Integer 最大文字数_住所１, Integer 最大文字数_住所２) {
        if (住所１.length() < 最大文字数_住所１) {
            住所２ = RString.EMPTY;
        } else {
            RString 住所Temp = 住所１.substring(最大文字数_住所１, 住所１.length());
            if (住所Temp.length() < 最大文字数_住所２) {
                住所２ = 住所Temp;
            } else {
                住所２ = 住所Temp.substring(0, 最大文字数_住所２);
            }
            住所１ = 住所１.substring(0, 最大文字数_住所１);
        }
    }

    private void set住所１２３By文字切れ_印字する(MeiboShohonZaigaiSource source, Integer 最大文字数_住所１, Integer 最大文字数_住所２) {
        Katagaki katagaki = target.getZaigaiSenkyoninJushoEntity().getKatagaki();
        RString 方書 = katagaki == null ? RString.EMPTY : katagaki.value();

        if (0 == 住所１.length() || 住所１.length() < 最大文字数_住所１) {
            RString 住所Temp = 方書;
            if (0 == 住所Temp.length() || 住所Temp.length() < 最大文字数_住所２) {
                住所２ = 住所Temp;
            } else {
                住所２ = 住所Temp.substring(0, 最大文字数_住所２);
            }
        } else {
            RString 住所Temp = 住所１.substring(最大文字数_住所１, 住所１.length()).concat(RString.FULL_SPACE).concat(
                    方書);
            if (住所Temp.length() < 最大文字数_住所２) {
                住所２ = 住所Temp;
            } else {
                住所２ = 住所Temp.substring(0, 最大文字数_住所２);
            }
            住所１ = 住所１.substring(0, 最大文字数_住所１);
            source.listJusho = 住所１.concat(住所Temp);

        }
    }

    private int getItemLength(RString parameterName) {
        return ReportDataInfoLoader.getMaxLength(MeiboShohonZaigaiSource.class, parameterName);
    }

    private void edit住所１_１(MeiboShohonZaigaiSource source) {
        source.listListjusho1_1 = 住所１;
        source.listListjusho1M_1 = 住所１;
    }

    private void edit住所２_１(MeiboShohonZaigaiSource source) {
        source.listListjusho2_1 = 住所２;
        source.listListjusho2M_1 = 住所２;
    }

    private void edit住所３_１(MeiboShohonZaigaiSource source) {
        RString 在外国外分類コード = get在外_国外分類コード();
        if (ZaigaiKokugaiKindCode.使用しない.value().equals(在外国外分類コード)) {
            source.listListjusho3_1 = RString.EMPTY;
            source.listListjusho3M_1 = RString.EMPTY;
        } else if (ZaigaiKokugaiKindCode.国籍コード使用する.value().equals(在外国外分類コード)) {
            source.listListjusho3_1 = target.get在外選挙人国内住所();
            source.listListjusho3M_1 = target.get在外選挙人国内住所();
        } else if (ZaigaiKokugaiKindCode.領事官コード使用する.value().equals(在外国外分類コード)) {
            source.listListjusho3_1 = target.get領事官名();
            source.listListjusho3M_1 = target.get領事官名();
        }
    }

    private void edit生年月日(MeiboShohonZaigaiSource source) {
        RString 生年月日 = RString.EMPTY;
        RString 印字有無_生年月日Flg = BusinessConfig.get(MeiboShohonConfigKeys.抄本_印字有無_生年月日, SubGyomuCode.AFA選挙本体);
        if (InnjiFlg.印字しない.value().equals(印字有無_生年月日Flg)) {
            生年月日 = RString.EMPTY;
        } else if (InnjiFlg.印字する.value().equals(印字有無_生年月日Flg)) {
            if (ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).is外国人()) {
                生年月日 = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).get生年月日().toFlexibleDate().seireki()
                        .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            } else {
                生年月日 = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).
                        get生年月日().toFlexibleDate().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
        }
        source.listSeinengappi_1 = 生年月日;
        source.listSeinengappiM_1 = 生年月日;
    }

    private void edit性別(MeiboShohonZaigaiSource source) {
        RString 性別 = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).get性別().getName().getShortJapanese();
        source.listSeinengappi_2 = 性別;
        source.listSeinengappiM_2 = 性別;
    }

    private void edit氏名１(MeiboShohonZaigaiSource source) {
        RString 氏名１ = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).get名称().getName().value();
        source.listShimei_1 = 氏名１;
        source.listShimeiM_1 = 氏名１;
    }

    private void edit氏名２(MeiboShohonZaigaiSource source) {
        RString 氏名２ = RString.EMPTY;
        int 最大文字数 = getItemLength(new RString("listKanaShimei_1"));
        int 文字数_識別コード = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).get識別コード().value().length();
        RString 印字有無_カナ名称Flg = BusinessConfig.get(MeiboShohonConfigKeys.抄本_印字有無_カナ名称, SubGyomuCode.AFA選挙本体);
        RString 印字有無_識別コードFlg = BusinessConfig.get(MeiboShohonConfigKeys.抄本_印字有無_識別コード, SubGyomuCode.AFA選挙本体);
        RString 識別コード = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).get識別コード().value();
        if (InnjiFlg.印字しない.value().equals(印字有無_カナ名称Flg)) {
            if (InnjiFlg.印字する.value().equals(印字有無_識別コードFlg)) {
                氏名２ = getHalfSpace(最大文字数 - 文字数_識別コード).concat(識別コード);
            } else {
                氏名２ = RString.EMPTY;
            }
        } else if (InnjiFlg.印字する.value().equals(印字有無_カナ名称Flg)) {
            if (InnjiFlg.印字しない.value().equals(印字有無_識別コードFlg)) {
                int 算出文字数 = 最大文字数 - 2;
                氏名２ = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧);
            } else if (InnjiFlg.印字する.value().equals(印字有無_識別コードFlg)) {
                int 算出文字数 = 最大文字数 - 文字数_識別コード - 2;
                氏名２ = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧).concat(識別コード);
            }
        }
        source.listKanaShimei_1 = 氏名２;
        source.listKanaShimeiM_1 = 氏名２;
    }

    private RString getカナ名称_算出文字数(int number) {
        RString カナ名称 = ShikibetsuTaishoFactory.createKojin(target.getAtenaPSMEntity()).get名称().getKana().value();
        if (number < 0) {
            return RString.EMPTY;
        }
        if (number < カナ名称.length()) {
            カナ名称 = カナ名称.substring(0, number);
        } else {
            カナ名称 = カナ名称.concat(getHalfSpace(number - カナ名称.length()));
        }
        return カナ名称;
    }

    private RString getHalfSpace(Integer number) {
        RString value = RString.EMPTY;
        if (null == number || number < 1) {
            return value;
        }
        for (int i = 0; i < number; i++) {
            value = value.concat(RString.HALF_SPACE);
        }
        return value;
    }

    private void edit選挙管理委員会名称(MeiboShohonZaigaiSource source) {
        if (null != parameter.get導入団体()) {
            source.senkanMei = parameter.get導入団体().get市町村名().concat(選挙管理委員会);
        } else {
            source.senkanMei = 選挙管理委員会;
        }
    }

    private void edit選択範囲(MeiboShohonZaigaiSource source) {
        source.selHani1 = target.getShohonEntity().getShohonName();
        Code 選挙種類 = target.getShohonEntity().getSenkyoShurui();
        FlexibleDate kijunYMD = NullHandler.getNullToFlexibleDate(target.getSenkyoEntity().getKijunYMD());
        FlexibleDate tohyoUketsukeYMD = NullHandler.getNullToFlexibleDate(target.getShohonEntity().getTohyoYMD());
        if (new Code(SenkyoShurui.定時登録.getCode()).equals(選挙種類)) {
            source.selHani2 = new RString("基準日:").concat(kijunYMD.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        } else if (new Code(SenkyoShurui.国政選挙_地方選挙.getCode()).equals(選挙種類)
                || new Code(SenkyoShurui.憲法改正国民投票.getCode()).equals(選挙種類)) {
            source.selHani2 = new RString("基準日:").concat(kijunYMD.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString())
                    .concat(new RString("　投票日:")).concat(tohyoUketsukeYMD.wareki().eraType(EraType.KANJI_RYAKU)
                            .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }

    }

    private void edit表示の停止文字(MeiboShohonZaigaiSource source) {
        source.listTeishiMoji_1 = BusinessConfig.get(MeiboShohonConfigKeys.抄本_公民権停止文字, SubGyomuCode.AFA選挙本体);
    }

    private void edit表示の抹消事由(MeiboShohonZaigaiSource source) {
        if (target.getZaigaiSenkyoShikakuEntity().getMasshoJiyuCode() != null) {
            source.listMasshoJiyu_1 = CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, new CodeShubetsu("7010"),
                    target.getZaigaiSenkyoShikakuEntity().getMasshoJiyuCode());
        }
    }

    private void edit本籍地(MeiboShohonZaigaiSource source) {
        RString honseki = NullHandler.getNullToRString(target.getAtenaPSMEntity().getHonsekiZenkokuJushoCode());
        RString 地方公共団体コード = RString.EMPTY;
        if (!RString.EMPTY.equals(honseki)) {
            honseki = honseki.substring(0, サブ文字列桁数);
        }
        if (null != parameter.get導入団体() && null != parameter.get導入団体().get地方公共団体コード()) {
            地方公共団体コード = parameter.get導入団体().get地方公共団体コード()
                    .value().substring(0, サブ文字列桁数);
        }

        if (地方公共団体コード.equals(honseki)) {
            source.listHonseki_1 = 本籍地標識;
            source.listHonsekiM_1 = 本籍地標識;
        }
    }

    private Boolean is縦覧() {
        return !reportID.equals(ReportIdKeys.在外選挙人名簿抄本.value());
    }

    private void editKey１To４(MeiboShohonZaigaiSource source) {
        if (parameter.get出力順List().size() >= CommonConstant.キー4
                && !RString.isNullOrEmpty(parameter.get出力順List().get(CommonConstant.キー3))) {
            source.key4 = this.get集計Key(parameter.get出力順List().get(CommonConstant.キー3));
        }
        if (parameter.get出力順List().size() >= CommonConstant.キー3
                && !RString.isNullOrEmpty(parameter.get出力順List().get(2))) {
            source.key3 = this.get集計Key(parameter.get出力順List().get(2));
        }
        if (parameter.get出力順List().size() >= 2 && !RString.isNullOrEmpty(parameter.get出力順List().get(1))) {
            source.key2 = this.get集計Key(parameter.get出力順List().get(1));
        }
        if (parameter.get出力順List().size() >= 1 && !RString.isNullOrEmpty(parameter.get出力順List().get(0))) {
            source.key1 = this.get集計Key(parameter.get出力順List().get(0));
        }

    }

    private void edit集計１To集計４(MeiboShohonZaigaiSource source) {
        if (parameter.is集計1出力フラグ()) {
            source.kei1Title = this.get集計Title(parameter.get出力順List().get(0));
            source.kei1Man = DecimalFormatter.toコンマ区切りRString(parameter.get計１男(), 0);
            source.kei1Woman = DecimalFormatter.toコンマ区切りRString(parameter.get計１女(), 0);
            source.kei1Kei = DecimalFormatter.toコンマ区切りRString(parameter.get計１男().add(parameter.get計１女()), 0);
        }
        if (parameter.is集計2出力フラグ()) {
            source.kei2Title = this.get集計Title(parameter.get出力順List().get(1));
            source.kei2Man = DecimalFormatter.toコンマ区切りRString(parameter.get計２男(), 0);
            source.kei2Woman = DecimalFormatter.toコンマ区切りRString(parameter.get計２女(), 0);
            source.kei2Kei = DecimalFormatter.toコンマ区切りRString(parameter.get計２男().add(parameter.get計２女()), 0);
        }
        if (parameter.is集計3出力フラグ()) {
            source.kei3Title = this.get集計Title(parameter.get出力順List().get(2));
            source.kei3Man = DecimalFormatter.toコンマ区切りRString(parameter.get計３男(), 0);
            source.kei3Woman = DecimalFormatter.toコンマ区切りRString(parameter.get計３女(), 0);
            source.kei3Kei = DecimalFormatter.toコンマ区切りRString(parameter.get計３男().add(parameter.get計３女()), 0);
        }
        if (parameter.is集計4出力フラグ()) {
            source.kei4Title = this.get集計Title(parameter.get出力順List().get(CommonConstant.キー3));
            source.kei4Man = DecimalFormatter.toコンマ区切りRString(parameter.get計４男(), 0);
            source.kei4Woman = DecimalFormatter.toコンマ区切りRString(parameter.get計４女(), 0);
            source.kei4Kei = DecimalFormatter.toコンマ区切りRString(parameter.get計４男().add(parameter.get計４女()), 0);
        }
    }

    private RString get集計Title(RString 集計キー) {
        if (グループコード.equals(集計キー)) {
            return new RString("合計");
        } else if (投票区コード.equals(集計キー)) {
            return new RString("第").concat(target.getZaigaiSenkyoninMeiboEntity().getTohyokuCode()).concat("投票区計");
        } else if (領事官コード.equals(集計キー)) {
            return RString.isNullOrEmpty(target.get領事官名()) ? new RString("計") : target.get領事官名().concat("計");
        } else if (国籍コード.equals(集計キー)) {
            return RString.isNullOrEmpty(target.get在外選挙人国内住所()) ? new RString("計") : target.get在外選挙人国内住所().concat("計");
        } else if (冊.equals(集計キー)) {
            return new RString("冊計");
        }
        return RString.EMPTY;
    }

    private RString get集計Key(RString 集計キー) {
        if (グループコード.equals(集計キー)) {
            return target.getZaigaiSenkyoninMeiboEntity().getGroupCode();
        } else if (投票区コード.equals(集計キー)) {
            return 宛名PSM.get行政区画().getTohyoku().getコード().value();
        } else if (領事官コード.equals(集計キー)) {
            return target.getZaigaiSenkyoninShinseiEntity().getRyojikanCode();
        } else if (国籍コード.equals(集計キー)) {
            return target.getZaigaiSenkyoninShinseiEntity().getKokusekiCode();
        } else if (冊.equals(集計キー)) {
            return target.getZaigaiSenkyoninMeiboEntity().getSatsu();
        } else {
            return RString.EMPTY;
        }
    }

    private void editページ計(MeiboShohonZaigaiSource source) {
        source.pageKeiMan = new RString(String.valueOf(parameter.getページ計男()));
        source.pageKeiWoman = new RString(String.valueOf(parameter.getページ計女()));
        source.pageKeiKei = new RString(String.valueOf(parameter.getページ計男() + parameter.getページ計女()));
    }

    private Boolean has抹消線() {
        RString 抹消事由コード = NullHandler.getNullToRString(target.getZaigaiSenkyoShikakuEntity().getMasshoJiyuCode());
        RString 印字有無_抹消者抹消線 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_抹消者抹消線, SubGyomuCode.AFA選挙本体);
        RString 印字有無_二重登録時抹消線 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_二重登録時抹消線, SubGyomuCode.AFA選挙本体);
        if (InnjiFlg.印字する.value().equals(印字有無_抹消者抹消線) && JiyuCode.二重登録.getKey().equals(抹消事由コード)) {
            return InnjiFlg.印字する.value().equals(印字有無_二重登録時抹消線);
        }
        return false;
    }

    private void eidt抹消線(MeiboShohonZaigaiSource source) {
        if (has抹消線()) {
            source.listHonseki_1 = RString.EMPTY;
            source.listKanaShimei_1 = RString.EMPTY;
            source.listListjusho1_1 = RString.EMPTY;
            source.listListjusho2_1 = RString.EMPTY;
            source.listListjusho3_1 = RString.EMPTY;
            source.listSeinengappi_1 = RString.EMPTY;
            source.listSeinengappi_2 = RString.EMPTY;
            source.listShimei_1 = RString.EMPTY;
        } else {
            source.listHonsekiM_1 = RString.EMPTY;
            source.listKanaShimeiM_1 = RString.EMPTY;
            source.listListjusho1M_1 = RString.EMPTY;
            source.listListjusho2M_1 = RString.EMPTY;
            source.listListjusho3M_1 = RString.EMPTY;
            source.listSeinengappiM_1 = RString.EMPTY;
            source.listSeinengappiM_2 = RString.EMPTY;
            source.listShimeiM_1 = RString.EMPTY;
        }
    }
}
