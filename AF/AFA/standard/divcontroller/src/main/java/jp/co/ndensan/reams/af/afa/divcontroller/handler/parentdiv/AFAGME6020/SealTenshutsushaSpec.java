/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020.SealTenshutsushaDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * AFAGME6020 転出者宛名シール
 *
 * @reamsid_L AF-0620-011 lis2
 */
public enum SealTenshutsushaSpec implements IPredicate<SealTenshutsushaDiv> {

    /**
     * 対象期間対象開始年月日未入力チェック
     */
    対象期間対象開始年月日未入力チェック {
                @Override
                public boolean apply(SealTenshutsushaDiv div) {
                    boolean チェック結果 = true;
                    if (null == div.getTxtTaishoKikan().getFromValue()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 対象期間対象終了年月日未入力チェック
     */
    対象期間対象終了年月日未入力チェック {
                @Override
                public boolean apply(SealTenshutsushaDiv div) {
                    boolean チェック結果 = true;
                    if (null == div.getTxtTaishoKikan().getToValue()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 対象期間関連チェック
     */
    対象期間関連チェック {
                @Override
                public boolean apply(SealTenshutsushaDiv div) {
                    boolean チェック結果 = true;
                    int 比較結果 = div.getTxtTaishoKikan().getFromValue().compareTo(div.getTxtTaishoKikan().getToValue());
                    if (比較結果 == 0) {
                        チェック結果 = false;
                    }
                    return チェック結果;

                }
            },
    /**
     * 開始印字位置チェック
     */
    開始印字位置チェック {
                @Override
                public boolean apply(SealTenshutsushaDiv div) {
                    boolean チェック結果 = true;
                    if (((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue().isEmpty()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };
}
