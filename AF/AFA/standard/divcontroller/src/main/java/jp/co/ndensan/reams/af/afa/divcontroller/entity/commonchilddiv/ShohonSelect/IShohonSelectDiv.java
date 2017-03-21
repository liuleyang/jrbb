package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。
 */
public interface IShohonSelectDiv {

    /**
     * 抄本情報を取得します。
     *
     * @return IShohonNameListDiv
     */
    IShohonNameListDiv getCcdShohonNameList();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     */
    void initialize();

    /**
     * 入場券作成可能抄本の初期表示を行います。
     *
     */
    void initialSetting();

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
    RString get抄本番号();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     * @return RString
     */
    RString get選挙種類();

    /**
     * この共有子Div情報を取得する。
     *
     * @return ShohonSelectDiv
     */
    ShohonSelectDiv get抄本選択共有情報();
}
