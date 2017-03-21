package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKyohiJiyuNyuryokuDiv extends ICommonChildDivBaseProperties {

    /**
     * 拒否事由定型文を返します。
     *
     * @return 拒否事由定型文
     */
    RString get拒否事由定型文();

    /**
     * 拒否事由入力文を返します。
     *
     * @return 拒否事由入力文
     */
    RString get拒否事由入力文();

    /**
     * 投票状況用拒否事由を返します。
     *
     * @return 投票状況用拒否事由
     */
    RString get投票状況用拒否事由();

    /**
     * この共有子Divを初期化します。
     */
    void initialSetting();

    /**
     * この共有子Divに初期値を設定します。
     */
    void initialize();

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    void clear();

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

}
