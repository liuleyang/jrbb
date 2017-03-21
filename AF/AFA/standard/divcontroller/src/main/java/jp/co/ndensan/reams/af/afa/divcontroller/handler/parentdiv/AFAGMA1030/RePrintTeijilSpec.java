/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.RePrintTeijiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 定時登録再発行のSpecクラスです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public enum RePrintTeijilSpec implements IPredicate<RePrintTeijiDiv> {

    /**
     * 実行する時明細必須選択です。
     *
     */
    実行する時明細必須選択 {
                @Override
                public boolean apply(RePrintTeijiDiv div) {
                    return isNotSelect(div);
                }
            },
    /**
     * 実行する時作成帳票必須選択です。
     *
     */
    実行する時作成帳票必須選択 {
                @Override
                public boolean apply(RePrintTeijiDiv div) {
                    return isNotSelectSakuseiChohyo(div);
                }
            };

    private static boolean isNotSelect(RePrintTeijiDiv div) {
        return null != div.getRePrintTeijiShohonSelect().getDgRePrintTeijiShohonSelect().getClickedItem();
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 21 LINES
    private static boolean isNotSelectSakuseiChohyo(RePrintTeijiDiv div) {
        return div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoTorokushasuList().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoYukenshasuList().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdo19saishaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish()
                || div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish();
    }
}
