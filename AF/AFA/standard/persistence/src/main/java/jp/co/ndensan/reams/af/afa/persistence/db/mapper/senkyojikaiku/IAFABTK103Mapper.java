/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.KaikuTeiseishaMeiboEntity;

/**
 * 海区漁業調整委員会委員選挙時登録のマッパクラスのインタフェースです。
 *
 *
 * @reamsid_L AF-0470-030 jihb
 */
public interface IAFABTK103Mapper {

    /**
     * 宛名識別対象を取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<KaikuTeiseishaMeiboEntity> select訂正者名簿データ(SenkyojiKaikuMybatisParameter parameter);
}
