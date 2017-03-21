/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010.JuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-010 jihb
 */
public enum JuminTohyojiTorokuSpec implements IPredicate<JuminTohyojiTorokuDiv> {

    /**
     * 抄本未選択
     */
    抄本未選択 {
                @Override
                public boolean apply(JuminTohyojiTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    if (new RString("2").equals(div.getJuminTohyojiJoho().getRadShori().getSelectedKey())
                    && RString.isNullOrEmpty(div.getJuminTohyojiJoho().getCcdShohonNameList().getSelectedShohonNo())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 転出日未入力
     */
    転出日未入力 {
                @Override
                public boolean apply(JuminTohyojiTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    if (!div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                    .getChkTenshutsusha().getSelectedKeys().isEmpty()
                    && new RString("1").equals(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                            .getChkTenshutsusha().getSelectedKeys().get(0))
                    && RString.isNullOrEmpty(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                            .getTxtTenshutsuYMD().getText())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 転入日未入力
     */
    転入日未入力 {
                @Override
                public boolean apply(JuminTohyojiTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    if (!div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                    .getChkTennyusha().getSelectedKeys().isEmpty()
                    && new RString("1").equals(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                            .getChkTennyusha().getSelectedKeys().get(0))
                    && (RString.isNullOrEmpty(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                            .getTxtTennyuYMD().getText()))) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 住定期間未入力
     */
    住定期間未入力 {
                @Override
                public boolean apply(JuminTohyojiTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    if (!div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                    .getChkRenzokuKikan().getSelectedKeys().isEmpty()
                    && new RString("1").equals(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                            .getChkRenzokuKikan().getSelectedKeys().get(0))
                    && (null == div.getJuminTohyojiJoken()
                    .getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getFromValue()
                    || null == div.getJuminTohyojiJoken()
                    .getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getToValue()
                    || RString.isNullOrEmpty(div.getJuminTohyojiJoken()
                            .getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getFromValue().toDateString())
                    || RString.isNullOrEmpty(div.getJuminTohyojiJoken()
                            .getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getToValue().toDateString()))) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 居住年数未入力
     */
    居住年数未入力 {
                @Override
                public boolean apply(JuminTohyojiTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    if (!div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                    .getChkRenzokuKikan().getSelectedKeys().isEmpty()
                    && new RString("1").equals(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                            .getChkRenzokuKikan().getSelectedKeys().get(0))
                    && RString.isNullOrEmpty(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                            .getTxtKyojuNensu().getText())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 住定期間大小
     */
    住定期間大小 {
                @Override
                public boolean apply(JuminTohyojiTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    if (!RString.isNullOrEmpty(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getFromText())
                    && !RString.isNullOrEmpty(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getToText())
                    && div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getFromValue()
                    .compareTo(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtJuteiKikan().getToValue()) > 0) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };

}
