package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * AFAGMC1000の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum AFAGMC1000StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    Default("default"),
    検索結果状態("検索結果状態"),
    再検索状態("再検索状態");

    private final RString name;

    private AFAGMC1000StateName(String name) {
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
