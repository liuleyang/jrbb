/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票情報を検索するためのクラスです。
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public final class ChouhyouCommon {

    private ChouhyouCommon() {
    }

    /**
     * 帳票共通ヘッダー
     *
     * @return TeijiCommonJohoItem
     */
    public static TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通 = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通.set選挙名称(定時登録.toRString());
        帳票共通.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通;
    }

    /**
     * Assembler確立
     *
     * @param <T> IReportSource
     * @param <R> Report
     * @param property IReportProperty<T>
     * @param manager ReportManager
     * @return reportbuilder
     */
    public static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property,
            ReportManager manager) {
        ReportAssemblerBuilder reportbuilder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            reportbuilder.addBreak(breaker);
        }
        reportbuilder.isHojinNo(property.containsHojinNo());
        reportbuilder.isKojinNo(property.containsKojinNo());
        return reportbuilder.<T>create();
    }
}
