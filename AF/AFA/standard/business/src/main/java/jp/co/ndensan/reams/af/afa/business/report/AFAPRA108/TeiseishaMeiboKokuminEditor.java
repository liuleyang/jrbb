/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA108;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys.訂正者名簿;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig.登録異動年月日;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.TeiseishaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA108.TeiseishaMeiboSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link TeiseishaMeiboSource}を編集します。
 *
 * @reamsid_L AF-0360-053 caijj2
 */
public class TeiseishaMeiboKokuminEditor implements ITeiseishaMeiboKokuminEditor {

    private static final int 投票区_項目サイズ = 4;
    private static final int 住所コード_項目サイズ = 11;
    private static final int 世帯コードと識別コード_続柄項目サイズ = 15;
    private static final int 性別_項目サイズ = 1;
    private static final int 生年月日と日付_項目サイズ = 8;
    private static final int 地区_項目サイズ = 9;
    private static final int 住所の上段_項目サイズ = getItemLength(new RString("listTeiseiBeforeMeisai1_4"));
    private static final int 氏名_項目サイズ = getItemLength(new RString("listTeiseiBeforeMeisai1_5"));
    private static final int 世帯主名_項目サイズ = getItemLength(new RString("listTeiseiBeforeMeisai2_7"));
    private static final RString 訂正後日付が空 = new RString("--------");
    private static final int 地区コードタイトル = 0;
    private static final int 地区コード内容 = 1;
    private static final int 地区名タイトル = 2;
    private static final int 地区名内容 = 3;
    private static final int 先頭の5文字 = 5;
    private static final RString 日付タイトル_転居 = new RString("転居届出日");
    private static final RString 日付タイトル_訂正 = new RString("転入届出日");

    private final IdouSenkyoninIchiran 異動選挙人一覧;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final TeiseishaMeiboKokuminParam param;
    private final TeiseishaMeiboEntity entity;
    private final JiyuCode 事由コード;

    /**
     * コンストラクタです。
     *
     * @param param TeiseishaMeiboKokuminParam
     */
    public TeiseishaMeiboKokuminEditor(TeiseishaMeiboKokuminParam param) {
        this.param = param;
        this.帳票共通ヘッダー = param.get帳票共通ヘッダー();
        this.entity = param.getEntity();
        this.異動選挙人一覧 = new IdouSenkyoninIchiran();
        this.事由コード = param.getEntity().isIdoJiyuCodeIsTenKyo() ? JiyuCode.転居 : JiyuCode.訂正;
    }

    @Override
    public TeiseishaMeiboSource edit(TeiseishaMeiboSource source) {
        setヘッダフッタ(source);

        if (param.is合計行()) {
            source.listTeiseiAfterMeisai1_4 = param.get合計行();
        } else if (!param.isEmpty()) {
            set明細(source);
        }
        return source;

    }

    private void setヘッダフッタ(TeiseishaMeiboSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.subTitle = 事由コード.getValue();
        source.meisaiTitleYmd = entity.isIdoJiyuCodeIsTenKyo() ? 日付タイトル_転居 : 日付タイトル_訂正;

        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(entity.getAfterUaft200());

        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        AfT111SenkyoEntity afT111SenkyoEntity = new AfT111SenkyoEntity();
        afT111SenkyoEntity.setKijunYMD(entity.getMaxKijunYMD());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(afT111SenkyoEntity));
        senkyoJohoEntity.setShohonEntity(entity.getAfT100Shohon());

        senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);

        List<RString> 地区行政区判断_訂正後 = 異動選挙人一覧.is行政区_地区(senkyoninTohyoJokyoEntity);
        source.chikuCodeMei = 地区行政区判断_訂正後.get(地区コードタイトル);
        source.chikuMei = 地区行政区判断_訂正後.get(地区名タイトル);
        source.selHani = 異動選挙人一覧.get作成条件(訂正者名簿.value(), 事由コード.getKey(), senkyoninTohyoJokyoEntity);
    }

    private void set明細(TeiseishaMeiboSource source) {

        UaFt200FindShikibetsuTaishoEntity 訂正前宛名 = entity.getBeforeUaft200();
        UaFt200FindShikibetsuTaishoEntity 訂正後宛名 = entity.getAfterUaft200();

        IKojin kojin訂正前 = ShikibetsuTaishoFactory.createKojin(訂正前宛名);
        IKojin kojin訂正後 = ShikibetsuTaishoFactory.createKojin(訂正後宛名);

        IGyoseiKukaku 行政区画_訂正前 = kojin訂正前.get行政区画();
        IGyoseiKukaku 行政区画_訂正後 = kojin訂正後.get行政区画();

        // 明細タイトル１
        List<RString> 日付s = get日付(kojin訂正前, kojin訂正後);
        source.listTeiseiBeforeMeisai1_8 = 日付s.get(0);
        source.listTeiseiAfterMeisai1_8 = 日付s.get(1);

        set地区コード名と地区名(source);

        // 投票区
        source.listTeiseiBeforeMeisai1_1 = 行政区画_訂正前.getTohyoku().getコード().getColumnValue();
        source.listTeiseiAfterMeisai1_1 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai1_1,
                行政区画_訂正後.getTohyoku().getコード().getColumnValue(),
                投票区_項目サイズ);

        // 住所コード
        IJusho 住所_訂正前 = kojin訂正前.get住所();
        IJusho 住所_訂正後 = kojin訂正後.get住所();
        source.listTeiseiBeforeMeisai1_2 = 住所_訂正前.get町域コード().getColumnValue();
        source.listTeiseiAfterMeisai1_2 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai1_2,
                住所_訂正後.get町域コード().getColumnValue(), 住所コード_項目サイズ);

        // 世帯コード
        source.listTeiseiBeforeMeisai1_3 = kojin訂正前.get世帯コード().getColumnValue();
        source.listTeiseiAfterMeisai1_3 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai1_3,
                kojin訂正後.get世帯コード().getColumnValue(), 世帯コードと識別コード_続柄項目サイズ);

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
        source.listTeiseiAfterMeisai1_5 = 異動選挙人一覧.set訂正後情報(氏名_訂正前, 氏名_訂正後, 氏名_項目サイズ);

        // 性別
        source.listTeiseiBeforeMeisai1_6 = kojin訂正前.get性別().getCommonName();
        source.listTeiseiAfterMeisai1_6 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai1_6,
                kojin訂正後.get性別().getCommonName(), 性別_項目サイズ);

        // 生年月日
        List<RString> 生年月日s = edit日付(kojin訂正前.get生年月日().toFlexibleDate(),
                kojin訂正後.get生年月日().toFlexibleDate(),
                kojin訂正前.get住民種別());
        source.listTeiseiBeforeMeisai1_7 = 生年月日s.get(0);
        source.listTeiseiAfterMeisai1_7 = 生年月日s.get(1);

        // 表示年月日
        List<RString> 表示年月日s = edit日付(entity.getAfT113SenkyoShikaku().getHyojiYMD(), entity.getAfT113SenkyoShikakuAfter().getHyojiYMD());
        source.listTeiseiBeforeMeisai1_9 = 表示年月日s.get(0);
        source.listTeiseiAfterMeisai1_9 = 表示年月日s.get(1);

        // 異動年月日
        FlexibleDate 異動年月日 = entity.isIdoJiyuCodeIsTenKyo() ? kojin訂正前.get異動年月日() : kojin訂正前.get処理年月日();
        List<RString> 異動年月日s = edit日付(異動年月日, 異動年月日);
        source.listTeiseiBeforeMeisai1_10 = 異動年月日s.get(0);
        source.listTeiseiAfterMeisai1_10 = 異動年月日s.get(1);

        // 識別コード
        source.listTeiseiBeforeMeisai2_3 = kojin訂正前.get識別コード().getColumnValue();
        source.listTeiseiAfterMeisai2_3 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai2_3,
                kojin訂正後.get識別コード().getColumnValue(), 世帯コードと識別コード_続柄項目サイズ);

        // 続柄
        source.listTeiseiBeforeMeisai2_6 = kojin訂正前.get続柄();
        source.listTeiseiAfterMeisai2_6 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai2_6,
                kojin訂正後.get続柄(), 世帯コードと識別コード_続柄項目サイズ);

        // 世帯主名
        source.listTeiseiBeforeMeisai2_7 = kojin訂正前.get世帯主名().getColumnValue();
        source.listTeiseiAfterMeisai2_7 = 異動選挙人一覧.set訂正後情報(source.listTeiseiBeforeMeisai2_7,
                kojin訂正後.get世帯主名().getColumnValue(), 世帯主名_項目サイズ);

        source.listTeiseiBeforeMeisai2_8 = RString.EMPTY;
        source.listTeiseiAfterMeisai2_8 = get事由名称(kojin訂正後);

    }

    private RString get事由名称(IKojin kojin訂正後) {
        return kojin訂正後.get異動事由().get異動事由正式名称().padLeft(先頭の5文字).substring(0, 先頭の5文字).trim();

    }

    private void set地区コード名と地区名(TeiseishaMeiboSource source) {
        SenkyoninTohyoJokyoEntity 訂正前情報 = new SenkyoninTohyoJokyoEntity();
        訂正前情報.setAtenaPSMEntity(entity.getBeforeUaft200());
        SenkyoninTohyoJokyoEntity 訂正後情報 = new SenkyoninTohyoJokyoEntity();
        訂正後情報.setAtenaPSMEntity(entity.getAfterUaft200());
        List<RString> 地区行政区判断_訂正前 = 異動選挙人一覧.is行政区_地区(訂正前情報);
        List<RString> 地区行政区判断_訂正後 = 異動選挙人一覧.is行政区_地区(訂正後情報);
        source.listTeiseiBeforeMeisai2_2 = 地区行政区判断_訂正前.get(地区コード内容);
        source.listTeiseiBeforeMeisai2_5 = 地区行政区判断_訂正前.get(地区名内容);
        source.listTeiseiAfterMeisai2_2 = 異動選挙人一覧
                .set訂正後情報(地区行政区判断_訂正前.get(地区コード内容), 地区行政区判断_訂正後.get(地区コード内容), 地区_項目サイズ);
        source.listTeiseiAfterMeisai2_5 = 異動選挙人一覧
                .set訂正後情報(地区行政区判断_訂正前.get(地区名内容), 地区行政区判断_訂正後.get(地区名内容), 地区_項目サイズ);
    }

    private List<RString> edit日付(FlexibleDate 訂正前, FlexibleDate 訂正後) {
        return edit日付(訂正前, 訂正後, JuminShubetsu.日本人);
    }

    private List<RString> edit日付(FlexibleDate 訂正前, FlexibleDate 訂正後, JuminShubetsu 住民種別コード) {
        RString 訂正後日付 = 異動選挙人一覧.set訂正後情報(訂正前 == null ? RString.EMPTY : 訂正前.wareki().toDateString(),
                訂正後 == null ? RString.EMPTY : 訂正後.wareki().toDateString(), 生年月日と日付_項目サイズ);
        return Arrays.asList(訂正前 == null ? RString.EMPTY : 異動選挙人一覧.get生年月日(住民種別コード.getCode(), 訂正前),
                RString.isNullOrEmpty(訂正後日付) || 訂正後日付が空.equals(訂正後日付)
                ? 訂正後日付 : (訂正後 == null ? RString.EMPTY : 異動選挙人一覧.get生年月日(住民種別コード.getCode(), 訂正後)));
    }

    private List<RString> get日付(IKojin kojin訂正前, IKojin kojin訂正後) {
        if (entity.isIdoJiyuCodeIsTenKyo()) {
            return Arrays.asList(getNonNullDate(kojin訂正前.get住定届出年月日()).wareki().toDateString(), RString.EMPTY);

        } else {
            RDate nowDate = RDate.getNowDate();
            RString 登録検索基準 = BusinessConfig.get(YMDKensakuKijunConfig.登録年月日検索基準, nowDate, SubGyomuCode.AFA選挙本体);
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

    private FlexibleDate getNonNullDate(FlexibleDate date) {
        return null == date ? FlexibleDate.EMPTY : date;
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(TeiseishaMeiboSource.class, itemName);
    }
}
