/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.SenkyokuInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.SenkyokuCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class SenkyokuBatchCsvEditor {

    private final SenkyokuCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public SenkyokuBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new SenkyokuCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current SenkyokuInfoEntity
     * @return SenkyokuCsvEntity
     */
    public SenkyokuCsvEntity usualProcess(SenkyokuInfoEntity current) {
        senkyokuセット(current);
        return data;
    }

    /**
     * keyBreakProcess
     *
     * @param before SenkyokuInfoEntity
     * @param current SenkyokuInfoEntity
     * @return SenkyokuCsvEntity
     */
    public SenkyokuCsvEntity keyBreakProcess(SenkyokuInfoEntity before, SenkyokuInfoEntity current) {
        return null;
    }

    /**
     * createLastProcess
     *
     * @return SenkyokuCsvEntity
     */
    public SenkyokuCsvEntity createLastProcess() {
        return null;
    }

    private void senkyokuセット(SenkyokuInfoEntity current) {
        data.set選挙種類(common.toRString(current.get選挙区Entity().getSenkyoShurui()));
        data.set選挙区コード(current.get選挙区Entity().getSenkyokuCode());
        data.set選挙区名称(common.convertTtoRString(current.get選挙区Entity().getSenkyokuName()));
        data.set選挙区名称_カナ(RString.EMPTY);
        data.set選挙区名称_検索カナ(RString.EMPTY);
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.get選挙区Entity().getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.get選挙区Entity().getUpdateCount()));
        data.set作成日時(common.toRString(current.get選挙区Entity().getInsertTimestamp()));
        data.set作成ユーザ(current.get選挙区Entity().getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.get選挙区Entity().getLastUpdateTimestamp()));
        data.set更新ユーザ(current.get選挙区Entity().getLastUpdateReamsLoginId());
    }

}
