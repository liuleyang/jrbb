/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminShohonSelect;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.business.KokuminTohyoji;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author uppzhang
 */
public class KokuminShohonSelect {

    /**
     * 検索結果グリッドから対象データを選択した時のイベントメソッドです。
     *
     * @param div KokuminShohonSelectDiv
     * @return ResponseData<KokuminShohonSelectDiv>
     */
    public ResponseData<KokuminShohonSelectDiv> onSelect_dgIdoSearchKekkaList(KokuminShohonSelectDiv div) {
        dgKokuminShohon_Row row = div.getDgKokuminShohon().getClickedItem();
        ShohonSearchResult shohonSearch = new ShohonSearchResult();
        shohonSearch.set処理年月日(FlexibleDate.EMPTY);
        shohonSearch.set名簿基準年月日(null == row.getTxtKijunYMD().getValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(row.getTxtKijunYMD().getValue().toDateString()));
        shohonSearch.set名簿登録年月日(null == row.getTxtMeiboTorokuYMD() ? FlexibleDate.EMPTY
                : new FlexibleDate(row.getTxtMeiboTorokuYMD().getValue().toDateString()));;
        shohonSearch.set投票受付開始年月日(null == row.getTxtTohyoUketsukeYMD().getValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(row.getTxtTohyoUketsukeYMD().getValue().toDateString()));
        shohonSearch.set投票年月日(null == row.getTxtTohyoYMD().getValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(row.getTxtTohyoYMD().getValue().toDateString()));
        shohonSearch.set規定年齢到達年月日(null == row.getTxtNenreiTotatsuYMD().getValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(row.getTxtNenreiTotatsuYMD().getValue().toDateString()));
        shohonSearch.set転入期限年月日(null == row.getTxtTokuteiKigenYMD().getValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(row.getTxtTokuteiKigenYMD().getValue().toDateString()));
        shohonSearch.set転出期限年月日(FlexibleDate.EMPTY);
        shohonSearch.set抄本名称(row.getTxtShohonName());
        shohonSearch.set抄本番号(new ShohonNo(row.getTxtShohonNo()));
        shohonSearch.set選挙種類(Code.EMPTY);
        ViewStateHolder.put(ViewStateKeys.対象抄本情報, (Serializable) shohonSearch);
        KokuminTohyoji kokuminTohyoji = new KokuminTohyoji();
        div.setHdnMasshoYMD(kokuminTohyoji.get帳票条件_日付取得処理(row.getTxtTohyoYMD().getValue()).toDateString());
        div.setHdnShohonNo(row.getTxtShohonNo());
        return ResponseData.of(div).respond();
    }

}
