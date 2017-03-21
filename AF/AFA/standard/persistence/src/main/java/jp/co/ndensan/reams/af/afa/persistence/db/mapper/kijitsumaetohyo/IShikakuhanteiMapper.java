/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kijitsumaetohyo;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kijitsumaetohyo.ShikakuhanteiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ビジネス設計_AFABZA101_ShikakuHantei_資格判定のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0070-030 liss
 */
public interface IShikakuhanteiMapper {

    /**
     * 最新の転出年月日を取得します。
     *
     * @param param ShikakuhanteiMybatisParameter
     * @return 転出年月日 FlexibleDate
     */
    FlexibleDate selectNewTenshutsuYmd(ShikakuhanteiMybatisParameter param);

    /**
     * 最新の転入年月日を取得します。
     *
     * @param param ShikakuhanteiMybatisParameter
     * @return 転入年月日 FlexibleDate
     */
    FlexibleDate selectNewTennyuYmd(ShikakuhanteiMybatisParameter param);

    /**
     * 最新の転出年月日対応の履歴番号を取得します。
     *
     * @param param ShikakuhanteiMybatisParameter
     * @return 履歴番号 int
     */
    int selectNewTenshutsuYmdSeq(ShikakuhanteiMybatisParameter param);
}
