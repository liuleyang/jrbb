package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;

/**
 * 当日投票受付の持ち出し端末のデータ状態を保持する。テーブルのエンティティクラスです。
 */
public class AfT252MochidashiPcJotaiKanriEntity extends DbTableEntityBase<AfT252MochidashiPcJotaiKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT252MochidashiPcJotaiKanri");

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
    private RString tohyokuCode;
    private Code dataCreateKubun;
    private YMDHMS dataCreateYMD;
    private Code systemSendKubun;
    private YMDHMS systemSendYMD;
    private Code dataSendKubun;
    private YMDHMS dataSendYMD;
    private Code dataImportKubun;
    private YMDHMS dataImportYMD;

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
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * 投票区コードのsetメソッドです。
     *
     * @param tohyokuCode 投票区コード
     */
    public void setTohyokuCode(@Nonnull RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * データ作成区分のgetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、1：作成済）
     *
     * @return データ作成区分
     */
    @CheckForNull
    public Code getDataCreateKubun() {
        return dataCreateKubun;
    }

    /**
     * データ作成区分のsetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、1：作成済）
     *
     * @param dataCreateKubun データ作成区分
     */
    public void setDataCreateKubun(Code dataCreateKubun) {
        this.dataCreateKubun = dataCreateKubun;
    }

    /**
     * データ作成日時のgetメソッドです。
     *
     * @return データ作成日時
     */
    @CheckForNull
    public YMDHMS getDataCreateYMD() {
        return dataCreateYMD;
    }

    /**
     * データ作成日時のsetメソッドです。
     *
     * @param dataCreateYMD データ作成日時
     */
    public void setDataCreateYMD(YMDHMS dataCreateYMD) {
        this.dataCreateYMD = dataCreateYMD;
    }

    /**
     * AP受渡区分のgetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、2：受渡済）
     *
     * @return AP受渡区分
     */
    @CheckForNull
    public Code getSystemSendKubun() {
        return systemSendKubun;
    }

    /**
     * AP受渡区分のsetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、2：受渡済）
     *
     * @param systemSendKubun AP受渡区分
     */
    public void setSystemSendKubun(Code systemSendKubun) {
        this.systemSendKubun = systemSendKubun;
    }

    /**
     * AP受渡日時のgetメソッドです。
     *
     * @return AP受渡日時
     */
    @CheckForNull
    public YMDHMS getSystemSendYMD() {
        return systemSendYMD;
    }

    /**
     * AP受渡日時のsetメソッドです。
     *
     * @param systemSendYMD AP受渡日時
     */
    public void setSystemSendYMD(YMDHMS systemSendYMD) {
        this.systemSendYMD = systemSendYMD;
    }

    /**
     * データ受渡区分のgetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、2：受渡済
     *
     * @return データ受渡区分
     */
    @CheckForNull
    public Code getDataSendKubun() {
        return dataSendKubun;
    }

    /**
     * データ受渡区分のsetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、2：受渡済
     *
     * @param dataSendKubun データ受渡区分
     */
    public void setDataSendKubun(Code dataSendKubun) {
        this.dataSendKubun = dataSendKubun;
    }

    /**
     * データ受渡日時のgetメソッドです。
     *
     * @return データ受渡日時
     */
    @CheckForNull
    public YMDHMS getDataSendYMD() {
        return dataSendYMD;
    }

    /**
     * データ受渡日時のsetメソッドです。
     *
     * @param dataSendYMD データ受渡日時
     */
    public void setDataSendYMD(YMDHMS dataSendYMD) {
        this.dataSendYMD = dataSendYMD;
    }

    /**
     * データ取込区分のgetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、3：取込済）
     *
     * @return データ取込区分
     */
    @CheckForNull
    public Code getDataImportKubun() {
        return dataImportKubun;
    }

    /**
     * データ取込区分のsetメソッドです。
     * <br/>
     * <br/>データ引継区分（0：未、3：取込済）
     *
     * @param dataImportKubun データ取込区分
     */
    public void setDataImportKubun(Code dataImportKubun) {
        this.dataImportKubun = dataImportKubun;
    }

    /**
     * データ取込日時のgetメソッドです。
     *
     * @return データ取込日時
     */
    @CheckForNull
    public YMDHMS getDataImportYMD() {
        return dataImportYMD;
    }

    /**
     * データ取込日時のsetメソッドです。
     *
     * @param dataImportYMD データ取込日時
     */
    public void setDataImportYMD(YMDHMS dataImportYMD) {
        this.dataImportYMD = dataImportYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT252MochidashiPcJotaiKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT252MochidashiPcJotaiKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT252MochidashiPcJotaiKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.tohyokuCode, other.tohyokuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT252MochidashiPcJotaiKanriEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.tohyokuCode = entity.tohyokuCode;
        this.dataCreateKubun = entity.dataCreateKubun;
        this.dataCreateYMD = entity.dataCreateYMD;
        this.systemSendKubun = entity.systemSendKubun;
        this.systemSendYMD = entity.systemSendYMD;
        this.dataSendKubun = entity.dataSendKubun;
        this.dataSendYMD = entity.dataSendYMD;
        this.dataImportKubun = entity.dataImportKubun;
        this.dataImportYMD = entity.dataImportYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, tohyokuCode, dataCreateKubun, dataCreateYMD, systemSendKubun, systemSendYMD, dataSendKubun, dataSendYMD, dataImportKubun, dataImportYMD);
    }

// </editor-fold>
}
