/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * HakkoBangoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してHakkoBangoDivの入力可否の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 */
public class HakkoBangoHandler {

    private final HakkoBangoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 発行番号div
     */
    public HakkoBangoHandler(HakkoBangoDiv div) {
        this.div = div;
    }

    /**
     * 引数の帳票IDから、該当する発行番号を入力します。
     *
     */
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * メンバ変数で保持しているdivへの初期設定をします。
     *
     * @param chohyoID 帳票ID
     */
    public void initialize(RString chohyoID) {
        clear();
        RString configName1 = chohyoID.concat("_発行番号_第");
        RString configName2 = chohyoID.concat("_発行番号_号");
        RString daiValue = getBusinessConfig(configName1);
        RString goValue = getBusinessConfig(configName2);
        div.getTxtHakkoNoDai().setValue(daiValue);
        div.getTxtHakkoNoBango().setValue(RString.EMPTY);
        div.getTxtHakkoNoGo().setValue(goValue);
    }

    /**
     * 入力された項目をクリアします。
     */
    public void clear() {
        div.getTxtHakkoNoDai().clearValue();
        div.getTxtHakkoNoBango().clearValue();
        div.getTxtHakkoNoGo().clearValue();
    }

    private RString getBusinessConfig(RString configKey) {
        return BusinessConfig.get(ConfigKeysAFA.toValue(configKey), SubGyomuCode.AFA選挙本体);
    }
}
