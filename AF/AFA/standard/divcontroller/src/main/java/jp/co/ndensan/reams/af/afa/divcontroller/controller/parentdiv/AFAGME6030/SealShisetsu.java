/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME6030;

import java.util.ArrayList;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.AFABTE6010BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6030.SealShisetsuHandler;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME6030 施設宛名シール <br />
 * SealShisetsuDivに対するコントローラです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public class SealShisetsu {

    private static final RString 位置指定区分の表示有無 = new RString("FALSE");
    private static final RString 位置指定区分 = new RString("2");
    private static final RString 印字開始位置 = new RString("1");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onLoad(SealShisetsuDiv div) {
        CodeShubetsu コード種別 = AFACodeShubetsu.施設種別.getCodeShubetsu();

        div.getSealShisetsuParam().getCcdShisetsuShubetsu().load(コード種別);
        div.getSealShisetsuParam().getCcdShisetsuCodeRange().initialize(RString.EMPTY, RString.EMPTY, null);
        div.getSealShisetsuParam().getSealShisetsuNaiyo().getCcdSealLayout().initialize();
        div.getSealShisetsuParam().getCcdSealPosition().initialize();
        RString mensu = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
        div.getCcdSealPosition().load(位置指定区分の表示有無, 位置指定区分, new ArrayList<RString>(), 印字開始位置, mensu);

        return ResponseData.of(div).respond();

    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onClick_btnCheck(SealShisetsuDiv div) {
        return SealShisetsuHandler.of(div).check入力内容();
    }

    /**
     * 「実行する」ボタン押下時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<AFABTE6010BatchParameter> onClick_setBatchParameter(SealShisetsuDiv div) {
        AFABTE6010BatchParameter parm = SealShisetsuHandler.of(div).setBatchParameter();
        return ResponseData.of(parm).respond();
    }

    /**
     *
     * 施設種別のonChangeイベント
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onChange_ccdShisetsuShubetsu(SealShisetsuDiv div) {
        RString focusID = div.getSealShisetsuParam().getCcdShisetsuShubetsu().getCode().value();
        if (!focusID.isEmpty()) {
            div.getCcdShisetsuCodeRange().initialize(RString.EMPTY, RString.EMPTY, ShisetsuShubetsu.toValue(focusID));
            div.getCcdShisetsuCodeRange().clearData();
        } else {
            div.getCcdShisetsuCodeRange().initialize(RString.EMPTY, RString.EMPTY, null);
            div.getCcdShisetsuCodeRange().clearData();
        }
        return ResponseData.of(div).respond();
    }

    /**
     *
     * 施設範囲選択FromのonChangeイベント
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onChange_txtShisetsuCodeFrom(SealShisetsuDiv div) {
        return SealShisetsuHandler.of(div).施設コードFrom_ChangeEvent();
    }

    /**
     *
     * 施設範囲選択ToのonChangeイベント
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onChange_txtShisetsuCodeTo(SealShisetsuDiv div) {
        return SealShisetsuHandler.of(div).施設コードTo_ChangeEvent();
    }

    /**
     *
     * 施設範囲選択Fromのダイアログ入力OKCloseボタンイベント
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onClick_OKCloseFrom(SealShisetsuDiv div) {
        return SealShisetsuHandler.of(div).施設コードFrom_ChangeEvent();
    }

    /**
     *
     * 施設範囲選択Toのダイアログ入力OKCloseボタンイベント
     *
     * @param div SealShisetsuDiv
     * @return ResponseData<SealShisetsuDiv>
     */
    public ResponseData<SealShisetsuDiv> onClick_OKCloseTo(SealShisetsuDiv div) {
        return SealShisetsuHandler.of(div).施設コードTo_ChangeEvent();
    }

}
