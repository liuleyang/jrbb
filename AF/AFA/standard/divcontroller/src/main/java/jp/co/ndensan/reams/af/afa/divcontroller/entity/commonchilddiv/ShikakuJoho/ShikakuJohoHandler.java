/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.FindShikibetsuTaishoResult;
import jp.co.ndensan.reams.af.afa.business.core.shikakujoho.ShikakuJohoParameter;
import jp.co.ndensan.reams.af.afa.business.core.shikakujoho.ShikakuJohoResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuIdoShikakuIdoShoriEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.service.core.shikakujoho.ShikakuJohoManger;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ShikakuJohoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してShikakuJohoDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoHandler {

    private final ShikakuJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格情報Div
     */
    public ShikakuJohoHandler(ShikakuJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     * @param shikibetsuCode ShikibetsuCode
     */
    public void initialize(SenkyoShurui senkyoShurui, ShikibetsuCode shikibetsuCode) {
        clearThisPanel();
        div.setTxtHdnSenkyoShurui(senkyoShurui.toRString());

        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            div.getCcdMeiboTorokuJiyu().initialize(AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu(), true);
        } else {
            div.getCcdMeiboTorokuJiyu().initialize(AFACodeShubetsu.登録事由コード.getCodeShubetsu(), true);
        }

        div.getCcdTorokuTeishiJiyu().initialize(AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), true);

        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), true);
        } else if (AFAMenuId.AFAMND2040_在外選挙.menuId().equals(ResponseHolder.getMenuID())) {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), true);
        } else if (AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNC2030_南極投票資格登録.menuId().equals(ResponseHolder.getMenuID())) {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu(), true);
        } else {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), true);
        }

        if (AFAMenuId.AFAMND2040_在外選挙.menuId().equals(ResponseHolder.getMenuID())) {
            div.getCcdHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), true);
        } else {
            div.getCcdHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), true);
        }
        div.getCcdTohyokuCode().clear();
        div.getCcdTohyokuCode().initialize(senkyoShurui, true);
        ShikakuJohoManger shikakuJohoManger = ShikakuJohoManger.createInstance();
        ShikakuJohoParameter parameter = new ShikakuJohoParameter();
        parameter.setShikibetsuCode(shikibetsuCode);
        if (senkyoShurui == SenkyoShurui.国政選挙_地方選挙) {
            parameter.setWksenkyoShurui(1);
            parameter.setSenkyoShurui(new Code(KaikuIdoShikakuIdoShoriEnum.RST_0.getValue()));
        } else {
            parameter.setSenkyoShurui(new Code(senkyoShurui.getCode()));
        }

        FindShikibetsuTaishoResult result = shikakuJohoManger.get宛名識別対象(shikibetsuCode);
        List<FuzaishaShikakuResult> fuzaishaShikakuResult = new ArrayList<>();

        if (AFAMenuId.AFAMND2040_在外選挙.menuId().equals(ResponseHolder.getMenuID())) {
            ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult = shikakuJohoManger.get在外選挙資格情報(parameter);
            set在外選挙資格表示(zaigaiSenkyoShikakuResult, senkyoShurui);
            set投票資格(fuzaishaShikakuResult);
        } else {
            ShikakuJohoResult shikakuJohoResult = shikakuJohoManger.get選挙資格情報(parameter);
            set選挙資格表示(shikakuJohoResult, result, senkyoShurui);
            fuzaishaShikakuResult = shikakuJohoManger.get不在者投票資格(parameter);
            set投票資格(fuzaishaShikakuResult);
        }
        RString 検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        FlexibleDate 登録年月日 = FlexibleDate.EMPTY;
        if (検索基準.equals(KaikuIdoShikakuIdoShoriEnum.RST_1.getValue())) {
            登録年月日 = result.get宛名PSM().getTorokuTodokedeYMD();
        }
        if (検索基準.equals(KaikuIdoShikakuIdoShoriEnum.RST_2.getValue())) {
            登録年月日 = result.get宛名PSM().getTorokuIdoYMD();
        }
        if (登録年月日 != null && !登録年月日.isEmpty()) {
            div.setTxtHdnTorokuYMD(new RString(登録年月日.toString()));
        }

        setDisplayMode(senkyoShurui);
        set選挙資格状態制御(senkyoShurui);

        setHid項目(senkyoShurui, shikibetsuCode, result);

        if (AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId().equals(ResponseHolder.getMenuID())) {
            div.getRadSenkyoShikaku().setSelectedKey(KaikuIdoShikakuIdoShoriEnum.RST_3.getValue());
            div.getCcdMasshoJiyu().setDisabledMode(Boolean.FALSE);
            div.getTxtMasshoYMD().setDisabled(Boolean.FALSE);
            div.getCcdTohyokuCode().setReadOnlyMode(Boolean.TRUE);
            div.getRadSenkyoShikaku().setDisabled(Boolean.TRUE);
            div.getTxtMeiboTorokuYMD().setDisabled(Boolean.TRUE);
            div.getCcdMeiboTorokuJiyu().setDisabled(Boolean.TRUE);
        }
    }

    private void set投票資格(List<FuzaishaShikakuResult> fuzaishaShikakuResult) {
        if (null != fuzaishaShikakuResult && !fuzaishaShikakuResult.isEmpty()) {
            for (FuzaishaShikakuResult result : fuzaishaShikakuResult) {
                if (result.get投票資格種類().value().equals(KaikuIdoShikakuIdoShoriEnum.RST_1.getValue())) {
                    div.getLblTohyoShikakuShurui().setDisplayNone(false);
                    div.getBtnYubin().setDisabled(false);
                    div.getBtnYubin().setDisplayNone(false);
                }

                if (result.get投票資格種類().value().equals(KaikuIdoShikakuIdoShoriEnum.RST_2.getValue())) {
                    div.getLblTohyoShikakuShurui().setDisplayNone(false);
                    div.getBtnSenin().setDisabled(false);
                    div.getBtnSenin().setDisplayNone(false);
                }

                if (result.get投票資格種類().value().equals(KaikuIdoShikakuIdoShoriEnum.RST_3.getValue())) {
                    div.getLblTohyoShikakuShurui().setDisplayNone(false);
                    div.getBtnNankyoku().setDisabled(false);
                    div.getBtnNankyoku().setDisplayNone(false);
                }

            }
        } else {
            div.getLblTohyoShikakuShurui().setDisplayNone(true);
            div.getBtnNankyoku().setDisplayNone(true);
            div.getBtnSenin().setDisplayNone(true);
            div.getBtnYubin().setDisplayNone(true);
        }
    }

    private void set選挙資格表示(ShikakuJohoResult shikakuJohoResult, FindShikibetsuTaishoResult 識別対象s, SenkyoShurui senkyoShurui) {

        set選挙資格(senkyoShurui);

        if (shikakuJohoResult != null) {
            ViewStateHolder.put(ViewStateKeys.選挙資格情報, (Serializable) shikakuJohoResult);
            ViewStateHolder.put(ViewStateKeys.新規登録区分, false);
            if (null != shikakuJohoResult.get投票区コード() && !shikakuJohoResult.get投票区コード().isEmpty()) {
                div.getCcdTohyokuCode().initialize(shikakuJohoResult.get投票区コード());
            } else {
                if (識別対象s.get宛名PSM() != null) {
                    TohyokuCode tohyokuCode = 識別対象s.get宛名PSM().getTohyokuCode();
                    div.getCcdTohyokuCode().initialize(tohyokuCode == null ? null : tohyokuCode.getColumnValue());
                }
            }

            if (shikakuJohoResult.get名簿登録年月日() != null && shikakuJohoResult.get名簿登録年月日().isValid()) {
                div.getTxtMeiboTorokuYMD().setValue(new RDate(shikakuJohoResult.get名簿登録年月日().toString()));
            }
            div.getCcdMeiboTorokuJiyu().initialize(shikakuJohoResult.get登録事由コード());

            if (shikakuJohoResult.get登録停止年月日() != null && shikakuJohoResult.get登録停止年月日().isValid()) {
                div.getTxtTorokuTeishiYMD().setValue(new RDate(shikakuJohoResult.get登録停止年月日().toString()));
            }

            div.getCcdTorokuTeishiJiyu().initialize(shikakuJohoResult.get登録停止事由コード());

            if (shikakuJohoResult.get抹消年月日() != null && shikakuJohoResult.get抹消年月日().isValid()) {
                div.getTxtMasshoYMD().setValue(new RDate(shikakuJohoResult.get抹消年月日().toString()));
            }

            div.getCcdMasshoJiyu().initialize(shikakuJohoResult.get抹消事由コード());
            if (shikakuJohoResult.get表示年月日() != null && shikakuJohoResult.get表示年月日().isValid()) {
                div.getTxtHyojiYMD().setValue(new RDate(shikakuJohoResult.get表示年月日().toString()));
            }

            div.getCcdHyojiJiyu().initialize(shikakuJohoResult.get表示事由コード());

            if (SennkyoSikakuKubun.資格なし.value().equals(shikakuJohoResult.get選挙資格区分().value())) {
                div.getRadSenkyoShikaku().clearSelectedItem();
            }else{
                div.getRadSenkyoShikaku().setSelectedKey(shikakuJohoResult.get選挙資格区分().value());
            }

            if (shikakuJohoResult.get表示消除予定年月日() != null && shikakuJohoResult.get表示消除予定年月日().isValid()) {
                div.getTxtHyojiShojoYoteiYMD().setValue(new RDate(shikakuJohoResult.get表示消除予定年月日().toString()));
            }

            if (shikakuJohoResult.get表示消除年月日() != null && shikakuJohoResult.get表示消除年月日().isValid()) {
                div.getTxtHyojiShojoYMD().setValue(new RDate(shikakuJohoResult.get表示消除年月日().toString()));
            }

            if (shikakuJohoResult.get刑期終了年月日() != null && shikakuJohoResult.get刑期終了年月日().isValid()) {
                div.getTxtKeikiShuryoYMD().setValue(new RDate(shikakuJohoResult.get刑期終了年月日().toString()));
            }

            List<RString> rst = new ArrayList<>();
            if (shikakuJohoResult.is2刑持ちフラグ()) {
                rst.add(new RString("1"));
                div.getChk2keiMochi().setSelectedItemsByKey(rst);
            } else {
                div.getChk2keiMochi().setSelectedItemsByKey(rst);
            }

        } else {
            ViewStateHolder.put(ViewStateKeys.新規登録区分, true);
            if (識別対象s.get宛名PSM() != null) {
                TohyokuCode tohyokuCode = 識別対象s.get宛名PSM().getTohyokuCode();
                div.getCcdTohyokuCode().initialize(tohyokuCode == null ? null : tohyokuCode.getColumnValue());
            }
        }

    }

    private void set在外選挙資格表示(ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult, SenkyoShurui senkyoShurui) {

        set選挙資格(senkyoShurui);

        if (zaigaiSenkyoShikakuResult != null) {
            ViewStateHolder.put(ViewStateKeys.在外選挙資格情報, (Serializable) zaigaiSenkyoShikakuResult);
            if (null != zaigaiSenkyoShikakuResult.get投票区コード() && !zaigaiSenkyoShikakuResult.get投票区コード().isEmpty()) {
                div.getCcdTohyokuCode().initialize(zaigaiSenkyoShikakuResult.get投票区コード());
            }

            if (null != zaigaiSenkyoShikakuResult.get選挙資格区分()) {
                div.getRadSenkyoShikaku().setSelectedKey(zaigaiSenkyoShikakuResult.get選挙資格区分().value());
            }

            if (zaigaiSenkyoShikakuResult.get名簿登録年月日() != null && zaigaiSenkyoShikakuResult.get名簿登録年月日().isValid()) {
                div.getTxtMeiboTorokuYMD().setValue(new RDate(zaigaiSenkyoShikakuResult.get名簿登録年月日().toString()));
            }

            if (zaigaiSenkyoShikakuResult.get抹消年月日() != null && zaigaiSenkyoShikakuResult.get抹消年月日().isValid()) {
                div.getTxtMasshoYMD().setValue(new RDate(zaigaiSenkyoShikakuResult.get抹消年月日().toString()));
            }
            div.getCcdMasshoJiyu().initialize(zaigaiSenkyoShikakuResult.get抹消事由コード());

            if (zaigaiSenkyoShikakuResult.get表示年月日() != null && zaigaiSenkyoShikakuResult.get表示年月日().isValid()) {
                div.getTxtHyojiYMD().setValue(new RDate(zaigaiSenkyoShikakuResult.get表示年月日().toString()));
            }

            div.getCcdHyojiJiyu().initialize(zaigaiSenkyoShikakuResult.get表示事由コード());
        }
    }

    private void set選挙資格(SenkyoShurui senkyoShurui) {
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
            List<KeyValueDataSource> keyList = new ArrayList<>();
            for (UzT0007CodeEntity entity : codeEntity) {
                if (!KaikuIdoShikakuIdoShoriEnum.RST_0.getValue().equals(entity.getコード().value())) {
                    keyList.add(new KeyValueDataSource(entity.getコード().value(), entity.getコード名称()));
                }
            }
            div.getRadSenkyoShikaku().setDataSource(keyList);
        } else {
            List<UzT0007CodeEntity> codeEntity = CodeMaster.getCode(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
            List<KeyValueDataSource> keyList = new ArrayList<>();
            for (UzT0007CodeEntity entity : codeEntity) {
                if (!KaikuIdoShikakuIdoShoriEnum.RST_0.getValue().equals(entity.getコード().value())) {
                    keyList.add(new KeyValueDataSource(entity.getコード().value(), entity.getコード名称()));
                }
            }
            div.getRadSenkyoShikaku().setDataSource(keyList);
        }
    }

    private void setDisplayMode(SenkyoShurui senkyoShurui) {
        div.getCcdTohyokuCode().setDisabled(true);
        div.getRadSenkyoShikaku().setDisabled(false);
        div.getCcdMeiboTorokuJiyu().setDisabled(false);
        div.getTxtMeiboTorokuYMD().setDisabled(false);

        if (AFAMenuId.AFAMND2040_在外選挙.menuId().equals(ResponseHolder.getMenuID())) {
            div.getCcdMeiboTorokuJiyu().setDisplayNone(true);
            div.getTxtTorokuTeishiYMD().setDisplayNone(true);
            div.getCcdTorokuTeishiJiyu().setDisplayNone(true);
            div.getTxtHyojiShojoYoteiYMD().setDisplayNone(true);
            div.getTxtHyojiShojoYMD().setDisplayNone(true);
            div.getTxtKeikiShuryoYMD().setDisplayNone(true);
            div.getChk2keiMochi().setDisplayNone(true);
        } else {
            if (senkyoShurui == SenkyoShurui.憲法改正国民投票 || senkyoShurui == SenkyoShurui.海区漁業調整委員会委員選挙) {
                div.getTxtTorokuTeishiYMD().setDisplayNone(true);
                div.getCcdTorokuTeishiJiyu().setDisplayNone(true);
                div.getTxtHyojiYMD().setDisplayNone(true);
                div.getCcdHyojiJiyu().setDisplayNone(true);
                div.getTxtHyojiShojoYoteiYMD().setDisplayNone(true);
                div.getTxtHyojiShojoYMD().setDisplayNone(true);
                div.getTxtKeikiShuryoYMD().setDisplayNone(true);
                div.getChk2keiMochi().setDisplayNone(true);
            }
        }

    }

    private void setHid項目(SenkyoShurui senkyoShurui, ShikibetsuCode shikibetsuCode, FindShikibetsuTaishoResult result) {
        div.setTxtHdnSenkyoShurui(senkyoShurui.toRString());
        div.setTxtHdnShikibetsuCode(shikibetsuCode.value());
        if (result != null && result.get宛名PSM() != null) {
            div.setTxtHdnjuminShubetsuCode(result.get宛名PSM().getJuminShubetsuCode());
            div.setTxtHdnjuminJotaiCode(result.get宛名PSM().getJuminJotaiCode());
            FlexibleDate 年月日 = result.get宛名PSM().getSeinengappiYMD();
            div.setTxtHdnSeinengappiYMD(null == 年月日 ? RString.EMPTY
                    : new RString(年月日.toString()));

            if (result.get宛名PSM() != null) {
                FlexibleDate 登録異動年月日 = result.get宛名PSM().getShojoIdoYMD();
                div.setTxtHdnShojoIdoYMD(set登録年月日(登録異動年月日));
            }

            if (result.get宛名PSM() != null) {
                FlexibleDate 登録届出年月日 = result.get宛名PSM().getShojoTodokedeYMD();
                div.setTxtHdnShojoTodokedeYMD(set登録年月日(登録届出年月日));
            }
        }

    }

    private RString set登録年月日(FlexibleDate 登録年月日) {
        RString 年月日 = RString.EMPTY;
        if (登録年月日 != null) {
            年月日 = new RString(登録年月日.toString());
        }

        return 年月日;
    }

    /**
     * 選挙資格選択部品の連動です。
     *
     * @param senkyoShurui
     */
    public void set選挙資格状態制御(SenkyoShurui senkyoShurui) {

        if (div.getRadSenkyoShikaku().getSelectedIndex() == 0) {
            div.getTxtMasshoYMD().setDisabled(true);
            div.getCcdMasshoJiyu().setDisabled(true);
            div.getTxtHyojiYMD().setDisabled(true);
            div.getCcdHyojiJiyu().setDisabled(true);
            div.getTxtHyojiShojoYMD().setDisabled(true);
            div.getTxtHyojiShojoYoteiYMD().setDisabled(true);
            div.getTxtKeikiShuryoYMD().setDisabled(false);
            div.getChk2keiMochi().setDisabled(false);
        }
        if (div.getRadSenkyoShikaku().getSelectedIndex() == 1) {
            div.getTxtMasshoYMD().setDisabled(true);
            div.getCcdMasshoJiyu().setDisabled(true);
            div.getTxtHyojiYMD().setDisabled(false);
            div.getCcdHyojiJiyu().setDisabled(false);
            div.getTxtHyojiShojoYMD().setDisabled(false);
            div.getTxtHyojiShojoYoteiYMD().setDisabled(false);
            div.getTxtKeikiShuryoYMD().setDisabled(false);
            div.getChk2keiMochi().setDisabled(false);

        }
        if (div.getRadSenkyoShikaku().getSelectedIndex() == 2) {
            div.getTxtMasshoYMD().setDisabled(false);
            div.getCcdMasshoJiyu().setDisabled(false);
            div.getTxtHyojiYMD().setDisabled(true);
            div.getCcdHyojiJiyu().setDisabled(true);
            div.getTxtHyojiShojoYMD().setDisabled(true);
            div.getTxtHyojiShojoYoteiYMD().setDisabled(true);
            div.getTxtKeikiShuryoYMD().setDisabled(true);
            div.getChk2keiMochi().setDisabled(true);

        }
        if (div.getRadSenkyoShikaku().getSelectedIndex() == 3) {
            div.getTxtMasshoYMD().setDisabled(true);
            div.getCcdMasshoJiyu().setDisabled(true);
            div.getTxtHyojiYMD().setDisabled(false);
            div.getCcdHyojiJiyu().setDisabled(false);
            div.getTxtHyojiShojoYMD().setDisabled(false);
            div.getTxtHyojiShojoYoteiYMD().setDisabled(false);
            div.getTxtKeikiShuryoYMD().setDisabled(false);
            div.getChk2keiMochi().setDisabled(false);
        }
    }

    /**
     * 各項目をクリアします。
     *
     */
    public void clearThisPanel() {
        div.getCcdTohyokuCode().clear();
        div.getTxtMeiboTorokuYMD().clearValue();
        div.getCcdMeiboTorokuJiyu().clear();
        div.getTxtTorokuTeishiYMD().clearValue();
        div.getCcdTorokuTeishiJiyu().clear();
        div.getTxtMasshoYMD().clearValue();
        div.getCcdMasshoJiyu().clear();
        div.getTxtHyojiYMD().clearValue();
        div.getCcdHyojiJiyu().clear();
        div.getTxtHyojiShojoYoteiYMD().clearValue();
        div.getTxtHyojiShojoYMD().clearValue();
        div.getTxtKeikiShuryoYMD().clearValue();
    }

}
