package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode;

import jp.co.ndensan.reams.af.afa.business.core.contexts.TohyoJiyuCodeContext;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITohyoJiyuCodeDiv extends ICommonChildDivBaseProperties {

    /**
     * 投票事由コードのContextを取得します。
     *
     * @return TohyoJiyuCodeContext 投票事由コードContext
     */
    TohyoJiyuCodeContext getTohyoJiyuCodeContext();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param tohyoJokyo TohyoJokyo 投票状況
     */
    void initialize(SenkyoShurui senkyoShurui, TohyoJokyo tohyoJokyo);

    /**
     * この共有子Divの初期表示を行います。
     *
     */
    void initialSetting();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 投票事由コード存在を判断します
     *
     * @return 判断結果
     */
    boolean checkTohyoJiyuCode();
}
