package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 在外選挙人申請の状態を保持する。テーブルのエンティティクラスです。
 */
public class AfT124ZaigaiSenkyoninShinseiEntity extends DbTableEntityBase<AfT124ZaigaiSenkyoninShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT124ZaigaiSenkyoninShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int shinseiNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate juteiYMD;
    private RString ryojikanCode;
    private RString kokusekiCode;
    private AtenaMeisho shinseishaShimei;
    private AtenaKanaMeisho shinseishaKanaShimei;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private Code shinseiKubun;
    private FlexibleDate shinseiYMD;
    private FlexibleDate henkoYMD;
    private Code henkoJiyuCode;
    private FlexibleDate torisageYMD;
    private Code torisageJiyuCode;
    private FlexibleDate kyakkaYMD;
    private Code kyakkaJiyuCode;
    private FlexibleDate honsekiShokaiYMD;
    private FlexibleDate honsekiKaitoYMD;
    private FlexibleDate honsekiTsuchiYMD;
    private RString tokkiJiko;

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
     * 申請番号のgetメソッドです。
     *
     * @return 申請番号
     */
    public int getShinseiNo() {
        return shinseiNo;
    }

    /**
     * 申請番号のsetメソッドです。
     *
     * @param shinseiNo 申請番号
     */
    public void setShinseiNo(@Nonnull int shinseiNo) {
        this.shinseiNo = shinseiNo;
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
     * 住定年月日のgetメソッドです。
     *
     * @return 住定年月日
     */
    @CheckForNull
    public FlexibleDate getJuteiYMD() {
        return juteiYMD;
    }

    /**
     * 住定年月日のsetメソッドです。
     *
     * @param juteiYMD 住定年月日
     */
    public void setJuteiYMD(FlexibleDate juteiYMD) {
        this.juteiYMD = juteiYMD;
    }

    /**
     * 領事官コードのgetメソッドです。
     *
     * @return 領事官コード
     */
    @CheckForNull
    public RString getRyojikanCode() {
        return ryojikanCode;
    }

    /**
     * 領事官コードのsetメソッドです。
     *
     * @param ryojikanCode 領事官コード
     */
    public void setRyojikanCode(RString ryojikanCode) {
        this.ryojikanCode = ryojikanCode;
    }

    /**
     * 国籍コードのgetメソッドです。
     *
     * @return 国籍コード
     */
    @CheckForNull
    public RString getKokusekiCode() {
        return kokusekiCode;
    }

    /**
     * 国籍コードのsetメソッドです。
     *
     * @param kokusekiCode 国籍コード
     */
    public void setKokusekiCode(RString kokusekiCode) {
        this.kokusekiCode = kokusekiCode;
    }

    /**
     * 申請者氏名のgetメソッドです。
     *
     * @return 申請者氏名
     */
    @CheckForNull
    public AtenaMeisho getShinseishaShimei() {
        return shinseishaShimei;
    }

    /**
     * 申請者氏名のsetメソッドです。
     *
     * @param shinseishaShimei 申請者氏名
     */
    public void setShinseishaShimei(AtenaMeisho shinseishaShimei) {
        this.shinseishaShimei = shinseishaShimei;
    }

    /**
     * 申請者カナ氏名のgetメソッドです。
     *
     * @return 申請者カナ氏名
     */
    @CheckForNull
    public AtenaKanaMeisho getShinseishaKanaShimei() {
        return shinseishaKanaShimei;
    }

    /**
     * 申請者カナ氏名のsetメソッドです。
     *
     * @param shinseishaKanaShimei 申請者カナ氏名
     */
    public void setShinseishaKanaShimei(AtenaKanaMeisho shinseishaKanaShimei) {
        this.shinseishaKanaShimei = shinseishaKanaShimei;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    @CheckForNull
    public FlexibleDate getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     *
     * @param seinengappiYMD 生年月日
     */
    public void setSeinengappiYMD(FlexibleDate seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    @CheckForNull
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * 性別コードのsetメソッドです。
     *
     * @param seibetsuCode 性別コード
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * 申請区分のgetメソッドです。
     * <br/>
     * <br/>"1"：申請、"2"；取下、"3"：却下
     *
     * @return 申請区分
     */
    @CheckForNull
    public Code getShinseiKubun() {
        return shinseiKubun;
    }

    /**
     * 申請区分のsetメソッドです。
     * <br/>
     * <br/>"1"：申請、"2"；取下、"3"：却下
     *
     * @param shinseiKubun 申請区分
     */
    public void setShinseiKubun(Code shinseiKubun) {
        this.shinseiKubun = shinseiKubun;
    }

    /**
     * 申請区分の名称のgetメソッドです。
     * <br/>
     * <br/>"1"：申請、"2"；取下、"3"：却下
     *
     * @return 申請区分の名称
     */
    public RString getShinseiKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請区分.getCodeShubetsu(), shinseiKubun);
    }

    /**
     * 申請区分の略称のgetメソッドです。
     * <br/>
     * <br/>"1"：申請、"2"；取下、"3"：却下
     *
     * @return 申請区分の略称
     */
    public RString getShinseiKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請区分.getCodeShubetsu(), shinseiKubun);
    }

    /**
     * 申請区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>"1"：申請、"2"；取下、"3"：却下
     *
     * @return 申請区分のDescription
     */
    public RString getShinseiKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請区分.getCodeShubetsu(), shinseiKubun);
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 申請内容変更年月日のgetメソッドです。
     *
     * @return 申請内容変更年月日
     */
    @CheckForNull
    public FlexibleDate getHenkoYMD() {
        return henkoYMD;
    }

    /**
     * 申請内容変更年月日のsetメソッドです。
     *
     * @param henkoYMD 申請内容変更年月日
     */
    public void setHenkoYMD(FlexibleDate henkoYMD) {
        this.henkoYMD = henkoYMD;
    }

    /**
     * 申請内容変更事由コードのgetメソッドです。
     *
     * @return 申請内容変更事由コード
     */
    @CheckForNull
    public Code getHenkoJiyuCode() {
        return henkoJiyuCode;
    }

    /**
     * 申請内容変更事由コードのsetメソッドです。
     *
     * @param henkoJiyuCode 申請内容変更事由コード
     */
    public void setHenkoJiyuCode(Code henkoJiyuCode) {
        this.henkoJiyuCode = henkoJiyuCode;
    }

    /**
     * 申請内容変更事由コードの名称のgetメソッドです。
     *
     * @return 申請内容変更事由コードの名称
     */
    public RString getHenkoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), henkoJiyuCode);
    }

    /**
     * 申請内容変更事由コードの略称のgetメソッドです。
     *
     * @return 申請内容変更事由コードの略称
     */
    public RString getHenkoJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), henkoJiyuCode);
    }

    /**
     * 申請内容変更事由コードのDescriptionのgetメソッドです。
     *
     * @return 申請内容変更事由コードのDescription
     */
    public RString getHenkoJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), henkoJiyuCode);
    }

    /**
     * 申請取下年月日のgetメソッドです。
     * <br/>
     * <br/>選挙人本人からの申請取消をした日
     *
     * @return 申請取下年月日
     */
    @CheckForNull
    public FlexibleDate getTorisageYMD() {
        return torisageYMD;
    }

    /**
     * 申請取下年月日のsetメソッドです。
     * <br/>
     * <br/>選挙人本人からの申請取消をした日
     *
     * @param torisageYMD 申請取下年月日
     */
    public void setTorisageYMD(FlexibleDate torisageYMD) {
        this.torisageYMD = torisageYMD;
    }

    /**
     * 申請取下事由コードのgetメソッドです。
     *
     * @return 申請取下事由コード
     */
    @CheckForNull
    public Code getTorisageJiyuCode() {
        return torisageJiyuCode;
    }

    /**
     * 申請取下事由コードのsetメソッドです。
     *
     * @param torisageJiyuCode 申請取下事由コード
     */
    public void setTorisageJiyuCode(Code torisageJiyuCode) {
        this.torisageJiyuCode = torisageJiyuCode;
    }

    /**
     * 申請取下事由コードの名称のgetメソッドです。
     *
     * @return 申請取下事由コードの名称
     */
    public RString getTorisageJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), torisageJiyuCode);
    }

    /**
     * 申請取下事由コードの略称のgetメソッドです。
     *
     * @return 申請取下事由コードの略称
     */
    public RString getTorisageJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), torisageJiyuCode);
    }

    /**
     * 申請取下事由コードのDescriptionのgetメソッドです。
     *
     * @return 申請取下事由コードのDescription
     */
    public RString getTorisageJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), torisageJiyuCode);
    }

    /**
     * 却下年月日のgetメソッドです。
     * <br/>
     * <br/>選管で、申請を受け付けられない判断をした日
     *
     * @return 却下年月日
     */
    @CheckForNull
    public FlexibleDate getKyakkaYMD() {
        return kyakkaYMD;
    }

    /**
     * 却下年月日のsetメソッドです。
     * <br/>
     * <br/>選管で、申請を受け付けられない判断をした日
     *
     * @param kyakkaYMD 却下年月日
     */
    public void setKyakkaYMD(FlexibleDate kyakkaYMD) {
        this.kyakkaYMD = kyakkaYMD;
    }

    /**
     * 却下事由コードのgetメソッドです。
     *
     * @return 却下事由コード
     */
    @CheckForNull
    public Code getKyakkaJiyuCode() {
        return kyakkaJiyuCode;
    }

    /**
     * 却下事由コードのsetメソッドです。
     *
     * @param kyakkaJiyuCode 却下事由コード
     */
    public void setKyakkaJiyuCode(Code kyakkaJiyuCode) {
        this.kyakkaJiyuCode = kyakkaJiyuCode;
    }

    /**
     * 却下事由コードの名称のgetメソッドです。
     *
     * @return 却下事由コードの名称
     */
    public RString getKyakkaJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.却下事由コード.getCodeShubetsu(), kyakkaJiyuCode);
    }

    /**
     * 却下事由コードの略称のgetメソッドです。
     *
     * @return 却下事由コードの略称
     */
    public RString getKyakkaJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.却下事由コード.getCodeShubetsu(), kyakkaJiyuCode);
    }

    /**
     * 却下事由コードのDescriptionのgetメソッドです。
     *
     * @return 却下事由コードのDescription
     */
    public RString getKyakkaJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.却下事由コード.getCodeShubetsu(), kyakkaJiyuCode);
    }

    /**
     * 本籍地照会年月日のgetメソッドです。
     *
     * @return 本籍地照会年月日
     */
    @CheckForNull
    public FlexibleDate getHonsekiShokaiYMD() {
        return honsekiShokaiYMD;
    }

    /**
     * 本籍地照会年月日のsetメソッドです。
     *
     * @param honsekiShokaiYMD 本籍地照会年月日
     */
    public void setHonsekiShokaiYMD(FlexibleDate honsekiShokaiYMD) {
        this.honsekiShokaiYMD = honsekiShokaiYMD;
    }

    /**
     * 本籍地回答年月日のgetメソッドです。
     *
     * @return 本籍地回答年月日
     */
    @CheckForNull
    public FlexibleDate getHonsekiKaitoYMD() {
        return honsekiKaitoYMD;
    }

    /**
     * 本籍地回答年月日のsetメソッドです。
     *
     * @param honsekiKaitoYMD 本籍地回答年月日
     */
    public void setHonsekiKaitoYMD(FlexibleDate honsekiKaitoYMD) {
        this.honsekiKaitoYMD = honsekiKaitoYMD;
    }

    /**
     * 本籍地通知年月日のgetメソッドです。
     *
     * @return 本籍地通知年月日
     */
    @CheckForNull
    public FlexibleDate getHonsekiTsuchiYMD() {
        return honsekiTsuchiYMD;
    }

    /**
     * 本籍地通知年月日のsetメソッドです。
     *
     * @param honsekiTsuchiYMD 本籍地通知年月日
     */
    public void setHonsekiTsuchiYMD(FlexibleDate honsekiTsuchiYMD) {
        this.honsekiTsuchiYMD = honsekiTsuchiYMD;
    }

    /**
     * tokkiJikoのgetメソッドです。
     *
     * @return tokkiJiko
     */
    @CheckForNull
    public RString getTokkiJiko() {
        return tokkiJiko;
    }

    /**
     * tokkiJikoのsetメソッドです。
     *
     * @param tokkiJiko tokkiJiko
     */
    public void setTokkiJiko(RString tokkiJiko) {
        this.tokkiJiko = tokkiJiko;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT124ZaigaiSenkyoninShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT124ZaigaiSenkyoninShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT124ZaigaiSenkyoninShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (this.shinseiNo != other.shinseiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        this.shinseiNo = entity.shinseiNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.juteiYMD = entity.juteiYMD;
        this.ryojikanCode = entity.ryojikanCode;
        this.kokusekiCode = entity.kokusekiCode;
        this.shinseishaShimei = entity.shinseishaShimei;
        this.shinseishaKanaShimei = entity.shinseishaKanaShimei;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.shinseiKubun = entity.shinseiKubun;
        this.shinseiYMD = entity.shinseiYMD;
        this.henkoYMD = entity.henkoYMD;
        this.henkoJiyuCode = entity.henkoJiyuCode;
        this.torisageYMD = entity.torisageYMD;
        this.torisageJiyuCode = entity.torisageJiyuCode;
        this.kyakkaYMD = entity.kyakkaYMD;
        this.kyakkaJiyuCode = entity.kyakkaJiyuCode;
        this.honsekiShokaiYMD = entity.honsekiShokaiYMD;
        this.honsekiKaitoYMD = entity.honsekiKaitoYMD;
        this.honsekiTsuchiYMD = entity.honsekiTsuchiYMD;
        this.tokkiJiko = entity.tokkiJiko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseiNo, shikibetsuCode, juteiYMD, ryojikanCode, kokusekiCode, shinseishaShimei, shinseishaKanaShimei, seinengappiYMD, seibetsuCode, shinseiKubun, shinseiYMD, henkoYMD, henkoJiyuCode, torisageYMD, torisageJiyuCode, kyakkaYMD, kyakkaJiyuCode, honsekiShokaiYMD, honsekiKaitoYMD, honsekiTsuchiYMD, tokkiJiko);
    }

// </editor-fold>
}
