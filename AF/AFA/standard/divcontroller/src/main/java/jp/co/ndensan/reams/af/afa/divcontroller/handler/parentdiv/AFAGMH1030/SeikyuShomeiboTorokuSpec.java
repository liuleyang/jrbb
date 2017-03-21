/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030;

import java.util.List;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.審査区分_2;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShomeishaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 署名簿登録のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public enum SeikyuShomeiboTorokuSpec implements IPredicate<SeikyuShomeiboTorokuDiv> {

    /**
     * 在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力をチェックします。
     */
    署名状況無効事由相関チェック {
                @Override
                public boolean apply(SeikyuShomeiboTorokuDiv div) {
                    List<dgSeikyuShomeiboShomeishaIchiran_Row> datasource = div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource();
                    if (null != datasource && !datasource.isEmpty()) {
                        for (dgSeikyuShomeiboShomeishaIchiran_Row row : datasource) {
                            if (row.getDdlShomeiJokyo().getSelectedKey().equals(審査区分_2.getKey())
                            && row.getTxtMukoJiyu().getSelectedKey().equals(RString.EMPTY)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            };

}
