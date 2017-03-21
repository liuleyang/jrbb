package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * UzT0001StandardConfig
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class UzT0001StandardConfigEntity extends DbTableEntityBase<UzT0001StandardConfigEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;

    @PrimaryKey
    private RString schemaName;

    @PrimaryKey
    private SubGyomuCode subGyomuCode;

    @PrimaryKey
    private RString configName;
    private RString javaType;
    private boolean theyCanChange;
    private RString configValue;
    private RString configDesc;

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
     * insertReamsLoginIdのgetメソッドです。
     *
     * @return insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return insertReamsLoginId;
    }

    /**
     * insertTimestampのsetメソッドです。
     *
     * @param insertReamsLoginId RString
     */
    public void setInsertReamsLoginId(RString insertReamsLoginId) {
        this.insertReamsLoginId = insertReamsLoginId;
    }

    /**
     * insertTimestampのgetメソッドです。
     *
     * @return insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * insertTimestampのsetメソッドです。
     *
     * @param insertTimestamp RDateTime
     */
    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /**
     * insertContextIdのgetメソッドです。
     *
     * @return insertContextId
     */
    public UUID getInsertContextId() {
        return insertContextId;
    }

    /**
     * insertContextIdのsetメソッドです。
     *
     * @param insertContextId UUID
     */
    public void setInsertContextId(UUID insertContextId) {
        this.insertContextId = insertContextId;
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
     * updateCountのgetメソッドです。
     *
     * @return updateCount
     */
    public int getUpdateCount() {
        return updateCount;
    }

    /**
     * updateCountのsetメソッドです。
     *
     * @param updateCount int
     */
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * lastUpdateTimestampのgetメソッドです。
     *
     * @return lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * lastUpdateTimestampのsetメソッドです。
     *
     * @param lastUpdateTimestamp RDateTime
     */
    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    /**
     * lastUpdateReamsLoginIdのgetメソッドです。
     *
     * @return lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return lastUpdateReamsLoginId;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId RString
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * schemaNameのgetメソッドです。
     *
     * @return schemaName RString
     */
    public RString getSchemaName() {
        return this.schemaName;
    }

    /**
     * schemaNameのsetメソッドです。
     *
     * @param schemaName RString
     */
    public void setSchemaName(RString schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * subGyomuCodeのgetメソッドです。
     *
     * @return subGyomuCode SubGyomuCode
     */
    public SubGyomuCode getSubGyomuCode() {
        return this.subGyomuCode;
    }

    /**
     * subGyomuCodeのsetメソッドです。
     *
     * @param subGyomuCode SubGyomuCode
     */
    public void setSubGyomuCode(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * configNameのgetメソッドです。
     *
     * @return configName RString
     */
    public RString getConfigName() {
        return this.configName;
    }

    /**
     * configNameのsetメソッドです。
     *
     * @param configName RString
     */
    public void setConfigName(RString configName) {
        this.configName = configName;
    }

    /**
     * javaTypeのgetメソッドです。
     *
     * @return javaType RString
     */
    public RString getJavaType() {
        return this.javaType;
    }

    /**
     * javaTypeのsetメソッドです。
     *
     * @param javaType RString
     */
    public void setJavaType(RString javaType) {
        this.javaType = javaType;
    }

    /**
     * theyCanChangeのgetメソッドです。
     *
     * @return theyCanChange RString
     */
    public boolean getTheyCanChange() {
        return this.theyCanChange;
    }

    /**
     * theyCanChangeのsetメソッドです。
     *
     * @param theyCanChange RString
     */
    public void setTheyCanChange(boolean theyCanChange) {
        this.theyCanChange = theyCanChange;
    }

    /**
     * configValueのgetメソッドです。
     *
     * @return configValue RString
     */
    public RString getConfigValue() {
        return this.configValue;
    }

    /**
     * configValueのsetメソッドです。
     *
     * @param configValue RString
     */
    public void setConfigValue(RString configValue) {
        this.configValue = configValue;
    }

    /**
     * configDescのgetメソッドです。
     *
     * @return configDesc RString
     */
    public RString getConfigDesc() {
        return this.configDesc;
    }

    /**
     * configDescのsetメソッドです。
     *
     * @param configDesc RString
     */
    public void setConfigDesc(RString configDesc) {
        this.configDesc = configDesc;
    }

}
