/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo;

import java.io.Serializable;
import java.util.Arrays;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo.TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 選挙人資格の情報用ビジネスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
public class TohyoJokyoSearchResult implements Serializable {

    private final TohyoJokyoEntity entity;
    private final AfT100ShohonEntity 抄本Entity;
    private final AfT111SenkyoEntity 選挙Entity;
    private final AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private final AfT113SenkyoShikakuEntity 選挙資格Entity;
    private final AfT201TohyoJokyoEntity 投票状況Entity;
    private final UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;
    private final AfT114FuzaishaTohyoShikakuEntity 不在者投票資格Entity;
    private final AfT507ShisetsuEntity 施設Entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link TohyoJokyoEntity}を生成します。
     *
     * @param entity DBより取得した{@link TohyoJokyoEntity}
     */
    public TohyoJokyoSearchResult(TohyoJokyoEntity entity) {
        this.entity = requireNonNull(entity);
        this.抄本Entity = entity.get抄本Entity();
        this.選挙Entity = entity.get選挙Entity();
        this.選挙人名簿Entity = entity.get選挙人名簿Entity();
        this.選挙資格Entity = entity.get選挙資格Entity();
        this.投票状況Entity = entity.get投票状況Entity();
        this.宛名情報Entity = entity.get宛名情報Entity();
        this.不在者投票資格Entity = entity.get不在者投票資格Entity();
        this.施設Entity = entity.get施設Entity();
    }

    /**
     * 抄本番号があるかどうか。
     *
     * @return 抄本番号 ShohonNo
     */
    public ShohonNo get抄本番号() {
        return null == 抄本Entity ? null : 抄本Entity.getShohonNo();
    }

    /**
     * 投票状況があるかどうか。
     *
     * @return has投票状況 boolean
     */
    public boolean has投票状況() {
        if (null != 投票状況Entity) {
            ShikibetsuCode shikibetsuCode = 投票状況Entity.getShikibetsuCode();
            return shikibetsuCode != null && !shikibetsuCode.isEmpty();
        }
        return false;
    }

    /**
     * entityを返します。
     *
     * @return entity TohyoJokyoEntity
     */
    public TohyoJokyoEntity getEntity() {
        return this.entity;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日 FlexibleDate
     */
    public FlexibleDate get投票年月日() {
        if (null == 抄本Entity) {
            return FlexibleDate.EMPTY;
        }
        return this.抄本Entity.getTohyoYMD();
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 Code
     */
    public Code get投票状況() {
        if (null == 投票状況Entity) {
            return Code.EMPTY;
        }
        return this.投票状況Entity.getTohyoJokyo();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名 AtenaMeisho
     */
    public AtenaMeisho get氏名() {
        if (null == 宛名情報Entity) {
            return AtenaMeisho.EMPTY;
        }
        return this.宛名情報Entity.getKanjiShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString get性別() {
        if (null == 宛名情報Entity) {
            return RString.EMPTY;
        }
        return Gender.toValue(this.宛名情報Entity.getSeibetsuCode()).getCommonName();
    }

    /**
     * 選挙略称を返します。
     *
     * @return 選挙略称 RString
     */
    public RString get選挙略称() {
        return null == 選挙Entity ? RString.EMPTY : 選挙Entity.getSenkyoRyakusho();
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号 RString
     */
    public RString get選挙番号() {
        return null == 選挙Entity ? RString.EMPTY : new RString(選挙Entity.getSenkyoNo().value());
    }

    /**
     * 無投票選挙を返します。
     *
     * @return 無投票選挙 boolean
     */
    public boolean is無投票選挙() {
        return null == 選挙Entity ? false : 選挙Entity.getMutohyoSenkyoFlag();
    }

    /**
     * 受付番号を返します。
     *
     * @return 受付番号 RString
     */
    public RString get受付番号() {
        if (null == 投票状況Entity) {
            return RString.EMPTY;
        }
        Integer 受付番号 = 投票状況Entity.getUketsukeNo();
        return null == 受付番号 ? RString.EMPTY : new RString(受付番号);
    }

    /**
     * 不在者投票事由を返します。
     *
     * @return 不在者投票事由 Code
     */
    public Code get不在者投票事由() {
        return null == 投票状況Entity ? Code.EMPTY : 投票状況Entity.getTohyoJiyuCode();
    }

    /**
     * 請求日を返します。
     *
     * @return 請求日 FlexibleDate
     */
    public FlexibleDate get請求日() {
        return null == 投票状況Entity ? FlexibleDate.EMPTY : 投票状況Entity.getSeikyuYMD();
    }

    /**
     * 請求方法を返します。
     *
     * @return 請求方法 Code
     */
    public Code get請求方法() {
        return null == 投票状況Entity ? Code.EMPTY : 投票状況Entity.getSeikyuHoho();
    }

    /**
     * 交付日を返します。
     *
     * @return 交付日 FlexibleDate
     */
    public FlexibleDate get交付日() {
        return null == 投票状況Entity ? FlexibleDate.EMPTY : 投票状況Entity.getKofuYMD();
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法 Code
     */
    public Code get交付方法() {
        return null == 投票状況Entity ? Code.EMPTY : 投票状況Entity.getKofuHoho();
    }

    /**
     * 点字を返します。
     *
     * @return 点字 boolean
     */
    public boolean is点字() {
        return null == 投票状況Entity ? false : 投票状況Entity.getTenjiFlag();
    }

    /**
     * 証明書を返します。
     *
     * @return 証明書 boolean
     */
    public boolean is証明書() {
        return null == 投票状況Entity ? false : 投票状況Entity.getShomeishoPrintFlag();
    }

    /**
     * 受取日を返します。
     *
     * @return 受取日 FlexibleDate
     */
    public FlexibleDate get受取日() {
        return null == 投票状況Entity ? FlexibleDate.EMPTY : 投票状況Entity.getUketoriYMD();
    }

    /**
     * 受理日を返します。
     *
     * @return 受理日 FlexibleDate
     */
    public FlexibleDate get受理日() {
        return null == 投票状況Entity ? FlexibleDate.EMPTY : 投票状況Entity.getJuriYMD();
    }

    /**
     * 受理時刻を返します。
     *
     * @return 受理時刻 RTime
     */
    public RTime get受理時刻() {
        return null == 投票状況Entity ? RTime.of(RString.EMPTY) : 投票状況Entity.getJuriTime();
    }

    /**
     * 受理方法を返します。
     *
     * @return 受理方法 Code
     */
    public Code get受理方法() {
        return null == 投票状況Entity ? Code.EMPTY : 投票状況Entity.getJuriHoho();
    }

    /**
     * 受理施設種別を返します。
     *
     * @return 受理施設種別 Code
     */
    public Code get受理施設種別() {
        return null == 投票状況Entity ? Code.EMPTY : 投票状況Entity.getJuriShisetsuShubetsu();
    }

    /**
     * 代理を返します。
     *
     * @return 代理 boolean
     */
    public boolean is代理() {
        return null == 投票状況Entity ? false : 投票状況Entity.getDairiTohyoAriFlag();
    }

    /**
     * 補助者氏名１を返します。
     *
     * @return 補助者氏名１ AtenaMeisho
     */
    public AtenaMeisho get補助者氏名１() {
        return null == 投票状況Entity ? AtenaMeisho.EMPTY : 投票状況Entity.getHojoshaShimei1();
    }

    /**
     * 補助者氏名２を返します。
     *
     * @return 補助者氏名２ AtenaMeisho
     */
    public AtenaMeisho get補助者氏名２() {
        return null == 投票状況Entity ? AtenaMeisho.EMPTY : 投票状況Entity.getHojoshaShimei2();
    }

    /**
     * 拒否の事由を返します。
     *
     * @return 拒否の事由 RString
     */
    public RString get拒否の事由() {
        return null == 投票状況Entity ? RString.EMPTY : 投票状況Entity.getKyohiJiyu();
    }

    /**
     * 送致済を返します。
     *
     * @return 送致済 boolean
     */
    public boolean is送致済() {
        return null == 投票状況Entity ? false : 投票状況Entity.getSochiZumiFlag();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return null == 宛名情報Entity ? ShikibetsuCode.EMPTY : 宛名情報Entity.getShikibetsuCode();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード SetaiCode
     */
    public SetaiCode get世帯コード() {
        return null == 宛名情報Entity ? SetaiCode.EMPTY : 宛名情報Entity.getSetaiCode();
    }

    /**
     * 補助者識別コード１を返します。
     *
     * @return 補助者識別コード１ ShikibetsuCode
     */
    public ShikibetsuCode get補助者識別コード１() {
        return null == 投票状況Entity ? ShikibetsuCode.EMPTY : 投票状況Entity.getHojoshaShikibetsuCode1();
    }

    /**
     * 補助者識別コード２を返します。
     *
     * @return 補助者識別コード２ ShikibetsuCode
     */
    public ShikibetsuCode get補助者識別コード２() {
        return null == 投票状況Entity ? ShikibetsuCode.EMPTY : 投票状況Entity.getHojoshaShikibetsuCode2();
    }

    /**
     * 郵便を返します。
     *
     * @return 郵便 boolean
     */
    public boolean is郵便() {
        if (null == 不在者投票資格Entity) {
            return false;
        }
        return TohyoShikakuShurui.投票資格種類_郵便.getCode().equals(不在者投票資格Entity.getTohyoShikakuShurui().value());
    }

    /**
     * 船員を返します。
     *
     * @return 船員 boolean
     */
    public boolean is船員() {
        if (null == 不在者投票資格Entity) {
            return false;
        }
        return TohyoShikakuShurui.投票資格種類_船員.getCode().equals(不在者投票資格Entity.getTohyoShikakuShurui().value());
    }

    /**
     * 南極を返します。
     *
     * @return 南極 boolean
     */
    public boolean is南極() {
        if (null == 不在者投票資格Entity) {
            return false;
        }
        return TohyoShikakuShurui.投票資格種類_南極.getCode().equals(不在者投票資格Entity.getTohyoShikakuShurui().value());
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        return null == 投票状況Entity ? RString.EMPTY : 投票状況Entity.getShisetsuCode();
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別 Code
     */
    public Code get施設種別() {
        return null == 施設Entity ? Code.EMPTY : 施設Entity.getShisetsuShubetsu();
    }

    /**
     * SenkyoninTohyoJokyoEntityを返す。
     *
     * @return SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity getSenkyoninTohyoJokyoEntity() {
        SenkyoninTohyoJokyoEntity result = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(選挙Entity));
        senkyoJohoEntity.setShohonEntity(抄本Entity);
        result.setSenkyoJohoEntity(senkyoJohoEntity);
        result.setSenkyoninMeiboEntity(選挙人名簿Entity);
        result.setSenkyoShikakuEntity(選挙資格Entity);
        result.setAtenaPSMEntity(宛名情報Entity);
        if (null != 投票状況Entity) {
            result.setTohyoJokyoEntityList(Arrays.asList(投票状況Entity));
        }
        return result;
    }

}
