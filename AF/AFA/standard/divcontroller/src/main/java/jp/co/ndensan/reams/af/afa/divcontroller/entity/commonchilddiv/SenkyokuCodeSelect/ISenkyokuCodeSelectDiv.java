package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ISenkyokuCodeSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     */
    void initialize();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui Code 選挙種類
     * @param senkyokuCode RString 選挙区コード
     * @return ResponseData
     */
    ResponseData initialize(Code senkyoShurui, RString senkyokuCode);

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
     * 選挙区名称を取得します。
     *
     * @param senkyoshurui 選挙種類
     * @param senkyokuCode 選挙区コード
     * @return 選挙区名称
     */
    RString get選挙区名称(Code senkyoshurui, RString senkyokuCode);

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 共有子Div自身の選挙区コードをセットします
     *
     * @return 選挙区コード
     */
    RString get選挙区コード();

}
