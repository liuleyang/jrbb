/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.barcodejuri;

import java.io.Serializable;
import java.util.Arrays;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.barcodejuri.BarCodeJuriEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理のビジネスクラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public class BarCodeJuriSearchResult implements Serializable {

    private final BarCodeJuriEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link BarCodeJuriEntity}より{@link BarCodeJuriSearchResult}を生成します。
     *
     * @param entity DBより取得した{@link BarCodeJuriEntity}
     */
    public BarCodeJuriSearchResult(BarCodeJuriEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 抄本の投票年月日を返します。
     *
     * @return 抄本の投票年月日 FlexibleDate
     */
    public FlexibleDate get抄本の投票年月日() {
        FlexibleDate 投票年月日 = entity.getShohon().getTohyoYMD();
        return 投票年月日 == null ? FlexibleDate.EMPTY : 投票年月日;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号 RString
     */
    public RString get抄本番号() {
        ShohonNo shohonNo = entity.getShohon().getShohonNo();
        return shohonNo == null ? RString.EMPTY : new RString(shohonNo.toString());
    }

    /**
     * 受付番号を返します。
     *
     * @return 受付番号 Integer
     */
    public Integer get受付番号() {
        return entity.getTohyoJokyo().getUketsukeNo();
    }

    /**
     * 名称を返します。
     *
     * @return 名称 RString
     */
    public RString get名称() {
        AtenaMeisho meisho = entity.getShikibetsuTaisho().getMeisho();
        return meisho == null ? RString.EMPTY : meisho.getColumnValue();
    }

    /**
     * 選挙Noを返します。
     *
     * @return 選挙No RString
     */
    public RString get選挙No() {
        SenkyoNo senkyoNo = entity.getSenkyo().getSenkyoNo();
        return senkyoNo == null ? RString.EMPTY : new RString(senkyoNo.getColumnValue());
    }

    /**
     * 選挙略称を返します。
     *
     * @return 選挙略称 RString
     */
    public RString get選挙略称() {
        RString senkyoRyakusho = entity.getSenkyo().getSenkyoRyakusho();
        return senkyoRyakusho == null ? RString.EMPTY : senkyoRyakusho;
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 Code
     */
    public Code get投票状況() {
        return entity.getTohyoJokyo() == null ? Code.EMPTY : entity.getTohyoJokyo().getTohyoJokyo();
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ boolean
     */
    public boolean is代理投票有フラグ() {
        return entity.getTohyoJokyo() == null ? false : entity.getTohyoJokyo().getDairiTohyoAriFlag();
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString get性別() {
        RString seibetsuCode = entity.getShikibetsuTaisho().getSeibetsuCode();
        return RString.isNullOrEmpty(seibetsuCode) ? RString.EMPTY : new SeibetsuCode(seibetsuCode).value().getCommonName();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日 RString
     */
    public RString get生年月日() {
        FlexibleDate seinengappiYMD = entity.getShikibetsuTaisho().getSeinengappiYMD();
        return seinengappiYMD == null ? RString.EMPTY : format生年月日(seinengappiYMD);
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        return entity.getTohyoJokyo() == null ? RString.EMPTY : entity.getTohyoJokyo().getShisetsuCode();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード RString
     */
    public RString get識別コード() {
        ShikibetsuCode shikibetsuCode = entity.getShikibetsuTaisho().getShikibetsuCode();
        return shikibetsuCode == null ? RString.EMPTY : shikibetsuCode.getColumnValue();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード RString
     */
    public RString get世帯コード() {
        SetaiCode setaiCode = entity.getShikibetsuTaisho().getSetaiCode();
        return setaiCode == null ? RString.EMPTY : setaiCode.getColumnValue();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード RString
     */
    public RString get投票区コード() {
        RString tohyokuCode = entity.getSenkyoninMeibo().getTohyokuCode();
        return tohyokuCode == null ? RString.EMPTY : tohyokuCode;
    }

    /**
     * 補助者識別コード１を返します。
     *
     * @return 補助者識別コード１ ShikibetsuCode
     */
    public ShikibetsuCode get補助者識別コード１() {
        return entity.getTohyoJokyo() == null ? ShikibetsuCode.EMPTY
                : (entity.getTohyoJokyo().getHojoshaShikibetsuCode1() == null ? ShikibetsuCode.EMPTY
                : entity.getTohyoJokyo().getHojoshaShikibetsuCode1());
    }

    /**
     * 補助者識別コード２を返します。
     *
     * @return 補助者識別コード２ ShikibetsuCode
     */
    public ShikibetsuCode get補助者識別コード２() {
        return entity.getTohyoJokyo() == null ? ShikibetsuCode.EMPTY
                : (entity.getTohyoJokyo().getHojoshaShikibetsuCode2() == null ? ShikibetsuCode.EMPTY
                : entity.getTohyoJokyo().getHojoshaShikibetsuCode2());
    }

    /**
     * 補助者氏名１を返します。
     *
     * @return 補助者氏名１ AtenaMeisho
     */
    public AtenaMeisho get補助者氏名１() {
        return entity.getTohyoJokyo() == null ? AtenaMeisho.EMPTY
                : (entity.getTohyoJokyo().getHojoshaShimei1() == null ? AtenaMeisho.EMPTY
                : entity.getTohyoJokyo().getHojoshaShimei1());
    }

    /**
     * 補助者氏名２を返します。
     *
     * @return 補助者氏名２ AtenaMeisho
     */
    public AtenaMeisho get補助者氏名２() {
        return entity.getTohyoJokyo() == null ? AtenaMeisho.EMPTY
                : (entity.getTohyoJokyo().getHojoshaShimei2() == null ? AtenaMeisho.EMPTY
                : entity.getTohyoJokyo().getHojoshaShimei2());
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日 FlexibleDate
     */
    public FlexibleDate get交付年月日() {
        return entity.getTohyoJokyo() == null ? FlexibleDate.EMPTY : entity.getTohyoJokyo().getKofuYMD();
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法 Code
     */
    public Code get交付方法() {
        return entity.getTohyoJokyo() == null ? Code.EMPTY : entity.getTohyoJokyo().getKofuHoho();
    }

    /**
     * 投票受付開始年月日を返します。
     *
     * @return 投票受付開始年月日 FlexibleDate
     */
    public FlexibleDate get投票受付開始年月日() {
        FlexibleDate tohyoUketsukeYMD = entity.getSenkyo().getTohyoUketsukeYMD();
        return tohyoUketsukeYMD == null ? FlexibleDate.EMPTY : tohyoUketsukeYMD;
    }

    /**
     * 無投票選挙フラグを返します。
     *
     * @return 無投票選挙フラグ boolean
     */
    public boolean is無投票選挙フラグ() {
        return entity.getSenkyo().getMutohyoSenkyoFlag();
    }

    /**
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分 Code
     */
    public Code get選挙資格区分() {
        Code shikakuKubun = entity.getSenkyoShikaku().getShikakuKubun();
        return shikakuKubun == null ? Code.EMPTY : shikakuKubun;
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日 FlexibleDate
     */
    public FlexibleDate get名簿登録年月日() {
        FlexibleDate meiboTorokuYMD = entity.getSenkyoShikaku().getMeiboTorokuYMD();
        return meiboTorokuYMD == null ? FlexibleDate.EMPTY : meiboTorokuYMD;
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード Code
     */
    public Code get登録事由コード() {
        Code torokuJiyuCode = entity.getSenkyoShikaku().getTorokuJiyuCode();
        return torokuJiyuCode == null ? Code.EMPTY : torokuJiyuCode;
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 登録停止年月日 FlexibleDate
     */
    public FlexibleDate get登録停止年月日() {
        FlexibleDate torokuTeishiYMD = entity.getSenkyoShikaku().getTorokuTeishiYMD();
        return torokuTeishiYMD == null ? FlexibleDate.EMPTY : torokuTeishiYMD;
    }

    /**
     * 登録停止事由コードを返します。
     *
     * @return 登録停止事由コード Code
     */
    public Code get登録停止事由コード() {
        Code torokuTeishiJiyuCode = entity.getSenkyoShikaku().getTorokuTeishiJiyuCode();
        return torokuTeishiJiyuCode == null ? Code.EMPTY : torokuTeishiJiyuCode;
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日 FlexibleDate
     */
    public FlexibleDate get表示年月日() {
        FlexibleDate hyojiYMD = entity.getSenkyoShikaku().getHyojiYMD();
        return hyojiYMD == null ? FlexibleDate.EMPTY : hyojiYMD;
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード Code
     */
    public Code get表示事由コード() {
        Code hyojiJiyuCode = entity.getSenkyoShikaku().getHyojiJiyuCode();
        return hyojiJiyuCode == null ? Code.EMPTY : hyojiJiyuCode;
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日 FlexibleDate
     */
    public FlexibleDate get表示消除年月日() {
        FlexibleDate hyojiShojoYMD = entity.getSenkyoShikaku().getHyojiShojoYMD();
        return hyojiShojoYMD == null ? FlexibleDate.EMPTY : hyojiShojoYMD;
    }

    /**
     * 表示消除予定年月日を返します。
     *
     * @return 表示消除予定年月日 FlexibleDate
     */
    public FlexibleDate get表示消除予定年月日() {
        FlexibleDate hyojiShojoYoteiYMD = entity.getSenkyoShikaku().getHyojiShojoYoteiYMD();
        return hyojiShojoYoteiYMD == null ? FlexibleDate.EMPTY : hyojiShojoYoteiYMD;
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日 FlexibleDate
     */
    public FlexibleDate get抹消年月日() {
        FlexibleDate masshoYMD = entity.getSenkyoShikaku().getMasshoYMD();
        return masshoYMD == null ? FlexibleDate.EMPTY : masshoYMD;
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード Code
     */
    public Code get抹消事由コード() {
        Code masshoJiyuCode = entity.getSenkyoShikaku().getMasshoJiyuCode();
        return masshoJiyuCode == null ? Code.EMPTY : masshoJiyuCode;
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 刑期終了年月日 FlexibleDate
     */
    public FlexibleDate get刑期終了年月日() {
        FlexibleDate keikiShuryoYMD = entity.getSenkyoShikaku().getKeikiShuryoYMD();
        return keikiShuryoYMD == null ? FlexibleDate.EMPTY : keikiShuryoYMD;
    }

    /**
     * 2刑持ちフラグを返します。
     *
     * @return 2刑持ちフラグ boolean
     */
    public boolean is2刑持ちフラグ() {
        return entity.getSenkyoShikaku().getNikeimochiFlag();
    }

    private RString format生年月日(FlexibleDate 生年月日) {
        if (JuminShubetsu.外国人.getCode().equals(entity.getShikibetsuTaisho().getJuminShubetsuCode())) {
            return 生年月日.seireki().toDateString();
        }
        if (JuminShubetsu.日本人.getCode().equals(entity.getShikibetsuTaisho().getJuminShubetsuCode())) {
            return 生年月日.wareki().toDateString();
        }
        return 生年月日.wareki().toDateString();
    }

    /**
     * {@link TohyoJokyo}を返します。
     *
     * @return {@link TohyoJokyo}
     */
    public RString toTohyoJokyo() {
        AfT201TohyoJokyoEntity aft201 = entity.getTohyoJokyo();
        if (aft201 == null) {
            return RString.EMPTY;
        }
        aft201.initializeMd5();
        return DataPassingConverter.serialize(aft201);
    }

    /**
     * 投票資格有無を返します。
     *
     * @return 投票資格有無 boolean
     */
    public boolean has投票資格() {
        SenkyoninTohyoJokyoEntity 投票資格情報 = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(entity.getShohon());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(entity.getSenkyo()));
        投票資格情報.setSenkyoJohoEntity(senkyoJohoEntity);
        投票資格情報.setAtenaPSMEntity(entity.getShikibetsuTaisho());
        投票資格情報.setSenkyoninMeiboEntity(entity.getSenkyoninMeibo());
        投票資格情報.setSenkyoShikakuEntity(entity.getSenkyoShikaku());
        投票資格情報.setTohyoJokyoEntityList(Arrays.asList(entity.getTohyoJokyo()));

        return new TohyoShikakuHantei(null, null, null).has投票資格Old(投票資格情報,
                entity.getShikibetsuTaisho().getShikibetsuCode(),
                FlexibleDate.getNowDate());
    }
}
