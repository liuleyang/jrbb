/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.SearchSimpleKekkaListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.dgSearchSimpleKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.SeinengappiFushoKubunType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 【View】SearchSimpleJuminDiv内の <br />
 * SearchSimpleKekkaListDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0170-020 qiuxy
 */
public class SearchSimpleKekkaList {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SearchSimpleKekkaListDiv
     */
    public static void initialize(SearchSimpleKekkaListDiv div) {
        div.getDgSearchSimpleKekkaList().init();
    }

    /**
     * グリッド上の選択ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleKekkaListDiv
     * @return ResponseData<SearchSimpleKekkaListDiv>
     */
    public ResponseData<SearchSimpleKekkaListDiv> onSelect_dgSearchKekkaList(SearchSimpleKekkaListDiv div) {
        RString shikibetsuCode = div.getDgSearchSimpleKekkaList().getSelectedItems().get(0).getTxtShikibetsuCode();
        div.setTxtHdnShikibetsuCode(shikibetsuCode);
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        shikibetsuCodeList.add(new ShikibetsuCode(shikibetsuCode));
        SearchSimpleJuminModel model = new SearchSimpleJuminModel();
        model.set識別コードリスト(shikibetsuCodeList);
        div.setSearchSimpleJuminModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 画面項目をクリアします。
     *
     * @param div SearchSimpleKekkaListDiv
     */
    public static void clearThisPanel(SearchSimpleKekkaListDiv div) {
        div.setTxtHdnShikibetsuCode(RString.EMPTY);
        div.getDgSearchSimpleKekkaList().getDataSource().clear();
    }

    /**
     * 検索結果をセットします。
     *
     * @param div SearchSimpleKekkaListDiv
     */
    public static void set検索結果(SearchSimpleKekkaListDiv div) {
        div.getDgSearchSimpleKekkaList().getDataSource().addAll(createDataSourceForYml());
    }

    /**
     * 検索結果をセットします。
     *
     * @param div SearchSimpleKekkaListDiv
     * @param list List<IShikibetsuTaisho>
     */
    public static void set検索結果(SearchSimpleKekkaListDiv div, List<IShikibetsuTaisho> list) {
        div.getDgSearchSimpleKekkaList().getDataSource().addAll(createDataSource(list));
    }

    private static List<dgSearchSimpleKekkaList_Row> createDataSource(List<IShikibetsuTaisho> list) {
        List<dgSearchSimpleKekkaList_Row> dataSource = new ArrayList<>();

        for (IShikibetsuTaisho taisho : list) {
            dgSearchSimpleKekkaList_Row row = new dgSearchSimpleKekkaList_Row();
            row.setTxtShimei(taisho.get名称().getName().getColumnValue());
            row.setTxtSeinengappiYMD(createBirthDayArea(taisho));
            row.setTxtSeibetsu(createSeibetsuArea(taisho));
            row.setTxtJusho(createJushoArea(taisho));
            row.setTxtJuminShubetsu(taisho.get住民種別().toRString());
            row.setTxtShikibetsuCode(taisho.get識別コード().getColumnValue());
            row.setTxtSetaiCode(taisho.canBe個人() ? taisho.to個人().get世帯コード().getColumnValue() : RString.EMPTY);
            //TODO 選挙情報部分のセットをどうするか

            dataSource.add(row);
        }

        return dataSource;
    }

    //TODO 生年月日の部分（日本人は和暦、外国人は西暦）は、共通関数がないのか？あちこちで同様の実装になってしまうのを防ぐこと!!
    private static RString createBirthDayArea(IShikibetsuTaisho item) {

        if (item.canBe個人()) {
            if (isEmptyOfBirth(item.to個人().get生年月日())) {
                return RString.EMPTY;
            }
            //TODO n0869生年月日不詳区分の対応が必要
            //TODO n3407 isEmptyメソッドを使用していたが、エラーが起きていたため暫定的に修正
            if (!(item.to個人().get生年月日不詳区分().value() == SeinengappiFushoKubunType.未定義)) {
                return RString.EMPTY;
            }
            return editBirthDay(item);
        }

        return RString.EMPTY;
    }

    private static RString editBirthDay(IShikibetsuTaisho item) {
        FlexibleDate 生年月日 = item.to個人().get生年月日().toFlexibleDate();

        switch (item.get住民種別()) {
            case 日本人:
            case 住登外個人_日本人:
                return 生年月日.wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
            case 外国人:
            case 住登外個人_外国人:
                return 生年月日.seireki().separator(Separator.PERIOD).toDateString();
            default:
                return RString.EMPTY;
        }
    }

    private static boolean isEmptyOfBirth(IDateOfBirth birthDay) {
        FlexibleDate 生年月日 = birthDay.toFlexibleDate();
        return 生年月日.isEmpty() || 生年月日.isMaxOrMin();
    }

    private static RString createSeibetsuArea(IShikibetsuTaisho item) {
        return item.canBe個人() ? item.to個人().get性別().getCommonName() : RString.EMPTY;
    }

    private static RString createJushoArea(IShikibetsuTaisho item) {

        StringBuilder jushoArea = new StringBuilder();

        jushoArea.append(item.get住所().get住所());
        jushoArea.append(item.get住所().get番地().getBanchi().getColumnValue());

        if (!item.get住所().get方書().isEmpty()) {
            jushoArea.append(new RString("&nbsp;"));
            jushoArea.append(item.get住所().get方書().getColumnValue());
        }

        return new RString(jushoArea.toString());
    }

    private static List<dgSearchSimpleKekkaList_Row> createDataSourceForYml() {
        //TODO 検索条件を作成して必要なデータを取得する。
        // yamlファイルはやめて、ちゃんと宛名検索と結合させて、実データを抽出するようにする。
        RString yamlSenkyoFile = new RString("AtenaJoho.yml");
        List<HashMap> sourceKekka = YamlLoader.loadAsList(yamlSenkyoFile);

        List<dgSearchSimpleKekkaList_Row> dataSource = new ArrayList<>();
        for (HashMap item : sourceKekka) {
            dgSearchSimpleKekkaList_Row row = new dgSearchSimpleKekkaList_Row();
            row.setTxtShimei(YamlLoader.getStringText(item, "氏名"));
            row.setTxtSeinengappiYMD(YamlLoader.getStringText(item, "生年月日"));
            row.setTxtSeibetsu(YamlLoader.getStringText(item, "性別"));
            row.setTxtJusho(YamlLoader.getStringText(item, "住所"));
            row.setTxtJuminShubetsu(YamlLoader.getStringText(item, "住民種別"));
            row.setTxtShikibetsuCode(YamlLoader.getStringText(item, "shikibetsuCode"));
            row.setTxtSetaiCode(YamlLoader.getStringText(item, "世帯コード"));

            List<HashMap> sourceShikaku = YamlLoader.loadAsList(new RString("SenkyoShikaku.yml"));
            for (HashMap item2 : sourceShikaku) {
                if (new RString(item.get("shikibetsuCode").toString()).equals(new RString(item2.get("shikibetsuCode").toString()))) {
                    row.setTxtSenkyoShikaku(YamlLoader.getStringText(item2, "選挙資格"));
                    row.setTxtTohyokuCode(YamlLoader.getStringText(item2, "投票区コード"));
                    row.setTxtMeiboBango(YamlLoader.getStringText(item2, "名簿番号"));
//                    row.setTxtMeiboTorokuYMD(YamlLoader.getStringText(item2, "名簿登録日"));
//                    row.setTxtHyojiYMD(YamlLoader.getStringText(item2, "表示年月日"));
                    row.setTxtHyojiJiyu(YamlLoader.getStringText(item2, "表示事由"));
//                    row.setTxtMasshoYMD(YamlLoader.getStringText(item2, "抹消年月日"));
                    row.setTxtMasshoJiyu(YamlLoader.getStringText(item2, "抹消事由"));
                    break;
                }
            }
            dataSource.add(row);
        }

        return dataSource;
    }

}
