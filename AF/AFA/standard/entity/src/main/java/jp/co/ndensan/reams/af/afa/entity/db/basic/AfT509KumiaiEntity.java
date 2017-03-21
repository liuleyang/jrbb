package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 農委、海区で使用する組合マスタを保持する。 使用しなくても可。テーブルのエンティティクラスです。
 */
public class AfT509KumiaiEntity extends DbTableEntityBase<AfT509KumiaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT509Kumiai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString kumiaiCode;
    private RString kumiaiName;
    private RString kanaKumiaiName;
    private RString searchKumiaiName;
    private AtenaJusho jusho;

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
     * 組合コードのgetメソッドです。
     * 
     * @return 組合コード
     */
    public RString getKumiaiCode() {
        return kumiaiCode;
    }

    /**
     * 組合コードのsetメソッドです。
     * 
     * @param kumiaiCode 組合コード
     */
    public void setKumiaiCode(@Nonnull RString kumiaiCode) {
        this.kumiaiCode = kumiaiCode;
    }

    /**
     * 組合名称のgetメソッドです。
     * 
     * @return 組合名称
     */
    @CheckForNull
    public RString getKumiaiName() {
        return kumiaiName;
    }

    /**
     * 組合名称のsetメソッドです。
     * 
     * @param kumiaiName 組合名称
     */
    public void setKumiaiName(RString kumiaiName) {
        this.kumiaiName = kumiaiName;
    }

    /**
     * カナ組合名称のgetメソッドです。
     * 
     * @return カナ組合名称
     */
    @CheckForNull
    public RString getKanaKumiaiName() {
        return kanaKumiaiName;
    }

    /**
     * カナ組合名称のsetメソッドです。
     * 
     * @param kanaKumiaiName カナ組合名称
     */
    public void setKanaKumiaiName(RString kanaKumiaiName) {
        this.kanaKumiaiName = kanaKumiaiName;
    }

    /**
     * 検索用カナ組合名称のgetメソッドです。
     * 
     * @return 検索用カナ組合名称
     */
    @CheckForNull
    public RString getSearchKumiaiName() {
        return searchKumiaiName;
    }

    /**
     * 検索用カナ組合名称のsetメソッドです。
     * 
     * @param searchKumiaiName 検索用カナ組合名称
     */
    public void setSearchKumiaiName(RString searchKumiaiName) {
        this.searchKumiaiName = searchKumiaiName;
    }

    /**
     * 組合の住所等のgetメソッドです。
     * 
     * @return 組合の住所等
     */
    @CheckForNull
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 組合の住所等のsetメソッドです。
     * 
     * @param jusho 組合の住所等
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT509KumiaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT509KumiaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT509KumiaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kumiaiCode, other.kumiaiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT509KumiaiEntity entity) {
        this.kumiaiCode = entity.kumiaiCode;
        this.kumiaiName = entity.kumiaiName;
        this.kanaKumiaiName = entity.kanaKumiaiName;
        this.searchKumiaiName = entity.searchKumiaiName;
        this.jusho = entity.jusho;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kumiaiCode, kumiaiName, kanaKumiaiName, searchKumiaiName, jusho);
    }

// </editor-fold>

}
