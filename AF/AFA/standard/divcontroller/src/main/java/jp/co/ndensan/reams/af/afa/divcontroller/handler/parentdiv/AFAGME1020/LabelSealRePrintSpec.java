/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.LabelSealRePrintDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.dgLabelSealRePrintTaishosha_Row;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * ラベルシール再印刷のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
public enum LabelSealRePrintSpec implements IPredicate<LabelSealRePrintDiv> {

    /**
     * 施設コードの入力チェックをチェックします。
     */
    施設コードの入力チェック_未入力 {
                @Override
                public boolean apply(LabelSealRePrintDiv div) {
                    RString 施設コード = div.getLabelSealRePrintParam().getLabelSealSakuseiTaisho().getCcdShisetsuCode().get施設コード();
                    return !(RString.isNullOrEmpty(施設コード));
                }
            },
    /**
     * 選挙人一覧データチェックをチェックします。
     */
    選挙人一覧データチェック_データなし {
                @Override
                public boolean apply(LabelSealRePrintDiv div) {
                    DataGrid<dgLabelSealRePrintTaishosha_Row> dgLabelSealRePrintTaishosha
                    = div.getLabelSealRePrintParam().getLabelSealSakuseiTaisho().getDgLabelSealRePrintTaishosha();
                    return !(null == dgLabelSealRePrintTaishosha || 0 == dgLabelSealRePrintTaishosha.getTotalRecords());
                }
            },
    /**
     * 選挙人一覧選択チェックをチェックします。
     */
    選挙人一覧選択チェック_選択しなし {
                @Override
                public boolean apply(LabelSealRePrintDiv div) {
                    DataGrid<dgLabelSealRePrintTaishosha_Row> dgLabelSealRePrintTaishosha
                    = div.getLabelSealRePrintParam().getLabelSealSakuseiTaisho().getDgLabelSealRePrintTaishosha();
                    return !(!(null == dgLabelSealRePrintTaishosha || 0 == dgLabelSealRePrintTaishosha.getTotalRecords())
                    && dgLabelSealRePrintTaishosha.getSelectedItems().isEmpty());
                }
            },
    /**
     * 開始印字位置選択チェック_選択しなし。
     */
    開始印字位置選択チェック_選択しなし {
                @Override
                public boolean apply(LabelSealRePrintDiv div) {
                    return div.getLabelSealSakuseiTaisho().getCcdSealPosition().isDisplayNone()
                    || !((AtenaSealPositionGuideDiv) div.getLabelSealSakuseiTaisho().getCcdSealPosition()).getTxtPosition().getValue().isNullOrEmpty();
                }
            };

}
