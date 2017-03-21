/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE202;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE202.LabelSealSource;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link LabelSealSource}を編集します。
 *
 * @reamsid_L AF-0070-021 liss
 */
public class LabelSealEditor implements ILabelSealEditor {

    private final LabelSealParam item;
    private static final int 印字内容１ = 0;
    private static final int 印字内容２ = 1;
    private static final int 印字内容３ = 2;
    private static final int 印字内容４ = 3;
    private static final int 印字内容５ = 4;
    private static final int 抄本番号桁数 = 4;
    private static final RString コンフィグ値_00 = new RString("00");
    private static final RString コンフィグ値_01 = new RString("01");
    private static final RString コンフィグ値_02 = new RString("02");
    private static final RString コンフィグ値_03 = new RString("03");
    private static final RString コンフィグ値_04 = new RString("04");
    private static final RString コンフィグ値_05 = new RString("05");
    private static final RString コンフィグ値_06 = new RString("06");
    private static final RString コンフィグ値_07 = new RString("07");
    private static final RString コンフィグ値_08 = new RString("08");
    private static final RString コンフィグ値_09 = new RString("09");
    private static final RString コンフィグ値_10 = new RString("10");
    private static final RString コンフィグ値_11 = new RString("11");
    private static final RString コンフィグ値_12 = new RString("12");
    private static final RString コンフィグ値_13 = new RString("13");
    private static final RString コンフィグ値_14 = new RString("14");
    private static final RString コンフィグ値_15 = new RString("15");
    private static final RString コンフィグ値_16 = new RString("16");
    private static final RString コンフィグ値_17 = new RString("17");
    private static final RString コンフィグ値_18 = new RString("18");
    private static final RString コンフィグ値_19 = new RString("19");
    private static final RString コンフィグ値_20 = new RString("20");
    private static final RString コンフィグ値_21 = new RString("21");
    private static final RString コンフィグ値_22 = new RString("22");
    private static final RString コンフィグ値_23 = new RString("23");
    private static final RString コンフィグ値_24 = new RString("24");
    private static final RString コンフィグ値_25 = new RString("25");
    private static final RString コンフィグ値_26 = new RString("26");
    private static final RString コンフィグ値_27 = new RString("27");
    private static final RString 抹消者標識 = new RString("非");
    private static final RString 表示者標識 = new RString("表");
    private static final RString 公民権停止者標識 = new RString("停");
    private static final RString 連結標識 = new RString("-");
    private static final RString コロン = new RString("：");
    private static final RString シール_宣誓書貼付用 = new RString("宣誓書貼付用");
    private static final RString シール_封筒貼付用 = new RString("封筒貼付用");
    private static final RString シール_抄本貼付用 = new RString("抄本貼付用");
    private static final RString シール_入場券貼付用 = new RString("入場券貼付用");
    private static final RString バーコード印字有 = new RString("1");
    private static final int 選挙１ = 0;
    private static final int 選挙２ = 1;
    private static final int 選挙３ = 2;
    private static final int 選挙４ = 3;
    private static final int 選挙５ = 4;
    private static final int 選挙６ = 5;
    private static final int 選挙７ = 6;
    private static final int 選挙８ = 7;
    private static final int 選挙９ = 8;
    private static final int 選挙１０ = 9;

