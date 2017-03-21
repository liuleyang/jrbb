/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect;

import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6030.SealShisetsuHandler;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】ShisetsuCodeSelectDivに対するSpecです。
 *
 * @reamsid_L AF-0080-035 qiuxy
 */
public enum ShisetsuCodeSelectSpec implements IPredicate<ShisetsuCodeSelectDiv> {

    /**
     * 施設コード有無チェック。
     */
    施設コード有無チェック {
                @Override
                public boolean apply(ShisetsuCodeSelectDiv div) {
                    RString 施設コード = div.getTxtShisetsuCode().getValue();
                    ShisetsuManager Manager = new ShisetsuManager();
                    return RString.isNullOrEmpty(施設コード) || Manager.get施設By施設コード(施設コード) != null;
                }
            },
    /**
     * 施設コード関連チェック。
     *
     */
    施設コード関連チェック {
                @Override
                public boolean apply(ShisetsuCodeSelectDiv div) {
                    RString 施設種別 = div.getTxtHdnShisetsuShubetsu();
                    RString 施設コード = div.getTxtShisetsuCode().getValue();
                    
                    if (RString.isNullOrEmpty(施設種別) || RString.isNullOrEmpty(施設コード)) {
                        return true;
                    }

                    ShisetsuManager Manager = new ShisetsuManager();
                    Shisetsu 施設 = Manager.get施設By施設コード(施設コード);
                    
                    if (施設 == null) {
                        return true;
                    }
                    
                    return 施設.get施設種別().value().equals(施設種別);
                 }
            }
}
