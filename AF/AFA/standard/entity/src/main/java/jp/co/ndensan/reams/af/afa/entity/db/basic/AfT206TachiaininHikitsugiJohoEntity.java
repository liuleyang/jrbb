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
 * 立会人引継情報を保持する。 投票録作成時（新規登録時）には、この立会人引継情報を集約した情報を初期表示として使用する。テーブルのエンティティクラスです。
 */
public class AfT206TachiaininHikitsugiJohoEntity extends DbTableEntityBase<AfT206TachiaininHikitsugiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT206TachiaininHikitsugiJoho");

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
    private int tachiaininRenban;
    @PrimaryKey
    private Code komokuShurui;
    @PrimaryKey
    private int renban;
    private AtenaMeisho shimei;
    private RString toha;
    private RTime tachiaiStartTime;
    private RTime tachiaiStopTime;
    private boolean ijoAriFlag;
    private RString ijoNaiyo;

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
     * 立会人連番のgetメソッドです。
     * <br/>
     * <br/>立会人の党派と氏名をキーとしたいが修正できなくなるので、その代替キー。1からの意味のない連番で構わない。
     *
     * @return 立会人連番
     */
    public int getTachiaininRenban() {
        return tachiaininRenban;
    }

    /**
     * 立会人連番のsetメソッドです。
     * <br/>
     * <br/>立会人の党派と氏名をキーとしたいが修正できなくなるので、その代替キー。1からの意味のない連番で構わない。
     *
     * @param tachiaininRenban 立会人連番
     */
    public void setTachiaininRenban(@Nonnull int tachiaininRenban) {
        this.tachiaininRenban = tachiaininRenban;
    }

    /**
     * 投票録項目種類のgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 再交付者 決定書・判決書
     *
     * @return 投票録項目種類
     */
    public Code getKomokuShurui() {
        return komokuShurui;
    }

    /**
     * 投票録項目種類のsetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 再交付者 決定書・判決書
     *
     * @param komokuShurui 投票録項目種類
     */
    public void setKomokuShurui(@Nonnull Code komokuShurui) {
        this.komokuShurui = komokuShurui;
    }

    /**
     * 投票録項目種類の名称のgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 再交付者 決定書・判決書
     *
     * @return 投票録項目種類の名称
     */
    public RString getKomokuShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), komokuShurui);
    }

    /**
     * 投票録項目種類の略称のgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 再交付者 決定書・判決書
     *
     * @return 投票録項目種類の略称
     */
    public RString getKomokuShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), komokuShurui);
    }

    /**
     * 投票録項目種類のDescriptionのgetメソッドです。
     * <br/>
     * <br/>投票立会人（選管） 再交付者 決定書・判決書
     *
     * @return 投票録項目種類のDescription
     */
    public RString getKomokuShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), komokuShurui);
    }

    /**
     * 連番のgetメソッドです。
     * <br/>
     * <br/>投票録項目種類別の、対象者氏名別の連番。氏名の修正を考えたときの代替機ー。1からの意味のない連番でかまわない。
     *
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * <br/>
     * <br/>投票録項目種類別の、対象者氏名別の連番。氏名の修正を考えたときの代替機ー。1からの意味のない連番でかまわない。
     *
     * @param renban 連番
     */
    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
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
     * 立会時間（開始時刻）のgetメソッドです。
     *
     * @return 立会時間（開始時刻）
     */
    public RTime getTachiaiStartTime() {
        return tachiaiStartTime;
    }

    /**
     * 立会時間（開始時刻）のsetメソッドです。
     *
     * @param tachiaiStartTime 立会時間（開始時刻）
     */
    public void setTachiaiStartTime(@Nonnull RTime tachiaiStartTime) {
        this.tachiaiStartTime = tachiaiStartTime;
    }

    /**
     * 立会時間（終了時刻）のgetメソッドです。
     *
     * @return 立会時間（終了時刻）
     */
    public RTime getTachiaiStopTime() {
        return tachiaiStopTime;
    }

    /**
     * 立会時間（終了時刻）のsetメソッドです。
     *
     * @param tachiaiStopTime 立会時間（終了時刻）
     */
    public void setTachiaiStopTime(@Nonnull RTime tachiaiStopTime) {
        this.tachiaiStopTime = tachiaiStopTime;
    }

    /**
     * 異常有フラグのgetメソッドです。
     * <br/>
     * <br/>true：異常有り　false：異常なし
     *
     * @return 異常有フラグ
     */
    public boolean getIjoAriFlag() {
        return ijoAriFlag;
    }

    /**
     * 異常有フラグのsetメソッドです。
     * <br/>
     * <br/>true：異常有り　false：異常なし
     *
     * @param ijoAriFlag 異常有フラグ
     */
    public void setIjoAriFlag(@Nonnull boolean ijoAriFlag) {
        this.ijoAriFlag = ijoAriFlag;
    }

    /**
     * 異常内容のgetメソッドです。
     * <br/>
     * <br/>異常有りのとき、その異常内容を保持する
     *
     * @return 異常内容
     */
    @CheckForNull
    public RString getIjoNaiyo() {
        return ijoNaiyo;
    }

    /**
     * 異常内容のsetメソッドです。
     * <br/>
     * <br/>異常有りのとき、その異常内容を保持する
     *
     * @param ijoNaiyo 異常内容
     */
    public void setIjoNaiyo(RString ijoNaiyo) {
        this.ijoNaiyo = ijoNaiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT206TachiaininHikitsugiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT206TachiaininHikitsugiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT206TachiaininHikitsugiJohoEntity other) {
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
        if (this.tachiaininRenban != other.tachiaininRenban) {
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
    public void shallowCopy(AfT206TachiaininHikitsugiJohoEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.senkyoNo = entity.senkyoNo;
        this.hokokuYMD = entity.hokokuYMD;
        this.shisetsuCode = entity.shisetsuCode;
        this.tohyokuCode = entity.tohyokuCode;
        this.tachiaininRenban = entity.tachiaininRenban;
        this.komokuShurui = entity.komokuShurui;
        this.renban = entity.renban;
        this.shimei = entity.shimei;
        this.toha = entity.toha;
        this.tachiaiStartTime = entity.tachiaiStartTime;
        this.tachiaiStopTime = entity.tachiaiStopTime;
        this.ijoAriFlag = entity.ijoAriFlag;
        this.ijoNaiyo = entity.ijoNaiyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, senkyoNo, hokokuYMD, shisetsuCode, tohyokuCode, tachiaininRenban, komokuShurui, renban, shimei, toha, tachiaiStartTime, tachiaiStopTime, ijoAriFlag, ijoNaiyo);
    }

// </editor-fold>
}
