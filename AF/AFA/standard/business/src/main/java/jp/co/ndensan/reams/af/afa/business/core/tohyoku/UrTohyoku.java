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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku.UrTohyokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 投票区を管理するクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class UrTohyoku extends ModelBase<UrTohyokuIdentifier, UrT0159TohyokuEntity, UrTohyoku> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final UrT0159TohyokuEntity entity;
    private final UrTohyokuIdentifier id;
    private final Models<TohyojoIdentifier, Tohyojo> tohyojo;

    /**
     * コンストラクタです。<br/>
     * 投票区の新規作成時に使用します。
     *
     * @param 投票区コード 投票区コード
     * @param 地方公共団体コード 地方公共団体コード
     * @param 連番 連番
     * @param 有効開始年月日 有効開始年月日
     */
    public UrTohyoku(TohyokuCode 投票区コード, LasdecCode 地方公共団体コード, int 連番, FlexibleDate 有効開始年月日) {

        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(地方公共団体コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地方公共団体コード"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        this.entity = new UrT0159TohyokuEntity();
        this.entity.setTohyokuCode(投票区コード);
        this.entity.setLasdecCode(地方公共団体コード);
        this.entity.setLasdecCodeRenban(連番);
        this.entity.setYukoKaishiYMD(有効開始年月日);
        this.id = new UrTohyokuIdentifier(投票区コード, 地方公共団体コード, 連番, 有効開始年月日);
        this.tohyojo = Models.create(new ArrayList<Tohyojo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UrT0159TohyokuEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link UrT0159TohyokuEntity}
     */
    public UrTohyoku(UrT0159TohyokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区"));
        this.id = new UrTohyokuIdentifier(entity.getTohyokuCode(), entity.getLasdecCode(), entity.getLasdecCodeRenban(), entity.getYukoKaishiYMD());
        this.tohyojo = Models.create(new ArrayList<Tohyojo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UrT0159TohyokuEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link TohyokuEntity}
     */
    public UrTohyoku(UrTohyokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区"));
        this.entity = entity.get投票区Entity();
        this.id = new UrTohyokuIdentifier(this.entity.getTohyokuCode(), this.entity.getLasdecCode(),
                this.entity.getLasdecCodeRenban(), this.entity.getYukoKaishiYMD());

        List<Tohyojo> tohyojoList = new ArrayList<>();
        for (AfT502TohyojoEntity tohyojoInfo : entity.get投票所Entity()) {
            tohyojoList.add(new Tohyojo(tohyojoInfo));
        }
        this.tohyojo = Models.create(tohyojoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link UrT0159TohyokuEntity}
     * @param id {@link UrTohyokuIdentifier}
     * @param tohyojo {@link Models<TohyojoIdentifier, Tohyojo>}
     */
    UrTohyoku(
            UrT0159TohyokuEntity entity,
            UrTohyokuIdentifier id,
            Models<TohyojoIdentifier, Tohyojo> tohyojo) {
        this.entity = entity;
        this.id = id;
        this.tohyojo = tohyojo;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public TohyokuCode get投票区コード() {
        return entity.getTohyokuCode();
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return entity.getName();
    }

    /**
     * カナ投票区名を返します。
     *
     * @return カナ投票区名
     */
    public RString getカナ投票区名() {
        return entity.getKanaName();
    }

    /**
     * 検索用カナ投票区名を返します。
     *
     * @return 検索用カナ投票区名
     */
    public RString get検索用カナ投票区名() {
        return entity.getKensakuKana();
    }

    /**
     * 表示順を返します。
     *
     * @return 表示順
     */
    public int get表示順() {
        return entity.getHyojiJun();
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
     * {@link UrT0159TohyokuEntity}のクローンを返します。
     *
     * @return {@link UrT0159TohyokuEntity}のクローン
     */
    @Override
    public UrT0159TohyokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票区の識別子{@link UrTohyokuIdentifier}を返します。
     *
     * @return 投票区の識別子{@link UrTohyokuIdentifier}
     */
    @Override
    public UrTohyokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する投票区を削除対象とします。<br/> {@link UrT0159TohyokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Tohyoku}
     * @throws IllegalStateException UrT0159TohyokuEntityのデータ状態が変更の場合
     */
    @Override
    public UrTohyoku deleted() {
        UrT0159TohyokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new UrTohyoku(deletedEntity, id, tohyojo.deleted());
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
        private final UrT0159TohyokuEntity entity;
        private final UrTohyokuIdentifier id;
        private final Models<TohyojoIdentifier, Tohyojo> tohyojo;

        private _SerializationProxy(UrT0159TohyokuEntity entity, UrTohyokuIdentifier id, Models<TohyojoIdentifier, Tohyojo> tohyojo) {
            this.entity = entity;
            this.id = id;
            this.tohyojo = tohyojo;
        }

        private Object readResolve() {
            return new UrTohyoku(this.entity, this.id, this.tohyojo);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link UrTohyokuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public UrTohyokuBuilder createBuilderForEdit() {
        return new UrTohyokuBuilder(entity, id, tohyojo);
    }

}
