package jp.co.ndensan.reams.af.afa.business.report.AFAPRB214;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenTestPrintDataListParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214.NyujokenTestPrintDataListSource;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListEditor implements INyujokenTestPrintDataListEditor {

    private static final RString 連結標識 = new RString("-");
    private static final RString 基準日 = new RString("（基準日：");
    private static final RString 投票日 = new RString("　投票日：");
    private static final RString 右括弧 = new RString(")");
    private static final RString 入場券 = new RString("入場券");
    private static final RString 作成 = new RString("作成");
    private static final RString 全角スペース = new RString("　");
    private static final int 長さ_氏名１ = getItemLength(new RString("listMeisai1_3"));
    private static final int 長さ_氏名２ = getItemLength(new RString("listMeisai2_3"));
    private static final int 長さ_抽出条件該当項目１ = getItemLength(new RString("listMeisai1_4"));
    private static final int 長さ_抽出条件該当項目２ = getItemLength(new RString("listMeisai2_4"));
    private static final RString テストデータ抽出一覧表 = new RString("テストデータ抽出一覧表");
    private final NyujokenTestPrintDataListParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link NyujokenTestPrintDataListParam}
     */
    public NyujokenTestPrintDataListEditor(NyujokenTestPrintDataListParam data) {
        this.data = data;
    }

    /**
     * 入場券テストデータ抽出一覧表
     *
     * @param source 入場券テストデータ抽出一覧表
     * @return 入場券テストデータ抽出一覧表
     */
    @Override
    public NyujokenTestPrintDataListSource edit(NyujokenTestPrintDataListSource source) {
        source.listMeisai2_1 = RString.EMPTY;
        edit作成日時(source);
        edit市町村コード(source);
        edit市町村名(source);
        edit名簿番号タイトル(source);
        edit抽出条件(source);
        edit作成条件(source);
        edit識別コード(source);
        edit名簿番号(source);
        editサブタイトルと帳票タイトル(source);
        edit氏名(source);
        edit抽出条件該当項目(source);
        editページ(source);
        editアクセスロ(source);
        return source;
    }

    private void edit作成日時(NyujokenTestPrintDataListSource source) {
        source.sakuseiYmdTime = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(全角スペース)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分)).concat(作成);
    }

    private void edit市町村コード(NyujokenTestPrintDataListSource source) {
        if (null != data.get帳票共通ヘッダー()) {
            source.shichosonCode = data.get帳票共通ヘッダー().get市町村コード();
        }
    }

    private void edit市町村名(NyujokenTestPrintDataListSource source) {
        if (null != data.get帳票共通ヘッダー()) {
            source.shichosonMei = data.get帳票共通ヘッダー().get市町村名();
        }
    }

    private void editサブタイトルと帳票タイトル(NyujokenTestPrintDataListSource source) {
        source.subTitle = 入場券;
        source.title = テストデータ抽出一覧表;
    }

    private void edit名簿番号タイトル(NyujokenTestPrintDataListSource source) {
        source.meiboBangoMei = BusinessConfig.get(ConfigKeysAFA.テスト抽出一覧_名簿番号タイトル, SubGyomuCode.AFA選挙本体);

    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private void edit抽出条件(NyujokenTestPrintDataListSource source) {
        if (data.getテストデータの情報() != null) {
            source.listMeisai1_1 = changeNullToEmpty(data.getテストデータの情報().get抽出条件());
        }

    }

    private void edit抽出条件該当項目(NyujokenTestPrintDataListSource source) {
        if (null != data.getテストデータの情報() && null != data.getテストデータの情報().get該当項目()) {
            if (data.getテストデータの情報().get該当項目().length() > (長さ_抽出条件該当項目１ + 長さ_抽出条件該当項目２)) {
                source.listMeisai1_4 = data.getテストデータの情報().get該当項目().substring(0, 長さ_抽出条件該当項目１);
                source.listMeisai2_4 = data.getテストデータの情報().get該当項目().substring(長さ_抽出条件該当項目１, (長さ_抽出条件該当項目１ + 長さ_抽出条件該当項目２));
            } else if (data.getテストデータの情報().get該当項目().length() > 長さ_抽出条件該当項目１) {
                source.listMeisai1_4 = data.getテストデータの情報().get該当項目().substring(0, 長さ_抽出条件該当項目１);
                source.listMeisai2_4 = data.getテストデータの情報().get該当項目().substring(長さ_抽出条件該当項目１);
            } else {
                source.listMeisai1_4 = data.getテストデータの情報().get該当項目();
                source.listMeisai2_4 = RString.EMPTY;
            }
        }
    }

    private void edit作成条件(NyujokenTestPrintDataListSource source) {
        if (null != data.getテストデータの情報()) {
            source.selHani = changeNullToEmpty(data.getテストデータの情報().get選挙種類()).concat(基準日)
                    .concat(null == data.getテストデータの情報().get名簿基準年月日()
                            ? RString.EMPTY : data.getテストデータの情報().get名簿基準年月日().wareki().toDateString()).concat(投票日)
                    .concat(null == data.getテストデータの情報().get投票年月日()
                            ? RString.EMPTY : data.getテストデータの情報().get投票年月日().wareki().toDateString()).concat(右括弧);
        }
    }

    private void edit氏名(NyujokenTestPrintDataListSource source) {
        if (null != data.getテストデータの情報() && null != data.getテストデータの情報().get氏名()) {
            if (data.getテストデータの情報().get氏名().length() > (長さ_氏名１ + 長さ_氏名２)) {
                source.listMeisai1_3 = data.getテストデータの情報().get氏名().substring(0, 長さ_氏名１);
                source.listMeisai2_3 = data.getテストデータの情報().get氏名().substring(長さ_氏名１, (長さ_氏名１ + 長さ_氏名２));
            } else if (data.getテストデータの情報().get氏名().length() > 長さ_氏名１) {
                source.listMeisai1_3 = data.getテストデータの情報().get氏名().substring(0, 長さ_氏名１);
                source.listMeisai2_3 = data.getテストデータの情報().get氏名().substring(長さ_氏名１);
            } else {
                source.listMeisai1_3 = data.getテストデータの情報().get氏名();
                source.listMeisai2_3 = RString.EMPTY;
            }
        }
    }

    private void edit識別コード(NyujokenTestPrintDataListSource source) {
        if (null != data.getテストデータの情報()) {
            source.listMeisai2_2 = changeNullToEmpty(data.getテストデータの情報().get識別コード());
        }
    }

    private void edit名簿番号(NyujokenTestPrintDataListSource source) {
        if (null != data.getテストデータの情報()) {
            source.listMeisai1_2 = data.getテストデータの情報().get名簿番号();
        }
    }

    private void editページ(NyujokenTestPrintDataListSource source) {
        source.pageCount = data.get頁();
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NyujokenTestPrintDataListSource.class, itemName);
    }

    private void editアクセスロ(NyujokenTestPrintDataListSource source) {
        if (null != data.getテストデータの情報()) {
            source.識別コード = new ShikibetsuCode(data.getテストデータの情報().get識別コード());
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
