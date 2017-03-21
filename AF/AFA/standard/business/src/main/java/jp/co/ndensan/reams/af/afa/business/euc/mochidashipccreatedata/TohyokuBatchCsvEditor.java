/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.TohyokuInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.TohyokuCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class TohyokuBatchCsvEditor {

    private final TohyokuCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public TohyokuBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new TohyokuCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current TohyokuInfoEntity
     * @return TohyokuCsvEntity
     */
    public TohyokuCsvEntity usualProcess(TohyokuInfoEntity current) {
        tohyokuセット(current);
        return data;
    }

    /**
     * keyBreakProcess
     *
     * @param before TohyokuInfoEntity
     * @param current TohyokuInfoEntity
     * @return TohyokuCsvEntity
     */
    public TohyokuCsvEntity keyBreakProcess(TohyokuInfoEntity before, TohyokuInfoEntity current) {
        return null;
    }

    /**
     * createLastProcess
     *
     * @return TohyokuCsvEntity
     */
    public TohyokuCsvEntity createLastProcess() {
        return null;
    }

    private void tohyokuセット(TohyokuInfoEntity current) {
        RString senkyoShurui = current.get投票区Entity().getSenkyoShurui();
        if (SenkyoShurui.国政選挙_地方選挙.getCode().equals(senkyoShurui)) {
            senkyoShurui = MochidashiPcCreateDataEnum.ZERO.getRString();
        }
        data.set選挙種類(senkyoShurui);
        data.set投票区コード(current.get投票区Entity().getTohyokuCode());
        data.set投票区名称(common.convertTtoRString(current.get投票区Entity().getTohyokuName()));
        data.set投票区名称_カナ(common.convertTtoRString(current.get投票区Entity().getKanaTohyokuName()));
        data.set投票区名称_検索カナ(common.convertTtoRString(current.get投票区Entity().getSearchKanaTohyokuName()));
        data.set投票所名称(common.convertTtoRString(current.get投票所Entity().getTohyojoName()));
        data.set投票所名称_カナ(common.convertTtoRString(current.get投票所Entity().getKanaTohyojoName()));
        data.set投票所名称_検索カナ(common.convertTtoRString(current.get投票所Entity().getSearchKanaTohyojoName()));
        data.set投票開始時刻(common.toRString(current.get投票所Entity().getTohyoStartTime()));
        data.set投票終了時刻(common.toRString(current.get投票所Entity().getTohyoStopTime()));
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.get投票所Entity().getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.get投票所Entity().getUpdateCount()));
        data.set作成日時(common.toRString(current.get投票所Entity().getInsertTimestamp()));
        data.set作成ユーザ(current.get投票所Entity().getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.get投票所Entity().getLastUpdateTimestamp()));
        data.set更新ユーザ(current.get投票所Entity().getLastUpdateReamsLoginId());
    }

}
