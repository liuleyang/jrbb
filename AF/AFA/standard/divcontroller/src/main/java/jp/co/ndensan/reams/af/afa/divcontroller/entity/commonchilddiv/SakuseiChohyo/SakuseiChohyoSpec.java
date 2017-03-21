/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 作成帳票共有子DIVのSpecクラス
 */
public enum SakuseiChohyoSpec implements IPredicate<SakuseiChohyoDiv> {

    二重登録通知_転入期間 {
                @Override
                public boolean apply(SakuseiChohyoDiv div) {
                    if (div.getSakuseiChohyoNijuTorokuTsuchi().isIsPublish()
                    && div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue() != null
                    && div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue() != null) {
                        return div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue().isBeforeOrEquals(
                                div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }

            },
    帰化期間 {
                @Override
                public boolean apply(SakuseiChohyoDiv div) {
                    if (div.getSakuseiChohyoIdoKikaMeibo().isIsPublish()
                    && div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue() != null
                    && div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue() != null) {
                        return div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue().isBeforeOrEquals(
                                div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }
            },
    二重登録調査票_転出期間 {
                @Override
                public boolean apply(SakuseiChohyoDiv div) {
                    if (!div.getSakuseiChohyoNijuChosahyo().isDisplayNone()
                    && div.getSakuseiChohyoNijuChosahyo().isIsPublish()
                    && div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getFromValue() != null
                    && div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getToValue() != null) {
                        return div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getFromValue().isBeforeOrEquals(
                                div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getToValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }
            },
    永久選挙人名簿_出力条件 {
                @Override
                public boolean apply(SakuseiChohyoDiv div) {
                    if (div.getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish()
                    && div.getSakuseiChohyoEikyuSenkyoninMeibo().getRadEikyuMeiboShoriKubun().getSelectedValue()
                    .equals(new RString("指定日、事由により出力する"))) {
                        return div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getFromValue() != null
                        && div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getToValue() != null
                        && !div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().getSelectedKey().isEmpty();
                    } else {
                        return Boolean.TRUE;
                    }
                }
            };
}
