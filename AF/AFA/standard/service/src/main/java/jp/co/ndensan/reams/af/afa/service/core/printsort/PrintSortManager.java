/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.printsort;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.printsort.ReportControlResult;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.printsort.PrintSortDac;
import jp.co.ndensan.reams.uz.uza.report.dac.entities.UzT0400ReportControlEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票出力条件保守のクラス
 *
 * @reamsid_L AF-0680-010 wanghj
 */
public class PrintSortManager {

    private final PrintSortDac dac;

    /**
     * コンストラクタです。
     */
    public PrintSortManager() {
        dac = InstanceProvider.create(PrintSortDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link PrintSortManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link PrintSortManager}のインスタンス
     */
    public static PrintSortManager createInstance() {
        return InstanceProvider.create(PrintSortManager.class);
    }

    /**
     * 帳票データを取得します。
     *
     * @return ReportControlResult
     */
    public List<ReportControlResult> get帳票データ() {
        List<ReportControlResult> list = new ArrayList<>();
        List<UzT0400ReportControlEntity> 帳票データ = dac.select();
        if (null == 帳票データ || 帳票データ.isEmpty()) {
            return null;
        }
        for (UzT0400ReportControlEntity entity : 帳票データ) {
            list.add(new ReportControlResult(entity));
        }
        return list;
    }

}
