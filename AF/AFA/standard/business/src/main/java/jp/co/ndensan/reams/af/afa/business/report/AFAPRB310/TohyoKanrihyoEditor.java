package jp.co.ndensan.reams.af.afa.business.report.AFAPRB310;

import jp.co.ndensan.reams.af.afa.business.core.TohyoKanrihyoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB310.TohyoKanrihyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoEditor implements ITohyoKanrihyoEditor {

    private final TohyoKanrihyoParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link TohyoKanrihyoParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TohyoKanrihyoEditor(TohyoKanrihyoParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 在外投票資格者名簿エディットメソッド
     *
     * @param source 在外投票資格者名簿
     * @return 在外投票資格者名簿
     */
    @Override
    public TohyoKanrihyoReportSource edit(TohyoKanrihyoReportSource source) {
        editヘッダ(source);
        edit交付番号(source);
        editカナ氏名(source);
        edit氏名(source);
        edit性別(source);
        edit経由領事官(source);
        edit資格(source);
        edit生年月日(source);
        edit登録年月日(source);
        editログの出力(source);
        return source;
    }

    private void editヘッダ(TohyoKanrihyoReportSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void edit交付番号(TohyoKanrihyoReportSource source) {
        source.listKofuNo_1 = data.get在外選挙異動累積情報().get在外選挙資格().getKofuNo();
    }

    private void editカナ氏名(TohyoKanrihyoReportSource source) {
        AtenaKanaMeisho カナ氏名 = data.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseishaKanaShimei();
        source.listKanaShimei_1 = null == カナ氏名 ? RString.EMPTY : カナ氏名.getColumnValue();
    }

    private void edit氏名(TohyoKanrihyoReportSource source) {
        AtenaMeisho 氏名 = data.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseishaShimei();
        source.listShimei1_1 = null == 氏名 ? RString.EMPTY : 氏名.getColumnValue();
    }

    private void edit性別(TohyoKanrihyoReportSource source) {
        source.listSeibetsu_1 = data.get性別();
    }

    private void edit経由領事官(TohyoKanrihyoReportSource source) {
        source.listKeiyuRyojiKan1_1 = data.get経由領事官１();
        source.listKeiyuRyojiKan2_1 = data.get経由領事官２();
    }

    private void edit資格(TohyoKanrihyoReportSource source) {
        source.listShikaku_1 = data.get資格();
    }

    private void edit生年月日(TohyoKanrihyoReportSource source) {
        FlexibleDate 生年月日 = data.get在外選挙異動累積情報().get在外選挙人申請情報().getSeinengappiYMD();
        if (null != 生年月日 && !生年月日.isEmpty()) {
            source.listSeinengappi_1 = 生年月日.wareki().toDateString();
        } else {
            source.listSeinengappi_1 = RString.EMPTY;
        }
    }

    private void edit登録年月日(TohyoKanrihyoReportSource source) {
        FlexibleDate 登録年月日 = data.get在外選挙異動累積情報().get在外選挙資格().getMeiboTorokuYMD();
        if (null != 登録年月日 && !登録年月日.isEmpty()) {
            source.listTorokuYmd_1 = 登録年月日.wareki().toDateString();
        } else {
            source.listTorokuYmd_1 = RString.EMPTY;
        }
    }

    private void editログの出力(TohyoKanrihyoReportSource source) {
        source.識別コード = data.get在外選挙異動累積情報().get在外選挙人申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
