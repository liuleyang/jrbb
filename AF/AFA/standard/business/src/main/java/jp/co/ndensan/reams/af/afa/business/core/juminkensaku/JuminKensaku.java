/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.juminkensaku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.JuminKensakuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索を管理するクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public class JuminKensaku implements Serializable {

    private static final RString 性別コード男 = new RString("1");
    private static final RString 性別名称男 = new RString("男");
    private static final RString 性別名称女 = new RString("女");
    private static final RString 全角スペース = new RString("　");
    private static final RString 住登内外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private final JuminKensakuEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link JuminKensakuEntity}より{@link JuminKensaku}を生成します。
     *
     * @param entity DBより取得した{@link JuminKensakuEntity}
     */
    public JuminKensaku(JuminKensakuEntity entity) {
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
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public RString getカナ氏名() {
        IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.getShikibetsuTaisho());
        IName 氏名 = iShikibetsuTaisho.get名称();
        return 氏名 == null ? RString.EMPTY : 氏名.getKana().getColumnValue();
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

    /**
     * 生年月日西暦を返します。
     *
     * @return 生年月日西暦
     */
    public RString get生年月日西暦() {
        FlexibleDate 生年月日 = entity.getShikibetsuTaisho().getSeinengappiYMD();
        return 生年月日 == null ? RString.EMPTY : 生年月日.seireki().toDateString();
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
     * 性別名称を返します。
     *
     * @return 性別名称
     */
    public RString get性別名称() {
        RString 性別コード = entity.getShikibetsuTaisho().getSeibetsuCode();
        return convert性別コードTo名称(性別コード);
    }

    private RString convert性別コードTo名称(RString 性別コード) {
        if (性別コード == null) {
            return RString.EMPTY;
        }
        return 性別コード.equals(性別コード男) ? 性別名称男 : 性別名称女;
    }

    /**
     * フォーマット後住所を返します。
     *
     * @return フォーマット後住所
     */
    public RString getフォーマット後住所() {
        return (get住登内住所()).concat(get住登内番地()).concat(全角スペース).concat(get住登内方書());
    }

    /**
     * 住登内住所を返します。
     *
     * @return 住登内住所
     */
    public RString get住登内住所() {
        RString jusho = entity.getShikibetsuTaisho().getJutonaiJusho();
        return jusho == null ? RString.EMPTY : jusho;
    }

    /**
     * 住登内番地を返します。
     *
     * @return 住登内番地
     */
    public RString get住登内番地() {
        AtenaBanchi banchi = entity.getShikibetsuTaisho().getJutonaiBanchi();
        return banchi == null ? RString.EMPTY : banchi.getColumnValue();
    }

    /**
     * 住登内方書を返します。
     *
     * @return 住登内方書
     */
    public RString get住登内方書() {
        Katagaki katagaki = entity.getShikibetsuTaisho().getJutonaiKatagaki();
        return katagaki == null ? RString.EMPTY : katagaki.getColumnValue();
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
     * 住民種別コードを返します。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        RString 住民種別コード = entity.getShikibetsuTaisho().getJuminShubetsuCode();
        return 住民種別コード == null ? RString.EMPTY : 住民種別コード;
    }

    /**
     * 住民状態コードを返します。
     *
     * @return 住民状態コード
     */
    public RString get住民状態コード() {
        RString 住民状態コード = entity.getShikibetsuTaisho().getJuminJotaiCode();
        return 住民状態コード == null ? RString.EMPTY : 住民状態コード;
    }

    /**
     * 住民状態名称を返します。
     *
     * @return 住民状態名称
     */
    public RString get住民状態名称() {
        RString 住民状態コード = entity.getShikibetsuTaisho().getJuminShubetsuCode();
        return 住民状態コード == null ? RString.EMPTY : JuminJotai.toValue(住民状態コード).住民状態略称();
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
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public RString get世帯コード() {
        SetaiCode 世帯コード = entity.getShikibetsuTaisho().getSetaiCode();
        return 世帯コード == null ? RString.EMPTY : 世帯コード.getColumnValue();
    }

    /**
     * 選挙資格を返します。
     *
     * @return 選挙資格
     */
    public Code get選挙資格() {
        Code 選挙資格区分 = entity.getShikakuKubun();
        return 選挙資格区分 == null ? Code.EMPTY : 選挙資格区分;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        RString 投票区コード = entity.getTohyokuCode();
        return 投票区コード == null ? RString.EMPTY : 投票区コード;
    }

    /**
     * 冊を返します。
     *
     * @return 冊
     */
    public RString get冊() {
        RString 冊 = entity.getSatsu();
        return 冊 == null ? RString.EMPTY : 冊;
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public int get頁() {
        return entity.getPage();
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public int get行() {
        return entity.getGyo();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public RString get名簿登録年月日() {
        FlexibleDate 名簿登録年月日 = entity.getMeiboTorokuYMD();
        return 名簿登録年月日 == null ? RString.EMPTY : to和暦(名簿登録年月日);
    }

    /**
     * 名簿登録年月日西暦を返します。
     *
     * @return 名簿登録年月日西暦
     */
    public RString get名簿登録年月日西暦() {
        FlexibleDate 名簿登録年月日 = entity.getMeiboTorokuYMD();
        return 名簿登録年月日 == null ? RString.EMPTY : 名簿登録年月日.seireki().toDateString();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public FlexibleDate get表示年月日() {
        return entity.getHyojiYMD();
    }

    /**
     * 表示年月日和暦を返します。
     *
     * @return 表示年月日和暦
     */
    public RString get表示年月日和暦() {
        FlexibleDate 表示年月日 = entity.getHyojiYMD();
        return 表示年月日 == null ? RString.EMPTY : to和暦(表示年月日);
    }

    /**
     * 表示年月日西暦を返します。
     *
     * @return 表示年月日西暦
     */
    public RString get表示年月日西暦() {
        FlexibleDate 表示年月日 = entity.getHyojiYMD();
        return 表示年月日 == null ? RString.EMPTY : 表示年月日.seireki().toDateString();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード
     */
    public Code get表示事由コード() {
        Code 表示事由コード = entity.getHyojiJiyuCode();
        return 表示事由コード == null ? Code.EMPTY : 表示事由コード;
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public FlexibleDate get抹消年月日() {
        return entity.getMasshoYMD();
    }

    /**
     * 抹消年月日和暦を返します。
     *
     * @return 抹消年月日和暦
     */
    public RString get抹消年月日和暦() {
        FlexibleDate 抹消年月日 = entity.getMasshoYMD();
        return 抹消年月日 == null ? RString.EMPTY : to和暦(抹消年月日);
    }

    /**
     * 抹消年月日西暦を返します。
     *
     * @return 抹消年月日西暦
     */
    public RString get抹消年月日西暦() {
        FlexibleDate 抹消年月日 = entity.getMasshoYMD();
        return 抹消年月日 == null ? RString.EMPTY : 抹消年月日.seireki().toDateString();
    }

    private RString to和暦(FlexibleDate 日付) {
        return 日付.wareki().toDateString();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード
     */
    public Code get抹消事由コード() {
        Code 抹消事由コード = entity.getMasshoJiyuCode();
        return 抹消事由コード == null ? Code.EMPTY : 抹消事由コード;
    }

    /**
     * 投票資格種類コードを返します。
     *
     * @return 投票資格種類コード
     */
    public Code get投票資格種類コード() {
        Code 投票資格種類 = entity.getTohyoShikakuShurui();
        return 投票資格種類 == null ? Code.EMPTY : 投票資格種類;
    }

    /**
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public int get申請番号() {
        return entity.getShinseiNo();
    }
}
