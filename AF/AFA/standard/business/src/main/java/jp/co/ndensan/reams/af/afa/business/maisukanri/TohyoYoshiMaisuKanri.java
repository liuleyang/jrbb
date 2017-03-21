/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.maisukanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票用紙枚数を保存するのクラスです。
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public class TohyoYoshiMaisuKanri implements Serializable {

    private static final long serialVersionUID = 1L;

    private RString shohon;
    private RString senkyoNo;
    private List<TohyoYoshiMaisuSearchResult> entities;

    /**
     * コンストラクタです。
     */
    public TohyoYoshiMaisuKanri() {
        this.shohon = RString.EMPTY;
        this.senkyoNo = RString.EMPTY;
        this.entities = new ArrayList<>();
    }

    /**
     * コンストラクタです。
     *
     * @param shohon RString
     * @param senkyoNo RString
     * @param entities TohyoYoshiMaisuSearchResult
     */
    public TohyoYoshiMaisuKanri(RString shohon, RString senkyoNo, List<TohyoYoshiMaisuSearchResult> entities) {
        this.shohon = shohon;
        this.senkyoNo = senkyoNo;
        this.entities = entities;
    }

    /**
     * shohonを取得します。
     *
     * @return shohon
     */
    public RString getShohon() {
        return shohon;
    }

    /**
     * shohonを設定します。
     *
     * @param shohon RString
     */
    public void setShohon(RString shohon) {
        this.shohon = shohon;
    }

    /**
     * senkyoNoを取得します。
     *
     * @return senkyoNo
     */
    public RString getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * senkyoNoを設定します。
     *
     * @param senkyoNo RString
     */
    public void setSenkyoNo(RString senkyoNo) {
        this.senkyoNo = senkyoNo;
    }

    /**
     * entitiesを取得します。
     *
     * @return entities
     */
    public List<TohyoYoshiMaisuSearchResult> getEntities() {
        return entities;
    }

    /**
     * entitiesを設定します。
     *
     * @param entities MaisuKanriJouhou
     */
    public void setEntities(List<TohyoYoshiMaisuSearchResult> entities) {
        this.entities = entities;
    }

}
