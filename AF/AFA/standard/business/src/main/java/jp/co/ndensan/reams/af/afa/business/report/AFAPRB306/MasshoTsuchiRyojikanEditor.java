package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 抹消通知（領事官）
 *
 * @reamsid_L AF-0350-031 wangh
 */
public class MasshoTsuchiRyojikanEditor implements IMasshoTsuchiRyojikanEditor {

    private static final RString タイトル_選挙 = new RString("在外選挙人名簿の抹消について（通知）");
    private static final RString タイトル_投票 = new RString("在外投票人名簿の抹消について（通知）");

    private final MasshoTsuchiRyojikanParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link MasshoTsuchiRyojikanParam}
     */
    public MasshoTsuchiRyojikanEditor(MasshoTsuchiRyojikanParam data) {
        this.data = data;
    }

    /**
     * 抹消通知（領事官）エディットメソッド
     *
     * @param source 抹消通知（領事官）
     * @return 抹消通知（領事官）
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
        edit本文(source);
        edit氏名(source);
        edit生年月日(source);
        edit性別(source);
        edit委員長名(source);
        edit修正年月日(source);
        edit修正理由(source);
        edit修正前氏名(source);
        editログの出力(source);
        return source;
    }

    private void edit発行番号(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.hakkoDaino = data.getHakkoDaino();
    }

    private void edit発行年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit市町村名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.tsuchiSakiS = data.getTsuchiSakiS();
        source.tsuchiSakiL = data.getTsuchiSakiL();
        source.tsuchiMoto1 = data.getTsuchiMoto1();
        source.tsuchiMoto2 = data.getTsuchiMoto2();
    }

    private void edit公印省略(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.koinShoryaku = null == BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体)
                ? RString.EMPTY : BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void edit選挙種類(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.senkyoShurui = data.getSenkyoShurui();
    }

    private void editタイトル(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())) {
            source.title = タイトル_選挙;
        } else if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())) {
            source.title = タイトル_投票;
        }
    }

    private void edit登録年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.torokuYmd = data.getTorokuYmd();
    }

    private void edit抹消(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.masshoYmd = data.getMasshoYmd();
        source.masshoRiyu1 = data.getMasshoRiyu1();
        source.masshoRiyu2 = data.getMasshoRiyu2();
        source.masshoRiyu3 = data.getMasshoRiyu3();
        source.masshoRiyu4 = data.getMasshoRiyu4();
    }

    private void edit本文(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.honbun1 = data.getHonbun1();
        source.honbun2 = data.getHonbun2();
        source.honbun3 = data.getHonbun3();
    }

    private void edit氏名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.shimei = data.getShimei();
        source.shimei1 = data.getShimei1();
        source.shimei2 = data.getShimei2();
    }

    private void edit生年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.seinengappi = data.getSeinengappi();
    }

    private void edit性別(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.seibetsuM = data.getSeibetsuM();
        source.seibetsuF = data.getSeibetsuF();
    }

    private void edit委員長名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.iinchoMei1 = data.getIinchoMei1();
        source.iinchoMei2 = data.getIinchoMei2();
    }

    private void edit修正年月日(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.shuseiYmd = RString.EMPTY;
    }

    private void edit修正理由(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.shuseiRiyu1 = RString.EMPTY;
        source.shuseiRiyu2 = RString.EMPTY;
        source.shuseiRiyu3 = RString.EMPTY;
        source.shuseiRiyu4 = RString.EMPTY;
        source.shuseiRiyu5 = RString.EMPTY;
    }

    private void edit修正前氏名(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.shuseiMaeShimei = RString.EMPTY;
        source.shuseiMaeShimei1 = RString.EMPTY;
        source.shuseiMaeShimei2 = RString.EMPTY;
    }

    private void editログの出力(KisaijikoHenkoTsuchiRyojikanReportSource source) {
        source.識別コード = data.get在外選挙人申請情報().get申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

}
