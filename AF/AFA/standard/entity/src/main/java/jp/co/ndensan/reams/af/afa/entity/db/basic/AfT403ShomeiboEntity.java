package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 直接請求に対し、署名した住民の情報を保持。 有効無効情報も保持し、集計に使用する。テーブルのエンティティクラスです。
 */
public class AfT403ShomeiboEntity extends DbTableEntityBase<AfT403ShomeiboEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT403Shomeibo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int seikyuNo;
    @PrimaryKey
    private RString satsu;
    @PrimaryKey
    private int page;
    @PrimaryKey
    private int gyo;
    private Code shinsaKubun;
    private Code mukoJiyuCode;
    private FlexibleDate shomeiYMD;
    private ShikibetsuCode shomeishaShikibetsuCode;
    private AtenaMeisho kanjiShimei;
    private AtenaKanaMeisho kanaShimei;
    private AtenaKanaMeisho searchKanaShimei;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private AtenaJusho jusho;
    private ShikibetsuCode daihitsushaShikibetsuCode;
    private AtenaMeisho daihitsushaKanjiShimei;
    private FlexibleDate daihitsushaSeinengappiYMD;
    private RString daihitsushaSeibetsuCode;
    private AtenaJusho daihitsushaJusho;

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
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return seikyuNo;
    }

    /**
     * 直接請求番号のsetメソッドです。
     *
     * @param seikyuNo 直接請求番号
     */
    public void setSeikyuNo(@Nonnull int seikyuNo) {
        this.seikyuNo = seikyuNo;
    }

    /**
     * 冊のgetメソッドです。
     *
     * @return 冊
     */
    public RString getSatsu() {
        return satsu;
    }

    /**
     * 冊のsetメソッドです。
     *
     * @param satsu 冊
     */
    public void setSatsu(@Nonnull RString satsu) {
        this.satsu = satsu;
    }

    /**
     * 頁のgetメソッドです。
     *
     * @return 頁
     */
    public int getPage() {
        return page;
    }

    /**
     * 頁のsetメソッドです。
     *
     * @param page 頁
     */
    public void setPage(@Nonnull int page) {
        this.page = page;
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    public int getGyo() {
        return gyo;
    }

    /**
     * 行のsetメソッドです。
     *
     * @param gyo 行
     */
    public void setGyo(@Nonnull int gyo) {
        this.gyo = gyo;
    }

    /**
     * 審査区分のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分
     */
    @CheckForNull
    public Code getShinsaKubun() {
        return shinsaKubun;
    }

    /**
     * 審査区分のsetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @param shinsaKubun 審査区分
     */
    public void setShinsaKubun(Code shinsaKubun) {
        this.shinsaKubun = shinsaKubun;
    }

    /**
     * 審査区分の名称のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分の名称
     */
    public RString getShinsaKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(), shinsaKubun);
    }

    /**
     * 審査区分の略称のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分の略称
     */
    public RString getShinsaKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(), shinsaKubun);
    }

    /**
     * 審査区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分のDescription
     */
    public RString getShinsaKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(), shinsaKubun);
    }

    /**
     * 無効事由コードのgetメソッドです。
     *
     * @return 無効事由コード
     */
    @CheckForNull
    public Code getMukoJiyuCode() {
        return mukoJiyuCode;
    }

    /**
     * 無効事由コードのsetメソッドです。
     *
     * @param mukoJiyuCode 無効事由コード
     */
    public void setMukoJiyuCode(Code mukoJiyuCode) {
        this.mukoJiyuCode = mukoJiyuCode;
    }

    /**
     * 無効事由コードの名称のgetメソッドです。
     *
     * @return 無効事由コードの名称
     */
    public RString getMukoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.無効事由コード.getCodeShubetsu(), mukoJiyuCode);
    }

    /**
     * 無効事由コードの略称のgetメソッドです。
     *
     * @return 無効事由コードの略称
     */
    public RString getMukoJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.無効事由コード.getCodeShubetsu(), mukoJiyuCode);
    }

    /**
     * 無効事由コードのDescriptionのgetメソッドです。
     *
     * @return 無効事由コードのDescription
     */
    public RString getMukoJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.無効事由コード.getCodeShubetsu(), mukoJiyuCode);
    }

    /**
     * 署名年月日のgetメソッドです。
     * <br/>
     * <br/>署名人が記入した日付を入力するため、暦上日とは限らない
     *
     * @return 署名年月日
     */
    @CheckForNull
    public FlexibleDate getShomeiYMD() {
        return shomeiYMD;
    }

    /**
     * 署名年月日のsetメソッドです。
     * <br/>
     * <br/>署名人が記入した日付を入力するため、暦上日とは限らない
     *
     * @param shomeiYMD 署名年月日
     */
    public void setShomeiYMD(FlexibleDate shomeiYMD) {
        this.shomeiYMD = shomeiYMD;
    }

    /**
     * 署名者識別コードのgetメソッドです。
     *
     * @return 署名者識別コード
     */
    @CheckForNull
    public ShikibetsuCode getShomeishaShikibetsuCode() {
        return shomeishaShikibetsuCode;
    }

    /**
     * 署名者識別コードのsetメソッドです。
     *
     * @param shomeishaShikibetsuCode 署名者識別コード
     */
    public void setShomeishaShikibetsuCode(ShikibetsuCode shomeishaShikibetsuCode) {
        this.shomeishaShikibetsuCode = shomeishaShikibetsuCode;
    }

    /**
     * 漢字氏名のgetメソッドです。
     *
     * @return 漢字氏名
     */
    @CheckForNull
    public AtenaMeisho getKanjiShimei() {
        return kanjiShimei;
    }

    /**
     * 漢字氏名のsetメソッドです。
     *
     * @param kanjiShimei 漢字氏名
     */
    public void setKanjiShimei(AtenaMeisho kanjiShimei) {
        this.kanjiShimei = kanjiShimei;
    }

    /**
     * カナ氏名のgetメソッドです。
     *
     * @return カナ氏名
     */
    @CheckForNull
    public AtenaKanaMeisho getKanaShimei() {
        return kanaShimei;
    }

    /**
     * カナ氏名のsetメソッドです。
     *
     * @param kanaShimei カナ氏名
     */
    public void setKanaShimei(AtenaKanaMeisho kanaShimei) {
        this.kanaShimei = kanaShimei;
    }

    /**
     * 検索用カナ氏名のgetメソッドです。
     *
     * @return 検索用カナ氏名
     */
    @CheckForNull
    public AtenaKanaMeisho getSearchKanaShimei() {
        return searchKanaShimei;
    }

    /**
     * 検索用カナ氏名のsetメソッドです。
     *
     * @param searchKanaShimei 検索用カナ氏名
     */
    public void setSearchKanaShimei(AtenaKanaMeisho searchKanaShimei) {
        this.searchKanaShimei = searchKanaShimei;
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
     * 代筆者識別コードのgetメソッドです。
     *
     * @return 代筆者識別コード
     */
    @CheckForNull
    public ShikibetsuCode getDaihitsushaShikibetsuCode() {
        return daihitsushaShikibetsuCode;
    }

    /**
     * 代筆者識別コードのsetメソッドです。
     *
     * @param daihitsushaShikibetsuCode 代筆者識別コード
     */
    public void setDaihitsushaShikibetsuCode(ShikibetsuCode daihitsushaShikibetsuCode) {
        this.daihitsushaShikibetsuCode = daihitsushaShikibetsuCode;
    }

    /**
     * 代筆者漢字氏名のgetメソッドです。
     *
     * @return 代筆者漢字氏名
     */
    @CheckForNull
    public AtenaMeisho getDaihitsushaKanjiShimei() {
        return daihitsushaKanjiShimei;
    }

    /**
     * 代筆者漢字氏名のsetメソッドです。
     *
     * @param daihitsushaKanjiShimei 代筆者漢字氏名
     */
    public void setDaihitsushaKanjiShimei(AtenaMeisho daihitsushaKanjiShimei) {
        this.daihitsushaKanjiShimei = daihitsushaKanjiShimei;
    }

    /**
     * 代筆者生年月日のgetメソッドです。
     *
     * @return 代筆者生年月日
     */
    @CheckForNull
    public FlexibleDate getDaihitsushaSeinengappiYMD() {
        return daihitsushaSeinengappiYMD;
    }

    /**
     * 代筆者生年月日のsetメソッドです。
     *
     * @param daihitsushaSeinengappiYMD 代筆者生年月日
     */
    public void setDaihitsushaSeinengappiYMD(FlexibleDate daihitsushaSeinengappiYMD) {
        this.daihitsushaSeinengappiYMD = daihitsushaSeinengappiYMD;
    }

    /**
     * 代筆者性別コードのgetメソッドです。
     *
     * @return 代筆者性別コード
     */
    @CheckForNull
    public RString getDaihitsushaSeibetsuCode() {
        return daihitsushaSeibetsuCode;
    }

    /**
     * 代筆者性別コードのsetメソッドです。
     *
     * @param daihitsushaSeibetsuCode 代筆者性別コード
     */
    public void setDaihitsushaSeibetsuCode(RString daihitsushaSeibetsuCode) {
        this.daihitsushaSeibetsuCode = daihitsushaSeibetsuCode;
    }

    /**
     * 代筆者住所のgetメソッドです。
     *
     * @return 代筆者住所
     */
    @CheckForNull
    public AtenaJusho getDaihitsushaJusho() {
        return daihitsushaJusho;
    }

    /**
     * 代筆者住所のsetメソッドです。
     *
     * @param daihitsushaJusho 代筆者住所
     */
    public void setDaihitsushaJusho(AtenaJusho daihitsushaJusho) {
        this.daihitsushaJusho = daihitsushaJusho;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT403ShomeiboEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT403ShomeiboEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT403ShomeiboEntity other) {
        if (other == null) {
            return false;
        }
        if (this.seikyuNo != other.seikyuNo) {
            return false;
        }
        if (!Objects.equals(this.satsu, other.satsu)) {
            return false;
        }
        if (this.page != other.page) {
            return false;
        }
        if (this.gyo != other.gyo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT403ShomeiboEntity entity) {
        this.seikyuNo = entity.seikyuNo;
        this.satsu = entity.satsu;
        this.page = entity.page;
        this.gyo = entity.gyo;
        this.shinsaKubun = entity.shinsaKubun;
        this.mukoJiyuCode = entity.mukoJiyuCode;
        this.shomeiYMD = entity.shomeiYMD;
        this.shomeishaShikibetsuCode = entity.shomeishaShikibetsuCode;
        this.kanjiShimei = entity.kanjiShimei;
        this.kanaShimei = entity.kanaShimei;
        this.searchKanaShimei = entity.searchKanaShimei;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.jusho = entity.jusho;
        this.daihitsushaShikibetsuCode = entity.daihitsushaShikibetsuCode;
        this.daihitsushaKanjiShimei = entity.daihitsushaKanjiShimei;
        this.daihitsushaSeinengappiYMD = entity.daihitsushaSeinengappiYMD;
        this.daihitsushaSeibetsuCode = entity.daihitsushaSeibetsuCode;
        this.daihitsushaJusho = entity.daihitsushaJusho;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(seikyuNo, satsu, page, gyo, shinsaKubun, mukoJiyuCode, shomeiYMD, shomeishaShikibetsuCode, kanjiShimei, kanaShimei, searchKanaShimei, seinengappiYMD, seibetsuCode, jusho, daihitsushaShikibetsuCode, daihitsushaKanjiShimei, daihitsushaSeinengappiYMD, daihitsushaSeibetsuCode, daihitsushaJusho);
    }

// </editor-fold>
}
