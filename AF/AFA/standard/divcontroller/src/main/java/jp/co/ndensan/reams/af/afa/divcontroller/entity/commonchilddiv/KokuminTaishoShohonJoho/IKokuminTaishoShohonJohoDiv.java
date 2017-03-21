package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0360-011 lis
 */
public interface IKokuminTaishoShohonJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 抄本情報を取得します。
     *
     * @return IShohonNameListDiv
     */
    IShohonNameListDiv getCcdShohonNameList();

    /**
     * 基準日を取得します
     *
     * @return TextBoxDate
     */
    TextBoxDate getTxtKijunYMD();

    /**
     * 投票日を取得します
     *
     * @return TextBoxDate
     */
    TextBoxDate getTxtTohyoYMD();

    /**
     * radShoriを取得します
     *
     * @return TextBoxDate
     */
    RadioButton getRadShori();

    /**
     * 受付開始日を取得します
     *
     * @return TextBoxDate
     */
    TextBoxDate getTxtTohyoUketsukeYMD();

    /**
     * 特定期限日を取得します
     *
     * @return TextBoxDate
     */
    TextBoxDate getTxtTokuteiKigenYMD();

    /**
     * 名簿登録日を取得します
     *
     * @return TextBoxDate
     */
    TextBoxDate getTxtMeiboTorokuYMD();

    /**
     * 年齢到達日を取得します
     *
     * @return TextBoxDate
     */
    TextBoxDate getTxtNenreiTotatsuYMD();

    /**
     * 抄本名を取得します
     *
     * @return TextBoxDate
     */
    TextBox getTxtShohonName();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param displayMode DisplayMode 画面表示モード
     */
    void initialize(DisplayMode displayMode);

    /**
     * この共有子Divの初期表示を行います。
     *
     */
    void initialSetting();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 新規処理と再処理のラジオボタン切り替え時の処理をするメソッドです。
     *
     */
    void clickRadShori();

    /**
     * 現在の処理モードを取得します
     *
     * @return 処理モード（ラジオボタンのキー値）
     */
    RString getShoriMode();

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param senkyoShurui SenkyoShurui
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Div情報を取得する。
     *
     * @return YubinShikakuDiv
     */
    KokuminTaishoShohonJohoDiv get国民投票抄本情報();

    /**
     * DDLで選択されている抄本の抄本番号を取得する
     *
     * @return RString 抄本番号
     */
    RString getHidShohonNo();

    /**
     * ウォーニングチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs ウォーニングチェックです();

    /**
     * エラーチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs エラーチェックです();

    /**
     * setChohyoYmdチェックです
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs setChohyoYmdチェックです();
}
