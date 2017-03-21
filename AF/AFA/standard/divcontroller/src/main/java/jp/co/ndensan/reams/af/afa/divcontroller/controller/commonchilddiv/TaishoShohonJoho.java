/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

/**
 * 【共有子Div】TaishoShohonJohoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class TaishoShohonJoho {

//    private TaishoShohonJoho() {
//    }
//
//    /**
//     * 画面ロード時のイベントメソッドです。
//     *
//     * @param div TaishoShohonJohoDiv
//     * @param senkyoShurui SenkyoShurui
//     */
//    public static void onLoad(TaishoShohonJohoDiv div, SenkyoShurui senkyoShurui) {
//
//        div.getCcdShohonNameList().load(senkyoShurui);
//        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
//
//        setData(div);
//
//    }
//
//    /**
//     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
//     *
//     * @param div TaishoShohonJohoDiv
//     */
//    public static void setData(TaishoShohonJohoDiv div) {
//
//        div.getCcdShohonNameList().changeDdlShohon();
//        RString selectedKey = div.getCcdShohonNameList().getTxtHdnShohonNo();
//        div.setTxtHdnShohonNo(selectedKey);
//        setDisplayNone表示(div);
//
//        if (selectedKey.equals(RString.EMPTY)) {
//            TaishoShohonJoho.clearThisPanel(div);
//
//        } else {
//            TaishoShohonJoho.set選択抄本情報(div, selectedKey);
//        }
//    }
//
//    /**
//     * 抄本番号取得時の処理をするメソッドです。
//     *
//     * @param div TaishoShohonJohoDiv
//     * @param shohonNo RString
//     */
//    public static void setData(TaishoShohonJohoDiv div, RString shohonNo) {
//        TaishoShohonJoho.set選択抄本情報(div, shohonNo);
//        div.setTxtHdnShohonNo(shohonNo);
//        setDisplayNone表示(div);
//    }
//
//    private static void setDisplayNone表示(TaishoShohonJohoDiv div) {
//        div.getTxtKijunYMD().setDisplayNone(false);
//        div.getTxtTohyoYMD().setDisplayNone(false);
//        div.getTxtMeiboTorokuYMD().setDisplayNone(false);
//        div.getTxtNenreiTotatsuYMD().setDisplayNone(false);
//        div.getTxtTenshutsuKigenYMD().setDisplayNone(false);
//        div.getTxtTennyuKigenYMD().setDisplayNone(false);
//        if (div.getTxtHdnSenkyoShurui().equalsIgnoreCase(SenkyoShurui.農業委員会委員選挙.getCode())) {
//            div.getTxtMeiboTorokuYMD().setLabelLText(new RString("名簿確定日"));
//            div.getTxtTenshutsuKigenYMD().setDisplayNone(true);
//            div.getTxtTennyuKigenYMD().setDisplayNone(true);
//        }
//    }
//
//    private static void clearThisPanel(TaishoShohonJohoDiv div) {
//////        div.getDdlShohon().setSelectedItem(RString.EMPTY);
////        div.getCcdShohonNameList().getDdlShohon().setSelectedItem(RString.EMPTY);
//        div.getCcdShohonNameList().selectedShohon(RString.EMPTY);
//        div.getTxtShohonName().clearValue();
//        div.getTxtKijunYMD().clearValue();
//        div.getTxtTohyoYMD().clearValue();
//
//        div.getTxtMeiboTorokuYMD().clearValue();
//        div.getTxtTennyuKigenYMD().clearValue();
//        div.getTxtTenshutsuKigenYMD().clearValue();
//        div.getTxtNenreiTotatsuYMD().clearValue();
//
//        div.setTxtHdnSenkyoShurui(RString.EMPTY);
//        div.setTxtHdnShohonNo(RString.EMPTY);
//    }
//
//    private static void set選択抄本情報(TaishoShohonJohoDiv div, RString shohonNo) throws IllegalArgumentException {
//        RString yamlShohonFile = new RString("ShohonSenkyoji.yml");
//
//        if ((shohonNo.toString().equalsIgnoreCase("1"))
//                || (shohonNo.toString().equalsIgnoreCase("2"))
//                || (shohonNo.toString().equalsIgnoreCase("3"))) {
//            yamlShohonFile = new RString("ShohonTeiji.yml");
//        }
//        if (shohonNo.toString().equalsIgnoreCase("101")) {
//            yamlShohonFile = new RString("ShohonKokumin.yml");
//        }
//        if (shohonNo.toString().equalsIgnoreCase("1001")) {
//            yamlShohonFile = new RString("ShohonNogyo.yml");
//        }
//
//        List<HashMap> source = YamlLoader.loadAsList(yamlShohonFile);
//        for (HashMap item : source) {
//            if (new RString(item.get("key").toString()).equals(shohonNo)) {
//                div.setTxtHdnSenkyoShurui(new RString(item.get("選挙種類").toString()));
//                div.getTxtShohonName().setValue(YamlLoader.getStringText(item, "抄本名"));
//                div.getTxtTohyoYMD().setValue(YamlLoader.getTextBoxDateText(item, "投票年月日").getValue());
//                div.getTxtKijunYMD().setValue(YamlLoader.getTextBoxDateText(item, "名簿基準年月日").getValue());
//                div.getTxtMeiboTorokuYMD().setValue(YamlLoader.getTextBoxDateText(item, "名簿登録年月日").getValue());
//                if (!new RString(item.get("転入期限年月日").toString()).isEmpty()) {
//                    div.getTxtTennyuKigenYMD().setValue(YamlLoader.getTextBoxDateText(item, "転入期限年月日").getValue());
//                }
//                if (!new RString(item.get("転出期限年月日").toString()).isEmpty()) {
//                    div.getTxtTenshutsuKigenYMD().setValue(YamlLoader.getTextBoxDateText(item, "転出期限年月日").getValue());
//                }
//                div.getTxtNenreiTotatsuYMD().setValue(YamlLoader.getTextBoxDateText(item, "規定年齢到達年月日").getValue());
//                break;
//            }
//        }
//    }
}
