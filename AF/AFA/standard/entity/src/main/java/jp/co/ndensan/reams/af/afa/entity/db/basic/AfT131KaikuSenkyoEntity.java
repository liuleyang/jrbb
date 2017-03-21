package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 農業、海区名簿の確定、最新化等の日付情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT131KaikuSenkyoEntity extends DbTableEntityBase<AfT131KaikuSenkyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT131KaikuSenkyo");

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
    private RYear nendo;
    private FlexibleDate sakuseiYMD;
    private FlexibleDate kakuteiYMD;
    private FlexibleDate saishinkaYMD;
    private boolean senkyojiTorokuFlag;

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
     * 年度のgetメソッドです。
     * 
     * @return 年度
     */
    public RYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     * 
     * @param nendo 年度
     */
    public void setNendo(@Nonnull RYear nendo) {
        this.nendo = nendo;
    }

    /**
     * 名簿作成年月日のgetメソッドです。
     * <br/>
     * <br/>名簿を最初に作成した日
     * 
     * @return 名簿作成年月日
     */
    @CheckForNull
    public FlexibleDate getSakuseiYMD() {
        return sakuseiYMD;
    }

    /**
     * 名簿作成年月日のsetメソッドです。
     * <br/>
     * <br/>名簿を最初に作成した日
     * 
     * @param sakuseiYMD 名簿作成年月日
     */
    public void setSakuseiYMD(FlexibleDate sakuseiYMD) {
        this.sakuseiYMD = sakuseiYMD;
    }

    /**
     * 名簿確定年月日のgetメソッドです。
     * <br/>
     * <br/>名簿を確定した日
     * 
     * @return 名簿確定年月日
     */
    @CheckForNull
    public FlexibleDate getKakuteiYMD() {
        return kakuteiYMD;
    }

    /**
     * 名簿確定年月日のsetメソッドです。
     * <br/>
     * <br/>名簿を確定した日
     * 
     * @param kakuteiYMD 名簿確定年月日
     */
    public void setKakuteiYMD(FlexibleDate kakuteiYMD) {
        this.kakuteiYMD = kakuteiYMD;
    }

    /**
     * 名簿最新化年月日のgetメソッドです。
     * <br/>
     * <br/>最新化処理を行った日
     * 
     * @return 名簿最新化年月日
     */
    @CheckForNull
    public FlexibleDate getSaishinkaYMD() {
        return saishinkaYMD;
    }

    /**
     * 名簿最新化年月日のsetメソッドです。
     * <br/>
     * <br/>最新化処理を行った日
     * 
     * @param saishinkaYMD 名簿最新化年月日
     */
    public void setSaishinkaYMD(FlexibleDate saishinkaYMD) {
        this.saishinkaYMD = saishinkaYMD;
    }

    /**
     * 選挙時登録フラグのgetメソッドです。
     * <br/>
     * <br/>True:選挙時登録からの登録の場合 False：選挙人名簿作成（登載申請書等）からの登録の場合
     * 
     * @return 選挙時登録フラグ
     */
    public boolean getSenkyojiTorokuFlag() {
        return senkyojiTorokuFlag;
    }

    /**
     * 選挙時登録フラグのsetメソッドです。
     * <br/>
     * <br/>True:選挙時登録からの登録の場合 False：選挙人名簿作成（登載申請書等）からの登録の場合
     * 
     * @param senkyojiTorokuFlag 選挙時登録フラグ
     */
    public void setSenkyojiTorokuFlag(@Nonnull boolean senkyojiTorokuFlag) {
        this.senkyojiTorokuFlag = senkyojiTorokuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT131KaikuSenkyoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT131KaikuSenkyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT131KaikuSenkyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT131KaikuSenkyoEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.nendo = entity.nendo;
        this.sakuseiYMD = entity.sakuseiYMD;
        this.kakuteiYMD = entity.kakuteiYMD;
        this.saishinkaYMD = entity.saishinkaYMD;
        this.senkyojiTorokuFlag = entity.senkyojiTorokuFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, nendo, sakuseiYMD, kakuteiYMD, saishinkaYMD, senkyojiTorokuFlag);
    }

// </editor-fold>

}
