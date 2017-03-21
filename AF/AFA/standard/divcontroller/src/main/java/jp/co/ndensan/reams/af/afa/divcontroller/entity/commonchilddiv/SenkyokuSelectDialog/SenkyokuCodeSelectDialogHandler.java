/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuSelectDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyoku.SenkyokuJouhou;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.service.senkyoku.SenkyokuFinder;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SenkyokuSelectDialogDiv の操作を担当するクラスです。
 *
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuCodeSelectDialogHandler {

    private final SenkyokuSelectDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙区コード選択Div
     */
    public SenkyokuCodeSelectDialogHandler(SenkyokuSelectDialogDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 選挙区DialogDiv
     * @return SenkyokuCodeSelectDialogHandler
     */
    public static SenkyokuCodeSelectDialogHandler of(SenkyokuSelectDialogDiv div) {
        return new SenkyokuCodeSelectDialogHandler(div);
    }

    /**
     * 選挙区選択ダイアログ初期表示
     *
     * @param senkyoShurui SenkyoShurui
     */
    public void onLoad(SenkyoShurui senkyoShurui) {
        div.getCcdSenkyoShurui().initialize(senkyoShurui);
        div.getDgSenkyokuSelect().getDataSource().clear();
        RString 選挙種類 = null == senkyoShurui ? RString.EMPTY : senkyoShurui.getCode();
        List<dgSenkyokuSelect_Row> rowList = new ArrayList();
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        List<SenkyokuJouhou> 選挙種類リスト = finder.select選挙区情報リスト(選挙種類);
        if (null != 選挙種類リスト && !選挙種類リスト.isEmpty()) {
            for (SenkyokuJouhou 選挙種類Entity : 選挙種類リスト) {
                dgSenkyokuSelect_Row row = new dgSenkyokuSelect_Row();
                row.setTxtSenkyoShuruiCode(null == 選挙種類Entity.getEntity().getSenkyoShurui() ? RString.EMPTY : 選挙種類Entity.getEntity().getSenkyoShurui().getColumnValue());
                row.setTxtSenkyoShurui(選挙種類Entity.getEntity().getSenkyoShuruiMeisho());
                row.setTxtSenkyokuCode(選挙種類Entity.getEntity().getSenkyokuCode());
                row.setTxtSenkyokuName(選挙種類Entity.getEntity().getSenkyokuName());
                rowList.add(row);
            }
        }
        div.getDgSenkyokuSelect().setDataSource(rowList);
    }

    /**
     * 選挙区選択ボタン
     *
     * @return dgSenkyokuSelect_Row
     */
    public dgSenkyokuSelect_Row onClick_btnSentaku() {
        dgSenkyokuSelect_Row row = new dgSenkyokuSelect_Row();
        row.setTxtSenkyokuCode(div.getDgSenkyokuSelect().getClickedItem().getTxtSenkyokuCode());
        row.setTxtSenkyokuName(div.getDgSenkyokuSelect().getClickedItem().getTxtSenkyokuName());
        row.setTxtSenkyoShurui(div.getDgSenkyokuSelect().getClickedItem().getTxtSenkyoShurui());
        return row;
    }

    public void createDataSource(RString 選挙種類) {
        List<dgSenkyokuSelect_Row> rowList = new ArrayList();
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        List<SenkyokuJouhou> 選挙種類リスト = finder.select選挙区情報リスト(選挙種類);
        if (null != 選挙種類リスト && !選挙種類リスト.isEmpty()) {
            for (SenkyokuJouhou 選挙種類Entity1 : 選挙種類リスト) {
                dgSenkyokuSelect_Row row = new dgSenkyokuSelect_Row();
                row.setTxtSenkyoShuruiCode(null == 選挙種類Entity1.getEntity().getSenkyoShurui() ? RString.EMPTY : 選挙種類Entity1.getEntity().getSenkyoShurui().getColumnValue());
                row.setTxtSenkyoShurui(選挙種類Entity1.getEntity().getSenkyoShuruiMeisho());
                row.setTxtSenkyokuCode(選挙種類Entity1.getEntity().getSenkyokuCode());
                row.setTxtSenkyokuName(選挙種類Entity1.getEntity().getSenkyokuName());
                rowList.add(row);
            }
        }
        div.getDgSenkyokuSelect().setDataSource(rowList);
    }
}
