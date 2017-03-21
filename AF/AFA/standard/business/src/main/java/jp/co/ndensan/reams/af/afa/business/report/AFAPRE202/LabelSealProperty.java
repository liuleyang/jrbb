/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE202;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE202.LabelSealSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * LabelSealのプロパティクラスです。
 *
 * @reamsid_L AF-0070-021 liss
 */
public class LabelSealProperty extends ReportPropertyBase<LabelSealSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.ラベルシール_専用ラベル.value());

    /**
     * インスタンスを生成します。
     */
    public LabelSealProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
