/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku;

import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.viewbox.yubinshikaku.YubinShikakuParameter;
import jp.co.ndensan.reams.af.afa.service.core.fuzaishashikaku.FuzaishaShikakuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
public class FuzaishaShikakuHandler {

    private final FuzaishaShikakuDiv div;
    private static final int 資格区分_有り = 0;
    private static final int 資格区分_無し = 1;
    private static final RString 投票資格種類_洋上 = new RString("2");
    private static final RString 投票資格種類_南極 = new RString("3");
    private static final RString Title_洋上投票資格 = new RString("洋上投票資格情報");
    private static final RString Title_南極投票資格 = new RString("南極投票資格情報");

    /**
     * コンストラクタです。
     *
     * @param div 不在者資格情報共有子DIV
     */
    public FuzaishaShikakuHandler(FuzaishaShikakuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 不在者資格情報共有子DIV
     * @return HenreiChohyoShokaiHandler
     */
    public static FuzaishaShikakuHandler of(FuzaishaShikakuDiv div) {
        return new FuzaishaShikakuHandler(div);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 投票資格種類 Code
     * @param 識別コード ShikibetsuCode
     */
    public void initialize(Code 投票資格種類, ShikibetsuCode 識別コード) {
        div.setTxtHdnNumber(new RString("1"));
        div.setTxtHdnTohyoShikakuShurui(投票資格種類.value());
        FuzaishaShikakuManager fuzaishaShikakuManager = FuzaishaShikakuManager.createInstance();
        FuzaishaShikakuResult fuzaishaTohyoShikaku = fuzaishaShikakuManager.get不在者投票資格情報(識別コード, 投票資格種類);
        div.setTxtHdnSeq(RString.EMPTY);
        if (fuzaishaTohyoShikaku != null) {
            if (!fuzaishaTohyoShikaku.get資格抹消年月日().isEmpty() && fuzaishaTohyoShikaku.get資格抹消年月日() != null
                    && fuzaishaTohyoShikaku.get資格抹消年月日().isBefore(new FlexibleDate(RDate.getNowDate().toDateString()))
                    || fuzaishaTohyoShikaku.get資格満了年月日() != null && !fuzaishaTohyoShikaku.get資格満了年月日().isEmpty()
                    && fuzaishaTohyoShikaku.get資格満了年月日().isBefore(new FlexibleDate(RDate.getNowDate().toDateString()))) {
                div.getRadShikakuKubun().setSelectedIndex(資格区分_無し);
                set不在者投票資格情報(fuzaishaTohyoShikaku);
                set無しの場合();
                ViewStateHolder.put(YubinShikakuParameter.不在者資格情報, new RString(Base64Serializer.serialize(fuzaishaTohyoShikaku.serialize())));
            } else {
                div.getRadShikakuKubun().setSelectedIndex(資格区分_有り);
                set不在者投票資格情報(fuzaishaTohyoShikaku);
                set有りの場合();
                ViewStateHolder.put(YubinShikakuParameter.不在者資格情報, new RString(Base64Serializer.serialize(fuzaishaTohyoShikaku.serialize())));
            }

        } else {
            div.getRadShikakuKubun().setSelectedIndex(資格区分_有り);
            clear();
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
            set有りの場合();
            ViewStateHolder.put(YubinShikakuParameter.不在者資格情報, RString.EMPTY);
        }

        div.getBtnCancel().setDisplayNone(true);

    }

    public void clear() {
        div.getTxtShikakuTorokuYMD().clearValue();
        div.getTxtKofuYMD().clearValue();
        div.getTxtManryoYMD().clearValue();
        div.getTxtMasshoYMD().clearValue();
        div.getCcdMasshoJiyu().clear();
    }

    public void set不在者投票資格情報(FuzaishaShikakuResult fuzaishaTohyoShikaku) {

        if (fuzaishaTohyoShikaku.get投票資格種類().getColumnValue().equals(投票資格種類_洋上)) {
            div.setTitle(Title_洋上投票資格);
        } else if (fuzaishaTohyoShikaku.get投票資格種類().getColumnValue().equals(投票資格種類_南極)) {
            div.setTitle(Title_南極投票資格);
        }
        if (fuzaishaTohyoShikaku.get資格登録年月日() != null && fuzaishaTohyoShikaku.get資格登録年月日().isValid()) {
            div.getTxtShikakuTorokuYMD().setValue(new RDate(fuzaishaTohyoShikaku.get資格登録年月日().toString()));
        }

        if (fuzaishaTohyoShikaku.get交付年月日() != null && fuzaishaTohyoShikaku.get交付年月日().isValid()) {
            div.getTxtKofuYMD().setValue(new RDate(fuzaishaTohyoShikaku.get交付年月日().toString()));
        }

        if (fuzaishaTohyoShikaku.get資格満了年月日() != null && fuzaishaTohyoShikaku.get資格満了年月日().isValid()) {
            div.getTxtManryoYMD().setValue(new RDate(fuzaishaTohyoShikaku.get資格満了年月日().toString()));
        }

        if (fuzaishaTohyoShikaku.get資格抹消年月日() != null && fuzaishaTohyoShikaku.get資格抹消年月日().isValid()) {
            div.getTxtMasshoYMD().setValue(new RDate(fuzaishaTohyoShikaku.get資格抹消年月日().toString()));
        }

        div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
        if (fuzaishaTohyoShikaku.get資格抹消事由コード() != null) {
            div.getCcdMasshoJiyu().initialize(fuzaishaTohyoShikaku.get資格抹消事由コード());
        }
        div.setTxtHdnSeq(new RString(fuzaishaTohyoShikaku.get履歴番号().toString()));
    }

    /**
     * 資格区分＝有りの場合、活性
     */
    public void set有りの場合() {
        div.getRadShikakuKubun().setReadOnly(false);
        div.getTxtShikakuTorokuYMD().setReadOnly(false);
        div.getTxtKofuYMD().setReadOnly(false);
        div.getTxtManryoYMD().setReadOnly(false);
        div.getTxtMasshoYMD().setReadOnly(true);
        div.getCcdMasshoJiyu().setRequiredMode(Boolean.FALSE);
        div.getCcdMasshoJiyu().setReadOnlyMode(Boolean.TRUE);
        div.getCcdMasshoJiyu().setDisabled(Boolean.TRUE);
    }

    /**
     * 資格区分＝無しの場合、非活性
     */
    public void set無しの場合() {
        div.getRadShikakuKubun().setReadOnly(false);
        div.getTxtShikakuTorokuYMD().setReadOnly(true);
        div.getTxtKofuYMD().setReadOnly(true);
        div.getTxtManryoYMD().setReadOnly(true);
        div.getTxtMasshoYMD().setReadOnly(false);
        div.getCcdMasshoJiyu().setRequiredMode(Boolean.TRUE);
        div.getCcdMasshoJiyu().setReadOnlyMode(Boolean.FALSE);
        div.getCcdMasshoJiyu().setDisabled(Boolean.FALSE);
    }

}
