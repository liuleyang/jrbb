/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.FuzaishaShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.FuzaishaShikakuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.viewbox.yubinshikaku.YubinShikakuParameter;
import jp.co.ndensan.reams.af.afa.service.core.fuzaishashikaku.FuzaishaShikakuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 不在者資格情報共有子DIVのコントロールクラスです。
 *
 * @reamsid_L AF-0210-020 liuj
 */
public class FuzaishaShikaku {

    private static final int 交付日 = 7;
    private final RString 洋上投票資格登録_2 = new RString("2");
    private static final int 資格区分_有り = 0;
    private static final int 資格区分_無し = 1;

    /**
     * ダイアログとして呼び出された場合、各項目は非活性にします。
     *
     * @param div FuzaishaShikakuDiv
     * @return ResponseData<FuzaishaShikakuDiv>
     */
    public ResponseData<FuzaishaShikakuDiv> onLoad(FuzaishaShikakuDiv div) {
        if (RString.isNullOrEmpty(div.getTxtHdnNumber())) {
            RString 識別コード = div.getTxtHdnShikibetsuCode();
            RString 投票資格種類 = div.getTxtHdnTohyoShikakuShurui();
            FuzaishaShikakuManager fuzaishaShikakuManager = FuzaishaShikakuManager.createInstance();
            FuzaishaShikakuResult fuzaishaTohyoShikaku = fuzaishaShikakuManager.get不在者投票資格情報(new ShikibetsuCode(識別コード), new Code(投票資格種類));

            if ((fuzaishaTohyoShikaku != null) && (fuzaishaTohyoShikaku.get資格抹消年月日() != null && fuzaishaTohyoShikaku.get資格抹消年月日().
                    isBefore(new FlexibleDate(RDate.getNowDate().toDateString())) || fuzaishaTohyoShikaku.get資格満了年月日() != null
                    && fuzaishaTohyoShikaku.get資格満了年月日().isBefore(new FlexibleDate(RDate.getNowDate().toDateString())))) {
                div.getRadShikakuKubun().setSelectedIndex(資格区分_無し);
                FuzaishaShikakuHandler.of(div).set不在者投票資格情報(fuzaishaTohyoShikaku);
                ViewStateHolder.put(YubinShikakuParameter.不在者資格情報, new RString(Base64Serializer.serialize(fuzaishaTohyoShikaku.serialize())));
            } else if (fuzaishaTohyoShikaku != null) {
                div.getRadShikakuKubun().setSelectedIndex(資格区分_有り);
                FuzaishaShikakuHandler.of(div).set不在者投票資格情報(fuzaishaTohyoShikaku);
                ViewStateHolder.put(YubinShikakuParameter.不在者資格情報, new RString(Base64Serializer.serialize(fuzaishaTohyoShikaku.serialize())));
            } else {
                div.getRadShikakuKubun().setSelectedIndex(資格区分_有り);
                FuzaishaShikakuHandler.of(div).clear();
                ViewStateHolder.put(YubinShikakuParameter.不在者資格情報, RString.EMPTY);
            }
            set項目状態(div);
        }

        return getResponseData(div);
    }

    private void set項目状態(FuzaishaShikakuDiv div) {
        div.getRadShikakuKubun().setReadOnly(true);
        div.getTxtShikakuTorokuYMD().setReadOnly(true);
        div.getTxtKofuYMD().setReadOnly(true);
        div.getTxtManryoYMD().setReadOnly(true);
        div.getTxtMasshoYMD().setReadOnly(true);
        div.getCcdMasshoJiyu().setReadOnlyMode(true);
    }

    /**
     * 交付日を入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div FuzaishaShikakuDiv
     * @return ResponseData<FuzaishaShikakuDiv>
     */
    public ResponseData<FuzaishaShikakuDiv> onBlur_txtKofuYMD(FuzaishaShikakuDiv div) {
        RDate kofuYMD = div.getTxtKofuYMD().getValue();
        if (div.getTxtHdnTohyoShikakuShurui().equals(洋上投票資格登録_2) && kofuYMD != null) {
            div.getTxtManryoYMD().setValue(kofuYMD.plusYear(交付日));
        }
        return getResponseData(div);
    }

    private ResponseData<FuzaishaShikakuDiv> getResponseData(FuzaishaShikakuDiv div) {
        ResponseData<FuzaishaShikakuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 資格区分のonChangeイベントメソッドです。
     *
     * @param div FuzaishaShikakuDiv
     * @return ResponseData<FuzaishaShikakuDiv>
     */
    public ResponseData<FuzaishaShikakuDiv> onChange_btnRadShikakuKubun(FuzaishaShikakuDiv div) {
        RString 不在者資格情報文字列 = ViewStateHolder.get(YubinShikakuParameter.不在者資格情報, RString.class);
        if (RString.isNullOrEmpty(不在者資格情報文字列)) {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
            FuzaishaShikakuHandler.of(div).clear();
        } else {
            FuzaishaShikakuHandler.of(div).clear();
            FuzaishaShikakuHandler.of(div).set不在者投票資格情報(Base64Serializer.deSerialize(不在者資格情報文字列.toString(), FuzaishaShikakuResult.class));
        }

        int 資格区分 = div.getRadShikakuKubun().getSelectedIndex();
        if (資格区分 == 0) {
            div.getTxtMasshoYMD().setRequired(false);
            div.getTxtShikakuTorokuYMD().setRequired(true);
            div.getTxtKofuYMD().setRequired(true);
            div.getTxtManryoYMD().setRequired(true);
            FuzaishaShikakuHandler.of(div).set有りの場合();
        } else {
            div.getTxtMasshoYMD().setRequired(true);
            div.getTxtShikakuTorokuYMD().setRequired(false);
            div.getTxtKofuYMD().setRequired(false);
            div.getTxtManryoYMD().setRequired(false);
            FuzaishaShikakuHandler.of(div).set無しの場合();
        }
        return getResponseData(div);
    }

}
