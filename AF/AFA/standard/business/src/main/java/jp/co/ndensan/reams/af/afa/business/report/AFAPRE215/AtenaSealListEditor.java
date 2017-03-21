package jp.co.ndensan.reams.af.afa.business.report.AFAPRE215;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealListParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215.AtenaSealListSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListEditor implements IAtenaSealListEditor {

    private static final RString 全角スペース = new RString("　");
    private static final RString 作成 = new RString("作成");
    private static final RString 線 = new RString("～");
    private static final RString なし = new RString("なし");
    private static final RString すべて = new RString("すべて");
    private static final RString 施設コード = new RString("施設コード");
    private static final RString 施設種別 = new RString("施設種別");
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 世帯コード = new RString("世帯コード");
    private static final RString 住所コード = new RString("住所コード");
    private static final RString 行政区コード = new RString("行政区コード");
    private static final RString コード = new RString("コード");
    private static final RString 通し番号 = new RString("通し番号");
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区名 = new RString("行政区名");
    private static final RString 日付 = new RString("日付");
    private static final RString 投票区コード = new RString("投票区コード");
    private static final RString 名簿番号 = new RString("名簿番号");
    private static final RString 印号 = new RString("〒");
    private static final RString 横線 = new RString("-");
    private static final RString 選挙人宛名シール = new RString("選挙人宛名シール出力一覧表");
    private static final RString 選挙人画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール = new RString("転出者宛名シール出力一覧表");
    private static final RString 転出者画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール = new RString("施設宛名シール出力一覧表");
    private static final RString 宛名シール出力一覧表 = new RString("宛名シール出力一覧表");
    private static final RString 施設宛名画面ID = new RString("AFAGME6030");
    private static final RString 氏名 = new RString("氏名");
    private static final RString 施設名称 = new RString("施設名称");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 性別 = new RString("性別");
    private static final RString 区分 = new RString("区分");
    private static final RString 転出先住所 = new RString("転出先住所");
    private static final RString 消除年月日 = new RString("消除年月日");
    private static final RString 施設宛名 = new RString("施設宛名");
    private static final RString 電話番号 = new RString("電話番号");
    private static final RString 明細1 = new RString("listMeisho1_1");
    private static final RString 明細2 = new RString("listMeisho2_1");
    private static final RString 明細5 = new RString("listJusho1_2");
    private static final RString 有権者 = new RString("1");
    private static final RString 表示者 = new RString("2");
    private static final RString ZONE = new RString("01");
    private static final RString ZTWO = new RString("02");
    private static final RString ZTHREE = new RString("03");
    private static final RString ZFOUR = new RString("04");
    private static final RString ZFIVE = new RString("05");
    private static final RString ZSIX = new RString("06");
    private static final RString ZSEVEN = new RString("07");
    private static final RString ZEIGHT = new RString("08");
    private static final RString ZNINE = new RString("09");
    private static final RString ZTEN = new RString("10");
    private static final RString ELEVEN = new RString("11");
    private static final RString TWELVE = new RString("12");
    private static final RString THIRTEEN = new RString("13");
    private static final RString FOURTEEN = new RString("14");
    private static final RString FIVETEEN = new RString("15");
    private static final RString SIXTEEN = new RString("16");

    private final AtenaSealListParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link AtenaSealListParam}
     */
    public AtenaSealListEditor(AtenaSealListParam data) {
        this.data = data;
    }

    /**
     * 宛名シール出力対象者一覧エディットメソッド
     *
     * @param source 宛名シール出力対象者一覧
     * @return 宛名シール出力対象者一覧
     */
    @Override
    public AtenaSealListSource edit(AtenaSealListSource source) {
        editタイトル(source);
        edit市町村コード(source);
        edit市町村名(source);
        edit作成日時(source);
        edit選挙名称(source);
        edit抽出条件(source);
        edit明細タイトル(source);
        edit明細1(source);
        edit明細2(source);
        edit明細3_4(source);
        edit明細5(source);
        edit明細6_7(source);
        edit作成日時(source);
        editログ出力(source);
        return source;
    }

    private void editログ出力(AtenaSealListSource source) {
        if (!施設宛名画面ID.equals(data.get画面ID())) {
            if (null != data.get投票資格情報()) {
                source.識別コード = data.get投票資格情報().get識別コード();
            }
            source.個人番号使用 = KojinNo.EMPTY;
            source.法人番号使用 = HojinNo.EMPTY;
        }
    }

    private void edit明細6_7(AtenaSealListSource source) {
        if ((選挙人画面ID.equals(data.get画面ID()) || 有権者.equals(data.get出力対象()))
                && null != data.get画面情報()) {
            RString 任意項目1;
            RString 任意項目2;
            任意項目1 = edit任意項目コード(data.get画面情報().get右上項目コード());
            任意項目2 = edit任意項目コード(data.get画面情報().get右下項目コード());
            source.meisaiTitle6 = 任意項目1;
            source.listBiko_1 = edit任意項目(data.get画面情報().get右上項目コード(), source);
            source.listBiko_2 = edit任意項目(data.get画面情報().get右下項目コード(), source);
            if (null != 任意項目1 && null == 任意項目2) {
                source.listBiko_2 = edit任意項目(data.get画面情報().get左下項目コード(), source);
            } else if (null != 任意項目2) {
                任意項目1 = edit任意項目コード(data.get画面情報().get右下項目コード());
                source.meisaiTitle6 = 任意項目1;
                source.listBiko_1 = edit任意項目(data.get画面情報().get右下項目コード(), source);
                source.listBiko_2 = edit任意項目(data.get画面情報().get左下項目コード(), source);
            } else {
                任意項目1 = edit任意項目コード(data.get画面情報().get左下項目コード());
                source.meisaiTitle6 = 任意項目1;
                source.listBiko_1 = edit任意項目(data.get画面情報().get左下項目コード(), source);
                source.listBiko_2 = RString.EMPTY;
            }

        } else if (転出者画面ID.equals(data.get画面ID()) && null != data.get画面情報()) {
            if (data.get投票資格情報() != null
                    && data.get投票資格情報().get消除異動年月日() != null
                    && data.get投票資格情報().get消除異動年月日().isWareki()) {
                source.listBiko_1 = data.get投票資格情報().get消除異動年月日().wareki().toDateString();
            }
            RString 設定内容 = edit設定内容(data.get画面情報().get右上項目コード());
            if (設定内容.isEmpty()) {
                設定内容 = edit設定内容(data.get画面情報().get右下項目コード());
            }
            if (設定内容.isEmpty()) {
                設定内容 = edit設定内容(data.get画面情報().get左下項目コード());
            }
            source.listBiko_2 = 設定内容;
        } else if (施設宛名画面ID.equals(data.get画面ID()) && null != data.get画面情報()) {
            source.listBiko_1 = data.get投票資格情報().get施設情報_電話番号();
            source.listBiko_2 = RString.EMPTY;
        } else {
            source.listBiko_1 = RString.EMPTY;
            source.listBiko_2 = RString.EMPTY;
        }
    }

    private RString edit設定内容(RString 項目コード) {
        RString 設定内容 = RString.EMPTY;
        if (ZONE.equals(項目コード) && null != data.get投票資格情報()) {
            設定内容 = null == data.get投票資格情報().get識別コード() ? RString.EMPTY : data.get投票資格情報().get識別コード().getColumnValue();
        } else if (ZEIGHT.equals(項目コード) && null != data.get投票資格情報()) {
            設定内容 = data.get投票資格情報().get通し番号();
        } else if (FOURTEEN.equals(項目コード)) {
            設定内容 = RDate.getNowDate().wareki().toDateString();
        } else if (SIXTEEN.equals(項目コード) && null != data.get投票資格情報()) {
            設定内容 = changeNullToEmpty(data.get投票資格情報().get投票区コード()).concat(changeNullToEmpty(data.get投票資格情報().get頁()))
                    .concat(changeNullToEmpty(data.get投票資格情報().get行()));
        }
        return 設定内容;
    }

    private RString edit任意項目(RString 四隅項目コード, AtenaSealListSource source) {
        RString 出力 = RString.EMPTY;
        if (null != data.get投票資格情報()) {
            if (ZONE.equals(四隅項目コード)) {
                出力 = null == data.get投票資格情報().get識別コード() ? RString.EMPTY : data.get投票資格情報().get識別コード().getColumnValue();
            } else if (ZTWO.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get世帯コード();
            } else if (ZTHREE.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get住登内町域コード();
            } else if (ZFOUR.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get行政区コード();
            } else if (ZFIVE.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get地区コード１();
            } else if (ZSIX.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get地区コード２();
            } else if (ZSEVEN.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get地区コード３();
            } else if (ZEIGHT.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get通し番号();
            } else if (ZNINE.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get住登内住所();
                source.jusho = data.get投票資格情報().get住登内住所();
            } else if (ZTEN.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get行政区名();
                source.gyoseikumei = data.get投票資格情報().get行政区名();
            } else if (ELEVEN.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get地区名１();
                source.chiku1 = data.get投票資格情報().get地区名１();
            } else if (TWELVE.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get地区名２();
                source.chiku2 = data.get投票資格情報().get地区名２();
            } else if (THIRTEEN.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get地区名３();
                source.chiku3 = data.get投票資格情報().get地区名３();
            } else if (FOURTEEN.equals(四隅項目コード)) {
                出力 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            } else if (FIVETEEN.equals(四隅項目コード)) {
                出力 = data.get投票資格情報().get投票区コード();
            } else if (SIXTEEN.equals(四隅項目コード)) {
                出力 = changeNullToEmpty(data.get投票資格情報().get投票区コード()).concat(changeNullToEmpty(data.get投票資格情報().get頁()))
                        .concat(changeNullToEmpty(data.get投票資格情報().get行()));
            }
        }
        return 出力;
    }

    private RString edit任意項目コード(RString 四隅項目コード) {
        RString 出力 = RString.EMPTY;
        if (ZONE.equals(四隅項目コード)) {
            出力 = 識別コード;
        } else if (ZTWO.equals(四隅項目コード)) {
            出力 = 世帯コード;
        } else if (ZTHREE.equals(四隅項目コード)) {
            出力 = 住所コード;
        } else if (ZFOUR.equals(四隅項目コード)) {
            出力 = 行政区コード;
        } else if (ZFIVE.equals(四隅項目コード)) {
            出力 = changeNullToEmpty(data.get投票資格情報().get地区名１()).concat(コード);
        } else if (ZSIX.equals(四隅項目コード)) {
            出力 = changeNullToEmpty(data.get投票資格情報().get地区名２()).concat(コード);
        } else if (ZSEVEN.equals(四隅項目コード)) {
            出力 = changeNullToEmpty(data.get投票資格情報().get地区名３()).concat(コード);
        } else if (ZEIGHT.equals(四隅項目コード)) {
            出力 = 通し番号;
        } else if (ZNINE.equals(四隅項目コード)) {
            出力 = 住所;
        } else if (ZTEN.equals(四隅項目コード)) {
            出力 = 行政区名;
        } else if (ELEVEN.equals(四隅項目コード)) {
            出力 = data.get投票資格情報().get地区名１();
        } else if (TWELVE.equals(四隅項目コード)) {
            出力 = data.get投票資格情報().get地区名２();
        } else if (THIRTEEN.equals(四隅項目コード)) {
            出力 = data.get投票資格情報().get地区名３();
        } else if (FOURTEEN.equals(四隅項目コード)) {
            出力 = 日付;
        } else if (FIVETEEN.equals(四隅項目コード)) {
            出力 = 投票区コード;
        } else if (SIXTEEN.equals(四隅項目コード)) {
            出力 = 名簿番号;
        }
        return 出力;
    }

    private void edit明細5(AtenaSealListSource source) {
        if (選挙人画面ID.equals(data.get画面ID()) && null != data.get投票資格情報()) {
            source.listJusho1_1 = 印号.concat(changeNullToEmpty(data.get投票資格情報().get住登内郵便番号()));
            RString 住所 = changeNullToEmpty(data.get投票資格情報().get住登内住所()).concat(changeNullToEmpty(data.get投票資格情報().get住登内番地()))
                    .concat(全角スペース).concat(changeNullToEmpty(data.get投票資格情報().get住登内方書()));
            if (getItemLength(明細5) < 住所.length()) {
                source.listJusho1_2 = 住所.substring(0, getItemLength(明細5));
                source.listJusho2_1 = 住所.substring(getItemLength(明細5));
            } else {
                source.listJusho1_2 = 住所;
                source.listJusho2_1 = RString.EMPTY;
            }
        } else if (転出者画面ID.equals(data.get画面ID()) && null != data.get投票資格情報()) {
            source.listJusho1_1 = 印号.concat(changeNullToEmpty(data.get投票資格情報().get郵便番号()));
            RString 住所 = changeNullToEmpty(data.get投票資格情報().get住所()).concat(changeNullToEmpty(data.get投票資格情報().get番地()))
                    .concat(全角スペース).concat(changeNullToEmpty(data.get投票資格情報().get方書()));
            if (getItemLength(明細5) < 住所.length()) {
                source.listJusho1_2 = 住所.substring(0, getItemLength(明細5));
                source.listJusho2_1 = 住所.substring(getItemLength(明細5));
            } else {
                source.listJusho1_2 = 住所;
                source.listJusho2_1 = RString.EMPTY;
            }
        } else if (施設宛名画面ID.equals(data.get画面ID()) && null != data.get投票資格情報()) {
            source.listJusho1_1 = 印号.concat(changeNullToEmpty(data.get投票資格情報().get施設情報郵便番号()));
            RString 住所 = changeNullToEmpty(data.get投票資格情報().get施設情報郵便番号());
            if (getItemLength(明細5) < 住所.length()) {
                source.listJusho1_2 = 住所.substring(0, getItemLength(明細5));
                source.listJusho2_1 = 住所.substring(getItemLength(明細5));
            } else {
                source.listJusho1_2 = 住所;
                source.listJusho2_1 = RString.EMPTY;
            }
        } else if (null != data.get投票資格情報()) {
            source.listJusho1_1 = 印号.concat(changeNullToEmpty(data.get投票資格情報().get帳票出力た郵便番号()));
            RString 住所 = changeNullToEmpty(data.get投票資格情報().get帳票出力た住所());
            if (getItemLength(明細5) < 住所.length()) {
                source.listJusho1_2 = 住所.substring(0, getItemLength(明細5));
                source.listJusho2_1 = 住所.substring(getItemLength(明細5));
            } else {
                source.listJusho1_2 = 住所;
                source.listJusho2_1 = RString.EMPTY;
            }
        }
    }

    private void edit明細1(AtenaSealListSource source) {
        if (施設宛名画面ID.equals(data.get画面ID())
                && null != data.get投票資格情報()
                && null != data.get投票資格情報().get施設名称()) {
            if (getItemLength(明細1) < data.get投票資格情報().get施設名称().length()) {
                source.listMeisho1_1 = data.get投票資格情報().get施設名称().substring(0, getItemLength(明細1));
                source.listMeisho2_1 = data.get投票資格情報().get施設名称().substring(getItemLength(明細1));
            } else {
                source.listMeisho1_1 = data.get投票資格情報().get施設名称();
                source.listMeisho2_1 = RString.EMPTY;
            }
        } else if (null != data.get投票資格情報()
                && null != data.get投票資格情報().get名称()) {
            if (getItemLength(明細1) < data.get投票資格情報().get名称().length()) {
                source.listMeisho1_1 = data.get投票資格情報().get名称().substring(0, getItemLength(明細1));
                source.listMeisho2_1 = data.get投票資格情報().get名称().substring(getItemLength(明細1));
            } else {
                source.listMeisho1_1 = data.get投票資格情報().get名称();
                source.listMeisho2_1 = RString.EMPTY;
            }
        }
    }

    private void edit明細3_4(AtenaSealListSource source) {
        if (施設宛名画面ID.equals(data.get画面ID()) && null != data.get投票資格情報()) {
            source.listMeisai_1 = data.get投票資格情報().get施設コード();
            source.listMeisai_2 = data.get投票資格情報().get施設種別();
        } else if (null != data.get投票資格情報()) {
            if (null != data.get投票資格情報().get生年月日()) {
                source.listMeisai_1 = data.get投票資格情報().get生年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (FEMALE.getCode().equals(data.get投票資格情報().get性別コード())) {
                source.listMeisai_2 = FEMALE.getName().getShortJapanese();
            } else if (MALE.getCode().equals(data.get投票資格情報().get性別コード())) {
                source.listMeisai_2 = MALE.getName().getShortJapanese();
            }
        }
    }

    private void edit明細2(AtenaSealListSource source) {
        if (施設宛名画面ID.equals(data.get画面ID()) && null != data.get投票資格情報()) {
            if (getItemLength(明細2) < data.get投票資格情報().get施設宛名().length()) {
                source.listMeisho1_2 = data.get投票資格情報().get施設宛名().substring(0, getItemLength(明細2));
                source.listMeisho2_2 = data.get投票資格情報().get施設宛名().substring(getItemLength(明細2));
            } else {
                source.listMeisho1_2 = data.get投票資格情報().get施設宛名();
                source.listMeisho2_2 = RString.EMPTY;
            }
        } else if (null != data.get投票資格情報()) {
            source.listMeisho1_2 = changeNullToEmpty(data.get投票資格情報().get投票区コード()).concat(横線)
                    .concat(changeNullToEmpty(data.get投票資格情報().get頁())).concat(横線)
                    .concat(changeNullToEmpty(data.get投票資格情報().get行()));
            source.listMeisho2_2 = changeNullToEmpty(data.get投票資格情報().get投票区コード()).concat(横線)
                    .concat(changeNullToEmpty(data.get投票資格情報().get頁())).concat(横線)
                    .concat(changeNullToEmpty(data.get投票資格情報().get行()));
        }
    }

    private void editタイトル(AtenaSealListSource source) {
        if (選挙人画面ID.equals(data.get画面ID())) {
            source.title = 選挙人宛名シール;
        } else if (転出者画面ID.equals(data.get画面ID())) {
            source.title = 転出者宛名シール;
        } else if (施設宛名画面ID.equals(data.get画面ID())) {
            source.title = 施設宛名シール;
        } else {
            source.title = 宛名シール出力一覧表;
        }
    }

    private void edit明細タイトル(AtenaSealListSource source) {
        if (選挙人画面ID.equals(data.get画面ID())) {
            source.meisaiTitle1 = 氏名;
            source.meisaiTitle2 = 名簿番号;
            source.meisaiTitle3 = 生年月日;
            source.meisaiTitle4 = 性別;
            source.meisaiTitle5 = 住所;
        } else if (転出者画面ID.equals(data.get画面ID()) || 表示者.equals(data.get出力対象())) {
            source.meisaiTitle1 = 氏名;
            source.meisaiTitle2 = 名簿番号;
            source.meisaiTitle3 = 生年月日;
            source.meisaiTitle4 = 性別;
            source.meisaiTitle5 = 転出先住所;
            source.meisaiTitle6 = 消除年月日;
        } else if (施設宛名画面ID.equals(data.get画面ID())) {
            source.meisaiTitle1 = 施設名称;
            source.meisaiTitle2 = 施設宛名;
            source.meisaiTitle3 = 施設コード;
            source.meisaiTitle4 = 区分;
            source.meisaiTitle5 = 住所;
            source.meisaiTitle6 = 電話番号;
        }
    }

    private RString set選択した項目(List<RString> 一覧リスト) {
        RString 一覧項目 = RString.EMPTY;
        for (RString 一覧 : 一覧リスト) {
            一覧項目 = 一覧項目.concat(全角スペース).concat(一覧);
        }
        return 一覧項目;
    }

    private void edit抽出条件(AtenaSealListSource source) {
        if (選挙人画面ID.equals(data.get画面ID()) && null != data.get画面情報()) {
            if (null != data.get画面情報().get住所一覧リスト_コード() && !data.get画面情報().get住所一覧リスト_コード().isEmpty()) {
                source.sakuseiJoken = changeNullToEmpty(data.get画面情報().get住所条件()).concat(set選択した項目(data.get画面情報().get住所一覧リスト_コード()));
            } else {
                source.sakuseiJoken = changeNullToEmpty(data.get画面情報().get住所条件()).concat(全角スペース).concat(すべて);
            }
        } else if (転出者画面ID.equals(data.get画面ID())
                && null != data.get画面情報() && null != data.get画面情報().get対象期間FROM() && null != data.get画面情報().get対象期間TO()) {
            source.sakuseiJoken = data.get画面情報().get対象期間FROM().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString()
                    .concat(全角スペース).concat(線).concat(全角スペース)
                    .concat(data.get画面情報().get対象期間TO().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        } else if (施設宛名画面ID.equals(data.get画面ID())) {
            RString 入力 = 施設種別.concat(全角スペース);
            if (null != data.get画面情報() && null != data.get画面情報().get施設種別()) {
                入力 = 入力.concat(changeNullToEmpty(data.get画面情報().get施設種別()));
            } else {
                入力 = 入力.concat(なし);
            }
            入力 = 入力.concat(施設コード).concat(全角スペース);
            if (null != data.get画面情報() && null != data.get画面情報().get施設コードFROM()
                    && null != data.get画面情報().get施設コードTO()) {
                入力 = 入力.concat(全角スペース).concat(changeNullToEmpty(data.get画面情報().get施設コードFROM()))
                        .concat(全角スペース).concat(線).concat(全角スペース)
                        .concat(changeNullToEmpty(data.get画面情報().get施設コードTO()));
            } else {
                入力 = 入力.concat(なし);
            }
            source.sakuseiJoken = 入力;
        }
    }

    private void edit選挙名称(AtenaSealListSource source) {
        if (選挙人画面ID.equals(data.get画面ID())) {
            source.senkyoMei = RString.EMPTY;
        } else if (転出者画面ID.equals(data.get画面ID()) && null != data.get投票資格情報()) {
            source.senkyoMei = data.get投票資格情報().get選挙名称();
        } else if (施設宛名画面ID.equals(data.get画面ID())) {
            source.senkyoMei = RString.EMPTY;
        } else if (null != data.get投票資格情報()) {
            source.senkyoMei = data.get投票資格情報().get抄本名();
        }
    }

    private void edit市町村コード(AtenaSealListSource source) {
        if (null != data.get地方公共団体情報() && null != data.get地方公共団体情報().get地方公共団体コード()) {
            source.shichosonCode = data.get地方公共団体情報().get地方公共団体コード().getColumnValue();
        }
    }

    private void edit作成日時(AtenaSealListSource source) {
        source.sakuseiYmdTime = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(全角スペース)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分))
                .concat(作成);
    }

    private void edit市町村名(AtenaSealListSource source) {
        if (null != data.get地方公共団体情報()) {
            source.shichosonMei = data.get地方公共団体情報().get市町村名();
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;

    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(AtenaSealListSource.class, itemName);
    }
}
