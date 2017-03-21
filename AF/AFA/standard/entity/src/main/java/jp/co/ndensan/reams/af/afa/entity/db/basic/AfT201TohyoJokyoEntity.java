package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 投票の状態を保持する。 定時登録時は作成されない。テーブルのエンティティクラスです。
 */
public class AfT201TohyoJokyoEntity extends DbTableEntityBase<AfT201TohyoJokyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT201TohyoJokyo");

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
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private SenkyoNo senkyoNo;
    private Code tohyoJokyo;
    private Code tohyoJiyuCode;
    private FlexibleDate seikyuYMD;
    private Code seikyuHoho;
    private Integer uketsukeNo;
    private FlexibleDate kofuYMD;
    private RTime kofuTime;
    private Code kofuHoho;
    private RString shisetsuCode;
    private FlexibleDate uketoriYMD;
    private FlexibleDate juriYMD;
    private RTime juriTime;
    private Code juriHoho;
    private Code juriShisetsuShubetsu;
    private FlexibleDate kikenYMD;
    private FlexibleDate henkanYMD;
    private boolean tenjiFlag;
    private boolean dairiTohyoAriFlag;
    private ShikibetsuCode hojoshaShikibetsuCode1;
    private AtenaMeisho hojoshaShimei1;
    private ShikibetsuCode hojoshaShikibetsuCode2;
    private AtenaMeisho hojoshaShimei2;
    private RString kyohiJiyu;
    private boolean shomeishoPrintFlag;
    private boolean sochiZumiFlag;
    private Code kijitsuFuzaiKubun;
    private RString reamsClientId;

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
     * 投票状況のgetメソッドです。
     *
     * @return 投票状況
     */
    @CheckForNull
    public Code getTohyoJokyo() {
        return tohyoJokyo;
    }

    /**
     * 投票状況のsetメソッドです。
     *
     * @param tohyoJokyo 投票状況
     */
    public void setTohyoJokyo(Code tohyoJokyo) {
        this.tohyoJokyo = tohyoJokyo;
    }

    /**
     * 投票事由コードのgetメソッドです。
     * <br/>
     * <br/>旧　請求事由コード
     *
     * @return 投票事由コード
     */
    @CheckForNull
    public Code getTohyoJiyuCode() {
        return tohyoJiyuCode;
    }

    /**
     * 投票事由コードのsetメソッドです。
     * <br/>
     * <br/>旧　請求事由コード
     *
     * @param tohyoJiyuCode 投票事由コード
     */
    public void setTohyoJiyuCode(Code tohyoJiyuCode) {
        this.tohyoJiyuCode = tohyoJiyuCode;
    }

    /**
     * 請求年月日のgetメソッドです。
     *
     * @return 請求年月日
     */
    @CheckForNull
    public FlexibleDate getSeikyuYMD() {
        return seikyuYMD;
    }

    /**
     * 請求年月日のsetメソッドです。
     *
     * @param seikyuYMD 請求年月日
     */
    public void setSeikyuYMD(FlexibleDate seikyuYMD) {
        this.seikyuYMD = seikyuYMD;
    }

    /**
     * 請求方法のgetメソッドです。
     * <br/>
     * <br/>'直接・本人　or　直接・代理人　or　郵便 ※期日前で郵便はない
     *
     * @return 請求方法
     */
    @CheckForNull
    public Code getSeikyuHoho() {
        return seikyuHoho;
    }

    /**
     * 請求方法のsetメソッドです。
     * <br/>
     * <br/>'直接・本人　or　直接・代理人　or　郵便 ※期日前で郵便はない
     *
     * @param seikyuHoho 請求方法
     */
    public void setSeikyuHoho(Code seikyuHoho) {
        this.seikyuHoho = seikyuHoho;
    }

    /**
     * 受付番号のgetメソッドです。
     * <br/>
     * <br/>自動採番
     *
     * @return 受付番号
     */
    @CheckForNull
    public Integer getUketsukeNo() {
        return uketsukeNo;
    }

    /**
     * 受付番号のsetメソッドです。
     * <br/>
     * <br/>自動採番
     *
     * @param uketsukeNo 受付番号
     */
    public void setUketsukeNo(Integer uketsukeNo) {
        this.uketsukeNo = uketsukeNo;
    }

    /**
     * 交付年月日のgetメソッドです。
     *
     * @return 交付年月日
     */
    @CheckForNull
    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    /**
     * 交付年月日のsetメソッドです。
     *
     * @param kofuYMD 交付年月日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    /**
     * 交付時刻のgetメソッドです。
     *
     * @return 交付時刻
     */
    @CheckForNull
    public RTime getKofuTime() {
        return kofuTime;
    }

    /**
     * 交付時刻のsetメソッドです。
     *
     * @param kofuTime 交付時刻
     */
    public void setKofuTime(RTime kofuTime) {
        this.kofuTime = kofuTime;
    }

    /**
     * 交付方法のgetメソッドです。
     * <br/>
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     *
     * @return 交付方法
     */
    @CheckForNull
    public Code getKofuHoho() {
        return kofuHoho;
    }

    /**
     * 交付方法のsetメソッドです。
     * <br/>
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     *
     * @param kofuHoho 交付方法
     */
    public void setKofuHoho(Code kofuHoho) {
        this.kofuHoho = kofuHoho;
    }

    /**
     * 施設コードのgetメソッドです。
     * <br/>
     * <br/>不在者の時は交付施設コード
     *
     * @return 施設コード
     */
    @CheckForNull
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    /**
     * 施設コードのsetメソッドです。
     * <br/>
     * <br/>不在者の時は交付施設コード
     *
     * @param shisetsuCode 施設コード
     */
    public void setShisetsuCode(RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * 受取年月日のgetメソッドです。
     * <br/>
     * <br/>投票用紙が戻ってきた日を入力
     *
     * @return 受取年月日
     */
    @CheckForNull
    public FlexibleDate getUketoriYMD() {
        return uketoriYMD;
    }

    /**
     * 受取年月日のsetメソッドです。
     * <br/>
     * <br/>投票用紙が戻ってきた日を入力
     *
     * @param uketoriYMD 受取年月日
     */
    public void setUketoriYMD(FlexibleDate uketoriYMD) {
        this.uketoriYMD = uketoriYMD;
    }

    /**
     * 受理年月日のgetメソッドです。
     *
     * @return 受理年月日
     */
    @CheckForNull
    public FlexibleDate getJuriYMD() {
        return juriYMD;
    }

    /**
     * 受理年月日のsetメソッドです。
     *
     * @param juriYMD 受理年月日
     */
    public void setJuriYMD(FlexibleDate juriYMD) {
        this.juriYMD = juriYMD;
    }

    /**
     * 受理時刻のgetメソッドです。
     *
     * @return 受理時刻
     */
    @CheckForNull
    public RTime getJuriTime() {
        return juriTime;
    }

    /**
     * 受理時刻のsetメソッドです。
     *
     * @param juriTime 受理時刻
     */
    public void setJuriTime(RTime juriTime) {
        this.juriTime = juriTime;
    }

    /**
     * 受理方法のgetメソッドです。
     * <br/>
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     *
     * @return 受理方法
     */
    @CheckForNull
    public Code getJuriHoho() {
        return juriHoho;
    }

    /**
     * 受理方法のsetメソッドです。
     * <br/>
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     *
     * @param juriHoho 受理方法
     */
    public void setJuriHoho(Code juriHoho) {
        this.juriHoho = juriHoho;
    }

    /**
     * 受理施設種別のgetメソッドです。
     * <br/>
     * <br/>旧・受理施設（投票場所）
     *
     * @return 受理施設種別
     */
    @CheckForNull
    public Code getJuriShisetsuShubetsu() {
        return juriShisetsuShubetsu;
    }

    /**
     * 受理施設種別のsetメソッドです。
     * <br/>
     * <br/>旧・受理施設（投票場所）
     *
     * @param juriShisetsuShubetsu 受理施設種別
     */
    public void setJuriShisetsuShubetsu(Code juriShisetsuShubetsu) {
        this.juriShisetsuShubetsu = juriShisetsuShubetsu;
    }

    /**
     * 棄権年月日のgetメソッドです。
     * <br/>
     * <br/>選挙人の意思で棄権を宣言した日。以降、投票できなくなる。
     *
     * @return 棄権年月日
     */
    @CheckForNull
    public FlexibleDate getKikenYMD() {
        return kikenYMD;
    }

    /**
     * 棄権年月日のsetメソッドです。
     * <br/>
     * <br/>選挙人の意思で棄権を宣言した日。以降、投票できなくなる。
     *
     * @param kikenYMD 棄権年月日
     */
    public void setKikenYMD(FlexibleDate kikenYMD) {
        this.kikenYMD = kikenYMD;
    }

    /**
     * 返還年月日のgetメソッドです。
     * <br/>
     * <br/>返還時はここに日付をセット。返還しても投票はできる（期日前にはない）
     *
     * @return 返還年月日
     */
    @CheckForNull
    public FlexibleDate getHenkanYMD() {
        return henkanYMD;
    }

    /**
     * 返還年月日のsetメソッドです。
     * <br/>
     * <br/>返還時はここに日付をセット。返還しても投票はできる（期日前にはない）
     *
     * @param henkanYMD 返還年月日
     */
    public void setHenkanYMD(FlexibleDate henkanYMD) {
        this.henkanYMD = henkanYMD;
    }

    /**
     * 点字フラグのgetメソッドです。
     *
     * @return 点字フラグ
     */
    public boolean getTenjiFlag() {
        return tenjiFlag;
    }

    /**
     * 点字フラグのsetメソッドです。
     *
     * @param tenjiFlag 点字フラグ
     */
    public void setTenjiFlag(@Nonnull boolean tenjiFlag) {
        this.tenjiFlag = tenjiFlag;
    }

    /**
     * 代理投票有フラグのgetメソッドです。
     * <br/>
     * <br/>期日前、当日の時のみ
     *
     * @return 代理投票有フラグ
     */
    public boolean getDairiTohyoAriFlag() {
        return dairiTohyoAriFlag;
    }

    /**
     * 代理投票有フラグのsetメソッドです。
     * <br/>
     * <br/>期日前、当日の時のみ
     *
     * @param dairiTohyoAriFlag 代理投票有フラグ
     */
    public void setDairiTohyoAriFlag(@Nonnull boolean dairiTohyoAriFlag) {
        this.dairiTohyoAriFlag = dairiTohyoAriFlag;
    }

    /**
     * 補助者識別コード1のgetメソッドです。
     *
     * @return 補助者識別コード1
     */
    @CheckForNull
    public ShikibetsuCode getHojoshaShikibetsuCode1() {
        return hojoshaShikibetsuCode1;
    }

    /**
     * 補助者識別コード1のsetメソッドです。
     *
     * @param hojoshaShikibetsuCode1 補助者識別コード1
     */
    public void setHojoshaShikibetsuCode1(ShikibetsuCode hojoshaShikibetsuCode1) {
        this.hojoshaShikibetsuCode1 = hojoshaShikibetsuCode1;
    }

    /**
     * 補助者氏名1のgetメソッドです。
     *
     * @return 補助者氏名1
     */
    @CheckForNull
    public AtenaMeisho getHojoshaShimei1() {
        return hojoshaShimei1;
    }

    /**
     * 補助者氏名1のsetメソッドです。
     *
     * @param hojoshaShimei1 補助者氏名1
     */
    public void setHojoshaShimei1(AtenaMeisho hojoshaShimei1) {
        this.hojoshaShimei1 = hojoshaShimei1;
    }

    /**
     * 補助者識別コード2のgetメソッドです。
     *
     * @return 補助者識別コード2
     */
    @CheckForNull
    public ShikibetsuCode getHojoshaShikibetsuCode2() {
        return hojoshaShikibetsuCode2;
    }

    /**
     * 補助者識別コード2のsetメソッドです。
     *
     * @param hojoshaShikibetsuCode2 補助者識別コード2
     */
    public void setHojoshaShikibetsuCode2(ShikibetsuCode hojoshaShikibetsuCode2) {
        this.hojoshaShikibetsuCode2 = hojoshaShikibetsuCode2;
    }

    /**
     * 補助者氏名2のgetメソッドです。
     *
     * @return 補助者氏名2
     */
    @CheckForNull
    public AtenaMeisho getHojoshaShimei2() {
        return hojoshaShimei2;
    }

    /**
     * 補助者氏名2のsetメソッドです。
     *
     * @param hojoshaShimei2 補助者氏名2
     */
    public void setHojoshaShimei2(AtenaMeisho hojoshaShimei2) {
        this.hojoshaShimei2 = hojoshaShimei2;
    }

    /**
     * 拒否事由のgetメソッドです。
     * <br/>
     * <br/>拒否事由コードでの選択もできるが、DBセット時は文字列をセットする。
     *
     * @return 拒否事由
     */
    @CheckForNull
    public RString getKyohiJiyu() {
        return kyohiJiyu;
    }

    /**
     * 拒否事由のsetメソッドです。
     * <br/>
     * <br/>拒否事由コードでの選択もできるが、DBセット時は文字列をセットする。
     *
     * @param kyohiJiyu 拒否事由
     */
    public void setKyohiJiyu(RString kyohiJiyu) {
        this.kyohiJiyu = kyohiJiyu;
    }

    /**
     * 証明書出力フラグのgetメソッドです。
     * <br/>
     * <br/>不在者投票の時のみ
     *
     * @return 証明書出力フラグ
     */
    public boolean getShomeishoPrintFlag() {
        return shomeishoPrintFlag;
    }

    /**
     * 証明書出力フラグのsetメソッドです。
     * <br/>
     * <br/>不在者投票の時のみ
     *
     * @param shomeishoPrintFlag 証明書出力フラグ
     */
    public void setShomeishoPrintFlag(@Nonnull boolean shomeishoPrintFlag) {
        this.shomeishoPrintFlag = shomeishoPrintFlag;
    }

    /**
     * 送致済フラグのgetメソッドです。
     * <br/>
     * <br/>'選管から、各投票所や開票場所へ送致した時にTrueにする
     *
     * @return 送致済フラグ
     */
    public boolean getSochiZumiFlag() {
        return sochiZumiFlag;
    }

    /**
     * 送致済フラグのsetメソッドです。
     * <br/>
     * <br/>'選管から、各投票所や開票場所へ送致した時にTrueにする
     *
     * @param sochiZumiFlag 送致済フラグ
     */
    public void setSochiZumiFlag(@Nonnull boolean sochiZumiFlag) {
        this.sochiZumiFlag = sochiZumiFlag;
    }

    /**
     * 期日前不在者区分のgetメソッドです。
     * <br/>
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     *
     * @return 期日前不在者区分
     */
    @CheckForNull
    public Code getKijitsuFuzaiKubun() {
        return kijitsuFuzaiKubun;
    }

    /**
     * 期日前不在者区分のsetメソッドです。
     * <br/>
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     *
     * @param kijitsuFuzaiKubun 期日前不在者区分
     */
    public void setKijitsuFuzaiKubun(Code kijitsuFuzaiKubun) {
        this.kijitsuFuzaiKubun = kijitsuFuzaiKubun;
    }

    /**
     * 期日前不在者区分の名称のgetメソッドです。
     * <br/>
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     *
     * @return 期日前不在者区分の名称
     */
    public RString getKijitsuFuzaiKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), kijitsuFuzaiKubun);
    }

    /**
     * 期日前不在者区分の略称のgetメソッドです。
     * <br/>
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     *
     * @return 期日前不在者区分の略称
     */
    public RString getKijitsuFuzaiKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), kijitsuFuzaiKubun);
    }

    /**
     * 期日前不在者区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     *
     * @return 期日前不在者区分のDescription
     */
    public RString getKijitsuFuzaiKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), kijitsuFuzaiKubun);
    }

    /**
     * 更新端末IDのgetメソッドです。
     *
     * @return 更新端末ID
     */
    @CheckForNull
    public RString getReamsClientId() {
        return reamsClientId;
    }

    /**
     * 更新端末IDのsetメソッドです。
     *
     * @param reamsClientId 更新端末ID
     */
    public void setReamsClientId(RString reamsClientId) {
        this.reamsClientId = reamsClientId;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT201TohyoJokyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT201TohyoJokyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT201TohyoJokyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.senkyoNo, other.senkyoNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT201TohyoJokyoEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.senkyoNo = entity.senkyoNo;
        this.tohyoJokyo = entity.tohyoJokyo;
        this.tohyoJiyuCode = entity.tohyoJiyuCode;
        this.seikyuYMD = entity.seikyuYMD;
        this.seikyuHoho = entity.seikyuHoho;
        this.uketsukeNo = entity.uketsukeNo;
        this.kofuYMD = entity.kofuYMD;
        this.kofuTime = entity.kofuTime;
        this.kofuHoho = entity.kofuHoho;
        this.shisetsuCode = entity.shisetsuCode;
        this.uketoriYMD = entity.uketoriYMD;
        this.juriYMD = entity.juriYMD;
        this.juriTime = entity.juriTime;
        this.juriHoho = entity.juriHoho;
        this.juriShisetsuShubetsu = entity.juriShisetsuShubetsu;
        this.kikenYMD = entity.kikenYMD;
        this.henkanYMD = entity.henkanYMD;
        this.tenjiFlag = entity.tenjiFlag;
        this.dairiTohyoAriFlag = entity.dairiTohyoAriFlag;
        this.hojoshaShikibetsuCode1 = entity.hojoshaShikibetsuCode1;
        this.hojoshaShimei1 = entity.hojoshaShimei1;
        this.hojoshaShikibetsuCode2 = entity.hojoshaShikibetsuCode2;
        this.hojoshaShimei2 = entity.hojoshaShimei2;
        this.kyohiJiyu = entity.kyohiJiyu;
        this.shomeishoPrintFlag = entity.shomeishoPrintFlag;
        this.sochiZumiFlag = entity.sochiZumiFlag;
        this.kijitsuFuzaiKubun = entity.kijitsuFuzaiKubun;
        this.reamsClientId = entity.reamsClientId;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, shikibetsuCode, senkyoNo, tohyoJokyo, tohyoJiyuCode, seikyuYMD, seikyuHoho, uketsukeNo, kofuYMD, kofuTime, kofuHoho, shisetsuCode, uketoriYMD, juriYMD, juriTime, juriHoho, juriShisetsuShubetsu, kikenYMD, henkanYMD, tenjiFlag, dairiTohyoAriFlag, hojoshaShikibetsuCode1, hojoshaShimei1, hojoshaShikibetsuCode2, hojoshaShimei2, kyohiJiyu, shomeishoPrintFlag, sochiZumiFlag, kijitsuFuzaiKubun, reamsClientId);
    }

