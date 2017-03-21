/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME3010;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010.TojitsuTohyoJokyoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010.TojitsuTohyoValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 【View】TojitsuTohyoJokyoDiv内の <br />
 * TojitsuTohyoJokyoDivに対するコントローラです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoJokyo {

    private static final RString 初期選択 = new RString("1");
    private static final RString 集計単位KEY_15分 = new RString("1");
    private static final RString 集計単位KEY_30分 = new RString("2");
    private static final RString 集計単位KEY_60分 = new RString("3");
    private static final RString 集計単位KEY_任意 = new RString("4");
    private static final int 集計単位_15分 = 15;
    private static final int 集計単位_30分 = 30;
    private static final int 集計単位_60分 = 60;

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div TojitsuTohyoJokyoDiv
     * @param 抄本番号 抄本番号
     * @param 選挙種類 SenkyoShurui
     */
    public static void setData(TojitsuTohyoJokyoDiv div, RString 抄本番号, SenkyoShurui 選挙種類) {

        div.setTxtHdnShohonNo(抄本番号);
        if (抄本番号.equals(RString.EMPTY)) {
            div.getRadSenkyoNo().getDataSource().clear();
            div.getDgTojitsuTohyoShukei().getDataSource().clear();

        } else {
            div.getCcdTojitsuTohyokuCode().initialize(div.getTxtHdnTohyokuCode());
            div.getRadSenkyoNo().setDataSource(getHandler().getSenkyoDataSource(抄本番号));
            div.getRadSenkyoNo().setSelectedKey(初期選択);
            div.getRadShukeiTani().setSelectedKey(集計単位KEY_30分);
            div.getTxtTime().setDisabled(true);
            div.getTxtTime().clearValue();
            div.setTxtHdnSenkyoShurui(選挙種類.getCode());
            div.setTxtHdnShohonNo(抄本番号);
            RString 集計単位Key = div.getRadShukeiTani().getSelectedKey();
            if (集計単位Key.equals(集計単位KEY_任意)) {
                div.getTxtTime().setDisabled(false);
                div.getTxtTime().setReadOnly(false);
                div.getTxtTime().setRequired(true);
            } else {
                int 集計単位 = get集計単位(div, 集計単位Key);
                div.getDgTojitsuTohyoShukei().setDataSource(
                        getHandler().createTohyoJokyoShukeiDataSource(div.getCcdTojitsuTohyokuCode().get投票区コード(),
                                選挙種類, 集計単位, 抄本番号, div.getRadSenkyoNo().getSelectedKey()));
            }
        }
    }

    /**
     * 選挙番号ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div TojitsuTohyoJokyoDiv
     * @return ResponseData<TojitsuTohyoJokyoDiv>
     */
    public ResponseData<TojitsuTohyoJokyoDiv> onClick_radSenkyoNo(TojitsuTohyoJokyoDiv div) {
        div.getDgTojitsuTohyoShukei().getDataSource().clear();
        RString 集計単位Key = div.getRadShukeiTani().getSelectedKey();
        if (集計単位Key.equals(集計単位KEY_任意)) {
            div.getTxtTime().setDisabled(false);
            div.getTxtTime().setReadOnly(false);
            div.getTxtTime().setRequired(true);
        } else {
            int 集計単位 = get集計単位(div, 集計単位Key);
            SenkyoShurui 選挙種類 = SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui());
            div.getDgTojitsuTohyoShukei().setDataSource(getHandler().createTohyoJokyoShukeiDataSource(div.getCcdTojitsuTohyokuCode().get投票区コード(), 選挙種類, 集計単位, div.getTxtHdnShohonNo(), div.getRadSenkyoNo().getSelectedKey())
            );
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選挙番号ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div TojitsuTohyoJokyoDiv
     * @return ResponseData<TojitsuTohyoJokyoDiv>
     */
    public ResponseData<TojitsuTohyoJokyoDiv> onClick_btnSaishinka(TojitsuTohyoJokyoDiv div) {
        div.getDgTojitsuTohyoShukei().getDataSource().clear();
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate必須項目();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        RString 集計単位Key = div.getRadShukeiTani().getSelectedKey();
        int 集計単位 = get集計単位(div, 集計単位Key);
        SenkyoShurui 選挙種類 = SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui());
        div.getDgTojitsuTohyoShukei().setDataSource(getHandler().
                createTohyoJokyoShukeiDataSource(div.getCcdTojitsuTohyokuCode().get投票区コード(), 選挙種類, 集計単位, div.getTxtHdnShohonNo(), div.getRadSenkyoNo().getSelectedKey())
        );
        return ResponseData.of(div).respond();
    }

    /**
     * 選挙番号ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div TojitsuTohyoJokyoDiv
     * @return ResponseData<TojitsuTohyoJokyoDiv>
     */
    public ResponseData<TojitsuTohyoJokyoDiv> onClick_radShukeiTani(TojitsuTohyoJokyoDiv div) {
        div.getDgTojitsuTohyoShukei().getDataSource().clear();
        RString 集計単位Key = div.getRadShukeiTani().getSelectedKey();
        if (集計単位Key.equals(集計単位KEY_任意)) {
            div.getTxtTime().setDisabled(false);
            div.getTxtTime().setReadOnly(false);
            div.getTxtTime().setRequired(true);
        } else {
            div.getTxtTime().setDisabled(true);
            div.getTxtTime().setReadOnly(true);
            div.getTxtTime().clearValue();
            div.getTxtTime().setRequired(false);
            int 集計単位 = get集計単位(div, 集計単位Key);
            SenkyoShurui 選挙種類 = SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui());
            div.getDgTojitsuTohyoShukei().setDataSource(getHandler().
                    createTohyoJokyoShukeiDataSource(div.getCcdTojitsuTohyokuCode().get投票区コード(),
                            選挙種類, 集計単位, div.getTxtHdnShohonNo(), div.getRadSenkyoNo().getSelectedKey()));
        }
        return ResponseData.of(div).respond();
    }

    private static int get集計単位(TojitsuTohyoJokyoDiv div, RString 集計単位Key) {
        if (集計単位Key.equals(集計単位KEY_15分)) {
            return 集計単位_15分;
        } else if (集計単位Key.equals(集計単位KEY_30分)) {
            return 集計単位_30分;
        } else if (集計単位Key.equals(集計単位KEY_60分)) {
            return 集計単位_60分;
        }
        return new Decimal(div.getTxtTime().getValue().getHour())
                .multiply(集計単位_60分).add(div.getTxtTime().getValue().getMinute()).intValue();

    }

    private static TojitsuTohyoJokyoHandler getHandler() {
        return new TojitsuTohyoJokyoHandler();
    }

    private static TojitsuTohyoValidationHandler getValidationHandler(TojitsuTohyoJokyoDiv div) {
        return new TojitsuTohyoValidationHandler(div);
    }
}
