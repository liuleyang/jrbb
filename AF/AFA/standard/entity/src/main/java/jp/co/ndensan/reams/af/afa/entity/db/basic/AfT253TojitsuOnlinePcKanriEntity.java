package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 当日投票の時、そのオンライン端末がどの投票区コードで利用されるのかを管理する。
1投票区で複数端末管理できるようにする。テーブルのエンティティクラスです。
 */
public class AfT253TojitsuOnlinePcKanriEntity extends DbTableEntityBase<AfT253TojitsuOnlinePcKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT253TojitsuOnlinePcKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code senkyoShurui;
    @PrimaryKey
    private RString tohyokuCode;
    @PrimaryKey
    private RString tanmatsuId;
    private RString biko;

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
     * コード種別：3620（選挙種類）のgetメソッドです。
     * 
     * @return コード種別：3620（選挙種類）
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * コード種別：3620（選挙種類）のsetメソッドです。
     * 
     * @param senkyoShurui コード種別：3620（選挙種類）
     */
    public void setSenkyoShurui(@Nonnull Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * tohyokuCodeのgetメソッドです。
     * 
     * @return tohyokuCode
     */
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * tohyokuCodeのsetメソッドです。
     * 
     * @param tohyokuCode tohyokuCode
     */
    public void setTohyokuCode(@Nonnull RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * tanmatsuIdのgetメソッドです。
     * 
     * @return tanmatsuId
     */
    public RString getTanmatsuId() {
        return tanmatsuId;
    }

    /**
     * tanmatsuIdのsetメソッドです。
     * 
     * @param tanmatsuId tanmatsuId
     */
    public void setTanmatsuId(@Nonnull RString tanmatsuId) {
        this.tanmatsuId = tanmatsuId;
    }

    /**
     * bikoのgetメソッドです。
     * 
     * @return biko
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * bikoのsetメソッドです。
     * 
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT253TojitsuOnlinePcKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT253TojitsuOnlinePcKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT253TojitsuOnlinePcKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.senkyoShurui, other.senkyoShurui)) {
            return false;
        }
        if (!Objects.equals(this.tohyokuCode, other.tohyokuCode)) {
            return false;
        }
        if (!Objects.equals(this.tanmatsuId, other.tanmatsuId)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT253TojitsuOnlinePcKanriEntity entity) {
        this.senkyoShurui = entity.senkyoShurui;
        this.tohyokuCode = entity.tohyokuCode;
        this.tanmatsuId = entity.tanmatsuId;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(senkyoShurui, tohyokuCode, tanmatsuId, biko);
    }

// </editor-fold>
}
