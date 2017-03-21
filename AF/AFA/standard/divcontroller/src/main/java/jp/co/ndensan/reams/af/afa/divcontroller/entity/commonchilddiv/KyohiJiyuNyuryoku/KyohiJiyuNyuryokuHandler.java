/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KyohiJiyuNyuryokuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してKyohiJiyuNyuryokuDivの入力可否、表示・非表示の制御を行ったり、<br />
 * KyohiJiyuNyuryokuDivの情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-011 liss
 */
public class KyohiJiyuNyuryokuHandler {

    private final KyohiJiyuNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 拒否事由入力div
     */
    public KyohiJiyuNyuryokuHandler(KyohiJiyuNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * この共有子Divに初期値を設定します。
     *
     */
    public void initialize() {
        div.getDdlKyohiJiyu().setDataSource(CodeMasterHelper.createDataSource(AFACodeShubetsu.拒否事由コード.getCodeShubetsu(), true));
        clear();
    }

    /**
     * メンバ変数で保持しているdivへの初期設定をします。
     *
     */
    public void initialSetting() {
        clear();
    }

    /**
     * 入力された項目をクリアします。
     */
    public void clear() {
        div.getDdlKyohiJiyu().setSelectedIndex(0);
        div.getTxtKyohiJiyu().clearValue();
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（True：照会モード　False：入力モード）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        // readOnlySetMode  True：画面での入力不可、False：画面での入力可
        div.getDdlKyohiJiyu().setDisabled(readOnlySetMode);
        div.getTxtKyohiJiyu().setReadOnly(readOnlySetMode);

        div.getDdlKyohiJiyu().setRequired(!readOnlySetMode);
    }

    /**
     * 投票状況用拒否事由の編集
     *
     * @return RString
     */
    public RString edit投票状況用拒否事由() {
        return div.get拒否事由定型文().concat(RString.FULL_SPACE).concat(div.get拒否事由入力文());
    }
}
