package jp.co.ndensan.reams.af.afa.business.report.AFAPRE205;

import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.LayoutBreakItems;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoEditor implements IShisetsuSofushoEditor {

    private static final int 二倍 = 2;
    private static final int 三倍 = 3;
    private static final RString 全角スペース = new RString("　");
    private static final RString 宛名上 = new RString("atenaU1");
    private static final RString 住所 = new RString("listJusho_1");
    private static final RString 氏名 = new RString("listShimei_1");
    private static final RString 文章上 = new RString("honbun1");
    private static final RString 選挙管理委員会 = new RString("選挙管理委員会");
    private static final RString 委員長 = new RString("委員長　");
    private static final RString 交付日 = new RString("交付日：");
    private static final RString 線 = new RString("～");
    private static final RString 選挙人 = new RString("　先に請求のありました、次の選挙人の");
    private static final RString 投票用紙 = new RString("の投票用紙および不在者投票用封筒を送付します。");

    private final ShisetsuSofushoParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link ShisetsuSofushoParam}
     */
    public ShisetsuSofushoEditor(ShisetsuSofushoParam data) {
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
        edit宛名(source);
        edit発行第番号(source);
        edit日付(source);
        edit委員会名称(source);
        eidt文章(source);
        eidtページ(source);
        edit交付(source);
        edit受付番号(source);
        edit投票区コード(source);
        edit名簿番号(source);
        edit住所(source);
        edit氏名(source);
        edit性別(source);
        editアクセスログ出力(source);
        source.layoutBreakItem = LayoutBreakItems.施設送付書;
        source.shisetsuCode = data.get施設コード();
        source.senkyoNo = data.get選挙番号();
        source.gokei = data.get人数を集計();
        source.shikibetsuCode_1 = data.get識別コード().getColumnValue();
        return source;
    }

    private void eidtページ(ShisetsuSofushoSource source) {
        source.page = data.getページ();
        source.pagecnt = data.get総ページ();
    }

    private void eidt文章(ShisetsuSofushoSource source) {
        RString 文章;
        文章 = 選挙人;
        if (null != data.get施設送付書()) {
            文章 = 文章.concat(changeNullToEmpty(data.get施設送付書().get選挙名称()));
        }
        文章 = 文章.concat(投票用紙);
        if (文章.length() > getItemLength(文章上)) {
            source.honbun1 = 文章.substring(0, getItemLength(文章上));
            source.honbun2 = 文章.substring(getItemLength(文章上));
        } else {
            source.honbun1 = 文章;
        }
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

    private Boolean is文字切れ(int 文字最大数, RString 編集文字) {
        if (RString.isNullOrEmpty(編集文字)) {
            return Boolean.FALSE;
        }
        if (編集文字.length() > 文字最大数) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void edit名簿番号(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.listMeiboNo_3 = data.get施設送付書().get名簿番号();
        }
    }

    private void edit投票区コード(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.listMeiboNo_2 = data.get施設送付書().get投票区コード();
        }
    }

    private void edit受付番号(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            source.listMeiboNo_1 = new RString(data.get施設送付書().get受付番号());
        }
    }

    private void edit交付(ShisetsuSofushoSource source) {
        if (null != data.get画面情報() && null != data.get画面情報().get交付日開始() && null != data.get画面情報().get交付日終了()) {
            source.kofuTitle = 交付日;
            source.kara = 線;
            source.kofuYmdStart = data.get画面情報().get交付日開始().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.kofuYmdEnd = data.get画面情報().get交付日終了().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit委員会名称(ShisetsuSofushoSource source) {
        if (null != data.get地方公共団体情報()) {
            source.iinkaiMei = changeNullToEmpty(data.get地方公共団体情報().get市町村名()).concat(選挙管理委員会);
        }
        source.iinchoMei = 委員長.concat(BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体));
        source.koinshoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private void edit日付(ShisetsuSofushoSource source) {
        if (null != data.get画面情報() && null != data.get画面情報().get発行日()) {
            source.hakkoYmd = data.get画面情報().get発行日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit発行第番号(ShisetsuSofushoSource source) {
        if (null != data.get画面情報()) {
            source.hakkoDaino = data.get画面情報().get発行番号();
        }
    }

    private void editアクセスログ出力(ShisetsuSofushoSource source) {
        source.識別コード = data.get識別コード();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void edit宛名(ShisetsuSofushoSource source) {
        if (null != data.get施設送付書()) {
            RString 送付書_宛名敬称 = BusinessConfig.get(ConfigKeysAFA.送付書_宛名敬称, SubGyomuCode.AFA選挙本体);
            RString 敬称 = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.敬称.getCodeShubetsu(), new Code(送付書_宛名敬称));
            AtenaMeisho 施設宛名1 = data.get施設送付書().get施設宛名();
            RString 施設宛名 = changeNullToEmpty(data.get施設送付書().get施設名称())
                    .concat(全角スペース)
                    .concat(null == 施設宛名1 ? RString.EMPTY : 施設宛名1.getColumnValue());
            if (getItemLength(宛名上) >= 施設宛名.length()) {
                source.atenaD2 = 施設宛名;
                source.atenaDR2 = 敬称;
            } else if (getItemLength(宛名上) * 二倍 >= 施設宛名.length()) {
                source.atenaD1 = 施設宛名.substring(0, getItemLength(宛名上));
                source.atenaD2 = 施設宛名.substring(getItemLength(宛名上));
                source.atenaDR2 = 敬称;
            } else if (getItemLength(宛名上) * 三倍 >= 施設宛名.length()) {
                source.atenaU2 = 施設宛名.substring(0, getItemLength(宛名上));
                source.atenaD1 = 施設宛名.substring(getItemLength(宛名上), getItemLength(宛名上) * 二倍);
                source.atenaD2 = 施設宛名.substring(getItemLength(宛名上) * 二倍);
                source.atenaDR2 = 敬称;
            } else if (getItemLength(宛名上) * 三倍 < 施設宛名.length()) {
                source.atenaU1 = 施設宛名.substring(0, getItemLength(宛名上));
                source.atenaU2 = 施設宛名.substring(getItemLength(宛名上), getItemLength(宛名上) * 二倍);
                source.atenaD1 = 施設宛名.substring(getItemLength(宛名上) * 二倍, getItemLength(宛名上) * 三倍);
                source.atenaD2 = 施設宛名.substring(getItemLength(宛名上) * 三倍);
                source.atenaDR2 = 敬称;
            }
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ShisetsuSofushoSource.class, itemName);
    }

}
