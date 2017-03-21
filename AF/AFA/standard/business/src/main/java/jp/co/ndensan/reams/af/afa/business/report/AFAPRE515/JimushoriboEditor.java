/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE515;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.KofuJuriHoho;
import jp.co.ndensan.reams.af.afa.definition.core.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515.JimushoriboSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票AFAPRE515_Jimushoribo_事務処理簿を編集するクラスです。
 *
 * @reamsid_L AF-0280-032 wangm
 */
public class JimushoriboEditor implements IJimushoriboEditor {

    private static final RString 期日前投票_TITLE = new RString("期日前投票");
    private static final RString 不在者投票_TITLE = new RString("不在者投票");
    private static final RString 委員会名 = new RString("選挙管理委員会");

    private static final RString 不在者_明細タイトル1 = new RString("以外の場所で不在者投票をした");
    private static final RString 不在者_明細タイトル2 = new RString("不在者投票の受付月日、送付方法等");
    private static final RString 不在者_明細タイトル3 = new RString("投票用封筒及び");
    private static final RString 期日前_明細タイトル4 = new RString("投票");
    private static final RString 不在者_明細タイトル4 = new RString("投票");
    private static final RString 期日前_明細タイトル5 = new RString("用紙");
    private static final RString 不在者_明細タイトル5 = new RString("用紙・");
    private static final RString 期日前_明細タイトル6 = new RString("交付月");
    private static final RString 不在者_明細タイトル6 = new RString("投票用");
    private static final RString 期日前_明細タイトル7 = new RString("日");
    private static final RString 不在者_明細タイトル7 = new RString("封筒交");
    private static final RString 期日前_明細タイトル8 = new RString("その");
    private static final RString 不在者_明細タイトル8 = new RString("付月日");
    private static final RString 期日前_明細タイトル9 = new RString("方法");
    private static final RString 不在者_明細タイトル9 = new RString("その");
    private static final RString 不在者_明細タイトル10 = new RString("方法");
    private static final RString 期日前_明細タイトル11 = new RString("期日前");
    private static final RString 不在者_明細タイトル11 = new RString("不在者");

    private static final RString 連番 = new RString("1");
    private static final RString 受付番号 = new RString("2");

    private static final int 整理番号_LENGTH = 8;
    private static final int 投票場所_LENGTH = 8;
    private static final int 月日_LENGTH = 5;

    private static final RString ZERO = new RString("0");
    private static final RString 丸 = new RString("○");
    private static final Map<Code, RString> 事由_MAP;
    private static final RString 備考 = new RString("　代理");

    static {
        事由_MAP = new HashMap<>();
        事由_MAP.put(new Code("1"), new RString("1項1号"));
        事由_MAP.put(new Code("2"), new RString("1項2号"));
        事由_MAP.put(new Code("3"), new RString("1項3号"));
        事由_MAP.put(new Code("4"), new RString("1項4号"));
        事由_MAP.put(new Code("5"), new RString("1項5号"));
        事由_MAP.put(new Code("6"), new RString("2項 　"));
        事由_MAP.put(new Code("7"), new RString("4項 　"));
    }

