package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 施設情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT507ShisetsuEntity extends DbTableEntityBase<AfT507ShisetsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT507Shisetsu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shisetsuCode;
    private Code shisetsuShubetsu;
    private RString shisetsuName;
    private RString kanaShisetsuName;
    private RString searchKanaShisetsuName;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private AtenaMeisho shisetsuAtena;
    private TelNo telNo;
    private TelNo faxNo;

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
     * 施設コードのgetメソッドです。
     *
     * @return 施設コード
     */
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    /**
     * 施設コードのsetメソッドです。
     *
     * @param shisetsuCode 施設コード
     */
    public void setShisetsuCode(@Nonnull RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * 施設種別のgetメソッドです。
     *
     * @return 施設種別
     */
    public Code getShisetsuShubetsu() {
        return shisetsuShubetsu;
    }

    /**
     * 施設種別のsetメソッドです。
     *
     * @param shisetsuShubetsu 施設種別
     */
    public void setShisetsuShubetsu(@Nonnull Code shisetsuShubetsu) {
        this.shisetsuShubetsu = shisetsuShubetsu;
    }

    /**
     * 施設種別の名称のgetメソッドです。
     *
     * @return 施設種別の名称
     */
    public RString getShisetsuShubetsuMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), shisetsuShubetsu);
    }

    /**
     * 施設種別の略称のgetメソッドです。
     *
     * @return 施設種別の略称
     */
    public RString getShisetsuShubetsuRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), shisetsuShubetsu);
    }

    /**
     * 施設種別のDescriptionのgetメソッドです。
     *
     * @return 施設種別のDescription
     */
    public RString getShisetsuShubetsuDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), shisetsuShubetsu);
    }

    /**
     * 施設名称のgetメソッドです。
     *
     * @return 施設名称
     */
    @CheckForNull
    public RString getShisetsuName() {
        return shisetsuName;
    }

    /**
     * 施設名称のsetメソッドです。
     *
     * @param shisetsuName 施設名称
     */
    public void setShisetsuName(RString shisetsuName) {
        this.shisetsuName = shisetsuName;
    }

    /**
     * カナ施設名称のgetメソッドです。
     *
     * @return カナ施設名称
     */
    @CheckForNull
    public RString getKanaShisetsuName() {
        return kanaShisetsuName;
    }

    /**
     * カナ施設名称のsetメソッドです。
     *
     * @param kanaShisetsuName カナ施設名称
     */
    public void setKanaShisetsuName(RString kanaShisetsuName) {
        this.kanaShisetsuName = kanaShisetsuName;
    }

    /**
     * 検索用カナ施設名称のgetメソッドです。
     *
     * @return 検索用カナ施設名称
     */
    @CheckForNull
    public RString getSearchKanaShisetsuName() {
        return searchKanaShisetsuName;
    }

    /**
     * 検索用カナ施設名称のsetメソッドです。
     *
     * @param searchKanaShisetsuName 検索用カナ施設名称
     */
    public void setSearchKanaShisetsuName(RString searchKanaShisetsuName) {
        this.searchKanaShisetsuName = searchKanaShisetsuName;
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
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * 施設宛名のgetメソッドです。
     *
     * @return 施設宛名
     */
    @CheckForNull
    public AtenaMeisho getShisetsuAtena() {
        return shisetsuAtena;
    }

    /**
     * 施設宛名のsetメソッドです。
     *
     * @param shisetsuAtena 施設宛名
     */
    public void setShisetsuAtena(AtenaMeisho shisetsuAtena) {
        this.shisetsuAtena = shisetsuAtena;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     *
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * FAX番号のgetメソッドです。
     *
     * @return FAX番号
     */
    @CheckForNull
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     *
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT507ShisetsuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT507ShisetsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT507ShisetsuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shisetsuCode, other.shisetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT507ShisetsuEntity entity) {
        this.shisetsuCode = entity.shisetsuCode;
        this.shisetsuShubetsu = entity.shisetsuShubetsu;
        this.shisetsuName = entity.shisetsuName;
        this.kanaShisetsuName = entity.kanaShisetsuName;
        this.searchKanaShisetsuName = entity.searchKanaShisetsuName;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.shisetsuAtena = entity.shisetsuAtena;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shisetsuCode, shisetsuShubetsu, shisetsuName, kanaShisetsuName, searchKanaShisetsuName, yubinNo, jusho, shisetsuAtena, telNo, faxNo);
    }

// </editor-fold>
}
