package jp.co.ndensan.reams.af.afa.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * 選挙人の郵便投票資格の詳細情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT115FuzaishaTohyoShikakuYubinEntity extends DbTableEntityBase<AfT115FuzaishaTohyoShikakuYubinEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT115FuzaishaTohyoShikakuYubin");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private BigSerial seq;
    private boolean shogaiTechoAriFlag;
    private boolean senshoTechoAriFlag;
    private boolean kaigoHokenshoAriFlag;
    private Code dairiInputKubun;
    private ShikibetsuCode dairiShikibetsuCode;
    private AtenaMeisho dairiKanjiShimei;
    private AtenaKanaMeisho dairiKanaShimei;
    private FlexibleDate dairiSeinengappiYMD;
    private RString dairiSeibetsuCode;
    private YubinNo dairiYubinNo;
    private AtenaJusho dairiJusho;

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
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public BigSerial getSeq() {
        return seq;
    }

    /**
     * 履歴番号のsetメソッドです。
     * <br/>
     * <br/>履歴番号
     *
     * @param seq 履歴番号
     */
    public void setSeq(BigSerial seq) {
        this.seq = seq;
    }

    /**
     * 身体障害者手帳有フラグのgetメソッドです。
     *
     * @return 身体障害者手帳有フラグ
     */
    public boolean getShogaiTechoAriFlag() {
        return shogaiTechoAriFlag;
    }

    /**
     * 身体障害者手帳有フラグのsetメソッドです。
     *
     * @param shogaiTechoAriFlag 身体障害者手帳有フラグ
     */
    public void setShogaiTechoAriFlag(@Nonnull boolean shogaiTechoAriFlag) {
        this.shogaiTechoAriFlag = shogaiTechoAriFlag;
    }

    /**
     * 戦傷病者手帳有フラグのgetメソッドです。
     *
     * @return 戦傷病者手帳有フラグ
     */
    public boolean getSenshoTechoAriFlag() {
        return senshoTechoAriFlag;
    }

    /**
     * 戦傷病者手帳有フラグのsetメソッドです。
     *
     * @param senshoTechoAriFlag 戦傷病者手帳有フラグ
     */
    public void setSenshoTechoAriFlag(@Nonnull boolean senshoTechoAriFlag) {
        this.senshoTechoAriFlag = senshoTechoAriFlag;
    }

    /**
     * 介護保険被保険者証有フラグのgetメソッドです。
     *
     * @return 介護保険被保険者証有フラグ
     */
    public boolean getKaigoHokenshoAriFlag() {
        return kaigoHokenshoAriFlag;
    }

    /**
     * 介護保険被保険者証有フラグのsetメソッドです。
     *
     * @param kaigoHokenshoAriFlag 介護保険被保険者証有フラグ
     */
    public void setKaigoHokenshoAriFlag(@Nonnull boolean kaigoHokenshoAriFlag) {
        this.kaigoHokenshoAriFlag = kaigoHokenshoAriFlag;
    }

    /**
     * 代理記載者入力区分のgetメソッドです。
     * <br/>
     * <br/>0：代理記載者入力無し、 1：住基（宛名）検索、 2：直接入力
     *
     * @return 代理記載者入力区分
     */
    @CheckForNull
    public Code getDairiInputKubun() {
        return dairiInputKubun;
    }

    /**
     * 代理記載者入力区分のsetメソッドです。
     * <br/>
     * <br/>0：代理記載者入力無し、 1：住基（宛名）検索、 2：直接入力
     *
     * @param dairiInputKubun 代理記載者入力区分
     */
    public void setDairiInputKubun(Code dairiInputKubun) {
        this.dairiInputKubun = dairiInputKubun;
    }

    /**
     * 代理記載者入力区分の名称のgetメソッドです。
     * <br/>
     * <br/>0：代理記載者入力無し、 1：住基（宛名）検索、 2：直接入力
     *
     * @return 代理記載者入力区分の名称
     */
    public RString getDairiInputKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.代理記載者入力区分.getCodeShubetsu(), dairiInputKubun);
    }

    /**
     * 代理記載者入力区分の略称のgetメソッドです。
     * <br/>
     * <br/>0：代理記載者入力無し、 1：住基（宛名）検索、 2：直接入力
     *
     * @return 代理記載者入力区分の略称
     */
    public RString getDairiInputKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.代理記載者入力区分.getCodeShubetsu(), dairiInputKubun);
    }

    /**
     * 代理記載者入力区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>0：代理記載者入力無し、 1：住基（宛名）検索、 2：直接入力
     *
     * @return 代理記載者入力区分のDescription
     */
    public RString getDairiInputKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.代理記載者入力区分.getCodeShubetsu(), dairiInputKubun);
    }

    /**
     * 代理記載者識別コードのgetメソッドです。
     * <br/>
     * <br/>代理記載者入力区分＝2の場合、検索した結果の識別コードをセット
     *
     * @return 代理記載者識別コード
     */
    @CheckForNull
    public ShikibetsuCode getDairiShikibetsuCode() {
        return dairiShikibetsuCode;
    }

    /**
     * 代理記載者識別コードのsetメソッドです。
     * <br/>
     * <br/>代理記載者入力区分＝2の場合、検索した結果の識別コードをセット
     *
     * @param dairiShikibetsuCode 代理記載者識別コード
     */
    public void setDairiShikibetsuCode(ShikibetsuCode dairiShikibetsuCode) {
        this.dairiShikibetsuCode = dairiShikibetsuCode;
    }

    /**
     * 代理記載者漢字氏名のgetメソッドです。
     *
     * @return 代理記載者漢字氏名
     */
    @CheckForNull
    public AtenaMeisho getDairiKanjiShimei() {
        return dairiKanjiShimei;
    }

    /**
     * 代理記載者漢字氏名のsetメソッドです。
     *
     * @param dairiKanjiShimei 代理記載者漢字氏名
     */
    public void setDairiKanjiShimei(AtenaMeisho dairiKanjiShimei) {
        this.dairiKanjiShimei = dairiKanjiShimei;
    }

    /**
     * 代理記載者カナ氏名のgetメソッドです。
     *
     * @return 代理記載者カナ氏名
     */
    @CheckForNull
    public AtenaKanaMeisho getDairiKanaShimei() {
        return dairiKanaShimei;
    }

    /**
     * 代理記載者カナ氏名のsetメソッドです。
     *
     * @param dairiKanaShimei 代理記載者カナ氏名
     */
    public void setDairiKanaShimei(AtenaKanaMeisho dairiKanaShimei) {
        this.dairiKanaShimei = dairiKanaShimei;
    }

    /**
     * 代理記載者生年月日のgetメソッドです。
     *
     * @return 代理記載者生年月日
     */
    @CheckForNull
    public FlexibleDate getDairiSeinengappiYMD() {
        return dairiSeinengappiYMD;
    }

    /**
     * 代理記載者生年月日のsetメソッドです。
     *
     * @param dairiSeinengappiYMD 代理記載者生年月日
     */
    public void setDairiSeinengappiYMD(FlexibleDate dairiSeinengappiYMD) {
        this.dairiSeinengappiYMD = dairiSeinengappiYMD;
    }

    /**
     * 代理記載者性別コードのgetメソッドです。
     *
     * @return 代理記載者性別コード
     */
    @CheckForNull
    public RString getDairiSeibetsuCode() {
        return dairiSeibetsuCode;
    }

    /**
     * 代理記載者性別コードのsetメソッドです。
     *
     * @param dairiSeibetsuCode 代理記載者性別コード
     */
    public void setDairiSeibetsuCode(RString dairiSeibetsuCode) {
        this.dairiSeibetsuCode = dairiSeibetsuCode;
    }

    /**
     * 代理記載者郵便番号のgetメソッドです。
     *
     * @return 代理記載者郵便番号
     */
    @CheckForNull
    public YubinNo getDairiYubinNo() {
        return dairiYubinNo;
    }

    /**
     * 代理記載者郵便番号のsetメソッドです。
     *
     * @param dairiYubinNo 代理記載者郵便番号
     */
    public void setDairiYubinNo(YubinNo dairiYubinNo) {
        this.dairiYubinNo = dairiYubinNo;
    }

    /**
     * 代理記載者住所のgetメソッドです。
     *
     * @return 代理記載者住所
     */
    @CheckForNull
    public AtenaJusho getDairiJusho() {
        return dairiJusho;
    }

    /**
     * 代理記載者住所のsetメソッドです。
     *
     * @param dairiJusho 代理記載者住所
     */
    public void setDairiJusho(AtenaJusho dairiJusho) {
        this.dairiJusho = dairiJusho;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT115FuzaishaTohyoShikakuYubinEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal AfT115FuzaishaTohyoShikakuYubinEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT115FuzaishaTohyoShikakuYubinEntity other) {
        if (other == null) {
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
    public void shallowCopy(AfT115FuzaishaTohyoShikakuYubinEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.seq = entity.seq;
        this.shogaiTechoAriFlag = entity.shogaiTechoAriFlag;
        this.senshoTechoAriFlag = entity.senshoTechoAriFlag;
        this.kaigoHokenshoAriFlag = entity.kaigoHokenshoAriFlag;
        this.dairiInputKubun = entity.dairiInputKubun;
        this.dairiShikibetsuCode = entity.dairiShikibetsuCode;
        this.dairiKanjiShimei = entity.dairiKanjiShimei;
        this.dairiKanaShimei = entity.dairiKanaShimei;
        this.dairiSeinengappiYMD = entity.dairiSeinengappiYMD;
        this.dairiSeibetsuCode = entity.dairiSeibetsuCode;
        this.dairiYubinNo = entity.dairiYubinNo;
        this.dairiJusho = entity.dairiJusho;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, seq, shogaiTechoAriFlag, senshoTechoAriFlag, kaigoHokenshoAriFlag, dairiInputKubun, dairiShikibetsuCode, dairiKanjiShimei, dairiKanaShimei, dairiSeinengappiYMD, dairiSeibetsuCode, dairiYubinNo, dairiJusho);
    }

}
