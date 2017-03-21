/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboKokuminSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 補正登録者名簿のShinkiTorokushaMeiboKokuminEditorです。
 *
 * @reamsid_L AF-0360-051 zhoujie3
 */
public class ShinkiTorokushaMeiboKokuminEditor implements IShinkiTorokushaMeiboKokuminEditor {

    private final TorokushaMeiboEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private static final RString 補正登録者名簿_タイトル = new RString("補正登録者名簿");
    private static final RString 抹消者名簿_タイトル = new RString("抹消者名簿");
    private static final RString その他の場合 = new RString("その他");
    private static final RString 死亡の場合 = new RString("死亡");
    private static final RString 転入年月日_補正登録者名簿 = new RString("転入年月日");
    private static final RString 登録年月日_補正登録者名簿 = new RString("登録年月日");
    private static final RString 表示年月日_補正登録者名簿 = new RString("表示年月日");
    private static final RString 表示年月日_抹消者名簿 = new RString("表示年月日");
    private static final RString 異動年月日_抹消者名簿 = new RString("異動年月日");
    private static final RString 転出先住所_抹消者名簿 = new RString("転出先住所");
    private static final RString 抹消年月日_抹消者名簿 = new RString("抹消年月日");
    private static final RString 住基届出日_抹消者名簿 = new RString("住基届出日");
    private static final int 最大文字数 = getItemLength(new RString("listMeisai1_4"));
    private final RString 帳票ID;
    private static final int 空白LENGTH = 60;
    private static final int 内容2 = 3;

