/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA107;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig.消除届出年月日;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig.消除異動年月日;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig.登録届出年月日;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig.登録異動年月日;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA107.KikaTaishoshaListSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.住民;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link KikaTaishoshaListSource}を編集します。
 *
 * @reamsid_L AF-0010-041 xiaoj
 */
public class KikaTaishoshaListEditor implements IKikaTaishoshaListEditor {

    private static final RString 項目_住所 = new RString("listMeisai1_4");
    private static final RString 項目_氏名 = new RString("listMeisai1_5");
    private static final int 地区コードタイトル = 0;
    private static final int 地区コード内容 = 1;
    private static final int 地区名タイトル = 2;
    private static final int 地区名内容 = 3;
    private static final RString 出力区分_データ = new RString("データ");
    private static final RString 出力区分_集計行 = new RString("集計行");
    private static final CodeShubetsu 表示事由コード = new CodeShubetsu("6210");
    private static final CodeShubetsu 抹消事由コード = new CodeShubetsu("7010");

    private final UaFt200FindShikibetsuTaishoEntity 宛名PSM;
    private final FlexibleDate 帰化期間開始日;
    private final FlexibleDate 帰化期間終了日;
    private final IdouSenkyoninIchiran 異動選挙人一覧;
    private final SenkyoninTohyoJokyoEntity 異動選挙人一覧Entity;
    private final SenkyoMeiboShohonEntity 選挙人資格の情報;
    private final KikaTaishoshaListParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 選挙人資格の情報
     * @param 帰化期間開始日 FlexibleDate
     * @param 帰化期間終了日 FlexibleDate
     */
    public KikaTaishoshaListEditor(KikaTaishoshaListParameter target,
            FlexibleDate 帰化期間開始日, FlexibleDate 帰化期間終了日) {
        this.選挙人資格の情報 = target.get選挙人資格の情報();
        this.異動選挙人一覧 = new IdouSenkyoninIchiran();
        this.target = target;
        this.帰化期間終了日 = 帰化期間終了日;
        this.帰化期間開始日 = 帰化期間開始日;
        異動選挙人一覧Entity = new SenkyoninTohyoJokyoEntity();
        宛名PSM = 選挙人資格の情報.getAtenaPSMEntity();
        異動選挙人一覧Entity.setAtenaPSMEntity(宛名PSM);

    }

    @Override
    public KikaTaishoshaListSource edit(KikaTaishoshaListSource source) {
        setヘッダ(source);
        setフッタ(source);
        if (出力区分_データ.equals(target.get出力区分())) {
            set明細(source);
        } else if (出力区分_集計行.equals(target.get出力区分())) {
            set集計行(source);
        } else {
            return source;
        }
        editログの出力(source);
        return source;
    }

    private void editログの出力(KikaTaishoshaListSource source) {
        source.識別コード1 = target.get選挙人資格の情報().getAtenaPSMEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void setヘッダ(KikaTaishoshaListSource source) {
        source.kisaiYmdHani = get帳票サブタイトル(帰化期間開始日, 帰化期間終了日);
        source.chikuCodeMei = get地区コード名タイトル();
        source.chikuMei = get地区名タイトル();
        source.shichosonCode = target.get帳票共通ヘッダー().get市町村コード();
        source.shichosonMei = target.get帳票共通ヘッダー().get市町村名();
        source.sakuseiYmdTime = target.get帳票共通ヘッダー().get作成日時();
    }

    private void set明細(KikaTaishoshaListSource source) {
        source.listMeisai1_1 = get投票区();
        source.listMeisai1_2 = get住所コード();
        source.listMeisai1_3 = get世帯コード();
        set住所(source);
        set氏名(source);
        source.listMeisai1_6 = get性別();
        source.listMeisai1_7 = get生年月日();
        source.listMeisai1_8 = get住民票記載日();
        source.listMeisai1_9 = get表示年月日();
        source.listMeisai1_10 = get表示事由();
        source.listMeisai1_11 = get選挙資格();
        source.listMeisai2_1 = RString.EMPTY;
        source.listMeisai2_2 = get地区コード名();
        source.listMeisai2_3 = get識別コード();
        source.listMeisai2_6 = RString.EMPTY;
        source.listMeisai2_7 = get帰化年月日();
        source.listMeisai2_8 = get消除年月日();
        source.listMeisai2_9 = get抹消年月日();
        source.listMeisai2_10 = get抹消理由();
        source.listMeisai2_11 = get住民種別();
        source.listChiku_1 = get地区名();
    }

    private void setフッタ(KikaTaishoshaListSource source) {
        source.selHani = target.get帳票共通ヘッダー().get作成条件();
    }

    private RString get帳票サブタイトル(FlexibleDate 帰化期間開始日, FlexibleDate 帰化期間終了日) {
        return new RString("【").concat(帰化期間開始日.wareki().toDateString()).concat("～")
                .concat(帰化期間終了日.wareki().toDateString()).concat("】");
    }

    private void set住所(KikaTaishoshaListSource source) {
        int 住所のlength = get項目lengthMap(source).get(項目_住所);
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
        source.listMeisai1_4 = 異動選挙人一覧
                .文字列分割(住所文字列.toRString(), 住所のlength).get(0);
        source.listMeisai2_4 = 異動選挙人一覧
                .文字列分割(住所文字列.toRString(), 住所のlength).get(1);
    }

    private void set氏名(KikaTaishoshaListSource source) {
        int 氏名のlength = get項目lengthMap(source).get(項目_氏名);
        AtenaMeisho 名称 = 宛名PSM.getMeisho();
        if (null != 名称) {
            source.listMeisai1_5 = 異動選挙人一覧.文字列分割(名称.value(), 氏名のlength).get(0);
            source.listMeisai2_5 = 異動選挙人一覧.文字列分割(名称.value(), 氏名のlength).get(1);
        }
    }

    private RString get性別() {
        return Gender.toValue(宛名PSM.getSeibetsuCode()).getCommonName();
    }

    private RString get生年月日() {
        RString 住民種別コード = 宛名PSM.getJuminShubetsuCode();
        FlexibleDate 生年月日 = 宛名PSM.getSeinengappiYMD();
        return 異動選挙人一覧.get生年月日(住民種別コード, 生年月日);
    }

    private RString get選挙資格() {
        Code 選挙資格区分 = 選挙人資格の情報.getSenkyoShikakuEntity().getShikakuKubun();
        if (null == 選挙資格区分) {
            return 異動選挙人一覧.get選挙資格(選挙人資格の情報.getSenkyoShikakuEntity().getSenkyoShurui().value(),
                    RString.EMPTY);
        } else {
            return 異動選挙人一覧.get選挙資格(選挙人資格の情報.getSenkyoShikakuEntity().getSenkyoShurui().value(),
                    選挙資格区分.value());
        }
    }

    private RString get住民種別() {
        RString 住民状態 = 宛名PSM.getJuminJotaiCode();
        if (住民.コード().equals(住民状態) || null == 住民状態) {
            return RString.EMPTY;
        } else {
            return JuminJotai.toValue(住民状態).住民状態略称();
        }
    }

    private RString get住民票記載日() {
        RString 登録検索基準 = BusinessConfig.get(YMDKensakuKijunConfig.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (登録異動年月日.getValue().equals(登録検索基準)) {
            FlexibleDate 登録異動年月日 = 宛名PSM.getTorokuIdoYMD();
            return getパターン１Date(登録異動年月日);
        } else if (登録届出年月日.getValue().equals(登録検索基準)) {
            FlexibleDate 登録届出年月日 = 宛名PSM.getTorokuTodokedeYMD();
            return getパターン１Date(登録届出年月日);
        } else {
            return RString.EMPTY;
        }
    }

    private RString get表示事由() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, 表示事由コード,
                選挙人資格の情報.getSenkyoShikakuEntity().getHyojiJiyuCode());
    }

