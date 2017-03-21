package jp.co.ndensan.reams.af.afa.business.report.AFAPRE507;

import jp.co.ndensan.reams.af.afa.business.core.TachiaininHikitsugishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE507.TachiaininHikitsugishoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 投票立会人引継書
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoEditor implements ITachiaininHikitsugishoEditor {

    private final TachiaininHikitsugishoParam data;

    private static final RString 丸印 = new RString("○");
    private static final RString 全角スペース = new RString("　");
    private static final RString 作成 = new RString("作成");
    private int 再交付者人数 = 0;
    private int 決定書人数 = 0;
    private int 返還不在人数 = 0;
    private int 点字人数 = 0;
    private int 代理人数 = 0;
    private int 拒否人数 = 0;

    /**
     * コンストラクタです。
     *
     * @param data {@link TachiaininHikitsugishoParam}
     */
    public TachiaininHikitsugishoEditor(TachiaininHikitsugishoParam data) {
        this.data = data;
    }

    /**
     * 投票立会人引継書エディットメソッド
     *
     * @param source 投票立会人引継書
     * @return 投票立会人引継書
     */
    @Override
    public TachiaininHikitsugishoSource edit(TachiaininHikitsugishoSource source) {
        edit立会開始時刻(source);
        edit立会終了時刻(source);
        edit異常なし(source);
        edit異常あり(source);
        edit異常内容(source);
        edit再交付者人数(source);
        edit再交付氏名１列目(source);
        edit再交付氏名２列目(source);
        edit決定書人数(source);
        edit決定書氏名１列目(source);
        edit決定書氏名２列目(source);
        edit返還不在人数(source);
        edit返還不在者氏名１列目(source);
        edit返還不在者氏名２列目(source);
        edit点字人数(source);
        edit点字氏名１列目(source);
        edit点字氏名２列目(source);
        edit代理人数(source);
        edit代理氏名１列目(source);
        edit代理氏名２列目(source);
        edit拒否人数(source);
        edit拒否氏名１列目(source);
        edit拒否氏名２列目(source);
        edit投票所名(source);
        edit作成日時(source);
        return source;
    }

    private void edit立会開始時刻(TachiaininHikitsugishoSource source) {
        RString 開始時刻 = data.get立会時間_開始時刻()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分);
        source.tachiaiStartTime = 開始時刻;
    }

    private void edit立会終了時刻(TachiaininHikitsugishoSource source) {
        RString 終了時刻 = data.get立会時間_終了時刻()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分);
        source.tachiaiStopTime = 終了時刻;
    }

    private void edit異常なし(TachiaininHikitsugishoSource source) {
        source.ijoNashi = RString.EMPTY;
        if (data.is異常なし()) {
            source.ijoNashi = 丸印;
        }
    }

    private void edit異常あり(TachiaininHikitsugishoSource source) {
        source.ijoAri = RString.EMPTY;
        if (data.is異常あり()) {
            source.ijoAri = 丸印;
        }
    }

    private void edit異常内容(TachiaininHikitsugishoSource source) {
        source.ijoNaiyo = data.get異常内容();
    }

    private void edit再交付者人数(TachiaininHikitsugishoSource source) {
        if (null != data.get投票用紙再交付者情報の氏名リスト()
                && !data.get投票用紙再交付者情報の氏名リスト().isEmpty()) {
            再交付者人数 = data.get投票用紙再交付者情報の氏名リスト().size();
        }
        source.ninzuSaikofusha = doZZZ_ZZ9編集(new RString(再交付者人数));
    }

    private void edit再交付氏名１列目(TachiaininHikitsugishoSource source) {
        source.listSaikofusha_1 = data.get再交付氏名１列目();
    }

    private void edit再交付氏名２列目(TachiaininHikitsugishoSource source) {
        source.listSaikofusha_2 = data.get再交付氏名２列目();
    }

    private void edit決定書人数(TachiaininHikitsugishoSource source) {
        if (null != data.get決定書または裁決書により投票をした者情報の氏名リスト()
                && !data.get決定書または裁決書により投票をした者情報の氏名リスト().isEmpty()) {
            決定書人数 = data.get決定書または裁決書により投票をした者情報の氏名リスト().size();
        }
        source.ninzuKetteisho = doZZZ_ZZ9編集(new RString(決定書人数));
    }

    private void edit決定書氏名１列目(TachiaininHikitsugishoSource source) {
        source.listKetteisho_1 = data.get決定書氏名１列目();
    }

    private void edit決定書氏名２列目(TachiaininHikitsugishoSource source) {
        source.listKetteisho_2 = data.get決定書氏名２列目();
    }

    private void edit返還不在人数(TachiaininHikitsugishoSource source) {
        if (null != data.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト()
                && !data.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().isEmpty()) {
            返還不在人数 = data.get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト().size();
        }
        source.ninzuHenkanFuzai = doZZZ_ZZ9編集(new RString(返還不在人数));
    }

    private void edit返還不在者氏名１列目(TachiaininHikitsugishoSource source) {
        source.listHenkanFuzai_1 = data.get返還不在者氏名１列目();
    }

    private void edit返還不在者氏名２列目(TachiaininHikitsugishoSource source) {
        source.listHenkanFuzai_2 = data.get返還不在者氏名２列目();
    }

    private void edit点字人数(TachiaininHikitsugishoSource source) {
        if (null != data.get点字により投票をした者情報の氏名リスト()
                && !data.get点字により投票をした者情報の氏名リスト().isEmpty()) {
            点字人数 = data.get点字により投票をした者情報の氏名リスト().size();
        }
        source.ninzuTenji = doZZZ_ZZ9編集(new RString(点字人数));
    }

    private void edit点字氏名１列目(TachiaininHikitsugishoSource source) {
        source.listTenji_1 = data.get点字氏名１列目();
    }

    private void edit点字氏名２列目(TachiaininHikitsugishoSource source) {
        source.listTenji_2 = data.get点字氏名２列目();
    }

    private void edit代理人数(TachiaininHikitsugishoSource source) {
        if (null != data.get代理投票をした者情報の氏名リスト()
                && !data.get代理投票をした者情報の氏名リスト().isEmpty()) {
            代理人数 = data.get代理投票をした者情報の氏名リスト().size();
        }
        source.ninzuDairi = doZZZ_ZZ9編集(new RString(代理人数));
    }

    private void edit代理氏名１列目(TachiaininHikitsugishoSource source) {
        source.listDairi_1 = data.get代理氏名１列目();
    }

    private void edit代理氏名２列目(TachiaininHikitsugishoSource source) {
        source.listDairi_2 = data.get代理氏名２列目();
    }

    private void edit拒否人数(TachiaininHikitsugishoSource source) {
        if (null != data.get投票拒否の決定をした者情報の氏名リスト()
                && !data.get投票拒否の決定をした者情報の氏名リスト().isEmpty()) {
            拒否人数 = data.get投票拒否の決定をした者情報の氏名リスト().size();
        }
        source.ninzuKyohi = doZZZ_ZZ9編集(new RString(拒否人数));
    }

    private void edit拒否氏名１列目(TachiaininHikitsugishoSource source) {
        source.listKyohi_1 = data.get拒否氏名１列目();
    }

    private void edit拒否氏名２列目(TachiaininHikitsugishoSource source) {
        source.listKyohi_2 = data.get拒否氏名２列目();
    }

    private void edit投票所名(TachiaininHikitsugishoSource source) {
        source.tohyojoMei = data.get投票所名();
    }

    private void edit作成日時(TachiaininHikitsugishoSource source) {
        RString システム日付 = RDate.getNowDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();
        RString システム日時 = RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
        RString 作成日時 = システム日付.concat(全角スペース).concat(システム日時).concat(作成);
        source.sakuseiYmdTime = 作成日時;
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

    }
}
