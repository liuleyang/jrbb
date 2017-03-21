/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubinIdentifier;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 不在者投票資格を管理するクラスです。
 */
public class FuzaishaTohyoShikaku extends
        ModelBase<FuzaishaTohyoShikakuIdentifier, AfT114FuzaishaTohyoShikakuEntity, FuzaishaTohyoShikaku>
        implements Serializable {

    private final AfT114FuzaishaTohyoShikakuEntity entity;
    private final FuzaishaTohyoShikakuIdentifier id;
    private final Models<FuzaishaTohyoShikakuYubinIdentifier, FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubin;

    /**
     * コンストラクタです。<br/>
     * 不在者投票資格の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 投票資格種類 投票資格種類
     * @param 履歴番号 履歴番号
     */
    public FuzaishaTohyoShikaku(ShikibetsuCode 識別コード,
            Code 投票資格種類,
            BigSerial 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(投票資格種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票資格種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new AfT114FuzaishaTohyoShikakuEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setTohyoShikakuShurui(投票資格種類);
        this.entity.setSeq(履歴番号);
        this.id = new FuzaishaTohyoShikakuIdentifier(
                識別コード,
                投票資格種類,
                履歴番号
        );
        this.fuzaishaTohyoShikakuYubin = Models.create(new ArrayList<FuzaishaTohyoShikakuYubin>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}より{@link FuzaishaTohyoShikaku}を生成します。
     *
     * @param entity DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}
     */
    public FuzaishaTohyoShikaku(FuzaishaTohyoShikakuEntity entity) {
        this.entity = requireNonNull(entity.get不在者投票資格Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格"));
        this.id = new FuzaishaTohyoShikakuIdentifier(
                entity.get不在者投票資格Entity().getShikibetsuCode(),
                entity.get不在者投票資格Entity().getTohyoShikakuShurui(),
                entity.get不在者投票資格Entity().getSeq());
        List<FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubinList = new ArrayList<>();
        for (AfT115FuzaishaTohyoShikakuYubinEntity 郵便投票資格付随情報Entity : entity.get郵便投票資格付随情報Entity()) {
            fuzaishaTohyoShikakuYubinList.add(new FuzaishaTohyoShikakuYubin(郵便投票資格付随情報Entity));
        }
        this.fuzaishaTohyoShikakuYubin = Models.create(fuzaishaTohyoShikakuYubinList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT114FuzaishaTohyoShikakuEntity}
     * @param id {@link FuzaishaTohyoShikakuIdentifier}
     */
    FuzaishaTohyoShikaku(
            AfT114FuzaishaTohyoShikakuEntity entity,
            FuzaishaTohyoShikakuIdentifier id,
            Models<FuzaishaTohyoShikakuYubinIdentifier, FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubin
    ) {
        this.entity = entity;
        this.id = id;
        this.fuzaishaTohyoShikakuYubin = fuzaishaTohyoShikakuYubin;
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
     * 投票資格種類を返します。
     *
     * @return 投票資格種類
     */
    public Code get投票資格種類() {
        return entity.getTohyoShikakuShurui();
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
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return entity.getKofuYMD();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return entity.getKofuNo();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格登録年月日() {
        return entity.getShikakuTorokuYMD();
    }

    /**
     * 資格満了年月日を返します。
     *
     * @return 資格満了年月日
     */
    public FlexibleDate get資格満了年月日() {
        return entity.getShikakuManryoYMD();
    }

    /**
     * 資格抹消年月日を返します。
     *
     * @return 資格抹消年月日
     */
    public FlexibleDate get資格抹消年月日() {
        return entity.getShikakuMasshoYMD();
    }

    /**
     * 資格抹消事由コードを返します。
     *
     * @return 資格抹消事由コード
     */
    public Code get資格抹消事由コード() {
        return entity.getShikakuMasshoJiyuCode();
    }

    /**
     * {@link AfT114FuzaishaTohyoShikakuEntity}のクローンを返します。
     *
     * @return {@link AfT114FuzaishaTohyoShikakuEntity}のクローン
     */
    @Override
    public AfT114FuzaishaTohyoShikakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 不在者投票資格の識別子{@link FuzaishaTohyoShikakuIdentifier}を返します。
     *
     * @return 不在者投票資格の識別子{@link FuzaishaTohyoShikakuIdentifier}
     */
    @Override
    public FuzaishaTohyoShikakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 不在者投票資格配下の要素を削除対象とします。<br/>
     * {@link AfT114FuzaishaTohyoShikakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 不在者投票資格配下の要素である郵便投票資格付随情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link FuzaishaTohyoShikaku}を返します。
     *
     * @return 削除対象処理実施後の{@link FuzaishaTohyoShikaku}
     * @throws IllegalStateException AfT114FuzaishaTohyoShikakuEntityのデータ状態が変更の場合
     */
    @Override
    public FuzaishaTohyoShikaku deleted() {
        AfT114FuzaishaTohyoShikakuEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FuzaishaTohyoShikaku(
                deletedEntity, id, fuzaishaTohyoShikakuYubin.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || fuzaishaTohyoShikakuYubin.hasAnyChanged();
    }

    /**
     * 不在者投票資格のみを変更対象とします。<br/>
     * {@link AfT114FuzaishaTohyoShikakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FuzaishaTohyoShikaku}
     */
    public FuzaishaTohyoShikaku modifiedModel() {
        AfT114FuzaishaTohyoShikakuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FuzaishaTohyoShikaku(
                modifiedEntity, id, fuzaishaTohyoShikakuYubin);
    }

    /**
     * 不在者投票資格が保持する郵便投票資格付随情報に対して、指定の識別子に該当する郵便投票資格付随情報を返します。
     *
     * @param id 郵便投票資格付随情報の識別子
     * @return 郵便投票資格付随情報
     * @throws IllegalStateException 指定の識別子に該当する郵便投票資格付随情報がない場合
     */
    public FuzaishaTohyoShikakuYubin getFuzaishaTohyoShikakuYubin(FuzaishaTohyoShikakuYubinIdentifier id) {
        if (fuzaishaTohyoShikakuYubin.contains(id)) {
            return fuzaishaTohyoShikakuYubin.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 不在者投票資格が保持する郵便投票資格付随情報をリストで返します。
     *
     * @return 郵便投票資格付随情報
     */
    public List<FuzaishaTohyoShikakuYubin> getFuzaishaTohyoShikakuYubinList() {
        return new ArrayList<>(fuzaishaTohyoShikakuYubin.values());

    }

    /**
     * {@link FuzaishaTohyoShikaku}のシリアライズ形式を提供します。
     *
     * @return {@link FuzaishaTohyoShikaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, fuzaishaTohyoShikakuYubin);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -2673578377562291250L;
        private final AfT114FuzaishaTohyoShikakuEntity entity;
        private final FuzaishaTohyoShikakuIdentifier id;
        private final Models<FuzaishaTohyoShikakuYubinIdentifier, FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubin;

        private _SerializationProxy(
                AfT114FuzaishaTohyoShikakuEntity entity,
                FuzaishaTohyoShikakuIdentifier id,
                Models<FuzaishaTohyoShikakuYubinIdentifier, FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubin
        ) {
            this.entity = entity;
            this.id = id;
            this.fuzaishaTohyoShikakuYubin = fuzaishaTohyoShikakuYubin;
        }

        private Object readResolve() {
            return new FuzaishaTohyoShikaku(this.entity, this.id, this.fuzaishaTohyoShikakuYubin);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link FuzaishaTohyoShikakuBuilder#build()}を使用してください。
     *
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder createBuilderForEdit() {
        return new FuzaishaTohyoShikakuBuilder(entity, id, fuzaishaTohyoShikakuYubin);
    }
}
