/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMA1030;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintteiji.AFABTA103BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.AFAGMA1030TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.RePrintTeijiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.dgRePrintTeijiShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030.RePrintTeijiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030.RePrintTeijiValidationHandler;
import jp.co.ndensan.reams.af.afa.service.reprintteiji.RePrintTeijiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMA1030 選挙　帳票再発行（定時）<br />
 * RePrintTeijiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public class RePrintTeiji {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.定時登録;
    private static final RString 処理可能な = new RString("処理可能な");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div RePrintTeijiDiv
     * @return ResponseData<RePrintTeijiDiv>
     */
    public ResponseData<RePrintTeijiDiv> onLoad(RePrintTeijiDiv div) {

        RePrintTeijiHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            RePrintTeijiFinder finder = RePrintTeijiFinder.createInstance();
            List<ShohonSenkyoSearchResult> shohonSenkyoList = finder.get抄本選挙一覧().records();
            if (shohonSenkyoList.isEmpty()) {
                return ResponseData.of(div).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            } else {
                handler.set選挙一覧(RePrintTeijiShohonSelect.setData(shohonSenkyoList));
            }
            ViewStateHolder.put(ViewStateKeys.メニューID, ResponseHolder.getMenuID());
            div.getCcdRePrintTeijiSakuseiChohyo().initialize(SENKYO_SHURUI);
        } else {
            return ResponseData.of(div).forwardWithEventName(AFAGMA1030TransitionEventName.メニューへ戻る).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * グリッド選択時のイベントメソッドです。
     *
     * @param div RePrintTeijiDiv
     * @return ResponseData<RePrintTeijiDiv>
     */
    public ResponseData<RePrintTeijiDiv> onSelect_dgRePrintTeijiShohonSelect(RePrintTeijiDiv div) {

        dgRePrintTeijiShohonSelect_Row row
                = div.getRePrintTeijiShohonSelect().getDgRePrintTeijiShohonSelect().getClickedItem();

        div.getCcdRePrintTeijiSakuseiChohyo().initialize(
                new RDate(row.getTxtTennyuKigenYMD().getValue().toString()),
                new RDate(row.getTxtTenshutsuKigenYMD().getValue().toString()),
                new RDate(row.getTxtKijunYMD().getValue().toString()),
                new RDate(row.getTxtKijunYMD().getValue().toString()));

        return ResponseData.of(div).respond();
    }

    /**
     * グリッド選択時のイベントメソッドです。
     *
     * @param div RePrintTeijiDiv
     * @return ResponseData<RePrintTeijiDiv>
     */
    public ResponseData<RePrintTeijiDiv> onBeforeOpenDialog_btnBatchExecute(RePrintTeijiDiv div) {
        ValidationMessageControlPairs controlPairs = new RePrintTeijiValidationHandler(div).validate必須項目();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンを押下します。
     *
     * @param div RePrintTeijiDiv
     * @return ResponseData<AFABTA103BatchParameter>
     */
    public ResponseData<AFABTA103BatchParameter> onClick_btnBatchExecute(RePrintTeijiDiv div) {
        AFABTA103BatchParameter param = getHandler(div).setバッチパラメータ(div);
        return ResponseData.of(param).respond();
    }

    private RePrintTeijiHandler getHandler(RePrintTeijiDiv div) {
        return new RePrintTeijiHandler(div);
    }

}
