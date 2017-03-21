/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 選挙人の資格情報を表すインタフェースです。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格インタフェース
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 * @deprecated 使用してません
 */
public interface ISenkyoninShikaku extends Serializable {

    /**
     * 選挙人の識別コードを取得します。
     *
     * @return 識別コード
     */
    ShikibetsuCode get選挙人識別コード();

    /**
     * 選挙資格を取得します。
     *
     * @return 選挙資格
     */
    SenkyoShikaku get選挙資格();

    /**
     * 投票区を取得します。
     *
     * @return 投票区
     */
    Tohyoku get投票区();

    /**
     * 選挙人名簿登録年月日を取得します。
     *
     * @return 選挙人名簿登録年月日
     */
    RDate get選挙人名簿登録年月日();
}
