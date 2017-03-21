/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JushoCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui.投票資格種類_南極;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui.投票資格種類_船員;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui.投票資格種類_郵便;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.SenkyoninMeiboShohonEntity;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.Chiku;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.Gyoseiku;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 選挙人名簿抄本のパラメタです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeinoShohonParam {

    private final boolean is縦覧;
    private final RString 取扱注意者出力方式;

    private final RString 投票区名;
    private final RString 投票区コード;

    private final RString ヘッダ項目名称見出し;
    private final RString ヘッダ項目コード;
    private final RString ヘッダ項目名称;

    private final long page;
    private final long totalPage;
    private final long realPage;

    private final boolean 抹消線;

    private final RString 住所;
    private final RString 方書;
    private final RString 生年月日;
    private final RString 不在者投票資格;
    private final Gender 性別;
    private final boolean 世帯主;
    private final IName 氏名;
    private final boolean 印字有無_カナ名称;
    private final boolean 印字有無_識別コード;
    private final List<RString> 表示;
    private final RString 受付1;
    private final RString 受付2;

    private final ShikibetsuCode 識別コード;
    private final List<RString> 選挙;

    private final RString 選挙管理委員会名称;
    private TotalParam ページ計;
    private TotalParam 計1;
    private TotalParam 計2;
    private TotalParam 計3;
    private TotalParam 計4;

    /**
     * コンストラクタ
     *
     * @param 取扱注意者出力方式 RString
     * @param 投票区名 RString
     * @param 投票区コード RString
     * @param ヘッダ項目名称見出し RString
     * @param ヘッダ項目コード RString
     * @param ヘッダ項目名称 RString
     * @param page long
     * @param totalPage long
     * @param realPage long
     * @param 抹消線 boolean
     * @param 住所 RString
     * @param 方書 RString
     * @param 生年月日 RString
     * @param 不在者投票資格 RString
     * @param 性別 RString
     * @param 世帯主 boolean
     * @param 氏名 IName
     * @param 印字有無_カナ名称 boolean
     * @param 印字有無_識別コード boolean
     * @param 表示 List<RString>
     * @param 受付1 RString
     * @param 受付2 RString
     * @param 識別コード ShikibetsuCode
     * @param 選挙 List<RString>
     * @param 選挙管理委員会名称 RString
     */
    public MeinoShohonParam(
            RString 取扱注意者出力方式,
            RString 投票区名,
            RString 投票区コード,
            RString ヘッダ項目名称見出し,
            RString ヘッダ項目コード,
            RString ヘッダ項目名称,
            long page,
            long totalPage,
            long realPage,
            boolean 抹消線,
            RString 住所,
            RString 方書,
            RString 生年月日,
            RString 不在者投票資格,
            Gender 性別,
            boolean 世帯主,
            IName 氏名,
            boolean 印字有無_カナ名称,
            boolean 印字有無_識別コード,
            List<RString> 表示,
            RString 受付1,
            RString 受付2,
            ShikibetsuCode 識別コード,
            List<RString> 選挙,
            RString 選挙管理委員会名称) {
        this.is縦覧 = false;
        this.取扱注意者出力方式 = 取扱注意者出力方式;
        this.投票区名 = 投票区名;
        this.投票区コード = 投票区コード;
        this.ヘッダ項目名称見出し = ヘッダ項目名称見出し;
        this.ヘッダ項目コード = ヘッダ項目コード;
        this.ヘッダ項目名称 = ヘッダ項目名称;
        this.page = page;
        this.totalPage = totalPage;
        this.realPage = realPage;
        this.抹消線 = 抹消線;
        this.住所 = 住所;
        this.方書 = 方書;
        this.生年月日 = 生年月日;
        this.不在者投票資格 = 不在者投票資格;
        this.性別 = 性別;
        this.世帯主 = 世帯主;
        this.氏名 = 氏名;
        this.印字有無_カナ名称 = 印字有無_カナ名称;
        this.印字有無_識別コード = 印字有無_識別コード;
        this.表示 = 表示;
        this.受付1 = 受付1;
        this.受付2 = 受付2;
        this.識別コード = 識別コード;
        this.選挙 = 選挙;
        this.選挙管理委員会名称 = 選挙管理委員会名称;
    }

    /**
     * コンストラクタ
     *
     * @param is縦覧 boolean
     * @param param MeinoShohonParam
     */
    public MeinoShohonParam(
            boolean is縦覧,
            MeinoShohonParam param) {
        this.is縦覧 = is縦覧;
        this.取扱注意者出力方式 = is縦覧 ? param.取扱注意者出力方式 : RString.EMPTY;
        this.投票区名 = param.投票区名;
        this.投票区コード = param.投票区コード;
        this.ヘッダ項目名称見出し = param.ヘッダ項目名称見出し;
        this.ヘッダ項目コード = param.ヘッダ項目コード;
        this.ヘッダ項目名称 = param.ヘッダ項目名称;
        this.page = param.page;
        this.totalPage = param.totalPage;
        this.realPage = param.realPage;
        this.抹消線 = param.抹消線;
        this.住所 = param.住所;
        this.方書 = param.方書;
        this.生年月日 = param.生年月日;
        this.不在者投票資格 = param.不在者投票資格;
        this.性別 = param.性別;
        this.世帯主 = param.世帯主;
        this.氏名 = param.氏名;
        this.印字有無_カナ名称 = param.印字有無_カナ名称;
        this.印字有無_識別コード = param.印字有無_識別コード;
        this.表示 = param.表示;
        this.受付1 = param.受付1;
        this.受付2 = param.受付2;
        this.識別コード = param.識別コード;
        this.選挙 = param.選挙;
        this.選挙管理委員会名称 = param.選挙管理委員会名称;
        if (!is縦覧) {
            this.ページ計 = param.ページ計;
            this.計1 = param.計1;
            this.計2 = param.計2;
            this.計3 = param.計3;
            this.計4 = param.計4;
        }
    }

    /**
     * 登録者数リストのパラメータbuilderクラスです。
     *
     */
    public static class MeinoShohonParamBuilder {

        private static final int 選挙_TYPE = 1;
        private static final int 不在者_TYPE = 2;
        private static final int 宛名_全履歴_TYPE = 3;

        private static final RString ヘッダ項目名称_住所 = new RString("住所");
        private static final RString ヘッダ項目名称_行政区 = new RString("行政区");
        private static final int 帳票最大行 = 25;
        private static final RString 選挙管理委員会_TAIL = new RString("選挙管理委員会");
        private static final RString 表示_内 = new RString("内");
        private static final RString 表示_外 = new RString("外");
        private static final RString 表示_出 = new RString("出");
        private static final RString 表示_再 = new RString("再");
        private static final RString 表示_表示 = new RString(" 表示");
        private static final RString 表示_転出 = new RString(" 転出");
        private static final RString アスタリスク_全角 = new RString("＊");
        private static final RString スラッシュ = new RString("/");
        private static final RString コロン = new RString(":");

        private static final RString 表示_交付済み = new RString("交付済み");
        private static final RString 表示_不在済み = new RString("不在済み");
        private static final RString 表示_交付取消 = new RString("交付取消");
        private static final RString 表示_投票棄権 = new RString("投票棄権");
        private static final RString 表示_期日前済 = new RString("期日前済");
        private static final RString 表示_当日済み = new RString("当日済み");
        private static final RString 表示_その他 = new RString("その他");

        private static final RString 受付_国_不可 = new RString("国");
        private static final RString 受付_県_不可 = new RString("県");
        private static final RString 受付_市_不可 = new RString("市");
        private static final RString 受付_不可 = new RString("　不可");

        private static final RString 受付_印字文字_不在者投票済 = new RString("不在者投票済");
        private static final RString 受付_印字文字_交付したが返票_返還 = RString.EMPTY;
        private static final RString 受付_印字文字_棄権 = new RString("棄権");
        private static final RString 受付_印字文字_期日前投票済 = new RString("期日前投票済");
        private static final RString 受付_印字文字_交付済で未受理 = new RString("不在者交付済");
        private static final RString 受付_印字文字_当日投票済 = new RString("当日投票済");
        private static final RString 受付_印字文字_期日前_OR_不在者投票済 = new RString("期・不投票済");
        private static final RString 受付_印字文字_期日前_OR_不在者_OR_当日投票済 = new RString("投票済");
        private static final RString 受付_印字文字_一部が期日前_OR_不在者投票済 = new RString("一部投票済");

        private static final RString 集計キー_グループコード = new RString("グループコード");
        private static final RString 集計キー_投票区コード = new RString("投票区コード");
        private static final RString 集計キー_住所コード = new RString("住所コード");
        private static final RString 集計キー_行政区コード = new RString("行政区コード");
        private static final RString 集計キー_地区コード１ = new RString("地区コード１");
        private static final RString 集計キー_地区コード２ = new RString("地区コード２");
        private static final RString 集計キー_地区コード３ = new RString("地区コード３");
        private static final RString 集計キー_冊 = new RString("冊");

        private static final int 表示行データ数 = 3;
        private static final int 集計4_INDEX = 0;
        private static final int 集計3_INDEX = 1;
        private static final int 集計2_INDEX = 2;
        private static final int 集計1_INDEX = 3;

        private static final List<RString> EMPTY_選挙 = Arrays.asList(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);

        private final RString 集計印字_グループコード = new RString("合計");
        private final RString 集計印字_投票区コード__HEAD = new RString("第");
        private final RString 集計印字_投票区コード__TAIL = new RString("投票区計");
        private final RString 集計印字_住所コード = new RString("住所計");
        private final RString 集計印字_行政区コード__TAIL = new RString("計");
        private final RString 集計印字_地区コード１__TAIL = new RString("計");
        private final RString 集計印字_地区コード２__TAIL = new RString("計");
        private final RString 集計印字_地区コード３__TAIL = new RString("計");
        private final RString 集計印字_冊 = new RString("冊計");

        private final ShikakuHantei shikakuHantei;
        private final TohyoShikakuHantei tohyoShikakuHantei;
        private final AFABTA101SelectProcessParameter parameter;

        private final RString 選挙管理委員会;
        private final RString 出力方式;

        private final int 最大印字行;
        private final boolean is抄本グループコード資格区分毎;
        private final long 表示者ページ;
        private final long 公民権停止者ページ;
        private final boolean 抄本印字有無投票区名;
        private final boolean 印字有無_抹消者抹消線;
        private final boolean 印字有無_二重登録時抹消線;
        private final boolean 印字有無_生年月日;
        private final boolean 印字有無_世帯主区分;
        private final boolean 印字有無_カナ名称;
        private final boolean 印字有無_識別コード;
        private final RString 印字有無_日付;
        private final boolean 方書印字有無;
        private final RString 消除年月日検索基準;
        private final boolean 印字有無_転出先名;
        private final boolean 受付欄編集_印字有無_投票不可情報;
        private final boolean 受付欄編集_印字有無_不在者交付済;
        private final boolean 受付欄編集_印字有無_一部投票済;

        private final RString 抄本住所編集ヘッダ部住所;
        private final RString ヘッダ項目名称見出し;
        private final RString 抄本_住所編集_住所欄出力内容;
        private final RString 抄本_公民権停止文字;

        private SenkyoninMeiboShohonEntity current;
        private ZenkokuJushoItem current全国住所;

        private List<AfT111SenkyoEntity> afT111SenkyoList;
        private List<AfT201TohyoJokyoEntity> afT201TohyoJokyoList;
        private List<AfT114FuzaishaTohyoShikakuEntity> afT114List;
        private List<UaFt200FindShikibetsuTaishoEntity> uaft200List;

        private int lineInPage;
        private long page;
        private long totalPage;
        private long realPage;

        private TotalParam ページ計;

        private final List<TotalParam> 計List;

        /**
         * コンストラクタ
         *
         * @param parameter AFABTA101SelectProcessParameter
         * @param 出力順List List<RString>
         * @param 市町村名 RString
         */
        public MeinoShohonParamBuilder(AFABTA101SelectProcessParameter parameter,
                List<RString> 出力順List,
                RString 市町村名) {

            this.parameter = parameter;
            shikakuHantei = new ShikakuHantei();
            tohyoShikakuHantei = new TohyoShikakuHantei();

            this.選挙管理委員会 = 市町村名.concat(選挙管理委員会_TAIL);
            出力方式 = BusinessConfig.get(
                    ToriatsukaiChuishaShutsurokuHoshikiConfig.取扱注意者_出力方式, SubGyomuCode.AFA選挙本体);

            // load config
            最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_ページ行数, SubGyomuCode.AFA選挙本体).toString());

            is抄本グループコード資格区分毎 = AFAConfigKeysValue.抄本_グループコード_資格区分毎.isEqual(ConfigKeysAFA.抄本_グループコード);
            表示者ページ = !is抄本グループコード資格区分毎 ? 0
                    : Long.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_開始ページ指示_表示者ページ, SubGyomuCode.AFA選挙本体).toString()) - 1;
            公民権停止者ページ = !is抄本グループコード資格区分毎 ? 0
                    : Long.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_開始ページ指示_公民権停止者ページ, SubGyomuCode.AFA選挙本体).toString()) - 1;
            抄本印字有無投票区名 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_投票区名);
            印字有無_抹消者抹消線 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_抹消者抹消線);
            印字有無_二重登録時抹消線 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_二重登録時抹消線);
            印字有無_生年月日 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_生年月日);
            印字有無_世帯主区分 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_世帯主区分);
            印字有無_カナ名称 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_カナ名称);
            印字有無_識別コード = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_識別コード);
            印字有無_日付 = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_日付, SubGyomuCode.AFA選挙本体);
            方書印字有無 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_住所編集_方書印字有無);
            消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
            印字有無_転出先名 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_印字有無_転出先名);
            受付欄編集_印字有無_投票不可情報 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_受付欄編集_印字有無_投票不可情報);
            受付欄編集_印字有無_不在者交付済 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_受付欄編集_印字有無_不在者交付済);
            受付欄編集_印字有無_一部投票済 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.抄本_受付欄編集_印字有無_一部投票済);

            抄本住所編集ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所, SubGyomuCode.AFA選挙本体);
            if (JushoCode.住所.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目名称見出し = ヘッダ項目名称_住所;
            } else if (JushoCode.行政区.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目名称見出し = ヘッダ項目名称_行政区;
            } else if (JushoCode.地区コード１.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目名称見出し = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
            } else if (JushoCode.地区コード２.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目名称見出し = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
            } else if (JushoCode.地区コード３.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目名称見出し = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
            } else {
                ヘッダ項目名称見出し = RString.EMPTY;
            }

            抄本_住所編集_住所欄出力内容 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_住所欄出力内容, SubGyomuCode.AFA選挙本体);
            抄本_公民権停止文字 = BusinessConfig.get(ConfigKeysAFA.抄本_公民権停止文字, SubGyomuCode.AFA選挙本体);

            current = null;
            current全国住所 = null;

            afT111SenkyoList = null;
            afT114List = null;

            lineInPage = 1;
            page = 1;
            totalPage = 1;
            realPage = 1;

            ページ計 = new TotalParam(RString.EMPTY);

            計List = new ArrayList<>();
            for (RString 出力順 : 出力順List) {
                計List.add(new TotalParam(出力順));
            }

        }

        /**
         * 検索データを追加します。
         *
         * @param entity SenkyoninMeiboShohonEntity
         *
         * @return MeinoShohonParam
         */
        public MeinoShohonParam addData(SenkyoninMeiboShohonEntity entity) {
            MeinoShohonParam param = null;
            if (current == null) {
                newEntity(entity);
            } else if (is同じレコード(current, entity)) {
                addSenkyoAndFuzaishaTohyoShikaku(entity);
            } else {
                param = newParam();
                集計(param, entity);
                newEntity(entity);
            }
            return param;

        }

        /**
         * 最後合計です。
         *
         * @return MeinoShohonParam
         */
        public MeinoShohonParam afterAll() {
            MeinoShohonParam param = null;
            if (current != null) {
                param = newParam();
                集計(param, null);
            }
            return param;

        }

        private void newEntity(SenkyoninMeiboShohonEntity entity) {
            current = entity;
            UrT0101ZenkokuJushoEntity urT0101 = entity.getUrT0101();
            current全国住所 = urT0101 == null ? null : new ZenkokuJushoItem(urT0101);
            afT111SenkyoList = new ArrayList<>();
            afT201TohyoJokyoList = new ArrayList<>();
            afT114List = new ArrayList<>();
            uaft200List = new ArrayList<>();
            addSenkyoAndFuzaishaTohyoShikaku(entity);
        }

        //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
        private void addSenkyoAndFuzaishaTohyoShikaku(SenkyoninMeiboShohonEntity entity) {

            switch (entity.getType()) {
                case 選挙_TYPE:
                    AfT111SenkyoEntity senkyo = entity.getAfT111Senkyo();
                    if (senkyo != null) {
                        afT111SenkyoList.add(senkyo);
                        afT201TohyoJokyoList.add(entity.getAfT201TohyoJokyo());
                    }
                    break;
                case 不在者_TYPE:
                    AfT114FuzaishaTohyoShikakuEntity fuzaishaTohyoShikaku = entity.getAfT114();
                    if (fuzaishaTohyoShikaku != null) {
                        afT114List.add(fuzaishaTohyoShikaku);
                    }
                    break;
                case 宛名_全履歴_TYPE:
                    UaFt200FindShikibetsuTaishoEntity uaft200 = entity.getUaft200ForAll();
                    if (uaft200 != null) {
                        uaft200List.add(uaft200);
                    }
                    break;
                default:
            }

        }

        //CHECKSTYLE IGNORE MethodLength FOR NEXT 170 LINES
        //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 170 LINES
        private MeinoShohonParam newParam() {

            IShikibetsuTaisho 宛名PSM = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.getUaft200());

            // 投票区名
            RString 投票区名 = 抄本印字有無投票区名 ? 宛名PSM.get行政区画().getTohyoku().get名称() : RString.EMPTY;

            // 投票区コード
            RString 投票区コード = current.getAfT112SenkyoninMeibo().getTohyokuCode();

            // ヘッダ項目コード
            RString ヘッダ項目コード;

            // ヘッダ項目名称
            RString ヘッダ項目名称;

            IKojin kojin = 宛名PSM.to個人();
            IGyoseiKukaku 行政区画 = kojin.get行政区画();
            IJusho 住登内住所 = kojin.get住登内住所();
            Gyoseiku gyoseiku = 行政区画.getGyoseiku();

            if (JushoCode.住所.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目コード = 住登内住所.get町域コード().value();
                ヘッダ項目名称 = 住登内住所.get住所();

            } else if (JushoCode.行政区.value().equals(抄本住所編集ヘッダ部住所)) {
                ヘッダ項目コード = gyoseiku.getコード().value();
                ヘッダ項目名称 = gyoseiku.get名称();
            } else if (JushoCode.地区コード１.value().equals(抄本住所編集ヘッダ部住所)) {
                Chiku chiku1 = 行政区画.getChiku1();
                ヘッダ項目コード = chiku1.getコード().value();
                ヘッダ項目名称 = chiku1.get名称();
            } else if (JushoCode.地区コード２.value().equals(抄本住所編集ヘッダ部住所)) {
                Chiku chiku2 = 行政区画.getChiku2();
                ヘッダ項目コード = chiku2.getコード().value();
                ヘッダ項目名称 = chiku2.get名称();
            } else if (JushoCode.地区コード３.value().equals(抄本住所編集ヘッダ部住所)) {
                Chiku chiku3 = 行政区画.getChiku3();
                ヘッダ項目コード = chiku3.getコード().value();
                ヘッダ項目名称 = chiku3.get名称();
            } else {
                ヘッダ項目コード = RString.EMPTY;
                ヘッダ項目名称 = RString.EMPTY;
            }

            // 抹消線
            boolean 抹消線;
            Code 抹消事由コード = current.getAfT113SenkyoShikaku().getMasshoJiyuCode();
            if (抹消事由コード != null && !抹消事由コード.isEmpty()) {
                抹消線 = 印字有無_抹消者抹消線
                        && (!JiyuCode.二重登録.getKey().equals(抹消事由コード.getColumnValue()) || 印字有無_二重登録時抹消線);
            } else {
                抹消線 = current.getAfT112SenkyoninMeibo().getTohyokuHenkoMasshoFlag();
            }

            // 住所
            RStringBuilder 住所Builder = new RStringBuilder();
            if (JushoCode.行政区_番地.value().equals(抄本_住所編集_住所欄出力内容)) {
                住所Builder.append(gyoseiku.get名称());
            } else if (JushoCode.住所_番地.value().equals(抄本_住所編集_住所欄出力内容)) {
                住所Builder.append(住登内住所.get住所());
            }
            if (Arrays.asList(JushoCode.番地.value(), JushoCode.住所_番地.value(), JushoCode.行政区_番地.value()).contains(抄本_住所編集_住所欄出力内容)) {
                住所Builder.append(住登内住所.get番地().getBanchi().value());
            }
            RString 住所 = 住所Builder.toRString();
            RString 方書 = 方書印字有無 ? 住登内住所.get方書().value() : RString.EMPTY;

            // 生年月日
            RString 生年月日 = RString.EMPTY;
            if (印字有無_生年月日 && 宛名PSM.canBe個人()) {
                IKojin 個人 = 宛名PSM.to個人();
                if (個人.is外国人()) {
                    生年月日 = 個人.get生年月日().toFlexibleDate().seireki()
                            .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                } else {
                    生年月日 = 個人.get生年月日().toFlexibleDate().wareki().eraType(EraType.KANJI_RYAKU)
                            .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                }
            }

            // 不在者投票資格
            RString 不在者投票資格 = RString.EMPTY;
            if (shikakuHantei.has郵便投票資格(宛名PSM.get識別コード(), parameter.getKijunbi(), afT114List)) {
                不在者投票資格 = new TohyoShikakuShurui(投票資格種類_郵便.getCode()).getRyakusho();
            } else if (shikakuHantei.has洋上投票資格(宛名PSM.get識別コード(), parameter.getKijunbi(), afT114List)) {
                不在者投票資格 = new TohyoShikakuShurui(投票資格種類_船員.getCode()).getRyakusho();
            } else if (shikakuHantei.has南極投票資格(宛名PSM.get識別コード(), parameter.getKijunbi(), afT114List)) {
                不在者投票資格 = new TohyoShikakuShurui(投票資格種類_南極.getCode()).getRyakusho();
            }

            // 性別
            Gender 性別 = null;
            if (宛名PSM.canBe個人()) {
                性別 = 宛名PSM.to個人().get性別();
            }

            // 世帯主
            boolean 世帯主 = false;
            if (印字有無_世帯主区分 && 宛名PSM.canBe個人()) {
                IKojin 個人 = 宛名PSM.to個人();
                世帯主 = (個人.is住民() && 個人.is世帯主())
                        || (!個人.is住民() && 個人.is世帯主() && 個人.get世帯主識別コード().equals(個人.get識別コード()));
            }

            // 氏名
            IName 氏名 = 宛名PSM.get名称();

            // 表示
            List<RString> 表示 = get表示();

            // 受付
            RString 受付1 = RString.EMPTY;
            RString 受付2 = RString.EMPTY;
            if (is選挙時登録(current)) {
                受付1 = get受付1();
                受付2 = get受付2();
            }

            // 識別コード
            ShikibetsuCode 識別コード = 宛名PSM.get識別コード();

            // 選挙
            List<RString> 選挙 = new ArrayList<>(EMPTY_選挙);
            for (AfT111SenkyoEntity aft111 : afT111SenkyoList) {
                int index = aft111.getSenkyoNo().getColumnValue() - 1;
                if (index < 選挙.size()) {
                    RStringBuilder 選挙Builder = new RStringBuilder();
                    選挙Builder.append(aft111.getSenkyoMark());
                    選挙Builder.append(コロン);
                    選挙Builder.append(aft111.getSenkyoRyakusho());

                    選挙.set(index, 選挙Builder.toRString());
                }
            }

            long totalPageReal = this.totalPage;
            RString 選挙資格区分 = NullHandler.getNullToRString(current.getAfT113SenkyoShikaku().getShikakuKubun());
            if (SennkyoSikakuKubun.表示者.value().equals(選挙資格区分)) {
                totalPageReal += 表示者ページ;
            }
            if (SennkyoSikakuKubun.公民権停止.value().equals(選挙資格区分)) {
                totalPageReal += 公民権停止者ページ;
            }
            UaFt400FindeCautionShaMapperEntity uaft400 = current.getUaft400();
            return new MeinoShohonParam(
                    uaft400 != null && uaft400.isGaitoKubun() ? 出力方式 : RString.EMPTY,
                    投票区名,
                    投票区コード,
                    ヘッダ項目名称見出し,
                    ヘッダ項目コード,
                    ヘッダ項目名称,
                    page,
                    totalPageReal,
                    realPage,
                    抹消線,
                    住所,
                    方書,
                    生年月日,
                    不在者投票資格,
                    性別,
                    世帯主,
                    氏名,
                    印字有無_カナ名称,
                    印字有無_識別コード,
                    表示,
                    受付1,
                    受付2,
                    識別コード,
                    選挙,
                    選挙管理委員会);
        }

        /**
         * 表示を取得します。
         *
         * @return 表示
         */
        protected List<RString> get表示() {
            return get表示2(get表示1());
        }

        //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 120 LINES
        //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 120 LINES
        private List<RString> get表示1() {
            List<RString> 表示 = new ArrayList<>();

            boolean is再転入者 = shikakuHantei.is再転入者(uaft200List, parameter.getTenshutuKigenbi(),
                    parameter.getTennyuKigenbi(), parameter.getNenreiKigenbi());

            RString 選挙資格区分 = NullHandler.getNullToRString(current.getAfT113SenkyoShikaku().getShikakuKubun());

            if (is再転入者 || Arrays.asList(SennkyoSikakuKubun.表示者.value(),
                    SennkyoSikakuKubun.抹消者.value(),
                    SennkyoSikakuKubun.公民権停止.value()).contains(選挙資格区分)) {
                SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
                senkyoninTohyoJokyoEntity.setAtenaPSMEntity(current.getUaft200());

                Boolean is都道府県内転出者 = shikakuHantei.is都道府県内転出者(senkyoninTohyoJokyoEntity);
                Boolean is都道府県外転出者 = shikakuHantei.is都道府県外転出者(senkyoninTohyoJokyoEntity);
                Boolean is国外転出者 = shikakuHantei.is国外転出者(senkyoninTohyoJokyoEntity);

                if (is都道府県内転出者 && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分)) {
                    表示.add(表示_内.concat(RString.FULL_SPACE));
                } else if (is都道府県内転出者 && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分)) {
                    表示.add(表示_内.concat(アスタリスク_全角));
                } else if (is都道府県外転出者 && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分)) {
                    表示.add(表示_外.concat(RString.FULL_SPACE));
                } else if (is都道府県外転出者 && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分)) {
                    表示.add(表示_外.concat(アスタリスク_全角));
                } else if (is国外転出者 && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分)) {
                    表示.add(表示_出.concat(RString.FULL_SPACE));
                } else if (is国外転出者 && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分)) {
                    表示.add(表示_出.concat(アスタリスク_全角));
                } else if (SennkyoSikakuKubun.公民権停止.value().equals(選挙資格区分)) {
                    表示.add(抄本_公民権停止文字.concat(RString.FULL_SPACE));
                } else if (is再転入者) {
                    表示.add(表示_再.concat(RString.FULL_SPACE));
                }
                表示.add(RString.EMPTY);

                FlexibleDate 表示年月日 = null;
                RString 表示項 = null;
                if (InnjiFlg.印字する.value().equals(印字有無_日付)) {
                    表示年月日 = current.getAfT113SenkyoShikaku().getHyojiYMD();
                    表示項 = 表示_表示;
                } else if (InnjiFlg.印字その他.value().equals(印字有無_日付)) {
                    表示年月日 = AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)
                            ? current.getUaft200().getShojoTodokedeYMD()
                            : current.getUaft200().getShojoIdoYMD();
                    表示項 = 表示_転出;
                }
                if (null != 表示年月日 && !表示年月日.isEmpty()) {
                    表示.add(get日付印字内容(表示年月日, 表示項));
                }
                表示.add(RString.EMPTY);

                if (印字有無_転出先名 && current全国住所 != null) {
                    if (is都道府県内転出者) {
                        表示.add(current全国住所.get市町村名());

                    } else if (is都道府県外転出者) {
                        表示.add(current全国住所.get都道府県名());
                    } else {
                        表示.add(RString.EMPTY);
                    }
                } else {
                    表示.add(RString.EMPTY);
                }

                boolean 表示1Empty = true;
                for (RString 表示RString : 表示) {
                    if (!RString.isNullOrEmpty(表示RString)) {
                        表示1Empty = false;
                    }
                }
                if (表示1Empty) {
                    表示 = new ArrayList<>();
                }

            }
            return 表示;
        }

        /**
         * 表示2を取得します。
         *
         * @param 表示 List<RString>
         * @return 表示2
         */
        protected List<RString> get表示2(List<RString> 表示) {
            if (is選挙時登録(current)) {
                List<RString> 交付済みList = new ArrayList<>();
                交付済みList.add(表示_交付済み);
                List<RString> 不在済みList = new ArrayList<>();
                不在済みList.add(表示_不在済み);
                List<RString> 交付取消List = new ArrayList<>();
                交付取消List.add(表示_交付取消);
                List<RString> 投票棄権List = new ArrayList<>();
                投票棄権List.add(表示_投票棄権);
                List<RString> 期日前済List = new ArrayList<>();
                期日前済List.add(表示_期日前済);
                List<RString> 当日済みList = new ArrayList<>();
                当日済みList.add(表示_当日済み);
                List<RString> その他List = new ArrayList<>();
                その他List.add(表示_その他);

                for (int i = 0; i < afT111SenkyoList.size(); i++) {
                    AfT111SenkyoEntity afT111Senkyo = afT111SenkyoList.get(i);
                    AfT201TohyoJokyoEntity afT201TohyoJokyo = afT201TohyoJokyoList.get(i);

                    if (afT201TohyoJokyo == null) {
                        その他List.add(afT111Senkyo.getSenkyoMark());
                    } else {
                        Code tohyoJokyo = afT201TohyoJokyo.getTohyoJokyo();
                        RString tohyoJokyoCode = tohyoJokyo == null ? RString.EMPTY : tohyoJokyo.getColumnValue();
                        if (TohyoJokyo.交付.getCode().equals(tohyoJokyoCode)) {
                            交付済みList.add(get日付印字内容(afT201TohyoJokyo.getKofuYMD(), afT111Senkyo.getSenkyoMark()));
                        } else if (TohyoJokyo.受理.getCode().equals(tohyoJokyoCode)) {
                            不在済みList.add(get日付印字内容(afT201TohyoJokyo.getJuriYMD(), afT111Senkyo.getSenkyoMark()));
                        } else if (TohyoJokyo.返還.getCode().equals(tohyoJokyoCode)) {
                            交付取消List.add(afT111Senkyo.getSenkyoMark());
                        } else if (TohyoJokyo.棄権.getCode().equals(tohyoJokyoCode)) {
                            投票棄権List.add(afT111Senkyo.getSenkyoMark());
                        } else if (TohyoJokyo.期日前.getCode().equals(tohyoJokyoCode)) {
                            期日前済List.add(get日付印字内容(afT201TohyoJokyo.getJuriYMD(), afT111Senkyo.getSenkyoMark()));
                        } else if (TohyoJokyo.当日.getCode().equals(tohyoJokyoCode)) {
                            当日済みList.add(get日付印字内容(afT201TohyoJokyo.getJuriYMD(), afT111Senkyo.getSenkyoMark()));
                        } else {
                            その他List.add(afT111Senkyo.getSenkyoMark());
                        }
                    }

                }
                表示.addAll(edit表示2List(交付済みList));
                表示.addAll(edit表示2List(不在済みList));
                表示.addAll(edit表示2List(交付取消List));
                表示.addAll(edit表示2List(投票棄権List));
                表示.addAll(edit表示2List(期日前済List));
                表示.addAll(edit表示2List(当日済みList));
                表示.addAll(edit表示2List(その他List));

            }
            return 表示;
        }

        /**
         * 受付1を取得します。
         *
         * @return 受付1
         */
        //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 120 LINES
        protected RString get受付1() {
            UaFt200FindShikibetsuTaishoEntity uaft200 = current.getUaft200();
            AfT113SenkyoShikakuEntity aft113 = current.getAfT113SenkyoShikaku();

            RString 受付1 = RString.EMPTY;
            if (shikakuHantei.is公民権停止者(uaft200,
                    aft113,
                    parameter.getNenreiKigenbi(),
                    parameter.getKijunbi())) {
                受付1 = 抄本_公民権停止文字;
            }

            if (RString.isNullOrEmpty(受付1)) {
                Code 抹消事由コード = aft113.getMasshoJiyuCode();
                if (抹消事由コード != null && !抹消事由コード.isEmpty()) {
                    受付1 = aft113.getMasshoJiyuCodeRyakusho();
                }
            }

            if (RString.isNullOrEmpty(受付1) && 受付欄編集_印字有無_投票不可情報) {
                Boolean 国 = false;
                Boolean 県 = false;
                Boolean 市 = false;

                SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();

                SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
                senkyoJohoEntity.setShohonEntity(current.getAfT100Shohon());
                senkyoJohoEntity.setSenkyoEntity(afT111SenkyoList);
                senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);

                senkyoninTohyoJokyoEntity.setSenkyoShikakuEntity(aft113);
                senkyoninTohyoJokyoEntity.setAtenaPSMEntity(uaft200);
                senkyoninTohyoJokyoEntity.setSenkyoninMeiboEntity(current.getAfT112SenkyoninMeibo());
                List<Boolean> 投票資格List = tohyoShikakuHantei.has投票資格(senkyoninTohyoJokyoEntity, uaft200.getShikibetsuCode(), parameter.getKijunbi());

                for (int i = 0; i < 投票資格List.size(); i++) {
                    AfT111SenkyoEntity afT111Senkyo = afT111SenkyoList.get(i);
                    Code senkyoLevel = afT111Senkyo.getSenkyoLevel();
                    if (!投票資格List.get(i) && senkyoLevel != null && !senkyoLevel.isEmpty()) {
                        if (SennkyoLevel.国.value().equals(senkyoLevel.getColumnValue())) {
                            国 = true;
                        } else if (SennkyoLevel.都道府県.value().equals(senkyoLevel.getColumnValue())) {
                            県 = true;
                        } else if (SennkyoLevel.市区町村.value().equals(senkyoLevel.getColumnValue())) {
                            市 = true;
                        }
                    }
                }

                RStringBuilder 受付1builder = new RStringBuilder();

                if (国) {
                    受付1builder.append(受付_国_不可);
                }
                if (県) {
                    受付1builder.append(受付_県_不可);
                }
                if (市) {
                    受付1builder.append(受付_市_不可);
                }
                if (受付1builder.length() > 0) {
                    受付1builder.append(受付_不可);
                }
                受付1 = 受付1builder.toRString();
            }

            return 受付1;
        }

        //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 120 LINES
        private RString get受付2() {

            boolean is不在者投票済 = true;
            boolean is交付したが返票返還 = true;
            boolean is棄権 = true;
            boolean is期日前投票済 = true;
            boolean is交付済で未受理 = false;
            boolean is当日投票済 = true;
            boolean is期日前or不在者投票済 = true;
            boolean is期日前or不在者or当日投票済 = true;
            boolean is一部が期日前or不在者投票済 = false;
            boolean is全無投票 = true;

            for (int i = 0; i < afT111SenkyoList.size(); i++) {
                if (!afT111SenkyoList.get(i).getMutohyoSenkyoFlag()) {
                    is全無投票 = false;
                    AfT201TohyoJokyoEntity aft201 = afT201TohyoJokyoList.get(i);
                    RString 投票状況 = aft201 == null ? RString.EMPTY : NullHandler.getNullToRString(aft201.getTohyoJokyo());

                    if (!TohyoJokyo.受理.getCode().equals(投票状況)) {
                        is不在者投票済 = false;
                    }
                    if (!TohyoJokyo.返還.getCode().equals(投票状況)) {
                        is交付したが返票返還 = false;
                    }
                    if (!TohyoJokyo.棄権.getCode().equals(投票状況)) {
                        is棄権 = false;
                    }
                    if (!TohyoJokyo.期日前.getCode().equals(投票状況)) {
                        is期日前投票済 = false;
                    }
                    if (TohyoJokyo.交付.getCode().equals(投票状況)) {
                        is交付済で未受理 = true;
                    }
                    if (!TohyoJokyo.当日.getCode().equals(投票状況)) {
                        is当日投票済 = false;
                    }
                    if (!Arrays.asList(TohyoJokyo.受理.getCode(), TohyoJokyo.期日前.getCode()).contains(投票状況)) {
                        is期日前or不在者投票済 = false;
                    }
                    if (!Arrays.asList(TohyoJokyo.受理.getCode(), TohyoJokyo.期日前.getCode(), TohyoJokyo.当日.getCode()).contains(投票状況)) {
                        is期日前or不在者or当日投票済 = false;
                    }
                    if (Arrays.asList(TohyoJokyo.受理.getCode(), TohyoJokyo.期日前.getCode()).contains(投票状況)) {
                        is一部が期日前or不在者投票済 = true;
                    }

                }
            }

            if (is全無投票) {
                return RString.EMPTY;
            }
            if (is不在者投票済) {
                return 受付_印字文字_不在者投票済;
            }
            if (is交付したが返票返還) {
                return 受付_印字文字_交付したが返票_返還;
            }
            if (is棄権) {
                return 受付_印字文字_棄権;
            }
            if (is期日前投票済) {
                return 受付_印字文字_期日前投票済;
            }
            if (is交付済で未受理 && 受付欄編集_印字有無_不在者交付済) {
                return 受付_印字文字_交付済で未受理;
            }
            if (is当日投票済) {
                return 受付_印字文字_当日投票済;
            }
            if (is期日前or不在者投票済) {
                return 受付_印字文字_期日前_OR_不在者投票済;
            }
            if (is期日前or不在者or当日投票済) {
                return 受付_印字文字_期日前_OR_不在者_OR_当日投票済;
            }
            if (is一部が期日前or不在者投票済 && 受付欄編集_印字有無_一部投票済) {
                return 受付_印字文字_一部が期日前_OR_不在者投票済;
            }
            return RString.EMPTY;
        }

        private Boolean is選挙時登録(SenkyoninMeiboShohonEntity entity) {
            return SenkyoShurui.国政選挙_地方選挙.getCode().equals(entity.getAfT100Shohon().getSenkyoShurui().value());
        }

        private RString get日付印字内容(FlexibleDate date, RString 表示項) {
            return (date == null
                    ? RString.EMPTY
                    : new RString(String.valueOf(date.getMonthValue())).concat(スラッシュ).concat(new RString(String.valueOf(date.getDayValue()))))
                    .concat(RString.HALF_SPACE).concat(表示項);
        }

        private List<RString> edit表示2List(List<RString> 表示2List) {
            if (表示2List.size() == 1) {
                return new ArrayList<>();
            } else {
                switch (表示2List.size() % 表示行データ数) {
                    case 1:
                        表示2List.add(RString.EMPTY);
                        表示2List.add(RString.EMPTY);
                        break;
                    case 2:
                        表示2List.add(RString.EMPTY);
                        break;
                    default:
                }
            }
            return 表示2List;
        }

        private boolean is同じレコード(SenkyoninMeiboShohonEntity current, SenkyoninMeiboShohonEntity entity) {
            return current.getAfT112SenkyoninMeibo().equalsPrimaryKeys(entity.getAfT112SenkyoninMeibo());
        }

        private void 集計(MeinoShohonParam param, SenkyoninMeiboShohonEntity entity) {

            lineInPage++;
            RString 性別 = current.getUaft200().getSeibetsuCode();
            boolean needPageBreak = false;

            if (entity == null || (is抄本グループコード資格区分毎
                    && !NullHandler.getNullToRString(current.getAfT113SenkyoShikaku().getShikakuKubun())
                    .equals(NullHandler.getNullToRString(entity.getAfT113SenkyoShikaku().getShikakuKubun())))) {
                totalPage = 0;
                needPageBreak = true;
            }
            if (entity == null
                    || needPageBreak
                    || !NullHandler.getNullToRString(current.getAfT112SenkyoninMeibo().getTohyokuCode())
                    .equals(NullHandler.getNullToRString(entity.getAfT112SenkyoninMeibo().getTohyokuCode()))) {
                page = 0;
                needPageBreak = true;
            }

            for (int i = 0; i < 計List.size(); i++) {
                TotalParam 計 = 計List.get(i);
                if (isCount(param)) {
                    計.add(性別);
                }
                if (needPageBreak || is集計項目改ページ(計.get出力順(), entity)) {
                    needPageBreak = true;
                    set集計印字(計);
                    switch (i) {
                        case 集計4_INDEX:
                            param.set計4(計);
                            break;
                        case 集計3_INDEX:
                            param.set計3(計);
                            break;
                        case 集計2_INDEX:
                            param.set計2(計);
                            break;
                        case 集計1_INDEX:
                            param.set計1(計);
                            break;
                        default:

                    }
                    計List.set(i, new TotalParam(計));
                }
            }
            if (isCount(param)) {
                ページ計.add(性別);
            }
            if (needPageBreak || lineInPage > 最大印字行 || lineInPage > 帳票最大行) {
                param.setページ計(ページ計);
                ページ計 = new TotalParam(ページ計);
                lineInPage = 1;
                realPage++;
                page++;
                totalPage++;
            }
        }

        private Boolean isCount(MeinoShohonParam param) {
            Code 抹消事由コード = current.getAfT113SenkyoShikaku().getMasshoJiyuCode();
            if ((抹消事由コード == null || 抹消事由コード.isEmpty() || !JiyuCode.二重登録.getKey().equals(抹消事由コード.getColumnValue()))
                    && param.抹消線) {
                return false;
            }

            SenkyoninTohyoJokyoEntity entity = new SenkyoninTohyoJokyoEntity();
            entity.setAtenaPSMEntity(current.getUaft200());
            entity.setSenkyoShikakuEntity(current.getAfT113SenkyoShikaku());

            return !(shikakuHantei.is転出4ヶ月抹消予定者_日付指定(entity, parameter.getKijunbi())
                    || SennkyoSikakuKubun.公民権停止.value().equals(NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun())));

        }

        private boolean is集計項目改ページ(RString 集計キー, SenkyoninMeiboShohonEntity entity) {
            IShikibetsuTaisho next宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.getUaft200());
            IShikibetsuTaisho current宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.getUaft200());

            AfT112SenkyoninMeiboEntity nextAfT112 = entity.getAfT112SenkyoninMeibo();
            AfT112SenkyoninMeiboEntity currentAfT112 = current.getAfT112SenkyoninMeibo();

            RString nextVal = RString.EMPTY;
            RString currentVal = RString.EMPTY;

            if (集計キー_グループコード.equals(集計キー)) {
                nextVal = nextAfT112.getGroupCode();
                currentVal = currentAfT112.getGroupCode();
            } else if (集計キー_投票区コード.equals(集計キー)) {
                nextVal = nextAfT112.getTohyokuCode();
                currentVal = currentAfT112.getTohyokuCode();
            } else if (集計キー_住所コード.equals(集計キー)) {
                nextVal = next宛名.to個人().get住登内住所().get町域コード().value();
                currentVal = current宛名.to個人().get住登内住所().get町域コード().value();
            } else if (集計キー_行政区コード.equals(集計キー)) {
                nextVal = next宛名.get行政区画().getGyoseiku().getコード().value();
                currentVal = current宛名.get行政区画().getGyoseiku().getコード().value();
            } else if (集計キー_地区コード１.equals(集計キー)) {
                nextVal = next宛名.get行政区画().getChiku1().getコード().value();
                currentVal = current宛名.get行政区画().getChiku1().getコード().value();
            } else if (集計キー_地区コード２.equals(集計キー)) {
                nextVal = next宛名.get行政区画().getChiku2().getコード().value();
                currentVal = current宛名.get行政区画().getChiku2().getコード().value();
            } else if (集計キー_地区コード３.equals(集計キー)) {
                nextVal = next宛名.get行政区画().getChiku3().getコード().value();
                currentVal = current宛名.get行政区画().getChiku3().getコード().value();
            } else if (集計キー_冊.equals(集計キー)) {
                nextVal = nextAfT112.getSatsu();
                currentVal = nextAfT112.getSatsu();
            }
            return !nextVal.equals(currentVal);
        }

        private void set集計印字(TotalParam 集計) {

            RString 集計キー = 集計.get出力順();
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.getUaft200());

            AfT112SenkyoninMeiboEntity afT112 = current.getAfT112SenkyoninMeibo();

            RStringBuilder 集計印字Builder = new RStringBuilder();

            if (集計キー_グループコード.equals(集計キー)) {
                集計印字Builder.append(集計印字_グループコード);
            } else if (集計キー_投票区コード.equals(集計キー)) {
                集計印字Builder.append(集計印字_投票区コード__HEAD).append(afT112.getTohyokuCode()).append(集計印字_投票区コード__TAIL);
            } else if (集計キー_住所コード.equals(集計キー)) {
                集計印字Builder.append(集計印字_住所コード);
            } else if (集計キー_行政区コード.equals(集計キー)) {
                集計印字Builder.append(宛名.get行政区画().getGyoseiku().getコード().value()).append(集計印字_行政区コード__TAIL);
            } else if (集計キー_地区コード１.equals(集計キー)) {
                集計印字Builder.append(宛名.get行政区画().getChiku1().getコード().value()).append(集計印字_地区コード１__TAIL);
            } else if (集計キー_地区コード２.equals(集計キー)) {
                集計印字Builder.append(宛名.get行政区画().getChiku2().getコード().value()).append(集計印字_地区コード２__TAIL);
            } else if (集計キー_地区コード３.equals(集計キー)) {
                集計印字Builder.append(宛名.get行政区画().getChiku3().getコード().value()).append(集計印字_地区コード３__TAIL);
            } else if (集計キー_冊.equals(集計キー)) {
                集計印字Builder.append(集計印字_冊);
            }
            集計.set集計印字(集計印字Builder.toRString());
        }

    }

    /**
     * 登録者数リストのパラメータbuilderクラスです。
     *
     */
    public static class MeinoShohonParamKokuminBuilder extends MeinoShohonParamBuilder {

        /**
         * 登録者数リストのパラメータbuilderクラスです。
         *
         * @param parameter AFABTA101SelectProcessParameter
         * @param 出力順List List<RString>
         * @param 市町村名 RString
         */
        public MeinoShohonParamKokuminBuilder(AFABTA101SelectProcessParameter parameter,
                List<RString> 出力順List,
                RString 市町村名) {
            super(parameter, 出力順List, 市町村名);
        }

        @Override
        protected RString get受付1() {
            AfT113SenkyoShikakuEntity aft113 = super.current.getAfT113SenkyoShikaku();
            RString 受付1 = RString.EMPTY;
            Code 選挙資格区分 = aft113.getShikakuKubun();
            if (選挙資格区分 != null && SenkyoShikaku.抹消者.getコード().equals(選挙資格区分.value())) {
                受付1 = CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体,
                        AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(),
                        aft113.getMasshoJiyuCode(),
                        FlexibleDate.getNowDate());
            }
            return 受付1;
        }

        @Override
        protected List<RString> get表示() {
            return super.get表示2(new ArrayList<RString>());
        }

    }

}
