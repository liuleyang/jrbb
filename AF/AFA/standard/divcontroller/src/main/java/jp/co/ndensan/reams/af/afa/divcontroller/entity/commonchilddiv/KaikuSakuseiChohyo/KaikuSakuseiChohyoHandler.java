/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区作成帳票共有子DIV
 *
 * @reamsid_L AF-0460-011 liuyj
 */
public class KaikuSakuseiChohyoHandler {

    private final KaikuSakuseiChohyoDiv div;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private final RString menuID = ViewState.getメニューID();

    /**
     * コンストラクタです。
     *
     * @param div 海区漁業調整委員会委員選挙人名簿Div
     */
    public KaikuSakuseiChohyoHandler(KaikuSakuseiChohyoDiv div) {
        this.div = div;
    }

    /**
     * 名簿基準年月日から、時点日をセットする。
     *
     * @param 名簿基準年月日 RDate
     */
    public void set時点日(RDate 名簿基準年月日) {
        div.getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().setValue(名簿基準年月日);
    }

    /**
     * 海区漁業調整委員会委員選挙人名簿作成帳票をセットする。
     *
     */
    public void initialize() {

        if (menuID.equals(new RString("AFAMNK1010"))) {
            set海区選挙人当初登録Init();
        }

        if (menuID.equals(new RString("AFAMNK1030")) || menuID.equals(new RString("AFAMNK1040"))) {
            set作成帳票Init();
        }
    }

