/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.printsort;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.dac.entities.UzT0400ReportControlEntity;

/**
 * 帳票出力条件保守データクラスです。
 *
 * @reamsid_L AF-0680-010 wanghj
 */
public class ReportControlResult {

    private final UzT0400ReportControlEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public ReportControlResult(UzT0400ReportControlEntity entity) {
        this.entity = entity;

    }

    /**
     * 帳票IDのgetメソッドです。
     *
     * @return 帳票ID
     */
    public RString get帳票ID() {
        return entity.getReportId().getColumnValue();
    }

    /**
     * 帳票名のgetメソッドです。
     *
     * @return 帳票名
     */
    public RString get帳票名() {
        return entity.getReportName();
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public UzT0400ReportControlEntity getEntity() {
        return entity;
    }
}
