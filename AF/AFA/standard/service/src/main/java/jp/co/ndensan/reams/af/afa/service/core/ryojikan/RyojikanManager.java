/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.ryojikan;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.ryojikan.RyojikanResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT510RyojikanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 領事官の取得
 *
 * @reamsid_L AF-0320-015 xul
 */
public class RyojikanManager {

    private final AfT510RyojikanDac dac;

    /**
     * コンストラクタです。
     */
    public RyojikanManager() {
        dac = InstanceProvider.create(AfT510RyojikanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT111SenkyoDac}
     */
    public RyojikanManager(AfT510RyojikanDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンス
     */
    public static RyojikanManager createInstance() {
        return InstanceProvider.create(RyojikanManager.class);
    }

    /**
     * 主キーに合致する領事官マスタを返します。
     *
     * @param ryojikanCode RString
     *
     * @return RyojikanResult nullが返る可能性があります。
     */
    @Transaction
    public RyojikanResult selectBy領事官コード(RString ryojikanCode) {
        requireNonNull(ryojikanCode, UrSystemErrorMessages.値がnull.getReplacedMessage("ryojikanCode"));

        AfT510RyojikanEntity entity = dac.select(ryojikanCode);

        if (entity == null) {
            return null;
        }
        return new RyojikanResult(entity);
    }

    /**
     * 領事官マスタを返します。
     *
     *
     * @return RyojikanResult nullが返る可能性があります。
     */
    @Transaction
    public List<RyojikanResult> select領事官マスタ() {

        List<AfT510RyojikanEntity> entitys = dac.select();
        List<RyojikanResult> ryojikanResulttList = new ArrayList<>();

        for (AfT510RyojikanEntity entity : entitys) {
            ryojikanResulttList.add(new RyojikanResult(entity));
        }

        return ryojikanResulttList;
    }

}
