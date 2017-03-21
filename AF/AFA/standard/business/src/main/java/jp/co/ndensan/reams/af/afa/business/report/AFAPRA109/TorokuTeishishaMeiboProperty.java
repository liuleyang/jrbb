/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA109;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA109.TorokuTeishishaMeiboSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 登録停止者名簿のプロパティクラスです。
 *
 */
public class TorokuTeishishaMeiboProperty extends ReportPropertyBase<TorokuTeishishaMeiboSource> {

    private static final ReportId REPORT_ID = new ReportId(ReportIdKeys.登録停止者名簿.value());

    /**
     * コンストラクタです。
     */
    public TorokuTeishishaMeiboProperty() {
        super(SubGyomuCode.AFA選挙本体, REPORT_ID);
    }
}
