package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 名簿調整プログラムで抽選された裁判員候補者予定者名簿を、年度別に保持する。テーブルのエンティティクラスです。
 */
public class AfT302SaibaninYoteishaEntity extends DbTableEntityBase<AfT302SaibaninYoteishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT302SaibaninYoteisha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RYear nendo;
    @PrimaryKey
    private int senkanRenban;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private AtenaMeisho shimei;
    private FlexibleDate seinengappiYMD;
    private YubinNo yubinNo;
    private RString jusho;
    private RString honsekichi;
    private Code saibaninShinsainKubun;

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
     * 選管連番のgetメソッドです。
     *
     * @return 選管連番
     */
    public int getSenkanRenban() {
        return senkanRenban;
    }

    /**
     * 選管連番のsetメソッドです。
     *
     * @param senkanRenban 選管連番
     */
    public void setSenkanRenban(@Nonnull int senkanRenban) {
        this.senkanRenban = senkanRenban;
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
     * 氏名のgetメソッドです。
     *
     * @return 氏名
     */
    @CheckForNull
    public AtenaMeisho getShimei() {
        return shimei;
    }

    /**
     * 氏名のsetメソッドです。
     *
     * @param shimei 氏名
     */
    public void setShimei(AtenaMeisho shimei) {
        this.shimei = shimei;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    @CheckForNull
    public FlexibleDate getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     *
     * @param seinengappiYMD 生年月日
     */
    public void setSeinengappiYMD(FlexibleDate seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
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
    public RString getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * 本籍地のgetメソッドです。
     *
     * @return 本籍地
     */
    @CheckForNull
    public RString getHonsekichi() {
        return honsekichi;
    }

    /**
     * 本籍地のsetメソッドです。
     *
     * @param honsekichi 本籍地
     */
    public void setHonsekichi(RString honsekichi) {
        this.honsekichi = honsekichi;
    }

    /**
     * 裁判員審査員区分のgetメソッドです。
     *
     * @return 裁判員審査員区分
     */
    @CheckForNull
    public Code getSaibaninShinsainKubun() {
        return saibaninShinsainKubun;
    }

    /**
     * 裁判員審査員区分のsetメソッドです。
     *
     * @param saibaninShinsainKubun 裁判員審査員区分
     */
    public void setSaibaninShinsainKubun(Code saibaninShinsainKubun) {
        this.saibaninShinsainKubun = saibaninShinsainKubun;
    }

    /**
     * 裁判員審査員区分の名称のgetメソッドです。
     *
     * @return 裁判員審査員区分の名称
     */
    public RString getSaibaninShinsainKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.裁判員審査員区分.getCodeShubetsu(), saibaninShinsainKubun);
    }

    /**
     * 裁判員審査員区分の略称のgetメソッドです。
     *
     * @return 裁判員審査員区分の略称
     */
    public RString getSaibaninShinsainKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.裁判員審査員区分.getCodeShubetsu(), saibaninShinsainKubun);
    }

    /**
     * このエンティティの主キーが他の{@literal AfT302SaibaninYoteishaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT302SaibaninYoteishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT302SaibaninYoteishaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (this.senkanRenban != other.senkanRenban) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT302SaibaninYoteishaEntity entity) {
        this.nendo = entity.nendo;
        this.senkanRenban = entity.senkanRenban;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shimei = entity.shimei;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.honsekichi = entity.honsekichi;
        this.saibaninShinsainKubun = entity.saibaninShinsainKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, senkanRenban, shikibetsuCode, shimei, seinengappiYMD, yubinNo, jusho, honsekichi, saibaninShinsainKubun);
    }

// </editor-fold>
}
