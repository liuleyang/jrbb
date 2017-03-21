/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMF1020;

import jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi.SaibaninTorikomiEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1020.SaibaninTorikomiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 裁判員候補者予定者取込
 *
 * @reamsid_L AF-0310-010 guancy
 */
public enum SaibaninTorikomiSpec implements IPredicate<SaibaninTorikomiDiv> {

    /**
     * ファイルデータ数チェック
     */
    ファイルデータ数チェック {
                @Override
                public boolean apply(SaibaninTorikomiDiv div
                ) {
                    boolean チェック結果 = true;
                    if (SaibaninTorikomiEnum.ONE.getRString().equals(div.getFileEmptyFlg())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * ファイル項目数チェック
     */
    ファイル項目数チェック {
                @Override
                public boolean apply(SaibaninTorikomiDiv div
                ) {
                    boolean チェック結果 = true;
                    if (SaibaninTorikomiEnum.ONE.getRString().equals(div.getCountFlg())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * ファイル存在チェック
     */
    ファイル再登録チェック {
                @Override
                public boolean apply(SaibaninTorikomiDiv div
                ) {
                    boolean チェック結果 = true;
                    if (SaibaninTorikomiEnum.ONE.getRString().equals(div.getMeiboTorikomiZumiFlg())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * ファイル存在チェック
     */
    情報存在チェック {
                @Override
                public boolean apply(SaibaninTorikomiDiv div
                ) {
                    boolean チェック結果 = true;
                    if (SaibaninTorikomiEnum.ONE.getRString().equals(div.getSaibaninMeiboSakuseiFlg())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };

}
