package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku;

import jp.co.ndensan.reams.af.afa.business.core.contexts.HojoshaNyuryokuContext;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0080-030 wangm
 */
public interface IHojoshaNyuryokuDiv extends ICommonChildDivBaseProperties, IDialogDiv {

    /**
     * 補助者入力のContextを取得します。
     *
     * @return HojoshaNyuryokuContext 補助者入力Context
     */
    HojoshaNyuryokuContext getHojoshaNyuryokuContext();

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param shohonNo RString
     */
    void initialize(RString shohonNo);

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param shohonNo RString
     * @param tohyokuCode RString
     */
    void initialize(RString shohonNo, RString tohyokuCode);

    /**
     * 補助者の入力可否をセットします。
     *
     * @param blnShiyoFuka 入力可否（True：画面での入力不可、False：画面での入力可）
     */
    void setReadOnlyMode(Boolean blnShiyoFuka);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * ダイアログを設定します。
     *
     * @param DisplayNone boolean
     */
    void setButtonDisplayNone(boolean DisplayNone);
}
