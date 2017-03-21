package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 @reamsid_L AF-0320-011 lis
 */
public interface IJiyuNameListDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divに初期値を設定します。<br />
     * 空白行は追加されません。
     *
     * @param codeShubetsu コード種別
     */
    void initialize(CodeShubetsu codeShubetsu);

    /**
     * この共有子Divに初期値を設定します。<br />
     * 空白行を追加するときは、isAddEmptyRowをTrueにしてください。
     *
     * @param codeShubetsu コード種別
     * @param isAddEmptyRow Boolean
     */
    void initialize(CodeShubetsu codeShubetsu, Boolean isAddEmptyRow);

    /**
     * この共有子Divの初期値セットします。<br />
     * 引数のコードから、ドロップダウンリストの初期表示を行う。
     *
     * @param code コード
     */
    void initialize(Code code);

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    void clear();

    /**
     * 共有子Div自身のsetDisplayNoneをセットします。
     *
     * @param displayNoneSetMode True：表示しない　False：表示する
     */
    void setDisplayNoneMode(Boolean displayNoneSetMode);

    /**
     * 共有子Div自身のsetReadOnlyをセットします。
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 共有子Div自身のisDisplayNoneを取得します。
     *
     * @return 表示状態
     */
    boolean isDisplayNoneMode();

    /**
     * 共有子Div自身の選択した事由コードを取得します。
     *
     * @return 事由コード
     */
    RString getSelectJiyuCode();

    /**
     * 共有子Div自身の事由ドロップダウンリストを取得します。
     *
     * @return 事由ドロップダウンリスト
     */
    DropDownList getDdlJiyuNameList();

    /**
     * 共有子Div事由ドロップダウンリストのsetRequiredをセットします。
     *
     * @param requiredSetMode True：必須　False：非必須
     */
    void setRequiredMode(Boolean requiredSetMode);

    /**
     * 共有子Div自身のsetDisabledをセットします。
     *
     * @param diabledSetMode True：活性　False：非活性
     */
    void setDisabledMode(Boolean diabledSetMode);

}
