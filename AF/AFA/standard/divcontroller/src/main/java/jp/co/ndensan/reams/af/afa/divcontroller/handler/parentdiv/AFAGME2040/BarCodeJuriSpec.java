/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodejuri.BarCodeJuriSearchResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.dgBarCodeJuriTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理のSpecです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public enum BarCodeJuriSpec implements IPredicate<BarCodeJuriDiv> {

    /**
     * バーコードの抄本番号一致性チェック
     */
    バーコードの抄本番号一致性チェック {
                @Override
                public boolean apply(BarCodeJuriDiv div) {
                    return div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().isMatchShohonNo(div.getBarCodeJuriNyuryoku().getCcdShohonNameList().getSelectedShohonNo());
                }
            },
    /**
     * 無投票選挙かどうかをチェック
     */
    無投票選挙かどうかをチェック {
                @Override
                public boolean apply(BarCodeJuriDiv div) {
                    List<BarCodeJuriSearchResult> 投票状況データs = ViewState.get投票状況データ();
                    if (投票状況データs != null && !投票状況データs.isEmpty()) {
                        for (BarCodeJuriSearchResult 投票状況データ : 投票状況データs) {
                            if (投票状況データ.is無投票選挙フラグ()) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            },
    /**
     * 件数チェック
     */
    件数チェック {
                @Override
                public boolean apply(BarCodeJuriDiv div) {
                    List<BarCodeJuriSearchResult> 投票状況データs = ViewState.get投票状況データ();
                    return 投票状況データs != null && !投票状況データs.isEmpty();
                }
            },
    /**
     * 投票資格チェック
     */
    投票資格チェック {
                @Override
                public boolean apply(BarCodeJuriDiv div) {
                    List<BarCodeJuriSearchResult> 投票状況データs = ViewState.get投票状況データ();
                    if (投票状況データs != null && !投票状況データs.isEmpty()) {
                        for (BarCodeJuriSearchResult 投票状況データ : 投票状況データs) {
                            if (!投票状況データ.has投票資格()) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            },
    /**
     * 受理日と抄本の投票年月日大小チェック
     */
    受理日と抄本の投票年月日大小チェック {
                @Override
                public boolean apply(BarCodeJuriDiv div) {
                    RDate 抄本の投票年月日 = div.getBarCodeJuriNyuryoku().getDgBarCodeJuriTaishosha().getDataSource().get(0).getTxtTohyoYMD().getValue();
                    RDate 受理日 = div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD().getValue();
                    return 抄本の投票年月日 == null || 受理日 == null || !抄本の投票年月日.isBeforeOrEquals(受理日);
                }
            },
    /**
     * バーコード重複チェック
     */
    バーコード重複チェック {
                @Override
                public boolean apply(BarCodeJuriDiv div) {
                    RString barCode = div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getBarCode();
                    List<dgBarCodeJuriTaishosha_Row> rowList = div.getBarCodeJuriNyuryoku().getDgBarCodeJuriTaishosha().getDataSource();
                    if (!rowList.isEmpty()) {
                        for (dgBarCodeJuriTaishosha_Row row : rowList) {
                            if (row.getTxtBarCode().equals(barCode)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            };

}