    /**
     * コンストラクタです。
     *
     * @param entity {@link KokuminTohyojiEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ShinkiTorokushaMeiboKokuminEditor(TorokushaMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.帳票ID = entity.get帳票ID();

    }

    @Override
    public ShinkiTorokushaMeiboKokuminSource edit(ShinkiTorokushaMeiboKokuminSource source) {

        ヘッダ(source);

        明細タイトル(source);
        if (entity.get出力区分_合計行()) {
            source.listMeisai1_4 = entity.get合計();
        } else if (entity.get出力区分_空白行()) {
            get空白(source);
        } else {
            明細(source);
        }
        フッタ(source);

        return source;
    }

    private void ヘッダ(ShinkiTorokushaMeiboKokuminSource source) {
        source.title = entity.getタイトル();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時().concat("作成");
        source.subTitle = entity.getサブタイトル();
    }

    private void 明細タイトル(ShinkiTorokushaMeiboKokuminSource source) {
        List<RString> 地区名 = 地区名();
        if (補正登録者名簿_タイトル.equals(entity.getタイトル())) {
            if (その他の場合.equals(entity.getサブタイトル())) {
                source.meisaiTitleDate1 = 転入年月日_補正登録者名簿;
                source.meisaiTitleDate2 = 登録年月日_補正登録者名簿;
                source.meisaiTitleDate3 = 表示年月日_補正登録者名簿;
                source.chikuCodeMei = 地区名.get(0);
                source.jushoMei = RString.EMPTY;
                source.chikuMei = 地区名.get(2);
                source.meisaiTitleDate4 = RString.EMPTY;
            } else {
                source.meisaiTitleDate1 = 転入年月日_補正登録者名簿;
                source.meisaiTitleDate2 = 登録年月日_補正登録者名簿;
                source.meisaiTitleDate3 = RString.EMPTY;
                source.chikuCodeMei = 地区名.get(0);
                source.jushoMei = RString.EMPTY;
                source.chikuMei = 地区名.get(2);
                source.meisaiTitleDate4 = RString.EMPTY;
            }
        } else if (抹消者名簿_タイトル.equals(entity.getタイトル())) {
            if (死亡の場合.equals(entity.getサブタイトル())) {
                source.meisaiTitleDate1 = 異動年月日_抹消者名簿;
                source.meisaiTitleDate2 = 抹消年月日_抹消者名簿;
                source.meisaiTitleDate3 = 住基届出日_抹消者名簿;
                source.chikuCodeMei = 地区名.get(0);
                source.jushoMei = 転出先住所_抹消者名簿;
                source.chikuMei = 地区名.get(2);
                source.meisaiTitleDate4 = RString.EMPTY;
            } else {
                source.meisaiTitleDate1 = 異動年月日_抹消者名簿;
                source.meisaiTitleDate2 = 抹消年月日_抹消者名簿;
                source.meisaiTitleDate3 = 表示年月日_抹消者名簿;
                source.chikuCodeMei = 地区名.get(0);
                source.jushoMei = 転出先住所_抹消者名簿;
                source.chikuMei = 地区名.get(2);
                source.meisaiTitleDate4 = RString.EMPTY;
            }
        }
    }

    private void 明細(ShinkiTorokushaMeiboKokuminSource source) {
        List<RString> 地区名 = 地区名();
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity());
        RString tohyokuCode = entity.getSenkyoninMeiboEntity().getTohyokuCode();
        if (tohyokuCode != null) {
            source.listMeisai1_1 = tohyokuCode;
        }
        ChoikiCode choikiCode = entity.getShikibetsuTaishoEntity().getJutonaiChoikiCode();
        if (choikiCode != null) {
            source.listMeisai1_2 = choikiCode.getColumnValue();
        }
        SetaiCode setaiCode = entity.getShikibetsuTaishoEntity().getSetaiCode();
        if (setaiCode != null) {
            source.listMeisai1_3 = setaiCode.getColumnValue();
        }
        source.listMeisai1_4 = 住所();
        source.listMeisai1_5 = kojin.get名称().getName().getColumnValue();
        if (kojin.get性別() != null) {
            source.listMeisai1_6 = kojin.get性別().getCommonName();
        } else {
            source.listMeisai1_6 = RString.EMPTY;
        }
        source.listMeisai1_7 = 生年月日();
        if (ReportIdKeys.新規登録者名簿国民.value().equals(帳票ID)) {
            source.listMeisai1_8 = 補正登録者名簿明細項目1();
            FlexibleDate meiboTorokuYMD = entity.getSenkyoShikakuEntity().getMeiboTorokuYMD();
            source.listMeisai1_9 = meiboTorokuYMD == null ? RString.EMPTY : meiboTorokuYMD.wareki().toDateString();
            source.listMeisai1_10 = 表示年月日();
            source.listMeisai2_2 = 地区名.get(1);
            source.listMeisai2_4 = RString.EMPTY;
            source.listMeisai2_5 = 地区名.get(内容2);
        } else if (ReportIdKeys.抹消者名簿国民.value().equals(帳票ID)) {
            source.listMeisai1_8 = 抹消者名簿明細項目1();
            FlexibleDate masshoYMD = entity.getSenkyoShikakuEntity().getMasshoYMD();
            if (masshoYMD != null) {
                source.listMeisai1_9 = masshoYMD.wareki().toDateString();
            }
            source.listMeisai1_10 = 抹消年月日();
            source.listMeisai2_2 = 地区名.get(1);
            source.listMeisai2_4 = 抹消者名簿明細項目5();
            source.listMeisai2_5 = 地区名.get(内容2);
        }
        source.listMeisai2_3 = kojin.get識別コード().getColumnValue();
        source.listMeisai2_6 = kojin.get続柄();
        source.listMeisai2_7 = kojin.get世帯主名().getColumnValue();
        source.listMeisai2_8 = RString.EMPTY;
    }

    private void フッタ(ShinkiTorokushaMeiboKokuminSource source) {

        source.selHani = 作成条件();
        source.識別コード = entity.getShikibetsuTaishoEntity().getShikibetsuCode();
    }

    private List<RString> 地区名() {
        IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
        return idouSenkyoninIchiran.is行政区_地区(senkyoninTohyoJokyoEntity);
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ShinkiTorokushaMeiboKokuminSource.class, itemName);
    }

    private RString 住所() {
        IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        RStringBuilder 文字列 = new RStringBuilder();
        RString 住登内住所 = entity.getShikibetsuTaishoEntity().getJutonaiJusho();
        文字列.append(住登内住所);
        AtenaBanchi 住登内番地 = entity.getShikibetsuTaishoEntity().getJutonaiBanchi();
        Katagaki 住登内方書 = entity.getShikibetsuTaishoEntity().getJutonaiKatagaki();
        if (住登内番地 != null) {
            文字列.append(住登内番地.getColumnValue());
        }
        if (住登内方書 != null) {
            文字列.append(RString.FULL_SPACE).append(住登内方書.getColumnValue());
        }
        return idouSenkyoninIchiran.文字列分割(文字列.toRString(), 最大文字数).get(0);

    }

    private RString 生年月日() {
        IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        return idouSenkyoninIchiran.get生年月日(entity.getShikibetsuTaishoEntity().getJuminShubetsuCode(),
                entity.getShikibetsuTaishoEntity().getSeinengappiYMD());
    }

    private RString 補正登録者名簿明細項目1() {
        RString 登録事由コード = entity.getShikibetsuTaishoEntity().getTorokuJiyuCode();
        FlexibleDate 登録届出年月日 = entity.getShikibetsuTaishoEntity().getTorokuTodokedeYMD();
        FlexibleDate 登録異動年月日 = entity.getShikibetsuTaishoEntity().getTorokuIdoYMD();
        RString 登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (登録事由コード != null && 登録事由コード.equals(JukiIdoJiyu.転入.get異動事由コード())) {
            if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(登録年月日検索基準)) {
                return 登録届出年月日 != null ? 登録届出年月日.wareki().toDateString() : RString.EMPTY;
            } else if (AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(登録年月日検索基準)) {
                return 登録異動年月日 != null ? 登録異動年月日.wareki().toDateString() : RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private RString 抹消者名簿明細項目1() {
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        FlexibleDate 消除届出年月日 = entity.getShikibetsuTaishoEntity().getShojoTodokedeYMD();
        FlexibleDate 消除異動年月日 = entity.getShikibetsuTaishoEntity().getShojoIdoYMD();
        if (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)) {
            return 消除届出年月日 != null ? 消除届出年月日.wareki().toDateString() : RString.EMPTY;
        } else if (AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)) {
            return 消除異動年月日 != null ? 消除異動年月日.wareki().toDateString() : RString.EMPTY;
        } else {
            return RString.EMPTY;
        }

    }

    private RString 表示年月日() {
        FlexibleDate hyojiYMD = entity.getSenkyoShikakuEntity().getHyojiYMD();
        if (entity.getサブタイトル() != null && その他の場合.equals(entity.getサブタイトル()) && hyojiYMD != null) {
            return hyojiYMD.wareki().toDateString();
        }
        return RString.EMPTY;

    }

    private RString 抹消年月日() {
        FlexibleDate hyojiYMD = entity.getSenkyoShikakuEntity().getHyojiYMD();
        FlexibleDate masshoYMD = entity.getSenkyoShikakuEntity().getMasshoYMD();
        if (死亡の場合.equals(entity.getサブタイトル())) {
            return masshoYMD != null ? masshoYMD.wareki().toDateString() : RString.EMPTY;
        } else {
            return hyojiYMD != null ? hyojiYMD.wareki().toDateString() : RString.EMPTY;
        }

    }

    private RString 抹消者名簿明細項目5() {
        if (entity.get出力区分_合計行() || 死亡の場合.equals(entity.getサブタイトル())) {
            return RString.EMPTY;
        } else {
            RStringBuilder 転出先住所_明細項目5 = new RStringBuilder();
            AtenaJusho 住所 = entity.getShikibetsuTaishoEntity().getJusho();
            AtenaBanchi 番地 = entity.getShikibetsuTaishoEntity().getBanchi();
            Katagaki 方書 = entity.getShikibetsuTaishoEntity().getKatagaki();
            if (住所 != null) {
                転出先住所_明細項目5.append(住所.getColumnValue());
            }
            if (番地 != null) {
                転出先住所_明細項目5.append(番地.getColumnValue());
            }
            if (方書 != null) {
                転出先住所_明細項目5.append(RString.FULL_SPACE).append(方書.getColumnValue());
            }
            return new RString("[転出先").concat(転出先住所_明細項目5.toRString().padRight(空白LENGTH)).concat(new RString("]"));
        }

    }

    private RString 作成条件() {
        IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        List<AfT111SenkyoEntity> senkyoEntity = new ArrayList<>();
        if (entity.getSenkyoEntity() != null) {
            senkyoEntity.add(entity.getSenkyoEntity());
            senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(new SenkyoJohoEntity());
            senkyoninTohyoJokyoEntity.getSenkyoJohoEntity().setSenkyoEntity(senkyoEntity);
            senkyoninTohyoJokyoEntity.getSenkyoJohoEntity().setShohonEntity(entity.getShohonEntity());
            if (ReportIdKeys.新規登録者名簿国民.value().equals(帳票ID)) {
                Code 登録事由コード = entity.getSenkyoShikakuEntity().getTorokuJiyuCode();
                return 登録事由コード != null ? idouSenkyoninIchiran.get作成条件(帳票ID, 登録事由コード.getColumnValue(), senkyoninTohyoJokyoEntity) : RString.EMPTY;
            } else if (ReportIdKeys.抹消者名簿国民.value().equals(帳票ID)) {
                Code 抹消事由コード = entity.getSenkyoShikakuEntity().getMasshoJiyuCode();
                return 抹消事由コード != null ? idouSenkyoninIchiran.get作成条件(帳票ID, 抹消事由コード.getColumnValue(), senkyoninTohyoJokyoEntity) : RString.EMPTY;
            }
        }

        return RString.EMPTY;
    }

    private void get空白(ShinkiTorokushaMeiboKokuminSource source) {
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
        source.listMeisai2_2 = RString.EMPTY;
        source.listMeisai2_3 = RString.EMPTY;
        source.listMeisai2_4 = RString.EMPTY;
        source.listMeisai2_5 = RString.EMPTY;
        source.listMeisai2_6 = RString.EMPTY;
        source.listMeisai2_7 = RString.EMPTY;
        source.listMeisai2_8 = RString.EMPTY;
    }
}
