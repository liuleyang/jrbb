/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMF1010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.meibochoseifilesakusei.AFABTF101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.処理可能な;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.最新有権者情報ファイル;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1010.AFAGMF1010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1010.SaibaninYoteiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
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
 * AFAGMF1010 名簿調製用連携ファイル作成 <br />
 * SaibaninYoteiSelectDivに対応するコントローラです。
 *
 * @reamsid_L AF-0300-010 guancy
 */
public class SaibaninYoteiSelect {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SaibaninYoteiSelectDiv
     * @return ResponseData<SaibaninYoteiSelectDiv>
     */
    public ResponseData<SaibaninYoteiSelectDiv> onLoad(SaibaninYoteiSelectDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGMF1010TransitionEventName.メニューへ戻る).respond();
        }
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(true);
        div.getCcdShohonNameList().initialize(SenkyoShurui.国政選挙_地方選挙, true);
        RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
        int shohonListSize = div.getCcdShohonNameList().getShohonListSize();
        if (shohonListSize > 0 && shohon過去 != null) {
            div.getCcdShohonNameList().selectedShohon(shohon過去);
        } else {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.getKey().toString())).respond();
        }
        div.getTxtHozonFileName().setValue(最新有権者情報ファイル.getKey());
        div.getTxtNenrei().setValue(new Decimal(BusinessConfig.get(ConfigKeysAFA.名簿調製_抽出対象年齢, RDate.getNowDate(), SubGyomuCode.AFA選挙本体).toString()));
        div.getTxtNenreiKijunYMD().setValue(get年齢計算基準日(BusinessConfig.get(ConfigKeysAFA.名簿調製_年齢計算基準月日, SubGyomuCode.AFA選挙本体)));
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時の実行です。
     *
     * @param div SaibaninYoteiSelectDiv
     * @return ResponseData<SaibaninYoteiSelectDiv>
     */
    public ResponseData<AFABTF101BatchParameter> onClick_batchExecute(SaibaninYoteiSelectDiv div) {
        div.getCcdShohonNameList().changeDdlShohon();
        AFABTF101BatchParameter parameter = new AFABTF101BatchParameter();
        parameter.set抄本番号(div.getCcdShohonNameList().getSelectedShohonNo());
        parameter.setファイル名(div.getTxtHozonFileName().getValue());
        parameter.set抽出対象年齢(div.getTxtNenrei().getValue().intValue());
        parameter.set年齢計算基準日(new FlexibleDate(div.getTxtNenreiKijunYMD().getValue().toDateString()));
        return ResponseData.of(parameter).respond();
    }

    private RDate get年齢計算基準日(RString date) {
        return new RDate(RDate.getNowDate().getYearValue() + 1, Integer.valueOf(date.substring(0, 2).toString()), Integer.valueOf(date.substring(2, 2 + 2).toString()));
    }

}
