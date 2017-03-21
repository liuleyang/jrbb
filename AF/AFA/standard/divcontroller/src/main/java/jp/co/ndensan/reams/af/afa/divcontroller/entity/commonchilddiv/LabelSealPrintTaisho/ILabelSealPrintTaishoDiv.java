package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * ラベルシール作成対象共有子divのインタフェースです。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public interface ILabelSealPrintTaishoDiv extends ICommonChildDivBaseProperties {

    /**
     * ラベルシール作成対象共有子divの初期化メソッドです。
     *
     * @param 期日前不在者区分 KijitsumaeFuzaishaKubun
     * @param 抄本番号 ShohonNo
     */
    void initialize(KijitsumaeFuzaishaKubun 期日前不在者区分, ShohonNo 抄本番号);

    /**
     * 入力チェックメソッドです。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs validate();

    /**
     * 不在者投票証明書チェックボックスのチェック状態判定メソッドです。<br />
     * チェックON時、trueを戻る。チェックOFF時、falseを戻る。
     *
     * @return boolean
     */
    boolean isCheckedFuzaishaTohyoShomeisho();

    /**
     * 宣誓書チェックボックスのチェック状態判定メソッドです。<br />
     * チェックON時、trueを戻る。チェックOFF時、falseを戻る。
     *
     * @return boolean
     */
    boolean isCheckedSenseisho();

    /**
     * 宣誓書貼付用チェックボックスのチェック状態判定メソッドです。<br />
     * チェックON時、trueを戻る。チェックOFF時、falseを戻る。
     *
     * @return boolean
     */
    boolean isCheckedLabelSenseisho();

    /**
     * 封筒貼付用チェックボックスのチェック状態判定メソッドです。<br />
     * チェックON時、trueを戻る。チェックOFF時、falseを戻る。
     *
     * @return boolean
     */
    boolean isCheckedLabelFuto();

    /**
     * 抄本貼付用チェックボックスのチェック状態判定メソッドです。<br />
     * チェックON時、trueを戻る。チェックOFF時、falseを戻る。
     *
     * @return boolean
     */
    boolean isCheckedLabelShohon();

    /**
     * 入場券貼付用チェックボックスのチェック状態判定メソッドです。<br />
     * チェックON時、trueを戻る。チェックOFF時、falseを戻る。
     *
     * @return boolean
     */
    boolean isCheckedLabelNyujoken();

    /**
     * 不在者投票証明書チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkFuzaishaTohyoShomeishoDisplay();

    /**
     * 宣誓書チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkSenseishoDisplay();

    /**
     * 宣誓書貼付用チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkLabelSenseishoDisplay();

    /**
     * 封筒貼付用チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkLabelFutoDisplay();

    /**
     * 選挙チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkSenkyoDisplay();

    /**
     * 抄本貼付用チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkLabelShohonDisplay();

    /**
     * 入場券貼付用チェックボックスの表示状態判定メソッドです。<br />
     * 表示時、trueを戻る。非表示時、falseを戻る。
     *
     * @return boolean
     */
    boolean isChkLabelNyujokenDisplay();

    /**
     * すべてのチェックボックスの状態判定メソッドです。<br />
     * 全て非表示時、trueを戻る。以外、falseを戻る。
     *
     * @return boolean
     */
    boolean is全てのチェックボックス非表示();

    /**
     * 選挙チェックボックスが表示する時、選挙リストを返す。
     *
     * @return List<RString>
     */
    List<RString> get選挙リスト();

    /**
     * 選挙チェックボックスが表示する時、選挙Indexリストを返す。
     *
     * @return List<RString>
     */
    List<RString> get選挙Indexリスト();

    /**
     * シール種別リストを取得します。。
     *
     * @return List<RString>
     */
    List<RString> getシール種別リスト();

    /**
     * 宣誓書貼付用の印刷枚数を取得します。。
     *
     * @return int
     */
    int get宣誓書貼付用の印刷枚数();

    /**
     * 抄本貼付用の印刷枚数を取得します。。
     *
     * @return int
     */
    int get抄本貼付用の印刷枚数();

    /**
     * 入場券貼付用の印刷枚数を取得します。。
     *
     * @return int
     */
    int get入場券貼付用の印刷枚数();
}
