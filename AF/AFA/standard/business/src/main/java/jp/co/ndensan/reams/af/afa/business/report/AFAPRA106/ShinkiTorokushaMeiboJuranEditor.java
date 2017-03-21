/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA106;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys.抹消者名簿縦覧;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys.抹消者名簿縦覧国民;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys.新規登録者名簿縦覧;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys.新規登録者名簿縦覧国民;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig.何もしない;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig.行をマスク;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TorokuJiyuCodeKokumin;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA106.ShinkiTorokushaMeiboJuranSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * {@link ShinkiTorokushaMeiboJuranSource}を編集します。
 *
 * @reamsid_L AF-0010-040 xiaoj
 */
public class ShinkiTorokushaMeiboJuranEditor implements IShinkiTorokushaMeiboJuranEditor {

    private static final RString 出力区分_データ = new RString("データ");
    private static final RString 出力区分_空白行 = new RString("空白行");
    private static final RString 出力区分_集計行 = new RString("集計行");
    private static final RString 星 = new RString("*");
    private static final int 地区コードタイトル = 0;
    private static final int 地区コード内容 = 1;
    private static final int 地区名タイトル = 2;
    private static final int 地区名内容 = 3;
    private static final RString 項目_投票区 = new RString("listMeisai1_1");
    private static final RString 項目_住所コード = new RString("listMeisai1_2");
    private static final RString 項目_住所 = new RString("listMeisai1_3");
    private static final RString 項目_氏名 = new RString("listMeisai1_4");
    private static final RString 項目_性別 = new RString("listMeisai1_5");
    private static final RString 項目_生年月日 = new RString("listMeisai1_6");
    private static final RString 項目_日付 = new RString("listMeisai1_7");
    private static final RString 項目_地区コード名 = new RString("listMeisai2_1");
    private static final RString 項目_地区名 = new RString("listMeisai2_2");

    private final IdouSenkyoninIchiran 異動選挙人一覧;
    private final RString 帳票ID;
    private final ShinkiTorokushaMeiboJuranParameter target;
    private final TorokushaMeiboEntity 選挙人資格の情報;
    private final UaFt200FindShikibetsuTaishoEntity 宛名PSM;
    private final SenkyoninTohyoJokyoEntity 異動選挙人一覧Entity;

    /**
     * コンストラクタです。
     *
     * @param target {@link ShinkiTorokushaMeiboJuranParameter}
     */
    public ShinkiTorokushaMeiboJuranEditor(ShinkiTorokushaMeiboJuranParameter target) {
        this.target = target;
        this.選挙人資格の情報 = target.get選挙人資格の情報();
        this.帳票ID = target.get帳票共通ヘッダー().get帳票ID();
        this.異動選挙人一覧 = new IdouSenkyoninIchiran();
        this.宛名PSM = target.get選挙人資格の情報().getShikibetsuTaishoEntity();
        this.異動選挙人一覧Entity = target.toSenkyoninTohyoJokyoEntity(選挙人資格の情報);
    }

    @Override
    public ShinkiTorokushaMeiboJuranSource edit(ShinkiTorokushaMeiboJuranSource source) {
        setヘッダ(source);
        setフッタ(source);
        if ((出力区分_空白行.equals(target.get出力区分()))) {
            return source;
        } else if ((出力区分_集計行.equals(target.get出力区分()))) {
            source.listMeisai1_3 = target.get集計();
            return source;
        }
        set明細(source);
        editログの出力(source);
        return source;
    }

