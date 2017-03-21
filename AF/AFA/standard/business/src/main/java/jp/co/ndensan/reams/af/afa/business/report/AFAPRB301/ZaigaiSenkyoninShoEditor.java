package jp.co.ndensan.reams.af.afa.business.report.AFAPRB301;

import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB301.ZaigaiSenkyoninShoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoEditor implements IZaigaiSenkyoninShoEditor {

    private static final RString タイトル = new RString("在外選挙人証");

    private final ZaigaiSenkyoninShoParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link ZaigaiSenkyoninShoParam}
     */
    public ZaigaiSenkyoninShoEditor(ZaigaiSenkyoninShoParam data) {
        this.data = data;
    }

    /**
     * 在外選挙人証エディットメソッド
     *
     * @param source 在外選挙人証
     * @return 在外選挙人証
     */
    @Override
    public ZaigaiSenkyoninShoReportSource edit(ZaigaiSenkyoninShoReportSource source) {
        edit交付番号(source);
        editタイトル(source);
        edit氏名(source);
        edit生年月日(source);
        edit性別(source);
        edit登録(source);
        edit選挙名(source);
        edit住所(source);
        edit送付先(source);
        edit選挙種類(source);
        edit発行日(source);
        edit市町村名(source);
        edit委員長名(source);
        editログの出力(source);
        return source;
    }

    private void edit交付番号(ZaigaiSenkyoninShoReportSource source) {
        source.kofuNo = data.getKofuNo();
    }

    private void editタイトル(ZaigaiSenkyoninShoReportSource source) {
        source.title = タイトル;
    }

    private void edit氏名(ZaigaiSenkyoninShoReportSource source) {
        source.shimei = data.getShimei();
    }

    private void edit生年月日(ZaigaiSenkyoninShoReportSource source) {
        source.yukoKikanStart1 = data.getYukoKikanStart1();
    }

    private void edit性別(ZaigaiSenkyoninShoReportSource source) {
        source.seibetsu = data.getSeibetsu();
    }

    private void edit登録(ZaigaiSenkyoninShoReportSource source) {
        source.yukoKikanEnd = data.getYukoKikanEnd();
    }

    private void edit選挙名(ZaigaiSenkyoninShoReportSource source) {
        source.senkyoMei = data.getSenkyoMei();
    }

    private void edit住所(ZaigaiSenkyoninShoReportSource source) {
        source.jusho = data.getJusho();
    }

    private void edit送付先(ZaigaiSenkyoninShoReportSource source) {
        source.sofusaki = data.getSofusaki();
    }

    private void edit選挙種類(ZaigaiSenkyoninShoReportSource source) {
        source.shuruiTitle = data.getShuruiTitle();
    }

    private void edit発行日(ZaigaiSenkyoninShoReportSource source) {
        source.hakkoYmd = data.getHakkoYmd();
    }

    private void edit市町村名(ZaigaiSenkyoninShoReportSource source) {
        source.shichosonMei = data.getShichosonMei();
    }

    private void edit委員長名(ZaigaiSenkyoninShoReportSource source) {
        source.iinchoMei = BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体);
    }

    private void editログの出力(ZaigaiSenkyoninShoReportSource source) {
        source.識別コード = data.get在外選挙人申請情報().get申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
