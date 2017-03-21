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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 期日前投票録、当日投票録の情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT204TohyorokuEntity extends DbTableEntityBase<AfT204TohyorokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("AfT204Tohyoroku");

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
    private RString secchiJokyo;
    private RString kaisetsuBasho;
    private FlexibleDate secchiFirstYMD;
    private FlexibleDate secchiLastYMD;
    private RTime kaiheiStartTime;
    private RTime kaiheiStopTime;
    private int shokiNinzu;
    private int shokuinNinzu;
    private int sonotaNinzu;

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
     * <br/>
     * <br/>期日前投票日や投票日当日をセット。
     * 
     * @return 報告年月日
     */
    public FlexibleDate getHokokuYMD() {
        return hokokuYMD;
    }

    /**
     * 報告年月日のsetメソッドです。
     * <br/>
     * <br/>期日前投票日や投票日当日をセット。
     * 
     * @param hokokuYMD 報告年月日
     */
    public void setHokokuYMD(@Nonnull FlexibleDate hokokuYMD) {
        this.hokokuYMD = hokokuYMD;
    }

    /**
     * 施設コードのgetメソッドです。
     * <br/>
     * <br/>期日前投票録の時、施設コードをセットする。 当日投票録のとき、ALL0をセットする。
     * 
     * @return 施設コード
     */
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    /**
     * 施設コードのsetメソッドです。
     * <br/>
     * <br/>期日前投票録の時、施設コードをセットする。 当日投票録のとき、ALL0をセットする。
     * 
     * @param shisetsuCode 施設コード
     */
    public void setShisetsuCode(@Nonnull RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * 投票区コードのgetメソッドです。
     * <br/>
     * <br/>期日前投票録の時、ALL0をセットする。 当日投票録の時、投票区コードをセットする。
     * 
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * 投票区コードのsetメソッドです。
     * <br/>
     * <br/>期日前投票録の時、ALL0をセットする。 当日投票録の時、投票区コードをセットする。
     * 
     * @param tohyokuCode 投票区コード
     */
    public void setTohyokuCode(@Nonnull RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * 投票所設置状況のgetメソッドです。
     * 
     * @return 投票所設置状況
     */
    @CheckForNull
    public RString getSecchiJokyo() {
        return secchiJokyo;
    }

    /**
     * 投票所設置状況のsetメソッドです。
     * 
     * @param secchiJokyo 投票所設置状況
     */
    public void setSecchiJokyo(RString secchiJokyo) {
        this.secchiJokyo = secchiJokyo;
    }

    /**
     * 投票所開設場所のgetメソッドです。
     * 
     * @return 投票所開設場所
     */
    @CheckForNull
    public RString getKaisetsuBasho() {
        return kaisetsuBasho;
    }

    /**
     * 投票所開設場所のsetメソッドです。
     * 
     * @param kaisetsuBasho 投票所開設場所
     */
    public void setKaisetsuBasho(RString kaisetsuBasho) {
        this.kaisetsuBasho = kaisetsuBasho;
    }

    /**
     * 設置期間（開始年月日）のgetメソッドです。
     * 
     * @return 設置期間（開始年月日）
     */
    @CheckForNull
    public FlexibleDate getSecchiFirstYMD() {
        return secchiFirstYMD;
    }

    /**
     * 設置期間（開始年月日）のsetメソッドです。
     * 
     * @param secchiFirstYMD 設置期間（開始年月日）
     */
    public void setSecchiFirstYMD(FlexibleDate secchiFirstYMD) {
        this.secchiFirstYMD = secchiFirstYMD;
    }

    /**
     * 設置期間（終了年月日）のgetメソッドです。
     * 
     * @return 設置期間（終了年月日）
     */
    @CheckForNull
    public FlexibleDate getSecchiLastYMD() {
        return secchiLastYMD;
    }

    /**
     * 設置期間（終了年月日）のsetメソッドです。
     * 
     * @param secchiLastYMD 設置期間（終了年月日）
     */
    public void setSecchiLastYMD(FlexibleDate secchiLastYMD) {
        this.secchiLastYMD = secchiLastYMD;
    }

    /**
     * 開閉時刻（開始）のgetメソッドです。
     * 
     * @return 開閉時刻（開始）
     */
    @CheckForNull
    public RTime getKaiheiStartTime() {
        return kaiheiStartTime;
    }

    /**
     * 開閉時刻（開始）のsetメソッドです。
     * 
     * @param kaiheiStartTime 開閉時刻（開始）
     */
    public void setKaiheiStartTime(RTime kaiheiStartTime) {
        this.kaiheiStartTime = kaiheiStartTime;
    }

    /**
     * 開閉時刻（終了）のgetメソッドです。
     * 
     * @return 開閉時刻（終了）
     */
    @CheckForNull
    public RTime getKaiheiStopTime() {
        return kaiheiStopTime;
    }

    /**
     * 開閉時刻（終了）のsetメソッドです。
     * 
     * @param kaiheiStopTime 開閉時刻（終了）
     */
    public void setKaiheiStopTime(RTime kaiheiStopTime) {
        this.kaiheiStopTime = kaiheiStopTime;
    }

    /**
     * 選管書記人数のgetメソッドです。
     * 
     * @return 選管書記人数
     */
    @CheckForNull
    public int getShokiNinzu() {
        return shokiNinzu;
    }

    /**
     * 選管書記人数のsetメソッドです。
     * 
     * @param shokiNinzu 選管書記人数
     */
    public void setShokiNinzu(int shokiNinzu) {
        this.shokiNinzu = shokiNinzu;
    }

    /**
     * 職員人数のgetメソッドです。
     * 
     * @return 職員人数
     */
    @CheckForNull
    public int getShokuinNinzu() {
        return shokuinNinzu;
    }

    /**
     * 職員人数のsetメソッドです。
     * 
     * @param shokuinNinzu 職員人数
     */
    public void setShokuinNinzu(int shokuinNinzu) {
        this.shokuinNinzu = shokuinNinzu;
    }

    /**
     * sonotaNinzuのgetメソッドです。
     * 
     * @return sonotaNinzu
     */
    @CheckForNull
    public int getSonotaNinzu() {
        return sonotaNinzu;
    }

    /**
     * sonotaNinzuのsetメソッドです。
     * 
     * @param sonotaNinzu sonotaNinzu
     */
    public void setSonotaNinzu(int sonotaNinzu) {
        this.sonotaNinzu = sonotaNinzu;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT204TohyorokuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal AfT204TohyorokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT204TohyorokuEntity other) {
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT204TohyorokuEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.senkyoNo = entity.senkyoNo;
        this.hokokuYMD = entity.hokokuYMD;
        this.shisetsuCode = entity.shisetsuCode;
        this.tohyokuCode = entity.tohyokuCode;
        this.secchiJokyo = entity.secchiJokyo;
        this.kaisetsuBasho = entity.kaisetsuBasho;
        this.secchiFirstYMD = entity.secchiFirstYMD;
        this.secchiLastYMD = entity.secchiLastYMD;
        this.kaiheiStartTime = entity.kaiheiStartTime;
        this.kaiheiStopTime = entity.kaiheiStopTime;
        this.shokiNinzu = entity.shokiNinzu;
        this.shokuinNinzu = entity.shokuinNinzu;
        this.sonotaNinzu = entity.sonotaNinzu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, senkyoNo, hokokuYMD, shisetsuCode, tohyokuCode, secchiJokyo, kaisetsuBasho, secchiFirstYMD, secchiLastYMD, kaiheiStartTime, kaiheiStopTime, shokiNinzu, shokuinNinzu, sonotaNinzu);
    }

// </editor-fold>

}
