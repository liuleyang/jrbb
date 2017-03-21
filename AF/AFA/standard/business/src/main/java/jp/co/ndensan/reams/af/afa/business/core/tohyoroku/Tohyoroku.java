/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 期日前・当日投票録を管理するクラスです。
 */
public class Tohyoroku extends ModelBase<TohyorokuIdentifier, AfT204TohyorokuEntity, Tohyoroku> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT204TohyorokuEntity entity;
    private final TohyorokuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 期日前・当日投票録の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     */
    public Tohyoroku(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        this.entity = new AfT204TohyorokuEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setSenkyoNo(選挙番号);
        this.entity.setHokokuYMD(報告年月日);
        this.entity.setShisetsuCode(施設コード);
        this.entity.setTohyokuCode(投票区コード);
        this.id = new TohyorokuIdentifier(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT204TohyorokuEntity}を生成します。
     *
     * @param entity DBより取得した{@link AfT204TohyorokuEntity}
     */
    public Tohyoroku(AfT204TohyorokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("期日前・当日投票録"));
        this.id = new TohyorokuIdentifier(
                entity.getShohonNo(),
                entity.getSenkyoNo(),
                entity.getHokokuYMD(),
                entity.getShisetsuCode(),
                entity.getTohyokuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT204TohyorokuEntity}
     * @param id {@link TohyorokuIdentifier}
     */
    Tohyoroku(
            AfT204TohyorokuEntity entity,
            TohyorokuIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public SenkyoNo get選挙番号() {
        return entity.getSenkyoNo();
    }

    /**
     * 報告年月日を返します。
     *
     * @return 報告年月日
     */
    public FlexibleDate get報告年月日() {
        return entity.getHokokuYMD();
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return entity.getShisetsuCode();
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
     * 投票所設置状況を返します。
     *
     * @return 投票所設置状況
     */
    public RString get投票所設置状況() {
        return entity.getSecchiJokyo();
    }

    /**
     * 投票所開設場所を返します。
     *
     * @return 投票所開設場所
     */
    public RString get投票所開設場所() {
        return entity.getKaisetsuBasho();
    }

    /**
     * 設置期間（開始年月日）を返します。
     *
     * @return 設置期間（開始年月日）
     */
    public FlexibleDate get設置期間_開始年月日() {
        return entity.getSecchiFirstYMD();
    }

    /**
     * 設置期間（終了年月日）を返します。
     *
     * @return 設置期間（終了年月日）
     */
    public FlexibleDate get設置期間_終了年月日() {
        return entity.getSecchiLastYMD();
    }

    /**
     * 開閉時刻（開始）を返します。
     *
     * @return 開閉時刻（開始）
     */
    public RTime get開閉時刻_開始() {
        return entity.getKaiheiStartTime();
    }

    /**
     * 開閉時刻（終了）を返します。
     *
     * @return 開閉時刻（終了）
     */
    public RTime get開閉時刻_終了() {
        return entity.getKaiheiStopTime();
    }

    /**
     * 選管書記人数を返します。
     *
     * @return 選管書記人数
     */
    public int get選管書記人数() {
        return entity.getShokiNinzu();
    }

    /**
     * 職員人数を返します。
     *
     * @return 職員人数
     */
    public int get職員人数() {
        return entity.getShokuinNinzu();
    }

    /**
     * その他人数を返します。
     *
     * @return その他人数
     */
    public int getその他人数() {
        return entity.getSonotaNinzu();
    }

    /**
     * {@link AfT204TohyorokuEntity}のクローンを返します。
     *
     * @return {@link AfT204TohyorokuEntity}のクローン
     */
    @Override
    public AfT204TohyorokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 期日前・当日投票録の識別子{@link TohyorokuIdentifier}を返します。
     *
     * @return 選挙の識別子{@link TohyorokuIdentifier}
     */
    @Override
    public TohyorokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する期日前・当日投票録を削除対象とします。<br/> {@link AfT204TohyorokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Tohyoroku}
     * @throws IllegalStateException AfT204TohyorokuEntityのデータ状態が変更の場合
     */
    @Override
    public Tohyoroku deleted() {
        AfT204TohyorokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Tohyoroku(deletedEntity, id);
    }

    /**
     * {@link Tohyoroku}のシリアライズ形式を提供します。
     *
     * @return {@link Tohyoroku}のシリアライズ形式
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
        private final AfT204TohyorokuEntity entity;
        private final TohyorokuIdentifier id;

        private _SerializationProxy(AfT204TohyorokuEntity entity, TohyorokuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Tohyoroku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyorokuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyorokuBuilder createBuilderForEdit() {
        return new TohyorokuBuilder(entity, id);
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyorokuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyorokuBuilder createBuilderForAddEdit() {
        entity.setState(EntityDataState.Added);
        return new TohyorokuBuilder(entity, id);
    }

    /**
     * 投票録のみを変更対象とします。<br/> {@link AfT204TohyorokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Tohyoroku}
     */
    public Tohyoroku modifiedModel() {
        AfT204TohyorokuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Tohyoroku(modifiedEntity, id);
    }
}
