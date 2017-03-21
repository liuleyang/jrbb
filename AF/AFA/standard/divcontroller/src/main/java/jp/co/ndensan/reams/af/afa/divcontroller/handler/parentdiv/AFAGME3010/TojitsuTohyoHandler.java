/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeSenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.UketsukeNoShisetsuSetei;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME3010.TojitsuKojinJoho;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME3010.TojitsuTohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.ITohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.dgTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo.TojitsuTohyoManager;
import jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo.TojitsuTohyoValidationService;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * TojitsuTohyoJokyoの操作を担当するクラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoHandler {

    private final TojitsuTohyoDiv div;
    private static final RString 零 = new RString("0");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final RString 一 = new RString("1");
    private static final RString 投票受付不可 = new RString("投票区コードが違います。");

    /**
     * コンストラクタです。
     *
     * @param div 当日投票Div
     */
    public TojitsuTohyoHandler(TojitsuTohyoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void onload() {
        loadTohyoShukei();
        loadSenkyoninTohyoJokyo();
        setDisabledCommonButton(Boolean.TRUE);
    }

    /**
     * 抄本ドロップダウンのイベントメソッドです。
     *
     */
    public void onChangeCcdShohonNameListチェック() {
        TojitsuKojinJohoDiv kojinJoho = div.getTojitsuKojinJoho();
        RString shohonNo = kojinJoho.getCcdShohonNameList().getSelectedShohonNo();
        TojitsuTohyoValidationService validationService = TojitsuTohyoValidationService.createInstance();

        Message validationMessage = validationService.各種エラーチェック1(new ShohonNo(shohonNo));
        if (validationMessage != null) {
            throw new ApplicationException(validationMessage);
        }
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param useingDialog boolean
     * @return Message
     */
    public Message チェックBarCode(boolean useingDialog) {
        ITohyoJokyoNyuryokuDiv tohyoJokyo = div.getCcdTojitsuSenkyoninTohyoJokyo();
        TojitsuKojinJohoDiv kojinJohodiv = div.getTojitsuKojinJoho();
        RString 抄本No = kojinJohodiv.getCcdShohonNameList().getSelectedShohonNo();
        ShikibetsuCode 識別コード = new ShikibetsuCode(kojinJohodiv.getTxtHdnShikibetsuCode());
        ShohonNo 抄本番号 = new ShohonNo(抄本No);
        TojitsuTohyoValidationService tojitsuTohyoValidationService = TojitsuTohyoValidationService.createInstance();

        if (!useingDialog && !kojinJohodiv.getCcdTojitsuBarCode().getBarCode().isEmpty()) {
            Boolean hasShohonNo = kojinJohodiv.getCcdTojitsuBarCode().isMatchShohonNo(kojinJohodiv.getCcdShohonNameList().getSelectedShohonNo());
            if (!hasShohonNo) {
                throw new ApplicationException(AfErrorMessages.入場券確認.getMessage());
            }
        }

        if (!tojitsuTohyoValidationService.validate選挙人(抄本番号, 識別コード)) {
            RString replacess = new RString("抄本：").concat(kojinJohodiv.getCcdShohonNameList().getSelectedShohonName()).concat("　に、識別コード：")
                    .concat(識別コード.value()).concat("　の住民が存在しません。");
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(replacess.toString()));
        }

        SenkyoninMeibo senkyoninMeibo = SenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(
                new ShohonNo(div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo()), 識別コード);
        if (senkyoninMeibo != null
                && !senkyoninMeibo.get投票区コード().equals(div.getTojitsuTohyoJokyo().getTxtHdnTohyokuCode())) {
            throw new ApplicationException(AfErrorMessages.投票受付不可.getMessage().replace(投票受付不可.toString()));
        }

        TohyoJokyoManager tohyoJokyoManager = TohyoJokyoManager.createInstance();
        RString tanmatsuID = ControlDataHolder.getClientId();
        List<jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo> 投票状況情報List
                = tohyoJokyoManager.get投票状況情報(抄本番号, 識別コード, tanmatsuID);
        KijitsumaeSenkyoShikaku 投票資格 = tohyoJokyoManager.get投票資格情報(抄本番号, 識別コード, tanmatsuID);

        KijitsumaeTohyoChohyoData tohyoChohyoData = 投票資格.to期日前投票状況情報(投票状況情報List);

        Message validationMessage = tojitsuTohyoValidationService.各種エラーチェック(tohyoChohyoData);
        if (validationMessage != null) {
            throw new ApplicationException(validationMessage);
        }

        IValidationMessages messgs = tojitsuTohyoValidationService.確認チェック(tohyoChohyoData);
        if (messgs != null) {
            validationMessage = messgs.getList().get(0).getMessage();
            RString 投票状態 = RString.EMPTY;
            if (validationMessage.evaluate().contains(AfInformationMessages.投票受付完了.getMessage().evaluate())) {
                投票状態 = new RString(AfInformationMessages.投票受付完了.getMessage().evaluate());
            }
            if (validationMessage.evaluate().contains(AfInformationMessages.一部交付済み.getMessage().evaluate())) {
                投票状態 = 投票状態.concat(
                        new RString(AfInformationMessages.一部交付済み.getMessage().evaluate()));
            }
            if (validationMessage.evaluate().contains(AfInformationMessages.一部受付済み.getMessage().evaluate())) {
                投票状態 = 投票状態.concat(
                        new RString(AfInformationMessages.一部受付済み.getMessage().evaluate()));
            }
            div.getTojitsuKojinJoho().getTxtTohyoJokyo().setValue(投票状態);
        }
        if (validationMessage == null) {
            TojitsuKojinJoho.set選挙人情報と投票情報(kojinJohodiv);
            tohyoJokyo.setShikibetsuCode(識別コード);
            tohyoJokyo.setReadOnlyMode(false);
            RString selectedKey = div.getTojitsuKojinJoho().getDdlSenkyoName().getSelectedKey();
            if (selectedKey.equals(零)) {
                tohyoJokyo.initialize(抄本No, 識別コード, div.getTojitsuKojinJoho().getCcdTohyokuCode().get投票区コード());
            } else {
                tohyoJokyo.initialize(抄本No, 識別コード, div.getTojitsuKojinJoho().getCcdTohyokuCode().get投票区コード(),
                        new SenkyoNo(div.getTojitsuKojinJoho().getDdlSenkyoName().getSelectedKey()));
            }
            accessLog(AccessLogType.照会, 識別コード);
            setDisabledCommonButton(false);
        }

        return validationMessage;
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     */
    public void チェックBarCodeOK() {
        ITohyoJokyoNyuryokuDiv tohyoJokyo = div.getCcdTojitsuSenkyoninTohyoJokyo();
        TojitsuKojinJohoDiv kojinJoho = div.getTojitsuKojinJoho();
        RString 抄本No = kojinJoho.getCcdShohonNameList().getSelectedShohonNo();

        ShikibetsuCode 識別コード = new ShikibetsuCode(kojinJoho.getTxtHdnShikibetsuCode());
        TojitsuKojinJoho.set選挙人情報と投票情報(kojinJoho);

        tohyoJokyo.setShikibetsuCode(識別コード);
        //チェックOKだったとき
        tohyoJokyo.setReadOnlyMode(false);
        //データの取得＆セット
        RString selectedKey = kojinJoho.getDdlSenkyoName().getSelectedKey();
        if (selectedKey.equals(零)) {
            tohyoJokyo.initialize(抄本No, 識別コード, kojinJoho.getCcdTohyokuCode().get投票区コード());
        } else {
            tohyoJokyo.initialize(抄本No, 識別コード, kojinJoho.getCcdTohyokuCode().get投票区コード(),
                    new SenkyoNo(kojinJoho.getDdlSenkyoName().getSelectedKey()));
        }
        if (div.getTojitsuKojinJoho().getTxtHdnSenkyoninFlag().equals(一)) {
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(true);

        } else {
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(false);
        }
        accessLog(AccessLogType.照会, 識別コード);
        setDisabledCommonButton(false);

    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     */
    public void loadTohyoShukei() {
        RString shohonNo = div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo();
        SenkyoShurui 選挙種類 = div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui();
        div.getTojitsuKojinJoho().getDdlSenkyoName().setDataSource(get選挙ドロップダウン(shohonNo));
        div.getTojitsuKojinJoho().getDdlSenkyoName().setSelectedIndex(INDEX_0);
        if (div.getTojitsuKojinJoho().getTxtHdnSenkyoninFlag().equals(一)) {
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(true);

        } else {
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(false);
        }
        TojitsuTohyoJokyo.setData(div.getTojitsuTohyoJokyo(), shohonNo, 選挙種類);
    }

    /**
     * 選挙ドロップダウンを取得します。
     *
     * @param 抄本番号 RString
     * @return List<dgKijitsumaeTohyoShukei_Row>
     */
    public List<KeyValueDataSource> get選挙ドロップダウン(RString 抄本番号) {
        KeyValueDataSource sourceEmpty = new KeyValueDataSource();
        sourceEmpty.setKey(零);
        sourceEmpty.setValue(RString.EMPTY);

        List<Senkyo> senkyo = SenkyoManager.createInstance().get有投票選挙選挙By抄本番号(new ShohonNo(抄本番号));

        List<KeyValueDataSource> source = new ArrayList<>();
        source.add(sourceEmpty);
        if (null != senkyo && !senkyo.isEmpty()) {
            for (Senkyo senkyoitem : senkyo) {
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(new RString(senkyoitem.get選挙番号().getColumnValue().toString()));
                dataSource.setValue(senkyoitem.get選挙名称());
                source.add(dataSource);
            }
        }
        return source;
    }

    private void loadSenkyoninTohyoJokyo() {
        SenkyoShurui senkyoShurui = div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui();
        RString shohonNo = div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo();
        //todo
        div.getCcdTojitsuSenkyoninTohyoJokyo().initialize(senkyoShurui, TohyoJokyo.当日, shohonNo);
        div.getCcdTojitsuSenkyoninTohyoJokyo().setReadOnlyMode(Boolean.TRUE);

    }

    private void setDisabledCommonButton(boolean isDisabled) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), isDisabled);
    }

    private void setDataFor投票(TohyoJokyoBuilder tohyoJokyoBuilder) {
        tohyoJokyoBuilder.set投票状況(new Code(TohyoJokyo.当日.getCode()));
        tohyoJokyoBuilder.set投票事由コード(Code.EMPTY);
        tohyoJokyoBuilder.set請求年月日(formatDate());
        tohyoJokyoBuilder.set請求方法(Code.EMPTY);
        tohyoJokyoBuilder.set交付年月日(formatDate());
        tohyoJokyoBuilder.set交付時刻(div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoTime());
        if (EntityDataState.Added == tohyoJokyoBuilder.getState()) {
            tohyoJokyoBuilder.set交付方法(Code.EMPTY);
            tohyoJokyoBuilder.set受取年月日(FlexibleDate.EMPTY);
            tohyoJokyoBuilder.set受理方法(Code.EMPTY);
            tohyoJokyoBuilder.set返還年月日(FlexibleDate.EMPTY);
        }
        tohyoJokyoBuilder.set施設コード(RString.EMPTY);
        tohyoJokyoBuilder.set受理年月日(formatDate());
        tohyoJokyoBuilder.set受理時刻(div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoTime());
        tohyoJokyoBuilder.set受理施設種別(Code.EMPTY);
        tohyoJokyoBuilder.set棄権年月日(FlexibleDate.EMPTY);
        tohyoJokyoBuilder.set点字フラグ(div.getCcdTojitsuSenkyoninTohyoJokyo().isTenjiTohyo());
        tohyoJokyoBuilder.set代理投票有フラグ(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().isDairiTohyoAri());
        tohyoJokyoBuilder.set補助者識別コード1(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha1ShikibetsuCode());
        tohyoJokyoBuilder.set補助者氏名1(new AtenaMeisho(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha1Name()));
        tohyoJokyoBuilder.set補助者識別コード2(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha2ShikibetsuCode());
        tohyoJokyoBuilder.set補助者氏名2(new AtenaMeisho(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha2Name()));
        tohyoJokyoBuilder.set拒否事由(RString.EMPTY);
        tohyoJokyoBuilder.set証明書出力フラグ(false);
        tohyoJokyoBuilder.set送致済フラグ(false);
        tohyoJokyoBuilder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.当日投票.value()));
        tohyoJokyoBuilder.set更新端末ID(RString.EMPTY);
    }

    private void setDataFor棄権(TohyoJokyoBuilder 棄権Builder) {
        棄権Builder.set投票状況(new Code(TohyoJokyo.棄権.getCode()));
        棄権Builder.set投票事由コード(Code.EMPTY);
        棄権Builder.set請求年月日(formatDate());
        棄権Builder.set請求方法(Code.EMPTY);
        棄権Builder.set交付年月日(formatDate());
        棄権Builder.set交付時刻(div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoTime());
        if (EntityDataState.Added == 棄権Builder.getState()) {
            棄権Builder.set交付方法(Code.EMPTY);
            棄権Builder.set受取年月日(FlexibleDate.EMPTY);
            棄権Builder.set受理方法(Code.EMPTY);
            棄権Builder.set返還年月日(FlexibleDate.EMPTY);
        }
        棄権Builder.set施設コード(RString.EMPTY);
        棄権Builder.set受理年月日(FlexibleDate.EMPTY);
        棄権Builder.set受理時刻(RTime.of(0, 0, 0));
        棄権Builder.set受理施設種別(Code.EMPTY);
        棄権Builder.set棄権年月日(formatDate());
        棄権Builder.set点字フラグ(false);
        棄権Builder.set代理投票有フラグ(false);
        棄権Builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        棄権Builder.set補助者氏名1(AtenaMeisho.EMPTY);
        棄権Builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        棄権Builder.set補助者氏名2(AtenaMeisho.EMPTY);
        棄権Builder.set拒否事由(RString.EMPTY);
        棄権Builder.set証明書出力フラグ(false);
        棄権Builder.set送致済フラグ(false);
        棄権Builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.当日投票.value()));
        棄権Builder.set更新端末ID(RString.EMPTY);

    }

    private void setDataFor受取拒否仮投票(TohyoJokyoBuilder 受取拒否仮投票Builder) {
        受取拒否仮投票Builder.set投票状況(new Code(TohyoJokyo.仮投票.getCode()));
        受取拒否仮投票Builder.set投票事由コード(Code.EMPTY);
        受取拒否仮投票Builder.set請求年月日(formatDate());
        受取拒否仮投票Builder.set請求方法(Code.EMPTY);
        受取拒否仮投票Builder.set交付年月日(formatDate());
        受取拒否仮投票Builder.set交付時刻(div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoTime());
        if (EntityDataState.Added == 受取拒否仮投票Builder.getState()) {
            受取拒否仮投票Builder.set交付方法(Code.EMPTY);
            受取拒否仮投票Builder.set受取年月日(FlexibleDate.EMPTY);
            受取拒否仮投票Builder.set受理方法(Code.EMPTY);
            受取拒否仮投票Builder.set返還年月日(FlexibleDate.EMPTY);
        }
        受取拒否仮投票Builder.set施設コード(RString.EMPTY);
        受取拒否仮投票Builder.set受理年月日(formatDate());
        受取拒否仮投票Builder.set受理時刻(div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoTime());
        受取拒否仮投票Builder.set受理施設種別(Code.EMPTY);
        受取拒否仮投票Builder.set棄権年月日(FlexibleDate.EMPTY);
        受取拒否仮投票Builder.set点字フラグ(false);
        受取拒否仮投票Builder.set代理投票有フラグ(false);
        受取拒否仮投票Builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        受取拒否仮投票Builder.set補助者氏名1(AtenaMeisho.EMPTY);
        受取拒否仮投票Builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        受取拒否仮投票Builder.set補助者氏名2(AtenaMeisho.EMPTY);
        受取拒否仮投票Builder.set拒否事由(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdKyohiJiyuNyuryoku().get投票状況用拒否事由());
        受取拒否仮投票Builder.set証明書出力フラグ(false);
        受取拒否仮投票Builder.set送致済フラグ(false);
        受取拒否仮投票Builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.当日投票.value()));
        受取拒否仮投票Builder.set更新端末ID(RString.EMPTY);

    }

    private FlexibleDate formatDate() {
        RDate date = div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoYMD();
        return new FlexibleDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
    }

    private void setDataFor受取拒否(TohyoJokyoBuilder 受取拒否Builder) {
        受取拒否Builder.set投票状況(new Code(TohyoJokyo.受付拒否.getCode()));
        受取拒否Builder.set投票事由コード(Code.EMPTY);
        受取拒否Builder.set請求年月日(FlexibleDate.EMPTY);
        受取拒否Builder.set請求方法(Code.EMPTY);
        受取拒否Builder.set交付年月日(FlexibleDate.EMPTY);
        受取拒否Builder.set交付時刻(RTime.of(0, 0, 0));
        受取拒否Builder.set交付方法(Code.EMPTY);
        受取拒否Builder.set施設コード(RString.EMPTY);
        受取拒否Builder.set受取年月日(FlexibleDate.EMPTY);
        受取拒否Builder.set受理年月日(FlexibleDate.EMPTY);
        受取拒否Builder.set受理時刻(RTime.of(0, 0, 0));
        受取拒否Builder.set受理方法(Code.EMPTY);
        受取拒否Builder.set受理施設種別(Code.EMPTY);
        受取拒否Builder.set棄権年月日(FlexibleDate.EMPTY);
        if (EntityDataState.Added == 受取拒否Builder.getState()) {
            受取拒否Builder.set返還年月日(FlexibleDate.EMPTY);
        }
        受取拒否Builder.set点字フラグ(false);
        受取拒否Builder.set代理投票有フラグ(false);
        受取拒否Builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        受取拒否Builder.set補助者氏名1(AtenaMeisho.EMPTY);
        受取拒否Builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        受取拒否Builder.set補助者氏名2(AtenaMeisho.EMPTY);
        受取拒否Builder.set拒否事由(div.getCcdTojitsuSenkyoninTohyoJokyo().getCcdKyohiJiyuNyuryoku().get投票状況用拒否事由());
        受取拒否Builder.set証明書出力フラグ(false);
        受取拒否Builder.set送致済フラグ(false);
        受取拒否Builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.当日投票.value()));
        受取拒否Builder.set更新端末ID(RString.EMPTY);
    }

    /**
     * 当日投票情報の帳票作成用データを取得します。
     *
     * @param withSenkyoNo boolean
     * @return List<TojitsuTohyoJokyoChohyoData>
     */
    public List<KijitsumaeTohyoChohyoData> get帳票データ(boolean withSenkyoNo) {
        ShohonNo 抄本番号 = new ShohonNo(div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo());
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTojitsuKojinJoho().getTxtHdnShikibetsuCode());
        Code senkyoShurui = new Code(div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        List<SenkyoNo> senkyoNoLst = new ArrayList<>();
        if (withSenkyoNo) {
            List<dgTohyoJokyo_Row> selectedItems = div.getCcdTojitsuSenkyoninTohyoJokyo().getDgTohyoJokyo().getSelectedItems();
            for (dgTohyoJokyo_Row row : selectedItems) {
                senkyoNoLst.add(new SenkyoNo(row.getTxtSenkyoNo().getValue().intValue()));
            }
        }
        return TojitsuTohyoManager.createInstance().getTojitsuTohyoChohyoData(senkyoShurui, 抄本番号, 識別コード, senkyoNoLst,
                ControlDataHolder.getClientId());
    }

    /**
     * データを更新します。
     *
     * @param rowList List<dgTohyoJokyo_Row>
     */
    public void updateData(List<dgTohyoJokyo_Row> rowList) {
        TohyoJokyo tohyoJokyo区分 = div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoKubun();
        boolean isKariTohyo = div.getCcdTojitsuSenkyoninTohyoJokyo().isKariTohyo();
        ShohonNo 抄本番号 = new ShohonNo(div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo());
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTojitsuKojinJoho().getTxtHdnShikibetsuCode());

        Code 施設種別 = new Code("00");
        //todo
        RString コード = div.getTojitsuKojinJoho().getCcdTohyokuCode().get投票区コード();
        Code 期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.当日投票.value());
        RString 受付番号_施設設定 = BusinessConfig.get(ConfigKeysAFA.受付番号_施設設定, SubGyomuCode.AFA選挙本体);
        if (UketsukeNoShisetsuSetei.施設管理なし.getCode().equals(受付番号_施設設定)) {
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.通番.value());
        }
        TojitsuTohyoManager manager = TojitsuTohyoManager.createInstance();
        List<TohyoJokyoBuilder> builderList = new ArrayList<>();

        for (dgTohyoJokyo_Row row : rowList) {

            TohyoJokyoBuilder tohyoJokyoBuilder;

            if (!div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getBarCode().isEmpty()) {
                識別コード = div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getShikibetsuCodeNyujoken();
            }
            SenkyoNo 選挙番号 = new SenkyoNo(row.getTxtSenkyoNo().getValue().intValue());
            if (TohyoJokyo.取消.equals(tohyoJokyo区分)) {
                tohyoJokyoBuilder = jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo.createBuilderForDelete(row.getRowData(),
                        抄本番号, 識別コード, 選挙番号);
            } else {
                tohyoJokyoBuilder = jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo.createBuilderForEdit(row.getRowData(),
                        抄本番号, 識別コード, 選挙番号);

                if (TohyoJokyo.棄権.equals(tohyoJokyo区分)) {
                    setDataFor棄権(tohyoJokyoBuilder);
                } else if (TohyoJokyo.受付拒否.equals(tohyoJokyo区分) && !isKariTohyo) {
                    setDataFor受取拒否(tohyoJokyoBuilder);
                } else if (TohyoJokyo.受付拒否.equals(tohyoJokyo区分) && isKariTohyo) {
                    setDataFor受取拒否仮投票(tohyoJokyoBuilder);
                } else {
                    setDataFor投票(tohyoJokyoBuilder);
                }

            }
            builderList.add(tohyoJokyoBuilder);
        }

        if (TohyoJokyo.取消.equals(tohyoJokyo区分)) {
            manager.deleteData(builderList);
        } else if (TohyoJokyo.棄権.equals(tohyoJokyo区分)) {
            manager.saveData棄権受取拒否(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        } else if (TohyoJokyo.受付拒否.equals(tohyoJokyo区分) && !isKariTohyo) {
            manager.saveData棄権受取拒否(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        } else if (TohyoJokyo.受付拒否.equals(tohyoJokyo区分) && isKariTohyo) {
            manager.saveData受取拒否仮投票(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        } else {
            manager.saveData投票(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        }
        accessLog(AccessLogType.更新, 識別コード);
    }

    /**
     * 画面を初期表示状態にする。
     *
     * @param clearBarCode boolean
     * @param skip当日投票 boolean
     */
    public void clear(boolean clearBarCode, boolean skip当日投票) {

        enableAll();
        TojitsuKojinJohoDiv 選挙人情報 = div.getTojitsuKojinJoho();

        loadTohyoShukei();
        if (!skip当日投票) {
            // 当日投票の投票状況
            div.getTojitsuTohyoJokyo().setIsOpen(true);
        }

        RString barCode = 選挙人情報.getCcdTojitsuBarCode().getBarCode();
        // 選挙人情報
        選挙人情報.getCcdTojitsuBarCode().clearData();

        選挙人情報.getCcdKojinJoho().getCcdKojinJohoUR().clear();

        選挙人情報.getCcdTohyokuCode().clear();
        選挙人情報.getCcdMeiboBango().clear();
        選挙人情報.getTxtSenkyoShikaku().clearValue();
        選挙人情報.getTxtTohyoJokyo().clearValue();
        選挙人情報.getDdlSenkyoName().setDisabled(false);
        if (!clearBarCode) {
            選挙人情報.getCcdTojitsuBarCode().getTxtBarCode().setValue(barCode);
        }

        // 選挙人の投票状況
        ITohyoJokyoNyuryokuDiv 選挙人の投票状況 = div.getCcdTojitsuSenkyoninTohyoJokyo();
        選挙人の投票状況.clearData();
        loadSenkyoninTohyoJokyo();

        setDisabledCommonButton(true);

    }

    /**
     * 画面を初期表示状態にする。
     *
     */
    public void initialClear() {
        div.getTojitsuTohyoJokyo().getDgTojitsuTohyoShukei().getDataSource().clear();

        TojitsuKojinJohoDiv 選挙人情報 = div.getTojitsuKojinJoho();

        // 選挙人情報
        選挙人情報.getCcdTojitsuBarCode().clearData();

        選挙人情報.getCcdKojinJoho().getCcdKojinJohoUR().clear();

        選挙人情報.getCcdTohyokuCode().clear();
        選挙人情報.getCcdMeiboBango().clear();
        選挙人情報.getTxtSenkyoShikaku().clearValue();

        // 選挙人の投票状況
        ITohyoJokyoNyuryokuDiv 選挙人の投票状況 = div.getCcdTojitsuSenkyoninTohyoJokyo();
        選挙人の投票状況.clearData();

    }

    /**
     * 初期表示の設定内容と比する。
     *
     * @param skip当日投票 boolean
     * @return 結果
     */
    public boolean isChanged(boolean skip当日投票) {

        if (!skip当日投票) {

            //  当日投票の投票状況
            TojitsuTohyoJokyoDiv 当日投票の投票状況 = div.getTojitsuTohyoJokyo();
            if (当日投票の投票状況.getRadSenkyoNo().getSelectedIndex() != 0) {
                return true;
            }
            if (当日投票の投票状況.getRadShukeiTani().getSelectedIndex() != INDEX_1) {
                return true;
            }
            if (ViewState.get抄本番号() != div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo()) {
                return true;
            }
        }

        // 選挙人情報
        TojitsuKojinJohoDiv 選挙人情報 = div.getTojitsuKojinJoho();

        RString barCode = 選挙人情報.getCcdTojitsuBarCode().getBarCode();
        AtenaShokaiSimpleDiv 宛名情報 = (AtenaShokaiSimpleDiv) 選挙人情報.getCcdKojinJoho().getCcdKojinJohoUR();

        ShikibetsuCode 識別コード = 宛名情報.getShokaiData().getTxtShikibetsuCode().getDomain();

        if (!RString.isNullOrEmpty(barCode) || !(識別コード == null || 識別コード.isEmpty())) {
            return true;
        }

        // 選挙人の投票状況
        ITohyoJokyoNyuryokuDiv 選挙人の投票状況 = div.getCcdTojitsuSenkyoninTohyoJokyo();
        return 選挙人の投票状況.isSearchAlready();

    }

    /**
     * 共通ボタンエリアの「初期表示に戻る」を使用可能にし、他の入力項目とボタンを非活性にする。
     *
     */
    public void disableAll() {
        div.getTojitsuTohyoJokyo().setDisabled(true);
        div.getTojitsuKojinJoho().setDisabled(true);
        div.getCcdTojitsuSenkyoninTohyoJokyo().setDisabled(true);

        setDisabledCommonButton(true);

    }

    private void enableAll() {
        div.getTojitsuTohyoJokyo().setDisabled(false);
        div.getTojitsuKojinJoho().setDisabled(false);
        div.getCcdTojitsuSenkyoninTohyoJokyo().setDisabled(false);

        setDisabledCommonButton(false);

    }

    private void accessLog(AccessLogType type, ShikibetsuCode shikibetsuCode) {
        AccessLogger.log(type, PersonalData.of(shikibetsuCode));
    }
}
