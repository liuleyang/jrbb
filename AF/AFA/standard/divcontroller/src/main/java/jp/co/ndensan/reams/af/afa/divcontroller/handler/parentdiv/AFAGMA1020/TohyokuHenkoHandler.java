/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1020;

import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.SenkyoninMeiboJoho;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.SenkyoninMeiboSearchResult;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.ShikibetsuTaishoSearchResult;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.configkeys.tohyokuhenko.TohyokuHenkoCode;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokuhenko.TohyokuHenkoMyBatisParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1020.TohyokuHenkoDiv;
import jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku.SenkyojiTourokuValidationService;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyokuhenko.TohyokuHenkoManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 投票区変更のハンドラクラスです。
 *
 * @reamsid_L AF-0050-010 qiuxy
 */
public class TohyokuHenkoHandler {

    private final TohyokuHenkoDiv div;
    private static final RString ラジオ_1 = new RString("key0");
    private static final int 異常処理 = 0;
    private static final RString 入場券発行済み_追加メッセージ = new RString("投票区変更");

    /**
     * コンストラクタです。
     *
     * @param div 投票区変更Div
     */
    public TohyokuHenkoHandler(TohyokuHenkoDiv div) {
        this.div = div;
    }

    /**
     * 変更前名簿番号と投票区情報取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     */
    public void 変更前名簿番号と投票区情報取得(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {

        SenkyoninMeiboSearchResult meiboSearchResult = new TohyokuHenkoManager().get変更前名簿番号(抄本番号, 識別コード, false);
        if (null != meiboSearchResult) {
            out名簿番号アクセスログ出力(識別コード);
            SenkyoninMeiboJoho 登録用選挙人名簿 = new SenkyoninMeiboJoho();
            SenkyoninMeiboJoho 更新用選挙人名簿 = new SenkyoninMeiboJoho();
            登録用選挙人名簿.setSeq(meiboSearchResult.getSeq());
            登録用選挙人名簿.setGroupCode(meiboSearchResult.getGroupCode());
            更新用選挙人名簿.setShohonNo(抄本番号);
            更新用選挙人名簿.setTohyokuCode(meiboSearchResult.getTohyokuCode());
            更新用選挙人名簿.setSeq(meiboSearchResult.getSeq());
            更新用選挙人名簿.setShikibetsuCode(識別コード);
            ViewStateHolder.put(TohyokuHenkoCode.登録用選挙人名簿キー, 登録用選挙人名簿);
            ViewStateHolder.put(TohyokuHenkoCode.更新用選挙人名簿キー, 更新用選挙人名簿);
            ViewStateHolder.put(TohyokuHenkoCode.検索結果, meiboSearchResult);
            div.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuBefore().initialize(meiboSearchResult.getTohyokuCode());
            div.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoBefore().initialize(meiboSearchResult.getSatsu(),
                    new Decimal(meiboSearchResult.getPage()), new Decimal(meiboSearchResult.getGyo()));
        }
    }

    /**
     * 初期の変更後投票区情報を取得します。
     *
     * @param 選挙種類 SenkyoShurui
     * @param 識別コード ShikibetsuCode
     * @param 抄本番号 ShohonNo
     */
    public void 初期の変更後投票区(SenkyoShurui 選挙種類, ShikibetsuCode 識別コード, ShohonNo 抄本番号) {
        if ((選挙種類 == SenkyoShurui.定時登録) || (選挙種類 == SenkyoShurui.国政選挙_地方選挙)) {
            ShikibetsuTaishoSearchResult taishoSearchResult = new TohyokuHenkoManager().直近宛名PSM取得(識別コード);
            if ((null != taishoSearchResult) && (null != taishoSearchResult.getTohyokuCode())) {
                div.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter().initialize(taishoSearchResult.getTohyokuCode().getColumnValue());
                採番処理(抄本番号, 識別コード, taishoSearchResult.getTohyokuCode().getColumnValue());
            }
        } else if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            RString tohyokuCode = 初期の国民投票抄本投票区(識別コード, 選挙種類);
            if (!RString.isNullOrEmpty(tohyokuCode)) {
                div.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter().initialize(tohyokuCode);
                採番処理(抄本番号, 識別コード, tohyokuCode);
            }
        }
    }

