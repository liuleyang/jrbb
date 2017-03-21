package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 */
public interface ITohyokuCodeSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     */
    void initialize();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。<br/>
     * 親画面で、投票区コードTextBoxのonBlurイベントがある場合、共有子Divの入力チェックメソッドは親画面で呼び出し、実行します。isNyuryokuCheckByCommonChildDiv：false。<br/>
     * 親画面で、投票区コードTextBoxのonBlurイベントがない場合、入力チェックはこの共有子Divで実行します。isNyuryokuCheckByCommonChildDiv：true。<br/>
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param isNyuryokuCheckByCommonChildDiv boolean　false:入力チェックは親画面で実行します。　true:入力チェックはこの共有子Divで実行します。常に：true
     */
    void initialize(SenkyoShurui senkyoShurui, boolean isNyuryokuCheckByCommonChildDiv);

    /**
     * 引数のコードから、投票区名称を取得し初期表示を行う。
     *
     * @param code 投票区コード
     */
    void initialize(RString code);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clear();

    /**
     * 投票区名称を取得します。
     *
     * @return 投票区名称
     */
    RString get投票区名称();

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 投票区コードを取得します
     *
     * @return 投票区コード 投票区コード
     */
    RString get投票区コード();

    /**
     * 投票区コードのテキストを取得します
     *
     * @return TextBoxCode 投票区コードのテキスト
     */
    TextBoxCode getTxtTohyokuCode();

    /**
     * 投票区コードより、取得した投票区名称をセットします。<br/>
     * このメソッドを呼び出す前に、必ず「投票区コードチェック」メソッドを呼び出す。<br/>
     * チェックエラーがない場合、このメソッドの処理を続く。
     *
     */
    void set投票区名称();

    /**
     * 投票区コードに対する投票区名があるかどうかをチェックする。<br/>
     * チェックエラーがない場合、メソッド「set投票区名称()」を呼び出しください。
     *
     * @return ValidationMessageControlPairs チェック結果
     */
    ValidationMessageControlPairs 投票区コードチェック();
}
