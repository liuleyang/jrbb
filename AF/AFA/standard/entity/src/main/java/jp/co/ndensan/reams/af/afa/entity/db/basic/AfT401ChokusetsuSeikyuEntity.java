package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 直接請求の内容、期限日等を保持するテーブルのエンティティクラスです。
 */
public class AfT401ChokusetsuSeikyuEntity extends DbTableEntityBase<AfT401ChokusetsuSeikyuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT401ChokusetsuSeikyu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int seikyuNo;
    private FlexibleDate seikyuYMD;
    private RString seikyuMei;
    private RString seikyuNaiyo;
    private FlexibleDate kofuYMD;
    private FlexibleDate teishutsuKigenYMD;
    private Code kofuSoshikiCode;
    private boolean torokuZumiFlag;
    private ShohonNo shohonNo;

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
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return seikyuNo;
    }

    /**
     * 直接請求番号のsetメソッドです。
     *
     * @param seikyuNo 直接請求番号
     */
    public void setSeikyuNo(@Nonnull int seikyuNo) {
        this.seikyuNo = seikyuNo;
    }

    /**
     * 請求年月日のgetメソッドです。
     *
     * @return 請求年月日
     */
    public FlexibleDate getSeikyuYMD() {
        return seikyuYMD;
    }

    /**
     * 請求年月日のsetメソッドです。
     *
     * @param seikyuYMD 請求年月日
     */
    public void setSeikyuYMD(@Nonnull FlexibleDate seikyuYMD) {
        this.seikyuYMD = seikyuYMD;
    }

    /**
     * 請求名のgetメソッドです。
     *
     * @return 請求名
     */
    @CheckForNull
    public RString getSeikyuMei() {
        return seikyuMei;
    }

    /**
     * 請求名のsetメソッドです。
     *
     * @param seikyuMei 請求名
     */
    public void setSeikyuMei(RString seikyuMei) {
        this.seikyuMei = seikyuMei;
    }

    /**
     * 請求内容のgetメソッドです。
     *
     * @return 請求内容
     */
    @CheckForNull
    public RString getSeikyuNaiyo() {
        return seikyuNaiyo;
    }

    /**
     * 請求内容のsetメソッドです。
     *
     * @param seikyuNaiyo 請求内容
     */
    public void setSeikyuNaiyo(RString seikyuNaiyo) {
        this.seikyuNaiyo = seikyuNaiyo;
    }

    /**
     * 交付年月日のgetメソッドです。
     *
     * @return 交付年月日
     */
    @CheckForNull
    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    /**
     * 交付年月日のsetメソッドです。
     *
     * @param kofuYMD 交付年月日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    /**
     * 提出期限年月日のgetメソッドです。
     *
     * @return 提出期限年月日
     */
    @CheckForNull
    public FlexibleDate getTeishutsuKigenYMD() {
        return teishutsuKigenYMD;
    }

    /**
     * 提出期限年月日のsetメソッドです。
     *
     * @param teishutsuKigenYMD 提出期限年月日
     */
    public void setTeishutsuKigenYMD(FlexibleDate teishutsuKigenYMD) {
        this.teishutsuKigenYMD = teishutsuKigenYMD;
    }

    /**
     * 交付組織コードのgetメソッドです。
     *
     * @return 交付組織コード
     */
    @CheckForNull
    public Code getKofuSoshikiCode() {
        return kofuSoshikiCode;
    }

    /**
     * 交付組織コードのsetメソッドです。
     *
     * @param kofuSoshikiCode 交付組織コード
     */
    public void setKofuSoshikiCode(Code kofuSoshikiCode) {
        this.kofuSoshikiCode = kofuSoshikiCode;
    }

    /**
     * 交付組織コードの名称のgetメソッドです。
     *
     * @return 交付組織コードの名称
     */
    public RString getKofuSoshikiCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付組織コード.getCodeShubetsu(), kofuSoshikiCode);
    }

    /**
     * 交付組織コードの略称のgetメソッドです。
     *
     * @return 交付組織コードの略称
     */
    public RString getKofuSoshikiCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付組織コード.getCodeShubetsu(), kofuSoshikiCode);
    }

    /**
     * 交付組織コードのDescriptionのgetメソッドです。
     *
     * @return 交付組織コードのDescription
     */
    public RString getKofuSoshikiCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付組織コード.getCodeShubetsu(), kofuSoshikiCode);
    }

    /**
     * 署名簿登録済フラグのgetメソッドです。
     * <br/>
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     *
     * @return 署名簿登録済フラグ
     */
    public boolean getTorokuZumiFlag() {
        return torokuZumiFlag;
    }

    /**
     * 署名簿登録済フラグのsetメソッドです。
     * <br/>
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     *
     * @param torokuZumiFlag 署名簿登録済フラグ
     */
    public void setTorokuZumiFlag(@Nonnull boolean torokuZumiFlag) {
        this.torokuZumiFlag = torokuZumiFlag;
    }

    /**
     * 抄本番号のgetメソッドです。
     * <br/>
     * <br/>チェックの基準とする抄本番号を設定する
     *
     * @return 抄本番号
     */
    @CheckForNull
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 抄本番号のsetメソッドです。
     * <br/>
     * <br/>チェックの基準とする抄本番号を設定する
     *
     * @param shohonNo 抄本番号
     */
    public void setShohonNo(ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT401ChokusetsuSeikyuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT401ChokusetsuSeikyuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT401ChokusetsuSeikyuEntity other) {
        if (other == null) {
            return false;
        }
        if (this.seikyuNo != other.seikyuNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT401ChokusetsuSeikyuEntity entity) {
        this.seikyuNo = entity.seikyuNo;
        this.seikyuYMD = entity.seikyuYMD;
        this.seikyuMei = entity.seikyuMei;
        this.seikyuNaiyo = entity.seikyuNaiyo;
        this.kofuYMD = entity.kofuYMD;
        this.teishutsuKigenYMD = entity.teishutsuKigenYMD;
        this.kofuSoshikiCode = entity.kofuSoshikiCode;
        this.torokuZumiFlag = entity.torokuZumiFlag;
        this.shohonNo = entity.shohonNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(seikyuNo, seikyuYMD, seikyuMei, seikyuNaiyo, kofuYMD, teishutsuKigenYMD, kofuSoshikiCode, torokuZumiFlag, shohonNo);
    }

// </editor-fold>
}
