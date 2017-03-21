/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA101;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.世帯;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.住所;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.住所と番地;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.地区1;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.地区2;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.地区3;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.地区コード1;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.地区名1と番地;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.空欄;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.行政区;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.行政区と番地;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.EikyuMeiboInjiNaiyoConfig.識別コード;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.EikyuSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA101.EikyuMeiboSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.転出者;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu.外国人;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 永久選挙人名簿Editorです。
 *
 * @reamsid_L AF-0010-035 qiuxy
 */
public class EikyuMeiboEditor implements IEikyuMeiboEditor {

    private static final int 住所分割_20 = 20;
    private static final int 住所分割_40 = 40;
    private static final int 住所分割_60 = 60;
    private static final RString 項目_氏名1 = new RString("shimei1");
    private static final RString 項目_氏名2 = new RString("shimei2");
    private static final RString 項目_氏名3 = new RString("shimei3");
    private static final RString 項目_カナ氏名1 = new RString("shimeiKana1");
    private static final RString 項目_地区名1 = new RString("chikuMei1");
    private static final RString 項目_地区名2 = new RString("chikuMei2");
    private static final RString 項目_地区名3 = new RString("chikuMei3");
    private static final RString 項目_続柄1 = new RString("zokugara1");
    private static final RString 項目_続柄2 = new RString("zokugara2");
    private static final RString 項目_続柄3 = new RString("zokugara2");
    private static final RString 項目_世帯主名1 = new RString("setainushiMei1");
    private static final RString 項目_世帯主名2 = new RString("setainushiMei2");
    private static final RString 項目_世帯主名3 = new RString("setainushiMei3");
    private static final RString 項目_表示理由1 = new RString("hyojiRiyu1");
    private static final RString 項目_抹消理由1 = new RString("masshoRiyu1");
    private static final RString 項目_従前の住所1 = new RString("sakiJusho1");
    private static final RString 項目_従前の住所2 = new RString("sakiJusho2");
    private static final RString 項目_従前の住所3 = new RString("sakiJusho3");
    private static final RString 項目_従前の住所4 = new RString("sakiJusho4");
    private static final RString 項目_従前の住所5 = new RString("sakiJusho5");
    private static final RString 項目_転出先住所1 = new RString("zenJusho1");
    private static final RString 項目_転出先住所2 = new RString("zenJusho2");
    private static final RString 項目_転出先住所3 = new RString("zenJusho3");
    private static final RString 項目_転出先住所4 = new RString("zenJusho4");
    private static final RString 項目_転出先住所5 = new RString("zenJusho5");
    private final EikyuSenkyoninMeiboEntity item;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final UaFt200FindShikibetsuTaishoEntity 宛名PSM;

