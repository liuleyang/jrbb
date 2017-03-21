package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import jp.co.ndensan.reams.af.afa.business.core.TorokuTsuchiParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 登録した旨の通知
 *
 * @reamsid_L AF-0320-032 lis2
 */
public class TorokuTsuchiEditor implements ITorokuTsuchiEditor {

    private static final RString 氏名 = new RString("登録者氏名");
    private static final RString 年月日 = new RString("登録年月日");
    private static final RString タイトル = new RString("在外選挙人名簿の登録について（通知）");

    private final TorokuTsuchiParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link TorokuTsuchiParam}
     */
    public TorokuTsuchiEditor(TorokuTsuchiParam data) {
        this.data = data;
    }

    /**
     * 登録した旨の通知エディットメソッド
     *
     * @param source 登録した旨の通知
     * @return 登録した旨の通知
     */
    @Override
    public TorokuTsuchiReportSource edit(TorokuTsuchiReportSource source) {
        edit郵便番号(source);
        edit発行年月日(source);
        edit発行番号(source);
        edit通知先市町村(source);
        edit委員長名(source);
        edit通知元市町村名(source);
        edit公印省略(source);
        edit本文(source);
        editタイトル(source);
        edit項目タイトル(source);
        edit氏名(source);
        edit性別(source);
        edit生年月日(source);
        edit登録年月日(source);
        editログの出力(source);
        edit本籍(source);
        return source;
    }

    private void edit郵便番号(TorokuTsuchiReportSource source) {
        source.yubinNo = data.getYubinNo();
    }

    private void edit発行年月日(TorokuTsuchiReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit発行番号(TorokuTsuchiReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit通知先市町村(TorokuTsuchiReportSource source) {
        source.tsuchiSaki = data.getTsuchiSaki();
        source.tsuchiSakiL = data.getTsuchiSakiL();
    }

    private void edit委員長名(TorokuTsuchiReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }

    private void edit通知元市町村名(TorokuTsuchiReportSource source) {
        source.tsuchiMoto1 = data.getTsuchiMoto1();
        source.tsuchiMoto2 = data.getTsuchiMoto2();
    }

    private void edit公印省略(TorokuTsuchiReportSource source) {
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void edit本文(TorokuTsuchiReportSource source) {
        source.honbun1 = data.getHonbun1();
        source.honbun2 = data.getHonbun2();
    }

    private void editタイトル(TorokuTsuchiReportSource source) {
        source.title = タイトル;
    }

    private void edit項目タイトル(TorokuTsuchiReportSource source) {
        source.komokuTitleShimei = 氏名;
        source.komokuTitleYmd = 年月日;

    }

    private void edit生年月日(TorokuTsuchiReportSource source) {
        source.seinengappi = data.getSeinengappi();
    }

    private void edit氏名(TorokuTsuchiReportSource source) {
        source.shimei = data.getShimei();
        source.shimei1 = data.getShimei1();
        source.shimei2 = data.getShimei2();
        source.shimei3 = data.getShimei3();
        source.shimei4 = data.getShimei4();
    }

    private void edit性別(TorokuTsuchiReportSource source) {
        source.seibetsuF = data.getSeibetsuF();
        source.seibetsuM = data.getSeibetsuM();
    }

    private void edit本籍(TorokuTsuchiReportSource source) {
        source.honseki1 = data.getHonseki1();
        source.honseki2 = data.getHonseki2();
        source.honseki3 = data.getHonseki3();
        source.honseki4 = data.getHonseki4();
    }

    private void edit登録年月日(TorokuTsuchiReportSource source) {
        source.torokuYmd = data.getTorokuYmd();
    }

    private void editログの出力(TorokuTsuchiReportSource source) {
        source.識別コード = data.get在外選挙人申請情報().get申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

}
