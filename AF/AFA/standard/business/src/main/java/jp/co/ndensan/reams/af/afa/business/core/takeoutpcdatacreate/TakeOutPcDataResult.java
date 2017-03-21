/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacreate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacreate.TakeOutPcDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 端末用データを管理するクラスです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class TakeOutPcDataResult {

    private final TakeOutPcDataEntity 端末用データEntity;
    private final List<RString> 選挙名List;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link TakeOutPcDataEntity} より{@link TakeOutPcDataResult}を生成します。
     *
     * @param 端末用データEntity DBより取得した{@link TakeOutPcDataEntity}
     * @param 選挙名List DBより取得した{@link 選挙名List}
     */
    public TakeOutPcDataResult(TakeOutPcDataEntity 端末用データEntity, List<RString> 選挙名List) {
        this.端末用データEntity = requireNonNull(端末用データEntity,
                UrSystemErrorMessages.値がnull.getReplacedMessage("端末用データ"));
        this.選挙名List = requireNonNull(選挙名List,
                UrSystemErrorMessages.値がnull.getReplacedMessage("選挙名List"));
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return this.端末用データEntity.get抄本Entity().getShohonNo();
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名
     */
    public RString get抄本名() {
        return this.端末用データEntity.get抄本Entity().getShohonName();
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return this.端末用データEntity.get抄本Entity().getTohyoYMD();
    }

    /**
     * 選挙名Listを返します。
     *
     * @return 選挙名List
     */
    public List<RString> get選挙名List() {
        return this.選挙名List;
    }

}
