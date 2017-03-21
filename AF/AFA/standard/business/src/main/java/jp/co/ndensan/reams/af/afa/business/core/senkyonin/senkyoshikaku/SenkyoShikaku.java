    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuIdentifier;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoshikaku.SenkyoShikakuEntity;
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
 * 選挙資格を管理するクラスです。
 */
public class SenkyoShikaku extends ModelBase<SenkyoShikakuIdentifier, AfT113SenkyoShikakuEntity, SenkyoShikaku> implements Serializable {

    private final AfT113SenkyoShikakuEntity entity;
    private final SenkyoShikakuIdentifier id;
    private final Models<FuzaishaTohyoShikakuIdentifier, FuzaishaTohyoShikaku> fuzaishaTohyoShikaku;

    /**
     * コンストラクタです。<br/>
     * 選挙資格の新規作成時に使用します。
     *
     * @param 選挙種類 選挙種類
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public SenkyoShikaku(Code 選挙種類,
            ShikibetsuCode 識別コード,
            BigSerial 履歴番号) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new AfT113SenkyoShikakuEntity();
        this.entity.setSenkyoShurui(選挙種類);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setSeq(履歴番号);
        this.id = new SenkyoShikakuIdentifier(選挙種類, 識別コード, 履歴番号);
        this.fuzaishaTohyoShikaku = Models.create(new ArrayList<FuzaishaTohyoShikaku>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT113SenkyoShikakuEntity}より{@link SenkyoShikaku}を生成します。
     *
     * @param entity DBより取得した{@link AfT113SenkyoShikakuEntity}
     */
    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    public SenkyoShikaku(SenkyoShikakuEntity entity) {
        this.entity = requireNonNull(entity.get選挙資格Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格"));
        this.id = new SenkyoShikakuIdentifier(
                entity.get選挙資格Entity().getSenkyoShurui(),
                entity.get選挙資格Entity().getShikibetsuCode(),
                entity.get選挙資格Entity().getSeq());
        List<FuzaishaTohyoShikaku> fuzaishaTohyoShikakuList = new ArrayList<>();
        for (FuzaishaTohyoShikakuEntity fuzaishaTohyoShikakuEntity : entity.get不在者投票資格Entity()) {
            fuzaishaTohyoShikakuList.add(new FuzaishaTohyoShikaku(fuzaishaTohyoShikakuEntity));
        }
        this.fuzaishaTohyoShikaku = Models.create(fuzaishaTohyoShikakuList);
    }

    /**
     * コンストラクタです。<br/>
     *
     *
     * @param entity DBより取得した{@link AfT113SenkyoShikakuEntity}
     */
    public SenkyoShikaku(AfT113SenkyoShikakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格"));
        this.id = new SenkyoShikakuIdentifier(
                entity.getSenkyoShurui(),
                entity.getShikibetsuCode(),
                entity.getSeq());
        this.fuzaishaTohyoShikaku = null;

    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT113SenkyoShikakuEntity}
     * @param id {@link SenkyoShikakuIdentifier}
     */
    SenkyoShikaku(
            AfT113SenkyoShikakuEntity entity,
            SenkyoShikakuIdentifier id,
            Models<FuzaishaTohyoShikakuIdentifier, FuzaishaTohyoShikaku> fuzaishaTohyoShikaku
    ) {
        this.entity = entity;
        this.id = id;
        this.fuzaishaTohyoShikaku = fuzaishaTohyoShikaku;
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return entity.getShikakuKubun();
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
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード
     */
    public Code get登録事由コード() {
        return entity.getTorokuJiyuCode();
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 登録停止年月日
     */
    public FlexibleDate get登録停止年月日() {
        return entity.getTorokuTeishiYMD();
    }

    /**
     * 登録停止事由コードを返します。
     *
     * @return 登録停止事由コード
     */
    public Code get登録停止事由コード() {
        return entity.getTorokuTeishiJiyuCode();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public FlexibleDate get表示年月日() {
        return entity.getHyojiYMD();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード
     */
    public Code get表示事由コード() {
        return entity.getHyojiJiyuCode();
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日
     */
    public FlexibleDate get表示消除年月日() {
        return entity.getHyojiShojoYMD();
    }

    /**
     * 表示消除予定年月日を返します。
     *
     * @return 表示消除予定年月日
     */
    public FlexibleDate get表示消除予定年月日() {
        return entity.getHyojiShojoYoteiYMD();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public FlexibleDate get抹消年月日() {
        return entity.getMasshoYMD();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード
     */
    public Code get抹消事由コード() {
        return entity.getMasshoJiyuCode();
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 刑期終了年月日
     */
    public FlexibleDate get刑期終了年月日() {
        return entity.getKeikiShuryoYMD();
    }

    /**
     * 2刑持ちフラグを返します。
     *
     * @return 2刑持ちフラグ
     */
    public boolean is2刑持ち() {
        return entity.getNikeimochiFlag();
    }

    /**
     * {@link AfT113SenkyoShikakuEntity}のクローンを返します。
     *
     * @return {@link AfT113SenkyoShikakuEntity}のクローン
     */
    @Override
    public AfT113SenkyoShikakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 選挙資格の識別子{@link SenkyoShikakuIdentifier}を返します。
     *
     * @return 選挙資格の識別子{@link SenkyoShikakuIdentifier}
     */
    @Override
    public SenkyoShikakuIdentifier identifier() {
        return this.id;
    }

    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * 選挙資格配下の要素を削除対象とします。<br/> {@link AfT113SenkyoShikakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 選挙資格配下の要素である不在者投票資格の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link SenkyoShikaku}を返します。
     *
     * @return 削除対象処理実施後の{@link SenkyoShikaku}
     * @throws IllegalStateException AfT113SenkyoShikakuEntityのデータ状態が変更の場合
     */
    @Override
    public SenkyoShikaku deleted() {
        AfT113SenkyoShikakuEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SenkyoShikaku(
                deletedEntity, id, fuzaishaTohyoShikaku.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || fuzaishaTohyoShikaku.hasAnyChanged();
    }

    /**
     * 選挙資格のみを変更対象とします。<br/> {@link AfT113SenkyoShikakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SenkyoShikaku}
     */
    public SenkyoShikaku modifiedModel() {
        AfT113SenkyoShikakuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SenkyoShikaku(
                modifiedEntity, id, fuzaishaTohyoShikaku);
    }

    /**
     * 選挙資格が保持する不在者投票資格に対して、指定の識別子に該当する不在者投票資格を返します。
     *
     * @param id 不在者投票資格の識別子
     * @return 不在者投票資格
     * @throws IllegalStateException 指定の識別子に該当する不在者投票資格がない場合
     */
    public FuzaishaTohyoShikaku getFuzaishaTohyoShikaku(FuzaishaTohyoShikakuIdentifier id) {
        if (fuzaishaTohyoShikaku.contains(id)) {
            return fuzaishaTohyoShikaku.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 選挙資格が保持する不在者投票資格をリストで返します。
     *
     * @return 不在者投票資格リスト
     */
    public List<FuzaishaTohyoShikaku> getFuzaishaTohyoShikakuiList() {
        return new ArrayList<>(fuzaishaTohyoShikaku.values());

    }

//    /**
//     * {@link SenkyoShikaku}のシリアライズ形式を提供します。
//     *
//     * @return {@link SenkyoShikaku}のシリアライズ形式
//     */
//    protected Object writeReplace() {
//        return new _SerializationProxy(entity, id, fuzaishaTohyoShikaku);
//    }
//
//    private static final class _SerializationProxy implements Serializable {
//
//        private static final long serialVersionUID = -710031961519711799L;
//        private final AfT113SenkyoShikakuEntity entity;
//        private final SenkyoShikakuIdentifier id;
//        private final Models<FuzaishaTohyoShikakuIdentifier, FuzaishaTohyoShikaku> fuzaishaTohyoShikaku;
//
//        private _SerializationProxy(
//                AfT113SenkyoShikakuEntity entity,
//                SenkyoShikakuIdentifier id,
//                Models<FuzaishaTohyoShikakuIdentifier, FuzaishaTohyoShikaku> fuzaishaTohyoShikaku) {
//            this.entity = entity;
//            this.id = id;
//            this.fuzaishaTohyoShikaku = fuzaishaTohyoShikaku;
//        }
//
//    }
    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SenkyoShikakuBuilder#build()}を使用してください。
     *
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder createBuilderForEdit() {
        return new SenkyoShikakuBuilder(entity, id, fuzaishaTohyoShikaku);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    /**
     * 保持する選挙資格を削除対象とします。<br/> {@link AfT113SenkyoShikakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SenkyoShikaku}
     * @throws IllegalStateException AfT113SenkyoShikakuEntityのデータ状態が変更の場合
     */

    public SenkyoShikaku deleted2() {
        AfT113SenkyoShikakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SenkyoShikaku(deletedEntity, id, null);
    }

//    /**
//     * {@link SenkyoShikaku}のシリアライズ形式を提供します。
//     *
//     * @return {@link SenkyoShikaku}のシリアライズ形式
//     */
//    protected Object writeReplace2() {
//        return new _SerializationProxy(entity, id, null);
//
//    }
//    /**
//     * このクラスの編集を行うBuilderを取得します。<br/>
//     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
//     *
//     * @return Builder
//     */
//    public SenkyoShikakuBuilder createBuilderForEdit2() {
//        return new SenkyoShikakuBuilder(entity, id, null);
//    }
}
