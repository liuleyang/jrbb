/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB2020;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.NyujokenKobetsuSakuseiTaishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.dgNyujokenKobetsuTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 【View】NyujokenSakuseiKobetsuDiv内の <br />
 * NyujokenKobetsuSakuseiTaishoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class NyujokenKobetsuSakuseiTaisho {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div NyujokenKobetsuSakuseiTaishoDiv
     * @param shohonNo 抄本番号
     */
    public static void onLoad(NyujokenKobetsuSakuseiTaishoDiv div, RString shohonNo) {
        // 本来は管理情報からセットする
        div.getNyujokenKobetsuSentaku().getTxtNyujokenType().setValue(new RString("シーラー"));
        final int six = 6;
        div.getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().setValue(new Decimal(six));

        if ((div.getNyujokenKobetsuSentaku().getTxtNyujokenType().getValue().equals(new RString("シーラー")))
                || (div.getNyujokenKobetsuSentaku().getTxtNyujokenType().getValue().equals(new RString("ポステックス")))) {
            div.getNyujokenKobetsuSentaku().getRadHakkoTani().setDisplayNone(true);
            div.getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().setDisplayNone(false);
//            div.getNyujokenKobetsuSentaku().getChkSetaiIchiran().setDisplayNone(false);
        } else {
            div.getNyujokenKobetsuSentaku().getRadHakkoTani().setDisplayNone(false);
            div.getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().setDisplayNone(true);
//            div.getNyujokenKobetsuSentaku().getChkSetaiIchiran().setDisplayNone(true);
        }

        setData(div, shohonNo);
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NyujokenKobetsuSakuseiTaishoDiv
     * @param shohonNo RString
     */
    public static void setData(NyujokenKobetsuSakuseiTaishoDiv div, RString shohonNo) {

        if (shohonNo.equals(RString.EMPTY)) {
            clearThisPanel(div);

        } else {
            set選択抄本情報(div, shohonNo);
        }
    }

    /**
     * 選挙人検索ボタン（簡易版）の確定クローズイベントメソッドです。
     *
     * @param div NyujokenKobetsuSakuseiTaishoDiv
     * @return ResponseData<NyujokenKobetsuSakuseiTaishoDiv>
     */
    public ResponseData<NyujokenKobetsuSakuseiTaishoDiv> onOkClose_btnSearchSimple(NyujokenKobetsuSakuseiTaishoDiv div) {

        // もともと何か入ってるかもしれないので、Emptyの時には何もしない
        if (!div.getTxtHdnShikibetsuCode().isEmpty()) {
            //TODO hiddenInputの抄本番号と選挙種類を渡して、住民検索画面を呼び出す。（住民検索画面では選挙種類、抄本DDLは使用不可にする）
            // 戻ってくるのは、たぶん識別コード（複数件はどう戻ってくる？List？？）なので、
            // それを使用して住基情報を取得して、ほかにもチェックして、グリッドに追加する。という処理をここに書く。
            createDataSourceFrom識別コード(div, new ShikibetsuCode(div.getTxtHdnShikibetsuCode()));
        }
        div.setTxtHdnShikibetsuCode(RString.EMPTY);

        ResponseData<NyujokenKobetsuSakuseiTaishoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private static void createDataSourceFrom識別コード(NyujokenKobetsuSakuseiTaishoDiv div, ShikibetsuCode shikibetsuCode) {
        // ①入力された抄本番号、施設コードで取得した中で、同一人がいないかのチェック
        List<dgNyujokenKobetsuTaishosha_Row> dataSource = div.getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource();
        for (dgNyujokenKobetsuTaishosha_Row row : dataSource) {
            if (row.getTxtShikibetsuCode().equals(shikibetsuCode.value())) {
                // 本来、同一識別コードがいた場合はエラーにする（TODO　エラーメッセージ考えること）
                throw new ApplicationException(AfErrorMessages.選択済み確認.getMessage());
            }
        }

        // エラーにならなければ、ここでセットされる
        dataSource.add(createDataRowFrom識別コード(shikibetsuCode));
//        return dataSource;
    }

    private static dgNyujokenKobetsuTaishosha_Row createDataRowFrom識別コード(ShikibetsuCode shikibetsuCode) {
        List<HashMap> source = YamlLoader.loadAsList(new RString("AtenaJoho.yml"));
        dgNyujokenKobetsuTaishosha_Row row = new dgNyujokenKobetsuTaishosha_Row();
        for (HashMap item : source) {
            if (new RString(item.get("shikibetsuCode").toString()).equals(shikibetsuCode.value())) {
//            Button deleteButton = new Button();
//            deleteButton.setText(new RString("×"));
//            row.setBtnDelete(deleteButton);
                row.setBtnDelete(new Button());
//                if (isDisabled) {
//                    row.setDeleteButtonState(DataGridButtonState.Disabled);
//                }
                row.setTxtShimei(YamlLoader.getStringText(item, "氏名"));
                if (!new RString(item.get("生年月日").toString()).isEmpty()) {
                    row.setTxtSeinengappiYMD(YamlLoader.getTextBoxDateText(item, "生年月日"));
                }
                row.setTxtSeibetsu(YamlLoader.getStringText(item, "性別"));
                row.setTxtJuminShubetsu(YamlLoader.getStringText(item, "住民種別"));
                row.setTxtShikibetsuCode(YamlLoader.getStringText(item, "shikibetsuCode"));
                row.setTxtSetaiCode(YamlLoader.getStringText(item, "世帯コード"));
                row.setTxtJusho(YamlLoader.getStringText(item, "住所"));
                break;
            }
        }
        return row;
    }

    /**
     * グリッド内の削除ボタンクリック時のイベントメソッドです。
     *
     * @param div NyujokenKobetsuSakuseiTaishoDiv
     * @return ResponseData<NyujokenKobetsuSakuseiTaishoDiv>
     */
    public ResponseData<NyujokenKobetsuSakuseiTaishoDiv> onClick_dgNyujokenKobetsuTaishosha_btnDelete(NyujokenKobetsuSakuseiTaishoDiv div) {

        div.getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource().
                remove(div.getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getClickedRowId());

        ResponseData<NyujokenKobetsuSakuseiTaishoDiv> response = new ResponseData();
        response.data = div;
        return response;
    }

    private static void clearThisPanel(NyujokenKobetsuSakuseiTaishoDiv div) {
        //div.getNyujokenKobetsuSentaku().getTxtShohonName().clearValue();
        div.getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource().clear();
//        div.getNyujokenKobetsuSentaku().getChkSetaiIchiran().getSelectedItems().clear();
    }

    private static void set選択抄本情報(NyujokenKobetsuSakuseiTaishoDiv div, RString shohonNo) {
        // 抄本情報
        RString senkyoShurui;
        List<HashMap> source = YamlLoader.loadAsList(new RString("Shohon.yml"));
        for (HashMap item : source) {
            if (new RString(item.get("key").toString()).equals(shohonNo)) {
                //div.getNyujokenKobetsuSentaku().getTxtShohonName().setValue(YamlLoader.getTextBoxText(item, "抄本名").getValue());
                senkyoShurui = new RString(item.get("選挙種類").toString());

                div.setTxtHdnShohonNo(shohonNo);
                div.setTxtHdnSenkyoShurui(senkyoShurui);
                break;
            }
        }
    }

//    private List<dgNyujokenKobetsuTaishosha_Row> createDataSource() {
//        RString yamlSenkyoFile = new RString("AtenaJoho.yml");
//        List<HashMap> sourceKekka = YamlLoader.loadAsList(yamlSenkyoFile);
//
//        List<dgNyujokenKobetsuTaishosha_Row> dataSource = new ArrayList<>();
//        for (HashMap item : sourceKekka) {
//            // AtenaJoho.ymlから適当に選択して追加
//            if ((new RString(item.get("key").toString()).equals(new RString("7")))
//                    || (new RString(item.get("key").toString()).equals(new RString("11")))
//                    || (new RString(item.get("key").toString()).equals(new RString("13")))) {
//                dgNyujokenKobetsuTaishosha_Row row = new dgNyujokenKobetsuTaishosha_Row();
////                Button deleteButton = new Button();
////                deleteButton.setText(new RString("×"));
////                row.setBtnDelete(deleteButton);
//                row.setBtnDelete(new Button());
//                row.setTxtShimei(YamlLoader.getStringText(item, "氏名"));
//                row.setTxtSeinengappiYMD(YamlLoader.getTextBoxDateText(item, "生年月日"));
//                row.setTxtSeibetsu(YamlLoader.getStringText(item, "性別"));
//                row.setTxtJusho(YamlLoader.getStringText(item, "住所"));
//                row.setTxtJuminShubetsu(YamlLoader.getStringText(item, "住民種別"));
//                row.setTxtShikibetsuCode(YamlLoader.getStringText(item, "shikibetsuCode"));
//                row.setTxtSetaiCode(YamlLoader.getStringText(item, "世帯コード"));
//                dataSource.add(row);
//            }
//        }
//        return dataSource;
//    }
}
