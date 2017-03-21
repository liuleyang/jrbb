/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 入場券発行明細情報
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujoukenHakkouMeishoWithCheckListParam {

    private List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト;
    private List<NyujoukenNyujyokkenParam> 投票所入場券情報チェックリスト;

    /**
     * コンストラクタです。
     *
     *
     */
    public NyujoukenHakkouMeishoWithCheckListParam() {
        投票所入場券情報リスト = new ArrayList();
        投票所入場券情報チェックリスト = new ArrayList<>();
    }

    /**
     * コンストラクタです。
     *
     *
     *
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     * @param 投票所入場券情報チェックリスト List<NyujoukenNyujyokkenParam>
     */
    public NyujoukenHakkouMeishoWithCheckListParam(List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト,
            List<NyujoukenNyujyokkenParam> 投票所入場券情報チェックリスト) {
        this.投票所入場券情報リスト = 投票所入場券情報リスト;
        this.投票所入場券情報チェックリスト = 投票所入場券情報チェックリスト;

    }

    /**
     * 投票所入場券情報リスト
     *
     * @return 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     */
    public List<NyujoukenNyujyokkenParam> get投票所入場券情報リスト() {
        return 投票所入場券情報リスト;
    }

    /**
     * 投票所入場券情報チェックリスト
     *
     * @return 投票所入場券情報チェックリスト List<NyujoukenNyujyokkenParam>
     */
    public List<NyujoukenNyujyokkenParam> get投票所入場券情報チェックリスト() {
        return 投票所入場券情報チェックリスト;
    }

    /**
     * 投票所入場券情報リスト
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     */
    public void set投票所入場券情報リスト(List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト) {
        this.投票所入場券情報リスト = 投票所入場券情報リスト;
    }

    /**
     * 投票所入場券情報チェックリスト
     *
     * @param 投票所入場券情報チェックリスト List<NyujoukenNyujyokkenParam>
     */
    public void set投票所入場券情報チェックリスト(List<NyujoukenNyujyokkenParam> 投票所入場券情報チェックリスト) {
        this.投票所入場券情報チェックリスト = 投票所入場券情報チェックリスト;
    }

}
