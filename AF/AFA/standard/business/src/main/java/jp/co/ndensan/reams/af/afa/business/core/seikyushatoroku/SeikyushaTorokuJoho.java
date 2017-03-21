/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.seikyushatoroku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SeikyushaTorokuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * 請求代表者証明書交付を管理するクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyushaTorokuJoho implements Serializable {

    private static final RString 性別コード男 = new RString("1");
    private static final RString 性別名称男 = new RString("男");
    private static final RString 性別名称女 = new RString("女");
    private static final RString 全角スペース = new RString("　");
    private static final RString 住登内外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private final SeikyushaTorokuEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link SeikyushaTorokuEntity}より{@link SeikyushaToroku}を生成します。
     *
     * @param entity DBより取得した{@link SeikyushaTorokuEntity}
     */
    public SeikyushaTorokuJoho(SeikyushaTorokuEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.getShikibetsuTaisho());
        IName 氏名 = iShikibetsuTaisho.get名称();
        return 氏名 == null ? RString.EMPTY : 氏名.getName().getColumnValue();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString getカナ氏名() {
        return entity.getShikibetsuTaisho().getKanaName();
    }

    /**
     * 性別名称を返します。
     *
     * @return 性別名称
     */
    public RString get性別名称() {

        RString 性別コード = entity.getShikibetsuTaisho().getSeibetsuCode();
        if (性別コード == null) {
            return RString.EMPTY;
        }
        return 性別コード.equals(性別コード男) ? 性別名称男 : 性別名称女;
    }

    /**
     * 性別名称を返します。
     *
     * @return 性別名称
     */
    public RString get性別() {

        RString 性別コード = entity.getShikibetsuTaisho().getSeibetsuCode();
        if (性別コード == null) {
            return RString.EMPTY;
        }
        return 性別コード;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getShikibetsuTaisho().getSeinengappiYMD();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        FlexibleDate 生年月日 = entity.getShikibetsuTaisho().getSeinengappiYMD();
        return 生年月日 == null ? RString.EMPTY : format生年月日(生年月日);
    }

    private RString format生年月日(FlexibleDate 生年月日) {
        RString 住民種別コード = entity.getShikibetsuTaisho().getJuminShubetsuCode();
        if (住民種別コード != null) {
            return (住民種別コード.equals(住登内外国人) || 住民種別コード.equals(住登外外国人))
                    ? 生年月日.seireki().toDateString() : 生年月日.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * フォーマット後住所を返します。
     *
     * @return フォーマット後住所
     */
    public RString get住所() {
        return (get住登内住所()).concat(get住登内番地()).concat(全角スペース).concat(get住登内方書());
    }

    private RString get住登内住所() {
        RString jusho = entity.getShikibetsuTaisho().getJutonaiJusho();
        return jusho == null ? RString.EMPTY : entity.getShikibetsuTaisho().getJutonaiJusho();
    }

    private RString get住登内番地() {
        AtenaBanchi banchi = entity.getShikibetsuTaisho().getJutonaiBanchi();
        return banchi == null ? RString.EMPTY : banchi.getColumnValue();
    }

    private RString get住登内方書() {
        Katagaki katagaki = entity.getShikibetsuTaisho().getJutonaiKatagaki();
        return katagaki == null ? RString.EMPTY : katagaki.getColumnValue();
    }

    /**
     * 選挙資格を返します。
     *
     * @return 選挙資格
     */
    public RString get選挙資格名称() {
        Code 選挙資格区分 = entity.getShikakuKubun();
        if (null != 選挙資格区分) {
            return CodeMasterNoOption.getCodeMeisho(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分);
        } else {
            return RString.EMPTY;
        }

    }

    /**
     * 住民種別名称を返します。
     *
     * @return 住民種別名称
     */
    public RString get住民種別名称() {
        RString 住民種別コード = entity.getShikibetsuTaisho().getJuminShubetsuCode();
        return 住民種別コード == null ? RString.EMPTY : JuminShubetsu.toValue(住民種別コード).toRString();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        ShikibetsuCode 識別コード = entity.getShikibetsuTaisho().getShikibetsuCode();
        return 識別コード == null ? RString.EMPTY : 識別コード.getColumnValue();
    }

    /**
     * 請求代表者識別コードを返します。
     *
     * @return 請求代表者識別コード
     */
    public RString get請求代表者識別コード() {
        ShikibetsuCode 請求代表者識別コード = entity.getAft402entity().getSeikyuShikibetsuCode();
        return 請求代表者識別コード == null ? RString.EMPTY : 請求代表者識別コード.getColumnValue();
    }

}
