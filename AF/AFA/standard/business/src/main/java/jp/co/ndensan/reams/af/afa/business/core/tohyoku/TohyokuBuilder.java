/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.TohyojoIdentifier;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link Tohyoku}の編集を行うビルダークラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class TohyokuBuilder {

    private final AfT501TohyokuEntity entity;
    private final TohyokuIdentifier id;
    private final Models<TohyojoIdentifier, Tohyojo> tohyojo;

    /**
     * {@link AfT501TohyokuEntity}より{@link Tohyoku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT501TohyokuEntity}
     * @param id {@link TohyokuIdentifier}
     * @param tohyojo {@link Models}
     *
     */
    TohyokuBuilder(
            AfT501TohyokuEntity entity,
            TohyokuIdentifier id,
            Models<TohyojoIdentifier, Tohyojo> tohyojo) {
        this.entity = entity.clone();
        this.id = id;
        this.tohyojo = tohyojo;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 選挙種類
     * @return {@link TohyokuBuilder}
     */
    public TohyokuBuilder set選挙種類(Code 選挙種類) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        entity.setSenkyoShurui(選挙種類);
        return this;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link TohyokuBuilder}
     */
    public TohyokuBuilder set投票区コード(RString 投票区コード) {
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        entity.setTohyokuCode(投票区コード);
        return this;
    }

    /**
     * 投票区名を設定します。
     *
     * @param 投票区名 投票区名
     * @return {@link TohyokuBuilder}
     */
    public TohyokuBuilder set投票区名(RString 投票区名) {
        requireNonNull(投票区名, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区名"));
        entity.setTohyokuName(投票区名);
        return this;
    }

    /**
     * カナ投票区名を設定します。
     *
     * @param カナ投票区名 カナ投票区名
     * @return {@link TohyokuBuilder}
     */
    public TohyokuBuilder setカナ投票区名(RString カナ投票区名) {
        requireNonNull(カナ投票区名, UrSystemErrorMessages.値がnull.getReplacedMessage("カナ投票区名"));
        entity.setKanaTohyokuName(カナ投票区名);
        return this;
    }

    /**
     * 検索用カナ投票区名を設定します。
     *
     * @param 検索用カナ投票区名 検索用カナ投票区名
     * @return {@link TohyokuBuilder}
     */
    public TohyokuBuilder set検索用カナ投票区名(RString 検索用カナ投票区名) {
        requireNonNull(検索用カナ投票区名, UrSystemErrorMessages.値がnull.getReplacedMessage("検索用カナ投票区名"));
        entity.setSearchKanaTohyokuName(検索用カナ投票区名);
        return this;
    }

    /**
     * 表示順を設定します。
     *
     * @param 表示順 表示順
     * @return {@link TohyokuBuilder}
     */
    public TohyokuBuilder set表示順(int 表示順) {
        requireNonNull(表示順, UrSystemErrorMessages.値がnull.getReplacedMessage("表示順"));
        entity.setHyojijun(表示順);
        return this;
    }

    /**
     * {@link Tohyoku}のインスタンスを生成します。
     *
     * @return {@link Tohyoku}のインスタンス
     */
    public Tohyoku build() {
        return new Tohyoku(entity, id, tohyojo);
    }
}
