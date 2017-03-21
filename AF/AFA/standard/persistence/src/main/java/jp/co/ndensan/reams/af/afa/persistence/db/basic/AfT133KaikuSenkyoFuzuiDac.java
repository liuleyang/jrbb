/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 海区付随情報テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT133KaikuSenkyoFuzuiDac
        implements IInsertOrUpdatable<AfT133KaikuSenkyoFuzuiEntity>,
        IDeletable<AfT133KaikuSenkyoFuzuiEntity>, IPhysicalDeletable<AfT133KaikuSenkyoFuzuiEntity>,
        ISaveable<AfT133KaikuSenkyoFuzuiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号、識別コードに該当する、海区付随情報エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @param shikibetsuCode 識別コード
     * @return 該当した海区付随情報エンティティ
     */
    @Transaction
    public AfT133KaikuSenkyoFuzuiEntity select(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT133KaikuSenkyoFuzui.class).
                where(and(eq(AfT133KaikuSenkyoFuzui.shohonNo, shohonNo),
                                eq(AfT133KaikuSenkyoFuzui.shikibetsuCode, shikibetsuCode))).
                toObject(AfT133KaikuSenkyoFuzuiEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、海区付随情報エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した海区付随情報エンティティリスト
     */
    @Transaction
    public List<AfT133KaikuSenkyoFuzuiEntity> select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT133KaikuSenkyoFuzui.class).
                where(eq(AfT133KaikuSenkyoFuzui.shohonNo, shohonNo)).
                order(by(AfT133KaikuSenkyoFuzui.shikibetsuCode)).
                toList(AfT133KaikuSenkyoFuzuiEntity.class);
    }

    /**
     * 海区付随情報エンティティリストを取得します。
     *
     * @return 該当した海区付随情報エンティティリスト
     */
    @Transaction
    public List<AfT133KaikuSenkyoFuzuiEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT133KaikuSenkyoFuzui.class).
                order(by(AfT133KaikuSenkyoFuzui.shohonNo), by(AfT133KaikuSenkyoFuzui.shikibetsuCode)).
                toList(AfT133KaikuSenkyoFuzuiEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT133KaikuSenkyoFuzuiEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT133KaikuSenkyoFuzuiEntity entity) {
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
    public int delete(List<AfT133KaikuSenkyoFuzuiEntity> entities) {
        int count = 0;
        for (AfT133KaikuSenkyoFuzuiEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT133KaikuSenkyoFuzuiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT133KaikuSenkyoFuzuiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT133KaikuSenkyoFuzuiEntity entity) {
        return (select(entity.getShohonNo(), entity.getShikibetsuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT133KaikuSenkyoFuzuiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * エンティティの複数件実削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(List<AfT133KaikuSenkyoFuzuiEntity> entities) {
        int count = 0;
        for (AfT133KaikuSenkyoFuzuiEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * エンティティを登録します。
     *
     * @param entity 対象のエンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT133KaikuSenkyoFuzuiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(" 海区付随情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
