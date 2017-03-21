package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 選挙区と端末IDの関係を保持するテーブルのエンティティクラスです。
 */
public class AfT505SenkyokuTanmatsuKanriEntity extends DbTableEntityBase<AfT505SenkyokuTanmatsuKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT505SenkyokuTanmatsuKanri");

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
    private RString senkyokuCode;
    @PrimaryKey
    private RString tanmatsuID;

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
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙種類の略称のgetメソッドです。
     *
     * @return 選挙種類の略称
     */
    public RString getSenkyoShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙種類のDescriptionのgetメソッドです。
     *
     * @return 選挙種類のDescription
     */
    public RString getSenkyoShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙区コードのgetメソッドです。
     *
     * @return 選挙区コード
     */
    public RString getSenkyokuCode() {
        return senkyokuCode;
    }

    /**
     * 選挙区コードのsetメソッドです。
     *
     * @param senkyokuCode 選挙区コード
     */
    public void setSenkyokuCode(@Nonnull RString senkyokuCode) {
        this.senkyokuCode = senkyokuCode;
    }

    /**
     * 端末IDのgetメソッドです。
     *
     * @return 端末ID
     */
    public RString getTanmatsuID() {
        return tanmatsuID;
    }

    /**
     * 端末IDのsetメソッドです。
     *
     * @param tanmatsuID 端末ID
     */
    public void setTanmatsuID(@Nonnull RString tanmatsuID) {
        this.tanmatsuID = tanmatsuID;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT505SenkyokuTanmatsuKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT505SenkyokuTanmatsuKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT505SenkyokuTanmatsuKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.senkyoShurui, other.senkyoShurui)) {
            return false;
        }
        if (!Objects.equals(this.senkyokuCode, other.senkyokuCode)) {
            return false;
        }
        if (!Objects.equals(this.tanmatsuID, other.tanmatsuID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT505SenkyokuTanmatsuKanriEntity entity) {
        this.senkyoShurui = entity.senkyoShurui;
        this.senkyokuCode = entity.senkyokuCode;
        this.tanmatsuID = entity.tanmatsuID;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(senkyoShurui, senkyokuCode, tanmatsuID);
    }

// </editor-fold>
}
