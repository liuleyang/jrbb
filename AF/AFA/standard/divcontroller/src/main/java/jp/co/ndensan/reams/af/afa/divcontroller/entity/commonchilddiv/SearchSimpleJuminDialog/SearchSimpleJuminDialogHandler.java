/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.juminkensaku.JuminKensaku;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.juminkensaku.JuminKensakuMapperParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SearchSimpleJoken;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SearchSimpleKekkaList;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * SearchSimpleJuminDialogHandler の操作を担当するクラスです。
 * <p>
 * このクラスを通してSearchSimpleJuminDialogDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0170-020 lis
 */
public class SearchSimpleJuminDialogHandler {

    private final SearchSimpleJuminDialogDiv div;
//    private final RString RST_0 = new RString("0");
//    private final RString RST_4 = new RString("4");
//    private final RString RST_1 = new RString("1");
//    private final RString RST_2 = new RString("2");
//    private final RString RST_3 = new RString("3");
//    private static final RString 全角スペース = new RString("　");
    private static final RString 横線 = new RString("-");
//    private static final RString 有権者 = new RString("有権者");
//    private static final RString 表示者 = new RString("表示者");
//    private static final RString 抹消者 = new RString("抹消者");
//    private static final RString 公民権停止者 = new RString("公民権停止者");
//    private static final RString 一号資格者 = new RString("1号資格者");
//    private static final RString 二号資格者 = new RString("2号資格者");
//    private static final RString 投票資格_郵便 = new RString("郵便");
//    private static final RString 投票資格_船員 = new RString("船員");
//    private static final RString 投票資格_南極 = new RString("南極");
    private static final int 空白埋めの２桁 = 2;
    private static final int 空白埋めの３桁 = 3;
    private static final int 空白埋めの６桁 = 6;

