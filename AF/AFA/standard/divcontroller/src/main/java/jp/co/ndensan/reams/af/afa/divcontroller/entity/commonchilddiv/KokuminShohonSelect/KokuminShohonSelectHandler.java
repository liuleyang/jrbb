/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminShohonSelect;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.service.core.kokuminshohonselect.KokuminShohonSelectManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票抄本選択共有子DIVのコントロールクラスです。
 *
 * @reamsid_L AF-0390-020 jihb
 */
public class KokuminShohonSelectHandler {

    private final KokuminShohonSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 国民投票抄本選択共有子DIV
     */
    public KokuminShohonSelectHandler(KokuminShohonSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 組合コード選択共用共有子Div
     * @return HenreiChohyoShokaiHandler
     */
    public static KokuminShohonSelectHandler of(KokuminShohonSelectDiv div) {
        return new KokuminShohonSelectHandler(div);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @return boolean
     */
    public boolean initialize() {

        div.getDgKokuminShohon().getDataSource().clear();
        KokuminShohonSelectManager manager = KokuminShohonSelectManager.createInstance();
        List<ShohonSearchResult> shohonSearchlist = manager.get抄本情報();
        List<dgKokuminShohon_Row> rowlist = new ArrayList<>();
        if (shohonSearchlist == null || shohonSearchlist.isEmpty()) {
            return false;
        } else {
            for (ShohonSearchResult result : shohonSearchlist) {
                dgKokuminShohon_Row row = new dgKokuminShohon_Row();
                row.setTxtShohonName(result.get抄本名称());
                FlexibleDate 投票年月日 = result.get投票年月日();
                row.getTxtTohyoYMD().setValue(投票年月日 != null
                        && !投票年月日.isEmpty() ? new RDate(投票年月日.toString()) : null);
                FlexibleDate 名簿基準年月日 = result.get名簿基準年月日();
                row.getTxtKijunYMD().setValue(名簿基準年月日 != null
                        && !名簿基準年月日.isEmpty() ? new RDate(名簿基準年月日.toString()) : null);
                FlexibleDate 名簿登録日 = result.get名簿登録年月日();
                row.getTxtMeiboTorokuYMD().setValue(名簿登録日 != null
                        && !名簿登録日.isEmpty() ? new RDate(名簿登録日.toString()) : null);
                FlexibleDate 年齢到達日 = result.get規定年齢到達年月日();
                row.getTxtNenreiTotatsuYMD().setValue(年齢到達日 != null
                        && !年齢到達日.isEmpty() ? new RDate(年齢到達日.toString()) : null);
                FlexibleDate 特定期限日 = result.get転入期限年月日();
                row.getTxtTokuteiKigenYMD().setValue(特定期限日 != null
                        && !特定期限日.isEmpty() ? new RDate(特定期限日.toString()) : null);
                FlexibleDate 受付開始日 = result.get投票受付開始年月日();
                row.getTxtTohyoUketsukeYMD().setValue(受付開始日 != null
                        && !受付開始日.isEmpty() ? new RDate(受付開始日.toString()) : null);
                row.setTxtShohonNo(new RString(result.get抄本番号().toString()));
                rowlist.add(row);
            }
        }
        div.getDgKokuminShohon().setDataSource(rowlist);
        return true;
    }

}
