/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB300;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB300.MeiboShohonZaigaiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 選挙人名簿抄本のページブレーククラス
 *
 * @reamsid_L AF-0030-035 liss
 */
public class MeiboShohonZaigaiPageBreak extends PageBreaker<MeiboShohonZaigaiSource> {

    @Override
    public List<RString> breakKeys() {
        return Collections.unmodifiableList(Arrays.asList(new RString(MeiboShohonZaigaiSource.ReportSourceFields.totalPage.name())));
    }
}
