/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.barcodetojitsu;

import java.io.Serializable;
import java.util.Arrays;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.barcodetojitsu.BarCodeTojitsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バーコード一括当日投票入力データクラスです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public class BarCodeTojitsuResult implements Serializable {

    private final BarCodeTojitsuEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link BarCodeJuriEntity}より{@link BarCodeTojitsuResult}を生成します。
     *
     * @param entity DBより取得した{@link BarCodeJuriEntity}
     */
    public BarCodeTojitsuResult(BarCodeTojitsuEntity entity) {
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
        ShohonNo shohonNo = entity.getSenkyoninMeibo().getShohonNo();
        return shohonNo == null ? RString.EMPTY : new RString(shohonNo.toString());
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
     * @return 投票状況 List<AfT201TohyoJokyoEntity>
     */
    public AfT201TohyoJokyoEntity get投票状況データ() {
        return entity.getTohyoJokyoEntity();
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 RString
     */
    public RString get投票状況() {
        Code tohyoJokyo = entity.getTohyoJokyoEntity().getTohyoJokyo();
        return tohyoJokyo == null ? RString.EMPTY : new RString(tohyoJokyo.toString());
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
     * 住民種別を返します。
     *
     * @return 生年月日 RString
     */
    public RString get住民種別() {
        RString juminShubetsuCode = entity.getShikibetsuTaisho().getJuminShubetsuCode();
        return juminShubetsuCode == null ? RString.EMPTY : juminShubetsuCode;
    }

    /**
     * 住民状態コードを返します。
     *
     * @return 生年月日 RString
     */
    public RString get住民状態コード() {
        RString juminJotaiCode = entity.getShikibetsuTaisho().getJuminJotaiCode();
        return juminJotaiCode == null ? RString.EMPTY : juminJotaiCode;
    }

    /**
     * 住所を返します。
     *
     * @return 生年月日 RString
     */
    public RString get住所() {
        AtenaJusho jusho = entity.getShikibetsuTaisho().getJusho();
        return jusho == null ? RString.EMPTY : jusho.getColumnValue();
    }

    /**
     * 番地を返します。
     *
     * @return 生年月日 RString
     */
    public RString get番地() {
        AtenaBanchi banchi = entity.getShikibetsuTaisho().getBanchi();
        return banchi == null ? RString.EMPTY : banchi.getColumnValue();
    }

    /**
     * 番地を返します。
     *
     * @return 生年月日 RString
     */
    public RString get方書() {
        Katagaki katagaki = entity.getShikibetsuTaisho().getKatagaki();
        return katagaki == null ? RString.EMPTY : katagaki.getColumnValue();
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
     * 行政区コードを返します。
     *
     * @return 世帯コード RString
     */
    public RString get行政区コード() {
        GyoseikuCode gyoseikuCode = entity.getShikibetsuTaisho().getGyoseikuCode();
        return gyoseikuCode == null ? RString.EMPTY : gyoseikuCode.getColumnValue();
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
     * 頁を返します。
     *
     * @return 頁 int
     */
    public int get頁() {
        return entity.getSenkyoninMeibo().getPage();
    }

    /**
     * 行を返します。
     *
     * @return 行 int
     */
    public int get行() {
        return entity.getSenkyoninMeibo().getGyo();
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
     * 選挙種類を返します。
     *
     * @return 選挙種類 Code
     */
    public Code get選挙種類() {
        Code senkyoShurui = entity.getSenkyoShikaku().getSenkyoShurui();
        return senkyoShurui == null ? Code.EMPTY : senkyoShurui;
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
        投票資格情報.setTohyoJokyoEntityList(Arrays.asList(entity.getTohyoJokyoEntity()));
        return new TohyoShikakuHantei(null, null, null).has投票資格Old(投票資格情報,
                entity.getShikibetsuTaisho().getShikibetsuCode(),
                entity.getShohon().getTohyoYMD());
    }
}
