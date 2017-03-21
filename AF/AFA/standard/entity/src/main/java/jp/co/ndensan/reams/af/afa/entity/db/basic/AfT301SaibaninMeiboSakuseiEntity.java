package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;

/**
 * 名簿調整プログラムに渡すデータを作成するのに使用した抄本番号と、作成したデータの保存先等を年度別に保持する。
 * また、名簿調整プログラムで生成された裁判員候補者予定者名簿の情報を取り込んだかどうかの情報も保持する。テーブルのエンティティクラスです。
 */
public class AfT301SaibaninMeiboSakuseiEntity extends DbTableEntityBase<AfT301SaibaninMeiboSakuseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT301SaibaninMeiboSakusei");

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
    private ShohonNo shohonNo;
    private RString hozonSaki;
    private RString fileName;
    private boolean meiboTorikomiZumiFlag;

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
     * 抄本番号のgetメソッドです。
     * <br/>
     * <br/>基にした抄本番号
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 抄本番号のsetメソッドです。
     * <br/>
     * <br/>基にした抄本番号
     *
     * @param shohonNo 抄本番号
     */
    public void setShohonNo(@Nonnull ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * 有権者情報保存先のgetメソッドです。
     * <br/>
     * <br/>作成した裁判員候補者名簿の保存先
     *
     * @return 有権者情報保存先
     */
    @CheckForNull
    public RString getHozonSaki() {
        return hozonSaki;
    }

    /**
     * 有権者情報保存先のsetメソッドです。
     * <br/>
     * <br/>作成した裁判員候補者名簿の保存先
     *
     * @param hozonSaki 有権者情報保存先
     */
    public void setHozonSaki(RString hozonSaki) {
        this.hozonSaki = hozonSaki;
    }

    /**
     * 有権者情報ファイル名のgetメソッドです。
     * <br/>
     * <br/>作成した裁判員候補者名簿のファイル名
     *
     * @return 有権者情報ファイル名
     */
    @CheckForNull
    public RString getFileName() {
        return fileName;
    }

    /**
     * 有権者情報ファイル名のsetメソッドです。
     * <br/>
     * <br/>作成した裁判員候補者名簿のファイル名
     *
     * @param fileName 有権者情報ファイル名
     */
    public void setFileName(RString fileName) {
        this.fileName = fileName;
    }

    /**
     * 予定者名簿取込済フラグのgetメソッドです。
     * <br/>
     * <br/>抽選結果の裁判員候補者予定者名簿を取込みしたらTrue
     *
     * @return 予定者名簿取込済フラグ
     */
    public boolean getMeiboTorikomiZumiFlag() {
        return meiboTorikomiZumiFlag;
    }

    /**
     * 予定者名簿取込済フラグのsetメソッドです。
     * <br/>
     * <br/>抽選結果の裁判員候補者予定者名簿を取込みしたらTrue
     *
     * @param meiboTorikomiZumiFlag 予定者名簿取込済フラグ
     */
    public void setMeiboTorikomiZumiFlag(@Nonnull boolean meiboTorikomiZumiFlag) {
        this.meiboTorikomiZumiFlag = meiboTorikomiZumiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT301SaibaninMeiboSakuseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT301SaibaninMeiboSakuseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT301SaibaninMeiboSakuseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT301SaibaninMeiboSakuseiEntity entity) {
        this.nendo = entity.nendo;
        this.shohonNo = entity.shohonNo;
        this.hozonSaki = entity.hozonSaki;
        this.fileName = entity.fileName;
        this.meiboTorikomiZumiFlag = entity.meiboTorikomiZumiFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, shohonNo, hozonSaki, fileName, meiboTorikomiZumiFlag);
    }

// </editor-fold>
}
