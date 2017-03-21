package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UDT022CodeTable;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * UzT0007CodeEntity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class UzT0007CodeEntity extends UDT022CodeTable<UzT0007CodeEntity>
        implements IDbAccessable {

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

    @PrimaryKey
    private Code code;

    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private RString codeMeisho;
    private RString codeRyakusho;
    private boolean canUpdate;
    private int hyojiJun;
    private RString option1;
    private RString option2;
    private RString option3;

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
    @Override
    public SubGyomuCode getサブ業務コード() {
        return this.subGyomuCode;
    }

    /**
     * codeShubetsuのgetメソッドです。
     *
     * @return codeShubetsu
     */
    @Override
    public CodeShubetsu getコード種別() {
        return this.codeShubetsu;
    }

    /**
     * codeのgetメソッドです。
     *
     * @return code
     */
    @Override
    public Code getコード() {
        return this.code;
    }

    /**
     * yukoKaishiYMDのgetメソッドです。
     *
     * @return yukoKaishiYMD
     */
    @Override
    public FlexibleDate get有効開始年月日() {
        return this.yukoKaishiYMD;
    }

    /**
     * yukoShuryoYMDのgetメソッドです。
     *
     * @return yukoShuryoYMD
     */
    @Override
    public FlexibleDate get有効終了年月日() {
        return this.yukoShuryoYMD;
    }

    /**
     * codeMeishoのgetメソッドです。
     *
     * @return codeMeisho
     */
    @Override
    public RString getコード名称() {
        return this.codeMeisho;
    }

    /**
     * codeRyakushoのgetメソッドです。
     *
     * @return codeRyakusho
     */
    @Override
    public RString getコード略称() {
        return this.codeRyakusho;
    }

    /**
     * option1のgetメソッドです。
     *
     * @return option1
     */
    public RString getオプション１() {
        return this.option1;
    }

    /**
     * option2のgetメソッドです。
     *
     * @return option2
     */
    public RString getオプション２() {
        return this.option2;
    }

    /**
     * option3のgetメソッドです。
     *
     * @return option3
     */
    public RString getオプション３() {
        return this.option3;
    }

    /**
     * canUpdateのgetメソッドです。
     *
     * @return canUpdate
     */
    @Override
    public boolean get更新可否区分() {
        return this.canUpdate;
    }

    @Override
    public int get表示順() {
        return this.hyojiJun;
    }

    /**
     * subGyomuCodeのsetメソッドです。
     *
     * @param subGyomuCode RString
     */
    @Override
    public void setサブ業務コード(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * codeShubetsuのsetメソッドです。
     *
     * @param codeShubetsu CodeShubetsu
     */
    @Override
    public void setコード種別(CodeShubetsu codeShubetsu) {
        this.codeShubetsu = codeShubetsu;
    }

    /**
     * codeのsetメソッドです。
     *
     * @param code Code
     */
    @Override
    public void setコード(Code code) {
        this.code = code;
    }

    /**
     * yukoKaishiYMDのsetメソッドです。
     *
     * @param yukoKaishiYMD FlexibleDate
     */
    @Override
    public void set有効開始年月日(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * yukoShuryoYMDのsetメソッドです。
     *
     * @param yukoShuryoYMD FlexibleDate
     */
    @Override
    public void set有効終了年月日(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * codeMeishoのsetメソッドです。
     *
     * @param codeMeisho RString
     */
    @Override
    public void setコード名称(RString codeMeisho) {
        this.codeMeisho = codeMeisho;
    }

    /**
     * codeRyakushoのsetメソッドです。
     *
     * @param codeRyakusho RString
     */
    @Override
    public void setコード略称(RString codeRyakusho) {
        this.codeRyakusho = codeRyakusho;
    }

    /**
     * option1のsetメソッドです。
     *
     * @param option1 RString
     */
    public void setオプション１(RString option1) {
        this.option1 = option1;
    }

    /**
     * option2のsetメソッドです。
     *
     * @param option2 RString
     */
    public void setオプション２(RString option2) {
        this.option2 = option2;
    }

    /**
     * option3のsetメソッドです。
     *
     * @param option3 RString
     */
    public void setオプション３(RString option3) {
        this.option3 = option3;
    }

    /**
     * hyojiJunのsetメソッドです。
     *
     * @param hyojiJun RString
     */
    @Override
    public void set表示順(int hyojiJun) {
        this.hyojiJun = hyojiJun;
    }

}
