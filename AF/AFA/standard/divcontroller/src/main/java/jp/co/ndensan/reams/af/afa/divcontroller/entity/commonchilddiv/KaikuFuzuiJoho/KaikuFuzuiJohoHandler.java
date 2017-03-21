/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho;

import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiParameter;
import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaViewStateHolderKey;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.kaikufuzuijoho.KaikufuzuijohoManger;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 海区付随情報クラスです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public class KaikuFuzuiJohoHandler {

    private final KaikuFuzuiJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 海区付随情報Div
     */
    public KaikuFuzuiJohoHandler(KaikuFuzuiJohoDiv div) {
        this.div = div;
    }

    /**
     * 識別コードから、付随情報をセットする。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    public void initialize(ShikibetsuCode shikibetsuCode) {
        clearThisPanel();
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().initialize();
        div.getCcdShohonNameList().getDdlShohonItem().setSelectedIndex(0);
        div.getCcdShohonNameList().changeDdlShohon();
        div.setTxtHiddenShikibetsuCode(shikibetsuCode.value());
        div.getCcdGyogyoKumiaiCode().initialize(RString.EMPTY);
        RString shohonNo = div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey();
        RString hiddenShikibetsuCode = div.getTxtHiddenShikibetsuCode();
        KaikuSenkyoFuzuiParameter parameter = new KaikuSenkyoFuzuiParameter();
        KaikuSenkyoFuzuiResult result;
        if (!shohonNo.isNullOrEmpty()) {
            parameter.set抄本番号(new ShohonNo(shohonNo));
            parameter.set識別コード(new ShikibetsuCode(hiddenShikibetsuCode));
            KaikufuzuijohoManger kaikufuzuijohoManger = KaikufuzuijohoManger.createInstance();
            result = kaikufuzuijohoManger.get海区付随情報(parameter);
            if (result != null) {
                set表示画面(result);
                div.setHdnKaikuSenkyoFuzuiJoho(new RString(Base64Serializer.serialize(new KaikuSenkyoFuzuiResult(result.getEntity()).serialize())));
            }
        }
        set表示状態();
    }

    private void set表示画面(KaikuSenkyoFuzuiResult result) {
        if (AFAMenuId.AFAMNK1060_選挙人名簿登録.equals(
                ViewStateHolder.get(AfaViewStateHolderKey.遷移元画面Key, AFAMenuId.class))) {
            div.getTxtGyogyoshaBango().setValue(null);
            div.getCcdGyogyoKumiaiCode().clear();
            div.getTxtGyogyoshaNissu().setValue(null);
            div.getTxtGyogyoJujishaNissu().setValue(null);
            div.getCcdGyogyoShurui().clear();
            div.getCcdGyogyoShurui().clear();
            div.getCcdGyosenShubetsu().clear();
            div.getTxtSenmei().setValue(null);
            div.getTxtTorokuBango().setValue(null);
        } else {
            if (!result.get漁業者番号().isNull() && !result.get漁業者番号().isEmpty()) {
                div.getTxtGyogyoshaBango().setValue(new Decimal(result.get漁業者番号().toString()));
            }

            if (!result.get組合コード().isNullOrEmpty()) {
                div.getCcdGyogyoKumiaiCode().initialize(result.get組合コード());
            }
            div.getTxtGyogyoshaNissu().setValue(new Decimal(result.get漁業日数_漁業者()));
            div.getTxtGyogyoJujishaNissu().setValue(new Decimal(result.get漁業日数_漁業従事者()));
            div.getCcdGyogyoShurui().load(AFACodeShubetsu.漁業種類.getCodeShubetsu(), result.get漁業種類());
            div.getCcdGyosenShubetsu().load(AFACodeShubetsu.漁船種別.getCodeShubetsu(), result.get使用漁船種別());
            div.getTxtSenmei().setValue(result.get船名());
            div.getTxtTorokuBango().setValue(result.get登録番号());

        }

    }

    private void set表示状態() {
        if (AFAMenuId.AFAMNK1080_選挙人名簿削除.equals(
                ViewStateHolder.get(AfaViewStateHolderKey.遷移元画面Key, AFAMenuId.class))) {
            div.getCcdShohonNameList().setReadOnlyMode(Boolean.TRUE);
            div.getTxtGyogyoshaBango().setDisabled(Boolean.TRUE);
            div.getCcdGyogyoKumiaiCode().setDisabled(Boolean.TRUE);
            div.getTxtGyogyoJujishaNissu().setDisabled(Boolean.TRUE);
            div.getTxtGyogyoshaNissu().setDisabled(Boolean.TRUE);

        } else {
            div.getCcdShohonNameList().setReadOnlyMode(Boolean.FALSE);
            div.getTxtGyogyoshaBango().setDisabled(Boolean.FALSE);
            div.getCcdGyogyoKumiaiCode().setDisabled(Boolean.FALSE);
            div.getTxtGyogyoJujishaNissu().setDisabled(Boolean.FALSE);
            div.getTxtGyogyoshaNissu().setDisabled(Boolean.FALSE);
        }

        div.getCcdGyogyoShurui().setDisplayNone(Boolean.TRUE);
        div.getCcdGyosenShubetsu().setDisplayNone(Boolean.TRUE);
        div.getTxtSenmei().setDisplayNone(Boolean.TRUE);
        div.getTxtTorokuBango().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 抄本番号と識別コードから、付随情報をセットする。
     *
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     */
    public void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode) {
        clearThisPanel();
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().initialize();
        div.setTxtHiddenShikibetsuCode(shikibetsuCode.value());
        RString hiddenShikibetsuCode = div.getTxtHiddenShikibetsuCode();
        KaikuSenkyoFuzuiParameter parameter = new KaikuSenkyoFuzuiParameter();
        if (!RString.isNullOrEmpty(shohonNo)) {
            parameter.set抄本番号(new ShohonNo(shohonNo));
            parameter.set識別コード(new ShikibetsuCode(hiddenShikibetsuCode));
            KaikufuzuijohoManger kaikufuzuijohoManger = KaikufuzuijohoManger.createInstance();
            KaikuSenkyoFuzuiResult result = kaikufuzuijohoManger.get海区付随情報(parameter);
            if (result != null) {
                set表示画面(result);
                div.setHdnKaikuSenkyoFuzuiJoho(new RString(Base64Serializer.serialize(new KaikuSenkyoFuzuiResult(result.getEntity()).serialize())));
            }
        }

        set表示状態();

    }

    /**
     * 抄本番号と識別コードから、付随情報をセットする。
     *
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     */
    public void changeDdlShohon(RString shohonNo, ShikibetsuCode shikibetsuCode) {
        clearThisPanel();
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.setTxtHiddenShikibetsuCode(shikibetsuCode.value());
        KaikuSenkyoFuzuiParameter parameter = new KaikuSenkyoFuzuiParameter();
        RString hiddenShikibetsuCode = div.getTxtHiddenShikibetsuCode();
        if (!shohonNo.isNullOrEmpty()) {
            KaikufuzuijohoManger kaikufuzuijohoManger = KaikufuzuijohoManger.createInstance();
            parameter.set抄本番号(new ShohonNo(shohonNo));
            parameter.set識別コード(new ShikibetsuCode(hiddenShikibetsuCode));
            KaikuSenkyoFuzuiResult result = kaikufuzuijohoManger.get海区付随情報(parameter);
            if (result != null) {
                set表示画面(result);
                div.setHdnKaikuSenkyoFuzuiJoho(new RString(Base64Serializer.serialize(new KaikuSenkyoFuzuiResult(result.getEntity()).serialize())));
            }
        }
    }

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     */
    public void clearThisPanel() {
        div.getTxtGyogyoshaBango().clearValue();
        div.getCcdGyogyoKumiaiCode().clear();
        div.getTxtGyogyoshaNissu().clearValue();
        div.getTxtGyogyoJujishaNissu().clearValue();

        if (div.isDisabled()) {
            div.getCcdShohonNameList().setDisplayNoneMode(true);
            div.getCcdGyogyoKumiaiCode().setReadOnlyMode(Boolean.TRUE);
        }
    }

    /**
     * 共有子Divの表示状態（表示／非表示）モードを設定します。
     *
     * @param displayNoneSetMode 表示状態（表示／非表示）
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        div.setDisplayNone(displayNoneSetMode);
    }

    /**
     * 共有子Divの表示状態（表示／非表示）を返します。
     *
     * @return 表示状態（表示／非表示）
     */
    public boolean isDisplayNoneMode() {
        return div.isDisplayNone();
    }

}
