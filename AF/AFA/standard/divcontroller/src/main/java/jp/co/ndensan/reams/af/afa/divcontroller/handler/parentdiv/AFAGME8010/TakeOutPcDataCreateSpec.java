/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.TakeOutPcDataCreateDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 持出端末用データ作成
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public enum TakeOutPcDataCreateSpec implements IPredicate<TakeOutPcDataCreateDiv> {

    /**
     * 処理の続行確認
     */
    処理の続行確認 {
                @Override
                public boolean apply(TakeOutPcDataCreateDiv div
                ) {
                    boolean チェック結果 = true;

                    if (MochidashiPcCreateDataEnum.ONE.getRString().equals(div.getDataCreatFlg())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 投票日前日確認
     */
    投票日前日確認 {
                @Override
                public boolean apply(TakeOutPcDataCreateDiv div
                ) {
                    boolean チェック結果 = true;
                    if (new FlexibleDate(div.getDdlTohyoYmd().getSelectedKey()).getBetweenDays(FlexibleDate.getNowDate()) > 1) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },

}
