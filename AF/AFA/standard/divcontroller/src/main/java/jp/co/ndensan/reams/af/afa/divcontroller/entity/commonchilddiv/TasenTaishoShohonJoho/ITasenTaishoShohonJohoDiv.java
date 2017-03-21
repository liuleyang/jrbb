package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TasenTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 */
public interface ITasenTaishoShohonJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param displayMode DisplayMode 画面表示モード
     */
    void initialize(SenkyoShurui senkyoShurui, DisplayMode displayMode);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

}
