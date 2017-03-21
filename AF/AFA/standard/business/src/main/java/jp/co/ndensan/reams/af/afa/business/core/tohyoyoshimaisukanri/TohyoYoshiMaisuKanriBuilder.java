/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoyoshimaisukanri;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;

/**
 * {@link TohyoYoshiMaisuKanri}の編集を行うビルダークラスです。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class TohyoYoshiMaisuKanriBuilder {

    private final AfT251TohyoYoshiMaisuKanriEntity entity;
    private final TohyoYoshiMaisuKanriIdentifier id;

    /**
     * {@link AfT251TohyoYoshiMaisuKanriEntity}より{@link TohyoYoshiMaisuKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT251TohyoYoshiMaisuKanriEntity}
     * @param id {@link TohyoYoshiMaisuKanriIdentifier}
     *
     */
    TohyoYoshiMaisuKanriBuilder(
            AfT251TohyoYoshiMaisuKanriEntity entity,
            TohyoYoshiMaisuKanriIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * tenjiYoshiMaisuのgetメソッドです。
     *
     * @param tenjiYoshiMaisu tenjiYoshiMaisu
     * @return {@link TohyoYoshiMaisuKanriBuilder}
     */
    public TohyoYoshiMaisuKanriBuilder setTenjiYoshiMaisu(int tenjiYoshiMaisu) {
        entity.setTenjiYoshiMaisu(tenjiYoshiMaisu);
        return this;
    }

    /**
     * tohyoYoshiMaisuのgetメソッドです。
     *
     * @param tohyoYoshiMaisu tohyoYoshiMaisu
     * @return {@link TohyoYoshiMaisuKanriBuilder}
     */
    public TohyoYoshiMaisuKanriBuilder getTohyoYoshiMaisu(int tohyoYoshiMaisu) {
        entity.setTohyoYoshiMaisu(tohyoYoshiMaisu);
        return this;
    }

    /**
     * kariFutoMaisuのgetメソッドです。
     *
     * @param kariFutoMaisu kariFutoMaisu
     * @return {@link TohyoYoshiMaisuKanriBuilder}
     */
    public TohyoYoshiMaisuKanriBuilder getKariFutoMaisu(int kariFutoMaisu) {
        entity.setKariFutoMaisu(kariFutoMaisu);
        return this;
    }

    /**
     * {@link TohyoYoshiMaisuKanri}のインスタンスを生成します。
     *
     * @return {@link TohyoYoshiMaisuKanri}のインスタンス
     */
    public TohyoYoshiMaisuKanri build() {
        return new TohyoYoshiMaisuKanri(entity, id);
    }
}
