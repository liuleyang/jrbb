package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 送致書の投票使用汚損残余枚数欄に印字するための、投票用紙枚数を選挙、投票区別に管理する。テーブルのエンティティクラスです。
 */
public class AfT251TohyoYoshiMaisuKanriEntity extends DbTableEntityBase<AfT251TohyoYoshiMaisuKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT251TohyoYoshiMaisuKanri");

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
    private SenkyoNo senkyoNo;
    @PrimaryKey
    private RString tohyokuCode;
    private int tohyoYoshiMaisu;
    private int tenjiYoshiMaisu;
    private int kariFutoMaisu;

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
     * 選挙番号のgetメソッドです。
     * 
     * @return 選挙番号
     */
    public SenkyoNo getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * 選挙番号のsetメソッドです。
     * 
     * @param senkyoNo 選挙番号
     */
    public void setSenkyoNo(@Nonnull SenkyoNo senkyoNo) {
        this.senkyoNo = senkyoNo;
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
     * 投票用紙枚数のgetメソッドです。
     * 
     * @return 投票用紙枚数
     */
    @CheckForNull
    public int getTohyoYoshiMaisu() {
        return tohyoYoshiMaisu;
    }

    /**
     * 投票用紙枚数のsetメソッドです。
     * 
     * @param tohyoYoshiMaisu 投票用紙枚数
     */
    public void setTohyoYoshiMaisu(int tohyoYoshiMaisu) {
        this.tohyoYoshiMaisu = tohyoYoshiMaisu;
    }

    /**
     * 点字投票用紙枚数のgetメソッドです。
     * 
     * @return 点字投票用紙枚数
     */
    @CheckForNull
    public int getTenjiYoshiMaisu() {
        return tenjiYoshiMaisu;
    }

    /**
     * 点字投票用紙枚数のsetメソッドです。
     * 
     * @param tenjiYoshiMaisu 点字投票用紙枚数
     */
    public void setTenjiYoshiMaisu(int tenjiYoshiMaisu) {
        this.tenjiYoshiMaisu = tenjiYoshiMaisu;
    }

    /**
     * 仮投票用封筒枚数のgetメソッドです。
     * 
     * @return 仮投票用封筒枚数
     */
    @CheckForNull
    public int getKariFutoMaisu() {
        return kariFutoMaisu;
    }

    /**
     * 仮投票用封筒枚数のsetメソッドです。
     * 
     * @param kariFutoMaisu 仮投票用封筒枚数
     */
    public void setKariFutoMaisu(int kariFutoMaisu) {
        this.kariFutoMaisu = kariFutoMaisu;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT251TohyoYoshiMaisuKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT251TohyoYoshiMaisuKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT251TohyoYoshiMaisuKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.senkyoNo, other.senkyoNo)) {
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
    public void shallowCopy(AfT251TohyoYoshiMaisuKanriEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.senkyoNo = entity.senkyoNo;
        this.tohyokuCode = entity.tohyokuCode;
        this.tohyoYoshiMaisu = entity.tohyoYoshiMaisu;
        this.tenjiYoshiMaisu = entity.tenjiYoshiMaisu;
        this.kariFutoMaisu = entity.kariFutoMaisu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, senkyoNo, tohyokuCode, tohyoYoshiMaisu, tenjiYoshiMaisu, kariFutoMaisu);
    }

// </editor-fold>
}
