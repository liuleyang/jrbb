package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanCodeSelect;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/*
 * このコードはツールによって生成されました。
 */
public interface IRyojikanCodeSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数のコードから、組合名称を取得し初期表示を行う。
     *
     * @param code 組合コード
     */
    void initialize(RString code);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clear();

    TextBoxCode getTxtRyojikanCode();

}