    private final JimushoriboParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link JimushoriboParam}
     */
    public JimushoriboEditor(JimushoriboParam target) {
        this.target = target;
    }

    @Override
    public JimushoriboSource edit(JimushoriboSource source) {
        editCommon(source);
        if (target.is期日前投票()) {
            edit期日前投票事務処理簿(source);
        } else {
            edit不在者投票事務処理簿(source);
        }
        return source;
    }

    private void editCommon(JimushoriboSource source) {
        ZenjitsuCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();
        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();
        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();
        //選挙番号
        source.senkyoNo = new RString(target.get選挙番号().toString());
        // 選挙名称
        source.senkyoMei = target.get選挙名称();
        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();
        // 委員会名
        source.iinkaiMei = source.shichosonMei.concat(委員会名);

        AfT201TohyoJokyoEntity 投票状況 = target.get投票状況();

        // 整理番号
        RString 事務処理簿整理番号印字内容 = BusinessConfig.get(ConfigKeysAFA.事務処理簿_整理番号印字内容, SubGyomuCode.AFA選挙本体);
        if (連番.equals(事務処理簿整理番号印字内容)) {
            source.listMeisai2_1 = new RString(String.valueOf(target.get連番())).padLeft(ZERO, 整理番号_LENGTH);
            source.listMeisai1_9 = new RString(String.valueOf(target.get投票状況().getUketsukeNo())).padLeft(RString.HALF_SPACE, 整理番号_LENGTH);
        } else if (受付番号.equals(事務処理簿整理番号印字内容)) {
            source.listMeisai2_1 = new RString(String.valueOf(投票状況.getUketsukeNo())).padLeft(RString.HALF_SPACE, 整理番号_LENGTH);
            source.listMeisai1_9 = 投票状況.getDairiTohyoAriFlag() ? 備考 : RString.EMPTY;
        }

        // 投票区名
        source.listMeisai2_2 = target.get投票区名();
        // 行政区
        source.listMeisai1_1 = target.get行政区();
        // 名簿番号
        source.listMeisai3_1 = target.get名簿番号();
        // 氏名
        source.listMeisai1_2 = target.get氏名();

        switch (target.get性別()) {
            case FEMALE:
                // 性別（男）
                source.listMeisai2_3 = RString.EMPTY;
                // 性別（女）
                source.listMeisai2_4 = 丸;
                break;
            case MALE:
                // 性別（男）
                source.listMeisai2_3 = 丸;
                // 性別（女）
                source.listMeisai2_4 = RString.EMPTY;
                break;
            default:
        }
        // 請求月日
        source.listMeisai1_3 = edit月日(投票状況.getSeikyuYMD());
        // 請求方法
        source.listMeisai3_2 = new SeikyuHoho(投票状況.getSeikyuHoho()).getMeisho();
        // 事由
        source.listMeisai1_4 = 事由_MAP.get(投票状況.getTohyoJiyuCode());
        if (投票状況.getShomeishoPrintFlag()) {
            // 証明交付（有）
            source.listMeisai2_5 = 丸;
            // 証明交付（無）
            source.listMeisai2_6 = RString.EMPTY;

        } else {
            // 証明交付（有）
            source.listMeisai2_5 = RString.EMPTY;
            // 証明交付（無）
            source.listMeisai2_6 = 丸;
        }
        // 交付月日
        source.listMeisai1_5 = edit月日(投票状況.getKofuYMD());
        // 交付方法
        source.listMeisai3_3 = new KofuJuriHoho(投票状況.getKofuHoho()).getMeisho();
        // 投票月日
        source.listMeisai1_6 = edit月日(投票状況.getJuriYMD());
        // 受理月日
        source.listMeisai1_7 = edit月日(投票状況.getJuriYMD());
        // 送付方法
        source.listMeisai3_4 = new KofuJuriHoho(投票状況.getJuriHoho()).getMeisho();
        RString 施設名称 = target.get施設名称();
        if (!RString.isNullOrEmpty(施設名称)) {
            // 投票場所（上段）
            source.listMeisai1_8 = target.get施設名称().substringReturnAsPossible(0, 投票場所_LENGTH);
            // 投票場所（下段）
            source.listMeisai3_5 = target.get施設名称().substringReturnAsPossible(投票場所_LENGTH);
        }

        if (target.is合計()) {
            // 合計人数（男）
            source.seibetsuKeiMan = formatInt(target.get合計人数男());
            // 合計人数（女）
            source.seibetsuKeiWoman = formatInt(target.get合計人数女());
            // 合計人数（計）
            source.kei = formatInt(target.get合計人数計());
        }
    }

    private void edit期日前投票事務処理簿(JimushoriboSource source) {
        // タイトル
        source.title = 期日前投票_TITLE;
        // 明細タイトル1
        source.meisaiTitle1 = RString.EMPTY;
        // 明細タイトル2
        source.meisaiTitle2 = RString.EMPTY;
        // 明細タイトル3
        source.meisaiTitle3 = RString.EMPTY;
        // 明細タイトル4
        source.meisaiTitle4 = 期日前_明細タイトル4;
        // 明細タイトル5
        source.meisaiTitle5 = 期日前_明細タイトル5;
        // 明細タイトル6
        source.meisaiTitle6 = 期日前_明細タイトル6;
        // 明細タイトル7
        source.meisaiTitle7 = 期日前_明細タイトル7;
        // 明細タイトル8
        source.meisaiTitle8 = 期日前_明細タイトル8;
        // 明細タイトル9
        source.meisaiTitle9 = 期日前_明細タイトル9;
        // 明細タイトル10
        source.meisaiTitle10 = RString.EMPTY;
        // 明細タイトル11
        source.meisaiTitle11 = 期日前_明細タイトル11;

    }

    private void edit不在者投票事務処理簿(JimushoriboSource source) {
        // タイトル
        source.title = 不在者投票_TITLE;
        // 明細タイトル1
        source.meisaiTitle1 = source.shichosonMei.concat(不在者_明細タイトル1);
        // 明細タイトル2
        source.meisaiTitle2 = 不在者_明細タイトル2;
        // 明細タイトル3
        source.meisaiTitle3 = 不在者_明細タイトル3;
        // 明細タイトル4
        source.meisaiTitle4 = 不在者_明細タイトル4;
        // 明細タイトル5
        source.meisaiTitle5 = 不在者_明細タイトル5;
        // 明細タイトル6
        source.meisaiTitle6 = 不在者_明細タイトル6;
        // 明細タイトル7
        source.meisaiTitle7 = 不在者_明細タイトル7;
        // 明細タイトル8
        source.meisaiTitle8 = 不在者_明細タイトル8;
        // 明細タイトル9
        source.meisaiTitle9 = 不在者_明細タイトル9;
        // 明細タイトル10
        source.meisaiTitle10 = 不在者_明細タイトル10;
        // 明細タイトル11
        source.meisaiTitle11 = 不在者_明細タイトル11;

    }

    private RString edit月日(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString().substring(月日_LENGTH);
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,###"));
    }
}
