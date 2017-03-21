package jp.co.ndensan.reams.af.afa.service.report.AFAPRB309;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiShikakushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB309.ZaigaiShikakushaMeiboPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB309.ZaigaiShikakushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB309.ZaigaiShikakushaMeiboReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.IZenkokuJushoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboPrintService {

    private final RString 全角スペース = new RString("　");
    private static final RString 長さ_最終住所または本籍地１ = new RString("listMeisai1_3");
    private static final RString 長さ_最終住所または本籍地２ = new RString("listMeisai2_4");
    private static final RString 最終住所 = new RString("0");
    private static final RString 申請時の本籍 = new RString("1");

    /**
     * 在外投票資格者名簿
     *
     * @param zaigaiShikakushaMeiboList List<ZaigaiShikakushaMeiboParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ZaigaiShikakushaMeiboParam> zaigaiShikakushaMeiboList) {
        try (ReportManager reportManager = new ReportManager()) {
            ZaigaiShikakushaMeiboPorperty property = new ZaigaiShikakushaMeiboPorperty();
            try (ReportAssembler<ZaigaiShikakushaMeiboReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<ZaigaiShikakushaMeiboReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = new NotTorokuTsuchiHonnin();
                TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();

                if (null != zaigaiShikakushaMeiboList && !zaigaiShikakushaMeiboList.isEmpty()) {

                    int 連番 = 1;
                    for (ZaigaiShikakushaMeiboParam param : zaigaiShikakushaMeiboList) {
                        List<ZaigaiShikakushaMeiboParam> list = new ArrayList<>();

                        set在外投票資格者名簿リスト(param, notTorokuTsuchiHonnin, list, 連番);
                        連番++;
                        for (ZaigaiShikakushaMeiboReport report : toReports(list, 帳票共通ヘッダー)) {
                            report.writeBy(reportSourceWriter);
                        }
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ZaigaiShikakushaMeiboReport> toReports(List<ZaigaiShikakushaMeiboParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<ZaigaiShikakushaMeiboReport> list = new ArrayList<>();
        list.add(new ZaigaiShikakushaMeiboReport(targets, 帳票共通ヘッダー));
        return list;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ZaigaiShikakushaMeiboReportSource.class, itemName);
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通ヘッダー = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通ヘッダー.set選挙名称(定時登録.toRString());
        帳票共通ヘッダー.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通ヘッダー;
    }

    private RString set申請区分略称(List<UzT0007CodeEntity> 申請略称リスト, RString 申請区分, RString 申請区分略称) {
        for (UzT0007CodeEntity codeEntity : 申請略称リスト) {
            if (申請区分.equals(codeEntity.getコード().getColumnValue())) {
                申請区分略称 = codeEntity.getコード略称();
                break;
            }
        }
        return 申請区分略称;
    }

    private RString set選挙資格区分名称(List<UzT0007CodeEntity> 選挙資格名称リスト, RString 選挙資格区分, RString 選挙資格区分名称) {
        for (UzT0007CodeEntity codeEntity : 選挙資格名称リスト) {
            if (選挙資格区分.equals(codeEntity.getコード().getColumnValue())) {
                選挙資格区分名称 = codeEntity.getコード名称();
                break;
            }
        }
        return 選挙資格区分名称;
    }

    private RString set本籍地登録(List<UzT0007CodeEntity> 本籍地登録リスト, RString 本籍地登録区分, RString 本籍地登録) {
        for (UzT0007CodeEntity codeEntity : 本籍地登録リスト) {
            if (本籍地登録区分.equals(codeEntity.getコード().getColumnValue())) {
                本籍地登録 = codeEntity.getコード略称();
                break;
            }
        }
        return 本籍地登録;
    }

    private List set在外投票資格者名簿リスト(ZaigaiShikakushaMeiboParam param,
            NotTorokuTsuchiHonnin notTorokuTsuchiHonnin, List<ZaigaiShikakushaMeiboParam> list, int 連番) {

        RString 申請区分略称 = RString.EMPTY;
        RString 選挙資格区分名称 = RString.EMPTY;
        Code 申請コード = param.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseiKubun();
        RString 申請区分 = null == 申請コード ? RString.EMPTY : 申請コード.getColumnValue();
        Code 選挙資格コード = param.get在外選挙異動累積情報().get在外選挙資格().getShikakuKubun();
        RString 選挙資格区分 = null == 選挙資格コード ? RString.EMPTY : 選挙資格コード.getColumnValue();
        List<UzT0007CodeEntity> 申請略称リスト = CodeMaster.getCode(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.申請区分.getCodeShubetsu());
        List<UzT0007CodeEntity> 選挙資格名称リスト = CodeMaster.getCode(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
        if (null != 申請略称リスト && !申請略称リスト.isEmpty()) {
            申請区分略称 = set申請区分略称(申請略称リスト, 申請区分, 申請区分略称);
        }
        if (null != 選挙資格名称リスト && !選挙資格名称リスト.isEmpty()) {
            選挙資格区分名称 = set選挙資格区分名称(選挙資格名称リスト, 選挙資格区分, 選挙資格区分名称);

        }
        RString 申請資格 = 申請区分略称.concat(全角スペース).concat(選挙資格区分名称);

        RString 最終住所_本籍地 = RString.EMPTY;
        Code 本籍地区分 = param.get在外選挙異動累積情報().get在外選挙資格().getHonsekiTorokuKubun();
        RString 本籍地登録区分 = null == 本籍地区分 ? RString.EMPTY : 本籍地区分.getColumnValue();
        if (最終住所.equals(本籍地登録区分)) {
            最終住所_本籍地 = param.get在外選挙異動累積情報().get最終住所().getColumnValue()
                    .concat(param.get在外選挙異動累積情報().get最終番地().getColumnValue())
                    .concat(全角スペース)
                    .concat(param.get在外選挙異動累積情報().get最終方書().getColumnValue());
        }
        if (申請時の本籍.equals(本籍地登録区分)) {
            最終住所_本籍地 = param.get在外選挙異動累積情報().get本籍住所().getColumnValue()
                    .concat(param.get在外選挙異動累積情報().get本籍番地().getColumnValue());
        }
        if (getItemLength(長さ_最終住所または本籍地１) >= 最終住所_本籍地.length()) {
            param.set最終住所または本籍地_１(最終住所_本籍地);
            param.set最終住所または本籍地_２(RString.EMPTY);
        } else if (getItemLength(長さ_最終住所または本籍地１) + getItemLength(長さ_最終住所または本籍地２) >= 最終住所_本籍地.length()) {
            param.set最終住所または本籍地_１(最終住所_本籍地.substring(0, getItemLength(長さ_最終住所または本籍地１)));
            param.set最終住所または本籍地_２(最終住所_本籍地.substring(getItemLength(長さ_最終住所または本籍地１)));
        } else {
            param.set最終住所または本籍地_１(最終住所_本籍地.substring(0, getItemLength(長さ_最終住所または本籍地１)));
            param.set最終住所または本籍地_２(最終住所_本籍地.substring(getItemLength(長さ_最終住所または本籍地１), getItemLength(長さ_最終住所または本籍地２)));
        }
        RString 性別 = notTorokuTsuchiHonnin.get性別(param.get在外選挙異動累積情報().get在外選挙人申請情報().getSeibetsuCode());
        RString 生年月日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙人申請情報().getSeinengappiYMD());
        RString 申請年月日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseiYMD());
        RString 登録年月日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙資格().getMeiboTorokuYMD());
        RString 表示年月日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙資格().getHyojiYMD());
        RString 抹消年月日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙資格().getMasshoYMD());
        RString 照会日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙人申請情報().getHonsekiShokaiYMD());
        RString 回答日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙人申請情報().getHonsekiKaitoYMD());
        RString 通知日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙人申請情報().getHonsekiTsuchiYMD());
        RString 交付日 = notTorokuTsuchiHonnin.get日付編集(param.get在外選挙異動累積情報().get在外選挙資格().getKofuYMD());
        RString 項番 = new RString(連番);
        RString 領事官名称 = notTorokuTsuchiHonnin.get領事官名称(param.get在外選挙異動累積情報().get在外選挙人申請情報().getRyojikanCode());

        RString 本籍地 = RString.EMPTY;
        ZenkokuJushoCode 本籍全国住所コード = param.get在外選挙異動累積情報().get本籍全国住所コード();
        IZenkokuJushoFinder zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(本籍全国住所コード);
        if (null != zenkokuJushoItem) {
            本籍地 = zenkokuJushoItem.get都道府県名().concat(zenkokuJushoItem.get市町村名());
        }

        RString 本籍地登録 = RString.EMPTY;
        List<UzT0007CodeEntity> 本籍地登録リスト = CodeMaster.getCode(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.本籍地登録区分.getCodeShubetsu());
        if (null != 本籍地登録リスト && !本籍地登録リスト.isEmpty()) {
            本籍地登録 = set本籍地登録(本籍地登録リスト, 本籍地登録区分, 本籍地登録);
        }

        param.set申請資格(申請資格);
        param.set性別(性別);
        param.set生年月日(生年月日);
        param.set申請年月日(申請年月日);
        param.set登録年月日(登録年月日);
        param.set表示年月日(表示年月日);
        param.set抹消年月日(抹消年月日);
        param.set項番(項番);
        param.set経由領事官等の名称(領事官名称);
        param.set本籍地(本籍地);
        param.set照会日(照会日);
        param.set回答日(回答日);
        param.set通知日(通知日);
        param.set交付日(交付日);
        param.set本籍地登録(本籍地登録);
        list.add(param);

        return list;
    }
}
