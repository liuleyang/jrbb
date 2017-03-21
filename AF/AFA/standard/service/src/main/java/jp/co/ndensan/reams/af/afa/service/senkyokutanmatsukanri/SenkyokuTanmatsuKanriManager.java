/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.senkyokutanmatsukanri;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.business.core.senkyokutanmatsukanri.SenkyokuTanmatsuKanriJoho;
import jp.co.ndensan.reams.af.afa.business.core.senkyokutanmatsukanri.SenkyokuTanmatsuKanriJohoList;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT505SenkyokuTanmatsuKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙修正のファインダーです。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class SenkyokuTanmatsuKanriManager {

    private final AfT505SenkyokuTanmatsuKanriDac afT505SenkyokuTanmatsuKanriDac;

    SenkyokuTanmatsuKanriManager() {
        afT505SenkyokuTanmatsuKanriDac = InstanceProvider.create(AfT505SenkyokuTanmatsuKanriDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static SenkyokuTanmatsuKanriManager createInstance() {
        return InstanceProvider.create(SenkyokuTanmatsuKanriManager.class);
    }

    /**
     * 選挙区情報により、選挙区情報を取得します。
     *
     * @param 選挙区情報 SenkyokuTanmatsuKanriJoho
     */
    @Transaction
    public void delete選挙区端末情報(SenkyokuTanmatsuKanriJoho 選挙区情報) {
        選挙区情報.getEntity().setState(EntityDataState.Modified);
        afT505SenkyokuTanmatsuKanriDac.save(選挙区情報.getEntity());
    }

    /**
     * 選挙種類と選挙区コードにより、選挙区情報を取得します。
     *
     * @param senkyoShurui Code
     * @param senkyokuCode RString
     * @return List<SenkyokuTanmatsuKanriJoho>
     */
    @Transaction
    public List<SenkyokuTanmatsuKanriJoho> get選挙区端末情報リスト(Code senkyoShurui, RString senkyokuCode) {
        List<AfT505SenkyokuTanmatsuKanriEntity> entityList
                = afT505SenkyokuTanmatsuKanriDac.selectBySenkyoShuruiAndSenkyoCode(senkyoShurui, senkyokuCode);
        List<SenkyokuTanmatsuKanriJoho> senkyokuTanmatsuList = new ArrayList();
        if (null != entityList && !entityList.isEmpty()) {
            for (AfT505SenkyokuTanmatsuKanriEntity entity : entityList) {
                SenkyokuTanmatsuKanriJoho tanmatsu = new SenkyokuTanmatsuKanriJoho();
                tanmatsu.setEntity(entity);
                senkyokuTanmatsuList.add(tanmatsu);
            }
        }
        return senkyokuTanmatsuList;
    }

    /**
     * 選挙種類と選挙区コードと端末Idにより、選挙区情報を取得します。
     *
     * @param senkyoShurui Code
     * @param senkyokuCode RString
     */
    @Transaction
    public void delete選挙区端末情報(Code senkyoShurui, RString senkyokuCode) {
        List<AfT505SenkyokuTanmatsuKanriEntity> entityList
                = afT505SenkyokuTanmatsuKanriDac.selectBySenkyoShuruiAndSenkyoCode(senkyoShurui, senkyokuCode);
        if (null != entityList) {
            for (AfT505SenkyokuTanmatsuKanriEntity entity : entityList) {
                afT505SenkyokuTanmatsuKanriDac.deletePhysical(entity);
            }
        }
    }

    /**
     * 選挙種類と選挙区コードと端末Idにより、選挙区情報を取得します。
     *
     * @param 選挙区情報 SenkyokuTanmatsuKanriJohoList
     * @param senkyoShurui Code
     * @param senkyokuCode RString
     * @param tanmatsuIdList Set<RString>
     * @return List<AfT505SenkyokuTanmatsuKanriEntity>
     */
    @Transaction
    public int insertAll選挙区端末情報(SenkyokuTanmatsuKanriJohoList 選挙区情報, Code senkyoShurui, RString senkyokuCode, Set<RString> tanmatsuIdList) {
        List<SenkyokuTanmatsuKanriJoho> 選挙区情報リスト = 選挙区情報.get選挙区リスト();
        if (null != 選挙区情報リスト) {
            for (SenkyokuTanmatsuKanriJoho 選挙区 : 選挙区情報リスト) {
                選挙区.getEntity().setState(EntityDataState.Deleted);
                afT505SenkyokuTanmatsuKanriDac.deletePhysical(選挙区.getEntity());
            }
        }

        int count = 0;
        if (null != tanmatsuIdList) {
            for (RString tanmatsuId : tanmatsuIdList) {
                AfT505SenkyokuTanmatsuKanriEntity entity = new AfT505SenkyokuTanmatsuKanriEntity();
                entity.setSenkyoShurui(senkyoShurui);
                entity.setSenkyokuCode(senkyokuCode);
                entity.setTanmatsuID(tanmatsuId);
                afT505SenkyokuTanmatsuKanriDac.save(entity);
                count++;
            }
        }
        return count;
    }
}
