package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 投票所の情報を保持する。 このテーブルは、投票区や選挙種類にかかわらずに投票所情報を保持する。テーブルのエンティティクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class AfT502TohyojoEntity extends DbTableEntityBase<AfT502TohyojoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT502Tohyojo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString tohyojoCode;
    private RString tohyojoName;
    private RString kanaTohyojoName;
    private RString searchKanaTohyojoName;
    private RTime tohyoStartTime;
    private RTime tohyoStopTime;
    private boolean zaigaiTohyoKanoFlag;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private AtenaMeisho tohyojoAtena;
    private TelNo telNo;
    private TelNo faxNo;
    private RString mapImage;

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
     * 投票所コードのgetメソッドです。
     *
     * @return 投票所コード
     */
    public RString getTohyojoCode() {
        return tohyojoCode;
    }

    /**
     * 投票所コードのsetメソッドです。
     *
     * @param tohyojoCode 投票所コード
     */
    public void setTohyojoCode(@Nonnull RString tohyojoCode) {
        this.tohyojoCode = tohyojoCode;
    }

    /**
     * 投票所名称のgetメソッドです。
     *
     * @return 投票所名称
     */
    @CheckForNull
    public RString getTohyojoName() {
        return tohyojoName;
    }

    /**
     * 投票所名称のsetメソッドです。
     *
     * @param tohyojoName 投票所名称
     */
    public void setTohyojoName(RString tohyojoName) {
        this.tohyojoName = tohyojoName;
    }

    /**
     * カナ投票所名称のgetメソッドです。
     *
     * @return カナ投票所名称
     */
    @CheckForNull
    public RString getKanaTohyojoName() {
        return kanaTohyojoName;
    }

    /**
     * カナ投票所名称のsetメソッドです。
     *
     * @param kanaTohyojoName カナ投票所名称
     */
    public void setKanaTohyojoName(RString kanaTohyojoName) {
        this.kanaTohyojoName = kanaTohyojoName;
    }

    /**
     * 検索用カナ投票所名称のgetメソッドです。
     *
     * @return 検索用カナ投票所名称
     */
    @CheckForNull
    public RString getSearchKanaTohyojoName() {
        return searchKanaTohyojoName;
    }

    /**
     * 検索用カナ投票所名称のsetメソッドです。
     *
     * @param searchKanaTohyojoName 検索用カナ投票所名称
     */
    public void setSearchKanaTohyojoName(RString searchKanaTohyojoName) {
        this.searchKanaTohyojoName = searchKanaTohyojoName;
    }

    /**
     * 投票開始時刻のgetメソッドです。
     *
     * @return 投票開始時刻
     */
    @CheckForNull
    public RTime getTohyoStartTime() {
        return tohyoStartTime;
    }

    /**
     * 投票開始時刻のsetメソッドです。
     *
     * @param tohyoStartTime 投票開始時刻
     */
    public void setTohyoStartTime(RTime tohyoStartTime) {
        this.tohyoStartTime = tohyoStartTime;
    }

    /**
     * 投票終了時刻のgetメソッドです。
     *
     * @return 投票終了時刻
     */
    @CheckForNull
    public RTime getTohyoStopTime() {
        return tohyoStopTime;
    }

    /**
     * 投票終了時刻のsetメソッドです。
     *
     * @param tohyoStopTime 投票終了時刻
     */
    public void setTohyoStopTime(RTime tohyoStopTime) {
        this.tohyoStopTime = tohyoStopTime;
    }

    /**
     * 在外投票可能フラグのgetメソッドです。
     * <br/>
     * <br/>True:在外投票可能な投票所の場合 False：在外投票できない投票所の場合
     *
     * @return 在外投票可能フラグ
     */
    public boolean getZaigaiTohyoKanoFlag() {
        return zaigaiTohyoKanoFlag;
    }

    /**
     * 在外投票可能フラグのsetメソッドです。
     * <br/>
     * <br/>True:在外投票可能な投票所の場合 False：在外投票できない投票所の場合
     *
     * @param zaigaiTohyoKanoFlag 在外投票可能フラグ
     */
    public void setZaigaiTohyoKanoFlag(@Nonnull boolean zaigaiTohyoKanoFlag) {
        this.zaigaiTohyoKanoFlag = zaigaiTohyoKanoFlag;
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     *
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    @CheckForNull
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * 投票所宛名のgetメソッドです。
     *
     * @return 投票所宛名
     */
    @CheckForNull
    public AtenaMeisho getTohyojoAtena() {
        return tohyojoAtena;
    }

    /**
     * 投票所宛名のsetメソッドです。
     *
     * @param tohyojoAtena 投票所宛名
     */
    public void setTohyojoAtena(AtenaMeisho tohyojoAtena) {
        this.tohyojoAtena = tohyojoAtena;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     *
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * FAX番号のgetメソッドです。
     *
     * @return FAX番号
     */
    @CheckForNull
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     *
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * 地図ファイル名のgetメソッドです。
     *
     * @return 地図ファイル名
     */
    @CheckForNull
    public RString getMapImage() {
        return mapImage;
    }

    /**
     * 地図ファイル名のsetメソッドです。
     *
     * @param mapImage 地図ファイル名
     */
    public void setMapImage(RString mapImage) {
        this.mapImage = mapImage;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT502TohyojoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT502TohyojoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT502TohyojoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.tohyojoCode, other.tohyojoCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT502TohyojoEntity entity) {
        this.tohyojoCode = entity.tohyojoCode;
        this.tohyojoName = entity.tohyojoName;
        this.kanaTohyojoName = entity.kanaTohyojoName;
        this.searchKanaTohyojoName = entity.searchKanaTohyojoName;
        this.tohyoStartTime = entity.tohyoStartTime;
        this.tohyoStopTime = entity.tohyoStopTime;
        this.zaigaiTohyoKanoFlag = entity.zaigaiTohyoKanoFlag;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.tohyojoAtena = entity.tohyojoAtena;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.mapImage = entity.mapImage;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(tohyojoCode, tohyojoName, kanaTohyojoName, searchKanaTohyojoName, tohyoStartTime, tohyoStopTime, zaigaiTohyoKanoFlag, yubinNo, jusho, tohyojoAtena, telNo, faxNo, mapImage);
    }

// </editor-fold>
}