    private void set海区選挙人当初登録Init() {
        RString 選挙人名簿抄本_海区_当初_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_選挙人名簿抄本_海区_当初, SubGyomuCode.AFA選挙本体);
        RString 登録者数リスト_海区_当初_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_登録者数リスト_海区_当初, SubGyomuCode.AFA選挙本体);

        div.getKaikuSakuseiChohyoMeiboShohon().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setDisplayNone(true);
        div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setDisplayNone(true);
        div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setDisplayNone(true);
        div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setDisplayNone(true);
        div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setDisplayNone(true);

        div.getKaikuSakuseiChohyoTorokushasuList().setDisplayNone(false);
        if (選挙人名簿抄本_海区_当初_コンフィグ.equals(ZERO)) {
            div.getKaikuSakuseiChohyoMeiboShohon().setIsPublish(false);
        } else if (選挙人名簿抄本_海区_当初_コンフィグ.equals(ONE)) {
            div.getKaikuSakuseiChohyoMeiboShohon().setIsPublish(true);
        }

        if (登録者数リスト_海区_当初_コンフィグ.equals(ZERO)) {
            div.getKaikuSakuseiChohyoTorokushasuList().setIsPublish(false);
        } else if (登録者数リスト_海区_当初_コンフィグ.equals(ONE)) {
            div.getKaikuSakuseiChohyoTorokushasuList().setIsPublish(true);
        }
    }

    private void set作成帳票Init() {
        RString 選挙人名簿抄本_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_選挙人名簿抄本_海区, SubGyomuCode.AFA選挙本体);
        RString 登録者数リスト_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_登録者数リスト_海区, SubGyomuCode.AFA選挙本体);
        RString 選挙人名簿抄本_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_選挙人名簿抄本_海区_最新化, SubGyomuCode.AFA選挙本体);
        RString 登録者数リスト_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_登録者数リスト_海区_最新化, SubGyomuCode.AFA選挙本体);
        RString 登録者名簿_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_登録者名簿_海区, SubGyomuCode.AFA選挙本体);
        RString 登録者名簿_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_登録者名簿_海区_最新化, SubGyomuCode.AFA選挙本体);
        RString 抹消者名簿_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_抹消者名簿_海区, SubGyomuCode.AFA選挙本体);
        RString 抹消者名簿_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_抹消者名簿_海区_最新化, SubGyomuCode.AFA選挙本体);
        RString 失権者名簿_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_失権者名簿_海区, SubGyomuCode.AFA選挙本体);
        RString 失権者名簿_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_失権者名簿_海区_最新化, SubGyomuCode.AFA選挙本体);
        RString 表示者名簿_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_表示者名簿_海区, SubGyomuCode.AFA選挙本体);
        RString 表示者名簿_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_表示者名簿_海区_最新化, SubGyomuCode.AFA選挙本体);
        RString 訂正者名簿_海区_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_訂正者名簿_海区, SubGyomuCode.AFA選挙本体);
        RString 訂正者名簿_海区_最新化_コンフィグ = BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_訂正者名簿_海区_最新化, SubGyomuCode.AFA選挙本体);

        List<KeyValueDataSource> list = new ArrayList<>();
        KeyValueDataSource data = new KeyValueDataSource();
        data.setKey(ONE);
        list.add(data);
        div.getKaikuSakuseiChohyoMeiboShohon().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setDisplayNone(false);
        div.getKaikuSakuseiChohyoTorokushasuList().setDisplayNone(false);
        div.getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().setDisplayNone(false);

        div.getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().setSelectedItems(list);

        if (menuID.equals(new RString("AFAMNK1030"))) {
            if (選挙人名簿抄本_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoMeiboShohon().setIsPublish(false);
            } else if (選挙人名簿抄本_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoMeiboShohon().setIsPublish(true);
            }

            if (登録者数リスト_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoTorokushasuList().setIsPublish(false);
            } else if (登録者数リスト_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoTorokushasuList().setIsPublish(true);
            }

            if (登録者名簿_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setIsPublish(false);
            } else if (登録者名簿_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setIsPublish(true);
            }
            if (抹消者名簿_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(false);
            } else if (抹消者名簿_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(true);
            }
            if (失権者名簿_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setIsPublish(false);
            } else if (失権者名簿_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setIsPublish(true);
            }
            if (表示者名簿_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setIsPublish(false);
            } else if (表示者名簿_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setIsPublish(true);
            }
            if (訂正者名簿_海区_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(false);
            } else if (訂正者名簿_海区_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(true);
            }

        }

        if (menuID.equals(new RString("AFAMNK1040"))) {
            if (選挙人名簿抄本_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoMeiboShohon().setIsPublish(false);
            } else if (選挙人名簿抄本_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoMeiboShohon().setIsPublish(true);
            }
            if (登録者数リスト_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoTorokushasuList().setIsPublish(false);
            } else if (登録者数リスト_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoTorokushasuList().setIsPublish(true);
            }
            if (登録者名簿_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setIsPublish(false);
            } else if (登録者名簿_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setIsPublish(true);
            }
            if (抹消者名簿_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(false);
            } else if (抹消者名簿_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(true);
            }
            if (失権者名簿_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setIsPublish(false);
            } else if (失権者名簿_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setIsPublish(true);
            }
            if (表示者名簿_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setIsPublish(false);
            } else if (表示者名簿_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setIsPublish(true);
            }
            if (訂正者名簿_海区_最新化_コンフィグ.equals(ZERO)) {
                div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(false);
            } else if (訂正者名簿_海区_最新化_コンフィグ.equals(ONE)) {
                div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(true);
            }
        }
    }

    /**
     * 選挙人名簿作成リストをセットする。
     *
     * @param 選挙時登録フラグ
     */
    public void edit選挙人名簿最新化(Boolean 選挙時登録フラグ) {
        if (!選挙時登録フラグ) {
            List<KeyValueDataSource> list = new ArrayList<>();
            div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setDisabledPublishCheckBox(true);
            div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setDisabledPublishCheckBox(true);
            div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setDisabledPublishCheckBox(true);
            div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setDisabledPublishCheckBox(true);
            div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setDisabledPublishCheckBox(true);
            div.getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().setDisabled(true);

            div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setIsPublish(false);
            div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(false);
            div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setIsPublish(false);
            div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setIsPublish(false);
            div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(false);
            div.getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().setSelectedItems(list);
        } else {
            div.getKaikuSakuseiChohyoIdoHyojishaMeibo().setDisabledPublishCheckBox(false);
            div.getKaikuSakuseiChohyoIdoMasshoshaMeibo().setDisabledPublishCheckBox(false);
            div.getKaikuSakuseiChohyoIdoShikkenshaMeibo().setDisabledPublishCheckBox(false);
            div.getKaikuSakuseiChohyoIdoTeiseishaMeibo().setDisabledPublishCheckBox(false);
            div.getKaikuSakuseiChohyoIdoTorokushaMeibo().setDisabledPublishCheckBox(false);
            div.getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().setDisabled(false);
        }
    }
}
