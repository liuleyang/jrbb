/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoSelectDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.service.core.tohyojo.TohyojoFinder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 投票所選択ダイアログに対するハンドラークラスです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoSelectDialogHandler {

    private final TohyojoFinder finder;
    private final TohyojoSelectDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 投票所選択ダイアログのdiv
     */
    public TohyojoSelectDialogHandler(TohyojoSelectDialogDiv div) {
        this.div = div;
        finder = InstanceProvider.create(TohyojoFinder.class);
    }

    /**
     * 投票所選択ダイアログデータを取得する
     *
     * @param 投票区コード 投票所選択ダイアログ
     */
    public void 画面設定_投票所ダイアログ(RString 投票区コード) {

        List<Tohyojo> tohyojoList = finder.get投票所全件();
        if (!tohyojoList.isEmpty()) {
            List<dgTohyojoSelect_Row> dgList = new ArrayList<>();
            for (Tohyojo tohyojo : tohyojoList) {
                dgTohyojoSelect_Row dg = new dgTohyojoSelect_Row();
                dg.setTxtTohyojoCode(tohyojo.get投票所コード());
                dg.setTxtTohyojoName(tohyojo.get投票所名());
                dg.setTxtKanaTohyojoName(tohyojo.getカナ投票所名());
                dgList.add(dg);
            }
            div.getDgTohyojoSelect().setDataSource(dgList);
        }
        List<dgTohyojoSelect_Row> selectedItems = new ArrayList();
        for (dgTohyojoSelect_Row dgTemp : div.getDgTohyojoSelect().getDataSource()) {
            if (null != 投票区コード && 投票区コード.equals(dgTemp.getTxtTohyojoCode())) {
                selectedItems.add(dgTemp);
            }
        }
        div.getDgTohyojoSelect().setSelectedItems(selectedItems);

    }
}
