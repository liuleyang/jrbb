/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * メニューを表す列挙型です。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public enum AFAMenuId {

    /**
     * AFAGMG1010_国民投票時登録
     */
    AFAGMG1010_国民投票時登録("AFAGMG1010", "国民投票時登録"),
    /**
     * AFAGMK1010_海区漁業調整委員会委員選挙人名簿作成
     */
    AFAGMK1010_海区漁業調整委員会委員選挙人名簿作成("AFAGMK1010", "海区漁業調整委員会委員選挙人名簿作成"),
    /**
     * AFAGMK1030_海区漁業調整委員会委員選挙時登録
     */
    AFAGMK1030_海区漁業調整委員会委員選挙時登録("AFAGMK1030", "海区漁業調整委員会委員選挙時登録"),
    /**
     * AFAGMI1010_住民投票時登録
     */
    AFAGMI1010_住民投票時登録("AFAGMI1010", "住民投票時登録"),
    /**
     * AFAGML1010_財産区議会議員選挙時登録
     */
    AFAGML1010_財産区議会議員選挙時登録("AFAGML1010", "財産区議会議員選挙時登録"),
    /**
     * AFAGMM3010_各種マスタデータ出力
     */
    AFAGMM3010_各種マスタデータ出力("AFAGMM3010", "各種マスタデータ出力"),
    /**
     * AFAMNA1010_定時登録。
     */
    AFAMNA1010_定時登録("AFAMNA1010", "定時登録"),
    /**
     * AFAMNA1020_選挙人の投票区変更。
     */
    AFAMNA1020_選挙人の投票区変更("AFAMNA1020", "定時登録：選挙人の投票区変更"),
    /**
     * AFAMNA1030_帳票再発行。
     */
    AFAMNA1030_帳票再発行("AFAMNA1030", "帳票再発行"),
    /**
     * AFAMNA2010_定時登録。
     */
    AFAMNA2010_定時登録("AFAMNA2010", "定時登録"),
    /**
     * AFAMNB1010_選挙時登録。
     */
    AFAMNB1010_選挙時登録("AFAMNB1010", "国政選挙・地方選挙：選挙時登録"),
    /**
     * AFAMNB1020_選挙情報修正。
     */
    AFAMNB1020_選挙情報修正("AFAMNB1020", "国政選挙・地方選挙：選挙情報修正"),
    /**
     * AFAMNB1030_選挙人の投票区変更。
     */
    AFAMNB1030_選挙人の投票区変更("AFAMNB1030", "選挙人の投票区変更"),
    /**
     * AFAMNB1040_帳票再発行。
     */
    AFAMNB1040_帳票再発行("AFAMNB1040", "帳票再発行"),
    /**
     * AFAMNB2010_入場券発行（一括）。
     */
    AFAMNB2010_入場券発行一括("AFAMNB2010", "国政選挙・地方選挙の入場券発行（一括）"),
    /**
     * AFAMNB2020_入場券発行（個別）。
     */
    AFAMNB2020_入場券発行個別("AFAMNB2020", "国政選挙・地方選挙の入場券発行（個別）"),
    /**
     * AFAMNB3010_名簿登録。
     */
    AFAMNB3010_名簿登録("AFAMNB3010", "名簿登録"),
    /**
     * AFAMNB3020_証明書記載事項変更。
     */
    AFAMNB3020_証明書記載事項変更("AFAMNB3020", "証明書記載事項変更"),
    /**
     * AFAMNB3030_証明書再交付。
     */
    AFAMNB3030_証明書再交付("AFAMNB3030", "証明書再交付"),
    /**
     * AFAMNB3040_名簿抹消。
     */
    AFAMNB3040_名簿抹消("AFAMNB3040", "名簿抹消"),
    /**
     * AFAMNB3050_選挙人名簿修正。
     */
    AFAMNB3050_選挙人名簿修正("AFAMNB3050", "選挙人名簿修正"),
    /**
     * AFAMNB4010_選挙時登録。
     */
    AFAMNB4010_選挙時登録("AFAMNB4010", "シミュレーションの選挙時登録"),
    /**
     * AFAMNB4020_選挙情報修正。
     */
    AFAMNB4020_選挙情報修正("AFAMNB4020", "シミュレーション：選挙情報修正"),
    /**
     * AFAMNB4030_入場券発行（個別）。
     */
    AFAMNB4030_入場券発行個別("AFAMNB4030", "シミュレーション：入場券発行個別"),
    /**
     * AFAMNC1010_選挙人資格異動。
     */
    AFAMNC1010_選挙人資格異動("AFAMNC1010", "選挙人資格異動"),
    /**
     * AFAMNC2010_郵便等投票資格登録。
     */
    AFAMNC2010_郵便等投票資格登録("AFAMNC2010", "郵便等投票資格登録"),
    /**
     * AFAMNC2020_洋上投票資格登録。
     */
    AFAMNC2020_洋上投票資格登録("AFAMNC2020", "洋上投票資格登録"),
    /**
     * AFAMNC2030_南極投票資格登録。
     */
    AFAMNC2030_南極投票資格登録("AFAMNC2030", "南極投票資格登録"),
    /**
     * AFAMND1010_定時登録・選挙時登録。
     */
    AFAMND1010_定時登録選挙時登録("AFAMND1010", "定時登録・選挙時登録"),
    /**
     * AFAMND1020_国民投票。
     */
    AFAMND1020_国民投票("AFAMND1020", "国民投票"),
    /**
     * AFAMND1030_在外選挙。
     */
    AFAMND1030_在外選挙("AFAMND1030", "在外選挙"),
    /**
     * AFAMND1040_海区漁業調整委員会委員選挙。
     */
    AFAMND1040_海区漁業調整委員会委員選挙("AFAMND1040", "海区漁業調整委員会委員選挙"),
    /**
     * AFAMND2010_定時登録。
     */
    AFAMND2010_定時登録("AFAMND2010", "定時登録"),
    /**
     * AFAMND2020_選挙時登録。
     */
    AFAMND2020_選挙時登録("AFAMND2020", "照会の選挙時登録"),
    /**
     * AFAMND2030_国民投票。
     */
    AFAMND2030_国民投票("AFAMND2030", "国民投票"),
    /**
     * AFAMND2040_在外選挙。
     */
    AFAMND2040_在外選挙("AFAMND2040", "在外選挙"),
    /**
     * AFAMND2050_海区漁業調整委員会委員選挙。
     */
    AFAMND2050_海区漁業調整委員会委員選挙("AFAMND2050", "海区漁業調整委員会委員選挙"),
    /**
     * AFAMNE1010_期日前投票。
     */
    AFAMNE1010_期日前投票("AFAMNE1010", "期日前投票"),
    /**
     * AFAMNE1020_ラベルシール再印刷。
     */
    AFAMNE1020_ラベルシール再印刷("AFAMNE1020", "ラベルシール再印刷"),
    /**
     * AFAMNE2010_不在者投票用紙請求。
     */
    AFAMNE2010_不在者投票用紙請求("AFAMNE2010", "不在者投票用紙請求"),
    /**
     * AFAMNE2020_不在者投票用紙交付。
     */
    AFAMNE2020_不在者投票用紙交付("AFAMNE2020", "不在者投票用紙交付"),
    /**
     * AFAMNE2030_不在者投票用紙受理。
     */
    AFAMNE2030_不在者投票用紙受理("AFAMNE2030", "不在者投票用紙受理"),
    /**
     * AFAMNE2040_施設バーコード一括受理。
     */
    AFAMNE2040_施設バーコード一括受理("AFAMNE2040", "施設バーコード一括受理"),
    /**
     * AFAMNE2050_施設送付書発行。
     */
    AFAMNE2050_施設送付書発行("AFAMNE2050", "施設送付書発行"),
    /**
     * AFAMNE2060_ラベルシール再印刷。
     */
    AFAMNE2060_ラベルシール再印刷("AFAMNE2060", "ラベルシール再印刷"),
    /**
     * AFAMNE3010_当日投票。
     */
    AFAMNE3010_当日投票("AFAMNE3010", "当日投票"),
    /**
     * AFAMNE3020_当日投票録。
     */
    AFAMNE3020_当日投票録("AFAMNE3020", "当日投票録"),
    /**
     * AFAMNE4010_無投票入力。
     */
    AFAMNE4010_無投票入力("AFAMNE4010", "無投票入力"),
    /**
     * AFAMNE4020_バーコード一括当日投票入力。
     */
    AFAMNE4020_バーコード一括当日投票入力("AFAMNE4020", "バーコード一括当日投票入力"),
    /**
     * AFAMNE5010_立会人引継書。
     */
    AFAMNE5010_立会人引継書("AFAMNE5010", "立会人引継書"),
    /**
     * AFAMNE5020_投票録。
     */
    AFAMNE5020_投票録("AFAMNE5020", "投票録"),
    /**
     * AFAMNE5030_日報。
     */
    AFAMNE5030_日報("AFAMNE5030", "日報"),
    /**
     * AFAMNE5040_投票日前日関連帳票。
     */
    AFAMNE5040_投票日前日関連帳票("AFAMNE5040", "投票日前日関連帳票"),
    /**
     * AFAMNE5050_投票結果集計表。
     */
    AFAMNE5050_投票結果集計表("AFAMNE5050", "投票結果集計表"),
    /**
     * AFAMNE5060_投票用紙枚数管理。
     */
    AFAMNE5060_投票用紙枚数管理("AFAMNE5060", "投票用紙枚数管理"),
    /**
     * AFAMNE6010_選挙人宛名シール。
     */
    AFAMNE6010_選挙人宛名シール("AFAMNE6010", "選挙人宛名シール"),
    /**
     * AFAMNE6020_転出者宛名シール。
     */
    AFAMNE6020_転出者宛名シール("AFAMNE6020", "転出者宛名シール"),
    /**
     * AFAMNE6030_施設宛名シール。
     */
    AFAMNE6030_施設宛名シール("AFAMNE6030", "施設宛名シール"),
    /**
     * AFAMNE7010_期日前投票。
     */
    AFAMNE7010_期日前投票("AFAMNE7010", "期日前投票"),
    /**
     * AFAMNE7020_当日投票。
     */
    AFAMNE7020_当日投票("AFAMNE7020", "当日投票"),
    /**
     * AFAMNE8010_端末用データ作成。
     */
    AFAMNE8010_端末用データ作成("AFAMNE8010", "端末用データ作成"),
    /**
     * AFAMNE8030_端末データ取込。
     */
    AFAMNE8030_端末データ取込("AFAMNE8030", "端末データ取込"),
    /**
     * AFAMNF1010_名簿調製用連携ファイル作成。
     */
    AFAMNF1010_名簿調製用連携ファイル作成("AFAMNF1010", "名簿調製用連携ファイル作成"),
    /**
     * AFAMNF1020_裁判員候補者予定者取込。
     */
    AFAMNF1020_裁判員候補者予定者取込("AFAMNF1020", "裁判員候補者予定者取込"),
    /**
     * AFAMNG1010_国民投票時登録。
     */
    AFAMNG1010_国民投票時登録("AFAMNG1010", "国民投票時登録"),
    /**
     * AFAMNG1020_国民投票情報修正。
     */
    AFAMNG1020_国民投票情報修正("AFAMNG1020", "国民投票情報修正"),
    /**
     * AFAMNG1030_投票人資格異動。
     */
    AFAMNG1030_投票人資格異動("AFAMNG1030", "投票人資格異動"),
    /**
     * AFAMNG1040_投票人の投票区変更。
     */
    AFAMNG1040_投票人の投票区変更("AFAMNG1040", "投票人の投票区変更"),
    /**
     * AFAMNG1050_投票人名簿最新化。
     */
    AFAMNG1050_投票人名簿最新化("AFAMNG1050", "投票人名簿最新化"),
    /**
     * AFAMNG1060_帳票再発行。
     */
    AFAMNG1060_帳票再発行("AFAMNG1060", "帳票再発行"),
    /**
     * AFAMNG2010_入場券発行（一括）。
     */
    AFAMNG2010_入場券発行一括("AFAMNG2010", "国民投票の入場券発行（一括）"),
    /**
     * AFAMNG2020_入場券発行（個別）。
     */
    AFAMNG2020_入場券発行個別("AFAMNG2020", "国民投票の入場券発行（個別）"),
    /**
     * AFAMNG3010_名簿登録。
     */
    AFAMNG3010_名簿登録("AFAMNG3010", "名簿登録"),
    /**
     * AFAMNG3020_証明書記載事項変更。
     */
    AFAMNG3020_証明書記載事項変更("AFAMNG3020", "証明書記載事項変更"),
    /**
     * AFAMNG3030_証明書再交付。
     */
    AFAMNG3030_証明書再交付("AFAMNG3030", "証明書再交付"),
    /**
     * AFAMNG3040_名簿抹消。
     */
    AFAMNG3040_名簿抹消("AFAMNG3040", "名簿抹消"),
    /**
     * AFAMNG3050_投票人名簿修正。
     */
    AFAMNG3050_投票人名簿修正("AFAMNG3050", "投票人名簿修正"),
    /**
     * AFAMNH1010_直接請求時登録。
     */
    AFAMNH1010_直接請求時登録("AFAMNH1010", "直接請求時登録"),
    /**
     * AFAMNH1020_署名簿登録。
     */
    AFAMNH1020_署名簿登録("AFAMNH1020", "署名簿登録"),
    /**
     * AFAMNI1010_住民投票時登録。
     */
    AFAMNI1010_住民投票時登録("AFAMNI1010", "住民投票時登録"),
    /**
     * AFAMNI2010_入場券発行（一括）。
     */
    AFAMNI2010_入場券発行一括("AFAMNI2010", "住民投票の入場券発行（一括）"),
    /**
     * AFAMNI2020_入場券発行（個別）。
     */
    AFAMNI2020_入場券発行個別("AFAMNI2020", "住民投票の入場券発行（個別）"),
    /**
     * AFAMNK1010_選挙人当初登録。
     */
    AFAMNK1010_選挙人当初登録("AFAMNK1010", "選挙人当初登録"),
    /**
     * AFAMNK1020_選挙人の投票区変更。
     */
    AFAMNK1020_選挙人の投票区変更("AFAMNK1020", "海区漁業調整委員会委員選挙：選挙人の投票区変更"),
    /**
     * AFAMNK1030_選挙時登録。
     */
    AFAMNK1030_選挙時登録("AFAMNK1030", "海区漁業調整委員会委員選挙の選挙時登録"),
    /**
     * AFAMNK1040_選挙人名簿最新化。
     */
    AFAMNK1040_選挙人名簿最新化("AFAMNK1040", "選挙人名簿最新化"),
    /**
     * AFAMNK1050_選挙情報修正。
     */
    AFAMNK1050_選挙情報修正("AFAMNK1050", "海区漁業調整委員会委員選挙：選挙情報修正"),
    /**
     * AFAMNK1060_選挙人名簿登録。
     */
    AFAMNK1060_選挙人名簿登録("AFAMNK1060", "選挙人名簿登録"),
    /**
     * AFAMNK1070_選挙人名簿修正。
     */
    AFAMNK1070_選挙人名簿修正("AFAMNK1070", "選挙人名簿修正"),
    /**
     * AFAMNK1080_選挙人名簿削除。
     */
    AFAMNK1080_選挙人名簿削除("AFAMNK1080", "選挙人名簿削除"),
    /**
     * AFAMNK2010_入場券発行（一括）。
     */
    AFAMNK2010_入場券発行一括("AFAMNK2010", "海区漁業調整委員会委員選挙の入場券発行（一括）"),
    /**
     * AFAMNK2020_入場券発行（個別）。
     */
    AFAMNK2020_入場券発行個別("AFAMNK2020", "海区漁業調整委員会委員選挙の入場券発行（個別）"),
    /**
     * AFAMNL1010_選挙時登録。
     */
    AFAMNL1010_選挙時登録("AFAMNL1010", "財産区議会議員選挙の選挙時登録"),
    /**
     * AFAMNL2010_入場券発行（一括）。
     */
    AFAMNL2010_入場券発行一括("AFAMNL2010", "財産区議会議員選挙の入場券発行（一括）"),
    /**
     * AFAMNL2020_入場券発行（個別）。
     */
    AFAMNL2020_入場券発行個別("AFAMNL2020", "財産区議会議員選挙の入場券発行（個別）"),
    /**
     * AFAMNM1010_コンフィグ保守。
     */
    AFAMNM1010_コンフィグ保守("AFAMNM1010", "コンフィグ保守"),
    /**
     * AFAMNM1020_コードマスタ保守。
     */
    AFAMNM1020_コードマスタ保守("AFAMNM1020", "コードマスタ保守"),
    /**
     * AFAMNM1030_帳票出力条件保守。
     */
    AFAMNM1030_帳票出力条件保守("AFAMNM1030", "帳票出力条件保守"),
    /**
     * AFAMNM2011_投票区保守（憲法改正国民投票）。
     */
    AFAMNM2011_投票区保守憲法改正国民投票("AFAMNM2011", "投票区保守（憲法改正国民投票）"),
    /**
     * AFAMNM2012_投票区保守（海区漁業調整委員会委員選挙）。
     */
    AFAMNM2012_投票区保守海区漁業調整委員会委員選挙("AFAMNM2012", "投票区保守（海区漁業調整委員会委員選挙）"),
    /**
     * AFAMNM2013_投票区保守（財産区議会議員選挙）。
     */
    AFAMNM2013_投票区保守財産区議会議員選挙("AFAMNM2013", "投票区保守（財産区議会議員選挙）"),
    /**
     * AFAMNM2014_投票区保守（住民投票）。
     */
    AFAMNM2014_投票区保守住民投票("AFAMNM2014", "投票区保守（住民投票）"),
    /**
     * AFAMNM2020_投票所保守。
     */
    AFAMNM2020_投票所保守("AFAMNM2020", "投票所保守"),
    /**
     * AFAMNM2030_選挙区保守。
     */
    AFAMNM2030_選挙区保守("AFAMNM2030", "選挙区保守"),
    /**
     * AFAMNM2040_投票区投票所対応保守。
     */
    AFAMNM2040_投票区投票所対応保守("AFAMNM2040", "投票区投票所対応保守"),
    /**
     * AFAMNM2050_不在者投票管理施設保守。
     */
    AFAMNM2050_不在者投票管理施設保守("AFAMNM2050", "不在者投票管理施設保守"),
    /**
     * AFAMNM2060_投票補助者保守。
     */
    AFAMNM2060_投票補助者保守("AFAMNM2060", "投票補助者保守"),
    /**
     * AFAMNM2070_組合保守。
     */
    AFAMNM2070_組合保守("AFAMNM2070", "組合保守"),
    /**
     * AFAMNM2080_領事官保守。
     */
    AFAMNM2080_領事官保守("AFAMNM2080", "領事官保守"),
    /**
     * AFAMNM3010_各種マスタデータ出力。
     */
    AFAMNM3010_各種マスタデータ出力("AFAMNM3010", "各種マスタデータ出力"),
    /**
     * AFAMNM3020_同一人物調査。
     */
    AFAMNM3020_同一人物調査("AFAMNM3020", "同一人物調査"),
    /**
     * AFAMNM3030_汎用EUC出力。
     */
    AFAMNM3030_汎用EUC出力("AFAMNM3030", "汎用EUC出力");

    private final RString menuId;
    private final RString name;

    private AFAMenuId(String menuId, String name) {
        this.menuId = new RString(menuId);
        this.name = new RString(name);
    }

    /**
     * メニューIDを返します。
     *
     * @return メニューID
     */
    public RString menuId() {
        return this.menuId;
    }

    /**
     * メニューID名称を返します。
     *
     * @return メニューID名称
     */
    public RString menuName() {
        return this.name;
    }
}
