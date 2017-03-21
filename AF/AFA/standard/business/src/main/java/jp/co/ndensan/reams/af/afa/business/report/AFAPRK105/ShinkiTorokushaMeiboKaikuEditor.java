package jp.co.ndensan.reams.af.afa.business.report.AFAPRK105;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShinkiTorokushaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.NumberEdit;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShutsuryokuShuryohiEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyorokuKomokuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.ShinkiTorokushaMeiboKaikuRStringEnum;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 新規登録者名簿
 *
 * @reamsid_L AF-0460-034 wanghj
 */
public class ShinkiTorokushaMeiboKaikuEditor implements IShinkiTorokushaMeiboKaikuEditor {

    private final ShinkiTorokushaMeiboKaikuParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();

    /**
     * コンストラクタです。
     *
     * @param data {@link ShinkiTorokushaMeiboKaikuParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public ShinkiTorokushaMeiboKaikuEditor(ShinkiTorokushaMeiboKaikuParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 新規登録者名簿エディットメソッド
     *
     * @param source 新規登録者名簿
     * @return 新規登録者名簿
     */
    @Override
    public ShinkiTorokushaMeiboKaikuSource edit(ShinkiTorokushaMeiboKaikuSource source) {
        editヘッダ(source);
        edit改頁(source);
        if (data.getIs空白行()) {
            setAllWhen空白行(source);
            return source;
        }
        if (!data.get集計情報().isEmpty()) {
            setAllWhen集計情報(source);
            return source;
        }
        edit帳票タイトル(source);
        edit住所コード(source);
        edit明細見出し(source);
        edit世帯コード(source);
        edit住所(source);
        edit氏名(source);
        edit性別(source);
        edit生年月日(source);
        edit日付(source);
        edit住所名(source);
        edit識別コード(source);
        edit日数(source);
        edit地区(source);
        edit投票区コード(source);
        edit作成条件(source);
        editログの出力(source);
        return source;
    }

    private void setAllWhen集計情報(ShinkiTorokushaMeiboKaikuSource source) {
        edit帳票タイトル(source);
        edit明細見出し(source);

        source.listMeisai1_1 = RString.EMPTY;
        source.listMeisai1_3 = RString.EMPTY;
        source.listMeisai1_2 = RString.EMPTY;
        source.listMeisai1_4 = data.get集計情報();
        source.listMeisai1_6 = RString.EMPTY;
        source.listMeisai1_5 = RString.EMPTY;
        source.listMeisai1_7 = RString.EMPTY;
        source.listMeisai1_9 = RString.EMPTY;
        source.listMeisai1_8 = RString.EMPTY;
        source.listMeisai1_10 = RString.EMPTY;
        source.listMeisai2_2 = RString.EMPTY;
        source.listMeisai2_1 = RString.EMPTY;
        source.listMeisai2_3 = RString.EMPTY;
        source.listMeisai2_5 = RString.EMPTY;
        source.listMeisai2_4 = RString.EMPTY;
        source.listMeisai2_6 = RString.EMPTY;
        source.listMeisai2_8 = RString.EMPTY;
        source.listMeisai2_7 = RString.EMPTY;
        source.selHani = idouSenkyoninIchiran.get作成条件(data.get帳票ID(), data.get事由コード(), toSenkyoninTohyoJokyoEntity(data.getEntity()));
    }

    private void setAllWhen空白行(ShinkiTorokushaMeiboKaikuSource source) {
        edit帳票タイトル(source);
        edit明細見出し(source);
        source.listMeisai1_1 = RString.EMPTY;
        source.listMeisai1_3 = RString.EMPTY;
        source.listMeisai1_2 = RString.EMPTY;
        source.listMeisai1_4 = RString.EMPTY;
        source.listMeisai1_6 = RString.EMPTY;
        source.listMeisai1_5 = RString.EMPTY;
        source.listMeisai1_7 = RString.EMPTY;
        source.listMeisai1_9 = RString.EMPTY;
        source.listMeisai1_8 = RString.EMPTY;
        source.listMeisai1_10 = RString.EMPTY;
        source.listMeisai2_2 = RString.EMPTY;
        source.listMeisai2_3 = RString.EMPTY;
        source.listMeisai2_1 = RString.EMPTY;
        source.listMeisai2_4 = RString.EMPTY;
        source.listMeisai2_6 = RString.EMPTY;
        source.listMeisai2_5 = RString.EMPTY;
        source.listMeisai2_7 = RString.EMPTY;
        source.selHani = idouSenkyoninIchiran.get作成条件(data.get帳票ID(), data.get事由コード(), toSenkyoninTohyoJokyoEntity(data.getEntity()));
        source.listMeisai2_8 = RString.EMPTY;
    }

