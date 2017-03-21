/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KaikuTaishoShohonJohoData;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuSenkyojiTorokuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyushaTorokuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.kaikutaishoshohonjoho.KaikuTaishoShohonJohoManager;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 海区対象抄本情報共有子Divの操作を担当するクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public class KaikuTaishoShohonJohoHandler {

    private final KaikuTaishoShohonJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 海区対象抄本情報Div
     */
    public KaikuTaishoShohonJohoHandler(KaikuTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @return boolean
     */
    public boolean initialize() {

        KaikuTaishoShohonJohoManager manager = KaikuTaishoShohonJohoManager.createInstance();
        RYear 抄本確認日 = get名簿抄本確定日();
        if (manager.get海区名簿更新日情報(抄本確認日)) {
            ViewStateHolder.put(ViewStateKeys.抄本0件チェック, SeikyushaTorokuEnum.当初登録の.getValue());
            return true;
        } else {
            RString メニューID = ResponseHolder.getMenuID();
            set初期状態(メニューID);
            ViewState.setメニューID(メニューID);
            div.getTxtShiyoShohon().setValue(get平成年度(抄本確認日).concat(KaikuSenkyojiTorokuEnum.ラベル_後.getValue()));
            div.getCcdShohonNameList().initialize(SenkyoShurui.海区漁業調整委員会委員選挙);

            if (KaikuSenkyojiTorokuEnum.メニューID_修正.getValue().equals(メニューID)
                    && div.getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                ViewStateHolder.put(ViewStateKeys.抄本0件チェック, SeikyushaTorokuEnum.再処理可能な.getValue());
                return true;
            }

            if (KaikuSenkyojiTorokuEnum.メニューID_修正.getValue().equals(メニューID)) {
                div.getCcdShohonNameList().changeDdlShohon();
                set選択抄本情報(new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo()));
            }
            return false;
        }
    }

    /**
     * 新規処理の時、画面入力内容のクリアイベントメソッドです。
     *
     */
    public void clearThisPanel() {

        div.getCcdShohonNameList().setDisabled(Boolean.TRUE);
        div.getTxtShohonName().clearValue();
        div.getTxtSenkyoName().clearValue();
        div.getTxtKijunYMD().clearValue();
        div.getTxtTohyoYMD().clearValue();
        div.getTxtTohyoUketsukeYMD().clearValue();
        div.getChkMutohyo().getSelectedItems().clear();
    }

    /**
     * 新規処理の時、画面入力内容のクリアイベントメソッドです。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set選択抄本情報(ShohonNo 抄本番号) {

        div.getCcdShohonNameList().setDisabled(false);

        KaikuTaishoShohonJohoManager manager = KaikuTaishoShohonJohoManager.createInstance();
        KaikuTaishoShohonJohoData data = manager.get日付情報(抄本番号);
        div.setHidMotoData(new RString(Base64Serializer.serialize(data)));
        div.getTxtShohonName().setValue(data.getShohonName());
        div.getTxtSenkyoName().setValue(data.getSenkyoName());
        if (null != data.getKijunYMD()) {
            div.getTxtKijunYMD().setValue(new RDate(data.getKijunYMD().toString()));
        }
        if (null != data.getTohyoYMD()) {
            div.getTxtTohyoYMD().setValue(new RDate(data.getTohyoYMD().toString()));
        }
        if (null != data.getTohyoUketsukeYMD() && !data.getTohyoUketsukeYMD().isEmpty()) {
            div.getTxtTohyoUketsukeYMD().setValue(new RDate(data.getTohyoUketsukeYMD().toString()));
        }
        if (data.isMutohyoSenkyoFlag()) {
            div.getChkMutohyo().setSelectedItemsByKey(Arrays.asList(KaikuSenkyojiTorokuEnum.チェックオン.getValue()));
        } else {
            List<RString> keys = new ArrayList<>();
            div.getChkMutohyo().setSelectedItemsByKey(keys);
        }
    }

    private RYear get名簿抄本確定日() {
        RYear システム日付 = RDate.getNowDate().getYear();
        int 今月 = RDate.getNowDate().getMonthValue();
        int 今日 = RDate.getNowDate().getDayValue();
        RYear 抄本確認日;
        if (KaikuSenkyojiTorokuEnum.本年_4月.getIntValue() <= 今月
                && KaikuSenkyojiTorokuEnum.本年_1日.getIntValue() <= 今日
                && KaikuSenkyojiTorokuEnum.本年_12月.getIntValue() >= 今月
                && KaikuSenkyojiTorokuEnum.本年_31日.getIntValue() >= 今日) {
            抄本確認日 = システム日付.minusYear(KaikuSenkyojiTorokuEnum.ONE.getIntValue());
        } else {
            抄本確認日 = システム日付.minusYear(KaikuSenkyojiTorokuEnum.TWO.getIntValue());
        }
        return 抄本確認日;
    }

    private void set初期状態(RString メニューID) {
        if (KaikuSenkyojiTorokuEnum.メニューID_登録.getValue().equals(メニューID)) {
            div.getTxtShiyoShohon().setDisabled(true);
            div.getRadShori().setSelectedKey(KaikuSenkyojiTorokuEnum.ONE.getValue());
            div.getCcdShohonNameList().setDisabled(true);
            div.getTxtShohonName().setRequired(true);
            div.getTxtSenkyoName().setRequired(true);
            div.getTxtKijunYMD().setRequired(true);
            div.getTxtTohyoYMD().setRequired(true);
            div.getTxtTohyoUketsukeYMD().setVisible(true);
            div.getTxtTohyoUketsukeYMD().setRequired(true);
            div.getChkMutohyo().setVisible(false);
        }
        if (KaikuSenkyojiTorokuEnum.メニューID_修正.getValue().equals(メニューID)) {
            div.getTxtShiyoShohon().setVisible(false);
            div.getRadShori().setVisible(false);
            div.getCcdShohonNameList().setDisabled(false);
            div.getTxtShohonName().setRequired(true);
            div.getTxtSenkyoName().setRequired(true);
            div.getTxtKijunYMD().setDisabled(true);
            div.getTxtTohyoYMD().setDisabled(true);
            div.getTxtTohyoUketsukeYMD().setVisible(true);
            div.getTxtTohyoUketsukeYMD().setRequired(true);
        }
    }

    private RString get平成年度(RYear 年度) {
        return 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