    private void editログの出力(ShinkiTorokushaMeiboJuranSource source) {
        source.識別コード1 = 宛名PSM.getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void set明細(ShinkiTorokushaMeiboJuranSource source) {
        RString 帳票出力方式 = target.get出力区分();
        if (何もしない.getValue().equals(帳票出力方式) || 出力区分_データ.equals(帳票出力方式)) {
            source.listMeisai1_1 = 選挙人資格の情報.getSenkyoninMeiboEntity().getTohyokuCode();
            source.listMeisai1_2 = get住所コード();
            source.listMeisai1_3 = get住所();
            source.listMeisai1_4 = get氏名();
            source.listMeisai1_5 = get性別();
            source.listMeisai1_6 = get生年月日();
            source.listMeisai1_7 = get日付();
            source.listMeisai2_1 = 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区コード内容);
            source.listMeisai2_2 = 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区名内容);
        } else if (行をマスク.getValue().equals(帳票出力方式)) {
            set出力方式(source, 星);
        } else {
            set出力方式(source, RString.HALF_SPACE);
        }
    }

    private void setフッタ(ShinkiTorokushaMeiboJuranSource source) {
        source.selHani = 異動選挙人一覧.get作成条件(帳票ID, get事由コード(), 異動選挙人一覧Entity);
    }

    private void setヘッダ(ShinkiTorokushaMeiboJuranSource source) {
        source.chikuCodeMei = 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区コードタイトル);
        source.chikuMei = 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区名タイトル);
        source.shichosonCode = target.get帳票共通ヘッダー().get市町村コード();
        source.shichosonMei = target.get帳票共通ヘッダー().get市町村名();
        source.sakuseiYmdTime = target.get帳票共通ヘッダー().get作成日時();
        source.shikibetsuCode = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getShikibetsuCode().value();
        set明細見出し(source);
    }

    private RString get住所() {
        RStringBuilder 住所文字列 = new RStringBuilder();
        RString 住所 = 宛名PSM.getJutonaiJusho();
        住所文字列.append(住所);
        AtenaBanchi 番地 = 宛名PSM.getJutonaiBanchi();
        if (null != 番地) {
            住所文字列.append(番地.value());
        }
        住所文字列.append(RString.FULL_SPACE);
        Katagaki 方書 = 宛名PSM.getJutonaiKatagaki();
        if (null != 方書) {
            住所文字列.append(方書.value());
        }
        return 住所文字列.toRString();
    }

    private RString get性別() {
        return Gender.toValue(宛名PSM.getSeibetsuCode()).getCommonName();
    }

    private RString get氏名() {
        AtenaMeisho 名称 = 宛名PSM.getMeisho();
        return null == 名称 ? RString.EMPTY : 名称.value();
    }

    private RString get生年月日() {
        RString 住民種別コード = 宛名PSM.getJuminShubetsuCode();
        FlexibleDate 生年月日 = 宛名PSM.getSeinengappiYMD();
        return 異動選挙人一覧.get生年月日(住民種別コード, 生年月日);

    }

    private RString get日付() {
        if (帳票ID.equals(抹消者名簿縦覧.value()) || 帳票ID.equals(抹消者名簿縦覧国民.value())) {
            FlexibleDate 抹消年月日 = 選挙人資格の情報.getSenkyoShikakuEntity().getMasshoYMD();
            return null == 抹消年月日 ? RString.EMPTY : 抹消年月日.wareki().toDateString();
        } else if (帳票ID.equals(新規登録者名簿縦覧.value())) {
            FlexibleDate 登録届出年月日 = 宛名PSM.getTorokuTodokedeYMD();
            return null == 登録届出年月日 ? RString.EMPTY : 登録届出年月日.wareki().toDateString();
        } else if (帳票ID.equals(新規登録者名簿縦覧国民.value())) {
            if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(target.get登録年月日検索基準国民投票用())) {
                FlexibleDate 登録届出年月日 = 宛名PSM.getTorokuTodokedeYMD();
                return null == 登録届出年月日 ? RString.EMPTY : 登録届出年月日.wareki().toDateString();
            } else {
                FlexibleDate 登録異動年月日 = 宛名PSM.getTorokuIdoYMD();
                return null == 登録異動年月日 ? RString.EMPTY : 登録異動年月日.wareki().toDateString();
            }
        } else {
            return RString.EMPTY;
        }
    }

    private void set出力方式(ShinkiTorokushaMeiboJuranSource source, RString str) {
        Map<RString, Integer> 項目map = get項目lengthMap(source);
        source.listMeisai1_1 = RString.EMPTY.padLeft(str, 項目map.get(項目_投票区));
        source.listMeisai1_2 = RString.EMPTY.padLeft(str, 項目map.get(項目_住所コード));
        source.listMeisai1_3 = RString.EMPTY.padLeft(str, 項目map.get(項目_住所));
        source.listMeisai1_4 = RString.EMPTY.padLeft(str, 項目map.get(項目_氏名));
        source.listMeisai1_5 = RString.EMPTY.padLeft(str, 項目map.get(項目_性別));
        source.listMeisai1_6 = RString.EMPTY.padLeft(str, 項目map.get(項目_生年月日));
        source.listMeisai1_7 = RString.EMPTY.padLeft(str, 項目map.get(項目_日付));
        source.listMeisai2_1 = RString.EMPTY.padLeft(str, 項目map.get(項目_地区コード名));
        source.listMeisai2_2 = RString.EMPTY.padLeft(str, 項目map.get(項目_地区名));
    }

    private void set明細見出し(ShinkiTorokushaMeiboJuranSource source) {
        RString 事由コード = get事由コード();
        if (帳票ID.equals(抹消者名簿縦覧.value()) || 帳票ID.equals(抹消者名簿縦覧国民.value())) {
            source.title = new RString("抹消者名簿（縦覧用)");
            source.subTitle = new RString("誤載");
            source.meisaiTitleYmd = new RString("抹消年月日");
        } else if (帳票ID.equals(新規登録者名簿縦覧.value())) {
            source.title = new RString("登録者名簿（縦覧用)");
            source.meisaiTitleYmd = new RString("転入届出日");
            if (JiyuCode.年齢到達.getKey().equals(事由コード)) {
                source.subTitle = JiyuCode.年齢到達.getValue();
            } else if (JiyuCode.転入3カ月経過.getKey().equals(事由コード)) {
                source.subTitle = JiyuCode.転入3カ月経過.getValue();
            } else if (JiyuCode.その他_登録.getKey().equals(事由コード)) {
                source.subTitle = JiyuCode.その他_登録.getValue();
            }
        } else if (帳票ID.equals(新規登録者名簿縦覧国民.value())) {
            source.title = new RString("補正登録者名簿（縦覧用）");
            source.meisaiTitleYmd = new RString("転入届出日");
            if (TorokuJiyuCodeKokumin.一号資格者.getCode().value().equals(事由コード)) {
                source.subTitle = TorokuJiyuCodeKokumin.一号資格者.getMeisho();
            } else if (TorokuJiyuCodeKokumin.二号資格者.getCode().value().equals(事由コード)) {
                source.subTitle = TorokuJiyuCodeKokumin.二号資格者.getMeisho();
            } else if (TorokuJiyuCodeKokumin.その他.getCode().value().equals(事由コード)) {
                source.subTitle = TorokuJiyuCodeKokumin.その他.getMeisho();
            }
        }
    }

    private RString get事由コード() {
        if (帳票ID.equals(新規登録者名簿縦覧.value()) || 帳票ID.equals(新規登録者名簿縦覧国民.value())) {
            Code コード = 選挙人資格の情報.getSenkyoShikakuEntity().getTorokuJiyuCode();
            if (null == コード) {
                return RString.EMPTY;
            } else {
                return コード.value();
            }
        }
        return RString.EMPTY;
    }

    private Map<RString, Integer> get項目lengthMap(ShinkiTorokushaMeiboJuranSource source) {
        Map<RString, Integer> map = new HashMap<>();
        try {
            map.put(項目_投票区, source.getClass()
                    .getDeclaredField(項目_投票区.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_住所コード, source.getClass()
                    .getDeclaredField(項目_住所コード.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_住所, source.getClass()
                    .getDeclaredField(項目_住所.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_氏名, source.getClass()
                    .getDeclaredField(項目_氏名.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_性別, source.getClass()
                    .getDeclaredField(項目_性別.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_生年月日, source.getClass()
                    .getDeclaredField(項目_生年月日.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_日付, source.getClass()
                    .getDeclaredField(項目_日付.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_地区コード名, source.getClass()
                    .getDeclaredField(項目_地区コード名.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_地区名, source.getClass()
                    .getDeclaredField(項目_地区名.toString()).getAnnotation(ReportItem.class).length());

        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(ShinkiTorokushaMeiboJuranEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    private RString get住所コード() {
        ChoikiCode 住登内町域コード = 宛名PSM.getJutonaiChoikiCode();
        return null == 住登内町域コード ? RString.EMPTY : 住登内町域コード.value();
    }

}