    private static final int 八文字 = 8;
    private static final int 七文字 = 7;

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link LabelSealParam}
     */
    public LabelSealEditor(LabelSealParam item) {
        this.item = item;
    }

    @Override
    public LabelSealSource edit(LabelSealSource source) {
        RString シール種別 = item.getシール種別();

        AfT111SenkyoEntity senkyoEntity = null;
        AfT201TohyoJokyoEntity tohyoJokyoEntity = null;
        RString 施設種別コード名称 = RString.EMPTY;
        RString 施設名称 = RString.EMPTY;

        for (AfT111SenkyoEntity senkyo : item.get選挙人資格情報().getSenkyoJohoEntity().getSenkyoEntity()) {
            if (senkyo.getSenkyoNo().getColumnValue() == item.get選挙Index()) {
                senkyoEntity = senkyo;
                break;
            }
        }

        List<AfT201TohyoJokyoEntity> tohyoJokyoEntityList = item.get選挙人資格情報().getTohyoJokyoEntityList();
        for (int i = 0; i < tohyoJokyoEntityList.size(); i++) {
            if (tohyoJokyoEntityList.get(i).getSenkyoNo().getColumnValue() == item.get選挙Index()) {
                tohyoJokyoEntity = tohyoJokyoEntityList.get(i);
                施設種別コード名称 = item.get施設種別コード名称リスト().get(i);
                施設名称 = item.get施設名称リスト().get(i);
                break;
            }
        }

        if (シール_宣誓書貼付用.equals(シール種別) || シール_封筒貼付用.equals(シール種別) || シール_入場券貼付用.equals(シール種別)) {
            editタイトルと内容(source, シール種別, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        } else if (シール_抄本貼付用.equals(シール種別)) {
            edit抄本貼付用内容(source);
        }
        editコード(source, シール種別, senkyoEntity);
        AtenaKanaMeisho kanaMeisho = item.get選挙人資格情報().getAtenaPSMEntity().getKanaMeisho();
        if (kanaMeisho == null) {
            source.kanaMeisho = RString.EMPTY;
        } else {
            source.kanaMeisho = kanaMeisho.value();
        }
        editログの出力(source);

        return source;
    }

    private void editタイトルと内容(LabelSealSource source,
            RString シール種別,
            AfT111SenkyoEntity senkyoEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity,
            RString 施設種別コード名称,
            RString 施設名称) {
        RString 印字内容 = RString.EMPTY;
        if (シール_宣誓書貼付用.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_印字内容, SubGyomuCode.AFA選挙本体);
        } else if (シール_封筒貼付用.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_印字内容, SubGyomuCode.AFA選挙本体);
        } else if (シール_入場券貼付用.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_印字内容, SubGyomuCode.AFA選挙本体);
        }
        List<RString> 印字内容List = 印字内容.split(",");
        RString コンフィグ値1 = 印字内容List.get(印字内容１);
        RString コンフィグ値2 = 印字内容List.get(印字内容２);
        RString コンフィグ値3 = 印字内容List.get(印字内容３);
        RString コンフィグ値4 = 印字内容List.get(印字内容４);
        RString コンフィグ値5 = 印字内容List.get(印字内容５);
        List<RString> 印字内容1 = getタイトルByコンフィグ値(コンフィグ値1, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容2 = getタイトルByコンフィグ値(コンフィグ値2, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容3 = getタイトルByコンフィグ値(コンフィグ値3, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容4 = getタイトルByコンフィグ値(コンフィグ値4, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容5 = getタイトルByコンフィグ値(コンフィグ値5, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        source.title1 = 印字内容1.get(印字内容１);
        source.title2 = 印字内容2.get(印字内容１);
        source.title3 = 印字内容3.get(印字内容１);
        source.title4 = 印字内容4.get(印字内容１);
        source.title5 = 印字内容5.get(印字内容１);
        source.naiyo1 = 印字内容1.get(印字内容２);
        source.naiyo2 = 印字内容2.get(印字内容２);
        source.naiyo3 = 印字内容3.get(印字内容２);
        source.naiyo4 = 印字内容4.get(印字内容２);
        source.naiyo5 = 印字内容5.get(印字内容２);
        source.shoNaiyo1 = RString.EMPTY;
        source.shoNaiyo2 = RString.EMPTY;
        source.shoNaiyo3 = RString.EMPTY;
        source.shoNaiyo4 = RString.EMPTY;
        source.shoNaiyo5 = RString.EMPTY;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private List<RString> getタイトルByコンフィグ値(RString コンフィグ値,
            AfT111SenkyoEntity senkyoEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity,
            RString 施設種別コード名称,
            RString 施設名称) {
        List<RString> 結果リスト = new ArrayList<>();
        RString 頁 = new RString(item.get選挙人資格情報().getSenkyoninMeiboEntity().getPage());
        RString 行 = new RString(item.get選挙人資格情報().getSenkyoninMeiboEntity().getGyo());
        RString 性別 = new SeibetsuCode(item.get選挙人資格情報().getAtenaPSMEntity().getSeibetsuCode()).value().getCommonName();
        RString 名称 = RString.EMPTY;
        RString 投票事由コード = RString.EMPTY;
        AtenaMeisho meisho = item.get選挙人資格情報().getAtenaPSMEntity().getMeisho();
        RString tohyokuCode = item.get選挙人資格情報().getSenkyoShikakuEntity().getTohyokuCode();
        Code tohyoJiyuCode = tohyoJokyoEntity == null ? null : tohyoJokyoEntity.getTohyoJiyuCode();
        if (tohyoJiyuCode != null) {
            投票事由コード = tohyoJiyuCode.getKey();
        }
        if (tohyokuCode == null) {
            tohyokuCode = RString.EMPTY;
        }
        if (meisho != null) {
            名称 = meisho.value();
        }
        if (コンフィグ値_00.equals(コンフィグ値)) {
            結果リスト.add(RString.EMPTY);
            結果リスト.add(RString.EMPTY);
        } else if (コンフィグ値_01.equals(コンフィグ値)) {
            結果リスト.add(new RString("投票区名　："));
            結果リスト.add(item.get選挙人資格情報().getSenkyoShikakuEntity().getTohyokuCode());
        } else if (コンフィグ値_02.equals(コンフィグ値)) {
            結果リスト.add(new RString("登録番号　："));
            結果リスト.add(get標識().concat(頁).concat(連結標識).concat(行));
        } else if (コンフィグ値_03.equals(コンフィグ値)) {
            結果リスト.add(new RString("登録番号　："));
            結果リスト.add(tohyokuCode.concat(連結標識).concat(get標識())
                    .concat(頁).concat(連結標識).concat(行));
        } else if (コンフィグ値_04.equals(コンフィグ値)) {
            結果リスト.add(new RString("名簿番号　："));
            結果リスト.add(tohyokuCode.concat(連結標識).concat(頁).concat(連結標識).concat(行));
        } else if (コンフィグ値_05.equals(コンフィグ値)) {
            結果リスト.add(new RString("行政区　　："));
            結果リスト.add(item.get選挙人資格情報().getAtenaPSMEntity().getGyoseikuName());
        } else if (コンフィグ値_06.equals(コンフィグ値)) {
            結果リスト.add(new RString("住所コード："));
            ChoikiCode code = item.get選挙人資格情報().getAtenaPSMEntity().getJutonaiChoikiCode();
            if (code != null) {
                結果リスト.add(code.value());
            } else {
                結果リスト.add(RString.EMPTY);
            }
        } else if (コンフィグ値_07.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(コロン));
            結果リスト.add(item.get選挙人資格情報().getAtenaPSMEntity().getChikuName1());
        } else if (コンフィグ値_08.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２).concat(コロン));
            結果リスト.add(item.get選挙人資格情報().getAtenaPSMEntity().getChikuName2());
        } else if (コンフィグ値_09.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３).concat(コロン));
            結果リスト.add(item.get選挙人資格情報().getAtenaPSMEntity().getChikuName3());
        } else if (コンフィグ値_10.equals(コンフィグ値)) {
            結果リスト.add(new RString("識別コード："));
            ShikibetsuCode 識別コード = item.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            if (識別コード != null) {
                結果リスト.add(識別コード.value());
            } else {
                結果リスト.add(RString.EMPTY);
            }
        } else if (コンフィグ値_11.equals(コンフィグ値)) {
            結果リスト.add(new RString("世帯コード："));
            SetaiCode 世帯コード = item.get選挙人資格情報().getAtenaPSMEntity().getSetaiCode();
            if (世帯コード != null) {
                結果リスト.add(世帯コード.value());
            } else {
                結果リスト.add(RString.EMPTY);
            }
        } else if (コンフィグ値_12.equals(コンフィグ値)) {
            結果リスト.add(new RString("性別　　　："));
            結果リスト.add(性別);

        } else if (コンフィグ値_13.equals(コンフィグ値)) {
            結果リスト.add(new RString("生年月日　："));
            FlexibleDate seinengappiYMD = item.get選挙人資格情報().getAtenaPSMEntity().getSeinengappiYMD();
            if (seinengappiYMD != null) {
                結果リスト.add(seinengappiYMD.wareki().toDateString());
            }
        } else if (コンフィグ値_14.equals(コンフィグ値)) {
            結果リスト.add(new RString("氏　　名　："));
            結果リスト.add(名称);
        } else if (コンフィグ値_15.equals(コンフィグ値)) {
            結果リスト.add(new RString("受付番号　："));
            Integer uketsukeNo = tohyoJokyoEntity == null ? null : tohyoJokyoEntity.getUketsukeNo();
            結果リスト.add(uketsukeNo == null ? RString.EMPTY : new RString(uketsukeNo));
        } else if (コンフィグ値_16.equals(コンフィグ値)) {
            結果リスト.add(new RString("氏　　名　："));
            結果リスト.add(名称.trimEnd().padRight(RString.FULL_SPACE, 八文字).substring(0, 八文字)
                    .concat(RString.FULL_SPACE)
                    .concat(RStringUtil.convert半角to全角(投票事由コード)));
        } else if (コンフィグ値_17.equals(コンフィグ値)) {
            結果リスト.add(new RString("氏　　名　："));
            結果リスト.add(名称.trimEnd().padRight(RString.FULL_SPACE, 七文字).substring(0, 七文字)
                    .concat(RString.HALF_SPACE)
                    .concat(性別)
                    .concat(RString.HALF_SPACE)
                    .concat(RStringUtil.convert半角to全角(投票事由コード)));
        } else if (コンフィグ値_18.equals(コンフィグ値)) {
            結果リスト.add(new RString("選挙名称　："));
            結果リスト.add(senkyoEntity == null ? RString.EMPTY : senkyoEntity.getSenkyoName());
        } else if (コンフィグ値_19.equals(コンフィグ値)) {
            結果リスト.add(new RString("選挙略称　："));
            結果リスト.add(senkyoEntity == null ? RString.EMPTY : senkyoEntity.getSenkyoRyakusho());
        } else if (コンフィグ値_20.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求年月日："));
            FlexibleDate seikyuYMD = tohyoJokyoEntity == null ? null : tohyoJokyoEntity.getSeikyuYMD();
            if (seikyuYMD != null) {
                結果リスト.add(seikyuYMD.wareki().toDateString());
            }
        } else if (コンフィグ値_21.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求方法　："));
            結果リスト.add(tohyoJokyoEntity == null ? RString.EMPTY : tohyoJokyoEntity.getSeikyuHohoMeisho());
        } else if (コンフィグ値_22.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求事由　："));
            結果リスト.add(tohyoJokyoEntity == null ? RString.EMPTY : tohyoJokyoEntity.getTohyoJiyuCodeRyakusho());
        } else if (コンフィグ値_23.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付年月日："));
            FlexibleDate kofuYMD = tohyoJokyoEntity == null ? null : tohyoJokyoEntity.getKofuYMD();
            if (kofuYMD != null) {
                結果リスト.add(kofuYMD.wareki().toDateString());
            }
        } else if (コンフィグ値_24.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付区分　："));
            結果リスト.add(施設種別コード名称);
        } else if (コンフィグ値_25.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付方法　："));
            結果リスト.add(tohyoJokyoEntity == null ? RString.EMPTY : tohyoJokyoEntity.getKofuHohoMeisho());
        } else if (コンフィグ値_26.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付施設　："));
            結果リスト.add(施設名称);
        } else if (コンフィグ値_27.equals(コンフィグ値)) {
            結果リスト.add(new RString("市区町村名："));
            結果リスト.add(item.get帳票共通ヘッダー().get市町村名());
        }

        return 結果リスト;
    }

    private RString get標識() {
        Code 選挙資格区分 = item.get選挙人資格情報().getSenkyoShikakuEntity().getShikakuKubun();
        if (new Code(SennkyoSikakuKubun.抹消者.value()).equals(選挙資格区分)
                || new Code(SennkyoSikakuKubun.資格なし.value()).equals(選挙資格区分)) {
            return 抹消者標識;
        } else if (new Code(SennkyoSikakuKubun.表示者.value()).equals(選挙資格区分)) {
            return 表示者標識;
        } else if (new Code(SennkyoSikakuKubun.公民権停止.value()).equals(選挙資格区分)) {
            return 公民権停止者標識;
        } else {
            return RString.EMPTY;
        }
    }

    private void edit抄本貼付用内容(LabelSealSource source) {
        source.title1 = RString.EMPTY;
        source.title2 = RString.EMPTY;
        source.title3 = RString.EMPTY;
        source.title4 = RString.EMPTY;
        source.title5 = RString.EMPTY;
        source.naiyo1 = RString.EMPTY;
        source.naiyo2 = RString.EMPTY;
        source.naiyo3 = RString.EMPTY;
        source.naiyo4 = RString.EMPTY;
        source.naiyo5 = RString.EMPTY;
        AtenaMeisho meisho = item.get選挙人資格情報().getAtenaPSMEntity().getMeisho();
        if (meisho != null) {
            source.shoNaiyo1 = meisho.value();
        }
        List<RString> 選挙マークリスト = item.get選挙マークリスト();
        int 選挙マーク数 = 選挙マークリスト.size();

        switch (選挙マーク数) {
            case 選挙１:
                break;
            case 選挙２:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１);
                break;
            case 選挙３:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２);
                break;
            case 選挙４:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                break;
            case 選挙５:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                source.shoNaiyo3 = edit小_内容(選挙マークリスト, 選挙４);
                break;
            case 選挙６:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                source.shoNaiyo3 = edit小_内容(選挙マークリスト, 選挙４, 選挙５);
                break;
            case 選挙７:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                source.shoNaiyo3 = edit小_内容(選挙マークリスト, 選挙４, 選挙５, 選挙６);
                break;
            case 選挙８:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                source.shoNaiyo3 = edit小_内容(選挙マークリスト, 選挙４, 選挙５, 選挙６);
                source.shoNaiyo4 = edit小_内容(選挙マークリスト, 選挙７);
                break;
            case 選挙９:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                source.shoNaiyo3 = edit小_内容(選挙マークリスト, 選挙４, 選挙５, 選挙６);
                source.shoNaiyo4 = edit小_内容(選挙マークリスト, 選挙７, 選挙８);
                break;
            case 選挙１０:
                source.shoNaiyo2 = edit小_内容(選挙マークリスト, 選挙１, 選挙２, 選挙３);
                source.shoNaiyo3 = edit小_内容(選挙マークリスト, 選挙４, 選挙５, 選挙６);
                source.shoNaiyo4 = edit小_内容(選挙マークリスト, 選挙７, 選挙８, 選挙９);
                break;
            default:
        }
        source.barcodeBarcode = RString.EMPTY;
        source.code = RString.EMPTY;
    }

    private RString edit小_内容(List<RString> 選挙マークリスト, int index, int... indexs) {
        RString 小_内容 = 選挙マークリスト.get(index);
        for (int i : indexs) {
            小_内容 = 小_内容.concat(RString.HALF_SPACE).concat(選挙マークリスト.get(i));
        }
        return 小_内容;
    }

    private void editコード(LabelSealSource source, RString シール種別, AfT111SenkyoEntity senkyoEntity) {
        RString 印字有無 = RString.EMPTY;
        if (シール_宣誓書貼付用.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        } else if (シール_封筒貼付用.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        } else if (シール_入場券貼付用.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        }
        if (バーコード印字有.equals(印字有無)) {
            RString 識別コード = RString.EMPTY;
            ShikibetsuCode shikibetsuCode = item.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            if (shikibetsuCode != null) {
                識別コード = shikibetsuCode.value();
            }
            if (シール_封筒貼付用.equals(シール種別)) {
                source.barcodeBarcode = 識別コード.concat(new RString(item.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity().getShohonNo().value())
                        .padZeroToLeft(抄本番号桁数))
                        .concat(senkyoEntity == null ? RString.EMPTY : new RString(senkyoEntity.getSenkyoNo().value()));
            } else {
                source.barcodeBarcode = 識別コード.concat(new RString(item.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity().getShohonNo().value())
                        .padZeroToLeft(抄本番号桁数))
                        .concat(new RString(0));
            }
        } else {
            source.barcodeBarcode = RString.EMPTY;
        }
        source.code = source.barcodeBarcode;
    }

    private void editログの出力(LabelSealSource source) {
        source.識別コード1 = item.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
    }
}
