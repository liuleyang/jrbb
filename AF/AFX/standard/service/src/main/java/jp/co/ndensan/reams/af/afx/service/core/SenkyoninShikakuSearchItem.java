/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.core;

import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 選挙人の資格情報を検索する際に条件指定する項目の列挙型です。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格検索項目
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 * @deprecated 使用してません
 */
public enum SenkyoninShikakuSearchItem implements ISearchItem {
    //TODO N2311関和可奈 検索項目はDB設計後に主管業務にて定義。2014/03/31まで。

    ;

    private IColumnDefinition columnDefinition;

    private SenkyoninShikakuSearchItem(IColumnDefinition columnDefinition) {
        this.columnDefinition = columnDefinition;
    }

    @Override
    public String getItemName() {
        return columnDefinition.name();
    }

    @Override
    public IColumnDefinition getColumnDefinition() {
        return columnDefinition;
    }
}
