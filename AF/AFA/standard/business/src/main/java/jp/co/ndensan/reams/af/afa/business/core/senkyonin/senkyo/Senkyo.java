/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoIdentifier;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 選挙を管理するクラスです。
 */
public class Senkyo extends ModelBase<SenkyoIdentifier, AfT111SenkyoEntity, Senkyo> implements Serializable {

    private final AfT111SenkyoEntity entity;
    private final SenkyoIdentifier id;
    private final Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo;

    /**
     * コンストラクタです。<br/>
     * 選挙の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     */
    public Senkyo(ShohonNo 抄本番号,
            SenkyoNo 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        this.entity = new AfT111SenkyoEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setSenkyoNo(選挙番号);
        this.id = new SenkyoIdentifier(
                抄本番号,
                選挙番号
        );
        this.tohyoJokyo = Models.create(new ArrayList<TohyoJokyo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT111SenkyoEntity}より{@link Senkyo}を生成します。
     *
     * @param entity DBより取得した{@link AfT111SenkyoEntity}
     */
    public Senkyo(SenkyoEntity entity) {
        this.entity = requireNonNull(entity.get選挙Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("選挙"));
        this.id = new SenkyoIdentifier(
                entity.get選挙Entity().getShohonNo(),
                entity.get選挙Entity().getSenkyoNo());
        List<TohyoJokyo> tohyoJokyoList = new ArrayList<>();
        for (AfT201TohyoJokyoEntity tohyoJokyoEntity : entity.get投票状況Entity()) {
            tohyoJokyoList.add(new TohyoJokyo(tohyoJokyoEntity));
        }
        this.tohyoJokyo = Models.create(tohyoJokyoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT111SenkyoEntity}
     * @param id {@link SenkyoIdentifier}
     */
    Senkyo(
            AfT111SenkyoEntity entity,
            SenkyoIdentifier id,
            Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo
    ) {
        this.entity = entity;
        this.id = id;
        this.tohyoJokyo = tohyoJokyo;
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
     * 選挙レベルを返します。
     *
     * @return 選挙レベル
     */
    public Code get選挙レベル() {
        return entity.getSenkyoLevel();
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称
     */
    public RString get選挙名称() {
        return entity.getSenkyoName();
    }

    /**
     * 選挙略称を返します。
     *
     * @return 選挙略称
     */
    public RString get選挙略称() {
        return entity.getSenkyoRyakusho();
    }

    /**
     * 選挙マークを返します。
     *
     * @return 選挙マーク
     */
    public RString get選挙マーク() {
        return entity.getSenkyoMark();
    }

    /**
     * 名簿基準年月日を返します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 告示（公示）年月日を返します。
     *
     * @return 告示（公示）年月日
     */
    public FlexibleDate get告示公示年月日() {
        return entity.getKokujiYMD();
    }

    /**
     * 転出期限年月日を返します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return entity.getTenshutsuKigenYMD();
    }

    /**
     * 転入期限年月日を返します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return entity.getTennyuKigenYMD();
    }

    /**
     * 投票受付開始年月日を返します。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return entity.getTohyoUketsukeYMD();
    }

    /**
     * 無投票選挙フラグを返します。
     *
     * @return 無投票選挙フラグ
     */
    public boolean is無投票選挙() {
        return entity.getMutohyoSenkyoFlag();
    }

    /**
     * {@link AfT111SenkyoEntity}のクローンを返します。
     *
     * @return {@link AfT111SenkyoEntity}のクローン
     */
    @Override
    public AfT111SenkyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 選挙の識別子{@link SenkyoIdentifier}を返します。
     *
     * @return 選挙の識別子{@link SenkyoIdentifier}
     */
    @Override
    public SenkyoIdentifier identifier() {
        return this.id;
    }

    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * 選挙配下の要素を削除対象とします。<br/> {@link AfT111SenkyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 選挙配下の要素である投票状況の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link Senkyo}を返します。
     *
     * @return 削除対象処理実施後の{@link Senkyo}
     * @throws IllegalStateException AfT111SenkyoEntityのデータ状態が変更の場合
     */
    @Override
    public Senkyo deleted() {
        AfT111SenkyoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Senkyo(
                deletedEntity, id, tohyoJokyo.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || tohyoJokyo.hasAnyChanged();
    }

    /**
     * 選挙のみを変更対象とします。<br/> {@link AfT111SenkyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Senkyo}
     */
    public Senkyo modifiedModel() {
        AfT111SenkyoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Senkyo(
                modifiedEntity, id, tohyoJokyo);
    }

    /**
     * 選挙が保持する投票状況に対して、指定の識別子に該当する投票状況を返します。
     *
     * @param id 投票状況の識別子
     * @return 投票状況
     * @throws IllegalStateException 指定の識別子に該当する投票状況がない場合
     */
    public TohyoJokyo getTohyoJokyo(TohyoJokyoIdentifier id) {
        if (tohyoJokyo.contains(id)) {
            return tohyoJokyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 選挙が保持する投票状況をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<TohyoJokyo> getTohyoJokyoList() {
        return new ArrayList<>(tohyoJokyo.values());

    }

    /**
     * {@link Senkyo}のシリアライズ形式を提供します。
     *
     * @return {@link Senkyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, tohyoJokyo);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final AfT111SenkyoEntity entity;
        private final SenkyoIdentifier id;
        private final Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo;

        private _SerializationProxy(
                AfT111SenkyoEntity entity,
                SenkyoIdentifier id,
                Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo
        ) {
            this.entity = entity;
            this.id = id;
            this.tohyoJokyo = tohyoJokyo;
        }

        private Object readResolve() {
            return new Senkyo(this.entity, this.id, this.tohyoJokyo);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SenkyoBuilder#build()}を使用してください。
     *
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder createBuilderForEdit() {
        return new SenkyoBuilder(entity, id, tohyoJokyo);
    }
    // </editor-fold>
}
