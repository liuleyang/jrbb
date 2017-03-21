/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.TohyojoIdentifier;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link UrTohyoku}の編集を行うビルダークラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class UrTohyokuBuilder {

    private final UrT0159TohyokuEntity entity;
    private final UrTohyokuIdentifier id;
    private final Models<TohyojoIdentifier, Tohyojo> tohyojo;

    /**
     * {@link UrT0159TohyokuEntity}より{@link UrTohyoku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link UrT0159TohyokuEntity}
     * @param id {@link UrTohyokuIdentifier}
     * @param tohyojo {@link Models}
     *
     */
    UrTohyokuBuilder(
            UrT0159TohyokuEntity entity,
            UrTohyokuIdentifier id,
            Models<TohyojoIdentifier, Tohyojo> tohyojo) {
        this.entity = entity.clone();
        this.id = id;
        this.tohyojo = tohyojo;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link TohyokuBuilder}
     */
    public UrTohyokuBuilder set投票区コード(TohyokuCode 投票区コード) {
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
    public UrTohyokuBuilder set投票区名(RString 投票区名) {
        requireNonNull(投票区名, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区名"));
        entity.setName(投票区名);
        return this;
    }

    /**
     * カナ投票区名を設定します。
     *
     * @param カナ投票区名 カナ投票区名
     * @return {@link TohyokuBuilder}
     */
    public UrTohyokuBuilder setカナ投票区名(RString カナ投票区名) {
        requireNonNull(カナ投票区名, UrSystemErrorMessages.値がnull.getReplacedMessage("カナ投票区名"));
        entity.setKanaName(カナ投票区名);
        return this;
    }

    /**
     * 検索用カナ投票区名を設定します。
     *
     * @param 検索用カナ投票区名 検索用カナ投票区名
     * @return {@link TohyokuBuilder}
     */
    public UrTohyokuBuilder set検索用カナ投票区名(RString 検索用カナ投票区名) {
        requireNonNull(検索用カナ投票区名, UrSystemErrorMessages.値がnull.getReplacedMessage("検索用カナ投票区名"));
        entity.setKensakuKana(検索用カナ投票区名);
        return this;
    }

    /**
     * 表示順を設定します。
     *
     * @param 表示順 表示順
     * @return {@link TohyokuBuilder}
     */
    public UrTohyokuBuilder set表示順(int 表示順) {
        requireNonNull(表示順, UrSystemErrorMessages.値がnull.getReplacedMessage("表示順"));
        entity.setHyojiJun(表示順);
        return this;
    }

    /**
     * {@link UrTohyoku}のインスタンスを生成します。
     *
     * @return {@link UrTohyoku}のインスタンス
     */
    public UrTohyoku build() {
        return new UrTohyoku(entity, id, tohyojo);
    }
}
