package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.business.core.SaikofuTsuchiParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 再交付通知
 *
 * @reamsid_L AF-0340-020 liuj2
 */
public class SaikofuTsuchiEditor implements ISaikofuTsuchiEditor {

    private static final RString タイトル_再交付 = new RString("在外投票人再交付申請について");
    private static final RString タイトル_以外 = new RString("在外選挙人再交付申請について");

    private final SaikofuTsuchiParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link SaikofuTsuchiParam}
     */
    public SaikofuTsuchiEditor(SaikofuTsuchiParam data) {
        this.data = data;
    }

    /**
     * 再交付通知エディットメソッド
     *
     * @param source 再交付通知
     * @return 再交付通知
     */
    @Override
    public NotTorokuTsuchiRyojikanReportSource edit(NotTorokuTsuchiRyojikanReportSource source) {
        edit発行番号(source);
        edit発行年月日(source);
        edit本人氏名(source);
        edit市町村名(source);
        edit公印省略(source);
        editタイトル(source);
        edit連絡先(source);
        edit本文(source);
        edit委員長名(source);
        return source;
    }

    private void edit発行番号(NotTorokuTsuchiRyojikanReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit発行年月日(NotTorokuTsuchiRyojikanReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit本人氏名(NotTorokuTsuchiRyojikanReportSource source) {
        source.honninShimei1 = data.getHonninShimei1();
        source.honninShimei2 = data.getHonninShimei2();
    }

    private void edit市町村名(NotTorokuTsuchiRyojikanReportSource source) {
        source.tsuchiSaki1 = RString.EMPTY;
        source.tsuchiSaki2 = RString.EMPTY;
        source.tsuchiMoto1 = data.getTsuchiMoto1();
        source.tsuchiMoto2 = data.getTsuchiMoto2();
    }

    private void edit公印省略(NotTorokuTsuchiRyojikanReportSource source) {
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void editタイトル(NotTorokuTsuchiRyojikanReportSource source) {
        if (AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())) {
            source.title = タイトル_再交付;
        } else {
            source.title = タイトル_以外;
        }
    }

    private void edit連絡先(NotTorokuTsuchiRyojikanReportSource source) {
        source.renrakusakiIinkaiMei = data.getRenrakusakiIinkaiMei();
        source.renrakusakiYubinNo = data.getRenrakusakiYubinNo();
        source.renrakusakiJusho1 = data.getRenrakusakiJusho1();
        source.renrakusakiJusho2 = data.getRenrakusakiJusho2();
        source.renrakusakiTitle1 = data.getRenrakusakiTitle1();
        source.renrakusaki1 = data.getRenrakusaki1();
        source.renrakusakiTitle2 = data.getRenrakusakiTitle2();
        source.renrakusaki2 = data.getRenrakusaki2();
        source.renrakusakiTitle3 = data.getRenrakusakiTitle3();
        source.renrakusaki3 = data.getRenrakusaki3();
    }

    private void edit委員長名(NotTorokuTsuchiRyojikanReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }

    private void edit本文(NotTorokuTsuchiRyojikanReportSource source) {
        source.honbun1 = data.getHonbun1();
        source.honbun2 = data.getHonbun2();
        source.honbun3 = data.getHonbun3();
        source.honbun4 = data.getHonbun4();
        source.honbun5 = data.getHonbun5();
        source.honbun6 = data.getHonbun6();
    }
}
