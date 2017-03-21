/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAUZTEST;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAUZTEST.AfzUzTestPanel1Div;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TreeItem;

/**
 *
 * @author N1229 橋田 宏司
 */
public class AfzUzTestPanel1 {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div AfzUzTestPanel1Div
     * @return ResponseData<AfzUzTestPanel1Div>
     */
    public ResponseData<AfzUzTestPanel1Div> onLoad(AfzUzTestPanel1Div div) {

        div.getAfzUzTestTextBox1().setValue(new RString("入力可"));
        div.getAfzUzTestTextBox2().setValue(new RString("入力可"));
        div.getAfzUzTestTextBox3().setValue(new RString("読取専用"));
        div.getAfzUzTestTextBox4().setValue(new RString("使用不可"));

        div.getTxtSenkyoShurui().setValue(div.getDdlSenkyoShurui().getSelectedKey());

        div.getTvTest().setDataSource(createTreeItem(div));
        div.getDgAfzUzTest().init();

        return getResponseData(div);
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param div AfzUzTestPanel1Div
     * @return ResponseData<AfzUzTestPanel1Div>
     */
    public ResponseData<AfzUzTestPanel1Div> onChange_ddlSenkyoShurui(AfzUzTestPanel1Div div) {

        div.getTxtSenkyoShurui().setValue(div.getDdlSenkyoShurui().getSelectedKey());
        return getResponseData(div);
    }

    private ResponseData<AfzUzTestPanel1Div> getResponseData(AfzUzTestPanel1Div div) {
        ResponseData<AfzUzTestPanel1Div> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private List<TreeItem> createTreeItem(AfzUzTestPanel1Div div) {
        div.getTvTest().getDataSource().clear();

        List<HashMap> sourceKekka = YamlLoader.loadAsList(new RString("CodeMaster.yml"));
        List<TreeItem> dataSource = div.getTvTest().getDataSource();
        RString beforeNode = RString.EMPTY;
        TreeItem oyaNode = new TreeItem();

        for (HashMap item : sourceKekka) {
            if (!beforeNode.equalsIgnoreCase(YamlLoader.getStringText(item, "codeShubetsu"))) {
                if (!beforeNode.isEmpty()) {
                    dataSource.add(oyaNode);
                }
                beforeNode = YamlLoader.getStringText(item, "codeShubetsu");
                oyaNode = new TreeItem(beforeNode);
            }
            TreeItem row = new TreeItem(new RString(YamlLoader.getStringText(item, "コード") + ":" + YamlLoader.getStringText(item, "名称")));
            row.setHasChildNode(true);
            oyaNode.addChildNodes(row);
        }
        return dataSource;
    }
}
