/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.definition.core.TohyouSha;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506.KijitsumaeTohyorokuReportSource;

/**
 * {@link KijitsumaeTohyorokuReportSource}を編集します。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuThreeMaiThirdEditor extends KijitsumaeTohyorokuCommon implements IKijitsumaeTohyorokuEditor {

    private final TohyorokuChohyo item;

    /**
     * コンストラクタです。
     *
     * @param item {@link TohyorokuChohyo}
     */
    public KijitsumaeTohyorokuThreeMaiThirdEditor(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public KijitsumaeTohyorokuReportSource edit(KijitsumaeTohyorokuReportSource source) {
        set帳票情報(source);
        source.layout = KijitsumaeTohyorokuReportSource.Layouts.AFAPRE506_KijitsumaeTohyoroku3mai3;
        return source;
    }

    private void set帳票情報(KijitsumaeTohyorokuReportSource source) {
        set投票基本情報(source);
        set投票拒否者法1リスト(source);
        set投票拒否者法2リスト(source);
    }

    private void set投票基本情報(KijitsumaeTohyorokuReportSource source) {
        source.shuruiTitle = item.get種類タイトル();
        source.jimuSosu = getFormatNumber(item.get従事者総数());
        source.jimu1 = getFormatNumber(item.get選挙管理委員会書記数());
        source.jimu2 = getFormatNumber(item.get職員数());
        source.jimu3 = getFormatNumber(item.getその他数());
        source.choseiYmd = getKanjiYmd(item.get調整年月日());
    }

    private void set投票拒否者法1リスト(KijitsumaeTohyorokuReportSource source) {
        source.houNo1 = item.get法1();

        List<TohyouSha> 法1リスト = item.get投票拒否者法1リスト();
        if (null == 法1リスト || 法1リスト.isEmpty()) {
            return;
        }
        TohyouSha 法投票者;
        if (法1リスト.size() >= TohyoshaIndex.法1投票拒否者1.getIndex()) {
            法投票者 = 法1リスト.get(TohyoshaIndex.法1投票拒否者1.getListIndex());
            source.shimei1Jo = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, true);
            source.shimei1Ge = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, false);
            source.kyohiJiyu1Jo = getSubString(法投票者.get事由(), 事由_上段表示可能数, true);
            source.kyohiJiyu1Ge = getSubString(法投票者.get事由(), 事由_上段表示可能数, false);
            source.kariUmu1 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法1リスト.size() >= TohyoshaIndex.法1投票拒否者2.getIndex()) {
            法投票者 = 法1リスト.get(TohyoshaIndex.法1投票拒否者2.getListIndex());
            source.shimei2Jo = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, true);
            source.shimei2Ge = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, false);
            source.kyohiJiyu2Jo = getSubString(法投票者.get事由(), 事由_上段表示可能数, true);
            source.kyohiJiyu2Ge = getSubString(法投票者.get事由(), 事由_上段表示可能数, false);
            source.kariUmu2 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法1リスト.size() >= TohyoshaIndex.法1投票拒否者3.getIndex()) {
            法投票者 = 法1リスト.get(TohyoshaIndex.法1投票拒否者3.getListIndex());
            source.shimei3Jo = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, true);
            source.shimei3Ge = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, false);
            source.kyohiJiyu3Jo = getSubString(法投票者.get事由(), 事由_上段表示可能数, true);
            source.kyohiJiyu3Ge = getSubString(法投票者.get事由(), 事由_上段表示可能数, false);
            source.kariUmu3 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
    }

    private void set投票拒否者法2リスト(KijitsumaeTohyorokuReportSource source) {
        source.houNo2 = item.get法2();

        List<TohyouSha> 法2リスト = item.get投票拒否者法2リスト();
        if (null == 法2リスト || 法2リスト.isEmpty()) {
            return;
        }
        TohyouSha 法投票者;
        if (法2リスト.size() >= TohyoshaIndex.法2投票拒否者1.getIndex()) {
            法投票者 = 法2リスト.get(TohyoshaIndex.法2投票拒否者1.getListIndex());
            source.dShimei1Jo = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, true);
            source.dShimei1Ge = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, false);
            source.dKyohiJiyu1Jo = getSubString(法投票者.get事由(), 事由_上段表示可能数, true);
            source.dKyohiJiyu1Ge = getSubString(法投票者.get事由(), 事由_上段表示可能数, false);
            source.dKariUmu1 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法2リスト.size() >= TohyoshaIndex.法2投票拒否者2.getIndex()) {
            法投票者 = 法2リスト.get(TohyoshaIndex.法2投票拒否者2.getListIndex());
            source.dShimei2Jo = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, true);
            source.dShimei2Ge = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, false);
            source.dKyohiJiyu2Jo = getSubString(法投票者.get事由(), 事由_上段表示可能数, true);
            source.dKyohiJiyu2Ge = getSubString(法投票者.get事由(), 事由_上段表示可能数, false);
            source.dKariUmu2 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法2リスト.size() >= TohyoshaIndex.法2投票拒否者3.getIndex()) {
            法投票者 = 法2リスト.get(TohyoshaIndex.法2投票拒否者3.getListIndex());
            source.dShimei3Jo = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, true);
            source.dShimei3Ge = getSubString(法投票者.get氏名(), 氏名_上段表示可能数, false);
            source.dKyohiJiyu3Jo = getSubString(法投票者.get事由(), 事由_上段表示可能数, true);
            source.dKyohiJiyu3Ge = getSubString(法投票者.get事由(), 事由_上段表示可能数, false);
            source.dKariUmu3 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
    }

    @Override
    public boolean isLastFlg() {
        return true;
    }

    @Override
    public void setLastFlg(boolean lastFlg) {
    }
}
