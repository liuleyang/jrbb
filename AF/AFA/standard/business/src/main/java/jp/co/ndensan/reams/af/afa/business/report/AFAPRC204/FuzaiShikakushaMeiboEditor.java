/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRC204;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.FuzaiShikakushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC204.FuzaiShikakushaMeiboSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link FuzaiShikakushaMeiboSource}を編集します。
 *
 * @reamsid_L AF-0030-035 liss
 */
public class FuzaiShikakushaMeiboEditor implements IFuzaiShikakushaMeiboEditor {

    private static final RString 選資_無し = new RString("無し");
    private static final RString 選資_有り = new RString("有り");
    private static final RString 選資_表示 = new RString("表示");
    private static final RString 選資_抹消 = new RString("抹消");
    private static final RString 選資_停止 = new RString("停止");
    private static final RString 性別コード_男 = new RString("1");
    private static final RString 性別コード_女 = new RString("2");
    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");
    private static final RString 帳票タイトル_郵便 = new RString("不在者資格者名簿（郵便等投票）");
    private static final RString 帳票タイトル_船員 = new RString("不在者資格者名簿（洋上投票）");
    private static final RString 帳票タイトル_南極 = new RString("不在者資格者名簿（南極投票）");
    private static final RString 代理人識別コードタイトル = new RString("代理人識別CD");
    private static final RString 代理氏名タイトル = new RString("代理記載者氏名");
    private static final RString 代理生年月日タイトル = new RString("生年月日");
    private static final RString 代理性別タイトル = new RString("性別");
    private static final RString 代理種別タイトル = new RString("種別");
    private static final RString 代理住所タイトル = new RString("代理記載者住所");
    private static final RString 郵便投票タイトル = new RString("郵便投票");
    private static final RString 資格書類タイトル = new RString("資格書類");
    private static final RString 備考タイトル = new RString("備考");
    private static final RString 住所タイトル_住所 = new RString("住所コード");
    private static final RString 住所タイトル_行政区 = new RString("行政区コード");
    private static final RString 身体障害者手帳 = new RString("身障");
    private static final RString 戦傷病者手帳 = new RString("戦傷");
    private static final RString 介護保険被保険者証 = new RString("介護");
    private static final RString 住所コード = new RString("11");
    private static final RString 行政区コード = new RString("12");
    private static final int 郵便番号１ = 3;
    private static final int 郵便番号２ = 7;
    private final Code 投票資格種類;
    private final FuzaiShikakushaMeiboEntity item;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final int rowCount;

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link FuzaiShikakushaMeiboEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param rowCount int
     */
    public FuzaiShikakushaMeiboEditor(FuzaiShikakushaMeiboEntity item, TeijiCommonJohoItem 帳票共通ヘッダー, int rowCount) {
        this.item = item;
        this.投票資格種類 = item.getFuzaishaTohyoShikakuEntity().getTohyoShikakuShurui();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.rowCount = rowCount;
    }

    @Override
    public FuzaiShikakushaMeiboSource edit(FuzaiShikakushaMeiboSource source) {
        setヘッダ(source);
        set明細(source);
        setフッタ(source);
        source.pageBreak = item.getBreakPage();
        return source;
    }

