/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

/**
 * 共通関数
 *
 * @author N1823 有澤 礼恵
 */
public final class CommonFunction {

    private CommonFunction() {

    }

    /**
     * シミュレーション画面の場合は{@code true}、本番起動画面の場合は{@code false}を返します。
     *
     * @return シミュレーション画面の場合{@code true}、本番起動画面の場合{@code false}
     */
    public static boolean isSimulation() {
        // Trueの時、シミュレーション画面。Falseの時は、本番起動画面。
        // TODO まだメニューIDが取れないので、常に本番判定として返す。取れるようになったら修正する
        return false;
//        RString menuID = _ControlDataHolder.getControlData().getMenuID();
//        return (menuID.equalsIgnoreCase("AFAMNA2001"))
//                || (menuID.equalsIgnoreCase("AFAMNB4001")) || (menuID.equalsIgnoreCase("AFAMNB4002"))
//                || (menuID.equalsIgnoreCase("AFAMNE6001")) || (menuID.equalsIgnoreCase("AFAMNE6002"));
    }

}
