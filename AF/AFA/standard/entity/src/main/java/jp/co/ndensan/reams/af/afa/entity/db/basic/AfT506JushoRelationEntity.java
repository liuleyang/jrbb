package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 選挙種類別に、住所から自動設定される投票区コードの情報を保持する。
 * 通常選挙（定時、国政、地方）は、UR住所番地対応で対応する。テーブルのエンティティクラスです。
 */
public class AfT506JushoRelationEntity extends DbTableEntityBase<AfT506JushoRelationEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT506JushoRelation");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code senkyoShurui;
    @PrimaryKey
    private ChoikiCode choikiCode;
    @PrimaryKey
    private BanchiCode kaishiBanchi1BanchiCode;
    @PrimaryKey
    private BanchiCode kaishiBanchi2BanchiCode;
    @PrimaryKey
    private BanchiCode kaishiBanchi3BanchiCode;
    @PrimaryKey
    private BanchiCode kaishiBanchi4BanchiCode;
    private BanchiCode shuiryoBanchi1BanchiCode;
    private BanchiCode shuiryoBanchi2BanchiCode;
    private BanchiCode shuiryoBanchi3BanchiCode;
    private BanchiCode shuiryoBanchi4BanchiCode;
    private RString tohyokuCode;

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
     * 選挙種類のgetメソッドです。
     *
     * @return 選挙種類
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 選挙種類のsetメソッドです。
     *
     * @param senkyoShurui 選挙種類
     */
    public void setSenkyoShurui(@Nonnull Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 選挙種類の名称のgetメソッドです。
     *
     * @return 選挙種類の名称
     */
    public RString getSenkyoShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙種類の略称のgetメソッドです。
     *
     * @return 選挙種類の略称
     */
    public RString getSenkyoShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙種類のDescriptionのgetメソッドです。
     *
     * @return 選挙種類のDescription
     */
    public RString getSenkyoShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 町域コードのgetメソッドです。
     *
     * @return 町域コード
     */
    public ChoikiCode getChoikiCode() {
        return choikiCode;
    }

    /**
     * 町域コードのsetメソッドです。
     *
     * @param choikiCode 町域コード
     */
    public void setChoikiCode(@Nonnull ChoikiCode choikiCode) {
        this.choikiCode = choikiCode;
    }

    /**
     * 開始番地1のgetメソッドです。
     *
     * @return 開始番地1
     */
    public BanchiCode getKaishiBanchi1BanchiCode() {
        return kaishiBanchi1BanchiCode;
    }

    /**
     * 開始番地1のsetメソッドです。
     *
     * @param kaishiBanchi1BanchiCode 開始番地1
     */
    public void setKaishiBanchi1BanchiCode(@Nonnull BanchiCode kaishiBanchi1BanchiCode) {
        this.kaishiBanchi1BanchiCode = kaishiBanchi1BanchiCode;
    }

    /**
     * 開始番地2のgetメソッドです。
     *
     * @return 開始番地2
     */
    public BanchiCode getKaishiBanchi2BanchiCode() {
        return kaishiBanchi2BanchiCode;
    }

    /**
     * 開始番地2のsetメソッドです。
     *
     * @param kaishiBanchi2BanchiCode 開始番地2
     */
    public void setKaishiBanchi2BanchiCode(@Nonnull BanchiCode kaishiBanchi2BanchiCode) {
        this.kaishiBanchi2BanchiCode = kaishiBanchi2BanchiCode;
    }

    /**
     * 開始番地3のgetメソッドです。
     *
     * @return 開始番地3
     */
    public BanchiCode getKaishiBanchi3BanchiCode() {
        return kaishiBanchi3BanchiCode;
    }

    /**
     * 開始番地3のsetメソッドです。
     *
     * @param kaishiBanchi3BanchiCode 開始番地3
     */
    public void setKaishiBanchi3BanchiCode(@Nonnull BanchiCode kaishiBanchi3BanchiCode) {
        this.kaishiBanchi3BanchiCode = kaishiBanchi3BanchiCode;
    }

    /**
     * 開始番地4のgetメソッドです。
     *
     * @return 開始番地4
     */
    public BanchiCode getKaishiBanchi4BanchiCode() {
        return kaishiBanchi4BanchiCode;
    }

    /**
     * 開始番地4のsetメソッドです。
     *
     * @param kaishiBanchi4BanchiCode 開始番地4
     */
    public void setKaishiBanchi4BanchiCode(@Nonnull BanchiCode kaishiBanchi4BanchiCode) {
        this.kaishiBanchi4BanchiCode = kaishiBanchi4BanchiCode;
    }

    /**
     * 終了番地1のgetメソッドです。
     *
     * @return 終了番地1
     */
    public BanchiCode getShuiryoBanchi1BanchiCode() {
        return shuiryoBanchi1BanchiCode;
    }

    /**
     * 終了番地1のsetメソッドです。
     *
     * @param shuiryoBanchi1BanchiCode 終了番地1
     */
    public void setShuiryoBanchi1BanchiCode(@Nonnull BanchiCode shuiryoBanchi1BanchiCode) {
        this.shuiryoBanchi1BanchiCode = shuiryoBanchi1BanchiCode;
    }

    /**
     * 終了番地2のgetメソッドです。
     *
     * @return 終了番地2
     */
    public BanchiCode getShuiryoBanchi2BanchiCode() {
        return shuiryoBanchi2BanchiCode;
    }

    /**
     * 終了番地2のsetメソッドです。
     *
     * @param shuiryoBanchi2BanchiCode 終了番地2
     */
    public void setShuiryoBanchi2BanchiCode(@Nonnull BanchiCode shuiryoBanchi2BanchiCode) {
        this.shuiryoBanchi2BanchiCode = shuiryoBanchi2BanchiCode;
    }

    /**
     * 終了番地3のgetメソッドです。
     *
     * @return 終了番地3
     */
    public BanchiCode getShuiryoBanchi3BanchiCode() {
        return shuiryoBanchi3BanchiCode;
    }

    /**
     * 終了番地3のsetメソッドです。
     *
     * @param shuiryoBanchi3BanchiCode 終了番地3
     */
    public void setShuiryoBanchi3BanchiCode(@Nonnull BanchiCode shuiryoBanchi3BanchiCode) {
        this.shuiryoBanchi3BanchiCode = shuiryoBanchi3BanchiCode;
    }

    /**
     * 終了番地4のgetメソッドです。
     *
     * @return 終了番地4
     */
    public BanchiCode getShuiryoBanchi4BanchiCode() {
        return shuiryoBanchi4BanchiCode;
    }

    /**
     * 終了番地4のsetメソッドです。
     *
     * @param shuiryoBanchi4BanchiCode 終了番地4
     */
    public void setShuiryoBanchi4BanchiCode(@Nonnull BanchiCode shuiryoBanchi4BanchiCode) {
        this.shuiryoBanchi4BanchiCode = shuiryoBanchi4BanchiCode;
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
     * このエンティティの主キーが他の{@literal AfT506JushoRelationEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT506JushoRelationEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT506JushoRelationEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.senkyoShurui, other.senkyoShurui)) {
            return false;
        }
        if (!Objects.equals(this.choikiCode, other.choikiCode)) {
            return false;
        }
        if (!Objects.equals(this.kaishiBanchi1BanchiCode, other.kaishiBanchi1BanchiCode)) {
            return false;
        }
        if (!Objects.equals(this.kaishiBanchi2BanchiCode, other.kaishiBanchi2BanchiCode)) {
            return false;
        }
        if (!Objects.equals(this.kaishiBanchi3BanchiCode, other.kaishiBanchi3BanchiCode)) {
            return false;
        }
        if (!Objects.equals(this.kaishiBanchi4BanchiCode, other.kaishiBanchi4BanchiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT506JushoRelationEntity entity) {
        this.senkyoShurui = entity.senkyoShurui;
        this.choikiCode = entity.choikiCode;
        this.kaishiBanchi1BanchiCode = entity.kaishiBanchi1BanchiCode;
        this.kaishiBanchi2BanchiCode = entity.kaishiBanchi2BanchiCode;
        this.kaishiBanchi3BanchiCode = entity.kaishiBanchi3BanchiCode;
        this.kaishiBanchi4BanchiCode = entity.kaishiBanchi4BanchiCode;
        this.shuiryoBanchi1BanchiCode = entity.shuiryoBanchi1BanchiCode;
        this.shuiryoBanchi2BanchiCode = entity.shuiryoBanchi2BanchiCode;
        this.shuiryoBanchi3BanchiCode = entity.shuiryoBanchi3BanchiCode;
        this.shuiryoBanchi4BanchiCode = entity.shuiryoBanchi4BanchiCode;
        this.tohyokuCode = entity.tohyokuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(senkyoShurui, choikiCode, kaishiBanchi1BanchiCode, kaishiBanchi2BanchiCode, kaishiBanchi3BanchiCode, kaishiBanchi4BanchiCode, shuiryoBanchi1BanchiCode, shuiryoBanchi2BanchiCode, shuiryoBanchi3BanchiCode, shuiryoBanchi4BanchiCode, tohyokuCode);
    }

// </editor-fold>
}
