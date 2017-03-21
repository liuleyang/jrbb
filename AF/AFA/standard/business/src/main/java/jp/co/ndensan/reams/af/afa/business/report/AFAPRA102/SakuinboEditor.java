/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA102;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.SsnkyoShikakuKubun;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.国政選挙_地方選挙;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.憲法改正国民投票;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.抹消者;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.有権者;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.有権者_1号資格;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.有権者_2号資格;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.表示者;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun.資格なし;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA102.SakuinboSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu.外国人;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu.日本人;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * {@link SakuinboSource}を編集します。
 *
 * @reamsid_L AF-0010-036 qiuxy
 */
public class SakuinboEditor implements ISakuinboEditor {

    private static final RString 帳票タイトル_投票区別５０音選挙人索引簿 = new RString("投票区別５０音選挙人索引簿");

    private static final RString 資格_無し = new RString("無し");
    private static final RString 資格_有り = new RString("有り");
    private static final RString 資格_表示 = new RString("表示");
    private static final RString 資格_抹消 = new RString("抹消");
    private static final RString 資格_停止 = new RString("停止");

    private static final RString 符号ー = new RString("-");
    private static final int 空白埋めの２桁 = 2;
    private static final int 空白埋めの４桁 = 4;
    private static final int 空白埋めの６桁 = 6;
    private final SakuinboParam param;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    private static final Map<RString, RString> 資格_定時登録_国政選挙_地方選挙;
    private static final Map<RString, RString> 資格_国民投票;

    static {
        資格_定時登録_国政選挙_地方選挙 = new HashMap<>();
        // 1.0. 選挙資格区分 = '0':資格なしの場合、'無し'を表示する
        資格_定時登録_国政選挙_地方選挙.put(資格なし.value(), 資格_無し);
        // 1.1. 選挙資格区分 = '1':有権者の場合、'有り'を表示する
        資格_定時登録_国政選挙_地方選挙.put(有権者.value(), 資格_有り);
        // 1.2. 選挙資格区分 = '2':表示者の場合、'表示'を表示する
        資格_定時登録_国政選挙_地方選挙.put(表示者.value(), 資格_表示);
        // 1.3. 選挙資格区分 = '3':抹消者の場合、'抹消'を表示する
        資格_定時登録_国政選挙_地方選挙.put(抹消者.value(), 資格_抹消);

        資格_国民投票 = new HashMap<>();
        // 2.0. 選挙資格区分 = '0':資格なしの場合、'無し'を表示する
        資格_国民投票.put(資格なし.value(), 資格_無し);
        // 2.1. 選挙資格区分（国民投票） = '1':有権者（1号資格）、又は'2':有権者（2号資格）の場合、'有り'を表示する
        資格_国民投票.put(有権者_1号資格.value(), 資格_表示);
        資格_国民投票.put(有権者_2号資格.value(), 資格_表示);

    }

