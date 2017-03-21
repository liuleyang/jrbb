/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.core;

/**
 * 選挙人の資格情報を検索するクラスを生成するクラスです。
 * <p>
 * 選挙人で利用するデータをDBへ登録・削除するManagerや、 データの検索を行うFinderを取得することができます。
 * </p>
 * <p>
 * <br/>
 * ■主要メソッド
 * <ul>
 * <li>{@link #createSenkyoninShikakuFinder createSenkyoninShikakuFinder} … 選挙人の資格情報を検索するクラスを生成します。</li>
 * </ul>
 * ■関連クラス
 * <ul>
 * <li>{@link ISenkyoninShikakuFinder}</li>
 * </ul>
 * </p>
 * <hr>
 *
 *
 * @author N2311 関　和可奈
 * @jpName 住基サービス
 * @bizDomain 選挙
 * @category 住基系業務
 * @subCategory 住基系業務
 * @mainClass ○
 * @reference
 * @deprecated 使用してません
 */
public class JukiService {

    /**
     * 選挙人の資格情報を検索するクラスを生成します。
     *
     * @return ISenkyoninShikakuFinder 選挙人の資格情報を検索するクラス
     */
    public ISenkyoninShikakuFinder createSenkyoninShikakuFinder() {
        return new _SenkyoninShikakuFinder();
    }

}
