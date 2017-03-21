package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 郵便、洋上、南極の各種資格を持つ選挙人情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT114FuzaishaTohyoShikakuEntity extends DbTableEntityBase<AfT114FuzaishaTohyoShikakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT114FuzaishaTohyoShikaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private Code tohyoShikakuShurui;
    @PrimaryKey
    private BigSerial seq;
    private FlexibleDate kofuYMD;
    private RString kofuNo;
    private FlexibleDate shikakuTorokuYMD;
    private FlexibleDate shikakuManryoYMD;
    private FlexibleDate shikakuMasshoYMD;
    private Code shikakuMasshoJiyuCode;

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
     * 投票資格種類のgetメソッドです。
     * <br/>
     * <br/>1：郵便投票資格、2：洋上投票資格、3：南極投票資格
     *
     * @return 投票資格種類
     */
    public Code getTohyoShikakuShurui() {
        return tohyoShikakuShurui;
    }

    /**
     * 投票資格種類のsetメソッドです。
     * <br/>
     * <br/>1：郵便投票資格、2：洋上投票資格、3：南極投票資格
     *
     * @param tohyoShikakuShurui 投票資格種類
     */
    public void setTohyoShikakuShurui(@Nonnull Code tohyoShikakuShurui) {
        this.tohyoShikakuShurui = tohyoShikakuShurui;
    }

    /**
     * 投票資格種類の名称のgetメソッドです。
     * <br/>
     * <br/>1：郵便投票資格、2：洋上投票資格、3：南極投票資格
     *
     * @return 投票資格種類の名称
     */
    public RString getTohyoShikakuShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票資格種類.getCodeShubetsu(), tohyoShikakuShurui);
    }

    /**
     * 投票資格種類の略称のgetメソッドです。
     * <br/>
     * <br/>1：郵便投票資格、2：洋上投票資格、3：南極投票資格
     *
     * @return 投票資格種類の略称
     */
    public RString getTohyoShikakuShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票資格種類.getCodeShubetsu(), tohyoShikakuShurui);
    }

    /**
     * 投票資格種類のDescriptionのgetメソッドです。
     * <br/>
     * <br/>1：郵便投票資格、2：洋上投票資格、3：南極投票資格
     *
     * @return 投票資格種類のDescription
     */
    public RString getTohyoShikakuShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票資格種類.getCodeShubetsu(), tohyoShikakuShurui);
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
     * <br/>
     * <br/>履歴番号
     *
     * @param seq 履歴番号
     */
    public void setSeq(BigSerial seq) {
        this.seq = seq;
    }

    /**
     * 交付年月日のgetメソッドです。
     * <br/>
     * <br/>各投票資格証明書を交付した日
     *
     * @return 交付年月日
     */
    @CheckForNull
    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    /**
     * 交付年月日のsetメソッドです。
     * <br/>
     * <br/>各投票資格証明書を交付した日
     *
     * @param kofuYMD 交付年月日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    /**
     * 交付番号のgetメソッドです。
     * <br/>
     * <br/>郵便投票資格のみ
     *
     * @return 交付番号
     */
    @CheckForNull
    public RString getKofuNo() {
        return kofuNo;
    }

    /**
     * 交付番号のsetメソッドです。
     * <br/>
     * <br/>郵便投票資格のみ
     *
     * @param kofuNo 交付番号
     */
    public void setKofuNo(RString kofuNo) {
        this.kofuNo = kofuNo;
    }

    /**
     * 資格登録年月日のgetメソッドです。
     *
     * @return 資格登録年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuTorokuYMD() {
        return shikakuTorokuYMD;
    }

    /**
     * 資格登録年月日のsetメソッドです。
     *
     * @param shikakuTorokuYMD 資格登録年月日
     */
    public void setShikakuTorokuYMD(FlexibleDate shikakuTorokuYMD) {
        this.shikakuTorokuYMD = shikakuTorokuYMD;
    }

    /**
     * 資格満了年月日のgetメソッドです。
     * <br/>
     * <br/>郵便投票：交付日＋7年 洋上投票：交付日＋7年 南極投票：南極調査機関の満了の日まで
     *
     * @return 資格満了年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuManryoYMD() {
        return shikakuManryoYMD;
    }

    /**
     * 資格満了年月日のsetメソッドです。
     * <br/>
     * <br/>郵便投票：交付日＋7年 洋上投票：交付日＋7年 南極投票：南極調査機関の満了の日まで
     *
     * @param shikakuManryoYMD 資格満了年月日
     */
    public void setShikakuManryoYMD(FlexibleDate shikakuManryoYMD) {
        this.shikakuManryoYMD = shikakuManryoYMD;
    }

    /**
     * 資格抹消年月日のgetメソッドです。
     *
     * @return 資格抹消年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuMasshoYMD() {
        return shikakuMasshoYMD;
    }

    /**
     * 資格抹消年月日のsetメソッドです。
     *
     * @param shikakuMasshoYMD 資格抹消年月日
     */
    public void setShikakuMasshoYMD(FlexibleDate shikakuMasshoYMD) {
        this.shikakuMasshoYMD = shikakuMasshoYMD;
    }

    /**
     * 資格抹消事由コードのgetメソッドです。
     *
     * @return 資格抹消事由コード
     */
    @CheckForNull
    public Code getShikakuMasshoJiyuCode() {
        return shikakuMasshoJiyuCode;
    }

    /**
     * 資格抹消事由コードのsetメソッドです。
     *
     * @param shikakuMasshoJiyuCode 資格抹消事由コード
     */
    public void setShikakuMasshoJiyuCode(Code shikakuMasshoJiyuCode) {
        this.shikakuMasshoJiyuCode = shikakuMasshoJiyuCode;
    }

    /**
     * 資格抹消事由コードの名称のgetメソッドです。
     *
     * @return 資格抹消事由コードの名称
     */
    public RString getShikakuMasshoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu(), shikakuMasshoJiyuCode);
    }

    /**
     * 資格抹消事由コードの略称のgetメソッドです。
     *
     * @return 資格抹消事由コードの略称
     */
    public RString getShikakuMasshoJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu(), shikakuMasshoJiyuCode);
    }

    /**
     * 資格抹消事由コードのDescriptionのgetメソッドです。
     *
     * @return 資格抹消事由コードのDescription
     */
    public RString getShikakuMasshoJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu(), shikakuMasshoJiyuCode);
    }

    /**
     * このエンティティの主キーが他の{@literal AfT114FuzaishaTohyoShikakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT114FuzaishaTohyoShikakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT114FuzaishaTohyoShikakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.tohyoShikakuShurui, other.tohyoShikakuShurui)) {
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
    public void shallowCopy(AfT114FuzaishaTohyoShikakuEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.tohyoShikakuShurui = entity.tohyoShikakuShurui;
        this.seq = entity.seq;
        this.kofuYMD = entity.kofuYMD;
        this.kofuNo = entity.kofuNo;
        this.shikakuTorokuYMD = entity.shikakuTorokuYMD;
        this.shikakuManryoYMD = entity.shikakuManryoYMD;
        this.shikakuMasshoYMD = entity.shikakuMasshoYMD;
        this.shikakuMasshoJiyuCode = entity.shikakuMasshoJiyuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, tohyoShikakuShurui, seq, kofuYMD, kofuNo, shikakuTorokuYMD, shikakuManryoYMD, shikakuMasshoYMD, shikakuMasshoJiyuCode);
    }

//    /**
//     *
//     * @param 履歴番号
//     */
//    public void setSeq(BigSerial 履歴番号) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
