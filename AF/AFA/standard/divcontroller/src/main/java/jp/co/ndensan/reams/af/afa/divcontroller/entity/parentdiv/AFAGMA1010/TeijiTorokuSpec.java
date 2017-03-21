/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SimulationMenuId;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

public enum TeijiTorokuSpec implements IPredicate<TeijiTorokuDiv> {

    基準日必須入力 {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    return div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue() != null;
                }
            },
    登録日必須入力 {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    return div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD().getValue() != null;
                }
            },
    転出期限必須入力 {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    return div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue() != null;
                }
            },
    転入期限必須入力 {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    return div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue() != null;
                }
            },
    年齢期限必須入力 {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    return div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue() != null;
                }
            },
    基準日と登録日の関係性チェック {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue() != null
                    && div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD().getValue() != null) {
                        return div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue().
                        isBeforeOrEquals(div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD().getValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }
            },
    未来基準日抄本確認 {

                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (new SimulationMenuId().isSimulationMenuId(ResponseHolder.getMenuID())) {
                        return true;
                    }
                    List<Shohon> shohonList = TeijiTorokuSpec.get抄本By定時登録();
                    if (null == shohonList
                    || !div.getCcdTeijiMeiboSakuseiKijun().getRadShori().getSelectedValue().equals(CommonConstant.新規処理)) {
                        return true;
                    }
                    for (Shohon shohon : shohonList) {
                        RDate 基準日 = div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue();
                        if (null != 基準日 && null != shohon.get投票年月日() && !shohon.get投票年月日().isEmpty()
                        && 基準日.isBefore(new RDate(shohon.get投票年月日().toString()))) {
                            return false;
                        }
                    }
                    return true;
                }

            },
    定時未実施確認 {

                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (new SimulationMenuId().isSimulationMenuId(ResponseHolder.getMenuID())) {
                        return true;
                    }
                    List<Shohon> shohonList = TeijiTorokuSpec.get抄本By定時登録();
                    if (null == shohonList || shohonList.isEmpty()
                    || !div.getCcdTeijiMeiboSakuseiKijun().getRadShori().getSelectedValue().equals(CommonConstant.新規処理)) {
                        return true;
                    }
                    for (Shohon shohon : shohonList) {
                        RDate 基準日 = div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue();
                        if (null != 基準日 && null != shohon.get投票年月日() && !shohon.get投票年月日().isEmpty()
                        && 基準日.minusMonth(CommonConstant.月_3ヶ).isBeforeOrEquals(new RDate(shohon.get投票年月日().toString()))
                        && new RDate(shohon.get投票年月日().toString()).isBefore(基準日)) {
                            return true;
                        }
                    }
                    return false;
                }

            },
    同一基準日抄本確認 {

                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (new SimulationMenuId().isSimulationMenuId(ResponseHolder.getMenuID())) {
                        return true;
                    }
                    List<Shohon> shohonList = TeijiTorokuSpec.get抄本By定時登録();
                    if (null == shohonList || shohonList.isEmpty()
                    || !div.getCcdTeijiMeiboSakuseiKijun().getRadShori().getSelectedValue().equals(CommonConstant.新規処理)) {
                        return true;
                    }
                    for (Shohon shohon : shohonList) {
                        RDate 基準日 = div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue();
                        if (null != 基準日 && null != shohon.get投票年月日() && !shohon.get投票年月日().isEmpty()
                        && 基準日.equals(new RDate(shohon.get投票年月日().toString()))) {
                            return false;
                        }
                    }
                    return true;
                }

            },
    過去抄本再処理確認 {

                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (new SimulationMenuId().isSimulationMenuId(ResponseHolder.getMenuID())) {
                        return true;
                    }
                    List<Shohon> shohonList = TeijiTorokuSpec.get抄本By定時登録();
                    if (null == shohonList || shohonList.isEmpty()
                    || div.getCcdTeijiMeiboSakuseiKijun().getRadShori().getSelectedValue().equals(CommonConstant.新規処理)) {
                        return true;
                    }
                    for (Shohon shohon : shohonList) {
                        RDate 基準日 = div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue();
                        if (null != 基準日 && null != shohon.get投票年月日() && !shohon.get投票年月日().isEmpty()
                        && 基準日.isBefore(new RDate(shohon.get投票年月日().toString()))) {
                            return false;
                        }
                    }
                    return true;
                }

            },
    年齢期限日と基準日の関係性チェック {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue() != null
                    && div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD() != null) {
                        return div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue().equals(
                                div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue().plusDay(1));
                    } else {
                        return Boolean.TRUE;
                    }
                }
            },
    転出期限と基準日の関係性チェック {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue() != null
                    && div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD() != null) {
                        return div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue().isBeforeOrEquals(
                                div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }
            },
    転入期限と基準日の関係性チェック {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue() != null
                    && div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD() != null) {
                        return div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue().isBeforeOrEquals(
                                div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }
            },
    転出期限と転入期限の関係性チェック {
                @Override
                public boolean apply(TeijiTorokuDiv div) {
                    if (div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue() != null
                    && div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD() != null) {
                        return div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue().isBeforeOrEquals(
                                div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue());
                    } else {
                        return Boolean.TRUE;
                    }
                }
            };

    private static List<Shohon> get抄本By定時登録() {
        ShohonManager maneger = ShohonManager.createInstance();
        return maneger.get抄本By定時登録();
    }
}
