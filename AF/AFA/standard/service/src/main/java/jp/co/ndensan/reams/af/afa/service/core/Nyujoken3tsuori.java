/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAChohyoId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.Seibetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT502TohyojoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT504TohyokuRelationDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 投票所入場券
 *
 *
 * @reamsid_L AF-0160-025 guyq
 */
public class Nyujoken3tsuori {

    private static final int 二倍 = 2;
    private static final int 三倍 = 3;
    private static final int 四倍 = 4;
    private static final int 五倍 = 5;
    private static final int 桁数_投票区コード = 4;
    private static final int 桁数_頁 = 6;
    private static final int 桁数_行 = 2;
    private static final int 桁数_識別コード = 15;
    private static final int 桁数_抄本番号 = 4;
    private static final int インデックス_送付先行政区名1 = 0;
    private static final int インデックス_送付先行政区名2 = 1;
    private static final int インデックス_送付先行政区名3 = 2;
    private static final int インデックス_送付先住所1 = 0;
    private static final int インデックス_送付先住所2 = 1;
    private static final int インデックス_送付先住所3 = 2;
    private static final int インデックス_送付先住所4 = 3;
    private static final int インデックス_送付先住所5 = 4;
    private static final int インデックス_宛名1 = 0;
    private static final int インデックス_宛名2 = 1;
    private static final int インデックス_宛名3 = 2;
    private static final int インデックス_住所1 = 0;
    private static final int インデックス_住所2 = 1;
    private static final int インデックス_住所3 = 2;
    private static final int インデックス_住所4 = 3;
    private static final int インデックス_住所5 = 4;
    private static final int インデックス_氏名1 = 0;
    private static final int インデックス_氏名2 = 1;
    private static final int インデックス_氏名3 = 2;
    private static final int インデックス_カナ名称1 = 0;
    private static final int インデックス_カナ名称2 = 1;
    private static final int インデックス_投票所名1 = 0;
    private static final int インデックス_投票所名2 = 1;
    private static final int インデックス_投票所名3 = 2;
    private static final int インデックス_名称1 = 0;
    private static final int インデックス_名称2 = 1;
    private static final int インデックス_名称3 = 2;
    private static final RString 住民種別_日本人 = new RString("1");
    private static final RString 住民種別_外国人 = new RString("2");
    private static final RString 空白 = new RString(" ");
    private static final RString 全角スペース = new RString("　");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString 様 = new RString("　様");
    private static final RString 殿 = new RString("　殿");
    private static final RString 横線 = new RString("-");
    private static final RString 国民投票入場券発行 = new RString("AFMNG");
    private static final RString 海区選挙入場券発行 = new RString("AFMNK");
    private static final RString 続柄コードの先頭2桁_01 = new RString("01");
    private static final RString 星印 = new RString("*");
    private static final RString 種類_入場券 = new RString("1");
    private static final RString 種類_転出者お知らせはがき = new RString("2");
    private static final RString ゼロ = new RString("0");

    private final AfT504TohyokuRelationDac afT504TohyokuRelationDac;
    private final AfT502TohyojoDac afT502TohyojoDac;
    private static final Map<String, RString> businessConfigMap = new HashMap();
    private static final Map<YubinNo, RString> barCodeMap = new HashMap();

    static {
        businessConfigMap.put(ConfigKeysAFA.入場券_送付先住所編集.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_送付先住所編集, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_宛名敬称.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_宛名敬称, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_投票区コード編集方法.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_投票区コード編集方法, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_地図印字.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_明細部住所編集.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_明細部住所編集, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_性別印字文字_男.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_性別印字文字_男, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.転出者はがき_性別印字文字_男.toString(),
                BusinessConfig.get(ConfigKeysAFA.転出者はがき_性別印字文字_男, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_性別印字文字_女.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_性別印字文字_女, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.転出者はがき_性別印字文字_女.toString(),
                BusinessConfig.get(ConfigKeysAFA.転出者はがき_性別印字文字_女, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_宛名敬称.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_宛名敬称, SubGyomuCode.AFA選挙本体));
        businessConfigMap.put(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString(),
                BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ項目出力区分, SubGyomuCode.AFA選挙本体));
    } 


    /**
     * コンストラクタです。
     */
    public Nyujoken3tsuori() {
        afT504TohyokuRelationDac = InstanceProvider.create(AfT504TohyokuRelationDac.class);
        afT502TohyojoDac = InstanceProvider.create(AfT502TohyojoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link Nyujoken3tsuori}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link Nyujoken3tsuori}のインスタンス
     */
    public static Nyujoken3tsuori createInstance() {
        return InstanceProvider.create(Nyujoken3tsuori.class);
    }

