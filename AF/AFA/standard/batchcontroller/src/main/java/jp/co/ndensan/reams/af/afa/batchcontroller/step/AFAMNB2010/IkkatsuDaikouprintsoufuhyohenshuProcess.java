/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintEditor;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 代行プリント送付票編集するクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class IkkatsuDaikouprintsoufuhyohenshuProcess extends SimpleBatchProcessBase {

    private static final RString 処理名 = new RString("入場券発行（一括）");
    private static final RString 代行プリント送付票 = new RString("URU000A10_DaikoPrintCheck");
    private static final RString 抽出条件_抄本番号 = new RString("抄本番号　　");
    private static final RString 抽出条件_抄本名 = new RString("抄本名　　");
    private static final RString 抽出条件_選挙種類 = new RString("選挙種類　　");
    private static final RString 抽出条件_投票年月日 = new RString("投票年月日　　");
    private AFABTB201SelectProcessParameter parameter;

    @Override
    protected void process() {
        List<RString> 帳票名List = parameter.get帳票名リスト();
        List<Decimal> ページ数List = parameter.getページ数リスト();
        List<RString> 抽出条件List = new ArrayList<>();
        RString 抄本番号 = 抽出条件_抄本番号.concat(parameter.get抄本番号().toString());
        抽出条件List.add(抄本番号);
        RString 抄本名 = 抽出条件_抄本名.concat(parameter.get抄本名());
        抽出条件List.add(抄本名);
        RString 選挙種類 = 抽出条件_選挙種類.concat(parameter.get選挙種類());
        抽出条件List.add(選挙種類);
        RString 投票年月日 = 抽出条件_投票年月日.concat(edit日時(parameter.get投票日()));
        抽出条件List.add(投票年月日);
        List<RString> 改頁条件List = parameter.get改頁条件リスト();
        List<RString> 詳細設定List = parameter.get詳細設定リスト();
        List<RString> ソート順項目名称List = parameter.get出力順リスト();
        RString jobId = new RString(String.valueOf(parameter.getジョブ番号()));
        代行プリント送付票編集(jobId,
                帳票名List,
                ページ数List,
                抽出条件List,
                ソート順項目名称List,
                詳細設定List,
                改頁条件List);
    }

    /**
     * 代行プリント送付票編集する。
     *
     * @param ジョブ番号 RString
     * @param 帳票名 List<RString>
     * @param ページ数 List<Decimal>
     * @param 抽出条件 List<RString>
     * @param ソート順項目名称List List<RString>
     * @param 詳細設定 List<RString>
     * @param 改頁条件 List<RString>
     *
     */
    public void 代行プリント送付票編集(RString ジョブ番号,
            List<RString> 帳票名,
            List<Decimal> ページ数,
            List<RString> 抽出条件,
            List<RString> ソート順項目名称List,
            List<RString> 詳細設定,
            List<RString> 改頁条件) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> 出力順 = new ArrayList<>();
        if (!ソート順項目名称List.isEmpty()) {
            出力順.add(DaikoPrintEditor.edit出力順(ソート順項目名称List));
        }
        DaikoPrintItem 代行プリントパラメータ = new DaikoPrintItem(
                SubGyomuCode.AFA選挙本体,
                association.get地方公共団体コード(),
                association.get市町村名(),
                ジョブ番号,
                処理名,
                代行プリント送付票,
                帳票名,
                ページ数,
                抽出条件,
                出力順,
                改頁条件,
                詳細設定);
        DaikoPrintFactory.createInstance(代行プリントパラメータ).print();
    }

    /**
     * FlexibleDateを編集する。
     *
     * @param 投票年月日
     * @return 日時
     */
    private RString edit日時(FlexibleDate 投票年月日) {
        return 投票年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
