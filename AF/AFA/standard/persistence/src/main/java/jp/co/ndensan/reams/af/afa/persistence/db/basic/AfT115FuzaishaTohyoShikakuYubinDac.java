/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAppendType;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 郵便投票資格付随情報のデータアクセスクラスです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class AfT115FuzaishaTohyoShikakuYubinDac implements ISaveable<AfT115FuzaishaTohyoShikakuYubinEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで郵便投票資格付随情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 Seq
     * @return AfT115FuzaishaTohyoShikakuYubinEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT115FuzaishaTohyoShikakuYubinEntity selectByKey(
            ShikibetsuCode 識別コード,
            BigSerial 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT115FuzaishaTohyoShikakuYubin.class).
                where(and(
                                eq(AfT115FuzaishaTohyoShikakuYubin.shikibetsuCode, 識別コード),
                                eq(AfT115FuzaishaTohyoShikakuYubin.seq, 履歴番号))).
                toObject(AfT115FuzaishaTohyoShikakuYubinEntity.class);
    }

    /**
     * 郵便投票資格付随情報を全件返します。
     *
     * @return AfT115FuzaishaTohyoShikakuYubinEntityの{@code list}
     */
    @Transaction
    public List<AfT115FuzaishaTohyoShikakuYubinEntity> selectAll() {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT115FuzaishaTohyoShikakuYubin.class).
                toList(AfT115FuzaishaTohyoShikakuYubinEntity.class);
    }

    /**
     * AfT115FuzaishaTohyoShikakuYubinEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT115FuzaishaTohyoShikakuYubinEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便投票資格付随情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorForAppendType(session), entity);
    }

    /**
     * AfT115FuzaishaTohyoShikakuYubinEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save郵便投票資格(AfT115FuzaishaTohyoShikakuYubinEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便投票資格付随情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
