package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L AF-0290-011 wangxt2
 */
public interface IShohonSenkyoListDiv extends ICommonChildDivBaseProperties {

    /**
     * 抄本情報を取得します
     *
     * @return IShohonNameListDiv
     */
    IShohonNameListDiv getCcdShohonNameList();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。 親画面から呼び出す場合、選挙種類＝定時登録以外の場合、このメソッドを利用します。 選挙種類＝定時登録以外の制御、
     */
    void initialize();

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     */
    void initialSetting();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearThisPanel();

    /**
     * 「無投票選挙も出力する」チェックボックス選択時の処理をするメソッドです。
     */
    void changeflag();

    /**
     * 無投票選挙checkを取得します。
     *
     * @return 無投票選挙check
     */
    boolean 無投票選挙check();

    /**
     * SenkyoDataSourceを取得します。
     *
     * @return DataSource
     */
    List<dgSenkyoList_Row> getSenkyoDataSource();

    /**
     * SelectedShohonNoを取得します。
     *
     * @return ShohonNo
     */
    RString getSelectedShohonNo();

    /**
     * 抄本DDLの件数を取得します。
     *
     * @return 取得された抄本の数
     */
    int getShohonListSize();

    /**
     * 過去分も含めるチェックボックス選択時の処理をするメソッドです。
     */
    void click過去分も含める();

}
