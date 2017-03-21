/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE516;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE516.FuzaishaTohyoChoshoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE516_FuzaishaTohyoChosho_不在者投票に関する調書（25号様式）を編集するクラスです。
 *
 * @reamsid_L AF-0280-033 wangm
 */
public class FuzaishaTohyoChoshoEditor implements IFuzaishaTohyoChoshoEditor {

    private static final int 第53条 = 0;
    private static final int 第54条 = 1;
    private static final int 第59条の4 = 2;
    private static final int 第59条の5 = 3;
    private static final int 第59条の6 = 4;

    private static final int 交付 = 0;
    private static final int 投票者男 = 1;
    private static final int 投票者女 = 2;
    private static final int 投票者計 = 3;
    private static final int 代理 = 4;
    private static final int 点字 = 5;

    private static final RString 代理_HEAD = new RString("代理");
    private static final RString 点字_HEAD = new RString("点字");
    private static final RString 人_TAIL = new RString("人");

    private final FuzaishaTohyoChoshoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link FuzaishaTohyoChoshoParam}
     */
    public FuzaishaTohyoChoshoEditor(FuzaishaTohyoChoshoParam target) {
        this.target = target;
    }

    @Override
    public FuzaishaTohyoChoshoSource edit(FuzaishaTohyoChoshoSource source) {

        source.senkyoMei = target.get選挙名称();
        source.touhyokuMei = target.get投票区名();
        source.tohyoYmd = target.get調製年月日();
        source.iinkaiMei = target.get委員会名();
        source.iinchoMei = target.get委員長名();

        source.nin53kofu = edit交付(target.get投票者().get(第53条));
        source.nin53man = edit投票者男(target.get投票者().get(第53条));
        source.nin53woman = edit投票者女(target.get投票者().get(第53条));
        source.nin53kei = edit投票者計(target.get投票者().get(第53条));
        source.nin54man = edit投票者男(target.get投票者().get(第54条));
        source.nin54woman = edit投票者女(target.get投票者().get(第54条));
        source.nin54kei = edit投票者計(target.get投票者().get(第54条));
        source.nin594kofu = edit交付(target.get投票者().get(第59条の4));
        source.nin594man = edit投票者男(target.get投票者().get(第59条の4));
        source.nin594woman = edit投票者女(target.get投票者().get(第59条の4));
        source.nin594kei = edit投票者計(target.get投票者().get(第59条の4));
        source.nin595kofu = edit交付(target.get投票者().get(第59条の5));
        source.nin595man = edit投票者男(target.get投票者().get(第59条の5));
        source.nin595woman = edit投票者女(target.get投票者().get(第59条の5));
        source.nin595kei = edit投票者計(target.get投票者().get(第59条の5));
        source.nin596man = edit投票者男(target.get投票者().get(第59条の6));
        source.nin596woman = edit投票者女(target.get投票者().get(第59条の6));
        source.nin596kei = edit投票者計(target.get投票者().get(第59条の6));
        source.ninShokeiMan = edit投票者男(target.get小計());
        source.ninShokeiWoman = edit投票者女(target.get小計());
        source.ninShokeiKei = edit投票者計(target.get小計());
        source.ninGokeiKofu = edit交付(target.get小計());
        source.ninGokeiMan = edit投票者男(target.get小計());
        source.ninGokeiWoman = edit投票者女(target.get小計());
        source.ninGokeiKei = edit投票者計(target.get小計());

        if (target.is印字有無フラグ()) {
            source.nin53dairi = edit代理(target.get投票者().get(第53条));
            source.nin53tenji = edit点字(target.get投票者().get(第53条));
            source.nin54dairi = edit代理(target.get投票者().get(第54条));
            source.nin54tenji = edit点字(target.get投票者().get(第54条));
            source.nin594dairi = edit代理(target.get投票者().get(第59条の4));
            source.nin594tenji = edit点字(target.get投票者().get(第59条の4));
            source.nin595dairi = edit代理(target.get投票者().get(第59条の5));
            source.nin595tenji = edit点字(target.get投票者().get(第59条の5));
            source.nin596dairi = edit代理(target.get投票者().get(第59条の6));
            source.nin596tenji = edit点字(target.get投票者().get(第59条の6));
            source.ninShokeiDairi = edit代理(target.get小計());
            source.ninShokeiTenji = edit点字(target.get小計());
            source.ninGokeiDairi = edit代理(target.get小計());
            source.ninGokeiTenji = edit点字(target.get小計());
        }

        return source;
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    private RString edit交付(List<Decimal> 投票者) {
        return formatInt(投票者.get(交付));
    }

    private RString edit投票者男(List<Decimal> 投票者) {
        return formatInt(投票者.get(投票者男));
    }

    private RString edit投票者女(List<Decimal> 投票者) {
        return formatInt(投票者.get(投票者女));
    }

    private RString edit投票者計(List<Decimal> 投票者) {
        return formatInt(投票者.get(投票者計));
    }

    private RString edit代理(List<Decimal> 投票者) {
        return 代理_HEAD.concat(投票者.get(代理).toString()).concat(人_TAIL);
    }

    private RString edit点字(List<Decimal> 投票者) {
        return 点字_HEAD.concat(投票者.get(点字).toString()).concat(人_TAIL);
    }

}
