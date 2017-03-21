/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 投票日前日関連帳票のチェックロジックです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public enum ZenjitsuSakuseiSpec implements IPredicate<ZenjitsuSakuseiDiv> {

    /**
     * 作成帳票が選択されていることかをチェックします。
     */
    作成帳票が選択されていること {
                @Override
                public boolean apply(ZenjitsuSakuseiDiv div) {
                    return SpecHelper.is作成帳票が選択(div);
                }
            },
    /**
     * 期日前投票が入力されていることかをチェックします。
     */
    期日前投票が入力されていること {
                @Override
                public boolean apply(ZenjitsuSakuseiDiv div) {
                    return SpecHelper.is期日前投票が入力(div);
                }
            },
    /**
     * 不在者投票が入力されていることかをチェックします。
     */
    不在者投票が入力されていること {
                @Override
                public boolean apply(ZenjitsuSakuseiDiv div) {
                    return SpecHelper.is不在者投票が入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean is作成帳票が選択(ZenjitsuSakuseiDiv div) {
            ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
            if (chohyoDiv.getZenjitsuSakuseiChohyoTohyoShukei().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoNendaibetsu().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoJikanbetsu().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoJuriJokyo().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoKofuIchiran().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoFuzaishaChosho().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoKofuChosho().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoKanrishaChosho().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoTorokushaList().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoYukenshaList().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getZenjitsuSakuseiChohyoShohon().isIsPublish()) {
                return true;
            }
            return chohyoDiv.getZenjitsuSakuseiChohyoSochisho().isIsPublish();

        }

        public static boolean is期日前投票が入力(ZenjitsuSakuseiDiv div) {
            ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
            if (!chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().isIsPublish()) {
                return true;
            }

            return 0 < chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().getChkDairiTohyoTaisho().getSelectedKeys().size();

        }

        public static boolean is不在者投票が入力(ZenjitsuSakuseiDiv div) {
            ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
            if (!chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().isIsPublish()) {
                return true;
            }

            return 0 < chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().getChkJimuShoriboTaisho().getSelectedKeys().size();
        }
    }
}
