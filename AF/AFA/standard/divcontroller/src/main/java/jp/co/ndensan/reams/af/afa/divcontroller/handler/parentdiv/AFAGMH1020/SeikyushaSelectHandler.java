/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.seikyushaselect.SeikyushaSelectGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyushaTorokuEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.dgSeikyushaSelectSeikyuIchiran_Row;
import jp.co.ndensan.reams.af.afa.service.core.seikyushaselect.SeikyushaSelectManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求代表者選択
 *
 * @reamsid_L AF-0140-020 wangh
 */
public class SeikyushaSelectHandler {

    /**
     * 一覧データを取得処理。
     *
     * @return List<dgSeikyushaSelectSeikyuIchiran_Row>
     */
    public List<dgSeikyushaSelectSeikyuIchiran_Row> get一覧データ() {

        SeikyushaSelectManager manager = SeikyushaSelectManager.createInstance();
        List<SeikyushaSelectGamenData> 検索結果List = manager.get直接請求一覧データ();
        List<dgSeikyushaSelectSeikyuIchiran_Row> rowList = new ArrayList();
        if (null != 検索結果List && !検索結果List.isEmpty()) {
            for (SeikyushaSelectGamenData 検索結果 : 検索結果List) {
                dgSeikyushaSelectSeikyuIchiran_Row row = new dgSeikyushaSelectSeikyuIchiran_Row();
                if (検索結果.isTorokuZumiFlag()) {
                    row.setTxtShomeiboSakusei(SeikyushaTorokuEnum.署名簿作成.getValue());
                }
                row.setTxtSeikyuName(検索結果.getSeikyuMei());
                FlexibleDate 請求年月日 = 検索結果.getSeikyuYMD();
                row.getTxtSeikyuYMD().setValue(請求年月日 == null || 請求年月日.isEmpty() ? null : new RDate(請求年月日.toString()));
                FlexibleDate 交付年月日 = 検索結果.getKofuYMD();
                row.getTxtKofuYMD().setValue(交付年月日 == null || 交付年月日.isEmpty() ? null : new RDate(交付年月日.toString()));
                FlexibleDate 提出期限年月日 = 検索結果.getTeishutsuKigenYMD();
                row.getTxtTeishutsuKigenYMD().setValue(提出期限年月日 == null || 提出期限年月日.isEmpty()
                        ? null : new RDate(提出期限年月日.toString()));
                row.setTxtKofuSoshiki(検索結果.getKofuSoshikiCodeMeisho());
                row.setTxtSeikyuNaiyo(検索結果.getSeikyuNaiyo());
                row.setTxtSeikyuNo(new RString(検索結果.getSeikyuNo()));
                ShohonNo 抄本番号 = 検索結果.getShohonNo();
                if (null != 抄本番号) {
                    row.setTxtHdnShohonNo(new RString(抄本番号.getColumnValue()));
                }
                rowList.add(row);
            }
        }
        return rowList;
    }

}