// </editor-fold>
    /**
     * getTohyoJiyuCodeMeisho
     *
     * @param senkyoShurui senkyoShurui
     * @return Meisho
     */
    public RString getTohyoJiyuCodeMeisho(SenkyoShurui senkyoShurui) {
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), tohyoJokyo);
        } else {
            return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
        }
    }

    /**
     * getTohyoJiyuCodeRyakusho
     *
     * @param senkyoShurui senkyoShurui
     * @return Ryakusho
     */
    public RString getTohyoJiyuCodeRyakusho(SenkyoShurui senkyoShurui) {
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), tohyoJokyo);
        } else {
            return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
        }
    }

    /**
     * getTohyoJiyuCodeDescription
     *
     * @param senkyoShurui senkyoShurui
     * @return Option1
     */
    public RString getTohyoJiyuCodeDescription(SenkyoShurui senkyoShurui) {
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), tohyoJokyo);
        } else {
            return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
        }
    }

    /**
     * seikyuHohoの名称のgetメソッドです。
     *
     * @return seikyuHohoの名称
     */
    public RString getSeikyuHohoMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.請求方法.getCodeShubetsu(), seikyuHoho);
    }

    /**
     * seikyuHohoの略称のgetメソッドです。
     *
     * @return seikyuHohoの略称
     */
    public RString getSeikyuHohoRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.請求方法.getCodeShubetsu(), seikyuHoho);
    }

    /**
     * seikyuHohoのDescriptionのgetメソッドです。
     *
     * @return seikyuHohoのDescription
     */
    public RString getSeikyuHohoDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.請求方法.getCodeShubetsu(), seikyuHoho);
    }

    /**
     * tohyoJokyoの名称のgetメソッドです。
     *
     * @return tohyoJokyoの名称
     */
    public RString getTohyoJokyoMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票状況.getCodeShubetsu(), tohyoJokyo);
    }

    /**
     * tohyoJokyoの略称のgetメソッドです。
     *
     * @return tohyoJokyoの略称
     */
    public RString getTohyoJokyoRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票状況.getCodeShubetsu(), tohyoJokyo);
    }

    /**
     * tohyoJokyoのDescriptionのgetメソッドです。
     *
     * @return tohyoJokyoのDescription
     */
    public RString getTohyoJokyoDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票状況.getCodeShubetsu(), tohyoJokyo);
    }

    /**
     * 投票事由コードの名称のgetメソッドです。
     *
     * @return 旧　請求事由コードの名称
     */
    public RString getTohyoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
    }

    /**
     * 投票事由コードの略称のgetメソッドです。
     *
     * @return 旧　請求事由コードの略称
     */
    public RString getTohyoJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
    }

    /**
     * 投票事由コードのDescriptionのgetメソッドです。
     *
     * @return 旧　請求事由コードのDescription
     */
    public RString getTohyoJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
    }

    /**
     * kofuHohoの名称のgetメソッドです。
     *
     * @return kofuHohoの名称
     */
    public RString getKofuHohoMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), kofuHoho);
    }

    /**
     * kofuHohoの略称のgetメソッドです。
     *
     * @return kofuHohoの略称
     */
    public RString getKofuHohoRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), kofuHoho);
    }

    /**
     * kofuHohoのDescriptionのgetメソッドです。
     *
     * @return kofuHohoのDescription
     */
    public RString getKofuHohoDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), kofuHoho);
    }

    /**
     * juriHohoの名称のgetメソッドです。
     *
     * @return juriHohoの名称
     */
    public RString getJuriHohoMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), juriHoho);
    }

    /**
     * juriHohoの略称のgetメソッドです。
     *
     * @return juriHohoの略称
     */
    public RString getJuriHohoRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), juriHoho);
    }

    /**
     * juriHohoのDescriptionのgetメソッドです。
     *
     * @return juriHohoのDescription
     */
    public RString getJuriHohoDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), juriHoho);
    }

    /**
     * 受理施設種別の名称のgetメソッドです。
     *
     * @return 旧・受理施設（投票場所）の名称
     */
    public RString getJuriShisetsuShubetsuMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), juriShisetsuShubetsu);
    }

    /**
     * 受理施設種別の略称のgetメソッドです。
     *
     * @return 旧・受理施設（投票場所）の略称
     */
    public RString getJuriShisetsuShubetsuRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), juriShisetsuShubetsu);
    }

    /**
     * 受理施設種別のDescriptionのgetメソッドです。
     *
     * @return 旧・受理施設（投票場所）のDescription
     */
    public RString getJuriShisetsuShubetsuDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), juriShisetsuShubetsu);
    }

}
