/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyofuzui.KaikuSenkyoFuzui;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyoshikaku.KaikuSenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyoshikaku.SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuIdoShikakuIdoShoriEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho.KaikuFuzuiJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.kaikusenkyoninmeibo.KaikuSenkyoninMeiboManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区漁業調整委員会委員選挙人名簿登録handler
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuIdoShikakuIdoShoriHandler {

    private final KaikuIdoShikakuIdoShoriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 海区漁業調整委員会委員選挙人名簿登録Div
     */
    public KaikuIdoShikakuIdoShoriHandler(KaikuIdoShikakuIdoShoriDiv div) {
        this.div = div;
    }

    /**
     * edit選挙人名簿です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 画面 RString
     * @return 選挙人名簿
     */
    public SenkyoninMeiboEntity edit選挙人名簿(ShikibetsuCode 識別コード, RString 画面) {
        ShohonNo shohonNo = new ShohonNo(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo());
        SenkyoninMeiboEntity senkyoninMeibo = KaikuSenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(shohonNo, 識別コード);
        RString コンフィグ抄本_海区_ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);
        int 頁;
        int 行;
        int 枝番 = 0;
        if (null != senkyoninMeibo && !画面.equals(KaikuIdoShikakuIdoShoriEnum.RST_1.getValue())) {
            if ((senkyoninMeibo.get頁() + 1) > Integer.parseInt(コンフィグ抄本_海区_ページ行数.toString())) {
                頁 = senkyoninMeibo.get頁() + 1;
                枝番 = senkyoninMeibo.get枝番() + 1;
                行 = 1;
            } else {
                頁 = senkyoninMeibo.get頁();
                行 = senkyoninMeibo.get行() + 1;
            }
        } else if (null != senkyoninMeibo && 画面.equals(KaikuIdoShikakuIdoShoriEnum.RST_1.getValue())) {
            頁 = senkyoninMeibo.get頁();
            行 = senkyoninMeibo.get行();
        } else {
            頁 = 1;
            行 = 1;
        }
        boolean 投票区変更抹消フラグ = false;
        if (画面.equals(KaikuIdoShikakuIdoShoriEnum.RST_2.getValue())) {
            投票区変更抹消フラグ = true;
        }
        SenkyoninMeiboEntity 選挙人名簿 = new SenkyoninMeiboEntity(new ShohonNo(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo()),
                KaikuIdoShikakuIdoShoriEnum.RST_0.getValue(),
                div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().getCcdTohyokuCode().get投票区コード(),
                KaikuIdoShikakuIdoShoriEnum.RST_00.getValue(),
                頁,
                行,
                new BigSerial(1),
                識別コード,
                投票区変更抹消フラグ, 0, 枝番);

        return 選挙人名簿;
    }

    /**
     * edit選挙資格です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 画面 RString
     * @return 選挙資格
     */
    public KaikuSenkyoShikaku edit選挙資格(ShikibetsuCode 識別コード, RString 画面) {
        Code 選挙資格区分 = Code.EMPTY;
        RString 投票区コード = RString.EMPTY;
        FlexibleDate 名簿登録年月日 = FlexibleDate.EMPTY;
        Code 登録事由コード = Code.EMPTY;
        if (null != div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().getRadSenkyoShikaku()) {
            選挙資格区分 = new Code(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().getRadSenkyoShikaku().getSelectedKey());
        }
        if (null != div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdTohyokuCode()) {
            投票区コード = div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdTohyokuCode().get投票区コード();
        }
        if (null != div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getTxtMeiboTorokuYMD()) {
            名簿登録年月日 = new FlexibleDate(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getTxtMeiboTorokuYMD().getValue().toDateString());
        }
        if (null != div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdMeiboTorokuJiyu()) {
            登録事由コード = new Code(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdMeiboTorokuJiyu().getSelectJiyuCode());
        }
        FlexibleDate 抹消年月日 = FlexibleDate.EMPTY;
        Code 抹消事由コード = Code.EMPTY;
        if (画面.equals(KaikuIdoShikakuIdoShoriEnum.RST_2.getValue())) {
            RDate 画面_抹消年月日 = div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getTxtMasshoYMD().getValue();
            if (null != div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getTxtMasshoYMD().getValue()) {
                抹消年月日 = new FlexibleDate(画面_抹消年月日.toDateString());
            }
            if (null != div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdMasshoJiyu().getSelectJiyuCode()) {
                抹消事由コード = new Code(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoTohyoShikakuJoho().get選挙資格情報().getCcdMasshoJiyu().getSelectJiyuCode());
            }
        }
        KaikuSenkyoShikaku 選挙資格 = new KaikuSenkyoShikaku(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()),
                識別コード,
                new BigSerial(1),
                選挙資格区分,
                投票区コード,
                名簿登録年月日,
                登録事由コード,
                FlexibleDate.EMPTY,
                Code.EMPTY,
                FlexibleDate.EMPTY,
                Code.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                抹消年月日,
                抹消事由コード,
                FlexibleDate.EMPTY,
                Boolean.FALSE,
                FlexibleDate.getNowDate()
        );
        return 選挙資格;
    }

    /**
     * insert選挙資格です。
     *
     * @param 識別コード ShikibetsuCode
     * @return insert海区付随情報
     */
    public boolean insert海区付随情報(ShikibetsuCode 識別コード) {
        return KaikuSenkyoninMeiboManager.createInstance().insert海区付随情報(
                edit選挙資格(識別コード, KaikuIdoShikakuIdoShoriEnum.RST_0.getValue()),
                edit選挙人名簿(識別コード, KaikuIdoShikakuIdoShoriEnum.RST_0.getValue()), edit海区付随情報(識別コード));
    }

    /**
     * update海区付随情報です。
     *
     * @param 海区付随情報 KaikuSenkyoFuzuiResult
     * @param 識別コード ShikibetsuCode
     * @return update海区付随情報
     */
    public boolean update海区付随情報(KaikuSenkyoFuzuiResult 海区付随情報, ShikibetsuCode 識別コード) {
        return KaikuSenkyoninMeiboManager.createInstance().update海区付随情報(
                edit選挙資格(識別コード, KaikuIdoShikakuIdoShoriEnum.RST_1.getValue()),
                edit選挙人名簿(識別コード, KaikuIdoShikakuIdoShoriEnum.RST_1.getValue()), 海区付随情報);
    }

    /**
     * update選挙資格です。
     *
     * @param 海区付随情報 KaikuSenkyoFuzuiResult
     * @param 識別コード ShikibetsuCode
     * @return 海区付随情報
     */
    public KaikuSenkyoFuzuiResult edit海区付随情報(KaikuSenkyoFuzuiResult 海区付随情報, ShikibetsuCode 識別コード) {

        海区付随情報.set抄本番号(new ShohonNo(
                div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo()));
        海区付随情報.set識別コード(識別コード);
        海区付随情報.set組合コード(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().
                getCcdGyogyoKumiaiCode().get組合コード選択Div().getTxtKumiaiCode().getValue());
        海区付随情報.set漁業者番号(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getTxtGyogyoshaBango().getText());
        海区付随情報.set漁業日数_漁業者(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getTxtGyogyoshaNissu().getValue().intValue());
        海区付随情報.set漁業日数_漁業従事者(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getTxtGyogyoJujishaNissu().getValue().intValue());
        海区付随情報.set漁業種類(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdGyogyoShurui().getCode());
        海区付随情報.set使用漁船種別(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdGyosenShubetsu().getCode());
        海区付随情報.set船名(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getTxtSenmei().getText());
        海区付随情報.set登録番号(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getTxtTorokuBango().getText());

        return 海区付随情報;
    }

    /**
     * delete選挙資格です。
     *
     * @param 海区付随情報 KaikuSenkyoFuzuiResult
     * @param 識別コード ShikibetsuCode
     * @return update海区付随情報
     */
    public boolean delete海区付随情報(KaikuSenkyoFuzuiResult 海区付随情報, ShikibetsuCode 識別コード) {
        return KaikuSenkyoninMeiboManager.createInstance().delete海区付随情報(
                edit選挙資格(識別コード, KaikuIdoShikakuIdoShoriEnum.RST_2.getValue()),
                edit選挙人名簿(識別コード, KaikuIdoShikakuIdoShoriEnum.RST_2.getValue()), 海区付随情報);
    }

    private KaikuSenkyoFuzui edit海区付随情報(ShikibetsuCode 識別コード) {
        RString 漁業者番号 = RString.EMPTY;
        RString 組合コード = RString.EMPTY;
        int 漁業日数_漁業者 = 0;
        int 漁業日数_漁業従事者 = 0;
        Code 漁業種類 = Code.EMPTY;
        Code 使用漁船種別 = Code.EMPTY;
        RString 船名 = RString.EMPTY;
        RString 登録番号 = RString.EMPTY;
        KaikuFuzuiJohoDiv 海区付随情報画面 = div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報();

        if (!海区付随情報画面.getTxtGyogyoshaBango().getText().isEmpty()) {
            漁業者番号 = 海区付随情報画面.getTxtGyogyoshaBango().getText();
        }
        if (null != 海区付随情報画面.getCcdGyogyoKumiaiCode().get組合コード選択Div().getTxtKumiaiCode()) {
            組合コード = 海区付随情報画面.getCcdGyogyoKumiaiCode().get組合コード選択Div().getTxtKumiaiCode().getValue();
        }
        if (null != 海区付随情報画面.getTxtGyogyoshaNissu().getValue()) {
            漁業日数_漁業者 = 海区付随情報画面.getTxtGyogyoshaNissu().getValue().intValue();
        }
        if (null != 海区付随情報画面.getTxtGyogyoJujishaNissu().getValue()) {
            漁業日数_漁業従事者 = 海区付随情報画面.getTxtGyogyoJujishaNissu().getValue().intValue();
        }
        if (海区付随情報画面.getCcdGyogyoShurui().isコード入力済み()) {
            漁業種類 = 海区付随情報画面.getCcdGyogyoShurui().getCode();
        }
        if (海区付随情報画面.getCcdGyosenShubetsu().isコード入力済み()) {
            使用漁船種別 = 海区付随情報画面.getCcdGyosenShubetsu().getCode();
        }
        if (null != 海区付随情報画面.getTxtSenmei()) {
            船名 = 海区付随情報画面.getTxtSenmei().getText();
        }
        if (null != 海区付随情報画面.getTxtTorokuBango()) {
            登録番号 = 海区付随情報画面.getTxtTorokuBango().getText();
        }

        return new KaikuSenkyoFuzui(
                new ShohonNo(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo()),
                識別コード,
                漁業者番号,
                組合コード,
                漁業日数_漁業者,
                漁業日数_漁業従事者,
                漁業種類,
                使用漁船種別,
                船名,
                登録番号
        );
    }
}
