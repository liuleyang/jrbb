/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.TohyojoIdentifier;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku.TohyokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 投票区を管理するクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class Tohyoku extends ModelBase<TohyokuIdentifier, AfT501TohyokuEntity, Tohyoku> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT501TohyokuEntity entity;
    private final TohyokuIdentifier id;
    private final Models<TohyojoIdentifier, Tohyojo> tohyojo;

    /**
     * コンストラクタです。<br/>
     * 投票区の新規作成時に使用します。
     *
     * @param 選挙種類 選挙種類
     * @param 投票区コード 投票区コード
     */
    public Tohyoku(Code 選挙種類, RString 投票区コード) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        this.entity = new AfT501TohyokuEntity();
        this.entity.setSenkyoShurui(選挙種類);
        this.entity.setTohyokuCode(投票区コード);
        this.id = new TohyokuIdentifier(選挙種類, 投票区コード);
        this.tohyojo = Models.create(new ArrayList<Tohyojo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT501TohyokuEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link AfT501TohyokuEntity}
     */
    public Tohyoku(AfT501TohyokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区"));
        this.id = new TohyokuIdentifier(entity.getSenkyoShurui(), entity.getTohyokuCode());
        this.tohyojo = Models.create(new ArrayList<Tohyojo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT501TohyokuEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link TohyokuEntity}
     */
    public Tohyoku(TohyokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区"));
        this.entity = entity.get投票区Entity();
        this.id = new TohyokuIdentifier(entity.get投票区Entity().getSenkyoShurui(), entity.get投票区Entity().getTohyokuCode());

        List<Tohyojo> tohyojoList = new ArrayList<>();
        for (AfT502TohyojoEntity tohyojo : entity.get投票所Entity()) {
            tohyojoList.add(new Tohyojo(tohyojo));
        }
        this.tohyojo = Models.create(tohyojoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT501TohyokuEntity}
     * @param id {@link TohyokuIdentifier}
     * @param tohyojo {@link Models<TohyojoIdentifier, Tohyojo>}
     */
    Tohyoku(
            AfT501TohyokuEntity entity,
            TohyokuIdentifier id,
            Models<TohyojoIdentifier, Tohyojo> tohyojo) {
        this.entity = entity;
        this.id = id;
        this.tohyojo = tohyojo;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getSenkyoShurui();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return entity.getTohyokuCode();
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return entity.getTohyokuName();
    }

    /**
     * カナ投票区名を返します。
     *
     * @return カナ投票区名
     */
    public RString getカナ投票区名() {
        return entity.getKanaTohyokuName();
    }

    /**
     * 検索用カナ投票区名を返します。
     *
     * @return 検索用カナ投票区名
     */
    public RString get検索用カナ投票区名() {
        return entity.getSearchKanaTohyokuName();
    }

    /**
     * 表示順を返します。
     *
     * @return 表示順
     */
    public int get表示順() {
        return entity.getHyojijun();
    }

    /**
     * 投票所名を返します。
     *
     * @return 投票所名
     */
    public RString get投票所名() {
        return null == tohyojo || tohyojo.values().isEmpty() ? RString.EMPTY : tohyojo.getLatest().get投票所名();
    }

    /**
     * {@link AfT501TohyokuEntity}のクローンを返します。
     *
     * @return {@link AfT501TohyokuEntity}のクローン
     */
    @Override
    public AfT501TohyokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票区の識別子{@link TohyokuIdentifier}を返します。
     *
     * @return 投票区の識別子{@link TohyokuIdentifier}
     */
    @Override
    public TohyokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する投票区を削除対象とします。<br/> {@link AfT501TohyokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Tohyoku}
     * @throws IllegalStateException AfT501TohyokuEntityのデータ状態が変更の場合
     */
    @Override
    public Tohyoku deleted() {
        AfT501TohyokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Tohyoku(deletedEntity, id, tohyojo.deleted());
    }

    /**
     * {@link Tohyoku}のシリアライズ形式を提供します。
     *
     * @return {@link Tohyoku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, tohyojo);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7402213614486601766L;
        private final AfT501TohyokuEntity entity;
        private final TohyokuIdentifier id;
        private final Models<TohyojoIdentifier, Tohyojo> tohyojo;

        private _SerializationProxy(AfT501TohyokuEntity entity, TohyokuIdentifier id, Models<TohyojoIdentifier, Tohyojo> tohyojo) {
            this.entity = entity;
            this.id = id;
            this.tohyojo = tohyojo;
        }

        private Object readResolve() {
            return new Tohyoku(this.entity, this.id, this.tohyojo);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyokuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyokuBuilder createBuilderForEdit() {
        return new TohyokuBuilder(entity, id, tohyojo);
    }

}
