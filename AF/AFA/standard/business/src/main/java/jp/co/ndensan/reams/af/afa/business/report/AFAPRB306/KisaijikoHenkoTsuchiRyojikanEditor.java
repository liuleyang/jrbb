package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 記載事項変更通知（領事官）
 *
 * @reamsid_L AF-0330-031 zhangl
 */
public class KisaijikoHenkoTsuchiRyojikanEditor implements IKisaijikoHenkoTsuchiRyojikanEditor {

    private static final RString タイトル = new RString("在外選挙人名簿の抹消（記載事項変更）について（通知）");

    private final KisaijikoHenkoTsuchiRyojikanParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link KisaijikoHenkoTsuchiRyojikanParam}
     */
    public KisaijikoHenkoTsuchiRyojikanEditor(KisaijikoHenkoTsuchiRyojikanParam data) {
        this.data = data;
    }

    /**
     * 記載事項変更通知（領事官）エディットメソッド
     *
     * @param source 記載事項変更通知（領事官）
     * @return 記載事項変更通知（領事官）
     */
    @Override
    public KisaijikoHenkoTsuchiRyojikanReportSource edit(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        edit発行番号(source);
        edit発行年月日(source);
        edit市町村名(source);
        edit公印省略(source);
        edit選挙種類(source);
        editタイトル(source);
        edit登録年月日(source);
        edit抹消(source);
        edit修正(source);
        edit本文(source);
        edit氏名(source);
        edit生年月日(source);
        editログの出力(source);
        edit性別(source);
        edit委員長名(source);
        return source;
    }

    private void edit発行年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit発行番号(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit公印省略(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void edit市町村名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.tsuchiSakiS = data.getTsuchiSakiS();
        source.tsuchiSakiL = data.getTsuchiSakiL();
        source.tsuchiMoto1 = data.getTsuchiMoto1();
        source.tsuchiMoto2 = data.getTsuchiMoto2();
    }

    private void edit選挙種類(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.senkyoShurui = data.getSenkyoShurui();
    }

    private void editタイトル(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.title = タイトル;
    }

    private void edit登録年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.torokuYmd = data.getTorokuYmd();
    }

    private void edit抹消(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.masshoYmd = RString.EMPTY;
        source.masshoRiyu1 = RString.EMPTY;
        source.masshoRiyu2 = RString.EMPTY;
        source.masshoRiyu3 = RString.EMPTY;
        source.masshoRiyu4 = RString.EMPTY;
    }

    private void edit修正(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.shuseiYmd = data.getShuseiYmd();
        source.shuseiRiyu1 = data.getShuseiRiyu1();
        source.shuseiRiyu2 = data.getShuseiRiyu2();
        source.shuseiRiyu3 = data.getShuseiRiyu3();
        source.shuseiRiyu4 = data.getShuseiRiyu4();
        source.shuseiRiyu5 = data.getShuseiRiyu5();
        source.shuseiMaeShimei = data.getShuseiMaeShimei();
        source.shuseiMaeShimei1 = data.getShuseiMaeShimei1();
        source.shuseiMaeShimei2 = data.getShuseiMaeShimei2();
    }

    private void edit本文(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.honbun1 = data.getHonbun1();
        source.honbun2 = data.getHonbun2();
        source.honbun3 = data.getHonbun3();
    }

    private void edit生年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.seinengappi = data.getSeinengappi();
    }

    private void edit氏名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.shimei = data.getShimei();
        source.shimei1 = data.getShimei1();
        source.shimei2 = data.getShimei2();
    }

    private void edit性別(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.seibetsuM = data.getSeibetsuM();
        source.seibetsuF = data.getSeibetsuF();
    }

    private void editログの出力(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.識別コード = data.get在外選挙人申請情報().get申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void edit委員長名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }

}
