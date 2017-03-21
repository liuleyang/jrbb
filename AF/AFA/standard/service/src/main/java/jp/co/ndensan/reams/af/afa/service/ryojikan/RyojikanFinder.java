/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.ryojikan;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.ryojikan.Ryojikan;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT510RyojikanDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 領事官保守のファインダーです。
 *
 * @reamsid_L AF-0770-010 lis2
 */
public class RyojikanFinder {

    private final AfT510RyojikanDac dac;

    RyojikanFinder() {
        dac = InstanceProvider.create(AfT510RyojikanDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static RyojikanFinder createInstance() {
        return InstanceProvider.create(RyojikanFinder.class);
    }

    /**
     * 領事官コードに合致するの領事官を返します。
     *
     * @param ryojikanCode RString
     * @return Ryojikan
     */
    @Transaction
    public Ryojikan get領事官By領事官コード(RString ryojikanCode) {
        Ryojikan ryojikan = new Ryojikan();
        AfT510RyojikanEntity entity = dac.select(ryojikanCode);
        if (null != entity) {
            ryojikan.setEntity(entity);
        } else {
            return null;
        }
        return ryojikan;
    }

    /**
     * 領事官を返します。
     *
     * @return List<Ryojikan>
     */
    @Transaction
    public List<Ryojikan> get領事官() {
        List<Ryojikan> ryojikanList = new ArrayList();
        List<AfT510RyojikanEntity> entityList = dac.select();
        if (null != entityList) {
            for (AfT510RyojikanEntity entity : entityList) {
                Ryojikan ryojikan = new Ryojikan();
                ryojikan.setEntity(entity);
                ryojikanList.add(ryojikan);
            }
        } else {
            return null;
        }
        return ryojikanList;
    }

    /**
     * 領事官情報を追加します。
     *
     * @param 領事官 Ryojikan
     * @return int
     */
    @Transaction
    public int insert領事官(Ryojikan 領事官) {
        領事官.getEntity().setState(EntityDataState.Added);
        return dac.save(領事官.getEntity());
    }

    /**
     * 領事官情報を追加します。
     *
     * @param 領事官 Ryojikan
     * @return int
     */
    @Transaction
    public int update領事官(Ryojikan 領事官) {
        領事官.getEntity().setState(EntityDataState.Modified);
        return dac.save(領事官.getEntity());
    }

    /**
     * 領事官情報を削除します。
     *
     * @param 領事官 Ryojikan
     * @return boolean
     */
    @Transaction
    public boolean delete領事官(Ryojikan 領事官) {
        AfT510RyojikanEntity entity = 領事官.getEntity();
        return dac.deletePhysical(entity) > 0;
    }
}