    private void setヘッダ(FuzaiShikakushaMeiboSource source) {
        source.title = get帳票タイトル();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void set明細(FuzaiShikakushaMeiboSource source) {
        set明細タイトル(source);
        set明細リスト(source);
    }

    private void set明細タイトル(FuzaiShikakushaMeiboSource source) {
        if (new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()).equals(投票資格種類)) {
            source.meisaiTitleDairShikibetsuCode = 代理人識別コードタイトル;
            source.meisaiTitleDairiShimei = 代理氏名タイトル;
            source.meisaiTitleDairiSeinengappi = 代理生年月日タイトル;
            source.meisaiTitleDairiSeibetsu = 代理性別タイトル;
            source.meisaiTitleDairiShubetsu = 代理種別タイトル;
            source.meisaiTitleDairiJusho = 代理住所タイトル;
            source.meisaiTitleShikakuShorui1 = 郵便投票タイトル;
            source.meisaiTitleShikakuShorui2 = 資格書類タイトル;
        } else {
            source.meisaiTitleDairShikibetsuCode = RString.EMPTY;
            source.meisaiTitleDairiShimei = RString.EMPTY;
            source.meisaiTitleDairiSeinengappi = RString.EMPTY;
            source.meisaiTitleDairiSeibetsu = RString.EMPTY;
            source.meisaiTitleDairiShubetsu = RString.EMPTY;
            source.meisaiTitleDairiJusho = RString.EMPTY;
            source.meisaiTitleShikakuShorui1 = RString.EMPTY;
            source.meisaiTitleShikakuShorui2 = RString.EMPTY;
        }
        source.meisaiTitleYubinshikaku = RString.EMPTY;
        source.meisaiTitle = 備考タイトル;
        if (住所コード.equals(BusinessConfig.get(ConfigKeysAFA.不在者投票資格者名簿_住所コード内容, SubGyomuCode.AFA選挙本体))) {
            source.meisaiTitleJusho = 住所タイトル_住所;
        } else if (行政区コード.equals(BusinessConfig.get(ConfigKeysAFA.不在者投票資格者名簿_住所コード内容, SubGyomuCode.AFA選挙本体))) {
            source.meisaiTitleJusho = 住所タイトル_行政区;
        } else {
            source.meisaiTitleJusho = RString.EMPTY;
        }

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 9 LINES
    private void set明細リスト(FuzaiShikakushaMeiboSource source) {
        source.listMeisai1_1 = RString.EMPTY;
        if (item.getFuzaishaTohyoShikakuEntity().getKofuNo() != null) {
            source.listMeisai1_2 = item.getFuzaishaTohyoShikakuEntity().getKofuNo();
        }
        AtenaKanaMeisho atenaKanaMeisho = item.getShikibetsuTaishoEntity().getKanaMeisho();
        if (atenaKanaMeisho != null) {
            source.listMeisai1_3 = atenaKanaMeisho.value();
        }
        source.listMeisai1_4 = NullHandler.getNullToRString(item.getSenkyoShikakuEntity().getTohyokuCode());
        YubinNo yubinNo = item.getShikibetsuTaishoEntity().getJutonaiYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            RString yubinNoString = yubinNo.value();
            source.listMeisai1_5 = yubinNoString.substringReturnAsPossible(0, 郵便番号１)
                    .concat(new RString("-")).concat(yubinNoString.substringReturnAsPossible(郵便番号１, 郵便番号２));
        }
        ChoikiCode choikiCode = item.getShikibetsuTaishoEntity().getJutonaiChoikiCode();
        GyoseikuCode gyoseikuCode = item.getShikibetsuTaishoEntity().getGyoseikuCode();
        if (住所コード.equals(BusinessConfig.get(ConfigKeysAFA.不在者投票資格者名簿_住所コード内容, SubGyomuCode.AFA選挙本体))
                && choikiCode != null) {
            source.listMeisai1_6 = choikiCode.value();
        } else if (行政区コード.equals(BusinessConfig.get(ConfigKeysAFA.不在者投票資格者名簿_住所コード内容, SubGyomuCode.AFA選挙本体))
                && gyoseikuCode != null) {
            source.listMeisai1_6 = gyoseikuCode.value();
        }
        set明細住所(source);
        if (item.getFuzaishaTohyoShikakuYubinEntity() != null && item.getFuzaishaTohyoShikakuYubinEntity().getShogaiTechoAriFlag()) {
            source.listMeisai1_8 = 身体障害者手帳;
        }
        FlexibleDate kofuYMD = item.getFuzaishaTohyoShikakuEntity().getKofuYMD();
        if (kofuYMD != null) {
            source.listMeisai1_9 = kofuYMD.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listMeisai1_10 = RString.EMPTY;
        source.listMeisai2_1 = new RString(String.valueOf(rowCount));
        ShikibetsuCode shikibetsuCode = item.getShikibetsuTaishoEntity().getShikibetsuCode();
        if (shikibetsuCode != null) {
            source.listMeisai2_2 = shikibetsuCode.value();
        }
        AtenaMeisho atenaMeisho = item.getShikibetsuTaishoEntity().getMeisho();
        if (atenaMeisho != null) {
            source.listMeisai2_3 = atenaMeisho.value();
        }
        source.listMeisai2_4 = get選資(item);
        if (item.getShikibetsuTaishoEntity().getSeinengappiYMD() != null) {
            source.listMeisai2_5 = NullHandler.getNullToFlexibleDate(item.getShikibetsuTaishoEntity().getSeinengappiYMD())
                    .wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listMeisai2_6 = ShikibetsuTaishoFactory.createKojin(item.getShikibetsuTaishoEntity()).get性別().getCommonName();
        source.listMeisai2_7 = JuminShubetsu.toValue(item.getShikibetsuTaishoEntity().getJuminShubetsuCode()).toRString();
        if (item.getFuzaishaTohyoShikakuYubinEntity() != null && item.getFuzaishaTohyoShikakuYubinEntity().getSenshoTechoAriFlag()) {
            source.listMeisai2_9 = 戦傷病者手帳;
        }
        FlexibleDate shikakuManryoYMD = item.getFuzaishaTohyoShikakuEntity().getShikakuManryoYMD();
        if (shikakuManryoYMD != null) {
            source.listMeisai2_10 = shikakuManryoYMD.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }

        source.listMeisai2_11 = RString.EMPTY;
        source.listMeisai3_1 = RString.EMPTY;
        if (new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()).equals(投票資格種類) && item.getFuzaishaTohyoShikakuYubinEntity() != null) {
            shikibetsuCode = item.getFuzaishaTohyoShikakuYubinEntity().getDairiShikibetsuCode();
            if (null != shikibetsuCode) {
                source.listMeisai3_2 = shikibetsuCode.value();
            }
            atenaMeisho = item.getFuzaishaTohyoShikakuYubinEntity().getDairiKanjiShimei();
            if (null != atenaMeisho) {
                source.listMeisai3_3 = atenaMeisho.value();
            }
            source.listMeisai3_4 = RString.EMPTY;
            source.listMeisai3_5 = NullHandler.getNullToFlexibleDate(item.getFuzaishaTohyoShikakuYubinEntity().getDairiSeinengappiYMD())
                    .wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            if (null != item.getFuzaishaTohyoShikakuYubinEntity().getDairiInputKubunRyakusho()) {
                source.listMeisai3_6 = get性別名称(item.getFuzaishaTohyoShikakuYubinEntity().getDairiSeibetsuCode());
            }
            source.listMeisai3_7 = item.getFuzaishaTohyoShikakuYubinEntity().getDairiInputKubunRyakusho();
            AtenaJusho atenaJusho = item.getFuzaishaTohyoShikakuYubinEntity().getDairiJusho();
            if (null != atenaJusho) {
                source.listMeisai3_8 = atenaJusho.value();
            }
            if (item.getFuzaishaTohyoShikakuYubinEntity().getKaigoHokenshoAriFlag()) {
                source.listMeisai3_9 = 介護保険被保険者証;
            }
        }
        FlexibleDate shikakuMasshoYMD = item.getFuzaishaTohyoShikakuEntity().getShikakuMasshoYMD();
        if (shikakuMasshoYMD != null) {
            source.listMeisai3_10 = shikakuMasshoYMD.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        RString 備考3 = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, new CodeShubetsu("7013"),
                new Code(NullHandler.getNullToRString(item.getFuzaishaTohyoShikakuEntity().getShikakuMasshoJiyuCode())));
        if (備考3 != null) {
            source.listMeisai3_11 = 備考3;
        }

    }

    private RString get性別名称(RString source) {
        if (性別コード_男.equals(source)) {
            return 性別_男;
        } else if (性別コード_女.equals(source)) {
            return 性別_女;
        }
        return RString.EMPTY;
    }

    private void set明細住所(FuzaiShikakushaMeiboSource source) {
        RStringBuilder rsbulider = new RStringBuilder();
        if (item.getShikibetsuTaishoEntity().getJutonaiJusho() != null) {
            rsbulider.append(item.getShikibetsuTaishoEntity().getJutonaiJusho());
        }
        if (item.getShikibetsuTaishoEntity().getJutonaiBanchi() != null) {
            rsbulider.append(getNullToAtenaBanchi(item.getShikibetsuTaishoEntity().getJutonaiBanchi()).value());
        }
        rsbulider.append(RString.FULL_SPACE);
        if (item.getShikibetsuTaishoEntity().getKatagaki() != null) {
            rsbulider.append(getNullToKatagaki(item.getShikibetsuTaishoEntity().getKatagaki()).value());
        }
        RString 住所 = rsbulider.toRString();
        int 住所最大印字数 = ReportDataInfoLoader.getMaxLength(FuzaiShikakushaMeiboSource.class, new RString("listMeisai1_7"));
        if (住所.length() > 住所最大印字数) {
            source.listMeisai1_7 = 住所.substring(0, 住所最大印字数);
            source.listMeisai2_8 = 住所.substring(住所最大印字数, 住所.length());
        } else {
            source.listMeisai1_7 = 住所;
        }

    }

    /**
     * AtenaBanchiがNUllの解消メソード。
     *
     * @param arg AtenaBanchi
     * @return AtenaBanchi
     */
    private static AtenaBanchi getNullToAtenaBanchi(AtenaBanchi arg) {
        if (null == arg) {
            return AtenaBanchi.EMPTY;
        } else {
            return arg;
        }
    }

    /**
     * KatagakiがNUllの解消メソード。
     *
     * @param arg AtenaBanchi
     * @return Katagaki
     */
    private static Katagaki getNullToKatagaki(Katagaki arg) {
        if (null == arg) {
            return Katagaki.EMPTY;
        } else {
            return arg;
        }
    }

    private void setフッタ(FuzaiShikakushaMeiboSource source) {
        FlexibleDate 基準日 = NullHandler.getNullToFlexibleDate(item.getMaxKijunYMD());
        FlexibleDate 投票年月日 = NullHandler.getNullToFlexibleDate(item.getShohonEntity().getTohyoYMD());
        RString 選挙名 = item.getShohonEntity().getShohonName();
        if (null == 選挙名) {
            選挙名 = RString.EMPTY;
        }
        if (new Code(SenkyoShurui.国政選挙_地方選挙.getCode()).equals(item.getShohonEntity().getSenkyoShurui())) {
            source.selSenkyoHani = 選挙名
                    .concat(new RString("（投票日："))
                    .concat(投票年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                            .fillType(FillType.BLANK).toDateString())
                    .concat(new RString("）"));
        } else if (new Code(SenkyoShurui.定時登録.getCode()).equals(item.getShohonEntity().getSenkyoShurui())) {
            source.selSenkyoHani = 選挙名
                    .concat(new RString("（基準日："))
                    .concat(基準日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                            .fillType(FillType.BLANK).toDateString())
                    .concat(new RString("）"));
        }
    }

    private RString get帳票タイトル() {
        if (new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()).equals(投票資格種類)) {
            return 帳票タイトル_郵便;
        } else if (new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()).equals(投票資格種類)) {
            return 帳票タイトル_船員;
        } else if (new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()).equals(投票資格種類)) {
            return 帳票タイトル_南極;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get選資(FuzaiShikakushaMeiboEntity item) {
        Code 選挙資格区分 = item.getSenkyoShikakuEntity().getShikakuKubun();
        if (new Code(SennkyoSikakuKubun.資格なし.value()).equals(選挙資格区分)) {
            return 選資_無し;
        } else if (new Code(SennkyoSikakuKubun.有権者.value()).equals(選挙資格区分)) {
            return 選資_有り;
        } else if (new Code(SennkyoSikakuKubun.表示者.value()).equals(選挙資格区分)) {
            return 選資_表示;
        } else if (new Code(SennkyoSikakuKubun.抹消者.value()).equals(選挙資格区分)) {
            return 選資_抹消;
        } else if (new Code(SennkyoSikakuKubun.公民権停止.value()).equals(選挙資格区分)) {
            return 選資_停止;
        } else {
            return RString.EMPTY;
        }
    }

}
