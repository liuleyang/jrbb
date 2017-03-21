/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.contexts;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.validation.IContext;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 投票事由のコンテキストです。
 *
 * @author N1823 有澤 礼恵
 */
public class TohyoJiyuCodeContext implements IContext {

    private final Code tohyoJiyuCode;
    private final List<KeyValueDataSource> jiyuTaishoList;

    /**
     * コンストラクタです。
     *
     * @param tohyoJiyuCode 投票事由コード
     * @param jiyuTaishoList 投票事由対象リスト
     */
    public TohyoJiyuCodeContext(Code tohyoJiyuCode, List<KeyValueDataSource> jiyuTaishoList) {
        //TODO TohyoJiyuCodeのEnum型ではなくCode型なのは、Validationチェックで、空白やデータなしをチェックするため。
        this.tohyoJiyuCode = tohyoJiyuCode;
        this.jiyuTaishoList = jiyuTaishoList;
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由
     */
    public Code getTohyoJiyuCode() {
        return tohyoJiyuCode;
    }

    /**
     * 投票事由対象リストを返します。
     *
     * @return 投票事由対象リスト
     */
    public List<KeyValueDataSource> getJiyuTaishoList() {
        return jiyuTaishoList;
    }

}