    private RString get消除年月日() {
        RString 消除検索基準 = BusinessConfig.get(YMDKensakuKijunConfig.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (消除異動年月日.getValue().equals(消除検索基準)) {
            FlexibleDate 消除異動年月日 = 宛名PSM.getShojoIdoYMD();
            return getパターン１Date(消除異動年月日);
        } else if (消除届出年月日.getValue().equals(消除検索基準)) {
            FlexibleDate 消除届出年月日 = 宛名PSM.getShojoTodokedeYMD();
            return getパターン１Date(消除届出年月日);
        } else {
            return RString.EMPTY;
        }
    }

    private RString get抹消理由() {
        Code 抹消理由コード = 選挙人資格の情報.getSenkyoShikakuEntity().getMasshoJiyuCode();
        if (null == 抹消理由コード || 抹消理由コード.isEmpty()) {
            return RString.EMPTY;
        }
        RString 抹消理由 = CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, 抹消事由コード,
                抹消理由コード);
        return null == 抹消理由 ? RString.EMPTY : 抹消理由;
    }

    private RString get表示年月日() {
        FlexibleDate 表示年月日 = 選挙人資格の情報.getSenkyoShikakuEntity().getHyojiYMD();
        return getパターン１Date(表示年月日);
    }

    private RString get抹消年月日() {
        FlexibleDate 抹消年月日 = 選挙人資格の情報.getSenkyoShikakuEntity().getMasshoYMD();
        return getパターン１Date(抹消年月日);
    }

    private RString get投票区() {
        return 選挙人資格の情報.getSenkyoninMeiboEntity().getTohyokuCode();
    }

    private RString get住所コード() {
        ChoikiCode 住登内町域コード = 宛名PSM.getJutonaiChoikiCode();
        return null == 住登内町域コード ? RString.EMPTY : 住登内町域コード.value();
    }

    private RString get世帯コード() {
        SetaiCode 世帯コード = 宛名PSM.getSetaiCode();
        return null == 世帯コード ? RString.EMPTY : 世帯コード.value();
    }

    private RString get帰化年月日() {
        FlexibleDate 帰化年月日 = 宛名PSM.getKikaYMD();
        return getパターン１Date(帰化年月日);
    }

    private Map<RString, Integer> get項目lengthMap(KikaTaishoshaListSource source) {
        Map<RString, Integer> map = new HashMap<>();
        try {
            map.put(項目_住所, source.getClass()
                    .getDeclaredField(項目_住所.toString()).getAnnotation(ReportItem.class).length());
            map.put(項目_氏名, source.getClass()
                    .getDeclaredField(項目_氏名.toString()).getAnnotation(ReportItem.class).length());
        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(KikaTaishoshaListEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    private RString get地区コード名タイトル() {
        return 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区コードタイトル);
    }

    private RString get地区コード名() {
        return 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区コード内容);
    }

    private RString get地区名タイトル() {
        return 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区名タイトル);
    }

    private RString get地区名() {
        return 異動選挙人一覧.is行政区_地区(異動選挙人一覧Entity).get(地区名内容);
    }

    private RString get識別コード() {
        return 選挙人資格の情報.getSenkyoninMeiboEntity().getShikibetsuCode().value();
    }

    private void set集計行(KikaTaishoshaListSource source) {
        source.listMeisai1_4 = target.get集計();
    }

    private RString getパターン１Date(FlexibleDate date) {
        if (null == date || date.isEmpty()) {
            return RString.EMPTY;
        } else {
            return date.wareki().toDateString();
        }

    }
}
