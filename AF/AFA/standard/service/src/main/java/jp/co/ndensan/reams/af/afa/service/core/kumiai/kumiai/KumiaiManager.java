/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kumiai.kumiai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.kumiai.KumiaiResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT509KumiaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 組合マストの取得
 *
 * @reamsid_L AF-0500-030 guyq
 */
public class KumiaiManager {

    private final AfT509KumiaiDac dac;

    /**
     * コンストラクタです。
     */
    public KumiaiManager() {
        dac = InstanceProvider.create(AfT509KumiaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT111SenkyoDac}
     */
    public KumiaiManager(AfT509KumiaiDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンス
     */
    public static KumiaiManager createInstance() {
        return InstanceProvider.create(KumiaiManager.class);
    }

    /**
     * 主キーに合致する組合マスタを返します。
     *
     * @param kumiaiCode RString
     *
     * @return KumiaiResult nullが返る可能性があります。
     */
    @Transaction
    public KumiaiResult selectBy組合コード(RString kumiaiCode) {
        requireNonNull(kumiaiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("kumiaiCode"));

        AfT509KumiaiEntity entity = dac.select(kumiaiCode);

        if (entity == null) {
            return null;
        }
        return new KumiaiResult(entity);
    }

    /**
     * 組合マスタを返します。
     *
     *
     * @return KumiaiResult nullが返る可能性があります。
     */
    @Transaction
    public List<KumiaiResult> select組合マスタ() {

        List<AfT509KumiaiEntity> entitys = dac.select();
        List<KumiaiResult> kumiaiResultList = new ArrayList<>();
        for (AfT509KumiaiEntity entity : entitys) {
            kumiaiResultList.add(new KumiaiResult(entity));
        }
        return kumiaiResultList;
    }

}
