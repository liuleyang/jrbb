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
 * 帳票設計_AFAPRG112_MitorokushaMasshoTsuchiList_未登録者抹消通知一覧表のEditorクラスです。
 *
 * @reamsid_L AF-0360-060 zhoujie3
 */
public class MitorokushaMasshoTsuchiListEditor implements IMitorokushaMasshoTsuchiListEditor {

    private final MitorokushaMasshoTsuchiListEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 帳票ID;
    private final RString 帳票タイトル;
    private static final RString 住所タイトル_未登録者抹消通知一覧表 = new RString("転入前住所");
    private static final RString 住所タイトル_国外転入者調査一覧表 = new RString("転出元住所");
    private static final RString 住所タイトル_国内転入者調査一覧表 = new RString("転出元住所");
    private static final RString 日付タイトル_未登録者抹消通知一覧表 = new RString("抹消年月日");
    private static final RString 日付タイトル_国内転入者調査一覧表 = new RString("転入年月日");
    private static final RString 日付タイトル_国外転入者調査一覧表 = new RString("転入年月日");
    private static final int 最大文字数 = ReportDataInfoLoader.getMaxLength(
            MitorokushaMasshoTsuchiListSource.class, new RString("listMeisai_4"));
    private static final RString 選挙名称_他 = new RString("　他");
    private static final RString 作成日時_作成 = new RString("作成");

    /**
     * コンストラクタです。
     *
     * @param entity MitorokushaMasshoTsuchiListEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 帳票ID RString
     * @param 帳票タイトル RString
     */
    public MitorokushaMasshoTsuchiListEditor(MitorokushaMasshoTsuchiListEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー,
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
        if (entity.is出力区分_集計行()) {
            source.listMeisai_4 = entity.get集計();
        } else if (entity.is出力区分_空白行()) {
            set空白(source);
        } else {
            set明細(source);
        }
        editログの出力(source);
        return source;
    }

    private void setヘッダ(MitorokushaMasshoTsuchiListSource source) {

        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時().concat(作成日時_作成);

        RString senkyoName = entity.getSenkyoEntity().getSenkyoName();
        if (RString.isNullOrEmpty(senkyoName)) {
            senkyoName = RString.EMPTY;
        } else if (entity.getSenkyoCount() > 1) {
            senkyoName = senkyoName.concat(選挙名称_他);
        }
        source.senkyoMei = senkyoName;

    }

    private void set明細タイトル(MitorokushaMasshoTsuchiListSource source) {
        source.title = 帳票タイトル;
        if (ReportIdKeys.未登録者抹消通知一覧表.value().equals(帳票ID)) {
            source.headJushoName = 住所タイトル_未登録者抹消通知一覧表;
            source.headYmdName = 日付タイトル_未登録者抹消通知一覧表;
        } else if (ReportIdKeys.国外転入者調査一覧表.value().equals(帳票ID)) {
            source.headJushoName = 住所タイトル_国外転入者調査一覧表;
            source.headYmdName = 日付タイトル_国内転入者調査一覧表;
        } else if (ReportIdKeys.国内転入者調査一覧表.value().equals(帳票ID)) {
            source.headJushoName = 住所タイトル_国内転入者調査一覧表;
            source.headYmdName = 日付タイトル_国外転入者調査一覧表;
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
        住所.append(RString.FULL_SPACE);
        if (転入前方書 != null) {
            住所.append(転入前方書.value());
        }
        source.listMeisai_4 = idouSenkyoninIchiran.文字列分割(住所.toRString(), 最大文字数).get(0);

        if (帳票ID.equals(ReportIdKeys.未登録者抹消通知一覧表.value())) {
            FlexibleDate 消除異動年月日 = entity.getShikibetsuTaishoEntity().getShojoIdoYMD();
            if (消除異動年月日 != null) {
                source.listMeisai_5 = get日付のフォーマット(消除異動年月日);
            }
        } else if (帳票ID.equals(ReportIdKeys.国外転入者調査一覧表.value()) || 帳票ID.equals(ReportIdKeys.国内転入者調査一覧表.value())) {
            FlexibleDate 登録届出年月日 = entity.getShikibetsuTaishoEntity().getTorokuTodokedeYMD();
            FlexibleDate 登録異動年月日 = entity.getShikibetsuTaishoEntity().getTorokuIdoYMD();

            RString 登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
            if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(登録年月日検索基準)) {
                source.listMeisai_5 = 登録届出年月日 != null ? get日付のフォーマット(登録届出年月日) : RString.EMPTY;
            } else if (AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(登録年月日検索基準)) {
                source.listMeisai_5 = 登録異動年月日 != null ? get日付のフォーマット(登録異動年月日) : RString.EMPTY;
            }

        }

    }

    private RString get日付のフォーマット(FlexibleDate 日付) {
        return 日付.wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private void set空白(MitorokushaMasshoTsuchiListSource source) {
        source.listMeisai_1 = RString.EMPTY;
        source.listMeisai_2 = RString.EMPTY;
        source.listMeisai_3 = RString.EMPTY;
        source.listMeisai_4 = RString.EMPTY;
        source.listMeisai_5 = RString.EMPTY;
    }

    private void editログの出力(MitorokushaMasshoTsuchiListSource source) {
        ShikibetsuCode shikibetsuCode = entity.getShikibetsuTaishoEntity().getShikibetsuCode();
        if (shikibetsuCode != null) {
            source.shikibetsuCode = shikibetsuCode.getColumnValue();
        }
    }

}
