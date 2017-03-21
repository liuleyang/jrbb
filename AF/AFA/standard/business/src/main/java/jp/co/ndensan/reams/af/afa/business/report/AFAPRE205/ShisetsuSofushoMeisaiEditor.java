package jp.co.ndensan.reams.af.afa.business.report.AFAPRE205;

import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.LayoutBreakItems;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoMeisaiEditor implements IShisetsuSofushoEditor {

    private final ShisetsuSofushoParam data;

    private static final RString 住所 = new RString("listJusho_1");
    private static final RString 氏名 = new RString("listShimei_1");

    /**
     * コンストラクタです。
     *
     * @param data {@link ShisetsuSofushoParam}
     */
    public ShisetsuSofushoMeisaiEditor(ShisetsuSofushoParam data) {
        this.data = data;
    }

    /**
     * 施設送付書エディットメソッド
     *
     * @param source 施設送付書
     * @return 施設送付書
     */
    @Override
    public ShisetsuSofushoSource edit(ShisetsuSofushoSource source) {
        edit交付施設名称(source);
        edit選挙名称(source);
        edit日付(source);
        edit受付番号(source);
        edit投票区コード(source);
        edit名簿番号(source);
        editページ(source);
        edit住所(source);
        edit氏名(source);
        edit性別(source);
        editアクセスログ出力(source);
        source.layoutBreakItem = LayoutBreakItems.施設送付書明細;
        source.shisetsuCode = data.get施設コード();
        source.senkyoNo = data.get選挙番号();
        return source;
    }

    private void editページ(ShisetsuSofushoSource source) {
        source.page = data.getページ();
        source.pagecnt = data.get総ページ();
    }

    private void edit氏名(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            if (is文字切れ(getItemLength(氏名), data.get施設送付書().get名称())) {
                source.listShimei_1 = data.get施設送付書().get名称().substring(0, getItemLength(氏名));
            } else {
                source.listShimei_1 = data.get施設送付書().get名称();
            }
        }
        source.shimei = data.get施設送付書().get名称();
    }

    private void edit性別(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            if (FEMALE.getCode().equals(data.get施設送付書().get性別コード())) {
                source.listSeibetsu_1 = FEMALE.getName().getShortJapanese();
            }
            if (MALE.getCode().equals(data.get施設送付書().get性別コード())) {
                source.listSeibetsu_1 = MALE.getName().getShortJapanese();
            }
        }
    }

    private void edit住所(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            if (is文字切れ(getItemLength(住所), data.get施設送付書().get住所())) {
                source.listJusho_1 = data.get施設送付書().get住所().substring(0, getItemLength(住所));
            } else {
                source.listJusho_1 = data.get施設送付書().get住所();
            }
        }
        source.jusho = data.get施設送付書().get住所();
    }

    private void edit投票区コード(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.listMeiboNo_2 = data.get施設送付書().get投票区コード();
        }
    }

    private void edit名簿番号(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.listMeiboNo_3 = data.get施設送付書().get名簿番号();
        }
    }

    private void edit受付番号(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.listMeiboNo_1 = new RString(data.get施設送付書().get受付番号());
        }
    }

    private void edit交付施設名称(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.atenaD2 = data.get施設送付書().get施設名称();
        }
    }

    private void edit選挙名称(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.senkyoMei = data.get施設送付書().get選挙名称();
        }
    }

    private void edit日付(ShisetsuSofushoSource source) {
        if (null != data.get画面情報() && null != data.get画面情報().get発行日()) {
            source.hakkoYmd = data.get画面情報().get発行日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private Boolean is文字切れ(int 文字最大数, RString 編集文字) {
        if (RString.isNullOrEmpty(編集文字)) {
            return Boolean.FALSE;
        }
        if (編集文字.length() > 文字最大数) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void editアクセスログ出力(ShisetsuSofushoSource source) {
        source.識別コード = data.get識別コード();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ShisetsuSofushoSource.class, itemName);
    }
}
