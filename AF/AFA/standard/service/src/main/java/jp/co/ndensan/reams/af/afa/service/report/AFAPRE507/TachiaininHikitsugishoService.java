package jp.co.ndensan.reams.af.afa.service.report.AFAPRE507;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TachiaininHikitsugishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE507.TachiaininHikitsugishoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE507.TachiaininHikitsugishoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE507.TachiaininHikitsugishoSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 投票立会人引継書
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoService {

    private static final RString 全角スペース = new RString("　");
    private static final RString 他 = new RString("他");
    private static final int 人数 = 9;
    private static final int 項目数 = 5;

    /**
     * 投票立会人引継書
     *
     * @param tachiaininHikitsugishoList List<TachiaininHikitsugishoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TachiaininHikitsugishoParam> tachiaininHikitsugishoList) {
        try (ReportManager reportManager = new ReportManager()) {
            TachiaininHikitsugishoPorperty property = new TachiaininHikitsugishoPorperty();
            try (ReportAssembler<TachiaininHikitsugishoSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<TachiaininHikitsugishoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                if (null != tachiaininHikitsugishoList && !tachiaininHikitsugishoList.isEmpty()) {
                    for (TachiaininHikitsugishoParam param : tachiaininHikitsugishoList) {
                        List<TachiaininHikitsugishoParam> list = new ArrayList<>();
                        for (int i = 0; i < 項目数; i++) {
                            TachiaininHikitsugishoParam paramTemp = new TachiaininHikitsugishoParam(
                                    param.get立会時間_開始時刻(),
                                    param.get立会時間_終了時刻(),
                                    param.is異常なし(),
                                    param.is異常あり(),
                                    param.get異常内容(),
                                    param.get投票所名(),
                                    param.get投票用紙再交付者情報の氏名リスト(),
                                    param.get決定書または裁決書により投票をした者情報の氏名リスト(),
                                    param.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト(),
                                    param.get点字により投票をした者情報の氏名リスト(),
                                    param.get代理投票をした者情報の氏名リスト(),
                                    param.get投票拒否の決定をした者情報の氏名リスト()
                            );
                            paramTemp = set再交付氏名１列目と再交付氏名２列目(i, paramTemp);
                            paramTemp = set決定書氏名１列目と決定書氏名２列目(i, paramTemp);
                            paramTemp = set返還不在者氏名１列目と返還不在者氏名２列目(i, paramTemp);
                            paramTemp = set点字氏名１列目と点字氏名２列目(i, paramTemp);
                            paramTemp = set代理氏名１列目と代理氏名２列目(i, paramTemp);
                            paramTemp = set拒否氏名１列目列目と拒否氏名２列目(i, paramTemp);
                            list.add(paramTemp);
                        }
                        for (TachiaininHikitsugishoReport report : toReports(list)) {
                            report.writeBy(reportSourceWriter);
                        }
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private TachiaininHikitsugishoParam set再交付氏名１列目と再交付氏名２列目(int i, TachiaininHikitsugishoParam paramTemp) {
        if (null != paramTemp.get投票用紙再交付者情報の氏名リスト()
                && !paramTemp.get投票用紙再交付者情報の氏名リスト().isEmpty()
                && i < paramTemp.get投票用紙再交付者情報の氏名リスト().size()) {
            paramTemp.set再交付氏名１列目(paramTemp.get投票用紙再交付者情報の氏名リスト().get(i));
        } else {
            paramTemp.set再交付氏名１列目(RString.EMPTY);
        }
        if (null != paramTemp.get投票用紙再交付者情報の氏名リスト()
                && !paramTemp.get投票用紙再交付者情報の氏名リスト().isEmpty()
                && i + 項目数 < paramTemp.get投票用紙再交付者情報の氏名リスト().size()) {
            if (人数 == (i + 項目数) && 人数 < paramTemp.get投票用紙再交付者情報の氏名リスト().size() - 1) {
                paramTemp.set再交付氏名２列目(paramTemp.get投票用紙再交付者情報の氏名リスト().get(i + 項目数).concat(全角スペース).concat(他));
            } else {
                paramTemp.set再交付氏名２列目(paramTemp.get投票用紙再交付者情報の氏名リスト().get(i + 項目数));
            }
        } else {
            paramTemp.set再交付氏名２列目(RString.EMPTY);
        }
        return paramTemp;
    }

    private TachiaininHikitsugishoParam set決定書氏名１列目と決定書氏名２列目(int i, TachiaininHikitsugishoParam paramTemp) {
        if (null != paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト()
                && !paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().isEmpty()
                && i < paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().size()) {
            paramTemp.set決定書氏名１列目(paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().get(i));
        } else {
            paramTemp.set決定書氏名１列目(RString.EMPTY);
        }
        if (null != paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト()
                && !paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().isEmpty()
                && i + 項目数 < paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().size()) {
            if (人数 == (i + 項目数) && 人数 < paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().size() - 1) {
                paramTemp.set決定書氏名２列目(paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().get(i + 項目数).concat(全角スペース).concat(他));
            } else {
                paramTemp.set決定書氏名２列目(paramTemp.get決定書または裁決書により投票をした者情報の氏名リスト().get(i + 項目数));
            }
        } else {
            paramTemp.set決定書氏名２列目(RString.EMPTY);
        }
        return paramTemp;

    }

    private TachiaininHikitsugishoParam set返還不在者氏名１列目と返還不在者氏名２列目(int i, TachiaininHikitsugishoParam paramTemp) {
        if (null != paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト()
                && !paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().isEmpty()
                && i < paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().size()) {
            paramTemp.set返還不在者氏名１列目(paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().get(i));
        } else {
            paramTemp.set返還不在者氏名１列目(RString.EMPTY);
        }
        if (null != paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト()
                && !paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().isEmpty()
                && i + 項目数 < paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().size()) {
            if (人数 == (i + 項目数) && 人数 < paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().size() - 1) {
                paramTemp.set返還不在者氏名２列目(paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト()
                        .get(i + 項目数).concat(全角スペース).concat(他));
            } else {
                paramTemp.set返還不在者氏名２列目(paramTemp.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().get(i + 項目数));
            }
        } else {
            paramTemp.set返還不在者氏名２列目(RString.EMPTY);
        }
        return paramTemp;
    }

    private TachiaininHikitsugishoParam set点字氏名１列目と点字氏名２列目(int i, TachiaininHikitsugishoParam paramTemp) {
        if (null != paramTemp.get点字により投票をした者情報の氏名リスト()
                && !paramTemp.get点字により投票をした者情報の氏名リスト().isEmpty()
                && i < paramTemp.get点字により投票をした者情報の氏名リスト().size()) {
            paramTemp.set点字氏名１列目(paramTemp.get点字により投票をした者情報の氏名リスト().get(i));
        } else {
            paramTemp.set点字氏名１列目(RString.EMPTY);
        }
        if (null != paramTemp.get点字により投票をした者情報の氏名リスト()
                && !paramTemp.get点字により投票をした者情報の氏名リスト().isEmpty()
                && i + 項目数 < paramTemp.get点字により投票をした者情報の氏名リスト().size()) {
            if (人数 == (i + 項目数) && 人数 < paramTemp.get点字により投票をした者情報の氏名リスト().size() - 1) {
                paramTemp.set点字氏名２列目(paramTemp.get点字により投票をした者情報の氏名リスト()
                        .get(i + 項目数).concat(全角スペース).concat(他));
            } else {
                paramTemp.set点字氏名２列目(paramTemp.get点字により投票をした者情報の氏名リスト().get(i + 項目数));
            }
        } else {
            paramTemp.set点字氏名２列目(RString.EMPTY);
        }
        return paramTemp;
    }

    private TachiaininHikitsugishoParam set代理氏名１列目と代理氏名２列目(int i, TachiaininHikitsugishoParam paramTemp) {
        if (null != paramTemp.get代理投票をした者情報の氏名リスト()
                && !paramTemp.get代理投票をした者情報の氏名リスト().isEmpty()
                && i < paramTemp.get代理投票をした者情報の氏名リスト().size()) {
            paramTemp.set代理氏名１列目(paramTemp.get代理投票をした者情報の氏名リスト().get(i));
        } else {
            paramTemp.set代理氏名１列目(RString.EMPTY);
        }
        if (null != paramTemp.get代理投票をした者情報の氏名リスト()
                && !paramTemp.get代理投票をした者情報の氏名リスト().isEmpty()
                && i + 項目数 < paramTemp.get代理投票をした者情報の氏名リスト().size()) {
            if (人数 == (i + 項目数) && 人数 < paramTemp.get代理投票をした者情報の氏名リスト().size() - 1) {
                paramTemp.set代理氏名２列目(paramTemp.get代理投票をした者情報の氏名リスト()
                        .get(i + 項目数).concat(全角スペース).concat(他));
            } else {
                paramTemp.set代理氏名２列目(paramTemp.get代理投票をした者情報の氏名リスト().get(i + 項目数));
            }
        } else {
            paramTemp.set代理氏名２列目(RString.EMPTY);
        }
        return paramTemp;
    }

    private TachiaininHikitsugishoParam set拒否氏名１列目列目と拒否氏名２列目(int i, TachiaininHikitsugishoParam paramTemp) {
        if (null != paramTemp.get投票拒否の決定をした者情報の氏名リスト()
                && !paramTemp.get投票拒否の決定をした者情報の氏名リスト().isEmpty()
                && i < paramTemp.get投票拒否の決定をした者情報の氏名リスト().size()) {
            paramTemp.set拒否氏名１列目(paramTemp.get投票拒否の決定をした者情報の氏名リスト().get(i));
        } else {
            paramTemp.set拒否氏名１列目(RString.EMPTY);
        }
        if (null != paramTemp.get投票拒否の決定をした者情報の氏名リスト()
                && !paramTemp.get投票拒否の決定をした者情報の氏名リスト().isEmpty()
                && i + 項目数 < paramTemp.get投票拒否の決定をした者情報の氏名リスト().size()) {
            if (人数 == (i + 項目数) && 人数 < paramTemp.get投票拒否の決定をした者情報の氏名リスト().size() - 1) {
                paramTemp.set拒否氏名２列目(paramTemp.get投票拒否の決定をした者情報の氏名リスト()
                        .get(i + 項目数).concat(全角スペース).concat(他));
            } else {
                paramTemp.set拒否氏名２列目(paramTemp.get投票拒否の決定をした者情報の氏名リスト().get(i + 項目数));
            }
        } else {
            paramTemp.set拒否氏名２列目(RString.EMPTY);
        }
        return paramTemp;
    }

    private static List<TachiaininHikitsugishoReport> toReports(List<TachiaininHikitsugishoParam> targets) {
        List<TachiaininHikitsugishoReport> list = new ArrayList<>();
        list.add(new TachiaininHikitsugishoReport(targets));
        return list;
    }
}
