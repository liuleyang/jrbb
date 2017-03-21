/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.atenasealsakusei;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * 選挙人情報
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class AtenaSealSakuseiJyohouEntity {

    private AfT507ShisetsuEntity 施設情報;
    private AfT111SenkyoEntity 選挙情報;
    private AfT112SenkyoninMeiboEntity 選挙人名簿情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSM情報;
    private ShikibetsuCode 世帯主の識別コード;

    /**
     * 施設情報を返します。
     *
     * @return 施設情報
     */
    public AfT507ShisetsuEntity get施設情報() {
        return 施設情報;
    }

    /**
     * 選挙情報を返します。
     *
     * @return 選挙情報
     */
    public AfT111SenkyoEntity get選挙情報() {
        return 選挙情報;
    }

    /**
     * 選挙人名簿情報を返します。
     *
     * @return 選挙人名簿情報
     */
    public AfT112SenkyoninMeiboEntity get選挙人名簿情報() {
        return 選挙人名簿情報;
    }

    /**
     * 宛名PSM情報を返します。
     *
     * @return 宛名PSM情報
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM情報() {
        return 宛名PSM情報;
    }

    /**
     * 世帯主の識別コードを返します。
     *
     * @return 世帯主の識別コード
     */
    public ShikibetsuCode get世帯主の識別コード() {
        return 世帯主の識別コード;
    }

    /**
     * 施設情報を設定します。
     *
     * @param 施設情報 AfT507ShisetsuEntity
     */
    public void set施設情報(AfT507ShisetsuEntity 施設情報) {
        this.施設情報 = 施設情報;
    }

    /**
     * 選挙情報を設定します。
     *
     * @param 選挙情報 AfT111SenkyoEntity
     */
    public void set選挙情報(AfT111SenkyoEntity 選挙情報) {
        this.選挙情報 = 選挙情報;
    }

    /**
     * 選挙人名簿情報を設定します。
     *
     * @param 選挙人名簿情報 AfT112SenkyoninMeiboEntity
     */
    public void set選挙人名簿情報(AfT112SenkyoninMeiboEntity 選挙人名簿情報) {
        this.選挙人名簿情報 = 選挙人名簿情報;
    }

    /**
     * 宛名PSM情報を設定します。
     *
     * @param 宛名PSM情報 UaFt200FindShikibetsuTaishoEntity
     */
    public void set宛名PSM情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM情報) {
        this.宛名PSM情報 = 宛名PSM情報;
    }

    /**
     * 世帯主の識別コードを設定します。
     *
     * @param 世帯主の識別コード ShikibetsuCode
     */
    public void set世帯主の識別コード(ShikibetsuCode 世帯主の識別コード) {
        this.世帯主の識別コード = 世帯主の識別コード;
    }

}