    /**
     * カスタマーバーコード取得
     *
     * @param 郵便番号 YubinNo
     * @param 住所 AtenaJusho
     * @param 番地 AtenaBanchi
     * @param 方書 Katagaki
     * @return RString カスタマーバーコード
     */
    public RString getCustomBarCode(YubinNo 郵便番号, AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString 住所_変換後 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 番地_変換後 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        RString 方書_変換後 = null == 方書 || 方書.isEmpty() ? RString.EMPTY : changeNullToEmpty(方書.value());
        RString 編集用住所 = 住所_変換後.concat(番地_変換後).replace(空白, RString.EMPTY).concat(全角スペース).concat(方書_変換後);
        if (barCodeMap.containsKey(郵便番号)) {
            return barCodeMap.get(郵便番号);
        } else {
            CustomerBarCode barcode = new CustomerBarCode();
            CustomerBarCodeResult result
                    = barcode.convertCustomerBarCode(郵便番号 == null ? RString.EMPTY : 郵便番号.getYubinNo(), 編集用住所);
            barCodeMap.put(郵便番号, result.getCustomerBarCode());
            return result.getCustomerBarCode();
        }
    }

    /**
     * 送付先行政区名取得
     *
     * @param 送付先行政区名 RString
     * @param 行政区名1印字可能文字数 int
     * @param 行政区名2印字可能文字数 int
     * @param 行政区名3印字可能文字数 int
     * @return 送付先行政区名リスト
     */
    public List<RString> getSofusakiGyoseikuName(RString 送付先行政区名,
            int 行政区名1印字可能文字数, int 行政区名2印字可能文字数, int 行政区名3印字可能文字数) {
        List<RString> 送付先行政区名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_送付先行政区名3; i++) {
            送付先行政区名リスト.add(RString.EMPTY);
        }
        送付先行政区名 = changeNullToEmpty(送付先行政区名);
        if (送付先行政区名.length() <= 行政区名1印字可能文字数) {
            送付先行政区名リスト.set(インデックス_送付先行政区名1, 送付先行政区名);
        } else if (送付先行政区名.length() > 行政区名1印字可能文字数) {
            送付先行政区名リスト.set(インデックス_送付先行政区名2, 送付先行政区名.substring(0, 行政区名2印字可能文字数));
            if (行政区名2印字可能文字数 + 行政区名3印字可能文字数 < 送付先行政区名.length()) {
                送付先行政区名リスト.set(インデックス_送付先行政区名3, 送付先行政区名.substring(行政区名2印字可能文字数, 行政区名2印字可能文字数 + 行政区名3印字可能文字数));
            } else {
                送付先行政区名リスト.set(インデックス_送付先行政区名3, 送付先行政区名.substring(行政区名2印字可能文字数));
            }
        }
        return 送付先行政区名リスト;
    }

    /**
     * 生年月日取得
     *
     * @param 住民種別コード RString
     * @param 生年月日 RDate
     * @return 生年月日（変換後）
     */
    public RString getSeinengappi(RString 住民種別コード, RDate 生年月日) {
        RString 生年月日_変換後 = RString.EMPTY;
        if (null == 生年月日) {
            return RString.EMPTY;
        }
        if (住民種別_日本人.equals(住民種別コード)) {
            生年月日_変換後 = 生年月日.wareki().toDateString();
        }
        if (住民種別_外国人.equals(住民種別コード)) {
            生年月日_変換後 = 生年月日.seireki().toDateString();
        }
        return 生年月日_変換後;
    }

    /**
     * 送付先住所取得
     *
     * @param 住所 AtenaJusho
     * @param 番地 AtenaBanchi
     * @param 方書 Katagaki
     * @param 行政区名 RString
     * @param 印字可能文字数 int
     * @return 送送付先住所リスト
     */
    public List<RString> getSofusakiJushoCode(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書, RString 行政区名, int 印字可能文字数) {
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        RString 方書文字列 = null == 方書 || 方書.isEmpty() ? RString.EMPTY : changeNullToEmpty(方書.value());
        行政区名 = changeNullToEmpty(行政区名);
        住所文字列 = 住所文字列.replace(空白, RString.EMPTY);
        住所文字列 = 住所文字列.replace(全角スペース, RString.EMPTY);
        番地文字列 = 番地文字列.replace(空白, RString.EMPTY);
        番地文字列 = 番地文字列.replace(全角スペース, RString.EMPTY);
        行政区名 = 行政区名.replace(空白, RString.EMPTY);
        行政区名 = 行政区名.replace(全角スペース, RString.EMPTY);
        RString 入場券_送付先住所編集 = businessConfigMap.get(ConfigKeysAFA.入場券_送付先住所編集.toString());
        RString 編集用送付先住所 = RString.EMPTY;
        if (AFAConfigKeysValue.入場券_送付先住所編集_住所番地方書.configKeyValue().equals(入場券_送付先住所編集)) {
            編集用送付先住所 = 住所文字列.concat(番地文字列).concat(全角スペース).concat(方書文字列);
        }
        if (AFAConfigKeysValue.入場券_送付先住所編集_行政区番地方書.configKeyValue().equals(入場券_送付先住所編集)) {
            編集用送付先住所 = 行政区名.concat(番地文字列).concat(全角スペース).concat(方書文字列);
        }
        if (AFAConfigKeysValue.入場券_送付先住所編集_住所行政区番地方書.configKeyValue().equals(入場券_送付先住所編集)) {
            編集用送付先住所 = 住所文字列.concat(左括弧).concat(行政区名).concat(右括弧).concat(番地文字列)
                    .concat(全角スペース).concat(方書文字列);
        }
        List<RString> 送送付先住所リスト = new ArrayList();
        for (int i = 0; i <= インデックス_送付先住所5; i++) {
            送送付先住所リスト.add(RString.EMPTY);
        }
        if (編集用送付先住所.length() <= 印字可能文字数) {
            送送付先住所リスト.set(インデックス_送付先住所1, 編集用送付先住所);
        } else if (編集用送付先住所.length() <= 印字可能文字数 * 二倍) {
            送送付先住所リスト.set(インデックス_送付先住所1, 編集用送付先住所.substring(0, 印字可能文字数));
            送送付先住所リスト.set(インデックス_送付先住所2, 編集用送付先住所.substring(印字可能文字数));
        } else if (編集用送付先住所.length() <= 印字可能文字数 * 三倍) {
            送送付先住所リスト.set(インデックス_送付先住所1, 編集用送付先住所.substring(0, 印字可能文字数));
            送送付先住所リスト.set(インデックス_送付先住所2, 編集用送付先住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
            送送付先住所リスト.set(インデックス_送付先住所3, 編集用送付先住所.substring(印字可能文字数 * 二倍));
        } else if (編集用送付先住所.length() <= 印字可能文字数 * 四倍) {
            送送付先住所リスト.set(インデックス_送付先住所1, 編集用送付先住所.substring(0, 印字可能文字数));
            送送付先住所リスト.set(インデックス_送付先住所2, 編集用送付先住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
            送送付先住所リスト.set(インデックス_送付先住所3, 編集用送付先住所.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
            送送付先住所リスト.set(インデックス_送付先住所4, 編集用送付先住所.substring(印字可能文字数 * 三倍));
        } else if (編集用送付先住所.length() <= 印字可能文字数 * 五倍) {
            送送付先住所リスト.set(インデックス_送付先住所1, 編集用送付先住所.substring(0, 印字可能文字数));
            送送付先住所リスト.set(インデックス_送付先住所2, 編集用送付先住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
            送送付先住所リスト.set(インデックス_送付先住所3, 編集用送付先住所.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
            送送付先住所リスト.set(インデックス_送付先住所4, 編集用送付先住所.substring(印字可能文字数 * 三倍, 印字可能文字数 * 四倍));
            送送付先住所リスト.set(インデックス_送付先住所5, 編集用送付先住所.substring(印字可能文字数 * 四倍));
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                送送付先住所リスト.set(インデックス_送付先住所1, RString.EMPTY);
                送送付先住所リスト.set(インデックス_送付先住所2, RString.EMPTY);
                送送付先住所リスト.set(インデックス_送付先住所3, RString.EMPTY);
                送送付先住所リスト.set(インデックス_送付先住所4, RString.EMPTY);
                送送付先住所リスト.set(インデックス_送付先住所5, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                送送付先住所リスト.set(インデックス_送付先住所1, 編集用送付先住所.substring(0, 印字可能文字数));
                送送付先住所リスト.set(インデックス_送付先住所2, 編集用送付先住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
                送送付先住所リスト.set(インデックス_送付先住所3, 編集用送付先住所.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
                送送付先住所リスト.set(インデックス_送付先住所4, 編集用送付先住所.substring(印字可能文字数 * 三倍, 印字可能文字数 * 四倍));
                送送付先住所リスト.set(インデックス_送付先住所5, 編集用送付先住所.substring(印字可能文字数 * 四倍, 印字可能文字数 * 五倍));
            }
        }
        return 送送付先住所リスト;
    }

    /**
     * 宛名取得
     *
     * @param 宛名 RString
     * @param 印字可能文字数 int
     * @return 宛名リスト
     */
    public List<RString> getAtena(RString 宛名, int 印字可能文字数) {
        List<RString> 宛名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_宛名3; i++) {
            宛名リスト.add(RString.EMPTY);
        }
        RString 宛名敬称付加 = RString.EMPTY;
        RString 入場券_宛名敬称 = businessConfigMap.get(ConfigKeysAFA.入場券_宛名敬称.toString());
        if (AFAConfigKeysValue.入場券_宛名敬称_印字しない.configKeyValue().equals(入場券_宛名敬称)) {
            宛名敬称付加 = changeNullToEmpty(宛名);
        }
        if (AFAConfigKeysValue.入場券_宛名敬称_様を印字する.configKeyValue().equals(入場券_宛名敬称)) {
            宛名敬称付加 = changeNullToEmpty(宛名).concat(様);
        }
        if (AFAConfigKeysValue.入場券_宛名敬称_殿を印字する.configKeyValue().equals(入場券_宛名敬称)) {
            宛名敬称付加 = changeNullToEmpty(宛名).concat(殿);
        }
        if (宛名敬称付加.length() <= 印字可能文字数) {
            宛名リスト.set(インデックス_宛名3, 宛名敬称付加);
        } else if (宛名敬称付加.length() <= 印字可能文字数 * 二倍) {
            宛名リスト.set(インデックス_宛名2, 宛名敬称付加.substring(0, 印字可能文字数));
            宛名リスト.set(インデックス_宛名3, 宛名敬称付加.substring(印字可能文字数));
        } else if (宛名敬称付加.length() <= 印字可能文字数 * 三倍) {
            宛名リスト.set(インデックス_宛名1, 宛名敬称付加.substring(0, 印字可能文字数));
            宛名リスト.set(インデックス_宛名2, 宛名敬称付加.substring(印字可能文字数, 印字可能文字数 * 二倍));
            宛名リスト.set(インデックス_宛名3, 宛名敬称付加.substring(印字可能文字数 * 二倍));
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                宛名リスト.set(インデックス_宛名1, RString.EMPTY);
                宛名リスト.set(インデックス_宛名2, RString.EMPTY);
                宛名リスト.set(インデックス_宛名3, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                宛名リスト.set(インデックス_宛名1, 宛名敬称付加.substring(0, 印字可能文字数));
                宛名リスト.set(インデックス_宛名2, 宛名敬称付加.substring(印字可能文字数, 印字可能文字数 * 二倍));
                宛名リスト.set(インデックス_宛名3, 宛名敬称付加.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
            }
        }
        return 宛名リスト;
    }

    /**
     * 世帯主名取得
     *
     * @param 世帯主名 RString
     * @param 印字可能文字数 int
     * @return 世帯主名表示文字
     */
    public RString getSetainushiMei(RString 世帯主名, int 印字可能文字数) {
        RString 世帯主名表示文字 = RString.EMPTY;
        世帯主名 = changeNullToEmpty(世帯主名);
        if (世帯主名.length() <= 印字可能文字数) {
            世帯主名表示文字 = 世帯主名;
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                世帯主名表示文字 = RString.EMPTY;
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                世帯主名表示文字 = 世帯主名.substring(0, 印字可能文字数);
            }
        }
        return 世帯主名表示文字;
    }

    /**
     * 投票区コード取得
     *
     * @param 投票区コード RString
     * @return 投票区コード
     */
    public RString getTohyokuCode(RString 投票区コード) {
        投票区コード = changeNullToEmpty(投票区コード);
        RString 投票区コード_変換後 = RString.EMPTY;
        RString 入場券_投票区コード編集方法 = businessConfigMap.get(ConfigKeysAFA.入場券_投票区コード編集方法.toString());
        if (AFAConfigKeysValue.入場券_投票区コード編集方法_編集なし.configKeyValue().equals(入場券_投票区コード編集方法)) {
            投票区コード_変換後 = 投票区コード;
        } else if (AFAConfigKeysValue.入場券_投票区コード編集方法_頭0なし.configKeyValue().equals(入場券_投票区コード編集方法)) {
            if (RString.isNullOrEmpty(投票区コード)) {
                投票区コード_変換後 = RString.EMPTY.padLeft(空白, 桁数_投票区コード);
            } else {
                投票区コード_変換後 = new RString(Integer.valueOf(投票区コード.trim().toString()).toString())
                        .padLeft(空白, 桁数_投票区コード);
            }
        }
        return 投票区コード_変換後;
    }

    /**
     * 名簿番号取得
     *
     * @param 投票区コード RString
     * @param 頁 int
     * @param 行 int
     * @return 名簿番号
     */
    public RString getMeiboNo(RString 投票区コード, int 頁, int 行) {
        投票区コード = changeNullToEmpty(投票区コード);
        RString 名簿番号 = 投票区コード.concat(横線).concat(new RString(String.valueOf(頁)).padLeft(空白, 桁数_頁))
                .concat(横線).concat(new RString(String.valueOf(行)).padLeft(空白, 桁数_行));
        return 名簿番号;
    }

    /**
     * 地図情報取得
     *
     * @param 投票区コード RString
     * @return 地図情報
     */
    public RString getMapJoho(RString 投票区コード) {
        RString 入場券_地図印字 = businessConfigMap.get(ConfigKeysAFA.入場券_地図印字.toString());
        if (AFAConfigKeysValue.入場券_地図印字_印字しない.configKeyValue().equals(入場券_地図印字)) {
            return RString.EMPTY;
        }
        RString 地図ファイル名 = RString.EMPTY;
        if (AFAConfigKeysValue.入場券_地図印字_印字する.configKeyValue().equals(入場券_地図印字)) {
            RString 選挙種類 = SenkyoShurui.国政選挙_地方選挙.getCode();
            RString メニューID = ResponseHolder.getMenuID();
            if (メニューID.startsWith(国民投票入場券発行)) {
                選挙種類 = SenkyoShurui.憲法改正国民投票.getCode();
            }
            if (メニューID.startsWith(海区選挙入場券発行)) {
                選挙種類 = SenkyoShurui.海区漁業調整委員会委員選挙.getCode();
            }
            AfT504TohyokuRelationEntity 投票区投票所対応
                    = afT504TohyokuRelationDac.select(new Code(選挙種類), 投票区コード == null ? RString.EMPTY : 投票区コード);
            if (null == 投票区投票所対応) {
                return RString.EMPTY;
            }
            AfT502TohyojoEntity 投票所 = afT502TohyojoDac.select(投票区投票所対応.getTohyojoCode());
            if (null == 投票所) {
                return RString.EMPTY;
            }
            地図ファイル名 = 投票所.getMapImage();
        }
        return 地図ファイル名;
    }

    /**
     * 明細情報住所取得
     *
     * @param 住所 AtenaJusho
     * @param 番地 AtenaBanchi
     * @param 行政区名 RString
     * @param 地区名１ RString
     * @param 地区名２ RString
     * @param 地区名３ RString
     * @param 明細住所1印字可能文字数 int
     * @param 明細住所2印字可能文字数 int
     * @return 住所リスト
     */
    public List<RString> getMeisaiJusho(AtenaJusho 住所, AtenaBanchi 番地, RString 行政区名, RString 地区名１,
            RString 地区名２, RString 地区名３, int 明細住所1印字可能文字数, int 明細住所2印字可能文字数) {
        List<RString> 住所リスト = new ArrayList();
        for (int i = 0; i <= インデックス_住所2; i++) {
            住所リスト.add(RString.EMPTY);
        }
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        行政区名 = changeNullToEmpty(行政区名);
        地区名１ = changeNullToEmpty(地区名１);
        地区名２ = changeNullToEmpty(地区名２);
        地区名３ = changeNullToEmpty(地区名３);

        RString 編集用住所 = RString.EMPTY;
        RString 入場券_明細部住所編集 = businessConfigMap.get(ConfigKeysAFA.入場券_明細部住所編集.toString());
        if (AFAConfigKeysValue.入場券_明細部住所編集_住所.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 住所文字列;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_住所AND番地.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 住所文字列.concat(番地文字列).replace(空白, RString.EMPTY);
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_行政区.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 行政区名;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区1.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 地区名１;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区2.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 地区名２;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区3.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 地区名３;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_行政区AND番地.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 行政区名.concat(番地文字列).replace(空白, RString.EMPTY);
        }
        if (編集用住所.length() <= 明細住所1印字可能文字数) {
            住所リスト.set(インデックス_住所1, 編集用住所);
        } else if (編集用住所.length() > 明細住所1印字可能文字数 && 編集用住所.length() <= 明細住所2印字可能文字数) {
            住所リスト.set(インデックス_住所1, RString.EMPTY);
            住所リスト.set(インデックス_住所2, 編集用住所);
        } else if (編集用住所.length() > 明細住所2印字可能文字数) {
            RString 入場券_文字切れ = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力しない.configKeyValue().equals(入場券_文字切れ)) {
                住所リスト.set(インデックス_住所1, RString.EMPTY);
                住所リスト.set(インデックス_住所2, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力する.configKeyValue().equals(入場券_文字切れ)) {
                住所リスト.set(インデックス_住所1, RString.EMPTY);
                住所リスト.set(インデックス_住所2, 編集用住所.substring(0, 明細住所2印字可能文字数));
            }
        }
        return 住所リスト;
    }

    /**
     * 明細情報氏名取得
     *
     * @param 名称 RString
     * @param 氏名1の印字可能文字数 int
     * @param 氏名2の印字可能文字数 int
     * @param 氏名3の印字可能文字数 int
     * @return 氏名リスト
     */
    public List<RString> getMeisaiShimei(RString 名称, int 氏名1の印字可能文字数, int 氏名2の印字可能文字数, int 氏名3の印字可能文字数) {
        List<RString> 氏名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_氏名3; i++) {
            氏名リスト.add(RString.EMPTY);
        }
        名称 = changeNullToEmpty(名称);
        if (名称.length() <= 氏名1の印字可能文字数) {
            氏名リスト.set(インデックス_氏名1, 名称);
        } else if (名称.length() <= 氏名2の印字可能文字数 + 氏名3の印字可能文字数) {
            氏名リスト.set(インデックス_氏名2, 名称.substring(0, 氏名2の印字可能文字数));
            氏名リスト.set(インデックス_氏名3, 名称.substring(氏名2の印字可能文字数));
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                氏名リスト.set(インデックス_氏名1, RString.EMPTY);
                氏名リスト.set(インデックス_氏名2, RString.EMPTY);
                氏名リスト.set(インデックス_氏名3, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                氏名リスト.set(インデックス_氏名1, RString.EMPTY);
                氏名リスト.set(インデックス_氏名2, 名称.substring(0, 氏名2の印字可能文字数));
                氏名リスト.set(インデックス_氏名3, 名称.substring(氏名2の印字可能文字数, 氏名2の印字可能文字数 + 氏名3の印字可能文字数));
            }
        }
        return 氏名リスト;
    }

    /**
     * 明細情報氏名カナ取得
     *
     * @param カナ名称 RString
     * @param カナ名称1の印字可能文字数 int
     * @param カナ名称2の印字可能文字数 int
     * @return カナ名称リスト
     */
    public List<RString> getMeisaiKanaMeisho(RString カナ名称, int カナ名称1の印字可能文字数, int カナ名称2の印字可能文字数) {
        List<RString> カナ名称リスト = new ArrayList();
        for (int i = 0; i <= インデックス_カナ名称2; i++) {
            カナ名称リスト.add(RString.EMPTY);
        }
        カナ名称 = changeNullToEmpty(カナ名称);
        if (カナ名称.length() <= カナ名称1の印字可能文字数) {
            カナ名称リスト.set(インデックス_カナ名称1, カナ名称);
        } else if (カナ名称.length() <= カナ名称2の印字可能文字数) {
            カナ名称リスト.set(インデックス_カナ名称2, カナ名称);
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                カナ名称リスト.set(インデックス_カナ名称1, RString.EMPTY);
                カナ名称リスト.set(インデックス_カナ名称2, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                カナ名称リスト.set(インデックス_カナ名称1, RString.EMPTY);
                カナ名称リスト.set(インデックス_カナ名称2, カナ名称.substring(0, カナ名称2の印字可能文字数));
            }
        }
        return カナ名称リスト;
    }

    /**
     * 世帯主区分取得
     *
     * @param 続柄コード RString
     * @return 世帯主区分
     */
    public RString getSetainushiKubun(RString 続柄コード) {
        続柄コード = changeNullToEmpty(続柄コード);
        return 続柄コード.startsWith(続柄コードの先頭2桁_01) ? 星印 : RString.EMPTY;
    }

    /**
     * 性別表示文字取得
     *
     * @param 性別コード RString
     * @param 種類 RString
     * @return 性別表示文字
     */
    public RString getSeibetu(RString 性別コード, RString 種類) {
        RString 性別表示文字 = RString.EMPTY;
        if (Seibetsu.男.code().equals(性別コード)) {
            if (種類_入場券.equals(種類)) {
                性別表示文字 = businessConfigMap.get(ConfigKeysAFA.入場券_性別印字文字_男.toString());
            }
            if (種類_転出者お知らせはがき.equals(種類)) {
                性別表示文字 = businessConfigMap.get(ConfigKeysAFA.転出者はがき_性別印字文字_男.toString());
            }
        }
        if (Seibetsu.女.code().equals(性別コード)) {
            if (種類_入場券.equals(種類)) {
                性別表示文字 = businessConfigMap.get(ConfigKeysAFA.入場券_性別印字文字_女.toString());
            }
            if (種類_転出者お知らせはがき.equals(種類)) {
                性別表示文字 = businessConfigMap.get(ConfigKeysAFA.転出者はがき_性別印字文字_女.toString());
            }
        }
        return 性別表示文字;
    }

    /**
     * 投票所名取得
     *
     * @param 投票所名 RString
     * @param 帳票ID RString
     * @param 投票所名1の印字可能文字数 int
     * @param 投票所名2の印字可能文字数 int
     * @param 投票所名3の印字可能文字数 int
     * @return 投票所名リスト
     */
    public List<RString> getTohyojoMei(RString 投票所名, RString 帳票ID, int 投票所名1の印字可能文字数, int 投票所名2の印字可能文字数, int 投票所名3の印字可能文字数) {
        List<RString> 投票所名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_投票所名3; i++) {
            投票所名リスト.add(RString.EMPTY);
        }
        投票所名 = changeNullToEmpty(投票所名);
        if (AFAChohyoId.AFAPRB201_投票所入場券_個票3つ折り.chohyoId().equals(帳票ID)
                || AFAChohyoId.AFAPRB210_転出者お知らせハガキ.chohyoId().equals(帳票ID)) {
            if (投票所名.length() <= 投票所名1の印字可能文字数) {
                投票所名リスト.set(インデックス_投票所名1, 投票所名);
            } else if (投票所名.length() <= 投票所名2の印字可能文字数) {
                投票所名リスト.set(インデックス_投票所名2, 投票所名);
            } else {
                投票所名リスト = edit投票所名リスト(投票所名リスト, 投票所名, 帳票ID, 投票所名2の印字可能文字数);
            }
        } else {
            if (投票所名.length() <= 投票所名1の印字可能文字数) {
                投票所名リスト.set(インデックス_投票所名1, 投票所名);
            } else if (投票所名.length() <= 投票所名2の印字可能文字数 + 投票所名3の印字可能文字数) {
                投票所名リスト.set(インデックス_投票所名2, 投票所名);
                投票所名リスト.set(インデックス_投票所名3, 投票所名);
            } else {
                RString 入場券文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
                if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券文字切れ項目出力区分)) {
                    投票所名リスト.set(インデックス_投票所名1, RString.EMPTY);
                    投票所名リスト.set(インデックス_投票所名2, RString.EMPTY);
                    投票所名リスト.set(インデックス_投票所名3, RString.EMPTY);
                }
                if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券文字切れ項目出力区分)) {
                    投票所名リスト.set(インデックス_投票所名1, RString.EMPTY);
                    投票所名リスト.set(インデックス_投票所名2, 投票所名.substring(0, 投票所名2の印字可能文字数));
                    投票所名リスト.set(インデックス_投票所名3, 投票所名.substring(投票所名2の印字可能文字数, 投票所名2の印字可能文字数 + 投票所名3の印字可能文字数));
                }
            }
        }
        return 投票所名リスト;
    }

    private List<RString> edit投票所名リスト(List<RString> 投票所名リスト, RString 投票所名, RString 帳票ID, int 投票所名2の印字可能文字数) {
        if (AFAChohyoId.AFAPRB201_投票所入場券_個票3つ折り.chohyoId().equals(帳票ID)) {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                投票所名リスト.set(インデックス_投票所名1, RString.EMPTY);
                投票所名リスト.set(インデックス_投票所名2, RString.EMPTY);
                投票所名リスト.set(インデックス_投票所名3, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                投票所名リスト.set(インデックス_投票所名1, RString.EMPTY);
                投票所名リスト.set(インデックス_投票所名2, 投票所名.substring(0, 投票所名2の印字可能文字数));
                投票所名リスト.set(インデックス_投票所名3, RString.EMPTY);
            }
        }
        if (AFAChohyoId.AFAPRB210_転出者お知らせハガキ.chohyoId().equals(帳票ID)) {
            投票所名リスト.set(インデックス_投票所名2, 投票所名.substring(0, 投票所名2の印字可能文字数));
        }
        return 投票所名リスト;
    }

    /**
     * 入場券バーコード取得
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @return 入場券バーコード
     */
    public RString getNyujokenBarCode(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {
        RString 抄本番号文字列 = null == 抄本番号 ? RString.EMPTY : new RString(抄本番号.toString());
        RString 識別コード文字列 = null == 識別コード ? RString.EMPTY : 識別コード.value();
        抄本番号文字列 = 抄本番号文字列.padLeft(ゼロ, 桁数_抄本番号);
        識別コード文字列 = 識別コード文字列.padLeft(ゼロ, 桁数_識別コード);
        RString 入場券バーコード = 識別コード文字列.substring(0, 桁数_識別コード).concat(抄本番号文字列.substring(0, 桁数_抄本番号));
        return 入場券バーコード;
    }

    /**
     * ハガキ明細住所取得
     *
     * @param 住所 AtenaJusho
     * @param 番地 AtenaBanchi
     * @param 方書 Katagaki
     * @param 印字可能文字数 int
     * @return 住所リスト
     */
    public List<RString> getHagakiMeisaiJusho(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書, int 印字可能文字数) {
        List<RString> 住所リスト = new ArrayList();
        for (int i = 0; i <= インデックス_住所5; i++) {
            住所リスト.add(RString.EMPTY);
        }
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        RString 方書文字列 = null == 方書 || 方書.isEmpty() ? RString.EMPTY : changeNullToEmpty(方書.value());
        RString 編集用住所 = 住所文字列.concat(番地文字列).replace(空白, RString.EMPTY).concat(全角スペース).concat(方書文字列);
        if (編集用住所.length() <= 印字可能文字数) {
            住所リスト.set(インデックス_住所1, 編集用住所);
        } else if (編集用住所.length() <= 印字可能文字数 * 二倍) {
            住所リスト.set(インデックス_住所1, 編集用住所.substring(0, 印字可能文字数));
            住所リスト.set(インデックス_住所2, 編集用住所.substring(印字可能文字数));
        } else if (編集用住所.length() <= 印字可能文字数 * 三倍) {
            住所リスト.set(インデックス_住所1, 編集用住所.substring(0, 印字可能文字数));
            住所リスト.set(インデックス_住所2, 編集用住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
            住所リスト.set(インデックス_住所3, 編集用住所.substring(印字可能文字数 * 二倍));
        } else if (編集用住所.length() <= 印字可能文字数 * 四倍) {
            住所リスト.set(インデックス_住所1, 編集用住所.substring(0, 印字可能文字数));
            住所リスト.set(インデックス_住所2, 編集用住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
            住所リスト.set(インデックス_住所3, 編集用住所.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
            住所リスト.set(インデックス_住所4, 編集用住所.substring(印字可能文字数 * 三倍));
        } else if (編集用住所.length() <= 印字可能文字数 * 五倍) {
            住所リスト.set(インデックス_住所1, 編集用住所.substring(0, 印字可能文字数));
            住所リスト.set(インデックス_住所2, 編集用住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
            住所リスト.set(インデックス_住所3, 編集用住所.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
            住所リスト.set(インデックス_住所4, 編集用住所.substring(印字可能文字数 * 三倍, 印字可能文字数 * 四倍));
            住所リスト.set(インデックス_住所5, 編集用住所.substring(印字可能文字数 * 四倍));
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                住所リスト.set(インデックス_住所1, RString.EMPTY);
                住所リスト.set(インデックス_住所2, RString.EMPTY);
                住所リスト.set(インデックス_住所3, RString.EMPTY);
                住所リスト.set(インデックス_住所4, RString.EMPTY);
                住所リスト.set(インデックス_住所5, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                住所リスト.set(インデックス_住所1, 編集用住所.substring(0, 印字可能文字数));
                住所リスト.set(インデックス_住所2, 編集用住所.substring(印字可能文字数, 印字可能文字数 * 二倍));
                住所リスト.set(インデックス_住所3, 編集用住所.substring(印字可能文字数 * 二倍, 印字可能文字数 * 三倍));
                住所リスト.set(インデックス_住所4, 編集用住所.substring(印字可能文字数 * 三倍, 印字可能文字数 * 四倍));
                住所リスト.set(インデックス_住所5, 編集用住所.substring(印字可能文字数 * 四倍, 印字可能文字数 * 五倍));
            }
        }
        return 住所リスト;
    }

    /**
     * ハガキ明細氏名取得
     *
     * @param 名称 RString
     * @param 名称1の印字可能文字数 int
     * @param 名称2の印字可能文字数 int
     * @param 名称3の印字可能文字数 int
     * @return 名称リスト
     */
    public List<RString> getHagakiMeisaiShimei(RString 名称, int 名称1の印字可能文字数, int 名称2の印字可能文字数, int 名称3の印字可能文字数) {
        List<RString> 名称リスト = new ArrayList();
        for (int i = 0; i <= インデックス_名称3; i++) {
            名称リスト.add(RString.EMPTY);
        }
        名称 = changeNullToEmpty(名称);
        RString 宛名敬称付加 = RString.EMPTY;
        RString 入場券_宛名敬称 = businessConfigMap.get(ConfigKeysAFA.入場券_宛名敬称.toString());
        if (AFAConfigKeysValue.入場券_宛名敬称_印字しない.configKeyValue().equals(入場券_宛名敬称)) {
            宛名敬称付加 = 名称;
        }
        if (AFAConfigKeysValue.入場券_宛名敬称_様を印字する.configKeyValue().equals(入場券_宛名敬称)) {
            宛名敬称付加 = 名称.concat(様);
        }
        if (AFAConfigKeysValue.入場券_宛名敬称_殿を印字する.configKeyValue().equals(入場券_宛名敬称)) {
            宛名敬称付加 = 名称.concat(殿);
        }
        if (宛名敬称付加.length() <= 名称1の印字可能文字数) {
            名称リスト.set(インデックス_名称1, 宛名敬称付加);
        } else if (宛名敬称付加.length() <= 名称1の印字可能文字数 + 名称2の印字可能文字数) {
            名称リスト.set(インデックス_名称1, 宛名敬称付加.substring(0, 名称1の印字可能文字数));
            名称リスト.set(インデックス_名称2, 宛名敬称付加.substring(名称1の印字可能文字数));
        } else if (宛名敬称付加.length() <= 名称1の印字可能文字数 + 名称2の印字可能文字数 + 名称3の印字可能文字数) {
            名称リスト.set(インデックス_名称1, 宛名敬称付加.substring(0, 名称1の印字可能文字数));
            名称リスト.set(インデックス_名称2, 宛名敬称付加.substring(名称1の印字可能文字数, 名称1の印字可能文字数 + 名称2の印字可能文字数));
            名称リスト.set(インデックス_名称3, 宛名敬称付加.substring(名称1の印字可能文字数 + 名称2の印字可能文字数));
        } else {
            RString 入場券_文字切れ項目出力区分 = businessConfigMap.get(ConfigKeysAFA.入場券_文字切れ項目出力区分.toString());
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字しない.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                名称リスト.set(インデックス_名称1, RString.EMPTY);
                名称リスト.set(インデックス_名称2, RString.EMPTY);
                名称リスト.set(インデックス_名称3, RString.EMPTY);
            }
            if (AFAConfigKeysValue.入場券_文字切れ項目出力区分_印字可能文字数まで出力.configKeyValue().equals(入場券_文字切れ項目出力区分)) {
                名称リスト.set(インデックス_名称1, 宛名敬称付加.substring(0, 名称1の印字可能文字数));
                名称リスト.set(インデックス_名称2, 宛名敬称付加.substring(名称1の印字可能文字数, 名称1の印字可能文字数 + 名称2の印字可能文字数));
                名称リスト.set(インデックス_名称3, 宛名敬称付加.substring(名称1の印字可能文字数 + 名称2の印字可能文字数, 名称1の印字可能文字数 + 名称2の印字可能文字数 + 名称3の印字可能文字数));
            }
        }
        return 名称リスト;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
