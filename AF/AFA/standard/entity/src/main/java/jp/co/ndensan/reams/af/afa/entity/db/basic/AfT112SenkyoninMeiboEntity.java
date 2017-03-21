package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 各種選挙の選挙人名簿、投票人名簿を保持する。テーブルのエンティティクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class AfT112SenkyoninMeiboEntity extends DbTableEntityBase<AfT112SenkyoninMeiboEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT112SenkyoninMeibo");

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
    private RString groupCode;
    @PrimaryKey
    private RString tohyokuCode;
    @PrimaryKey
    private RString satsu;
    @PrimaryKey
    private int page;
    @PrimaryKey
    private int gyo;
    @PrimaryKey
    private BigSerial seq;
    private ShikibetsuCode shikibetsuCode;
    private boolean tohyokuHenkoMasshoFlag;
    private int renban;
    private int edaban;

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
     * グループコードのgetメソッドです。
     * <br/>
     * <br/>抄本を有権者、表示者でまとめる場合は、選挙資格区分をセット。 居住、非居住でまとめる場合は、居住区分をセット。 指定なしの場合は’0’をセット。
     *
     * @return グループコード
     */
    public RString getGroupCode() {
        return groupCode;
    }

    /**
     * グループコードのsetメソッドです。
     * <br/>
     * <br/>抄本を有権者、表示者でまとめる場合は、選挙資格区分をセット。 居住、非居住でまとめる場合は、居住区分をセット。 指定なしの場合は’0’をセット。
     *
     * @param groupCode グループコード
     */
    public void setGroupCode(@Nonnull RString groupCode) {
        this.groupCode = groupCode;
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
     * 冊のgetメソッドです。
     * <br/>
     * <br/>分冊する場合使用する。（1からの連番） 指定なしの場合は’00’をセット。
     *
     * @return 冊
     */
    public RString getSatsu() {
        return satsu;
    }

    /**
     * 冊のsetメソッドです。
     * <br/>
     * <br/>分冊する場合使用する。（1からの連番） 指定なしの場合は’00’をセット。
     *
     * @param satsu 冊
     */
    public void setSatsu(@Nonnull RString satsu) {
        this.satsu = satsu;
    }

    /**
     * 頁のgetメソッドです。
     * <br/>
     * <br/>最大6桁を想定
     *
     * @return 頁
     */
    public int getPage() {
        return page;
    }

    /**
     * 頁のsetメソッドです。
     * <br/>
     * <br/>最大6桁を想定
     *
     * @param page 頁
     */
    public void setPage(@Nonnull int page) {
        this.page = page;
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    public int getGyo() {
        return gyo;
    }

    /**
     * 行のsetメソッドです。
     *
     * @param gyo 行
     */
    public void setGyo(@Nonnull int gyo) {
        this.gyo = gyo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public BigSerial getSeq() {
        return seq;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param seq 履歴番号
     */
    public void setSeq(@Nonnull BigSerial seq) {
        this.seq = seq;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 投票区変更抹消フラグのgetメソッドです。
     * <br/>
     * <br/>定時登録の場合、転居前のレコードをTrueにする。
     *
     * @return 投票区変更抹消フラグ
     */
    public boolean getTohyokuHenkoMasshoFlag() {
        return tohyokuHenkoMasshoFlag;
    }

    /**
     * 投票区変更抹消フラグのsetメソッドです。
     * <br/>
     * <br/>定時登録の場合、転居前のレコードをTrueにする。
     *
     * @param tohyokuHenkoMasshoFlag 投票区変更抹消フラグ
     */
    public void setTohyokuHenkoMasshoFlag(@Nonnull boolean tohyokuHenkoMasshoFlag) {
        this.tohyokuHenkoMasshoFlag = tohyokuHenkoMasshoFlag;
    }

    /**
     * 連番のgetメソッドです。
     * <br/>
     * <br/>最初に名簿を作成した時の総頁をセットする。
     *
     * @return 連番
     */
    @CheckForNull
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * <br/>
     * <br/>最初に名簿を作成した時の総頁をセットする。
     *
     * @param renban 連番
     */
    public void setRenban(int renban) {
        this.renban = renban;
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    @CheckForNull
    public int getEdaban() {
        return edaban;
    }

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaban 枝番
     */
    public void setEdaban(int edaban) {
        this.edaban = edaban;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT112SenkyoninMeiboEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT112SenkyoninMeiboEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT112SenkyoninMeiboEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.groupCode, other.groupCode)) {
            return false;
        }
        if (!Objects.equals(this.tohyokuCode, other.tohyokuCode)) {
            return false;
        }
        if (!Objects.equals(this.satsu, other.satsu)) {
            return false;
        }
        if (this.page != other.page) {
            return false;
        }
        if (this.gyo != other.gyo) {
            return false;
        }
        if (!Objects.equals(this.seq, other.seq)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT112SenkyoninMeiboEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.groupCode = entity.groupCode;
        this.tohyokuCode = entity.tohyokuCode;
        this.satsu = entity.satsu;
        this.page = entity.page;
        this.gyo = entity.gyo;
        this.seq = entity.seq;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.tohyokuHenkoMasshoFlag = entity.tohyokuHenkoMasshoFlag;
        this.renban = entity.renban;
        this.edaban = entity.edaban;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, groupCode, tohyokuCode, satsu, page, gyo, seq, shikibetsuCode, tohyokuHenkoMasshoFlag, renban, edaban);
    }

// </editor-fold>
}
