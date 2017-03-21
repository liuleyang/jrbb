/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.tohyoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokuselect.TohyokuSelectGamenData;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票区のファインダーです。
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public class TohyokuFinder {

    private final AfT501TohyokuDac afT501TohyokuDac;

    TohyokuFinder() {
        afT501TohyokuDac = InstanceProvider.create(AfT501TohyokuDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static TohyokuFinder createInstance() {
        return InstanceProvider.create(TohyokuFinder.class);
    }

    /**
     * 選挙種類と投票区コードにより、投票区情報を取得します。
     *
     * @param senkyoShurui Code
     * @param tohyokuCode RString
     * @return AfT501TohyokuEntity
     */
    @Transaction
    public AfT501TohyokuEntity get投票区情報(Code senkyoShurui, RString tohyokuCode) {
        return afT501TohyokuDac.select(senkyoShurui, tohyokuCode);
    }

    /**
     * 指定された選挙種類に該当する、投票区エンティティリストを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return 該当した投票区エンティティリスト
     */
    @Transaction
    public List<TohyokuSelectGamenData> select投票区情報(Code senkyoShurui) {
        List<TohyokuSelectGamenData> dataList = new ArrayList<>();
        List<AfT501TohyokuEntity> entityList = afT501TohyokuDac.select(senkyoShurui);
        if (entityList == null) {
            return Collections.EMPTY_LIST;
        }
        for (AfT501TohyokuEntity entity : entityList) {
            dataList.add(new TohyokuSelectGamenData(entity));
        }
        return dataList;
    }

    /**
     * 投票区情報を追加します。
     *
     * @param 投票区情報 TohyokuSelectGamenData
     * @return int
     */
    @Transaction
    public int insert投票区情報(TohyokuSelectGamenData 投票区情報) {
        投票区情報.getEntity().setState(EntityDataState.Added);
        return afT501TohyokuDac.save(投票区情報.getEntity());
    }

    /**
     * 投票区情報を保存します。
     *
     * @param 投票区情報 TohyokuSelectGamenData
     * @return int
     */
    @Transaction
    public int update投票区情報(TohyokuSelectGamenData 投票区情報) {
        投票区情報.getEntity().setState(EntityDataState.Modified);
        return afT501TohyokuDac.save(投票区情報.getEntity());
    }

    /**
     * 投票区情報を削除します。
     *
     * @param 投票区情報 TohyokuSelectGamenData
     * @return boolean
     */
    @Transaction
    public boolean deltete投票区情報(TohyokuSelectGamenData 投票区情報) {
        AfT501TohyokuEntity entity = 投票区情報.getEntity();
        return afT501TohyokuDac.deletePhysical(entity) > 0;
    }
}
