/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public enum LayoutBreakItems {

    /**
     * 施設送付書
     */
    施設送付書(1),
    /**
     * 施設コード
     */
    施設送付書明細(2);
    private final int formGroupIndex;

    private LayoutBreakItems(int formGroupIndex) {
        this.formGroupIndex = formGroupIndex;
    }

    /**
     * フォームグループインデックスを返します。
     *
     * @return フォームグループインデックス
     */
    public int index() {
        return this.formGroupIndex;
    }
}
