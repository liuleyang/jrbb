/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRH101;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRH101.SeikyuDaihyoshaShomeishoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 請求代表者証明書
 *
 * @reamsid_L AF-0140-030 wangh
 */
public class SeikyuDaihyoshaShomeishoProperty extends ReportPropertyBase<SeikyuDaihyoshaShomeishoSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRH101_請求代表者証明書.value());

    /**
     * インスタンスを生成します。
     */
    public SeikyuDaihyoshaShomeishoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
