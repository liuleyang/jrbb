/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meibotorokuzaigai;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoIdouRuisekiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.apache.ibatis.annotations.Param;

/**
 * 在外選挙人名簿登録のマッパーインタフェースです。
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public interface IMeibotorokuZaigaiMapper {

    /**
     * 在外選挙異動累積情報を取得する。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return MeibotorokuZaigaiEntit 在外選挙異動累積情報
     */
    ZaigaiSenkyoIdouRuisekiEntity select在外選挙異動累積情報(@Param("shikibetsuCode") ShikibetsuCode shikibetsuCode);

    /**
     * 在外選挙人申請情報を取得する。
     *
     * @param shinseiNo int
     * @param shikibetsuCode ShikibetsuCode
     * @return ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報
     */
    ZaigaiSenkyoninShinseiJohoEntity select在外選挙人申請情報(@Param("shinseiNo") int shinseiNo, @Param("shikibetsuCode") ShikibetsuCode shikibetsuCode);

    /**
     * 選挙情報を取得する。
     *
     * @param shinseiNo int
     * @param shikibetsuCode ShikibetsuCode
     * @return AfT503SenkyokuEntity 選挙情報
     */
    AfT503SenkyokuEntity select選挙情報(@Param("shinseiNo") int shinseiNo, @Param("shikibetsuCode") ShikibetsuCode shikibetsuCode);
}
