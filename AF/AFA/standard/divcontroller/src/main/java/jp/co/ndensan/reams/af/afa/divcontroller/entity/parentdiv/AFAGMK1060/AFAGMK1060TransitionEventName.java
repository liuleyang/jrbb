package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * AFAGMK1060のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum AFAGMK1060TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    更新("更新"),
    再検索("再検索");

    private final RString name;

    private AFAGMK1060TransitionEventName(String name) {
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
