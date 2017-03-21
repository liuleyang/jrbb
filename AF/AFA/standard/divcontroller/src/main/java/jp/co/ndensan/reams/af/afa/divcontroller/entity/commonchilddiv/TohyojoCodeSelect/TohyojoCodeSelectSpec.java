/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect;

import jp.co.ndensan.reams.af.afa.service.core.tohyojo.TohyojoFinder;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】ShisetsuCodeSelectDivに対するSpecです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public enum TohyojoCodeSelectSpec implements IPredicate<TohyojoCodeSelectDiv> {

    /**
     * 投票所コード有無チェック。
     */
    投票所コード有無チェック {
                @Override
                public boolean apply(TohyojoCodeSelectDiv div) {
                    RString 投票所コード = div.getTxtTohyojoCode().getValue();
                    TohyojoFinder finder = TohyojoFinder.createInstance();
                    if (!RString.isNullOrEmpty(投票所コード)) {
                        return finder.get投票所By投票所コード(投票所コード) != null;
                    }
                    return Boolean.FALSE;
                }
            }
}
