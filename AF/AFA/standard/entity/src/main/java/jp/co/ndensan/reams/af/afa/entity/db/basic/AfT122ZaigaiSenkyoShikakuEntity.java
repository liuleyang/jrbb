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
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;

/**
 * 在外選挙での選挙資格の状態を保持する。テーブルのエンティティクラスです。
 */
public class AfT122ZaigaiSenkyoShikakuEntity extends DbTableEntityBase<AfT122ZaigaiSenkyoShikakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT122ZaigaiSenkyoShikaku");

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
    private Code kokuminTohyoKubun;
    private ShohonNo kokuminShohonNo;
    private Code honsekiTorokuKubun;
    private RString kofuNo;
    private FlexibleDate kofuYMD;
    private Code shikakuKubun;
    private RString tohyokuCode;
    private FlexibleDate meiboTorokuYMD;
    private FlexibleDate hyojiYMD;
    private Code hyojiJiyuCode;
    private FlexibleDate masshoYMD;
    private Code masshoJiyuCode;
    private Code shuseiKubun;
    private FlexibleDate shuseiYMD;
    private Code saiKofuJiyuCode;
    private Code henkoJiyuCode;
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
     * 国民投票区分のgetメソッドです。
     * <br/>
     * <br/>1：在外選挙資格（国民投票も可能）、 2：在外国民投票資格（申請した国民投票のみ可能）
     *
     * @return 国民投票区分
     */
    @CheckForNull
    public Code getKokuminTohyoKubun() {
        return kokuminTohyoKubun;
    }

    /**
     * 国民投票区分のsetメソッドです。
     * <br/>
     * <br/>1：在外選挙資格（国民投票も可能）、 2：在外国民投票資格（申請した国民投票のみ可能）
     *
     * @param kokuminTohyoKubun 国民投票区分
     */
    public void setKokuminTohyoKubun(Code kokuminTohyoKubun) {
        this.kokuminTohyoKubun = kokuminTohyoKubun;
    }

    /**
     * 国民投票区分の名称のgetメソッドです。
     * <br/>
     * <br/>1：在外選挙資格（国民投票も可能）、 2：在外国民投票資格（申請した国民投票のみ可能）
     *
     * @return 国民投票区分の名称
     */
    public RString getKokuminTohyoKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.国民投票区分.getCodeShubetsu(), kokuminTohyoKubun);
    }

    /**
     * 国民投票区分の略称のgetメソッドです。
     * <br/>
     * <br/>1：在外選挙資格（国民投票も可能）、 2：在外国民投票資格（申請した国民投票のみ可能）
     *
     * @return 国民投票区分の略称
     */
    public RString getKokuminTohyoKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.国民投票区分.getCodeShubetsu(), kokuminTohyoKubun);
    }

    /**
     * 国民投票区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>1：在外選挙資格（国民投票も可能）、 2：在外国民投票資格（申請した国民投票のみ可能）
     *
     * @return 国民投票区分のDescription
     */
    public RString getKokuminTohyoKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.国民投票区分.getCodeShubetsu(), kokuminTohyoKubun);
    }

    /**
     * 国民投票抄本番号のgetメソッドです。
     *
     * @return 国民投票抄本番号
     */
    @CheckForNull
    public ShohonNo getKokuminShohonNo() {
        return kokuminShohonNo;
    }

    /**
     * 国民投票抄本番号のsetメソッドです。
     *
     * @param kokuminShohonNo 国民投票抄本番号
     */
    public void setKokuminShohonNo(ShohonNo kokuminShohonNo) {
        this.kokuminShohonNo = kokuminShohonNo;
    }

    /**
     * 本籍地登録区分のgetメソッドです。
     * <br/>
     * <br/>本籍地登録の区分 0：国内最終住所で登録する、1：本籍地で登録する
     * 平成6年5月1日以降にいずれの市区町村においても住所を有していないとき、本籍地登録とする
     *
     * @return 本籍地登録区分
     */
    @CheckForNull
    public Code getHonsekiTorokuKubun() {
        return honsekiTorokuKubun;
    }

    /**
     * 本籍地登録区分のsetメソッドです。
     * <br/>
     * <br/>本籍地登録の区分 0：国内最終住所で登録する、1：本籍地で登録する
     * 平成6年5月1日以降にいずれの市区町村においても住所を有していないとき、本籍地登録とする
     *
     * @param honsekiTorokuKubun 本籍地登録区分
     */
    public void setHonsekiTorokuKubun(Code honsekiTorokuKubun) {
        this.honsekiTorokuKubun = honsekiTorokuKubun;
    }

    /**
     * 本籍地登録区分の名称のgetメソッドです。
     * <br/>
     * <br/>本籍地登録の区分 0：国内最終住所で登録する、1：本籍地で登録する
     * 平成6年5月1日以降にいずれの市区町村においても住所を有していないとき、本籍地登録とする
     *
     * @return 本籍地登録区分の名称
     */
    public RString getHonsekiTorokuKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.本籍地登録区分.getCodeShubetsu(), honsekiTorokuKubun);
    }

    /**
     * 本籍地登録区分の略称のgetメソッドです。
     * <br/>
     * <br/>本籍地登録の区分 0：国内最終住所で登録する、1：本籍地で登録する
     * 平成6年5月1日以降にいずれの市区町村においても住所を有していないとき、本籍地登録とする
     *
     * @return 本籍地登録区分の略称
     */
    public RString getHonsekiTorokuKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.本籍地登録区分.getCodeShubetsu(), honsekiTorokuKubun);
    }

    /**
     * 本籍地登録区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>本籍地登録の区分 0：国内最終住所で登録する、1：本籍地で登録する
     * 平成6年5月1日以降にいずれの市区町村においても住所を有していないとき、本籍地登録とする
     *
     * @return 本籍地登録区分のDescription
     */
    public RString getHonsekiTorokuKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.本籍地登録区分.getCodeShubetsu(), honsekiTorokuKubun);
    }

    /**
     * 交付番号のgetメソッドです。
     * <br/>
     * <br/>西暦下2桁＋市町村コード5桁＋通し（採番）3桁＋枝番1桁
     *
     * @return 交付番号
     */
    @CheckForNull
    public RString getKofuNo() {
        return kofuNo;
    }

    /**
     * 交付番号のsetメソッドです。
     * <br/>
     * <br/>西暦下2桁＋市町村コード5桁＋通し（採番）3桁＋枝番1桁
     *
     * @param kofuNo 交付番号
     */
    public void setKofuNo(RString kofuNo) {
        this.kofuNo = kofuNo;
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
     * 選挙資格区分のgetメソッドです。
     *
     * @return 選挙資格区分
     */
    @CheckForNull
    public Code getShikakuKubun() {
        return shikakuKubun;
    }

    /**
     * 選挙資格区分のsetメソッドです。
     *
     * @param shikakuKubun 選挙資格区分
     */
    public void setShikakuKubun(Code shikakuKubun) {
        this.shikakuKubun = shikakuKubun;
    }

    /**
     * 選挙資格区分の名称のgetメソッドです。
     *
     * @return 選挙資格区分の名称
     */
    public RString getShikakuKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), shikakuKubun);
    }

    /**
     * 選挙資格区分の略称のgetメソッドです。
     *
     * @return 選挙資格区分の略称
     */
    public RString getShikakuKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), shikakuKubun);
    }

    /**
     * 選挙資格区分のDescriptionのgetメソッドです。
     *
     * @return 選挙資格区分のDescription
     */
    public RString getShikakuKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), shikakuKubun);
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    @CheckForNull
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * 投票区コードのsetメソッドです。
     *
     * @param tohyokuCode 投票区コード
     */
    public void setTohyokuCode(RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * 名簿登録年月日のgetメソッドです。
     *
     * @return 名簿登録年月日
     */
    @CheckForNull
    public FlexibleDate getMeiboTorokuYMD() {
        return meiboTorokuYMD;
    }

    /**
     * 名簿登録年月日のsetメソッドです。
     *
     * @param meiboTorokuYMD 名簿登録年月日
     */
    public void setMeiboTorokuYMD(FlexibleDate meiboTorokuYMD) {
        this.meiboTorokuYMD = meiboTorokuYMD;
    }

    /**
     * 表示年月日のgetメソッドです。
     *
     * @return 表示年月日
     */
    @CheckForNull
    public FlexibleDate getHyojiYMD() {
        return hyojiYMD;
    }

    /**
     * 表示年月日のsetメソッドです。
     *
     * @param hyojiYMD 表示年月日
     */
    public void setHyojiYMD(FlexibleDate hyojiYMD) {
        this.hyojiYMD = hyojiYMD;
    }

    /**
     * 表示事由コードのgetメソッドです。
     *
     * @return 表示事由コード
     */
    @CheckForNull
    public Code getHyojiJiyuCode() {
        return hyojiJiyuCode;
    }

    /**
     * 表示事由コードのsetメソッドです。
     *
     * @param hyojiJiyuCode 表示事由コード
     */
    public void setHyojiJiyuCode(Code hyojiJiyuCode) {
        this.hyojiJiyuCode = hyojiJiyuCode;
    }

    /**
     * 表示事由コードの名称のgetメソッドです。
     *
     * @return 表示事由コードの名称
     */
    public RString getHyojiJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), hyojiJiyuCode);
    }

    /**
     * 表示事由コードの略称のgetメソッドです。
     *
     * @return 表示事由コードの略称
     */
    public RString getHyojiJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), hyojiJiyuCode);
    }

    /**
     * 表示事由コードのDescriptionのgetメソッドです。
     *
     * @return 表示事由コードのDescription
     */
    public RString getHyojiJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), hyojiJiyuCode);
    }

    /**
     * 抹消年月日のgetメソッドです。
     *
     * @return 抹消年月日
     */
    @CheckForNull
    public FlexibleDate getMasshoYMD() {
        return masshoYMD;
    }

    /**
     * 抹消年月日のsetメソッドです。
     *
     * @param masshoYMD 抹消年月日
     */
    public void setMasshoYMD(FlexibleDate masshoYMD) {
        this.masshoYMD = masshoYMD;
    }

    /**
     * 抹消事由コードのgetメソッドです。
     *
     * @return 抹消事由コード
     */
    @CheckForNull
    public Code getMasshoJiyuCode() {
        return masshoJiyuCode;
    }

    /**
     * 抹消事由コードのsetメソッドです。
     *
     * @param masshoJiyuCode 抹消事由コード
     */
    public void setMasshoJiyuCode(Code masshoJiyuCode) {
        this.masshoJiyuCode = masshoJiyuCode;
    }

    /**
     * 抹消事由コードの名称のgetメソッドです。
     *
     * @return 抹消事由コードの名称
     */
    public RString getMasshoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), masshoJiyuCode);
    }

    /**
     * 抹消事由コードの略称のgetメソッドです。
     *
     * @return 抹消事由コードの略称
     */
    public RString getMasshoJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), masshoJiyuCode);
    }

    /**
     * 抹消事由コードのDescriptionのgetメソッドです。
     *
     * @return 抹消事由コードのDescription
     */
    public RString getMasshoJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), masshoJiyuCode);
    }

    /**
     * 修正区分のgetメソッドです。
     * <br/>
     * <br/>1：再交付、2：記載事項変更
     *
     * @return 修正区分
     */
    @CheckForNull
    public Code getShuseiKubun() {
        return shuseiKubun;
    }

    /**
     * 修正区分のsetメソッドです。
     * <br/>
     * <br/>1：再交付、2：記載事項変更
     *
     * @param shuseiKubun 修正区分
     */
    public void setShuseiKubun(Code shuseiKubun) {
        this.shuseiKubun = shuseiKubun;
    }

    /**
     * 修正区分の名称のgetメソッドです。
     * <br/>
     * <br/>1：再交付、2：記載事項変更
     *
     * @return 修正区分の名称
     */
    public RString getShuseiKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.修正区分.getCodeShubetsu(), shuseiKubun);
    }

    /**
     * 修正区分の略称のgetメソッドです。
     * <br/>
     * <br/>1：再交付、2：記載事項変更
     *
     * @return 修正区分の略称
     */
    public RString getShuseiKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.修正区分.getCodeShubetsu(), shuseiKubun);
    }

    /**
     * 修正区分のDescriptionのgetメソッドです。
     * <br/>
     * <br/>1：再交付、2：記載事項変更
     *
     * @return 修正区分のDescription
     */
    public RString getShuseiKubunDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.修正区分.getCodeShubetsu(), shuseiKubun);
    }

    /**
     * 修正年月日のgetメソッドです。
     *
     * @return 修正年月日
     */
    @CheckForNull
    public FlexibleDate getShuseiYMD() {
        return shuseiYMD;
    }

    /**
     * 修正年月日のsetメソッドです。
     *
     * @param shuseiYMD 修正年月日
     */
    public void setShuseiYMD(FlexibleDate shuseiYMD) {
        this.shuseiYMD = shuseiYMD;
    }

    /**
     * 再交付事由コードのgetメソッドです。
     * <br/>
     * <br/>再交付事由
     *
     * @return 再交付事由コード
     */
    @CheckForNull
    public Code getSaiKofuJiyuCode() {
        return saiKofuJiyuCode;
    }

    /**
     * 再交付事由コードのsetメソッドです。
     * <br/>
     * <br/>再交付事由
     *
     * @param saiKofuJiyuCode 再交付事由コード
     */
    public void setSaiKofuJiyuCode(Code saiKofuJiyuCode) {
        this.saiKofuJiyuCode = saiKofuJiyuCode;
    }

    /**
     * 再交付事由コードの名称のgetメソッドです。
     * <br/>
     * <br/>再交付事由
     *
     * @return 再交付事由コードの名称
     */
    public RString getSaiKofuJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), saiKofuJiyuCode);
    }

    /**
     * 再交付事由コードの略称のgetメソッドです。
     * <br/>
     * <br/>再交付事由
     *
     * @return 再交付事由コードの略称
     */
    public RString getSaiKofuJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), saiKofuJiyuCode);
    }

    /**
     * 再交付事由コードのDescriptionのgetメソッドです。
     * <br/>
     * <br/>再交付事由
     *
     * @return 再交付事由コードのDescription
     */
    public RString getSaiKofuJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), saiKofuJiyuCode);
    }

    /**
     * 記載事項変更事由コードのgetメソッドです。
     * <br/>
     * <br/>申請内容変更事由コード　を使用する
     *
     * @return 記載事項変更事由コード
     */
    @CheckForNull
    public Code getHenkoJiyuCode() {
        return henkoJiyuCode;
    }

    /**
     * 記載事項変更事由コードのsetメソッドです。
     * <br/>
     * <br/>申請内容変更事由コード　を使用する
     *
     * @param henkoJiyuCode 記載事項変更事由コード
     */
    public void setHenkoJiyuCode(Code henkoJiyuCode) {
        this.henkoJiyuCode = henkoJiyuCode;
    }

    /**
     * 記載事項変更事由コードの名称のgetメソッドです。
     * <br/>
     * <br/>申請内容変更事由コード　を使用する
     *
     * @return 記載事項変更事由コードの名称
     */
    public RString getHenkoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), henkoJiyuCode);
    }

    /**
     * 記載事項変更事由コードの略称のgetメソッドです。
     * <br/>
     * <br/>申請内容変更事由コード　を使用する
     *
     * @return 記載事項変更事由コードの略称
     */
    public RString getHenkoJiyuCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), henkoJiyuCode);
    }

    /**
     * 記載事項変更事由コードのDescriptionのgetメソッドです。
     * <br/>
     * <br/>申請内容変更事由コード　を使用する
     *
     * @return 記載事項変更事由コードのDescription
     */
    public RString getHenkoJiyuCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), henkoJiyuCode);
    }

    /**
     * 特記事項のgetメソッドです。
     *
     * @return 特記事項
     */
    @CheckForNull
    public RString getTokkiJiko() {
        return tokkiJiko;
    }

    /**
     * 特記事項のsetメソッドです。
     *
     * @param tokkiJiko 特記事項
     */
    public void setTokkiJiko(RString tokkiJiko) {
        this.tokkiJiko = tokkiJiko;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT122ZaigaiSenkyoShikakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT122ZaigaiSenkyoShikakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT122ZaigaiSenkyoShikakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
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
    public void shallowCopy(AfT122ZaigaiSenkyoShikakuEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shinseiNo = entity.shinseiNo;
        this.kokuminTohyoKubun = entity.kokuminTohyoKubun;
        this.kokuminShohonNo = entity.kokuminShohonNo;
        this.honsekiTorokuKubun = entity.honsekiTorokuKubun;
        this.kofuNo = entity.kofuNo;
        this.kofuYMD = entity.kofuYMD;
        this.shikakuKubun = entity.shikakuKubun;
        this.tohyokuCode = entity.tohyokuCode;
        this.meiboTorokuYMD = entity.meiboTorokuYMD;
        this.hyojiYMD = entity.hyojiYMD;
        this.hyojiJiyuCode = entity.hyojiJiyuCode;
        this.masshoYMD = entity.masshoYMD;
        this.masshoJiyuCode = entity.masshoJiyuCode;
        this.shuseiKubun = entity.shuseiKubun;
        this.shuseiYMD = entity.shuseiYMD;
        this.saiKofuJiyuCode = entity.saiKofuJiyuCode;
        this.henkoJiyuCode = entity.henkoJiyuCode;
        this.tokkiJiko = entity.tokkiJiko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, shinseiNo, kokuminTohyoKubun, kokuminShohonNo, honsekiTorokuKubun, kofuNo, kofuYMD, shikakuKubun, tohyokuCode, meiboTorokuYMD, hyojiYMD, hyojiJiyuCode, masshoYMD, masshoJiyuCode, shuseiKubun, shuseiYMD, saiKofuJiyuCode, henkoJiyuCode, tokkiJiko);
    }

// </editor-fold>
}
