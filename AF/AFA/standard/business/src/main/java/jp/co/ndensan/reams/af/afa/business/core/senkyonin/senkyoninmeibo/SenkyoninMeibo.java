/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikakuIdentifier;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoIdentifier;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoninmeibo.SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoshikaku.SenkyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 選挙人名簿を管理するクラスです。
 */
public class SenkyoninMeibo extends ModelBase<SenkyoninMeiboIdentifier, AfT112SenkyoninMeiboEntity, SenkyoninMeibo> implements Serializable {

    private final AfT112SenkyoninMeiboEntity entity;
    private final SenkyoninMeiboIdentifier id;
    private final Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku;
    private final Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo;

    /**
     * コンストラクタです。<br/>
     * 選挙人名簿の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param グループコード グループコード
     * @param 投票区コード 投票区コード
     * @param 冊 冊
     * @param 頁 頁
     * @param 行 行
     * @param 履歴番号 履歴番号
     * @param 識別コード 識別コード
     * @param 投票区変更抹消フラグ 投票区変更抹消フラグ
     * @param 連番 連番
     * @param 枝番 枝番
     */
    public SenkyoninMeibo(ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            int 頁,
            int 行,
            BigSerial 履歴番号,
            ShikibetsuCode 識別コード,
            boolean 投票区変更抹消フラグ,
            int 連番,
            int 枝番) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("グループコード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(冊, UrSystemErrorMessages.値がnull.getReplacedMessage("冊"));
        requireNonNull(頁, UrSystemErrorMessages.値がnull.getReplacedMessage("頁"));
        requireNonNull(行, UrSystemErrorMessages.値がnull.getReplacedMessage("行"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(投票区変更抹消フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区変更抹消フラグ"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new AfT112SenkyoninMeiboEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setGroupCode(グループコード);
        this.entity.setTohyokuCode(投票区コード);
        this.entity.setSatsu(冊);
        this.entity.setPage(頁);
        this.entity.setGyo(行);
        this.entity.setSeq(履歴番号);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setTohyokuHenkoMasshoFlag(投票区変更抹消フラグ);
        this.entity.setRenban(連番);
        this.entity.setEdaban(枝番);
        this.id = new SenkyoninMeiboIdentifier(
                抄本番号,
                グループコード,
                投票区コード,
                冊,
                頁,
                行,
                履歴番号,
                識別コード,
                投票区変更抹消フラグ,
                連番,
                枝番
        );
        this.senkyoShikaku = Models.create(new ArrayList<SenkyoShikaku>());
        this.tohyoJokyo = Models.create(new ArrayList<TohyoJokyo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT112SenkyoninMeiboEntity}より{@link SenkyoninMeibo}を生成します。
     *
     * @param entity DBより取得した{@link AfT112SenkyoninMeiboEntity}
     */
    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    public SenkyoninMeibo(SenkyoninMeiboEntity entity) {
        this.entity = requireNonNull(entity.get選挙人名簿Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人名簿"));
        this.id = new SenkyoninMeiboIdentifier(
                entity.get選挙人名簿Entity().getShohonNo(),
                entity.get選挙人名簿Entity().getGroupCode(),
                entity.get選挙人名簿Entity().getTohyokuCode(),
                entity.get選挙人名簿Entity().getSatsu(),
                entity.get選挙人名簿Entity().getPage(),
                entity.get選挙人名簿Entity().getGyo(),
                entity.get選挙人名簿Entity().getSeq(),
                entity.get選挙人名簿Entity().getShikibetsuCode(),
                entity.get選挙人名簿Entity().getTohyokuHenkoMasshoFlag(),
                entity.get選挙人名簿Entity().getRenban(),
                entity.get選挙人名簿Entity().getEdaban());
        List<SenkyoShikaku> senkyoShikakuList = new ArrayList<>();
        for (SenkyoShikakuEntity senkyoShikakuEntity : entity.get選挙資格Entity()) {
            senkyoShikakuList.add(new SenkyoShikaku(senkyoShikakuEntity));
        }
        this.senkyoShikaku = Models.create(senkyoShikakuList);

        List<TohyoJokyo> tohyoJokyoList = new ArrayList<>();
        for (AfT201TohyoJokyoEntity tohyoJokyoEntity : entity.get投票状況Entity()) {
            tohyoJokyoList.add(new TohyoJokyo(tohyoJokyoEntity));
        }
        this.tohyoJokyo = Models.create(tohyoJokyoList);
    }

    // </editor-fold>
    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT112SenkyoninMeiboEntity}
     * @param id {@link SenkyoninMeiboIdentifier}
     */
    SenkyoninMeibo(
            AfT112SenkyoninMeiboEntity entity,
            SenkyoninMeiboIdentifier id,
            Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku,
            Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo
    ) {
        this.entity = entity;
        this.id = id;
        this.senkyoShikaku = senkyoShikaku;
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
     * グループコードを返します。
     *
     * @return グループコード
     */
    public RString getグループコード() {
        return entity.getGroupCode();
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
     * 冊を返します。
     *
     * @return 冊
     */
    public RString get冊() {
        return entity.getSatsu();
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public int get頁() {
        return entity.getPage();
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public int get行() {
        return entity.getGyo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return entity.getSeq();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 投票区変更抹消フラグを返します。
     *
     * @return 投票区変更抹消フラグ
     */
    public boolean is投票区変更抹消フラグ() {
        return entity.getTohyokuHenkoMasshoFlag();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public int get枝番() {
        return entity.getEdaban();
    }

    /**
     * {@link AfT112SenkyoninMeiboEntity}のクローンを返します。
     *
     * @return {@link AfT112SenkyoninMeiboEntity}のクローン
     */
    @Override
    public AfT112SenkyoninMeiboEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 選挙人名簿の識別子{@link SenkyoninMeiboIdentifier}を返します。
     *
     * @return 選挙人名簿の識別子{@link SenkyoninMeiboIdentifier}
     */
    @Override
    public SenkyoninMeiboIdentifier identifier() {
        return this.id;
    }
    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * 選挙人名簿配下の要素を削除対象とします。<br/> {@link AfT112SenkyoninMeiboEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 選挙人名簿配下の要素である投票状況の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link SenkyoninMeibo}を返します。
     *
     * @return 削除対象処理実施後の{@link SenkyoninMeibo}
     * @throws IllegalStateException AfT112SenkyoninMeiboEntityのデータ状態が変更の場合
     */
    @Override
    public SenkyoninMeibo deleted() {
        AfT112SenkyoninMeiboEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SenkyoninMeibo(
                deletedEntity, id, senkyoShikaku.deleted(), tohyoJokyo.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || senkyoShikaku.hasAnyChanged() || tohyoJokyo.hasAnyChanged();

    }

    /**
     * 選挙人名簿のみを変更対象とします。<br/> {@link AfT112SenkyoninMeiboEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SenkyoninMeibo}
     */
    public SenkyoninMeibo modifiedModel() {
        AfT112SenkyoninMeiboEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SenkyoninMeibo(
                modifiedEntity, id, senkyoShikaku, tohyoJokyo);
    }

    /**
     * 選挙人名簿が保持する選挙資格に対して、指定の識別子に該当する選挙資格を返します。
     *
     * @param id 選挙資格の識別子
     * @return 選挙資格
     * @throws IllegalStateException 指定の識別子に該当する選挙資格がない場合
     */
    public SenkyoShikaku getSenkyoShikaku(SenkyoShikakuIdentifier id) {
        if (senkyoShikaku.contains(id)) {
            return senkyoShikaku.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 選挙人名簿が保持する選挙資格をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<SenkyoShikaku> getSenkyoShikakuList() {
        return new ArrayList<>(senkyoShikaku.values());

    }

    /**
     * 選挙人名簿が保持する投票状況に対して、指定の識別子に該当する投票状況を返します。
     *
     * @param id 投票状況の識別子
     * @return 投票状況
     * @throws IllegalStateException 指定の識別子に該当する投票状況がない場合
     */
    public TohyoJokyo getTohyoJokyo(TohyoJokyoIdentifier id) {
        if (tohyoJokyo.contains(id)) {
            return tohyoJokyo.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 選挙人名簿が保持する投票状況をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<TohyoJokyo> getTohyoJokyoList() {
        return new ArrayList<>(tohyoJokyo.values());
    }

    /**
     * {@link SenkyoninMeibo}のシリアライズ形式を提供します。
     *
     * @return {@link SenkyoninMeibo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, senkyoShikaku, tohyoJokyo);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final AfT112SenkyoninMeiboEntity entity;
        private final SenkyoninMeiboIdentifier id;
        private final Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku;
        private final Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo;

        private _SerializationProxy(
                AfT112SenkyoninMeiboEntity entity,
                SenkyoninMeiboIdentifier id,
                Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku,
                Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo) {
            this.entity = entity;
            this.id = id;
            this.senkyoShikaku = senkyoShikaku;
            this.tohyoJokyo = tohyoJokyo;
        }

        private Object readResolve() {
            return new SenkyoninMeibo(this.entity, this.id, this.senkyoShikaku, this.tohyoJokyo);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SenkyoninMeiboBuilder#build()}を使用してください。
     *
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder createBuilderForEdit() {
        return new SenkyoninMeiboBuilder(entity, id, senkyoShikaku, tohyoJokyo);
    }
}
