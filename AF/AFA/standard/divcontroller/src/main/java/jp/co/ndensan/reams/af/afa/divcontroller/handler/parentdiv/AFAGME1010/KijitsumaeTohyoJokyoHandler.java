/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoShukei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.dgKijitsumaeTohyoShukei_Row;
import jp.co.ndensan.reams.af.afa.service.core.kijitsumaetohyo.KijitsumaeTohyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * KijitsumaeTohyoJokyoDivの操作を担当するクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoJokyoHandler {

    /**
     * コンストラクタです。
     *
     */
    public KijitsumaeTohyoJokyoHandler() {
    }

    /**
     * 選挙情報を取得します。
     *
     * @param shohonNo 抄本番号
     * @return List<dgKijitsumaeTohyoShukei_Row>
     */
    public List<KeyValueDataSource> createSenkyoDataSource(RString shohonNo) {
        List<Senkyo> sourceSenkyo = SenkyoManager.createInstance().get選挙By抄本番号(new ShohonNo(shohonNo));

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Senkyo item : sourceSenkyo) {
            KeyValueDataSource row = new KeyValueDataSource();
            row.setKey(new RString(item.get選挙番号().getColumnValue().toString()));
            row.setValue(item.get選挙略称());
            dataSource.add(row);
        }
        return dataSource;
    }

    /**
     * 期日前投票情報の集計を取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @return List<dgKijitsumaeTohyoShukei_Row>
     */
    public List<dgKijitsumaeTohyoShukei_Row> createTohyoJokyoShukeiDataSource(RString shohonNo, RString senkyoNo) {
        List<KijitsumaeTohyoShukei> resultList = KijitsumaeTohyoManager.createInstance().getKijitsumaeTohyoShukei(
                new ShohonNo(shohonNo), FlexibleDate.getNowDate(), new SenkyoNo(senkyoNo), ControlDataHolder.getClientId());
        List<dgKijitsumaeTohyoShukei_Row> dataSource = new ArrayList<>();

        if (resultList != null && !resultList.isEmpty()) {

            for (KijitsumaeTohyoShukei kijitsumaeTohyoShukei : resultList) {
                dgKijitsumaeTohyoShukei_Row row = new dgKijitsumaeTohyoShukei_Row();
                row.setTxtTohyojoName(kijitsumaeTohyoShukei.getShisetsuMeisho());
                row.getTxtManTojitsu().setValue(new Decimal(kijitsumaeTohyoShukei.getHonjitsuTohyoSuMale()));
                row.getTxtWomanTojitsu().setValue(new Decimal(kijitsumaeTohyoShukei.getHonjitsuTohyoSuFemale()));
                row.getTxtKeiTojitsu().setValue(new Decimal(kijitsumaeTohyoShukei.getHonjitsuTohyoSuMale()
                        + kijitsumaeTohyoShukei.getHonjitsuTohyoSuFemale()));
                row.getTxtManRuikei().setValue(new Decimal(kijitsumaeTohyoShukei.getIzenTohyoSuMale()));
                row.getTxtWomanRuikei().setValue(new Decimal(kijitsumaeTohyoShukei.getIzenTohyoSuFemale()));
                row.getTxtKeiRuikei().setValue(new Decimal(kijitsumaeTohyoShukei.getIzenTohyoSuMale()
                        + kijitsumaeTohyoShukei.getIzenTohyoSuFemale()));
                dataSource.add(row);
            }
        }
        return dataSource;
    }

}
