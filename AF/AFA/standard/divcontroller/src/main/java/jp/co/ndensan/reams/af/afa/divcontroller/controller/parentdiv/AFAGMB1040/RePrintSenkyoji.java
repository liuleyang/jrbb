/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB1040;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintsenkyoji.AFABTB104BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.AFAGMB1040TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiShohonSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040.RePrintSenkyojiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040.RePrintSenkyojiValidationHandler;
import jp.co.ndensan.reams.af.afa.service.reprintsenkyoji.RePrintSenkyojiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMB1040 選挙　帳票再発行（選挙時）<br />
 * RePrintSenkyojiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0060-010 liss
 */
public class RePrintSenkyoji {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.国政選挙_地方選挙;
    private static final RString 処理可能な = new RString("処理可能な");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel RePrintSenkyojiDiv
     * @return ResponseData<RePrintSenkyojiDiv>
     */
    public ResponseData<RePrintSenkyojiDiv> onLoad(RePrintSenkyojiDiv mainPanel) {

        RePrintSenkyojiHandler handler = getHandler(mainPanel);
        if (!ResponseHolder.isReRequest()) {
            RePrintSenkyojiFinder finder = RePrintSenkyojiFinder.createInstance();
            List<Shohon> shohonList = finder.get抄本();
            if (shohonList.isEmpty()) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            } else {
                handler.set選挙一覧(RePrintSenkyojiShohonSelect.setData(shohonList));
                mainPanel.getRePrintSenkyojiShohonSelect().getDgRePrintSenkyojiSenkyoList().getDataSource().clear();
            }
            ViewStateHolder.put(ViewStateKeys.メニューID, ResponseHolder.getMenuID());
            mainPanel.getCcdRePrintSenkyojiSakuseiChohyo().initialize(SENKYO_SHURUI);
            mainPanel.getCcdRePrintSenkyojiSakuseiChohyo().initialize(null, null, null, null);

        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMB1040TransitionEventName.バッチ起動).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 抄本一覧グリッド選択時のイベントメソッドです。
     *
     * @param div RePrintSenkyojiDiv
     * @return ResponseData<RePrintSenkyojiDiv>
     */
    public ResponseData<RePrintSenkyojiDiv> onSelect_dgRePrintSenkyojiShohonSelect(RePrintSenkyojiDiv div) {
        RePrintSenkyojiShohonSelectDiv shohonSelect = div.getRePrintSenkyojiShohonSelect();

        RePrintSenkyojiFinder finder = RePrintSenkyojiFinder.createInstance();
        List<Senkyo> senkyoList = finder.get選挙By抄本番号(
                new ShohonNo(shohonSelect.getDgRePrintSenkyojiShohonSelect().getSelectedItems().get(0).getTxtShohonNo()));

        // 選択した抄本番号より、選挙一覧の作成
        RePrintSenkyojiShohonSelect.setData(shohonSelect, senkyoList);

        // 作成帳票の条件にセット
        getHandler(div).setChohyoYmd();

        return ResponseData.of(div).respond();
    }

    /**
     * グリッド選択時のイベントメソッドです。
     *
     * @param div RePrintSenkyojiDiv
     * @return ResponseData<RePrintSenkyojiDiv>
     */
    public ResponseData<RePrintSenkyojiDiv> onBeforeOpenDialog_btnBatchExecute(RePrintSenkyojiDiv div) {
        ValidationMessageControlPairs controlPairs = new RePrintSenkyojiValidationHandler(div).validate必須項目();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンを押下します。
     *
     * @param div RePrintSenkyojiDiv
     * @return ResponseData<AFABTB104BatchParameter>
     */
    public ResponseData<AFABTB104BatchParameter> onClick_btnBatchExecute(RePrintSenkyojiDiv div) {
        AFABTB104BatchParameter param = getHandler(div).setParamter(div);
        return ResponseData.of(param).respond();
    }

    private RePrintSenkyojiHandler getHandler(RePrintSenkyojiDiv div) {
        return new RePrintSenkyojiHandler(div);
    }
}
