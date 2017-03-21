/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.printsort;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.report.dac.ReportContol;
import jp.co.ndensan.reams.uz.uza.report.dac.entities.UzT0400ReportControlEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票出力条件保守のクラス
 *
 * @reamsid_L AF-0680-010 wanghj
 */
public class PrintSortDac {

    @InjectSession
    private SqlSession sqlSession;

    /**
     * 帳票管理エンティティを取得します。
     *
     * @return List<UzT0400ReportControlEntity>
     */
    @Transaction
    public List<UzT0400ReportControlEntity> select() {
        ReportContol reportContol = new ReportContol(sqlSession);
        return reportContol.getReportControlInfo(SubGyomuCode.AFA選挙本体, RDate.getNowDate());

    }
}
