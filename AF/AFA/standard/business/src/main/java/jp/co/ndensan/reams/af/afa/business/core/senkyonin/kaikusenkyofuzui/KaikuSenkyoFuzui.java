/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyofuzui;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 海区付随情報を管理するクラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuSenkyoFuzui extends ModelBase<KaikuSenkyoFuzuiIdentifier, AfT133KaikuSenkyoFuzuiEntity, KaikuSenkyoFuzui> implements Serializable {

    private final AfT133KaikuSenkyoFuzuiEntity entity;
    private final KaikuSenkyoFuzuiIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param 漁業者番号 漁業者番号
     * @param 組合コード 組合コード
     * @param 漁業日数_漁業者 漁業日数_漁業者
     * @param 漁業日数_漁業従事者 漁業日数_漁業従事者
     * @param 漁業種類 漁業種類
     * @param 使用漁船種別 使用漁船種別
     * @param 船名 船名
     * @param 登録番号 登録番号
     */
    public KaikuSenkyoFuzui(ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            RString 漁業者番号,
            RString 組合コード,
            int 漁業日数_漁業者,
            int 漁業日数_漁業従事者,
            Code 漁業種類,
            Code 使用漁船種別,
            RString 船名,
            RString 登録番号
    ) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.entity = new AfT133KaikuSenkyoFuzuiEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setShohonNo(抄本番号);
        this.entity.setGyogyoshaNo(漁業者番号);
        this.entity.setKumiaiCode(組合コード);
        this.entity.setNissuGyogyosha(漁業日数_漁業者);
        this.entity.setNissuJujisha(漁業日数_漁業従事者);
        this.entity.setGyogyoShurui(漁業種類);
        this.entity.setGyosenShubetsu(使用漁船種別);
        this.entity.setSenmei(船名);
        this.entity.setTorokuNo(登録番号);
        this.id = new KaikuSenkyoFuzuiIdentifier(抄本番号, 識別コード);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT113SenkyoShikakuEntity}
     * @param id {@link SenkyoShikakuIdentifier}
     */
    KaikuSenkyoFuzui(AfT133KaikuSenkyoFuzuiEntity entity, KaikuSenkyoFuzuiIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号 ShohonNo
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 漁業者番号を返します。
     *
     * @return 漁業者番号 RString
     */
    public RString get漁業者番号() {
        return entity.getGyogyoshaNo();
    }

    /**
     * 組合コードを返します。
     *
     * @return 組合コード RString
     */
    public RString get組合コード() {
        return entity.getKumiaiCode();
    }

    /**
     * 漁業日数_漁業者を返します。
     *
     * @return 漁業日数_漁業者 int
     */
    public int get漁業日数_漁業者() {
        return entity.getNissuGyogyosha();
    }

    /**
     * 漁業日数（漁業従事者）を返します。
     *
     * @return 漁業日数_漁業従事者 int
     */
    public int get漁業日数_漁業従事者() {
        return entity.getNissuJujisha();
    }

    /**
     * 漁業種類を返します。
     *
     * @return 漁業種類 Code
     */
    public Code get漁業種類() {
        return entity.getGyogyoShurui();
    }

    /**
     * 使用漁船種別を返します。
     *
     * @return 使用漁船種別 Code
     */
    public Code get使用漁船種別() {
        return entity.getGyosenShubetsu();
    }

    /**
     * 船名を返します。
     *
     * @return 船名 RString
     */
    public RString get船名() {
        return entity.getSenmei();
    }

    /**
     * 登録番号を返します。
     *
     * @return 登録番号 RString
     */
    public RString get登録番号() {
        return entity.getTorokuNo();
    }

    @Override
    public AfT133KaikuSenkyoFuzuiEntity toEntity() {
        return this.entity.clone();
    }

    @Override
    public KaikuSenkyoFuzui deleted() {
        AfT133KaikuSenkyoFuzuiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaikuSenkyoFuzui(deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    @Override
    public KaikuSenkyoFuzuiIdentifier identifier() {
        return this.id;
    }

}
