/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 投票所入場券情報
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujoukenNyujyokkenWithCheckListParam {

    private List<Nyujoken3tsuoriParam> 投票所入場券情報リスト;
    private List<Nyujoken3tsuoriParam> 投票所入場券情報チェックリスト;

    /**
     * コンストラクタです。
     *
     *
     */
    public NyujoukenNyujyokkenWithCheckListParam() {
        投票所入場券情報リスト = new ArrayList();
        投票所入場券情報チェックリスト = new ArrayList<>();
    }

    /**
     * コンストラクタです。
     *
     *
     *
     *
     * @param 投票所入場券情報リスト List<Nyujoken3tsuoriParam>
     * @param 投票所入場券情報チェックリスト List<Nyujoken3tsuoriParam>
     */
    public NyujoukenNyujyokkenWithCheckListParam(List<Nyujoken3tsuoriParam> 投票所入場券情報リスト,
            List<Nyujoken3tsuoriParam> 投票所入場券情報チェックリスト) {
        this.投票所入場券情報リスト = 投票所入場券情報リスト;
        this.投票所入場券情報チェックリスト = 投票所入場券情報チェックリスト;

    }

    /**
     * 投票所入場券情報リスト
     *
     * @return 投票所入場券情報リスト List<Nyujoken3tsuoriParam>
     */
    public List<Nyujoken3tsuoriParam> get投票所入場券情報リスト() {
        return 投票所入場券情報リスト;
    }

    /**
     * 投票所入場券情報チェックリスト
     *
     * @return 投票所入場券情報チェックリスト List<Nyujoken3tsuoriParam>
     */
    public List<Nyujoken3tsuoriParam> get投票所入場券情報チェックリスト() {
        return 投票所入場券情報チェックリスト;
    }

    /**
     * 投票所入場券情報リスト
     *
     * @param 投票所入場券情報リスト List<Nyujoken3tsuoriParam>
     */
    public void set投票所入場券情報リスト(List<Nyujoken3tsuoriParam> 投票所入場券情報リスト) {
        this.投票所入場券情報リスト = 投票所入場券情報リスト;
    }

    /**
     * 投票所入場券情報チェックリスト
     *
     * @param 投票所入場券情報チェックリスト List<Nyujoken3tsuoriParam>
     */
    public void set投票所入場券情報チェックリスト(List<Nyujoken3tsuoriParam> 投票所入場券情報チェックリスト) {
        this.投票所入場券情報チェックリスト = 投票所入場券情報チェックリスト;
    }

}
