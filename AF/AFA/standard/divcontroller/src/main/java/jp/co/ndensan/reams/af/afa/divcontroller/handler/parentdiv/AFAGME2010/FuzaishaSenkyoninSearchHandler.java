/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.SenkyoninMybatisParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaSenkyoninSearchDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.dgFuzaishaSenkyoninSearch_Row;
import jp.co.ndensan.reams.af.afa.service.fuzaishatohyo.SenkyoninFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * FuzaishaSenkyoninSearchDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaSenkyoninSearchHandler {

    private FuzaishaSenkyoninSearchHandler() {

    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div FuzaishaSenkyoninSearchDiv
     */
    public static void initialize(FuzaishaSenkyoninSearchDiv div) {
        div.getDgFuzaishaSenkyoninSearch().init();
        div.getCcdFuzaishaBarCode().initialize(TohyoJokyo.期日前, false);
    }

    /**
     * 引数の情報を、hiddenInputにセットする。
     *
     * @param div FuzaishaSenkyoninSearchDiv
     * @param shohonNo 抄本番号
     * @param senkyoShurui 選挙種類
     * @param kidoMode 起動モード
     */
    public static void setHiddenInput(FuzaishaSenkyoninSearchDiv div, RString shohonNo, SenkyoShurui senkyoShurui, RString kidoMode) {
        div.setTxtHdnShohonNo(shohonNo);
        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
        div.setTxtHdnKidoMode(kidoMode);
    }

    /**
     * 選挙人選択ボタンの初期化処理(抄本番号、施設コードを渡された時のイベントメソッドです)。
     *
     * @param div FuzaishaSenkyoninSearchDiv
     * @param shohonNo RString
     * @param shisetsuCode RString
     */
    public static void setData(FuzaishaSenkyoninSearchDiv div, RString shohonNo, RString shisetsuCode) {
        List<PersonalData> personalDataList = new ArrayList<>();
        clearThisPanel(div);
        div.getDgFuzaishaSenkyoninSearch().getDataSource()
                .addAll(createDataSourceFrom抄本番号と施設コード(is受理(div), shohonNo, shisetsuCode, personalDataList));

        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    /**
     * 「選挙人を検索する」ボタン或は「入場券バーコード」ボタンのイベントメソッド。
     *
     * @param div FuzaishaSenkyoninSearchDiv
     * @param 選挙人リスト List<SenkyoninSearchResult>
     */
    public static void addData(FuzaishaSenkyoninSearchDiv div, List<SenkyoninSearchResult> 選挙人リスト) {
        List<PersonalData> personalDataList = new ArrayList<>();
        div.getDgFuzaishaSenkyoninSearch().getDataSource().addAll(createDataSource(選挙人リスト, div, personalDataList));
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    /**
     * 「選挙人の削除」ボタンのイベントメソッド。
     *
     * @param div FuzaishaSenkyoninSearchDiv
     */
    public static void deleteData(FuzaishaSenkyoninSearchDiv div) {
        div.getDgFuzaishaSenkyoninSearch().getDataSource().remove(div.getDgFuzaishaSenkyoninSearch().getClickedRowId());
    }

    /**
     * Panelにデータを初期化
     *
     * @param div FuzaishaSenkyoninSearchDiv
     */
    public static void clearThisPanel(FuzaishaSenkyoninSearchDiv div) {
        div.getCcdFuzaishaBarCode().clearData();
        div.getCcdFuzaishaBarCode().initialize(TohyoJokyo.期日前, false);
        div.getDgFuzaishaSenkyoninSearch().getDataSource().clear();
        div.getDgFuzaishaSenkyoninSearch().init();
    }

    private static dgFuzaishaSenkyoninSearch_Row createDataRowFrom選挙人(SenkyoninSearchResult 選挙人) {
        dgFuzaishaSenkyoninSearch_Row row = new dgFuzaishaSenkyoninSearch_Row();
        row.getBtnDelete().setDisabled(選挙人.is実データフラグ());
        row.setTxtShimei(選挙人.get氏名());
        JuminShubetsu 住民種別 = 選挙人.get識別対象().get住民種別();
        if (住民種別.equals(JuminShubetsu.日本人)) {
            row.setTxtSeinengappi(選挙人.get生年月日().wareki().toDateString());
        } else if (住民種別.equals(JuminShubetsu.外国人)) {
            row.setTxtSeinengappi(選挙人.get生年月日().seireki().toDateString());
        }
        row.setTxtSeibetsu(選挙人.get性別());
        row.setTxtShikibetsuCode(選挙人.get識別コード());
        row.setTxtSetaiCode(選挙人.get世帯コード());
        row.setTxtJusho(選挙人.get住所());
        return row;
    }

    private static List<dgFuzaishaSenkyoninSearch_Row> createDataSourceFrom抄本番号と施設コード(
            boolean 受理フラグ, RString shohonNo, RString shisetsuCode, List<PersonalData> personalDataList) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        SenkyoninMybatisParameter param = new SenkyoninMybatisParameter(
                受理フラグ, new ShohonNo(shohonNo), shisetsuCode, new ArrayList<ShikibetsuCode>(), key.getPSM検索キー());
        List<SenkyoninSearchResult> searchResult = SenkyoninFinder.createInstance().getSenkyoninList(param);
        List<dgFuzaishaSenkyoninSearch_Row> dataSource = new ArrayList<>();
        for (SenkyoninSearchResult 選挙人 : searchResult) {
            dataSource.add(createDataRowFrom選挙人(選挙人));
            personalDataList.add(PersonalData.of(new ShikibetsuCode(選挙人.get識別コード())));
        }
        return dataSource;
    }

    private static List<dgFuzaishaSenkyoninSearch_Row> createDataSource(
            List<SenkyoninSearchResult> 選挙人リスト, FuzaishaSenkyoninSearchDiv div, List<PersonalData> personalDataList) {
        List<dgFuzaishaSenkyoninSearch_Row> dataSource = new ArrayList<>();
        List<RString> 識別コードリスト = get識別コードリスト(div);
        for (SenkyoninSearchResult 選挙人 : 選挙人リスト) {
            if (!識別コードリスト.contains(選挙人.get識別コード())) {
                dataSource.add(createDataRowFrom選挙人(選挙人));
                識別コードリスト.add(選挙人.get識別コード());
                personalDataList.add(PersonalData.of(new ShikibetsuCode(選挙人.get識別コード())));
            }
        }
        return dataSource;
    }

    private static List<RString> get識別コードリスト(FuzaishaSenkyoninSearchDiv div) {
        List<dgFuzaishaSenkyoninSearch_Row> rowList = div.getDgFuzaishaSenkyoninSearch().getDataSource();
        List<RString> 識別コードリスト = new ArrayList<>();
        for (dgFuzaishaSenkyoninSearch_Row row : rowList) {
            識別コードリスト.add(row.getTxtShikibetsuCode());
        }
        return 識別コードリスト;
    }

    private static boolean is受理(FuzaishaSenkyoninSearchDiv div) {
        return TohyoJokyo.受理.getCode().equals(div.getTxtHdnKidoMode());
    }
}
