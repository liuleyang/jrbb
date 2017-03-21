package jp.co.ndensan.reams.af.afa.business.report.AFAPRB309;

import jp.co.ndensan.reams.af.afa.business.core.ZaigaiShikakushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB309.ZaigaiShikakushaMeiboReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboEditor implements IZaigaiShikakushaMeiboEditor {

    private final ZaigaiShikakushaMeiboParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString タイトル = new RString("在外投票資格者名簿");

    /**
     * コンストラクタです。
     *
     * @param data {@link ZaigaiShikakushaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ZaigaiShikakushaMeiboEditor(ZaigaiShikakushaMeiboParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
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
    public ZaigaiShikakushaMeiboReportSource edit(ZaigaiShikakushaMeiboReportSource source) {
        editヘッダ(source);
        edit申請資格(source);
        editﾌﾘｶﾞﾅ(source);
        edit最終住所または本籍地(source);
        edit性別(source);
        edit生年月日(source);
        edit申請年月日(source);
        edit登録年月日(source);
        edit表示年月日(source);
        edit抹消年月日(source);
        edit項番(source);
        edit申請番号(source);
        edit氏名(source);
        edit経由領事官等の名称(source);
        edit交付番号(source);
        edit本籍地(source);
        edit照会日(source);
        edit回答日(source);
        edit通知日(source);
        edit交付日(source);
        edit本籍地登録(source);
        edit現住所(source);
        editログの出力(source);
        return source;
    }

    private void editヘッダ(ZaigaiShikakushaMeiboReportSource source) {
        source.title = タイトル;
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void edit申請資格(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_1 = data.get申請資格();
    }

    private void editﾌﾘｶﾞﾅ(ZaigaiShikakushaMeiboReportSource source) {
        AtenaKanaMeisho カナ氏名 = data.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseishaKanaShimei();
        source.listMeisai1_2 = null == カナ氏名 ? RString.EMPTY : カナ氏名.getColumnValue();
    }

    private void edit最終住所または本籍地(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_3 = data.get最終住所または本籍地_１();
        source.listMeisai2_4 = data.get最終住所または本籍地_２();
    }

    private void edit性別(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_4 = data.get性別();
    }

    private void edit生年月日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_5 = data.get生年月日();
    }

    private void edit申請年月日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_6 = data.get申請年月日();
    }

    private void edit登録年月日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_7 = data.get登録年月日();
    }

    private void edit表示年月日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_8 = data.get表示年月日();
    }

    private void edit抹消年月日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai1_9 = data.get抹消年月日();
    }

    private void edit項番(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai2_1 = data.get項番();
    }

    private void edit申請番号(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai2_2 = new RString(data.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseiNo());
    }

    private void edit氏名(ZaigaiShikakushaMeiboReportSource source) {
        AtenaMeisho 氏名 = data.get在外選挙異動累積情報().get在外選挙人申請情報().getShinseishaShimei();
        source.listMeisai2_3 = null == 氏名 ? RString.EMPTY : 氏名.getColumnValue();
    }

    private void edit経由領事官等の名称(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai2_5 = data.get経由領事官等の名称();
    }

    private void edit交付番号(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_1 = data.get在外選挙異動累積情報().get在外選挙資格().getKofuNo();
    }

    private void edit本籍地(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_2 = data.get本籍地();
    }

    private void edit照会日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_3 = data.get照会日();
    }

    private void edit回答日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_4 = data.get回答日();
    }

    private void edit通知日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_5 = data.get通知日();
    }

    private void edit交付日(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_6 = data.get交付日();
    }

    private void edit本籍地登録(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_7 = data.get本籍地登録();
    }

    private void edit現住所(ZaigaiShikakushaMeiboReportSource source) {
        source.listMeisai3_8 = data.get在外選挙異動累積情報().get現住所().getColumnValue();
    }

    private void editログの出力(ZaigaiShikakushaMeiboReportSource source) {
        source.識別コード = data.get在外選挙異動累積情報().get在外選挙人申請情報().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
