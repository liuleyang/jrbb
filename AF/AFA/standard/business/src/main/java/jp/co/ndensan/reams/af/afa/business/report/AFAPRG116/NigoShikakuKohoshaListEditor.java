/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG116;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.NigoShikakuKohoshaListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG116.NigoShikakuKohoshaListSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAPRG116_2goShikakuKohoshaList_2号資格候補者一覧表のEditorクラスです。
 *
 * @reamsid_L AF-0360-063 fulc
 */
public class NigoShikakuKohoshaListEditor implements INigoShikakuKohoshaListEditor {

    private final NigoShikakuKohoshaListEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private static final int 最大文字数 = getItemLength(new RString("listMeisai_6"));
    private final IdouSenkyoninIchiran idouSenkyoninIchiran;

    /**
     * コンストラクタです。
     *
     * @param entity NigoShikakuKohoshaListEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public NigoShikakuKohoshaListEditor(NigoShikakuKohoshaListEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.idouSenkyoninIchiran = new IdouSenkyoninIchiran();
    }

    @Override
    public NigoShikakuKohoshaListSource edit(NigoShikakuKohoshaListSource source) {
        setヘッダ(source);
        if (entity.is出力区分_空白行()) {
            set空白(source);
            if (entity.is出力区分_集計行()) {
                source.listMeisai_6 = entity.get集計();
            }
        } else {
            set明細(source);
        }

        return source;
    }

    private void setヘッダ(NigoShikakuKohoshaListSource source) {

        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時().concat("作成");
        RStringBuilder 選挙名称 = new RStringBuilder();
        選挙名称.append(entity.getSenkyoName());
        if (entity.getSenkyoCount() > 1) {
            選挙名称.append(RString.FULL_SPACE)
                    .append("他");
        }
        source.senkyoMei = 選挙名称.toRString();

    }

    private void set明細(NigoShikakuKohoshaListSource source) {

        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity());
        source.listMeisai_3 = kojin.get名称().getName().getColumnValue();
        source.listMeisai_1 = kojin.get登録事由().get異動事由正式名称();
        RString 住民種別コード = kojin.get住民種別().getCode();
        FlexibleDate 生年月日 = kojin.get生年月日().toFlexibleDate();
        source.listMeisai_4 = idouSenkyoninIchiran.get生年月日(住民種別コード, 生年月日);
        source.listMeisai_5 = kojin.get性別().getCommonName();
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
        source.listMeisai_6 = idouSenkyoninIchiran.文字列分割(住所.toRString(), 最大文字数).get(0);
        FlexibleDate 登録届出年月日 = entity.getShikibetsuTaishoEntity().getTorokuTodokedeYMD();
        FlexibleDate 登録異動年月日 = entity.getShikibetsuTaishoEntity().getTorokuIdoYMD();
        if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, RDate.getNowDate(), SubGyomuCode.AFA選挙本体))
                && 登録届出年月日 != null) {
            source.listMeisai_2 = 登録届出年月日.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        } else if (AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(BusinessConfig
                .get(ConfigKeysAFA.登録年月日検索基準, RDate.getNowDate(), SubGyomuCode.AFA選挙本体))
                && 登録異動年月日 != null) {
            source.listMeisai_2 = 登録異動年月日.wareki().eraType(EraType.KANJI_RYAKU)
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
        return ReportDataInfoLoader.getMaxLength(NigoShikakuKohoshaListSource.class, itemName);
    }

    private void set空白(NigoShikakuKohoshaListSource source) {
        source.listMeisai_1 = RString.EMPTY;
        source.listMeisai_2 = RString.EMPTY;
        source.listMeisai_3 = RString.EMPTY;
        source.listMeisai_4 = RString.EMPTY;
        source.listMeisai_5 = RString.EMPTY;
        source.listMeisai_6 = RString.EMPTY;
    }
}
