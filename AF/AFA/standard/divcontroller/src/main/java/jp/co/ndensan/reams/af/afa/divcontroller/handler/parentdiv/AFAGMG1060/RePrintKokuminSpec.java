/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060.RePrintKokuminDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 国民投票帳票再発行のクラス
 *
 * @reamsid_L AF-0400-010 guancy
 */
public enum RePrintKokuminSpec implements IPredicate<RePrintKokuminDiv> {

    /**
     * 登録者の時点チェックをチェックします。
     *
     */
    登録者の時点チェック {
                @Override
                public boolean apply(RePrintKokuminDiv div) {
                    if (!div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().isIsPublish()) {
                        return Boolean.TRUE;
                    }
                    return div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().isIsPublish()
                    && div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().getTxtTorokushasuListKijunYmd().getValue() != null;

                }
            },
    /**
     * 抄本選択チェックをチェックします。
     *
     */
    抄本選択チェック {
                @Override
                public boolean apply(RePrintKokuminDiv div) {
                    return null != div.getRePrintKokuminShohonSelect().getDgRePrintKokuminShohonSelect().getDgKokuminShohon().getClickedItem();
                }
            },
    /**
     * 出力対象選択チェックをチェックします。
     *
     */
    出力対象選択チェック {
                //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
                @Override
                public boolean apply(RePrintKokuminDiv div) {
                    if (div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿抄本().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get2号資格候補者一覧表().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get補正登録者名簿().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get抹消者名簿().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get訂正者名簿().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get在外投票関連().getKokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get在外投票関連().getKokuminSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish()
                    || div.getCcdRePrintKokuminSakuseiChohy().get在外投票関連().getKokuminSakuseiChohyoZaigaiTohyoKanrihyo().isIsPublish()) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }

            };
}