    /**
     * コンストラクタです。
     *
     * @param item EikyuSenkyoninMeiboEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public EikyuMeiboEditor(EikyuSenkyoninMeiboEntity item, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.item = item;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.宛名PSM = item.getShikibetsuTaishoEntity();
    }

    @Override
    public EikyuMeiboSource edit(EikyuMeiboSource source) {
        Map<RString, Integer> 項目map = get項目lengthMap(source);
        set住所(source);
        setカナ氏名(source, 項目map);
        set氏名(source, 項目map);
        set生年月日(source);
        set性別(source);
        set住民票作成日転入届出日(source);
        set投票区(source);
        set地区_行政区名称(source, 項目map);
        set登録年月日(source);
        set世帯主名(source, 項目map);
        set続柄(source, 項目map);
        set住所コード(source);
        set行政区コード(source);
        setコード1(source);
        setコード2(source);
        set表示年月日(source);
        set表示理由(source, 項目map);
        set抹消年月日(source);
        set抹消理由(source, 項目map);
        set転出先住所(source, 項目map);
        set転入前住所(source, 項目map);
        editログの出力(source);
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        return source;
    }

    private void editログの出力(EikyuMeiboSource source) {
        source.識別コード1 = item.getShikibetsuTaishoEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void set住所(EikyuMeiboSource source) {
        RStringBuilder 住所文字列 = new RStringBuilder();
        AtenaBanchi 住登内番地 = 宛名PSM.getJutonaiBanchi();
        RString 番地 = RString.EMPTY;
        if (null != 住登内番地) {
            番地 = 住登内番地.value();
        }
        RString config = BusinessConfig.get(EikyuMeiboInjiNaiyoConfig.永久名簿_印字内容_住所, SubGyomuCode.AFA選挙本体);
        if (住所と番地.getValue().equals(config)) {
            RString 住所 = 宛名PSM.getJutonaiJusho();
            住所文字列.append(住所).append(番地);
        } else if (行政区と番地.getValue().equals(config)) {
            RString 行政区 = 宛名PSM.getGyoseikuName();
            住所文字列.append(行政区).append(番地);
        } else if (地区名1と番地.getValue().equals(config)) {
            RString 地区名1 = 宛名PSM.getChikuName1();
            住所文字列.append(地区名1).append(番地);
        }

        source.jusho1 = getSubstring(住所文字列.toRString(), 0, 住所分割_20);
        source.jusho2 = getSubstring(住所文字列.toRString(), 住所分割_20, 住所分割_40);
        source.jusho3 = getSubstring(住所文字列.toRString(), 住所分割_40, 住所分割_60);
    }

    private void setカナ氏名(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        AtenaKanaMeisho カナ氏名 = 宛名PSM.getKanaMeisho();
        if (null != カナ氏名) {
            if (項目map.get(項目_カナ氏名1) < カナ氏名.value().length()) {
                source.shimeiKana2 = カナ氏名.value();
            } else {
                source.shimeiKana1 = カナ氏名.value();
            }
        }
    }

    private void set氏名(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        AtenaMeisho 氏名 = 宛名PSM.getMeisho();
        if (null != 氏名) {
            if (氏名.value().length() < 項目map.get(項目_氏名1) + 1) {
                source.shimei1 = 氏名.value();
            } else if (氏名.value().length() < 項目map.get(項目_氏名3) + 1) {
                source.shimei3 = 氏名.value();
            } else {
                source.shimei2 = getSubstring(氏名.value(), 0, 項目map.get(項目_氏名2));
                source.shimei3 = getSubstring(氏名.value(), 項目map.get(項目_氏名2), 氏名.value().length());
            }
        }
    }

    private void set生年月日(EikyuMeiboSource source) {
        FlexibleDate 生年月日 = 宛名PSM.getSeinengappiYMD();
        if (null != 生年月日) {
            if (外国人.getCode().equals(宛名PSM.getJuminShubetsuCode())) {
                source.seinengappi = 生年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            } else {
                source.seinengappi = 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
        }
    }

    private void set性別(EikyuMeiboSource source) {
        source.seibetsu = Gender.toValue(宛名PSM.getSeibetsuCode()).getCommonName();
    }

    private void set住民票作成日転入届出日(EikyuMeiboSource source) {
        FlexibleDate 登録届出年月日 = 宛名PSM.getTorokuTodokedeYMD();
        source.tennyuTodokeYmd = null == 登録届出年月日 ? RString.EMPTY : 登録届出年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void set投票区(EikyuMeiboSource source) {
        source.tohyokuCode = item.getSenkyoninMeiboEntity().getTohyokuCode();
    }

    private void set地区_行政区名称(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        RString 地区名 = RString.EMPTY;
        RString config = BusinessConfig.get(EikyuMeiboInjiNaiyoConfig.永久名簿_印字内容_地区行政区名, SubGyomuCode.AFA選挙本体);
        if (空欄.getValue().equals(config)) {
            source.chikuMeisho = RString.EMPTY;
        } else if (住所.getValue().equals(config)) {
            source.chikuMeisho = EikyuMeiboInjiNaiyoConfig.住所.getKey();
            地区名 = 宛名PSM.getJutonaiJusho();
        } else if (行政区.getValue().equals(config)) {
            source.chikuMeisho = EikyuMeiboInjiNaiyoConfig.行政区.getKey();
            地区名 = 宛名PSM.getGyoseikuName();
        } else if (地区コード1.getValue().equals(config)) {
            source.chikuMeisho = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
            地区名 = 宛名PSM.getChikuName1();
        }
        if (null != 地区名) {
            if (項目map.get(項目_地区名1) < (地区名.length())) {
                source.chikuMei2 = getSubstring(地区名, 0, 項目map.get(項目_地区名2));
                source.chikuMei3 = getSubstring(地区名, 項目map.get(項目_地区名2), 地区名.length());
            } else {
                source.chikuMei1 = 地区名;
            }
        }
    }

    private void set登録年月日(EikyuMeiboSource source) {
        FlexibleDate date = item.getSenkyoShikakuEntity().getMeiboTorokuYMD();
        if (null != date) {
            source.torokuYmd = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void set世帯主名(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        AtenaMeisho 世帯主名 = 宛名PSM.getSetainushiMei();
        if (null != 世帯主名) {
            if (世帯主名.value().length() < 項目map.get(項目_世帯主名1) + 1) {
                source.setainushiMei1 = 世帯主名.value();
            } else if (世帯主名.value().length() < 項目map.get(項目_世帯主名3) + 1) {
                source.setainushiMei3 = 世帯主名.value();
            } else {
                source.setainushiMei2 = getSubstring(世帯主名.value(), 0, 項目map.get(項目_世帯主名2));
                source.setainushiMei3 = getSubstring(世帯主名.value(), 項目map.get(項目_世帯主名2), 世帯主名.value().length());
            }
        }
    }

    private void set続柄(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        RString 続柄 = 宛名PSM.getTsuzukigara();
        if (null != 続柄) {
            if (続柄.length() < 項目map.get(項目_続柄1) + 1) {
                source.zokugara1 = 続柄;
            } else if (続柄.length() < 項目map.get(項目_続柄3) + 1) {
                source.zokugara3 = 続柄;
            } else {
                source.zokugara2 = getSubstring(続柄, 0, 項目map.get(項目_続柄2));
                source.zokugara3 = getSubstring(続柄, 項目map.get(項目_続柄2), 続柄.length());
            }
        }
    }

    private void set住所コード(EikyuMeiboSource source) {
        ChoikiCode 住登内町域コード = 宛名PSM.getJutonaiChoikiCode();
        source.jushoCode = null == 住登内町域コード ? RString.EMPTY : 住登内町域コード.value();
    }

    private void set行政区コード(EikyuMeiboSource source) {
        GyoseikuCode 行政区コード = 宛名PSM.getGyoseikuCode();
        source.gyoseikuCode = null == 行政区コード ? RString.EMPTY : 行政区コード.value();
    }

    private void setコード1(EikyuMeiboSource source) {
        RString config = BusinessConfig.get(EikyuMeiboInjiNaiyoConfig.永久名簿_印字内容_コード欄1, SubGyomuCode.AFA選挙本体);
        if (世帯.getValue().equals(config)) {
            SetaiCode 世帯コード = 宛名PSM.getSetaiCode();
            source.code1 = null == 世帯コード ? RString.EMPTY : 世帯コード.value();
            source.codeMei1 = 世帯.getKey();
        } else if (識別コード.getValue().equals(config)) {
            ShikibetsuCode 識別code = 宛名PSM.getShikibetsuCode();
            source.code1 = null == 識別code ? RString.EMPTY : 識別code.value();
            source.codeMei1 = 識別コード.getKey();
        } else if (地区1.getValue().equals(config)) {
            ChikuCode 地区コード2 = 宛名PSM.getChikuCode1();
            source.code1 = null == 地区コード2 ? RString.EMPTY : 地区コード2.value();
            source.codeMei1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        } else if (地区2.getValue().equals(config)) {
            ChikuCode 地区コード2 = 宛名PSM.getChikuCode2();
            source.code1 = null == 地区コード2 ? RString.EMPTY : 地区コード2.value();
            source.codeMei1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        } else if (地区3.getValue().equals(config)) {
            ChikuCode 地区コード3 = 宛名PSM.getChikuCode3();
            source.code1 = null == 地区コード3 ? RString.EMPTY : 地区コード3.value();
            source.codeMei1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        } else {
            source.chikuMeisho = RString.EMPTY;
        }
    }

    private void setコード2(EikyuMeiboSource source) {
        RString config = BusinessConfig.get(EikyuMeiboInjiNaiyoConfig.永久名簿_印字内容_コード欄2, SubGyomuCode.AFA選挙本体);
        if (世帯.getValue().equals(config)) {
            SetaiCode 世帯コード = 宛名PSM.getSetaiCode();
            source.code2 = null == 世帯コード ? RString.EMPTY : 世帯コード.value();
            source.codeMei2 = 世帯.getKey();
        } else if (識別コード.getValue().equals(config)) {
            ShikibetsuCode 識別code = 宛名PSM.getShikibetsuCode();
            source.code2 = null == 識別code ? RString.EMPTY : 識別code.value();
            source.codeMei2 = 識別コード.getKey();
        } else if (地区1.getValue().equals(config)) {
            ChikuCode 地区コード2 = 宛名PSM.getChikuCode1();
            source.code2 = null == 地区コード2 ? RString.EMPTY : 地区コード2.value();
            source.codeMei2 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        } else if (地区2.getValue().equals(config)) {
            ChikuCode 地区コード2 = 宛名PSM.getChikuCode2();
            source.code2 = null == 地区コード2 ? RString.EMPTY : 地区コード2.value();
            source.codeMei2 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        } else if (地区3.getValue().equals(config)) {
            ChikuCode 地区コード3 = 宛名PSM.getChikuCode3();
            source.code2 = null == 地区コード3 ? RString.EMPTY : 地区コード3.value();
            source.codeMei2 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        } else {
            source.chikuMeisho = RString.EMPTY;
        }
    }

    private void set表示理由(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        Code 表示事由コード = item.getSenkyoShikakuEntity().getHyojiJiyuCode();
        RString 表示理由 = RString.EMPTY;
        if (null != 表示事由コード) {
            表示理由 = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, new CodeShubetsu("6210"), 表示事由コード);
        }
        if (表示理由.length() < 項目map.get(項目_表示理由1) + 1) {
            source.hyojiRiyu1 = 表示理由;
        } else {
            source.hyojiRiyu2 = 表示理由;
        }
    }

    private void set表示年月日(EikyuMeiboSource source) {
        FlexibleDate date = item.getSenkyoShikakuEntity().getHyojiYMD();
        if (null != date) {
            source.hyojiYmd = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void set抹消理由(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        Code 抹消事由コード = item.getSenkyoShikakuEntity().getMasshoJiyuCode();
        RString 抹消理由 = RString.EMPTY;
        if (null != 抹消事由コード) {
            抹消理由 = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, new CodeShubetsu("7010"), 抹消事由コード);
        }
        if (抹消理由.length() < 項目map.get(項目_抹消理由1) + 1) {
            source.masshoRiyu1 = 抹消理由;
        } else {
            source.masshoRiyu2 = 抹消理由;
        }
    }

    private void set抹消年月日(EikyuMeiboSource source) {
        FlexibleDate date = item.getSenkyoShikakuEntity().getMasshoYMD();
        if (null != date) {
            source.masshoYmd = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void set転入前住所(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        RStringBuilder 転入前住所文字列 = new RStringBuilder();
        AtenaJusho 転入前住所 = 宛名PSM.getTennyumaeJusho();
        if (null != 転入前住所) {
            転入前住所文字列.append(転入前住所);
        }
        AtenaBanchi 転入前番地 = 宛名PSM.getTennyumaeBanchi();
        if (null != 転入前番地) {
            転入前住所文字列.append(転入前番地);
        }
        RString 文字列 = 転入前住所文字列.toRString();
        if (文字列.length() < 項目map.get(項目_従前の住所1) + 項目map.get(項目_従前の住所2) + 1) {
            source.zenJusho1 = getSubstring(文字列, 0, 項目map.get(項目_従前の住所1));
            source.zenJusho2 = getSubstring(文字列, 項目map.get(項目_従前の住所1), 文字列.length());
        } else {
            source.zenJusho3 = getSubstring(文字列, 0, 項目map.get(項目_従前の住所3));
            source.zenJusho4 = getSubstring(文字列, 項目map.get(項目_従前の住所3), 項目map.get(項目_従前の住所3) + 項目map.get(項目_従前の住所4));
            source.zenJusho5 = getSubstring(文字列, 項目map.get(項目_従前の住所3) + 項目map.get(項目_従前の住所4),
                    項目map.get(項目_従前の住所3) + 項目map.get(項目_従前の住所4) + 項目map.get(項目_従前の住所5));
        }

    }

    private RString getSubstring(RString str, int begin, int end) {
        if (str.length() < end) {
            end = str.length();
        }
        if (begin < end) {
            return str.substring(begin, end);
        } else {
            return RString.EMPTY;
        }
    }

    private void set転出先住所(EikyuMeiboSource source, Map<RString, Integer> 項目map) {
        if (転出者.コード().equals(宛名PSM.getJuminJotaiCode())) {
            RStringBuilder 転出先住所文字列 = new RStringBuilder();
            AtenaJusho 転出先住所 = 宛名PSM.getJusho();
            if (null != 転出先住所) {
                転出先住所文字列.append(転出先住所);
            }
            AtenaBanchi 転出先番地 = 宛名PSM.getBanchi();
            if (null != 転出先番地) {
                転出先住所文字列.append(転出先番地);
            }
            RString 文字列 = 転出先住所文字列.toRString();
            if (文字列.length() < 項目map.get(項目_転出先住所1) + 項目map.get(項目_転出先住所2) + 1) {
                source.sakiJusho1 = getSubstring(文字列, 0, 項目map.get(項目_転出先住所1));
                source.sakiJusho2 = getSubstring(文字列, 項目map.get(項目_転出先住所1), 文字列.length());
            } else {
                source.sakiJusho3 = getSubstring(文字列, 0, 項目map.get(項目_転出先住所3));
                source.sakiJusho4 = getSubstring(文字列, 項目map.get(項目_転出先住所3),
                        項目map.get(項目_転出先住所3) + 項目map.get(項目_転出先住所4));
                source.sakiJusho5 = getSubstring(文字列, 項目map.get(項目_転出先住所3) + 項目map.get(項目_転出先住所4), 文字列.length());
            }
        }
    }

    private Map<RString, Integer> get項目lengthMap(EikyuMeiboSource source) {
        Map<RString, Integer> map = new HashMap<>();
        try {
            map.put(項目_氏名1, source.getClass()
                    .getDeclaredField(項目_氏名1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_氏名2, source.getClass()
                    .getDeclaredField(項目_氏名2.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_氏名3, source.getClass()
                    .getDeclaredField(項目_氏名3.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_カナ氏名1, source.getClass()
                    .getDeclaredField(項目_カナ氏名1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_地区名1, source.getClass()
                    .getDeclaredField(項目_地区名1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_地区名2, source.getClass()
                    .getDeclaredField(項目_地区名2.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_地区名3, source.getClass()
                    .getDeclaredField(項目_地区名3.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_続柄1, source.getClass()
                    .getDeclaredField(項目_続柄1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_続柄2, source.getClass()
                    .getDeclaredField(項目_続柄2.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_続柄3, source.getClass()
                    .getDeclaredField(項目_続柄3.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_世帯主名1, source.getClass()
                    .getDeclaredField(項目_世帯主名1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_世帯主名2, source.getClass()
                    .getDeclaredField(項目_世帯主名2.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_世帯主名3, source.getClass()
                    .getDeclaredField(項目_世帯主名3.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_表示理由1, source.getClass()
                    .getDeclaredField(項目_表示理由1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_抹消理由1, source.getClass()
                    .getDeclaredField(項目_抹消理由1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_従前の住所1, source.getClass()
                    .getDeclaredField(項目_従前の住所1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_従前の住所2, source.getClass()
                    .getDeclaredField(項目_従前の住所2.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_従前の住所3, source.getClass()
                    .getDeclaredField(項目_従前の住所3.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_従前の住所4, source.getClass()
                    .getDeclaredField(項目_従前の住所4.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_従前の住所5, source.getClass()
                    .getDeclaredField(項目_従前の住所5.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_転出先住所1, source.getClass()
                    .getDeclaredField(項目_転出先住所1.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_転出先住所2, source.getClass()
                    .getDeclaredField(項目_転出先住所2.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_転出先住所3, source.getClass()
                    .getDeclaredField(項目_転出先住所3.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_転出先住所4, source.getClass()
                    .getDeclaredField(項目_転出先住所4.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_転出先住所5, source.getClass()
                    .getDeclaredField(項目_転出先住所5.toString()).getAnnotation(ReportItem.class).length());

        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(EikyuMeiboEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
}
