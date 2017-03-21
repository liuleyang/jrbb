/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.yubinshikaku.YubinShikakuResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.viewbox.yubinshikaku.YubinShikakuParameter;
import jp.co.ndensan.reams.af.afa.service.yubinshikaku.YubinShikakuFinder;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 郵便等投票資格情報共有子DIVに対するコントローラです。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class YubinShikakuHandler {

    private final YubinShikakuDiv div;
    private static final int 交付日_7年後 = 7;
    private static final int 日付有効桁数 = 8;
    private final RString KEY_資格条件_身体障害者手帳 = new RString("1");
    private final RString KEY_資格条件_戦傷病者手帳 = new RString("2");
    private final RString KEY_資格条件_介護保険被保険者証 = new RString("3");

    /**
     * コンストラクタです。
     *
     * @param div 郵便等投票資格情報共有子DIV
     */
    public YubinShikakuHandler(YubinShikakuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoShurui RString
     */
    public void initialize(ShikibetsuCode shikibetsuCode, RString senkyoShurui) {
        div.setHdnIsDailog(new RString("1"));
        YubinShikakuFinder finder = YubinShikakuFinder.createInstance();
        YubinShikakuResult 郵便等投票資格情報 = finder.get郵便等投票資格情報(shikibetsuCode);
        if (null == 郵便等投票資格情報) {
            edit画面項目_データ無し(true);
            ViewStateHolder.put(YubinShikakuParameter.郵便等投票資格情報, RString.EMPTY);
        } else {
            edit画面項目_データあり(郵便等投票資格情報, true);
            ViewStateHolder.put(YubinShikakuParameter.郵便等投票資格情報, new RString(Base64Serializer.serialize(郵便等投票資格情報.serialize())));
        }
        set画面項目制御_資格登録画面();
        set画面項目制御_代理記載者情報非活性();
        div.setTxtHdnShikibetsuCode(null == shikibetsuCode ? RString.EMPTY : shikibetsuCode.getColumnValue());
        div.setTxtHdnSenkyoShurui(RString.isNullOrEmpty(senkyoShurui) ? RString.EMPTY : senkyoShurui);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 選挙種類 RString
     */
    public void load(ShikibetsuCode 識別コード, RString 選挙種類) {
        if (RString.isNullOrEmpty(div.getHdnIsDailog())) {
            YubinShikakuFinder yubinShikakuFinder = YubinShikakuFinder.createInstance();
            YubinShikakuResult result = yubinShikakuFinder.get郵便等投票資格情報(識別コード);
            if (null == result) {
                edit画面項目_データ無し(true);
                ViewStateHolder.put(YubinShikakuParameter.郵便等投票資格情報, RString.EMPTY);
            } else {
                edit画面項目_データあり(result, true);
                ViewStateHolder.put(YubinShikakuParameter.郵便等投票資格情報, new RString(Base64Serializer.serialize(result.serialize())));
            }
            set画面項目制御_資格登録画面();
            set画面項目制御_代理記載者情報非活性();
            div.setTxtHdnShikibetsuCode(null == 識別コード ? RString.EMPTY : 識別コード.getColumnValue());
            div.setTxtHdnSenkyoShurui(RString.isNullOrEmpty(選挙種類) ? RString.EMPTY : 選挙種類);
            set画面項目制御_資格登録画面以外();
        }
    }

    /**
     * 資格区分のonChangeのイベントメソッドです。
     *
     */
    public void onChange_radShikakuKubun() {
        RString 郵便等投票資格情報文字列 = ViewStateHolder.get(YubinShikakuParameter.郵便等投票資格情報, RString.class);
        if (RString.isNullOrEmpty(郵便等投票資格情報文字列)) {
            edit画面項目_データ無し(false);
        } else {
            edit画面項目_データあり(Base64Serializer.deSerialize(郵便等投票資格情報文字列.toString(), YubinShikakuResult.class), false);
        }
        if (0 == div.getRadShikakuKubun().getSelectedIndex()) {
            set画面項目制御_資格区分あり();
        } else {
            set画面項目制御_資格区分が無し();
        }
    }

    /**
     * 交付日のonBlurのイベントメソッドです。
     *
     */
    public void onBlur_txtKofuYMD() {
        RDate 交付日 = div.getTxtKofuYMD().getValue();
        if (交付日 != null) {
            div.getTxtManryoYMD().setValue(交付日.plusYear(交付日_7年後));
        }
    }

    /**
     * 「直接入力する」ボタンのonClickのイベントメソッドです。
     *
     */
    public void onClick_btnDirectInput() {
        div.getTxtDairiJuminShubetsu().clearValue();
        div.getTxtDairiShikibetsuCode().clearDomain();
        div.getTxtDairiSetaiCode().clearDomain();
        set画面項目制御_代理記載者情報活性();
    }

    /**
     * 「クリアする」ボタンのonClickのイベントメソッドです。
     *
     */
    public void onClick_btnClear() {
        div.getTxtDairiKanaShimei().clearValue();
        div.getTxtDairiSeinengappiYMD().clearValue();
        div.getTxtDairiNenrei().clearValue();
        div.getDdlDairiSeibetsu().setSelectedIndex(0);
        div.getTxtDairiJuminShubetsu().clearValue();
        div.getTxtDairiKanjiShimei().clearDomain();
        div.getTxtDairiShikibetsuCode().clearDomain();
        div.getTxtDairiSetaiCode().clearDomain();
        div.getTxtYubinNo().clearValue();
        div.getTxtDairiJusho().clearDomain();
    }

    private void edit画面項目_データ無し(boolean reset) {
        if (reset) {
            div.getRadShikakuKubun().setSelectedIndex(0);
        }
        List<RString> keys = new ArrayList<>();
        div.getChkShikakuJoken().setSelectedItemsByKey(keys);
        div.getTxtShikakuTorokuYMD().clearValue();
        div.getTxtKofuYMD().clearValue();
        div.getTxtKofuNo().clearValue();
        div.getTxtManryoYMD().clearValue();
        div.getTxtMasshoYMD().clearValue();
        div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keyList.add(new KeyValueDataSource(MALE.getCode(), MALE.getCommonName()));
        keyList.add(new KeyValueDataSource(FEMALE.getCode(), FEMALE.getCommonName()));
        div.getDdlDairiSeibetsu().setDataSource(keyList);
        div.getDdlDairiSeibetsu().setSelectedKey(RString.EMPTY);
        clear代理記載者情報();
    }

    /**
     * clear代理記載者情報のイベントメソッドです。
     *
     */
    public void clear代理記載者情報() {
        div.getTxtDairiKanaShimei().clearValue();
        div.getTxtDairiSeinengappiYMD().clearValue();
        div.getTxtDairiNenrei().clearValue();
        div.getDdlDairiSeibetsu().setSelectedIndex(0);
        div.getTxtDairiJuminShubetsu().clearValue();
        div.getTxtDairiKanjiShimei().clearDomain();
        div.getTxtDairiShikibetsuCode().clearDomain();
        div.getTxtDairiSetaiCode().clearDomain();
        div.getTxtYubinNo().clearValue();
        div.getTxtDairiJusho().clearDomain();
    }

    private void edit画面項目_データあり(YubinShikakuResult 郵便等投票資格情報, boolean reset) {
        if (reset) {
            FlexibleDate 資格抹消年月日 = 郵便等投票資格情報.get資格抹消年月日();
            FlexibleDate 資格満了年月日 = 郵便等投票資格情報.get資格満了年月日();
            if ((null != 資格抹消年月日 && !資格抹消年月日.isEmpty() && 資格抹消年月日.isBefore(FlexibleDate.getNowDate()))
                    || (null != 資格満了年月日 && !資格満了年月日.isEmpty() && 資格満了年月日.isBefore(FlexibleDate.getNowDate()))) {
                div.getRadShikakuKubun().setSelectedIndex(1);
            } else {
                div.getRadShikakuKubun().setSelectedIndex(0);
            }
        }
        List<RString> keys = new ArrayList<>();
        if (郵便等投票資格情報.is身体障害者手帳有フラグ()) {
            keys.add(KEY_資格条件_身体障害者手帳);
        }
        if (郵便等投票資格情報.is戦傷病者手帳有フラグ()) {
            keys.add(KEY_資格条件_戦傷病者手帳);
        }
        if (郵便等投票資格情報.is介護保険被保険者証有フラグ()) {
            keys.add(KEY_資格条件_介護保険被保険者証);
        }
        div.getChkShikakuJoken().setSelectedItemsByKey(keys);
        div.getTxtShikakuTorokuYMD().setValue(null == 郵便等投票資格情報.get資格登録年月日()
                || 郵便等投票資格情報.get資格登録年月日().isEmpty()
                ? null : new RDate(郵便等投票資格情報.get資格登録年月日().toString()));
        div.getTxtKofuYMD().setValue(null == 郵便等投票資格情報.get交付年月日()
                || 郵便等投票資格情報.get交付年月日().isEmpty()
                ? null : new RDate(郵便等投票資格情報.get交付年月日().toString()));
        div.getTxtKofuNo().setValue(郵便等投票資格情報.get交付番号());
        div.getTxtManryoYMD().setValue(null == 郵便等投票資格情報.get資格満了年月日()
                || 郵便等投票資格情報.get資格満了年月日().isEmpty()
                ? null : new RDate(郵便等投票資格情報.get資格満了年月日().toString()));
        div.getTxtMasshoYMD().setValue(null == 郵便等投票資格情報.get資格抹消年月日()
                || 郵便等投票資格情報.get資格抹消年月日().isEmpty()
                ? null : new RDate(郵便等投票資格情報.get資格抹消年月日().toString()));
        div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
        div.getCcdMasshoJiyu().initialize(郵便等投票資格情報.get資格抹消事由コード());
        div.getTxtDairiKanjiShimei().setDomain(郵便等投票資格情報.get代理記載者漢字氏名());
        div.getTxtDairiKanaShimei().setValue(null == 郵便等投票資格情報.get代理記載者カナ氏名()
                ? RString.EMPTY : 郵便等投票資格情報.get代理記載者カナ氏名().getColumnValue());
        div.getTxtDairiSeinengappiYMD().setValue(郵便等投票資格情報.get代理記載者生年月日());
        div.getTxtDairiNenrei().setValue(get年齢(郵便等投票資格情報.get代理記載者生年月日()));
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keyList.add(new KeyValueDataSource(MALE.getCode(), MALE.getCommonName()));
        keyList.add(new KeyValueDataSource(FEMALE.getCode(), FEMALE.getCommonName()));
        div.getDdlDairiSeibetsu().setDataSource(keyList);
        div.getDdlDairiSeibetsu().setSelectedKey(null == 郵便等投票資格情報.get代理記載者性別コード() ? RString.EMPTY : 郵便等投票資格情報.get代理記載者性別コード());
        div.getTxtDairiJuminShubetsu().clearValue();
        div.getTxtDairiShikibetsuCode().setDomain(郵便等投票資格情報.get代理記載者識別コード());
        div.getTxtDairiSetaiCode().clearDomain();
        div.getTxtYubinNo().setValue(郵便等投票資格情報.get代理記載者郵便番号());
        div.getTxtDairiJusho().setDomain(郵便等投票資格情報.get代理記載者住所());
        div.setTxtHdnAfT114Seq(new RString(郵便等投票資格情報.get不在者投票資格履歴番号().toString()));
        div.setTxtHdnAfT115Seq(new RString(郵便等投票資格情報.get郵便投票資格付随情報履歴番号().toString()));
    }

    private RString get年齢(FlexibleDate 生年月日) {
        if (null == 生年月日 || 生年月日.isEmpty() || !生年月日.isValid()) {
            return RString.EMPTY;
        }
        RDate システム日付 = RDate.getNowDate();
        int 年齢 = システム日付.getYearValue() - 生年月日.getYearValue();
        if (システム日付.getMonthValue() < 生年月日.getMonthValue()) {
            return new RString(Integer.toString(年齢 - 1));
        }
        if (システム日付.getMonthValue() > 生年月日.getMonthValue()) {
            return new RString(Integer.toString(年齢));
        }
        if (システム日付.getDayValue() < 生年月日.getDayValue()) {
            return new RString(Integer.toString(年齢 - 1));
        }
        return new RString(Integer.toString(年齢));
    }

    private void set画面項目制御_資格登録画面() {
        if (0 == div.getRadShikakuKubun().getSelectedIndex()) {
            set画面項目制御_資格区分あり();
        } else {
            set画面項目制御_資格区分が無し();
        }
        div.getRadShikakuKubun().setDisabled(Boolean.FALSE);
        div.getChkShikakuJoken().setDisabled(Boolean.FALSE);
        div.getBtnCancel().setDisplayNone(Boolean.TRUE);
        div.getBtnClear().setDisplayNone(Boolean.FALSE);
        div.getBtnDirectInput().setDisplayNone(Boolean.FALSE);
        div.getBtnSearchSimple().setDisplayNone(Boolean.FALSE);
    }

    private void set画面項目制御_資格区分あり() {
        div.getTxtShikakuTorokuYMD().setDisabled(Boolean.FALSE);
        div.getTxtKofuYMD().setDisabled(Boolean.FALSE);
        div.getTxtKofuNo().setDisabled(Boolean.FALSE);
        div.getTxtManryoYMD().setDisabled(Boolean.FALSE);
        div.getTxtShikakuTorokuYMD().setRequired(Boolean.TRUE);
        div.getTxtKofuYMD().setRequired(Boolean.TRUE);
        div.getTxtKofuNo().setRequired(Boolean.TRUE);
        div.getTxtManryoYMD().setRequired(Boolean.TRUE);
        div.getTxtMasshoYMD().setDisabled(Boolean.TRUE);
        div.getTxtMasshoYMD().setRequired(Boolean.FALSE);
        div.getCcdMasshoJiyu().setRequiredMode(Boolean.FALSE);
        div.getCcdMasshoJiyu().setReadOnlyMode(Boolean.TRUE);
    }

    private void set画面項目制御_資格区分が無し() {
        div.getTxtShikakuTorokuYMD().setDisabled(Boolean.TRUE);
        div.getTxtKofuYMD().setDisabled(Boolean.TRUE);
        div.getTxtKofuNo().setDisabled(Boolean.TRUE);
        div.getTxtManryoYMD().setDisabled(Boolean.TRUE);
        div.getTxtShikakuTorokuYMD().setRequired(Boolean.FALSE);
        div.getTxtKofuYMD().setRequired(Boolean.FALSE);
        div.getTxtKofuNo().setRequired(Boolean.FALSE);
        div.getTxtManryoYMD().setRequired(Boolean.FALSE);
        div.getTxtMasshoYMD().setDisabled(Boolean.FALSE);
        div.getTxtMasshoYMD().setRequired(Boolean.TRUE);
        div.getCcdMasshoJiyu().setRequiredMode(Boolean.TRUE);
        div.getCcdMasshoJiyu().setReadOnlyMode(Boolean.FALSE);
    }

    /**
     * 資格登録画面以外を呼び出す場合、各項目は非活性にします。
     *
     */
    public void set画面項目制御_資格登録画面以外() {
        div.getRadShikakuKubun().setDisabled(Boolean.TRUE);
        div.getChkShikakuJoken().setDisabled(Boolean.TRUE);
        div.getTxtShikakuTorokuYMD().setDisabled(Boolean.TRUE);
        div.getTxtKofuYMD().setDisabled(Boolean.TRUE);
        div.getTxtKofuNo().setDisabled(Boolean.TRUE);
        div.getTxtManryoYMD().setDisabled(Boolean.TRUE);
        div.getTxtMasshoYMD().setDisabled(Boolean.TRUE);
        div.getCcdMasshoJiyu().setReadOnlyMode(Boolean.TRUE);
        div.getBtnCancel().setDisplayNone(Boolean.FALSE);
        div.getBtnClear().setDisplayNone(Boolean.TRUE);
        div.getBtnDirectInput().setDisplayNone(Boolean.TRUE);
        div.getBtnSearchSimple().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 資格登録画面以外を呼び出す場合、各項目は非活性にします。
     *
     */
    public void set画面項目制御_代理記載者情報非活性() {
        div.getTxtDairiKanaShimei().setReadOnly(Boolean.TRUE);
        div.getTxtDairiSeinengappiYMD().setReadOnly(Boolean.TRUE);
        div.getDdlDairiSeibetsu().setDisabled(Boolean.TRUE);
        div.getTxtDairiKanjiShimei().setReadOnly(Boolean.TRUE);
        div.getTxtYubinNo().setReadOnly(Boolean.TRUE);
        div.getTxtDairiJusho().setReadOnly(Boolean.TRUE);
    }

    private void set画面項目制御_代理記載者情報活性() {
        div.getTxtDairiKanaShimei().setReadOnly(Boolean.FALSE);
        div.getTxtDairiSeinengappiYMD().setReadOnly(Boolean.FALSE);
        div.getDdlDairiSeibetsu().setDisabled(Boolean.FALSE);
        div.getTxtDairiKanjiShimei().setReadOnly(Boolean.FALSE);
        div.getTxtYubinNo().setReadOnly(Boolean.FALSE);
        div.getTxtDairiJusho().setReadOnly(Boolean.FALSE);
    }

    /**
     * 年齢計算する
     *
     */
    public void set年齢() {
        RString 生年月日 = div.getTxtDairiSeinengappiYMD().getText();
        if (RString.isNullOrEmpty(生年月日)) {
            div.getTxtDairiNenrei().setValue(RString.EMPTY);
        } else {
            if (生年月日.length() > 日付有効桁数) {
                div.getTxtDairiNenrei().setValue(get年齢(FlexibleDate.EMPTY));
            } else {
                div.getTxtDairiNenrei().setValue(get年齢(new FlexibleDate(生年月日)));
            }
        }
    }
}
