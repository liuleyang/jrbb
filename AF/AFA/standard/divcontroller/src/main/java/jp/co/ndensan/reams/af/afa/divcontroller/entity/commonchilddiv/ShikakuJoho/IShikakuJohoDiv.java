package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public interface IShikakuJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 投票区コードのgetter
     *
     * @return ITohyokuCodeSelectDiv
     */
    ITohyokuCodeSelectDiv getCcdTohyokuCode();

    public RadioButton getRadSenkyoShikaku();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     * @param shikibetsuCode ShikibetsuCode
     */
    void initialize(SenkyoShurui senkyoShurui, ShikibetsuCode shikibetsuCode);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     * @return RString
     */
    RString getTxtHdnSenkyoShurui();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     * @return RString
     */
    RString getTxtHdnShikibetsuCode();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     * @param senkyoShurui SenkyoShurui
     */
    void get選挙資格状態制御(SenkyoShurui senkyoShurui);

    ValidationMessageControlPairs 入力日付のチェック();

    ValidationMessageControlPairs 入力日付ウォーニングチェック();

    ValidationMessageControlPairs 同一日チェック();

    ValidationMessageControlPairs 抹消理由と住民種別のチェック();

    ValidationMessageControlPairs 抹消理由と抹消年月日入力チェック();

    ValidationMessageControlPairs 抹消異動日関連チェック();

    ValidationMessageControlPairs 登録停止者変更時のチェック();

    ValidationMessageControlPairs 登録年月日と抹消年月日の関連チェック();

    ValidationMessageControlPairs 登録年月日と表示年月日の関連チェック();

    ValidationMessageControlPairs 経過日3ヶ月チェック();

    ValidationMessageControlPairs 表示日と表示事由チェック();

    ValidationMessageControlPairs 表示消除予定年月日チェック();

    ValidationMessageControlPairs 表示消除年月日チェック();

    ValidationMessageControlPairs 転出時の住民種別ウォーニングチェック();

    ValidationMessageControlPairs 転出時の住民種別チェック();
    
    ValidationMessageControlPairs 選挙資格の有無チェック();

    ValidationMessageControlPairs 住登外チェック();

    ValidationMessageControlPairs 登録対象外Warnチェック();

    /**
     * この共有子Div情報を取得する。
     *
     * @return ShikakuJohoDiv
     */
    ShikakuJohoDiv get選挙資格情報();
}
