/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect;

import jp.co.ndensan.reams.af.afa.business.core.senkyoku.SenkyokuJouhou;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.service.senkyoku.SenkyokuFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SenkyokuCodeSelectDiv の操作を担当するクラスです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuCodeSelectHandler {

    private final SenkyokuCodeSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙区コード選択Div
     */
    public SenkyokuCodeSelectHandler(SenkyokuCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 選挙区コードDiv
     * @return SenkyokuCodeSelectHandler
     */
    public static SenkyokuCodeSelectHandler of(SenkyokuCodeSelectDiv div) {
        return new SenkyokuCodeSelectHandler(div);
    }

    /**
     * 画面ロード時のイベントメソッドです。(選挙種類の指定なし)
     *
     */
    public void initialize() {
        //　投票受付を想定。抄本が決まらないと、選挙種類が決定しないため。
        clear();
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
        if ((senkyoShurui == SenkyoShurui.定時登録) || (senkyoShurui == SenkyoShurui.国政選挙_地方選挙)) {
            //TODO ほんとは管理情報から取得する
            div.getTxtSenkyokuCode().setMaxLength(4);
        } else if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            //TODO ほんとは管理情報から取得する
            div.getTxtSenkyokuCode().setMaxLength(3);
        } else if (senkyoShurui == SenkyoShurui.農業委員会委員選挙) {
            //TODO ほんとは管理情報から取得する
            div.getTxtSenkyokuCode().setMaxLength(2);
        } else {
            div.getTxtSenkyokuCode().setMaxLength(4);
        }

    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param senkyokuCode RString 選挙区コード
     * @return ResponseData
     */
    public ResponseData initialize(Code senkyoShurui, RString senkyokuCode) {
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        SenkyokuJouhou senkyokuJoho = finder.get選挙区情報(senkyoShurui, senkyokuCode);
        if (null != senkyokuJoho.getEntity()) {
            div.setTxtHdnSenkyoShurui(null == senkyoShurui ? RString.EMPTY : senkyoShurui.getColumnValue());
            div.getTxtSenkyokuName().setValue(senkyokuJoho.getEntity().getSenkyokuName());
            div.getTxtSenkyokuCode().setValue(senkyokuCode);
        } else {
            ValidationMessageControlPairs controlErrorPairs = new SenkyokuCodeSelectValidationHandler(div).validate選挙区コード();
            if (controlErrorPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }

            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 引数のコードから、選挙区名称を取得し初期表示を行う。
     *
     * @param code 投票区コード
     */
    public void initialize(RString code) {
        div.getTxtSenkyokuCode().setValue(code);
        //TODO 名称を投票区マスタから取得して、セットする
//        div.getTxtSenkyokuName().setValue(get選挙区名称(div));
    }

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    public void clear() {
        div.getTxtSenkyokuCode().clearValue();
        div.getTxtSenkyokuName().clearValue();
        div.setTxtHdnSenkyoShurui(RString.EMPTY);
    }

    public RString get選挙区名称(Code 選挙種類, RString senkyokuCode) {
        RString senkyokuName = RString.EMPTY;
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        SenkyokuJouhou senkyokuJoho = finder.get選挙区情報(選挙種類, senkyokuCode);
        if (null != senkyokuJoho.getEntity()) {
            senkyokuName = senkyokuJoho.getEntity().getSenkyokuName();
        }
        return senkyokuName;
    }

    /**
     * 「選挙区詳細」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new SenkyokuCodeSelectValidationHandler(div).validate選挙区コード();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.setReadOnly(readOnlySetMode);
        div.getBtnSenkyokuCode().setDisplayNone(readOnlySetMode);
    }

    /**
     * 選挙区コードを設定します。
     *
     * @return 選挙区コード
     */
    public RString get選挙区コード() {
        return div.getTxtSenkyokuCode().getValue();
    }

}
