/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyojyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 投票所を管理するクラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class Tohyojo extends ModelBase<TohyojoIdentifier, AfT502TohyojoEntity, Tohyojo> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT502TohyojoEntity entity;
    private final TohyojoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 投票所の新規作成時に使用します。
     *
     * @param 投票所コード 投票所コード
     */
    public Tohyojo(RString 投票所コード) {
        requireNonNull(投票所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票所コード"));
        this.entity = new AfT502TohyojoEntity();
        this.entity.setTohyojoCode(投票所コード);
        this.id = new TohyojoIdentifier(投票所コード);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT502TohyojoEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link AfT502TohyojoEntity}
     */
    public Tohyojo(AfT502TohyojoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票所"));
        this.id = new TohyojoIdentifier(entity.getTohyojoCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT502TohyojoEntity}
     * @param id {@link TohyojoIdentifier}
     */
    Tohyojo(
            AfT502TohyojoEntity entity,
            TohyojoIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 投票所コードを返します。
     *
     * @return 投票所コード
     */
    public RString get投票所コード() {
        return entity.getTohyojoCode();
    }

    /**
     * 投票所名を返します。
     *
     * @return 投票所名
     */
    public RString get投票所名() {
        return entity.getTohyojoName();
    }

    /**
     * カナ投票所名を返します。
     *
     * @return カナ投票所名
     */
    public RString getカナ投票所名() {
        return entity.getKanaTohyojoName();
    }

    /**
     * 検索用カナ投票所名を返します。
     *
     * @return 検索用カナ投票所名
     */
    public RString get検索用カナ投票所名() {
        return entity.getSearchKanaTohyojoName();
    }

    /**
     * {@link AfT502TohyojoEntity}のクローンを返します。
     *
     * @return {@link AfT502TohyojoEntity}のクローン
     */
    @Override
    public AfT502TohyojoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票所の識別子{@link TohyojoIdentifier}を返します。
     *
     * @return 投票所の識別子{@link TohyojoIdentifier}
     */
    @Override
    public TohyojoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する投票所を削除対象とします。<br/> {@link AfT502TohyojoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Tohyojo}
     * @throws IllegalStateException AfT502TohyojoEntityのデータ状態が変更の場合
     */
    @Override
    public Tohyojo deleted() {
        AfT502TohyojoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Tohyojo(deletedEntity, id);
    }

    /**
     * {@link Tohyojo}のシリアライズ形式を提供します。
     *
     * @return {@link Tohyojo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7402213614486601766L;
        private final AfT502TohyojoEntity entity;
        private final TohyojoIdentifier id;

        private _SerializationProxy(AfT502TohyojoEntity entity, TohyojoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Tohyojo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyokuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyojoBuilder createBuilderForEdit() {
        return new TohyojoBuilder(entity, id);
    }

}
