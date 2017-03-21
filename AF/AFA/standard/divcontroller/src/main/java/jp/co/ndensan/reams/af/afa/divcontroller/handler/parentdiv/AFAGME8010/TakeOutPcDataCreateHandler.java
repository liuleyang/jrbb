/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacreate.TakeOutPcDataResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.TakeOutPcDataCreateDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.dgShohonSenkyo_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * TakeOutPcDataCreateDivに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class TakeOutPcDataCreateHandler {

    private final TakeOutPcDataCreateDiv div;
//    private final RString チェック = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div TakeOutPcDataCreateDiv
     */
    public TakeOutPcDataCreateHandler(TakeOutPcDataCreateDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param メニューID RString
     */
    public void onLoad(RString メニューID) {
    }

    /**
     * 投票日リストから、画面内容をセットする。
     *
     * @param 投票日リスト List<FlexibleDate>
     */
    public void 画面設定_投票日ドロップダウン(List<FlexibleDate> 投票日リスト) {
        KeyValueDataSource dataSource;
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 0; i < 投票日リスト.size(); i++) {
            dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(投票日リスト.get(i).toString()));
            dataSource.setValue(投票日リスト.get(i).wareki().toDateString());
            dataSourceList.add(dataSource);
        }
        div.getDdlTohyoYmd().setDataSource(dataSourceList);
        div.getDdlTohyoYmd().setSelectedKey(new RString(投票日リスト.get(0).toString()));
    }

    /**
     * 端末用データから、画面内容をセットする。
     *
     * @param 端末用データ List<TakeOutPcDataResult>
     */
    public void 画面設定_一覧グリッド(List<TakeOutPcDataResult> 端末用データ) {
        TakeOutPcDataResult result;
        RString 選挙名;
        List<dgShohonSenkyo_Row> rows = new ArrayList<>();
        dgShohonSenkyo_Row dg;
        for (int i = 0; i < 端末用データ.size(); i++) {
            result = 端末用データ.get(i);
            選挙名 = RString.EMPTY;
            for (int j = 0; j < result.get選挙名List().size(); j++) {
                if (j == (result.get選挙名List().size() - 1)) {
                    選挙名 = 選挙名.concat(result.get選挙名List().get(j));
                } else {
                    選挙名 = 選挙名.concat(result.get選挙名List().get(j)).concat(new RString("、"));
                }
            }

            dg = new dgShohonSenkyo_Row(result.get抄本名(), 選挙名, toRString(result.get抄本番号()));
            rows.add(dg);
        }
        div.getDgShohonSenkyo().setDataSource(rows);
    }

    private RString toRString(ShohonNo 抄本番号) {
        if (null == 抄本番号) {
            return RString.EMPTY;
        }
        return new RString(抄本番号.value());
    }

}
