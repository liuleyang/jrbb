/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohon.kaikusenkyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 海区漁業調整委員会委員選挙人名簿作成するクラスです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuSenkyo extends ModelBase<KaikuSenkyoIdentifier, AfT131KaikuSenkyoEntity, KaikuSenkyo> implements Serializable {

    private final AfT131KaikuSenkyoEntity entity;
    private final KaikuSenkyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 海区選挙の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     */
    public KaikuSenkyo(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        this.entity = new AfT131KaikuSenkyoEntity();
        this.entity.setShohonNo(抄本番号);
        this.id = new KaikuSenkyoIdentifier(抄本番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT131KaikuSenkyoEntity}より{@link KaikuSenkyo}を生成します。
     *
     * @param entity DBより取得した{@link AfT131KaikuSenkyoEntity}
     */
    public KaikuSenkyo(AfT131KaikuSenkyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("海区選挙"));
        this.id = new KaikuSenkyoIdentifier(entity.getShohonNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT131KaikuSenkyoEntity}
     * @param id {@link SenkyoIdentifier}
     */
    KaikuSenkyo(AfT131KaikuSenkyoEntity entity, KaikuSenkyoIdentifier id) {
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
     * 年度を返します。
     *
     * @return 年度 Ryear
     */
    public RYear get年度() {
        return entity.getNendo();
    }

    /**
     * 名簿作成年月日を返します。
     *
     * @return 名簿作成年月日 FlexibleDate
     */
    public FlexibleDate get名簿作成年月日() {
        return entity.getSakuseiYMD();
    }

    /**
     * 名簿確定年月日を返します。
     *
     * @return 名簿確定年月日 FlexibleDate
     */
    public FlexibleDate get名簿確定年月日() {
        return entity.getKakuteiYMD();
    }

    /**
     * 名簿最新化年月日を返します。
     *
     * @return 名簿最新化年月日 FlexibleDate
     */
    public FlexibleDate get名簿最新化年月日() {
        return entity.getSaishinkaYMD();
    }

    /**
     * 選挙時登録フラグを返します。
     *
     * @return 選挙時登録フラグ boolean
     */
    public boolean is選挙時登録フラグ() {
        return entity.getSenkyojiTorokuFlag();
    }

    @Override
    public AfT131KaikuSenkyoEntity toEntity() {
        return this.entity.clone();
    }

    @Override
    public KaikuSenkyo deleted() {
        AfT131KaikuSenkyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaikuSenkyo(deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    @Override
    public KaikuSenkyoIdentifier identifier() {
        return this.id;
    }

    /**
     * {@link KaikuSenkyo}のシリアライズ形式を提供します。
     *
     * @return {@link KaikuSenkyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7402213614486601766L;
        private final AfT131KaikuSenkyoEntity entity;
        private final KaikuSenkyoIdentifier id;

        private _SerializationProxy(AfT131KaikuSenkyoEntity entity, KaikuSenkyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaikuSenkyo(this.entity, this.id);
        }
    }

}
