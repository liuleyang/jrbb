/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 選挙人資格情報のコレクションを表すインタフェースです。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格リストインタフェース
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 * @deprecated 使用してません
 */
public interface ISenkyoninShikakuList extends Iterable<ISenkyoninShikaku>, Serializable {

    /**
     * 保持している選挙人資格情報の件数を返します。
     *
     * @return 件数
     */
    long size();

    /**
     * 指定された識別コードに該当する者の選挙人資格情報を返します。
     *
     * @param 選挙人識別コード 選挙人識別コード
     * @return 選挙人資格情報
     */
    ISenkyoninShikaku get選挙人資格(ShikibetsuCode 選挙人識別コード);
}
