package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * AfT147Chiku3Conditionテーブルのエンティティクラスです。
 */
public class AfT147Chiku3ConditionEntity extends DbTableEntityBase<AfT147Chiku3ConditionEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT147Chiku3Condition");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShohonNo shohonNo;
    @PrimaryKey
    private ChikuCode chikuCode3;

    /**
     * insertDantaiCdのgetメソッドです。
     * 
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     * 
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     * 
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     * 
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 抄本番号のgetメソッドです。
     * 
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 抄本番号のsetメソッドです。
     * 
     * @param shohonNo 抄本番号
     */
    public void setShohonNo(@Nonnull ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * chikuCode3のgetメソッドです。
     * 
     * @return chikuCode3
     */
    public ChikuCode getChikuCode3() {
        return chikuCode3;
    }

    /**
     * chikuCode3のsetメソッドです。
     * 
     * @param chikuCode3 chikuCode3
     */
    public void setChikuCode3(@Nonnull ChikuCode chikuCode3) {
        this.chikuCode3 = chikuCode3;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT147Chiku3ConditionEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT147Chiku3ConditionEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT147Chiku3ConditionEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.chikuCode3, other.chikuCode3)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT147Chiku3ConditionEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.chikuCode3 = entity.chikuCode3;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, chikuCode3);
    }

// </editor-fold>

}
