/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506.KijitsumaeTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportEditor;

/**
 * {@link KijitsumaeTohyorokuReportSource} を編集します。
 *
 * @reamsid_L AF-0130-020 lit
 */
public interface IKijitsumaeTohyorokuEditor extends IReportEditor<KijitsumaeTohyorokuReportSource> {

    /**
     * データリストの最後かどうか。
     *
     * @return データリストの最後かどうか
     */
    boolean isLastFlg();

    /**
     * データリストの最後かどうか。
     *
     * @param lastFlg lastFlg
     */
    void setLastFlg(boolean lastFlg);
}
