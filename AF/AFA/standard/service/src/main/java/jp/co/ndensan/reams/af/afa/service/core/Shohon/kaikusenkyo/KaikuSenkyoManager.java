/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shohon.kaikusenkyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.shohon.kaikusenkyo.KaikuSenkyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT131KaikuSenkyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 海区漁業調整委員会委員選挙人名簿作成するクラスです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuSenkyoManager {

    private final AfT131KaikuSenkyoDac dac;

    /**
     * コンストラクタです。
     */
    public KaikuSenkyoManager() {
        dac = InstanceProvider.create(AfT131KaikuSenkyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT131KaikuSenkyoDac}
     */
    public KaikuSenkyoManager(AfT131KaikuSenkyoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaikuSenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaikuSenkyoManager}のインスタンス
     */
    public static KaikuSenkyoManager createInstance() {
        return InstanceProvider.create(KaikuSenkyoManager.class);
    }

    /**
     * 抄本番号に合致する海区名簿更新日を返します。
     *
     * @param 抄本番号 抄本番号
     * @return KaikuSenkyoリスト
     */
    @Transaction
    public KaikuSenkyo get名簿確定年月日By抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));

        AfT131KaikuSenkyoEntity entity = dac.select(抄本番号);
        if (entity == null) {
            return null;
        }
        return new KaikuSenkyo(entity);
    }
}
