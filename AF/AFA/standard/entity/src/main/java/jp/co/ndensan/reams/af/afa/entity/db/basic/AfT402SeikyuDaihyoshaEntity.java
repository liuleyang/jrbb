package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 直接請求の代表者情報を保持。（1請求に複数人可能）テーブルのエンティティクラスです。
 */
public class AfT402SeikyuDaihyoshaEntity extends DbTableEntityBase<AfT402SeikyuDaihyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT402SeikyuDaihyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int seikyuNo;
    @PrimaryKey
    private ShikibetsuCode seikyuShikibetsuCode;

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
     * 直接請求番号のgetメソッドです。
     * 
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return seikyuNo;
    }

    /**
     * 直接請求番号のsetメソッドです。
     * 
     * @param seikyuNo 直接請求番号
     */
    public void setSeikyuNo(@Nonnull int seikyuNo) {
        this.seikyuNo = seikyuNo;
    }

    /**
     * 請求代表者識別コードのgetメソッドです。
     * 
     * @return 請求代表者識別コード
     */
    public ShikibetsuCode getSeikyuShikibetsuCode() {
        return seikyuShikibetsuCode;
    }

    /**
     * 請求代表者識別コードのsetメソッドです。
     * 
     * @param seikyuShikibetsuCode 請求代表者識別コード
     */
    public void setSeikyuShikibetsuCode(@Nonnull ShikibetsuCode seikyuShikibetsuCode) {
        this.seikyuShikibetsuCode = seikyuShikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT402SeikyuDaihyoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT402SeikyuDaihyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT402SeikyuDaihyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (this.seikyuNo != other.seikyuNo) {
            return false;
        }
        if (!Objects.equals(this.seikyuShikibetsuCode, other.seikyuShikibetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT402SeikyuDaihyoshaEntity entity) {
        this.seikyuNo = entity.seikyuNo;
        this.seikyuShikibetsuCode = entity.seikyuShikibetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(seikyuNo, seikyuShikibetsuCode);
    }

// </editor-fold>

}
