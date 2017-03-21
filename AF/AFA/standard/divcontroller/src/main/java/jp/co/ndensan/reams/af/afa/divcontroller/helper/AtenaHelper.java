/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.helper;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IAtenaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 【UR共有子Div】AtenaFinderの機能追加クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public final class AtenaHelper {

    private AtenaHelper() {
    }

    /**
     * 宛名照会簡易版を初期化するための検索キーを住登内優先で作成する。
     *
     * @param shikibetsuCode 識別コード
     * @return IAtenaSearchKey 宛名検索キー
     */
    public static IAtenaSearchKey createSearchKeyForAtenaShokaiSimple(ShikibetsuCode shikibetsuCode) {
        IAtesakiGyomuHanteiKey hanteiKey = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.AF選挙);
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登内優先, hanteiKey);
        atenaSearchKeyBuilder.set識別コード(shikibetsuCode);
        return atenaSearchKeyBuilder.build();
    }

    /**
     * 宛名共通検索を初期化するための検索キーを住登内優先で作成する。
     *
     * @return IShikibetsuTaishoGyomuHanteiKey 識別対象業務判定キー
     */
    public static IShikibetsuTaishoGyomuHanteiKey createSearchKeyForAtenaFinder() {
        return ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
    }

}
