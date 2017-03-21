/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 投票状況代理者SerachResultクラスです。
 */
public class TohyojokyoDairishaSerachResult {

    private final AfT201TohyoJokyoEntity 投票状況Entity;
    private final UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;

    /**
     * コンストラクタです。
     *
     * @param 投票状況Entity 投票状況Entity
     * @param 宛名情報Entity 宛名情報Entity
     */
    public TohyojokyoDairishaSerachResult(AfT201TohyoJokyoEntity 投票状況Entity,
            UaFt200FindShikibetsuTaishoEntity 宛名情報Entity) {
        this.投票状況Entity = 投票状況Entity;
        this.宛名情報Entity = 宛名情報Entity;
    }

    /**
     * 抄本番号のgetメソッドです。
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return this.投票状況Entity.getShohonNo();
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return this.投票状況Entity.getShikibetsuCode();
    }

    /**
     * 選挙番号のgetメソッドです。
     *
     * @return 選挙番号
     */
    public SenkyoNo getSenkyoNo() {
        return this.投票状況Entity.getSenkyoNo();
    }

    /**
     * 投票状況のgetメソッドです。
     *
     * @return 投票状況
     */
    public Code getTohyoJokyo() {
        return this.投票状況Entity.getTohyoJokyo();
    }

    /**
     * 投票事由コードのgetメソッドです。
     * <br/>
     * <br/>旧　請求事由コード
     *
     * @return 投票事由コード
     */
    public Code getTohyoJiyuCode() {
        return this.投票状況Entity.getTohyoJiyuCode();
    }

    /**
     * 請求年月日のgetメソッドです。
     *
     * @return 請求年月日
     */
    public FlexibleDate getSeikyuYMD() {
        return this.投票状況Entity.getSeikyuYMD();
    }

    /**
     * 請求方法のgetメソッドです。
     * <br/>
     * <br/>'直接・本人　or　直接・代理人　or　郵便 ※期日前で郵便はない
     *
     * @return 請求方法
     */
    public Code getSeikyuHoho() {
        return this.投票状況Entity.getSeikyuHoho();
    }

    /**
     * 受付番号のgetメソッドです。
     * <br/>
     * <br/>自動採番
     *
     * @return 受付番号
     */
    public Integer getUketsukeNo() {
        return this.投票状況Entity.getUketsukeNo();
    }

    /**
     * 交付年月日のgetメソッドです。
     *
     * @return 交付年月日
     */
    public FlexibleDate getKofuYMD() {
        return this.投票状況Entity.getKofuYMD();
    }

    /**
     * 交付時刻のgetメソッドです。
     *
     * @return 交付時刻
     */
    public RTime getKofuTime() {
        return this.投票状況Entity.getKofuTime();
    }

    /**
     * 交付方法のgetメソッドです。
     * <br/>
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     *
     * @return 交付方法
     */
    public Code getKofuHoho() {
        return this.投票状況Entity.getKofuHoho();
    }

    /**
     * 施設コードのgetメソッドです。
     * <br/>
     * <br/>不在者の時は交付施設コード
     *
     * @return 施設コード
     */
    public RString getShisetsuCode() {
        return this.投票状況Entity.getShisetsuCode();
    }

    /**
     * 受取年月日のgetメソッドです。
     * <br/>
     * <br/>投票用紙が戻ってきた日を入力
     *
     * @return 受取年月日
     */
    public FlexibleDate getUketoriYMD() {
        return this.投票状況Entity.getUketoriYMD();
    }

    /**
     * 受理年月日のgetメソッドです。
     *
     * @return 受理年月日
     */
    public FlexibleDate getJuriYMD() {
        return this.投票状況Entity.getJuriYMD();
    }

    /**
     * 受理時刻のgetメソッドです。
     *
     * @return 受理時刻
     */
    public RTime getJuriTime() {
        return this.投票状況Entity.getJuriTime();
    }

    /**
     * 受理方法のgetメソッドです。
     * <br/>
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     *
     * @return 受理方法
     */
    public Code getJuriHoho() {
        return this.投票状況Entity.getJuriHoho();
    }

