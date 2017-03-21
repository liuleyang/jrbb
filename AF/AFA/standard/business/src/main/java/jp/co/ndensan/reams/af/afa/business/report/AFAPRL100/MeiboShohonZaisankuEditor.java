package jp.co.ndensan.reams.af.afa.business.report.AFAPRL100;

import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonZaisankuParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 財産区選挙人名簿抄本
 *
 * @reamsid_L AF-0600-030 lis
 */
public class MeiboShohonZaisankuEditor implements IMeiboShohonZaisankuEditor {

    private static final RString 全角スペース = new RString("　");
    private final RString 財産区抄本 = new RString("財産区選挙人名簿抄本");
    private final RString 財産区抄本_縦覧 = new RString("財産区選挙人名簿抄本（縦覧）");
    private final RString 選挙管理委員会 = new RString("選挙管理委員会");
    private static final int 長さ_住所１ = getItemLength(new RString("listListjusho1_1"));
    private static final int 長さ_抹消線_住所１ = getItemLength(new RString("listListjusho1M_1"));
    private static final int 長さ_生年月日 = getItemLength(new RString("listSeinengappi_1"));
    private static final int 長さ_抹消線_生年月日 = getItemLength(new RString("listSeinengappiM_1"));
    private static final int 長さ_性別 = getItemLength(new RString("listSeinengappi_2"));
    private static final int 長さ_抹消線_性別 = getItemLength(new RString("listSeinengappiM_2"));
    private static final int 長さ_世帯主 = getItemLength(new RString("listSetainushi_1"));
    private static final int 長さ_抹消線_世帯主 = getItemLength(new RString("listSetainushiM_1"));
    private static final int 長さ_住所２ = getItemLength(new RString("listListjusho2_1"));
    private static final int 長さ_抹消線_住所２ = getItemLength(new RString("listListjusho2M_1"));
    private static final int 長さ_住所３ = getItemLength(new RString("listListjusho3_1"));
    private static final int 長さ_抹消線_住所３ = getItemLength(new RString("listListjusho3M_1"));
    private static final int 長さ_氏名1 = getItemLength(new RString("listShimei_1"));
    private static final int 長さ_抹消線_氏名1 = getItemLength(new RString("listShimeiM_1"));
    private static final int 長さ_氏名２ = getItemLength(new RString("listKanaShimei_1"));
    private static final int 長さ_抹消線_氏名２ = getItemLength(new RString("listKanaShimeiM_1"));
    private static final int 長さ_表示１ = getItemLength(new RString("listTeishiMoji_1"));
    private static final int 長さ_表示２ = getItemLength(new RString("listMasshoJiyu_1"));
    private final RString 基準日 = new RString("基準日:");
    private final RString 投票日 = new RString("投票日:");
    private final RString 左括弧 = new RString("(");
    private final RString 右括弧 = new RString(")");
    private final RString 印字しない = new RString("0");
    private final RString 印字する = new RString("1");
    private final RString 日本人 = new RString("1");
    private final RString 外国人 = new RString("2");
    private static final int 出力方式2 = 2;
    private static final int 出力方式3 = 3;
    private static final RString 住民 = new RString("住民");
    private static final RString 世帯主 = new RString("世帯主");
    private static final RString ヘッダ_住所 = new RString("11");
    private static final RString ヘッダ_行政区 = new RString("12");
    private static final RString ヘッダ_地区コード１ = new RString("13");
    private static final RString ヘッダ_地区コード2 = new RString("14");
    private static final RString ヘッダ_地区コード3 = new RString("15");
    private static final RString 明細部_番地 = new RString("10");
    private static final RString 明細部_住所番地 = new RString("11");
    private static final RString 明細部_行政区番地 = new RString("12");

    private final MeiboShohonZaisankuParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link MeiboShohonZaisankuParam}
     */
    public MeiboShohonZaisankuEditor(MeiboShohonZaisankuParam data) {
        this.data = data;
    }

    /**
     * 財産区選挙人名簿抄本エディットメソッド
     *
     * @param source 財産区選挙人名簿抄本
     * @return 財産区選挙人名簿抄本
     */
    @Override
    public MeiboShohonZaisankuSource edit(MeiboShohonZaisankuSource source) {
        edit投票区名(source);
        edit投票区コード(source);
        editヘッダ項目(source);
        editトータルページ(source);
        editページ(source);
        edit選挙管理委員会名称(source);
        editアクセスログ出力(source);
        edit作成条件(source);
        editキー(source);
        edit識別コード(source);
        if (null != data.get画面ID()) {
            if (data.get画面ID().equals(財産区抄本)) {
                source.title = 財産区抄本;
                edit生年月日(source);
                edit性別(source);
                edit世帯主(source);
                edit氏名1(source);
                edit氏名2(source);
                edit表示(source);
                edit住所(source);
                edit集計(source);
                edit抹消線(source);
            } else if (data.get画面ID().equals(財産区抄本_縦覧)) {
                source.title = 財産区抄本_縦覧;
                edit明細(source);
            }
        }
        return source;
    }

    private void editキー(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            source.key1 = null == data.get財産区選挙人名簿の情報().getKey1() ? RString.EMPTY : data.get財産区選挙人名簿の情報().getKey1();
            source.key2 = null == data.get財産区選挙人名簿の情報().getKey1() ? RString.EMPTY : data.get財産区選挙人名簿の情報().getKey2();
            source.key3 = null == data.get財産区選挙人名簿の情報().getKey1() ? RString.EMPTY : data.get財産区選挙人名簿の情報().getKey3();
            source.key4 = null == data.get財産区選挙人名簿の情報().getKey1() ? RString.EMPTY : data.get財産区選挙人名簿の情報().getKey4();
        }
    }

    private void edit明細(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            if (data.get財産区選挙人名簿の情報().get帳票フラグ() == 出力方式2) {
                edit明細空白行(source);
            } else if (data.get財産区選挙人名簿の情報().get帳票フラグ() == 出力方式3) {
                edit明細マスキング(source);
                edit抹消線(source);
            } else {
                edit生年月日(source);
                edit性別(source);
                edit世帯主(source);
                edit氏名1(source);
                edit氏名2(source);
                edit表示(source);
                edit住所(source);
                edit抹消線(source);
            }
        }
    }

    private void edit明細空白行(MeiboShohonZaisankuSource source) {
        source.listListjusho1_1 = RString.EMPTY;
        source.listListjusho1M_1 = RString.EMPTY;
        source.listListjusho2_1 = RString.EMPTY;
        source.listListjusho2M_1 = RString.EMPTY;
        source.listListjusho3_1 = RString.EMPTY;
        source.listListjusho3M_1 = RString.EMPTY;
        source.listSeinengappi_1 = RString.EMPTY;
        source.listSeinengappiM_1 = RString.EMPTY;
        source.listSeinengappi_2 = RString.EMPTY;
        source.listSeinengappiM_2 = RString.EMPTY;
        source.listSetainushi_1 = RString.EMPTY;
        source.listSetainushiM_1 = RString.EMPTY;
        source.listShimei_1 = RString.EMPTY;
        source.listShimeiM_1 = RString.EMPTY;
        source.listKanaShimei_1 = RString.EMPTY;
        source.listKanaShimeiM_1 = RString.EMPTY;
        source.listTeishiMoji_1 = RString.EMPTY;
        source.listMasshoJiyu_1 = RString.EMPTY;
    }

    private void edit明細マスキング(MeiboShohonZaisankuSource source) {
        source.listListjusho1_1 = editマスキングする(長さ_住所１);
        source.listListjusho1M_1 = editマスキングする(長さ_抹消線_住所１);
        source.listListjusho2_1 = editマスキングする(長さ_住所２);
        source.listListjusho2M_1 = editマスキングする(長さ_抹消線_住所２);
        source.listListjusho3_1 = editマスキングする(長さ_住所３);
        source.listListjusho3M_1 = editマスキングする(長さ_抹消線_住所３);
        source.listSeinengappi_1 = editマスキングする(長さ_生年月日);
        source.listSeinengappiM_1 = editマスキングする(長さ_抹消線_生年月日);
        source.listSeinengappi_2 = editマスキングする(長さ_性別);
        source.listSeinengappiM_2 = editマスキングする(長さ_抹消線_性別);
        source.listSetainushi_1 = editマスキングする(長さ_世帯主);
        source.listSetainushiM_1 = editマスキングする(長さ_抹消線_世帯主);
        source.listShimei_1 = editマスキングする(長さ_氏名1);
        source.listShimeiM_1 = editマスキングする(長さ_抹消線_氏名1);
        source.listKanaShimei_1 = editマスキングする(長さ_氏名２);
        source.listKanaShimeiM_1 = editマスキングする(長さ_抹消線_氏名２);
        source.listTeishiMoji_1 = editマスキングする(長さ_表示１);
        source.listMasshoJiyu_1 = editマスキングする(長さ_表示２);

    }

    private RString editマスキングする(int length) {
        RString マスキング = RString.EMPTY;
        for (int i = 0; i < length; i++) {
            マスキング = マスキング.concat(new RString("*"));
        }
        return マスキング;
    }

    private void edit投票区名(MeiboShohonZaisankuSource source) {
        source.tohyokuMei = RString.EMPTY;
        RString tohyokuMeiFlg = BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_投票区名, SubGyomuCode.AFA選挙本体);
        if (null != data.get財産区選挙人名簿の情報() && 印字する.equals(tohyokuMeiFlg)) {
            source.tohyokuMei = changeNullToEmpty(data.get財産区選挙人名簿の情報().get投票区名());
        }
    }

    private void edit投票区コード(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            source.tohyokuCode = changeNullToEmpty(data.get財産区選挙人名簿の情報().get投票区コード());
        } else {
            source.tohyokuCode = RString.EMPTY;
        }
    }

    private void editヘッダ項目(MeiboShohonZaisankuSource source) {
        if (null != data.get選挙人資格情報() && null != data.get選挙人資格情報().getAtenaPSMEntity()) {
            if (ヘッダ_住所.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所, SubGyomuCode.AFA選挙本体))) {
                source.jushoMeisho = new RString("住所");
                ChoikiCode jutonaiChoikiCode = data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiChoikiCode();
                source.jushoCode = null == jutonaiChoikiCode ? RString.EMPTY : jutonaiChoikiCode.getColumnValue();
                source.jusho = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiJusho());
            } else if (ヘッダ_行政区.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所, SubGyomuCode.AFA選挙本体))) {
                source.jushoMeisho = new RString("行政区");
                GyoseikuCode gyoseikuCode = data.get選挙人資格情報().getAtenaPSMEntity().getGyoseikuCode();
                source.jushoCode = null == gyoseikuCode ? RString.EMPTY : gyoseikuCode.getColumnValue();
                source.jusho = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getGyoseikuName());
            } else if (ヘッダ_地区コード１.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所, SubGyomuCode.AFA選挙本体))) {
                source.jushoMeisho = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１);
                ChikuCode chikuCode1 = data.get選挙人資格情報().getAtenaPSMEntity().getChikuCode1();
                source.jushoCode = null == chikuCode1 ? RString.EMPTY : chikuCode1.getColumnValue();
                source.jusho = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getChikuName1());
            } else if (ヘッダ_地区コード2.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所, SubGyomuCode.AFA選挙本体))) {
                source.jushoMeisho = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２);
                ChikuCode chikuCode2 = data.get選挙人資格情報().getAtenaPSMEntity().getChikuCode2();
                source.jushoCode = null == chikuCode2 ? RString.EMPTY : chikuCode2.getColumnValue();
                source.jusho = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getChikuName2());
            } else if (ヘッダ_地区コード3.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所, SubGyomuCode.AFA選挙本体))) {
                source.jushoMeisho = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３);
                ChikuCode chikuCode3 = data.get選挙人資格情報().getAtenaPSMEntity().getChikuCode3();
                source.jushoCode = null == chikuCode3 ? RString.EMPTY : chikuCode3.getColumnValue();
                source.jusho = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getChikuName3());
            }
        }
    }

    private void editトータルページ(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            source.totalPage = changeNullToEmpty(data.get財産区選挙人名簿の情報().getTotalPage());
        }
    }

    private void editページ(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            source.page = new RString(data.get財産区選挙人名簿の情報().getPage());
        }
    }

    private void edit住所(MeiboShohonZaisankuSource source) {
        RString 住所連結文字列 = RString.EMPTY;
        if (null != data.get選挙人資格情報() && null != data.get選挙人資格情報().getAtenaPSMEntity()) {
            if (明細部_番地.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_住所欄出力内容, SubGyomuCode.AFA選挙本体))) {
                AtenaBanchi jutonaiBanchi = data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiBanchi();
                住所連結文字列 = null == jutonaiBanchi ? RString.EMPTY : jutonaiBanchi.getColumnValue();
            } else if (明細部_住所番地.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_住所欄出力内容, SubGyomuCode.AFA選挙本体))) {
                AtenaBanchi jutonaiBanchi = data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiBanchi();
                住所連結文字列 = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiJusho())
                        .concat(null == jutonaiBanchi ? RString.EMPTY : jutonaiBanchi.getColumnValue());
            } else if (明細部_行政区番地.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_住所欄出力内容, SubGyomuCode.AFA選挙本体))) {
                AtenaBanchi jutonaiBanchi = data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiBanchi();
                住所連結文字列 = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getGyoseikuName())
                        .concat(null == jutonaiBanchi ? RString.EMPTY : jutonaiBanchi.getColumnValue());
            }
            if (住所連結文字列.length() <= 長さ_住所１) {
                source.listListjusho1_1 = 住所連結文字列;
            } else {
                source.listListjusho1_1 = 住所連結文字列.substring(0, 長さ_住所１);
            }
        }
        if (印字しない.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_方書印字有無, SubGyomuCode.AFA選挙本体))) {
            if (住所連結文字列.length() <= 長さ_住所１) {
                source.listListjusho2_1 = RString.EMPTY;
                source.listListjusho3_1 = RString.EMPTY;
            } else if (住所連結文字列.length() <= (長さ_住所１ + 長さ_住所２)) {
                source.listListjusho2_1 = 住所連結文字列.substring(長さ_住所１);
                source.listListjusho3_1 = RString.EMPTY;
            } else if (住所連結文字列.length() <= (長さ_住所１ + 長さ_住所２ + 長さ_住所３)) {
                source.listListjusho2_1 = 住所連結文字列.substring(長さ_住所１, (長さ_住所１ + 長さ_住所２));
                source.listListjusho3_1 = 住所連結文字列.substring((長さ_住所１ + 長さ_住所２));
            } else {
                source.listListjusho2_1 = 住所連結文字列.substring(長さ_住所１, (長さ_住所１ + 長さ_住所２));
                source.listListjusho3_1 = 住所連結文字列.substring((長さ_住所１ + 長さ_住所２), (長さ_住所１ + 長さ_住所２ + 長さ_住所３));
                source.listListjusho = 住所連結文字列;
            }
        } else if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_方書印字有無, SubGyomuCode.AFA選挙本体))) {
            Katagaki jutonaiKatagaki = data.get選挙人資格情報().getAtenaPSMEntity().getJutonaiKatagaki();
            RString 住登方書 = null == jutonaiKatagaki ? RString.EMPTY : jutonaiKatagaki.getColumnValue();
            if (住所連結文字列.length() <= 長さ_住所１) {
                edit住所２連結文字列(source, 住登方書);
            } else if (住所連結文字列.length() <= (長さ_住所１ + 長さ_住所２)) {
                RString 住所２連結文字列 = 住所連結文字列.substring(長さ_住所１).concat(全角スペース).concat(住登方書);
                edit住所２連結文字列(source, 住所２連結文字列);
            } else if (住所連結文字列.length() <= (長さ_住所１ + 長さ_住所２ + 長さ_住所３)) {
                RString 住所２連結文字列 = 住所連結文字列.substring(長さ_住所１).concat(全角スペース).concat(住登方書);
                source.listListjusho2_1 = 住所２連結文字列.substring(長さ_住所１, (長さ_住所１ + 長さ_住所２));
                source.listListjusho3_1 = 住所２連結文字列.substring(長さ_住所１ + 長さ_住所２);
            } else {
                RString 住所２連結文字列 = 住所連結文字列.substring(長さ_住所１).concat(全角スペース).concat(住登方書);
                source.listListjusho2_1 = 住所２連結文字列.substring(長さ_住所１, (長さ_住所１ + 長さ_住所２));
                source.listListjusho3_1 = 住所２連結文字列.substring((長さ_住所１ + 長さ_住所２), (長さ_住所１ + 長さ_住所２ + 長さ_住所３));
            }
            source.listListjusho = 住所連結文字列.concat(全角スペース).concat(住登方書);
        }
    }

    private void edit住所２連結文字列(MeiboShohonZaisankuSource source, RString 文字列) {
        if (文字列.length() <= 長さ_住所２) {
            source.listListjusho2_1 = 文字列;
        } else if (文字列.length() <= (長さ_住所２ + 長さ_住所３)) {
            source.listListjusho2_1 = 文字列.substring(0, 長さ_住所２);
            source.listListjusho3_1 = 文字列.substring(長さ_住所２);
        } else {
            source.listListjusho2_1 = 文字列.substring(0, 長さ_住所２);
            source.listListjusho3_1 = 文字列.substring(長さ_住所２, (長さ_住所２ + 長さ_住所３));
        }
    }

    private void edit生年月日(MeiboShohonZaisankuSource source) {
        if (印字しない.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_生年月日, SubGyomuCode.AFA選挙本体))) {
            source.listSeinengappi_1 = RString.EMPTY;
        } else if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_生年月日, SubGyomuCode.AFA選挙本体))) {
            if (日本人.equals(data.get財産区選挙人名簿の情報().get住民種別コード())) {
                source.listSeinengappi_1 = data.get財産区選挙人名簿の情報().get生年月日().wareki().toDateString();
            } else if (外国人.equals(data.get財産区選挙人名簿の情報().get住民種別コード())) {
                source.listSeinengappi_1 = data.get財産区選挙人名簿の情報().get生年月日().seireki().toDateString();
            }
        }

    }

    private void edit性別(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            if (RString.EMPTY.equals(data.get財産区選挙人名簿の情報().get性別コード())) {
                source.listSeinengappi_2 = RString.EMPTY;
            } else {
                if (FEMALE.getCode().equals(data.get財産区選挙人名簿の情報().get性別コード())) {
                    source.listSeinengappi_2 = FEMALE.getName().getFullJapanese();
                } else if (MALE.getCode().equals(data.get財産区選挙人名簿の情報().get性別コード())) {
                    source.listSeinengappi_2 = MALE.getName().getFullJapanese();
                }
            }
        }
    }

    private void edit世帯主(MeiboShohonZaisankuSource source) {
        if (印字しない.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_世帯主区分, SubGyomuCode.AFA選挙本体))) {
            source.listSetainushi_1 = RString.EMPTY;
        } else if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_世帯主区分, SubGyomuCode.AFA選挙本体))) {
            edit世帯主の編集方法(source);
        }
    }

    private void edit世帯主の編集方法(MeiboShohonZaisankuSource source) {
        RString juminJotaiCode = RString.EMPTY;
        RString tsuzukigara = RString.EMPTY;
        if (null != data.get選挙人資格情報() && null != data.get選挙人資格情報().getAtenaPSMEntity()) {
            juminJotaiCode = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getJuminJotaiCode());
            tsuzukigara = changeNullToEmpty(data.get選挙人資格情報().getAtenaPSMEntity().getTsuzukigara());
        }
        if (住民.equals(juminJotaiCode)) {
            if (世帯主.equals(data.get選挙人資格情報().getAtenaPSMEntity().getTsuzukigara())) {
                source.listSetainushi_1 = new RString("＊");
            } else {
                source.listSetainushi_1 = RString.EMPTY;
            }
        } else {
            if (世帯主.equals(tsuzukigara)) {
                source.listSetainushi_1 = new RString("*");
            } else {
                source.listSetainushi_1 = RString.EMPTY;
            }
        }
    }

    private void edit氏名1(MeiboShohonZaisankuSource source) {
        RString 名称 = changeNullToEmpty(data.get財産区選挙人名簿の情報().get名称());
        if (null != data.get財産区選挙人名簿の情報()) {
            if (名称.length() <= 長さ_氏名1) {
                source.listShimei_1 = 名称;
            } else {
                source.listShimei_1 = 名称.substring(0, 長さ_氏名1);
                source.listShimei = 名称;
            }
        }
    }

    private void edit抹消線(MeiboShohonZaisankuSource source) {
        if (BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_抹消者抹消線, SubGyomuCode.AFA選挙本体).equals(印字しない)) {
            source.listListjusho1M_1 = RString.EMPTY;
            source.listSeinengappiM_1 = RString.EMPTY;
            source.listSeinengappiM_2 = RString.EMPTY;
            source.listSetainushiM_1 = RString.EMPTY;
            source.listListjusho2M_1 = RString.EMPTY;
            source.listListjusho3M_1 = RString.EMPTY;
            source.listShimeiM_1 = RString.EMPTY;
            source.listKanaShimeiM_1 = RString.EMPTY;
        } else if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_抹消者抹消線, SubGyomuCode.AFA選挙本体))) {
            edit抹消線_印字(source);
        }
    }

    private void edit抹消線_印字(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            if (!data.get財産区選挙人名簿の情報().get抹消事由コード().isNullOrEmpty()) {
                source.listListjusho1M_1 = source.listListjusho1_1;
                source.listSeinengappiM_1 = source.listSeinengappi_1;
                source.listSeinengappiM_2 = source.listSeinengappi_2;
                source.listSetainushiM_1 = source.listSetainushi_1;
                source.listListjusho2M_1 = source.listListjusho2_1;
                source.listListjusho3M_1 = source.listListjusho3_1;
                source.listShimeiM_1 = source.listShimei_1;
                source.listKanaShimeiM_1 = source.listKanaShimei_1;
            } else {
                source.listListjusho1M_1 = RString.EMPTY;
                source.listSeinengappiM_1 = RString.EMPTY;
                source.listSeinengappiM_2 = RString.EMPTY;
                source.listSetainushiM_1 = RString.EMPTY;
                source.listListjusho2M_1 = RString.EMPTY;
                source.listListjusho3M_1 = RString.EMPTY;
                source.listShimeiM_1 = RString.EMPTY;
                source.listKanaShimeiM_1 = RString.EMPTY;
            }
        }
    }

    private void edit氏名2(MeiboShohonZaisankuSource source) {
        RString 識別コード = changeNullToEmpty(data.get財産区選挙人名簿の情報().get識別コード());
        if (印字しない.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_カナ名称, SubGyomuCode.AFA選挙本体))) {
            edit印字無(source, 識別コード);
        } else if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_カナ名称, SubGyomuCode.AFA選挙本体))) {
            edit印字有(source, 識別コード);
        }
    }

    private void edit印字無(MeiboShohonZaisankuSource source, RString 識別コード) {
        if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_識別コード, SubGyomuCode.AFA選挙本体))) {
            RString 氏名 = 識別コード.padLeft(長さ_氏名２ - 識別コード.length());
            if (氏名.length() <= 長さ_氏名２) {
                source.listKanaShimei_1 = 氏名;
            } else {
                source.listKanaShimei_1 = 氏名.substring(0, 長さ_氏名２);
                source.listShimei = 氏名;
            }
        } else {
            source.listKanaShimei_1 = RString.EMPTY;
        }
    }

    private void edit印字有(MeiboShohonZaisankuSource source, RString 識別コード) {
        if (印字しない.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_識別コード, SubGyomuCode.AFA選挙本体))) {
            int 算出文字数 = 長さ_氏名２ - 2;
            RString 氏名_1 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧);
            if (氏名_1.length() <= 長さ_氏名２) {
                source.listKanaShimei_1 = 氏名_1;
            } else {
                source.listKanaShimei_1 = 氏名_1.substring(0, 長さ_氏名２);
                source.listShimei = 氏名_1;
            }
        } else if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.抄本_印字有無_識別コード, SubGyomuCode.AFA選挙本体))) {
            int 算出文字数 = 長さ_氏名２ - 識別コード.length() - 2;
            RString 氏名_2 = 左括弧.concat(getカナ名称_算出文字数(算出文字数)).concat(右括弧).concat(識別コード);
            if (氏名_2.length() <= 長さ_氏名２) {
                source.listKanaShimei_1 = 氏名_2;
            } else {
                source.listKanaShimei_1 = 氏名_2.substring(0, 長さ_氏名２);
                source.listShimei = 氏名_2;
            }
        }
    }

    private RString getカナ名称_算出文字数(int number) {
        RString カナ名称 = RString.EMPTY;
        if (null != data.get財産区選挙人名簿の情報()) {
            RString kana = changeNullToEmpty(data.get財産区選挙人名簿の情報().getカナ名称());
            if (kana != null && kana.length() <= number) {
                カナ名称 = kana.padRight(number);
            } else if (kana != null) {
                カナ名称 = kana.substring(0, number);
            }
        }
        return カナ名称;
    }

    private void edit表示(MeiboShohonZaisankuSource source) {
        if (data.isIs公民権停止者()) {
            source.listTeishiMoji_1 = BusinessConfig.get(ConfigKeysAFA.抄本_公民権停止文字, SubGyomuCode.AFA選挙本体);
        }
        if (null != data.get財産区選挙人名簿の情報()) {
            RString 抹消事由コード = changeNullToEmpty(data.get財産区選挙人名簿の情報().get抹消事由コード());
            if (RString.EMPTY.equals(抹消事由コード)) {
                source.listMasshoJiyu_1 = RString.EMPTY;
            } else {
                source.listMasshoJiyu_1 = CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体,
                        AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), new Code(抹消事由コード));
            }
        }
    }

    private void edit選挙管理委員会名称(MeiboShohonZaisankuSource source) {
        if (null != data.get地方公共団体情報()) {
            source.senkanMei = changeNullToEmpty(data.get地方公共団体情報().get市町村名()).concat(選挙管理委員会);
        }
    }

    private void edit作成条件(MeiboShohonZaisankuSource source) {
        source.selHani1 = changeNullToEmpty(data.get財産区選挙人名簿の情報().get抄本名());
        if (null != data.get財産区選挙人名簿の情報()) {
            source.selHani2 = 基準日.concat(data.get財産区選挙人名簿の情報().get名簿基準年月日().wareki().toDateString())
                    .concat(全角スペース)
                    .concat(投票日).concat(data.get財産区選挙人名簿の情報().get投票年月日().wareki().toDateString());
        }
    }

    private void edit集計(MeiboShohonZaisankuSource source) {
        if (null != data.get名簿抄本情報集計()) {
            source.pageKeiMan = changeNullToEmpty(data.get名簿抄本情報集計().getPageKeiMan());
            source.pageKeiWoman = changeNullToEmpty(data.get名簿抄本情報集計().getPageKeiWoman());
            source.pageKeiKei = changeNullToEmpty(data.get名簿抄本情報集計().getPageKeiKei());
            source.kei1Title = changeNullToEmpty(data.get名簿抄本情報集計().getKei1Title());
            source.kei1Man = changeNullToEmpty(data.get名簿抄本情報集計().getKei1Man());
            source.kei1Woman = changeNullToEmpty(data.get名簿抄本情報集計().getKei1Woman());
            source.kei1Kei = changeNullToEmpty(data.get名簿抄本情報集計().getKei1Kei());
            source.kei2Title = changeNullToEmpty(data.get名簿抄本情報集計().getKei2Title());
            source.kei2Man = changeNullToEmpty(data.get名簿抄本情報集計().getKei2Man());
            source.kei2Woman = changeNullToEmpty(data.get名簿抄本情報集計().getKei2Woman());
            source.kei2Kei = changeNullToEmpty(data.get名簿抄本情報集計().getKei2Kei());
            source.kei3Title = changeNullToEmpty(data.get名簿抄本情報集計().getKei3Title());
            source.kei3Man = changeNullToEmpty(data.get名簿抄本情報集計().getKei3Man());
            source.kei3Woman = changeNullToEmpty(data.get名簿抄本情報集計().getKei3Woman());
            source.kei3Kei = changeNullToEmpty(data.get名簿抄本情報集計().getKei3Kei());
            source.kei4Title = changeNullToEmpty(data.get名簿抄本情報集計().getKei4Title());
            source.kei4Man = changeNullToEmpty(data.get名簿抄本情報集計().getKei4Man());
            source.kei4Woman = changeNullToEmpty(data.get名簿抄本情報集計().getKei4Woman());
            source.kei4Kei = changeNullToEmpty(data.get名簿抄本情報集計().getKei4Kei());
        }
    }

    private void edit識別コード(MeiboShohonZaisankuSource source) {
        if (null != data.get財産区選挙人名簿の情報()) {
            source.listShikibetsuCode = changeNullToEmpty(data.get財産区選挙人名簿の情報().get識別コード());
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;

    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(MeiboShohonZaisankuSource.class, itemName);
    }

    private void editアクセスログ出力(MeiboShohonZaisankuSource source) {
        if (null != data.get選挙人資格情報() && null != data.get選挙人資格情報().getAtenaPSMEntity()) {
            source.識別コード = data.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            source.shikibetsuCode = null == source.識別コード ? RString.EMPTY
                    : source.識別コード.getColumnValue();
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
