/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.dgSenkyojiSenkyoNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1010.SenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku.SenkyojiTourokuValidationService;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙時登録画面のチェックロジックです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public enum SenkyojiTorokuSpec implements IPredicate<SenkyojiTorokuDiv> {

    /**
     * 抄本名が入力されていることかをチェックします。
     */
    抄本名が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is抄本名が入力(div);
                }
            },
    /**
     * 投票日が入力されていることかをチェックします。
     */
    投票日が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is投票日が入力(div);
                }
            },
    /**
     * 年齢期限が入力されていることかをチェックします。
     */
    年齢期限が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is年齢期限が入力(div);
                }
            },
    /**
     * レベルが入力されていることかをチェックします。
     */
    レベルが入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.isレベルが入力(div);
                }
            },
    /**
     * 転入期間が入力されていることかをチェックします。
     */
    転入期間が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is転入期間が入力(div);
                }
            },
    /**
     * 帰化期間が入力されていることかをチェックします。
     */
    帰化期間が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is帰化期間が入力(div);
                }
            },
    /**
     * 転出期間が入力されていることかをチェックします。
     */
    転出期間が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is転出期間が入力(div);
                }
            },
    /**
     * 選挙名が入力されていることかをチェックします。
     */
    選挙名が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is選挙名が入力(div);
                }
            },
    /**
     * 略名が入力されていることかをチェックします。
     */
    略名が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is略名が入力(div);
                }
            },
    /**
     * マークが入力されていることかをチェックします。
     */
    マークが入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.isマークが入力(div);
                }
            },
    /**
     * 基準日が入力されていることかをチェックします。
     */
    基準日が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is基準日が入力(div);
                }
            },
    /**
     * 受付開始日が入力されていることかをチェックします。
     */
    受付開始日が入力されていること {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.is受付開始日が入力(div);
                }
            },
    /**
     * 基準日が投票日より前のことかをチェックします。
     */
    基準日が投票日より前のこと {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.基準日と投票日確認(div);
                }
            },
    /**
     * 基準日が受付開始日より前のことかをチェックします。
     */
    基準日が受付開始日より前のこと {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.基準日と受付開始日確認(div);
                }
            },
    /**
     * 受付開始日が投票日より前のことかをチェックします。
     */
    受付開始日が投票日より前のこと {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    return SpecHelper.受付開始日と投票日確認(div);
                }
            },
    /**
     * 入場券が発行済のことかをチェックします。
     */
    入場券が発行済のこと {
                @Override
                public boolean apply(SenkyojiTorokuDiv div) {
                    if (new RString("再処理").equals(div.getCcdSenkyojiMeiboSakuseiKijun().getRadShori().getSelectedValue())) {
                        RString 抄本番号 = div.getCcdSenkyojiMeiboSakuseiKijun().getCcdShohonNameList().getSelectedShohonNo();
                        return SenkyojiTourokuValidationService.createInstance().validate入場券発行済(抄本番号);
                    }
                    return true;
                }
            };

    private static class SpecHelper {

        public static boolean is抄本名が入力(SenkyojiTorokuDiv div) {
            RString 抄本名 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtShohonName().getValue();
            return !抄本名.isEmpty();
        }

        public static boolean is投票日が入力(SenkyojiTorokuDiv div) {
            RDate 投票日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue();
            return 投票日 != null && !投票日.toDateString().isEmpty();
        }

        public static boolean is年齢期限が入力(SenkyojiTorokuDiv div) {
            RDate 年齢期限日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue();
            return 年齢期限日 != null && !年齢期限日.toDateString().isEmpty();
        }

        public static boolean is転入期間が入力(SenkyojiTorokuDiv div) {
            if (div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish()) {
                RDate 転入期間From = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue();
                RDate 転入期間To = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue();

                return 転入期間From != null && !転入期間From.toDateString().isEmpty()
                        && 転入期間To != null && !転入期間To.toDateString().isEmpty();
            }
            return true;
        }

        public static boolean is帰化期間が入力(SenkyojiTorokuDiv div) {
            if (div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish()) {
                RDate 帰化期間From = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue();
                RDate 帰化期間To = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue();
                return 帰化期間From != null && !帰化期間From.toDateString().isEmpty()
                        && 帰化期間To != null && !帰化期間To.toDateString().isEmpty();
            }
            return true;
        }

        public static boolean is転出期間が入力(SenkyojiTorokuDiv div) {
            if (div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().isIsPublish()) {
                RDate 転出期間From = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getFromValue();
                RDate 転出期間To = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getToValue();
                return 転出期間From != null && !転出期間From.toDateString().isEmpty()
                        && 転出期間To != null && !転出期間To.toDateString().isEmpty();
            }
            return true;
        }

        public static boolean isレベルが入力(SenkyojiTorokuDiv div) {
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                if (RString.EMPTY.equals(選挙情報.getDdlLevel().getSelectedKey())) {
                    return false;
                }
            }
            return true;
        }

        public static Boolean is選挙名が入力(SenkyojiTorokuDiv div) {
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                RString 選挙名 = 選挙情報.getTxtSenkyoName().getValue();
                if (選挙名 == null || 選挙名.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public static Boolean is略名が入力(SenkyojiTorokuDiv div) {
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                RString 略名 = 選挙情報.getTxtSenkyoRyakusho().getValue();
                if (略名 == null || 略名.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isマークが入力(SenkyojiTorokuDiv div) {
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                RString マーク = 選挙情報.getTxtSenkyoRyakusho().getValue();
                if (マーク == null || マーク.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public static boolean is基準日が入力(SenkyojiTorokuDiv div) {
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                if (選挙情報.getTxtKijunYMD().getValue() == null) {
                    return false;
                }
            }
            return true;
        }

        public static boolean is受付開始日が入力(SenkyojiTorokuDiv div) {
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                if (選挙情報.getTxtTohyoUketsukeYMD().getValue() == null) {
                    return false;
                }
            }
            return true;
        }

        public static boolean 基準日と投票日確認(SenkyojiTorokuDiv div) {
            RString menuId = ViewState.getメニューID();
            RDate 投票日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue();
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                if ((menuId.equals(AFAMenuId.AFAMNB1010_選挙時登録.menuId()) && 投票日.compareTo(選挙情報.getTxtKijunYMD().getValue()) <= 0)
                        || (menuId.equals(AFAMenuId.AFAMNB4010_選挙時登録.menuId()) && 投票日.compareTo(選挙情報.getTxtKijunYMD().getValue()) < 0)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean 基準日と受付開始日確認(SenkyojiTorokuDiv div) {
            RString menuId = ViewState.getメニューID();
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                if ((menuId.equals(AFAMenuId.AFAMNB1010_選挙時登録.menuId()) && 選挙情報.getTxtTohyoUketsukeYMD().getValue().compareTo(選挙情報.getTxtKijunYMD().getValue()) <= 0)
                        || (menuId.equals(AFAMenuId.AFAMNB4010_選挙時登録.menuId()) && 選挙情報.getTxtTohyoUketsukeYMD().getValue().compareTo(選挙情報.getTxtKijunYMD().getValue()) < 0)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean 受付開始日と投票日確認(SenkyojiTorokuDiv div) {
            RDate 投票日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue();
            RString menuId = ViewState.getメニューID();
            for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
                if (menuId.equals(AFAMenuId.AFAMNB1010_選挙時登録.menuId()) && 選挙情報.getTxtTohyoUketsukeYMD().getValue().compareTo(投票日) >= 0) {
                    return false;
                }
            }
            return true;
        }

    }
}
