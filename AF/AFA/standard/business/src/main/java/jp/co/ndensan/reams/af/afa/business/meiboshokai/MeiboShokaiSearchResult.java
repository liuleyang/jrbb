/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.meiboshokai;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.KofuJuriHoho;
import jp.co.ndensan.reams.af.afa.definition.core.KyohiJiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meiboshokai.MeiboShokaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 名簿照会用ビジネスクラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public class MeiboShokaiSearchResult implements Serializable {

    private final MeiboShokaiEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link MeiboShokaiEntity}より{@link MeiboShokaiSearchResult}を生成します。
     *
     * @param entity DBより取得した{@link MeiboShokaiEntity}
     */
    public MeiboShokaiSearchResult(MeiboShokaiEntity entity) {
        this.entity = requireNonNull(entity);
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
     * 選挙番号を返します。
     *
     * @return 選挙番号 RString
     */
    public RString get選挙番号() {
        SenkyoNo senkyoNo = entity.getTohyoJokyo().getSenkyoNo();
        return senkyoNo == null ? RString.EMPTY : new RString(senkyoNo.toString());
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 RString
     */
    public RString get投票状況() {
        Code tohyojokyo = entity.getTohyoJokyo().getTohyoJokyo();
        return tohyojokyo == null ? RString.EMPTY : new TohyoJokyo(tohyojokyo.getColumnValue()).getMeisho();
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード RString
     */
    public Code get投票事由コード() {
        Code tohyoJiyuCode = entity.getTohyoJokyo().getTohyoJiyuCode();
        return tohyoJiyuCode == null ? Code.EMPTY : tohyoJiyuCode;
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日 RString
     */
    public RString get受理年月日() {
        FlexibleDate juriYMD = entity.getTohyoJokyo().getJuriYMD();
        return juriYMD == null ? RString.EMPTY : juriYMD.wareki().toDateString();
    }

    /**
     * 受理時刻を返します。
     *
     * @return 受理時刻 RString
     */
    public RString get受理時刻() {
        RTime juriTime = entity.getTohyoJokyo().getJuriTime();
        return juriTime == null ? RString.EMPTY : juriTime.toFormattedTimeString(DisplayTimeFormat.HH_mm);
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        RString shisetsuCode = entity.getTohyoJokyo().getShisetsuCode();
        return shisetsuCode == null ? RString.EMPTY : shisetsuCode;
    }

    /**
     * 受付番号を返します。
     *
     * @return 受付番号 RString
     */
    public RString get受付番号() {
        Integer uketsukeNo = entity.getTohyoJokyo().getUketsukeNo();
        return uketsukeNo == null ? RString.EMPTY : new RString(String.valueOf(uketsukeNo));
    }

    /**
     * 請求方法を返します。
     *
     * @return 請求方法 RString
     */
    public RString get請求方法() {
        Code seikyuHoho = entity.getTohyoJokyo().getSeikyuHoho();
        return seikyuHoho == null ? RString.EMPTY : new SeikyuHoho(seikyuHoho).getMeisho();
    }

    /**
     * 請求年月日を返します。
     *
     * @return 請求年月日 RString
     */
    public RString get請求年月日() {
        FlexibleDate seikyuYMD = entity.getTohyoJokyo().getSeikyuYMD();
        return seikyuYMD == null ? RString.EMPTY : seikyuYMD.wareki().toDateString();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日 RString
     */
    public RString get交付年月日() {
        FlexibleDate kofuYMD = entity.getTohyoJokyo().getKofuYMD();
        return kofuYMD == null ? RString.EMPTY : kofuYMD.wareki().toDateString();
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法 RString
     */
    public RString get交付方法() {
        Code kofuHoho = entity.getTohyoJokyo().getKofuHoho();
        return kofuHoho == null ? RString.EMPTY : new KofuJuriHoho(kofuHoho).getMeisho();
    }

    /**
     * 受取年月日を返します。
     *
     * @return 受取年月日 RString
     */
    public RString get受取年月日() {
        FlexibleDate uketoriYMD = entity.getTohyoJokyo().getUketoriYMD();
        return uketoriYMD == null ? RString.EMPTY : uketoriYMD.wareki().toDateString();
    }

    /**
     * 受理方法を返します。
     *
     * @return 受理方法 RString
     */
    public RString get受理方法() {
        Code juriHoho = entity.getTohyoJokyo().getJuriHoho();
        return juriHoho == null ? RString.EMPTY : new KofuJuriHoho(juriHoho).getMeisho();
    }

    /**
     * 受理施設種別を返します。
     *
     * @return 受理施設種別 RString
     */
    public RString get受理施設種別() {
        Code juriShisetsuShubetsu = entity.getTohyoJokyo().getJuriShisetsuShubetsu();
        return juriShisetsuShubetsu == null ? RString.EMPTY : new ShisetsuShubetsu(juriShisetsuShubetsu).getMeisho();
    }

    /**
     * 送致済フラグを返します。
     *
     * @return 送致済フラグ boolean
     */
    public boolean is送致済フラグ() {
        return entity.getTohyoJokyo().getSochiZumiFlag();
    }

    /**
     * 点字フラグを返します。
     *
     * @return 点字フラグ boolean
     */
    public boolean is点字フラグ() {
        return entity.getTohyoJokyo().getTenjiFlag();
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ boolean
     */
    public boolean is代理投票有フラグ() {
        return entity.getTohyoJokyo().getDairiTohyoAriFlag();
    }

    /**
     * 補助者氏名1を返します。
     *
     * @return 補助者氏名1 RString
     */
    public RString get補助者氏名1() {
        AtenaMeisho hojoshaShimei1 = entity.getTohyoJokyo().getHojoshaShimei1();
        return hojoshaShimei1 == null ? RString.EMPTY : hojoshaShimei1.getColumnValue();
    }

    /**
     * 補助者氏名2を返します。
     *
     * @return 補助者氏名2 RString
     */
    public RString get補助者氏名2() {
        AtenaMeisho hojoshaShimei2 = entity.getTohyoJokyo().getHojoshaShimei2();
        return hojoshaShimei2 == null ? RString.EMPTY : hojoshaShimei2.getColumnValue();
    }

    /**
     * 返還年月日を返します。
     *
     * @return 返還年月日 RString
     */
    public RString get返還年月日() {
        FlexibleDate henkanYMD = entity.getTohyoJokyo().getHenkanYMD();
        return henkanYMD == null ? RString.EMPTY : henkanYMD.wareki().toDateString();
    }

    /**
     * 棄権年月日を返します。
     *
     * @return 棄権年月日 RString
     */
    public RString get棄権年月日() {
        FlexibleDate kikenYMD = entity.getTohyoJokyo().getKikenYMD();
        return kikenYMD == null ? RString.EMPTY : kikenYMD.wareki().toDateString();
    }

    /**
     * 拒否事由を返します。
     *
     * @return 拒否事由 RString
     */
    public RString get拒否事由() {
        RString kyohiJiyu = entity.getTohyoJokyo().getKyohiJiyu();
        return kyohiJiyu == null ? RString.EMPTY : new KyohiJiyuCode(kyohiJiyu).getMeisho();
    }

}
