/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.shohon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo.SenkyoIdentifier;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikakuIdentifier;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeiboIdentifier;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoninmeibo.SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shohon.ShohonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 抄本を管理するクラスです。
 */
public class Shohon extends ParentModelBase<ShohonIdentifier, AfT100ShohonEntity, Shohon> implements Serializable {

    private final AfT100ShohonEntity entity;
    private final ShohonIdentifier id;
    private final Models<SenkyoIdentifier, Senkyo> senkyo;
    private final Models<SenkyoninMeiboIdentifier, SenkyoninMeibo> senkyoninMeibo;
    private final Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku;

    /**
     * コンストラクタです。<br/>
     * 抄本の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙種類 選挙種類
     */
    public Shohon(ShohonNo 抄本番号, Code 選挙種類) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        this.entity = new AfT100ShohonEntity();
        this.entity.setShohonNo(抄本番号);
        this.id = new ShohonIdentifier(抄本番号, 選挙種類);
        this.senkyo = Models.create(new ArrayList<Senkyo>());
        this.senkyoninMeibo = Models.create(new ArrayList<SenkyoninMeibo>());
        this.senkyoShikaku = Models.create(new ArrayList<SenkyoShikaku>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT100ShohonEntity}より{@link Shohon}を生成します。
     *
     * @param entity DBより取得した{@link AfT100ShohonEntity}
     */
    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    public Shohon(ShohonEntity entity) {
        this.entity = requireNonNull(entity.get抄本Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("抄本"));
        this.id = new ShohonIdentifier(
                entity.get抄本Entity().getShohonNo(),
                entity.get抄本Entity().getSenkyoShurui());

        List<Senkyo> senkyoList = new ArrayList<>();
        for (SenkyoEntity senkyoEntity : entity.get選挙Entity()) {
            senkyoList.add(new Senkyo(senkyoEntity));
        }
        this.senkyo = Models.create(senkyoList);

        List<SenkyoninMeibo> senkyoninMeiboList = new ArrayList<>();
        for (SenkyoninMeiboEntity meiboEntity : entity.get選挙人名簿Entity()) {
            senkyoninMeiboList.add(new SenkyoninMeibo(meiboEntity));
        }
        this.senkyoninMeibo = Models.create(senkyoninMeiboList);

        List<SenkyoShikaku> senkyoShikakuList = new ArrayList<>();
        for (AfT113SenkyoShikakuEntity senkyoShikakuEntity : entity.get選挙資格Entity()) {
            senkyoShikakuList.add(new SenkyoShikaku(senkyoShikakuEntity));
        }
        this.senkyoShikaku = Models.create(senkyoShikakuList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT100ShohonEntity}
     * @param id {@link ShohonIdentifier}
     */
    Shohon(
            AfT100ShohonEntity entity,
            ShohonIdentifier id,
            Models<SenkyoIdentifier, Senkyo> senkyo,
            Models<SenkyoninMeiboIdentifier, SenkyoninMeibo> senkyoninMeibo,
            Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku
    ) {
        this.entity = entity;
        this.id = id;
        this.senkyo = senkyo;
        this.senkyoninMeibo = senkyoninMeibo;
        this.senkyoShikaku = senkyoShikaku;

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
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getSenkyoShurui();
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名
     */
    public RString get抄本名() {
        return entity.getShohonName();
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return entity.getTohyoYMD();
    }

    /**
     * 規定年齢到達年月日を返します。
     *
     * @return 規定年齢到達年月日
     */
    public FlexibleDate get規定年齢到達年月日() {
        return entity.getKiteiNenreiTotatsuYMD();
    }

    /**
     * 処理年月日を返します。
     *
     * @return 処理年月日
     */
    public FlexibleDate get処理年月日() {
        return entity.getShoriYMD();
    }

    /**
     * 入場券発行固有連番を返します。
     *
     * @return 入場券発行固有連番
     */
    public Decimal get入場券発行固有連番() {
        return entity.getNyujokenReportIndex();
    }

    /**
     * {@link AfT100ShohonEntity}のクローンを返します。
     *
     * @return {@link AfT100ShohonEntity}のクローン
     */
    @Override
    public AfT100ShohonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 抄本の識別子{@link ShohonIdentifier}を返します。
     *
     * @return 抄本の識別子{@link ShohonIdentifier}
     */
    @Override
    public ShohonIdentifier identifier() {
        return this.id;
    }

    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * 抄本配下の要素を削除対象とします。<br/> {@link AfT100ShohonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 抄本配下の要素である選挙資格の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link Shohon}を返します。
     *
     * @return 削除対象処理実施後の{@link Shohon}
     * @throws IllegalStateException AfT100ShohonEntityのデータ状態が変更の場合
     */
    @Override
    public Shohon deleted() {
        AfT100ShohonEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Shohon(
                deletedEntity, id, senkyo.deleted(), senkyoninMeibo.deleted(), senkyoShikaku.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || senkyo.hasAnyChanged() || senkyoninMeibo.hasAnyChanged() || senkyoShikaku.hasAnyChanged();
    }

    /**
     * 抄本のみを変更対象とします。<br/> {@link AfT100ShohonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Shohon}
     */
    @Override
    public Shohon modifiedModel() {
        AfT100ShohonEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Shohon(
                modifiedEntity, id, senkyo, senkyoninMeibo, senkyoShikaku);
    }

    /**
     * 抄本が保持する選挙に対して、指定の識別子に該当する選挙を返します。
     *
     * @param id 選挙の識別子
     * @return 選挙
     * @throws IllegalStateException 指定の識別子に該当する選挙がない場合
     */
    public Senkyo getSenkyo(SenkyoIdentifier id) {
        if (senkyo.contains(id)) {
            return senkyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 抄本が保持する選挙をリストで返します。
     *
     * @return 選挙リスト
     */
    public List<Senkyo> getSenkyoList() {
        return new ArrayList<>(senkyo.values());

    }

    /**
     * 抄本が保持する選挙人名簿に対して、指定の識別子に該当する選挙人名簿を返します。
     *
     * @param id 選挙人名簿の識別子
     * @return 選挙人名簿
     * @throws IllegalStateException 指定の識別子に該当する選挙人名簿がない場合
     */
    public SenkyoninMeibo getSenkyoninMeibo(SenkyoninMeiboIdentifier id) {
        if (senkyoninMeibo.contains(id)) {
            return senkyoninMeibo.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 抄本が保持する選挙人名簿をリストで返します。
     *
     * @return 選挙人名簿リスト
     */
    public List<SenkyoninMeibo> getSenkyoninMeiboList() {
        return new ArrayList<>(senkyoninMeibo.values());
    }

    /**
     * 抄本が保持する選挙資格に対して、指定の識別子に該当する選挙資格を返します。
     *
     * @param id 選挙資格の識別子
     * @return 選挙資格
     * @throws IllegalStateException 指定の識別子に該当する選挙資格がない場合
     */
    public SenkyoShikaku getSenkyoShikaku(SenkyoShikakuIdentifier id) {
        if (senkyoShikaku.contains(id)) {
            return senkyoShikaku.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 抄本が保持する選挙資格をリストで返します。
     *
     * @return 選挙資格リスト
     */
    public List<SenkyoShikaku> getSenkyoShikakuList() {
        return new ArrayList<>(senkyoShikaku.values());

    }

    /**
     * {@link Shohon}のシリアライズ形式を提供します。
     *
     * @return {@link Shohon}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, senkyo, senkyoninMeibo, senkyoShikaku);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final AfT100ShohonEntity entity;
        private final ShohonIdentifier id;
        private final Models<SenkyoIdentifier, Senkyo> senkyo;
        private final Models<SenkyoninMeiboIdentifier, SenkyoninMeibo> senkyoninMeibo;
        private final Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku;

        private _SerializationProxy(
                AfT100ShohonEntity entity,
                ShohonIdentifier id,
                Models<SenkyoIdentifier, Senkyo> senkyo,
                Models<SenkyoninMeiboIdentifier, SenkyoninMeibo> senkyoninMeibo,
                Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku
        ) {
            this.entity = entity;
            this.id = id;
            this.senkyo = senkyo;
            this.senkyoninMeibo = senkyoninMeibo;
            this.senkyoShikaku = senkyoShikaku;
        }

        private Object readResolve() {
            return new Shohon(this.entity, this.id, this.senkyo, this.senkyoninMeibo, this.senkyoShikaku);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShohonBuilder#build()}を使用してください。
     *
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder createBuilderForEdit() {
        return new ShohonBuilder(entity, id, senkyo, senkyoninMeibo, senkyoShikaku);
    }
    // </editor-fold>

}