    /**
     * 受理施設種別のgetメソッドです。
     * <br/>
     * <br/>旧・受理施設（投票場所）
     *
     * @return 受理施設種別
     */
    public Code getJuriShisetsuShubetsu() {
        return this.投票状況Entity.getJuriShisetsuShubetsu();
    }

    /**
     * 棄権年月日のgetメソッドです。
     * <br/>
     * <br/>選挙人の意思で棄権を宣言した日。以降、投票できなくなる。
     *
     * @return 棄権年月日
     */
    public FlexibleDate getKikenYMD() {
        return this.投票状況Entity.getKikenYMD();
    }

    /**
     * 返還年月日のgetメソッドです。
     * <br/>
     * <br/>返還時はここに日付をセット。返還しても投票はできる（期日前にはない）
     *
     * @return 返還年月日
     */
    public FlexibleDate getHenkanYMD() {
        return this.投票状況Entity.getHenkanYMD();
    }

    /**
     * 点字フラグのgetメソッドです。
     *
     * @return 点字フラグ
     */
    public boolean isTenjiFlag() {
        return this.投票状況Entity.getTenjiFlag();
    }

    /**
     * 代理投票有フラグのgetメソッドです。
     * <br/>
     * <br/>期日前、当日の時のみ
     *
     * @return 代理投票有フラグ
     */
    public boolean isDairiTohyoAriFlag() {
        return this.投票状況Entity.getDairiTohyoAriFlag();
    }

    /**
     * 補助者識別コード1のgetメソッドです。
     *
     * @return 補助者識別コード1
     */
    public ShikibetsuCode getHojoshaShikibetsuCode1() {
        return this.投票状況Entity.getHojoshaShikibetsuCode1();
    }

    /**
     * 補助者氏名1のgetメソッドです。
     *
     * @return 補助者氏名1
     */
    public AtenaMeisho getHojoshaShimei1() {
        return this.投票状況Entity.getHojoshaShimei1();
    }

    /**
     * 補助者識別コード2のgetメソッドです。
     *
     * @return 補助者識別コード2
     */
    public ShikibetsuCode getHojoshaShikibetsuCode2() {
        return this.投票状況Entity.getHojoshaShikibetsuCode2();
    }

    /**
     * 補助者氏名2のgetメソッドです。
     *
     * @return 補助者氏名2
     */
    public AtenaMeisho getHojoshaShimei2() {
        return this.投票状況Entity.getHojoshaShimei2();
    }

    /**
     * 拒否事由のgetメソッドです。
     * <br/>
     * <br/>拒否事由コードでの選択もできるが、DBセット時は文字列をセットする。
     *
     * @return 拒否事由
     */
    public RString getKyohiJiyu() {
        return this.投票状況Entity.getKyohiJiyu();
    }

    /**
     * 証明書出力フラグのgetメソッドです。
     * <br/>
     * <br/>不在者投票の時のみ
     *
     * @return 証明書出力フラグ
     */
    public boolean isShomeishoPrintFlag() {
        return this.投票状況Entity.getShomeishoPrintFlag();
    }

    /**
     * 送致済フラグのgetメソッドです。
     * <br/>
     * <br/>'選管から、各投票所や開票場所へ送致した時にTrueにする
     *
     * @return 送致済フラグ
     */
    public boolean isSochiZumiFlag() {
        return this.投票状況Entity.getSochiZumiFlag();
    }

    /**
     * 期日前不在者区分のgetメソッドです。
     * <br/>
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     *
     * @return 期日前不在者区分
     */
    public Code getKijitsuFuzaiKubun() {
        return this.投票状況Entity.getKijitsuFuzaiKubun();
    }

    /**
     * 漢字氏名のgetメソッドです。
     *
     * @return 漢字氏名
     */
    public AtenaMeisho getKanjiShimei() {
        return this.宛名情報Entity.getKanjiShimei();
    }

    /**
     * 宛名情報のgetメソッドです。
     *
     * @return 宛名情報
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名情報() {
        return this.宛名情報Entity;
    }
}
