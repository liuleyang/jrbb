/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.barcodetojitsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.barcodetojitsu.BarCodeTojitsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.barcodetojitsu.BarCodeTojitsuEntity;

/**
 * 画面設計_AFAGME4020_期日前投票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public interface IBarCodeTojitsuMapper {

    /**
     * 期日前投票情報の集計を取得します。
     *
     * @param param BarCodeTojitsuMybatisParameter
     * @return 選挙人一覧情報 List<BarCodeTojitsuEntity>
     */
    List<BarCodeTojitsuEntity> selectTohyoJokyo(BarCodeTojitsuMybatisParameter param);
}