    /**
     * コンストラクタです。
     *
     * @param div 簡易版住民検索Div
     */
    public SearchSimpleJuminDialogHandler(SearchSimpleJuminDialogDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 簡易版住民検索Div
     * @return KojiKessaiShinseiPanelHandler
     */
    public static SearchSimpleJuminDialogHandler of(SearchSimpleJuminDialogDiv div) {
        return new SearchSimpleJuminDialogHandler(div);
    }

    /**
     * 初期フォーカスのメソッドです。
     *
     * @return フォーカス RString
     */
    public RString getFocusID() {
        if (AFAConfigKeysValue.検索画面_初期カーソル位置_生年月日.isEqual(ConfigKeysAFA.検索画面_初期カーソル位置)) {
            return div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().getControlIdOfSeinengappi();
        } else if (AFAConfigKeysValue.検索画面_初期カーソル位置_投票区コード.isEqual(ConfigKeysAFA.検索画面_初期カーソル位置)) {
            return div.getSearchSimpleJoken().getCcdTohyokuCode().getTxtTohyokuCode().getSelectControlID();
        } else {
            return div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().getControlIdOfAtenaMeisho();
        }
    }

    /**
     * 選挙資格と投票資格のチェックボックスを設定する。
     *
     * @param 渡された選挙種類 SenkyoShurui
     * @param menuID RString
     */
    public void set選挙資格と投票資格(SenkyoShurui 渡された選挙種類, RString menuID) {
        if (渡された選挙種類 == SenkyoShurui.憲法改正国民投票) {
            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
            List<KeyValueDataSource> keyList = new ArrayList<>();
            for (UzT0007CodeEntity entity : codeEntity) {
//                if (!RST_0.equals(entity.getコード().value())
//                        && !RST_4.equals(entity.getコード().value())) {
                if (!SennkyoSikakuKubun.資格なし.getKey().equals(entity.getコード().value())
                        && !SennkyoSikakuKubun.公民権停止.getKey().equals(entity.getコード().value())) {
                    keyList.add(new KeyValueDataSource(entity.getコード().value(), entity.getコード名称()));
                }
            }
            div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().setDataSource(keyList);
        } else {
            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
            List<KeyValueDataSource> keyList = new ArrayList<>();
            for (UzT0007CodeEntity entity : codeEntity) {
//                if (!RST_0.equals(entity.getコード().value())) {
                if (!SennkyoSikakuKubun.資格なし.getKey().equals(entity.getコード().value())) {
                    keyList.add(new KeyValueDataSource(entity.getコード().value(), entity.getコード名称()));
                }
            }
            div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().setDataSource(keyList);
        }

        if (AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId().equals(menuID)) {
            List<KeyValueDataSource> keyList = new ArrayList<>();
            List<RString> keys = new ArrayList<>();
//            keyList.add(new KeyValueDataSource(RST_1, 投票資格_船員));
            keyList.add(new KeyValueDataSource(TohyoShikakuShurui.投票資格種類_船員.getCode(), TohyoShikakuShurui.投票資格種類_船員.getValue()));
            div.getSearchSimpleJoken().getChkSearchTohyoShikaku().setDataSource(keyList);
//            keys.add(RST_1);
            keys.add(TohyoShikakuShurui.投票資格種類_船員.getCode());
            div.getSearchSimpleJoken().getChkSearchTohyoShikaku().setSelectedItemsByKey(keys);
        } else {
            List<KeyValueDataSource> keyList = new ArrayList<>();
//            keyList.add(new KeyValueDataSource(RST_1, 投票資格_郵便));
//            keyList.add(new KeyValueDataSource(RST_2, 投票資格_船員));
//            keyList.add(new KeyValueDataSource(RST_3, 投票資格_南極));
            keyList.add(new KeyValueDataSource(TohyoShikakuShurui.投票資格種類_郵便.getCode(), TohyoShikakuShurui.投票資格種類_郵便.getValue()));
            keyList.add(new KeyValueDataSource(TohyoShikakuShurui.投票資格種類_船員.getCode(), TohyoShikakuShurui.投票資格種類_船員.getValue()));
            keyList.add(new KeyValueDataSource(TohyoShikakuShurui.投票資格種類_南極.getCode(), TohyoShikakuShurui.投票資格種類_南極.getValue()));
            div.getSearchSimpleJoken().getChkSearchTohyoShikaku().setDataSource(keyList);
        }
    }

//    /**
//     *
//     * @param 渡された選挙種類 SenkyoShurui
//     * @param 抄本番号 ShohonNo
//     * @param 投票区コード RString
//     * @param 投票年月日 FlexibleDate
//     * @return parameter SearchSimpleJuminParameter
//     */
//    public SearchSimpleJuminParameter set画面パラメータ(SenkyoShurui 渡された選挙種類, ShohonNo 抄本番号, RString 投票区コード, FlexibleDate 投票年月日, ShikibetsuCode 識別コード) {
//        SearchSimpleJuminParameter parameter = new SearchSimpleJuminParameter();
//        if (渡された選挙種類 == SenkyoShurui.国政選挙_地方選挙) {
//            parameter.setSenkyoShurui(new Code(RST_0));
//        } else {
//            parameter.setSenkyoShurui(new Code(渡された選挙種類.getCode()));
//        }
//
//        parameter.setShohonNo(抄本番号);
//        List<Code> tohyoShikakuShuruiList = new ArrayList<>();
//        List<KeyValueDataSource> 投票資格dataSource = div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getSelectedItems();
//        for (KeyValueDataSource keyValueDataSource : 投票資格dataSource) {
//            tohyoShikakuShuruiList.add(new Code(keyValueDataSource.getKey()));
//        }
//
//        List<Code> shikakuKubunList = new ArrayList<>();
//        List<KeyValueDataSource> 選挙資格dataSource = div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().getSelectedItems();
//        for (KeyValueDataSource keyValueDataSource : 選挙資格dataSource) {
//            shikakuKubunList.add(new Code(keyValueDataSource.getKey()));
//        }
//        parameter.setShikakuKubunList(shikakuKubunList);
//        parameter.setTohyoShikakuShuruiList(tohyoShikakuShuruiList);
//        parameter.setTohyoYMD(new FlexibleDate(投票年月日.toString()));
//        parameter.setTohyokuCode(投票区コード);
//        parameter.set識別コード(識別コード);
//        return parameter;
//    }
//
//    /**
//     * 対象者情報の検索時のイベントメソッドです。
//     *
//     * @param result SearchSimpleJuminResult
//     * @param 対象者情報 Object
//     * @param map投票資格 FindShikibetsuTaishos
//     * @param 渡された選挙種類 SenkyoShurui
//     *
//     * @return dgSearchSimpleKekkaList_Row
//     */
//    public dgSearchSimpleKekkaList_Row set対象者情報のデータ1(SearchSimpleJuminResult result, FindShikibetsuTaishoResult 対象者情報,
//            FindShikibetsuTaishos map投票資格, SenkyoShurui 渡された選挙種類) {
//        dgSearchSimpleKekkaList_Row row = new dgSearchSimpleKekkaList_Row();
//        return setSenkyoDataSource(result, 対象者情報, row, map投票資格, 渡された選挙種類);
//    }
//
//    private dgSearchSimpleKekkaList_Row setSenkyoDataSource(SearchSimpleJuminResult result, FindShikibetsuTaishoResult 対象者情報,
//            dgSearchSimpleKekkaList_Row row, FindShikibetsuTaishos map投票資格, SenkyoShurui 渡された選挙種類) {
//
//        AtenaMeisho atenaMeisho = 対象者情報.get宛名PSM().getKanjiShimei();
//        row.setTxtShimei(get氏名(atenaMeisho));
//        AtenaKanaMeisho kanaAtenaMeisho = 対象者情報.get宛名PSM().getKanaShimei();
//        row.setTxtKanaShimei(getカナ氏名(kanaAtenaMeisho));
//
//        RString 住民種別コード = 対象者情報.get宛名PSM().getJuminShubetsuCode();
//
//        RString 生年月日 = format生年月日(対象者情報.get宛名PSM().getSeinengappiYMD(), 住民種別コード);
//
//        row.setTxtSeinengappiYMD(生年月日);
//
////        row.getTxtSeinengappiYMDseireki().setValue(getFlexibleDate(対象者情報.get宛名PSM().getSeinengappiYMD()));
//        RString 性別コード = 対象者情報.get宛名PSM().getSeibetsuCode();
//        row.setTxtSeibetsu(get性別名称(性別コード));
//
//        RString 住登内住所 = 対象者情報.get宛名PSM().getJutonaiJusho();
//
//        AtenaBanchi 住登内番地 = 対象者情報.get宛名PSM().getJutonaiBanchi();
//
//        Katagaki 住登内方書 = 対象者情報.get宛名PSM().getJutonaiKatagaki();
//
//        row.setTxtJusho(get住登内住所(住登内住所).concat(get住登内番地(住登内番地)).concat(全角スペース).concat(get住登内方書(住登内方書)));
//
//        RString 住民状態コード = 対象者情報.get宛名PSM().getJuminJotaiCode();
//
//        row.setTxtJuminShubetsu(get住民状態名称(住民状態コード));
//        row.setTxtJuminShubetsuCode(住民状態コード);
//
//        row.setTxtShikibetsuCode(get識別コード(対象者情報.get宛名PSM().getShikibetsuCode()));
//        SetaiCode 世帯コード = 対象者情報.get宛名PSM().getSetaiCode();
//        row.setTxtSetaiCode(get世帯コード(世帯コード));
//        if (渡された選挙種類 == SenkyoShurui.憲法改正国民投票) {
//            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
//            for (UzT0007CodeEntity uzT0007CodeEntity : codeEntity) {
//                if (uzT0007CodeEntity.getコード().value().equals(result.get選挙資格区分().value())) {
//                    row.setTxtSenkyoShikaku(uzT0007CodeEntity.getコード略称());
//                    row.setTxtSenkyoShikakuKbn(result.get選挙資格区分().value());
//                }
//            }
//        } else {
//            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
//            for (UzT0007CodeEntity uzT0007CodeEntity : codeEntity) {
//                if (uzT0007CodeEntity.getコード().value().equals(result.get選挙資格区分().value())) {
//                    row.setTxtSenkyoShikaku(uzT0007CodeEntity.getコード略称());
//                    row.setTxtSenkyoShikakuKbn(result.get選挙資格区分().value());
//                }
//            }
//        }
//
//        row.setTxtTohyokuCode(result.get投票区コード());
//
//        if (!result.get投票区コード().isNullOrEmpty()) {
//            row.setTxtMeiboBango(result.get投票区コード().concat(横線).concat(new RString(Integer.toString(result.get頁())))
//                    .concat(横線).concat(new RString(Integer.toString(result.get行()))));
//        }
//
////        row.getTxtMeiboTorokuYMD().setValue(get名簿登録年月日(result.get名簿登録年月日()));
////        row.getTxtMeiboTorokuYMDseireki().setValue(get名簿登録年月日(result.get名簿登録年月日()));
////
////        row.getTxtHyojiYMD().setValue(get表示年月日(result.get表示年月日()));
////        row.getTxtHyojiYMDseireki().setValue(get表示年月日(result.get表示年月日()));
////
//        if (渡された選挙種類 == SenkyoShurui.憲法改正国民投票) {
//            row.setTxtHyojiJiyu(getコード名称(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), result.get表示事由コード()));
//            row.setTxtHyojiJiyuCode(result.get表示事由コード().getColumnValue());
//            row.setTxtMasshoJiyu(getコード名称(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), result.get抹消事由コード()));
//            row.setTxtMasshoJiyuCode(result.get抹消事由コード().getColumnValue());
//        } else {
//            row.setTxtHyojiJiyu(getコード名称(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), result.get表示事由コード()));
//            if (result.get表示事由コード() != null) {
//                row.setTxtHyojiJiyuCode(result.get表示事由コード().getColumnValue());
//            } else {
//                row.setTxtHyojiJiyuCode(RString.EMPTY);
//            }
//            row.setTxtMasshoJiyu(getコード名称(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), result.get抹消事由コード()));
//            row.setTxtMasshoJiyuCode(result.get抹消事由コード().getColumnValue());
//        }
//
////        row.getTxtMasshoYMD().setValue(get抹消年月日(result.get抹消年月日()));
////        row.getTxtMasshoYMDseireki().setValue(get抹消年月日(result.get抹消年月日()));
//        if (map投票資格 == null) {
//            row.setTxtTohyoShikaku(new RString("通常"));
//        } else {
//            row.setTxtTohyoShikaku(map投票資格.get選挙資格区分略称());
//        }
//
//        return row;
//    }
//
//    private RString get識別コード(ShikibetsuCode 識別コード) {
//        return 識別コード == null ? RString.EMPTY : 識別コード.getColumnValue();
//    }
//
//    private RString get氏名(AtenaMeisho atenaMeisho) {
//        return atenaMeisho == null ? RString.EMPTY : atenaMeisho.value();
//    }
//
//    private RString getカナ氏名(AtenaKanaMeisho atenaKanaMeisho) {
//        return atenaKanaMeisho == null ? RString.EMPTY : atenaKanaMeisho.value();
//    }
//
//    public RString get投票資格種類コード(Code 投票資格種類) {
//        RString 投票資格略称 = RString.EMPTY;
//        List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.投票資格種類.getCodeShubetsu());
//        for (UzT0007CodeEntity uzT0007CodeEntity : codeEntity) {
//            if (投票資格種類 != null && uzT0007CodeEntity.getコード().value().equals(投票資格種類.value())) {
//                投票資格略称 = uzT0007CodeEntity.getコード略称();
//            }
//        }
//        return 投票資格略称;
//    }
//
//    private FlexibleDate getFlexibleDate(FlexibleDate 年月日) {
//        return 年月日 == null ? FlexibleDate.EMPTY : 年月日;
//    }
//
//    private FlexibleDate get表示年月日(FlexibleDate 表示年月日) {
//        return 表示年月日 == null ? FlexibleDate.EMPTY : 表示年月日;
//    }
//
//    private FlexibleDate get名簿登録年月日(FlexibleDate 名簿登録年月日) {
//        return 名簿登録年月日 == null ? FlexibleDate.EMPTY : 名簿登録年月日;
//    }
//
//    private FlexibleDate get抹消年月日(FlexibleDate 抹消年月日) {
//        return 抹消年月日 == null ? FlexibleDate.EMPTY : 抹消年月日;
//    }
//
//    private RString get世帯コード(SetaiCode 世帯コード) {
//        return 世帯コード == null ? RString.EMPTY : 世帯コード.getColumnValue();
//    }
//
//    public RString get住民状態名称(RString 住民状態コード) {
//
//        return 住民状態コード == null ? RString.EMPTY : JuminJotai.toValue(住民状態コード).住民状態略称();
//    }
//
//    public RString get住登内方書(Katagaki katagaki) {
//        return katagaki == null ? RString.EMPTY : katagaki.getColumnValue();
//    }
//
//    public RString get住登内番地(AtenaBanchi banchi) {
//        return banchi == null ? RString.EMPTY : banchi.getColumnValue();
//    }
//
//    public RString get住登内住所(RString 住登内住所) {
//        return 住登内住所 == null ? RString.EMPTY : 住登内住所;
//    }
//
//    private RString get性別名称(RString 性別コード) {
//
//        if (性別コード != null) {
//            return null == Gender.toValue(性別コード) ? RString.EMPTY
//                    : changeNullToEmpty(Gender.toValue(性別コード).getCommonName());
//        }
//        return RString.EMPTY;
//    }
//
//    private RString format生年月日(FlexibleDate 生年月日, RString 住民種別コード) {
//        RString 画面生年月日 = RString.EMPTY;
//        if (住民種別コード != null && 生年月日 != null && 住民種別コード.equals(JuminShubetsu.日本人.getCode())) {
//            画面生年月日 = 生年月日.wareki().toDateString();
//        } else if (住民種別コード != null && 生年月日 != null && 住民種別コード.equals(JuminShubetsu.外国人.getCode())) {
//            画面生年月日 = 生年月日.seireki().toDateString();
//        } else {
//            if (生年月日 != null) {
//                画面生年月日 = new RString(生年月日.toString());
//            }
//
//        }
//        return 画面生年月日;
//    }
//
//    private RString getコード名称(CodeShubetsu コード種別, Code コード) {
//        if (コード != null) {
//            return CodeMasterNoOption.getCodeMeisho(コード種別, コード);
//        }
//        return RString.EMPTY;
//    }
//
//    private static RString changeNullToEmpty(RString 文字列) {
//        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
//    }
//
    /**
     * 画面の戻るの値です。
     *
     * @param dgSearchSimpleKekkaList List<dgSearchSimpleKekkaList_Row>
     * @return modelデータ SearchSimpleJuminModel
     */
    public SearchSimpleJuminModel set画面データの値(List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList) {
        SearchSimpleJuminModel modelデータ = new SearchSimpleJuminModel();
        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
        List<TohyokuCode> 投票区コードリスト = new ArrayList<>();
        List<RString> 選挙資格リスト = new ArrayList<>();
        if (dgSearchSimpleKekkaList != null && !dgSearchSimpleKekkaList.isEmpty()) {
            for (dgSearchSimpleKekkaList_Row searchSimpleKekkaList_Row : dgSearchSimpleKekkaList) {
                識別コードリスト.add(new ShikibetsuCode(searchSimpleKekkaList_Row.getTxtShikibetsuCode()));
                投票区コードリスト.add(new TohyokuCode(searchSimpleKekkaList_Row.getTxtTohyokuCode()));
                選挙資格リスト.add(searchSimpleKekkaList_Row.getTxtSenkyoShikaku());
                // searchSimpleKekkaList_Row.getTxtMeiboBango().
            }

        }
        modelデータ.set基準年月日(new FlexibleDate(div.getTxtHdnMaxKijunYMD()));
        modelデータ.set識別コードリスト(識別コードリスト);
        modelデータ.set投票区コードリスト(投票区コードリスト);
        modelデータ.set選挙資格リスト(選挙資格リスト);
        if (dgSearchSimpleKekkaList != null && dgSearchSimpleKekkaList.size() == 1) {
            div.getSearchSimpleKekkaList().setTxtHdnShikibetsuCode(dgSearchSimpleKekkaList.get(0).getTxtShikibetsuCode());
        }
        return modelデータ;
    }

    /**
     * 一覧表示状態
     *
     * @param MenuID RString
     */
    public void set一覧表示の状態(RString MenuID) {
        if (AFAMenuId.AFAMNE1010_期日前投票.menuId().equals(MenuID)
                || AFAMenuId.AFAMNE7010_期日前投票.menuId().equals(MenuID)
                || AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId().equals(MenuID)) {
            div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setMultiSelectable(false);
            div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setIsShowSelectButtonColumn(true);
            div.getSearchSimpleKekkaList().getBtnSelect().setDisplayNone(true);

        } else {
            div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setMultiSelectable(true);
            div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getSearchSimpleKekkaList().getBtnSelect().setDisplayNone(false);
        }
        div.getSearchSimpleJoken().setIsOpen(false);
        div.getSearchSimpleKekkaList().setDisplayNone(false);
    }

//    /**
//     * 画面のgridSettingの値を設定する。
//     *
//     *
//     * @return modelデータ SearchSimpleJuminModel
//     */
//    public SearchSimpleJuminModel set検索結果一覧() {
//        SearchSimpleJuminModel modelデータ = new SearchSimpleJuminModel();
//        dgSearchSimpleKekkaList_Row dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getClickedItem();
//        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
//        if (dgSearchSimpleKekkaList != null) {
//            識別コードリスト.add(new ShikibetsuCode(dgSearchSimpleKekkaList.getTxtShikibetsuCode()));
//        }
//        modelデータ.set基準年月日(new FlexibleDate(div.getTxtHdnMaxKijunYMD()));
//        modelデータ.set識別コードリスト(識別コードリスト);
//        return modelデータ;
//
//    }
//
//    /**
//     * 投票資格チェックあるの設定する。
//     *
//     * @param div　SearchSimpleJuminDialogDiv
//     * @param 選挙人情報List　List<SearchSimpleJuminResult>
//     * @param map選挙資格　Map<ShikibetsuCode, FindShikibetsuTaishoResult>
//     * @param map投票資格　Map<ShikibetsuCode, FindShikibetsuTaishos>
//     * @param 渡された選挙種類 SenkyoShurui
//     *
//     * @return
//     */
//    public List<dgSearchSimpleKekkaList_Row> is投票資格あると選挙資格ある(SearchSimpleJuminDialogDiv div, List<SearchSimpleJuminResult> 選挙人情報List,
//            Map<ShikibetsuCode, FindShikibetsuTaishoResult> map選挙資格, Map<ShikibetsuCode, FindShikibetsuTaishos> map投票資格, SenkyoShurui 渡された選挙種類) {
//        Map<ShikibetsuCode, FindShikibetsuTaishoResult> map中選挙資格1 = new HashMap();
//        List<dgSearchSimpleKekkaList_Row> dataRowList = new ArrayList<>();
//
//        for (Map.Entry<ShikibetsuCode, FindShikibetsuTaishoResult> entry : map選挙資格.entrySet()) {
//            if (map投票資格.get(entry.getKey()) != null) {
//                map中選挙資格1.put(entry.getKey(), entry.getValue());
//            }
//        }
//
//        for (SearchSimpleJuminResult result : 選挙人情報List) {
//            if (map中選挙資格1.get(result.get識別コード1()) != null) {
//                dgSearchSimpleKekkaList_Row row = SearchSimpleJuminDialogHandler.of(div).set対象者情報のデータ1(result,
//                        (FindShikibetsuTaishoResult) map中選挙資格1.get(result.get識別コード1()), (FindShikibetsuTaishos) map投票資格.get(result.get識別コード1()), 渡された選挙種類);
//                dataRowList.add(row);
//            }
//        }
//        return dataRowList;
//
//    }
//
//    /**
//     * is投票資格チェックなしの場合
//     *
//     * @param div　SearchSimpleJuminDialogDiv
//     * @param 選挙人情報List　List<SearchSimpleJuminResult>
//     * @param map選挙資格　Map
//     * @param map投票資格 Map
//     * @param 渡された選挙種類 SenkyoShurui
//     * @return
//     */
//    public List<dgSearchSimpleKekkaList_Row> is投票資格なしと選挙資格ある(SearchSimpleJuminDialogDiv div, List<SearchSimpleJuminResult> 選挙人情報List,
//            Map map選挙資格, Map<ShikibetsuCode, FindShikibetsuTaishos> map投票資格, SenkyoShurui 渡された選挙種類) {
//        List<dgSearchSimpleKekkaList_Row> dataRowList = new ArrayList<>();
//        if (選挙人情報List != null && !選挙人情報List.isEmpty() && !map選挙資格.isEmpty()) {
//            for (SearchSimpleJuminResult result : 選挙人情報List) {
//                if (map選挙資格.get(result.get識別コード1()) != null) {
//                    dgSearchSimpleKekkaList_Row row = SearchSimpleJuminDialogHandler.of(div).set対象者情報のデータ1(result,
//                            (FindShikibetsuTaishoResult) map選挙資格.get(result.get識別コード1()), (FindShikibetsuTaishos) map投票資格.get(result.get識別コード1()), 渡された選挙種類);
//                    dataRowList.add(row);
//                }
//
//            }
//        }
//
//        return dataRowList;
//    }
//
//    /**
//     * is投票資格チェックなしの場合
//     *
//     * @param div　SearchSimpleJuminDialogDiv
//     * @param 選挙人情報List　List<SearchSimpleJuminResult>
//     * @param 宛名PSM　List<FindShikibetsuTaishoResult>
//     * @param map条件なし投票資格 Map
//     * @param 渡された選挙種類 SenkyoShurui
//     * @return
//     */
//    public List<dgSearchSimpleKekkaList_Row> is選挙資格なしと投票資格なし(SearchSimpleJuminDialogDiv div, List<SearchSimpleJuminResult> 選挙人情報List,
//            List<FindShikibetsuTaishoResult> 宛名PSM, Map<ShikibetsuCode, FindShikibetsuTaishos> map条件なし投票資格, SenkyoShurui 渡された選挙種類) {
//        List<dgSearchSimpleKekkaList_Row> dataRowList = new ArrayList<>();
//        if (選挙人情報List != null && !選挙人情報List.isEmpty() && 宛名PSM != null && !宛名PSM.isEmpty()) {
//            for (SearchSimpleJuminResult 選挙人result : 選挙人情報List) {
//                if (選挙人result.get識別コード1() != null) {
//                    for (FindShikibetsuTaishoResult 宛名Result : 宛名PSM) {
//                        if (宛名Result.get宛名PSM().getShikibetsuCode() != null
//                                && 選挙人result.get識別コード1().equals(宛名Result.get宛名PSM().getShikibetsuCode())) {
//                            dgSearchSimpleKekkaList_Row row = SearchSimpleJuminDialogHandler.of(div).set対象者情報のデータ1(選挙人result, 宛名Result,
//                                    (FindShikibetsuTaishos) map条件なし投票資格.get(選挙人result.get識別コード1()), 渡された選挙種類);
//                            dataRowList.add(row);
//                        }
//
//                    }
//                }
//
//            }
//        }
//
//        return dataRowList;
//    }
//
//    /**
//     * is投票資格チェックなしの場合
//     *
//     * @param div　SearchSimpleJuminDialogDiv
//     * @param 選挙人情報List　List<SearchSimpleJuminResult>
//     * @param map投票資格　Map<ShikibetsuCode, SearchSimpleJuminResult>
//     * @param 宛名PSM List<FindShikibetsuTaishoResult>
//     * @param 渡された選挙種類 SenkyoShurui
//     * @return
//     */
//    public List<dgSearchSimpleKekkaList_Row> is選挙資格なしと投票資格ある(SearchSimpleJuminDialogDiv div, List<SearchSimpleJuminResult> 選挙人情報List,
//            List<FindShikibetsuTaishoResult> 宛名PSM, Map<ShikibetsuCode, FindShikibetsuTaishos> map投票資格, SenkyoShurui 渡された選挙種類) {
//        List<dgSearchSimpleKekkaList_Row> dataRowList = new ArrayList<>();
//        List<SearchSimpleJuminResult> 現選挙人情報List = new ArrayList<>();
//        Map<ShikibetsuCode, FindShikibetsuTaishoResult> map選挙資格 = new HashMap<>();
//        if (選挙人情報List != null && !選挙人情報List.isEmpty() && !宛名PSM.isEmpty()) {
//            for (SearchSimpleJuminResult 選挙人result : 選挙人情報List) {
//                for (FindShikibetsuTaishoResult 宛名Result : 宛名PSM) {
//                    if (選挙人result.get識別コード1() != null && 宛名Result.get宛名PSM().getShikibetsuCode() != null
//                            && 選挙人result.get識別コード1().equals(宛名Result.get宛名PSM().getShikibetsuCode())) {
//                        現選挙人情報List.add(選挙人result);
//                        map選挙資格.put(宛名Result.get宛名PSM().getShikibetsuCode(), 宛名Result);
//                    }
//                }
//            }
//        }
//
//        if (!現選挙人情報List.isEmpty()) {
//            for (SearchSimpleJuminResult searchSimpleJuminResult : 現選挙人情報List) {
//                if (map投票資格.get(searchSimpleJuminResult.get識別コード1()) != null) {
//                    dgSearchSimpleKekkaList_Row row = SearchSimpleJuminDialogHandler.of(div).set対象者情報のデータ1(searchSimpleJuminResult,
//                            (FindShikibetsuTaishoResult) map選挙資格.get(searchSimpleJuminResult.get識別コード1()),
//                            (FindShikibetsuTaishos) map投票資格.get(searchSimpleJuminResult.get識別コード1()), 渡された選挙種類);
//                    dataRowList.add(row);
//                }
//            }
//        }
//
//        return dataRowList;
//    }
//
//    /**
//     *
//     * @param 不在者投票資格リスト List<FuzaishaShikakuResult>
//     * @param map Map
//     * @param findShikibetsuTaishos FindShikibetsuTaishos
//     * @return
//     */
//    public Map set条件なし投票資格(List<FuzaishaShikakuResult> 不在者投票資格リスト, Map map, FindShikibetsuTaishos findShikibetsuTaishos) {
//        for (FuzaishaShikakuResult fuzaishaShikakuResult : 不在者投票資格リスト) {
//            findShikibetsuTaishos = set条件なし投票資格のデータ(fuzaishaShikakuResult);
//            if (map.get(fuzaishaShikakuResult.get識別コード()) != null) {
//                FindShikibetsuTaishos reuslt = (FindShikibetsuTaishos) map.get(fuzaishaShikakuResult.get識別コード());
//
//                findShikibetsuTaishos.set選挙資格区分略称(reuslt.get選挙資格区分略称().concat(new RString("、"))
//                        .concat(get選挙資格区分略称(fuzaishaShikakuResult.get投票資格種類())));
//            }
//            map.put(fuzaishaShikakuResult.get識別コード(), findShikibetsuTaishos);
//        }
//        return map;
//    }
//
//    /**
//     *
//     * @param 投票資格の不在者投票資格List List<SearchSimpleJuminResult>
//     * @param map Map
//     * @param findShikibetsuTaishos FindShikibetsuTaishos
//     * @return Map
//     */
//    public Map set投票資格(List<SearchSimpleJuminResult> 投票資格の不在者投票資格List, Map map, FindShikibetsuTaishos findShikibetsuTaishos) {
//        if (投票資格の不在者投票資格List != null) {
//            for (SearchSimpleJuminResult searchSimpleJuminResult : 投票資格の不在者投票資格List) {
//                findShikibetsuTaishos = set投票資格のデータ(searchSimpleJuminResult);
//                if (map.get(searchSimpleJuminResult.get識別コード1()) != null) {
//                    FindShikibetsuTaishos reuslt = (FindShikibetsuTaishos) map.get(searchSimpleJuminResult.get識別コード1());
//
//                    findShikibetsuTaishos.set選挙資格区分略称(get選挙資格区分略称(searchSimpleJuminResult.get投票資格種類()).concat(new RString("、"))
//                            .concat(reuslt.get選挙資格区分略称()));
//
//                }
//                map.put(searchSimpleJuminResult.get識別コード1(), findShikibetsuTaishos);
//            }
//        }
//        return map;
//    }
//
//    private FindShikibetsuTaishos set投票資格のデータ(SearchSimpleJuminResult searchSimpleJuminResult) {
//        FindShikibetsuTaishos findShikibetsuTaishos = new FindShikibetsuTaishos();
//        findShikibetsuTaishos.set識別コード(searchSimpleJuminResult.get識別コード1());
//        findShikibetsuTaishos.set選挙資格区分(searchSimpleJuminResult.get投票資格種類());
//        findShikibetsuTaishos.set選挙資格区分略称(get選挙資格区分略称(searchSimpleJuminResult.get投票資格種類()));
//        return findShikibetsuTaishos;
//    }
//
//    private FindShikibetsuTaishos set条件なし投票資格のデータ(FuzaishaShikakuResult fuzaishaShikakuResult) {
//        FindShikibetsuTaishos findShikibetsuTaishos = new FindShikibetsuTaishos();
//        findShikibetsuTaishos.set識別コード(fuzaishaShikakuResult.get識別コード());
//        findShikibetsuTaishos.set選挙資格区分(fuzaishaShikakuResult.get投票資格種類());
//        findShikibetsuTaishos.set選挙資格区分略称(get選挙資格区分略称(fuzaishaShikakuResult.get投票資格種類()));
//        return findShikibetsuTaishos;
//    }
//
//    private RString get選挙資格区分略称(Code 選挙資格区分) {
//        RString 選挙資格区分略称 = RString.EMPTY;
//        List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.投票資格種類.getCodeShubetsu());
//        for (UzT0007CodeEntity uzT0007CodeEntity : codeEntity) {
//            if (uzT0007CodeEntity.getコード().value().equals(選挙資格区分.value())) {
//                選挙資格区分略称 = uzT0007CodeEntity.getコード略称();
//            }
//        }
//        return 選挙資格区分略称;
//    }
//
    /**
     * 画面項目をクリアします。
     *
     */
    public void clearThisPanel() {
        SearchSimpleJoken.clearThisPanel(div.getSearchSimpleJoken());
        SearchSimpleKekkaList.clearThisPanel(div.getSearchSimpleKekkaList());
    }

    /**
     * 検索用パラメータを生成します。
     *
     * @return JuminKensakuMapperParameter
     */
    public JuminKensakuMapperParameter create検索用パラメータ(FlexibleDate max名簿基準年月日) {
//        ISearchShikakuDiv 投票資格Div = div.getSearchSimpleJoken().getCcdSearchTohyoShikaku();
//        IMeiboBangoDiv 名簿番号Div = div.getSearchSimpleJoken().getSearchTohyoJokyo().getCcdMeiboBango();
//        SearchTohyoJokyoDiv 投票状況Div = div.getSearchSimpleJoken().getSearchTohyoJokyo();
        ShikibetsuCode 識別コード = ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getTxtShikibetsuCodeSub().getDomain();

        div.getSearchSimpleJoken().getCcdShohonNameList().changeDdlShohon();
        RString 抄本番号 = div.getSearchSimpleJoken().getCcdShohonNameList().getSelectedShohonNo();
        if (RString.isNullOrEmpty(抄本番号)) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        SenkyoShurui 選挙種類 = SenkyoShurui.valueOf(div.getTxtHdnSenkyoShurui().toString());
        return new JuminKensakuMapperParameter(
                div.getSearchSimpleJoken().getCcdShohonNameList().getSelectedShohonNo(),
                new Code(SenkyoShurui.国政選挙_地方選挙.equals(選挙種類) ? SenkyoShurui.定時登録.getCode() : 選挙種類.getCode()),
                div.getSearchSimpleJoken().getCcdTohyokuCode().getTxtTohyokuCode().getValue(),
                edit選挙資格リスト(選挙種類),
                edit投票資格リスト(選挙種類),
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                RString.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                RString.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                RString.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                RString.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                RString.EMPTY,
                null,
                null,
                Collections.EMPTY_LIST,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                null,
                null,
                null,
                null,
                1000,
                識別コード,
                false,
                false,
                is宛名情報あり(),
                is選挙情報あり(),
                createSearchKey(max名簿基準年月日));
    }

    private IShikibetsuTaishoPSMSearchKey createSearchKey(FlexibleDate max名簿基準年月日) {
        return div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().makeShikibetsuTaishoSearchKey(max名簿基準年月日).getPSMSearchKey();
    }

    private boolean is宛名情報あり() {
        AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho();
        return !RString.isNullOrEmpty(宛名検索Div.getTxtAtenaMeisho().getText())
                || !RString.isNullOrEmpty(宛名検索Div.getTxtSeinenGappi().getText())
                || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiCode().getDomain().value())
                || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiName().getValue())
                || !宛名検索Div.getTxtShikibetsuCodeSub().getDomain().isEmpty()
                || !宛名検索Div.getTxtSetaiCodeSub().getDomain().isEmpty();
    }

    private boolean is選挙情報あり() {
//        ISearchSimpleShikakuDiv 資格検索Div = div.getSearchSimpleJoken().getCcdSearchTohyoShikaku();
        return !RString.isNullOrEmpty(div.getSearchSimpleJoken().getCcdTohyokuCode().getTxtTohyokuCode().getValue())
                || !div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getSelectedKeys().isEmpty();
    }

    /**
     * 選挙資格リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit選挙資格リスト(SenkyoShurui 選挙種類) {
        List<Code> 選挙資格s = new ArrayList<>();
//        RString メニュー_ID = ResponseHolder.getMenuID();
//
//        boolean is国民投票Or在外国民関連 = メニュー_ID.equals(AFAMenuId.AFAMNG1040_投票人の投票区変更.menuId())
//                || メニュー_ID.equals(AFAMenuId.AFAMNG1060_帳票再発行.menuId())
//                || メニュー_ID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
//                || メニュー_ID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
//                || メニュー_ID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
//                || メニュー_ID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
//                || メニュー_ID.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId());
//
//        List<RString> 選挙資格リスト = div.getSearchSimpleJoken().getChkSearchSenkyoShikaku();
        List<RString> 選挙資格リスト = div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().getSelectedValues();
        if (SenkyoShurui.憲法改正国民投票.equals(選挙種類)) {
            if (選挙資格リスト.contains(SennkyoSikakuKubun.抹消者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.抹消者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者_1号資格.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.有権者_1号資格.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者_2号資格.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.有権者_2号資格.getKey()));
            }
        } else {
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.有権者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.表示者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.表示者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.抹消者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.抹消者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.公民権停止.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.公民権停止.getKey()));
            }
        }
        return 選挙資格s;
    }

    /**
     * 投票資格リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit投票資格リスト(SenkyoShurui 選挙種類) {
        List<Code> 投票資格s = new ArrayList<>();
//        List<RString> 投票資格リスト = div.getSearchJoken().getCcdSearchTohyoShikaku().get投票資格リスト();
        List<RString> 投票資格リスト = div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getSelectedValues();
        if (投票資格リスト.contains(TohyoShikakuShurui.投票資格種類_郵便.getValue())) {
            投票資格s.add(new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()));
        }
        if (投票資格リスト.contains(TohyoShikakuShurui.投票資格種類_船員.getValue())) {
            投票資格s.add(new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()));
        }
        if (投票資格リスト.contains(TohyoShikakuShurui.投票資格種類_南極.getValue())) {
            投票資格s.add(new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()));
        }

        return 投票資格s;
    }

    /**
     * 検索結果を一覧に設定します。
     *
     * @param result JuminKensaku
     * @param row dgSearchSimpleKekkaList_Row
     * @param senkyoShurui SenkyoShurui
     * @param 投票資格リスト List<RString>
     * @param 基準日 FlexibleDate
     * @return dgSearchSimpleKekkaList_Row
     */
    public dgSearchSimpleKekkaList_Row set検索結果To一覧(JuminKensaku result,
            dgSearchSimpleKekkaList_Row row,
            SenkyoShurui senkyoShurui,
            List<RString> 投票資格リスト,
            FlexibleDate 基準日) {
//    private dgSearchSimpleKekkaList_Row setSenkyoDataSource(SearchSimpleJuminResult result, FindShikibetsuTaishoResult 対象者情報,
//            dgSearchSimpleKekkaList_Row row, FindShikibetsuTaishos map投票資格, SenkyoShurui 渡された選挙種類) {

//        AtenaMeisho atenaMeisho = 対象者情報.get宛名PSM().getKanjiShimei();
//        row.setTxtShimei(get氏名(atenaMeisho));
//        AtenaKanaMeisho kanaAtenaMeisho = 対象者情報.get宛名PSM().getKanaShimei();
//        row.setTxtKanaShimei(getカナ氏名(kanaAtenaMeisho));
        row.setTxtShimei(result.get氏名());
        row.setTxtKanaShimei(result.getカナ氏名());

//        RString 住民種別コード = 対象者情報.get宛名PSM().getJuminShubetsuCode();
//        RString 生年月日 = format生年月日(対象者情報.get宛名PSM().getSeinengappiYMD(), 住民種別コード);
//        row.setTxtSeinengappiYMD(生年月日);
//        row.getTxtSeinengappiYMDseireki().setValue(getFlexibleDate(対象者情報.get宛名PSM().getSeinengappiYMD()));
        row.setTxtSeinengappiYMD(result.get生年月日());
        row.setTxtSeinengappiYMDseireki(result.get生年月日西暦());

//        RString 性別コード = 対象者情報.get宛名PSM().getSeibetsuCode();
//        row.setTxtSeibetsu(get性別名称(性別コード));
        row.setTxtSeibetsu(result.get性別名称());

//        RString 住登内住所 = 対象者情報.get宛名PSM().getJutonaiJusho();
//        AtenaBanchi 住登内番地 = 対象者情報.get宛名PSM().getJutonaiBanchi();
//        Katagaki 住登内方書 = 対象者情報.get宛名PSM().getJutonaiKatagaki();
//        row.setTxtJusho(get住登内住所(住登内住所).concat(get住登内番地(住登内番地)).concat(全角スペース).concat(get住登内方書(住登内方書)));
        row.setTxtJusho(result.getフォーマット後住所());

//        RString 住民状態コード = 対象者情報.get宛名PSM().getJuminJotaiCode();
//        row.setTxtJuminShubetsu(get住民状態名称(住民状態コード));
//        row.setTxtJuminShubetsuCode(住民状態コード);
        row.setTxtJuminShubetsu(result.get住民状態名称());
        row.setTxtJuminShubetsuCode(result.get住民状態コード());

//        row.setTxtShikibetsuCode(get識別コード(対象者情報.get宛名PSM().getShikibetsuCode()));
        row.setTxtShikibetsuCode(result.get識別コード());
//        SetaiCode 世帯コード = 対象者情報.get宛名PSM().getSetaiCode();
//        row.setTxtSetaiCode(get世帯コード(世帯コード));
        row.setTxtSetaiCode(result.get世帯コード());
//        if (渡された選挙種類 == SenkyoShurui.憲法改正国民投票) {
//            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
//            for (UzT0007CodeEntity uzT0007CodeEntity : codeEntity) {
//                if (uzT0007CodeEntity.getコード().value().equals(result.get選挙資格区分().value())) {
//                    row.setTxtSenkyoShikaku(uzT0007CodeEntity.getコード略称());
//                    row.setTxtSenkyoShikakuKbn(result.get選挙資格区分().value());
//                }
//            }
//        } else {
//            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
//            for (UzT0007CodeEntity uzT0007CodeEntity : codeEntity) {
//                if (uzT0007CodeEntity.getコード().value().equals(result.get選挙資格区分().value())) {
//                    row.setTxtSenkyoShikaku(uzT0007CodeEntity.getコード略称());
//                    row.setTxtSenkyoShikakuKbn(result.get選挙資格区分().value());
//                }
//            }
//        }
        row.setTxtSenkyoShikaku(edit選挙資格(senkyoShurui, result.get選挙資格(), 基準日));
        row.setTxtSenkyoShikakuKbn(result.get選挙資格().value());

        row.setTxtTohyokuCode(result.get投票区コード());

//        if (!result.get投票区コード().isNullOrEmpty()) {
//            row.setTxtMeiboBango(result.get投票区コード().concat(横線).concat(new RString(Integer.toString(result.get頁())))
//                    .concat(横線).concat(new RString(Integer.toString(result.get行()))));
//        }
        row.setTxtMeiboBango(format名簿番号(result));

//        row.getTxtMeiboTorokuYMD().setValue(get名簿登録年月日(result.get名簿登録年月日()));
//        row.getTxtMeiboTorokuYMDseireki().setValue(get名簿登録年月日(result.get名簿登録年月日()));
        row.setTxtMeiboTorokuYMD(result.get名簿登録年月日());
        row.setTxtMeiboTorokuYMDseireki(result.get名簿登録年月日西暦());

//        row.getTxtHyojiYMD().setValue(get表示年月日(result.get表示年月日()));
//        row.getTxtHyojiYMDseireki().setValue(get表示年月日(result.get表示年月日()));
        row.setTxtHyojiYMD(result.get表示年月日和暦());
        row.setTxtHyojiYMDseireki(result.get表示年月日西暦());
        row.setTxtHyojiJiyu(edit表示事由(senkyoShurui, result.get表示事由コード(), result.get表示年月日()));
        row.setTxtHyojiJiyuCode(result.get表示事由コード().value());
//        if (渡された選挙種類 == SenkyoShurui.憲法改正国民投票) {
//            row.setTxtHyojiJiyu(getコード名称(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), result.get表示事由コード()));
//            row.setTxtHyojiJiyuCode(result.get表示事由コード().getColumnValue());
//            row.setTxtMasshoJiyu(getコード名称(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), result.get抹消事由コード()));
//            row.setTxtMasshoJiyuCode(result.get抹消事由コード().getColumnValue());
//        } else {
//            row.setTxtHyojiJiyu(getコード名称(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), result.get表示事由コード()));
//            if (result.get表示事由コード() != null) {
//                row.setTxtHyojiJiyuCode(result.get表示事由コード().getColumnValue());
//            } else {
//                row.setTxtHyojiJiyuCode(RString.EMPTY);
//            }
//            row.setTxtMasshoJiyu(getコード名称(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), result.get抹消事由コード()));
//            row.setTxtMasshoJiyuCode(result.get抹消事由コード().getColumnValue());
//        }

//        row.getTxtMasshoYMD().setValue(get抹消年月日(result.get抹消年月日()));
//        row.getTxtMasshoYMDseireki().setValue(get抹消年月日(result.get抹消年月日()));
        row.setTxtMasshoYMD(result.get抹消年月日和暦());
        row.setTxtMasshoYMDseireki(result.get抹消年月日西暦());
        row.setTxtMasshoJiyu(edit抹消事由(senkyoShurui, result.get抹消事由コード(), result.get抹消年月日()));
        row.setTxtMasshoJiyuCode(result.get抹消事由コード().value());
//        if (map投票資格 == null) {
//            row.setTxtTohyoShikaku(new RString("通常"));
//        } else {
//            row.setTxtTohyoShikaku(map投票資格.get選挙資格区分略称());
//        }
        row.setTxtTohyoShikaku(getコード略称(AFACodeShubetsu.投票資格種類.getCodeShubetsu(), result.get投票資格種類コード(), 基準日));

        return row;
    }

    private RString edit選挙資格(SenkyoShurui 選挙種類, Code 選挙資格区分コード, FlexibleDate 基準日) {
        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            return getコード名称(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), 選挙資格区分コード, 基準日);
        } else {
            return getコード名称(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分コード, 基準日);
        }
    }

    private RString getコード名称(CodeShubetsu コード種別, Code コード, FlexibleDate 基準日) {
        return CodeMasterNoOption.getCodeMeisho(コード種別, コード, 基準日);
    }

    private RString getコード略称(CodeShubetsu コード種別, Code コード, FlexibleDate 基準日) {
        return CodeMasterNoOption.getCodeRyakusho(コード種別, コード, 基準日);
    }

    private RString format名簿番号(JuminKensaku result) {
        RString 冊 = result.get冊().padLeft(空白埋めの３桁);
        RString 頁 = new RStringBuilder().append(result.get頁()).toRString().padLeft(空白埋めの６桁);
        RString 行 = new RStringBuilder().append(result.get行()).toRString().padLeft(空白埋めの２桁);
        if (!AFAConfigKeysValue.抄本_冊区分管理_使用しない.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            return 冊.concat(横線).concat(頁).concat(横線).concat(行);
        }
        return 頁.concat(横線).concat(行);
    }

    private RString edit表示事由(SenkyoShurui 選挙種類, Code 表示事由コード, FlexibleDate 基準日) {
        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            return getコード名称(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), 表示事由コード, 基準日);
        } else {
//            if (投票資格リスト.contains(在外)) {
//                return getコード名称(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), 表示事由コード, 基準日);
//            } else {
            return getコード名称(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), 表示事由コード, 基準日);
//            }
        }
    }

    private RString edit抹消事由(SenkyoShurui 選挙種類, Code 抹消事由コード, FlexibleDate 基準日) {
        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            return getコード名称(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), 抹消事由コード, 基準日);
        } else {
//            if (投票資格リスト.contains(在外)) {
//                return getコード名称(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), 抹消事由コード, 基準日);
//            } else {
            return getコード名称(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), 抹消事由コード, 基準日);
//            }
        }
    }

}
