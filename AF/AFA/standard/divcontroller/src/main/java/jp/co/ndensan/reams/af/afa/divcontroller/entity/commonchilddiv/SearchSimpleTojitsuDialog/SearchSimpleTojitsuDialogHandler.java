/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleTojitsuDialog;

import jp.co.ndensan.reams.af.afa.business.core.idosearchjumin.IdoSearchJumin;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.searchsimpletojitsu.SearchSimpleTojitsuMapperParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * SearchSimpleTojitsuDialogHandler の操作を担当するクラスです。
 * <p>
 * このクラスを通してSearchSimpleTojitsuDialogDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0260-020 lis
 */
public class SearchSimpleTojitsuDialogHandler {

    private final SearchSimpleTojitsuDialogDiv div;
    private final RString RST_0 = new RString("0");
    private final RString RST_1 = new RString("1");
    private final RString RST_2 = new RString("2");
    private final RString RST_通常 = new RString("通常");
    private static final int 三 = 3;
    private static final RString 横線 = new RString("-");

    /**
     * コンストラクタです。
     *
     * @param div 簡易版住民検索Div
     */
    public SearchSimpleTojitsuDialogHandler(SearchSimpleTojitsuDialogDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 簡易版住民検索Div
     * @return SearchSimpleTojitsuDialogHandler
     */
    public static SearchSimpleTojitsuDialogHandler of(SearchSimpleTojitsuDialogDiv div) {
        return new SearchSimpleTojitsuDialogHandler(div);
    }

    /**
     * 検索用パラメータを生成します。
     *
     * @return SearchSimpleTojitsuMapperParameter
     */
    public SearchSimpleTojitsuMapperParameter create検索用パラメータ() {
        IMeiboBangoDiv 名簿番号Div = div.getSearchTojitsuJoken().getCcdMeiboBango();
        return new SearchSimpleTojitsuMapperParameter(
                new ShohonNo(div.getSearchTojitsuJoken().getCcdShohon().getSelectedShohonNo()),
                new Code(div.getSearchTojitsuJoken().getCcdShohon().getSelectedSenkyoShurui().getCode()),
                div.getSearchTojitsuJoken().getCcdTohyokuCode().get投票区コード(),
                名簿番号Div.get冊(),
                名簿番号Div.get頁(),
                名簿番号Div.get行(),
                div.getSearchTojitsuJoken().getTxtMeisho().getValue(),
                div.getSearchTojitsuJoken().getTxtMaxDisplayCount().getValue().multiply(三).intValue(),
                is氏名前方一致(),
                is氏名後方一致(),
                is氏名部分一致(),
                createSearchKey());
    }

    private IShikibetsuTaishoPSMSearchKey createSearchKey() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        builder.set生年月日(div.getSearchTojitsuJoken().getTxtSeinengappi().getValue())
                .set性別(get性別(div.getSearchTojitsuJoken().getTxtSeibetsu().getSelectedKey()));
        return builder.build();
    }

    /**
     * 検索結果を一覧に設定します。
     *
     * @param senkyoShurui SenkyoShurui
     * @param result JuminKensaku
     * @param row dgSearchKekkaList_Row
     * @return dgSearchKekkaList_Row
     */
    public dgSearchTojitsuKekkaList_Row set検索結果To一覧(SenkyoShurui senkyoShurui, IdoSearchJumin result,
            dgSearchTojitsuKekkaList_Row row) {
        row.setTxtShimei(result.get氏名());
        row.setTxtKanaShimei(result.getカナ氏名());
        row.setTxtSeinengappiYMD(result.get生年月日());
        row.getTxtSeinengappiYMDseireki().setValue(result.get生年月日西暦());
        row.setTxtSeibetsu(result.get性別名称());
        row.setTxtJusho(result.get住所());
        row.setTxtJuminShubetsu(result.get住民状態名称());
        row.setTxtJuminShubetsuCode(result.get住民状態コード());
        row.setTxtShikibetsuCode(result.get識別コード());
        row.setTxtSetaiCode(result.get世帯コード());
        row.setTxtSenkyoShikaku(edit選挙資格(senkyoShurui, result.get選挙資格()));
        row.setTxtSenkyoShikakuKubun(result.get選挙資格().getColumnValue());
        row.setTxtTohyokuCode(result.get投票区コード());
        row.setTxtMeiboBango(edit名簿番号(result));
        row.setTxtMeiboTorokuYMD(result.get名簿登録日());
        row.getTxtMeiboTorokuYMDseireki().setValue(result.get名簿登録年月日西暦());
        row.setTxtHyojiYMD(result.get表示日());
        row.getTxtHyojiYMDseireki().setValue(result.get表示年月日西暦());
        row.setTxtHyojiJiyu(edit表示事由(senkyoShurui, result.get表示事由コード()));
        row.setTxtHyojiJiyuCode(result.get表示事由コード().getColumnValue());
        row.setTxtMasshoYMD(result.get抹消日());
        row.getTxtMasshoYMDseireki().setValue(result.get抹消年月日西暦());
        row.setTxtMasshoJiyu(edit抹消事由(senkyoShurui, result.get抹消事由コード()));
        row.setTxtMasshoJiyuCode(result.get抹消事由コード().getColumnValue());
        if (null != result.get投票資格() && !result.get投票資格().isEmpty()) {
            row.setTxtTohyoShikaku(get投票資格コード略称(AFACodeShubetsu.投票資格種類.getCodeShubetsu(),
                    result.get投票資格().get(0).getTohyoShikakuShurui()));
        }
        return row;
    }

