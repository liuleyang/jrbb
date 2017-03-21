/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.definition.batchprm.nippo.AFABTE503BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.AFAGME5030TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5030.NippoSakuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * AFAGME5030_日報 <br />
 * NippoSakuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0270-010 xul
 */
public class NippoSakusei {

    private static final RString 処理可能な = new RString("処理可能な");
    private static final boolean 空行作成 = Boolean.TRUE;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel NippoSakuseiDiv
     * @return ResponseData<NippoSakuseiDiv>
     */
    public ResponseData<NippoSakuseiDiv> onLoad(NippoSakuseiDiv mainPanel) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        if (!ResponseHolder.isReRequest()) {
            NippoSakuseiHandler.of(mainPanel).set帳票の出力();

            mainPanel.getCcdNippoShohonSenkyoList().initialize();
            int 抄本List = mainPanel.getCcdNippoShohonSenkyoList().getShohonListSize();
            if (抄本List == 0) {
                return ResponseData.of(mainPanel).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            }

            NippoSakuseiChohyoDiv chohyoDiv = mainPanel.getNippoSakuseiChohyo();
            chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getCcdKijitsumaeNippoShisetsuCode().initialize();
            chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranShisetsuCode().initialize();
            chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranShisetsuCode().initialize();
            chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranShisetsuCode().initialize();
            SenkyoShurui 選挙種類 = mainPanel.getCcdNippoShohonSenkyoList().getCcdShohonNameList().getSelectedSenkyoShurui();
            if (選挙種類 != null) {
                chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranTohyokuCode().initialize(選挙種類);
                chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranTohyokuCode().initialize(選挙種類);
                chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranTohyokuCode().initialize(選挙種類);
                chohyoDiv.getNippoSakuseiChohyoSeirihyo().getCcdSeirihyoTohyokuCode().initialize(選挙種類);
            }
            if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
                mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran()
                        .getCcdTohyoJiyu().initialize(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), 空行作成);
            } else {
                mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoJiyu()
                        .initialize(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), 空行作成);
            }
            mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoSeirihyo().getTxtSeirihyoJuriYMD().setValue(RDate.getNowDate());
            NippoSakuseiHandler.of(mainPanel).set初期化状態();

        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGME5030TransitionEventName.メニューへ戻る).respond();
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param mainPanel NippoSakuseiDiv
     * @return ResponseData<NippoSakuseiDiv>
     */
    public ResponseData<NippoSakuseiDiv> onChange_ccdShohonNameList(NippoSakuseiDiv mainPanel) {

        mainPanel.getCcdNippoShohonSenkyoList().initialSetting();
        SenkyoShurui 選挙種類 = mainPanel.getCcdNippoShohonSenkyoList().getCcdShohonNameList().getSelectedSenkyoShurui();
        mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranTohyokuCode().initialize(選挙種類);
        mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranTohyokuCode().initialize(選挙種類);
        mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranTohyokuCode().initialize(選挙種類);
        mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoSeirihyo().getCcdSeirihyoTohyokuCode().initialize(選挙種類);

        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoJiyu()
                    .initialize(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), 空行作成);
        } else {
            mainPanel.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoJiyu()
                    .initialize(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), 空行作成);
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param mainPanel NippoSakuseiDiv
     * @return ResponseData<NippoSakuseiDiv>
     */
    public ResponseData<NippoSakuseiDiv> onClick_checkbox(NippoSakuseiDiv mainPanel) {
        mainPanel.getCcdNippoShohonSenkyoList().changeflag();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * バッチを起動して帳票を作成する。
     *
     * @param mainPanel NippoSakuseiDiv
     * @return ResponseData<NippoSakuseiDiv>
     */
    public ResponseData<NippoSakuseiDiv> onClick_btnBatchCheck(NippoSakuseiDiv mainPanel) {
        return NippoSakuseiHandler.of(mainPanel).check入力内容();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param mainPanel NippoSakuseiDiv
     * @return ResponseData<NippoSakuseiDiv>
     */
    public ResponseData<AFABTE503BatchParameter> onClick_setBatchParameter(NippoSakuseiDiv mainPanel) {
        return NippoSakuseiHandler.of(mainPanel).set画面入力内容();

    }

}
