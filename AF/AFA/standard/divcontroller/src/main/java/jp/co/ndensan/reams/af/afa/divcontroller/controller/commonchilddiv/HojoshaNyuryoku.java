/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.core.contexts.HojoshaNyuryokuContext;
import jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku.HojoshaNyuryokuModel;
import jp.co.ndensan.reams.af.afa.business.hojoshaselectdialog.HojoshaSelectDialogModel;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku.HojoshaNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku.HojoshaNyuryokuHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 【共有子Div】HojoshaNyuryokuDivに対するコントローラです。
 *
 * @reamsid_L AF-0080-030 wangm
 */
public class HojoshaNyuryoku {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onload(HojoshaNyuryokuDiv div) {
        HojoshaNyuryokuModel model = DataPassingConverter.deserialize(div.getHojoshaNyuryokuModel(), HojoshaNyuryokuModel.class);
        if (model != null) {
            div.setTxtHdnShohonNo(new RString(model.getShohonNo().getColumnValue()));
            div.setTxtHdnTohyokuCode(model.getTohyokuCode());
            HojoshaNyuryokuHandler handler = createHandlerOf(div);
            handler.initialize();
            handler.setDialog(model);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 代理投票チェックボックスを選択時のイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onClickChkDairiTohyo(HojoshaNyuryokuDiv div) {
        HojoshaNyuryokuHandler handler = createHandlerOf(div);

        handler.clearThisPanelForCheckBox();
        handler.set補助者を不可にする(false);

        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログをクリックのイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onClickDialog1(HojoshaNyuryokuDiv div) {

        HojoshaSelectDialogModel model = new HojoshaSelectDialogModel();
        model.setShohonNo(new ShohonNo(div.getTxtHdnShohonNo()));
        model.setTohyokuCode(div.getTxtHdnTohyokuCode());

        div.setHojoshaSelectDialogModel(DataPassingConverter.serialize(model));

        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログをクリックのイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onClickDialog1OK(HojoshaNyuryokuDiv div) {

        HojoshaSelectDialogModel model = DataPassingConverter.deserialize(div.getHojoshaSelectDialogModel(), HojoshaSelectDialogModel.class);

        div.getTxtHojoshaShimei1().setValue(model.getMeisho());
        div.getTxtHojosha1ShikibetsuCode().setDomain(new ShikibetsuCode(model.getShikibetsuCode()));

        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログをクリックのイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onClickDialog2(HojoshaNyuryokuDiv div) {

        HojoshaSelectDialogModel model = new HojoshaSelectDialogModel();
        model.setShohonNo(new ShohonNo(div.getTxtHdnShohonNo()));
        model.setTohyokuCode(div.getTxtHdnTohyokuCode());

        div.setHojoshaSelectDialogModel(DataPassingConverter.serialize(model));

        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログをクリックのイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onClickDialog2OK(HojoshaNyuryokuDiv div) {

        HojoshaSelectDialogModel model = DataPassingConverter.deserialize(div.getHojoshaSelectDialogModel(), HojoshaSelectDialogModel.class);

        div.getTxtHojoshaShimei2().setValue(model.getMeisho());
        div.getTxtHojosha2ShikibetsuCode().setDomain(new ShikibetsuCode(model.getShikibetsuCode()));

        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンクリック時のイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> onOK(HojoshaNyuryokuDiv div) {

        HojoshaNyuryokuModel model = new HojoshaNyuryokuModel();

        HojoshaNyuryokuContext context = div.getHojoshaNyuryokuContext();

        model.setDairiTohyoAri(context.isDairiTohyoAri());
        model.setMeisho1(context.getHojosha1Name());
        model.setShikibetsuCode1(context.getHojosha1ShikibetsuCode());
        model.setMeisho2(context.getHojosha2Name());
        model.setShikibetsuCode2(context.getHojosha2ShikibetsuCode());

        div.setHojoshaNyuryokuModel(DataPassingConverter.serialize(model));

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 取消ボタンクリック時のイベントメソッドです。
     *
     * @param div HojoshaNyuryokuDiv
     * @return ResponseData<HojoshaNyuryokuDiv>
     */
    public ResponseData<HojoshaNyuryokuDiv> cancel(HojoshaNyuryokuDiv div) {

        return ResponseData.of(div).dialogNGClose();
    }

    private HojoshaNyuryokuHandler createHandlerOf(HojoshaNyuryokuDiv div) {
        return new HojoshaNyuryokuHandler(div);
    }

}
