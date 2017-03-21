package jp.co.ndensan.reams.af.afa.business.report.AFAPRK108;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TeiseishaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.NumberEdit;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys.訂正者名簿;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig.登録異動年月日;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.ShinkiTorokushaMeiboKaikuRStringEnum;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.KaikuTeiseishaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108.TeiseishaMeiboKaikuSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 訂正者名簿
 *
 * @reamsid_L AF-0460-035 wanghj
 */
public class TeiseishaMeiboKaikuEditor implements ITeiseishaMeiboKaikuEditor {

    private static final int 住所の上段_項目サイズ = getItemLength(new RString("listTeiseiBeforeMeisai1_4"));

    private final IdouSenkyoninIchiran 異動選挙人一覧;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final TeiseishaMeiboKaikuParam data;
    private final KaikuTeiseishaMeiboEntity entity;
    private final JiyuCode 事由コード;

    /**
     * コンストラクタです。
     *
     * @param data {@link TeiseishaMeiboKaikuParam}
     */
    public TeiseishaMeiboKaikuEditor(TeiseishaMeiboKaikuParam data) {
        this.異動選挙人一覧 = new IdouSenkyoninIchiran();
        this.帳票共通ヘッダー = data.get帳票共通ヘッダー();
        this.data = data;
        this.entity = data.getEntity();
        this.事由コード = data.getEntity().isIdoJiyuCodeIsTenKyo() ? JiyuCode.転居 : JiyuCode.訂正;
    }

    /**
     * 訂正者名簿エディットメソッド
     *
     * @param source 訂正者名簿
     * @return 訂正者名簿
     */
    @Override
    public TeiseishaMeiboKaikuSource edit(TeiseishaMeiboKaikuSource source) {
        setヘッダフッタ(source);
        if (data.is合計行()) {
            source.listTeiseiAfterMeisai1_4 = data.get合計行();
        } else if (!data.isEmpty()) {
            set明細(source);
        }
        return source;
    }

    private void setヘッダフッタ(TeiseishaMeiboKaikuSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.subTitle = 事由コード.getValue();
        source.meisaiTitleYmd = entity.isIdoJiyuCodeIsTenKyo()
                ? ShinkiTorokushaMeiboKaikuRStringEnum.転居届出日.getKey() : ShinkiTorokushaMeiboKaikuRStringEnum.転入届出日.getKey();

        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(entity.getAfterUaft200());

        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        AfT111SenkyoEntity afT111SenkyoEntity = new AfT111SenkyoEntity();
        afT111SenkyoEntity.setKijunYMD(entity.getMaxKijunYMD());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(afT111SenkyoEntity));
        senkyoJohoEntity.setShohonEntity(entity.getAfT100Shohon());

        senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);

        List<RString> 地区行政区判断_訂正後 = 異動選挙人一覧.is行政区_地区(senkyoninTohyoJokyoEntity);
        source.chikuCodeMei = 地区行政区判断_訂正後.get(NumberEdit.固定数_０.getKey());
        source.chikuMei = 地区行政区判断_訂正後.get(NumberEdit.固定数_２.getKey());
        source.selHani = 異動選挙人一覧.get作成条件(訂正者名簿.value(), 事由コード.getKey(), senkyoninTohyoJokyoEntity);
    }

    private void set明細(TeiseishaMeiboKaikuSource source) {

        UaFt200FindShikibetsuTaishoEntity 訂正後宛名 = entity.getAfterUaft200();
        UaFt200FindShikibetsuTaishoEntity 訂正前宛名 = entity.getBeforeUaft200();

        IKojin kojin訂正後 = ShikibetsuTaishoFactory.createKojin(訂正後宛名);
        IKojin kojin訂正前 = ShikibetsuTaishoFactory.createKojin(訂正前宛名);

        IGyoseiKukaku 行政区画_訂正後 = kojin訂正後.get行政区画();
        IGyoseiKukaku 行政区画_訂正前 = kojin訂正前.get行政区画();

        // 投票区
        source.listTeiseiBeforeMeisai1_1 = 行政区画_訂正前.getTohyoku().getコード().getColumnValue();
        source.listTeiseiAfterMeisai1_1 = 異動選挙人一覧.set訂正後情報(行政区画_訂正前.getTohyoku().getコード().getColumnValue(),
                行政区画_訂正後.getTohyoku().getコード().getColumnValue(), NumberEdit.固定数_４.getKey());

        // 住所コード
        IJusho 住所_訂正前 = kojin訂正前.get住所();
        IJusho 住所_訂正後 = kojin訂正後.get住所();
        source.listTeiseiBeforeMeisai1_2 = 住所_訂正前.get町域コード().getColumnValue();
        source.listTeiseiAfterMeisai1_2 = 異動選挙人一覧.set訂正後情報(住所_訂正前.get町域コード().getColumnValue(),
                住所_訂正後.get町域コード().getColumnValue(), NumberEdit.固定数_11.getKey());

        // 世帯コード
        source.listTeiseiBeforeMeisai1_3 = kojin訂正前.get世帯コード().getColumnValue();
        source.listTeiseiAfterMeisai1_3 = 異動選挙人一覧.set訂正後情報(kojin訂正前.get世帯コード().getColumnValue(),
                kojin訂正後.get世帯コード().getColumnValue(), NumberEdit.固定数_15.getKey());

        // 住所
        RString 住所文字列_訂正前 = get住所(kojin訂正前.get住登内住所());
        RString 住所文字列_訂正後 = get住所(kojin訂正後.get住登内住所());
        List<RString> 住所文字列s_訂正前 = 異動選挙人一覧.文字列分割(住所文字列_訂正前, 住所の上段_項目サイズ);
        List<RString> 住所文字列s_訂正後 = 異動選挙人一覧.文字列分割(異動選挙人一覧.set訂正後情報(住所文字列_訂正前, 住所文字列_訂正後,
                住所の上段_項目サイズ), 住所の上段_項目サイズ);
        source.listTeiseiBeforeMeisai1_4 = 住所文字列s_訂正前.get(0);
        source.listTeiseiBeforeMeisai2_4 = 住所文字列s_訂正前.get(1);
        source.listTeiseiAfterMeisai1_4 = 住所文字列s_訂正後.get(0);
        source.listTeiseiAfterMeisai2_4 = 住所文字列s_訂正後.get(1);

        // 氏名
        RString 氏名_訂正前 = kojin訂正前.get名称().getName().getColumnValue();
        RString 氏名_訂正後 = kojin訂正後.get名称().getName().getColumnValue();
        source.listTeiseiBeforeMeisai1_5 = 氏名_訂正前;
        source.listTeiseiAfterMeisai1_5 = 異動選挙人一覧.set訂正後情報(氏名_訂正前, 氏名_訂正後, getItemLength(new RString("listTeiseiBeforeMeisai1_5")));

        // 性別
        source.listTeiseiBeforeMeisai1_6 = kojin訂正前.get性別().getCommonName();
        source.listTeiseiAfterMeisai1_6 = 異動選挙人一覧.set訂正後情報(kojin訂正前.get性別().getCommonName(),
                kojin訂正後.get性別().getCommonName(), NumberEdit.固定数_１.getKey());

        // 生年月日
        List<RString> 生年月日s = edit日付(kojin訂正前.get生年月日().toFlexibleDate(),
                kojin訂正後.get生年月日().toFlexibleDate(),
                kojin訂正前.get住民種別());
        source.listTeiseiBeforeMeisai1_7 = 生年月日s.get(0);
        source.listTeiseiAfterMeisai1_7 = 生年月日s.get(1);

        //明細タイトル年月日
        List<RString> 日付s = get日付(kojin訂正前, kojin訂正後);
        source.listTeiseiBeforeMeisai1_8 = 日付s.get(0);
        source.listTeiseiAfterMeisai1_8 = 日付s.get(1);

        // 表示年月日
        List<RString> 表示年月日s = edit日付(entity.getAfT113SenkyoShikaku().getHyojiYMD(), entity.getAfT113SenkyoShikakuBefore().getHyojiYMD());
        source.listTeiseiBeforeMeisai1_9 = 表示年月日s.get(0);
        source.listTeiseiAfterMeisai1_9 = 表示年月日s.get(1);

        // 異動年月日
        FlexibleDate 異動年月日 = entity.isIdoJiyuCodeIsTenKyo() ? kojin訂正前.get異動年月日() : kojin訂正前.get処理年月日();
        List<RString> 異動年月日s = edit日付(異動年月日, 異動年月日);
        source.listTeiseiBeforeMeisai1_10 = 異動年月日s.get(0);
        source.listTeiseiAfterMeisai1_10 = 異動年月日s.get(1);

        // 識別コード
        source.listTeiseiBeforeMeisai2_3 = kojin訂正前.get識別コード().getColumnValue();
        source.listTeiseiAfterMeisai2_3 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai1_5,
                kojin訂正後.get識別コード().getColumnValue(), NumberEdit.固定数_15.getKey());

        // 漁業日数（漁業者）
        source.listTeiseiBeforeMeisai2_6 = new RString(data.getEntity().getAfT133KaikuSenkyoFuzuiBefore().getNissuGyogyosha());
        source.listTeiseiAfterMeisai2_6 = 異動選挙人一覧.set訂正後情報(new RString(data.getEntity().getAfT133KaikuSenkyoFuzuiBefore().getNissuGyogyosha()),
                new RString(data.getEntity().getAfT133KaikuSenkyoFuzui().getNissuGyogyosha()), NumberEdit.固定数_３.getKey());

        // 漁業日数（従事者）
        source.listTeiseiBeforeMeisai2_7 = new RString(data.getEntity().getAfT133KaikuSenkyoFuzuiBefore().getNissuJujisha());
        source.listTeiseiAfterMeisai2_7 = 異動選挙人一覧.set訂正後情報(new RString(data.getEntity().getAfT133KaikuSenkyoFuzuiBefore().getNissuJujisha()),
                new RString(data.getEntity().getAfT133KaikuSenkyoFuzui().getNissuJujisha()), NumberEdit.固定数_３.getKey());

        set地区コード名と地区名(source);
        // 明細８列目
        source.listTeiseiBeforeMeisai2_8 = RString.EMPTY;
        source.listTeiseiAfterMeisai2_8 = get事由名称(kojin訂正後);

        source.識別コード = kojin訂正前.get識別コード();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get事由名称(IKojin kojin訂正後) {
        return kojin訂正後.get異動事由().get異動事由正式名称().padLeft(NumberEdit.固定数_５.getKey()).substring(0, NumberEdit.固定数_５.getKey()).trim();

    }

    private void set地区コード名と地区名(TeiseishaMeiboKaikuSource source) {
        SenkyoninTohyoJokyoEntity 訂正前情報 = new SenkyoninTohyoJokyoEntity();
        訂正前情報.setAtenaPSMEntity(entity.getBeforeUaft200());
        SenkyoninTohyoJokyoEntity 訂正後情報 = new SenkyoninTohyoJokyoEntity();
        訂正後情報.setAtenaPSMEntity(entity.getAfterUaft200());
        List<RString> 地区行政区判断_訂正前 = 異動選挙人一覧.is行政区_地区(訂正前情報);
        List<RString> 地区行政区判断_訂正後 = 異動選挙人一覧.is行政区_地区(訂正後情報);
        source.listTeiseiBeforeMeisai2_2 = 地区行政区判断_訂正前.get(NumberEdit.固定数_１.getKey());
        source.listTeiseiBeforeMeisai2_5 = 地区行政区判断_訂正前.get(NumberEdit.固定数_３.getKey());
        source.listTeiseiAfterMeisai2_2 = 異動選挙人一覧
                .set訂正後情報(地区行政区判断_訂正前.get(NumberEdit.固定数_１.getKey()), 地区行政区判断_訂正後.get(NumberEdit.固定数_１.getKey()), NumberEdit.固定数_９.getKey());
        source.listTeiseiAfterMeisai2_5 = 異動選挙人一覧
                .set訂正後情報(地区行政区判断_訂正前.get(NumberEdit.固定数_３.getKey()), 地区行政区判断_訂正後.get(NumberEdit.固定数_３.getKey()), NumberEdit.固定数_９.getKey());
    }

    private List<RString> edit日付(FlexibleDate 訂正前, FlexibleDate 訂正後) {
        return edit日付(訂正前, 訂正後, JuminShubetsu.日本人);
    }

    private List<RString> edit日付(FlexibleDate 訂正前, FlexibleDate 訂正後, JuminShubetsu 住民種別コード) {
        RString 訂正後日付 = 異動選挙人一覧.set訂正後情報(訂正前 == null ? RString.EMPTY : 訂正前.wareki().toDateString(),
                訂正後 == null ? RString.EMPTY : 訂正後.wareki().toDateString(), NumberEdit.固定数_８.getKey());
        return Arrays.asList(訂正前 == null ? RString.EMPTY : 異動選挙人一覧.get生年月日(住民種別コード.getCode(), 訂正前),
                RString.isNullOrEmpty(訂正後日付) || ShinkiTorokushaMeiboKaikuRStringEnum.訂正後日付が空.getKey().equals(訂正後日付)
                ? 訂正後日付 : (訂正後 == null ? RString.EMPTY : 異動選挙人一覧.get生年月日(住民種別コード.getCode(), 訂正後)));
    }

    private List<RString> get日付(IKojin kojin訂正前, IKojin kojin訂正後) {
        if (entity.isIdoJiyuCodeIsTenKyo()) {
            return Arrays.asList(getNonNullDate(kojin訂正前.get住定届出年月日()).wareki().toDateString(), RString.EMPTY);

        } else {
            RString 登録検索基準 = BusinessConfig.get(YMDKensakuKijunConfig.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
            FlexibleDate 日付_訂正前;
            FlexibleDate 日付_訂正後;
            if (登録異動年月日.getValue().equals(登録検索基準)) {
                日付_訂正前 = getNonNullDate(kojin訂正前.get登録異動年月日());
                日付_訂正後 = getNonNullDate(kojin訂正後.get登録異動年月日());
            } else {
                日付_訂正前 = getNonNullDate(kojin訂正前.get登録届出年月日());
                日付_訂正後 = getNonNullDate(kojin訂正後.get登録届出年月日());
            }
            return edit日付(日付_訂正前, 日付_訂正後);
        }
    }

    private RString get住所(IJusho 住所) {
        RStringBuilder 住所文字列 = new RStringBuilder();
        住所文字列.append(住所.get住所().trimEnd());
        住所文字列.append(住所.get番地().getBanchi().getColumnValue().trimStart());
        住所文字列.append(RString.FULL_SPACE);
        住所文字列.append(住所.get方書().getColumnValue());
        return 住所文字列.toRString();
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(TeiseishaMeiboKaikuSource.class, itemName);
    }

    private FlexibleDate getNonNullDate(FlexibleDate date) {
        return null == date ? FlexibleDate.EMPTY : date;
    }
}
