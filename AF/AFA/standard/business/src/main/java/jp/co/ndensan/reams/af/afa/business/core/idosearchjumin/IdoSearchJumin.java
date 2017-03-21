/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.idosearchjumin;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 住民検索（資格）を管理するクラスです。
 *
 * @reamsid_L AF-0180-013 liuj
 */
public class IdoSearchJumin implements Serializable {

    private static final RString 性別コード男 = new RString("1");
    private static final RString 性別名称男 = new RString("男");
    private static final RString 性別名称女 = new RString("女");
    private static final RString 全角スペース = new RString("　");
    private static final RString 住登内外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private final IdoSearchJuminShikakuEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link IdoSearchJuminShikakuEntity}より{@link IdoSearchJuminShikaku}を生成します。
     *
     * @param entity DBより取得した{@link IdoSearchJuminShikakuEntity}
     */
    public IdoSearchJumin(IdoSearchJuminShikakuEntity entity) {
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
        AtenaKanaMeisho カナ氏名 = entity.getShikibetsuTaisho().getKanaMeisho();
        return カナ氏名 == null ? RString.EMPTY : カナ氏名.getColumnValue();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public FlexibleDate get生年月日西暦() {
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
     * フォーマット後住所を返します。
     *
     * @return フォーマット後住所
     */
    public RString get住所() {
        return (get住登内住所()).concat(get住登内番地());
    }

    /**
     * 住登内住所を返します。
     *
     * @return 住登内住所
     */
    public RString get住登内住所() {
        RString jusho = entity.getShikibetsuTaisho().getJutonaiJusho();
        return jusho == null ? RString.EMPTY : entity.getShikibetsuTaisho().getJutonaiJusho();
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
     * get住民状態コードを返します。
     *
     * @return get住民状態コード
     */
    public RString get住民状態コード() {
        return entity.getShikibetsuTaisho().getJuminJotaiCode();
    }

    /**
     * 住民種別名称を返します。
     *
     * @return 住民種別名称
     */
    public RString get住民状態名称() {
        RString 住民状態コード = entity.getShikibetsuTaisho().getJuminJotaiCode();
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
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public RString get名簿登録年月日() {
        FlexibleDate 名簿登録年月日 = entity.getMeiboTorokuYMD();
        return 名簿登録年月日 == null ? RString.EMPTY : to和暦(名簿登録年月日);
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日西暦() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public RString get名簿登録日() {
        FlexibleDate 名簿登録日 = entity.getMeiboTorokuYMD();
        return 名簿登録日 == null ? RString.EMPTY : to共有ポリシーパタンー13(名簿登録日);
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード
     */
    public Code get登録事由コード() {
        Code 登録事由コード = entity.getTorokuJiyuCode();
        return 登録事由コード == null ? Code.EMPTY : 登録事由コード;
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 登録停止年月日
     */
    public RString get登録停止年月日() {
        FlexibleDate 登録停止年月日 = entity.getTorokuTeishiYMD();
        return 登録停止年月日 == null ? RString.EMPTY : to和暦(登録停止年月日);
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get登録停止年月日西暦() {
        return entity.getTorokuTeishiYMD();
    }

    /**
     * 登録停止事由コードを返します。
     *
     * @return 登録停止事由コード
     */
    public Code get登録停止事由コード() {
        Code 登録停止事由コード = entity.getTorokuTeishiJiyuCode();
        return 登録停止事由コード == null ? Code.EMPTY : 登録停止事由コード;
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public RString get表示年月日() {
        FlexibleDate 表示年月日 = entity.getHyojiYMD();
        return 表示年月日 == null ? RString.EMPTY : to和暦(表示年月日);
    }

    /**
     * 表示年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get表示年月日西暦() {
        return entity.getHyojiYMD();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public RString get表示日() {
        FlexibleDate 表示日 = entity.getHyojiYMD();
        return 表示日 == null ? RString.EMPTY : to共有ポリシーパタンー13(表示日);
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
     * 表示消除予定年月日を返します。
     *
     * @return 表示消除予定年月日
     */
    public RString get表示消除予定年月日() {
        FlexibleDate 表示消除予定年月日 = entity.getHyojiShojoYoteiYMD();
        return 表示消除予定年月日 == null ? RString.EMPTY : to和暦(表示消除予定年月日);
    }

    /**
     * 表示消除予定年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get表示消除予定年月日西暦() {
        return entity.getHyojiShojoYoteiYMD();
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日
     */
    public RString get表示消除年月日() {
        FlexibleDate 表示消除年月日 = entity.getHyojiShojoYMD();
        return 表示消除年月日 == null ? RString.EMPTY : to和暦(表示消除年月日);
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get表示消除年月日西暦() {
        return entity.getHyojiShojoYMD();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public RString get抹消年月日() {
        FlexibleDate 抹消年月日 = entity.getMasshoYMD();
        return 抹消年月日 == null ? RString.EMPTY : to和暦(抹消年月日);
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get抹消年月日西暦() {
        return entity.getMasshoYMD();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public RString get抹消日() {
        FlexibleDate 抹消日 = entity.getMasshoYMD();
        return 抹消日 == null ? RString.EMPTY : to共有ポリシーパタンー13(抹消日);
    }

    private RString to和暦(FlexibleDate 日付) {
        return 日付.wareki().toDateString();
    }

    private RString to共有ポリシーパタンー13(FlexibleDate 日付) {
        return 日付.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString();
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
    public List<AfT114FuzaishaTohyoShikakuEntity> get投票資格() {
        return entity.getFuzaishaTohyoShikakuEntity();
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 刑期終了年月日
     */
    public RString get刑期終了年月日() {
        FlexibleDate 刑期終了年月日 = entity.getKeikiShuryoYMD();
        return 刑期終了年月日 == null ? RString.EMPTY : to和暦(刑期終了年月日);
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get刑期終了年月日西暦() {
        return entity.getKeikiShuryoYMD();
    }

    /**
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public int get申請番号() {
        return entity.getShinseiNo();
    }

    /**
     * ２刑持ちフラグのgetメソッドです。
     * <br/>
     * <br/>True:２刑持ちの場合 False：２刑なしの場合
     *
     * @return ２刑持ちフラグ
     */
    public boolean isNikeimochiFlag() {
        return entity.isNikeimochiFlag();
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

}
