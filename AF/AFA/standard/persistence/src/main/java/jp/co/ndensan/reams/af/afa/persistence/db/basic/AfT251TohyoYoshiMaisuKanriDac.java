/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanri;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507Shisetsu;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票用紙枚数管理テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @reamsid_L AF-0280-036 lit
 */
public class AfT251TohyoYoshiMaisuKanriDac implements IInsertOrUpdatable<AfT251TohyoYoshiMaisuKanriEntity>,
        IDeletable<AfT251TohyoYoshiMaisuKanriEntity>, IPhysicalDeletable<AfT251TohyoYoshiMaisuKanriEntity>,
        ISaveable<AfT251TohyoYoshiMaisuKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号、選挙番号、投票区コードに該当する、投票用紙枚数管理エンティティを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @param 投票区コード RString
     * @return 該当した投票用紙枚数管理エンティティ
     */
    @Transaction
    public AfT251TohyoYoshiMaisuKanriEntity select(ShohonNo 抄本番号, SenkyoNo 選挙番号, RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT251TohyoYoshiMaisuKanri.class).
                where(and(
                                eq(AfT251TohyoYoshiMaisuKanri.shohonNo, 抄本番号),
                                eq(AfT251TohyoYoshiMaisuKanri.senkyoNo, 選挙番号),
                                eq(AfT251TohyoYoshiMaisuKanri.tohyokuCode, 投票区コード))
                ).
                toObject(AfT251TohyoYoshiMaisuKanriEntity.class);
    }

    /**
     * すべての投票用紙枚数管理エンティティリストを取得します。
     *
     * @return 該当した投票用紙枚数管理エンティティリスト
     */
    @Transaction
    public List<AfT251TohyoYoshiMaisuKanriEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT251TohyoYoshiMaisuKanri.class).
                toList(AfT251TohyoYoshiMaisuKanriEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT251TohyoYoshiMaisuKanriEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT251TohyoYoshiMaisuKanriEntity> entities) {
        int count = 0;
        for (AfT251TohyoYoshiMaisuKanriEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT251TohyoYoshiMaisuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    /**
     * エンティティの複数件削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int delete(List<AfT251TohyoYoshiMaisuKanriEntity> entities) {
        int count = 0;
        for (AfT251TohyoYoshiMaisuKanriEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT251TohyoYoshiMaisuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT251TohyoYoshiMaisuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT251TohyoYoshiMaisuKanriEntity entity) {
        return (select(entity.getShohonNo(), entity.getSenkyoNo(), entity.getTohyokuCode()) != null);
    }

    /**
     * 引数の投票用紙枚数管理コードがマスタに存在するか判定します。
     *
     * @param shisetsuCode 投票用紙枚数管理コード
     * @return 存在する場合はtrueを返します。
     */
    @Transaction
    public boolean exists(RString shisetsuCode) {
        return getMatchRowCount(shisetsuCode) != 0;
    }

    private int getMatchRowCount(RString shisetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT507Shisetsu.class).
                where(eq(AfT507Shisetsu.shisetsuCode, shisetsuCode)).
                getCount();
    }

    @Override
    @Transaction
    public int deletePhysical(AfT251TohyoYoshiMaisuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * エンティティの複数件の実削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(List<AfT251TohyoYoshiMaisuKanriEntity> entities) {
        int count = 0;
        for (AfT251TohyoYoshiMaisuKanriEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT251TohyoYoshiMaisuKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT251TohyoYoshiMaisuKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票用紙枚数管理エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
