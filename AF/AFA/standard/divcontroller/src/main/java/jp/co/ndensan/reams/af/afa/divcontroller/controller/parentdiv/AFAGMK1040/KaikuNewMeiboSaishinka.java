/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMK1040;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.meibosaishinkakaiku.AFABTK104BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuNewMeiboSaishinkaEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikunewmeibosenkyo.KaikuNewMeiBoSenkyoMapperParam;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.AFAGMK1040TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.dgKaikuShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.kaikukewkeibokaishinka.KaikuNewMeiBoSenkyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化 <br />
 * KaikuIdoShikakuIdoShoriDivに対応するコントローラです。
 *
 * @reamsid_L AF-0480-010 liuj
 */
public class KaikuNewMeiboSaishinka {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KaikuNewMeiboSaishinkaDiv
     * @return ResponseData<KaikuNewMeiboSaishinkaDiv>
     */
    public ResponseData<KaikuNewMeiboSaishinkaDiv> onLoad(KaikuNewMeiboSaishinkaDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        ViewState.setメニューID(menuID);
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMK1040TransitionEventName.メニューへ戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            List<KaikuNewMeiBoSenkyoMapperParam> 対象抄本情報リスト = KaikuNewMeiBoSenkyoManager.createInstance().get検索結果一覧();
            if (対象抄本情報リスト.isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(KaikuNewMeiboSaishinkaEnum.画面起動チェック_処理可能な.getValue().toString())).respond();
            }
            new KaikuNewMeiboSaishinkaHandler(div).edit対象抄本Grid(対象抄本情報リスト);
            div.getKaikuNewJoken().getTxtSaishinkaYMD().setValue(RDate.getNowDate());
            div.getCcdKaikuNewSakuseiChohyo().initialize();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * グリッドのイベントメソッドです。
     *
     * @param div KaikuNewMeiboSaishinkaDiv
     * @return ResponseData<KaikuNewMeiboSaishinkaDiv>
     */
    public ResponseData<KaikuNewMeiboSaishinkaDiv> onSelectBySelectButton_closeOK(KaikuNewMeiboSaishinkaDiv div) {
        dgKaikuShohonSelect_Row selectRow = div.getDgKaikuShohonSelect().getClickedItem();
        if (null != selectRow.getTxtSaishinkaYMD()) {
            div.getKaikuNewJoken().getTxtSaishinkaYMD().setValue(new RDate(selectRow.getTxtSaishinkaYMD().getValue().toString()));
        } else {
            div.getKaikuNewJoken().getTxtSaishinkaYMD().setValue(RDate.getNowDate());
        }

        if (null != selectRow.getTxtKijunYMD()) {
            div.getCcdKaikuNewSakuseiChohyo().set時点日(selectRow.getTxtKijunYMD().getValue());
        }
        if (selectRow.getTxtShohonShurui().equals(KaikuNewMeiboSaishinkaEnum.選挙時.getValue())) {
            div.getCcdKaikuNewSakuseiChohyo().edit選挙人名簿最新化(Boolean.TRUE);
        } else {
            div.getCcdKaikuNewSakuseiChohyo().edit選挙人名簿最新化(Boolean.FALSE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行前のイベントメソッドです。
     *
     * @param div KaikuMeiboSakuseiDiv
     * @return ResponseData<KaikuMeiboSakuseiDiv>
     */
    public ResponseData<KaikuNewMeiboSaishinkaDiv> onBeforeOpenDialog_btnBatchExecute(KaikuNewMeiboSaishinkaDiv div) {
        ValidationMessageControlPairs controlErrorPairs = KaikuNewMeiboSaishinkaValidationHandler.of(div).validateチェック();
        if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行する時バッチパラメータ設定
     *
     * @param div KaikuMeiboSakuseiDiv
     * @return AFABTK101BatchParameter
     */
    public ResponseData<AFABTK104BatchParameter> setBatchParameter(KaikuNewMeiboSaishinkaDiv div) {
        AFABTK104BatchParameter param = new AFABTK104BatchParameter();
        dgKaikuShohonSelect_Row selectRow = div.getDgKaikuShohonSelect().getClickedItem();
        param.set抄本番号(selectRow.getTxtShohonNo());
        param.set抄本名(selectRow.getTxtShohonName());
        param.set基準日(edit日付(selectRow.getTxtKijunYMD()));
        param.set名簿確定日(edit日付(selectRow.getTxtMeiboKakuteiYMD()));
        param.set年齢到達日(edit日付(selectRow.getTxtNenreiTotatsuYMD()));
        param.set投票日(edit日付(selectRow.getTxtTohyoYMD()));
        if (selectRow.getTxtNendoSeireki() == null) {
            param.set年度(RString.EMPTY);
        } else {
            param.set年度(selectRow.getTxtNendoSeireki());
        }
        param.set処理日(edit日付(selectRow.getTxtShoriYMD()));
        param.set最新化時点日(selectRow.getTxtSaishinkaYMD().getValue());
        if (div.getRadSort().getSelectedKey().equals(KaikuNewMeiboSaishinkaEnum.あり.getValue())) {
            param.set最新化有無(Boolean.TRUE);
        } else {
            param.set最新化有無(Boolean.FALSE);
        }
        param.set名簿並び替え有無(div.getKaikuNewJoken().getChkOnlyPrint().isAllSelected());
        param.set選挙人名簿抄本出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoMeiboShohon().isIsPublish());
        param.set登録者数リスト出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoTorokushasuList().isIsPublish());
        if (div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue() == null) {
            param.set時点(edit日付(selectRow.getTxtKijunYMD()));
        } else {
            param.set時点(edit日付(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd()));
        }
        param.set登録者名簿出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoIdoTorokushaMeibo().isIsPublish());
        param.set新規登録者宛名シール作成有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().isAllSelected());
        param.set抹消者名簿出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoIdoMasshoshaMeibo().isIsPublish());
        param.set失権者名簿出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoIdoShikkenshaMeibo().isIsPublish());
        param.set表示者名簿出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoIdoHyojishaMeibo().isIsPublish());
        param.set訂正者名簿出力有無(div.getCcdKaikuNewSakuseiChohyo().get海区作成帳票情報().getKaikuSakuseiChohyoIdoTeiseishaMeibo().isIsPublish());

        return ResponseData.of(param).respond();
    }

    private FlexibleDate edit日付(TextBoxDate date) {
        if (null != date.getValue()) {
            return new FlexibleDate(date.getValue().toDateString());
        } else {
            return FlexibleDate.EMPTY;
        }
    }
}
