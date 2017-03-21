package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 在外選挙資格の申請時に使用する。申請書提出の宛先となる。 「領事館」ではない。テーブルのエンティティクラスです。
 */
public class AfT510RyojikanEntity extends DbTableEntityBase<AfT510RyojikanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT510Ryojikan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString ryojikanCode;
    private RString ryojikanName;
    private RString kanaRyojikanName;
    private RString searchKanaRyojikanName;
    private int hyojijun;

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
     * 領事官コードのgetメソッドです。
     * 
     * @return 領事官コード
     */
    public RString getRyojikanCode() {
        return ryojikanCode;
    }

    /**
     * 領事官コードのsetメソッドです。
     * 
     * @param ryojikanCode 領事官コード
     */
    public void setRyojikanCode(@Nonnull RString ryojikanCode) {
        this.ryojikanCode = ryojikanCode;
    }

    /**
     * 領事官名称のgetメソッドです。
     * 
     * @return 領事官名称
     */
    @CheckForNull
    public RString getRyojikanName() {
        return ryojikanName;
    }

    /**
     * 領事官名称のsetメソッドです。
     * 
     * @param ryojikanName 領事官名称
     */
    public void setRyojikanName(RString ryojikanName) {
        this.ryojikanName = ryojikanName;
    }

    /**
     * カナ領事官名称のgetメソッドです。
     * 
     * @return カナ領事官名称
     */
    @CheckForNull
    public RString getKanaRyojikanName() {
        return kanaRyojikanName;
    }

    /**
     * カナ領事官名称のsetメソッドです。
     * 
     * @param kanaRyojikanName カナ領事官名称
     */
    public void setKanaRyojikanName(RString kanaRyojikanName) {
        this.kanaRyojikanName = kanaRyojikanName;
    }

    /**
     * 検索用カナ領事官名称のgetメソッドです。
     * 
     * @return 検索用カナ領事官名称
     */
    @CheckForNull
    public RString getSearchKanaRyojikanName() {
        return searchKanaRyojikanName;
    }

    /**
     * 検索用カナ領事官名称のsetメソッドです。
     * 
     * @param searchKanaRyojikanName 検索用カナ領事官名称
     */
    public void setSearchKanaRyojikanName(RString searchKanaRyojikanName) {
        this.searchKanaRyojikanName = searchKanaRyojikanName;
    }

    /**
     * 表示順のgetメソッドです。
     * 
     * @return 表示順
     */
    @CheckForNull
    public int getHyojijun() {
        return hyojijun;
    }

    /**
     * 表示順のsetメソッドです。
     * 
     * @param hyojijun 表示順
     */
    public void setHyojijun(int hyojijun) {
        this.hyojijun = hyojijun;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT510RyojikanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT510RyojikanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT510RyojikanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.ryojikanCode, other.ryojikanCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT510RyojikanEntity entity) {
        this.ryojikanCode = entity.ryojikanCode;
        this.ryojikanName = entity.ryojikanName;
        this.kanaRyojikanName = entity.kanaRyojikanName;
        this.searchKanaRyojikanName = entity.searchKanaRyojikanName;
        this.hyojijun = entity.hyojijun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(ryojikanCode, ryojikanName, kanaRyojikanName, searchKanaRyojikanName, hyojijun);
    }

// </editor-fold>

}
