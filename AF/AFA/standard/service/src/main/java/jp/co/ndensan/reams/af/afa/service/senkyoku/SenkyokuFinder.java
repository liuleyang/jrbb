/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.senkyoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyoku.SenkyokuJouhou;
import jp.co.ndensan.reams.af.afa.business.core.senkyoku.Senkyokuhoshu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyokuJoho;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT503SenkyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT505SenkyokuTanmatsuKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.ISenkyokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙修正のファインダーです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuFinder {

    private final AfT503SenkyokuDac afT503SenkyokuDac;
    private final AfT505SenkyokuTanmatsuKanriDac afT505SenkyokuTanmatsuKanriDac;
    private final AfaMapperProvider mapperProvider;

    SenkyokuFinder() {
        afT503SenkyokuDac = InstanceProvider.create(AfT503SenkyokuDac.class);
        afT505SenkyokuTanmatsuKanriDac = InstanceProvider.create(AfT505SenkyokuTanmatsuKanriDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static SenkyokuFinder createInstance() {
        return InstanceProvider.create(SenkyokuFinder.class);
    }

    /**
     * 選挙種類と選挙区コードにより、選挙区情報を取得します。
     *
     * @param senkyoShurui Code
     * @param senkyokuCode RString
     * @return SenkyokuJouhou
     */
    @Transaction
    public SenkyokuJouhou get選挙区情報(Code senkyoShurui, RString senkyokuCode) {
        SenkyokuJouhou joho = new SenkyokuJouhou();
        joho.setEntity(afT503SenkyokuDac.select(senkyoShurui, senkyokuCode));
        return joho;
    }

    /**
     * 選挙区情報を追加します。
     *
     * @param 選挙区情報 Senkyokuhoshu
     * @return int
     */
    @Transaction
    public int insert選挙区情報(Senkyokuhoshu 選挙区情報) {
        選挙区情報.getAfT503SenkyokuEntity().setState(EntityDataState.Modified);
        return afT503SenkyokuDac.save(選挙区情報.getAfT503SenkyokuEntity());
    }

    /**
     * 選挙区情報を追加します。
     *
     * @param 選挙区情報 Senkyokuhoshu
     * @return int
     */
    @Transaction
    public int insert選挙区(Senkyokuhoshu 選挙区情報) {
        AfT503SenkyokuEntity entity = new AfT503SenkyokuEntity();
        選挙区情報.setAfT503SenkyokuEntity(entity);
        選挙区情報.getAfT503SenkyokuEntity().setSenkyoShurui(new Code(選挙区情報.get選挙種類()));
        選挙区情報.getAfT503SenkyokuEntity().setSenkyokuCode(選挙区情報.get選挙区コード());
        選挙区情報.getAfT503SenkyokuEntity().setSenkyokuName(選挙区情報.get選挙名());

        選挙区情報.getAfT503SenkyokuEntity().setState(EntityDataState.Added);
        return afT503SenkyokuDac.save(選挙区情報.getAfT503SenkyokuEntity());
    }

    /**
     * 選挙区情報を削除します。
     *
     * @param 選挙区情報 Senkyokuhoshu
     * @return int
     */
    @Transaction
    public boolean deltete選挙区情報(Senkyokuhoshu 選挙区情報) {

        int afT503DeleteNo = afT503SenkyokuDac.deletePhysical(選挙区情報.getAfT503SenkyokuEntity());
        List<AfT505SenkyokuTanmatsuKanriEntity> entityList
                = afT505SenkyokuTanmatsuKanriDac.selectBySenkyoShuruiAndSenkyoCode(選挙区情報.getAfT503SenkyokuEntity().getSenkyoShurui(),
                        選挙区情報.getAfT503SenkyokuEntity().getSenkyokuCode());
        if (null != entityList) {
            for (AfT505SenkyokuTanmatsuKanriEntity aft505Entity : entityList) {
                afT505SenkyokuTanmatsuKanriDac.deletePhysical(aft505Entity);
            }
        }
        if (afT503DeleteNo > 0) {
            return true;
        }
        return false;
    }

    /**
     * 選挙区情報リストを取得します。
     *
     * @param 選挙種類 選挙種類
     * @return 選挙区情報 List<SenkyokuJoho>
     */
    @Transaction
    public List<Senkyokuhoshu> select選挙区情報(RString 選挙種類) {
        ISenkyokuMapper mapper = mapperProvider.create(ISenkyokuMapper.class);
        List<SenkyokuJoho> johoList = mapper.select選挙区情報を検索(選挙種類);
        List<Senkyokuhoshu> senkyokuList = new ArrayList();
        if (null != johoList && !johoList.isEmpty()) {
            for (SenkyokuJoho joho : johoList) {
                Senkyokuhoshu jouhou = new Senkyokuhoshu();
                jouhou.set選挙種類(joho.get選挙種類());
                jouhou.set選挙区コード(joho.get選挙区コード());
                jouhou.set選挙名(joho.get選挙区名());
                jouhou.set端末Id(joho.get登録端末数());
                jouhou.setAfT503SenkyokuEntity(joho.get選挙区Entity());
                senkyokuList.add(jouhou);
            }
        }
        return senkyokuList;
    }

    /**
     * 選挙区リストを取得します。
     *
     * @param 選挙種類 選挙種類
     * @return 選挙区情報 List<SenkyokuJoho>
     */
    @Transaction
    public List<SenkyokuJouhou> select選挙区情報リスト(RString 選挙種類) {
        Code senkyoshurui = null == 選挙種類 ? Code.EMPTY : new Code(選挙種類);
        List<AfT503SenkyokuEntity> entityList = afT503SenkyokuDac.select(senkyoshurui);
        List<SenkyokuJouhou> senkyokuList = new ArrayList();
        if (null != entityList && !entityList.isEmpty()) {
            for (AfT503SenkyokuEntity entity : entityList) {
                SenkyokuJouhou joho = new SenkyokuJouhou();
                joho.setEntity(entity);
                senkyokuList.add(joho);
            }
        }
        return senkyokuList;
    }
}
