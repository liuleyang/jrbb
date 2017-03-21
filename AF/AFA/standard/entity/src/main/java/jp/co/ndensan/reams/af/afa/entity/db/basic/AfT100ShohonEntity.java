package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 定時処理、各種選挙等の1処理につき、1抄本を作成する。 複数選挙を1つにまとめるためのもの。 投票年月日が違う場合は、別抄本とする。テーブルのエンティティクラスです。
 */
public class AfT100ShohonEntity extends DbTableEntityBase<AfT100ShohonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT100Shohon");

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
    private Code senkyoShurui;
    private RString shohonName;
    private FlexibleDate tohyoYMD;
    private FlexibleDate kiteiNenreiTotatsuYMD;
    private FlexibleDate shoriYMD;
    private Decimal nyujokenReportIndex;
    private ShohonNo simulationShohonNo;

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
     * insertReamsLoginIdのgetメソッドです。
     *
     * @return insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return insertReamsLoginId;
    }

    /**
     * insertTimestampのsetメソッドです。
     *
     * @param insertReamsLoginId RString
     */
    public void setInsertReamsLoginId(RString insertReamsLoginId) {
        this.insertReamsLoginId = insertReamsLoginId;
    }

    /**
     * insertTimestampのgetメソッドです。
     *
     * @return insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * insertTimestampのsetメソッドです。
     *
     * @param insertTimestamp RDateTime
     */
    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /**
     * insertContextIdのgetメソッドです。
     *
     * @return insertContextId
     */
    public UUID getInsertContextId() {
        return insertContextId;
    }

    /**
     * insertContextIdのsetメソッドです。
     *
     * @param insertContextId UUID
     */
    public void setInsertContextId(UUID insertContextId) {
        this.insertContextId = insertContextId;
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
     * updateCountのgetメソッドです。
     *
     * @return updateCount
     */
    public int getUpdateCount() {
        return updateCount;
    }

    /**
     * updateCountのsetメソッドです。
     *
     * @param updateCount int
     */
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * lastUpdateTimestampのgetメソッドです。
     *
     * @return lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * lastUpdateTimestampのsetメソッドです。
     *
     * @param lastUpdateTimestamp RDateTime
     */
    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    /**
     * lastUpdateReamsLoginIdのgetメソッドです。
     *
     * @return lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return lastUpdateReamsLoginId;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId RString
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 抄本番号のgetメソッドです。
     * <br/>
     * <br/>各処理の単位となる。 複数選挙同日投票日などの時、1つにまとめて処理を行うため。
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 抄本番号のsetメソッドです。
     * <br/>
     * <br/>各処理の単位となる。 複数選挙同日投票日などの時、1つにまとめて処理を行うため。
     *
     * @param shohonNo 抄本番号
     */
    public void setShohonNo(@Nonnull ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * 選挙種類のgetメソッドです。
     * <br/>
     * <br/>異なった選挙種類での複数選挙は登録できない。
     *
     * @return 選挙種類
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 選挙種類のsetメソッドです。
     * <br/>
     * <br/>異なった選挙種類での複数選挙は登録できない。
     *
     * @param senkyoShurui 選挙種類
     */
    public void setSenkyoShurui(@Nonnull Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 選挙種類の名称のgetメソッドです。
     * <br/>
     * <br/>異なった選挙種類での複数選挙は登録できない。
     *
     * @return 選挙種類の名称
     */
    public RString getSenkyoShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙種類の略称のgetメソッドです。
     * <br/>
     * <br/>異なった選挙種類での複数選挙は登録できない。
     *
     * @return 選挙種類の略称
     */
    public RString getSenkyoShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 選挙種類のDescriptionのgetメソッドです。
     * <br/>
     * <br/>異なった選挙種類での複数選挙は登録できない。
     *
     * @return 選挙種類のDescription
     */
    public RString getSenkyoShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * 抄本名のgetメソッドです。
     *
     * @return 抄本名
     */
    @CheckForNull
    public RString getShohonName() {
        return shohonName;
    }

    /**
     * 抄本名のsetメソッドです。
     *
     * @param shohonName 抄本名
     */
    public void setShohonName(RString shohonName) {
        this.shohonName = shohonName;
    }

    /**
     * 投票年月日のgetメソッドです。
     * <br/>
     * <br/>定時登録の場合は、名簿基準年月日と同日
     *
     * @return 投票年月日
     */
    @CheckForNull
    public FlexibleDate getTohyoYMD() {
        return tohyoYMD;
    }

    /**
     * 投票年月日のsetメソッドです。
     * <br/>
     * <br/>定時登録の場合は、名簿基準年月日と同日
     *
     * @param tohyoYMD 投票年月日
     */
    public void setTohyoYMD(FlexibleDate tohyoYMD) {
        this.tohyoYMD = tohyoYMD;
    }

    /**
     * 規定年齢到達年月日のgetメソッドです。
     *
     * @return 規定年齢到達年月日
     */
    @CheckForNull
    public FlexibleDate getKiteiNenreiTotatsuYMD() {
        return kiteiNenreiTotatsuYMD;
    }

    /**
     * 規定年齢到達年月日のsetメソッドです。
     *
     * @param kiteiNenreiTotatsuYMD 規定年齢到達年月日
     */
    public void setKiteiNenreiTotatsuYMD(FlexibleDate kiteiNenreiTotatsuYMD) {
        this.kiteiNenreiTotatsuYMD = kiteiNenreiTotatsuYMD;
    }

    /**
     * 処理年月日のgetメソッドです。
     * <br/>
     * <br/>抄本を作成した日
     *
     * @return 処理年月日
     */
    @CheckForNull
    public FlexibleDate getShoriYMD() {
        return shoriYMD;
    }

    /**
     * 処理年月日のsetメソッドです。
     * <br/>
     * <br/>抄本を作成した日
     *
     * @param shoriYMD 処理年月日
     */
    public void setShoriYMD(FlexibleDate shoriYMD) {
        this.shoriYMD = shoriYMD;
    }

    /**
     * 入場券発行固有番号のgetメソッドです。
     * <br/>
     * <br/>入場券一括作成時に取得できる帳票固有連番をセット 入場券が実印刷されているかどうかの確認に使用する
     *
     * @return 入場券発行固有番号
     */
    @CheckForNull
    public Decimal getNyujokenReportIndex() {
        return nyujokenReportIndex;
    }

    /**
     * 入場券発行固有番号のsetメソッドです。
     * <br/>
     * <br/>入場券一括作成時に取得できる帳票固有連番をセット 入場券が実印刷されているかどうかの確認に使用する
     *
     * @param nyujokenReportIndex 入場券発行固有番号
     */
    public void setNyujokenReportIndex(Decimal nyujokenReportIndex) {
        this.nyujokenReportIndex = nyujokenReportIndex;
    }

    /**
     * 研修用抄本番号のgetメソッドです。
     * <br/>
     * <br/>選挙時登録で必要。同時作成した、研修用データの抄本番号をセットする
     *
     * @return 研修用抄本番号
     */
    public ShohonNo getSimulationShohonNo() {
        return simulationShohonNo;
    }

    /**
     * 研修用抄本番号のsetメソッドです。
     * <br/>
     * <br/>選挙時登録で必要。同時作成した、研修用データの抄本番号をセットする
     *
     * @param simulationShohonNo 研修用抄本番号
     */
    public void setSimulationShohonNo(@Nonnull ShohonNo simulationShohonNo) {
        this.simulationShohonNo = simulationShohonNo;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT100ShohonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT100ShohonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT100ShohonEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity AfT100ShohonEntity
     */
    @Override
    public void shallowCopy(AfT100ShohonEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.senkyoShurui = entity.senkyoShurui;
        this.shohonName = entity.shohonName;
        this.tohyoYMD = entity.tohyoYMD;
        this.kiteiNenreiTotatsuYMD = entity.kiteiNenreiTotatsuYMD;
        this.shoriYMD = entity.shoriYMD;
        this.nyujokenReportIndex = entity.nyujokenReportIndex;
        this.simulationShohonNo = entity.simulationShohonNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, senkyoShurui, shohonName, tohyoYMD, kiteiNenreiTotatsuYMD, shoriYMD, nyujokenReportIndex, simulationShohonNo);
    }

// </editor-fold>
}
