package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
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
 * 選挙資格、投票資格の状態を保持する。テーブルのエンティティクラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class AfT113SenkyoShikakuEntity extends DbTableEntityBase<AfT113SenkyoShikakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT113SenkyoShikaku");

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
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private BigSerial seq;
    private Code shikakuKubun;
    private RString tohyokuCode;
    private FlexibleDate meiboTorokuYMD;
    private Code torokuJiyuCode;
    private FlexibleDate torokuTeishiYMD;
    private Code torokuTeishiJiyuCode;
    private FlexibleDate hyojiYMD;
    private Code hyojiJiyuCode;
    private FlexibleDate hyojiShojoYMD;
    private FlexibleDate hyojiShojoYoteiYMD;
    private FlexibleDate masshoYMD;
    private Code masshoJiyuCode;
    private FlexibleDate keikiShuryoYMD;
    private boolean nikeimochiFlag;
    private FlexibleDate dataTorokuYMD;

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
     * senkyoShuruiのgetメソッドです。
     *
     * @return senkyoShurui
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * senkyoShuruiのsetメソッドです。
     *
     * @param senkyoShurui senkyoShurui
     */
    public void setSenkyoShurui(@Nonnull Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * senkyoShuruiの名称のgetメソッドです。
     *
     * @return senkyoShuruiの名称
     */
    public RString getSenkyoShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * senkyoShuruiの略称のgetメソッドです。
     *
     * @return senkyoShuruiの略称
     */
    public RString getSenkyoShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * senkyoShuruiのDescriptionのgetメソッドです。
     *
     * @return senkyoShuruiのDescription
     */
    public RString getSenkyoShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), senkyoShurui);
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * seqのgetメソッドです。
     *
     * @return seq
     */
    public BigSerial getSeq() {
        return seq;
    }

    /**
     * shikakuKubunのgetメソッドです。
     *
     * @return shikakuKubun
     */
    @CheckForNull
    public Code getShikakuKubun() {
        return shikakuKubun;
    }

    /**
     * shikakuKubunのsetメソッドです。
     *
     * @param shikakuKubun shikakuKubun
     */
    public void setShikakuKubun(Code shikakuKubun) {
        this.shikakuKubun = shikakuKubun;
    }

    /**
     * tohyokuCodeのgetメソッドです。
     *
     * @return tohyokuCode
     */
    @CheckForNull
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * tohyokuCodeのsetメソッドです。
     *
     * @param tohyokuCode tohyokuCode
     */
    public void setTohyokuCode(RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * 最初に名簿に登録された日のgetメソッドです。
     *
     * @return 最初に名簿に登録された日
     */
    @CheckForNull
    public FlexibleDate getMeiboTorokuYMD() {
        return meiboTorokuYMD;
    }

    /**
     * 最初に名簿に登録された日のsetメソッドです。
     *
     * @param meiboTorokuYMD 最初に名簿に登録された日
     */
    public void setMeiboTorokuYMD(FlexibleDate meiboTorokuYMD) {
        this.meiboTorokuYMD = meiboTorokuYMD;
    }

    /**
     * torokuJiyuCodeのgetメソッドです。
     *
     * @return torokuJiyuCode
     */
    @CheckForNull
    public Code getTorokuJiyuCode() {
        return torokuJiyuCode;
    }

    /**
     * torokuJiyuCodeのsetメソッドです。
     *
     * @param torokuJiyuCode torokuJiyuCode
     */
    public void setTorokuJiyuCode(Code torokuJiyuCode) {
        this.torokuJiyuCode = torokuJiyuCode;
    }

    /**
     * torokuTeishiYMDのgetメソッドです。
     *
     * @return torokuTeishiYMD
     */
    @CheckForNull
    public FlexibleDate getTorokuTeishiYMD() {
        return torokuTeishiYMD;
    }

    /**
     * torokuTeishiYMDのsetメソッドです。
     *
     * @param torokuTeishiYMD torokuTeishiYMD
     */
    public void setTorokuTeishiYMD(FlexibleDate torokuTeishiYMD) {
        this.torokuTeishiYMD = torokuTeishiYMD;
    }

    /**
     * torokuTeishiJiyuCodeのgetメソッドです。
     *
     * @return torokuTeishiJiyuCode
     */
    @CheckForNull
    public Code getTorokuTeishiJiyuCode() {
        return torokuTeishiJiyuCode;
    }

    /**
     * torokuTeishiJiyuCodeのsetメソッドです。
     *
     * @param torokuTeishiJiyuCode torokuTeishiJiyuCode
     */
    public void setTorokuTeishiJiyuCode(Code torokuTeishiJiyuCode) {
        this.torokuTeishiJiyuCode = torokuTeishiJiyuCode;
    }

    /**
     * torokuTeishiJiyuCodeの名称のgetメソッドです。
     *
     * @return torokuTeishiJiyuCodeの名称
     */
    public RString getTorokuTeishiJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), torokuTeishiJiyuCode);
    }

    /**
     * torokuTeishiJiyuCodeの略称のgetメソッドです。
     *
     * @return torokuTeishiJiyuCodeの略称
     */
    public RString getTorokuTeishiJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), torokuTeishiJiyuCode);
    }

    /**
     * torokuTeishiJiyuCodeのDescriptionのgetメソッドです。
     *
     * @return torokuTeishiJiyuCodeのDescription
     */
    public RString getTorokuTeishiJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), torokuTeishiJiyuCode);
    }

    /**
     * hyojiYMDのgetメソッドです。
     *
     * @return hyojiYMD
     */
    @CheckForNull
    public FlexibleDate getHyojiYMD() {
        return hyojiYMD;
    }

    /**
     * hyojiYMDのsetメソッドです。
     *
     * @param hyojiYMD hyojiYMD
     */
    public void setHyojiYMD(FlexibleDate hyojiYMD) {
        this.hyojiYMD = hyojiYMD;
    }

    /**
     * hyojiJiyuCodeのgetメソッドです。
     *
     * @return hyojiJiyuCode
     */
    @CheckForNull
    public Code getHyojiJiyuCode() {
        return hyojiJiyuCode;
    }

    /**
     * hyojiJiyuCodeのsetメソッドです。
     *
     * @param hyojiJiyuCode hyojiJiyuCode
     */
    public void setHyojiJiyuCode(Code hyojiJiyuCode) {
        this.hyojiJiyuCode = hyojiJiyuCode;
    }

    /**
     * 公民権停止者について表示が消える日を設定のgetメソッドです。
     *
     * @return 公民権停止者について表示が消える日を設定
     */
    @CheckForNull
    public FlexibleDate getHyojiShojoYMD() {
        return hyojiShojoYMD;
    }

    /**
     * 公民権停止者について表示が消える日を設定のsetメソッドです。
     *
     * @param hyojiShojoYMD 公民権停止者について表示が消える日を設定
     */
    public void setHyojiShojoYMD(FlexibleDate hyojiShojoYMD) {
        this.hyojiShojoYMD = hyojiShojoYMD;
    }

    /**
     * hyojiShojoYoteiYMDのgetメソッドです。
     *
     * @return hyojiShojoYoteiYMD
     */
    @CheckForNull
    public FlexibleDate getHyojiShojoYoteiYMD() {
        return hyojiShojoYoteiYMD;
    }

    /**
     * hyojiShojoYoteiYMDのsetメソッドです。
     *
     * @param hyojiShojoYoteiYMD hyojiShojoYoteiYMD
     */
    public void setHyojiShojoYoteiYMD(FlexibleDate hyojiShojoYoteiYMD) {
        this.hyojiShojoYoteiYMD = hyojiShojoYoteiYMD;
    }

    /**
     * masshoYMDのgetメソッドです。
     *
     * @return masshoYMD
     */
    @CheckForNull
    public FlexibleDate getMasshoYMD() {
        return masshoYMD;
    }

    /**
     * masshoYMDのsetメソッドです。
     *
     * @param masshoYMD masshoYMD
     */
    public void setMasshoYMD(FlexibleDate masshoYMD) {
        this.masshoYMD = masshoYMD;
    }

    /**
     * masshoJiyuCodeのgetメソッドです。
     *
     * @return masshoJiyuCode
     */
    @CheckForNull
    public Code getMasshoJiyuCode() {
        return masshoJiyuCode;
    }

    /**
     * masshoJiyuCodeのsetメソッドです。
     *
     * @param masshoJiyuCode masshoJiyuCode
     */
    public void setMasshoJiyuCode(Code masshoJiyuCode) {
        this.masshoJiyuCode = masshoJiyuCode;
    }

    /**
     * keikiShuryoYMDのgetメソッドです。
     *
     * @return keikiShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getKeikiShuryoYMD() {
        return keikiShuryoYMD;
    }

    /**
     * keikiShuryoYMDのsetメソッドです。
     *
     * @param keikiShuryoYMD keikiShuryoYMD
     */
    public void setKeikiShuryoYMD(FlexibleDate keikiShuryoYMD) {
        this.keikiShuryoYMD = keikiShuryoYMD;
    }

    /**
     * True:２刑持ちの場合 False：２刑なしの場合のgetメソッドです。
     *
     * @return True:２刑持ちの場合 False：２刑なしの場合
     */
    public boolean getNikeimochiFlag() {
        return nikeimochiFlag;
    }

    /**
     * True:２刑持ちの場合 False：２刑なしの場合のsetメソッドです。
     *
     * @param nikeimochiFlag True:２刑持ちの場合 False：２刑なしの場合
     */
    public void setNikeimochiFlag(@Nonnull boolean nikeimochiFlag) {
        this.nikeimochiFlag = nikeimochiFlag;
    }

    /**
     * dataTorokuYMDのgetメソッドです。
     *
     * @return dataTorokuYMD
     */
    @CheckForNull
    public FlexibleDate getDataTorokuYMD() {
        return dataTorokuYMD;
    }

    /**
     * dataTorokuYMDのsetメソッドです。
     *
     * @param dataTorokuYMD dataTorokuYMD
     */
    public void setDataTorokuYMD(FlexibleDate dataTorokuYMD) {
        this.dataTorokuYMD = dataTorokuYMD;
    }

    /**
     * seqのsetメソッドです。
     *
     * @param seq seq
     */
    public void setSeq(BigSerial seq) {
        this.seq = seq;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT113SenkyoShikakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT113SenkyoShikakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT113SenkyoShikakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.senkyoShurui, other.senkyoShurui)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
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
    public void shallowCopy(AfT113SenkyoShikakuEntity entity) {
        this.senkyoShurui = entity.senkyoShurui;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.seq = entity.seq;
        this.shikakuKubun = entity.shikakuKubun;
        this.tohyokuCode = entity.tohyokuCode;
        this.meiboTorokuYMD = entity.meiboTorokuYMD;
        this.torokuJiyuCode = entity.torokuJiyuCode;
        this.torokuTeishiYMD = entity.torokuTeishiYMD;
        this.torokuTeishiJiyuCode = entity.torokuTeishiJiyuCode;
        this.hyojiYMD = entity.hyojiYMD;
        this.hyojiJiyuCode = entity.hyojiJiyuCode;
        this.hyojiShojoYMD = entity.hyojiShojoYMD;
        this.hyojiShojoYoteiYMD = entity.hyojiShojoYoteiYMD;
        this.masshoYMD = entity.masshoYMD;
        this.masshoJiyuCode = entity.masshoJiyuCode;
        this.keikiShuryoYMD = entity.keikiShuryoYMD;
        this.nikeimochiFlag = entity.nikeimochiFlag;
        this.dataTorokuYMD = entity.dataTorokuYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(senkyoShurui, shikibetsuCode, seq, shikakuKubun, tohyokuCode, meiboTorokuYMD, torokuJiyuCode, torokuTeishiYMD, torokuTeishiJiyuCode, hyojiYMD, hyojiJiyuCode, hyojiShojoYMD, hyojiShojoYoteiYMD, masshoYMD, masshoJiyuCode, keikiShuryoYMD, nikeimochiFlag, dataTorokuYMD);
    }

