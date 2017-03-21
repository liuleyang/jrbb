package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 登録を行わなかった旨の通知（領事官）
 *
 * @reamsid_L AF-0320-034 lis2
 */
public class NotTorokuTsuchiRyojikanEditor implements INotTorokuTsuchiRyojikanEditor {

    private static final RString タイトル = new RString("在外選挙人名簿の登録について(通知)");

    private final NotTorokuTsuchiRyojikanParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link NotTorokuTsuchiRyojikanParam}
     */
    public NotTorokuTsuchiRyojikanEditor(NotTorokuTsuchiRyojikanParam data) {
        this.data = data;
    }

    /**
     * 登録を行わなかった旨の通知（領事官）エディットメソッド
     *
     * @param source 登録を行わなかった旨の通知（領事官）
     * @return 登録を行わなかった旨の通知（領事官）
     */
    @Override
    public NotTorokuTsuchiRyojikanReportSource edit(NotTorokuTsuchiRyojikanReportSource source) {
        edit発行番号(source);
        edit発行年月日(source);
        edit市町村名(source);
        edit公印省略(source);
        editタイトル(source);
        edit連絡先(source);
        edit本文(source);
        edit事務局名(source);
        edit郵便番号(source);
        edit委員長名(source);
        return source;
    }

    private void edit発行番号(NotTorokuTsuchiRyojikanReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit発行年月日(NotTorokuTsuchiRyojikanReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit市町村名(NotTorokuTsuchiRyojikanReportSource source) {
        source.tsuchiSaki1 = data.getTsuchiSaki1();
        source.tsuchiSaki2 = data.getTsuchiSaki2();
        source.tsuchiMoto1 = data.getTsuchiMoto1();
        source.tsuchiMoto2 = data.getTsuchiMoto2();
    }

    private void edit公印省略(NotTorokuTsuchiRyojikanReportSource source) {
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void editタイトル(NotTorokuTsuchiRyojikanReportSource source) {
        source.title = タイトル;

    }

    private void edit事務局名(NotTorokuTsuchiRyojikanReportSource source) {
        source.renrakusakiIinkaiMei = data.getRenrakusakiIinkaiMei();

    }

    private void edit郵便番号(NotTorokuTsuchiRyojikanReportSource source) {
        source.renrakusakiYubinNo = data.getRenrakusakiYubinNo();

    }

    private void edit連絡先(NotTorokuTsuchiRyojikanReportSource source) {
        source.renrakusakiJusho1 = data.getRenrakusakiJusho1();
        source.renrakusakiJusho2 = data.getRenrakusakiJusho2();
        source.renrakusakiTitle1 = data.getRenrakusakiTitle1();
        source.renrakusaki1 = data.getRenrakusaki1();
        source.renrakusakiTitle2 = data.getRenrakusakiTitle2();
        source.renrakusaki2 = data.getRenrakusaki2();
        source.renrakusakiTitle3 = data.getRenrakusakiTitle3();
        source.renrakusaki3 = data.getRenrakusaki3();
    }

    private void edit本文(NotTorokuTsuchiRyojikanReportSource source) {
        source.honbun1 = data.getHonbun1();
        source.honbun2 = data.getHonbun2();
        source.honbun3 = data.getHonbun3();
        source.honbun4 = data.getHonbun4();
        source.honbun5 = data.getHonbun5();
        source.honbun6 = data.getHonbun6();
    }

    private void edit委員長名(NotTorokuTsuchiRyojikanReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }
}
