/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.core;

import jp.co.ndensan.reams.af.afx.business.core.ISenkyoninShikaku;
import jp.co.ndensan.reams.af.afx.business.core.ISenkyoninShikakuList;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;

/**
 * 選挙人の資格情報を検索するインタフェースです。<br />
 *   //TODO 検索処理まわりはDB設計後に主管業務にて実装。実装が完了され次第ガイドラインを完成させます。
 * <p>
 * ■主要メソッド
 * <ul>
 * <li>{@link #get選挙人資格 get選挙人資格} … 指定された条件に該当する選挙人資格情報を返します。</li>
 * <li>{@link #get選挙人資格List get選挙人資格List} … 指定された条件に該当する選挙人資格情報のコレクションを返します。</li>
 * <li>{@link #get農委選挙人資格 get農委選挙人資格} … 指定された条件に該当する農業委員会委員選挙の選挙人資格情報を返します。</li>
 * <li>{@link #get農委選挙人資格List get農委選挙人資格List} … 指定された条件に該当する農業委員会委員選挙の選挙人資格情報のコレクションを返します。</li>
 * </ul>
 * ■関連クラス
 * <ul>
 * <li>{@link ISenkyoninShikaku}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格取得インタフェース
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass ○
 * @reference
 * @deprecated 使用してません
 */
public interface ISenkyoninShikakuFinder {

    /**
     * 指定された条件に該当する選挙人資格情報を返します。
     *
     * @param searchCondition 検索条件
     * @return 選挙人資格情報
     */
    ISenkyoninShikaku get選挙人資格(ISearchCondition searchCondition);

    /**
     * 指定された条件に該当する選挙人資格情報のコレクションを返します。
     *
     * @param searchCondition 検索条件
     * @return 選挙人資格情報のコレクション
     */
    ISenkyoninShikakuList get選挙人資格List(ISearchCondition searchCondition);
}
