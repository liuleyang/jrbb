package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UDT021CodeShubetsuTable;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * UzT0006CodeShubetsuEntity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class UzT0006CodeShubetsuEntity extends UDT021CodeShubetsuTable
        implements IDbAccessable {
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
    private CodeShubetsu codeShubetsu;
    private RString codeShubetsuMeisho;
    private int yukoKetasu;
    private boolean canAdd;
    private RString setsumei;
    private RString option1Meisho;
    private RString option2Meisho;
    private RString option3Meisho;

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
     * codeShubetsuのgetメソッドです。
     *
     * @return codeShubetsu
     */
    public CodeShubetsu getCodeShubetsu() {
        return this.codeShubetsu;
    }

    /**
     * codeShubetsuMeishoのgetメソッドです。
     *
     * @return codeShubetsuMeisho
     */
    public RString getCodeShubetsuMeisho() {
        return this.codeShubetsuMeisho;
    }

    /**
     * canAddのgetメソッドです。
     *
     * @return canAdd
     */
    public boolean isCanAdd() {
        return this.canAdd;
    }

    /**
     * setsumeiのgetメソッドです。
     *
     * @return setsumei
     */
    public RString getSetsumei() {
        return this.setsumei;
    }

    /**
     * yukoKetasuのgetメソッドです。
     *
     * @return yukoKetasu
     */
    public int getYukoKetasu() {
        return this.yukoKetasu;
    }

    /**
     * option1Meishoのgetメソッドです。
     *
     * @return option1Meisho
     */
    public RString getOption1Meisho() {
        return this.option1Meisho;
    }

    /**
     * option2Meishoのgetメソッドです。
     *
     * @return option2Meisho
     */
    public RString getOption2Meisho() {
        return this.option2Meisho;
    }

    /**
     * option3Meishoのgetメソッドです。
     *
     * @return option3Meisho
     */
    public RString getOption3Meisho() {
        return this.option3Meisho;
    }

    /**
     * subGyomuCodeのsetメソッドです。
     *
     * @param subGyomuCode RString
     */
    @Override
    public void setGyomuCode(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * codeShubetsuのsetメソッドです。
     *
     * @param codeShubetsu RString
     */
    @Override
    public void setCodeShubetsu(CodeShubetsu codeShubetsu) {
        this.codeShubetsu = codeShubetsu;
    }

    /**
     * codeShubetsuMeishoのsetメソッドです。
     *
     * @param codeShubetsuMeisho RString
     */
    @Override
    public void setCodeShubetsuMeisho(RString codeShubetsuMeisho) {
        this.codeShubetsuMeisho = codeShubetsuMeisho;
    }

    /**
     * canAddのsetメソッドです。
     *
     * @param canAdd RString
     */
    @Override
    public void setCanAdd(boolean canAdd) {
        this.canAdd = canAdd;
    }

    /**
     * setsumeiのsetメソッドです。
     *
     * @param setsumei RString
     */
    @Override
    public void setSetsumei(RString setsumei) {
        this.setsumei = setsumei;
    }

    /**
     * yukoKetasuのsetメソッドです。
     *
     * @param yukoKetasu RString
     */
    @Override
    public void setYukoKetasu(int yukoKetasu) {
        this.yukoKetasu = yukoKetasu;
    }

    /**
     * option1Meishoのsetメソッドです。
     *
     * @param option1Meisho RString
     */
    public void setOption1Meisho(RString option1Meisho) {
        this.option1Meisho = option1Meisho;
    }

    /**
     * option2Meishoのsetメソッドです。
     *
     * @param option2Meisho RString
     */
    public void setOption2Meisho(RString option2Meisho) {
        this.option2Meisho = option2Meisho;
    }

    /**
     * option3Meishoのsetメソッドです。
     *
     * @param option3Meisho RString
     */
    public void setOption3Meisho(RString option3Meisho) {
        this.option3Meisho = option3Meisho;
    }

}