    /**
     * コンストラクタです。
     *
     * @param param {@link SakuinboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public SakuinboEditor(SakuinboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.param = param;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public SakuinboSource edit(SakuinboSource source) {
        setヘッダ(source);
        set明細(source);
        setフッタ(source);
        editログの出力(source);
        return source;
    }

    private void setヘッダ(SakuinboSource source) {
        source.headTohyokuCode = get投票区();
        source.headKana = getカナ氏名タイトル();
        source.title = 帳票共通ヘッダー.get帳票タイトル();
        source.sakuseiNichiji = 帳票共通ヘッダー.get作成日時();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
    }

    private void set明細(SakuinboSource source) {
        source.listMeisai_1 = get氏名();
        source.listMeisai_2 = getカナ氏名();
        source.listMeisai_3 = get住所();
        source.listMeisai_4 = get行政区();
        source.listMeisai_5 = get識別コード();
        source.listMeisai_6 = get届出日();
        source.listMeisai_7 = get生年月日();
        source.listMeisai_8 = get性別();
        source.listMeisai_9 = get資格();
        source.listMeisai_10 = getグループコード名称();
        source.listMeisai_11 = get名簿番号();
    }

    private void editログの出力(SakuinboSource source) {
        source.識別コード1 = param.get識別コード();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void setフッタ(SakuinboSource source) {
        source.taishoKikan = get作成条件();
    }

    private RString get投票区() {
        if (帳票タイトル_投票区別５０音選挙人索引簿.equals(帳票共通ヘッダー.get帳票タイトル())) {
            return param.get投票区コード();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get氏名() {
        AtenaMeisho 氏名 = param.get氏名();
        return null == 氏名 ? RString.EMPTY : 氏名.value();
    }

    private RString getカナ氏名() {
        AtenaKanaMeisho カナ氏名 = param.getカナ氏名();
        return null == カナ氏名 ? RString.EMPTY : カナ氏名.value();
    }

    private RString get住所() {
        return param.get住所();
    }

    private RString get行政区() {
        return param.get行政区();
    }

    private RString get識別コード() {
        return param.get識別コード().getColumnValue();
    }

    private RString get届出日() {
        FlexibleDate 届出日 = param.get届出日();
        return null == 届出日 ? RString.EMPTY : 届出日.wareki().toDateString();
    }

    private RString get性別() {
        return Gender.toValue(param.get性別コード()).getCommonName();
    }

    private RString get生年月日() {
        RString 住民種別 = param.get住民種別コード();
        FlexibleDate 生年月日 = param.get生年月日();
        if (null != 生年月日) {
            if (外国人.getCode().equals(住民種別)) {
                return 生年月日.seireki().toDateString();
            }
            if (日本人.getCode().equals(住民種別)) {
                return 生年月日.wareki().toDateString();
            }
        }
        return RString.EMPTY;
    }

    private RString get資格() {
        RString 選挙種類 = param.get選挙種類().value();
        Code 区分 = param.get資格区分();
        if (null == 区分) {
            return RString.EMPTY;
        } else {
            RString 選挙資格区分 = 区分.value();
            if (定時登録.getCode().equals(選挙種類) || 国政選挙_地方選挙.getCode().equals(選挙種類)) {
                RString 資格 = 資格_定時登録_国政選挙_地方選挙.get(選挙資格区分);
                return RString.isNullOrEmpty(資格) ? 資格_停止 : 資格;
            } else if (憲法改正国民投票.getCode().equals(選挙種類)) {
                RString 資格 = 資格_国民投票.get(選挙資格区分);
                return RString.isNullOrEmpty(資格) ? 資格_抹消 : 資格;
            }
            return RString.EMPTY;
        }
    }

    private RString get作成条件() {
        RString 抄本名 = param.get抄本名();
        FlexibleDate date1 = param.get投票日();
        FlexibleDate date2 = param.get基準日List().get(0);
        RString 基準日 = RString.EMPTY;
        RString 投票日 = RString.EMPTY;
        if (date2 != null) {
            基準日 = date2.wareki().toDateString();
        }
        if (date1 != null) {
            投票日 = date1.wareki().toDateString();
        }
        return new RStringBuilder().append(抄本名).append("（基準日:").append(基準日).append("　投票日:").append(投票日)
                .append(")").toRString();
    }

    private RString getグループコード名称() {

        if (AFAConfigKeysValue.抄本_グループコード_未使用.isEqual(ConfigKeysAFA.抄本_グループコード)) {
            return RString.EMPTY;
        } else if (AFAConfigKeysValue.抄本_グループコード_居住区分毎.isEqual(ConfigKeysAFA.抄本_グループコード)) {
            RString 住民種別 = param.get住民種別コード();
            if (日本人.getCode().equals(住民種別) || 外国人.getCode().equals(住民種別)) {
                return new RString("居住");
            } else {
                return new RString("非居住");
            }
        } else if (AFAConfigKeysValue.抄本_グループコード_資格区分毎.isEqual(ConfigKeysAFA.抄本_グループコード)) {
            return new SsnkyoShikakuKubun(param.get資格区分()).getMeisho();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get名簿番号() {
        RString 投票区コード = param.get投票区コード().padLeft(空白埋めの４桁);
        RString 冊 = param.get冊().padLeft(空白埋めの２桁);
        RString 頁 = new RStringBuilder().append(param.get頁()).toRString().padLeft(空白埋めの６桁);
        RString 行 = new RStringBuilder().append(param.get行()).toRString().padLeft(空白埋めの２桁);
        if (AFAConfigKeysValue.抄本_冊区分管理_使用しない.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            return 投票区コード.concat(符号ー).concat(頁).concat(符号ー).concat(行);
        }
        if (AFAConfigKeysValue.抄本_冊区分管理_性別を冊区分とする.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            return 投票区コード.concat(符号ー).concat(冊).concat(符号ー).concat(頁).concat(符号ー).concat(行);
        }
        return RString.EMPTY;
    }

    private RString getカナ氏名タイトル() {
        AtenaKanaMeisho カナ氏名 = param.getヘッダ_カナ氏名();
        return null == カナ氏名 || カナ氏名.isEmpty() ? RString.EMPTY : カナ氏名.value().stringAt(0);
    }

}
