package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 財産区議会議員選挙人名簿や、住民投票人名簿を作成するための選挙人抽出条件を保持するテーブルのエンティティクラスです。
 */
public class AfT141ZaisankuJuminTohyoConditionEntity extends DbTableEntityBase<AfT141ZaisankuJuminTohyoConditionEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT141ZaisankuJuminTohyoCondition");

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
    private FlexibleDate nenreiKeisanKijunYMD;
    private int nenrei;
    private boolean birthdayFukumuFlag;
    private int kyojuNensu;
    private FlexibleDate juteiFirstYMD;
    private FlexibleDate juteiLastYMD;
    private boolean japaneseFlag;
    private boolean foreignerFlag;
    private boolean juminFlag;
    private boolean tenshutsushaFlag;
    private boolean tennyushaFlag;
    private boolean teishishaFukumuFlag;

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
     * 年齢計算基準年月日のgetメソッドです。
     * <br/>
     * <br/>『年齢計算基準年月日』時点で『年齢』以上の人を対象とする。
     * 
     * @return 年齢計算基準年月日
     */
    @CheckForNull
    public FlexibleDate getNenreiKeisanKijunYMD() {
        return nenreiKeisanKijunYMD;
    }

    /**
     * 年齢計算基準年月日のsetメソッドです。
     * <br/>
     * <br/>『年齢計算基準年月日』時点で『年齢』以上の人を対象とする。
     * 
     * @param nenreiKeisanKijunYMD 年齢計算基準年月日
     */
    public void setNenreiKeisanKijunYMD(FlexibleDate nenreiKeisanKijunYMD) {
        this.nenreiKeisanKijunYMD = nenreiKeisanKijunYMD;
    }

    /**
     * 年齢のgetメソッドです。
     * 
     * @return 年齢
     */
    @CheckForNull
    public int getNenrei() {
        return nenrei;
    }

    /**
     * 年齢のsetメソッドです。
     * 
     * @param nenrei 年齢
     */
    public void setNenrei(int nenrei) {
        this.nenrei = nenrei;
    }

    /**
     * 誕生日含フラグのgetメソッドです。
     * <br/>
     * <br/>『年齢計算基準日＋1日』の誕生日の人を含む。
     * 
     * @return 誕生日含フラグ
     */
    public boolean getBirthdayFukumuFlag() {
        return birthdayFukumuFlag;
    }

    /**
     * 誕生日含フラグのsetメソッドです。
     * <br/>
     * <br/>『年齢計算基準日＋1日』の誕生日の人を含む。
     * 
     * @param birthdayFukumuFlag 誕生日含フラグ
     */
    public void setBirthdayFukumuFlag(@Nonnull boolean birthdayFukumuFlag) {
        this.birthdayFukumuFlag = birthdayFukumuFlag;
    }

    /**
     * 居住年数のgetメソッドです。
     * <br/>
     * <br/>財産区選挙時に入力
     * 
     * @return 居住年数
     */
    @CheckForNull
    public int getKyojuNensu() {
        return kyojuNensu;
    }

    /**
     * 居住年数のsetメソッドです。
     * <br/>
     * <br/>財産区選挙時に入力
     * 
     * @param kyojuNensu 居住年数
     */
    public void setKyojuNensu(int kyojuNensu) {
        this.kyojuNensu = kyojuNensu;
    }

    /**
     * 住定開始年月日のgetメソッドです。
     * <br/>
     * <br/>住民投票時に入力
     * 
     * @return 住定開始年月日
     */
    @CheckForNull
    public FlexibleDate getJuteiFirstYMD() {
        return juteiFirstYMD;
    }

    /**
     * 住定開始年月日のsetメソッドです。
     * <br/>
     * <br/>住民投票時に入力
     * 
     * @param juteiFirstYMD 住定開始年月日
     */
    public void setJuteiFirstYMD(FlexibleDate juteiFirstYMD) {
        this.juteiFirstYMD = juteiFirstYMD;
    }

    /**
     * 住定終了年月日のgetメソッドです。
     * <br/>
     * <br/>住民投票時に入力
     * 
     * @return 住定終了年月日
     */
    @CheckForNull
    public FlexibleDate getJuteiLastYMD() {
        return juteiLastYMD;
    }

    /**
     * 住定終了年月日のsetメソッドです。
     * <br/>
     * <br/>住民投票時に入力
     * 
     * @param juteiLastYMD 住定終了年月日
     */
    public void setJuteiLastYMD(FlexibleDate juteiLastYMD) {
        this.juteiLastYMD = juteiLastYMD;
    }

    /**
     * 日本人フラグのgetメソッドです。
     * 
     * @return 日本人フラグ
     */
    public boolean getJapaneseFlag() {
        return japaneseFlag;
    }

    /**
     * 日本人フラグのsetメソッドです。
     * 
     * @param japaneseFlag 日本人フラグ
     */
    public void setJapaneseFlag(@Nonnull boolean japaneseFlag) {
        this.japaneseFlag = japaneseFlag;
    }

    /**
     * 外国人フラグのgetメソッドです。
     * 
     * @return 外国人フラグ
     */
    public boolean getForeignerFlag() {
        return foreignerFlag;
    }

    /**
     * 外国人フラグのsetメソッドです。
     * 
     * @param foreignerFlag 外国人フラグ
     */
    public void setForeignerFlag(@Nonnull boolean foreignerFlag) {
        this.foreignerFlag = foreignerFlag;
    }

    /**
     * 住民フラグのgetメソッドです。
     * 
     * @return 住民フラグ
     */
    public boolean getJuminFlag() {
        return juminFlag;
    }

    /**
     * 住民フラグのsetメソッドです。
     * 
     * @param juminFlag 住民フラグ
     */
    public void setJuminFlag(@Nonnull boolean juminFlag) {
        this.juminFlag = juminFlag;
    }

    /**
     * 転出者フラグのgetメソッドです。
     * 
     * @return 転出者フラグ
     */
    public boolean getTenshutsushaFlag() {
        return tenshutsushaFlag;
    }

    /**
     * 転出者フラグのsetメソッドです。
     * 
     * @param tenshutsushaFlag 転出者フラグ
     */
    public void setTenshutsushaFlag(@Nonnull boolean tenshutsushaFlag) {
        this.tenshutsushaFlag = tenshutsushaFlag;
    }

    /**
     * 転入者フラグのgetメソッドです。
     * 
     * @return 転入者フラグ
     */
    public boolean getTennyushaFlag() {
        return tennyushaFlag;
    }

    /**
     * 転入者フラグのsetメソッドです。
     * 
     * @param tennyushaFlag 転入者フラグ
     */
    public void setTennyushaFlag(@Nonnull boolean tennyushaFlag) {
        this.tennyushaFlag = tennyushaFlag;
    }

    /**
     * 公民権停止者含フラグのgetメソッドです。
     * <br/>
     * <br/>true：公民権停止者を含める
     * 
     * @return 公民権停止者含フラグ
     */
    public boolean getTeishishaFukumuFlag() {
        return teishishaFukumuFlag;
    }

    /**
     * 公民権停止者含フラグのsetメソッドです。
     * <br/>
     * <br/>true：公民権停止者を含める
     * 
     * @param teishishaFukumuFlag 公民権停止者含フラグ
     */
    public void setTeishishaFukumuFlag(@Nonnull boolean teishishaFukumuFlag) {
        this.teishishaFukumuFlag = teishishaFukumuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT141ZaisankuJuminTohyoConditionEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT141ZaisankuJuminTohyoConditionEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT141ZaisankuJuminTohyoConditionEntity other) {
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
    public void shallowCopy(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.nenreiKeisanKijunYMD = entity.nenreiKeisanKijunYMD;
        this.nenrei = entity.nenrei;
        this.birthdayFukumuFlag = entity.birthdayFukumuFlag;
        this.kyojuNensu = entity.kyojuNensu;
        this.juteiFirstYMD = entity.juteiFirstYMD;
        this.juteiLastYMD = entity.juteiLastYMD;
        this.japaneseFlag = entity.japaneseFlag;
        this.foreignerFlag = entity.foreignerFlag;
        this.juminFlag = entity.juminFlag;
        this.tenshutsushaFlag = entity.tenshutsushaFlag;
        this.tennyushaFlag = entity.tennyushaFlag;
        this.teishishaFukumuFlag = entity.teishishaFukumuFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, nenreiKeisanKijunYMD, nenrei, birthdayFukumuFlag, kyojuNensu, juteiFirstYMD, juteiLastYMD, japaneseFlag, foreignerFlag, juminFlag, tenshutsushaFlag, tennyushaFlag, teishishaFukumuFlag);
    }

// </editor-fold>

}
