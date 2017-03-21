package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * AfT143GyoseikuConditionテーブルのエンティティクラスです。
 */
public class AfT143GyoseikuConditionEntity extends DbTableEntityBase<AfT143GyoseikuConditionEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT143GyoseikuCondition");

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
    private GyoseikuCode gyoseikuCode;

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
     * 行政区コードのgetメソッドです。
     * 
     * @return 行政区コード
     */
    public GyoseikuCode getGyoseikuCode() {
        return gyoseikuCode;
    }

    /**
     * 行政区コードのsetメソッドです。
     * 
     * @param gyoseikuCode 行政区コード
     */
    public void setGyoseikuCode(@Nonnull GyoseikuCode gyoseikuCode) {
        this.gyoseikuCode = gyoseikuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT143GyoseikuConditionEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT143GyoseikuConditionEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT143GyoseikuConditionEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.gyoseikuCode, other.gyoseikuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT143GyoseikuConditionEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.gyoseikuCode = entity.gyoseikuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, gyoseikuCode);
    }

// </editor-fold>


}
