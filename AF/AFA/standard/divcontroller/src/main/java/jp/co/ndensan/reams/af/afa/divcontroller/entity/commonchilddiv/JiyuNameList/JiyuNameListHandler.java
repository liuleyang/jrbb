/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList;

import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 * JiyuNameListDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してJiyuNameListDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0270-011 lis
 */
public class JiyuNameListHandler {

    private final JiyuNameListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 事由名称リストDiv
     */
    public JiyuNameListHandler(JiyuNameListDiv div) {
        this.div = div;
    }

    /**
     * この共有子Divを使用する時に必ず呼ぶメソッドです。
     *
     * @param codeShubetsu コード種別
     * @param isAddEmptyRow 空行追加区分
     */
    public void initialize(CodeShubetsu codeShubetsu, boolean isAddEmptyRow) {
        div.getDdlJiyuName().setDataSource(CodeMasterHelper.createDataSource(codeShubetsu, isAddEmptyRow));
    }

    /**
     * 引数のコードから、ドロップダウンリストの初期表示を行う。
     *
     * @param code
     */
    public void initialize(Code code) {
        if (code == null) {
            div.getDdlJiyuName().setSelectedKey(RString.EMPTY);
        } else {
            div.getDdlJiyuName().setSelectedKey(code.getColumnValue());
        }
    }

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    public void clear() {
        div.getDdlJiyuName().setSelectedIndex(0);
    }

    /**
     * 共有子Divの表示状態（表示／非表示）モードを設定します。
     *
     * @param displayNoneSetMode 表示状態（表示／非表示）
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        div.setDisplayNone(displayNoneSetMode);
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.setReadOnly(readOnlySetMode);
    }

    /**
     * 共有子Divの表示状態（表示／非表示）を返します。
     *
     * @return 表示状態（表示／非表示）
     */
    public boolean isDisplayNoneMode() {
        return div.isDisplayNone();
    }

    /**
     * 共有子Divの選択した事由コードを返します。
     *
     * @return 事由コード
     */
    public RString getSelectJiyuCode() {
        return div.getDdlJiyuName().getSelectedKey();
    }

    /**
     * 共有子Divの事由ドロップダウンリストを返します。
     *
     * @return ドロップダウンリスト
     */
    public DropDownList getDdlJiyuNameList() {
        return div.getDdlJiyuName();
    }

    /**
     * 共有子Div事由ドロップダウンリストの必須項目状態（必須／非必須）モードを設定します。
     *
     * @param requiredSetMode 必須項目状態（必須／非必須）
     */
    public void setRequiredMode(Boolean requiredSetMode) {
        div.getDdlJiyuName().setRequired(requiredSetMode);
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param diabledSetMode 使用状態（照会／入力）
     */
    public void setDisabledMode(Boolean diabledSetMode) {
        div.getDdlJiyuNameList().setDisabled(diabledSetMode);
    }
}
