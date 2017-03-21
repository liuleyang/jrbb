/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kaikufuzuijoho;

import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiParameter;
import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT133KaikuSenkyoFuzuiDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 海区付随情報Mangerです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public class KaikufuzuijohoManger {

    private final AfT133KaikuSenkyoFuzuiDac dac;

    /**
     * コンストラクタです。
     */
    KaikufuzuijohoManger() {
        dac = InstanceProvider.create(AfT133KaikuSenkyoFuzuiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 抄本Dac 抄本Dac
     */
    KaikufuzuijohoManger(AfT133KaikuSenkyoFuzuiDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShohonManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShohonManager}のインスタンス
     */
    public static KaikufuzuijohoManger createInstance() {
        return InstanceProvider.create(KaikufuzuijohoManger.class);
    }

    /**
     * 海区付随情報を返します。
     *
     * @param parameter KaikuSenkyoFuzuiParameter
     * @return KaikuSenkyoFuzuiResult nullが返る可能性があります。
     */
    @Transaction
    public KaikuSenkyoFuzuiResult get海区付随情報(KaikuSenkyoFuzuiParameter parameter) {
        AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui = dac.select(parameter.get抄本番号(), parameter.get識別コード());

        if (afT133KaikuSenkyoFuzui == null) {
            return null;
        }

        return new KaikuSenkyoFuzuiResult(afT133KaikuSenkyoFuzui);
    }

}
