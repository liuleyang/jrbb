/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * SakuseiChohyoPrintNaiyoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してSakuseiChohyoPrintNaiyoDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 */
public class SakuseiChohyoPrintNaiyoHandler {

    private final SakuseiChohyoPrintNaiyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 作成帳票印刷内容Div
     */
    public SakuseiChohyoPrintNaiyoHandler(SakuseiChohyoPrintNaiyoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param chohyoID 帳票ID
     */
    public void initialize(RString chohyoID) {
        this.clearData();
        initialize(chohyoID, new RDate(RDate.getNowDate().wareki().toDateString().toString()));
    }

    /**
     * 引数の帳票ID、発行日から、帳票印字内容の初期表示を行います。
     *
     * @param chohyoID RString 帳票ID
     * @param hakkoYMD RDate 発行日
     */
    public void initialize(RString chohyoID, RDate hakkoYMD) {
        div.getTxtHakkoYMD().setValue(hakkoYMD);
        div.getCcdHakkoBango().initialize(chohyoID);
        div.getTxtIinchoName().setValue(BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体));
    }

    /**
     * 各項目をクリアします。
     */
    public void clearData() {
        div.getTxtHakkoYMD().clearValue();
        div.getCcdHakkoBango().clear();
        div.getTxtIinchoName().clearValue();
    }

}
