/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture.TakeOutPcDataCaptureEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 端末用データを管理するクラスです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class TakeOutPcDataCaptureResult {

    private final TakeOutPcDataCaptureEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link BarCodeJuriEntity}より{@link BarCodeTojitsuResult}を生成します。
     *
     * @param entity DBより取得した{@link BarCodeJuriEntity}
     */
    public TakeOutPcDataCaptureResult(TakeOutPcDataCaptureEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return this.entity.get抄本Entity().getShohonNo();
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名
     */
    public RString get抄本名() {
        return this.entity.get抄本Entity().getShohonName();
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return this.entity.get抄本Entity().getTohyoYMD();
    }

    /**
     * 選挙名Listを返します。
     *
     * @return 選挙名List
     */
    public List<AfT111SenkyoEntity> get選挙List() {
        return this.entity.get選挙Entity();
    }

}
