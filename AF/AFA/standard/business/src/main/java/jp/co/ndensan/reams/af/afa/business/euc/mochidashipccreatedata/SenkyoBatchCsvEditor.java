/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.ShohonInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.SenkyoCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class SenkyoBatchCsvEditor {

    private final SenkyoCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public SenkyoBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new SenkyoCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current ShohonInfoEntity
     * @param kijyunYMD RString
     * @return SenkyoCsvEntity
     */
    public SenkyoCsvEntity usualProcessShohonNo(ShohonInfoEntity current, RString kijyunYMD) {
        shohonNoセット(current, kijyunYMD);
        return data;
    }

    /**
     * usualProcessCount
     *
     * @param current ShohonInfoEntity
     * @return SenkyoCsvEntity
     */
    public SenkyoCsvEntity usualProcessSenkyo(ShohonInfoEntity current) {
        senkyoNoセット(current);
        return data;
    }

    /**
     * keyBreakProcessByShohonNo
     *
     * @param before ShohonInfoEntity
     * @param current ShohonInfoEntity
     * @param kijyunYMD RString
     * @return SenkyoCsvEntity
     */
    public SenkyoCsvEntity keyBreakProcessByShohonNo(ShohonInfoEntity before, ShohonInfoEntity current, RString kijyunYMD) {
        if (isNew抄本(before, current)) {
            shohonNoセット(current, kijyunYMD);
            return data;
        }
        return null;
    }

    /**
     * createLastProcess
     *
     * @return SenkyoCsvEntity
     */
    public SenkyoCsvEntity createLastProcess() {
        return null;
    }

    /**
     * 抄本判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew抄本(ShohonInfoEntity before, ShohonInfoEntity current) {
        if (null == before) {
            return false;
        }
        ShohonNo 抄本前 = before.get抄本Entity().getShohonNo();
        ShohonNo 抄本現 = current.get抄本Entity().getShohonNo();

        return !(null != 抄本前 && null != 抄本現 && 抄本前.equals(抄本現));

    }

    private void shohonNoセット(ShohonInfoEntity current, RString kijyunYMD) {
        data.set抄本番号(common.toRString(current.get抄本Entity().getShohonNo()));
        data.set選挙番号(MochidashiPcCreateDataEnum.ZERO.getRString());
        data.set選挙レベル(common.toRString(current.get抄本Entity().getSenkyoShurui()));
        data.set選挙名称(common.convertTtoRString(current.get抄本Entity().getShohonName()));
        data.set選挙略称(common.convertTtoRString(RString.EMPTY));
        data.set選挙マーク(common.convertTtoRString(RString.EMPTY));
        data.set基準年月日(kijyunYMD);
        data.set告示_公示_年月日(RString.EMPTY);
        data.set投票受付開始年月日(RString.EMPTY);
        data.set投票年月日(common.toRString(current.get抄本Entity().getTohyoYMD()));
        data.set投票有無(RString.EMPTY);
        data.set抄本取込済フラグ(MochidashiPcCreateDataEnum.ONE.getRString());
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.get抄本Entity().getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.get抄本Entity().getUpdateCount()));
        data.set作成日時(common.toRString(current.get抄本Entity().getInsertTimestamp()));
        data.set作成ユーザ(current.get抄本Entity().getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.get抄本Entity().getLastUpdateTimestamp()));
        data.set更新ユーザ(current.get抄本Entity().getLastUpdateReamsLoginId());
    }

    private void senkyoNoセット(ShohonInfoEntity current) {
        data.set抄本番号(common.toRString(current.get抄本Entity().getShohonNo()));
        data.set選挙番号(common.toRString(current.get選挙Entity().getSenkyoNo()));
        data.set選挙レベル(common.toRString(current.get選挙Entity().getSenkyoLevel()));
        data.set選挙名称(current.get選挙Entity().getSenkyoName());
        data.set選挙略称(current.get選挙Entity().getSenkyoRyakusho());
        data.set選挙マーク(current.get選挙Entity().getSenkyoMark());
        data.set基準年月日(common.toRString(current.get選挙Entity().getKijunYMD()));
        data.set告示_公示_年月日(common.toRString(current.get選挙Entity().getKokujiYMD()));
        data.set投票受付開始年月日(common.toRString(current.get選挙Entity().getTohyoUketsukeYMD()));
        data.set投票年月日(common.toRString(current.get抄本Entity().getTohyoYMD()));
        data.set投票有無(common.booleanToRString(current.get選挙Entity().getMutohyoSenkyoFlag()));
        data.set抄本取込済フラグ(RString.EMPTY);
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.get選挙Entity().getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.get選挙Entity().getUpdateCount()));
        data.set作成日時(common.toRString(current.get選挙Entity().getInsertTimestamp()));
        data.set作成ユーザ(current.get選挙Entity().getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.get選挙Entity().getLastUpdateTimestamp()));
        data.set更新ユーザ(current.get選挙Entity().getLastUpdateReamsLoginId());
    }

}
