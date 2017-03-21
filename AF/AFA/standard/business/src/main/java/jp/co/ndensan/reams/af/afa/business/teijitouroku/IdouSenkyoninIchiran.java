/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.teijitouroku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.Seibetsu;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.憲法改正国民投票;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.有権者;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.有権者_1号資格;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.有権者_2号資格;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.表示者;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui.通常選挙;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 異動選挙人一覧クラス
 *
 */
public class IdouSenkyoninIchiran {

    private final RString 行政区 = new RString("12");
    private final RString 地区コード1 = new RString("13");
    private final RString 地区コード2 = new RString("14");
    private final RString 地区コード3 = new RString("15");
    private final RString コード = new RString("コード");

    private final RString 基準日str = new RString("（基準日:");
    private final RString 投票年月日str = new RString("　投票年月日:");
    private final RString migi = new RString(")");

    private static final RString 集計情報_表示内容_年齢到達 = new RString("年齢到達");
    private static final RString 集計情報_表示内容_転入3カ月経過 = new RString("転入3カ月経過");
    private static final RString 集計情報_表示内容_その他 = new RString("その他");
    private static final RString 集計情報_表示内容_1号資格者 = new RString("1号資格者");
    private static final RString 集計情報_表示内容_2号資格者 = new RString("2号資格者");
    private static final RString 集計情報_表示内容_死亡 = new RString("死亡");
    private static final RString 集計情報_表示内容_国籍喪失 = new RString("国籍喪失");
    private static final RString 集計情報_表示内容_転出4ヶ月 = new RString("転出4ヶ月");
    private static final RString 集計情報_表示内容_誤載 = new RString("誤載");
    private static final RString 集計情報_表示内容_職権消除 = new RString("職権消除");
    private static final RString 集計情報_表示内容_居住要件 = new RString("居住要件");
    private static final RString 集計情報_表示内容_居住要件抹消 = new RString("居住要件抹消");
    private static final RString 集計情報_表示内容_抹消予定者 = new RString("抹消予定者");
    private static final RString 集計情報_表示内容_4ヶ月経過 = new RString("4ヶ月経過");
    private static final RString 集計情報_表示内容_公民権停止 = new RString("公民権停止");
    private static final RString 集計情報_表示内容_失権 = new RString("失権");
    private static final RString 集計情報_表示内容_再転入 = new RString("再転入");
    private static final RString 集計情報_表示内容_転出者 = new RString("転出者");
    private static final RString 集計情報_表示内容_公民権停止者 = new RString("公民権停止者");
    private static final RString 集計情報_表示内容_表示消除 = new RString("表示消除");
    private static final RString 集計情報_表示内容_表示消除予定者 = new RString("表示消除予定者");
    private static final RString 集計情報_表示内容_規定年齢前 = new RString("規定年齢前");
    private static final RString 集計情報_表示内容_再転入者 = new RString("再転入者");
    private static final RString 集計情報_表示内容_職権消除者 = new RString("職権消除者");
    private static final RString 集計情報_表示内容_規定年齢未到達者 = new RString("規定年齢未到達者");
    private static final RString 集計情報_表示内容_帰化対象者 = new RString("帰化対象者");
    private static final RString 集計情報_表示内容_転居 = new RString("転居");
    private static final RString 集計情報_表示内容_訂正 = new RString("訂正");
    private static final RString 集計情報_表示内容_登録停止者 = new RString("登録停止者");