// </editor-fold>
    /**
     * getTorokuJiyuCodeMeisho
     *
     * @return Meisho
     */
    public RString getTorokuJiyuCodeMeisho() {

        return getCodeMeisho(AFACodeShubetsu.登録事由コード_国民, AFACodeShubetsu.登録事由コード, torokuJiyuCode);

    }

    /**
     * getTorokuJiyuCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getTorokuJiyuCodeRyakusho() {
        return getCodeRyakusho(AFACodeShubetsu.登録事由コード_国民, AFACodeShubetsu.登録事由コード, torokuJiyuCode);
    }

    /**
     * getTorokuJiyuCodeDescription
     *
     * @return Option1
     */
    public RString getTorokuJiyuCodeDescription() {
        return getOption1(AFACodeShubetsu.登録事由コード_国民, AFACodeShubetsu.登録事由コード, torokuJiyuCode);
    }

    /**
     * getShikakuKubunMeisho
     *
     * @return Meisho
     */
    public RString getShikakuKubunMeisho() {
        return getCodeMeisho(AFACodeShubetsu.選挙資格区分_国民, AFACodeShubetsu.選挙資格区分, shikakuKubun);
    }

    /**
     * getShikakuKubunRyakusho
     *
     * @return Ryakusho
     */
    public RString getShikakuKubunRyakusho() {
        return getCodeRyakusho(AFACodeShubetsu.選挙資格区分_国民, AFACodeShubetsu.選挙資格区分, shikakuKubun);
    }

    /**
     * getShikakuKubunDescription
     *
     * @return Option1
     */
    public RString getShikakuKubunDescription() {
        return getOption1(AFACodeShubetsu.選挙資格区分_国民, AFACodeShubetsu.選挙資格区分, shikakuKubun);
    }

    /**
     * getHyojiJiyuCodeMeisho
     *
     * @return Meisho
     */
    public RString getHyojiJiyuCodeMeisho() {
        return getCodeMeisho(AFACodeShubetsu.表示事由コード_国民, AFACodeShubetsu.表示事由コード, hyojiJiyuCode);
    }

    /**
     * getHyojiJiyuCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getHyojiJiyuCodeRyakusho() {
        return getCodeRyakusho(AFACodeShubetsu.表示事由コード_国民, AFACodeShubetsu.表示事由コード, hyojiJiyuCode);
    }

    /**
     * getHyojiJiyuCodeDescription
     *
     * @return Option1
     */
    public RString getHyojiJiyuCodeDescription() {
        return getOption1(AFACodeShubetsu.表示事由コード_国民, AFACodeShubetsu.表示事由コード, hyojiJiyuCode);
    }

    /**
     * getMasshoJiyuCodeMeisho
     *
     * @return Meisho
     */
    public RString getMasshoJiyuCodeMeisho() {
        return getCodeMeisho(AFACodeShubetsu.抹消事由コード_国民, AFACodeShubetsu.抹消事由コード, masshoJiyuCode);
    }

    /**
     * getMasshoJiyuCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getMasshoJiyuCodeRyakusho() {
        return getCodeRyakusho(AFACodeShubetsu.抹消事由コード_国民, AFACodeShubetsu.抹消事由コード, masshoJiyuCode);
    }

    /**
     * getMasshoJiyuCodeDescription
     *
     * @return Option1
     */
    public RString getMasshoJiyuCodeDescription() {
        return getOption1(AFACodeShubetsu.抹消事由コード_国民, AFACodeShubetsu.抹消事由コード, masshoJiyuCode);
    }

    private RString getCodeMeisho(AFACodeShubetsu codeShubetsu憲法改正国民投票, AFACodeShubetsu codeShubetsu, Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        if (senkyoShurui.getColumnValue().equals(SenkyoShurui.憲法改正国民投票.getCode())) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, codeShubetsu憲法改正国民投票.getCodeShubetsu(), code);
        }
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, codeShubetsu.getCodeShubetsu(), code);
    }

    private RString getCodeRyakusho(AFACodeShubetsu codeShubetsu憲法改正国民投票, AFACodeShubetsu codeShubetsu, Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        if (senkyoShurui.getColumnValue().equals(SenkyoShurui.憲法改正国民投票.getCode())) {
            return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, codeShubetsu憲法改正国民投票.getCodeShubetsu(), code);
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, codeShubetsu.getCodeShubetsu(), code);
    }

    private RString getOption1(AFACodeShubetsu codeShubetsu憲法改正国民投票, AFACodeShubetsu codeShubetsu, Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        if (senkyoShurui.getColumnValue().equals(SenkyoShurui.憲法改正国民投票.getCode())) {
            return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, codeShubetsu憲法改正国民投票.getCodeShubetsu(), code);
        }
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, codeShubetsu.getCodeShubetsu(), code);
    }

    private RString getCodeMeisho(AFACodeShubetsu codeShubetsu, Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, codeShubetsu.getCodeShubetsu(), code);
    }

    private RString getCodeRyakusho(AFACodeShubetsu codeShubetsu, Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, codeShubetsu.getCodeShubetsu(), code);
    }

    private RString getOption1(AFACodeShubetsu codeShubetsu, Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, codeShubetsu.getCodeShubetsu(), code);
    }

}
