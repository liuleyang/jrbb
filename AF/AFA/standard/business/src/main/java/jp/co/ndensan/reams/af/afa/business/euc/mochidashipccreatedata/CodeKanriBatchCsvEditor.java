/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.UzT0006CodeShubetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.CodeKanriCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コード管理ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class CodeKanriBatchCsvEditor {

    private final CodeKanriCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public CodeKanriBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new CodeKanriCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current UzT0006CodeShubetsuEntity
     * @return CodeKanriCsvEntity
     */
    public CodeKanriCsvEntity usualProcess(UzT0006CodeShubetsuEntity current) {
        codeShubetsuセット(current);
        return data;
    }

    /**
     * keyBreakProcess
     *
     * @param before UzT0006CodeShubetsuEntity
     * @param current UzT0006CodeShubetsuEntity
     * @return CodeKanriCsvEntity
     */
    public CodeKanriCsvEntity keyBreakProcess(UzT0006CodeShubetsuEntity before, UzT0006CodeShubetsuEntity current) {
        return null;
    }

    /**
     * createLastProcess
     *
     * @return CodeKanriCsvEntity
     */
    public CodeKanriCsvEntity createLastProcess() {
        return null;
    }

    private void codeShubetsuセット(UzT0006CodeShubetsuEntity current) {
        data.set種別(common.toRString(current.getCodeShubetsu()));
        data.set種別名称(common.convertTtoRString(current.getCodeShubetsuMeisho()));
        data.set有効桁数(common.toRString(current.getYukoKetasu()));
        data.setシステム区分(common.booleanToRString(current.isCanAdd()));
        data.setカスタマイズ区分(MochidashiPcCreateDataEnum.ONE.getRString());
        data.set親種別(RString.EMPTY);
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.getUpdateCount()));
        data.set作成日時(common.toRString(current.getInsertTimestamp()));
        data.set作成ユーザ(current.getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.getLastUpdateTimestamp()));
        data.set更新ユーザ(current.getLastUpdateReamsLoginId());
    }

}
