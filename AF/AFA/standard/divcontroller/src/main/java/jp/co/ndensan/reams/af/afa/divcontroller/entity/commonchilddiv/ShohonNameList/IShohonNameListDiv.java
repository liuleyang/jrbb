package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShohonNameListDiv extends ICommonChildDivBaseProperties {

    /**
     * DDLで選択されている抄本の抄本名を取得する
     *
     * @return RString 抄本名
     */
    RString getSelectedShohonName();

    /**
     * DDLで選択されている抄本の選挙種類を取得する
     *
     * @return RString 選挙種類
     */
    SenkyoShurui getSelectedSenkyoShurui();

    /**
     * DDLで選択されている抄本の投票日を取得する
     *
     * @return RDate 投票日
     */
    RDate getSelectedTohyoYMD();

    /**
     * DDLで選択されている抄本の規定年齢到達日を取得する
     *
     * @return RDate 規定年齢到達日
     */
    RDate getSelectedKiteiNenreiTotatsuYMD();

    /**
     * DDLで選択されている抄本の抄本番号を取得する
     *
     * @return RString 抄本番号
     */
    RString getSelectedShohonNo();

    /**
     * この共有子Divに初期値を設定します。
     */
    void initialize();

    /**
     * この共有子Divに初期値を設定します。<br />
     * 空白行は追加されません。
     *
     * @param senkyoShurui 選挙種類
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Divに初期値を設定します。<br />
     * 空白行は追加されません。
     *
     * @param senkyoShurui 選挙種類
     * @param is過去分のみ対象区分 Boolean
     */
    void initialize(RString senkyoShurui, Boolean is過去分のみ対象区分);

    /**
     * この共有子Divに初期値を設定します。<br />
     * 空白行を追加するときは、isAddEmptyRowをTrueにしてください。
     *
     * @param senkyoShurui 選挙種類
     * @param is過去分のみ対象区分 Boolean
     */
    void initialize(SenkyoShurui senkyoShurui, Boolean is過去分のみ対象区分);

    /**
     * この共有子Divの初期値セットします。
     */
    void initialSetting();

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    void clear();

    /**
     * 引数の抄本番号から、ドロップダウンリストの初期表示を行います。
     *
     * @param shohonNo 抄本番号
     */
    void selectedShohon(RString shohonNo);

    /**
     * 抄本ドロップダウンリストが選択変更されたときのイベントメソッドです。
     */
    void changeDdlShohon();

    /**
     * 共有子Div自身のsetDisplayNoneをセットします。
     *
     * @param displayNoneSetMode True：表示しない　False：表示する
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode);

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    public void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 過去分のみ対象区分のsetDisplayNoneをセットします。
     *
     * @param displayNoneSetMode True：表示しない　False：表示する
     */
    public void setChkKakoShohonDisplayNoneMode(Boolean displayNoneSetMode);

    /**
     * 過去分のみ対象区分のcheckSetModeをセットします。
     *
     * @param checkSetMode True：check　False：unCheck
     */
    public void setChkKakoShohonCheckMode(Boolean checkSetMode);

    /**
     * 共有子Div自身のisDisplayNoneを取得します
     *
     * @return 表示状態
     */
    public boolean isDisplayNoneMode();

    /**
     * 抄本DDLの件数を取得します。
     *
     * @return 取得された抄本の数
     */
    public int getShohonListSize();

    /**
     * チェックボックスをクリックするときのイベントメソッドです。
     */
    public void click_chkKakoShohon();

    /**
     * 一番近い未来抄本番号を取得します。
     *
     * @return 抄本番号
     */
    RString get一番近い未来抄本番号();

    /**
     * 一番近い過去抄本番号を取得します。
     *
     * @return 抄本番号
     */
    RString get一番近い過去抄本番号();

    /**
     * 抄本DDLを取得します。
     *
     * @return 抄本DDL
     */
    RString get抄本DDL();

    /**
     * 抄本DDL項目を取得します。
     *
     * @return 抄本DDL項目
     */
    DropDownList getDdlShohonItem();
}