    /**
     * 集計情報取得
     *
     * @param 帳票ID RString
     * @param 事由コード RString
     * @param 異動選挙人一覧List List<SenkyoninTohyoJokyoEntity>
     * @return 集計情報 RString
     */
    public RString get集計情報(RString 帳票ID, RString 事由コード, List<SenkyoninTohyoJokyoEntity> 異動選挙人一覧List) {
        int femaleCnt = 0;
        int maleCnt = 0;
        TeijitourokuCommonEditor editor = new TeijitourokuCommonEditor();

        for (SenkyoninTohyoJokyoEntity 異動選挙人一覧 : 異動選挙人一覧List) {
            if (Seibetsu.男.code().equals(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).to個人().get性別().getCode())) {
                femaleCnt++;
            } else if (Seibetsu.女.code().equals(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).to個人().get性別().getCode())) {
                maleCnt++;
            }
        }
        Map<RString, RString> 集計情報Map = set集計情報Map();
        if (null == 集計情報Map.get(帳票ID.concat(事由コード))) {
            return new RString("**").concat("**［男 " + femaleCnt + "人］［女 " + maleCnt + "人］［計 " + (異動選挙人一覧List.size()) + "人］");
        } else {
            return new RString("**").concat(集計情報Map.get(帳票ID.concat(事由コード)))
                    .concat("**［男 " + femaleCnt + "人］［女 " + maleCnt + "人］［計 " + (異動選挙人一覧List.size()) + "人］");
        }
    }

    /**
     * 集計情報取得
     *
     * @param 帳票ID RString
     * @param 事由コード RString
     * @return 集計情報 SyukeiJyouhou
     */
    public SyukeiJyouhou get集計情報(RString 帳票ID, RString 事由コード) {

        return new SyukeiJyouhou(帳票ID, 事由コード);

    }

    /**
     * 集計情報
     */
    public static class SyukeiJyouhou {

        private Decimal femaleCnt;
        private Decimal maleCnt;
        private final RString 帳票ID;
        private final RString 事由コード;

        /**
         * コンストラクタです。
         *
         * @param 帳票ID RString
         * @param 事由コード RString
         */
        public SyukeiJyouhou(RString 帳票ID, RString 事由コード) {
            this.帳票ID = 帳票ID;
            this.事由コード = 事由コード;
            this.maleCnt = Decimal.ZERO;
            this.femaleCnt = Decimal.ZERO;
        }

        /**
         * データを追加します。
         *
         * @param kojin IKojin
         */
        public void add(IKojin kojin) {
            if (Seibetsu.男.code().equals(kojin.get性別().getCode())) {
                this.maleCnt = maleCnt.add(Decimal.ONE);
            } else if (Seibetsu.女.code().equals(kojin.get性別().getCode())) {
                this.femaleCnt = femaleCnt.add(Decimal.ONE);
            }
        }

        /**
         * 集計情報取得
         *
         * @return 集計情報 RString
         */
        public RString toRString() {
            Map<RString, RString> 集計情報Map = set集計情報Map();
            RStringBuilder builder = new RStringBuilder();
            builder.append("**");
            RString 集計情報 = 集計情報Map.get(帳票ID.concat(事由コード));
            if (集計情報 != null) {
                builder.append(集計情報);
            }

            builder.append("**［男 ");
            builder.append(editDecimal(maleCnt));
            builder.append("人］［女 ");
            builder.append(editDecimal(femaleCnt));
            builder.append("人］［計 ");
            builder.append(editDecimal(femaleCnt.add(maleCnt)));
            builder.append("人］");

            return builder.toRString();
        }

        /**
         * 集計情報取得
         *
         * @param 事由コード RString
         * @return 集計情報 RString
         */
        public RString toRString(RString 事由コード) {
            Map<RString, RString> 集計情報Map = set集計情報Map();
            RStringBuilder builder = new RStringBuilder();
            builder.append("**");
            RString 集計情報 = 集計情報Map.get(帳票ID.concat(事由コード));
            if (集計情報 != null) {
                builder.append(集計情報);
            }

            builder.append("**［男 ");
            builder.append(editDecimal(maleCnt));
            builder.append("人］［女 ");
            builder.append(editDecimal(femaleCnt));
            builder.append("人］［計 ");
            builder.append(editDecimal(femaleCnt.add(maleCnt)));
            builder.append("人］");

            return builder.toRString();
        }

        /**
         * 情報をリセットする。
         */
        public void resetCount() {
            this.maleCnt = Decimal.ZERO;
            this.femaleCnt = Decimal.ZERO;
        }

    }

    private static RString editDecimal(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    /**
     * 作成条件取得
     *
     * @param 帳票ID RString
     * @param 事由コード RString
     * @param 異動選挙人一覧 SenkyoninTohyoJokyoEntity
     * @return 作成条件 RString
     */
    public RString get作成条件(RString 帳票ID, RString 事由コード, SenkyoninTohyoJokyoEntity 異動選挙人一覧) {
        Map<RString, RString> 作成条件Map = set作成条件Map(
                (null == 異動選挙人一覧.getSenkyoJohoEntity().getSenkyoEntity() || 異動選挙人一覧.getSenkyoJohoEntity().getSenkyoEntity().isEmpty())
                ? FlexibleDate.MIN : 異動選挙人一覧.getSenkyoJohoEntity().getSenkyoEntity().get(0).getKijunYMD(),
                異動選挙人一覧.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui().value(),
                異動選挙人一覧.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD());
        if (作成条件Map.get(帳票ID.concat(事由コード)) == null) {
            return RString.EMPTY;
        } else {
            return 作成条件Map.get(帳票ID.concat(事由コード));
        }
    }

    /**
     * 生年月日取得
     *
     * @param 住民種別コード RString
     * @param 生年月日 FlexibleDate
     * @return 生年月日（変換後）RString
     */
    public RString get生年月日(RString 住民種別コード, FlexibleDate 生年月日) {
        if (JuminShubetsu.日本人.getCode().equals(住民種別コード)) {
            return 生年月日.wareki().toDateString();
        } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード)) {
            return 生年月日.seireki().toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * 文字列分割
     *
     * @param 文字列 RString
     * @param 最大文字数 int
     * @return 文字列1,文字列2 List<RString>
     */
    public List<RString> 文字列分割(RString 文字列, int 最大文字数) {
        List<RString> mojiLst = new ArrayList<>();

        if (最大文字数 >= 文字列.length()) {
            mojiLst.add(文字列);
            mojiLst.add(RString.EMPTY);
            return mojiLst;
        } else if (最大文字数 * 2 >= 文字列.length()) {
            mojiLst.add(文字列.substring(0, 最大文字数));
            mojiLst.add(文字列.substring(最大文字数));
            return mojiLst;
        } else {
            mojiLst.add(文字列.substring(0, 最大文字数));
            mojiLst.add(文字列.substring(最大文字数, 最大文字数 * 2));
            return mojiLst;
        }
    }

    /**
     * 選挙資格取得
     *
     * @param 選挙資格種類 RString
     * @param 選挙資格区分 RString
     * @return 選挙資格名称 RString
     */
    public RString get選挙資格(RString 選挙資格種類, RString 選挙資格区分) {
        if (通常選挙.value().equals(選挙資格種類)) {
            if (有権者.value().equals(選挙資格区分)) {
                return new RString("有り");
            } else if (表示者.value().equals(選挙資格区分)) {
                return new RString("表示");
            } else {
                return new RString("停止");
            }
        } else if (憲法改正国民投票.getCode().equals(選挙資格種類)) {
            if (有権者_1号資格.value().equals(選挙資格区分) || 有権者_2号資格.value().equals(選挙資格区分)) {
                return new RString("有り");
            } else {
                return new RString("停止");
            }
        }
        return RString.EMPTY;
    }

    /**
     * 訂正後情報設定
     *
     * @param 訂正前項目 Object
     * @param 訂正後項目 Object
     * @param 項目サイズ int
     * @return 比較後情報 Object
     */
    public RString set訂正後情報(RString 訂正前項目, RString 訂正後項目, int 項目サイズ) {

        RStringBuilder 比較後情報 = new RStringBuilder();
        if (null == 訂正前項目 && null == 訂正後項目
                || (null != 訂正後項目 && 訂正後項目.equals(訂正前項目))) {
            return RString.EMPTY;
        }
        if (null == 訂正後項目 || 訂正後項目.trim().isEmpty()) {
            return 比較後情報.toRString().padRight(new RString("-"), 項目サイズ);
        } else {
            return 訂正後項目;
        }
    }

    /**
     * 行政区・地区判定
     *
     * @param 異動選挙人一覧 SenkyoninTohyoJokyoEntity
     * @return タイトル1,内容1,タイトル2,内容2 List<RString>
     */
    public List<RString> is行政区_地区(SenkyoninTohyoJokyoEntity 異動選挙人一覧) {
        List<RString> retList = new ArrayList<>();
        RString 行政区地区判定区分 = BusinessConfig.get(ConfigKeysAFA.異動選挙人一覧_行政区地区判定区分, SubGyomuCode.AFA選挙本体);
        TeijitourokuCommonEditor editor = new TeijitourokuCommonEditor();

        if (地区コード1.equals(行政区地区判定区分)) {
            RString コード名称_地区の分類１ = getConfigValue(ConfigKeysCodeName.コード名称_地区の分類１);
            retList.add(コード名称_地区の分類１.concat(コード));
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getChiku1().getコード().value());
            retList.add(コード名称_地区の分類１);
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getChiku1().get名称());
        } else if (地区コード2.equals(行政区地区判定区分)) {
            RString コード名称_地区の分類２ = getConfigValue(ConfigKeysCodeName.コード名称_地区の分類２);
            retList.add(コード名称_地区の分類２.concat(コード));
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getChiku2().getコード().value());
            retList.add(コード名称_地区の分類２);
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getChiku2().get名称());
        } else if (地区コード3.equals(行政区地区判定区分)) {
            RString コード名称_地区の分類３ = getConfigValue(ConfigKeysCodeName.コード名称_地区の分類３);
            retList.add(コード名称_地区の分類３.concat(コード));
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getChiku3().getコード().value());
            retList.add(コード名称_地区の分類３);
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getChiku3().get名称());
        } else if (行政区.equals(行政区地区判定区分)) {
            retList.add(new RString("行政区コード"));
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getGyoseiku().getコード().value());
            retList.add(new RString("行政区"));
            retList.add(editor.toShikibetsuTaisho(異動選挙人一覧.getAtenaPSMEntity()).get行政区画().getGyoseiku().get名称());
        }

        return retList;
    }

    private RString getConfigValue(ConfigKeysCodeName key) {
        RString value = BusinessConfig.get(key, SubGyomuCode.URZ業務共通_共通系);
        return null == value ? RString.EMPTY : value;
    }

    private static Map<RString, RString> set集計情報Map() {
        Map<RString, RString> map = new HashMap<>();
        map.put(ReportIdKeys.新規登録者名簿.value().concat(JiyuCode.年齢到達.getKey()), 集計情報_表示内容_年齢到達);
        map.put(ReportIdKeys.新規登録者名簿.value().concat(JiyuCode.転入3カ月経過.getKey()), 集計情報_表示内容_転入3カ月経過);
        map.put(ReportIdKeys.新規登録者名簿.value().concat(JiyuCode.その他_登録.getKey()), 集計情報_表示内容_その他);
        map.put(ReportIdKeys.新規登録者名簿海区.value().concat(JiyuCode.年齢到達.getKey()), 集計情報_表示内容_年齢到達);
        map.put(ReportIdKeys.新規登録者名簿海区.value().concat(JiyuCode.転入3カ月経過.getKey()), 集計情報_表示内容_転入3カ月経過);
        map.put(ReportIdKeys.新規登録者名簿海区.value().concat(JiyuCode.その他_登録.getKey()), 集計情報_表示内容_その他);

        map.put(ReportIdKeys.新規登録者名簿国民.value().concat(JiyuCode.年齢到達.getKey()), 集計情報_表示内容_1号資格者);
        map.put(ReportIdKeys.新規登録者名簿国民.value().concat(JiyuCode.転入3カ月経過.getKey()), 集計情報_表示内容_2号資格者);
        map.put(ReportIdKeys.新規登録者名簿国民.value().concat(JiyuCode.その他_登録.getKey()), 集計情報_表示内容_その他);

        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.死亡.getKey()), 集計情報_表示内容_死亡);
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.国籍喪失.getKey()), 集計情報_表示内容_国籍喪失);
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.転出4カ月.getKey()), 集計情報_表示内容_転出4ヶ月);
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.誤載.getKey()), 集計情報_表示内容_誤載);
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.職権消除.getKey()), 集計情報_表示内容_職権消除);
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.居住要件.getKey()), 集計情報_表示内容_居住要件);
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.その他_抹消.getKey()), 集計情報_表示内容_その他);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.死亡.getKey()), 集計情報_表示内容_死亡);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.国籍喪失.getKey()), 集計情報_表示内容_国籍喪失);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.転出4カ月.getKey()), 集計情報_表示内容_転出4ヶ月);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.誤載.getKey()), 集計情報_表示内容_誤載);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.職権消除.getKey()), 集計情報_表示内容_職権消除);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.居住要件.getKey()), 集計情報_表示内容_居住要件);
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.その他_抹消.getKey()), 集計情報_表示内容_その他);

        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.死亡.getKey()), 集計情報_表示内容_死亡);
        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.国籍喪失.getKey()), 集計情報_表示内容_国籍喪失);
        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.誤載.getKey()), 集計情報_表示内容_誤載);
        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.その他_抹消.getKey()), 集計情報_表示内容_その他);

        map.put(ReportIdKeys.居住要件抹消者名簿.value(), 集計情報_表示内容_居住要件抹消);
        map.put(ReportIdKeys.抹消予定者名簿.value(), 集計情報_表示内容_抹消予定者);

        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode._4ヶ月経過.getKey()), 集計情報_表示内容_4ヶ月経過);
        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode.公民権停止.getKey()), 集計情報_表示内容_公民権停止);
        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode.失権.getKey()), 集計情報_表示内容_失権);
        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode.再転入_失権.getKey()), 集計情報_表示内容_再転入);
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode._4ヶ月経過.getKey()), 集計情報_表示内容_4ヶ月経過);
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode.公民権停止.getKey()), 集計情報_表示内容_公民権停止);
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode.失権.getKey()), 集計情報_表示内容_失権);
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode.再転入_失権.getKey()), 集計情報_表示内容_再転入);

        map.put(ReportIdKeys.表示者名簿.value().concat(JiyuCode.再転入_表示.getKey()), 集計情報_表示内容_再転入);
        map.put(ReportIdKeys.表示者名簿.value().concat(JiyuCode.転出者.getKey()), 集計情報_表示内容_転出者);
        map.put(ReportIdKeys.表示者名簿.value().concat(JiyuCode.公民権停止者.getKey()), 集計情報_表示内容_公民権停止者);
        map.put(ReportIdKeys.表示者名簿海区.value().concat(JiyuCode.再転入_表示.getKey()), 集計情報_表示内容_再転入);
        map.put(ReportIdKeys.表示者名簿海区.value().concat(JiyuCode.転出者.getKey()), 集計情報_表示内容_転出者);
        map.put(ReportIdKeys.表示者名簿海区.value().concat(JiyuCode.公民権停止者.getKey()), 集計情報_表示内容_公民権停止者);

        map.put(ReportIdKeys.表示消除者名簿.value(), 集計情報_表示内容_表示消除);
        map.put(ReportIdKeys.表示消除予定者名簿.value(), 集計情報_表示内容_表示消除予定者);
        map.put(ReportIdKeys.規定年齢前名簿.value(), 集計情報_表示内容_規定年齢前);
        map.put(ReportIdKeys.再転入者名簿.value(), 集計情報_表示内容_再転入者);
        map.put(ReportIdKeys.転出者名簿.value(), 集計情報_表示内容_転出者);
        map.put(ReportIdKeys.職権消除者名簿.value(), 集計情報_表示内容_職権消除者);
        map.put(ReportIdKeys.規定年齢未到達者名簿.value(), 集計情報_表示内容_規定年齢未到達者);

        map.put(ReportIdKeys.新規登録者名簿縦覧.value().concat(JiyuCode.年齢到達.getKey()), 集計情報_表示内容_年齢到達);
        map.put(ReportIdKeys.新規登録者名簿縦覧.value().concat(JiyuCode.転入3カ月経過.getKey()), 集計情報_表示内容_転入3カ月経過);
        map.put(ReportIdKeys.新規登録者名簿縦覧.value().concat(JiyuCode.その他_登録.getKey()), 集計情報_表示内容_その他);

        map.put(ReportIdKeys.新規登録者名簿縦覧国民.value().concat(JiyuCode.年齢到達.getKey()), 集計情報_表示内容_1号資格者);
        map.put(ReportIdKeys.新規登録者名簿縦覧国民.value().concat(JiyuCode.転入3カ月経過.getKey()), 集計情報_表示内容_2号資格者);
        map.put(ReportIdKeys.新規登録者名簿縦覧国民.value().concat(JiyuCode.その他_登録.getKey()), 集計情報_表示内容_その他);

        map.put(ReportIdKeys.抹消者名簿縦覧.value(), 集計情報_表示内容_誤載);
        map.put(ReportIdKeys.抹消者名簿縦覧国民.value(), 集計情報_表示内容_誤載);
        map.put(ReportIdKeys.帰化対象者リスト.value(), 集計情報_表示内容_帰化対象者);

        map.put(ReportIdKeys.訂正者名簿.value().concat(JiyuCode.転居.getKey()), 集計情報_表示内容_転居);
        map.put(ReportIdKeys.訂正者名簿.value().concat(JiyuCode.訂正.getKey()), 集計情報_表示内容_訂正);
        map.put(ReportIdKeys.訂正者名簿国民.value().concat(JiyuCode.転居.getKey()), 集計情報_表示内容_転居);
        map.put(ReportIdKeys.訂正者名簿国民.value().concat(JiyuCode.訂正.getKey()), 集計情報_表示内容_訂正);
        map.put(ReportIdKeys.訂正者名簿海区.value().concat(JiyuCode.転居.getKey()), 集計情報_表示内容_転居);
        map.put(ReportIdKeys.訂正者名簿海区.value().concat(JiyuCode.訂正.getKey()), 集計情報_表示内容_訂正);

        map.put(ReportIdKeys.登録停止者名簿.value(), 集計情報_表示内容_登録停止者);
        return map;
    }

    private Map<RString, RString> set作成条件Map(FlexibleDate 基準日, RString 選挙種類, FlexibleDate 投票年月日) {
        Map<RString, RString> map = new HashMap<>();

        map.put(ReportIdKeys.新規登録者名簿.value().concat(JiyuCode.年齢到達.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿.value().concat(JiyuCode.転入3カ月経過.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿.value().concat(JiyuCode.その他_登録.getKey()), set作成条件_投票年月日(基準日, 投票年月日));
        map.put(ReportIdKeys.新規登録者名簿海区.value().concat(JiyuCode.年齢到達.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿海区.value().concat(JiyuCode.転入3カ月経過.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿海区.value().concat(JiyuCode.その他_登録.getKey()), set作成条件_投票年月日(基準日, 投票年月日));
        map.put(ReportIdKeys.新規登録者名簿国民.value().concat(JiyuCode.年齢到達.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿国民.value().concat(JiyuCode.転入3カ月経過.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿国民.value().concat(JiyuCode.その他_登録.getKey()), set作成条件_投票年月日(基準日, 投票年月日));

        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.死亡.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.国籍喪失.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.転出4カ月.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.誤載.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.職権消除.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.居住要件.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿.value().concat(JiyuCode.その他_抹消.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.死亡.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.国籍喪失.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.転出4カ月.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.誤載.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.職権消除.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.居住要件.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿海区.value().concat(JiyuCode.その他_抹消.getKey()), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.死亡.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.国籍喪失.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.誤載.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.抹消者名簿国民.value().concat(JiyuCode.その他_抹消.getKey()), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.居住要件抹消者名簿.value(), RString.EMPTY);
        map.put(ReportIdKeys.抹消予定者名簿.value(), set作成条件_投票年月日(基準日, 投票年月日));

        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode._4ヶ月経過.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode.公民権停止.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode.失権.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿.value().concat(JiyuCode.再転入_失権.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode._4ヶ月経過.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode.公民権停止.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode.失権.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.失権者名簿海区.value().concat(JiyuCode.再転入_失権.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));

        map.put(ReportIdKeys.表示者名簿.value().concat(JiyuCode.再転入_表示.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.表示者名簿.value().concat(JiyuCode.転出者.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.表示者名簿.value().concat(JiyuCode.公民権停止者.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.表示者名簿海区.value().concat(JiyuCode.再転入_表示.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.表示者名簿海区.value().concat(JiyuCode.転出者.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.表示者名簿海区.value().concat(JiyuCode.公民権停止者.getKey()), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));

        map.put(ReportIdKeys.表示消除者名簿.value(), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.表示消除予定者名簿.value(), set作成条件_基準日と投票年月日(選挙種類, 基準日, 投票年月日));
        map.put(ReportIdKeys.規定年齢前名簿.value(), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.再転入者名簿.value(), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.転出者名簿.value(), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.職権消除者名簿.value(), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.規定年齢未到達者名簿.value(), set作成条件_投票年月日(基準日, 投票年月日));

        map.put(ReportIdKeys.新規登録者名簿縦覧.value().concat(JiyuCode.年齢到達.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿縦覧.value().concat(JiyuCode.転入3カ月経過.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿縦覧.value().concat(JiyuCode.その他_登録.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿縦覧国民.value().concat(JiyuCode.年齢到達.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿縦覧国民.value().concat(JiyuCode.転入3カ月経過.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.新規登録者名簿縦覧国民.value().concat(JiyuCode.その他_登録.getKey()), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.抹消者名簿縦覧.value(), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.抹消者名簿縦覧国民.value(), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.帰化対象者リスト.value(), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.訂正者名簿.value().concat(JiyuCode.転居.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.訂正者名簿.value().concat(JiyuCode.訂正.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.訂正者名簿国民.value().concat(JiyuCode.転居.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.訂正者名簿国民.value().concat(JiyuCode.訂正.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.訂正者名簿海区.value().concat(JiyuCode.転居.getKey()), set作成条件_選挙種類(選挙種類, 基準日));
        map.put(ReportIdKeys.訂正者名簿海区.value().concat(JiyuCode.訂正.getKey()), set作成条件_選挙種類(選挙種類, 基準日));

        map.put(ReportIdKeys.登録停止者名簿.value(), RString.EMPTY);
        return map;
    }

    private RString set作成条件_選挙種類(RString 選挙種類, FlexibleDate 基準日) {
        return (選挙種類 == null ? RString.EMPTY : get選挙種類(選挙種類)).concat(基準日str)
                .concat((基準日 == null ? FlexibleDate.EMPTY : 基準日).wareki().toDateString()).concat(migi);
    }

    private RString set作成条件_投票年月日(FlexibleDate 基準日, FlexibleDate 投票年月日) {
        return 基準日str.concat((基準日 == null ? FlexibleDate.EMPTY : 基準日).wareki().toDateString())
                .concat(投票年月日str).concat((投票年月日 == null ? FlexibleDate.EMPTY : 投票年月日).wareki().toDateString()).concat(migi);
    }

    private RString set作成条件_基準日と投票年月日(RString 選挙種類, FlexibleDate 基準日, FlexibleDate 投票年月日) {
        return (選挙種類 == null ? RString.EMPTY : get選挙種類(選挙種類)).concat(基準日str).concat(
                (基準日 == null ? FlexibleDate.EMPTY : 基準日).wareki().toDateString()).concat(RString.FULL_SPACE)
                .concat(投票年月日str).concat((投票年月日 == null ? FlexibleDate.EMPTY : 投票年月日).wareki().toDateString()).concat(migi);
    }

    private RString get選挙種類(RString 選挙種類) {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), new Code(選挙種類));
    }
}
