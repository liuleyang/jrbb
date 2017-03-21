/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.core;

import jp.co.ndensan.reams.af.afx.business.core.ISenkyoninShikaku;
import jp.co.ndensan.reams.af.afx.business.core.ISenkyoninShikakuList;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;

/**
 * 選挙人の資格情報を検索するクラスです。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格取得
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 * @deprecated 使用してません
 */
public class _SenkyoninShikakuFinder implements ISenkyoninShikakuFinder {

    @Override
    public ISenkyoninShikaku get選挙人資格(ISearchCondition searchCondition) {
        //TODO N2311関和可奈 検索処理まわりはDB設計後に主管業務にて実装。2014/03/31まで。
        return null;
    }

    @Override
    public ISenkyoninShikakuList get選挙人資格List(ISearchCondition searchCondition) {
        //TODO N2311関和可奈 検索処理まわりはDB設計後に主管業務にて実装。2014/03/31まで。
        return null;
    }
}
