/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku;

import java.io.Serializable;
import java.util.Arrays;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku.MutohyoNyuryokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票情報です。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public class TohyoJokyoJoho implements Serializable {

    private final MutohyoNyuryokuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public TohyoJokyoJoho(MutohyoNyuryokuEntity entity) {
        this.entity = entity;
    }

    /**
     * TohyoYMDのgetメソッドです。
     *
     * @return TohyoYMD
     */
    public FlexibleDate getTohyoYMD() {
        return entity.getShohonEntity().getTohyoYMD();
    }

    /**
     * SenkyoninTohyoJokyoEntityのgetメソッドです。
     *
     * @return MutohyoNyuryokuEntity
     */
    public MutohyoNyuryokuEntity getMutohyoNyuryokuEntity() {
        return entity;
    }

    /**
     * 選挙種類のgetメソッドです。
     *
     * @return 選挙種類
     */
    public Code getSenkyoShurui() {
        return entity.getShohonEntity().getSenkyoShurui();
    }

    /**
     * 住民種別のgetメソッドです。
     *
     * @return 住民種別
     */
    public RString getJuminShubetsuCode() {
        return entity.getAtenaPSMEntity().getJuminShubetsuCode();
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    public int getGyo() {
        return entity.getSenkyoninMeiboEntity().getGyo();

    }

    /**
     * 名称のgetメソッドです。
     *
     * @return 名称
     */
    public AtenaMeisho getMeisho() {
        return entity.getAtenaPSMEntity().getMeisho();
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    public RString getSeibetsuCode() {
        return entity.getAtenaPSMEntity().getSeibetsuCode();
    }

    /**
     * 住登内住所のgetメソッドです。
     *
     * @return 住登内住所
     */
    public RString getJutonaiJusho() {
        return entity.getAtenaPSMEntity().getJutonaiJusho();
    }

    /**
     * 住登内番地のgetメソッドです。
     *
     * @return 住登内番地
     */
    public AtenaBanchi getJutonaiBanchi() {
        return entity.getAtenaPSMEntity().getJutonaiBanchi();
    }

    /**
     * 住登内方書のgetメソッドです。
     *
     * @return 住登内方書
     */
    public Katagaki getJutonaiKatagaki() {
        return entity.getAtenaPSMEntity().getJutonaiKatagaki();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getAtenaPSMEntity().getSeinengappiYMD();
    }

    /**
     * 住民状態コードのgetメソッドです。
     *
     * @return 住民状態コード
     */
    public RString getJuminJotaiCode() {
        return entity.getAtenaPSMEntity().getJuminJotaiCode();
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return entity.getAtenaPSMEntity().getShikibetsuCode();
    }

    /**
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
    public SetaiCode getSetaiCode() {
        return entity.getAtenaPSMEntity().getSetaiCode();
    }

    /**
     * 行政区コードのgetメソッドです。
     *
     * @return 行政区コード
     */
    public GyoseikuCode getGyoseikuCode() {
        return entity.getAtenaPSMEntity().getGyoseikuCode();
    }

    /**
     * 選挙資格区分のgetメソッドです。
     *
     * @return 選挙資格区分
     */
    public Code getShikakuKubun() {
        return entity.getSenkyoShikakuEntity().getShikakuKubun();
    }

    /**
     * 表示年月日のgetメソッドです。
     *
     * @return 表示年月日
     */
    public FlexibleDate getHyojiYMD() {
        return entity.getSenkyoShikakuEntity().getHyojiYMD();
    }

    /**
     * 抹消年月日のgetメソッドです。
     *
     * @return 抹消年月日
     */
    public FlexibleDate getMasshoYMD() {
        return entity.getSenkyoShikakuEntity().getMasshoYMD();

    }

    /**
     * TohyoJokyoのgetメソッドです。
     *
     * @return TohyoJokyo
     */
    public Code getTohyoJokyo() {
        return entity.getTohyoJokyoEntity().getTohyoJokyo();

    }

    /**
     * MutohyoSenkyoFlagのgetメソッドです。
     *
     * @return MutohyoSenkyoFlag
     */
    public boolean isMutohyoSenkyoFlag() {
        return entity.getSenkyoEntity().getMutohyoSenkyoFlag();
    }

    /**
     * SenkyoLevelのgetメソッドです。
     *
     * @return SenkyoLevel
     */
    public Code getSenkyoLevel() {
        return entity.getSenkyoEntity().getSenkyoLevel();

    }

    /**
     * 消除届出年月日のgetメソッドです。
     *
     * @return 消除届出年月日
     */
    public FlexibleDate getShojoTodokedeYMD() {
        return entity.getAtenaPSMEntity().getShojoTodokedeYMD();
    }

    /**
     * 消除異動年月日のgetメソッドです。
     *
     * @return 消除異動年月日
     */
    public FlexibleDate getshojoIdoYMD() {
        return entity.getAtenaPSMEntity().getShojoIdoYMD();
    }

    /**
     * UaFt200FindShikibetsuTaishoEntityのgetメソッドです。
     *
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    public UaFt200FindShikibetsuTaishoEntity getAtenaPSMEntity() {
        return entity.getAtenaPSMEntity();

    }

    /**
     * AfT201TohyoJokyoEntityのgetメソッドです。
     *
     * @return AfT201TohyoJokyoEntity
     */
    public AfT201TohyoJokyoEntity getTohyoJokyoEntity() {
        return entity.getTohyoJokyoEntity();
    }

    /**
     * 投票資格有無を返します。
     *
     * @return 投票資格有無 boolean
     */
    public boolean has投票資格() {
        SenkyoninTohyoJokyoEntity 投票資格情報 = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(entity.getShohonEntity());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(entity.getSenkyoEntity()));
        投票資格情報.setSenkyoJohoEntity(senkyoJohoEntity);
        投票資格情報.setAtenaPSMEntity(entity.getAtenaPSMEntity());
        投票資格情報.setSenkyoninMeiboEntity(entity.getSenkyoninMeiboEntity());
        投票資格情報.setSenkyoShikakuEntity(entity.getSenkyoShikakuEntity());
        投票資格情報.setTohyoJokyoEntityList(Arrays.asList(entity.getTohyoJokyoEntity()));
        return new TohyoShikakuHantei(null, null, null).has投票資格Old(投票資格情報,
                entity.getAtenaPSMEntity().getShikibetsuCode(),
                entity.getShohonEntity().getTohyoYMD());
    }
}
