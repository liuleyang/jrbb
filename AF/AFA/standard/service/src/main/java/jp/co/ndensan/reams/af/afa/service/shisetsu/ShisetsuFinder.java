/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.shisetsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.shisetsuselect.ShisetsuSelectGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT507ShisetsuDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不在者投票管理施設のファインダーです。
 *
 * @reamsid_L AF-0730-010 liuj
 */
public class ShisetsuFinder {

    private final AfT507ShisetsuDac afT507ShisetsuDac;

    ShisetsuFinder() {
        afT507ShisetsuDac = InstanceProvider.create(AfT507ShisetsuDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static ShisetsuFinder createInstance() {
        return InstanceProvider.create(ShisetsuFinder.class);
    }

    /**
     * すべての施設エンティティリストを取得します。
     *
     * @return List<ShisetsuSelectGamenData>
     */
    @Transaction
    public List<ShisetsuSelectGamenData> select施設情報() {
        List<ShisetsuSelectGamenData> dataList = new ArrayList<>();
        List<AfT507ShisetsuEntity> entityList = afT507ShisetsuDac.select();
        if (entityList == null) {
            return Collections.EMPTY_LIST;
        }
        for (AfT507ShisetsuEntity entity : entityList) {
            dataList.add(new ShisetsuSelectGamenData(entity));
        }
        return dataList;
    }

    /**
     * 指定された施設コードに該当する、施設エンティティを取得します。
     *
     * @param shisetsuCode 施設コード
     * @return 該当した施設エンティティ
     */
    @Transaction
    public AfT507ShisetsuEntity select施設(RString shisetsuCode) {
        return afT507ShisetsuDac.select(shisetsuCode);
    }

    /**
     * 施設情報を追加します。
     *
     * @param 施設情報 ShisetsuSelectGamenData
     * @return int
     */
    @Transaction
    public int insert施設情報(ShisetsuSelectGamenData 施設情報) {
        施設情報.getEntity().setState(EntityDataState.Added);
        return afT507ShisetsuDac.save(施設情報.getEntity());
    }

    /**
     * 施設情報を修正します。
     *
     * @param 施設情報 ShisetsuSelectGamenData
     * @return int
     */
    @Transaction
    public int update施設情報(ShisetsuSelectGamenData 施設情報) {
        施設情報.getEntity().setState(EntityDataState.Modified);
        return afT507ShisetsuDac.save(施設情報.getEntity());
    }

    /**
     * 指定された施設コードに該当する、施設エンティティを取得します。
     *
     * @param shisetsuCode 施設コード
     * @return AfT507ShisetsuEntity
     */
    @Transaction
    public AfT507ShisetsuEntity get施設情報(RString shisetsuCode) {
        return afT507ShisetsuDac.select(shisetsuCode);
    }

    /**
     * 施設種別コードを取得します。
     *
     * @return AfT507ShisetsuEntity
     */
    @Transaction
    public boolean select施設種別() {
        boolean flag = false;
        List<AfT507ShisetsuEntity> 施設種別リスト = afT507ShisetsuDac.selectBy施設種別コードリスト(ShisetsuShubetsu.一般_本庁.getCode());
        if (null != 施設種別リスト && !施設種別リスト.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 施設情報を削除します。
     *
     * @param 施設情報 ShisetsuSelectGamenData
     * @return boolean
     */
    @Transaction
    public boolean deltete施設情報(ShisetsuSelectGamenData 施設情報) {
        AfT507ShisetsuEntity entity = 施設情報.getEntity();
        int afT507DeleteNo = afT507ShisetsuDac.deletePhysical(entity);
        return afT507DeleteNo > 0;
    }
}
