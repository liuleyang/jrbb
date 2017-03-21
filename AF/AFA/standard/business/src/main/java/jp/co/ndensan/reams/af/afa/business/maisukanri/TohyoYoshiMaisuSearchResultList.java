/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.maisukanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 投票用紙枚数検索結果のクラスです。
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public class TohyoYoshiMaisuSearchResultList implements Serializable {

    private static final long serialVersionUID = 351901586803745749L;

    private List<TohyoYoshiMaisuSearchResult> 投票用紙枚数リスト;

    /**
     * コンストラクタです。
     */
    public TohyoYoshiMaisuSearchResultList() {
        投票用紙枚数リスト = new ArrayList();
    }

    /**
     * 投票用紙枚数リスト
     *
     * @return 投票用紙枚数リスト List<TohyoYoshiMaisuSearchResult>
     */
    public List<TohyoYoshiMaisuSearchResult> get投票用紙枚数リスト() {
        return 投票用紙枚数リスト;
    }

    /**
     * 投票用紙枚数リスト
     *
     * @param 投票用紙枚数リスト List<TohyoYoshiMaisuSearchResult>
     */
    public void set投票用紙枚数リスト(List<TohyoYoshiMaisuSearchResult> 投票用紙枚数リスト) {
        this.投票用紙枚数リスト = 投票用紙枚数リスト;
    }
}
