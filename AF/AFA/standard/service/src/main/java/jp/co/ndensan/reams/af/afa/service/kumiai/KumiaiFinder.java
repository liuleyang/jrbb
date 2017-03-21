/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.kumiai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.kumiai.Kumiai;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT509KumiaiDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public class KumiaiFinder {

    private final AfT509KumiaiDac dac;

    KumiaiFinder() {
        dac = InstanceProvider.create(AfT509KumiaiDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static KumiaiFinder createInstance() {
        return InstanceProvider.create(KumiaiFinder.class);
    }

    /**
     * 組合コードに合致するの組合を返します。
     *
     * @param kumiaiCode RString
     * @return Kumiai
     */
    @Transaction
    public Kumiai get組合By組合コード(RString kumiaiCode) {
        Kumiai kumiai = new Kumiai();
        AfT509KumiaiEntity entity = dac.select(kumiaiCode);
        if (null != entity) {
            kumiai.setEntity(entity);
        } else {
            return null;
        }
        return kumiai;
    }

    /**
     * 組合を返します。
     *
     * @return List<Kumiai>
     */
    @Transaction
    public List<Kumiai> get組合() {
        List<Kumiai> kumiaiList = new ArrayList();
        List<AfT509KumiaiEntity> entityList = dac.select();
        if (null != entityList) {
            for (AfT509KumiaiEntity entity : entityList) {
                Kumiai kumiai = new Kumiai();
                kumiai.setEntity(entity);
                kumiaiList.add(kumiai);
            }
        } else {
            return null;
        }
        return kumiaiList;
    }

    /**
     * 組合情報を追加します。
     *
     * @param 組合 Kumiai
     * @return int
     */
    @Transaction
    public int insert組合(Kumiai 組合) {
        組合.getEntity().setState(EntityDataState.Added);
        return dac.save(組合.getEntity());
    }

    /**
     * 組合情報を追加します。
     *
     * @param 組合 Kumiai
     * @return int
     */
    @Transaction
    public int update組合(Kumiai 組合) {
        組合.getEntity().setState(EntityDataState.Modified);
        return dac.save(組合.getEntity());
    }

    /**
     * 組合情報を削除します。
     *
     * @param 組合 Kumiai
     * @return boolean
     */
    @Transaction
    public boolean delete組合(Kumiai 組合) {
        AfT509KumiaiEntity entity = 組合.getEntity();
        return dac.deletePhysical(entity) > 0;

    }
}