    private void edit地区(ShinkiTorokushaMeiboKaikuSource source) {
        source.listMeisai2_2 = get地区コード名().get(NumberEdit.固定数_１.getKey());
        source.listMeisai2_5 = get地区コード名().get(NumberEdit.固定数_３.getKey());
    }

    private void edit改頁(ShinkiTorokushaMeiboKaikuSource source) {
        source.key = data.getKey();
    }

    private List<RString> get地区コード名() {
        return idouSenkyoninIchiran.is行政区_地区(toSenkyoninTohyoJokyoEntity(data.getEntity()));
    }

    private SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(SenkyojiKaikuEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        AfT111SenkyoEntity senkyoEntity = new AfT111SenkyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoEntity.setKijunYMD(entity.getKijunYMD());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(senkyoEntity));
        senkyoJohoEntity.setShohonEntity(entity.getShohonEntity());
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
        targetEntity.setSenkyoJohoEntity(senkyoJohoEntity);

        return targetEntity;
    }

    private void edit住所名(ShinkiTorokushaMeiboKaikuSource source) {
        if (ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID())) {
            source.listMeisai2_4 = RString.EMPTY;
        } else if ((ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID()) || ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID())
                || ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID()))) {
            source.listMeisai2_4 = get住所名();
        }
    }

    private RString get住所名() {
        RString 住所名 = null;
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            RString 住登内住所 = data.getEntity().getShikibetsuTaishoEntity().getJutonaiJusho();
            AtenaBanchi jutonaiBanchi = data.getEntity().getShikibetsuTaishoEntity().getJutonaiBanchi();
            Katagaki jutonaiKatagaki = data.getEntity().getShikibetsuTaishoEntity().getJutonaiKatagaki();
            RString 住登内番地 = null == jutonaiBanchi ? RString.EMPTY : jutonaiBanchi.getColumnValue();
            RString 住登内方書 = null == jutonaiKatagaki ? RString.EMPTY : jutonaiKatagaki.getColumnValue();
            住所名 = changeNullToEmpty(住登内住所).concat(changeNullToEmpty(住登内番地))
                    .concat(ShinkiTorokushaMeiboKaikuRStringEnum.全角スペース.getKey()).concat(changeNullToEmpty(住登内方書));
        }
        return 住所名;
    }

    private void edit日付(ShinkiTorokushaMeiboKaikuSource source) {
        edit日付1(source);
        edit日付2(source);
        if ((ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID()) || ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID()))
                && null != data.getEntity() && null != data.getEntity().getSenkyoShikakuEntity()) {
            FlexibleDate 表示年月日1 = data.getEntity().getSenkyoShikakuEntity().getHyojiYMD();
            source.listMeisai1_10 = null == 表示年月日1 ? RString.EMPTY : 表示年月日1.wareki().toDateString();
        } else if ((ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID()) || ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID()))) {
            source.listMeisai1_10 = RString.EMPTY;
        }
    }

    private void edit日付1(ShinkiTorokushaMeiboKaikuSource source) {
        if (ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID()) && null != data.getEntity()
                && null != data.getEntity().getShikibetsuTaishoEntity()) {
            if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体))) {
                FlexibleDate 登録届出年月日 = data.getEntity().getShikibetsuTaishoEntity().getTorokuTodokedeYMD();
                source.listMeisai1_8 = null == 登録届出年月日 ? RString.EMPTY : 登録届出年月日.wareki().toDateString();
            } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体))) {
                FlexibleDate 登録異動年月日 = data.getEntity().getShikibetsuTaishoEntity().getTorokuIdoYMD();
                source.listMeisai1_8 = null == 登録異動年月日 ? RString.EMPTY : 登録異動年月日.wareki().toDateString();
            }
        } else if (ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID()) && null != data.getEntity()
                && null != data.getEntity().getShikibetsuTaishoEntity()) {
            if (KoteibunCode.固定文コード_０８.getCode().equals(data.get事由コード())) {
                FlexibleDate 処理年月日 = data.getEntity().getShikibetsuTaishoEntity().getShoriYMD();
                source.listMeisai1_8 = null == 処理年月日 ? RString.EMPTY : 処理年月日.wareki().toDateString();
            } else {
                FlexibleDate 消除異動年月日 = data.getEntity().getShikibetsuTaishoEntity().getShojoIdoYMD();
                source.listMeisai1_8 = null == 消除異動年月日 ? RString.EMPTY : 消除異動年月日.wareki().toDateString();
            }
        } else if ((ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID()) || ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID()))
                && null != data.getEntity() && null != data.getEntity().getSenkyoShikakuEntity()) {
            FlexibleDate 表示年月日失権 = data.getEntity().getSenkyoShikakuEntity().getHyojiYMD();
            source.listMeisai1_8 = null == 表示年月日失権 ? RString.EMPTY : 表示年月日失権.wareki().toDateString();
        }
    }

    private void edit日付2(ShinkiTorokushaMeiboKaikuSource source) {
        if (ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID()) && null != data.getEntity()
                && null != data.getEntity().getSenkyoShikakuEntity()) {
            FlexibleDate 名簿登録年月日 = data.getEntity().getSenkyoShikakuEntity().getMeiboTorokuYMD();
            source.listMeisai1_9 = null == 名簿登録年月日 ? RString.EMPTY : 名簿登録年月日.wareki().toDateString();
        } else if (ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID()) && null != data.getEntity()
                && null != data.getEntity().getSenkyoShikakuEntity()) {
            FlexibleDate 抹消年月日抹消者 = data.getEntity().getSenkyoShikakuEntity().getMeiboTorokuYMD();
            source.listMeisai1_9 = null == 抹消年月日抹消者 ? RString.EMPTY : 抹消年月日抹消者.wareki().toDateString();
        } else if ((ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID()) || ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID()))
                && null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体))) {
                FlexibleDate 消除届出年月日 = data.getEntity().getShikibetsuTaishoEntity().getShojoTodokedeYMD();
                source.listMeisai1_9 = null == 消除届出年月日 ? RString.EMPTY : 消除届出年月日.wareki().toDateString();
            } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体))) {
                FlexibleDate 消除異動年月日 = data.getEntity().getShikibetsuTaishoEntity().getShojoIdoYMD();
                source.listMeisai1_9 = null == 消除異動年月日 ? RString.EMPTY : 消除異動年月日.wareki().toDateString();
            }
        }
    }

    private void edit明細見出し(ShinkiTorokushaMeiboKaikuSource source) {
        source.chikuCodeMei = get地区コード名().get(NumberEdit.固定数_０.getKey());
        source.chikuMei = get地区コード名().get(NumberEdit.固定数_２.getKey());
        if (ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID())) {
            source.meisaiTitleDate1 = ShinkiTorokushaMeiboKaikuRStringEnum.転入年月日.getKey();
            source.meisaiTitleDate2 = ShinkiTorokushaMeiboKaikuRStringEnum.登録年月日.getKey();
            source.meisaiTitleDate3 = ShinkiTorokushaMeiboKaikuRStringEnum.表示年月日.getKey();
            source.jushoMei = RString.EMPTY;
        } else if (ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID())) {
            source.meisaiTitleDate1 = ShinkiTorokushaMeiboKaikuRStringEnum.異動年月日.getKey();
            source.meisaiTitleDate2 = ShinkiTorokushaMeiboKaikuRStringEnum.抹消年月日.getKey();
            source.jushoMei = ShinkiTorokushaMeiboKaikuRStringEnum.転出先住所.getKey();
            source.meisaiTitleDate4 = RString.EMPTY;
            if (KoteibunCode.固定文コード_０８.getCode().equals(data.get事由コード())) {
                source.meisaiTitleDate3 = RString.EMPTY;
            } else {
                source.meisaiTitleDate3 = ShinkiTorokushaMeiboKaikuRStringEnum.表示年月日.getKey();
            }
        } else if (ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID())) {
            source.meisaiTitleDate1 = ShinkiTorokushaMeiboKaikuRStringEnum.表示年月日.getKey();
            source.meisaiTitleDate2 = ShinkiTorokushaMeiboKaikuRStringEnum.転出年月日.getKey();
            source.meisaiTitleDate3 = RString.EMPTY;
            source.jushoMei = ShinkiTorokushaMeiboKaikuRStringEnum.転出先住所.getKey();
            source.meisaiTitleDate4 = RString.EMPTY;
        } else if (ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID())) {
            source.meisaiTitleDate1 = ShinkiTorokushaMeiboKaikuRStringEnum.表示年月日.getKey();
            source.meisaiTitleDate2 = ShinkiTorokushaMeiboKaikuRStringEnum.転出年月日.getKey();
            source.meisaiTitleDate3 = RString.EMPTY;
            source.jushoMei = ShinkiTorokushaMeiboKaikuRStringEnum.転出先住所.getKey();
            source.meisaiTitleDate4 = RString.EMPTY;
        }

    }

    private void editヘッダ(ShinkiTorokushaMeiboKaikuSource source) {
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void edit作成条件(ShinkiTorokushaMeiboKaikuSource source) {
        source.selHani = idouSenkyoninIchiran.get作成条件(data.get帳票ID(), data.get事由コード(), toSenkyoninTohyoJokyoEntity(data.getEntity()));
    }

    private void edit住所(ShinkiTorokushaMeiboKaikuSource source) {

        source.listMeisai1_4 = get住所名();
        if (ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID()) && null != data.get集計情報()) {
            source.listMeisai1_4 = data.get集計情報();
        } else if (ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID()) && null != data.get集計情報()) {
            source.listMeisai1_4 = data.get集計情報();
        } else if (ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID()) && null != data.get集計情報()) {
            source.listMeisai1_4 = data.get集計情報();
        } else if (ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID()) && null != data.get集計情報()) {
            source.listMeisai1_4 = data.get集計情報();
        }
    }

    private void edit帳票タイトル(ShinkiTorokushaMeiboKaikuSource source) {
        if (ReportIdKeys.新規登録者名簿海区.value().equals(data.get帳票ID())) {
            source.title = ShinkiTorokushaMeiboKaikuRStringEnum.帳票タイトル新規.getKey();
        } else if (ReportIdKeys.抹消者名簿海区.value().equals(data.get帳票ID())) {
            source.title = ShinkiTorokushaMeiboKaikuRStringEnum.帳票タイトル抹消.getKey();
            if (KoteibunCode.固定文コード_０１.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.死亡.getKey();
            } else if (KoteibunCode.固定文コード_０２.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.国籍喪失.getKey();
            } else if (KoteibunCode.固定文コード_０３.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.転出4カ月.getKey();
            } else if (KoteibunCode.固定文コード_０４.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.誤載.getKey();
            } else if (KoteibunCode.固定文コード_０７.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.職権消除.getKey();
            } else if (KoteibunCode.固定文コード_０８.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.居住要件.getKey();
            } else if (KoteibunCode.固定文コード_０９.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.その他.getKey();
            }
        } else if (ReportIdKeys.失権者名簿海区.value().equals(data.get帳票ID())) {
            source.title = ShinkiTorokushaMeiboKaikuRStringEnum.帳票タイトル失権.getKey();
            if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.経過4ヶ月.getKey();
            } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.公民権停止.getKey();
            } else if (KoteibunCode.固定文コード_０３.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.失権.getKey();
            } else if (TohyorokuKomokuShurui.決定書_判決書.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.再転入.getKey();
            }
        } else if (ReportIdKeys.表示者名簿海区.value().equals(data.get帳票ID())) {
            source.title = ShinkiTorokushaMeiboKaikuRStringEnum.帳票タイトル表示.getKey();
            if (KoteibunCode.固定文コード_０１.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.再転入.getKey();
            } else if (KoteibunCode.固定文コード_０２.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.転出者.getKey();
            } else if (KoteibunCode.固定文コード_０３.getCode().equals(data.get事由コード())) {
                source.subTitle = ShinkiTorokushaMeiboKaikuRStringEnum.公民権停止者.getKey();
            }
        }
    }

    private void editログの出力(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            source.識別コード = data.getEntity().getShikibetsuTaishoEntity().getShikibetsuCode();
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void edit日数(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getKaikuSenkyoFuzuiEntity()) {
            source.listMeisai2_6 = new RString(data.getEntity().getKaikuSenkyoFuzuiEntity().getNissuGyogyosha());
            source.listMeisai2_7 = new RString(data.getEntity().getKaikuSenkyoFuzuiEntity().getNissuJujisha());
        }
    }

    private void edit識別コード(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            ShikibetsuCode 識別コード = data.getEntity().getShikibetsuTaishoEntity().getShikibetsuCode();
            source.listMeisai2_3 = null == 識別コード ? RString.EMPTY : 識別コード.getColumnValue();
        }
    }

    private void edit生年月日(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            if (JuminShubetsu.日本人.getCode().equals(data.getEntity().getShikibetsuTaishoEntity().getJuminShubetsuCode())) {
                FlexibleDate 生年月日 = data.getEntity().getShikibetsuTaishoEntity().getSeinengappiYMD();
                source.listMeisai1_7 = null == 生年月日 ? RString.EMPTY : 生年月日.wareki().toDateString();
            }
            if (JuminShubetsu.外国人.getCode().equals(data.getEntity().getShikibetsuTaishoEntity().getJuminShubetsuCode())) {
                FlexibleDate 生年月日 = data.getEntity().getShikibetsuTaishoEntity().getSeinengappiYMD();
                source.listMeisai1_7 = null == 生年月日 ? RString.EMPTY : 生年月日.seireki().toDateString();
            }
        }
    }

    private void edit氏名(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            AtenaMeisho 名称 = data.getEntity().getShikibetsuTaishoEntity().getMeisho();
            source.listMeisai1_5 = null == 名称 ? RString.EMPTY : 名称.getColumnValue();
        }
    }

    private void edit性別(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            if (FEMALE.getCode().equals(data.getEntity().getShikibetsuTaishoEntity().getSeibetsuCode())) {
                source.listMeisai1_6 = FEMALE.getName().getShortJapanese();
            } else if (MALE.getCode().equals(data.getEntity().getShikibetsuTaishoEntity().getSeibetsuCode())) {
                source.listMeisai1_6 = MALE.getName().getShortJapanese();
            }
        }
    }

    private void edit世帯コード(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            SetaiCode 世帯コード = data.getEntity().getShikibetsuTaishoEntity().getSetaiCode();
            source.listMeisai1_3 = null == 世帯コード ? RString.EMPTY : 世帯コード.getColumnValue();
        }
    }

    private void edit住所コード(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            ChoikiCode 住登内町域コード = data.getEntity().getShikibetsuTaishoEntity().getJutonaiChoikiCode();
            source.listMeisai1_2 = null == 住登内町域コード ? RString.EMPTY : 住登内町域コード.getColumnValue();
        }
    }

    private void edit投票区コード(ShinkiTorokushaMeiboKaikuSource source) {
        if (null != data.getEntity() && null != data.getEntity().getShikibetsuTaishoEntity()) {
            TohyokuCode 投票区コード = data.getEntity().getShikibetsuTaishoEntity().getTohyokuCode();
            source.listMeisai1_1 = null == 投票区コード ? RString.EMPTY : 投票区コード.getColumnValue();
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

}
