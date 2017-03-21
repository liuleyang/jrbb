/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango;

import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * MeiboBangoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してMeiboBangoDivの入力可否、表示・非表示の制御を行ったり、MeiboBangoDivの情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-012 liss
 */
public class MeiboBangoHandler {

    private final MeiboBangoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 発行番号div
     */
    public MeiboBangoHandler(MeiboBangoDiv div) {
        this.div = div;
    }

    /**
     * 引数の帳票IDから、該当する発行番号を入力します。
     *
     */
    public void initialize() {
        if (AFAConfigKeysValue.使用有無_使用しない.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            div.getTxtSatsu().setDisplayNone(Boolean.TRUE);
        }
    }

    /**
     * メンバ変数で保持しているdivへの初期設定をします。
     *
     * @param satsu RString
     * @param page RString
     * @param gyo RString
     */
    public void initialize(RString satsu, Decimal page, Decimal gyo) {
        clear();
        div.getTxtSatsu().setValue(satsu);
        div.getTxtPage().setValue(page);
        div.getTxtGyo().setValue(gyo);
    }

    /**
     * 入力された項目をクリアします。
     */
    public void clear() {
        div.getTxtSatsu().clearValue();
        div.getTxtPage().clearValue();
        div.getTxtGyo().clearValue();
    }

}
