package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 海区選挙に関する選挙人別の付随情報を保持する。テーブルのエンティティクラスです。
 */
public class AfT133KaikuSenkyoFuzuiEntity extends DbTableEntityBase<AfT133KaikuSenkyoFuzuiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("AfT133KaikuSenkyoFuzui");

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
    private RString gyogyoshaNo;
    private RString kumiaiCode;
    private int nissuGyogyosha;
    private int nissuJujisha;
    private Code gyogyoShurui;
    private Code gyosenShubetsu;
    private RString senmei;
    private RString torokuNo;

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
     * 漁業者番号のgetメソッドです。
     *
     * @return 漁業者番号
     */
    @CheckForNull
    public RString getGyogyoshaNo() {
        return gyogyoshaNo;
    }

    /**
     * 漁業者番号のsetメソッドです。
     *
     * @param gyogyoshaNo 漁業者番号
     */
    public void setGyogyoshaNo(RString gyogyoshaNo) {
        this.gyogyoshaNo = gyogyoshaNo;
    }

    /**
     * 組合コードのgetメソッドです。
     * <br/>
     * <br/>漁業組合等
     *
     * @return 組合コード
     */
    @CheckForNull
    public RString getKumiaiCode() {
        return kumiaiCode;
    }

    /**
     * 組合コードのsetメソッドです。
     * <br/>
     * <br/>漁業組合等
     *
     * @param kumiaiCode 組合コード
     */
    public void setKumiaiCode(RString kumiaiCode) {
        this.kumiaiCode = kumiaiCode;
    }

    /**
     * 漁業日数（漁業者）のgetメソッドです。
     *
     * @return 漁業日数（漁業者）
     */
    @CheckForNull
    public int getNissuGyogyosha() {
        return nissuGyogyosha;
    }

    /**
     * 漁業日数（漁業者）のsetメソッドです。
     *
     * @param nissuGyogyosha 漁業日数（漁業者）
     */
    public void setNissuGyogyosha(int nissuGyogyosha) {
        this.nissuGyogyosha = nissuGyogyosha;
    }

    /**
     * 漁業日数（漁業従事者）のgetメソッドです。
     *
     * @return 漁業日数（漁業従事者）
     */
    @CheckForNull
    public int getNissuJujisha() {
        return nissuJujisha;
    }

    /**
     * 漁業日数（漁業従事者）のsetメソッドです。
     *
     * @param nissuJujisha 漁業日数（漁業従事者）
     */
    public void setNissuJujisha(int nissuJujisha) {
        this.nissuJujisha = nissuJujisha;
    }

    /**
     * 漁業種類のgetメソッドです。
     * <br/>
     * <br/>例　1：漁船漁業、2：養殖、3：その他
     *
     * @return 漁業種類
     */
    @CheckForNull
    public Code getGyogyoShurui() {
        return gyogyoShurui;
    }

    /**
     * 漁業種類のsetメソッドです。
     * <br/>
     * <br/>例　1：漁船漁業、2：養殖、3：その他
     *
     * @param gyogyoShurui 漁業種類
     */
    public void setGyogyoShurui(Code gyogyoShurui) {
        this.gyogyoShurui = gyogyoShurui;
    }

    /**
     * 漁業種類の名称のgetメソッドです。
     * <br/>
     * <br/>例　1：漁船漁業、2：養殖、3：その他
     *
     * @return 漁業種類の名称
     */
    public RString getGyogyoShuruiMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.漁業種類.getCodeShubetsu(), gyogyoShurui);
    }

    /**
     * 漁業種類の略称のgetメソッドです。
     * <br/>
     * <br/>例　1：漁船漁業、2：養殖、3：その他
     *
     * @return 漁業種類の略称
     */
    public RString getGyogyoShuruiRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.漁業種類.getCodeShubetsu(), gyogyoShurui);
    }

    /**
     * 漁業種類のDescriptionのgetメソッドです。
     * <br/>
     * <br/>例　1：漁船漁業、2：養殖、3：その他
     *
     * @return 漁業種類のDescription
     */
    public RString getGyogyoShuruiDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.漁業種類.getCodeShubetsu(), gyogyoShurui);
    }

    /**
     * 使用漁船種別のgetメソッドです。
     * <br/>
     * <br/>例　1：動力船、2：和船、3：その他
     *
     * @return 使用漁船種別
     */
    @CheckForNull
    public Code getGyosenShubetsu() {
        return gyosenShubetsu;
    }

    /**
     * 使用漁船種別のsetメソッドです。
     * <br/>
     * <br/>例　1：動力船、2：和船、3：その他
     *
     * @param gyosenShubetsu 使用漁船種別
     */
    public void setGyosenShubetsu(Code gyosenShubetsu) {
        this.gyosenShubetsu = gyosenShubetsu;
    }

    /**
     * 使用漁船種別の名称のgetメソッドです。
     * <br/>
     * <br/>例　1：動力船、2：和船、3：その他
     *
     * @return 使用漁船種別の名称
     */
    public RString getGyosenShubetsuMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.漁船種別.getCodeShubetsu(), gyosenShubetsu);
    }

    /**
     * 使用漁船種別の略称のgetメソッドです。
     * <br/>
     * <br/>例　1：動力船、2：和船、3：その他
     *
     * @return 使用漁船種別の略称
     */
    public RString getGyosenShubetsuRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.漁船種別.getCodeShubetsu(), gyosenShubetsu);
    }

    /**
     * 使用漁船種別のDescriptionのgetメソッドです。
     * <br/>
     * <br/>例　1：動力船、2：和船、3：その他
     *
     * @return 使用漁船種別のDescription
     */
    public RString getGyosenShubetsuDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.漁船種別.getCodeShubetsu(), gyosenShubetsu);
    }

    /**
     * 船名のgetメソッドです。
     *
     * @return 船名
     */
    @CheckForNull
    public RString getSenmei() {
        return senmei;
    }

    /**
     * 船名のsetメソッドです。
     *
     * @param senmei 船名
     */
    public void setSenmei(RString senmei) {
        this.senmei = senmei;
    }

    /**
     * 登録番号のgetメソッドです。
     *
     * @return 登録番号
     */
    @CheckForNull
    public RString getTorokuNo() {
        return torokuNo;
    }

    /**
     * 登録番号のsetメソッドです。
     *
     * @param torokuNo 登録番号
     */
    public void setTorokuNo(RString torokuNo) {
        this.torokuNo = torokuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal AfT133KaikuSenkyoFuzuiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal AfT133KaikuSenkyoFuzuiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(AfT133KaikuSenkyoFuzuiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohonNo, other.shohonNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(AfT133KaikuSenkyoFuzuiEntity entity) {
        this.shohonNo = entity.shohonNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.gyogyoshaNo = entity.gyogyoshaNo;
        this.kumiaiCode = entity.kumiaiCode;
        this.nissuGyogyosha = entity.nissuGyogyosha;
        this.nissuJujisha = entity.nissuJujisha;
        this.gyogyoShurui = entity.gyogyoShurui;
        this.gyosenShubetsu = entity.gyosenShubetsu;
        this.senmei = entity.senmei;
        this.torokuNo = entity.torokuNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohonNo, shikibetsuCode, gyogyoshaNo, kumiaiCode, nissuGyogyosha, nissuJujisha, gyogyoShurui, gyosenShubetsu, senmei, torokuNo);
    }

// </editor-fold>
}
