package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.KatagakiCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.MailAddress;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 本籍地住所、国外転出前最終住所、国内転入住所の国内での住所情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT123ZaigaiSenkyoninJushoEntity extends DbTableEntityBase<AfT123ZaigaiSenkyoninJushoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT123ZaigaiSenkyoninJusho");

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
    private int shinseiNo;
    @PrimaryKey
    private Code jushoShuruiKubun;
    private YubinNo yubinNo;
    private ZenkokuJushoCode zenkokuJushoCode;
    private AtenaJusho jusho;
    private AtenaBanchi banchi;
    private KatagakiCode katagakiCode;
    private Katagaki katagaki;
    private RString dokyoKazokuShimei;
    private RString tel;
    private RString fax;
    private MailAddress mail;
    private FlexibleDate kokugaiTenshutsuYMD;
    private FlexibleDate kokunaiTennyuYMD;

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
     * 住所種類区分のgetメソッドです。
     * <br/>
     * <br/>1：本籍地住所　2：国外転出前最終住所　3：国内転入先住所 4：海外住所 5：海外送付先住所
     *
     * @return 住所種類区分
     */
    public Code getJushoShuruiKubun() {
        return jushoShuruiKubun;
    }

    /**
     * 住所種類区分のsetメソッドです。
     * <br/>
     * <br/>1：本籍地住所　2：国外転出前最終住所　3：国内転入先住所 4：海外住所 5：海外送付先住所
     *
     * @param jushoShuruiKubun 住所種類区分
     */
    public void setJushoShuruiKubun(@Nonnull Code jushoShuruiKubun) {
        this.jushoShuruiKubun = jushoShuruiKubun;
    }

    /**
     * 住所種類区分の名称のgetメソッドです。
     * <br/>
     * <br/>1：本籍地住所　2：国外転出前最終住所　3：国内転入先住所 4：海外住所 5：海外送付先住所
     *
     * @return 住所種類区分の名称
     */
    public RString getJushoShuruiKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.住所種類区分.getCodeShubetsu(), jushoShuruiKubun);
    }

    /**
     * 住所種類区分の略称のgetメソッドです。
     * <br/>
     * <br/>1：本籍地住所　2：国外転出前最終住所　3：国内転入先住所 4：海外住所 5：海外送付先住所
     *
     * @return 住所種類区分の略称
     */
    public RString getJushoShuruiKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.住所種類区分.getCodeShubetsu(), jushoShuruiKubun);
    }

    /**
     * 住所種類区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>1：本籍地住所　2：国外転出前最終住所　3：国内転入先住所 4：海外住所 5：海外送付先住所
     *
     * @return 住所種類区分のDescription
     */
    public RString getJushoShuruiKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.住所種類区分.getCodeShubetsu(), jushoShuruiKubun);
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     *
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 全国住所コードのgetメソッドです。
     *
     * @return 全国住所コード
     */
    @CheckForNull
    public ZenkokuJushoCode getZenkokuJushoCode() {
        return zenkokuJushoCode;
    }

    /**
     * 全国住所コードのsetメソッドです。
     *
     * @param zenkokuJushoCode 全国住所コード
     */
    public void setZenkokuJushoCode(ZenkokuJushoCode zenkokuJushoCode) {
        this.zenkokuJushoCode = zenkokuJushoCode;
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    @CheckForNull
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * 番地のgetメソッドです。
     *
     * @return 番地
     */
    @CheckForNull
    public AtenaBanchi getBanchi() {
        return banchi;
    }

    /**
     * 番地のsetメソッドです。
     *
     * @param banchi 番地
     */
    public void setBanchi(AtenaBanchi banchi) {
        this.banchi = banchi;
    }

    /**
     * 方書コードのgetメソッドです。
     *
     * @return 方書コード
     */
    @CheckForNull
    public KatagakiCode getKatagakiCode() {
        return katagakiCode;
    }

    /**
     * 方書コードのsetメソッドです。
     *
     * @param katagakiCode 方書コード
     */
    public void setKatagakiCode(KatagakiCode katagakiCode) {
        this.katagakiCode = katagakiCode;
    }

    /**
     * 方書のgetメソッドです。
     *
     * @return 方書
     */
    @CheckForNull
    public Katagaki getKatagaki() {
        return katagaki;
    }

    /**
     * 方書のsetメソッドです。
     *
     * @param katagaki 方書
     */
    public void setKatagaki(Katagaki katagaki) {
        this.katagaki = katagaki;
    }

    /**
     * 同居家族氏名のgetメソッドです。
     * <br/>
     * <br/>申請時の情報。複数人数の記入可。送付先の場合は、送付先宛名
     *
     * @return 同居家族氏名
     */
    @CheckForNull
    public RString getDokyoKazokuShimei() {
        return dokyoKazokuShimei;
    }

    /**
     * 同居家族氏名のsetメソッドです。
     * <br/>
     * <br/>申請時の情報。複数人数の記入可。送付先の場合は、送付先宛名
     *
     * @param dokyoKazokuShimei 同居家族氏名
     */
    public void setDokyoKazokuShimei(RString dokyoKazokuShimei) {
        this.dokyoKazokuShimei = dokyoKazokuShimei;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    @CheckForNull
    public RString getTel() {
        return tel;
    }

    /**
     * 電話番号のsetメソッドです。
     *
     * @param tel 電話番号
     */
    public void setTel(RString tel) {
        this.tel = tel;
    }

    /**
     * FAX番号のgetメソッドです。
     *
     * @return FAX番号
     */
    @CheckForNull
    public RString getFax() {
        return fax;
    }

    /**
     * FAX番号のsetメソッドです。
     *
     * @param fax FAX番号
     */
    public void setFax(RString fax) {
        this.fax = fax;
    }

    /**
     * メールアドレスのgetメソッドです。
     *
     * @return メールアドレス
     */
    @CheckForNull
    public MailAddress getMail() {
        return mail;
    }

    /**
     * メールアドレスのsetメソッドです。
     *
     * @param mail メールアドレス
     */
    public void setMail(MailAddress mail) {
        this.mail = mail;
    }

    /**
     * 国外転出年月日のgetメソッドです。
     * <br/>
     * <br/>住所種類＝2の時
     *
     * @return 国外転出年月日
     */
    @CheckForNull
    public FlexibleDate getKokugaiTenshutsuYMD() {
        return kokugaiTenshutsuYMD;
    }

    /**
     * 国外転出年月日のsetメソッドです。
     * <br/>
     * <br/>住所種類＝2の時
     *
     * @param kokugaiTenshutsuYMD 国外転出年月日
     */
    public void setKokugaiTenshutsuYMD(FlexibleDate kokugaiTenshutsuYMD) {
        this.kokugaiTenshutsuYMD = kokugaiTenshutsuYMD;
    }

    /**
     * 国内転入年月日のgetメソッドです。
     * <br/>
     * <br/>住所種類＝3の時
     *
     * @return 国内転入年月日
     */
    @CheckForNull
    public FlexibleDate getKokunaiTennyuYMD() {
        return kokunaiTennyuYMD;
    }

    /**
     * 国内転入年月日のsetメソッドです。
     * <br/>
     * <br/>住所種類＝3の時
     *
     * @param kokunaiTennyuYMD 国内転入年月日
     */
    public void setKokunaiTennyuYMD(FlexibleDate kokunaiTennyuYMD) {
        this.kokunaiTennyuYMD = kokunaiTennyuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT123ZaigaiSenkyoninJushoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT123ZaigaiSenkyoninJushoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT123ZaigaiSenkyoninJushoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (this.shinseiNo != other.shinseiNo) {
            return false;
        }
        if (!Objects.equals(this.jushoShuruiKubun, other.jushoShuruiKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT123ZaigaiSenkyoninJushoEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shinseiNo = entity.shinseiNo;
        this.jushoShuruiKubun = entity.jushoShuruiKubun;
        this.yubinNo = entity.yubinNo;
        this.zenkokuJushoCode = entity.zenkokuJushoCode;
        this.jusho = entity.jusho;
        this.banchi = entity.banchi;
        this.katagakiCode = entity.katagakiCode;
        this.katagaki = entity.katagaki;
        this.dokyoKazokuShimei = entity.dokyoKazokuShimei;
        this.tel = entity.tel;
        this.fax = entity.fax;
        this.mail = entity.mail;
        this.kokugaiTenshutsuYMD = entity.kokugaiTenshutsuYMD;
        this.kokunaiTennyuYMD = entity.kokunaiTennyuYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, shinseiNo, jushoShuruiKubun, yubinNo, zenkokuJushoCode, jusho, banchi, katagakiCode, katagaki, dokyoKazokuShimei, tel, fax, mail, kokugaiTenshutsuYMD, kokunaiTennyuYMD);
    }

// </editor-fold>
}
