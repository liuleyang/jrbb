package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * AFAGME5030のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum AFAGME5030TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    バッチ起動("バッチ起動"),
    メニューへ戻る("メニューへ戻る");

    private final RString name;

    private AFAGME5030TransitionEventName(String name) {
        this.name = new RString(name);
    }

    /**
     * getName
     *
     * @return 名前
     */
    @Override
    public RString getName() {
        return name;
    }
// </editor-fold>
}
