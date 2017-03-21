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
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 定時、国政、地方選挙以外の選挙種類別に投票区情報を保持する。 定時、国政、地方選挙は、URの投票区を使用する。テーブルのエンティティクラスです。
 */
public class AfT501TohyokuEntity extends DbTableEntityBase<AfT501TohyokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT501Tohyoku");

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
    private RString tohyokuCode;
    private RString tohyokuName;
    private RString kanaTohyokuName;
    private RString searchKanaTohyokuName;
    private int hyojijun;

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
     * 投票区名のgetメソッドです。
     * <br/>
     * <br/>通常選挙時：UR投票区から取得、修正不可。 その他：自テーブルから取得、修正可能。
     *
     * @return 投票区名
     */
    @CheckForNull
    public RString getTohyokuName() {
        return tohyokuName;
    }

    /**
     * 投票区名のsetメソッドです。
     * <br/>
     * <br/>通常選挙時：UR投票区から取得、修正不可。 その他：自テーブルから取得、修正可能。
     *
     * @param tohyokuName 投票区名
     */
    public void setTohyokuName(RString tohyokuName) {
        this.tohyokuName = tohyokuName;
    }

    /**
     * カナ投票区名のgetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @return カナ投票区名
     */
    @CheckForNull
    public RString getKanaTohyokuName() {
        return kanaTohyokuName;
    }

    /**
     * カナ投票区名のsetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @param kanaTohyokuName カナ投票区名
     */
    public void setKanaTohyokuName(RString kanaTohyokuName) {
        this.kanaTohyokuName = kanaTohyokuName;
    }

    /**
     * 検索用カナ投票区名のgetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @return 検索用カナ投票区名
     */
    @CheckForNull
    public RString getSearchKanaTohyokuName() {
        return searchKanaTohyokuName;
    }

    /**
     * 検索用カナ投票区名のsetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @param searchKanaTohyokuName 検索用カナ投票区名
     */
    public void setSearchKanaTohyokuName(RString searchKanaTohyokuName) {
        this.searchKanaTohyokuName = searchKanaTohyokuName;
    }

    /**
     * 表示順のgetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @return 表示順
     */
    @CheckForNull
    public int getHyojijun() {
        return hyojijun;
    }

    /**
     * 表示順のsetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @param hyojijun 表示順
     */
    public void setHyojijun(int hyojijun) {
        this.hyojijun = hyojijun;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT501TohyokuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT501TohyokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT501TohyokuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.senkyoShurui, other.senkyoShurui)) {
            return false;
        }
        if (!Objects.equals(this.tohyokuCode, other.tohyokuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT501TohyokuEntity entity) {
        this.senkyoShurui = entity.senkyoShurui;
        this.tohyokuCode = entity.tohyokuCode;
        this.tohyokuName = entity.tohyokuName;
        this.kanaTohyokuName = entity.kanaTohyokuName;
        this.searchKanaTohyokuName = entity.searchKanaTohyokuName;
        this.hyojijun = entity.hyojijun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(senkyoShurui, tohyokuCode, tohyokuName, kanaTohyokuName, searchKanaTohyokuName, hyojijun);
    }

// </editor-fold>
}
