/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504BatchPrintProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.ReportOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 投票日前日関連帳票バッチ出力条件表のプロセスクラスです。
 *
 * @reamsid_L AF-0280-020 zhanggs
 */
public class ZenjitsuReportShutsuryokuJokenhyoProcess extends SimpleBatchProcessBase {

    private static final RString CSV_出力有無 = new RString("あり");
    private static final RString 出力条件_抄本番号 = new RString("【抄本番号】 ");
    private static final RString 出力条件_無投票選挙 = new RString("【無投票選挙も出力する】 ");
    private static final RString 出力条件_投票状況_受理期日前 = new RString("【投票状況】 受理、期日前");
    private static final RString 出力条件_投票区 = new RString("【投票区】 ");
    private static final RString 出力条件_受理日 = new RString("【受理日】 ");
    private static final RString 出力条件_出力対象_期日前 = new RString("【出力対象】 期日前投票");
    private static final RString 出力条件_出力対象_不在者 = new RString("【出力対象】 不在者投票");
    private static final RString 出力条件_出力対象_期日前不在者 = new RString("【出力対象】 期日前投票、不在者投票");
    private static final RString 出力条件_投票状況_期日前 = new RString("【投票状況】 期日前");
    private static final RString 出力条件_投票状況_受理 = new RString("【投票状況】 受理");
    private static final RString 出力条件_投票状況_期日前受理 = new RString("【投票状況】 期日前、受理");
    private static final RString 出力条件_投票状況_交付受理返還 = new RString("【投票状況】 交付、受理、返還");
    private static final RString 出力条件_投票状況_期日前交付受理返還 = new RString("【投票状況】 期日前、交付、受理、返還");
    private static final RString 出力条件_投票状況_交付受理 = new RString("【投票状況】 交付、受理");
    private static final RString 出力条件_投票状況_請求交付受理返還 = new RString("【投票状況】 請求、交付、受理、返還");
    private static final RString 出力条件_投票状況_有り = new RString("【投票状況】 有り");
    private static final RString 出力条件_交付年月日_有り = new RString("【交付年月日】 有り");
    private static final RString 出力条件_施設種別 = new RString("【施設種別】 病院、施設、郵便、他市町村、他施設、船舶、刑事施設等、少年院等、特定国外、南極地域");
    private static final RString 出力条件_施設 = new RString("【施設】 ");
    private static final RString 出力条件_交付日 = new RString("【交付日】 ");
    private static final RString 出力条件_印字有 = new RString("有り");
    private static final RString 出力条件_印字無 = new RString("無し");
    private static final RString 出力条件_期日前不在者区分_不在者投票 = new RString("【期日前不在者区分】 不在者投票");
    private static final RString 出力条件_投票事由 = new RString("【投票事由】 仕事等、旅行等、病院・施設等、交通至難等、住所移転、特定国外");
    private static final RString 出力条件_不在者投票資格 = new RString("不在者投票資格】 郵便等、洋上、南極");
    private static final RString 出力条件_人数を印字しない = new RString("【人数を印字しない】 ");
    private static final RString 出力条件_範囲符号 = new RString("～");
    private AFABTE504BatchPrintProcessParameter parameter;
    private Association association;

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 74 LINES
    @Override
    protected void process() {
        List<RString> 出力条件Base = get出力条件Base();
        List<ReportOutputJokenhyoItem> items = new ArrayList<>();
        if (parameter.get投票集計表出力有無()) {
            List<RString> 出力条件 = get投票集計表出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.投票集計表, parameter.get投票集計表出力数()));
        }
        if (parameter.get代理投票集計表出力有無()) {
            List<RString> 出力条件 = get代理投票集計表出力条件(出力条件Base);
            if (parameter.get代理投票集計表_出力対象_期日前投票有無()) {
                items.add(getItem(出力条件, ReportIdKeys.代理投票集計表_期日前, parameter.get代理投票集計表_期日前出力数()));
            }
            if (parameter.get代理投票集計表_出力対象_不在者投票有無()) {
                items.add(getItem(出力条件, ReportIdKeys.代理投票集計表_不在者, parameter.get代理投票集計表_不在者出力数()));
            }
        }
        if (parameter.get年代別投票状況調べ表出力有無()) {
            List<RString> 出力条件 = get年代別投票状況調べ表出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.年代別投票状況調べ, parameter.get年代別投票状況調べ表出力数()));
        }
        if (parameter.get時間別投票状況表出力有無()) {
            List<RString> 出力条件 = get時間別投票状況表出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.時間別投票状況表合計, parameter.get時間別投票状況表合計出力数()));
            items.add(getItem(出力条件, ReportIdKeys.時間別投票状況表投票所別, parameter.get時間別投票状況表投票所別出力数()));
        }
        if (parameter.get受理状況一覧表出力有無()) {
            List<RString> 出力条件 = get受理状況一覧表出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.受理状況一覧表, parameter.get受理状況一覧表出力数()));
        }
        if (parameter.get施設交付一覧表出力有無()) {
            List<RString> 出力条件 = get施設交付一覧表出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.施設交付一覧表, parameter.get施設交付一覧表出力数()));
        }
        if (parameter.get事務処理簿出力有無()) {
            List<RString> 出力条件 = get事務処理簿出力条件(出力条件Base);
            if (parameter.get事務処理簿_出力対象_期日前投票有無()) {
                items.add(getItem(出力条件, ReportIdKeys.事務処理簿_期日前, parameter.get事務処理簿_期日前出力数()));
            }
            if (parameter.get事務処理簿_出力対象_不在者投票有無()) {
                items.add(getItem(出力条件, ReportIdKeys.事務処理簿_不在者, parameter.get事務処理簿_不在者出力数()));
            }
        }
        if (parameter.get不在者投票に関する調書_25号様式出力有無()) {
            List<RString> 出力条件 = get不在者投票に関する調書_25号様式出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.不在者投票に関する調書25号様式, parameter.get不在者投票に関する調書_25号様式出力数()));
        }
        if (parameter.get不在者投票用紙等の調書出力有無()) {
            List<RString> 出力条件 = get不在者投票用紙等の調書出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.不在者投票用紙等の調書, parameter.get不在者投票用紙等の調書出力数()));
        }
        if (parameter.get不在者投票管理者別の調書出力有無()) {
            List<RString> 出力条件 = get不在者投票管理者別の調書出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.不在者投票管理者別の調書, parameter.get不在者投票管理者別の調書出力数()));
        }
        if (parameter.get登録者数リスト出力有無()) {
            List<RString> 出力条件 = get登録者数リスト出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.登録者数リスト, parameter.get登録者数リスト出力数()));
            if (parameter.get登録者数リスト_不在者投票資格者分出力有無()) {
                List<RString> 出力条件不在者 = get登録者数リスト_不在者投票資格者分出力条件(出力条件Base);
                items.add(getItem(出力条件不在者, ReportIdKeys.登録者数リスト不在者投票資格者分, parameter.get登録者数リスト_不在者投票資格者分出力数()));
            }
        }
        if (parameter.get有権者数調べ出力有無()) {
            List<RString> 出力条件 = get有権者数調べ出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.有権者数調べ, parameter.get有権者数調べ出力数()));
        }
        if (parameter.get選挙人名簿抄本出力有無()) {
            List<RString> 出力条件 = get選挙人名簿抄本出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.選挙人名簿抄本, parameter.get選挙人名簿抄本出力数()));
        }
        if (parameter.get送致書出力有無()) {
            List<RString> 出力条件 = get送致書出力条件(出力条件Base);
            items.add(getItem(出力条件, ReportIdKeys.送致書, parameter.get送致書出力数()));
        }
        ReportOutputJokenhyoFactory.createInstance(items).print();
    }

    private List<RString> get出力条件Base() {
        List<RString> 出力条件Base = new ArrayList();
        出力条件Base.add(出力条件_抄本番号.concat(parameter.get抄本番号().toString()));
        出力条件Base.add(出力条件_無投票選挙.concat(parameter.get無投票選挙有無() ? 出力条件_印字有 : 出力条件_印字無));
        return 出力条件Base;
    }

    private ReportOutputJokenhyoItem getItem(List<RString> 出力条件, ReportIdKeys reportIdKeys, Integer 出力数) {
        return new ReportOutputJokenhyoItem(
                reportIdKeys.value(),
                association.get地方公共団体コード().getColumnValue(),
                association.get市町村名(),
                new RString(parameter.getジョブ番号().toString()),
                reportIdKeys.getReportName(),
                new RString(出力数 == null ? 0 : 出力数),
                CSV_出力有無,
                reportIdKeys.getEucFileName(),
                出力条件);
    }

    private List<RString> get投票集計表出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_受理期日前);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get投票集計表_投票区from(), parameter.get投票集計表_投票区to()));
        出力条件.add(get出力条件(出力条件_受理日, parameter.get投票集計表_受理日from(), parameter.get投票集計表_受理日to()));
        return 出力条件;
    }

    private List<RString> get代理投票集計表出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力対象(parameter.get代理投票集計表_出力対象_期日前投票有無(), parameter.get代理投票集計表_出力対象_不在者投票有無()));
        出力条件.add(get代理投票集計表_投票状況());
        出力条件.add(get出力条件(出力条件_投票区, parameter.get代理投票集計表_投票区from(), parameter.get代理投票集計表_投票区to()));
        出力条件.add(get出力条件(出力条件_受理日, parameter.get代理投票集計表_受理日from(), parameter.get代理投票集計表_受理日to()));
        return 出力条件;
    }

    private List<RString> get年代別投票状況調べ表出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_受理期日前);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get年代別投票状況調べ表_投票区from(), parameter.get年代別投票状況調べ表_投票区to()));
        return 出力条件;
    }

    private List<RString> get時間別投票状況表出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_受理期日前);
        出力条件.add(出力条件_投票状況_期日前);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get時間別投票状況表_投票区from(), parameter.get時間別投票状況表_投票区to()));
        return 出力条件;
    }

    private List<RString> get受理状況一覧表出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_有り);
        出力条件.add(get出力条件(出力条件_受理日, parameter.get期日前_受理状況一覧表_受理日from(), parameter.get期日前_受理状況一覧表_受理日to()));
        return 出力条件;
    }

    private List<RString> get施設交付一覧表出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_交付年月日_有り);
        出力条件.add(出力条件_施設種別);
        出力条件.add(get出力条件(出力条件_施設, parameter.get施設交付一覧表_施設from(), parameter.get施設交付一覧表_施設to()));
        出力条件.add(get出力条件(出力条件_交付日, parameter.get施設交付一覧表_交付日from(), parameter.get施設交付一覧表_交付日to()));
        return 出力条件;
    }

    private List<RString> get事務処理簿出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力対象(parameter.get事務処理簿_出力対象_期日前投票有無(), parameter.get事務処理簿_出力対象_不在者投票有無()));
        出力条件.add(get事務処理簿_投票状況());
        出力条件.add(get出力条件(出力条件_投票区, parameter.get事務処理簿_投票区from(), parameter.get事務処理簿_投票区to()));
        return 出力条件;
    }

    private List<RString> get不在者投票に関する調書_25号様式出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_交付受理);
        出力条件.add(parameter.get不在者投票に関する調書_備考欄印字する有無() ? 出力条件_印字有 : 出力条件_印字無);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get不在者投票に関する調書投票区from(), parameter.get不在者投票に関する調書投票区to()));
        return 出力条件;
    }

    private List<RString> get不在者投票用紙等の調書出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_請求交付受理返還);
        出力条件.add(出力条件_期日前不在者区分_不在者投票);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get不在者投票用紙等の調書_投票区from(), parameter.get不在者投票用紙等の調書_投票区to()));
        return 出力条件;
    }

    private List<RString> get不在者投票管理者別の調書出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_投票状況_交付受理返還);
        出力条件.add(出力条件_期日前不在者区分_不在者投票);
        出力条件.add(出力条件_投票事由);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get不在者投票管理者別の調書_投票区from(), parameter.get不在者投票管理者別の調書_投票区to()));
        return 出力条件;
    }

    private List<RString> get登録者数リスト出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get登録者数リスト_投票区from(), parameter.get登録者数リスト_投票区to()));
        return 出力条件;
    }

    private List<RString> get登録者数リスト_不在者投票資格者分出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_不在者投票資格);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get登録者数リスト_投票区from(), parameter.get登録者数リスト_投票区to()));
        return 出力条件;
    }

    private List<RString> get有権者数調べ出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get有権者数調べ_投票区from(), parameter.get有権者数調べ_投票区to()));
        return 出力条件;
    }

    private List<RString> get選挙人名簿抄本出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get選挙人名簿抄本_投票区from(), parameter.get選挙人名簿抄本_投票区to()));
        return 出力条件;
    }

    private List<RString> get送致書出力条件(List<RString> 出力条件Base) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(get出力条件(出力条件_投票区, parameter.get送致書_投票区from(), parameter.get送致書_投票区to()));
        出力条件.add(出力条件_人数を印字しない.concat(parameter.get送致書_人数を印字しない有無() ? 出力条件_印字有 : 出力条件_印字無));
        return 出力条件;
    }

    private RString get出力対象(boolean 期日前投票有無, boolean 不在者投票有無) {
        if (期日前投票有無 && !不在者投票有無) {
            return 出力条件_出力対象_期日前;
        } else if (!期日前投票有無 && 不在者投票有無) {
            return 出力条件_出力対象_不在者;
        } else if (期日前投票有無 && 不在者投票有無) {
            return 出力条件_出力対象_期日前不在者;
        }
        return RString.EMPTY;
    }

    private RString get代理投票集計表_投票状況() {
        if (parameter.get代理投票集計表_出力対象_期日前投票有無() && !parameter.get代理投票集計表_出力対象_不在者投票有無()) {
            return 出力条件_投票状況_期日前;
        } else if (!parameter.get代理投票集計表_出力対象_期日前投票有無() && parameter.get代理投票集計表_出力対象_不在者投票有無()) {
            return 出力条件_投票状況_受理;
        } else if (parameter.get代理投票集計表_出力対象_期日前投票有無() && parameter.get代理投票集計表_出力対象_不在者投票有無()) {
            return 出力条件_投票状況_期日前受理;
        }
        return RString.EMPTY;
    }

    private RString get事務処理簿_投票状況() {
        if (parameter.get事務処理簿_出力対象_期日前投票有無() && !parameter.get事務処理簿_出力対象_不在者投票有無()) {
            return 出力条件_投票状況_期日前;
        } else if (!parameter.get事務処理簿_出力対象_期日前投票有無() && parameter.get事務処理簿_出力対象_不在者投票有無()) {
            return 出力条件_投票状況_交付受理返還;
        } else if (parameter.get事務処理簿_出力対象_期日前投票有無() && parameter.get事務処理簿_出力対象_不在者投票有無()) {
            return 出力条件_投票状況_期日前交付受理返還;
        }
        return RString.EMPTY;
    }

    private RString get出力条件(RString title, RString rangeFrom, RString rangeTo) {
        if (RString.isNullOrEmpty(rangeFrom) && RString.isNullOrEmpty(rangeTo)) {
            return title;
        }
        return title.concat(NullHandler.getNullToRString(rangeFrom)).concat(出力条件_範囲符号).concat(NullHandler.getNullToRString(rangeTo));
    }

    private RString get出力条件(RString title, FlexibleDate dateFrom, FlexibleDate dateTo) {
        if ((dateFrom == null || dateFrom.isEmpty()) && (dateTo == null || dateTo.isEmpty())) {
            return title;
        }
        return title.concat(dateFrom == null ? RString.EMPTY : toパターン12(dateFrom)).concat(出力条件_範囲符号)
                .concat(dateTo == null ? RString.EMPTY : toパターン12(dateTo));
    }

    private RString toパターン12(FlexibleDate date) {
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
