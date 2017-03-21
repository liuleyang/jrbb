/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
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
import jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME1010.KijitsumaeKojinJoho;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME1010.KijitsumaeTohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.ITohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.dgTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeTohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.service.core.kijitsumaetohyo.KijitsumaeTohyoManager;
import jp.co.ndensan.reams.af.afa.service.core.kijitsumaetohyo.KijitsumaeTohyoValidationService;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
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
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * KijitsumaeTohyoの操作を担当するクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoHandler {

    private final KijitsumaeTohyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 期日前投票Div
     */
    public KijitsumaeTohyoHandler(KijitsumaeTohyoDiv div) {
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
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void selectedFlag() {
        setDisabledCommonButton(Boolean.FALSE);
    }

    /**
     * 抄本ドロップダウンのイベントメソッドです。
     *
     */
    public void checkForOnChangeCcdShohonNameList() {
        KijitsumaeKojinJohoDiv kojinJoho = div.getKijitsumaeKojinJoho();
        RString 抄本No = kojinJoho.getCcdShohonNameList().getSelectedShohonNo();
        KijitsumaeTohyoValidationService validationService = KijitsumaeTohyoValidationService.createInstance();

        Message message = validationService.各種エラーチェック1(new ShohonNo(抄本No));
        if (message != null) {
            throw new ApplicationException(message);
        }
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param useDialog boolean
     * @return Message
     */
    public Message checkForOnClickBtnBarCode(boolean useDialog) {
        ITohyoJokyoNyuryokuDiv tohyoJokyo = div.getCcdKijitsumaeSenkyoninTohyoJokyo();
        KijitsumaeKojinJohoDiv kojinJoho = div.getKijitsumaeKojinJoho();
        RString 抄本No = kojinJoho.getCcdShohonNameList().getSelectedShohonNo();
        ShikibetsuCode 識別コード = new ShikibetsuCode(kojinJoho.getTxtHdnShikibetsuCode());
        ShohonNo 抄本番号 = new ShohonNo(抄本No);
        KijitsumaeTohyoValidationService validationService = KijitsumaeTohyoValidationService.createInstance();

        if (!useDialog && !kojinJoho.getCcdKijitsumaeBarCode().getBarCode().isEmpty()) {
            Boolean chkShohonNo = kojinJoho.getCcdKijitsumaeBarCode().isMatchShohonNo(kojinJoho.getCcdShohonNameList().getSelectedShohonNo());
            if (!chkShohonNo) {
                // バーコードで読み取った抄本番号と、DDLの抄本番号が不一致の時エラー
                throw new ApplicationException(AfErrorMessages.入場券確認.getMessage());
            }

        }

        if (!validationService.validate選挙人(抄本番号, 識別コード)) {
            RString replaces = new RString("抄本：").concat(kojinJoho.getCcdShohonNameList().getSelectedShohonName()).concat("　に、識別コード：")
                    .concat(識別コード.value()).concat("　の住民が存在しません。");
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(replaces.toString()));
        }

        TohyoJokyoManager manager = TohyoJokyoManager.createInstance();
        RString tanmatsuID = ControlDataHolder.getClientId();
        List<jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo> 投票状況情報List = manager.get投票状況情報(抄本番号, 識別コード,
                tanmatsuID);
        KijitsumaeSenkyoShikaku 投票資格情報 = manager.get投票資格情報(抄本番号, 識別コード, tanmatsuID);

        KijitsumaeTohyoChohyoData kijitsumaeTohyoChohyoData = 投票資格情報.to期日前投票状況情報(投票状況情報List);

        Message message = validationService.各種エラーチェック(kijitsumaeTohyoChohyoData);
        if (message != null) {
            throw new ApplicationException(message);
        }
        message = validationService.確認チェック(kijitsumaeTohyoChohyoData);
        if (message == null) {
            KijitsumaeKojinJoho.set読込個人情報(kojinJoho);
            tohyoJokyo.setShikibetsuCode(識別コード);
            //チェックOKだったとき
            tohyoJokyo.setReadOnlyMode(false);
            //データの取得＆セット
            tohyoJokyo.initialize(抄本No, 識別コード, kojinJoho.getCcdTohyokuCode().get投票区コード());
            accessLog(AccessLogType.照会, 識別コード);
            setDisabledCommonButton(false);
        }

        return message;
    }

    /**
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param 投票状況情報List
     * List<jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo>
     * @param 投票資格情報 KijitsumaeSenkyoShikaku
     * @return Message
     */
    public Message checkOnColse(ShikibetsuCode shikibetsuCode, List<jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo> 投票状況情報List, KijitsumaeSenkyoShikaku 投票資格情報) {
//        ITohyoJokyoNyuryokuDiv tohyoJokyo = div.getCcdKijitsumaeSenkyoninTohyoJokyo();
        KijitsumaeTohyoValidationService validationService = KijitsumaeTohyoValidationService.createInstance();
        KijitsumaeTohyoChohyoData kijitsumaeTohyoChohyoData = 投票資格情報.to期日前投票状況情報(投票状況情報List);
        Message message = validationService.各種エラーチェック(kijitsumaeTohyoChohyoData);
        if (message != null) {
            throw new ApplicationException(message);
        }
        message = validationService.確認チェック(kijitsumaeTohyoChohyoData);
        return message;
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     */
    public void checkForOnClickBtnBarCodeOK() {
        ITohyoJokyoNyuryokuDiv tohyoJokyo = div.getCcdKijitsumaeSenkyoninTohyoJokyo();
        KijitsumaeKojinJohoDiv kojinJoho = div.getKijitsumaeKojinJoho();
        RString 抄本No = kojinJoho.getCcdShohonNameList().getSelectedShohonNo();
        ShikibetsuCode 識別コード = new ShikibetsuCode(kojinJoho.getTxtHdnShikibetsuCode());
        KijitsumaeKojinJoho.set読込個人情報(kojinJoho);

        tohyoJokyo.setShikibetsuCode(識別コード);
        //チェックOKだったとき
        tohyoJokyo.setReadOnlyMode(false);
        //データの取得＆セット
        tohyoJokyo.initialize(抄本No, 識別コード, kojinJoho.getCcdTohyokuCode().get投票区コード());
        accessLog(AccessLogType.照会, 識別コード);
        setDisabledCommonButton(false);

    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     */
    public void loadTohyoShukei() {
        RString shohonNo = div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedShohonNo();
        KijitsumaeTohyoJokyo.setData(div.getKijitsumaeTohyoJokyo(), shohonNo);
    }

    private void loadSenkyoninTohyoJokyo() {
        SenkyoShurui senkyoShurui = div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui();
        RString shohonNo = div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedShohonNo();
        div.getCcdKijitsumaeSenkyoninTohyoJokyo().initialize(senkyoShurui, TohyoJokyo.期日前, shohonNo);
        div.getCcdKijitsumaeSenkyoninTohyoJokyo().setReadOnlyMode(Boolean.TRUE);

    }

    private void setDisabledCommonButton(boolean isDisabled) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), isDisabled);
    }

    private void setDataFor投票(TohyoJokyoBuilder builder) {
        builder.set投票状況(new Code(TohyoJokyo.期日前.getCode()));
        builder.set投票事由コード(
                div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdTohyoJiyu().getTohyoJiyuCodeContext().getTohyoJiyuCode());
        builder.set請求年月日(getDate());
        builder.set請求方法(new Code(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getSeikyusha().getCode()));
        builder.set交付年月日(getDate());
        builder.set交付時刻(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoTime());
        if (EntityDataState.Added == builder.getState()) {
            builder.set交付方法(new Code("1"));
            builder.set受取年月日(FlexibleDate.EMPTY);
            builder.set受理方法(new Code("1"));
            builder.set返還年月日(FlexibleDate.EMPTY);
        }
        RString 施設コード = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKofuShisetsu().get施設コード();
        builder.set施設コード(施設コード);
        builder.set受理年月日(getDate());
        builder.set受理時刻(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoTime());
        if (!RString.isNullOrEmpty(施設コード)) {
            builder.set受理施設種別(ShisetsuManager.createInstance().get施設By施設コード(施設コード).get施設種別());
        } else {
            builder.set受理施設種別(Code.EMPTY);
        }
        builder.set棄権年月日(FlexibleDate.EMPTY);
        builder.set点字フラグ(div.getCcdKijitsumaeSenkyoninTohyoJokyo().isTenjiTohyo());
        builder.set代理投票有フラグ(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().isDairiTohyoAri());
        builder.set補助者識別コード1(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha1ShikibetsuCode());
        builder.set補助者氏名1(new AtenaMeisho(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha1Name()));
        builder.set補助者識別コード2(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha2ShikibetsuCode());
        builder.set補助者氏名2(new AtenaMeisho(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdDairiTohyo().getHojoshaNyuryokuContext().getHojosha2Name()));
        builder.set拒否事由(RString.EMPTY);
        builder.set証明書出力フラグ(false);
        builder.set送致済フラグ(false);
        builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.期日前投票.value()));
        builder.set更新端末ID(ControlDataHolder.getClientId());
    }

    private void setDataFor棄権(TohyoJokyoBuilder builder) {
        builder.set投票状況(new Code(TohyoJokyo.棄権.getCode()));
        builder.set投票事由コード(Code.EMPTY);
        builder.set請求年月日(getDate());
        builder.set請求方法(Code.EMPTY);
        builder.set交付年月日(getDate());
        builder.set交付時刻(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoTime());
        if (EntityDataState.Added == builder.getState()) {
            builder.set交付方法(Code.EMPTY);
            builder.set受取年月日(FlexibleDate.EMPTY);
            builder.set受理方法(Code.EMPTY);
            builder.set返還年月日(FlexibleDate.EMPTY);
        }
        RString 施設コード = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKofuShisetsu().get施設コード();
        builder.set施設コード(施設コード);
        builder.set受理年月日(FlexibleDate.EMPTY);
        builder.set受理時刻(RTime.of(0, 0, 0));
        if (!RString.isNullOrEmpty(施設コード)) {
            builder.set受理施設種別(ShisetsuManager.createInstance().get施設By施設コード(施設コード).get施設種別());
        } else {
            builder.set受理施設種別(Code.EMPTY);
        }
        builder.set棄権年月日(getDate());
        builder.set点字フラグ(false);
        builder.set代理投票有フラグ(false);
        builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        builder.set補助者氏名1(AtenaMeisho.EMPTY);
        builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        builder.set補助者氏名2(AtenaMeisho.EMPTY);
        builder.set拒否事由(RString.EMPTY);
        builder.set証明書出力フラグ(false);
        builder.set送致済フラグ(false);
        builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.期日前投票.value()));
        builder.set更新端末ID(ControlDataHolder.getClientId());

    }

    private void setDataFor受取拒否仮投票(TohyoJokyoBuilder builder) {
        builder.set投票状況(new Code(TohyoJokyo.仮投票.getCode()));
        builder.set投票事由コード(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdTohyoJiyu().getTohyoJiyuCodeContext().getTohyoJiyuCode());
        builder.set請求年月日(getDate());
        builder.set請求方法(new Code(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getSeikyusha().getCode()));
        builder.set交付年月日(getDate());
        builder.set交付時刻(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoTime());
        if (EntityDataState.Added == builder.getState()) {
            builder.set交付方法(Code.EMPTY);
            builder.set受取年月日(FlexibleDate.EMPTY);
            builder.set受理方法(Code.EMPTY);
            builder.set返還年月日(FlexibleDate.EMPTY);
        }
        RString 施設コード = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKofuShisetsu().get施設コード();
        builder.set施設コード(施設コード);
        builder.set受理年月日(getDate());
        builder.set受理時刻(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoTime());
        if (!RString.isNullOrEmpty(施設コード)) {
            builder.set受理施設種別(ShisetsuManager.createInstance().get施設By施設コード(施設コード).get施設種別());
        } else {
            builder.set受理施設種別(Code.EMPTY);
        }
        builder.set棄権年月日(FlexibleDate.EMPTY);
        builder.set点字フラグ(false);
        builder.set代理投票有フラグ(false);
        builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        builder.set補助者氏名1(AtenaMeisho.EMPTY);
        builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        builder.set補助者氏名2(AtenaMeisho.EMPTY);
        builder.set拒否事由(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKyohiJiyuNyuryoku().get投票状況用拒否事由());
        builder.set証明書出力フラグ(false);
        builder.set送致済フラグ(false);
        builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.期日前投票.value()));
        builder.set更新端末ID(ControlDataHolder.getClientId());

    }

    private FlexibleDate getDate() {
        RDate date = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoYMD();
        return new FlexibleDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
    }

    private void setDataFor受取拒否(TohyoJokyoBuilder builder) {
        builder.set投票状況(new Code(TohyoJokyo.受付拒否.getCode()));
        builder.set投票事由コード(Code.EMPTY);
        builder.set請求年月日(FlexibleDate.EMPTY);
        builder.set請求方法(Code.EMPTY);
        builder.set交付年月日(FlexibleDate.EMPTY);
        builder.set交付時刻(RTime.of(0, 0, 0));
        builder.set交付方法(Code.EMPTY);
        builder.set施設コード(RString.EMPTY);
        builder.set受取年月日(FlexibleDate.EMPTY);
        builder.set受理年月日(FlexibleDate.EMPTY);
        builder.set受理時刻(RTime.of(0, 0, 0));
        builder.set受理方法(Code.EMPTY);
        builder.set受理施設種別(Code.EMPTY);
        builder.set棄権年月日(FlexibleDate.EMPTY);
        if (EntityDataState.Added == builder.getState()) {
            builder.set返還年月日(FlexibleDate.EMPTY);
        }
        builder.set点字フラグ(false);
        builder.set代理投票有フラグ(false);
        builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        builder.set補助者氏名1(AtenaMeisho.EMPTY);
        builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        builder.set補助者氏名2(AtenaMeisho.EMPTY);
        builder.set拒否事由(div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKyohiJiyuNyuryoku().get投票状況用拒否事由());
        builder.set証明書出力フラグ(false);
        builder.set送致済フラグ(false);
        builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.期日前投票.value()));
        builder.set更新端末ID(ControlDataHolder.getClientId());
    }

    /**
     * 期日前投票情報の帳票作成用データを取得します。
     *
     * @param withSenkyoNo boolean
     * @return List<KijitsumaeTohyoChohyoData>
     */
    public List<KijitsumaeTohyoChohyoData> get帳票データ(boolean withSenkyoNo) {
        ShohonNo 抄本番号 = new ShohonNo(div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedShohonNo());
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getKijitsumaeKojinJoho().getTxtHdnShikibetsuCode());
        Code senkyoShurui = new Code(div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        List<SenkyoNo> senkyoNoLst = new ArrayList<>();
        if (withSenkyoNo) {
            List<dgTohyoJokyo_Row> selectedItems = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getDgTohyoJokyo().getSelectedItems();
            for (dgTohyoJokyo_Row row : selectedItems) {
                senkyoNoLst.add(new SenkyoNo(row.getTxtSenkyoNo().getValue().intValue()));
            }
        }
        return KijitsumaeTohyoManager.createInstance().getKijitsumaeTohyoChohyoData(senkyoShurui, 抄本番号, 識別コード, senkyoNoLst,
                ControlDataHolder.getClientId());
    }

    /**
     * データを更新します。
     *
     * @param rowList List<dgTohyoJokyo_Row>
     */
    public void updateData(List<dgTohyoJokyo_Row> rowList) {
        TohyoJokyo 投票区分 = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoKubun();
        boolean isKariTohyo = div.getCcdKijitsumaeSenkyoninTohyoJokyo().isKariTohyo();
        ShohonNo 抄本番号 = new ShohonNo(div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedShohonNo());
        //       ShikibetsuCode 識別コード = new ShikibetsuCode(div.getKijitsumaeKojinJoho().getTxtHdnShikibetsuCode());
        ShikibetsuCode 識別コード = new ShikibetsuCode(((AtenaShokaiSimpleDiv) div.getKijitsumaeKojinJoho().getCcdKojinJoho().getCcdKojinJohoUR()).getHdnTxtShikibetsuCode());
        Code 施設種別 = new Code("00");
        RString コード = new RString("0000");
        Code 期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.期日前投票.value());
        RString 受付番号_施設設定 = BusinessConfig.get(ConfigKeysAFA.受付番号_施設設定, SubGyomuCode.AFA選挙本体);
        if (UketsukeNoShisetsuSetei.施設種別毎連番.getCode().equals(受付番号_施設設定)) {
            RString 施設コード = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKofuShisetsu().get施設コード();
            if (!RString.isNullOrEmpty(施設コード)) {
                施設種別 = ShisetsuManager.createInstance().get施設By施設コード(施設コード).get施設種別();
            }
        } else if (UketsukeNoShisetsuSetei.施設コード毎連番.getCode().equals(受付番号_施設設定)) {
            コード = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getCcdKofuShisetsu().get施設コード();
        } else if (UketsukeNoShisetsuSetei.施設管理なし.getCode().equals(受付番号_施設設定)) {
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.通番.value());
        }
        KijitsumaeTohyoManager kijitsumaeTohyoManager = KijitsumaeTohyoManager.createInstance();
        List<TohyoJokyoBuilder> builderList = new ArrayList<>();

        for (dgTohyoJokyo_Row row : rowList) {

            TohyoJokyoBuilder builder;

            if (!div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getBarCode().isEmpty()) {
                // バーコード入力があった時
                識別コード = div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getShikibetsuCodeNyujoken();
            }
            SenkyoNo 選挙番号 = new SenkyoNo(row.getTxtSenkyoNo().getValue().intValue());
            if (TohyoJokyo.取消.equals(投票区分)) {
                builder = jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo.createBuilderForDelete(row.getRowData(),
                        抄本番号, 識別コード, 選挙番号);
            } else {
                builder = jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo.createBuilderForEdit(row.getRowData(),
                        抄本番号, 識別コード, 選挙番号);

                if (TohyoJokyo.棄権.equals(投票区分)) {
                    setDataFor棄権(builder);
                } else if (TohyoJokyo.受付拒否.equals(投票区分) && !isKariTohyo) {
                    setDataFor受取拒否(builder);
                } else if (TohyoJokyo.受付拒否.equals(投票区分) && isKariTohyo) {
                    setDataFor受取拒否仮投票(builder);
                } else {
                    setDataFor投票(builder);
                }

            }
            builderList.add(builder);
        }

        if (TohyoJokyo.取消.equals(投票区分)) {
            kijitsumaeTohyoManager.deleteData(builderList);
        } else if (TohyoJokyo.棄権.equals(投票区分)) {
            kijitsumaeTohyoManager.saveData棄権受取拒否(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        } else if (TohyoJokyo.受付拒否.equals(投票区分) && !isKariTohyo) {
            kijitsumaeTohyoManager.saveData棄権受取拒否(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        } else if (TohyoJokyo.受付拒否.equals(投票区分) && isKariTohyo) {
            kijitsumaeTohyoManager.saveData受取拒否仮投票(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        } else {
            kijitsumaeTohyoManager.saveData投票(builderList, 抄本番号, 施設種別, コード, 期日前不在者区分);
        }
        accessLog(AccessLogType.更新, 識別コード);
    }

    /**
     * 画面を初期表示状態にする。
     *
     * @param clearBarCode boolean
     * @param skip期日前期間中 boolean
     */
    public void clear(boolean clearBarCode, boolean skip期日前期間中) {

        enableAll();
        KijitsumaeKojinJohoDiv 選挙人情報 = div.getKijitsumaeKojinJoho();

        loadTohyoShukei();
        if (!skip期日前期間中) {
            // 期日前期間中の投票状況
            div.getKijitsumaeTohyoJokyo().setIsOpen(false);
        }

        RString barCode = 選挙人情報.getCcdKijitsumaeBarCode().getBarCode();
        // 選挙人情報
        選挙人情報.getCcdKijitsumaeBarCode().clearData();

        選挙人情報.getCcdKojinJoho().getCcdKojinJohoUR().clear();

        選挙人情報.getCcdTohyokuCode().clear();
        選挙人情報.getCcdMeiboBango().clear();
        選挙人情報.getTxtSenkyoShikaku().clearValue();
        if (!clearBarCode) {
            選挙人情報.getCcdKijitsumaeBarCode().getTxtBarCode().setValue(barCode);
        }

        // 選挙人の投票状況
        ITohyoJokyoNyuryokuDiv 選挙人の投票状況 = div.getCcdKijitsumaeSenkyoninTohyoJokyo();
        選挙人の投票状況.clearData();
        loadSenkyoninTohyoJokyo();

        setDisabledCommonButton(true);

    }

    /**
     * 初期表示の設定内容と比する。
     *
     * @param skip期日前期間中 boolean
     * @return 結果
     */
    public boolean hasChanged(boolean skip期日前期間中) {

        if (!skip期日前期間中) {

            //  期日前期間中の投票状況
            KijitsumaeTohyoJokyoDiv 期日前期間中の投票状況 = div.getKijitsumaeTohyoJokyo();
            if (期日前期間中の投票状況.isIsOpen() || 期日前期間中の投票状況.getRadSenkyoNo().getSelectedIndex() != 0) {
                return true;
            }
        }

        // 選挙人情報
        KijitsumaeKojinJohoDiv 選挙人情報 = div.getKijitsumaeKojinJoho();

        RString barCode = 選挙人情報.getCcdKijitsumaeBarCode().getBarCode();
        AtenaShokaiSimpleDiv 宛名情報 = (AtenaShokaiSimpleDiv) 選挙人情報.getCcdKojinJoho().getCcdKojinJohoUR();

        ShikibetsuCode 識別コード = 宛名情報.getShokaiData().getTxtShikibetsuCode().getDomain();

        if (!RString.isNullOrEmpty(barCode) || !(識別コード == null || 識別コード.isEmpty())) {
            return true;
        }

        // 選挙人の投票状況
        ITohyoJokyoNyuryokuDiv 選挙人の投票状況 = div.getCcdKijitsumaeSenkyoninTohyoJokyo();
        return 選挙人の投票状況.isSearchAlready();

    }

    /**
     * 共通ボタンエリアの「初期表示に戻る」を使用可能にし、他の入力項目とボタンを非活性にする。
     *
     */
    public void disableAll() {
        div.getKijitsumaeTohyoJokyo().setDisabled(true);
        div.getKijitsumaeKojinJoho().setDisabled(true);
        div.getCcdKijitsumaeSenkyoninTohyoJokyo().setDisabled(true);

        setDisabledCommonButton(true);

    }

    private void enableAll() {
        div.getKijitsumaeTohyoJokyo().setDisabled(false);
        div.getKijitsumaeKojinJoho().setDisabled(false);
        div.getCcdKijitsumaeSenkyoninTohyoJokyo().setDisabled(false);

        setDisabledCommonButton(false);

    }

    private void accessLog(AccessLogType type, ShikibetsuCode shikibetsuCode) {
        AccessLogger.log(type, PersonalData.of(shikibetsuCode));
    }
}
