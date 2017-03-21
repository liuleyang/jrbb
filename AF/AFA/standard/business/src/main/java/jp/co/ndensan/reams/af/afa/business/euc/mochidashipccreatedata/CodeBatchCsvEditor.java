/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.UzT0007CodeEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.CodeCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コード管理ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class CodeBatchCsvEditor {

    private final CodeCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public CodeBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new CodeCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current UzT0006CodeShubetsuEntity
     * @return CodeCsvEntity
     */
    public CodeCsvEntity usualProcess(UzT0007CodeEntity current) {
        codeShubetsuセット(current);
        return data;
    }

    /**
     * keyBreakProcess
     *
     * @param before UzT0006CodeShubetsuEntity
     * @param current UzT0006CodeShubetsuEntity
     * @return CodeCsvEntity
     */
    public CodeCsvEntity keyBreakProcess(UzT0007CodeEntity before, UzT0007CodeEntity current) {
        return null;
    }

    /**
     * createLastProcess
     *
     * @return CodeCsvEntity
     */
    public CodeCsvEntity createLastProcess() {
        return null;
    }

    private void codeShubetsuセット(UzT0007CodeEntity current) {
        data.set種別(common.toRString(current.getコード種別()));
        data.setコード(common.toRString(current.getコード()));
        data.set名称(common.convertTtoRString(current.getコード名称()));
        data.set略称(common.convertTtoRString(current.getコード略称()));
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.getUpdateCount()));
        data.set作成日時(common.toRString(current.getInsertTimestamp()));
        data.set作成ユーザ(current.getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.getLastUpdateTimestamp()));
        data.set更新ユーザ(current.getLastUpdateReamsLoginId());
    }

}
