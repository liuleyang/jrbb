/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.ConfigInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.KanriInfoCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 管理情報ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class KanriInfoBatchCsvEditor {

    private final KanriInfoCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public KanriInfoBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new KanriInfoCsvEntity();

    }

    /**
     * usualProcessCount
     *
     * @param current ConfigInfoEntity
     * @return KanriInfoCsvEntity
     */
    public KanriInfoCsvEntity usualProcess(ConfigInfoEntity current) {
        senkyokuセット(current);
        return data;
    }

    /**
     * keyBreakProcess
     *
     * @param before ConfigInfoEntity
     * @param current ConfigInfoEntity
     * @return KanriInfoCsvEntity
     */
    public KanriInfoCsvEntity keyBreakProcess(ConfigInfoEntity before, ConfigInfoEntity current) {
        return null;
    }

    /**
     * createLastProcess
     *
     * @return KanriInfoCsvEntity
     */
    public KanriInfoCsvEntity createLastProcess() {
        return null;
    }

    private void senkyokuセット(ConfigInfoEntity current) {

        if (null == current.getUzT0002Entity()) {
            data.setスキーマ名(current.getUzT0001Entity().getSchemaName());
            data.setサブ業務コード(common.toRString(current.getUzT0001Entity().getSubGyomuCode()));
            data.setコンフィグ名(common.convertTtoRString(current.getUzT0001Entity().getConfigName()));
            data.setJavaタイプ(current.getUzT0001Entity().getJavaType());
            data.set変更可能フラグ(new RString(String.valueOf(current.getUzT0001Entity().getTheyCanChange())));
            data.set値(current.getUzT0001Entity().getConfigValue());
            data.set説明(current.getUzT0001Entity().getConfigDesc());

            data.set端末ID(RString.EMPTY);
            data.set削除フラグ(new RString(String.valueOf(current.getUzT0001Entity().getIsDeleted())));
            data.set更新カウンタ(common.toRString(current.getUzT0001Entity().getUpdateCount()));
            data.set作成日時(common.toRString(current.getUzT0001Entity().getInsertTimestamp()));
            data.set作成ユーザ(current.getUzT0001Entity().getInsertReamsLoginId());
            data.set更新日時(common.toRString(current.getUzT0001Entity().getLastUpdateTimestamp()));
            data.set更新ユーザ(current.getUzT0001Entity().getLastUpdateReamsLoginId());

        } else {
            data.setスキーマ名(current.getUzT0002Entity().getSchemaName());
            data.setサブ業務コード(common.toRString(current.getUzT0002Entity().getSubGyomuCode()));
            data.setコンフィグ名(common.convertTtoRString(current.getUzT0002Entity().getConfigName()));
            data.setJavaタイプ(current.getUzT0001Entity().getJavaType());
            data.set変更可能フラグ(new RString(String.valueOf(current.getUzT0001Entity().getTheyCanChange())));
            data.set値(current.getUzT0002Entity().getConfigValue());
            data.set説明(current.getUzT0001Entity().getConfigDesc());

            data.set端末ID(RString.EMPTY);
            data.set削除フラグ(new RString(String.valueOf(current.getUzT0002Entity().getIsDeleted())));
            data.set更新カウンタ(common.toRString(current.getUzT0002Entity().getUpdateCount()));
            data.set作成日時(common.toRString(current.getUzT0002Entity().getInsertTimestamp()));
            data.set作成ユーザ(current.getUzT0002Entity().getInsertReamsLoginId());
            data.set更新日時(common.toRString(current.getUzT0002Entity().getLastUpdateTimestamp()));
            data.set更新ユーザ(current.getUzT0002Entity().getLastUpdateReamsLoginId());
        }

    }

}
