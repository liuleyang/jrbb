/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.special;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.special.KijitsuzenTohyoShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 期日前投票の集計を行うDacクラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfFt500KijitsuzenTohyoShukeiFunctionDac {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号、選挙番号に該当する、期日前投票者数集計結果エンティティを取得します。
     *
     * @param psm PSM定義
     * @return 該当した期日前投票者数集計結果エンティティ
     */
    @Transaction
    public List<KijitsuzenTohyoShukeiEntity> select(IPsmCriteria psm) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        checkNull(psm);

        return accessor.
                select().
                table(psm).
                toList(KijitsuzenTohyoShukeiEntity.class);
    }

    private void checkNull(IPsmCriteria psm) {
        requireNonNull(psm, UrSystemErrorMessages.値がnull.getReplacedMessage("AfFt500KijitsuzenTohyoShukeiのpsm"));
    }

}
