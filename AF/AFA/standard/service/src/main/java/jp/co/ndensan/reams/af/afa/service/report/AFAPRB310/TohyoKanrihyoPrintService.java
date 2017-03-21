package jp.co.ndensan.reams.af.afa.service.report.AFAPRB310;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoKanrihyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB310.TohyoKanrihyoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB310.TohyoKanrihyoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB310.TohyoKanrihyoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoPrintService {

    private static final RString 長さ_経由領事官１ = new RString("listKeiyuRyojiKan1_1");

    /**
     * 在外投票資格者名簿
     *
     * @param zaigaiShikakushaMeiboList List<TohyoKanrihyoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TohyoKanrihyoParam> zaigaiShikakushaMeiboList) {
        try (ReportManager reportManager = new ReportManager()) {
            TohyoKanrihyoPorperty property = new TohyoKanrihyoPorperty();
            try (ReportAssembler<TohyoKanrihyoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<TohyoKanrihyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = new NotTorokuTsuchiHonnin();

                if (null != zaigaiShikakushaMeiboList && !zaigaiShikakushaMeiboList.isEmpty()) {
                    for (TohyoKanrihyoParam param : zaigaiShikakushaMeiboList) {

                        List<TohyoKanrihyoParam> list = new ArrayList<>();

                        RString 選挙資格区分略称 = RString.EMPTY;
                        Code 選挙資格コード = param.get在外選挙異動累積情報().get在外選挙資格().getShikakuKubun();
                        RString 選挙資格区分 = null == 選挙資格コード ? RString.EMPTY : 選挙資格コード.getColumnValue();
                        List<UzT0007CodeEntity> 選挙資格名称リスト = CodeMaster.getCode(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
                        if (null != 選挙資格名称リスト && !選挙資格名称リスト.isEmpty()) {
                            選挙資格区分略称 = set選挙資格区分略称(選挙資格名称リスト, 選挙資格区分, 選挙資格区分略称);
                        }
                        RString 資格 = 選挙資格区分略称;

                        RString 性別 = notTorokuTsuchiHonnin.get性別(param.get在外選挙異動累積情報().get在外選挙人申請情報().getSeibetsuCode());

                        RString 経由領事官１;
                        RString 経由領事官２ = RString.EMPTY;
                        RString 領事官名称 = notTorokuTsuchiHonnin.get領事官名称(param.get在外選挙異動累積情報().get在外選挙人申請情報().getRyojikanCode());
                        if (getItemLength(長さ_経由領事官１) >= 領事官名称.length()) {
                            経由領事官１ = 領事官名称;
                        } else {
                            経由領事官１ = 領事官名称.substring(0, getItemLength(長さ_経由領事官１));
                            経由領事官２ = 領事官名称.substring(getItemLength(長さ_経由領事官１));
                        }

                        param.set資格(資格);
                        param.set性別(性別);
                        param.set経由領事官１(経由領事官１);
                        param.set経由領事官２(経由領事官２);
                        list.add(param);

                        for (TohyoKanrihyoReport report : toReports(list, ChouhyouCommon.create帳票共通ヘッダー())) {
                            report.writeBy(reportSourceWriter);
                        }
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static List<TohyoKanrihyoReport> toReports(List<TohyoKanrihyoParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<TohyoKanrihyoReport> list = new ArrayList<>();
        list.add(new TohyoKanrihyoReport(targets, 帳票共通ヘッダー));
        return list;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(TohyoKanrihyoReportSource.class, itemName);
    }

    private RString set選挙資格区分略称(List<UzT0007CodeEntity> 選挙資格名称リスト, RString 選挙資格区分, RString 選挙資格区分略称) {
        for (UzT0007CodeEntity codeEntity : 選挙資格名称リスト) {
            if (選挙資格区分.equals(codeEntity.getコード().getColumnValue())) {
                選挙資格区分略称 = codeEntity.getコード略称();
                break;
            }
        }
        return 選挙資格区分略称;
    }
}
