/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.MitorokushaMasshoTsuchiListSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAPRG112_2goShikakuChosahyoList_2号資格調査一覧表のEditorクラスです。
 *
 * @reamsid_L AF-0360-057 fulc
 */
public class NigoShikakuChosahyoListEditor implements INigoShikakuChosahyoListEditor {

    private final MitorokushaMasshoTsuchiListEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 帳票ID;
    private final RString 帳票タイトル;
    private static final RString 住所タイトル_2号資格調査一覧表 = new RString("転入前住所");
    private static final RString 日付タイトル_2号資格調査一覧表 = new RString("転入年月日");
    private static final int 最大文字数 = getItemLength(new RString("listMeisai_4"));

    /**
     * コンストラクタです。
     *
     * @param entity MitorokushaMasshoTsuchiListEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 帳票ID RString
     * @param 帳票タイトル RString
     */
    public NigoShikakuChosahyoListEditor(MitorokushaMasshoTsuchiListEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー,
            RString 帳票ID, RString 帳票タイトル) {
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.帳票ID = 帳票ID;
        this.帳票タイトル = 帳票タイトル;
    }

    @Override
    public MitorokushaMasshoTsuchiListSource edit(MitorokushaMasshoTsuchiListSource source) {
        setヘッダ(source);
        set明細タイトル(source);
        if (entity.is出力区分_空白行()) {
            set空白(source);
            if (entity.is出力区分_集計行()) {
                source.listMeisai_4 = entity.get集計();
            }
        } else {
            set明細(source);
        }

        return source;
    }

    private void setヘッダ(MitorokushaMasshoTsuchiListSource source) {

        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時().concat("作成");
        RStringBuilder 選挙名称 = new RStringBuilder();
        選挙名称.append(entity.getSenkyoEntity().getSenkyoName());
        if (entity.getSenkyoCount() > 1) {
            選挙名称.append(RString.FULL_SPACE)
                    .append("他");
        }
        source.senkyoMei = 選挙名称.toRString();

    }

    private void set明細タイトル(MitorokushaMasshoTsuchiListSource source) {
        source.title = 帳票タイトル;
        if (ReportIdKeys.AFAPRG112_2号資格調査一覧表.value().equals(帳票ID)) {
            source.headJushoName = 住所タイトル_2号資格調査一覧表;
            source.headYmdName = 日付タイトル_2号資格調査一覧表;
        }
    }

    private void set明細(MitorokushaMasshoTsuchiListSource source) {

        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity());
        source.listMeisai_1 = kojin.get名称().getName().getColumnValue();
        IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        RString 住民種別コード = kojin.get住民種別().getCode();
        FlexibleDate 生年月日 = kojin.get生年月日().toFlexibleDate();
        source.listMeisai_2 = idouSenkyoninIchiran.get生年月日(住民種別コード, 生年月日);
        source.listMeisai_3 = kojin.get性別().getCommonName();
        RStringBuilder 住所 = new RStringBuilder();
        AtenaJusho 転入前住所 = entity.getShikibetsuTaishoEntity().getTennyumaeJusho();
        AtenaBanchi 転入前番地 = entity.getShikibetsuTaishoEntity().getTennyumaeBanchi();
        Katagaki 転入前方書 = entity.getShikibetsuTaishoEntity().getTennyumaeKatagaki();
        if (転入前住所 != null) {
            住所.append(転入前住所.value());
        }
        if (転入前番地 != null) {
            住所.append(転入前番地.value());
        }
        住所.replace(RString.FULL_SPACE, RString.EMPTY);
        住所.replace(RString.HALF_SPACE, RString.EMPTY);
        住所.append(RString.HALF_SPACE);
        if (転入前方書 != null) {
            住所.append(転入前方書.value());
        }
        source.listMeisai_4 = idouSenkyoninIchiran.文字列分割(住所.toRString(), 最大文字数).get(0);
        FlexibleDate 登録届出年月日 = entity.getShikibetsuTaishoEntity().getTorokuTodokedeYMD();
        FlexibleDate 登録異動年月日 = entity.getShikibetsuTaishoEntity().getTorokuIdoYMD();
        if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体))
                && 登録届出年月日 != null) {
            source.listMeisai_5 = 登録届出年月日.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        } else if (AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(BusinessConfig
                .get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体))
                && 登録異動年月日 != null) {
            source.listMeisai_5 = 登録異動年月日.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        ShikibetsuCode shikibetsuCode = entity.getShikibetsuTaishoEntity().getShikibetsuCode();
        if (shikibetsuCode != null) {
            source.shikibetsuCode = shikibetsuCode.value();
        } else {
            source.shikibetsuCode = RString.EMPTY;
        }
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(MitorokushaMasshoTsuchiListSource.class, itemName);
    }

    private void set空白(MitorokushaMasshoTsuchiListSource source) {
        source.listMeisai_1 = RString.EMPTY;
        source.listMeisai_2 = RString.EMPTY;
        source.listMeisai_3 = RString.EMPTY;
        source.listMeisai_4 = RString.EMPTY;
        source.listMeisai_5 = RString.EMPTY;
    }
}
