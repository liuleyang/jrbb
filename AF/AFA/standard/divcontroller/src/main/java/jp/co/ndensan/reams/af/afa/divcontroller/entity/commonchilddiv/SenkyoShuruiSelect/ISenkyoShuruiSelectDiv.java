package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ISenkyoShuruiSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divに初期値を設定します。
     *
     * @reamsid_L AF-0180-012 liuyj
     */
    void initialize();

    /**
     * この共有子Divに初期値を設定します。<br />
     * 引数の選挙種類を初期表示します。<br />
     * あらかじめ、選挙種類がわかっている場合は、こちらを使用してください。
     *
     * @param senkyoShurui 選挙種類
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Divに初期値を設定します。<br />
     * 引数の選挙種類を初期表示します。<br />
     * あらかじめ、選挙資格種類がわかっている場合は、こちらを使用してください。
     *
     * @param sennkyoSikakuShurui 選挙資格種類
     */
    void initialize(SennkyoSikakuShurui sennkyoSikakuShurui);

    /**
     * この共有子Divの初期値セットします。<br />
     * 引数のコードから、ドロップダウンリストの初期表示を行う。
     *
     * @param code 選挙種類コード
     */
    void initialize(Code code);

    /**
     * 選択されている選挙種類を取得します。
     *
     * @return 選挙種類
     */
    SenkyoShurui getSelectedSenkyoShurui();

    /**
     * 選択されている選挙資格種類を取得します。
     *
     * @return 選挙資格種類
     */
    SennkyoSikakuShurui getSelectedSennkyoSikakuShurui();

    /**
     * 共有子Div自身のsetDisplayNoneをセットします。
     *
     * @param displayNoneSetMode True：表示しない　False：表示する
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode);

    /**
     * 共有子Div自身のsetReadOnlyをセットします。
     *
     * @param readOnlyMode True：照会　False：入力
     */
    public void setReadOnlyMode(Boolean readOnlyMode);

}
