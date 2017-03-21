package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * UzT0001StandardConfig
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class UzT0002CustomConfigEntity implements IDbAccessable {

    private RString insertDantaiCd;

    @PrimaryKey
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

    @PrimaryKey
    private LasdecCode lasdecCode;

    @PrimaryKey
    private RString optionKeyword;

    @PrimaryKey
    private RDate effectiveDate;
    private RString configValue;
    private RString changeLog;
    private BigSerial seq;

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
     * schemaNamepのgetメソッドです。
     *
     * @return schemaName
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
     * @return subGyomuCode
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
     * @return configName
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
     * lasdecCodeのgetメソッドです。
     *
     * @return lasdecCode
     */
    public LasdecCode getLasdecCode() {
        return this.lasdecCode;
    }

    /**
     * lasdecCodeのsetメソッドです。
     *
     * @param lasdecCode LasdecCode
     */
    public void setLasdecCode(LasdecCode lasdecCode) {
        this.lasdecCode = lasdecCode;
    }

    /**
     * optionKeywordのgetメソッドです。
     *
     * @return optionKeyword
     */
    public RString getOptionKeyword() {
        return this.optionKeyword;
    }

    /**
     * optionKeywordのsetメソッドです。
     *
     * @param optionKeyword RString
     */
    public void setOptionKeyword(RString optionKeyword) {
        this.optionKeyword = optionKeyword;
    }

    /**
     * effectiveDateのgetメソッドです。
     *
     * @return effectiveDate
     */
    public RDate getEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * effectiveDateのsetメソッドです。
     *
     * @param effectiveDate RDate
     */
    public void setEffectiveDate(RDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * configValueのgetメソッドです。
     *
     * @return configValue
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
     * changeLogのgetメソッドです。
     *
     * @return changeLog
     */
    public RString getChangeLog() {
        return this.changeLog;
    }

    /**
     * changeLogのsetメソッドです。
     *
     * @param changeLog RString
     */
    public void setChangeLog(RString changeLog) {
        this.changeLog = changeLog;
    }

    /**
     * seqのgetメソッドです。
     *
     * @return seq
     */
    public BigSerial getSeq() {
        return this.seq;
    }

    /**
     * seqのsetメソッドです。
     *
     * @param seq BigSerial
     */
    public void setSeq(BigSerial seq) {
        this.seq = seq;
    }

}
