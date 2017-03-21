/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.kaikuidoshikakuidoshori;

import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuIdoShikakuIdoShoriFinder {

    private final AfT100ShohonDac dac;

    KaikuIdoShikakuIdoShoriFinder() {
        dac = InstanceProvider.create(AfT100ShohonDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static KaikuIdoShikakuIdoShoriFinder createInstance() {
        return InstanceProvider.create(KaikuIdoShikakuIdoShoriFinder.class);
    }

    /**
     * 抄本を取得します。
     *
     * @param shohonNo ShohonNo
     * @return 最新抄本 ShohonResult<ShohonResult>
     */
    @Transaction
    public ShohonResult get最新抄本(ShohonNo shohonNo) {
        AfT100ShohonEntity entity = dac.select(shohonNo);
        if (entity == null) {
            return null;
        }

        return new ShohonResult(entity);
    }
}
