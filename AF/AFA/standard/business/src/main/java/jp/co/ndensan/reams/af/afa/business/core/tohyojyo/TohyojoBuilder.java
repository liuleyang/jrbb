/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyojyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link Tohyojo}の編集を行うビルダークラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class TohyojoBuilder {

    private final AfT502TohyojoEntity entity;
    private final TohyojoIdentifier id;

    /**
     * {@link AfT502TohyojoEntity}より{@link Tohyojo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT502TohyojoEntity}
     * @param id {@link TohyojoIdentifier}
     *
     */
    TohyojoBuilder(
            AfT502TohyojoEntity entity,
            TohyojoIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 投票所コードを設定します。
     *
     * @param 投票所コード 投票所コード
     * @return {@link TohyojoBuilder}
     */
    public TohyojoBuilder set投票所コード(RString 投票所コード) {
        requireNonNull(投票所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票所コード"));
        entity.setTohyojoCode(投票所コード);
        return this;
    }

    /**
     * 投票所名を設定します。
     *
     * @param 投票所名 投票所名
     * @return {@link TohyojoBuilder}
     */
    public TohyojoBuilder set投票所名(RString 投票所名) {
        requireNonNull(投票所名, UrSystemErrorMessages.値がnull.getReplacedMessage("投票所名"));
        entity.setTohyojoName(投票所名);
        return this;
    }

    /**
     * カナ投票所名を設定します。
     *
     * @param カナ投票所名 カナ投票所名
     * @return {@link TohyojoBuilder}
     */
    public TohyojoBuilder setカナ投票所名(RString カナ投票所名) {
        requireNonNull(カナ投票所名, UrSystemErrorMessages.値がnull.getReplacedMessage("カナ投票所名"));
        entity.setKanaTohyojoName(カナ投票所名);
        return this;
    }

    /**
     * 検索用カナ投票所名を設定します。
     *
     * @param 検索用カナ投票所名 検索用カナ投票所名
     * @return {@link TohyojoBuilder}
     */
    public TohyojoBuilder set検索用カナ投票所名(RString 検索用カナ投票所名) {
        requireNonNull(検索用カナ投票所名, UrSystemErrorMessages.値がnull.getReplacedMessage("検索用カナ投票所名"));
        entity.setSearchKanaTohyojoName(検索用カナ投票所名);
        return this;
    }

    /**
     * {@link Tohyojo}のインスタンスを生成します。
     *
     * @return {@link Tohyojo}のインスタンス
     */
    public Tohyojo build() {
        return new Tohyojo(entity, id);
    }
}
