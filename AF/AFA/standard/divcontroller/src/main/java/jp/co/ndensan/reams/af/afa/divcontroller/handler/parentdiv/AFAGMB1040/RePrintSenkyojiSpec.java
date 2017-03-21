/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 選挙時登録再発行のSpecクラスです。
 *
 * @reamsid_L AF-0060-010 liss
 */
public enum RePrintSenkyojiSpec implements IPredicate<RePrintSenkyojiDiv> {

    /**
     * 転入期間が入力されていることかをチェックします。
     */
    転入期間が入力されていること {
                @Override
                public boolean apply(RePrintSenkyojiDiv div) {
                    return is転入期間が入力(div);
                }
            },
    /**
     * 帰化期間が入力されていることかをチェックします。
     */
    帰化期間が入力されていること {
                @Override
                public boolean apply(RePrintSenkyojiDiv div) {
                    return is帰化期間が入力(div);
                }
            },
    /**
     * 転出期間が入力されていることかをチェックします。
     */
    転出期間が入力されていること {
                @Override
                public boolean apply(RePrintSenkyojiDiv div) {
                    return is転出期間が入力(div);
                }
            },
    /**
     * 実行する時明細必須選択です。
     *
     */
    実行する時明細必須選択 {
                @Override
                public boolean apply(RePrintSenkyojiDiv div) {
                    return isNotSelect(div);
                }
            },
    /**
     * 実行する時作成帳票必須選択です。
     *
     */
    実行する時作成帳票必須選択 {
                @Override
                public boolean apply(RePrintSenkyojiDiv div) {
                    return isNotSelectSakuseiChohyo(div);
                }
            };

    private static boolean is転入期間が入力(RePrintSenkyojiDiv div) {
        if (div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish()) {
            RDate 転入期間From = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue();
            RDate 転入期間To = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue();

            return 転入期間From != null && !転入期間From.toDateString().isEmpty()
                    && 転入期間To != null && !転入期間To.toDateString().isEmpty();
        }
        return true;
    }

    private static boolean is帰化期間が入力(RePrintSenkyojiDiv div) {
        if (div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish()) {
            RDate 帰化期間From = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue();
            RDate 帰化期間To = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue();
            return 帰化期間From != null && !帰化期間From.toDateString().isEmpty()
                    && 帰化期間To != null && !帰化期間To.toDateString().isEmpty();
        }
        return true;
    }

    private static boolean is転出期間が入力(RePrintSenkyojiDiv div) {
        if (div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().isIsPublish()) {
            RDate 転出期間From = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getFromValue();
            RDate 転出期間To = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getToValue();
            return 転出期間From != null && !転出期間From.toDateString().isEmpty()
                    && 転出期間To != null && !転出期間To.toDateString().isEmpty();
        }
        return true;
    }

    private static boolean isNotSelect(RePrintSenkyojiDiv div) {
        return null != div.getRePrintSenkyojiShohonSelect().getDgRePrintSenkyojiShohonSelect().getClickedItem();
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 26 LINES
    private static boolean isNotSelectSakuseiChohyo(RePrintSenkyojiDiv div) {
        return div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoYukenshasuList().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoYoteishaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoShikkenshaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoYoteishaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish()
                || div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiTohyoKanrihyo().isIsPublish();

    }
}
