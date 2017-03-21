/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanri;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙区端末管理のデータアクセスクラスです。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class AfT505SenkyokuTanmatsuKanriDac implements ISaveable<AfT505SenkyokuTanmatsuKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで選挙区端末管理を取得します。
     *
     * @param 選挙種類 Code
     * @param 選挙区コード RString
     * @param 端末ID RString
     * @return AfT505SenkyokuTanmatsuKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT505SenkyokuTanmatsuKanriEntity selectByKey(
            Code 選挙種類,
            RString 選挙区コード,
            RString 端末ID) throws NullPointerException {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(選挙区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区コード"));
        requireNonNull(端末ID, UrSystemErrorMessages.値がnull.getReplacedMessage("端末ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT505SenkyokuTanmatsuKanri.class).
                where(and(
                                eq(AfT505SenkyokuTanmatsuKanri.senkyoShurui, 選挙種類),
                                eq(AfT505SenkyokuTanmatsuKanri.senkyokuCode, 選挙区コード),
                                eq(AfT505SenkyokuTanmatsuKanri.tanmatsuID, 端末ID))).
                toObject(AfT505SenkyokuTanmatsuKanriEntity.class);
    }

    /**
     * 主キーで選挙区端末管理を取得します。
     *
     * @param 選挙種類 Code
     * @param 選挙区コード RString
     * @param 端末ID RString
     * @return AfT505SenkyokuTanmatsuKanriEntityの{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT505SenkyokuTanmatsuKanriEntity> selectByKey(
            Code 選挙種類,
            RString 選挙区コード,
            List<RString> 端末ID) throws NullPointerException {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(選挙区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区コード"));
        requireNonNull(端末ID, UrSystemErrorMessages.値がnull.getReplacedMessage("端末ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT505SenkyokuTanmatsuKanri.class).
                where(and(
                                eq(AfT505SenkyokuTanmatsuKanri.senkyoShurui, 選挙種類),
                                eq(AfT505SenkyokuTanmatsuKanri.senkyokuCode, 選挙区コード),
                                in(AfT505SenkyokuTanmatsuKanri.tanmatsuID, 端末ID))).
                toList(AfT505SenkyokuTanmatsuKanriEntity.class);
    }

    /**
     * 主キーで選挙区端末管理を取得します。
     *
     * @param 選挙種類 Code
     * @param 選挙区コード RString
     * @return AfT505SenkyokuTanmatsuKanriEntityの{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT505SenkyokuTanmatsuKanriEntity> selectBySenkyoShuruiAndSenkyoCode(
            Code 選挙種類,
            RString 選挙区コード) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT505SenkyokuTanmatsuKanri.class).
                where(and(
                                eq(AfT505SenkyokuTanmatsuKanri.senkyoShurui, 選挙種類),
                                eq(AfT505SenkyokuTanmatsuKanri.senkyokuCode, 選挙区コード))).
                toList(AfT505SenkyokuTanmatsuKanriEntity.class);
    }

    /**
     * 主キーで選挙区端末管理を取得します。
     *
     * @param 選挙種類 Code
     * @return count
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int countBy選挙種類(
            Code 選挙種類) throws NullPointerException {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT505SenkyokuTanmatsuKanri.class).
                where(
                        eq(AfT505SenkyokuTanmatsuKanri.senkyoShurui, 選挙種類)).getCount();
    }

    /**
     * 選挙区端末管理を全件返します。
     *
     * @return AfT505SenkyokuTanmatsuKanriEntityの{@code list}
     */
    @Transaction
    public List<AfT505SenkyokuTanmatsuKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT505SenkyokuTanmatsuKanri.class).
                toList(AfT505SenkyokuTanmatsuKanriEntity.class);
    }

    /**
     * AfT505SenkyokuTanmatsuKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT505SenkyokuTanmatsuKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区端末管理エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定選挙番号、選挙番号AfT505SenkyokuTanmatsuKanriEntityを削除します。
     *
     * @param entity AfT505SenkyokuTanmatsuKanriEntity
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(AfT505SenkyokuTanmatsuKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区端末管理エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

}
