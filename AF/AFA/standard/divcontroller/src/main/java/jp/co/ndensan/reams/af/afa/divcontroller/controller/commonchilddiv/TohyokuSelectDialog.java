/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokucodeselect.TohyokuCodeSelectModel;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.TohyokuJohoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuSelectDialog.TohyokuSelectDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuSelectDialog.dgTohyokuSelect_Row;
import jp.co.ndensan.reams.af.afa.service.core.tohyokuhenko.TohyokuHenkoManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.AssociationKey;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.ITohyokuFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.TohyokuFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 投票区選択ダイアログに対するコントローラです。
 *
 * @reamsid_L AF-0070-015 liss
 */
public class TohyokuSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel TohyokuSelectDialogDiv
     * @return ResponseData<TohyokuSelectDialogDiv>
     */
    public ResponseData<TohyokuSelectDialogDiv> onLoad(TohyokuSelectDialogDiv mainPanel) {
        TohyokuCodeSelectModel model = DataPassingConverter.deserialize(mainPanel.getTohyokuCodeSelectModel(), TohyokuCodeSelectModel.class);

        RString 選挙種類コード = model.get選挙種類コード();
        if (RString.isNullOrEmpty(選挙種類コード)) {
            mainPanel.getCcdSenkyoShurui().initialize(SenkyoShurui.国政選挙_地方選挙);
        } else {
            mainPanel.getCcdSenkyoShurui().initialize(SenkyoShurui.toValue(選挙種類コード));
            mainPanel.getCcdSenkyoShurui().setDisabled(Boolean.TRUE);
        }

        mainPanel.getDgTohyokuSelect().setDataSource(createDataSource(mainPanel));

        ResponseData<TohyokuSelectDialogDiv> response = new ResponseData<>();
        response.data = mainPanel;
        return response;
    }

    /**
     * 選択ボタンクリック時のイベントメソッドです。 <br />
     * グリッド行ダブルクリック時のイベントメソッドです。
     *
     * @param div TohyokuSelectDialogDiv
     * @return ResponseData<TohyokuSelectDialogDiv>
     */
    public ResponseData<TohyokuSelectDialogDiv> onSelectBySelectButton_closeOK(TohyokuSelectDialogDiv div) {

        div.setTxtHdnSelectedCode(div.getDgTohyokuSelect().getSelectedItems().get(0).getTxtTohyokuCode());
        div.setTxtHdnSelectedName(div.getDgTohyokuSelect().getSelectedItems().get(0).getTxtTohyokuName());

        ResponseData<TohyokuSelectDialogDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 選挙種類DDLを変更した時のイベントメソッドです。
     *
     * @param div TohyokuSelectDialogDiv
     * @return ResponseData<TohyokuSelectDialogDiv>
     */
    public ResponseData<TohyokuSelectDialogDiv> onChange_ccdSenkyoShurui(TohyokuSelectDialogDiv div) {

        div.getDgTohyokuSelect().setDataSource(createDataSource(div));

        ResponseData<TohyokuSelectDialogDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private List<dgTohyokuSelect_Row> createDataSource(TohyokuSelectDialogDiv div) {
        SenkyoShurui senkyoShurui = div.getCcdSenkyoShurui().getSelectedSenkyoShurui();
        List<dgTohyokuSelect_Row> dataSource = new ArrayList<>();
        if (senkyoShurui == SenkyoShurui.定時登録 || senkyoShurui == SenkyoShurui.国政選挙_地方選挙) {
            ITohyokuFinder tohyokuFinder = TohyokuFinderFactory.createInstance();
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            List<Tohyoku> 投票区リスト = tohyokuFinder.get投票区by地方公共団体and基準日(new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());
            // 投票区コードでソートする。
            Collections.sort(投票区リスト, new Comparator<Tohyoku>() {
                @Override
                public int compare(Tohyoku o1, Tohyoku o2) {
                    return o1.get投票区コード().getColumnValue().compareTo(o2.get投票区コード().getColumnValue());
                }
            });
            for (Tohyoku 投票区 : 投票区リスト) {
                dgTohyokuSelect_Row row = new dgTohyokuSelect_Row();
                row.setTxtTohyokuCode(投票区.get投票区コード().getColumnValue());
                row.setTxtTohyokuName(投票区.get漢字名称());
                row.setTxtKanaTohyokuName(投票区.getカナ名称());
                row.setTxtSenkyoShurui(senkyoShurui.toRString());
                row.setTxtSenkyoShuruiCode(senkyoShurui.getCode());

                dataSource.add(row);
            }
        } else {
            List<TohyokuJohoSearchResult> 投票区リスト = new TohyokuHenkoManager().get投票区リスト(new Code(senkyoShurui.getCode()));
            for (TohyokuJohoSearchResult 投票区 : 投票区リスト) {
                dgTohyokuSelect_Row row = new dgTohyokuSelect_Row();
                row.setTxtTohyokuCode(投票区.getTohyokuCode());
                row.setTxtTohyokuName(投票区.getTohyokuName());
                row.setTxtKanaTohyokuName(投票区.getKanaTohyokuName());
                row.setTxtSenkyoShurui(senkyoShurui.toRString());
                row.setTxtSenkyoShuruiCode(senkyoShurui.getCode());
                dataSource.add(row);
            }
        }

        return dataSource;
    }

}