    private RString edit選挙資格(SenkyoShurui senkyoShurui, Code 選挙資格区分コード) {
        if (senkyoShurui.equals(SenkyoShurui.憲法改正国民投票)) {
            return getコード略称(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), 選挙資格区分コード);
        }
        return getコード略称(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分コード);
    }

    private RString edit表示事由(SenkyoShurui senkyoShurui, Code 表示事由コード) {
        if (senkyoShurui.equals(SenkyoShurui.憲法改正国民投票)) {
            return getコード名称(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), 表示事由コード);
        }
        return getコード名称(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), 表示事由コード);
    }

    private RString edit抹消事由(SenkyoShurui senkyoShurui, Code 抹消事由コード) {
        if (senkyoShurui.equals(SenkyoShurui.憲法改正国民投票)) {
            return getコード略称(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), 抹消事由コード);
        }
        return getコード略称(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), 抹消事由コード);
    }

    private RString get投票資格コード略称(CodeShubetsu コード種別, Code コード) {
        if (null == コード || コード.isEmpty()) {
            return RST_通常;
        }
        return CodeMasterNoOption.getCodeRyakusho(コード種別, コード);
    }

    private RString getコード略称(CodeShubetsu コード種別, Code コード) {
        return CodeMasterNoOption.getCodeRyakusho(コード種別, コード);
    }

    private RString getコード名称(CodeShubetsu コード種別, Code コード) {
        return CodeMasterNoOption.getCodeMeisho(コード種別, コード);
    }

    private Gender get性別(RString 性別コード) {
        if (RST_0.equals(性別コード)) {
            return Gender.未定義;
        }
        return Gender.toValue(性別コード);
    }

    /**
     * 氏名前方一致の判定メソッドです。
     *
     * @return boolean
     */
    public boolean is氏名前方一致() {
        RString 名称配列ドロップダウン = div.getSearchTojitsuJoken().getDdlMeishoKensaku().getSelectedKey();
        return 名称配列ドロップダウン.equals(RST_0);
    }

    /**
     * 氏名前方一致の判定メソッドです。
     *
     * @return boolean
     */
    public boolean is氏名部分一致() {
        RString 名称配列ドロップダウン = div.getSearchTojitsuJoken().getDdlMeishoKensaku().getSelectedKey();
        return 名称配列ドロップダウン.equals(RST_1);
    }

    /**
     * 氏名前方一致の判定メソッドです。
     *
     * @return boolean
     */
    public boolean is氏名後方一致() {
        RString 名称配列ドロップダウン = div.getSearchTojitsuJoken().getDdlMeishoKensaku().getSelectedKey();
        return 名称配列ドロップダウン.equals(RST_2);
    }

    /**
     * 画面項目をクリアします。
     *
     */
    public void clearThisPanel() {
//        SearchSimpleJoken.clearThisPanel(div.getSearchTojitsuJoken());
//        SearchSimpleKekkaList.clearThisPanel(div.getSearchTojitsuKekkaList());
    }

    /**
     * 初期化状態になります。
     */
    public void change画面To初期化状態() {
        div.getSearchTojitsuKekkaList().setDisabled(Boolean.TRUE);
        div.getSearchTojitsuJoken().setDisabled(Boolean.FALSE);
        setDisabled検索条件指定パネル(Boolean.FALSE);
        div.getSearchTojitsuKekkaList().setIsOpen(Boolean.FALSE);
    }

    /**
     * 検索結果状態になります。
     */
    public void change画面To検索結果状態() {
        div.getSearchTojitsuKekkaList().setDisabled(Boolean.FALSE);
        div.getSearchTojitsuJoken().setDisabled(Boolean.TRUE);
        setDisabled検索条件指定パネル(Boolean.TRUE);
        div.getSearchTojitsuKekkaList().setIsOpen(Boolean.TRUE);
    }

    /**
     * 再検索状態になります。
     */
    public void change画面To再検索状態() {
        div.getSearchTojitsuJoken().setDisabled(Boolean.FALSE);
        setDisabled検索条件指定パネル(Boolean.FALSE);
        div.getSearchTojitsuKekkaList().setIsOpen(Boolean.FALSE);
        div.getSearchTojitsuKekkaList().setDisabled(Boolean.TRUE);
    }

    private void setDisabled検索条件指定パネル(boolean isDisabled) {
        div.getSearchTojitsuJoken().setIsOpen(!isDisabled);
    }

    /**
     * 検索結果一覧データグリッドをクリアします。
     */
    public void clear検索結果一覧データグリッド() {
        div.getSearchTojitsuKekkaList().getDgSearchTojitsuKekkaList().getDataSource().clear();
        div.getSearchTojitsuKekkaList().getDgSearchTojitsuKekkaList().getFilterList().clear();
    }

    private RString edit名簿番号(IdoSearchJumin result) {
        RString 投票区コード = result.get投票区コード();
        RString 頁 = new RStringBuilder().append(result.get頁()).toRString();
        RString 行 = new RStringBuilder().append(result.get行()).toRString();
        return 投票区コード.concat(横線).concat(頁).concat(横線).concat(行);
    }
}