    private RString 初期の国民投票抄本投票区(ShikibetsuCode 識別コード, SenkyoShurui 選挙種類) {
        TohyokuHenkoMyBatisParameter key = createTohyokuHenkoMyBatisParameter(識別コード, 選挙種類);
        return new TohyokuHenkoManager().get初期の変更後投票区(key);

    }

    private TohyokuHenkoMyBatisParameter createTohyokuHenkoMyBatisParameter(ShikibetsuCode 識別コード, SenkyoShurui 選挙種類) {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        return new TohyokuHenkoMyBatisParameter(識別コード, 選挙種類, builder.build());

    }

    /**
     * 採番処理です。
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @param 投票区コード RString
     */
    public void 採番処理(ShohonNo 抄本番号, ShikibetsuCode 識別コード, RString 投票区コード) {
        if (!div.getTxtHdnSenkyoShurui().equals(SenkyoShurui.定時登録.getCode()) && !SenkyojiTourokuValidationService.createInstance().validate入場券発行済(new RString(抄本番号.toString()))) {
            throw new ApplicationException(AfErrorMessages.入場券発行済.getMessage().replace(入場券発行済み_追加メッセージ.toString()));
        }
        SenkyoninMeiboJoho 登録用選挙人名簿 = ViewStateHolder.get(TohyokuHenkoCode.登録用選挙人名簿キー, SenkyoninMeiboJoho.class);
        SenkyoninMeiboSearchResult meiboSearchResult = new TohyokuHenkoManager().get変更後名簿番号(抄本番号, 識別コード, false, 投票区コード);
        if (null != meiboSearchResult) {
            if (Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_ページ行数, SubGyomuCode.AFA選挙本体).toString()) == meiboSearchResult.
                    getGyo()) {
                登録用選挙人名簿.setGyo(1);
                登録用選挙人名簿.setPage(meiboSearchResult.getPage() + 1);
                登録用選挙人名簿.setRenban(meiboSearchResult.getRenban() + 1);
            } else {
                登録用選挙人名簿.setPage(meiboSearchResult.getPage());
                登録用選挙人名簿.setGyo(meiboSearchResult.getGyo() + 1);
                登録用選挙人名簿.setRenban(meiboSearchResult.getRenban());
            }

            登録用選挙人名簿.setShohonNo(meiboSearchResult.getShohonNo());
            登録用選挙人名簿.setGroupCode(meiboSearchResult.getGroupCode());

            TohyokuCodeSelectDiv tohyokuAfter = (TohyokuCodeSelectDiv) (div.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter());
            登録用選挙人名簿.setTohyokuCode(tohyokuAfter.getTxtTohyokuCode().getValue());
            登録用選挙人名簿.setSatsu(meiboSearchResult.getSatsu());

            登録用選挙人名簿.setShikibetsuCode(meiboSearchResult.getShikibetsuCode());
            登録用選挙人名簿.setTohyokuHenkoMasshoFlag(false);

