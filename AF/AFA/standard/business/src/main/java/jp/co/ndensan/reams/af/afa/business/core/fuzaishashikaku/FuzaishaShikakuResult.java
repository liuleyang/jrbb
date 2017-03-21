/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者投票資格情報を管理するクラスです。
 *
 * @reamsid_L AF-0210-020 liuj
 */
public class FuzaishaShikakuResult {

    private final AfT114FuzaishaTohyoShikakuEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}より{@link KumiaiResult}を生成します。
     *
     * @param entity DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}
     */
    public FuzaishaShikakuResult(AfT114FuzaishaTohyoShikakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格"));
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}より{@link KumiaiResult}を生成します。
     *
     * @return entity DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}
     */
    public AfT114FuzaishaTohyoShikakuEntity getEntity() {
        return entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * 投票資格種類を返します。
     *
     * @return 投票資格種類
     */
    public Code get投票資格種類() {
        return this.entity.getTohyoShikakuShurui();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return this.entity.getSeq();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return this.entity.getKofuYMD();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return this.entity.getKofuNo();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格登録年月日() {
        return this.entity.getShikakuTorokuYMD();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格満了年月日() {
        return this.entity.getShikakuManryoYMD();
    }

    /**
     * 資格抹消年月日を返します。
     *
     * @return 資格抹消年月日
     */
    public FlexibleDate get資格抹消年月日() {
        return this.entity.getShikakuMasshoYMD();
    }

    /**
     * 資格抹消事由コードを返します。
     *
     * @return 資格抹消事由コード
     */
    public Code get資格抹消事由コード() {
        return this.entity.getShikakuMasshoJiyuCode();
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final AfT114FuzaishaTohyoShikakuEntity entity;
        private static final long serialVersionUID = 351900186803745759L;

        private _SerializationProxy(FuzaishaShikakuResult fuzaishaShikakuResult) {
            this.entity = fuzaishaShikakuResult.getEntity();
        }

        private Object readResolve() {
            return new FuzaishaShikakuResult(entity);
        }
    }

}
