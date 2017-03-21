/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.contexts.HojoshaNyuryokuContext;
import jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku.HojoshaNyuryokuModel;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HojoshaNyuryokuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してHojoshaNyuryokuDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0080-030 wangm
 */
public class HojoshaNyuryokuHandler {

    private static final RString TITLE = new RString("補助者入力");
    private static final List メニューID = Arrays.asList(new RString("AFAMNE1010"),
            new RString("AFAMNE2030"),
            new RString("AFAMNE3010"),
            new RString("AFAMNE7020"),
            new RString("AFAMNE7010"));

    private final HojoshaNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 補助者入力Div
     */
    public HojoshaNyuryokuHandler(HojoshaNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 初期表示時のイベントメソッドです。
     *
     */
    public void initialize() {

        setDialogMode(メニューID.contains(ViewState.getメニューID()));
        clearThisPanelForCheckBox();
        div.getChkDairiTohyo().getSelectedItems().clear();
        set補助者を不可にする(true);
    }

    private void setDialogMode(Boolean mode) {
        // false：ダイアログ状態にする　　true：複合コントロールのようにする
        div.setEraseBorder(mode);
        div.getBtnOK().setDisplayNone(mode);
        div.getBtnCancel().setDisplayNone(mode);
        div.setTitle(!mode ? TITLE : RString.EMPTY);
    }

    /**
     * 補助者を初期表示します。
     *
     * @param model HojoshaNyuryokuModel
     */
    public void setDialog(HojoshaNyuryokuModel model) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可

        if (model.getDairiTohyoAri()) {
            div.getChkDairiTohyo().setSelectedItemsByKey(Arrays.asList(new RString("key0")));
            div.getTxtHojosha1ShikibetsuCode().setDomain(model.getShikibetsuCode1());
            div.getTxtHojoshaShimei1().setValue(model.getMeisho1());
            div.getTxtHojosha2ShikibetsuCode().setDomain(model.getShikibetsuCode2());
            div.getTxtHojoshaShimei2().setValue(model.getMeisho2());
        }
        set補助者を不可にする(false);

    }

    /**
     * 補助者の入力可否をセットします。
     *
     * @param blnShiyoFuka 入力可否（True：画面での入力不可、False：画面での入力可）
     */
    public void set補助者を不可にする(Boolean blnShiyoFuka) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可

        div.getChkDairiTohyo().setReadOnly(blnShiyoFuka);
        div.getTxtHojoshaShimei1().setReadOnly(true);
        div.getTxtHojoshaShimei2().setReadOnly(true);
        div.getBtnHojosha1Search().setDisabled(true);
        div.getBtnHojosha2Search().setDisabled(true);
//        div.getTxtHojoshaShimei1().setRequired(false);
//        div.getTxtHojoshaShimei2().setRequired(false);
        if (!div.getChkDairiTohyo().getSelectedItems().isEmpty()) {
            div.getTxtHojoshaShimei1().setReadOnly(blnShiyoFuka);
            div.getTxtHojoshaShimei2().setReadOnly(blnShiyoFuka);
            div.getBtnHojosha1Search().setDisabled(blnShiyoFuka);
            div.getBtnHojosha2Search().setDisabled(blnShiyoFuka);
//            div.getTxtHojoshaShimei1().setRequired(!blnShiyoFuka);
//            div.getTxtHojoshaShimei2().setRequired(!blnShiyoFuka);
        }

    }

    /**
     * 画面クリアのメソッドです。<br />
     * 代理投票チェックボックスクリック時用
     *
     */
    public void clearThisPanelForCheckBox() {
        div.getTxtHojoshaShimei1().clearValue();
        div.getTxtHojoshaShimei2().clearValue();
        div.getTxtHojosha1ShikibetsuCode().setDomain(ShikibetsuCode.EMPTY);
        div.getTxtHojosha2ShikibetsuCode().setDomain(ShikibetsuCode.EMPTY);

    }

    /**
     * 補助者入力のContextを取得します。
     *
     * @return HojoshaNyuryokuContext 補助者入力Context
     */
    public HojoshaNyuryokuContext getHojoshaNyuryokuContext() {
        Boolean hojoshaNyuryoku = (div.getChkDairiTohyo().getSelectedKeys().isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
        return new HojoshaNyuryokuContext(
                hojoshaNyuryoku,
                div.getTxtHojoshaShimei1().getValue(),
                div.getTxtHojoshaShimei2().getValue(),
                div.getTxtHojosha1ShikibetsuCode().getDomain(),
                div.getTxtHojosha2ShikibetsuCode().getDomain()
        );
    }

}
