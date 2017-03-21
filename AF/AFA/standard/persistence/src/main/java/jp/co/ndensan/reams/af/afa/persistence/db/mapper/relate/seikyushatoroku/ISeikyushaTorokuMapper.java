/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.seikyushatoroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushatoroku.SeikyushaTorokuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SeikyushaTorokuEntity;

/**
 * 請求代表者証明書交付のマッパーインタフェースです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public interface ISeikyushaTorokuMapper {

    /**
     * 請求代表者一覧情報を取得します。
     *
     * @param 請求代表者検索条件 SeikyushaTorokuParameter
     * @return List<SeikyushaTorokuEntity>
     */
    List<SeikyushaTorokuEntity> select請求代表者一覧(SeikyushaTorokuParameter 請求代表者検索条件);

    /**
     * 直接請求代表者一覧情報を取得します。
     *
     * @param 請求代表者検索条件 SeikyushaTorokuParameter
     * @return List<SeikyushaTorokuEntity>
     */
    List<SeikyushaTorokuEntity> select直接請求代表者一覧(SeikyushaTorokuParameter 請求代表者検索条件);
}
