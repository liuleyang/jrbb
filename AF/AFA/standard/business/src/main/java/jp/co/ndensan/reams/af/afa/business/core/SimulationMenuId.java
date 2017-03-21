/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * シミュレーション関連クラスです。
 *
 * @reamsid_L AF-0010-014 gaoya
 */
public class SimulationMenuId {

    /**
     * コンストラクス。
     */
    public SimulationMenuId() {
    }

    /**
     * シミュレーションかどうかを返す。
     *
     * @param menuID メニューID
     * @return シミュレーションかどうか
     */
    public Boolean isSimulationMenuId(RString menuID) {

        return menuID.startsWith(new RString("AFAMNA2")) || menuID.startsWith(new RString("AFAMNB4"))
                || menuID.startsWith(new RString("AFAMNE7"));
    }
}
