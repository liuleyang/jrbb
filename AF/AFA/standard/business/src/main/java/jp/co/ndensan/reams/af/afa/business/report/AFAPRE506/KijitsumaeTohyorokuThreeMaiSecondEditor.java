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
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KijitsumaeTohyorokuReportSource}を編集します。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuThreeMaiSecondEditor extends KijitsumaeTohyorokuCommon implements IKijitsumaeTohyorokuEditor {

    private static final int MAX_NO = 25;
    private final TohyorokuChohyo item;
    private boolean lastFlg = true;

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link TohyorokuChohyo}
     */
    public KijitsumaeTohyorokuThreeMaiSecondEditor(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public KijitsumaeTohyorokuReportSource edit(KijitsumaeTohyorokuReportSource source) {
        setヘッダ(source);
        set明細(source);
        source.layout = KijitsumaeTohyorokuReportSource.Layouts.AFAPRE506_KijitsumaeTohyoroku3mai2;
        return source;
    }

    private void setヘッダ(KijitsumaeTohyorokuReportSource source) {
        source.shuruiTitle = item.get種類タイトル();
        source.dairiTohyoshaSu = getFormatNumber(item.get代理投票者数());
    }

    private void set明細(KijitsumaeTohyorokuReportSource source) {
        List<TohyouSha> 代理投票者リスト = item.get代理投票者リスト();
        if (null == 代理投票者リスト || 代理投票者リスト.isEmpty()) {
            return;
        }

        TohyouSha 代理投票者 = 代理投票者リスト.get(item.get代理投票者Index());
        source.pageNo = new RString(String.valueOf(item.get代理投票者Index() / MAX_NO + 1));
        source.listNo_1 = new RString(String.valueOf(item.get代理投票者Index() + 1));
        source.listDairitohyoJo_1
                = getSubString(代理投票者.get氏名(), 氏名_上段表示可能数, true);
        source.listDairitohyoGe_1
                = getSubString(代理投票者.get氏名(), 氏名_上段表示可能数, false);
        source.listDairitohyoJo_2
                = getSubString(代理投票者.get補助者1氏名(), 氏名_上段表示可能数, true);
        source.listDairitohyoGe_2
                = getSubString(代理投票者.get補助者1氏名(), 氏名_上段表示可能数, false);
        source.listDairitohyoJo_3
                = getSubString(代理投票者.get補助者2氏名(), 氏名_上段表示可能数, true);
        source.listDairitohyoGe_3
                = getSubString(代理投票者.get補助者2氏名(), 氏名_上段表示可能数, false);
    }

    @Override
    public boolean isLastFlg() {
        return lastFlg;
    }

    @Override
    public void setLastFlg(boolean lastFlg) {
        this.lastFlg = lastFlg;
    }
}