            登録用選挙人名簿.setEdaban(meiboSearchResult.getEdaban());
            ViewStateHolder.put(TohyokuHenkoCode.登録用選挙人名簿キー, 登録用選挙人名簿);
            div.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoAfter().initialize(登録用選挙人名簿.getSatsu(),
                    new Decimal(登録用選挙人名簿.getPage()), new Decimal(登録用選挙人名簿.getGyo()));
        } else {
            RString 変更前情報の冊 = div.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoBefore().get冊();
            div.getTohyokuHenkoMeiboBangoJoho().getCcdMeiboBangoAfter().initialize(変更前情報の冊, Decimal.ONE, Decimal.ONE);
            登録用選挙人名簿.setShohonNo(抄本番号);
            登録用選挙人名簿.setTohyokuCode(div.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter().get投票区コード());
            登録用選挙人名簿.setSatsu(変更前情報の冊);
            登録用選挙人名簿.setPage(1);
            登録用選挙人名簿.setGyo(1);
            登録用選挙人名簿.setShikibetsuCode(識別コード);
            登録用選挙人名簿.setTohyokuHenkoMasshoFlag(false);
            登録用選挙人名簿.setRenban(new TohyokuHenkoManager().get選択した抄本内のMAX連番(抄本番号) + 1);
            登録用選挙人名簿.setEdaban(0);
            ViewStateHolder.put(TohyokuHenkoCode.登録用選挙人名簿キー, 登録用選挙人名簿);
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), Boolean.FALSE);
    }

    /**
     * 保存処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @return keka
     */
    public boolean 保存処理(ShikibetsuCode 識別コード) {

        boolean keka = false;
        SenkyoninMeiboSearchResult meiboSearchResult = ViewStateHolder.get(TohyokuHenkoCode.検索結果, SenkyoninMeiboSearchResult.class);

        // TODO handlerには、ViewStateHolderは使用しない。
        SenkyoninMeiboJoho 登録用選挙人名簿 = ViewStateHolder.get(TohyokuHenkoCode.登録用選挙人名簿キー, SenkyoninMeiboJoho.class);
        SenkyoninMeiboJoho 更新用選挙人名簿 = ViewStateHolder.get(TohyokuHenkoCode.更新用選挙人名簿キー, SenkyoninMeiboJoho.class);
        int 選挙人名簿updata = new TohyokuHenkoManager().選挙人名簿更新(meiboSearchResult);
        if (選挙人名簿updata == 0) {
            keka = false;
        } else {
            int 選挙人名簿insert = new TohyokuHenkoManager().選挙人名簿登録(登録用選挙人名簿);
            if (異常処理 != 選挙人名簿updata && 異常処理 != 選挙人名簿insert) {
                keka = true;
            }
            if (!div.getTohyokuHenkoMeiboBangoJoho().getRadTekiyoNaiyo().getSelectedKey().equals(ラジオ_1) && keka) {
                TohyokuCodeSelectDiv tohyokuAfter = (TohyokuCodeSelectDiv) (div.getTohyokuHenkoMeiboBangoJoho().getCcdTohyokuAfter());
                更新用選挙人名簿.setTohyokuCode(tohyokuAfter.getTxtTohyokuCode().getValue());
                keka = 選挙資格更新(更新用選挙人名簿);
            }
        }
        if (keka) {
            out保存アクセスログ出力(識別コード);
        }
        return keka;

    }

    /**
     * 選挙資格更新します。
     *
     * @param 更新用選挙人名簿情報 SenkyoninMeiboJoho
     * @return 更新件数
     */
    private boolean 選挙資格更新(SenkyoninMeiboJoho 更新用選挙人名簿情報) {
        boolean keka = false;
        if (new TohyokuHenkoManager().選挙資格更新(更新用選挙人名簿情報) != 異常処理) {
            keka = true;
        }
        return keka;
    }

    private void out名簿番号アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
    }

    /**
     * アクセスログです。
     *
     * @param 識別コード
     */
    private void out保存アクセスログ出力(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
    }

    /**
     * 抹消者であるかどうかを判定します。
     *
     * @param 識別コード ShikibetsuCode
     * @return boolean
     */
    public boolean is抹消者(ShikibetsuCode 識別コード) {
        ShikakuHantei hantei = new ShikakuHantei();
        ShikibetsuTaishoSearchResult taishoSearchResult = new TohyokuHenkoManager().直近宛名PSM取得(識別コード);
        return hantei.is抹消者(taishoSearchResult.getShikibetsuTaishoEntity(),
                new FlexibleDate(div.getCcdTohyokuHenkoTaishoShohonJoho().get転出期限日().toDateString()),
                new FlexibleDate(div.getCcdTohyokuHenkoTaishoShohonJoho().get年齢到達日().toDateString()));
    }

    /**
     * 入場券出力済みかどうかを判定します。
     *
     * @param 抄本番号 ShohonNo
     * @return boolean
     */
    public boolean is入場券出力済み(ShohonNo 抄本番号) {
        Decimal 入場券発行固有連番 = ShohonManager.createInstance().get抄本(抄本番号).get入場券発行固有連番();
        return !Decimal.ZERO.equals(入場券発行固有連番);
    }
}
