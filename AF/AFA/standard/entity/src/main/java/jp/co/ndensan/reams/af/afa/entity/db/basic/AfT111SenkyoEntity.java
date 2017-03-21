package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 各選挙の選挙名称や日付を管理する。 1抄本に1件以上の登録をする。テーブルのエンティティクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class AfT111SenkyoEntity extends DbTableEntityBase<AfT111SenkyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT111Senkyo");

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
    private Code senkyoLevel;
    private RString senkyoName;
    private RString senkyoRyakusho;
    private RString senkyoMark;
    private FlexibleDate kijunYMD;
    private FlexibleDate meiboTorokuYMD;
    private FlexibleDate kokujiYMD;
    private FlexibleDate tenshutsuKigenYMD;
    private FlexibleDate tennyuKigenYMD;
    private FlexibleDate tohyoUketsukeYMD;
    private boolean mutohyoSenkyoFlag;

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
     * 選挙番号のgetメソッドです。
     * <br/>
     * <br/>複数選挙ある場合の連番
     *
     * @return 選挙番号
     */
    public SenkyoNo getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * 選挙番号のsetメソッドです。
     * <br/>
     * <br/>複数選挙ある場合の連番
     *
     * @param senkyoNo 選挙番号
     */
    public void setSenkyoNo(@Nonnull SenkyoNo senkyoNo) {
        this.senkyoNo = senkyoNo;
    }

    /**
     * 選挙レベルのgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベル
     */
    @CheckForNull
    public Code getSenkyoLevel() {
        return senkyoLevel;
    }

    /**
     * 選挙レベルのsetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @param senkyoLevel 選挙レベル
     */
    public void setSenkyoLevel(Code senkyoLevel) {
        this.senkyoLevel = senkyoLevel;
    }

    /**
     * 選挙レベルの名称のgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベルの名称
     */
    public RString getSenkyoLevelMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), senkyoLevel);
    }

    /**
     * 選挙レベルの略称のgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベルの略称
     */
    public RString getSenkyoLevelRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), senkyoLevel);
    }

    /**
     * 選挙レベルのDescriptionのgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベルのDescription
     */
    public RString getSenkyoLevelDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), senkyoLevel);
    }

    /**
     * 選挙名称のgetメソッドです。
     *
     * @return 選挙名称
     */
    @CheckForNull
    public RString getSenkyoName() {
        return senkyoName;
    }

    /**
     * 選挙名称のsetメソッドです。
     *
     * @param senkyoName 選挙名称
     */
    public void setSenkyoName(RString senkyoName) {
        this.senkyoName = senkyoName;
    }

    /**
     * 選挙略称のgetメソッドです。
     *
     * @return 選挙略称
     */
    @CheckForNull
    public RString getSenkyoRyakusho() {
        return senkyoRyakusho;
    }

    /**
     * 選挙略称のsetメソッドです。
     *
     * @param senkyoRyakusho 選挙略称
     */
    public void setSenkyoRyakusho(RString senkyoRyakusho) {
        this.senkyoRyakusho = senkyoRyakusho;
    }

    /**
     * 選挙マークのgetメソッドです。
     *
     * @return 選挙マーク
     */
    @CheckForNull
    public RString getSenkyoMark() {
        return senkyoMark;
    }

    /**
     * 選挙マークのsetメソッドです。
     *
     * @param senkyoMark 選挙マーク
     */
    public void setSenkyoMark(RString senkyoMark) {
        this.senkyoMark = senkyoMark;
    }

    /**
     * 名簿基準年月日のgetメソッドです。
     * <br/>
     * <br/>定時登録：3、6、9、12月1日 選挙時：告示（公示）年月日の前日 農委：1月1日 海区：9月1日
     *
     * @return 名簿基準年月日
     */
    @CheckForNull
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * 名簿基準年月日のsetメソッドです。
     * <br/>
     * <br/>定時登録：3、6、9、12月1日 選挙時：告示（公示）年月日の前日 農委：1月1日 海区：9月1日
     *
     * @param kijunYMD 名簿基準年月日
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * 名簿登録年月日のgetメソッドです。
     * <br/>
     * <br/>定時登録：名簿基準年月日の翌日 選挙時：名簿基準年月日 農委：3月31日 海区：12月5日
     *
     * @return 名簿登録年月日
     */
    @CheckForNull
    public FlexibleDate getMeiboTorokuYMD() {
        return meiboTorokuYMD;
    }

    /**
     * 名簿登録年月日のsetメソッドです。
     * <br/>
     * <br/>定時登録：名簿基準年月日の翌日 選挙時：名簿基準年月日 農委：3月31日 海区：12月5日
     *
     * @param meiboTorokuYMD 名簿登録年月日
     */
    public void setMeiboTorokuYMD(FlexibleDate meiboTorokuYMD) {
        this.meiboTorokuYMD = meiboTorokuYMD;
    }

    /**
     * 告示（公示）年月日のgetメソッドです。
     * <br/>
     * <br/>名簿基準年月日の翌日
     *
     * @return 告示（公示）年月日
     */
    @CheckForNull
    public FlexibleDate getKokujiYMD() {
        return kokujiYMD;
    }

    /**
     * 告示（公示）年月日のsetメソッドです。
     * <br/>
     * <br/>名簿基準年月日の翌日
     *
     * @param kokujiYMD 告示（公示）年月日
     */
    public void setKokujiYMD(FlexibleDate kokujiYMD) {
        this.kokujiYMD = kokujiYMD;
    }

    /**
     * 転出期限年月日のgetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期間開始年月日（基準日の翌日）をセット
     *
     * @return 転出期限年月日
     */
    @CheckForNull
    public FlexibleDate getTenshutsuKigenYMD() {
        return tenshutsuKigenYMD;
    }

    /**
     * 転出期限年月日のsetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期間開始年月日（基準日の翌日）をセット
     *
     * @param tenshutsuKigenYMD 転出期限年月日
     */
    public void setTenshutsuKigenYMD(FlexibleDate tenshutsuKigenYMD) {
        this.tenshutsuKigenYMD = tenshutsuKigenYMD;
    }

    /**
     * 転入期限年月日のgetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期限年月日（基準日＋14日）をセット
     *
     * @return 転入期限年月日
     */
    @CheckForNull
    public FlexibleDate getTennyuKigenYMD() {
        return tennyuKigenYMD;
    }

    /**
     * 転入期限年月日のsetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期限年月日（基準日＋14日）をセット
     *
     * @param tennyuKigenYMD 転入期限年月日
     */
    public void setTennyuKigenYMD(FlexibleDate tennyuKigenYMD) {
        this.tennyuKigenYMD = tennyuKigenYMD;
    }

    /**
     * 投票受付開始年月日のgetメソッドです。
     *
     * @return 投票受付開始年月日
     */
    @CheckForNull
    public FlexibleDate getTohyoUketsukeYMD() {
        return tohyoUketsukeYMD;
    }

    /**
     * 投票受付開始年月日のsetメソッドです。
     *
     * @param tohyoUketsukeYMD 投票受付開始年月日
     */
    public void setTohyoUketsukeYMD(FlexibleDate tohyoUketsukeYMD) {
        this.tohyoUketsukeYMD = tohyoUketsukeYMD;
    }

    /**
     * 無投票選挙フラグのgetメソッドです。
     * <br/>
     * <br/>True：無投票選挙になった False：選挙開催となった
     *
     * @return 無投票選挙フラグ
     */
    public boolean getMutohyoSenkyoFlag() {
        return mutohyoSenkyoFlag;
    }

    /**
     * 無投票選挙フラグのsetメソッドです。
     * <br/>
     * <br/>True：無投票選挙になった False：選挙開催となった
     *
     * @param mutohyoSenkyoFlag 無投票選挙フラグ
     */
    public void setMutohyoSenkyoFlag(@Nonnull boolean mutohyoSenkyoFlag) {
        this.mutohyoSenkyoFlag = mutohyoSenkyoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT111SenkyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT111SenkyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT111SenkyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.senkyoNo, other.senkyoNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT111SenkyoEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.senkyoNo = entity.senkyoNo;
        this.senkyoLevel = entity.senkyoLevel;
        this.senkyoName = entity.senkyoName;
        this.senkyoRyakusho = entity.senkyoRyakusho;
        this.senkyoMark = entity.senkyoMark;
        this.kijunYMD = entity.kijunYMD;
        this.meiboTorokuYMD = entity.meiboTorokuYMD;
        this.kokujiYMD = entity.kokujiYMD;
        this.tenshutsuKigenYMD = entity.tenshutsuKigenYMD;
        this.tennyuKigenYMD = entity.tennyuKigenYMD;
        this.tohyoUketsukeYMD = entity.tohyoUketsukeYMD;
        this.mutohyoSenkyoFlag = entity.mutohyoSenkyoFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, senkyoNo, senkyoLevel, senkyoName, senkyoRyakusho, senkyoMark, kijunYMD, meiboTorokuYMD, kokujiYMD, tenshutsuKigenYMD, tennyuKigenYMD, tohyoUketsukeYMD, mutohyoSenkyoFlag);
    }

// </editor-fold>
}
