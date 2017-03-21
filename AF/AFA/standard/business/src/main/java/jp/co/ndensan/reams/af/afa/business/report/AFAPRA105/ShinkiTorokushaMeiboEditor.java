/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link ShinkiTorokushaMeiboSource}を編集します。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
public class ShinkiTorokushaMeiboEditor implements IShinkiTorokushaMeiboEditor {

    private final ShinkiTorokushaMeiboParam param;
    private final RString 帳票ID;
    private final RString 事由コード;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
    private static final int 頁最大値 = 6;
    private static final int 行最大値 = 2;
    private static final int 行目3 = 3;
    private static final int 行目6 = 6;
    private final RString 明細見出し = new RString("明細見出し");
    private final RString 明細行 = new RString("明細行");
    private final IShikibetsuTaisho 宛名識別対象;

    /**
     * テスト用のコンストラクタです。
     *
     * @param param {@link ShinkiTorokushaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ShinkiTorokushaMeiboEditor(ShinkiTorokushaMeiboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.param = param;
        this.帳票ID = param.get帳票ID();
        this.事由コード = param.get事由コード();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(param.getEntity().getShikibetsuTaishoEntity());
    }

    @Override
    public ShinkiTorokushaMeiboSource edit(ShinkiTorokushaMeiboSource source) {
        edit帳票共通ヘッダー(source);
        if (param.getIs空白行()) {
            setAllWhen空白行(source);
            return source;
        }
        if (!param.get集計情報().isEmpty()) {
            setAllWhen集計情報(source);
            return source;
        }
        set帳票タイトルAndサブタイトル(source);
        set明細見出し(source);
        set明細行(source);
        source.selHani = idouSenkyoninIchiran.get作成条件(帳票ID, 事由コード, toSenkyoninTohyoJokyoEntity(param.getEntity()));
        editログの出力(source);
        return source;

    }

    private void edit帳票共通ヘッダー(ShinkiTorokushaMeiboSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void editログの出力(ShinkiTorokushaMeiboSource source) {
        source.識別コード1 = param.getEntity().getShikibetsuTaishoEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void set明細見出し(ShinkiTorokushaMeiboSource source) {
        source.chikuCodeMei = this.get地区コード名(source, 明細見出し);
        source.jushoMei = this.get住所名(source, 明細見出し);
        source.chikuMei = this.get地区名(source, 明細見出し);
        source.meisaiTitleDate1 = this.get日付タイトル１(source, 明細見出し);
        source.meisaiTitleDate2 = this.get日付タイトル2(source, 明細見出し);
        source.meisaiTitleDate3 = this.get日付タイトル3(source, 明細見出し);
        source.meisaiTitleDate4 = this.get日付タイトル4(source, 明細見出し);
    }

    private void set明細行(ShinkiTorokushaMeiboSource source) {
        if (帳票ID.equals(ReportIdKeys.規定年齢前名簿.value())) {
            TohyokuCode tohyokuCode = param.getEntity().getShikibetsuTaishoEntity().getTohyokuCode();
            source.listMeisai1_1 = tohyokuCode == null ? RString.EMPTY : tohyokuCode.getColumnValue();
        } else {
            source.listMeisai1_1 = null == param.getEntity().getSenkyoninMeiboEntity() ? RString.EMPTY
                    : param.getEntity().getSenkyoninMeiboEntity().getTohyokuCode();
        }
        source.listMeisai1_2 = 宛名識別対象.to個人().get住登内住所().get町域コード().value();
        source.listMeisai1_3 = 宛名識別対象.to個人().get世帯コード().value();
        source.listMeisai1_4 = get住所();
        source.listMeisai1_5 = 宛名識別対象.to個人().get名称().getName().value();
        source.listMeisai1_6 = get性別();
        source.listMeisai1_7 = get生年月日();
        if (!source.meisaiTitleDate1.isNullOrEmpty()) {
            source.listMeisai1_8 = this.get日付タイトル１(source, 明細行);
        } else {
            source.listMeisai1_8 = RString.EMPTY;
        }
        if (!source.meisaiTitleDate2.isNullOrEmpty()) {
            source.listMeisai1_9 = this.get日付タイトル2(source, 明細行);
        } else {
            source.listMeisai1_9 = RString.EMPTY;
        }
        if (!source.meisaiTitleDate3.isNullOrEmpty()) {
            source.listMeisai1_10 = this.get日付タイトル3(source, 明細行);
        } else {
            source.listMeisai1_10 = RString.EMPTY;
        }
        if (!source.chikuCodeMei.isNullOrEmpty()) {
            source.listMeisai2_2 = this.get地区コード名(source, 明細行);
        } else {
            source.listMeisai2_2 = RString.EMPTY;
        }
        source.listMeisai2_3 = 宛名識別対象.get識別コード().value();
        if (!source.jushoMei.isNullOrEmpty()) {
            source.listMeisai2_4 = this.get住所名(source, 明細行);
        } else {
            source.listMeisai2_4 = RString.EMPTY;
        }
        if (!source.chikuMei.isNullOrEmpty()) {
            source.listMeisai2_5 = this.get地区名(source, 明細行);
        } else {
            source.listMeisai2_5 = RString.EMPTY;
        }
        source.listMeisai2_6 = 宛名識別対象.to個人().get続柄();
        source.listMeisai2_7 = 宛名識別対象.to個人().get世帯主名().value();
        source.listMeisai2_8 = this.get日付タイトル4(source, 明細行);
    }

    private void set帳票タイトルAndサブタイトル(ShinkiTorokushaMeiboSource source) {
        set帳票タイトルByCase1(source);
        set帳票タイトルByCase2(source);
    }

    private RString get地区コード名(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        if (!ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
            List<RString> 地区List = idouSenkyoninIchiran.is行政区_地区(toSenkyoninTohyoJokyoEntity(param.getEntity()));
            if (明細種類.equals(明細見出し)) {
                return 地区List.get(0);
            } else {
                return 地区List.get(1);
            }
        } else if (明細種類.equals(明細見出し)) {
            return new RString("頁－行");
        } else {
            int 頁 = param.getEntity().getSenkyoninMeiboEntity().getPage();
            int 行 = param.getEntity().getSenkyoninMeiboEntity().getGyo();
            return new RString(String.valueOf(頁)).padLeft(頁最大値)
                    .concat("-").concat(new RString(String.valueOf(行)).padLeft(行最大値));
        }
    }

    private RString get住所名(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        int 住所名最大文字数 = ReportDataInfoLoader.getMaxLength(ShinkiTorokushaMeiboSource.class, new RString("listMeisai2_4"));
        int 文字数 = 住所名最大文字数 - 行目6;
        RString 住所名 = RString.EMPTY;
        if (ReportIdKeys.抹消者名簿.getName().equals(source.title)) {
            if (明細種類.equals(明細見出し)) {
                住所名 = new RString("転出先住所");
            } else if (new RString("死亡").equals(source.subTitle) || new RString("居住要件").equals(source.subTitle)) {
                住所名 = RString.EMPTY;
            } else {
                住所名 = get転出先(文字数);
            }
        } else if (ReportIdKeys.転出者名簿.getName().equals(source.title) || ReportIdKeys.職権消除者名簿.getName().equals(source.title)
                || ReportIdKeys.失権者名簿.getName().equals(source.title) || ReportIdKeys.表示者名簿.getName().equals(source.title)) {
            if (明細種類.equals(明細見出し)) {
                住所名 = new RString("転出先住所");
            } else {
                住所名 = get転出先(文字数);
            }
        } else if (ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title) || ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)
                || ReportIdKeys.規定年齢前名簿.getName().equals(source.title) || ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title)
                || ReportIdKeys.表示消除者名簿.getName().equals(source.title)) {
            住所名 = RString.EMPTY;
        } else if (ReportIdKeys.抹消予定者名簿.getName().equals(source.title)) {
            住所名 = this.set住所名When抹消予定者名簿(明細種類, 文字数);
        }
        return 住所名;
    }

    private RString set住所名When抹消予定者名簿(RString 明細種類, int 文字数) {
        RString 住所名;
        if (明細種類.equals(明細見出し)) {
            住所名 = new RString("転出先（転入前）住所");
        } else {
            RString 住民状態コード = NullHandler.getNullToRString(param.getEntity().getShikibetsuTaishoEntity().getJuminJotaiCode());
            if (住民状態コード.equals(new RString("3")) || 住民状態コード.equals(new RString("9"))) {
                住所名 = get転出先(文字数);
            } else {
                RString 転入前住所 = 宛名識別対象.to個人().get転入前().get住所();
                RString 転入前番地 = 宛名識別対象.to個人().get転入前().get番地().getBanchi().value();
                RString 転入前方書 = 宛名識別対象.to個人().get転入前().get方書().value();
                RString 住民状態 = new RString("転入前");
                住所名 = this.getText(転入前住所, 転入前番地, 転入前方書, 住民状態, 文字数);
            }
        }
        return 住所名;
    }

    private RString get日付タイトル１(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        if (明細種類.equals(明細見出し)) {
            if (ReportIdKeys.新規登録者名簿.getName().equals(source.title) || ReportIdKeys.表示消除者名簿.getName().equals(source.title)
                    || ReportIdKeys.再転入者名簿.getName().equals(source.title) || ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title)) {
                return new RString("転入年月日");
            } else if (ReportIdKeys.抹消者名簿.getName().equals(source.title) || ReportIdKeys.抹消予定者名簿.getName().equals(source.title)
                    || ReportIdKeys.表示消除予定者名簿.getName().equals(source.title) || ReportIdKeys.職権消除者名簿.getName().equals(source.title)
                    || ReportIdKeys.転出者名簿.getName().equals(source.title)) {
                return new RString("異動年月日");
            } else if (ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title) || ReportIdKeys.規定年齢前名簿.getName().equals(source.title)) {
                return new RString("転入届出日");
            } else if (ReportIdKeys.失権者名簿.getName().equals(source.title) || ReportIdKeys.表示者名簿.getName().equals(source.title)) {
                return new RString("表示年月日");
            }
            return RString.EMPTY;
        } else {
            FlexibleDate 日付タイトル１ = FlexibleDate.EMPTY;
            日付タイトル１ = set日付タイトル１ByCase1(source, 日付タイトル１);
            return 日付タイトル１.wareki().toDateString();
        }
    }

    private RString get日付タイトル2(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        if (明細種類.equals(明細見出し)) {
            if (ReportIdKeys.新規登録者名簿.getName().equals(source.title) || ReportIdKeys.表示消除者名簿.getName().equals(source.title)
                    || ReportIdKeys.再転入者名簿.getName().equals(source.title)) {
                return new RString("登録年月日");
            } else if (ReportIdKeys.抹消者名簿.getName().equals(source.title) || ReportIdKeys.抹消予定者名簿.getName().equals(source.title)
                    || ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title)) {
                return new RString("抹消年月日");
            } else if (ReportIdKeys.失権者名簿.getName().equals(source.title) || ReportIdKeys.表示者名簿.getName().equals(source.title)) {
                return new RString("転出年月日");
            } else if (ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
                return new RString("異動届出日");
            } else if (ReportIdKeys.職権消除者名簿.getName().equals(source.title) || ReportIdKeys.転出者名簿.getName().equals(source.title)) {
                return new RString("届出年月日");
            } else if (ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title)) {
                return new RString("資格区分");
            }
            return RString.EMPTY;
        } else {
            return get日付タイトル2By明細行(source);
        }
    }

    private RString get日付タイトル2By明細行(ShinkiTorokushaMeiboSource source) {
        FlexibleDate 日付タイトル2 = FlexibleDate.EMPTY;
        if (ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title)) {
            RString 選挙種類 = param.getEntity().getSenkyoShikakuEntity().getSenkyoShurui().value();
            RString 選挙資格区分 = NullHandler.getNullToRString(param.getEntity().getSenkyoShikakuEntity().getShikakuKubun());
            return idouSenkyoninIchiran.get選挙資格(選挙種類, 選挙資格区分);
        } else {
            if (ReportIdKeys.新規登録者名簿.getName().equals(source.title) || ReportIdKeys.表示消除者名簿.getName().equals(source.title)
                    || ReportIdKeys.再転入者名簿.getName().equals(source.title)) {
                日付タイトル2 = param.getEntity().getSenkyoShikakuEntity().getMeiboTorokuYMD();
            }
            if ((ReportIdKeys.転出者名簿.getName().equals(source.title) || ReportIdKeys.職権消除者名簿.getName().equals(source.title))
                    && 宛名識別対象.to個人().canBe住基個人()) {
                日付タイトル2 = 宛名識別対象.to個人().to住基個人().get届出年月日();
            }
            if (ReportIdKeys.抹消者名簿.getName().equals(source.title) || ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title)) {
                日付タイトル2 = param.getEntity().getSenkyoShikakuEntity().getMasshoYMD();
            }
            if (ReportIdKeys.失権者名簿.getName().equals(source.title)) {
                日付タイトル2 = get日付タイトルBy消除年月日検索基準();
            }
            if (ReportIdKeys.抹消予定者名簿.getName().equals(source.title) || ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
                日付タイトル2 = 宛名識別対象.to個人().get消除届出年月日();
            }
            if (ReportIdKeys.表示者名簿.getName().equals(source.title)) {
                日付タイトル2 = param.getEntity().getSenkyoShikakuEntity().getHyojiYMD();
            }
            if (ReportIdKeys.規定年齢前名簿.getName().equals(source.title)) {
                日付タイトル2 = FlexibleDate.EMPTY;
            }
            return NullHandler.getNullToFlexibleDate(日付タイトル2).wareki().toDateString();
        }
    }

    private RString get日付タイトル3(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        if (明細種類.equals(明細見出し)) {
            if (ReportIdKeys.新規登録者名簿.getName().equals(source.title) && new RString("その他").equals(source.subTitle)) {
                return new RString("表示年月日");
            }
            if (ReportIdKeys.抹消者名簿.getName().equals(source.title)) {
                return this.get日付タイトル3When抹消者名簿(source);
            } else if (ReportIdKeys.抹消予定者名簿.getName().equals(source.title) || ReportIdKeys.表示消除者名簿.getName().equals(source.title)
                    || ReportIdKeys.再転入者名簿.getName().equals(source.title) || ReportIdKeys.転出者名簿.getName().equals(source.title)
                    || ReportIdKeys.職権消除者名簿.getName().equals(source.title)) {
                return new RString("表示年月日");
            } else if (ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
                return new RString("転入年月日");
            } else if (ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title) || ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title)) {
                return new RString("住民種別");
            }
            return RString.EMPTY;
        } else {
            return get日付タイトル3By明細行(source);
        }
    }

    private RString get日付タイトル3When抹消者名簿(ShinkiTorokushaMeiboSource source) {
        if (new RString("死亡").equals(source.subTitle)) {
            return new RString("住基届出日");
        }
        if (new RString("転出4カ月").equals(source.subTitle) || new RString("誤載").equals(source.subTitle)
                || new RString("国籍喪失").equals(source.subTitle) || new RString("職権消除").equals(source.subTitle)
                || new RString("その他").equals(source.subTitle)) {
            return new RString("表示年月日");
        }
        return RString.EMPTY;
    }

    private RString get日付タイトル3By明細行(ShinkiTorokushaMeiboSource source) {
        FlexibleDate 日付タイトル3 = FlexibleDate.EMPTY;
        if (ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title) || ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title)) {
            return this.get住民種別(宛名識別対象.get住民種別().getCode());
        } else {
            if (ReportIdKeys.新規登録者名簿.getName().equals(source.title) || ReportIdKeys.表示消除者名簿.getName().equals(source.title)
                    || ReportIdKeys.再転入者名簿.getName().equals(source.title) || ReportIdKeys.転出者名簿.getName().equals(source.title)
                    || (ReportIdKeys.職権消除者名簿.getName().equals(source.title)) || ReportIdKeys.抹消予定者名簿.getName().equals(source.title)) {
                日付タイトル3 = param.getEntity().getSenkyoShikakuEntity().getHyojiYMD();
            }
            if (ReportIdKeys.抹消者名簿.getName().equals(source.title)) {
                日付タイトル3 = get日付タイトル3BySubTitle(source);
            }
            if (ReportIdKeys.失権者名簿.getName().equals(source.title) || ReportIdKeys.表示者名簿.getName().equals(source.title)
                    || ReportIdKeys.規定年齢前名簿.getName().equals(source.title)) {
                日付タイトル3 = FlexibleDate.EMPTY;
            }
            if (ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
                日付タイトル3 = 宛名識別対象.to個人().get登録異動年月日();
            }
            return NullHandler.getNullToFlexibleDate(日付タイトル3).wareki().toDateString();
        }
    }

    private RString get日付タイトル4(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        if (ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
            if (明細種類.equals(明細見出し)) {
                return new RString("転入届出日");
            }
            return 宛名識別対象.to個人().get登録届出年月日().wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get住所() {
        RString 住登内住所 = 宛名識別対象.to個人().get住登内住所().get住所();
        RString 住登内番地 = 宛名識別対象.to個人().get住登内住所().get番地().getBanchi().value();
        RString 住登内方書 = 宛名識別対象.to個人().get住登内住所().get方書().value();
        RString 文字列 = 住登内住所.concat(住登内番地).concat(RString.FULL_SPACE).concat(住登内方書);
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(ShinkiTorokushaMeiboSource.class, new RString("listMeisai1_4"));
        List<RString> 文字List = idouSenkyoninIchiran.文字列分割(文字列, 住所最大文字数);
        return 文字List.get(0);
    }

    private RString get性別() {
        RString 性別コード = 宛名識別対象.to個人().get性別().getCode();
        if (性別コード.equals(new RString("1"))) {
            return new RString("男");
        } else if (性別コード.equals(new RString("2"))) {
            return new RString("女");
        } else {
            return RString.EMPTY;
        }
    }

    private RString get住民種別(RString 住民種別コード) {
        return JuminShubetsu.toValue(住民種別コード).toRString();
    }

    private RString get地区名(ShinkiTorokushaMeiboSource source, RString 明細種類) {
        if (!ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
            List<RString> 地区List = idouSenkyoninIchiran.is行政区_地区(toSenkyoninTohyoJokyoEntity(param.getEntity()));
            if (明細種類.equals(明細見出し)) {
                return 地区List.get(行最大値);
            } else {
                return 地区List.get(行目3);
            }
        } else if (明細種類.equals(明細見出し)) {
            return new RString("カナ氏名");
        } else {
            return 宛名識別対象.get名称().getKana().value();
        }
    }

    private RString get転出先(int 文字数) {
        RString 住所 = 宛名識別対象.get住所().get住所();
        RString 番地 = 宛名識別対象.get住所().get番地().getBanchi().value();
        RString 方書 = 宛名識別対象.get住所().get方書().value();
        RString 住民状態 = new RString("転出先");
        return this.getText(住所, 番地, 方書, 住民状態, 文字数);
    }

    private RString getText(RString 住所, RString 番地, RString 方書, RString 住民状態, int 文字数) {
        RString text = 住所.trim().concat(番地.trim()).concat(RString.FULL_SPACE).concat(方書.trim());
        if (text.length() <= 文字数) {
            text = text.padRight(文字数);
        } else {
            text = text.substring(0, 文字数);
        }
        return new RString("[").concat(住民状態).concat(RString.FULL_SPACE).concat(RStringUtil.convert半角to全角(text)).concat("]");
    }

    private RString get生年月日() {
        FlexibleDate 生年月日 = 宛名識別対象.to個人().get生年月日().toFlexibleDate();
        RString 住民種別コード = 宛名識別対象.get住民種別().getCode();
        return idouSenkyoninIchiran.get生年月日(住民種別コード, 生年月日);
    }

    private void setAllWhen空白行(ShinkiTorokushaMeiboSource source) {
        set帳票タイトルAndサブタイトル(source);
        source.chikuCodeMei = this.get地区コード名(source, 明細見出し);
        source.jushoMei = this.get住所名(source, 明細見出し);
        source.chikuMei = this.get地区名(source, 明細見出し);
        source.meisaiTitleDate1 = this.get日付タイトル１(source, 明細見出し);
        source.meisaiTitleDate2 = this.get日付タイトル2(source, 明細見出し);
        source.meisaiTitleDate3 = this.get日付タイトル3(source, 明細見出し);
        source.meisaiTitleDate4 = this.get日付タイトル4(source, 明細見出し);

        source.listMeisai1_1 = RString.EMPTY;
        source.listMeisai1_2 = RString.EMPTY;
        source.listMeisai1_3 = RString.EMPTY;
        source.listMeisai1_4 = RString.EMPTY;
        source.listMeisai1_5 = RString.EMPTY;
        source.listMeisai1_6 = RString.EMPTY;
        source.listMeisai1_7 = RString.EMPTY;
        source.listMeisai1_8 = RString.EMPTY;
        source.listMeisai1_9 = RString.EMPTY;
        source.listMeisai1_10 = RString.EMPTY;
        source.listMeisai2_1 = RString.EMPTY;
        source.listMeisai2_2 = RString.EMPTY;
        source.listMeisai2_3 = RString.EMPTY;
        source.listMeisai2_4 = RString.EMPTY;
        source.listMeisai2_5 = RString.EMPTY;
        source.listMeisai2_6 = RString.EMPTY;
        source.listMeisai2_7 = RString.EMPTY;
        source.listMeisai2_8 = RString.EMPTY;
        source.selHani = idouSenkyoninIchiran.get作成条件(帳票ID, 事由コード, toSenkyoninTohyoJokyoEntity(param.getEntity()));
    }

    private FlexibleDate get日付タイトルBy登録年月日検索基準() {
        if (BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体).equals(new RString("1"))) {
            return 宛名識別対象.to個人().get登録届出年月日();
        } else {
            return 宛名識別対象.to個人().get登録異動年月日();
        }
    }

    private FlexibleDate get日付タイトルBy消除年月日検索基準() {
        if (BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体).equals(new RString("2"))) {
            return 宛名識別対象.to個人().get消除異動年月日();
        } else {
            return 宛名識別対象.to個人().get消除届出年月日();
        }
    }

    private FlexibleDate get日付タイトル3BySubTitle(ShinkiTorokushaMeiboSource source) {
        if (new RString("死亡").equals(source.subTitle)) {
            return param.getEntity().getSenkyoShikakuEntity().getMasshoYMD();
        } else {
            return param.getEntity().getSenkyoShikakuEntity().getHyojiYMD();
        }
    }

    private void set新規登録者名簿サブタイトル(ShinkiTorokushaMeiboSource source) {
        if (事由コード.equals(JiyuCode.年齢到達.getKey())) {
            source.subTitle = new RString("年齢到達");
        } else if (事由コード.equals(JiyuCode.転入3カ月経過.getKey())) {
            source.subTitle = new RString("転入3カ月経過");
        } else if (事由コード.equals(JiyuCode.その他_登録.getKey())) {
            source.subTitle = new RString("その他");
        } else {
            source.subTitle = RString.EMPTY;
        }

    }

    private void set抹消者名簿サブタイトル(ShinkiTorokushaMeiboSource source) {
        if (事由コード.equals(JiyuCode.死亡.getKey())) {
            source.subTitle = new RString("死亡");
        } else if (事由コード.equals(JiyuCode.国籍喪失.getKey())) {
            source.subTitle = new RString("国籍喪失");
        } else if (事由コード.equals(JiyuCode.転出4カ月.getKey())) {
            source.subTitle = new RString("転出4カ月");
        } else if (事由コード.equals(JiyuCode.誤載.getKey())) {
            source.subTitle = new RString("誤載");
        } else if (事由コード.equals(JiyuCode.職権消除.getKey())) {
            source.subTitle = new RString("職権消除");
        } else if (事由コード.equals(JiyuCode.居住要件.getKey())) {
            source.subTitle = new RString("居住要件");
        } else if (事由コード.equals(JiyuCode.その他_抹消.getKey())) {
            source.subTitle = new RString("その他");
        } else {
            source.subTitle = RString.EMPTY;
        }
    }

    private void set失権者名簿サブタイトル(ShinkiTorokushaMeiboSource source) {
        if (事由コード.equals(JiyuCode._4ヶ月経過.getKey())) {
            source.subTitle = new RString("4ヶ月経過");
        } else if (事由コード.equals(JiyuCode.公民権停止.getKey())) {
            source.subTitle = new RString("公民権停止");
        } else if (事由コード.equals(JiyuCode.失権.getKey())) {
            source.subTitle = new RString("失権");
        } else if (事由コード.equals(JiyuCode.再転入_失権.getKey())) {
            source.subTitle = new RString("再転入");
        } else {
            source.subTitle = RString.EMPTY;
        }
    }

    private void set表示者名簿サブタイトル(ShinkiTorokushaMeiboSource source) {
        if (事由コード.equals(JiyuCode.再転入_表示.getKey())) {
            source.subTitle = new RString("再転入");
        } else if (事由コード.equals(JiyuCode.転出者.getKey())) {
            source.subTitle = new RString("転出者");
        } else if (事由コード.equals(JiyuCode.公民権停止者.getKey())) {
            source.subTitle = new RString("公民権停止者");
        } else {
            source.subTitle = RString.EMPTY;
        }
    }

    private FlexibleDate set日付タイトル１ByCase1(ShinkiTorokushaMeiboSource source, FlexibleDate 日付タイトル１) {
        if (ReportIdKeys.新規登録者名簿.getName().equals(source.title) || ReportIdKeys.表示消除者名簿.getName().equals(source.title)
                || ReportIdKeys.再転入者名簿.getName().equals(source.title) || ReportIdKeys.居住要件抹消者名簿.getName().equals(source.title)) {
            RString 登録事由コード = NullHandler.getNullToRString(param.getEntity().getSenkyoShikakuEntity().getTorokuJiyuCode());
            if (登録事由コード.equals(JiyuCode.転入3カ月経過.getKey())) {
                日付タイトル１ = get日付タイトルBy登録年月日検索基準();
            } else {
                日付タイトル１ = FlexibleDate.EMPTY;
            }
        }
        if (ReportIdKeys.転出者名簿.getName().equals(source.title) || ReportIdKeys.職権消除者名簿.getName().equals(source.title)) {
            日付タイトル１ = get日付タイトルBy消除年月日検索基準();
        }
        if (ReportIdKeys.規定年齢未到達者名簿.getName().equals(source.title)) {
            日付タイトル１ = get日付タイトルBy登録年月日検索基準();
        }
        if (ReportIdKeys.抹消者名簿.getName().equals(source.title)) {
            if (new RString("居住要件").equals(source.subTitle)) {
                日付タイトル１ = 宛名識別対象.to個人().get処理年月日();
            } else {
                日付タイトル１ = 宛名識別対象.to個人().get消除異動年月日();
            }
        }
        if (ReportIdKeys.失権者名簿.getName().equals(source.title)) {
            日付タイトル１ = param.getEntity().getSenkyoShikakuEntity().getHyojiYMD();
        }
        if (ReportIdKeys.抹消予定者名簿.getName().equals(source.title) || ReportIdKeys.表示者名簿.getName().equals(source.title)
                || ReportIdKeys.表示消除予定者名簿.getName().equals(source.title)) {
            日付タイトル１ = 宛名識別対象.to個人().get消除異動年月日();
        }
        if (ReportIdKeys.規定年齢前名簿.getName().equals(source.title)) {
            日付タイトル１ = 宛名識別対象.to個人().get登録届出年月日();
        }
        return NullHandler.getNullToFlexibleDate(日付タイトル１);
    }

    private void set帳票タイトルByCase1(ShinkiTorokushaMeiboSource source) {
        if (帳票ID.equals(ReportIdKeys.新規登録者名簿.value())) {
            source.title = ReportIdKeys.新規登録者名簿.getName();
            set新規登録者名簿サブタイトル(source);
        }
        if (帳票ID.equals(ReportIdKeys.抹消者名簿.value())) {
            source.title = ReportIdKeys.抹消者名簿.getName();
            set抹消者名簿サブタイトル(source);
        }
        if (帳票ID.equals(ReportIdKeys.失権者名簿.value())) {
            source.title = ReportIdKeys.失権者名簿.getName();
            set失権者名簿サブタイトル(source);
        }
        if (帳票ID.equals(ReportIdKeys.表示者名簿.value())) {
            source.title = ReportIdKeys.表示者名簿.getName();
            set表示者名簿サブタイトル(source);
        }
    }

    private void set帳票タイトルByCase2(ShinkiTorokushaMeiboSource source) {
        if (帳票ID.equals(ReportIdKeys.居住要件抹消者名簿.value())) {
            source.title = ReportIdKeys.居住要件抹消者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.抹消予定者名簿.value())) {
            source.title = ReportIdKeys.抹消予定者名簿.getName();
            source.subTitle = RString.EMPTY;
        }

        if (帳票ID.equals(ReportIdKeys.表示消除者名簿.value())) {
            source.title = ReportIdKeys.表示消除者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.表示消除予定者名簿.value())) {
            source.title = ReportIdKeys.表示消除予定者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.規定年齢前名簿.value())) {
            source.title = ReportIdKeys.規定年齢前名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.再転入者名簿.value())) {
            source.title = ReportIdKeys.再転入者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.転出者名簿.value())) {
            source.title = ReportIdKeys.転出者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.職権消除者名簿.value())) {
            source.title = ReportIdKeys.職権消除者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
        if (帳票ID.equals(ReportIdKeys.規定年齢未到達者名簿.value())) {
            source.title = ReportIdKeys.規定年齢未到達者名簿.getName();
            source.subTitle = RString.EMPTY;
        }
    }

    private void setAllWhen集計情報(ShinkiTorokushaMeiboSource source) {
        set帳票タイトルAndサブタイトル(source);
        source.chikuCodeMei = this.get地区コード名(source, 明細見出し);
        source.jushoMei = this.get住所名(source, 明細見出し);
        source.chikuMei = this.get地区名(source, 明細見出し);
        source.meisaiTitleDate1 = this.get日付タイトル１(source, 明細見出し);
        source.meisaiTitleDate2 = this.get日付タイトル2(source, 明細見出し);
        source.meisaiTitleDate3 = this.get日付タイトル3(source, 明細見出し);
        source.meisaiTitleDate4 = this.get日付タイトル4(source, 明細見出し);

        source.listMeisai1_1 = RString.EMPTY;
        source.listMeisai1_2 = RString.EMPTY;
        source.listMeisai1_3 = RString.EMPTY;
        source.listMeisai1_4 = param.get集計情報();
        source.listMeisai1_5 = RString.EMPTY;
        source.listMeisai1_6 = RString.EMPTY;
        source.listMeisai1_7 = RString.EMPTY;
        source.listMeisai1_8 = RString.EMPTY;
        source.listMeisai1_9 = RString.EMPTY;
        source.listMeisai1_10 = RString.EMPTY;
        source.listMeisai2_1 = RString.EMPTY;
        source.listMeisai2_2 = RString.EMPTY;
        source.listMeisai2_3 = RString.EMPTY;
        source.listMeisai2_4 = RString.EMPTY;
        source.listMeisai2_5 = RString.EMPTY;
        source.listMeisai2_6 = RString.EMPTY;
        source.listMeisai2_7 = RString.EMPTY;
        source.listMeisai2_8 = RString.EMPTY;
        source.selHani = idouSenkyoninIchiran.get作成条件(帳票ID, 事由コード, toSenkyoninTohyoJokyoEntity(param.getEntity()));
    }

    private SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(TorokushaMeiboEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        AfT111SenkyoEntity senkyoEntity = new AfT111SenkyoEntity();
        senkyoEntity.setKijunYMD(entity.getKijunYMD());
        senkyoJohoEntity.setShohonEntity(entity.getShohonEntity());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(senkyoEntity));
        targetEntity.setSenkyoJohoEntity(senkyoJohoEntity);
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());

        return targetEntity;
    }
}
