package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 不在者投票交付時、期日前投票時、当日投票時の受付番号を採番する。 さまざまな採番方法に対応できるようにする。テーブルのエンティティクラスです。
 */
public class AfT250UketsukeNoEntity extends DbTableEntityBase<AfT250UketsukeNoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT250UketsukeNo");

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
    private Code shisetsuShubetsu;
    @PrimaryKey
    private RString code;
    @PrimaryKey
    private Code kijitsuFuzaiKubun;
    private long currentNumber;
    private long minNumber;
    private long maxNumber;
    private int effectiveDigit;

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
     * 施設種別のgetメソッドです。
     * <br/>
     * <br/>施設コード毎の採番の場合は使用不可。
     *
     * @return 施設種別
     */
    public Code getShisetsuShubetsu() {
        return shisetsuShubetsu;
    }

    /**
     * 施設種別のsetメソッドです。
     * <br/>
     * <br/>施設コード毎の採番の場合は使用不可。
     *
     * @param shisetsuShubetsu 施設種別
     */
    public void setShisetsuShubetsu(@Nonnull Code shisetsuShubetsu) {
        this.shisetsuShubetsu = shisetsuShubetsu;
    }

    /**
     * 施設種別の名称のgetメソッドです。
     * <br/>
     * <br/>施設コード毎の採番の場合は使用不可。
     *
     * @return 施設種別の名称
     */
    public RString getShisetsuShubetsuMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), shisetsuShubetsu);
    }

    /**
     * 施設種別の略称のgetメソッドです。
     * <br/>
     * <br/>施設コード毎の採番の場合は使用不可。
     *
     * @return 施設種別の略称
     */
    public RString getShisetsuShubetsuRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), shisetsuShubetsu);
    }

    /**
     * 施設種別のDescriptionのgetメソッドです。
     * <br/>
     * <br/>施設コード毎の採番の場合は使用不可。
     *
     * @return 施設種別のDescription
     */
    public RString getShisetsuShubetsuDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), shisetsuShubetsu);
    }

    /**
     * コードのgetメソッドです。
     * <br/>
     * <br/>期日前、不在者の時は施設コード。 当日の時は投票区コード。 施設区分毎の採番の場合は使用不可。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * コードのsetメソッドです。
     * <br/>
     * <br/>期日前、不在者の時は施設コード。 当日の時は投票区コード。 施設区分毎の採番の場合は使用不可。
     *
     * @param code コード
     */
    public void setCode(@Nonnull RString code) {
        this.code = code;
    }

    /**
     * 期日前不在者区分のgetメソッドです。
     * <br/>
     * <br/>不在者投票時と期日前投票時で別々に採番する場合に使用する。 0：通番（期日前と不在者の区別をしない） 1：期日前投票 2：不在者投票
     * 3：当日投票
     *
     * @return 期日前不在者区分
     */
    public Code getKijitsuFuzaiKubun() {
        return kijitsuFuzaiKubun;
    }

    /**
     * 期日前不在者区分のsetメソッドです。
     * <br/>
     * <br/>不在者投票時と期日前投票時で別々に採番する場合に使用する。 0：通番（期日前と不在者の区別をしない） 1：期日前投票 2：不在者投票
     * 3：当日投票
     *
     * @param kijitsuFuzaiKubun 期日前不在者区分
     */
    public void setKijitsuFuzaiKubun(@Nonnull Code kijitsuFuzaiKubun) {
        this.kijitsuFuzaiKubun = kijitsuFuzaiKubun;
    }

    /**
     * 期日前不在者区分の名称のgetメソッドです。
     * <br/>
     * <br/>不在者投票時と期日前投票時で別々に採番する場合に使用する。 0：通番（期日前と不在者の区別をしない） 1：期日前投票 2：不在者投票
     * 3：当日投票
     *
     * @return 期日前不在者区分の名称
     */
    public RString getKijitsuFuzaiKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), kijitsuFuzaiKubun);
    }

    /**
     * 期日前不在者区分の略称のgetメソッドです。
     * <br/>
     * <br/>不在者投票時と期日前投票時で別々に採番する場合に使用する。 0：通番（期日前と不在者の区別をしない） 1：期日前投票 2：不在者投票
     * 3：当日投票
     *
     * @return 期日前不在者区分の略称
     */
    public RString getKijitsuFuzaiKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), kijitsuFuzaiKubun);
    }

    /**
     * 期日前不在者区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>不在者投票時と期日前投票時で別々に採番する場合に使用する。 0：通番（期日前と不在者の区別をしない） 1：期日前投票 2：不在者投票
     * 3：当日投票
     *
     * @return 期日前不在者区分のDescription
     */
    public RString getKijitsuFuzaiKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), kijitsuFuzaiKubun);
    }

    /**
     * 番号のgetメソッドです。
     *
     * @return 番号
     */
    @CheckForNull
    public long getCurrentNumber() {
        return currentNumber;
    }

    /**
     * 番号のsetメソッドです。
     *
     * @param currentNumber 番号
     */
    public void setCurrentNumber(long currentNumber) {
        this.currentNumber = currentNumber;
    }

    /**
     * MIN番号のgetメソッドです。
     *
     * @return MIN番号
     */
    @CheckForNull
    public long getMinNumber() {
        return minNumber;
    }

    /**
     * MIN番号のsetメソッドです。
     *
     * @param minNumber MIN番号
     */
    public void setMinNumber(long minNumber) {
        this.minNumber = minNumber;
    }

    /**
     * MAX番号のgetメソッドです。
     *
     * @return MAX番号
     */
    @CheckForNull
    public long getMaxNumber() {
        return maxNumber;
    }

    /**
     * MAX番号のsetメソッドです。
     *
     * @param maxNumber MAX番号
     */
    public void setMaxNumber(long maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * 有効桁数のgetメソッドです。
     *
     * @return 有効桁数
     */
    @CheckForNull
    public int getEffectiveDigit() {
        return effectiveDigit;
    }

    /**
     * 有効桁数のsetメソッドです。
     *
     * @param effectiveDigit 有効桁数
     */
    public void setEffectiveDigit(int effectiveDigit) {
        this.effectiveDigit = effectiveDigit;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT250UketsukeNoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT250UketsukeNoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT250UketsukeNoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.shisetsuShubetsu, other.shisetsuShubetsu)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.kijitsuFuzaiKubun, other.kijitsuFuzaiKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT250UketsukeNoEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.shisetsuShubetsu = entity.shisetsuShubetsu;
        this.code = entity.code;
        this.kijitsuFuzaiKubun = entity.kijitsuFuzaiKubun;
        this.currentNumber = entity.currentNumber;
        this.minNumber = entity.minNumber;
        this.maxNumber = entity.maxNumber;
        this.effectiveDigit = entity.effectiveDigit;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, shisetsuShubetsu, code, kijitsuFuzaiKubun, currentNumber, minNumber, maxNumber, effectiveDigit);
    }

// </editor-fold>
}
