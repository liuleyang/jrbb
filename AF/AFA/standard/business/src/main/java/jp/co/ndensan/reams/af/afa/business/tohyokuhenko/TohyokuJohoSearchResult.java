/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokuhenko;

import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 投票区変更情報検索結果です。
 */
public class TohyokuJohoSearchResult {

    private final AfT501TohyokuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT501TohyokuEntity
     */
    public TohyokuJohoSearchResult(AfT501TohyokuEntity entity) {
        this.entity = entity;
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return entity.getTohyokuCode();
    }

    /**
     * 投票区名のgetメソッドです。
     *
     * @return 投票区名
     */
    @CheckForNull
    public RString getTohyokuName() {
        return entity.getTohyokuName();
    }

    /**
     * 選挙種類のgetメソッドです。
     *
     * @return 選挙種類
     */
    public Code getSenkyoShurui() {
        return entity.getSenkyoShurui();
    }

    /**
     * カナ投票区名のgetメソッドです。
     *
     * @return カナ投票区名
     */
    @CheckForNull
    public RString getKanaTohyokuName() {
        return entity.getKanaTohyokuName();
    }

}
