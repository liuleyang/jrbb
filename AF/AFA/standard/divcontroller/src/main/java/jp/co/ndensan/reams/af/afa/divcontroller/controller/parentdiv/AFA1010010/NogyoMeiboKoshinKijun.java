/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFA1010010;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010010.NogyoMeiboKoshinKijunDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【View】NogyoMeiboSakuseiDiv内の<br />
 * NogyoMeiboKoshinKijunDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class NogyoMeiboKoshinKijun {

    private static final RString 新規登録 = new RString("key0");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div NogyoMeiboKoshinKijunDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void initialize(NogyoMeiboKoshinKijunDiv div, SenkyoShurui senkyoShurui) {
        div.getCcdShohonNameList().initialize(senkyoShurui, Boolean.TRUE);
    }

    /**
     * 新規処理と再処理のラジオボタンクリック時のイベントメソッドです。
     *
     * @param div NogyoMeiboKoshinKijunDiv
     * @return ResponseData<NogyoMeiboKoshinKijunDiv>
     */
    public ResponseData<NogyoMeiboKoshinKijunDiv> onClick_radShori(NogyoMeiboKoshinKijunDiv div) {

        clearThisPanel(div);

        div.getCcdShohonNameList().setReadOnlyMode(Boolean.FALSE);
        if (div.getRadShori().getSelectedKey().equals(新規登録)) {
            div.getCcdShohonNameList().setReadOnlyMode(Boolean.TRUE);

        } else {
            div.getCcdShohonNameList().initialSetting();
            set選択抄本情報(div, div.getCcdShohonNameList().getSelectedShohonNo());
        }
        return getResponseData(div);
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div NogyoMeiboKoshinKijunDiv
     * @return ResponseData<NogyoMeiboKoshinKijunDiv>
     */
    public ResponseData<NogyoMeiboKoshinKijunDiv> onChange_ccdShohonNameList(NogyoMeiboKoshinKijunDiv div) {

        div.getCcdShohonNameList().changeDdlShohon();
        RString selectedKey = div.getCcdShohonNameList().getSelectedShohonNo();
        if (selectedKey.equals(RString.EMPTY)) {
            clearThisPanel(div);

        } else {
            set選択抄本情報(div, selectedKey);
        }

        return getResponseData(div);
    }

    private void clearThisPanel(NogyoMeiboKoshinKijunDiv div) {

//        div.getCcdShohonNameList().getDdlShohon().setSelectedItem(RString.EMPTY);
        div.getCcdShohonNameList().selectedShohon(RString.EMPTY);
        div.getTxtShohonName().clearValue();
        div.getRadSakuseiKijun().setSelectedKey(new RString("key0"));

        div.getTxtKijunYMD().clearValue();
        div.getTxtKakuteiYMD().clearValue();
        div.getTxtNenreiTotatsuYMD().clearValue();
    }

    /**
     * 日付設定ボタンクリック時のイベントメソッドです。
     *
     * @param div NogyoMeiboKoshinKijunDiv
     * @return ResponseData<NogyoMeiboKoshinKijunDiv>
     */
    public ResponseData<NogyoMeiboKoshinKijunDiv> onClick_btnSetYmd(NogyoMeiboKoshinKijunDiv div) {

        final int april = 3;
        final int thirty_first = 31;
        div.getTxtKakuteiYMD().setValue(
                new RDate(div.getTxtKijunYMD().getValue().getYear().getYearValue(), april, thirty_first));
        div.getTxtNenreiTotatsuYMD().setValue(div.getTxtKakuteiYMD().getValue().plusDay(1));

        return getResponseData(div);

    }

    private void set選択抄本情報(NogyoMeiboKoshinKijunDiv div, RString selectedKey) throws IllegalArgumentException {

        RString yamlShohonFile = new RString("ShohonNogyo.yml");
        List<HashMap> source = YamlLoader.loadAsList(yamlShohonFile);
        for (HashMap item : source) {
            if (new RString(item.get("key").toString()).equals(selectedKey)) {
                div.getTxtShohonName().setValue(YamlLoader.getStringText(item, "抄本名"));
                div.getTxtKijunYMD().setValue(YamlLoader.getTextBoxDateText(item, "名簿基準年月日").getValue());
                div.getTxtKakuteiYMD().setValue(YamlLoader.getTextBoxDateText(item, "名簿登録年月日").getValue());
                div.getTxtNenreiTotatsuYMD().setValue(YamlLoader.getTextBoxDateText(item, "規定年齢到達年月日").getValue());
                break;
            }
        }
    }

    private ResponseData<NogyoMeiboKoshinKijunDiv> getResponseData(NogyoMeiboKoshinKijunDiv div) {
        ResponseData<NogyoMeiboKoshinKijunDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

}
