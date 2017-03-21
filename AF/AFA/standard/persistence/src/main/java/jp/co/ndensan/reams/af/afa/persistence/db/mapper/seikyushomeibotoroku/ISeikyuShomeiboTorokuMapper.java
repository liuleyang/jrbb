/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.seikyushomeibotoroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushatoroku.SeikyushaTorokuParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushomeibotoroku.SeikyuShomeiboTorokuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SeikyushaTorokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.seikyushomeibotoroku.ShomeiboEntity;

/**
 * AFAGMH1030_署名簿登録のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public interface ISeikyuShomeiboTorokuMapper {

    /**
     * 署名者一覧情報を取得します。
     *
     * @param seikyuNo int
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShomeibo(int seikyuNo);

    /**
     * 署名者一覧情報を取得します。
     *
     * @param seikyuNo int
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShomeiboback(int seikyuNo);

    /**
     * 請求代表者一覧情報を取得します。
     *
     * @param param SeikyushaTorokuParameter
     * @return SeikyushaTorokuEntity
     */
    SeikyushaTorokuEntity selectShomeiboByShikibetsuCode(SeikyushaTorokuParameter param);

    /**
     * 署名件数表（投票区別）データを取得します。
     *
     * @param seikyuNo int
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShukeiKensuTohyoku(int seikyuNo);

    /**
     * 署名件数表（投票区別）データを取得します。
     *
     * @param seikyuNo int
     * @return ShomeiboEntity
     */
    ShomeiboEntity selectShukeiKensuTohyokuFumei(int seikyuNo);

    /**
     * 無効件数無効事由内訳表（投票区別）データを取得します。
     *
     * @param param SeikyuShomeiboTorokuParameter
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShukeiKensuJusho(SeikyuShomeiboTorokuParameter param);

    /**
     * 署名件数表（住所別）データを取得します。
     *
     * @param seikyuNo int
     * @return ShomeiboEntity
     */
    ShomeiboEntity selectShukeiKensuJushoFumei(int seikyuNo);

    /**
     * 無効件数無効事由内訳表（投票区別）データを取得します。
     *
     * @param seikyuNo int
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShukeiMukoTohyoku(int seikyuNo);

    /**
     * 無効件数無効事由内訳表（投票区別）データを取得します。
     *
     * @param seikyuNo int
     * @return ShomeiboEntity
     */
    ShomeiboEntity selectShukeiMukoTohyokuFumei(int seikyuNo);

    /**
     * 無効件数無効事由内訳表（住所別）データを取得します。
     *
     * @param param SeikyuShomeiboTorokuParameter
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShukeiMukoJusho(SeikyuShomeiboTorokuParameter param);

    /**
     * 無効件数無効事由内訳表（住所別）データを取得します。
     *
     * @param seikyuNo int
     * @return ShomeiboEntity
     */
    ShomeiboEntity selectShukeiMukoJushoFumei(int seikyuNo);

    /**
     * 年齢別投票率集計表データを取得します。
     *
     * @param seikyuNo int
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShukeiNenreiNendai(int seikyuNo);

    /**
     * 年齢別投票率集計表データを取得します。
     *
     * @param seikyuNo int
     * @return List<ShomeiboEntity>
     */
    List<ShomeiboEntity> selectShukeiNenreiNendaiFumei(int seikyuNo);
}
