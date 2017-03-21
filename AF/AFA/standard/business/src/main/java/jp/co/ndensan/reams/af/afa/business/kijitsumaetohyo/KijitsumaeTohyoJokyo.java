/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.TohyoJiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 期日前投票情報の投票状況データクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoJokyo implements Serializable {

    private final AfT111SenkyoEntity aft111;
    private final AfT201TohyoJokyoEntity aft201;
    private final AfT507ShisetsuEntity aft507;

    /**
     * コンストラクタです。
     *
     * @param aft201 コンストラクタです。
     */
    public KijitsumaeTohyoJokyo(KijitsumaeTohyoJokyoEntity aft201) {
        this.aft111 = aft201.getAft111();
        this.aft201 = aft201.getAft201();
        AfT507ShisetsuEntity afT507ShisetsuEntity = aft201.getAft507();
        if (afT507ShisetsuEntity == null) {
            this.aft507 = new AfT507ShisetsuEntity();
        } else {
            this.aft507 = afT507ShisetsuEntity;
        }
    }

    /**
     * 投票状況判断を返します。
     *
     * @return 投票状況判断
     */
    public boolean has投票状況() {
        return aft201 != null
                && aft201.getShikibetsuCode() != null
                && !aft201.getShikibetsuCode().isEmpty();
    }

    /**
     * 投票状況判断を返します。
     *
     * @return 投票状況判断
     */
    public RString get投票状況Entity() {
        aft201.initializeMd5();
        return DataPassingConverter.serialize(aft201);
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return aft111.getShohonNo();
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public SenkyoNo get選挙番号() {
        return aft111.getSenkyoNo();
    }

    /**
     * 選挙レベルを返します。
     *
     * @return 選挙レベル
     */
    public Code get選挙レベル() {
        return aft111.getSenkyoLevel();
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称
     */
    public RString get選挙名称() {
        return aft111.getSenkyoName();
    }

    /**
     * 選挙略称を返します。
     *
     * @return 選挙略称
     */
    public RString get選挙略称() {
        return aft111.getSenkyoRyakusho();
    }

    /**
     * 選挙マークを返します。
     *
     * @return 選挙マーク
     */
    public RString get選挙マーク() {
        return aft111.getSenkyoMark();
    }

    /**
     * 名簿基準年月日を返します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return aft111.getKijunYMD();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return aft111.getMeiboTorokuYMD();
    }

    /**
     * 告示（公示）年月日を返します。
     *
     * @return 告示（公示）年月日
     */
    public FlexibleDate get告示公示年月日() {
        return aft111.getKokujiYMD();
    }

    /**
     * 転出期限年月日を返します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return aft111.getTenshutsuKigenYMD();
    }

    /**
     * 転入期限年月日を返します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return aft111.getTennyuKigenYMD();
    }

    /**
     * 投票受付開始年月日を返します。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return aft111.getTohyoUketsukeYMD();
    }

    /**
     * 無投票選挙フラグを返します。
     *
     * @return 無投票選挙フラグ
     */
    public boolean is無投票選挙() {
        return aft111.getMutohyoSenkyoFlag();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return aft201.getShikibetsuCode();
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況
     */
    public Code get投票状況() {
        return aft201.getTohyoJokyo();
    }

    /**
     * 投票状況名称を返します。
     *
     * @return 投票状況
     */
    public RString get投票状況名称() {
        Code 投票状況 = aft201.getTohyoJokyo();
        if (投票状況 == null) {
            return RString.EMPTY;
        }
        return new TohyoJokyo(投票状況).getMeisho();
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード
     */
    public Code get投票事由コード() {
        return aft201.getTohyoJiyuCode();
    }

    /**
     * 投票事由コード名称を返します。
     *
     * @return 投票事由コード名称
     */
    public RString get投票事由コード名称() {
        Code 投票事由コード = aft201.getTohyoJiyuCode();
        if (投票事由コード != null) {
            return new TohyoJiyuCode(投票事由コード).getMeisho();
        }
        return RString.EMPTY;
    }

    /**
     * 請求年月日を返します。
     *
     * @return 請求年月日
     */
    public FlexibleDate get請求年月日() {
        return aft201.getSeikyuYMD();
    }

    /**
     * 請求方法を返します。
     *
     * @return 請求方法
     */
    public Code get請求方法() {
        return aft201.getSeikyuHoho();
    }

    /**
     * 請求方法名称を返します。
     *
     * @return 請求方法
     */
    public RString get請求方法名称() {
        Code 請求方法 = aft201.getSeikyuHoho();
        if (請求方法 == null) {
            return RString.EMPTY;
        }
        return new SeikyuHoho(請求方法).getMeisho();
    }

    /**
     * 受付番号を返します。
     *
     * @return 受付番号
     */
    public Integer get受付番号() {
        return aft201.getUketsukeNo();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return aft201.getKofuYMD();
    }

    /**
     * 交付時刻を返します。
     *
     * @return 交付時刻
     */
    public RTime get交付時刻() {
        return aft201.getKofuTime();
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法
     */
    public Code get交付方法() {
        return aft201.getKofuHoho();
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return aft201.getShisetsuCode();
    }

    /**
     * 受取年月日を返します。
     *
     * @return 受取年月日
     */
    public FlexibleDate get受取年月日() {
        return aft201.getUketoriYMD();
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日
     */
    public FlexibleDate get受理年月日() {
        return aft201.getJuriYMD();
    }

    /**
     * 受理時刻を返します。
     *
     * @return 受理時刻
     */
    public RTime get受理時刻() {
        return aft201.getJuriTime();
    }

    /**
     * 受理方法を返します。
     *
     * @return 受理方法
     */
    public Code get受理方法() {
        return aft201.getJuriHoho();
    }

    /**
     * 受理施設種別を返します。
     *
     * @return 受理施設種別
     */
    public Code get受理施設種別() {
        return aft201.getJuriShisetsuShubetsu();
    }

    /**
     * 棄権年月日を返します。
     *
     * @return 棄権年月日
     */
    public FlexibleDate get棄権年月日() {
        return aft201.getKikenYMD();
    }

    /**
     * 返還年月日を返します。
     *
     * @return 返還年月日
     */
    public FlexibleDate get返還年月日() {
        return aft201.getHenkanYMD();
    }

    /**
     * 点字フラグを返します。
     *
     * @return 点字フラグ
     */
    public boolean is点字フラグ() {
        return aft201.getTenjiFlag();
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ
     */
    public boolean is代理投票有フラグ() {
        return aft201.getDairiTohyoAriFlag();
    }

    /**
     * 補助者識別コード1を返します。
     *
     * @return 補助者識別コード1
     */
    public ShikibetsuCode get補助者識別コード1() {
        return aft201.getHojoshaShikibetsuCode1();
    }

    /**
     * 補助者氏名1を返します。
     *
     * @return 補助者氏名1
     */
    public AtenaMeisho get補助者氏名1() {
        return aft201.getHojoshaShimei1();
    }

    /**
     * 補助者識別コード2を返します。
     *
     * @return 補助者識別コード2
     */
    public ShikibetsuCode get補助者識別コード2() {
        return aft201.getHojoshaShikibetsuCode2();
    }

    /**
     * 補助者氏名2を返します。
     *
     * @return 補助者氏名2
     */
    public AtenaMeisho get補助者氏名2() {
        return aft201.getHojoshaShimei2();
    }

    /**
     * 拒否事由を返します。
     *
     * @return 拒否事由
     */
    public RString get拒否事由() {
        return aft201.getKyohiJiyu();
    }

    /**
     * 証明書出力フラグを返します。
     *
     * @return 証明書出力フラグ
     */
    public boolean is証明書出力フラグ() {
        return aft201.getShomeishoPrintFlag();
    }

    /**
     * 送致済フラグを返します。
     *
     * @return 送致済フラグ
     */
    public boolean is送致済フラグ() {
        return aft201.getSochiZumiFlag();
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別
     */
    public Code get施設種別() {
        return aft507.getShisetsuShubetsu();
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return aft507.getShisetsuName();
    }

    /**
     * カナ施設名称を返します。
     *
     * @return カナ施設名称
     */
    public RString getカナ施設名称() {
        return aft507.getKanaShisetsuName();
    }

    /**
     * 検索用カナ施設名称を返します。
     *
     * @return 検索用カナ施設名称
     */
    public RString get検索用カナ施設名称() {
        return aft507.getSearchKanaShisetsuName();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return aft507.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return aft507.getJusho();
    }

    /**
     * 施設宛名を返します。
     *
     * @return 施設宛名
     */
    public AtenaMeisho get施設宛名() {
        return aft507.getShisetsuAtena();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return aft507.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return aft507.getFaxNo();
    }

    /**
     * 端末IDを返します。
     *
     * @return 使用端末ID
     */
    public RString get端末ID() {
        return aft201.getReamsClientId();
    }

    /**
     * 選挙を返します。
     *
     * @return 選挙
     */
    public AfT111SenkyoEntity getAft111() {
        return aft111;
    }

    /**
     * 選挙状況を返します。
     *
     * @return 選挙状況
     */
    public AfT201TohyoJokyoEntity getAft201() {
        return aft201;
    }

}
