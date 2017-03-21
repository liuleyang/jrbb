package jp.co.ndensan.reams.af.afa.business.report.AFAPRB304;

import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB304.NotTorokuTsuchiHonninReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninEditor implements INotTorokuTsuchiHonninEditor {

    private final NotTorokuTsuchiHonninParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link NotTorokuTsuchiHonninParam}
     */
    public NotTorokuTsuchiHonninEditor(NotTorokuTsuchiHonninParam data) {
        this.data = data;
    }

    /**
     * 登録を行わなかった旨の通知（本人）エディットメソッド
     *
     * @param source 登録を行わなかった旨の通知（本人）
     * @return 登録を行わなかった旨の通知（本人）
     */
    @Override
    public NotTorokuTsuchiHonninReportSource edit(NotTorokuTsuchiHonninReportSource source) {
        edit本人氏名(source);
        edit発行番号(source);
        edit発行年月日(source);
        edit通知元市町村名(source);
        edit公印省略(source);
        edit選挙種類(source);
        edit本文(source);
        edit氏名(source);
        edit委員長名(source);
        edit領事官(source);
        edit理由(source);
        return source;
    }

    private void edit本人氏名(NotTorokuTsuchiHonninReportSource source) {
        source.honninShimei1 = data.getHonninShimei1();
        source.honninShimei2 = data.getHonninShimei2();
    }

    private void edit発行番号(NotTorokuTsuchiHonninReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit発行年月日(NotTorokuTsuchiHonninReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit通知元市町村名(NotTorokuTsuchiHonninReportSource source) {
        source.tsuchiMoto1 = data.getTsuchiMoto1();
        source.tsuchiMoto2 = data.getTsuchiMoto2();
    }

    private void edit公印省略(NotTorokuTsuchiHonninReportSource source) {
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void edit選挙種類(NotTorokuTsuchiHonninReportSource source) {
        source.senkyoShurui = data.getSenkyoShurui();
    }

    private void edit本文(NotTorokuTsuchiHonninReportSource source) {
        source.honbun1 = data.getHonbun1();
        source.honbun2 = data.getHonbun2();
        source.honbun3 = data.getHonbun3();
    }

    private void edit氏名(NotTorokuTsuchiHonninReportSource source) {
        source.shimei = data.getShimei();
        source.shimei1 = data.getShimei1();
        source.shimei2 = data.getShimei2();
    }

    private void edit委員長名(NotTorokuTsuchiHonninReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }

    private void edit領事官(NotTorokuTsuchiHonninReportSource source) {
        source.ryojikan = data.getRyojikan();
        source.ryojikan1 = data.getRyojikan1();
        source.ryojikan2 = data.getRyojikan2();
    }

    private void edit理由(NotTorokuTsuchiHonninReportSource source) {
        source.riyu1 = data.getRiyu1();
        source.riyu2 = data.getRiyu2();
        source.riyu3 = data.getRiyu3();
        source.riyu4 = data.getRiyu4();
        source.riyu5 = data.getRiyu5();
        source.riyu6 = data.getRiyu6();
        source.riyu7 = data.getRiyu7();
        source.riyu8 = data.getRiyu8();
        source.riyu9 = data.getRiyu9();
    }
}
