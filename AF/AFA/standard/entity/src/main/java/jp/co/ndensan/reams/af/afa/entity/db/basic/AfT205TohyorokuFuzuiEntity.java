package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 投票録情報のうち、複数人数登録できるような項目を保持する。 各項目種類により、入力できる部分が変わる。テーブルのエンティティクラスです。
 */
public class AfT205TohyorokuFuzuiEntity extends DbTableEntityBase<AfT205TohyorokuFuzuiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT205TohyorokuFuzui");

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
    @PrimaryKey
    private FlexibleDate hokokuYMD;
    @PrimaryKey
    private RString shisetsuCode;
    @PrimaryKey
    private RString tohyokuCode;
    @PrimaryKey
    private Code komokuShurui;
    @PrimaryKey
    private int renban;
    private RString toha;
    private AtenaMeisho shimei;
    private FlexibleDate sennninYMD;
    private RTime tachiaiStartTime;
    private RTime tachiaiStopTime;
    private RTime sankaiTime;
    private RTime jishokuTime;
    private RString jiyu;

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
     * 選挙番号のgetメソッドです。
     *
     * @return 選挙番号
     */
    public SenkyoNo getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * 選挙番号のsetメソッドです。
     *
     * @param senkyoNo 選挙番号
     */
    public void setSenkyoNo(@Nonnull SenkyoNo senkyoNo) {
        this.senkyoNo = senkyoNo;
    }

    /**
     * 報告年月日のgetメソッドです。
     *
     * @return 報告年月日
     */
    public FlexibleDate getHokokuYMD() {
        return hokokuYMD;
    }

    /**
     * 報告年月日のsetメソッドです。
     *
     * @param hokokuYMD 報告年月日
     */
    public void setHokokuYMD(@Nonnull FlexibleDate hokokuYMD) {
        this.hokokuYMD = hokokuYMD;
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
     * 投票録項目種類のgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 投票立会人（投票管理者） 再交付者 決定書・判決書 用紙返還
     *
     * @return 投票録項目種類
     */
    public Code getKomokuShurui() {
        return komokuShurui;
    }

    /**
     * 投票録項目種類のsetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 投票立会人（投票管理者） 再交付者 決定書・判決書 用紙返還
     *
     * @param komokuShurui 投票録項目種類
     */
    public void setKomokuShurui(@Nonnull Code komokuShurui) {
        this.komokuShurui = komokuShurui;
    }

    /**
     * 投票録項目種類の名称のgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 投票立会人（投票管理者） 再交付者 決定書・判決書 用紙返還
     *
     * @return 投票録項目種類の名称
     */
    public RString getKomokuShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), komokuShurui);
    }

    /**
     * 投票録項目種類の略称のgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 投票立会人（投票管理者） 再交付者 決定書・判決書 用紙返還
     *
     * @return 投票録項目種類の略称
     */
    public RString getKomokuShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), komokuShurui);
    }

    /**
     * 投票録項目種類のDescriptionのgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 投票立会人（投票管理者） 再交付者 決定書・判決書 用紙返還
     *
     * @return 投票録項目種類のDescription
     */
    public RString getKomokuShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), komokuShurui);
    }

    /**
     * 連番のgetメソッドです。
     * <br/>
     * <br/>各投票録項目種類毎に連番。max値は帳票レイアウトによる。
     *
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * <br/>
     * <br/>各投票録項目種類毎に連番。max値は帳票レイアウトによる。
     *
     * @param renban 連番
     */
    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
    }

    /**
     * 党派のgetメソッドです。
     *
     * @return 党派
     */
    @CheckForNull
    public RString getToha() {
        return toha;
    }

    /**
     * 党派のsetメソッドです。
     *
     * @param toha 党派
     */
    public void setToha(RString toha) {
        this.toha = toha;
    }

    /**
     * 氏名のgetメソッドです。
     *
     * @return 氏名
     */
    @CheckForNull
    public AtenaMeisho getShimei() {
        return shimei;
    }

    /**
     * 氏名のsetメソッドです。
     *
     * @param shimei 氏名
     */
    public void setShimei(AtenaMeisho shimei) {
        this.shimei = shimei;
    }

    /**
     * 選任年月日のgetメソッドです。
     *
     * @return 選任年月日
     */
    @CheckForNull
    public FlexibleDate getSennninYMD() {
        return sennninYMD;
    }

    /**
     * 選任年月日のsetメソッドです。
     *
     * @param sennninYMD 選任年月日
     */
    public void setSennninYMD(FlexibleDate sennninYMD) {
        this.sennninYMD = sennninYMD;
    }

    /**
     * 立会時間（開始時刻）のgetメソッドです。
     *
     * @return 立会時間（開始時刻）
     */
    @CheckForNull
    public RTime getTachiaiStartTime() {
        return tachiaiStartTime;
    }

    /**
     * 立会時間（開始時刻）のsetメソッドです。
     *
     * @param tachiaiStartTime 立会時間（開始時刻）
     */
    public void setTachiaiStartTime(RTime tachiaiStartTime) {
        this.tachiaiStartTime = tachiaiStartTime;
    }

    /**
     * 立会時間（終了時刻）のgetメソッドです。
     *
     * @return 立会時間（終了時刻）
     */
    @CheckForNull
    public RTime getTachiaiStopTime() {
        return tachiaiStopTime;
    }

    /**
     * 立会時間（終了時刻）のsetメソッドです。
     *
     * @param tachiaiStopTime 立会時間（終了時刻）
     */
    public void setTachiaiStopTime(RTime tachiaiStopTime) {
        this.tachiaiStopTime = tachiaiStopTime;
    }

    /**
     * 参会時刻のgetメソッドです。
     *
     * @return 参会時刻
     */
    @CheckForNull
    public RTime getSankaiTime() {
        return sankaiTime;
    }

    /**
     * 参会時刻のsetメソッドです。
     *
     * @param sankaiTime 参会時刻
     */
    public void setSankaiTime(RTime sankaiTime) {
        this.sankaiTime = sankaiTime;
    }

    /**
     * 辞職時刻のgetメソッドです。
     *
     * @return 辞職時刻
     */
    @CheckForNull
    public RTime getJishokuTime() {
        return jishokuTime;
    }

    /**
     * 辞職時刻のsetメソッドです。
     *
     * @param jishokuTime 辞職時刻
     */
    public void setJishokuTime(RTime jishokuTime) {
        this.jishokuTime = jishokuTime;
    }

    /**
     * 事由のgetメソッドです。
     * <br/>
     * <br/>辞職事由、再交付事由、拒否事由
     *
     * @return 事由
     */
    @CheckForNull
    public RString getJiyu() {
        return jiyu;
    }

    /**
     * 事由のsetメソッドです。
     * <br/>
     * <br/>辞職事由、再交付事由、拒否事由
     *
     * @param jiyu 事由
     */
    public void setJiyu(RString jiyu) {
        this.jiyu = jiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT205TohyorokuFuzuiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT205TohyorokuFuzuiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT205TohyorokuFuzuiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.senkyoNo, other.senkyoNo)) {
            return false;
        }
        if (!Objects.equals(this.hokokuYMD, other.hokokuYMD)) {
            return false;
        }
        if (!Objects.equals(this.shisetsuCode, other.shisetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.tohyokuCode, other.tohyokuCode)) {
            return false;
        }
        if (!Objects.equals(this.komokuShurui, other.komokuShurui)) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT205TohyorokuFuzuiEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.senkyoNo = entity.senkyoNo;
        this.hokokuYMD = entity.hokokuYMD;
        this.shisetsuCode = entity.shisetsuCode;
        this.tohyokuCode = entity.tohyokuCode;
        this.komokuShurui = entity.komokuShurui;
        this.renban = entity.renban;
        this.toha = entity.toha;
        this.shimei = entity.shimei;
        this.sennninYMD = entity.sennninYMD;
        this.tachiaiStartTime = entity.tachiaiStartTime;
        this.tachiaiStopTime = entity.tachiaiStopTime;
        this.sankaiTime = entity.sankaiTime;
        this.jishokuTime = entity.jishokuTime;
        this.jiyu = entity.jiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, senkyoNo, hokokuYMD, shisetsuCode, tohyokuCode, komokuShurui, renban, toha, shimei, sennninYMD, tachiaiStartTime, tachiaiStopTime, sankaiTime, jishokuTime, jiyu);
    }

// </editor-fold>
}
