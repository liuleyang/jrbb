/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE301;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE506.KijitsumaeTohyorokuCommon;
import jp.co.ndensan.reams.af.afa.definition.core.TohyouSha;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE301.TojitsuTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TojitsuTohyorokuiReportSource}を編集します。
 *
 * @reamsid_L AF-0130-021 lit
 */
public class TojitsuTohyorokuiSecondEditor extends KijitsumaeTohyorokuCommon implements ITojitsuTohyorokuEditor {

    private final TohyorokuChohyo item;
    private static final int MAX_NO = 30;

    private boolean lastFlg = true;

    /**
     * コンストラクタです。
     *
     * @param item {@link TohyorokuChohyo}
     */
    public TojitsuTohyorokuiSecondEditor(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public TojitsuTohyorokuReportSource edit(TojitsuTohyorokuReportSource source) {
        setヘッダ(source);
        set明細(source);
        source.layout = TojitsuTohyorokuReportSource.Layouts.AFAPRE301_TojitsuTohyoroku1mai2;
        return source;
    }

    private void setヘッダ(TojitsuTohyorokuReportSource source) {
        source.subTitle = タイトル_符号左
                .concat(item.getタイトル())
                .concat(タイトル_当日投票所投票録)
                .concat(タイトル_別紙)
                .concat(タイトル_符号右);
        source.tohyoShuruiTitle = RString.EMPTY;
        source.tohyoYmd = getKanjiYmd(item.get投票年月日());
        source.tohyoBasho = item.get投票場所();
        source.shuruiTitle = item.get種類タイトル();
        source.choseiYmd = getKanjiYmd(item.get調整年月日());
    }

    private void set明細(TojitsuTohyorokuReportSource source) {
        List<TohyouSha> 代理投票者リスト = item.get代理投票者リスト();
        if (null == 代理投票者リスト || 代理投票者リスト.isEmpty()) {
            return;
        }

        TohyouSha 代理投票者 = 代理投票者リスト.get(item.get代理投票者Index());
        source.pageNo = new RString(String.valueOf(item.get代理投票者Index() / MAX_NO + 1));
        source.listNo_1 = new RString(String.valueOf(item.get代理投票者Index() + 1));
        source.listDairiTohyo_1 = 代理投票者.get氏名();
        source.listDairiTohyo_2 = 代理投票者.get補助者1氏名();
        source.listDairiTohyo_3 = 代理投票者.get補助者2氏名();
    }

    @Override
    public boolean isLastFlg() {
        return this.lastFlg;
    }

    @Override
    public void setLastFlg(boolean lastFlg) {
        this.lastFlg = lastFlg;
    }
}
