/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_使用しない;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_性別を冊区分とする;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu.住登外個人_外国人;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu.外国人;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link NijuTorokuTsuchishoListSource}を編集します。
 *
 * @reamsid_L AF-0010-045 xiaoj
 */
public class NijuTorokuTsuchishoListEditor implements INijuTorokuTsuchishoListEditor {

    private static final RString 帳票タイトル_通知 = new RString("二重登録者通知一覧表");
    private static final RString 住所タイトル_通知 = new RString("転入前住所");
    private static final RString 日付タイトル_通知 = new RString("転入年月日");
    private static final RString 帳票タイトル_調査 = new RString("二重登録調査一覧表");
    private static final RString 住所タイトル_調査 = new RString("転出先住所");
    private static final RString 日付タイトル_調査 = new RString("転出年月日");
    private static final RString 帳票区分 = new RString("二重登録者通知一覧表");
    private static final RString 符号ー = new RString("-");
    private static final int 空白埋めの２桁 = 2;
    private static final int 空白埋めの４桁 = 4;
    private static final int 空白埋めの６桁 = 6;
    private static final RString 出力区分_データ = new RString("データ");
    private static final RString 出力区分_集計行 = new RString("集計行");
    private final NijuTorokuTsuchishoListParameter target;

    /**
     * コンストラクタです。
     *
     * @param target {@link NijuTorokuTsuchishoListParameter}
     */
    public NijuTorokuTsuchishoListEditor(NijuTorokuTsuchishoListParameter target) {
        this.target = target;
    }

    @Override
    public NijuTorokuTsuchishoListSource edit(NijuTorokuTsuchishoListSource source) {
        setヘッダ(source);
        if (出力区分_データ.equals(target.get出力区分())) {
            set明細(source);
        } else if (出力区分_集計行.equals(target.get出力区分())) {
            source.listMeisai_5 = target.get集計();
        } else {
            return source;
        }
        editログの出力(source);
        return source;
    }

    private void editログの出力(NijuTorokuTsuchishoListSource source) {
        if (null == target.get選挙人資格の情報()
                || null == target.get選挙人資格の情報().getAtenaPSMEntity()
                || null == target.get選挙人資格の情報().getAtenaPSMEntity().getShikibetsuCode()) {
            return;
        }
        source.識別コード1 = target.get選挙人資格の情報().getAtenaPSMEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get日付() {
        if (帳票区分.equals(target.get帳票区分())) {
            return target.toShikibetsuTaisho().to個人().get登録届出年月日().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        } else {
            return target.toShikibetsuTaisho().to個人().get消除異動年月日().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString get氏名() {
        return target.toShikibetsuTaisho().get名称().getName().value();
    }

    private RString get名簿番号() {
        RString 抄本_冊区分管理 = BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体);
        RString 投票区コード = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getTohyokuCode().padLeft(空白埋めの４桁);
        RString 冊 = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getSatsu().padLeft(空白埋めの２桁);
        RString 頁 = new RStringBuilder().append(target.get選挙人資格の情報().getSenkyoninMeiboEntity().getPage()).toRString().padLeft(空白埋めの６桁);
        RString 行 = new RStringBuilder().append(target.get選挙人資格の情報().getSenkyoninMeiboEntity().getGyo()).toRString().padLeft(空白埋めの２桁);
        if (抄本_冊区分管理_使用しない.getValue().equals(抄本_冊区分管理)) {
            return 投票区コード.concat(符号ー).concat(頁).concat(符号ー).concat(行);
        }
        if (抄本_冊区分管理_性別を冊区分とする.getValue().equals(抄本_冊区分管理)) {
            return 投票区コード.concat(符号ー).concat(冊).concat(符号ー).concat(頁).concat(符号ー).concat(行);
        }
        return RString.EMPTY;
    }

    private RString get生年月日() {
        FlexibleDate 生年月日 = target.toShikibetsuTaisho().to個人().get生年月日().toFlexibleDate();
        JuminShubetsu 住民種別 = target.toShikibetsuTaisho().to個人().get住民種別();
        if (住登外個人_外国人.equals(住民種別) || 外国人.equals(住民種別)) {
            return 生年月日.seireki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        } else {
            return 生年月日.wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString get性別() {
        return target.toShikibetsuTaisho().to個人().get性別().getCommonName();
    }

    private RString get住所() {
        RString 住所;
        RString 番地;
        RString 方書;
        if (帳票区分.equals(target.get帳票区分())) {
            住所 = target.toShikibetsuTaisho().to個人().get転入前().get住所();
            番地 = target.toShikibetsuTaisho().to個人().get転入前().get番地().getBanchi().value();
            方書 = target.toShikibetsuTaisho().to個人().get転入前().get方書().value();
        } else {
            住所 = target.toShikibetsuTaisho().to個人().get転出確定().get住所();
            番地 = target.toShikibetsuTaisho().to個人().get転出確定().get番地().getBanchi().value();
            方書 = target.toShikibetsuTaisho().to個人().get転出確定().get方書().value();
            return 住所.concat(番地).concat(RString.FULL_SPACE).concat(方書);
        }
        return 住所.concat(番地).concat(RString.FULL_SPACE).concat(方書);
    }

    private void setヘッダ(NijuTorokuTsuchishoListSource source) {
        if (帳票区分.equals(target.get帳票区分())) {
            source.title = 帳票タイトル_通知;
            source.headJushoName = 住所タイトル_通知;
            source.headYmdName = 日付タイトル_通知;
        } else {
            source.title = 帳票タイトル_調査;
            source.headJushoName = 住所タイトル_調査;
            source.headYmdName = 日付タイトル_調査;
        }
        source.shichosonMei = target.get帳票共通ヘッダー().get市町村名();
        source.shichosonCode = target.get帳票共通ヘッダー().get市町村コード();
        source.senkyoMei = target.get帳票共通ヘッダー().get選挙名称();
        source.sakuseiYmdTime = target.get帳票共通ヘッダー().get作成日時();
    }

    private void set明細(NijuTorokuTsuchishoListSource source) {
        source.listMeisai_1 = get氏名();
        source.listMeisai_2 = get名簿番号();
        source.listMeisai_3 = get生年月日();
        source.listMeisai_4 = get性別();
        source.listMeisai_5 = get住所();
        source.listMeisai_6 = get日付();
    }

}
