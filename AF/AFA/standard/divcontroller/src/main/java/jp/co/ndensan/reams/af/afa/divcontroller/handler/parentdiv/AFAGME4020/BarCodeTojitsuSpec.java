/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodetojitsu.BarCodeTojitsuResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.BarCodeTojitsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.dgBarCodeTojitsuTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGME4020 不在者投票のチェックロジックです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public enum BarCodeTojitsuSpec implements IPredicate<BarCodeTojitsuDiv> {

    /**
     * 入場券確認をチェックします。
     */
    入場券確認チェック {
                @Override
                public boolean apply(BarCodeTojitsuDiv div) {
                    IBarCodeNyuryokuDiv barCodeDiv = div.getCcdNyujokenBarCode();
                    RString shohonNo = div.getCcdShohonNameList().getSelectedShohonNo();
                    if (!barCodeDiv.getBarCode().isEmpty()) {
                        return barCodeDiv.isMatchShohonNo(shohonNo);
                    }
                    return true;
                }
            },
    /**
     * バーコード重複チェック
     */
    バーコード重複チェック {
                @Override
                public boolean apply(BarCodeTojitsuDiv div) {
                    RString barCode = div.getBarCodeTojitsuNyuryoku().getCcdNyujokenBarCode().getBarCode();
                    List<dgBarCodeTojitsuTaishosha_Row> rowList = div.getDgBarCodeTojitsuTaishosha().getDataSource();
                    if (!rowList.isEmpty()) {
                        for (dgBarCodeTojitsuTaishosha_Row row : rowList) {
                            if (row.getHdnBarCode().equals(barCode)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            },
    /**
     * 投票資格があるかどうかを返します。
     */
    投票資格チェック {
                @Override
                public boolean apply(BarCodeTojitsuDiv div) {
                    List<BarCodeTojitsuResult> 選挙人名簿データs = ViewState.get選挙人名簿データ();
                    if (選挙人名簿データs != null && !選挙人名簿データs.isEmpty()) {
                        for (BarCodeTojitsuResult 選挙人名簿データ : 選挙人名簿データs) {
                            if (!選挙人名簿データ.has投票資格()) {
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
                public boolean apply(BarCodeTojitsuDiv div) {
                    List<BarCodeTojitsuResult> 選挙人名簿データs = ViewState.get選挙人名簿データ();
                    return 選挙人名簿データs != null && !選挙人名簿データs.isEmpty();
                }
            },
    /**
     * グリッドの選択をチェックします。
     */
    グリッドの選択チェック {
                @Override
                public boolean apply(BarCodeTojitsuDiv div
                ) {
                    return !div.getDgBarCodeTojitsuTaishosha().getSelectedItems().isEmpty();
                }
            };
}
