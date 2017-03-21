/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB2010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.AFABTB201BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.AFAGMB2010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiIkkatsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010.NyujokenSakuseiIkkatsuHandler;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGMB2010 選挙　入場券作成（一括）<br />
 * NyujokenSakuseiIkkatsuDivに対するコントローラです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public class NyujokenSakuseiIkkatsu {

    private static final RString 処理可能な = new RString("処理可能な");
    private static final RString ZERO = new RString("0");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel NyujokenSakuseiIkkatsuDiv
     * @return ResponseData<NyujokenSakuseiIkkatsuDiv>
     */
    public ResponseData<NyujokenSakuseiIkkatsuDiv> onLoad(NyujokenSakuseiIkkatsuDiv mainPanel) {

        if (!ResponseHolder.isReRequest()) {
            mainPanel.getCcdNyujokenShohonSelect().initialize();
            int 抄本Size = mainPanel.getCcdNyujokenShohonSelect().getCcdShohonNameList().getShohonListSize();
            if (抄本Size == 0) {
                return ResponseData.of(mainPanel).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            }
            RString 選挙種類 = mainPanel.getCcdNyujokenShohonSelect().getCcdShohonNameList().getSelectedSenkyoShurui().getCode();
            RString 印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
            RString 世帯印字人数 = BusinessConfig.get(ConfigKeysAFA.入場券_世帯印字人数, SubGyomuCode.AFA選挙本体);
            RString 世帯一覧人数 = BusinessConfig.get(ConfigKeysAFA.世帯一覧_抽出対象世帯人数_初期値, SubGyomuCode.AFA選挙本体);
            mainPanel.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtNyujokenType().setValue(
                    AFAInsakuTypeEnum.getAFAInsakuTypeEnumByCode(印刷タイプ).getValue());
            if (!世帯印字人数.isNullOrEmpty()) {
                mainPanel.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtPrintNinzutxtNyujokenType().setValue(new Decimal(世帯印字人数.toString()));
            }
            mainPanel.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtSetaiNinzu().setValue(世帯一覧人数);

            NyujokenSakuseiIkkatsuHandler.of(mainPanel).set画面状態1(選挙種類, 印刷タイプ);
        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMB2010TransitionEventName.メニューへ戻る).respond();
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiIkkatsuDiv
     * @return ResponseData<NyujokenSakuseiIkkatsuDiv>
     */
    public ResponseData<NyujokenSakuseiIkkatsuDiv> onChange_ccdShohonNameList(NyujokenSakuseiIkkatsuDiv div) {
        ResponseData<NyujokenSakuseiIkkatsuDiv> response = new ResponseData<>();
        div.getCcdNyujokenShohonSelect().initialSetting();
        RString 選挙種類 = div.getCcdNyujokenShohonSelect().getCcdShohonNameList().getSelectedSenkyoShurui().getCode();
        RString 印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        NyujokenSakuseiIkkatsuHandler.of(div).set画面状態1(選挙種類, 印刷タイプ);

        response.data = div;
        return response;
    }

    /**
     * 「転出者分」チェックボックス選択時の処理をするメソッドです。
     *
     * @param div NyujokenSakuseiTaishoDiv
     * @return ResponseData<NyujokenSakuseiIkkatsuDiv>
     */
    public ResponseData<NyujokenSakuseiIkkatsuDiv> onChange_chkTaisho(NyujokenSakuseiIkkatsuDiv div) {
        ResponseData<NyujokenSakuseiIkkatsuDiv> response = new ResponseData<>();
        List<RString> 転出者分リスト = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkTaisho().getSelectedKeys();
        if (BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体).equals(TWO)) {
            if (転出者分リスト.contains(TWO)) {
                NyujokenSakuseiIkkatsuHandler.of(div).set画面状態3();
            } else {
                NyujokenSakuseiIkkatsuHandler.of(div).set画面状態2();
            }
        }
        response.data = div;
        return response;
    }

    /**
     * 「実行する」ボタン押下時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<AFABTB201BatchParameter> onClick_setBatchParameter(NyujokenSakuseiIkkatsuDiv div) {
        ResponseData<AFABTB201BatchParameter> response = new ResponseData<>();
        RString menuId = ResponseHolder.getMenuID();
        response.data = NyujokenSakuseiIkkatsuHandler.of(div).set画面入力内容(menuId);
        return response;
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<NyujokenSakuseiIkkatsuDiv> onClick_btnBatchCheck(NyujokenSakuseiIkkatsuDiv div) {
        RString 抄本番号 = div.getCcdNyujokenShohonSelect().getCcdShohonNameList().getSelectedShohonNo();
        NyujokenIkkatsuFinder finder = NyujokenIkkatsuFinder.createInstance();
        FlexibleDate 転出年月日 = null;
        if (null != finder.select転出期限年月日MIN(new ShohonNo(抄本番号))) {
            転出年月日 = finder.select転出期限年月日MIN(new ShohonNo(抄本番号)).getTenshutsuKigenYMD();
        }
        RDate 転出日To = null;
        if (null != div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getTxtTohyoYMD()) {
            転出日To = div.getCcdNyujokenShohonSelect().get抄本選択共有情報().getTxtTohyoYMD().getValue();
        }
        if (BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体).equals(ZERO)
                && null != 転出日To) {
            転出日To = 転出日To.minusDay(1);
        } else if (BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体).equals(TWO)) {
            転出日To = RDate.getNowDate().minusDay(1);
        } else if (BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体).equals(THREE)) {
            転出日To = RDate.getNowDate();
        }
        if (null != 転出年月日) {
            div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().setHidden転出日From(転出年月日.seireki().toDateString());
        }
        if (null != 転出日To) {
            div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().setHidden転出日To(転出日To.toDateString());
        }
        return NyujokenSakuseiIkkatsuHandler.of(div).check入力内容();
    }
}
