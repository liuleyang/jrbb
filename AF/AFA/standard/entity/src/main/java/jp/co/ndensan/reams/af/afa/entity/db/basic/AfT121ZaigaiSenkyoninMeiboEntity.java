package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 在外選挙人名簿、在外投票人名簿の情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT121ZaigaiSenkyoninMeiboEntity extends DbTableEntityBase<AfT121ZaigaiSenkyoninMeiboEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT121ZaigaiSenkyoninMeibo");

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
    private RString kokugaiBunruiCode;
    @PrimaryKey
    private RString satsu;
    @PrimaryKey
    private int page;
    @PrimaryKey
    private int gyo;
    private ShikibetsuCode shikibetsuCode;

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
     * グループコードのgetメソッドです。
     * 
     * @return グループコード
     */
    public RString getGroupCode() {
        return groupCode;
    }

    /**
     * グループコードのsetメソッドです。
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
     * 国外分類コードのgetメソッドです。
     * <br/>
     * <br/>領事官コードまたは国籍コードでページを１に戻すとき、それぞれのコードを設定する 上記以外は"000"を設定する
     * 
     * @return 国外分類コード
     */
    public RString getKokugaiBunruiCode() {
        return kokugaiBunruiCode;
    }

    /**
     * 国外分類コードのsetメソッドです。
     * <br/>
     * <br/>領事官コードまたは国籍コードでページを１に戻すとき、それぞれのコードを設定する 上記以外は"000"を設定する
     * 
     * @param kokugaiBunruiCode 国外分類コード
     */
    public void setKokugaiBunruiCode(@Nonnull RString kokugaiBunruiCode) {
        this.kokugaiBunruiCode = kokugaiBunruiCode;
    }

    /**
     * 冊のgetメソッドです。
     * 
     * @return 冊
     */
    public RString getSatsu() {
        return satsu;
    }

    /**
     * 冊のsetメソッドです。
     * 
     * @param satsu 冊
     */
    public void setSatsu(@Nonnull RString satsu) {
        this.satsu = satsu;
    }

    /**
     * 頁のgetメソッドです。
     * 
     * @return 頁
     */
    public int getPage() {
        return page;
    }

    /**
     * 頁のsetメソッドです。
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
     * このエンティティの主キーが他の{@literal AfT121ZaigaiSenkyoninMeiboEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT121ZaigaiSenkyoninMeiboEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT121ZaigaiSenkyoninMeiboEntity other) {
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
        if (!Objects.equals(this.kokugaiBunruiCode, other.kokugaiBunruiCode)) {
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.groupCode = entity.groupCode;
        this.tohyokuCode = entity.tohyokuCode;
        this.kokugaiBunruiCode = entity.kokugaiBunruiCode;
        this.satsu = entity.satsu;
        this.page = entity.page;
        this.gyo = entity.gyo;
        this.shikibetsuCode = entity.shikibetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, groupCode, tohyokuCode, kokugaiBunruiCode, satsu, page, gyo, shikibetsuCode);
    }

// </editor-fold>

}
